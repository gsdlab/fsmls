/*******************************************************************************
 * Copyright (c) 2010 Herman Lee.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Herman Lee - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.quickFix;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.PlatformUI;

import ca.uwaterloo.gsd.fsml.codeAssist.FSMLCodeAssistUtil;
import ca.uwaterloo.gsd.fsml.contentassist.FSMLJavaContentCompleteProcessor;
import ca.uwaterloo.gsd.fsml.contentassist.FSMLJavaProposal;
import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMarkers;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.xmlMappingInterpreter.XMLMappingInterpreter;

public class FSMLProblemMarkersQuickFix implements IMarkerResolution {

	private String label;
	private String errorMsg;

	public FSMLProblemMarkersQuickFix(String label, String errorMsg) {
		this.label = label;
		this.errorMsg = errorMsg;

	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void run(IMarker problemMarker) {
// 		MessageDialog.openInformation(null, "QuickFix Demo",
//				"This quick-fix is not yet implemented");
		IProject currentProject = problemMarker.getResource().getProject();
		Markers.INSTANCE.setProject(currentProject);
		
		List<IFile> modelFiles = FSMLCodeAssistUtil.findModelFile(currentProject);
		for (IFile fsmlModelFile : modelFiles) {
			EList<EObject> fsmlModel = null;
			ResourceSet resourceSet = new ResourceSetImpl();
			URI fsmlModelURI = URI.createPlatformResourceURI(
					fsmlModelFile.getFullPath().toString(), true);
			Resource resource = resourceSet.getResource(
					fsmlModelURI, true);
			
			fsmlModel = resource.getContents();
			Model assertedModel = ((ModelContainer) fsmlModel.get(0))
					.getAssertedModel();
			
			
				
			HashMap<String, EObject> fsmlId2ModelEObject = new HashMap<String,EObject>();
			FSMLEcoreUtil.createFsmlId2EObjectMap(assertedModel, fsmlId2ModelEObject);
			
			
			ICompilationUnit compilationUnit = getCompilationUnit(problemMarker);
			
			int markerStartPos;
			int markerEndPos;
			try {
				markerStartPos = ((Integer) problemMarker
						.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START))
						.intValue();
				markerEndPos = ((Integer) problemMarker
						.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END))
						.intValue();
				ASTNode coveringNode = FSMLCodeAssistUtil.getCoveringNode(compilationUnit, markerStartPos, 0);
	
				
				Queries.INSTANCE.reset();
				JavaMappingInterpreter javaMappingInterpreter = new JavaMappingInterpreter();
				Queries.INSTANCE.registerCustomInterpreter(javaMappingInterpreter);
			
				//register XML mapping interpreter
				XMLMappingInterpreter xmlMappingInterpreter = new XMLMappingInterpreter();
				Queries.INSTANCE.registerCustomInterpreter(xmlMappingInterpreter);
				
				Queries.INSTANCE.initialize(currentProject,assertedModel);
				javaMappingInterpreter.getAnalysisManagers().getJavaASTManager().setCompilationUnit(
					JavaModelUtils.getTypeRoot(((CompilationUnit)coveringNode.getRoot()).getJavaElement()),(CompilationUnit)coveringNode.getRoot());
					
				ASTRewrite rewrite = ASTRewrite.create(coveringNode.getAST());
				String featureName=null;
				boolean isFeatureGroup = false;
				if (errorMsg.contains("'inv_featureGroupConstraint' invariant is violated on ")){
					//this diagnostic message is of the format 
					//"The 'inv_*' invariant is violated on '*'
					errorMsg  = errorMsg.replaceAll("'inv_featureGroupConstraint' invariant is violated on ", "");
					isFeatureGroup = true;
				}else if (errorMsg.contains("feature") && errorMsg.contains("must be")){
					//this diagnostic message is of the format 
					//"The * feature 'featureName' of 'project name' must be *
					int beginning = errorMsg.indexOf("'");
					featureName = errorMsg.substring(beginning+1,errorMsg.substring(beginning+1).indexOf("'")+beginning+1);
				}
				Vector<IMarker> markers = JavaMarkers.getMarkersCoveredByNode(coveringNode);
				Image proposalImage=null;
				if (resource.getURI().path()!=null){
					IEditorDescriptor modelEditor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
							resource.getURI().path());
					if (modelEditor!=null){
						proposalImage= modelEditor.getImageDescriptor().createImage();
					}
				} 
				if (proposalImage ==null){
					proposalImage = FSMLJavaContentCompleteProcessor.IMG_TOOL_FORWARD;
				}				
				for (IMarker coveringNodeMarker : markers) { 
					Object id = coveringNodeMarker.getAttribute(MarkerDescriptor.ATTRIBUTE_ID);
					
					EObject currentEObject = fsmlId2ModelEObject.get(id);
					if (currentEObject==null){
						continue;
					} else {
						//associate context
						Queries.INSTANCE.removeContext(currentEObject);
						ASTNode astNode = coveringNode;
						while (astNode!=null){
							if (astNode instanceof MethodDeclaration){
								MethodDeclaration methodDeclaration = (MethodDeclaration)astNode;
								//FSMLEcoreUtil.parameterValuesFromRecommenderSystem.put(JavaMappingInterpreter.DETAIL_LOCATION_NAME, methodDeclaration.getName().getIdentifier());								
								IMethod iMethod = (IMethod) methodDeclaration.resolveBinding().getJavaElement();
								String key = iMethod.getKey();
								String auxSignature = key.substring(key.indexOf('('));
								auxSignature = auxSignature.replace('/', '.');
								//FSMLEcoreUtil.parameterValuesFromRecommenderSystem.put(JavaMappingInterpreter.DETAIL_LOCATION_SIG, auxSignature);
							}
							astNode = astNode.getParent();
						}
					}
				}
				for (IMarker coveringNodeMarker : markers) { 
					Object id = coveringNodeMarker.getAttribute(MarkerDescriptor.ATTRIBUTE_ID);
					
					EObject currentEObject = fsmlId2ModelEObject.get(id);
					if (currentEObject==null){
						continue;
					}
					EStructuralFeature structuralFeature = currentEObject.eClass().getEStructuralFeature(featureName);
					if (structuralFeature==null && !isFeatureGroup){ 
						continue;
					}
					
					
					FSMLJavaProposal proposal =null;
					if (isFeatureGroup){
						proposal = new FSMLJavaProposal(errorMsg,compilationUnit,rewrite,2,
								proposalImage,currentEObject,currentEObject.eClass(),null,coveringNode,markerStartPos,resource,null);
					}else if (structuralFeature instanceof EAttribute){
						proposal = new FSMLJavaProposal(errorMsg,compilationUnit,rewrite,2,
								proposalImage,currentEObject,null,structuralFeature,coveringNode,markerStartPos,resource,null);
						
					}else if (structuralFeature instanceof EReference){
						Collection<EClass> concreteClasses = FSMLEcoreUtil
						.getSubclassesOfEClass(
								((EReference) structuralFeature)
										.getEReferenceType(), true);
						for (EClass concreteClass : concreteClasses) {
							proposal = new FSMLJavaProposal(errorMsg,compilationUnit,rewrite,2,
									proposalImage,currentEObject,concreteClass,structuralFeature,coveringNode,markerStartPos,	resource,null);
						
						}
					} 	
					proposal.apply(new JavaContentAssistInvocationContext(compilationUnit).getDocument());
					break; //we are done since we have applied the only relevant proposal
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	private ICompilationUnit getCompilationUnit(IMarker marker) {
		IResource res = marker.getResource();
		if (res instanceof IFile && res.isAccessible()) {
			IJavaElement element = JavaCore.create((IFile) res);
			if (element instanceof ICompilationUnit)
				return (ICompilationUnit) element;
		}
		return null;
	}

}
