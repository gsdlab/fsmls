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

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.RA;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationResult;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 * Generic implementation of the reconcile action.
 */
public class ModelCodeReconcileAction implements IObjectActionDelegate {
	protected ClassSyncItem classSyncItem;
	protected IAction action;
	protected IFsmlEditor editor;
	ModelCodeSynchronizationView syncView;
	protected IProject project;
	protected Model assertedModel;
	protected Model implementationModel;
	protected Model lastReconciledModel;
	protected HashMap<String, EObject> fsmlId2assertedModelObject;
	protected HashMap<String, EObject> fsmlId2implementationModelObject;
	protected HashMap<String, EObject> fsmlId2lastReconciledModelObject;
	protected EditingDomain editingDomain;
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		if (targetPart instanceof ModelCodeSynchronizationView) {
			this.syncView = (ModelCodeSynchronizationView) targetPart;
			this.editor = ((ModelCodeSynchronizationView) targetPart).getEditor();
		}
		else {
			this.syncView = null;
			this.editor = null;
		}
	}
	public void run(IAction action) {
		if (editor == null || classSyncItem == null)
			return;
		try {
			fsmlId2assertedModelObject = new HashMap<String, EObject>();
			fsmlId2implementationModelObject = new HashMap<String, EObject>();
			fsmlId2lastReconciledModelObject = new HashMap<String, EObject>();
			// stats
			Stats.INSTANCE.printMessage("Reconciliation results and statistics for " + classSyncItem.toString());
			Stats.INSTANCE.reset();
			
			// validate the model if forward
			// TODO: need to write custom validation that'll take into account states & decisions
			/*if (classSyncItem.isDecisionEnforce()) {
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(classSyncItem.getModel());
				handleDiagnostic(diagnostic);
				if (diagnostic.getSeverity() != Diagnostic.OK)
					return;
			}*/
			IRunnableWithProgress op = createReconcileRunnable();
			new ProgressMonitorDialog(((IEditorPart) editor).getSite().getShell()).run(true, true, op);
		} catch (InvocationTargetException e) {
			// handle exception
			e.printStackTrace();
			return;
		} catch (InterruptedException e) {
			// handle cancelation
			e.printStackTrace();
			return;
		} 
		editor.getViewer().refresh();
		syncView.refresh();
		// stats
		Stats.INSTANCE.printMessage("\n" + Stats.INSTANCE.toString());
	}
	/**
	 * construct IRunnableWithProgress that will do the actual reconciliation
	 */
	protected IRunnableWithProgress createReconcileRunnable() {
		return new ReconcileRunnable();
	}
	
	protected void handleDiagnostic(Diagnostic diagnostic) {
	    int severity = diagnostic.getSeverity();
	    String title = null;
	    String message = null;

	    if (severity == Diagnostic.ERROR || severity == Diagnostic.WARNING) {
	      title = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_title");
	      message = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_message");
	    }
	    else {
	      title = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationResults_title");
	      message = EMFEditUIPlugin.INSTANCE.getString(severity == Diagnostic.OK ? "_UI_ValidationOK_message" : "_UI_ValidationResults_message");
	    }
	    ErrorDialog.openError(((IEditorPart) editor).getSite().getShell(), 
	    		title, message, BasicDiagnostic.toIStatus(diagnostic));
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object object = ((IStructuredSelection) selection).getFirstElement();
			if (object instanceof ClassSyncItem) {
				classSyncItem = (ClassSyncItem) object;
				action.setEnabled(
						classSyncItem != null && 
						editor != null && 
						checkNoUndecidedConflicts(classSyncItem)
					);
			}	
			else
				action.setEnabled(false);
		}
	}
	private static boolean checkNoUndecidedConflicts(ClassSyncItem classSyncItem) {
		for (Object aux : classSyncItem.getSyncItems()) {
			if (aux instanceof StructuralFeatureSyncItem) {
				StructuralFeatureSyncItem attributeSyncItem = (StructuralFeatureSyncItem) aux;
				if (attributeSyncItem.getSynchronizationState().isConflict()) {
					int decision = attributeSyncItem.getReconciliationDecision().getValue(); 
					if (decision != ReconciliationDecision.OVERRIDE_AND_ENFORCE && decision != ReconciliationDecision.OVERRIDE_AND_UPDATE)
						// unresolved conflict
						return false;
					break;
				}
			}
			else if (aux instanceof ClassSyncItem) {
				ClassSyncItem subfeatureSyncItem = (ClassSyncItem) aux;
				if (!checkNoUndecidedConflicts(subfeatureSyncItem))
					return false;
			}
		}
		return true;
	}
	/**
	 * A generic reconcile runnable. This propagates changes according to the reconciliation 
	 * decisions.
	 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
	 */
	public class ReconcileRunnable implements IRunnableWithProgress {
		IProgressMonitor progressMonitor;
		/**
		 * Assuming that reconciliation decisions have been made for all non-consistent sync items
		 */
		public void run(IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException {
			this.progressMonitor = progressMonitor;
			
			// we do not clear the cache made during the synchronization because we use the same  
			// annotation interpreters and contexts.
			
			// navigate to the SynchronizationResult
			EObject aux = classSyncItem.eContainer();
			while (!(aux instanceof SynchronizationResult) && aux != null)
				aux = aux.eContainer();
			if (aux == null) {
				// should never happen!
				Stats.INSTANCE.logBug("BUG: ConceptSynchItem does not belong to any SynchronizationResult!");
				return;
			}
			SynchronizationResult synchronizationResult = (SynchronizationResult) aux;
			assertedModel = synchronizationResult.getAssertedModel();
			implementationModel = synchronizationResult.getImplementationModel();
			lastReconciledModel = ((ModelContainer) assertedModel.eContainer()).getLastReconciledModel();
			
			FSMLEcoreUtil.createFsmlId2EObjectMap(assertedModel, fsmlId2assertedModelObject);
			FSMLEcoreUtil.createFsmlId2EObjectMap(implementationModel, fsmlId2implementationModelObject);
			FSMLEcoreUtil.createFsmlId2EObjectMap(lastReconciledModel, fsmlId2lastReconciledModelObject);
			
			editingDomain = editor.getEditingDomain();
			
			try {
				// recursively traverse the sync items tree in a depth-first manner
				reconcileObject(classSyncItem);
				// traverse the sync items tree and update the last reconcile model for each reconciled sync item
				updateLastReconciledModel(classSyncItem);
			} catch (FSMLMappingException e) {
				e.printStackTrace();
			}
			
			// notify registered mapping interpreters that the process ended
			Queries.INSTANCE.terminate(progressMonitor);
		}
		
		protected void reconcileObject(ClassSyncItem classSyncItem) throws FSMLMappingException {
			EObject modelObject = classSyncItem.getModel();
			EObject codeObject = classSyncItem.getCode();
			// at least one object should exist
			if (modelObject != null)
				Stats.INSTANCE.printMessage("Model: " + modelObject);
			else if (codeObject != null)
				Stats.INSTANCE.printMessage("Code: " + codeObject);
			else {
				classSyncItem.setResult("Both model and code objects are null!");
				return;
			}
			// determine action for the object
			RA objectAction = classSyncItem.getReconciliationAction();
			
			switch (objectAction) {
			case MODEL_ADD:
				modelObject = EcoreUtil.create(codeObject.eClass());
				classSyncItem.setModel(modelObject);
				EStructuralFeature containingFeature = codeObject.eContainingFeature();
				EObject parent = ((ClassSyncItem)classSyncItem.eContainer()).getModel();
				if (containingFeature.isMany())
					((EList)parent.eGet(containingFeature)).add(modelObject);
				else
					parent.eSet(containingFeature, modelObject);
				break;
			case MODEL_REMOVE:
				EcoreUtil.remove(modelObject);
				classSyncItem.setModel(null);
				// TODO: what about children sync states? should the model ref be nullified too?
				break;
			case CODE_ADD:
			case CODE_REMOVE:
				Queries.INSTANCE.forwardFeatureRepresentedAsClass(classSyncItem, progressMonitor);
				break;
			}
			classSyncItem.setResult(objectAction.name());
			
			// process the structural features
			for (SyncItem syncItem : classSyncItem.getSyncItems()) {
				// feature or object?
				if (syncItem instanceof StructuralFeatureSyncItem) { 					
					StructuralFeatureSyncItem structuralFeatureSyncItem = (StructuralFeatureSyncItem) syncItem;
					Stats.INSTANCE.printMessage(structuralFeatureSyncItem.getStructuralFeature().toString());
					
					EStructuralFeature feature = structuralFeatureSyncItem.getStructuralFeature();
					RA featureAction = syncItem.getReconciliationAction();
					switch (featureAction) {
					case MODEL_ADD:
					case MODEL_CHANGE:
					case MODEL_REMOVE:
						if (!feature.isDerived()) {
							// need to treat references in a different way
							if (feature instanceof EReference) {
								if (codeObject != null) {
									EObject codeAux = (EObject) codeObject.eGet(feature);
									EObject modelAux = fsmlId2assertedModelObject.get(FSMLEcoreUtil.getFSMLId((EObject) codeAux, null));
									modelObject.eSet(feature, modelAux);
								}
								else
									modelObject.eUnset(feature);
							}
							else {
								// regular attribute
								if (codeObject != null) {
									if (feature.isMany()) {
										EList modelValues = (EList) modelObject.eGet(feature);
										modelValues.clear();
										EList codeValues = (EList) codeObject.eGet(feature);
										for (Object value : codeValues)
											modelValues.add(value);
									}
									else
										modelObject.eSet(feature, codeObject.eGet(feature));
								}
								else {
									if (feature.getEType().getName().equals("EBoolean"))
										modelObject.eSet(feature, false);
									else
										modelObject.eUnset(feature);
								}
							}
						}
						structuralFeatureSyncItem.setReconciliationDecision(ReconciliationDecision.IGNORE_LITERAL);
						structuralFeatureSyncItem.setSynchronizationState(SynchronizationState.UNCHANGED_LITERAL);
						break;
					case CODE_ADD:
					case CODE_CHANGE:
					case CODE_REMOVE:
						if (feature instanceof EAttribute)
							Queries.INSTANCE.forwardFeatureRepresentedAsAttribute(structuralFeatureSyncItem, progressMonitor);
						// ignore references, because they only correspond to model queries.
						// containment references are processed indirectly by processing their values 
						// see ClassSyncItem case below.
						break;
					}
					structuralFeatureSyncItem.setResult(featureAction.toString());
				}
				else if (syncItem instanceof ClassSyncItem){
					ClassSyncItem subfeatureSyncItem = (ClassSyncItem) syncItem;
					reconcileObject(subfeatureSyncItem);
				}
			}
			// reset state and decision for every object in the hierarchy
			classSyncItem.setSynchronizationState(SynchronizationState.UNCHANGED_LITERAL);
			classSyncItem.setReconciliationDecision(ReconciliationDecision.IGNORE_LITERAL);
		}
		
		protected void updateLastReconciledModel(ClassSyncItem classSyncItem) {
			EObject modelObject = classSyncItem.getModel();
			EObject codeObject = classSyncItem.getCode();
			String fsmlId = null;
			EClass eClass = null;
			EReference eContainingFeature = null;
			EObject lrmContainer = null;
			
			// at least one object should exist
			if (modelObject != null) {
				fsmlId = FSMLEcoreUtil.getFSMLId(modelObject, null);
				eClass = modelObject.eClass();
				eContainingFeature = (EReference) modelObject.eContainingFeature();
				if (modelObject.eContainer() instanceof Model)
					lrmContainer = lastReconciledModel;
				else
					lrmContainer = fsmlId2lastReconciledModelObject.get(FSMLEcoreUtil.getFSMLId(modelObject.eContainer(), null));
			}
			else if (codeObject != null) {
				fsmlId = FSMLEcoreUtil.getFSMLId(codeObject, null);
				eClass = codeObject.eClass();
				eContainingFeature = (EReference) codeObject.eContainingFeature();
			}
			else
				return;
			
			String result = classSyncItem.getResult();
			
			EObject lrmObject = fsmlId2lastReconciledModelObject.get(fsmlId);
			if (modelObject instanceof Model)
				lrmObject = lastReconciledModel;
			
			Command command = null;
			if (RA.CODE_ADD.toString().equals(result) || RA.MODEL_ADD.toString().equals(result)) {
				if (lrmObject == null && lrmContainer != null) {
					lrmObject = EcoreUtil.create(eClass);
					fsmlId2lastReconciledModelObject.put(fsmlId, lrmObject);
					if (eContainingFeature.isMany())
						command = new AddCommand(editingDomain, lrmContainer, eContainingFeature, lrmObject);
					else
						command = new SetCommand(editingDomain, lrmContainer, eContainingFeature, lrmObject);
				}
				// already existed - process subfeatures
			}
			else if (RA.CODE_CHANGE.toString().equals(result) || RA.MODEL_CHANGE.toString().equals(result)) {
				// lrmObject must existed. Create if missing 
				if (lrmObject == null && lrmContainer != null) {
					lrmObject = EcoreUtil.create(eClass);
					fsmlId2lastReconciledModelObject.put(fsmlId, lrmObject);
					if (eContainingFeature.isMany())
						command = new AddCommand(editingDomain, lrmContainer, eContainingFeature, lrmObject);
					else
						command = new SetCommand(editingDomain, lrmContainer, eContainingFeature, lrmObject);
				}
				// process subfeatures
			} 
			else if (RA.CODE_REMOVE.toString().equals(result) || RA.MODEL_REMOVE.toString().equals(result)) {
				if (lrmObject != null && lrmContainer != null)
					// need to remove it
					command = new RemoveCommand(editingDomain, lrmContainer, eContainingFeature, lrmObject);
				// can safely return because the subfeatures were just removed together with lrmObject
				return;
			}
			else if (RA.STOP.toString().equals(result))
				return;
			else
				// RA.PROCEED.equals(result) 
				;
				
			if (command != null) 
				editingDomain.getCommandStack().execute(command);
			
			// process subfeatures
			for (SyncItem syncItem : classSyncItem.getSyncItems()) {
				// feature or object?
				if (syncItem instanceof StructuralFeatureSyncItem) { 
					if (lrmObject == null)
						continue;
					StructuralFeatureSyncItem structuralFeatureSyncItem = (StructuralFeatureSyncItem) syncItem;
					EStructuralFeature feature = structuralFeatureSyncItem.getStructuralFeature();
					
					result = structuralFeatureSyncItem.getResult();
					
					if (RA.CODE_ADD.toString().equals(result) || RA.CODE_CHANGE.toString().equals(result)) {
						// so the new values comes from model
						if (feature instanceof EAttribute) {
							if (feature.isMany()) {
								EList modelValues = (EList) modelObject.eGet(feature);
								EList lrmValues = (EList) lrmObject.eGet(feature);
								lrmValues.clear();
								for (Object value : modelValues) {
									lrmValues.add(value);
								}
							}
							else
								lrmObject.eSet(feature, modelObject.eGet(feature));
						}
						else {
							// feature is an EReference
							// target EObjects in lrm might not have been created yet!!! TODO:
							EObject modelTarget = (EObject) modelObject.eGet(feature);
							if (modelTarget != null) {
								// try to find a corresponding target
								EObject lrmTarget = fsmlId2lastReconciledModelObject.get(modelTarget);
								lrmObject.eSet(feature, lrmTarget);
							}
						}
					}
					else if (RA.MODEL_ADD.toString().equals(result) || RA.MODEL_CHANGE.toString().equals(result)) { 
						// so the new values comes from code
						if (feature instanceof EAttribute) {
							if (feature.isMany()) {
								EList modelValues = (EList) modelObject.eGet(feature);
								EList lrmValues = (EList) lrmObject.eGet(feature);
								lrmValues.clear();
								for (Object value : modelValues) {
									lrmValues.add(value);
								}
							}
							else 
								lrmObject.eSet(feature, modelObject.eGet(feature));
						}
						else {
							// feature is an EReference
							// target EObjects in lrm might not have been created yet!!! TODO:
							EObject codeTarget = (EObject) codeObject.eGet(feature);
							if (codeTarget != null) {
								// try to find a corresponding target
								EObject lrmTarget = fsmlId2lastReconciledModelObject.get(codeTarget);
								lrmObject.eSet(feature, lrmTarget);
							}						
						}
					} 
					// Michal: the problem is with the default values for booleans and integers. Maybe we should always
					// use object types!!! Null would represent undecided.
				}
				else if (syncItem instanceof ClassSyncItem){
					ClassSyncItem subfeatureSyncItem = (ClassSyncItem) syncItem;
					updateLastReconciledModel(subfeatureSyncItem);
				}
			}
		}
	}
}
