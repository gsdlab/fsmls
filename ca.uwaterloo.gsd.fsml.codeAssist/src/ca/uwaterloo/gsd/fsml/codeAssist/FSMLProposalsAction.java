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
package ca.uwaterloo.gsd.fsml.codeAssist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;

public class FSMLProposalsAction {
	Vector<SyncItem> codeGenTasks;
	EList<EStructuralFeature> positionProposalStructuralFeatures;
	List<EObject>contextForPositionProposalStructuralFeatures;	
	Resource resource;
	public FSMLProposalsAction(Resource resource,Vector<SyncItem> codeGenTasks, EList<EStructuralFeature> positionProposalStructuralFeatures, List<EObject> contextForPositionProposalStructuralFeatures){
		this.codeGenTasks =codeGenTasks; 
		this.resource = resource;
		this.positionProposalStructuralFeatures = positionProposalStructuralFeatures;
		this.contextForPositionProposalStructuralFeatures = contextForPositionProposalStructuralFeatures;
	}
	
	public EObject forwardFeatureRepresentedAsReference(
			EStructuralFeature feature, EClass concreteClass, EObject eObject,
			ClassSyncItem parentClassSyncItem,
			NullProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject newConcreteClassInstance = EcoreUtil.create(concreteClass);
		if (feature.isMany())
			((EList) eObject.eGet(feature)).add(newConcreteClassInstance);
		else
			eObject.eSet(feature, newConcreteClassInstance);
		ClassSyncItem classSyncItem = SyncFactory.eINSTANCE
				.createClassSyncItem();
		classSyncItem.setModel(newConcreteClassInstance);
		classSyncItem
				.setReconciliationDecision(ReconciliationDecision.ENFORCE_LITERAL);
		classSyncItem
				.setSynchronizationState(SynchronizationState.ADDED_MODEL_LITERAL);

		//need the parent since the processField() in Mapping is getting the context from the parent
		parentClassSyncItem.getSyncItems().add(classSyncItem);
		EObject parentEObject = parentClassSyncItem.getModel();
		EObject container = parentEObject.eContainer();
		while (container!=null){
			ClassSyncItem ancestorClassSyncItem = SyncFactory.eINSTANCE
			.createClassSyncItem();
			ancestorClassSyncItem.setModel(container);
			ancestorClassSyncItem
			.setReconciliationDecision(ReconciliationDecision.ENFORCE_LITERAL);
			ancestorClassSyncItem
			.setSynchronizationState(SynchronizationState.ADDED_MODEL_LITERAL);
			ancestorClassSyncItem.getSyncItems().add(parentClassSyncItem);
			parentClassSyncItem = ancestorClassSyncItem;
			container = container.eContainer();

		}
		
		
		//mechanism to auto generate field names
//		EAnnotation annotation = FSMLEcoreUtil.getEAnnotation(concreteClass, JavaMappingInterpreter.CONTEXT_FIELD);
//		
//		if (annotation!=null){
//			EAttribute nameFeature = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(concreteClass, new String[] {JavaMappingInterpreter.QUERY_FIELD_NAME} );
//			String fieldName = (String) newConcreteClassInstance.eGet(nameFeature);
//			if (fieldName==null){
//				//create a default variable name for the field since it doesn't already have one
//				String name = "a"+newConcreteClassInstance.eClass().getName();
//				if (variableNames.contains(name)){
//					int count = 1;
//						while (variableNames.contains(name+count)){
//							count++;
//						}
//						name = name+count;
//				}
////				newConcreteClassInstance.eSet(nameFeature, name);
//			}
//		}
		
		
		//non-containment reference such as ones used for where constraint checking
		if (newConcreteClassInstance.eContainmentFeature()==null ){
			if (checkConstraint(classSyncItem,(EReference)feature,eObject,parentEObject)){

				codeGenTasks.add(classSyncItem);
			} else {
				return null;
			}
		} else {
			codeGenTasks.add(classSyncItem);	
		}
		EList<EStructuralFeature> allStructuralFeatures = concreteClass
				.getEAllStructuralFeatures();
		
		EAnnotation constraints = concreteClass
				.getEAnnotation("constraints");
		String choiceFromFeatureGroup=null;
		if (constraints != null && concreteClass.getEAnnotation(FSMLEcoreUtil.FEATURE_GROUP)!=null) {
		//if (false){
			choiceFromFeatureGroup = (String)FSMLEcoreUtil.getChoiceFromFeatureGroup(allStructuralFeatures);
			
		
		} else {
			prepareSubProposals(concreteClass, allStructuralFeatures,newConcreteClassInstance);
		}
		//else {
		//forward all the mandatory features
		//first forward all the mandatory non-containment references (constraints)
		//then forward all the  other mandatory features

		for (EStructuralFeature structuralFeature : allStructuralFeatures) {
			if (structuralFeature.getLowerBound() > 0 || (choiceFromFeatureGroup!=null && choiceFromFeatureGroup.equals(structuralFeature.getName()))) {
				if (structuralFeature instanceof EReference){
			
				Collection<EClass> concreteClasses = FSMLEcoreUtil
				.getSubclassesOfEClass(
						((EReference) structuralFeature)
								.getEReferenceType(), true);
				for (EClass class1 : concreteClasses) {
					EObject newConcreteClassInstance2 = EcoreUtil.create(class1);
					if (newConcreteClassInstance2.eContainmentFeature()!=null){
						continue;
					}
					
					newConcreteClassInstance=forwardFeatureRepresentedAsReference(structuralFeature,
							class1, newConcreteClassInstance,
							classSyncItem, progressMonitor);
				}

			  }
			}
		}
		for (EStructuralFeature structuralFeature : allStructuralFeatures) {
			if (structuralFeature.getLowerBound() > 0) {
				//also forward all the mandatory features
				if (structuralFeature instanceof EAttribute) {

					forwardFeatureRepresentedAsAttribute(structuralFeature,
							classSyncItem, progressMonitor);
				} else if (structuralFeature instanceof EReference) {
					
					Collection<EClass> concreteClasses = FSMLEcoreUtil
							.getSubclassesOfEClass(
									((EReference) structuralFeature)
											.getEReferenceType(), true);
					for (EClass class1 : concreteClasses) {
						EObject newConcreteClassInstance2 = EcoreUtil.create(class1);
						if (newConcreteClassInstance2.eContainmentFeature()==null){
							continue;
						}
						
						newConcreteClassInstance=forwardFeatureRepresentedAsReference(structuralFeature,
								class1, newConcreteClassInstance,
								classSyncItem, progressMonitor);
					}

				}
			}
		}
		return newConcreteClassInstance;
	}

