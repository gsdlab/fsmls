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
package ca.uwaterloo.gsd.fsml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jdt.core.JavaModelException;

import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil.NavigationResult;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.stats.Measurements;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.RA;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 * 
 * A singleton class. Implements a generic FSML reverse engineering algorithm and supports incremental forward engineering. 
 * Supports custom FSML annotation interpreters.
 * 
 * TODO: need to distinguish between incremental and non-incremental forward and reverse. 
 * Currently reverse is batch and forward is incremental.
 */
public class Queries {
	/**
	 * Annotation used on non-containment references to indicate the base concept reference
	 */
	public static final String BASE_CONCEPT = "baseConcept";
	
	/**
	 * Constants for constraint mappings
	 */
	public static final String DETAIL_INSTANCE_OF = "instanceOf";
	public static final String CONSTRAINT_AND = "and";
	public static final String CONSTRAINT_AND_PARENT_IS = "andParentIs";
	public static final String DETAIL_CONTAINS = "contains";
	public static final String DETAIL_EQUALS_TO = "equalsTo";
	public static final String DETAIL_ATTRIBUTE = "attribute";
	public static final String DETAIL_IN = "in";
	public static final String CONSTRAINT_WHERE = "where";
	public static final String CONSTRAINT_CONCATENATE = "concatenate";
	public static final String DETAIL_STRING = "string";
	public static final String DETAIL_ELEMENT = "element";
	public static final String DETAIL_POSITION = "position";
	public static final String CONSTRAINT_VALUE_OF = "valueOf";
	public static final String DETAIL_CLASS = "class";
	public static final String DETAIL_VALUE_BEFORE = "before";
	public static final String DETAIL_VALUE_AFTER = "after";
	
	/**
	 * <constraint feature: ../../x requires: ../y >
	 * <constraint feature: ../../x excludes: ../y >
	 */
	public static final String CONSTRAINT_REQUIRES_EXCLUDES = "constraint";
	public static final String DETAIL_FEATURE = "feature";
	public static final String DETAIL_REQUIRES = "requires";
	public static final String DETAIL_EXCLUDES = "excludes";
	/**
	 * some keys for performance measurements
	 */ 
	public static final String ANALYSIS_KEY = "Queries.Analysis";
	
	public static Queries INSTANCE = new Queries();

	/**
	 * The project being processed
	 */
	protected IProject project;
	private HashMap<EObject, IProject> feature2IProject;
	
	private Queries() {
	}

	/**
	 * @param project
	 * @param natureId
	 * @return true iff project has nature with natureId.
	 */
	public static boolean hasNature(IProject project, String natureId) {
		try {
			String[] natures = project.getDescription().getNatureIds();
			for (int i = 0; i < natures.length; i++)
				if (natures[i].compareTo(natureId) == 0)
					return true;
		} catch (CoreException e) {
		}
		return false;
	}

	/**
	 * This clears all cache data and configures Queries with given project. If
	 * project doesn't have required nature, all cache data is reset and null
	 * project is set.
	 * 
	 * @param project
	 */
	public void setProject(IProject project) {
		this.project = project;
		Markers.INSTANCE.setProject(project);
		
		reset();
	}
	
	
	public IProject getProject() {
		return project;
	}
	

	/**
	 * clear cache for annotation interpreters and registers new JavaAnnotationInterpreter (which
	 * effectively clears the cache of the interpreter too).
	 */
	public void reset() {
		// clear cache
		mappingInterpreters = new ArrayList<FSMLMappingInterpreter>();
		query2interpreter = new HashMap<String, FSMLMappingInterpreter>();
		context2interpreters = new HashMap<String, Collection<FSMLMappingInterpreter>>();
	}

