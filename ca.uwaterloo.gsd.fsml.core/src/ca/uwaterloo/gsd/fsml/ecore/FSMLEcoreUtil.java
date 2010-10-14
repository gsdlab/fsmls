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
package ca.uwaterloo.gsd.fsml.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationResult;

/**
 * Useful functions for manipulation and querying Ecore metamodels for FSMLs.
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class FSMLEcoreUtil {
	/**
	 * constants for feature models
	 */
	public static final String ESSENTIAL = "essential";
	public static final String PARENT_KEY = "parentKey";
	public static final String KEY = "key";
	public static final String INDEX_KEY = "indexKey";
	public static final String FEATURE_GROUP = "featureGroup";
	public static final String LOWER_BOUND = "lowerBound";
	public static final String UPPER_BOUND = "upperBound";
	public static final String EQUAL_TO = "equalTo";
	
	/**
	 * navigation error messages
	 */
	public static final String NAVIGATION_ERROR_TARGET_OBJECT_DOES_NOT_EXIST = "Target object does not exist";
	
	public static class NavigationResult {
		public NavigationResult(EObject eObject, EAttribute eAttribute) {
			this.eObject = eObject;
			this.eAttribute = eAttribute;
		}
		public NavigationResult(String errorMessage) {
			this.eObject = null;
			this.eAttribute = null;
			this.errorMessage = errorMessage;
		}
		public EObject eObject;
		public EAttribute eAttribute;
		public EReference eReference;
		public String errorMessage;
		
		public boolean hasError() {
			return errorMessage != null;
		}
		public boolean isPresent() {
			if (eObject != null) {
				if (eAttribute != null && eAttribute.getEType().getName().equals("EBoolean") && (Boolean) eObject.eGet(eAttribute))
					return true;
				if (eAttribute != null && !eAttribute.getEType().getName().equals("EBoolean") && eObject.eGet(eAttribute) != null)
					return true;
				if (eReference != null && eObject.eGet(eReference) != null && !((EList) eObject.eGet(eReference)).isEmpty())
					return true;
				// otherwise the eObject is the actual return
				return eReference == null && eAttribute == null;
			}
			return false;
		}
	}

	/**
	 * @param start 
	 * @param path - navigation path in the form (../)*(<containmentFeatureName>/)*[<attributeName>]  e.g., "../../child/attribute1"
	 * @return target EObject and EAttribute e.g., EObject contained by 'child' and EAttribute 'attribute1'. 
	 */
	public static FSMLEcoreUtil.NavigationResult navigateToEObject(EObject start, final String path) {
		FSMLEcoreUtil.NavigationResult result = new FSMLEcoreUtil.NavigationResult(start, null);
		
		String workingPath = path;
		if (workingPath.startsWith("./"))
			workingPath = workingPath.substring(2);
		
		// always substract first "../" 
		if (workingPath.startsWith("../"))
			workingPath = workingPath.substring(3);
		
		// go up first
		while (result.eObject!= null && workingPath.startsWith("../")) {
			result.eObject = result.eObject.eContainer();
			workingPath = workingPath.substring(3);
		}
		// now go down again through containment references
		while (result.eObject != null && workingPath.indexOf('/') > 0) {
			int index = workingPath.indexOf('/');
			String containmentReferenceName = workingPath.substring(0, index);
			EStructuralFeature containmentFeature = FSMLEcoreUtil.getStructuralFeatureByName(result.eObject.eClass(), containmentReferenceName);
			if (containmentFeature.isMany())
				return new FSMLEcoreUtil.NavigationResult("NavigationResult::navigateToEObject(" + start +", " + workingPath + "): cannot navigate through multivalue containment feature " + containmentFeature.getName());
			result.eObject = (EObject) result.eObject.eGet(containmentFeature);
			if (result.eObject == null)
				result.errorMessage = NAVIGATION_ERROR_TARGET_OBJECT_DOES_NOT_EXIST;
			workingPath = workingPath.substring(index+1);
		}
		
		if (result.eObject != null && workingPath.length() > 0) {
			EStructuralFeature auxFeature = FSMLEcoreUtil.getStructuralFeatureByName(result.eObject.eClass(), workingPath);
			if (auxFeature instanceof EAttribute)
				result.eAttribute = (EAttribute) auxFeature;
			else
				result.eReference = (EReference) auxFeature;
		}
		return result;
	}

	/**
	 * @param superClass
	 * @param includeSuperClass 
	 * @return collection of concrete subclasses of given superClass
	 * TODO: take external packages into account
	 */
	public static Collection<EClass> getSubclassesOfEClass(EClass superClass, boolean includeSuperClass) {
		Collection<EClass> subclasses = new ArrayList<EClass>();
		if (includeSuperClass && !superClass.isAbstract())
			subclasses.add(superClass);
		
		for (Object aux : superClass.getEPackage().getEClassifiers()) {
			if (aux instanceof EClass && aux != superClass) {
				EClass eClass = (EClass) aux;
				if (!eClass.isAbstract() && superClass.isSuperTypeOf(eClass))
					subclasses.add(eClass);
			}
		}
		return subclasses;
	}

	/**
	 * @param modelElement
	 * @param source
	 * @return EAnnotation for given modelElement. If modelElement is a class try retrieving the annotation from superclasses.
	 */
	public static EAnnotation getEAnnotation(EModelElement modelElement, String source) {
		EAnnotation annotation = modelElement.getEAnnotation(source);
		if (annotation != null)
			return annotation;
		
		// look for inherited annotations
		if (modelElement instanceof EClass) {
			EClass eClass = (EClass) modelElement;
			for (Object aux : eClass.getEAllSuperTypes()) {
				EClass superType = (EClass) aux;
				annotation = superType.getEAnnotation(source);
				if (annotation != null)
					return annotation;
			}
		}
		
		return annotation;
	}

	public static ArrayList<EAnnotation> getAllEAnnotations(EModelElement modelElement) {
		ArrayList<EAnnotation> result = new ArrayList<EAnnotation>();
		
		result.addAll(modelElement.getEAnnotations());
		
		// look for inherited annotations
		if (modelElement instanceof EClass) {
			EClass eClass = (EClass) modelElement;
			for (Object aux : eClass.getEAllSuperTypes()) {
				EClass superType = (EClass) aux;
				result.addAll(superType.getEAnnotations());
			}
		}
		return result;
	}

	public static EStructuralFeature getStructuralFeatureByName(EClass eClass, String name) {
		for (Object aux : eClass.getEAllStructuralFeatures()) {
			EStructuralFeature feature = (EStructuralFeature) aux;
			if (name.equals(feature.getName()))
				return feature;
		}
		return null;
	}

	public static boolean isEssential(EStructuralFeature feature) {
		return feature.getEAnnotation("essential") != null;
	}
	/**
	 * @param element
	 * @param essentialOnly specifies whether only missing essential features should cause false 
	 * @return false if 
	 * a) at least one mandatory feature is not present when essentialOnly = false (strong)
	 * b) at least one essential feature is not present when essentialOnly = true (weak)
	 * c) number of features does not satisfy group constraint for an essential feature group
	 */
	public static boolean checkMandatory(EObject element, boolean essentialOnly) {
		int featureCount = 0;
		for (Object aux : element.eClass().getEAllStructuralFeatures()) {
			EStructuralFeature feature = (EStructuralFeature) aux;
			if (isFeaturePresent(element, feature)) 
				featureCount++;
			else if (feature.getLowerBound() == 1 && essentialOnly && isEssential(feature)) {
				return false;
			}
		}
		EAnnotation featureGroup = element.eClass().getEAnnotation(FEATURE_GROUP);
		if (featureGroup != null) {
			String essentialDetail = (String) featureGroup.getDetails().get(ESSENTIAL);
			if (essentialDetail != null && essentialDetail.equals("true")) {
				int min = Integer.parseInt((String) featureGroup.getDetails().get(LOWER_BOUND));
				//int max = Integer.parseInt((String) featureGroup.getDetails().get(UPPER_BOUND));
				
				if (featureCount < min)
					return false;
			}
		}
		return true;
	}
	public static boolean isFeaturePresent(EObject element, EStructuralFeature feature) {
		if (feature.isMany()) {
			if (((EList)element.eGet(feature)).isEmpty())
				return false;
		}
		else {
			if (feature.getEType().getName().equals("EBoolean")) {
				if (!((Boolean) element.eGet(feature)).booleanValue())
					return false;
			}
			else if (element.eGet(feature) == null) {
				return false;
			}
		}
		return true;
	}
	public static EStructuralFeature findEStructuralFeatureWithAnnotations(EClass eClass, String [] annotations) {
		for (Object aux : eClass.getEAllStructuralFeatures()) {
			EStructuralFeature feature = (EStructuralFeature) aux;
			
			boolean hasAllAnnotations = true;
			for (String annotation : annotations)
				if (feature.getEAnnotation(annotation) == null) {
					hasAllAnnotations = false;
					break;
				}
			if (hasAllAnnotations)
				return feature;
		}
		return null;
	}

	public static EReference findReferenceWithAnnotation(EClass eClass, String annotation) {
		EReference result = null;
		for (Object aux : eClass.getEAllReferences()) {
			EReference reference = (EReference) aux;
			if (reference.getEAnnotation(annotation) != null) { 
				result = reference;
				break;
			}
		}
		return result;
	}
	public static void clearFeature(EObject element, EStructuralFeature feature) {
		if (feature.getEType().getName().equals("EBoolean")) {
			if (!feature.isMany())
				element.eSet(feature, false);
		}
		else {
			if (feature.isMany()) 
				element.eUnset(feature);
			else 
				element.eSet(feature, null);	
		}
	}
	public static EAnnotation getQueryAnnotation(EStructuralFeature feature) {
		for (Object aux : getAllEAnnotations(feature)) {
			EAnnotation annotation = (EAnnotation) aux;
			String source = annotation.getSource();
			// ignore key annotations
			if (source.equals(KEY))
				continue;
			// ignore essential
			if (source.equals(ESSENTIAL))
				continue;
			// ignore alias
			if (source.equals("baseConcept"))
				continue;
			// ignore constraint
			if (source.equals(EQUAL_TO))
				continue;
			// ignore subsumedBy
			if (source.equals(SUBSUMED_BY))
				continue;
			// is not of the above, so we assume it is a query annotation
			return annotation;
		}
		return null;
	}
	public static Collection<EAnnotation> getContextAnnotations(EClass eClass) {
		ArrayList<EAnnotation> result = new ArrayList<EAnnotation>();
		for (Object aux : getAllEAnnotations(eClass)) {
			EAnnotation annotation = (EAnnotation) aux;
			String source = annotation.getSource();
			// ignore key annotations
			if (source.equals(PARENT_KEY))
				continue;
			if (source.equals(INDEX_KEY))
				continue;
			// is not of the above, so we assume it is a query annotation
			result.add(annotation);
		}
		return result;
	}
	
	public static EReference findBaseConceptReference(EClass eClass) {
		EReference reference = FSMLEcoreUtil.findReferenceWithAnnotation(eClass, "baseConcept");
		if (reference != null && reference.isMany()) {
			Stats.INSTANCE.logError(eClass.getName() + "::" + reference.getName() + " base concept reference must not be multivalue!"); 
			return null;
		}
		return reference;
	}

	public static String computeAnnotationKey(EAnnotation annotation) {
		StringBuffer key = new StringBuffer();
		key.append(annotation.getSource());
		for (Object detailsEntry : annotation.getDetails()) {
			EStringToStringMapEntryImpl entry = (EStringToStringMapEntryImpl) detailsEntry;
			key.append("|key=" + entry.getTypedKey());
			key.append("|value=" + entry.getTypedValue());
		}
		return key.toString();
	}

	/**
	 * @param object 
	 * @param feature can be null if creating id for 
	 * @return generic Id for given FSML object. The id is constructed from values of key features. 
	 * Feature name is added as a suffix preceeded with "::". Id of a reference is the id of the target.
	 * Example:
	 * EditorPart (name <<key>>, qualifier <<key>>)  		--> EditorPart-name-qualifier
	 * EditorPart (name <<key>>, qualifier <<key>>), partId --> FSMLId(editorPart) + "::" + partId
	 * editor ListensToParts PartService (source, target)   --> ListensToParts-FSMLId(editor)-FSMLId(PartService)
	 */
	public static String getFSMLId(EObject object, EStructuralFeature feature) {
		if (object == null)
			return null;
		
		StringBuffer id = new StringBuffer();
		
		// append object's class
		EClass objectClass = object.eClass();
		id.append(objectClass.getName());
		
		// check if a class has 'indexKey' annotation
		if (objectClass.getEAnnotation(INDEX_KEY) != null) {
			
			EReference eContainingFeature = (EReference) object.eContainingFeature();
			if (eContainingFeature.getUpperBound() == -1 || eContainingFeature.getUpperBound() > 1) {
				EList container = (EList)  object.eContainer().eGet(eContainingFeature);
				id.append("#" + container.indexOf(object));
			}
			else {
				// wrong INDEX_KEY annotation but do not abort
				Stats.INSTANCE.logError("The annotation INDEX_KEY should only be put on multiple features. Fix the feature '" + object.eClass() + "::" + eContainingFeature.getName() +"'");
				id.append("#" + 1);
			}
		}
		
		// append values of key attributes
		boolean hasKeys = false;
		for (Object aux : objectClass.getEAllStructuralFeatures()) {
			EStructuralFeature auxFeature = (EStructuralFeature) aux;
			if (auxFeature.getEAnnotation(KEY) != null) {
				hasKeys = true;
				if (auxFeature instanceof EAttribute) {
					Object value = object.eGet(auxFeature);
					if (value != null)
						id.append("-" + value.toString());
					else 
						id.append("-null");
				}
				else if (auxFeature instanceof EReference) {
					EObject target = (EObject) object.eGet(auxFeature);
					if (target != null)
						id.append("-(" + getFSMLId(target, null) + ")");
					else
						id.append("-(null)");
				}
			}
		}
		if (!hasKeys || objectClass.getEAnnotation(PARENT_KEY) != null)
			// use eContainer as a key
			if (object.eContainer() != null)
				id.append(">" + getFSMLId(object.eContainer(), object.eContainingFeature()) + "<");
			else
				Stats.INSTANCE.logBug("Parent feature missing when processing the key annotation PARENT_KEY");
		
		// append feature
		if (feature != null) {
			id.append("::" + feature.getName());
		}
		return id.toString();
	}

	public static String getFSMLId(EObject object, EStructuralFeature feature, Object value) {
		String id = getFSMLId(object, feature);
		
		return value == null ? id : id +"(" + value +")";
	}
	public static void createFsmlId2EObjectMap(Model model, HashMap<String, EObject> fsmlId2feature) {
		TreeIterator iterator = EcoreUtil.getAllContents(model, true);
		for (; iterator.hasNext();) {
			EObject eObject = (EObject) iterator.next();
			String fsmlId = FSMLEcoreUtil.getFSMLId(eObject, null);
			fsmlId2feature.put(fsmlId, eObject);
		}
	}

	public static EObject retrieveContextElement(EObject element, String contextId) {
		EObject aux = element;
		while (aux != null && FSMLEcoreUtil.getEAnnotation(aux.eClass(), contextId) == null) {
			aux = aux.eContainer();
		}
		return aux;
	}
	/**
	 * @return Traverse the sync items tree towards the root starting from @param classSyncItem and return EObject annotated with the
	 * given @param contextId.
	 * Objects from the implementation model take precedence.
	 */
	public static EObject retrieveContextElement(SyncItem syncItem, String contextId) {
		ClassSyncItem aux = (ClassSyncItem) (syncItem instanceof ClassSyncItem ? syncItem : syncItem.eContainer());
		
		while (true) {
			EObject element = aux.getCode() != null ? aux.getCode() : aux.getModel();
			if (FSMLEcoreUtil.getEAnnotation(element.eClass(), contextId) != null)
				return element;
			if (aux.eContainer() instanceof SynchronizationResult)
				return null;
			aux = (ClassSyncItem) aux.eContainer();
		}
	}
	
	
	public static HashMap<String, String> parameterValuesFromRecommenderSystem = new HashMap<String, String>();
	
	public static String retrieveParameterValue(EAnnotation annotation, String detailName, boolean isRequired) throws FSMLMappingException {
		String value = annotation.getDetails().get(detailName);
		String parameterValueFromRecommenderSystem=parameterValuesFromRecommenderSystem.get(detailName);
		if (parameterValueFromRecommenderSystem!=null){
			value = parameterValueFromRecommenderSystem;
		}
		if (value == null && isRequired)
			throw new FSMLMappingException(Cause.MISSING_PARAMETER, detailName);
		return value;
	}
	public static String retrieveParameterValue(EAnnotation annotation, String detailName, String defaultValue) {
		String value = annotation.getDetails().get(detailName);
		String parameterValueFromRecommenderSystem=parameterValuesFromRecommenderSystem.get(detailName);
		if (parameterValueFromRecommenderSystem!=null){
			value = parameterValueFromRecommenderSystem;
		}
		if (value == null)
			return defaultValue;
		return value;
	}

	public static EClass getEClassByName(String className, EPackage ePackage) {
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass eClass = ((EClass) classifier);
				if (eClass.getName().equals(className))
					return eClass;
			}
		}
		return null;
	}

	public static boolean valuesEqual(Object value1, Object value2) {
		if (value1 instanceof String && value2 instanceof String)
			return ((String) value1).equals(value2);
		if (value1 instanceof Boolean && value2 instanceof Boolean)
			return ((Boolean) value1).equals(value2);
		if (value1 instanceof Integer && value2 instanceof Integer)
			return ((Integer) value1).equals(value2);
		
		return value1 == value2;
	}
	/**
	 * Subsumed by relationship: 
	 * 
	 * f <subsumedBy: a/b/c>
	 * 
	 * Interpretation. Not used in reverse engineering. In forward engineering used
	 * to decide whether a feature (f in the example) should be forwarded. In the example,
	 * the feature f will only be forwarded if c is not present.  
	 */
	public static final String SUBSUMED_BY = "subsumedBy";
	public static final String DETAIL_FEATURE = "feature";
	/**
	 * @param eObject
	 * @param modelElement
	 * @return true iff 1) the subsumedBy constraint is present AND 2) the subsuming feature is present
	 */
	public static boolean isSubsumingFeaturePresent(EObject eObject, EModelElement modelElement) {
		// check the SUBSUMED_BY constraint
		EAnnotation subsumedByAnnotation = FSMLEcoreUtil.getEAnnotation(modelElement, SUBSUMED_BY);
		if (subsumedByAnnotation != null) {
			try {
				String subsumingFeature = FSMLEcoreUtil.retrieveParameterValue(subsumedByAnnotation, DETAIL_FEATURE, true);
				// navigate to the subsuming feature from the element
				NavigationResult navigationResult = navigateToEObject(eObject, subsumingFeature); 
				
				if (navigationResult.errorMessage == null) {
					if (navigationResult.eAttribute != null) {
						if (isFeaturePresent(navigationResult.eObject, navigationResult.eAttribute))
							return true;
					}
					else {
						// so the eObject is present
						return true;
					}
				}
			} catch (FSMLMappingException e) {
				e.printStackTrace();
			}
		} 
		return false;
	}
	
	/**
	 * Recursively instantiates the subtree of the provided feature. Creates the minimum
	 * number of instances stipulated by the cardinality constraint. 
	 * @param feature
	 */
	public static EObject instantiateSubtree(EObject feature) {
		EClass eClass = feature.eClass();
		
		if (getEAnnotation(eClass, FEATURE_GROUP) != null)
			return feature;
		
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature.getLowerBound() > 0) {
				if (eStructuralFeature instanceof EAttribute) {
					if (eStructuralFeature.getEType().getName().equals("EBoolean")) 
						feature.eSet(eStructuralFeature, true);
				}
				else if (eStructuralFeature instanceof EReference && ((EReference)eStructuralFeature).isContainment()) {
					EObject subfeature = EcoreUtil.create((EClass) eStructuralFeature.getEType());
					if (eStructuralFeature.isMany())
						((EList)feature.eGet(eStructuralFeature)).add(subfeature);
					else
						feature.eSet(eStructuralFeature, subfeature);
					instantiateSubtree(subfeature);
				}
			}
		}
		return feature;
	}
	
	public static Object getAttributeValueFromAttributeValueWizard(EAttribute attribute) {
		final EcoreAttributeValueWizard wizard = new EcoreAttributeValueWizard();
		wizard.init(PlatformUI.getWorkbench(),attribute);
		wizard.addEcoreFmpTypeSelectionWizardPage(new EcoreAttributeValuePage("Attribute Value Selection",attribute)); 
		// Instantiates the wizard container with the wizard and opens it WizardDialog
		Display.getDefault().syncExec(new Runnable() {
					 public void run() {
					 	WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), wizard);
						dialog.create(); 
						dialog.open();
					 }
		});
	
		return wizard.getReturnValue().equals(EcoreAttributeValueWizard.WIZARD_CANCELED) ? null : wizard.getReturnValue();
	}
	public static String getAttributeValueWithSuggestionsWizard(Collection<EObject> eObjects, Collection<EAttribute> eAttributes) {
		final EcoreAttributeValueWithSuggestionWizard wizard = new EcoreAttributeValueWithSuggestionWizard();
		wizard.init(PlatformUI.getWorkbench());
		wizard.addEcoreFmpTypeSelectionWizardPage(new EcoreAttributeValueWithSuggestionsPage("Attribute Value Selection",eObjects,eAttributes)); 
		// Instantiates the wizard container with the wizard and opens it WizardDialog
		Display.getDefault().syncExec(new Runnable() {
					 public void run() {
					 	WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), wizard);
						dialog.create(); 
						dialog.open();
					 }
		});
	
		return wizard.getReturnValue().equals(EcoreAttributeValueWizard.WIZARD_CANCELED) ? null : wizard.getReturnValue();
	}
	public static Object getChoiceFromFeatureGroup(EList<EStructuralFeature>  structuralFeatures) {
		final EcoreFeatureGroupWizard wizard = new EcoreFeatureGroupWizard();
		wizard.init(PlatformUI.getWorkbench());
		wizard.addEcoreFmpTypeSelectionWizardPage(new EcoreFeatureGroupPage("Attribute Value Selection",structuralFeatures)); 
		// Instantiates the wizard container with the wizard and opens it WizardDialog
		Display.getDefault().syncExec(new Runnable() {
					 public void run() {
					 	WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), wizard);
						dialog.create(); 
						dialog.open();
					 }
		});
	
		return wizard.getReturnValue().equals(EcoreAttributeValueWizard.WIZARD_CANCELED) ? null : wizard.getReturnValue();
	}

}