	public boolean forwardFeatureRepresentedAsAttribute(
			EStructuralFeature feature, ClassSyncItem parentClassSyncItem,
			NullProgressMonitor progressMonitor) throws FSMLMappingException {
		//TOOD: need to set the model
		StructuralFeatureSyncItem featureSyncItem = SyncFactory.eINSTANCE
				.createStructuralFeatureSyncItem();
		featureSyncItem.setStructuralFeature(feature);
		featureSyncItem
				.setReconciliationDecision(ReconciliationDecision.ENFORCE_LITERAL);
		featureSyncItem
				.setSynchronizationState(SynchronizationState.ADDED_MODEL_LITERAL);

		//need the parent since the processField() in Mapping is getting the context from the parent
		parentClassSyncItem.getSyncItems().add(featureSyncItem);

		EObject parentEObject = parentClassSyncItem.getModel();
		EObject container = parentEObject.eContainer();
		while (container!=null){
			ClassSyncItem ancestorClassSyncItem = SyncFactory.eINSTANCE
			.createClassSyncItem();
			ancestorClassSyncItem.setModel(container);
			ancestorClassSyncItem
			.setReconciliationDecision(ReconciliationDecision.ENFORCE_LITERAL);
			ancestorClassSyncItem
			.setSynchronizationState(SynchronizationState.ADDED_MODEL_LITERAL);
			ancestorClassSyncItem.getSyncItems().add(parentClassSyncItem);
			parentClassSyncItem = ancestorClassSyncItem;
			container = container.eContainer();
		}
		
			
//			if (feature.getEAnnotation(JavaMappingInterpreter.QUERY_TYPED_WITH)!=null){
//				for (VarDesc varDesc : variablesInScope) {
//					if (varDesc.type.toString().equals(feature.getEAnnotation(JavaMappingInterpreter.QUERY_TYPED_WITH).getDetails().get(JavaMappingInterpreter.DETAIL_NAME))) {
//						getLinkedProposalModel()
//						.getPositionGroup("FSMLProposalLinkedPosition"+0, true)
//						.addProposal(varDesc.name,image,1);
//					}
//				}
//			}else if (feature.getEType().getName().equals("EString")) {
//				//TODO: String type = retrieveTypeOfArgumentFromSignature(syncItem, index);					
//				for (VarDesc varDesc : variablesInScope) {
//					if (varDesc.type.toString().equals("String")) {
//						getLinkedProposalModel()
//						.getPositionGroup("FSMLProposalLinkedPosition"+0, true)
//						.addProposal(varDesc.name,image,1);
//					}
//				}
//			
//			} 

		codeGenTasks.add(featureSyncItem);				
		return false;
	}
	
