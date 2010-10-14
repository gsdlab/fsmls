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
package ca.uwaterloo.gsd.fsml.contentassist;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposal;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import ca.uwaterloo.gsd.fsml.codeAssist.FSMLCodeAssistUtil;
import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMarkers;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.xmlMappingInterpreter.XMLMappingInterpreter;

public class FSMLJavaContentCompleteProcessor implements
		IJavaCompletionProposalComputer {
	
	public static final Image IMG_TOOL_FORWARD = PlatformUI.getWorkbench().getSharedImages()
	.getImage(ISharedImages.IMG_TOOL_FORWARD);
	
	//Eclipse callback method
	@Override
	public List<IJavaCompletionProposal> computeCompletionProposals(
			ContentAssistInvocationContext context, IProgressMonitor monitor) {

		JavaContentAssistInvocationContext jc = (JavaContentAssistInvocationContext) context;
		char[] token = jc.getCoreContext().getToken();
		String keywordToken;
		if (token==null){
			keywordToken="";
		}else {
			keywordToken= new String(token);
		}
		String currentFramework = null;	
		//check whether we should enable keyword programming
		
		if (keywordToken!=null && keywordToken.length()!=0)
		for (int i=0;i<FSMLCodeAssistUtil.supportedFrameworks.length;i++){
				if (keywordToken.toLowerCase().startsWith(FSMLCodeAssistUtil.supportedFrameworks[i])){
					currentFramework = FSMLCodeAssistUtil.supportedFrameworks[i]; 
					break;
				}
			
		}
		
		// assume at least a FSML model exist
		// get the metamodel from the FSML model, start querying it
		// TODO: if no FSML model exists, do reverse?


		//find the model file
	
		String[] frameworksToCheck; 
		if (currentFramework==null){
			frameworksToCheck = FSMLCodeAssistUtil.supportedFrameworks;
		}else { 
			//search for the framework-specific models for all possible frameworks if the 
			//keyword doesn't tell us which framework are we currently using
			frameworksToCheck = new String[]{currentFramework};
		}
		List<IJavaCompletionProposal> proposals= new Vector<IJavaCompletionProposal>();
		List<IFile> fsmlModelFiles = FSMLCodeAssistUtil.findModelFile(jc
								.getCompilationUnit()
								.getJavaProject().getProject(),frameworksToCheck);
		
		int score = 9999;
		for (IFile fsmlModelFile : fsmlModelFiles) {
			int counter = 0;
			if (fsmlModelFile ==null||!fsmlModelFile.exists()){
				System.err.println ("no valid project found");
				return Collections.EMPTY_LIST;
			} 
			EList<EObject> fsmlModel = null;
			ResourceSet resourceSet = new ResourceSetImpl();
			URI fsmlModelURI = URI.createPlatformResourceURI(
					fsmlModelFile.getFullPath().toString(), true);
			Resource resource = resourceSet.getResource(
					fsmlModelURI, true);
			
			fsmlModel = resource.getContents();
	
			Model assertedModel = ((ModelContainer) fsmlModel.get(0))
			.getAssertedModel();
			Queries.INSTANCE.reset();
			Queries.INSTANCE.setProject(jc.getCompilationUnit().getJavaProject().getProject());
			//register Java mapping interpreter
			JavaMappingInterpreter javaMappingInterpreter = new JavaMappingInterpreter();
			Queries.INSTANCE.registerCustomInterpreter(javaMappingInterpreter);
		
			//register XML mapping interpreter
			XMLMappingInterpreter xmlMappingInterpreter = new XMLMappingInterpreter();
			Queries.INSTANCE.registerCustomInterpreter(xmlMappingInterpreter);

			
			Queries.INSTANCE.initialize(jc
					.getCompilationUnit()
					.getJavaProject().getProject(),assertedModel);
			
			//main method call 
	
			proposals.addAll(getProposals(assertedModel, jc,resource,javaMappingInterpreter,score+counter*(score/10)));
		}
		return proposals;

	}

	@Override
	public List<IJavaCompletionProposal> computeContextInformation(
			ContentAssistInvocationContext context, IProgressMonitor monitor) {
		//TODO: compute context information
		System.out.println ("compute context information from FSMLJavaContentCompleteProcessor");
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getErrorMessage() {
		return "getErrorMessage() from FSMLJavaContentCompleteProcessor";
	}

	@Override
	public void sessionEnded() {
		//System.out.println ("Session ended from FSMLJavaContentCompleteProcessor");
	}

	@Override
	public void sessionStarted() {
		//System.out.println ("Session started from FSMLJavaContentCompleteProcessor");
	}



	
	protected Vector<IJavaCompletionProposal> getProposals(Model model,
			JavaContentAssistInvocationContext jc, Resource resource, JavaMappingInterpreter javaMappingInterpreter,int score) {
		// iterate through all the supported mappings - deprecated mechanism
		
		Vector<IJavaCompletionProposal> proposals = new Vector<IJavaCompletionProposal>();
	
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(jc.getCompilationUnit());
		parser.setStatementsRecovery(true);
		parser.setResolveBindings(true);

		//compute actual code transformation proposals
		ASTNode coveringNode = FSMLCodeAssistUtil.getCoveringNode(jc.getCompilationUnit(), jc.getInvocationOffset(), 0);
		IJavaElement javaElement = ((CompilationUnit)coveringNode.getRoot()).getJavaElement();
		javaMappingInterpreter.getAnalysisManagers().getJavaASTManager().setCompilationUnit(
				JavaModelUtils.getTypeRoot(javaElement),(CompilationUnit)coveringNode.getRoot());
			
		HashMap<String, EObject> fsmlId2ModelEObject = new HashMap<String,EObject>();
		FSMLEcoreUtil.createFsmlId2EObjectMap(model, fsmlId2ModelEObject);
		
		
		//map current context to markers
		Vector<IMarker> markers = JavaMarkers.getMarkersCoveredByNode(coveringNode);
		

		//set the context
		FSMLEcoreUtil.parameterValuesFromRecommenderSystem.clear();
		FSMLEcoreUtil.parameterValuesFromRecommenderSystem.put(JavaMappingInterpreter.DETAIL_POSITION, ""+jc.getInvocationOffset());
		for (IMarker marker : markers) {
				try {
					EObject eObject = fsmlId2ModelEObject.get(marker.getAttribute(MarkerDescriptor.ATTRIBUTE_ID));
					if (eObject!=null){
						ASTNode astNode = coveringNode;
						Queries.INSTANCE.removeContext(eObject);
						while (astNode!=null){
							Queries.INSTANCE.associateContext(eObject, astNode);
							if (astNode instanceof MethodDeclaration){
								MethodDeclaration methodDeclaration = (MethodDeclaration)astNode;
								FSMLEcoreUtil.parameterValuesFromRecommenderSystem.put(JavaMappingInterpreter.DETAIL_LOCATION_NAME, methodDeclaration.getName().getIdentifier());								
								IMethod iMethod = (IMethod) methodDeclaration.resolveBinding().getJavaElement();
								String key = iMethod.getKey();
								String auxSignature = key.substring(key.indexOf('('));
								auxSignature = auxSignature.replace('/', '.');
								FSMLEcoreUtil.parameterValuesFromRecommenderSystem.put(JavaMappingInterpreter.DETAIL_LOCATION_SIG, auxSignature);
							}
							astNode = astNode.getParent();
						}
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
		}
	
		if (markers.size()>0) {
			
			for (IMarker marker : markers) {
				try {
					EObject eObject = fsmlId2ModelEObject.get(marker.getAttribute(MarkerDescriptor.ATTRIBUTE_ID));
					//eObject corresponding to the marker
					
					if (eObject!=null) {
						proposals.addAll(createProposals(model, jc, resource,
								coveringNode, score,
								eObject));
						
					}
					} catch (CoreException e) {
					e.printStackTrace();
				}
				score--;
			}
		} 

		return proposals;

	}

	private Vector<IJavaCompletionProposal> createProposals(Model model,
			JavaContentAssistInvocationContext jc, Resource resource,
			ASTNode coveringNode,int score, EObject eObject) {
		//content assist
		Vector<IJavaCompletionProposal> proposals = new Vector<IJavaCompletionProposal>();
		EList<EStructuralFeature> allStructuralFeatures = eObject.eClass().getEAllStructuralFeatures();
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
		for (EStructuralFeature structuralFeature:allStructuralFeatures){
			String type="";
			if (structuralFeature instanceof EAttribute){
				type = "EAttribute";
				if (!FSMLEcoreUtil.isFeaturePresent(eObject, structuralFeature)){
						String projectName = resource.getURI().fileExtension();
						projectName = projectName.substring(0,1).toUpperCase()+projectName.substring(1);
						String proposalName = structuralFeature.getName();
						if (proposalName.length()>0){
							proposalName = proposalName.toUpperCase().charAt(0)+proposalName.substring(1);
							//if we have more than one concrete class, we should use the concreteClass name instead
							//going with the reference name for now to be consistent with the metamodel in DSPD
							//proposalName = concreteClass.getName();
						}
						ASTRewrite rewrite = ASTRewrite.create(coveringNode.getAST());
						
						FSMLJavaProposal linkedCorrectionProposal = new FSMLJavaProposal(
								"FSML: " + proposalName+"("+eObject.eClass().getName()+", "+projectName+")", jc.getCompilationUnit(), rewrite, score,
								proposalImage,eObject,null,structuralFeature,coveringNode,jc.getInvocationOffset(),resource,jc.getCoreContext());
						proposals.add(linkedCorrectionProposal);
					
				}
				continue;
			} else if (structuralFeature instanceof EReference){
				type = "EReference";
				Collection<EClass> concreteClasses = FSMLEcoreUtil
				.getSubclassesOfEClass(((EReference)structuralFeature).getEReferenceType(), true);
				for (EClass concreteClass : concreteClasses) {
					
					//calculate the number of instances so cardinality check can be done later on
					EList<EObject> contents = eObject.eContents();
					int numInstances = 0;
					for (EObject object : contents) {
						if (object.eClass().getName().equals(concreteClass.getName())){
							numInstances++;
						}
					}
					

						if (structuralFeature.getUpperBound()!=-1 && numInstances+1>structuralFeature.getUpperBound()){
							//skip this proposal if cardinaltiy constraint is not met
						
							//TODO: problem with feature group
							continue;
					
						}
						EAnnotation featureGroup= structuralFeature.getEAnnotation(FSMLEcoreUtil.FEATURE_GROUP);
						if (featureGroup!=null){
							//feature group
							if (false){
								continue;
							}
						}
						ASTRewrite rewrite = ASTRewrite.create(coveringNode.getAST());
						String projectName = resource.getURI().fileExtension();
						projectName = projectName.substring(0,1).toUpperCase()+projectName.substring(1);
						String proposalName = structuralFeature.getName();
						if (proposalName.length()>0){
							proposalName = proposalName.toUpperCase().charAt(0)+proposalName.substring(1);
							//if we have more than one concrete class, we should use the concreteClass name instead
							//going with the reference name for now to be consistent with the metamodel in DSPD
							//proposalName = concreteClass.getName();
						}

						FSMLJavaProposal linkedCorrectionProposal = new FSMLJavaProposal(
								"FSML: " + proposalName+"("+eObject.eClass().getName()+", "+projectName+")", jc.getCompilationUnit(), rewrite, score,
								proposalImage,eObject,concreteClass,structuralFeature,coveringNode,jc.getInvocationOffset(),resource,jc.getCoreContext());
						
						
						/*
						 *           KEYWORD 
						 *         PROGRAMMING
						 *             !!!
						 */
						char[] token = jc.getCoreContext().getToken();
						String keywordToken;
						if (token==null){
							keywordToken="";
						}else {
							keywordToken= new String(token);
						}
						
						
						if (keywordToken!=null && keywordToken.length()!=0){
							linkedCorrectionProposal.setDeleteKeyword(true);
						}
						
						if (keywordToken!=null && keywordToken.length()!=0 && keywordToken.matches(".*[A-Z].*")){
 							String conceptName = concreteClass.getName();
							
							//split camel case concept name
							StringBuffer buffer = new StringBuffer();
							Collection<String> conceptNameTokens = new Vector<String>();
							for (int i=0;i<conceptName.length()-1;i++){
								char currentChar = conceptName.charAt(i);
								if (Character.isUpperCase(currentChar) && buffer.toString().length()!=0){
									conceptNameTokens.add(buffer.toString());
									buffer = new StringBuffer();
								} 
								buffer.append(currentChar);
							}
							buffer.append(conceptName.charAt(conceptName.length()-1));
							conceptNameTokens.add(buffer.toString());
						
							
							boolean conceptNameContainsKeyword = false;
							for (Iterator iterator = conceptNameTokens.iterator(); iterator
									.hasNext();) {
								String currentToken = (String) iterator.next();
								if (keywordToken.toUpperCase().contains(currentToken.toUpperCase())){
									conceptNameContainsKeyword=true;
								}
								
							}
							//filter the proposals so that only proposals for concept names containing more than one word in the keyword appears
							//TODO: better ranking algorithm
							if (conceptNameContainsKeyword){
								proposals.add(linkedCorrectionProposal);
								//score++;
							}
							
						} //end keyword programming 
						else {
						
							proposals.add(linkedCorrectionProposal);
							//score++;
						}
				}
			}
		}
//		if (proposals.size()==1){
//			FSMLProposal onlyProposal = (FSMLProposal)proposals.get(0);
//			try {
//				onlyProposal.performChange(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor(), jc.getDocument());
//			} catch (CoreException e) {
//				e.printStackTrace();
//			}
//			proposals.clear();
//		}
		return proposals;
	}	

}
