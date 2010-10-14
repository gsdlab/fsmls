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
package ca.uwaterloo.gsd.fsml.xmleditor.editors;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IndexedRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;

import ca.uwaterloo.gsd.fsml.codeAssist.FSMLCodeAssistUtil;
import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.xmlMappingInterpreter.XMLMappingInterpreter;

public class FSMLXMLContentAssistProcessor implements IContentAssistProcessor {

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {

		IFile currentFile = (IFile) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput().getAdapter(IFile.class);

		List<IFile> fsmlModelFiles = FSMLCodeAssistUtil.findModelFile(
				currentFile.getProject(),
				FSMLCodeAssistUtil.supportedFrameworks);

		Vector<ICompletionProposal> proposals = new Vector<ICompletionProposal>();
		for (IFile fsmlModelFile : fsmlModelFiles) {
			if (fsmlModelFile == null || !fsmlModelFile.exists()) {
				System.err.println("no valid project found");
				return new CompletionProposal[0];
			}
			EList<EObject> fsmlModel = null;
			ResourceSet resourceSet = new ResourceSetImpl();
			URI fsmlModelURI = URI.createPlatformResourceURI(fsmlModelFile
					.getFullPath().toString(), true);
			Resource resource = resourceSet.getResource(fsmlModelURI, true);

			fsmlModel = resource.getContents();

			Model assertedModel = ((ModelContainer) fsmlModel.get(0))
					.getAssertedModel();
			Queries.INSTANCE.reset();
			// register Java mapping interpreter

			// register XML mapping interpreter
			XMLMappingInterpreter xmlMappingInterpreter = new XMLMappingInterpreter();
			Queries.INSTANCE.registerCustomInterpreter(xmlMappingInterpreter);

			Queries.INSTANCE
					.initialize(currentFile.getProject(), assertedModel);

			// main method call

			IDOMModel modelForEdit;
			modelForEdit = (IDOMModel) StructuredModelManager
					.getModelManager()
					.getModelForEdit((IStructuredDocument) viewer.getDocument());
			;
			((IStructuredDocument) viewer.getDocument())
					.getAdapter(IFile.class);

			IndexedRegion indexedRegion = modelForEdit.getIndexedRegion(offset);
			
			Markers.INSTANCE.setProject(currentFile.getProject());
			Vector<IMarker> markers = Markers.INSTANCE.getCoveringMarkers(
					currentFile, offset, indexedRegion.getLength());

			HashMap<String, EObject> fsmlId2ModelEObject = new HashMap<String, EObject>();
			FSMLEcoreUtil.createFsmlId2EObjectMap(assertedModel,
					fsmlId2ModelEObject);

			for (IMarker marker : markers) {
				EObject eObject;
				try {
					eObject = fsmlId2ModelEObject.get(marker
							.getAttribute(MarkerDescriptor.ATTRIBUTE_ID));
					if (eObject != null) {
						
						int start = ((Integer)marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START));
						int end = ((Integer)marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END));
						xmlMappingInterpreter.associateContext(start, end,eObject);
						proposals.addAll(createProposals(assertedModel,
								resource, offset, indexedRegion.getLength(),
								eObject));
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return proposals.toArray(new FSMLXMLProposal[1]);
	}

	private Vector<ICompletionProposal> createProposals(Model model,
			Resource resource, int offset, int length, 
			EObject eObject) {
		// content assist
		Vector<ICompletionProposal> proposals = new Vector<ICompletionProposal>();
		EList<EStructuralFeature> allStructuralFeatures = eObject.eClass()
				.getEAllStructuralFeatures();
		Image proposalImage = null;
		if (resource.getURI().path() != null) {
			IEditorDescriptor modelEditor = PlatformUI.getWorkbench()
					.getEditorRegistry().getDefaultEditor(
							resource.getURI().path());
			if (modelEditor != null) {
				proposalImage = modelEditor.getImageDescriptor().createImage();
			}
		}
		if (proposalImage == null) {
			proposalImage = PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_TOOL_FORWARD);
			
		}
		for (EStructuralFeature structuralFeature : allStructuralFeatures) {
			String type = "";
			if (structuralFeature instanceof EAttribute) {
				type = "EAttribute";

				// calculate the number of instances so cardinality check can be
				// done later on
			
				int numInstances = 0;
				
				if ((eObject.eIsSet(structuralFeature)) && !eObject.eGet(structuralFeature).getClass().isArray()) {
					numInstances = 1;
				} else if (eObject.eIsSet(structuralFeature)) {
					numInstances = Arrays.asList(eObject.eGet(structuralFeature)).size();
					
				}
				
				if (structuralFeature.getUpperBound() != -1
						&& numInstances + 1 > structuralFeature.getUpperBound()) {
					// skip this proposal if cardinaltiy constraint is not met

					// TODO: problem with feature group
					continue;

				}
				EAnnotation featureGroup = structuralFeature
						.getEAnnotation(FSMLEcoreUtil.FEATURE_GROUP);
				if (featureGroup != null) {
					// feature group
					if (false) {
						continue;
					}
				}
				// ASTRewrite rewrite =
				// ASTRewrite.create(coveringNode.getAST());
				String projectName = resource.getURI().fileExtension();
				projectName = projectName.substring(0, 1).toUpperCase()
						+ projectName.substring(1);
				String proposalName = structuralFeature.getName();
				if (proposalName.length() > 0) {
					proposalName = proposalName.toUpperCase().charAt(0)
							+ proposalName.substring(1);
					// if we have more than one concrete class, we should use
					// the concreteClass name instead
					// going with the reference name for now to be consistent
					// with the metamodel in DSPD
					// proposalName = concreteClass.getName();
				}

				ICompletionProposal linkedCorrectionProposal = new FSMLXMLProposal(
						"FSML: " + proposalName + "("
						+ eObject.eClass().getName() + ", "
						+ projectName + "-Attribute)", eObject,null,structuralFeature,resource,proposalImage);


				proposals.add(linkedCorrectionProposal);

			} else if (structuralFeature instanceof EReference) {
				type = "EReference";
				Collection<EClass> concreteClasses = FSMLEcoreUtil
						.getSubclassesOfEClass(((EReference) structuralFeature)
								.getEReferenceType(), true);
				for (EClass concreteClass : concreteClasses) {

					// calculate the number of instances so cardinality check
					// can be done later on
					EList<EObject> contents = eObject.eContents();
					int numInstances = 0;
					for (EObject object : contents) {
						if (object.eClass().getName().equals(
								concreteClass.getName())) {
							numInstances++;
						}
					}

					if (structuralFeature.getUpperBound() != -1
							&& numInstances + 1 > structuralFeature
									.getUpperBound()) {
						// skip this proposal if cardinaltiy constraint is not
						// met

						// TODO: problem with feature group
						continue;

					}
					EAnnotation featureGroup = structuralFeature
							.getEAnnotation(FSMLEcoreUtil.FEATURE_GROUP);
					if (featureGroup != null) {
						// feature group
						if (false) {
							continue;
						}
					}
					// ASTRewrite rewrite =
					// ASTRewrite.create(coveringNode.getAST());
					String projectName = resource.getURI().fileExtension();
					projectName = projectName.substring(0, 1).toUpperCase()
							+ projectName.substring(1);
					String proposalName = structuralFeature.getName();
					if (proposalName.length() > 0) {
						proposalName = proposalName.toUpperCase().charAt(0)
								+ proposalName.substring(1);
						// if we have more than one concrete class, we should
						// use the concreteClass name instead
						// going with the reference name for now to be
						// consistent with the metamodel in DSPD
						// proposalName = concreteClass.getName();
					}

					ICompletionProposal linkedCorrectionProposal = new FSMLXMLProposal(
							"FSML: " + proposalName + "("
									+ eObject.eClass().getName() + ", "
									+ projectName + ")", eObject,concreteClass,structuralFeature,resource,proposalImage);

					proposals.add(linkedCorrectionProposal);
				}
			}
		}
		// if (proposals.size()==1){
		// FSMLProposal onlyProposal = (FSMLProposal)proposals.get(0);
		// try {
		// onlyProposal.performChange(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor(),
		// jc.getDocument());
		// } catch (CoreException e) {
		// e.printStackTrace();
		// }
		// proposals.clear();
		// }
		return proposals;
	}

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub

		return null;
	}

}
