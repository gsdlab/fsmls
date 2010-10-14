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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public abstract class Mapping {
	protected EObject element;
	protected SyncItem syncItem;
	protected EStructuralFeature feature;
	protected EStructuralFeature essentialFeature;
	protected EAnnotation annotation;
	protected EClass concreteChildType;
	protected FSMLMappingInterpreter interpreter;
	protected IProgressMonitor progressMonitor;
	protected Mode currentMode;
	
	/**
	 * in reverse engineering, child is created for containment references in @see setFeature()
	 */
	protected EObject child;
	
	/**
	 * Constructor used in reverse engineering.
	 * @param element
	 * @param feature
	 * @param annotation
	 * @param concreteChildType
	 * @param interpreter
	 * @param progressMonitor
	 * @throws FSMLMappingException
	 */
	public Mapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, FSMLMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		currentMode = Mode.REVERSE;
		
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);

		this.element = element;
		this.syncItem = null;
		this.feature = feature;
		this.annotation = annotation;
		this.concreteChildType = concreteChildType;
		this.interpreter = interpreter;
		this.progressMonitor = progressMonitor;
		
		processFields();
	}
	/**
	 * Constructor used in reverse engineering using an essential feature.
	 * @param element
	 * @param feature
	 * @param annotation
	 * @param concreteChildType
	 * @param interpreter
	 * @param progressMonitor
	 * @throws FSMLMappingException
	 */
	public Mapping(EObject element, EStructuralFeature feature, EStructuralFeature essentialFeature, EAnnotation annotation, EClass concreteChildType, FSMLMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		currentMode = Mode.REVERSE_ESSENTIAL;
		
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);

		this.element = element;
		this.syncItem = null;
		this.feature = feature;
		this.essentialFeature = essentialFeature;
		this.annotation = annotation;
		this.concreteChildType = concreteChildType;
		this.interpreter = interpreter;
		this.progressMonitor = progressMonitor;
		
		processFields();
	}
	/**
	 * Constructor used in forward engineering.
	 * @param element
	 * @param syncItem
	 * @param feature
	 * @param annotation
	 * @param concreteChildType
	 * @param interpreter
	 * @param progressMonitor
	 * @throws FSMLMappingException 
	 */
	public Mapping(EObject element, SyncItem syncItem, EAnnotation annotation, EClass concreteChildType, FSMLMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		currentMode = Mode.FORWARD;
		
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);

		this.element = element;
		this.syncItem = syncItem;
		this.feature = syncItem instanceof StructuralFeatureSyncItem ? ((StructuralFeatureSyncItem) syncItem).getStructuralFeature() : null;
		this.annotation = annotation;
		this.concreteChildType = concreteChildType;
		this.interpreter = interpreter;
		this.progressMonitor = progressMonitor;
		
		processFields();
	}
	public boolean performForward() throws FSMLMappingException {
		// check if the mode is correct
		if (currentMode.compareTo(Mode.FORWARD) != 0)
			throw new IllegalStateException("performForward() can only be executed in the Mode.FORWARD mode.");
		
		// delegate to the actual forward method implemented in the concrete mapping.
		return forward();
	}
	public boolean performReverse() throws FSMLMappingException {
		// check if the mode is correct
		if (currentMode.compareTo(Mode.REVERSE) != 0)
			throw new IllegalStateException("performReverse() can only be executed in the Mode.REVERSE mode.");
		
		// delegate to the actual reverse method implemented in the concrete mapping.
		if (reverse()) {
			createMarkers();
			return true;
		}
		return false;
	}
	public boolean performReverseEssential() throws FSMLMappingException {
		// check if the mode is correct
		if (currentMode.compareTo(Mode.REVERSE_ESSENTIAL) != 0)
			throw new IllegalStateException("performReverseEssential() can only be executed in the Mode.REVERSE_ESSENTIAL mode.");
		
		// delegate to the actual reverse method implemented in the concrete mapping.
		if (reverseEssential()) {
			createMarkers();
			return true;
		}
		return false;
	}
	/**
	 * Performs code transformation for a feature.
	 * @return true if the transformation was successful. 
	 * @throws FSMLMappingException
	 */
	protected abstract boolean forward() throws FSMLMappingException;
	/**
	 * Performs code query for a feature.
	 * @return true if the feature is present.
	 * @throws FSMLMappingException
	 */
	protected abstract boolean reverse() throws FSMLMappingException;
	/**
	 * Performs code query for a feature and an essential subfeature.
	 * @return true if the feature is present.
	 * @throws FSMLMappingException
	 */
	protected boolean reverseEssential() throws FSMLMappingException {
		// by default do nothing
		return false;
	}
	/**
	 * Processes @Context and @Parameter annotations
	 */
	private void processFields() {
		Field[] fields = this.getClass().getFields();
		for (Field field : fields) {
			Annotation fieldAnnotation = field.getAnnotation(Context.class);
			if (fieldAnnotation != null) {
				Context contextAnnotation = (Context) fieldAnnotation;
				// check the dependency
				String dependsOn = contextAnnotation.dependsOn();
				if (!dependsOn.isEmpty()) {
					try {
						Field dependencyField = this.getClass().getField(dependsOn);
						Object value = dependencyField.get(this);
						if (value == null)
							continue;
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				// check excludes
				String excludes = contextAnnotation.excludes();
				if (!excludes.isEmpty()) {
					try {
						Field excludesField = this.getClass().getField(excludes);
						Object value = excludesField.get(this);
						if (value != null)
							continue;
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				Mode mode = contextAnnotation.mode();
				// the type of the field is the type of the context
				try {
					if (mode == Mode.ALL || 
						mode == currentMode || 
						(mode == Mode.REVERSE_AND_REVERSE_ESSENTIAL && (currentMode == Mode.REVERSE || currentMode == Mode.REVERSE_ESSENTIAL)) || 
						(mode == Mode.FORWARD_AND_REVERSE && (currentMode == Mode.FORWARD || currentMode == Mode.REVERSE)) ||
						(mode == Mode.FORWARD_AND_REVERSE_ESSENTIAL && (currentMode == Mode.FORWARD || currentMode == Mode.REVERSE_ESSENTIAL))) {
						
						Object context = null;
						boolean isRequired = contextAnnotation.required();
						switch (currentMode) {
						case REVERSE:
						case REVERSE_ESSENTIAL:
							context = Queries.INSTANCE.getContext(element, field.getType(), isRequired);
							break;
						case FORWARD:
							// need to start from the parent because the element of the sync item can also correspond
							// to the required context but it has not been created yet!
							SyncItem parentSyncItem = (SyncItem) syncItem.eContainer();
							context = Queries.INSTANCE.getContext(parentSyncItem, field.getType(), isRequired);
							break;
						}
						field.set(this, context);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				continue;
			}
			fieldAnnotation = field.getAnnotation(Parameter.class);
			if (fieldAnnotation != null) {
				Parameter parameterAnnotation = (Parameter) fieldAnnotation;
				Mode mode = parameterAnnotation.mode();
				String name = parameterAnnotation.name();
				if (mode == Mode.ALL 
					|| mode == currentMode 
					|| (mode == Mode.REVERSE && currentMode == Mode.REVERSE_ESSENTIAL)) { // REVERSE_ESSENTIAL is also REVERSE
					try {
						String value = FSMLEcoreUtil.retrieveParameterValue(annotation, name, parameterAnnotation.required());
						if (value == null)
							value = parameterAnnotation.defaultValue();
						field.set(this, value);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (FSMLMappingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	// support for markers
	/**
	 * A list of marker descriptors added for creation.
	 */
	ArrayList<MarkerDescriptor> markerDescriptors = new ArrayList<MarkerDescriptor>();
	/**
	 * Specify that a marker should be created in the @param resource at the given @param startOffset and @param endOffset.
	 * A @param value of the feature that the marker should correspond to can optionally be specified.
	 * The value should only be used for multivalue features, e.g., [0..*] f (String); 
	 */
	protected void createMarkerDescriptor(IResource resource, int startOffset, int endOffset, Object value) {
		MarkerDescriptor markerDescriptor = new MarkerDescriptor(resource);
		markerDescriptor.setAttributes(feature, startOffset, endOffset);
		if (value != null)
			markerDescriptor.setValue(value);
		addMarkerDescriptor(markerDescriptor);
	}
	protected void addMarkerDescriptor(MarkerDescriptor markerDescriptor) {
		markerDescriptors.add(markerDescriptor);
	}
	/**
	 * Creates markers for all added items.
	 */
	protected void createMarkers() {
		for (MarkerDescriptor descriptor : markerDescriptors)
			descriptor.create(element);
	}
	
	protected boolean setFeature(boolean result) throws FSMLMappingException {
		return setFeature(result, null);
	}
	protected boolean setFeature(boolean result, Object context) throws FSMLMappingException {
		if (feature instanceof EAttribute && feature.getEType().getName().equals("EBoolean")) {
			element.eSet(feature, result);
			if (result)
				Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
		}
		else if (feature instanceof EReference && result) {
			child = EcoreUtil.create(concreteChildType);
			
			if (feature.isMany())
				((EList)element.eGet(feature)).add(child);
			else
				element.eSet(feature, child);
			
			if (context != null)
				Queries.INSTANCE.associateContext(child, context);

			if (!Queries.INSTANCE.reverseFeatureRepresentedAsClass(child, progressMonitor))
				return false;
			// so the feature is present.
			Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
		}
		return result;
	}
	protected boolean setFeature(String result) throws FSMLMappingException {
		return setFeature(result, null);
	}
	protected boolean setFeature(String result, Object context) throws FSMLMappingException {
		if (feature instanceof EAttribute && feature.getEType().getName().equals("EString")) {
			if (feature.isMany())
				((EList)element.eGet(feature)).add(result);
			else
				element.eSet(feature, result);
		}
		else if (feature instanceof EReference && result != null) {
			child = EcoreUtil.create(concreteChildType);
			
			if (feature.isMany())
				((EList)element.eGet(feature)).add(child);
			else
				element.eSet(feature, child);
			
			if (context != null)
				Queries.INSTANCE.associateContext(child, context);
			
			if (!Queries.INSTANCE.reverseFeatureRepresentedAsClass(child, progressMonitor))
				return false;
		}
		if (result != null) {
			Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
			return true;
		}
		return false;
	}
}
