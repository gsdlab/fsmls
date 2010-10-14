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


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.internal.resources.Marker;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.internal.core.ResolvedSourceMethod;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MarkerTransfer;

import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;

public class FSMLCodeGenDragSourceListener extends DragSourceAdapter implements
		TransferDragSourceListener {
	private final StructuredViewer viewer;
	private final IProject project;
	private Marker marker;

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

//	public void dragSetData(DragSourceEvent event) {
//		//event.data = "showStatus(null);";
//		// event.data = new PluginTransferData( "my_drop_action", new
//		// byte[]{(byte)1});
//		event.detail = DND.DROP_MOVE;
//
//		ResourceSet resourceSet = new ResourceSetImpl();
//		EList<EObject> existingResourceModel = null;
//
//		IFile implModelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
//				project.getFullPath().append(JavaImplVariantManager.modelName));
//		URI implModelURI = URI.createPlatformResourceURI(implModelFile
//				.getFullPath().toString(), true);
//
//		if (implModelFile.exists()) {
//
//			existingResourceModel = resourceSet.getResource(implModelURI, true)
//					.getContents();
//
//		}
//
//		HashMap<String, EObject> defaultsInImplModel = new HashMap<String, EObject>();
//
//		EList<EObject> implModelContents = existingResourceModel.get(0)
//				.eContents();
//		EObject currentFeature = null;
//		for (int i = 0; i < implModelContents.size(); i++) {
//			currentFeature = implModelContents.get(i);
//			if (currentFeature.eClass().getName().startsWith(
//					JavaImplVariantManagerConstants.DEFAULT)) {
//				// check if the mapping is the same (eClass and
//				// eStructuralFeature)
//				String eClass = (String) currentFeature.eGet(currentFeature
//						.eClass().getEStructuralFeature(
//								JavaImplVariantManagerConstants.ECLASS));
//				String eStructuralFeature = (String) currentFeature
//						.eGet(currentFeature
//								.eClass()
//								.getEStructuralFeature(
//										JavaImplVariantManagerConstants.ESTRUCTURALFEATURE));
//
//				EList<Variant> defaultVariants = ((EList) currentFeature
//						.eGet(JavaImplVariantManager
//								.getVariantReferenceForDefault(currentFeature
//										.eClass())));
//
//				String mappingType = currentFeature
//						.eClass()
//						.getName()
//						.replaceAll(
//								JavaImplVariantManagerConstants.DEFAULT
//										+ JavaImplVariantManagerConstants.DELIMITER,
//								"");
//				String hashMapKey = mappingType
//						+ JavaImplVariantManagerConstants.DELIMITER + eClass
//						+ JavaImplVariantManagerConstants.DELIMITER
//						+ eStructuralFeature;
//				defaultsInImplModel.put(hashMapKey, currentFeature);
//			}
//
//		}
//		EObject eObj = (EObject) ((IStructuredSelection) viewer.getSelection())
//				.toArray()[0];
//		EList<EAnnotation> annotations = eObj.eContainingFeature()
//				.getEAnnotations();
//
//		for (EAnnotation annotation : annotations) {
//			String hashMapKey = annotation
//					.getSource()
//					+ JavaImplVariantManagerConstants.DELIMITER
//					+ eObj.eContainer().eClass().getName()
//					+ JavaImplVariantManagerConstants.DELIMITER
//					+ eObj.eContainingFeature().getName();
//			if (defaultsInImplModel.containsKey(hashMapKey)) {
//				EObject defaultMappingType = defaultsInImplModel.get(hashMapKey);
//
//				EList defaultVariants=(EList)defaultMappingType.eGet(defaultMappingType.eClass().getEStructuralFeature(JavaImplVariantManagerConstants.VARIANT));
//				if (defaultVariants.size()>0) {
//					String declaringMethodKey = (String)((EObject)defaultVariants.get(0)).eGet(((EObject)defaultVariants.get(0)).eClass().getEStructuralFeature(JavaImplVariantManagerConstants.METHOD_NAME));
//					
//					
////					IResource resource = iMember.getJavaProject().getResource();
////					JavaMarkerDescriptor markerDescriptor = createJavaMarkerDescriptor(resource, fullyQualifiedName, value, explanation);
////					markerDescriptor.setCharStartCharEnd(iMember);
////					
////					
////					BindingKeyResolver resolver = new BindingKeyResolver(declaringMethodKey);
////					resolver.parse();
////					resolver.getCompilationUnitDeclaration();
//					
////					try {
////						JavaCore.create(project).findType(Util.getDeclaringTypeSignature(declaringMethodKey));
////					} catch (JavaModelException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
//					
//					marker = (Marker)Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId((EObject)defaultVariants.get(0),null)).get(0);
//					event.data = new Marker[] { marker};
//					
//				}
//					
//				}
//			}
//		}

	

	@Override
	public void dragStart(DragSourceEvent event) {
		// check whether the feature is in the last reconciled model - if not,
		// this listener will handle it
		EObject selectedEObject = (EObject) ((IStructuredSelection) viewer.getSelection())
				.toArray()[0];
		String parentKey = FSMLEcoreUtil.getFSMLId(selectedEObject, null);

		Model lastReconciledModel = ((ModelContainer) selectedEObject.eResource()
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
	
	@Override
	public void dragSetData(DragSourceEvent event) {
		// TODO Auto-generated method stub
//		super.dragFinished(event);
		
//		PackageExplorerPart view = (PackageExplorerPart)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView("org.eclipse.jdt.ui.PackageExplorer");
//		TreeViewer treeViewer = view.getTreeViewer();
//		treeViewer.collapseAll();
//		treeViewer.addFilter(new ViewerFilter() {
//		
//			@Override
//			public boolean select(Viewer viewer, Object parentElement, Object element) {
//				// TODO Auto-generated method stub
//				return true;
//			}
//		
//		});
		
		
		
		
		
		ArrayList<IMarker> markers = new ArrayList<IMarker>();
		List<String> methodLocationNamesForMarkers= new ArrayList<String>();
		
		EObject selectedEObject = (EObject) ((IStructuredSelection) viewer.getSelection())
		.toArray()[0];
		Model assertedModel = ((ModelContainer)selectedEObject.eResource().getContents().get(0)).getAssertedModel();
		
		TreeIterator<EObject> allContents = assertedModel.eAllContents();
		HashMap<String, CompilationUnit> cuCache = new HashMap<String,CompilationUnit>();

		HashMap<String, Integer> methodLocations = new HashMap<String, Integer>();
		
		while (allContents.hasNext()){
			EObject currentObject = allContents.next();
			if (currentObject.eClass().equals(selectedEObject.eClass())){
				List<IMarker> markersForCurrentObject = Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId(currentObject, null));
				if (!markersForCurrentObject.isEmpty()){
					markers.addAll(markersForCurrentObject);
					IResource resource =null;
					ICompilationUnit cu =null;
					int markerStartPos;
					int markerEndPos;
					for (int i=0;i<markersForCurrentObject.size();i++){
						resource = markersForCurrentObject.get(i).getResource();
						cu = JavaCore.createCompilationUnitFrom(FileBuffers.getWorkspaceFileAtLocation(resource.getFullPath()));;
					
						try {
						
							markerStartPos = ((Integer)markersForCurrentObject.get(i)
									.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START))
									.intValue();
							markerEndPos = ((Integer) markersForCurrentObject.get(i)
									.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END))
									.intValue();
							CompilationUnit astRoot =null;
							CompilationUnit cuInCache = cuCache.get(resource.getFullPath().toString());
							if (cuInCache==null){
								ASTParser parser = ASTParser.newParser(AST.JLS3);
								parser.setSource(cu);
								parser.setResolveBindings(true);
								parser.setBindingsRecovery(true);
								astRoot = (CompilationUnit) parser.createAST(null);
								cuCache.put(resource.getFullPath().toString(), astRoot);
							}else {
								astRoot =cuInCache;
							}
							
							ASTNode astNode = ASTNodeSearchUtil.getAstNode(astRoot, markerStartPos, markerEndPos-markerStartPos);
							while (astNode!=null && !(astNode instanceof MethodDeclaration)){
								astNode = astNode.getParent();
							}
							if (astNode!=null){
								String methodKey = ((ResolvedSourceMethod)((MethodDeclaration)astNode).resolveBinding().getJavaElement()).getKey();
								methodKey = methodKey.substring(methodKey.indexOf(";.")+2);
								if (methodLocations.get(methodKey)==null){
									methodLocations.put(methodKey,1);
								} else {
									methodLocations.put(methodKey,methodLocations.get(methodKey)+1);
								}
								methodLocationNamesForMarkers.add(methodKey);
							} else {
								methodLocationNamesForMarkers.add("N/A");
							}
						} catch (JavaModelException e) {
							e.printStackTrace();
						} catch (CoreException e) {
							e.printStackTrace();
						}
						
					}
				
				}
			}
		}
		Set<Entry<String, Integer>> entrySet = methodLocations.entrySet();
		ArrayList<Entry<String,Integer>> sortedMethodLocations = new ArrayList<Entry<String,Integer>>();
		sortedMethodLocations.addAll(entrySet);
	
		Collections.sort(sortedMethodLocations, new Comparator<Entry<String,Integer>>(){
	
				@Override
				public int compare(Entry<String, Integer> o1,
						Entry<String, Integer> o2) {
					if (o1.getValue()>o2.getValue()){
						return -1;
					}else if (o1.getValue()==o2.getValue()){
						return 0;
					}else {
						return 1;
					}
				}
			}
		);
		
		//find the context class
		EObject classEObject = selectedEObject;
		while (classEObject!=null && classEObject.eClass().getEAnnotation(JavaMappingInterpreter.CONTEXT_CLASS)==null){
			classEObject = classEObject.eContainer();
		}
		if (classEObject!=null){
			List<IMarker> classEObjectMarker = Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId(classEObject, null));
			if (classEObjectMarker.size()>0){
				IResource resource = classEObjectMarker.get(0).getResource();
				ICompilationUnit cu = JavaCore.createCompilationUnitFrom(FileBuffers.getWorkspaceFileAtLocation(resource.getFullPath()));;
				ASTParser parser = ASTParser.newParser(AST.JLS3);
				parser.setSource(cu);
				parser.setResolveBindings(true);
				parser.setBindingsRecovery(true);
				CompilationUnit astRoot = (CompilationUnit) parser.createAST(null);
				
				for (Entry<String, Integer> entry : sortedMethodLocations) {
					System.out.println (entry.getKey()+"\t("+entry.getValue()+")");
				}	
				for (Entry<String, Integer> entry : sortedMethodLocations) {
						String targetMethodKey = "L"+astRoot.getPackage().getName().toString().replaceAll("\\.", "\\/")+"/"+resource.getName().replaceAll(resource.getFileExtension(), "").replaceAll("\\.","")+";."+entry.getKey();
						ASTNode targetMethod = astRoot.findDeclaringNode(targetMethodKey);
							
						if (targetMethod!=null){
							try {
								ResolvedSourceMethod resolvedSourceMethod = ((ResolvedSourceMethod)((MethodDeclaration)targetMethod).resolveBinding().getJavaElement());
								ISourceRange sourceRange = resolvedSourceMethod.getSourceRange();
								int sourceStart= resolvedSourceMethod.getSource().indexOf("{")+2;
								IMarker codeLocationAssistMarker = resource.createMarker("fsml code location assist");
								codeLocationAssistMarker.setAttribute(MarkerDescriptor.ATTRIBUTE_ID, targetMethodKey);
								codeLocationAssistMarker.setAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START, sourceRange.getOffset()+sourceStart);
								codeLocationAssistMarker.setAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END,sourceRange.getOffset()+sourceStart);
								event.data = new Marker[] { (Marker)codeLocationAssistMarker};
							} catch (CoreException e) {
								e.printStackTrace();
							}
							
							break;
							
						} 
				}			
			}
		}
		if (event.data ==null){
			event.data = new Marker[] {};
		}
		
		//TODO: create the most common method if can't find any target method??
		
		
		try {
			IViewPart showView = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("ca.uwaterloo.gsd.fsml.codeLocationAssist.featureInstancesCodeLocatorView");
			if (showView!=null && showView instanceof FeatureInstancesCodeLocatorView){
				((FeatureInstancesCodeLocatorView)showView).showMarker(markers,methodLocationNamesForMarkers);	
			}
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
				
	}
	
	
	
	
	
}
