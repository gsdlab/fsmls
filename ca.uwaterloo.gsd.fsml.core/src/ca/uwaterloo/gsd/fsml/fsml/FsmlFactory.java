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
package ca.uwaterloo.gsd.fsml.fsml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.fsml.FsmlPackage
 * @generated
 */
public interface FsmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmlFactory eINSTANCE = ca.uwaterloo.gsd.fsml.fsml.impl.FsmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Container</em>'.
	 * @generated
	 */
	ModelContainer createModelContainer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FsmlPackage getFsmlPackage();

} //FsmlFactory