	public void prepareSubProposals(EClass concreteClass,
			EList<EStructuralFeature> allStructuralFeatures,EObject newConcreteClassInstance) {
		//check whether we are in a feature group
		//if we are, propose features in the feature group using FSMLPositionProposal
		EAnnotation featureGroup = concreteClass
				.getEAnnotation(FSMLEcoreUtil.FEATURE_GROUP);
		if (featureGroup != null) {
			positionProposalStructuralFeatures.addAll(allStructuralFeatures);
			contextForPositionProposalStructuralFeatures.add(newConcreteClassInstance);
		}
	}

	//return true if forward should be run after constraint check
	private boolean checkConstraint(ClassSyncItem syncItem, EReference feature, EObject element,EObject parentEObject) throws FSMLMappingException {
		EObject newConcreteClassInstance  = syncItem.getModel(); 
		EAnnotation annotation = feature.getEAnnotation(Queries.CONSTRAINT_WHERE);
		if (annotation != null) {
			// find potential targets
			boolean foundTargetObject = false;
			Collection<EObject> targets = ItemPropertyDescriptor.getReachableObjectsOfType(
				element, feature.getEReferenceType());
			
			EList<EObject> fsmlModel = resource.getContents();
			
			Model assertedModel = ((ModelContainer) fsmlModel.get(0))
					.getAssertedModel();
			
			String attributePath = (String) annotation.getDetails().get(Queries.DETAIL_ATTRIBUTE);
			if (attributePath == null)
				return false;
			
			String equalsToPath = (String) annotation.getDetails().get(Queries.DETAIL_EQUALS_TO);
			String containsPath = (String) annotation.getDetails().get(Queries.DETAIL_CONTAINS);
			String inPath = (String) annotation.getDetails().get(Queries.DETAIL_IN);
			if (equalsToPath == null && containsPath == null && inPath == null)
				return false;
			
			FSMLEcoreUtil.NavigationResult target = null;
			String equalsToValue = null;
			EList equalsToList = null;
			if (equalsToPath != null){
				target = FSMLEcoreUtil.navigateToEObject(element, equalsToPath);
				equalsToValue = (String) target.eObject.eGet(target.eAttribute);
			}
			else if (containsPath != null){
				target = FSMLEcoreUtil.navigateToEObject(element, containsPath);
				equalsToValue = (String) target.eObject.eGet(target.eAttribute);
			}
			else if (inPath != null){
				target = FSMLEcoreUtil.navigateToEObject(element, inPath);
				equalsToList = (EList)target.eObject.eGet(target.eAttribute);
			}
			else{
				return false ;
			}
								
//			if (equalsToValue == null && (equalsToList == null|| equalsToList.isEmpty())){
//				return;
//			}
			assert (attributePath != null);

			// check for an additional 'andWhere' clause
			EAnnotation and = feature.getEAnnotation(Queries.CONSTRAINT_AND);
			String attribute2Path = null;
			String equalsTo2Path = null;
			String equalsTo2Value = null;
			if (and != null) {
				attribute2Path = (String) and.getDetails().get(Queries.DETAIL_ATTRIBUTE);
				equalsTo2Path = (String) and.getDetails().get(Queries.DETAIL_EQUALS_TO);
				FSMLEcoreUtil.NavigationResult target2 = FSMLEcoreUtil.navigateToEObject(element, equalsTo2Path);
				equalsTo2Value = (String) target2.eObject.eGet(target2.eAttribute);
			}
			EAnnotation andParentIs = feature.getEAnnotation(Queries.CONSTRAINT_AND_PARENT_IS);
			String parentClassName = null;
			if (andParentIs != null)
				parentClassName = (String) andParentIs.getDetails().get(Queries.DETAIL_INSTANCE_OF);
			
			ArrayList<EObject> possibleTargetEObject = new ArrayList<EObject>() ;
			ArrayList<EAttribute> possibleTargetEAttribute = new ArrayList<EAttribute>();
			// find the target(s) satisfying the constraint
			for (Object object : targets) {
				if (object instanceof EObject) {
					if (assertedModel!=null){
						EObject targetEContainer = ((EObject)object).eContainer();
						while (targetEContainer!=null && !targetEContainer.equals(assertedModel)){
							targetEContainer = targetEContainer.eContainer();
						}
						if (targetEContainer==null){
							continue;
						}
					} else {
						break;
					}
					EObject eObject = (EObject) object;
					EClass eClass = eObject.eClass();
					
					FSMLEcoreUtil.NavigationResult attributeTarget = FSMLEcoreUtil.navigateToEObject(eObject, attributePath);
					if (attributeTarget.errorMessage != null) 
						throw new FSMLMappingException(Cause.MODEL_NAVIGATION_ERROR, feature, attributeTarget.errorMessage);
					EAttribute eAttribute = attributeTarget.eAttribute;
					if (eAttribute==null || attributeTarget.eObject==null){
						continue;
					}
					if (equalsToPath != null) {
						// handle only single-valued attributes
						String auxValue = (String) attributeTarget.eObject.eGet(eAttribute);
						if (FSMLEcoreUtil.valuesEqual(equalsToValue, auxValue)||equalsToValue==null) {
							if (equalsToValue==null){
								//do something
							}
							
							if (and != null) {
								FSMLEcoreUtil.NavigationResult target3 = FSMLEcoreUtil.navigateToEObject(eObject, attribute2Path);
								if (target3.eObject == null || target3.eAttribute == null)
									continue;
								//FSMLEcoreUtil.NavigationResult attribute2Target = FSMLEcoreUtil.navigateToEObject(element, attribute2Path);
								EAttribute eAttribute2 = target3.eAttribute;
								String auxValue2 = (String) target3.eObject.eGet(eAttribute2);
								if (equalsTo2Value!=null && !FSMLEcoreUtil.valuesEqual(equalsTo2Value, auxValue2))
									continue;
							}
							if (andParentIs != null) {
								if (eObject.eContainer()==null||!eObject.eContainer().eClass().getName().equals(parentClassName))
									continue;
							}
							foundTargetObject = true;
							if (feature.isMany())
								((EList) element.eGet(feature)).add(eObject);
							else {
								element.eSet(feature, eObject);
							}
						}
						
						//need to iterate all the targets if 
						if (equalsToValue!=null && !feature.isMany()){
							continue;
						} else if (equalsToValue==null) {
							possibleTargetEObject.add(attributeTarget.eObject);
							possibleTargetEAttribute.add(attributeTarget.eAttribute);
						}
								
					}
					else if (containsPath != null) {
						// handle only multi-valued attributes
						if (attributeTarget.errorMessage != null)
							throw new FSMLMappingException(Cause.MODEL_NAVIGATION_ERROR, attributeTarget.errorMessage);
						else {
							EList auxValues = (EList) attributeTarget.eObject.eGet(attributeTarget.eAttribute);
							if (auxValues.contains(equalsToValue)) {
								foundTargetObject = true;
								if (feature.isMany())
									((EList) element.eGet(feature)).add(eObject);
								else {
									element.eSet(feature, eObject);
									break;
								}
							}
						}
					}
					else if (inPath != null){
						// handle only single-valued attributes contained in list.
						String auxValue = (String) attributeTarget.eObject.eGet(eAttribute);
						if (equalsToList.contains(auxValue)){
							foundTargetObject = true;
							if (feature.isMany())
								((EList) element.eGet(feature)).add(eObject);
							else {
								element.eSet(feature, eObject);
								break;
							}
						}
					}
					
				}
			}//for
			
			if (possibleTargetEObject.size()!=0){
				String attributeValueWithSuggestionsWizard = FSMLEcoreUtil.getAttributeValueWithSuggestionsWizard(possibleTargetEObject,possibleTargetEAttribute);
				if (attributeValueWithSuggestionsWizard.equals("new value")){
					attributeValueWithSuggestionsWizard= null;
					while (attributeValueWithSuggestionsWizard==null){
						attributeValueWithSuggestionsWizard = (String)FSMLEcoreUtil.getAttributeValueFromAttributeValueWizard(target.eAttribute);
					}
					foundTargetObject=false;
					target.eObject.eSet(target.eAttribute, attributeValueWithSuggestionsWizard);
					equalsToValue = attributeValueWithSuggestionsWizard;
						
				} else { //use a preexisting value
					for (int i=0;i<possibleTargetEObject.size();i++){
						if (possibleTargetEObject.get(i).eGet(possibleTargetEAttribute.get(i)).equals(attributeValueWithSuggestionsWizard)){
							syncItem.setModel(possibleTargetEObject.get(i));
							if (feature.isMany())
								((EList) element.eGet(feature)).add(possibleTargetEObject.get(i));
							else {
								element.eSet(feature, possibleTargetEObject.get(i));
								break;
							}
							
						}
					}
					target.eObject.eSet(target.eAttribute, attributeValueWithSuggestionsWizard);
					return false;
				}
			}
			
			if (!foundTargetObject){
				//create one ourselves
				
				//the following check maybe necessary
				//if (parentEObject!=null){
					if (andParentIs!=null){
						parentClassName = (String) andParentIs.getDetails().get(Queries.DETAIL_INSTANCE_OF);
						TreeIterator<EObject> allContents = assertedModel.eAllContents();
						while (allContents.hasNext()){
							EObject parentCandidate = allContents.next();
							if (parentCandidate.eClass().getName().equals(parentClassName)){
								checkConstraintHelper(newConcreteClassInstance, feature,
										attributePath, equalsToValue,
										parentCandidate);
								break;
							}
						}//end while
					}
					else { //try the where/and constraints for ../ attributes
						if (attributePath.startsWith("../") ||
								attribute2Path.startsWith("../")){
							String targetAttributePath;
							String targetEqualsToValue;
							if (attributePath.startsWith("../")){
								targetAttributePath = attributePath;
								targetEqualsToValue = equalsToValue;
							} else {
								targetAttributePath = attribute2Path;
								targetEqualsToValue = equalsTo2Value;
							}
							for (Object object : targets) {
								EObject eObject = (EObject) object;
								EClass eClass = eObject.eClass();
								
								FSMLEcoreUtil.NavigationResult attributeTarget = FSMLEcoreUtil.navigateToEObject(eObject, targetAttributePath);
								if (attributeTarget.eObject == null || attributeTarget.eAttribute == null)
									continue;
								EAttribute eAttribute = attributeTarget.eAttribute;

								if (targetEqualsToValue != null) {
									// handle only single-valued attributes
									String auxValue = (String) attributeTarget.eObject.eGet(eAttribute);
									if (FSMLEcoreUtil.valuesEqual(targetEqualsToValue, auxValue)) {
										checkConstraintHelper(newConcreteClassInstance, feature,
												attributePath, equalsToValue,
												attributeTarget.eObject);
										break;
									}
								}
							}

						}
						
					}
				//} //end if (parentEObject)
			}//end if (!foundTargetObject)
			return true;
		}
		return false;
	}

