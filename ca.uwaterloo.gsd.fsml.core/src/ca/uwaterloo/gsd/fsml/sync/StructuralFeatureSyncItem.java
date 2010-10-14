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

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Feature Sync Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem#getStructuralFeature <em>Structural Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getStructuralFeatureSyncItem()
 * @model
 * @generated
 */
public interface StructuralFeatureSyncItem extends SyncItem {
	/**
	 * Returns the value of the '<em><b>Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structural Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structural Feature</em>' reference.
	 * @see #setStructuralFeature(EStructuralFeature)
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getStructuralFeatureSyncItem_StructuralFeature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getStructuralFeature();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem#getStructuralFeature <em>Structural Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structural Feature</em>' reference.
	 * @see #getStructuralFeature()
	 * @generated
	 */
	void setStructuralFeature(EStructuralFeature value);

} // StructuralFeatureSyncItem
