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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter;

import java.util.HashMap;

import org.eclipse.core.internal.resources.Marker;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MarkerTransfer;

import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.implModel.Variant;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.JavaImplVariantManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.JavaImplVariantManagerConstants;

public class FSMLCodeGenDragSourceListener extends DragSourceAdapter implements
		TransferDragSourceListener {
	private final StructuredViewer viewer;
	private final IProject project;

	public FSMLCodeGenDragSourceListener(StructuredViewer viewer,
			IProject project) {
		this.viewer = viewer;
		this.project = project;
	}

	@Override
	public Transfer getTransfer() {
		return MarkerTransfer.getInstance();
		// return PluginTransfer.getInstance();
	}

	public void dragSetData(DragSourceEvent event) {
		//event.data = "showStatus(null);";
		// event.data = new PluginTransferData( "my_drop_action", new
		// byte[]{(byte)1});
		event.detail = DND.DROP_MOVE;

		ResourceSet resourceSet = new ResourceSetImpl();
		EList<EObject> existingResourceModel = null;

		IFile implModelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				project.getFullPath().append(JavaImplVariantManager.modelName));
		URI implModelURI = URI.createPlatformResourceURI(implModelFile
				.getFullPath().toString(), true);

		if (implModelFile.exists()) {

			existingResourceModel = resourceSet.getResource(implModelURI, true)
					.getContents();

		}

		HashMap<String, EObject> defaultsInImplModel = new HashMap<String, EObject>();

		EList<EObject> implModelContents = existingResourceModel.get(0)
				.eContents();
		EObject currentFeature = null;
		for (int i = 0; i < implModelContents.size(); i++) {
			currentFeature = implModelContents.get(i);
			if (currentFeature.eClass().getName().startsWith(
					JavaImplVariantManagerConstants.DEFAULT)) {
				// check if the mapping is the same (eClass and
				// eStructuralFeature)
				String eClass = (String) currentFeature.eGet(currentFeature
						.eClass().getEStructuralFeature(
								JavaImplVariantManagerConstants.ECLASS));
				String eStructuralFeature = (String) currentFeature
						.eGet(currentFeature
								.eClass()
								.getEStructuralFeature(
										JavaImplVariantManagerConstants.ESTRUCTURALFEATURE));

				EList<Variant> defaultVariants = ((EList) currentFeature
						.eGet(JavaImplVariantManager
								.getVariantReferenceForDefault(currentFeature
										.eClass())));

				String mappingType = currentFeature
						.eClass()
						.getName()
						.replaceAll(
								JavaImplVariantManagerConstants.DEFAULT
										+ JavaImplVariantManagerConstants.DELIMITER,
								"");
				String hashMapKey = mappingType
						+ JavaImplVariantManagerConstants.DELIMITER + eClass
						+ JavaImplVariantManagerConstants.DELIMITER
						+ eStructuralFeature;
				defaultsInImplModel.put(hashMapKey, currentFeature);
			}

		}
		EObject eObj = (EObject) ((IStructuredSelection) viewer.getSelection())
				.toArray()[0];
		EList<EAnnotation> annotations = eObj.eContainingFeature()
				.getEAnnotations();

		for (EAnnotation annotation : annotations) {
			String hashMapKey = annotation
					.getSource()
					+ JavaImplVariantManagerConstants.DELIMITER
					+ eObj.eContainer().eClass().getName()
					+ JavaImplVariantManagerConstants.DELIMITER
					+ eObj.eContainingFeature().getName();
			if (defaultsInImplModel.containsKey(hashMapKey)) {
				EObject defaultMappingType = defaultsInImplModel.get(hashMapKey);

				EList defaultVariants=(EList)defaultMappingType.eGet(defaultMappingType.eClass().getEStructuralFeature(JavaImplVariantManagerConstants.VARIANT));
				if (defaultVariants.size()>0) {
					String declaringMethodKey = (String)((EObject)defaultVariants.get(0)).eGet(((EObject)defaultVariants.get(0)).eClass().getEStructuralFeature(JavaImplVariantManagerConstants.METHOD_NAME));
					
					
//					IResource resource = iMember.getJavaProject().getResource();
//					JavaMarkerDescriptor markerDescriptor = createJavaMarkerDescriptor(resource, fullyQualifiedName, value, explanation);
//					markerDescriptor.setCharStartCharEnd(iMember);
//					
//					
//					BindingKeyResolver resolver = new BindingKeyResolver(declaringMethodKey);
//					resolver.parse();
//					resolver.getCompilationUnitDeclaration();
					
//					try {
//						JavaCore.create(project).findType(Util.getDeclaringTypeSignature(declaringMethodKey));
//					} catch (JavaModelException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
					event.data = new Marker[] { (Marker)Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId((EObject)defaultVariants.get(0),null)).get(0)};
					
				}
			}
		}

	}

	@Override
	public void dragStart(DragSourceEvent event) {
		// check whether the feature is in the last reconciled model - if not,
		// this listener will handle it
		EObject eObj = (EObject) ((IStructuredSelection) viewer.getSelection())
				.toArray()[0];
		String parentKey = FSMLEcoreUtil.getFSMLId(eObj, null);

		Model lastReconciledModel = ((ModelContainer) eObj.eResource()
				.getResourceSet().getResources().get(0).getContents().get(0))
				.getLastReconciledModel();
		TreeIterator<EObject> allContents = lastReconciledModel.eAllContents();
		boolean found = false;
		while (allContents.hasNext()) {
			if (parentKey.equals(FSMLEcoreUtil.getFSMLId(allContents.next(),
					null))) {
				found = true;
				break;
			}
		}

		if (!found) {
			event.doit = true;

			Image icon = PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_TOOL_FORWARD);

			double zoom = 1d * 5; // scale to half of the size maintaining
			// aspect ratio

			ImageData iconImageData = icon.getImageData().scaledTo(
					(int) (icon.getBounds().width * zoom),
					(int) (icon.getBounds().height * zoom));
			event.image = new Image(Display.getDefault(), iconImageData);

		} else {
			event.doit = false;
		}

	}
}
