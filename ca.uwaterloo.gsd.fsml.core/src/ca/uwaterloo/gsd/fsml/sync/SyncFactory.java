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
package ca.uwaterloo.gsd.fsml.sync;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage
 * @generated
 */
public interface SyncFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SyncFactory eINSTANCE = ca.uwaterloo.gsd.fsml.sync.impl.SyncFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Synchronization Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Synchronization Result</em>'.
	 * @generated
	 */
	SynchronizationResult createSynchronizationResult();

	/**
	 * Returns a new object of class '<em>Class Sync Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Sync Item</em>'.
	 * @generated
	 */
	ClassSyncItem createClassSyncItem();

	/**
	 * Returns a new object of class '<em>Structural Feature Sync Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Feature Sync Item</em>'.
	 * @generated
	 */
	StructuralFeatureSyncItem createStructuralFeatureSyncItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SyncPackage getSyncPackage();

} //SyncFactory
