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


import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.fsml.FsmlFactory;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.fsml.provider.FsmlEditPlugin;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 * 
 * This is a standard FSML analysis wizard.
 * Clients should call super(...) constructor and implement createInitialObject() method.
 * Additionally, clients may override validateProject(IProject) method.
 */
public abstract class FsmlAnalysisWizard extends Wizard implements INewWizard {
	/**
	 * This constructor configures the wizard with necessary metainformation
	 */
	public FsmlAnalysisWizard(EClass fsmlModelRoot, String requiredExt, String wizardLabel, String wizardDescription, Object image) {
		this.fsmlModelRoot = fsmlModelRoot;
		this.requiredExt = requiredExt;
		this.wizardLabel = wizardLabel;
		this.wizardDescription = wizardDescription;
		this.wizardImage = image;
	}
	/**
	 * This caches the class of model root
	 */
	protected EClass fsmlModelRoot;
	
	protected String requiredExt;
	
	protected String wizardLabel;
	
	protected String wizardDescription;
	
	protected Object wizardImage;

	/**
	 * This is the file creation page.
	 */
	protected WpiModelWizardNewFileCreationPage newFileCreationPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 */
	protected IWorkbench workbench;
	/**
	 * This just records the information.
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(wizardLabel);
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(wizardImage));
	}
	/**
	 * The clients can override this method to execute their custom analysis instead of the generic analysis.
	 * Clients must not set Model.lrm reference. 
	 */
	protected Model createInitialModel(IProgressMonitor progressMonitor) {
		EObject rootObject = EcoreUtil.create(fsmlModelRoot); 
		Queries.INSTANCE.reset();
		
		registerCustomInterpreters();
		
		return Queries.INSTANCE.performAnalysis((Model) rootObject, progressMonitor);
	}
	/**
	 * This is the place where custom interpreters should be registered by calling
	 * Queries.registerCustomInterpreter(FSMLAnnotationInterpreter) method.
	 * This method is called after resetting the Queries and just before the start of 
	 * Queries.performAnalysis(Model, IProgressMonitor)
	 */
	protected abstract void registerCustomInterpreters();
	
	/**
	 * Do the work after everything is specified.
	 */
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
					protected void execute(IProgressMonitor progressMonitor) {
						try {
							// Create a resource set
							//
							ResourceSet resourceSet = new ResourceSetImpl();

							// Get the URI of the model file.
							//
							URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

							// Create a resource for this file.
							//
							Resource resource = resourceSet.createResource(fileURI);

							// Add the initial model object to the contents.
							//
							ModelContainer modelContainer = FsmlFactory.eINSTANCE.createModelContainer();
							Model assertedModel = createInitialModel(progressMonitor);
							if (assertedModel != null) {
								modelContainer.setAssertedModel(assertedModel);
								modelContainer.setLastReconciledModel((Model) EcoreUtil.copy(assertedModel));
								resource.getContents().add(modelContainer);
							}
							// 
							// Save the contents of the resource to the file system.
							//
							Map options = new HashMap();
							options.put(XMLResource.OPTION_ENCODING, "ASCII");
							resource.save(options);
						}
						catch (Exception exception) {
							FsmlEditPlugin.INSTANCE.log(exception);
						}
						finally {
							progressMonitor.done();
						}
					}
				};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
						 }
					 });
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor
					(new FileEditorInput(modelFile),
					 workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), "Unable to open editor.", exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			FsmlEditPlugin.INSTANCE.log(exception);
			return false;
		}
	}
	/**
	 * @param projectPath
	 * @return null if project is ok, error message otherwise
	 */
	public String validateProject(IProject project) {
		return null;
	}
	
	/**
	 * This is the first page of the wizard.
	 */
	public class WpiModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Pass in the selection.
		 */
		public WpiModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 */
		protected boolean validatePage() {
			if (super.validatePage()) {
				// Make sure the file has the required extension
				//			
				String enteredExt = new Path(getFileName()).getFileExtension();
				if (enteredExt == null || !enteredExt.equals(requiredExt)) {
					setErrorMessage(FsmlEditPlugin.INSTANCE.getString("_WARN_FilenameExtension", new Object [] { requiredExt }));
					return false;
				}
			}
			// we are interested in a path to the project only
			IPath path = getContainerFullPath();
			if (path.segments().length > 1)
				path = path.removeLastSegments(path.segments().length - 1);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(path.toString());
			
			// call back
			String errorMessage = validateProject(project);
			
			if (errorMessage != null) {
				setErrorMessage(errorMessage);
				return false;
			}
			return true; 
		}
		public IFile getModelFile() {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
		}
	}
	/**
	 * The framework calls this to create the contents of the wizard.
	 * Default file name is the same as the project name
	 */
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new WpiModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(wizardLabel);
		newFileCreationPage.setDescription(wizardDescription);
		newFileCreationPage.setFileName("model." + requiredExt);
		addPage(newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			IResource selectedResource = null;
			
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}
			}
			else if (selectedElement instanceof IProject) {
				IProject project = (IProject) selectedElement;
				selectedResource = project;
			}

			if (selectedResource != null) {
				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = selectedResource.getProject().getName();
					String modelFilename = defaultModelBaseFilename + "." + requiredExt;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + "_" + i + "." + requiredExt;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
	}

	/**
	 * Get the file from the page.
	 */
	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}
}