	//this helper method sets the context for checkConstraints
	private void checkConstraintHelper(EObject newConcreteClassInstance, EReference feature,
			String attributePath, String equalsToValue, EObject parentCandidate)
			throws FSMLMappingException {
		List<IMarker> markers = Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId(parentCandidate, null));
		if (markers.size()!=0){
			try {
				int markerStartPos = ((Integer)markers.get(0).getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START)).intValue();
				int markerEndPos = ((Integer)markers.get(0).getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END)).intValue();
				if (markers.get(0).getResource().getFileExtension().equals("xml")){
					Queries.INSTANCE.associateContext(markerStartPos,markerEndPos,parentCandidate);
					EList<EStructuralFeature> allStructuralFeatures = parentCandidate.eClass().getEAllStructuralFeatures();
					for (EStructuralFeature structuralFeature : allStructuralFeatures) {
						if (structuralFeature.getEType().equals(feature.getEType())){
							if (structuralFeature.isMany())
								((EList) parentCandidate.eGet(structuralFeature)).add(newConcreteClassInstance);
							else
								parentCandidate.eSet(structuralFeature, newConcreteClassInstance);					

							FSMLEcoreUtil.NavigationResult attributeTarget = FSMLEcoreUtil.navigateToEObject(newConcreteClassInstance, attributePath);
							if (attributeTarget.errorMessage != null) 
								throw new FSMLMappingException(Cause.MODEL_NAVIGATION_ERROR, feature, attributeTarget.errorMessage);
							EAttribute eAttribute = attributeTarget.eAttribute;
							attributeTarget.eObject.eSet(eAttribute,equalsToValue);

						}
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
		}
	}
}

