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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationResult;
import ca.uwaterloo.gsd.fsml.sync.provider.SyncEditPlugin;
import ca.uwaterloo.gsd.fsml.sync.provider.SyncItemProviderAdapterFactory;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class ModelCodeSynchronizationView extends ViewPart implements IPartListener, ISelectionProvider {
	protected TreeViewer viewer;
	protected ReconciliationDecisionAction enforceAction;
	protected ReconciliationDecisionAction updateAction;
	protected ReconciliationDecisionAction enforceAndUpdateAction;
	protected ReconciliationDecisionAction replaceAndEnforceAction;
	protected ReconciliationDecisionAction replaceAndUpdateAction;
	protected ReconciliationDecisionAction ignore;
	private IFsmlEditor editor;
	private SynchronizationResult synchronizationResult;
	private AdapterFactory adapterFactory;
	
	public ModelCodeSynchronizationView() {
		adapterFactory = new SyncItemProviderAdapterFactory();
	}

	class NameSorter extends ViewerSorter {
	}
	
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setSorter(new NameSorter());
		viewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof SyncItem) {
					SyncItem syncItem = (SyncItem) element;
					if (!syncItem.getSynchronizationState().isConsistent())
						return true;
				}
				return false;
			}
			
		});
		
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
		makeActions();
		hookContextMenu();
		contributeToActionBars();
		
		getSite().getPage().addPartListener(this);
		getSite().setSelectionProvider(this);
	}
	public void refresh() {
		viewer.refresh();
		// refresh actions
	}
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				manager.updateAll(true);
				ModelCodeSynchronizationView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}
	private void fillContextMenu(IMenuManager manager) {
		manager.update(true);
		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		
		manager.add(enforceAction);
		manager.add(updateAction);
		manager.add(enforceAndUpdateAction);
		manager.add(replaceAndEnforceAction);
		manager.add(replaceAndUpdateAction);
		manager.add(ignore);
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.update(true);
		manager.add(enforceAction);
		manager.add(updateAction);
		manager.add(enforceAndUpdateAction);
		manager.add(replaceAndEnforceAction);
		manager.add(replaceAndUpdateAction);
		manager.add(ignore);
	}

	private void makeActions() {		
		enforceAction = new ReconciliationDecisionAction() {
			public void run() {
				setDecision(item, ReconciliationDecision.ENFORCE_LITERAL, true);
			}
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				super.selectionChanged(event);
				if (item != null)
					setEnabled(item.isDecisionValid(ReconciliationDecision.ENFORCE_LITERAL));
				else
					setEnabled(false);
			};
		};
		enforceAction.setText("Enforce in the code");
		enforceAction.setToolTipText("Propagate the change from the model in the code");
		enforceAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				"ca.uwaterloo.gsd.fsml", "icons/reconciliationDecisions/enforce.gif"));
		viewer.addSelectionChangedListener(enforceAction);
		
		updateAction = new ReconciliationDecisionAction() {
			public void run() {
				setDecision(item, ReconciliationDecision.UPDATE_LITERAL, true);
			}
			public void selectionChanged(SelectionChangedEvent event) {
				super.selectionChanged(event);
				if (item != null)
					setEnabled(item.isDecisionValid(ReconciliationDecision.UPDATE_LITERAL));
				else
					setEnabled(false);
			};
		};
		updateAction.setText("Update in the model");
		updateAction.setToolTipText("Propagate the change from the code to the model");
		updateAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				"ca.uwaterloo.gsd.fsml", "icons/reconciliationDecisions/update.gif"));
		viewer.addSelectionChangedListener(updateAction);
		
		enforceAndUpdateAction = new ReconciliationDecisionAction() {
			public void run() {
				setDecision(item, ReconciliationDecision.ENFORCE_AND_UPDATE_LITERAL, false);
			}
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				super.selectionChanged(event);
				setEnabled(item instanceof ClassSyncItem);
			};
		};
		
		// should be enabled only for ClassSyncItems
		enforceAndUpdateAction.setText("Enforce And Update");
		enforceAndUpdateAction.setToolTipText("Enforce and update the children depending on their individual decisions");
		enforceAndUpdateAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				"ca.uwaterloo.gsd.fsml", "icons/reconciliationDecisions/enforceAndUpdate.gif"));
		viewer.addSelectionChangedListener(enforceAndUpdateAction);
		
		replaceAndEnforceAction = new ReconciliationDecisionAction() {
			public void run() {
				setDecision(item, ReconciliationDecision.OVERRIDE_AND_ENFORCE_LITERAL, true);
			}
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				super.selectionChanged(event);
				if (item != null && item instanceof SyncItem) {
					boolean valid = item.isDecisionValid(ReconciliationDecision.OVERRIDE_AND_ENFORCE_LITERAL);
					if (valid) {
						setEnabled(true);
						if (item instanceof StructuralFeatureSyncItem){
							StructuralFeatureSyncItem asi = (StructuralFeatureSyncItem) item;
							if (asi.getStructuralFeature().getEAnnotation("readOnly") != null) {
								setEnabled(false);
							}
						}
					}
				}
				else
					setEnabled(false);
			};
		};
		replaceAndEnforceAction.setText("Override And Enforce");
		replaceAndEnforceAction.setToolTipText("Override the code and enforce the change from the model");
		replaceAndEnforceAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				"ca.uwaterloo.gsd.fsml", "icons/reconciliationDecisions/enforce.gif"));
		viewer.addSelectionChangedListener(replaceAndEnforceAction);
		
		replaceAndUpdateAction = new ReconciliationDecisionAction() {
			public void run() {
				setDecision(item, ReconciliationDecision.OVERRIDE_AND_UPDATE_LITERAL, true);
			}
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				super.selectionChanged(event);
				if (item != null)
					setEnabled(item.isDecisionValid(ReconciliationDecision.OVERRIDE_AND_UPDATE_LITERAL));
				else
					setEnabled(false);
			};
		};
		replaceAndUpdateAction.setText("Override And Update");
		replaceAndUpdateAction.setToolTipText("Override the model and update the model from the code");
		replaceAndUpdateAction.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				"ca.uwaterloo.gsd.fsml", "icons/reconciliationDecisions/update.gif"));
		viewer.addSelectionChangedListener(replaceAndUpdateAction);
		
		ignore = new ReconciliationDecisionAction() {
			public void run() {
				setDecision(item, ReconciliationDecision.IGNORE_LITERAL, true);
			}
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				super.selectionChanged(event);
				setEnabled(true);
			};
		};
		ignore.setText("Ignore");
		ignore.setToolTipText("Do not propagate");
		ignore.setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				"ca.uwaterloo.gsd.fsml", "icons/reconciliationDecisions/ignore.gif"));
		viewer.addSelectionChangedListener(ignore);
	}
	/**
	 * @param propagate TODO
	 * @param classSyncItem
	 * Propagates decision made for the concept to all its undecided subfeatures.
	 * Decision is set only for valid synchronization states (i.e., Update only for Reverse*)
	 * This assumes that only valid @param reconciliationDecision was made.
	 */
	private static void setDecision(SyncItem syncItem, ReconciliationDecision decision, boolean propagate) {
		// decide for the concept
		syncItem.setReconciliationDecision(decision);
		// decide for sub features
		if (propagate && syncItem instanceof ClassSyncItem) {
			ClassSyncItem classSyncItem = (ClassSyncItem) syncItem;
			for (SyncItem aux : classSyncItem.getSyncItems())
				setDecision(aux, decision, propagate);
		}
	}
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	/**
	 * this is called by the ModelCodeSynchronizeAction.run()
	 * @param synchronizationResult
	 */
	public void setSynchronizationResult(SynchronizationResult synchronizationResult) {
		setInput(synchronizationResult);
	}
	
	protected void setInput(SynchronizationResult result) {
		this.synchronizationResult = result;
		if (result != null) {
			viewer.setInput(this.synchronizationResult);
			viewer.refresh();
			viewer.expandAll();
		}
		else
			viewer.setInput(null);
	}
	public void dispose() {
		getSite().getPage().removePartListener(this);
		viewer.getTree().dispose();
		super.dispose();
	}
	/**
	 * always show synchronization results of the currently active WPI editor
	 */
	public void partActivated(IWorkbenchPart part) {
		if (part instanceof IFsmlEditor) {
			if (editor != part) {
				editor = (IFsmlEditor) part;
				
				EObject model = editor.getModel();
				if (model != null)
					setInput(SyncEditPlugin.INSTANCE.getSynchronizationResult(model));
			}
		}	
	}
	/**
	 * clear the view if current editor was closed
	 */
	public void partClosed(IWorkbenchPart part) {
		if (editor == part) {
			editor = null;
			setInput(null);
		}
	}
	public void partBroughtToTop(IWorkbenchPart part) {
	}
	public void partDeactivated(IWorkbenchPart part) {
	}
	public void partOpened(IWorkbenchPart part) {
	}
	public IFsmlEditor getEditor() {
		return editor;
	}
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		viewer.addSelectionChangedListener(listener);
	}
	public ISelection getSelection() {
		return viewer.getSelection();
	}
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		viewer.removeSelectionChangedListener(listener);
	}
	public void setSelection(ISelection selection) {
		viewer.setSelection(selection);
	}
}
