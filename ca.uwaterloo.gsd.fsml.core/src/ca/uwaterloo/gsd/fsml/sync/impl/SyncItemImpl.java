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
package ca.uwaterloo.gsd.fsml.sync.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.RA;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncPackage;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sync Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.SyncItemImpl#getSynchronizationState <em>Synchronization State</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.SyncItemImpl#getReconciliationDecision <em>Reconciliation Decision</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.SyncItemImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SyncItemImpl extends EObjectImpl implements SyncItem {
	/**
	 * The default value of the '{@link #getSynchronizationState() <em>Synchronization State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronizationState()
	 * @generated
	 * @ordered
	 */
	protected static final SynchronizationState SYNCHRONIZATION_STATE_EDEFAULT = SynchronizationState.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getSynchronizationState() <em>Synchronization State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronizationState()
	 * @generated
	 * @ordered
	 */
	protected SynchronizationState synchronizationState = SYNCHRONIZATION_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReconciliationDecision() <em>Reconciliation Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReconciliationDecision()
	 * @generated
	 * @ordered
	 */
	protected static final ReconciliationDecision RECONCILIATION_DECISION_EDEFAULT = ReconciliationDecision.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getReconciliationDecision() <em>Reconciliation Decision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReconciliationDecision()
	 * @generated
	 * @ordered
	 */
	protected ReconciliationDecision reconciliationDecision = RECONCILIATION_DECISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected String result = RESULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SyncItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SyncPackage.Literals.SYNC_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationState getSynchronizationState() {
		return synchronizationState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronizationState(SynchronizationState newSynchronizationState) {
		SynchronizationState oldSynchronizationState = synchronizationState;
		synchronizationState = newSynchronizationState == null ? SYNCHRONIZATION_STATE_EDEFAULT : newSynchronizationState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncPackage.SYNC_ITEM__SYNCHRONIZATION_STATE, oldSynchronizationState, synchronizationState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReconciliationDecision getReconciliationDecision() {
		return reconciliationDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReconciliationDecision(ReconciliationDecision newReconciliationDecision) {
		ReconciliationDecision oldReconciliationDecision = reconciliationDecision;
		reconciliationDecision = newReconciliationDecision == null ? RECONCILIATION_DECISION_EDEFAULT : newReconciliationDecision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncPackage.SYNC_ITEM__RECONCILIATION_DECISION, oldReconciliationDecision, reconciliationDecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(String newResult) {
		String oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncPackage.SYNC_ITEM__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStateForward() {
		switch (synchronizationState.getValue()) {
		case SynchronizationState.ADDED_MODEL:
		case SynchronizationState.CHANGED_MODEL:
		case SynchronizationState.REMOVED_MODEL:
			return true;
		default:
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStateReverse() {
		switch (synchronizationState.getValue()) {
		case SynchronizationState.ADDED_CODE:
		case SynchronizationState.CHANGED_CODE:
		case SynchronizationState.REMOVED_CODE:
			return true;
		default:
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStateConflict() {
		switch (synchronizationState.getValue()) {
		case SynchronizationState.ADDED_INCONSISTENTLY:
		case SynchronizationState.CHANGED_INCONSISTENTLY:
		case SynchronizationState.REMOVED_CODE_CHANGED_MODEL:
		case SynchronizationState.REMOVED_MODEL_CHANGED_CODE:
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDecisionIgnore() {
		return reconciliationDecision.getValue() == ReconciliationDecision.IGNORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStateChanged() {
		return synchronizationState.getValue() == SynchronizationState.CHANGED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDecisionEnforce() {
		switch (reconciliationDecision.getValue()) {
		case ReconciliationDecision.ENFORCE:
		case ReconciliationDecision.ENFORCE_AND_UPDATE:
		case ReconciliationDecision.OVERRIDE_AND_ENFORCE:
			return true;
		default:
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDecisionUpdate() {
		switch (reconciliationDecision.getValue()) {
		case ReconciliationDecision.UPDATE:
		case ReconciliationDecision.ENFORCE_AND_UPDATE:
		case ReconciliationDecision.OVERRIDE_AND_UPDATE:
			return true;
		default:
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDecisionValid(ReconciliationDecision decision) {
		switch (decision.getValue()) {
		case ReconciliationDecision.ENFORCE:
			return isStateForward();
		case ReconciliationDecision.OVERRIDE_AND_ENFORCE:
			return isStateReverse() || isStateConflict();
		case ReconciliationDecision.UPDATE:
			return isStateReverse();
		case ReconciliationDecision.OVERRIDE_AND_UPDATE:
			return isStateForward() || isStateConflict();
		case ReconciliationDecision.ENFORCE_AND_UPDATE:
			return isStateChanged();
		default:
			return true;
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract EObject getModel();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract EObject getCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static boolean isDecisionValidForState(ReconciliationDecision decision, SynchronizationState state) {
		ClassSyncItem aux = SyncFactory.eINSTANCE.createClassSyncItem();
		aux.setSynchronizationState(state);
		return aux.isDecisionValid(decision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SyncPackage.SYNC_ITEM__SYNCHRONIZATION_STATE:
				return getSynchronizationState();
			case SyncPackage.SYNC_ITEM__RECONCILIATION_DECISION:
				return getReconciliationDecision();
			case SyncPackage.SYNC_ITEM__RESULT:
				return getResult();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SyncPackage.SYNC_ITEM__SYNCHRONIZATION_STATE:
				setSynchronizationState((SynchronizationState)newValue);
				return;
			case SyncPackage.SYNC_ITEM__RECONCILIATION_DECISION:
				setReconciliationDecision((ReconciliationDecision)newValue);
				return;
			case SyncPackage.SYNC_ITEM__RESULT:
				setResult((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SyncPackage.SYNC_ITEM__SYNCHRONIZATION_STATE:
				setSynchronizationState(SYNCHRONIZATION_STATE_EDEFAULT);
				return;
			case SyncPackage.SYNC_ITEM__RECONCILIATION_DECISION:
				setReconciliationDecision(RECONCILIATION_DECISION_EDEFAULT);
				return;
			case SyncPackage.SYNC_ITEM__RESULT:
				setResult(RESULT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SyncPackage.SYNC_ITEM__SYNCHRONIZATION_STATE:
				return synchronizationState != SYNCHRONIZATION_STATE_EDEFAULT;
			case SyncPackage.SYNC_ITEM__RECONCILIATION_DECISION:
				return reconciliationDecision != RECONCILIATION_DECISION_EDEFAULT;
			case SyncPackage.SYNC_ITEM__RESULT:
				return RESULT_EDEFAULT == null ? result != null : !RESULT_EDEFAULT.equals(result);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (synchronizationState: ");
		result.append(synchronizationState);
		result.append(", reconciliationDecision: ");
		result.append(reconciliationDecision);
		result.append(", result: ");
		result.append(result);
		result.append(')');
		return result.toString();
	}
	/**
	 * @return a reconciliation action for the reconciliation decision and synchronization state.
	 * @generated NOT
	 */
	public ca.uwaterloo.gsd.fsml.sync.RA getReconciliationAction() {
		switch (reconciliationDecision.getValue()) {
		case ReconciliationDecision.ENFORCE:
			switch (synchronizationState.getValue()) {
			case SynchronizationState.ADDED_MODEL:
				return RA.CODE_ADD;
			case SynchronizationState.CHANGED_MODEL:
				return RA.CODE_CHANGE;
			case SynchronizationState.REMOVED_MODEL:
				return RA.CODE_REMOVE;
			}
			// error!
			return RA.STOP;
		case ReconciliationDecision.UPDATE:
			switch (synchronizationState.getValue()) {
			case SynchronizationState.ADDED_CODE:
				return RA.MODEL_ADD;
			case SynchronizationState.CHANGED_CODE:
				return RA.MODEL_CHANGE;
			case SynchronizationState.REMOVED_CODE:
				return RA.MODEL_REMOVE;
			}		
			// error!
			return RA.STOP;
		case ReconciliationDecision.OVERRIDE_AND_ENFORCE:
			switch (synchronizationState.getValue()) {
			case SynchronizationState.ADDED_CODE:
				return RA.CODE_REMOVE;
			case SynchronizationState.CHANGED_CODE:
				return RA.CODE_CHANGE;
			case SynchronizationState.REMOVED_CODE:
				return RA.CODE_ADD;
			case SynchronizationState.CHANGED_INCONSISTENTLY:
				return RA.CODE_CHANGE;
			case SynchronizationState.ADDED_INCONSISTENTLY:
				return RA.CODE_CHANGE;
			case SynchronizationState.REMOVED_CODE_CHANGED_MODEL:
				return RA.CODE_ADD;
			case SynchronizationState.REMOVED_MODEL_CHANGED_CODE:
				return RA.CODE_REMOVE;
			}	
			// error!
			return RA.STOP;
		case ReconciliationDecision.OVERRIDE_AND_UPDATE:
			switch (synchronizationState.getValue()) {
			case SynchronizationState.ADDED_MODEL:
				return RA.MODEL_REMOVE;
			case SynchronizationState.CHANGED_MODEL:
				return RA.MODEL_CHANGE;
			case SynchronizationState.REMOVED_MODEL:
				return RA.MODEL_ADD;
			case SynchronizationState.CHANGED_INCONSISTENTLY:
				return RA.MODEL_CHANGE;
			case SynchronizationState.ADDED_INCONSISTENTLY:
				return RA.MODEL_CHANGE;
			case SynchronizationState.REMOVED_CODE_CHANGED_MODEL:
				return RA.MODEL_REMOVE;
			case SynchronizationState.REMOVED_MODEL_CHANGED_CODE:
				return RA.MODEL_ADD;
			}
			// error!
			return RA.STOP;
		}
		return RA.PROCEED;
	}
} //SyncItemImpl