	/**
	 * This method MUST be called by any project specific analysis method
	 * because it sets up annotation cache and initializes context element maps.
	 * This method is not intended to be overriden. 
	 * Override doPerformAnalysis instead.
	 * 
	 * @param model
	 * @param progressMonitor
	 * @return
	 */
	public final Model performAnalysis(Model model, IProgressMonitor progressMonitor) {
		Stats.INSTANCE.reset();
		Markers.INSTANCE.removeMarkers();

		Stats.INSTANCE.printMessage("Analysis results and statistics for the project '" + project.getName() + "'\n");
		
		Measurements.instance(ANALYSIS_KEY).start();
		
		// initialize all registered mapping interpreters
		if (!initialize(project, model))
			// at least one of the interpreters failed to initialize
			return model;
		try {
			try {
				if (reverseFeatureRepresentedAsClass(model, progressMonitor))
					Stats.INSTANCE.logFeatureInstance(model, null, model.eClass().getEAnnotation("project"));
			} catch (FSMLMappingException e) {
				e.printStackTrace();
			}
	
			// process model queries to set values of non-containment and non-alias references
			
			try {
				processRegularReferences(model);
			} catch (FSMLMappingException e) {
				e.printStackTrace();
			}
		}
		// need to finalize regardless of what exception was thrown
		finally {
			// notify mapping interpreters that the analysis has ended
			terminate(progressMonitor);
		}
		
		Measurements.instance(ANALYSIS_KEY).stop();
		Measurements.instance(ANALYSIS_KEY).printAndReset("Time of reverse engineering : ");
		
		Stats.INSTANCE.printAll();
		return model;
	}

