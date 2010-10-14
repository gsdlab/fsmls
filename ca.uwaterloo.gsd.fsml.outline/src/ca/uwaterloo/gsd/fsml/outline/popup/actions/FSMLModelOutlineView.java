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
package ca.uwaterloo.gsd.fsml.outline.popup.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.internal.corext.dom.NodeFinder;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ITextEditor;

import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMarkers;

public class FSMLModelOutlineView extends ViewPart implements
		ISelectionListener, IEditorActionDelegate, ISelectionChangedListener,
		IDocumentListener {

	public final static String[] supportedProjectExtensions = new String[] {
			".applet", ".struts", ".wpi" };
	
	private IJavaElement cu;
	private HashMap<String, EObject> fsmlId2ModelEObject;
	private TreeViewer viewer;
	private ITextEditor activeEditor;
	private Model assertedModel;
	private IFile fsmlModelFile;

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		ISelectionService service = site.getWorkbenchWindow()
				.getSelectionService();
		service.addPostSelectionListener(this);
		IWorkbenchPage activePage = site.getWorkbenchWindow().getActivePage();
		if (activePage!=null){
			IEditorPart activeEditor = activePage.getActiveEditor();
			if (activeEditor instanceof ITextEditor){
			this.activeEditor = (ITextEditor)activeEditor;
			}
		}
		
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		List<AdapterFactoryImpl> factories = new Vector<AdapterFactoryImpl>();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				factories);
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory));
		viewer
				.setLabelProvider(new AdapterFactoryLabelProvider(
						adapterFactory));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (viewer.getControl().isFocusControl()) {
					TreeItem[] selection = viewer.getTree().getSelection();
					EObject selectedEObject = (EObject) selection[0].getData();
					List<IMarker> markers = Markers.INSTANCE
							.getMarkers(FSMLEcoreUtil.getFSMLId(
									selectedEObject, null));
					if (markers.size() > 0) {
						try {
							IDE.openEditor(getSite().getPage(), markers.get(0), OpenStrategy.activateOnOpen());
						} catch (PartInitException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		if (activeEditor!=null){
			linkEditorWithOutlineView(activeEditor);
		}
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart sourceEditor) {
		if (sourceEditor instanceof ITextEditor) {
			this.activeEditor = (ITextEditor) sourceEditor;
		}
	}

	@Override
	public void run(IAction action) {
		if (activeEditor != null) {
			try {
				activeEditor.getSite().getPage().showView(
						"ca.uwaterloo.gsd.fsml.outline.FSMLModelOutlineView");
			} catch (PartInitException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (!(selection instanceof ITextSelection) || !(part instanceof CompilationUnitEditor)) {
			return;
		}
		IEditorInput editorInput = ((CompilationUnitEditor)part).getEditorInput();
		IJavaElement currentEditorCU=null;
		if (editorInput != null)
			currentEditorCU = JavaUI.getEditorInputJavaElement(editorInput);

		if (cu == null || !currentEditorCU.equals(cu)) {
			boolean result = linkEditorWithOutlineView((ITextEditor) part);
			if (!result){
				return;
			}

		}
		ITextSelection textSelection = (ITextSelection) selection;
		NodeFinder finder = new NodeFinder(textSelection.getOffset(), 0);

		// compute actual code transformation proposals
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource((ITypeRoot) cu);
		parser.setStatementsRecovery(true);
		parser.setResolveBindings(true);
		parser.createAST(null).accept(finder);

		ASTNode coveringNode = finder.getCoveringNode();

		Vector<IMarker> markers = JavaMarkers.getMarkersCoveredByNode(coveringNode);
		IMarker targetMarker = null;
		int targetMarkerRange = 0;
		int markerStartPos = 0;
		int markerEndPos = 0;
		for (IMarker marker : markers) {
			try {
				markerStartPos = ((Integer) marker
						.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START))
						.intValue();
				markerEndPos = ((Integer) marker
						.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END))
						.intValue();
				if (targetMarker == null) {
					targetMarker = marker;
					targetMarkerRange = markerEndPos - markerStartPos;
				} else if (markerEndPos - markerStartPos < targetMarkerRange) {
					targetMarkerRange = markerEndPos - markerStartPos;
					targetMarker = marker;
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		if (targetMarker != null) {
			EObject eObject;
			try {

				eObject = fsmlId2ModelEObject.get(targetMarker
						.getAttribute(MarkerDescriptor.ATTRIBUTE_ID));
				if (eObject != null) {
					eObject = assertedModel.eResource()
							.getResourceSet().getEObject(
									EcoreUtil.getURI(eObject), true);

					viewer.setSelection(new StructuredSelection(eObject), true);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}

		}

	}

	private boolean linkEditorWithOutlineView(ITextEditor sourceEditor) {
		activeEditor = sourceEditor;
		IFile editorFile=null;
		if (sourceEditor.getEditorInput() instanceof FileEditorInput) {
			FileEditorInput editorInput = (FileEditorInput) sourceEditor
					.getEditorInput();
			editorFile = editorInput.getFile();
			IDocument document = sourceEditor.getDocumentProvider()
					.getDocument(editorInput);
			document.addDocumentListener(this);
		}
		
		fsmlModelFile = null;
		int retryAttempt = 0;
		boolean foundFile = false;
		String numbering = null;
		while (retryAttempt < 10 && !foundFile) {
			for (int i = 0; i < supportedProjectExtensions.length; i++) {
				numbering = (retryAttempt == 0) ? "" : "_" + retryAttempt;
				fsmlModelFile = ResourcesPlugin
						.getWorkspace()
						.getRoot()
						.getFile(
								editorFile
										.getProject()
										.getFullPath()
										.append(
												editorFile.getProject().getName()
														+ numbering
														+ supportedProjectExtensions[i]));
				if (fsmlModelFile.exists()) {
					foundFile = true;
					break;
				}
			}
			retryAttempt++;
		}
		if (!fsmlModelFile.exists()){
			return false;
		}
		IEditorInput editorInput = sourceEditor.getEditorInput();
		if (editorInput != null)
			cu = JavaUI.getEditorInputJavaElement(editorInput);
		Markers.INSTANCE.setProject(cu.getJavaProject().getProject());
		reloadModelFromDisk();
		return true;
	}

	private void reloadModelFromDisk() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI fsmlModelURI = URI.createPlatformResourceURI(fsmlModelFile
				.getFullPath().toString(), true);
		if (fsmlModelFile.exists()) {
			Resource resource = resourceSet.getResource(fsmlModelURI, true);
			
			EList<EObject> fsmlModel = resource.getContents();
			assertedModel = ((ModelContainer) fsmlModel.get(0))
					.getAssertedModel();
			fsmlId2ModelEObject = new HashMap<String, EObject>();

			FSMLEcoreUtil.createFsmlId2EObjectMap(assertedModel,
					fsmlId2ModelEObject);
			viewer.setInput(assertedModel);
			viewer.expandAll();
			viewer.refresh();
		}
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public void refresh() {
		viewer.refresh();
	}

	public void documentAboutToBeChanged(DocumentEvent event) {
	}

	public void documentChanged(DocumentEvent event) {
		reloadModelFromDisk();
	}

}
