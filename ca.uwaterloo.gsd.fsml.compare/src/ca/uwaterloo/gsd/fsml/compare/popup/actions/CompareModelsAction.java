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
package ca.uwaterloo.gsd.fsml.compare.popup.actions;

import java.util.HashMap;

import org.eclipse.compare.internal.Utilities;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.impl.ModelContainerImpl;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.provider.SyncEditPlugin;
import ca.uwaterloo.gsd.fsml.ui.ModelCodeSynchronizationView;
import ca.uwaterloo.gsd.fsml.ui.ModelCodeSynchronizeAction;

public class CompareModelsAction extends
		ModelCodeSynchronizeAction implements IObjectActionDelegate {

	private IResource fLeftResource;
	private IResource fRightResource;
	private ISelection fSelection;
	private ResourceSet resourceSet;
	private IWorkbenchPage page;

	@Override
	public void run(IAction action) {
		IResource[] selection = Utilities.getResources((ISelection) fSelection);

		fLeftResource = selection[0];
		fRightResource = selection[1];

		resourceSet = new ResourceSetImpl();

		URI left = URI.createPlatformResourceURI(fLeftResource.getFullPath()
				.toString(), true);
		URI right = URI.createPlatformResourceURI(fRightResource.getFullPath()
				.toString(), true);
		
		
		
		Shell shell = new Shell();
		boolean direction = MessageDialog.openConfirm(
				shell,
				"Compare Models Plug-in",
				"Left is "+left.toString()+" \nand\nRight is "+right.toString()+".\n\nPress OK to confirm or press Cancel to reverse the two files");
		
		if (!direction) {
			URI temp;
			temp = left;
			left = right ;
			right = temp;
		}
		try {
			assertedModel = ((ModelContainerImpl) resourceSet.getResource(right,
					true).getContents().get(0)).getAssertedModel();
	
	
			lastReconciledModel = ((ModelContainerImpl) resourceSet.getResource(
					left, true).getContents().get(0)).getLastReconciledModel();
			implementationModel = ((ModelContainerImpl) resourceSet.getResource(
					left, true).getContents().get(0)).getAssertedModel();

		} catch (Exception e) {
				MessageDialog.openError(
				shell,
				"Compare Models Plug-in",
				"One or more Invalid FSML Models Found.");
			return;
		}

			
		
		fsmlId2assertedModelFeature = new HashMap<String, EObject>();
		fsmlId2implementationModelFeature = new HashMap<String, EObject>();
		fsmlId2lastReconciledModelFeature = new HashMap<String, EObject>();
		// traverse each model and put elements to appropriate hash map

		FSMLEcoreUtil.createFsmlId2EObjectMap(assertedModel,
				fsmlId2assertedModelFeature);
		FSMLEcoreUtil.createFsmlId2EObjectMap(implementationModel,
				fsmlId2implementationModelFeature);
		FSMLEcoreUtil.createFsmlId2EObjectMap(lastReconciledModel,
				fsmlId2lastReconciledModelFeature);

		synchronizationResult = SyncFactory.eINSTANCE
				.createSynchronizationResult();
		synchronizationResult.setAssertedModel(assertedModel);
		synchronizationResult.setImplementationModel(implementationModel);

		ClassSyncItem classSyncItem = SyncFactory.eINSTANCE
				.createClassSyncItem();
		classSyncItem.setModel(assertedModel);
		classSyncItem.setCode(implementationModel);
		synchronizationResult.getClassSyncItems().add(classSyncItem);

		synchronizeInstanceAndSubfeatures(assertedModel, implementationModel,
				lastReconciledModel, classSyncItem);

		// run the operation

		// compute default decisions for states
		computeDefaultDecisions(synchronizationResult);
		// and finally store the result of the synchronization
		SyncEditPlugin.INSTANCE.putSynchronizationResult(assertedModel,
				synchronizationResult);

		// TODO: this is a hack! how to create adapters for code concepts in ClassSyncItemItemProvider?
		// adapt all elements in the synchronization result from code
		/*	for (Iterator i = synchronizationResult.getClassSyncItems().iterator(); i.hasNext(); )
				createAdapter((ClassSyncItem) i.next());
		 */
		// show the results in the model-code synchronization view
		try {
			IViewPart view = page
					.showView("ca.uwaterloo.gsd.fsml.ModelCodeSynchronizationView");
			if (view instanceof ModelCodeSynchronizationView) {
				ModelCodeSynchronizationView syncView = ((ModelCodeSynchronizationView) view);
				// this will hook up the view with the editor; the view will grab the synchronization result.

				syncView.setSynchronizationResult(synchronizationResult);
				syncView.refresh();
			}
		} catch (PartInitException e1) {
			e1.printStackTrace();
		}

	}
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		fSelection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		page = targetPart.getSite().getPage();
	}

}
