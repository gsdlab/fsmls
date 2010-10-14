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
package ca.uwaterloo.gsd.fsml.ecoreview.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import ca.uwaterloo.gsd.fsml.ecoreview.provider.EcoreEditPlugin;
import ca.uwaterloo.gsd.fsml.ecoreview.provider.FSMLEcoreItemProviderAdapterFactory;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class FSMLEcoreView extends ViewPart implements IPartListener, ISelectionChangedListener {
	private TreeViewer viewer;
	private EcoreEditor ecoreEditor;
	private ComposedAdapterFactory adapterFactory;
	private Action toggleAnnotations;
	private boolean showAnnotations = true;
	private boolean abbreviatedForm = true;
	
	/**
	 * This action opens the Properties view.
	 */
	protected IAction showPropertiesViewAction;
    /**
     * This action refreshes the viewer of the current editor if the editor
     */
    protected IAction refreshViewerAction = new Action("&Refresh")	{
    	public boolean isEnabled() {
    		return true;
        }
        public void run() {
        	if (viewer != null)
        		viewer.refresh();
        }
    };
	private Action expandAll;
	private Action collapseAll;
	private Action toggleAbbreviatedForm;

	public FSMLEcoreView() {
		List<AdapterFactoryImpl> factories = new ArrayList<AdapterFactoryImpl>();
	    factories.add(new ResourceItemProviderAdapterFactory());
	    factories.add(new FSMLEcoreItemProviderAdapterFactory());
	    factories.add(new ReflectiveItemProviderAdapterFactory());

	    adapterFactory = new ComposedAdapterFactory(factories);
	}

	public void createPartControl(Composite parent) {
		
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {
			@Override
			public Object[] getChildren(Object object) {
				Object[] children = super.getChildren(object);
				if (showAnnotations) {
					ArrayList<Object> filteredChildren = new ArrayList<Object>();
					for (Object child : children) {
						if (!(child instanceof EAnnotation))
							filteredChildren.add(child);
					}
					children = filteredChildren.toArray();
				}
				return children;
			}
		});
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {
			@Override
			public String getText(Object object) {
				return getColumnText(object, 0);
			}
			@Override
			public String getColumnText(Object object, int columnIndex) {
				String label = super.getText(object);
				if (showAnnotations && object instanceof EModelElement) {
					EModelElement ecoreElement = ((EModelElement) object);
					
					EList annotations = new BasicEList();
					annotations.addAll(ecoreElement.getEAnnotations());
					
					if (annotations.isEmpty())
						return label;
					
					for (Object aux : annotations) {
						EAnnotation annotation = (EAnnotation) aux;
						if (!annotation.getSource().equals("featureGroup") &&
							!annotation.getSource().equals("essential")  &&
							!annotation.getSource().equals("key")   &&
							!annotation.getSource().equals("parentKey")  &&
							!annotation.getSource().equals("indexKey")) {
							label += " " + describeAnnotation(annotation);
						}
					}
				}
				return label;
			}
			private String describeAnnotation(EAnnotation annotation) {
				StringBuffer label = new StringBuffer();
				String source = annotation.getSource();
				
				if (!abbreviatedForm) {
					// simply list all details
					label.append(source);
					for (Object aux : annotation.getDetails()) {
						Entry entry = (Entry) aux;
					
						String key = (String) entry.getKey(); 
						String value = (String) entry.getValue();
						label.append(" " + key + ": '" + value +"'");
					}
					return "<" + label.toString() + ">";
				}
				if (source.equals("methodCalls")) {
					label.append("methodCalls: '");
					try {
						String className = (String) annotation.getDetails().get("class");
						className = Signature.getSimpleName(className);
						String methodName = (String) annotation.getDetails().get("name");
						String signature = (String) annotation.getDetails().get("signature");
						String receiver = (String) annotation.getDetails().get("receiver");
						label.append(Signature.toString(signature, methodName != null ? className + "." + methodName : className, null, false, true));
						label.append("' in: '" + (String) annotation.getDetails().get("in") + "'");
						if (receiver != null && !receiver.isEmpty())
							label.append(" receiver: '" + Signature.getSimpleName(receiver) + "'");
					} catch (IllegalArgumentException e) {
						label.append("<signature parse error>");
					}
				}
				else if (source.equals("callsReceived")) {
					label.append("callsReceived: '");
					try {
						String className = (String) annotation.getDetails().get("class");
						className = Signature.getSimpleName(className);
						String methodName = (String) annotation.getDetails().get("name");
						String signature = (String) annotation.getDetails().get("signature");
						label.append(Signature.toString(signature, className + "." + methodName, null, false, true) +"'");
					} catch (IllegalArgumentException e) {
						label.append("<signature parse error>");
					}
				}
				else if (source.equals("assignedWithNew")) {
					label.append("assignedWithNew: ");
					try {
						// two variants: subtypeOf or explicit type
						String subtypeOf = (String) annotation.getDetails().get("subtypeOf");
						if (subtypeOf != null)
							label.append("subtypeOf: '" + subtypeOf + "'");
						else {
							String methodName = (String) annotation.getDetails().get("class");
							methodName = Signature.getSimpleName(methodName);
							String signature = (String) annotation.getDetails().get("signature");
							label.append("'" + Signature.toString(signature, methodName, null, false, false));
						}
					} catch (IllegalArgumentException e) {
						label.append("<signature parse error>");
					}
				}
				else if (source.equals("assignedWithNull"))
					label.append("assignedWithNull");
				else if (source.equals("methods")) {
					label.append("methods: '");
					try {
						String methodName = (String) annotation.getDetails().get("name");
						if (methodName == null || methodName.equals(""))
							methodName = "*";
						String signature = (String) annotation.getDetails().get("signature");
						label.append(Signature.toString(signature, methodName, null, false, true));
						label.append("' inherited: " + (String) annotation.getDetails().get("inherited"));
					} catch (IllegalArgumentException e) {
						label.append("<signature parse error>");
					}
				}
				else{
					label.append(source);
					boolean firstDetail = true;
					for (Object aux : annotation.getDetails()) {
						Entry entry = (Entry) aux;
					
						String key = (String) entry.getKey(); 
						String value = (String) entry.getValue();
						
						if (key.equals("local") || 
							key.equals("concrete") || 
							key.equals("inherited") ||
							key.equals("index") ||
							key.equals("argument")||
							key.equals("attribute")||
							key.equals("sameAsArg") ||
							key.equals("before") ||
							key.equals("ofCall") ||
							key.equals("ofMethodCall") ||
							key.equals("featurePath") ||
							key.equals("feature") ||
							key.equals("contains") ||
							key.equals("call") ||
							key.equals("equalsTo") ||
							key.equals("valueEqualsTo")) {
							if (firstDetail) {
								label.append(": " + value);
								firstDetail = false;
							} 
							else
								label.append(" " + key + ": " + value);
						}
						else {
							if (key.equals("name") || key.equals("class")) {
								try {
									value = Signature.getSimpleName(value);
								} catch (IllegalArgumentException e) {}
							}
							if (firstDetail) {
								label.append(": '" + value+ "'");
								firstDetail = false;
							} 
							else
								label.append(" " + key + ": '" + value+ "'");
						}
					}
				}
				return "<" + label.toString() + ">";
			}
		});
	
		viewer.addSelectionChangedListener(this);
		viewer.setInput(null);
		
		getSite().getPage().addPartListener(this);
		// Michal: to provide selection for the properties view
		getSite().setSelectionProvider(viewer);
		
		// actions
		toggleAnnotations = new Action("Toggle Annotations") {
			public void run() {
				showAnnotations = !showAnnotations;
		        viewer.refresh();
		        
		        if (showAnnotations) {
		        	setToolTipText("Hide Annotations");
		        	setDescription("Hide Annotations");
		        	setImageDescriptor(
		    		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		    		                EcoreEditPlugin.INSTANCE.getImage("full/ShowAnnotationsAction")));
		        }
		        else {
		        	setToolTipText("Show Annotations");
		        	setDescription("Show Annotations");
		        	setImageDescriptor(
		    		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		    		                EcoreEditPlugin.INSTANCE.getImage("full/HideAnnotationsAction")));
		        }
            }
		};
		toggleAnnotations.setToolTipText("Hide Annotations");
		toggleAnnotations.setDescription("Hide Annotations");
		toggleAnnotations.setImageDescriptor(
		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		                EcoreEditPlugin.INSTANCE.getImage("full/ShowAnnotationsAction")));
		
		toggleAbbreviatedForm = new Action("Show Abbreviated Form") {
			public void run() {
				abbreviatedForm = !abbreviatedForm;
		        viewer.refresh();
		        
		        if (abbreviatedForm) {
		        	setToolTipText("Show Full Form");
		        	setDescription("Show Full Form");
		        	setImageDescriptor(
		    		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		    		                EcoreEditPlugin.INSTANCE.getImage("full/AbbreviatedFormAction")));
		        }
		        else {
		        	setToolTipText("Show Abbreviated Form");
		        	setDescription("Show Abbreviated Form");
		        	setImageDescriptor(
		    		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		    		                EcoreEditPlugin.INSTANCE.getImage("full/FullFormAction")));
		        }
            }
		};
		toggleAbbreviatedForm.setToolTipText("Show Full Form");
		toggleAbbreviatedForm.setDescription("Show Full Form");
		toggleAbbreviatedForm.setImageDescriptor(
		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		                EcoreEditPlugin.INSTANCE.getImage("full/AbbreviatedFormAction")));
		
		showPropertiesViewAction = new Action("Show Properties View") {
				public void run() {
			        try {
			        	getSite().getPage().showView("org.eclipse.ui.views.PropertySheet");
			        }
			        catch (PartInitException exception) { }
			    }
			};
		showPropertiesViewAction.setToolTipText("Show Properties View");
		showPropertiesViewAction.setImageDescriptor(
		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		                EcoreEditPlugin.INSTANCE.getImage("full/PropertiesView")));
		
		expandAll = new Action("Expand All") {
			public void run() {
		        viewer.expandAll();
            }
		};
		expandAll.setToolTipText("Expand All");
		expandAll.setDescription("Expand All");
		expandAll.setImageDescriptor(
		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		                EcoreEditPlugin.INSTANCE.getImage("full/expandall")));
		
		collapseAll = new Action("Collapse All") {
			public void run() {
		        viewer.collapseAll();
            }
		};
		collapseAll.setToolTipText("Collapse All");
		collapseAll.setDescription("Collapse All");
		collapseAll.setImageDescriptor(
		        ExtendedImageRegistry.getInstance().getImageDescriptor(
		                EcoreEditPlugin.INSTANCE.getImage("full/collapseall")));
		
		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		toolBarManager.add(refreshViewerAction);
		toolBarManager.add(expandAll);
		toolBarManager.add(collapseAll);
		toolBarManager.add(toggleAnnotations);
		toolBarManager.add(toggleAbbreviatedForm);
		toolBarManager.add(showPropertiesViewAction);
	}
	public void dispose() {
		getSite().getPage().removePartListener(this);
		super.dispose();
	}
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public void partActivated(IWorkbenchPart part) {
		if (part instanceof EcoreEditor) {
			if (part != ecoreEditor) {
				ecoreEditor = (EcoreEditor) part;
				Object ecoreInput = ecoreEditor.getViewer().getInput();
				if (ecoreInput instanceof ResourceSet) {
					Object ePackage = ((Resource) ((ResourceSet)ecoreInput).getResources().get(0)).getAllContents().next();
					viewer.setInput(ePackage);
				}
			}
		}
	}
	public void partClosed(IWorkbenchPart part) {
		if (part instanceof EcoreEditor) {
			if (part == ecoreEditor)
				viewer.setInput(null);
		}
	}
	public void partBroughtToTop(IWorkbenchPart part) {}
	public void partDeactivated(IWorkbenchPart part) {}
	public void partOpened(IWorkbenchPart part) {}

	public void selectionChanged(SelectionChangedEvent event) {
		if (event.getSelectionProvider() == viewer && ecoreEditor != null){	
			ISelection selection = event.getSelection();
			
			if (showAnnotations && selection instanceof IStructuredSelection) {
				Object [] elements = ((IStructuredSelection) selection).toArray();
				EList<Object> newSelectedElements = new BasicEList<Object>(); 
				for (Object aux : elements) {
					if (aux instanceof EModelElement) {
						newSelectedElements.addAll(((EModelElement) aux).getEAnnotations());
						newSelectedElements.add(aux);
					}
				}
				selection = new StructuredSelection(newSelectedElements);
			}
			ecoreEditor.getViewer().setSelection(selection, true);
			//ecoreEditor.setSelection(ecoreEditor.getViewer().getSelection());
		}
	}
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IPropertySheetPage.class) && ecoreEditor != null) 
	      return ecoreEditor.getPropertySheetPage();
	    else
	    	return super.getAdapter(adapter);
	}
}
