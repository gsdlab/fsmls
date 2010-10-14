/*******************************************************************************
 * Copyright (c) 2010 Michal Antkiewicz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Michal Antkiewicz - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.javaeditor.InternalClassFileEditorInput;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class ModelCodeNavigationView extends ViewPart implements ISelectionListener, IDoubleClickListener, IPartListener {
	private TableViewer viewer;
	private IWorkbenchPart part;
	
	public ModelCodeNavigationView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(null);
		viewer.addDoubleClickListener(this);
				
		getSite().getPage().addSelectionListener(this);
		getSite().getPage().addPartListener(this);
	}

	@Override
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object object = ((IStructuredSelection) selection).getFirstElement();
			if (object instanceof EObject) {
				//make sure Markers are configured with appropriate project
				if (part instanceof IEditorPart) {
					if (this.part != part) {
						IFileEditorInput input = (IFileEditorInput) ((IEditorPart) part).getEditorInput();
						IProject project = input.getFile().getProject();
						Markers.INSTANCE.setProject(project);
						this.part = part;
					}
					viewer.setInput(object);
					// store part as a provider of the current input.
				}
				else if (part instanceof ModelCodeSynchronizationView) {
					ClassSyncItem classSyncItem = null;
					if (object instanceof StructuralFeatureSyncItem) {
						classSyncItem = (ClassSyncItem) ((StructuralFeatureSyncItem) object).eContainer();
					}
					else if (object instanceof ClassSyncItem)
						classSyncItem = (ClassSyncItem) object;
					
					if (classSyncItem != null) {
						EObject element = classSyncItem.getModel();
						if (element == null)
							element = classSyncItem.getCode();
						
						viewer.setInput(element);
					}
				}
			}
		}
	}
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		getSite().getPage().removePartListener(this);
		super.dispose();
	}
	
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			v.refresh();
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent instanceof EObject) {
				EObject element = (EObject) parent;
				// Retrieve markers in this list
				List<IMarker> markers = new ArrayList<IMarker>();
				
				// First put the markers for the parent key
				String parentKey = FSMLEcoreUtil.getFSMLId(element, null);
				addMarkers(markers, parentKey);
				
				// Now for each feature
				EClass parentClass = ((EObject) parent).eClass();
				for (EStructuralFeature feature : parentClass.getEAllStructuralFeatures()) {
					String id = parentKey + "::" + feature.getName();
					// Attributes that are * can have values
					if (feature.isMany() && ! (feature instanceof EReference)) {
						for (Object value : (EList<?>) element.eGet(feature)) {
							addMarkers(markers, id + "(" + value + ")");
						}
					} else {
						addMarkers(markers, id);
					}
				}
				return markers.toArray();	
			}
			return new Object[] {};
		}
	}
	
	/**
	 * Convenience method to add all markers identified by this id to this list or markers
	 * 
	 * @param markers the list of markers where the markers will be added
	 * @param id the marker id
	 */
	protected void addMarkers(List<IMarker> markers, String id) {

		for(IMarker marker : Markers.INSTANCE.getMarkers(id)) {
			if (marker.exists())
				markers.add(marker);
		}
	}
	
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			if (obj instanceof IMarker) {
				IMarker marker = (IMarker) obj;
				String label = marker.getAttribute("message", null);
				// for debug: return label + " ---> " + marker.getAttribute("id", null);
				return label;
			}
			return "<unknown>";
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_TOOL_FORWARD);
		}
	}
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			Object object = ((IStructuredSelection)selection).getFirstElement();
			if (object instanceof IMarker) {
				IMarker marker = (IMarker) object;
				if (marker.exists()) {
					// marker in a binary resource
					// this is Java-specific
					String customAttributeName = (String) marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CUSTOM_ATTRIBUTE, null);
					if ("fullyQualifiedName".equals(customAttributeName)) {
						String fullyQualifiedName = (String) marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CUSTOM_ATTRIBUTE_VALUE, null);
						
						// TODO: Michal: refactor to remove dependency of the core on JDT
						IJavaProject javaProject = JavaCore.create(marker.getResource().getProject());
						IType iType;
						try {
							iType = javaProject.findType(fullyQualifiedName);
							InternalClassFileEditorInput input = new InternalClassFileEditorInput(iType.getClassFile());
							
							IEditorPart classFileEditor = getSite().getPage().openEditor(input, "org.eclipse.jdt.ui.ClassFileEditor");
							classFileEditor.setFocus();
							IDE.gotoMarker(classFileEditor, marker);
						} catch (JavaModelException e) {
							e.printStackTrace();
						} catch (PartInitException e) {
							e.printStackTrace();
						}
					}
					else {
						// marker in a source resource
						try {
							IDE.openEditor(getSite().getPage(), marker, OpenStrategy.activateOnOpen());
						} catch (PartInitException e) {
							// should never happen!
						}
					}
				}
			}
		}
	}
	public void partClosed(IWorkbenchPart part) {
		if (this.part == part) { 
			// current provider got closed. Empty contents
			viewer.setInput(null);
			this.part = null;
		}
	}
	public void partDeactivated(IWorkbenchPart part) {
	}
	public void partOpened(IWorkbenchPart part) {
	}
	public void partActivated(IWorkbenchPart part) {
	}
	public void partBroughtToTop(IWorkbenchPart part) {
	}
}
