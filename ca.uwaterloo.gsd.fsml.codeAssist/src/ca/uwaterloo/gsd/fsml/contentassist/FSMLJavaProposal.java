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
package ca.uwaterloo.gsd.fsml.contentassist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.CompletionContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ITrackedNodePosition;
import org.eclipse.jdt.internal.corext.fix.LinkedProposalPositionGroup;
import org.eclipse.jdt.internal.corext.fix.LinkedProposalPositionGroup.PositionInformation;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;
import org.eclipse.jdt.internal.ui.text.correction.proposals.LinkedCorrectionProposal;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;

import ca.uwaterloo.gsd.fsml.codeAssist.FSMLCodeAssistUtil;
import ca.uwaterloo.gsd.fsml.codeAssist.FSMLProposalsAction;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.VarCollector;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.VarDesc;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;
import ca.uwaterloo.gsd.fsml.xmlMappingInterpreter.XMLMappingInterpreter;

public class FSMLJavaProposal extends LinkedCorrectionProposal {
	
	private EStructuralFeature feature;
	private ASTNode coveringNode;
	private EObject parentEObject;
	private ICompilationUnit cu;
	private int invocationOffset;
	private ASTRewrite rewrite;
	private EClass concreteClass;
	private Resource resource;
	private HashSet<String> variableNames;
	private Image image;

