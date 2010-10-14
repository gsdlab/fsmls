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
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationResult;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;
import ca.uwaterloo.gsd.fsml.sync.provider.SyncEditPlugin;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class ModelCodeSynchronizeAction implements IEditorActionDelegate {
	/**
	 * This has to be set by the SynchronizeRunnable
	 */
	protected SynchronizationResult synchronizationResult;
	protected IAction action;
	protected IFsmlEditor editor;
	protected IProject project;
	protected Model assertedModel;
	protected Model lastReconciledModel;
	protected Model implementationModel;
	protected HashMap<String, EObject> fsmlId2assertedModelFeature;
	protected HashMap<String, EObject> fsmlId2implementationModelFeature;
	protected HashMap<String, EObject> fsmlId2lastReconciledModelFeature;
	/**
	 * This method has to perform comparison of the implementation model and asserted model.
	 * The result of the comparison has to be stored in synchronizationResult field.
	 * The clients may override this method to create custom synchronization runnable. 
	 * The clients may extend default synchronization runnable implementation: SynchronizeRunnable
	 * By default this method instantiates the generic SynchronizeRunnable.  
	 * @return
	 */
	protected IRunnableWithProgress createSynchronizeRunnable() {
		return new SynchronizeRunnable();
	}
	public void run(IAction action) {
		fsmlId2assertedModelFeature = new HashMap<String, EObject>();
		fsmlId2implementationModelFeature = new HashMap<String, EObject>();
		fsmlId2lastReconciledModelFeature = new HashMap<String, EObject>();
		// adapter factory used by SyncItemProviders
		SyncEditPlugin.INSTANCE.putAdapterFactory(assertedModel.eClass().getEPackage(), editor.getAdapterFactory());
		try {
			Markers.INSTANCE.removeMarkers();
			IRunnableWithProgress op = createSynchronizeRunnable();
			// run the operation
			new ProgressMonitorDialog(editor.getEditorSite().getShell()).run(true, true, op);
			// compute default decisions for states
			computeDefaultDecisions(synchronizationResult);
			// and finally store the result of the synchronization
			SyncEditPlugin.INSTANCE.putSynchronizationResult(assertedModel, synchronizationResult);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return;
		} catch (InterruptedException e) {
			Stats.INSTANCE.printMessage("Model Synchronization Interrupted");
			//e.printStackTrace();
			return;
		}
		// TODO: this is a hack! how to create adapters for code concepts in ClassSyncItemItemProvider?
		// adapt all elements in the synchronization result from code
		for (Iterator i = synchronizationResult.getClassSyncItems().iterator(); i.hasNext(); )
			createAdapter((ClassSyncItem) i.next());
		
		// show the results in the model-code synchronization view
		IWorkbenchPage page = editor.getSite().getPage();
		try {
			IViewPart view = page.showView(
					"ca.uwaterloo.gsd.fsml.ModelCodeSynchronizationView");
			if (view instanceof ModelCodeSynchronizationView) {
				ModelCodeSynchronizationView syncView = ((ModelCodeSynchronizationView) view);
				// this will hook up the view with the editor; the view will grab the synchronization result.
				page.activate(editor);
				syncView.setSynchronizationResult(synchronizationResult);
				syncView.refresh();
			}
		} catch (PartInitException e1) {
			e1.printStackTrace();
		}
		editor.getViewer().refresh();
	}
	protected void computeDefaultDecisions(SynchronizationResult result) {
		for (Object aux : result.getClassSyncItems()) {
			ClassSyncItem conceptSyncItem = (ClassSyncItem) aux;
			computeDefaultDecisions(conceptSyncItem);
		}
	}
	/**
	 * @param conceptSyncItem
	 * Takes default decisions for all undecided sync items.
	 * Assumes no unresolved conflicts.
	 */
	private void computeDefaultDecisions(ClassSyncItem conceptSyncItem) {
		// decide for the concept
		if (conceptSyncItem.getReconciliationDecision().isUnspecified())
			conceptSyncItem.setReconciliationDecision(defaultDecision(conceptSyncItem.getSynchronizationState()));
		// decide for sub features
		for (Object aux : conceptSyncItem.getSyncItems()) {
			if (aux instanceof StructuralFeatureSyncItem) {
				StructuralFeatureSyncItem attributeSyncItem = (StructuralFeatureSyncItem) aux;
				if (attributeSyncItem.getReconciliationDecision().isUnspecified())
					attributeSyncItem.setReconciliationDecision(defaultDecision(attributeSyncItem.getSynchronizationState()));
			}
			else if (aux instanceof ClassSyncItem) {
				ClassSyncItem subfeatureSyncItem = (ClassSyncItem) aux;
				computeDefaultDecisions(subfeatureSyncItem);
			}
		}
	}
	private ReconciliationDecision defaultDecision(SynchronizationState synchronizationState) {
		if (synchronizationState.isForward())
			return ReconciliationDecision.ENFORCE_LITERAL;
		else if (synchronizationState.isReverse())
			return ReconciliationDecision.UPDATE_LITERAL;
		else if (synchronizationState.isChanged())
			return ReconciliationDecision.ENFORCE_AND_UPDATE_LITERAL;
		else if (synchronizationState.isConflict())
			return ReconciliationDecision.UNSPECIFIED_LITERAL;
		
		return ReconciliationDecision.IGNORE_LITERAL;
	}
	protected void createAdapter(ClassSyncItem item) {
		EObject codeConcept = item.getCode();
		if (codeConcept != null) {
			editor.getAdapterFactory().adapt(codeConcept, IEditingDomainItemProvider.class);
			for (Iterator i = item.getSyncItems().iterator(); i.hasNext(); ) {
				Object aux = i.next();
				if (aux instanceof ClassSyncItem)
					createAdapter((ClassSyncItem) aux);
			}
		}
	}
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.action = action;
		
		if (this.editor != targetEditor) {
			if (targetEditor != null) {
				if (targetEditor instanceof IFsmlEditor) {
					editor = (IFsmlEditor) targetEditor;
					IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
					project = input.getFile().getProject();
					if (project != null) {
						Queries.INSTANCE.setProject(project);
						action.setEnabled(editor != null && assertedModel != null);
						Markers.INSTANCE.setProject(project);
						return;
					}
				}
			}
			this.editor = null;
			action.setEnabled(false);
	    }
	}
	/**
	 * Clients may override this method. Clients MUST set the assertedModel field.
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object object = ((IStructuredSelection) selection).getFirstElement();
			if (object instanceof Model)
				assertedModel = (Model) object;
			else
				assertedModel = null;
		}
		action.setEnabled(project != null && editor != null && assertedModel != null);
	}
	
	// synchronization utilities
	public void synchronizeInstanceAndSubfeatures(EObject model, EObject code, EObject lrm, ClassSyncItem classSyncItem) {
		if (code == null && model == null && lrm == null) {
			classSyncItem.setSynchronizationState(SynchronizationState.UNCHANGED_LITERAL);
			return;
		}
		
		boolean hasForward = false;
		boolean hasReverse = false;
		boolean hasConflict = false;
		boolean hasChanged = false;
		
		EList sFeatures = null;
		if (model != null)
			sFeatures = model.eClass().getEAllStructuralFeatures();
		else if (code != null)
			sFeatures = code.eClass().getEAllStructuralFeatures();
		else if (lrm != null)
			sFeatures = lrm.eClass().getEAllStructuralFeatures();
		
		// analyze subfeatures
		for (Iterator features = sFeatures.iterator(); features.hasNext(); ) {
			EStructuralFeature feature = (EStructuralFeature) features.next();
			// simply ignore volatile & transient features
			if (feature.isVolatile() || feature.isTransient())
				continue;
			
			SyncItem current = null;
			
			if (feature instanceof EReference && ((EReference) feature).isContainment()) {
				// so this is a subfeature
				// a subfeature
				if (feature.isMany()) {
					EList<EObject> assertedSubfeatures = model != null ? (EList) model.eGet(feature) : new BasicEList<EObject>(); 
					EList<EObject> implementationSubfeatures = code != null ? (EList) code.eGet(feature) : new BasicEList<EObject>();
					//EList lastReconciledSubfeatures = lrm != null ? (EList) lrm.eGet(feature) : new BasicEList();
					
					for (EObject assertedSubfeature : assertedSubfeatures) {
						String featureFsmlID = FSMLEcoreUtil.getFSMLId(assertedSubfeature, null);
						// find corresponding implementation and last reconciled features
						EObject implementationSubfeature = fsmlId2implementationModelFeature.get(featureFsmlID);
						EObject lastReconciledSubfeature = fsmlId2lastReconciledModelFeature.get(featureFsmlID);
						ClassSyncItem subfeatureSyncItem = createClassSyncItem(assertedSubfeature, implementationSubfeature, lastReconciledSubfeature);
						
						classSyncItem.getSyncItems().add(subfeatureSyncItem);
						
						SynchronizationState state = subfeatureSyncItem.getSynchronizationState();
						hasForward = hasForward || state.isForward();
						hasReverse = hasReverse || state.isReverse();
						hasConflict = hasConflict || state.isConflict();
						hasChanged = hasChanged || state.isChanged();
					}
					for (Object object : implementationSubfeatures) {
						EObject implementationSubfeature = (EObject) object;
						String featureFsmlID = FSMLEcoreUtil.getFSMLId(implementationSubfeature, null);
						// skip all features that have a corresponding asserted feature 
						
						EObject assertedSubfeature = fsmlId2assertedModelFeature.get(featureFsmlID);
						if (assertedSubfeature == null) {
							EObject lastReconciledSubfeature = fsmlId2lastReconciledModelFeature.get(featureFsmlID);
							ClassSyncItem subfeatureSyncItem = createClassSyncItem(assertedSubfeature, implementationSubfeature, lastReconciledSubfeature);
							
							classSyncItem.getSyncItems().add(subfeatureSyncItem);
							
							SynchronizationState state = subfeatureSyncItem.getSynchronizationState();
							hasForward = hasForward || state.isForward();
							hasReverse = hasReverse || state.isReverse();
							hasConflict = hasConflict || state.isConflict();
							hasChanged = hasChanged || state.isChanged();
						}
					}
					// do the same for lastReconciledSubfeatures
					continue;
				}
				EObject assertedSubfeature = model != null ? (EObject) model.eGet(feature) : null; 
				EObject implementationSubfeature = code != null ? (EObject) code.eGet(feature) : null;
				EObject lastReconciledSubfeature = lrm != null ? (EObject) lrm.eGet(feature) : null;
				current = createClassSyncItem(assertedSubfeature, implementationSubfeature, lastReconciledSubfeature);
			}
			else 
				// normal attribute or reference
				current = createStructuralFeatureSyncItem(model, code, lrm, feature);
			
			if (current != null) {
				// store concept or attribute sync item
				classSyncItem.getSyncItems().add(current);
				
				SynchronizationState state = current.getSynchronizationState();
				hasForward = hasForward || state.isForward();
				hasReverse = hasReverse || state.isReverse();
				hasConflict = hasConflict || state.isConflict();
				hasChanged = hasChanged || state.isChanged();

				current = null;
			}
		}
		SynchronizationState classInstanceState = SynchronizationState.getClassInstanceSynchronizationState(model, code, lrm, hasConflict, hasForward, hasReverse, hasChanged);
		classSyncItem.setSynchronizationState(classInstanceState);
	}
	public ClassSyncItem createClassSyncItem(EObject modelObject, EObject codeObject, EObject archiveObject) {
		ClassSyncItem classSyncItem = SyncFactory.eINSTANCE.createClassSyncItem();	
		// new sync item
		classSyncItem.setModel(modelObject);
		classSyncItem.setCode(codeObject);
		synchronizeInstanceAndSubfeatures(modelObject, codeObject, archiveObject, classSyncItem);
		return classSyncItem;

	}
	/**
	 * @param model may be null
	 * @param code may be null
	 * @param lrm may be null
	 * @param feature
	 * @return attribute sync item with appropriate synchronization state
	 */
	public StructuralFeatureSyncItem createStructuralFeatureSyncItem(EObject model, EObject code, EObject lrm, EStructuralFeature feature) {
		boolean key = feature.getEAnnotation("key") != null;
		boolean mandatory = feature.getLowerBound() == 1 && feature.getUpperBound() == 1;
		boolean optional = feature.getLowerBound() == 0 && feature.getUpperBound() == 1;
		
		/*if (!mandatory && !optional)
			Stats.INSTANCE.logError("(!mandatory && !optional) for structural feature: " + feature.getName());
		if (key && optional)
			Stats.INSTANCE.logError("(key && optional) for structural feature: " + feature.getName());*/
		
		// new attribute sync item
		StructuralFeatureSyncItem attributeSyncItem = SyncFactory.eINSTANCE.createStructuralFeatureSyncItem();
		attributeSyncItem.setStructuralFeature(feature);
		
		Object modelValue = null;
		Object codeValue = null;
		Object lrmValue = null;
		if (feature instanceof EReference && !feature.isMany()) {
			// for references use keys
			modelValue = model != null ? FSMLEcoreUtil.getFSMLId((EObject) model.eGet(feature), null) : null;
			codeValue = code != null ? FSMLEcoreUtil.getFSMLId((EObject) code.eGet(feature), null) : null;
			lrmValue = lrm != null ? FSMLEcoreUtil.getFSMLId((EObject) lrm.eGet(feature), null) : null;
		}
		else if (feature instanceof EReference && feature.isMany()) {
			//Stats.INSTANCE.logMessage("Calculating keys for multi-valued references not supported yet.");
			return null;
		}
		else {
			if (feature.getEType().getName().equals("EBoolean")) {
				boolean modelValueBoolean =  (model != null ? (Boolean) model.eGet(feature) : false); 
				modelValue = modelValueBoolean ? modelValueBoolean : null;
				boolean codeValueBoolean = code != null ? (Boolean) code.eGet(feature) : false; 
				codeValue = codeValueBoolean ? codeValueBoolean : null;
				boolean archiveValueBoolean = lrm != null ? (Boolean) lrm.eGet(feature) : false;
				lrmValue = archiveValueBoolean ? archiveValueBoolean : null;
			}
			else {
				modelValue = model != null ? model.eGet(feature) : null;
				codeValue = code != null ? code.eGet(feature) : null;
				lrmValue = lrm != null ? lrm.eGet(feature) : null;
			}
			
		}
		SynchronizationState featureState = SynchronizationState.getFeatureSynchronizationState(modelValue, codeValue, lrmValue);
		attributeSyncItem.setSynchronizationState(featureState);
		
		return attributeSyncItem;
	}
	protected class SynchronizeRunnable implements IRunnableWithProgress {
		public SynchronizeRunnable() {
		}
		/**
		 * This method can be overridden by clients to provide custom analysis.
		 * By default, the method executes generic Queries.performAnalysis(). 
		 * @param progressMonitor
		 * @return implementation model
		 */
		protected final Model performAnalysis(IProgressMonitor progressMonitor) {
			Queries.INSTANCE.reset();
			
			registerCustomInterpreters();
			
			Model model = createInitialModel();
			
			return Queries.INSTANCE.performAnalysis(model, progressMonitor);
		}
		protected Model createInitialModel() {
			return (Model) EcoreUtil.create(assertedModel.eClass());
		}
		/**
		 * This is the place where custom interpreters should be registered by calling
		 * Queries.registerCustomInterpreter(FSMLAnnotationInterpreter) method.
		 * This method is called after resetting the Queries and just before the start of 
		 * Queries.performAnalysis(Model, IProgressMonitor)
		 */
		protected void registerCustomInterpreters() {
			
		}
		
		public void run(IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException {
			lastReconciledModel = ((ModelContainer)assertedModel.eContainer()).getLastReconciledModel();
			implementationModel = performAnalysis(progressMonitor);
			// traverse each model and put elements to appropriate hash map
			
			FSMLEcoreUtil.createFsmlId2EObjectMap(assertedModel, fsmlId2assertedModelFeature);
			FSMLEcoreUtil.createFsmlId2EObjectMap(implementationModel, fsmlId2implementationModelFeature);
			FSMLEcoreUtil.createFsmlId2EObjectMap(lastReconciledModel, fsmlId2lastReconciledModelFeature);
			
			synchronizationResult = SyncFactory.eINSTANCE.createSynchronizationResult();
			synchronizationResult.setAssertedModel(assertedModel);
			synchronizationResult.setImplementationModel(implementationModel);
			
			ClassSyncItem classSyncItem = SyncFactory.eINSTANCE.createClassSyncItem();
			classSyncItem.setModel(assertedModel);
			classSyncItem.setCode(implementationModel);
			synchronizationResult.getClassSyncItems().add(classSyncItem);
			
			synchronizeInstanceAndSubfeatures(assertedModel, implementationModel, lastReconciledModel, classSyncItem);
		}
	}
}
