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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getSynchronizationState <em>Synchronization State</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getReconciliationDecision <em>Reconciliation Decision</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSyncItem()
 * @model abstract="true"
 * @generated
 */
public interface SyncItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Synchronization State</b></em>' attribute.
	 * The literals are from the enumeration {@link ca.uwaterloo.gsd.fsml.sync.SynchronizationState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronization State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronization State</em>' attribute.
	 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationState
	 * @see #setSynchronizationState(SynchronizationState)
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSyncItem_SynchronizationState()
	 * @model
	 * @generated
	 */
	SynchronizationState getSynchronizationState();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getSynchronizationState <em>Synchronization State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronization State</em>' attribute.
	 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationState
	 * @see #getSynchronizationState()
	 * @generated
	 */
	void setSynchronizationState(SynchronizationState value);

	/**
	 * Returns the value of the '<em><b>Reconciliation Decision</b></em>' attribute.
	 * The literals are from the enumeration {@link ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reconciliation Decision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reconciliation Decision</em>' attribute.
	 * @see ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision
	 * @see #setReconciliationDecision(ReconciliationDecision)
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSyncItem_ReconciliationDecision()
	 * @model
	 * @generated
	 */
	ReconciliationDecision getReconciliationDecision();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getReconciliationDecision <em>Reconciliation Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reconciliation Decision</em>' attribute.
	 * @see ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision
	 * @see #getReconciliationDecision()
	 * @generated
	 */
	void setReconciliationDecision(ReconciliationDecision value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(String)
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSyncItem_Result()
	 * @model
	 * @generated
	 */
	String getResult();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStateForward();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStateReverse();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStateConflict();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStateChanged();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDecisionIgnore();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDecisionEnforce();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDecisionUpdate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isDecisionValid(ReconciliationDecision decision);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EObject getModel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EObject getCode();

	RA getReconciliationAction();

} // SyncItem