	protected void processRegularReferences(EObject element) throws FSMLMappingException {
		if (element == null)
			return;
		for (Object aux : element.eClass().getEAllReferences()) {
			EReference feature = (EReference) aux;
			if (!feature.isContainment() && feature.getEAnnotation(BASE_CONCEPT) == null) {
				EAnnotation annotation = feature.getEAnnotation(CONSTRAINT_WHERE);
				if (annotation != null) {
					// find potential targets
					Collection<EObject> targets = ItemPropertyDescriptor.getReachableObjectsOfType(
						element, feature.getEReferenceType());
	
					String attributePath = (String) annotation.getDetails().get(DETAIL_ATTRIBUTE);
					if (attributePath == null)
						continue;
					
					String equalsToPath = (String) annotation.getDetails().get(DETAIL_EQUALS_TO);
					String containsPath = (String) annotation.getDetails().get(DETAIL_CONTAINS);
					String inPath = (String) annotation.getDetails().get(DETAIL_IN);
					if (equalsToPath == null && containsPath == null && inPath == null)
						continue;
					
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
						continue; 
					}
										
					if (equalsToValue == null && (equalsToList == null|| equalsToList.isEmpty())){
						continue;
					}
					assert (attributePath != null);
	
					// check for an additional 'andWhere' clause
					EAnnotation and = feature.getEAnnotation(CONSTRAINT_AND);
					String attribute2Path = null;
					String equalsTo2Path = null;
					String equalsTo2Value = null;
					if (and != null) {
						attribute2Path = (String) and.getDetails().get(DETAIL_ATTRIBUTE);
						equalsTo2Path = (String) and.getDetails().get(DETAIL_EQUALS_TO);
						FSMLEcoreUtil.NavigationResult target2 = FSMLEcoreUtil.navigateToEObject(element, equalsTo2Path);
						equalsTo2Value = (String) target2.eObject.eGet(target2.eAttribute);
					}
					EAnnotation andParentIs = feature.getEAnnotation(CONSTRAINT_AND_PARENT_IS);
					String parentClassName = null;
					if (andParentIs != null)
						parentClassName = (String) andParentIs.getDetails().get(DETAIL_INSTANCE_OF);
					
					// find the first target satisfying the constraint
					for (Object object : targets) {
						if (object instanceof EObject) {
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
								if (FSMLEcoreUtil.valuesEqual(equalsToValue, auxValue)) {
									if (and != null) {
										FSMLEcoreUtil.NavigationResult target3 = FSMLEcoreUtil.navigateToEObject(eObject, attribute2Path);
										if (target3.eObject == null || target3.eAttribute == null)
											continue;
										//FSMLEcoreUtil.NavigationResult attribute2Target = FSMLEcoreUtil.navigateToEObject(element, attribute2Path);
										EAttribute eAttribute2 = target3.eAttribute;
										String auxValue2 = (String) target3.eObject.eGet(eAttribute2);
										
										if (!FSMLEcoreUtil.valuesEqual(equalsTo2Value, auxValue2))
											continue;
									}
									if (andParentIs != null) {
										if (!eObject.eContainer().eClass().getName().equals(parentClassName))
											continue;
									}
									
									if (feature.isMany())
										((EList) element.eGet(feature)).add(eObject);
									else {
										element.eSet(feature, eObject);
										break;
									}
								}
							}
							else if (containsPath != null) {
								// handle only multi-valued attributes
								if (attributeTarget.errorMessage != null)
									throw new FSMLMappingException(Cause.MODEL_NAVIGATION_ERROR, attributeTarget.errorMessage);
								else {
									EList auxValues = (EList) attributeTarget.eObject.eGet(attributeTarget.eAttribute);
									if (auxValues.contains(equalsToValue)) {
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
									if (feature.isMany())
										((EList) element.eGet(feature)).add(eObject);
									else {
										element.eSet(feature, eObject);
										break;
									}
								}
							}
						}
					}
				}
			}
			else {
				// recursively process children
				if (feature.isMany()) {
					for (Object child : (EList) element.eGet(feature)) {
						processRegularReferences((EObject) child);
					}
				}
				else 
					processRegularReferences((EObject) element.eGet(feature));
			}
		}
	}

	public boolean createChildrenForBaseConceptReference(EObject element, EReference feature, EClass concreteChildType, EReference baseConceptReference, IProgressMonitor progressMonitor) throws FSMLMappingException {
		if (concreteChildType == null || baseConceptReference == null)
			return false;

		// find potential targets
		Collection<EObject> targets = ItemPropertyDescriptor.getReachableObjectsOfType(element, baseConceptReference.getEReferenceType());

		if (feature.isMany()) {
			EList children = (EList) element.eGet(feature);
			for (Object target : targets) {
				EObject child = EcoreUtil.create(concreteChildType);
				children.add(child);

				// assuming that the reference is not multivalue
				child.eSet(baseConceptReference, target);

				EAnnotation annotation = baseConceptReference.getEAnnotation(BASE_CONCEPT);
				//Stats.INSTANCE.logFeatureInstance(concreteChildType, baseConceptReference, "(target set)");

				boolean aliased = false;
				for (Object aux : FSMLEcoreUtil.getContextAnnotations(concreteChildType)) {
					String name = ((EAnnotation) aux).getSource();
					
					Collection<FSMLMappingInterpreter> interpreters = context2interpreters.get(name);
					if (interpreters != null && !interpreters.isEmpty()) {
						for (FSMLMappingInterpreter interpreter : interpreters)
							if (interpreter.aliasContext((EObject) target, child))
								aliased = true;
					}	
				}

				if (aliased) {
					if (reverseFeatureRepresentedAsClass(child, progressMonitor)) {
						Stats.INSTANCE.logFeatureInstance(child, baseConceptReference, annotation);
						Stats.INSTANCE.logFeatureInstance(element, feature, null);
					}
				}
			}
		}
		return (feature.isMany() ? !((EList) element.eGet(feature)).isEmpty()
				: element.eGet(feature) != null);
	}

	Collection<FSMLMappingInterpreter> mappingInterpreters = new ArrayList<FSMLMappingInterpreter>();
	HashMap<String, FSMLMappingInterpreter> query2interpreter = new HashMap<String, FSMLMappingInterpreter>();
	HashMap<String, Collection<FSMLMappingInterpreter>> context2interpreters = new HashMap<String, Collection<FSMLMappingInterpreter>>();

	public void registerCustomInterpreter(FSMLMappingInterpreter interpreter) {
		if (interpreter != null) {
			mappingInterpreters.add(interpreter);
			for (String context : interpreter.getContextAnnotations()) {
				Collection<FSMLMappingInterpreter> interpreters = context2interpreters.get(context);
				if (interpreters == null) {
					interpreters = new ArrayList<FSMLMappingInterpreter>();
					context2interpreters.put(context, interpreters);
				}
				interpreters.add(interpreter);
			}
			for (String query : interpreter.getQueryAnnotations()) {
				FSMLMappingInterpreter existingInterpreter = query2interpreter.get(query);
				if (existingInterpreter == null || interpreter.getDescription().equals(existingInterpreter.getDescription())) {
					query2interpreter.put(query, interpreter);
				}
				else
					Stats.INSTANCE.logError("Critical error: at most one interpreter for query annotation! Tried to register query '" + query + "' of " + interpreter.getDescription() + " ");
			}
		}
	}

	public boolean initialize(IProject project, Model model) {
		feature2IProject = new HashMap<EObject, IProject>();
		feature2IProject.put(model, project);
		
		for (FSMLMappingInterpreter interpreter : mappingInterpreters)
			if (!interpreter.initialize(project, model)) {
				Stats.INSTANCE.logError("FSML annotation interpreter failed to initialize: " + interpreter.getDescription());
				return false;
			}
		return true;
	}
	public void terminate(IProgressMonitor progressMonitor) {
		for (FSMLMappingInterpreter interpreter : mappingInterpreters)
			interpreter.terminate(progressMonitor);
	}
	/**
	 * @param eObject
	 * @param contextClass
	 * @param required TODO
	 * @return context object returned by the first interpreter that can handle given contextClass type. 
	 */
	public Object getContext(EObject eObject, Class contextClass, boolean required) {
		EObject element = eObject;
		if (eObject instanceof SyncItem) {
			SyncItem syncItem = (SyncItem) eObject;
			element = (syncItem.getCode() != null ? syncItem.getCode() : syncItem.getModel());
		}
		if (IProject.class.equals(contextClass))
			return feature2IProject.get(element);
		
		for (FSMLMappingInterpreter interpreter : mappingInterpreters) {
			if (interpreter.canHandleContext(contextClass)) {
				Object context = interpreter.getContext(element, contextClass, required);
				if (context != null)
					return context;
				// keep looking
			}
		}
		return null;
	}
	/**
	 * Associate given context with eObject using every interpreter which can handle the context.
	 * @param eObject
	 * @param context
	 */
	public void associateContext(EObject eObject, Object context) {
		if (context instanceof IProject)
				feature2IProject.put(eObject, (IProject) context);
		
		for (FSMLMappingInterpreter interpreter : mappingInterpreters) {
			if (interpreter.canHandleContext(context.getClass()))
				interpreter.associateContext(eObject, context);
		}
	}

	public void associateContext(int start, int end, EObject eObject) {
		for (FSMLMappingInterpreter interpreter : mappingInterpreters) {
			if (interpreter.canAssociateContext(eObject))
				interpreter.associateContext(start,end,eObject);
		}
	}
	
	/**
	 * @param element
	 * @param progressMonitor
	 * @return true iff element is correct
	 * @throws JavaModelException
	 * @throws FSMLMappingException 
	 */
	public boolean reverseFeatureRepresentedAsClass(EObject element, IProgressMonitor progressMonitor) throws FSMLMappingException {
		// Stats.INSTANCE.printMessage("Reversing: " + element.eClass().getName());
	
		for (Object aux : element.eClass().getEAllStructuralFeatures()) {
			EStructuralFeature feature = (EStructuralFeature) aux;
			boolean featureIsEssential = FSMLEcoreUtil.isEssential(feature);
	
			// break the loop is an essential feature was not found
			if (feature instanceof EAttribute) {
				if (!reverseFeatureRepresentedAsAttribute(element, (EAttribute) feature, progressMonitor)) {
					FSMLEcoreUtil.clearFeature(element, feature);
					if (featureIsEssential)
						break;
				}
			} else if (feature instanceof EReference && feature.getEAnnotation(Queries.BASE_CONCEPT) == null) {
				if (!reverseFeatureRepresentedAsReference(element, (EReference) feature, progressMonitor)) {
					FSMLEcoreUtil.clearFeature(element, feature);
					if (featureIsEssential)
						break;
				}
			}
		}
		// remove the element if essential feature missing
		if (!FSMLEcoreUtil.checkMandatory(element, true)) {
			removeContext(element);
			EcoreUtil.remove(element);
			return false;
		}
		// set the marker only if the child has not been removed
		for (FSMLMappingInterpreter interpreter : mappingInterpreters) {
			if (interpreter.canCreateMarkerForElementRepresentedAsClass(element.eClass()))
				interpreter.createMarkerForFeatureRepresentedAsClass(element);
		}
		return true;
	}
	public void removeContext(EObject element) {
		for (FSMLMappingInterpreter interpreter : mappingInterpreters)
			interpreter.removeContext(element);
	}

	/**
	 * @return true iff feature is present
	 * @throws FSMLMappingException 
	 */
	public boolean reverseFeatureRepresentedAsAttribute(EObject element, EAttribute feature, IProgressMonitor progressMonitor)
			throws FSMLMappingException {
		// Stats.INSTANCE.printMessage("Reversing: " + element.eClass().getName() + "::" + feature.getName());
		EAnnotation annotation = feature.getEAnnotation(CONSTRAINT_VALUE_OF);
		EAnnotation whereAnnotation = feature.getEAnnotation(CONSTRAINT_WHERE);
		if (annotation != null && whereAnnotation != null) {
			// value of this attribute is the same as a value of another one.
			// Example: 
			// [0..1] name : String <valueOf attribute: input class: ActionDecl> <where attribute: type equalsTo: ../../qualifiedName>
			
			String detailAttribute = FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_ATTRIBUTE, true);
			String detailClass = FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_CLASS, true);
			
			EClass elementClass = FSMLEcoreUtil.getEClassByName(detailClass, element.eClass().getEPackage());
			
			String detailWhereAttribute = FSMLEcoreUtil.retrieveParameterValue(whereAnnotation, DETAIL_ATTRIBUTE, true);
			String detailWhereEqualsTo = FSMLEcoreUtil.retrieveParameterValue(whereAnnotation, DETAIL_EQUALS_TO, true);
			
			NavigationResult requiredValueTarget = FSMLEcoreUtil.navigateToEObject(element, detailWhereEqualsTo);
			if (requiredValueTarget.errorMessage != null)
				throw new FSMLMappingException(Cause.MODEL_NAVIGATION_ERROR, feature, requiredValueTarget.errorMessage);
			
			Object requiredValue = requiredValueTarget.eObject.eGet(requiredValueTarget.eAttribute);  
			// find potential targets
			Collection<EObject> targets = ItemPropertyDescriptor.getReachableObjectsOfType(element, elementClass);
			for (EObject target : targets) {
				EAttribute whereAttribute = (EAttribute) FSMLEcoreUtil.getStructuralFeatureByName(target.eClass(), detailWhereAttribute);
				Object whereAttributeValue = target.eGet(whereAttribute);
				
				if (FSMLEcoreUtil.valuesEqual(requiredValue, whereAttributeValue)) {
					EAttribute valueAttribute = (EAttribute) FSMLEcoreUtil.getStructuralFeatureByName(target.eClass(), detailAttribute);
					Object value = target.eGet(valueAttribute);
					element.eSet(feature, value);
					Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
					return true;
				}
			}
			// did not find any matches
			return false;
		}
		annotation = feature.getEAnnotation(CONSTRAINT_CONCATENATE);
		if (annotation != null && feature.getEType().getName().equalsIgnoreCase("EString")){
			String detailElement = FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_ELEMENT, true);
			String detailString = FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_STRING, true);
			String detailPosition = FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_POSITION, false);
			NavigationResult requiredValueTarget = FSMLEcoreUtil.navigateToEObject(element, detailElement);
			if (requiredValueTarget.errorMessage != null)
				throw new FSMLMappingException(Cause.MODEL_NAVIGATION_ERROR, feature, requiredValueTarget.errorMessage);
	
			Object requiredValue = requiredValueTarget.eObject.eGet(requiredValueTarget.eAttribute);
			if (requiredValue instanceof String){
				StringBuffer sb = new StringBuffer();
				if (DETAIL_VALUE_BEFORE.equalsIgnoreCase(detailPosition)){
					sb.append(detailString);
					sb.append(requiredValue.toString());
				}
				else if (DETAIL_VALUE_AFTER.equalsIgnoreCase(detailPosition)){
					sb.append(requiredValue.toString());
					sb.append(detailString);
				}
				else
					return false; 
				element.eSet(feature, sb.toString());
				Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
				return true;
			}
			else
				return false; 	
		}
		annotation = feature.getEAnnotation(CONSTRAINT_REQUIRES_EXCLUDES);
		if (annotation != null && feature.getEType().getName().equalsIgnoreCase("EBoolean")){
			String detailFeature = FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_FEATURE, true);
			String detailRequires = FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_REQUIRES, false);
			String detailExcludes = FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_EXCLUDES, false);
			if (detailRequires == null && detailExcludes == null ||
				detailRequires != null && detailExcludes != null)
				throw new FSMLMappingException(Cause.MISSING_PARAMETER, feature, "Exactly one of " + DETAIL_REQUIRES + " or " + DETAIL_EXCLUDES + " is required");
			
			NavigationResult requireingOrExcludingFeature = FSMLEcoreUtil.navigateToEObject(element, detailFeature);
			if (!requireingOrExcludingFeature.isPresent())
				// the feature is not instantiated and therefore the implies/excludes constraint is satisfied (false -> x is true for every x)
				return true;
			
			if (detailRequires != null) {
				NavigationResult requiredFeature = FSMLEcoreUtil.navigateToEObject(element, detailRequires);
				// true if present
				return requiredFeature.isPresent();
			}
			else {
				// detailExcludes must not be null
				NavigationResult excludedFeature = FSMLEcoreUtil.navigateToEObject(element, detailExcludes);
				// true if missing
				return !excludedFeature.isPresent();
			}
		}
		
		// delegate to interpreters
		annotation = FSMLEcoreUtil.getQueryAnnotation(feature);
	
		if (annotation != null) {
			FSMLMappingInterpreter interpreter = query2interpreter.get(annotation.getSource());
			
			if (interpreter != null) {
				return interpreter.reverseFeatureRepresentedAsAttribute(element, feature, progressMonitor);
			}
			else
				Stats.INSTANCE.logError("None of registered mapping interpreters supports annotation: " + annotation.getSource());
		}
		// features without annotations should not influence the analysis (i.e.,
		// are always present)
		return true;
	}

	/**
	 * @return true iff feature is present
	 * @throws FSMLMappingException 
	 */
	public boolean reverseFeatureRepresentedAsReference(EObject element,
			EReference feature, IProgressMonitor progressMonitor)
			throws FSMLMappingException {
		// Stats.INSTANCE.printMessage("Reversing: " + element.eClass().getName() + "::"
		// + feature.getName());
	
		if (!feature.isContainment())
			return true;
		// clean the list only containment feature in order no to clean context
		// injection refs
		if (feature.isChangeable())
			element.eUnset(feature);
		else
			// we assume that non-changeable features are always present
			return true;
	
		EAnnotation annotation = FSMLEcoreUtil.getQueryAnnotation(feature);
	
		Collection<EClass> concreteClasses = FSMLEcoreUtil.getSubclassesOfEClass(feature.getEReferenceType(), true);
	
		ConcreteTypeLoop: for (EClass concreteChildType : concreteClasses) {
			if (annotation != null) {
				FSMLMappingInterpreter interpreter = query2interpreter.get(annotation.getSource());
				interpreter.reverseFeatureRepresentedAsReference(element, feature, concreteChildType, progressMonitor);
				continue ConcreteTypeLoop;
			}
	
			// so far, the feature did not have a supported annotation
	
			// children specified by default query
			{
				for (FSMLMappingInterpreter interpreter : mappingInterpreters) {
					if (interpreter.canCreateChildrenForDefaultQuery(concreteChildType)) {
						interpreter.createChildrenForDefaultQuery(element, feature, concreteChildType, progressMonitor);
						continue ConcreteTypeLoop;
					}
				}
			}
			// base concept references
			{
				EReference baseConceptReference = FSMLEcoreUtil.findBaseConceptReference(concreteChildType);
				if (baseConceptReference != null) {
					createChildrenForBaseConceptReference(element, feature, concreteChildType, baseConceptReference, progressMonitor);
					continue ConcreteTypeLoop;
				}
			}
			// no base reference, check for query features
			{
				FSMLMappingInterpreter interpreter = null;
				EStructuralFeature queryFeature = null;
				for (FSMLMappingInterpreter aux : mappingInterpreters) {
					queryFeature = aux.findQueryFeature(concreteChildType);
					if (queryFeature != null) {
						interpreter = aux;
						break;
					}
					else
						// reset the interpreter because it is not the correct
						// one
						interpreter = null;
				}
				if (queryFeature != null) {
					if (interpreter != null)
						interpreter.createChildrenForQueryFeature(element, feature,
								concreteChildType, queryFeature, progressMonitor);
					continue ConcreteTypeLoop;
				}
			}
			if (feature.isMany())
				for (int i = 0; i < feature.getLowerBound(); i++) {
					EObject child = EcoreUtil.create(concreteChildType);
					((EList) element.eGet(feature)).add(child);
	
					if (reverseFeatureRepresentedAsClass(child, progressMonitor))
						Stats.INSTANCE.logFeatureInstance(element, feature, null);
				}
			else {
				EObject child = EcoreUtil.create(concreteChildType);
				element.eSet(feature, child);
	
				if (reverseFeatureRepresentedAsClass(child, progressMonitor))
					Stats.INSTANCE.logFeatureInstance(element, feature, null);
			}
		}
	
		// features without annotations should not influence the analysis (i.e.,
		// are always present)
		if (feature.getEAnnotations().isEmpty())
			return true;
	
		if (feature.isMany())
			return !((EList) element.eGet(feature)).isEmpty();
		else
			return element.eGet(feature) != null;
	}
	/**
	 * Incremental - recursion is controlled by the reconcile action
	 * @throws FSMLMappingException 
	 */
	public boolean forwardFeatureRepresentedAsClass(ClassSyncItem classSyncItem, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject element = classSyncItem.getModel() != null ? classSyncItem.getModel() : classSyncItem.getCode();
		EClass eClass = element.eClass();
		EReference eReference = element.eContainmentFeature();
		
		EReference baseReference = FSMLEcoreUtil.findBaseConceptReference(eClass);
		if (baseReference != null)
			return true;
		
		// forward specified by a default query or a context annotation 
		{
			for (FSMLMappingInterpreter interpreter : mappingInterpreters) {
				boolean forwardUsingQuery = interpreter.canForwardObjectUsingQueryMapping(eReference);
				boolean forwardUsingContext = interpreter.canForwardObjectUsingContextMapping(eClass);
				
				// check the SUBSUMED_BY constraint
				if (forwardUsingQuery && FSMLEcoreUtil.isSubsumingFeaturePresent(element, eReference))
					// abort if the subsuming feature is present
					continue;
				if(forwardUsingContext && FSMLEcoreUtil.isSubsumingFeaturePresent(element, eClass))
					// abort if the subsuming feature is present
					continue;
					
				if (forwardUsingQuery && forwardUsingContext) {
					// at least one must succeed
					boolean querySuccess = interpreter.forwardFeatureRepresentedAsReference(classSyncItem, progressMonitor);
					boolean contextSuccess = interpreter.forwardFeatureRepresentedAsClass(classSyncItem, progressMonitor);
					return querySuccess || contextSuccess;
				}
				if (forwardUsingContext)
					return interpreter.forwardFeatureRepresentedAsClass(classSyncItem, progressMonitor);
				if (forwardUsingQuery)
					return interpreter.forwardFeatureRepresentedAsReference(classSyncItem, progressMonitor);
			}
		}
		return false;
	}
	/**
	 * Incremental - recursion is controlled by reconcile action
	 * @throws FSMLMappingException 
	 */
	public boolean forwardFeatureRepresentedAsAttribute(StructuralFeatureSyncItem featureSyncItem, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EAnnotation annotation = FSMLEcoreUtil.getQueryAnnotation(featureSyncItem.getStructuralFeature());
		
		if (annotation != null) {
			FSMLMappingInterpreter interpreter = query2interpreter.get(annotation.getSource());
			
			if (interpreter != null)
					return interpreter.forwardFeatureRepresentedAsAttribute(featureSyncItem, progressMonitor);
			else
				Stats.INSTANCE.logError("None of the registered mapping interpreters supports annotation: " + annotation.getSource());
		}
		return false;
	}
	/**
	 * Incremental - recursion is controlled by reconcile action
	 */
	public boolean forwardFeatureRepresentedAsReference(EObject modelObject, EReference feature, RA action, IProgressMonitor progressMonitor) {
		// a containment reference is never processed directly because each of its children is processed recursively
		// a non-containment reference is ignored during forward engineering since it expresses a referential integrity constraint
		// a base element reference is ignored during forward engineering because forward for its target is already performed
		return true;
	}
}