	private EList<EStructuralFeature> positionProposalStructuralFeatures;
	private List<EObject> contextForPositionProposalStructuralFeatures;
	private List<VarDesc> variablesInScope;
	private CompilationUnit compilationUnit;
	private CompletionContext context;
	private boolean deleteKeyword;
	private Vector<SyncItem> codeGenTasks;
	private FSMLProposalsAction action;

	
	public FSMLJavaProposal(String name, ICompilationUnit cu, ASTRewrite rewrite,
			int relevance, Image image, EObject currentEObject, EClass concreteClass,
			EStructuralFeature feature, ASTNode coveringNode,
			int invocationOffset, Resource resource, CompletionContext context) {
		super(name, cu, rewrite, relevance, image);
		positionProposalStructuralFeatures = new BasicEList<EStructuralFeature>();
		contextForPositionProposalStructuralFeatures=new Vector<EObject>();
		codeGenTasks = new Vector<SyncItem>();
		action = new FSMLProposalsAction(resource,codeGenTasks,positionProposalStructuralFeatures,contextForPositionProposalStructuralFeatures);
		this.cu = cu;
		this.rewrite = rewrite;
		this.image = image;
		this.parentEObject = currentEObject;
		this.concreteClass = concreteClass;
		this.feature = feature;
		this.coveringNode = coveringNode;
		this.invocationOffset = invocationOffset;
		this.resource = resource;
		this.context = context;
		variablesInScope = new ArrayList<VarDesc>();
		variableNames = new HashSet<String>();
		if (coveringNode!=null){
			compilationUnit = (CompilationUnit)coveringNode.getRoot();
			VarCollector collector = new VarCollector();
			try {
				collector.collect(compilationUnit, compilationUnit.getTypeRoot().getSource(), invocationOffset);
				variablesInScope = collector.getDeclarations();
				for (int i = 0; i < variablesInScope.size(); i++) {
					variableNames.add(variablesInScope.get(i).name);
				}
	
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}

	}
	
	protected EObject performProposalChange(IEditorPart part, IDocument document) throws FSMLMappingException {
		EObject newConcreteClassInstance=null;
		CodeTransforms.currentProposal = this;
		ClassSyncItem parentClassSyncItem = SyncFactory.eINSTANCE
				.createClassSyncItem();
		parentClassSyncItem.setModel(parentEObject);
		parentClassSyncItem
				.setReconciliationDecision(ReconciliationDecision.ENFORCE_LITERAL);
		parentClassSyncItem
				.setSynchronizationState(SynchronizationState.ADDED_MODEL_LITERAL);
		
		//EReference feature = element.eContainmentFeature();
		NullProgressMonitor progressMonitor = new NullProgressMonitor();
		
		if (feature==null){
			ITrackedNodePosition trackedNodePosition = rewrite.track(coveringNode);
			CodeTransforms.currentProposal.addLinkedPosition(trackedNodePosition, true, "FSMLProposalLinkedPosition"+0);
			action.prepareSubProposals(concreteClass, concreteClass.getEAllStructuralFeatures(),parentEObject);
		}else if (feature instanceof EAttribute){
			
				action.forwardFeatureRepresentedAsAttribute(feature,
						parentClassSyncItem, progressMonitor);
			

		} else if (feature instanceof EReference) {
			try {
				newConcreteClassInstance = action.forwardFeatureRepresentedAsReference(feature, concreteClass,
						parentEObject, parentClassSyncItem, progressMonitor);
			} catch (FSMLMappingException e) {
				e.printStackTrace();
			}

		} 
		
		try {
			for (SyncItem item : codeGenTasks) {
				if (item instanceof ClassSyncItem){
					Queries.INSTANCE.forwardFeatureRepresentedAsClass((ClassSyncItem)item, progressMonitor);
				}else if (item instanceof StructuralFeatureSyncItem){
					Queries.INSTANCE.forwardFeatureRepresentedAsAttribute((StructuralFeatureSyncItem)item, progressMonitor);
				}
			}
		} catch (FSMLMappingException e) {
			e.printStackTrace();
		}
		codeGenTasks.clear();
		//commit the changes
		Queries.INSTANCE.terminate(progressMonitor);
		

		
		//update the field cu with the new cu (for the subproposals) 
		coveringNode= FSMLCodeAssistUtil.getCoveringNode(cu, invocationOffset+1, 0);
		if (coveringNode!=null && coveringNode.getRoot() instanceof CompilationUnit){
			compilationUnit=(CompilationUnit)coveringNode.getRoot();
			
			try {
				cu = JavaModelUtils.getTypeRoot(compilationUnit.getJavaElement()).getWorkingCopy(JavaMappingInterpreter.primaryWorkingCopyOwner, progressMonitor);
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		
		//suggest proposals for feature group
		createSubProposals(part,document);
		return newConcreteClassInstance; 
	}

	public void createSubProposals(IEditorPart part, IDocument document) {
		if (coveringNode==null){
			return;
		}
		ASTNode newNode=null;
		int offset = 0;
		for (Iterator positionGroupIterator = getLinkedProposalModel().getPositionGroupIterator(); positionGroupIterator.hasNext();) {
			LinkedProposalPositionGroup next = (LinkedProposalPositionGroup)positionGroupIterator.next();
			PositionInformation[] positions = next.getPositions();
			offset = positions[0].getOffset();
			int length = positions[0].getLength();
			newNode = ASTNodeSearchUtil.getAstNode(compilationUnit, offset-1, length);
		}
		if (!positionProposalStructuralFeatures.isEmpty()){
			for (EStructuralFeature structuralFeature : positionProposalStructuralFeatures) {
				//linked position proposal test
				if (structuralFeature instanceof EAttribute){
					String proposalName = structuralFeature.getName();
					if (proposalName.length()>0){
						proposalName = proposalName.toUpperCase().charAt(0)+proposalName.substring(1);
						//if we have more than one concrete class, we should use the concreteClass name instead
						//going with the reference name for now to be consistent with the metamodel in DSPD
						//proposalName = concreteClass.getName();
					}
					getLinkedProposalModel()
					.getPositionGroup("FSMLProposalLinkedPosition"+0, true)
					.addProposal(
	
							new FSMLPositionProposal(
									"positionProposal",
									proposalName+"("+contextForPositionProposalStructuralFeatures.get(0).eClass().getName()+")",
									cu,
									rewrite,
									contextForPositionProposalStructuralFeatures.get(0),
									null ,
									structuralFeature,
									newNode,
									offset,
									image,
									1, resource,part,document));
						
		
				} else if (structuralFeature instanceof EReference){
	
					Collection<EClass> concreteClasses = FSMLEcoreUtil
							.getSubclassesOfEClass(
									((EReference) structuralFeature)
											.getEReferenceType(), true);
					for (EClass class1 : concreteClasses) {
						//TODO: make the subproposals in the linked position of the feature that it is for
						String proposalName = structuralFeature.getName();
						if (proposalName.length()>0){
							proposalName = proposalName.toUpperCase().charAt(0)+proposalName.substring(1);
							//if we have more than one concrete class, we should use the concreteClass name instead
							//going with the reference name for now to be consistent with the metamodel in DSPD
							//proposalName = concreteClass.getName();
						}
						getLinkedProposalModel()
						.getPositionGroup("FSMLProposalLinkedPosition"+0, true)
						.addProposal(
		
								new FSMLPositionProposal(
										"positionProposal",
										proposalName+"("+contextForPositionProposalStructuralFeatures.get(0).eClass().getName()+")",
										cu,
										rewrite,
										contextForPositionProposalStructuralFeatures.get(0),
										class1 ,
										structuralFeature,
										newNode,
										offset,
										image,
										1, resource,part,document));
					}
				}
			}
		}
		positionProposalStructuralFeatures.clear();
		contextForPositionProposalStructuralFeatures.clear();
	}



	protected void performChange(org.eclipse.ui.IEditorPart part,
			org.eclipse.jface.text.IDocument document)
			throws org.eclipse.core.runtime.CoreException {
		// change the model
		try {
			EObject newConcreteClassInstance = performProposalChange(part,document);
			super.performChange(part, document);
			
			//TODO: fix problem with lost of linked mode OR if before super.performChange(part,document), 
			//"linked box" positions messing up
			//delete the keyword
			if (deleteKeyword && context!=null){
				try {
					document.replace(context.getTokenStart(), context.getTokenEnd()-context.getTokenStart()+1, "");
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}			
			

			FSMLEcoreUtil.parameterValuesFromRecommenderSystem.clear();
			Queries.INSTANCE.reset();
			JavaMappingInterpreter javaMappingInterpreter = new JavaMappingInterpreter();
			Queries.INSTANCE.registerCustomInterpreter(javaMappingInterpreter);
		
			//register XML mapping interpreter
			XMLMappingInterpreter xmlMappingInterpreter = new XMLMappingInterpreter();
			Queries.INSTANCE.registerCustomInterpreter(xmlMappingInterpreter);
			
			
			
			
			EList<EObject> fsmlModel = resource.getContents();
			
			Model assertedModel = ((ModelContainer) fsmlModel.get(0))
					.getAssertedModel();
			
			Queries.INSTANCE.initialize(cu
					.getJavaProject().getProject(),assertedModel);
			javaMappingInterpreter.getAnalysisManagers().getJavaASTManager().setCompilationUnit(
					JavaModelUtils.getTypeRoot(((CompilationUnit)coveringNode.getRoot()).getJavaElement()),(CompilationUnit)coveringNode.getRoot());
			
			
			EObject currentContext = (newConcreteClassInstance==null)?parentEObject:newConcreteClassInstance;
			while (coveringNode!=null){
				Queries.INSTANCE.associateContext(currentContext, coveringNode);
				coveringNode = coveringNode.getParent();
			}
			
			// Save the changes to the model
			
			Map options = new HashMap();
			options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
					Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
	
			try {
				resource.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FSMLMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//refresh the model editor
//		IWorkbench workbench = PlatformUI.getWorkbench();
//		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
//		IWorkbenchPage page = workbenchWindow.getActivePage();
//		final IWorkbenchPart activePart = page.getActivePart();
//		String featureInstanceModelExtension = ".applet";
//		//TODO: just use the project name as the model name now...
//		IFile fsmlModelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
//				cu.getJavaProject().getPath().append(
//						cu.getJavaProject().getElementName().toString()
//								+ featureInstanceModelExtension));
//		String modelEditorID = workbench.getEditorRegistry().getDefaultEditor(
//				fsmlModelFile.getFullPath().toString()).getId();
//		

//		IEditorReference[] editorReferences = PlatformUI.getWorkbench()
//				.getActiveWorkbenchWindow().getActivePage()
//				.getEditorReferences();
//
//		for (IEditorReference editorReference : editorReferences) {
//
//			if (editorReference.getEditor(true).getEditorInput().equals(
//					new FileEditorInput(fsmlModelFile))) {
				//TODO: refresh the model editor
//				try {
//					page.openEditor(new FileEditorInput(fsmlModelFile), modelEditorID,
//							true);
//				} catch (PartInitException exception) {
//					MessageDialog.openError(workbenchWindow.getShell(),
//							"Unable to open editor.", exception.getMessage());
//
//				}
//			}
//		}

	}

	public void setDeleteKeyword(boolean value) {
		deleteKeyword = value;
	}

}
