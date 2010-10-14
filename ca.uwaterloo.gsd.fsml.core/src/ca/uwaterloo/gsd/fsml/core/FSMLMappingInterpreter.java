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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.JavaModelException;

import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 * 
 * A base implementation for all FSML mapping interpreters.
 */
public abstract class FSMLMappingInterpreter {
	/**
	 * This method is called at the beginning of reverse and forward engineering.
	 * @param project
	 * @param model
	 * @return true iff initialization successful
	 */
	public boolean initialize(IProject project, Model model) {
		// sanity check
		return project != null && model != null;
	}
	/**
	 * This method is called at the end of reverse and forward engineering.
	 * It allows mapping interpreters to free any acquired resources.
	 * By default do nothing.
	 */
	public void terminate(IProgressMonitor progressMonitor) {
	}
	/**
	 * @return user-readable description
	 */
	public abstract String getDescription();
	/**
	 * @return an array of names of supported context annotations
	 */
	public abstract String[] getContextAnnotations();
	/**
	 * @return an array of names of supported query annotations
	 */
	public abstract String[] getQueryAnnotations();

	// context annotations begin
	/**
	 * @param context type
	 * @return true iff the interpreter associates model elements with contexts of the given type 
	 */
	public boolean canHandleContext(Class contextClass) {
		return false;
	}
	/**
	 * @param object
	 * @param context
	 * Associates context object with model element using feature2* hash maps.
	 * In the case where the contex object is to be handled by another interpreter,
	 * delegate to Queries.associateContext(EObject, Object).
	 */
	public void associateContext(EObject eObject, Object context) {
		// delegate to Default
		Queries.INSTANCE.associateContext(eObject, context);
	}
	public void associateContext(int start, int end, EObject eObject) {
	}
	
	public boolean canAssociateContext(EObject eObject){
		return false;
	}
	
	
	/**
	 * @param required TODO
	 * @param object
	 * @return Context of a model element. There is at most one context per single element.
	 */
	public Object getContext(EObject eObject, Class contextClass, boolean required) {
		// delegate to Default
		return Queries.INSTANCE.getContext(eObject, contextClass, required);
	}
	public void removeContext(EObject element) {	
	}
	/**
	 * @param source
	 * @param target
	 * @return true if the context for the source has been aliased for the target
	 */
	public boolean aliasContext(EObject source, EObject target) {
		return false;
	}
	/**
	 * @param eClass
	 * @return true iff the interpreter can create children specified in the default query annotation.
	 */
	public boolean canCreateChildrenForDefaultQuery(EClass eClass) {
		return false;
	}
	/**
	 * @param element
	 * @param feature
	 * @param concreteChildType
	 * @param progressMonitor
	 * @return true if any children as specified by the default query were created
	 * @throws JavaModelException
	 * @throws FSMLMappingException 
	 */
	public boolean createChildrenForDefaultQuery(EObject element, EReference feature, EClass concreteChildType, IProgressMonitor progressMonitor) throws FSMLMappingException {
		return false;
	}
	public boolean canForwardObjectUsingContextMapping(EClass eClass) {
		return false;
	}
	// context annotations end
	
	// markers begin
	/**
	 * @deprecated Markers are now handled in Mapping classes
	 */
	public boolean canCreateMarkerForElementRepresentedAsClass(EClass eClass) {
		return false;
	}
	/**
	 * @deprecated Markers are now handled in Mapping classes
	 */
	public void createMarkerForFeatureRepresentedAsClass(EObject element) {
	}
	// markers end
	
	// query feature begin
	public EStructuralFeature findQueryFeature(EClass concreteChildType) {
		return null;
	}
	public boolean canForwardObjectUsingQueryMapping(EReference reference) {
		return false;
	}
	/**
	 * @param element
	 * @param feature
	 * @param concreteChildType
	 * @param queryFeature
	 * @param progressMonitor
	 * @return true is at least one of the children is present. 
	 * @throws JavaModelException
	 * Must call reverseFeatureRepresentedAsClass() for each child
	 * @throws FSMLMappingException 
	 */
	public boolean createChildrenForQueryFeature(EObject element, EReference feature, EClass concreteChildType, EStructuralFeature queryFeature, IProgressMonitor progressMonitor) throws FSMLMappingException {
		return false;
	}
	// query feature end
	
	// class begin
	/**
	 * @return true iff feature is present
	 * May delegate back to Queries.reverseFeatureRepresentedAsClass() if support for default annotations is necessary.
	 * @throws FSMLMappingException 
	 */
	public final boolean reverseFeatureRepresentedAsClass(EObject element, IProgressMonitor progressMonitor) throws FSMLMappingException {
		return Queries.INSTANCE.reverseFeatureRepresentedAsClass(element, progressMonitor);
	}
	public boolean forwardFeatureRepresentedAsClass(ClassSyncItem classSyncItem, IProgressMonitor progressMonitor) throws FSMLMappingException {
		return false;
	}
	// class end
	
	// attribute begin
	/**
	 * @return true iff feature is present
	 * @throws FSMLMappingException 
	 */
	public boolean reverseFeatureRepresentedAsAttribute(EObject element, EAttribute feature, IProgressMonitor progressMonitor) throws FSMLMappingException {
		return false;
	}
	public boolean forwardFeatureRepresentedAsAttribute(StructuralFeatureSyncItem featureSyncItem, IProgressMonitor progressMonitor) throws FSMLMappingException{
		return false;
	}
	// attribute end
	
	// reference begin
	/**
	 * @return true iff feature is present
	 * Must call reverseFeatureRepresentedAsClass() for each child in order to continue with recursion.
	 * @throws FSMLMappingException 
	 */
	public boolean reverseFeatureRepresentedAsReference(EObject element, EReference feature, EClass concreteChildType, IProgressMonitor progressMonitor) throws FSMLMappingException {
		return false;
	}
	/**
	 * The reference is the containment reference of the element from the classSyncItem. 
	 */
	public boolean forwardFeatureRepresentedAsReference(ClassSyncItem classSyncItem, IProgressMonitor progressMonitor) throws FSMLMappingException {
		return false;
	}

}
