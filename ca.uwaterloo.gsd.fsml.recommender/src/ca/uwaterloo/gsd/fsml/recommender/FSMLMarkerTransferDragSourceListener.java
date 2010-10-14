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
package ca.uwaterloo.gsd.fsml.recommender;


import java.util.List;

import org.eclipse.core.internal.resources.Marker;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MarkerTransfer;

import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;

public class FSMLMarkerTransferDragSourceListener extends DragSourceAdapter
		implements TransferDragSourceListener {

	private IWorkbenchPage page;

	private final StructuredViewer viewer;

	private final IProject project;

	public FSMLMarkerTransferDragSourceListener(StructuredViewer viewer,IProject project) {
		this.viewer = viewer;
		this.project = project;
		}

	@Override
	public Transfer getTransfer() {
		return MarkerTransfer.getInstance();
	}

	public void dragSetData(DragSourceEvent event) {
		Object[] data = ((IStructuredSelection) viewer.getSelection())
				.toArray();
		String parentKey = FSMLEcoreUtil.getFSMLId((EObject) data[0], null);
		List<IMarker> markers = Markers.INSTANCE.getMarkers(parentKey);
		Marker marker=null;
		if (markers.size() != 0) {
			event.doit = true;
			marker = (Marker) markers.get(0);
		
		} else {
			// Now for each feature
			EClass parentClass = ((EObject) (EObject) data[0]).eClass();
			for (EStructuralFeature feature : parentClass.getEAllStructuralFeatures()) {
				String id = parentKey + "::" + feature.getName();
				// Attributes that are * can have values
				if (feature.isMany() && ! (feature instanceof EReference)) {
					for (Object value : (EList<?>) ((EObject) data[0]).eGet(feature)) {
						if (Markers.INSTANCE.getMarkers(id + "(" + value + ")").size()>0) {
							marker =(Marker)Markers.INSTANCE.getMarkers(id + "(" + value + ")").get(0);
						}
						break;
					}
				} else {
					if (Markers.INSTANCE.getMarkers(id).size()>0) {
						marker =(Marker)Markers.INSTANCE.getMarkers(id).get(0);
					}
					break;
				}
			}
		}
		event.data = new Marker[] { marker };
		event.detail = DND.DROP_MOVE;
	}

	@Override
	public void dragStart(DragSourceEvent event) {
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

		if (found) {
			event.doit = true;

			Image icon = PlatformUI.getWorkbench().getSharedImages().getImage(
					org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJS_BKMRK_TSK);

			double zoom = 1d * 5;

			final int width = icon.getBounds().width;
			final int height = icon.getBounds().height;

			event.image = new Image(Display.getDefault(), icon.getImageData()
					.scaledTo((int) (width * zoom), (int) (height * zoom)));
			// maybe this is too intrusive?
			/*try {
				
				PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().showView(
								"ca.uwaterloo.gsd.fsml.GoToView");
			} catch (PartInitException e) {
				e.printStackTrace();
			}*/

		} else {
			event.doit = false;
		}

	}

}
