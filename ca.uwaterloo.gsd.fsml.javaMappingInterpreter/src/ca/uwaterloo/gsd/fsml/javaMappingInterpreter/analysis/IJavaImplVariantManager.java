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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;

public interface IJavaImplVariantManager {

	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init();
	
	//the tear down method
	public void finish();

	public EObject getModel();

	public EClass getVariantEClass(String name) throws FSMLMappingException;

	public EObject getDefault(String eClass, String eStructuralFeature, String annotation) ;
	public String getVariantName(EObject variant);
	public void computeDefault();
	public EReference getDefaultsReference() ;
	public EReference getVariantsReference() ;
}
