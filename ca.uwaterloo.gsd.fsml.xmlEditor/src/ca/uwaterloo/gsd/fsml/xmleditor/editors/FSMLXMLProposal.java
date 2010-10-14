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
package ca.uwaterloo.gsd.fsml.xmleditor.editors;

import java.io.IOException;
import java.util.HashMap;
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
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

import ca.uwaterloo.gsd.fsml.codeAssist.FSMLProposalsAction;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;

public class FSMLXMLProposal implements ICompletionProposal {

	private EObject eObject;
	private EClass concreteClass;
	private EStructuralFeature structuralFeature;
	private String proposalName;
	private Resource resource;
	private Vector<SyncItem> codeGenTasks;
	private Image image;
	private FSMLProposalsAction action;
	private EList<EStructuralFeature> positionProposalStructuralFeatures;
	private List<EObject> contextForPositionProposalStructuralFeatures = null;
	
	public FSMLXMLProposal(String proposalName, EObject eObject, EClass concreteClass, EStructuralFeature structuralFeature, Resource resource, Image image) {
		positionProposalStructuralFeatures = new BasicEList<EStructuralFeature>();
		contextForPositionProposalStructuralFeatures = new Vector<EObject>();
		this.proposalName = proposalName;
		this.eObject = eObject;
		this.concreteClass = concreteClass;
		this.structuralFeature = structuralFeature;
		this.resource = resource;
		this.image = image;
		codeGenTasks = new Vector<SyncItem>();
		action = new FSMLProposalsAction(resource,codeGenTasks,positionProposalStructuralFeatures,contextForPositionProposalStructuralFeatures);
	}

	@Override
	public void apply(IDocument document) {

		ClassSyncItem parentClassSyncItem = SyncFactory.eINSTANCE
				.createClassSyncItem();
		parentClassSyncItem.setModel(eObject);
		parentClassSyncItem
				.setReconciliationDecision(ReconciliationDecision.ENFORCE_LITERAL);
		parentClassSyncItem
				.setSynchronizationState(SynchronizationState.ADDED_MODEL_LITERAL);
		
		//EReference feature = element.eContainmentFeature();		
		NullProgressMonitor progressMonitor = new NullProgressMonitor();
		if (structuralFeature instanceof EReference){
			try {
				action.forwardFeatureRepresentedAsReference(structuralFeature,concreteClass,eObject,parentClassSyncItem, progressMonitor);
			} catch (FSMLMappingException e) {
				e.printStackTrace();
			}
		} else if (structuralFeature instanceof EAttribute){
			try {
				action.forwardFeatureRepresentedAsAttribute(structuralFeature, parentClassSyncItem, progressMonitor);
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
		//save changes to the model
		Map options = new HashMap();
		options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	

	@Override
	public String getAdditionalProposalInfo() {
		return "A proposal from FSML";
	}

	@Override
	public IContextInformation getContextInformation() {
		return new ContextInformation("xml","xml2");
	}

	@Override
	public String getDisplayString() {
		return proposalName;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public Point getSelection(IDocument document) {
		return null;
	}

}
