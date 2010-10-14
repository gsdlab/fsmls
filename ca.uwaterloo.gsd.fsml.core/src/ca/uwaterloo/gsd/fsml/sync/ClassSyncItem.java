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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Sync Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getSyncItems <em>Sync Items</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getModel <em>Model</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getClassSyncItem()
 * @model
 * @generated
 */
public interface ClassSyncItem extends SyncItem {
	/**
	 * Returns the value of the '<em><b>Sync Items</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.fsml.sync.SyncItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync Items</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getClassSyncItem_SyncItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<SyncItem> getSyncItems();

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(EObject)
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getClassSyncItem_Model()
	 * @model
	 * @generated
	 */
	EObject getModel();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(EObject value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' reference.
	 * @see #setCode(EObject)
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getClassSyncItem_Code()
	 * @model
	 * @generated
	 */
	EObject getCode();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getCode <em>Code</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' reference.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(EObject value);

} // ClassSyncItem
