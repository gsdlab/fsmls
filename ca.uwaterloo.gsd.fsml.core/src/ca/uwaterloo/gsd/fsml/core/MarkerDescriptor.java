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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class MarkerDescriptor {
	// general properties
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_MESSAGE = "message";
	public static final String ATTRIBUTE_CHAR_START = "charStart";
	public static final String ATTRIBUTE_CHAR_END = "charEnd";
	public static final String ATTRIBUTE_LINE_NUMBER = "lineNumber";
	public static final String ATTRIBUTE_CUSTOM_ATTRIBUTE = "customAttribute";
	public static final String ATTRIBUTE_CUSTOM_ATTRIBUTE_VALUE = "customAttributeValue";
	/**
	 * Unique id of the marker (see createId()).
	 * id = <concept instance id> [:: <feature name>] [(<value>)]  
	 */
	protected String id;
	/**
	 * Human readable description of a concept or a feature
	 */
	protected String message;
	protected int charStart = -1;
	protected int charEnd = -1;
	protected int lineNumber = -1;
	protected String customAttribute = null;
	protected String customAttributeValue = null;
	
	/**
	 * Element for which the marker is created.
	 * Used for the creation of id.
	 */
	protected EObject element;
	/**
	 * Feature of the element for which the marker is created.
	 * Used for the creation of id.
	 */
	protected EStructuralFeature feature;
	public void setFeature(EStructuralFeature feature){
		this.feature = feature;
	}
	/**
	 * A value of a multivalue feature for which the marker is created.
	 * Can be EObject for references or any value for attributes.
	 * Used for the creation of id.
	 */
	protected Object value;
	/**
	 * a resource to create a marker in.
	 */
	protected IResource resource;
	protected String explanation;
	
	public MarkerDescriptor(String id) {
		this.id = id;
	}

	public MarkerDescriptor(IResource resource) {
		this.resource = resource;
	}
	/**
	 * 
	 * @return true if the marker is ready for creation
	 */
	public boolean isValid() {
		return 	id != null && 
				charStart >= 0 && 
				charEnd >= 0 && 
				resource != null;
	}
	
	/**
	 * 
	 * @return a marker created from this descriptor or null.
	 * This method should be used when manually setting ids without using FSMLEcoreUtil.getFSMLId().
	 * Feature suffix has to be manually appended to id before calling this function.
	 */
	protected IMarker create() {
		if (id == null || id == "")
			constructId();
		
		if (value instanceof EObject)
			this.message = ((EObject) value).eClass().getName();
		else if (feature == null)
			this.message = element.eClass().getName();
		else
			this.message = element.eClass().getName() + "." + feature.getName();
		
		if (!isValid())
			return null;
		try {
			IMarker marker = resource.createMarker("ca.uwaterloo.gsd.fsml.marker");
			marker.setAttribute(ATTRIBUTE_ID, id);
			marker.setAttribute(ATTRIBUTE_MESSAGE, message + (explanation != null ? " : " + explanation : ""));
			marker.setAttribute(ATTRIBUTE_CHAR_START, charStart);
			marker.setAttribute(ATTRIBUTE_CHAR_END, charEnd);
			marker.setAttribute(ATTRIBUTE_LINE_NUMBER, lineNumber);
			if (customAttribute != null && customAttributeValue != null) {
				marker.setAttribute(ATTRIBUTE_CUSTOM_ATTRIBUTE, customAttribute);
				marker.setAttribute(ATTRIBUTE_CUSTOM_ATTRIBUTE_VALUE, customAttributeValue);
			}
			return marker;
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Feature suffix is automatically appended.  
	 * @param modelElement
	 * @return
	 */
	public IMarker create(EObject element) {
		this.element = element;
		return create();
	}
 	/**
 	 * Construct marker's id based on a) element's id, b) feature, and c) value if present.
 	 */
 	public void constructId() {
 		StringBuffer id = new StringBuffer();
 		
 		if (value instanceof EObject)
 			id.append(FSMLEcoreUtil.getFSMLId((EObject) value, null));
 		else {
	 		id.append(FSMLEcoreUtil.getFSMLId(element, null));
			
			if (feature != null)
				id.append("::" + feature.getName());
			
			if (value != null)
				id.append("(" + value + ")");
 		}
		
		this.id = id.toString();
 	}
 	// getters and setters
 	public void setValue(Object value) {
		this.value = value;
	}
	/**
	 * Convenience function. Sets feature, message, charStart, charEnd.
	 * @param feature
	 * @param message
	 * @param astNode
	 */
	public void setAttributes(EStructuralFeature feature, int startOffset, int endOffset) {
		this.charStart = startOffset;
		this.charEnd = endOffset;
		if (feature != null)
			this.feature = feature;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
