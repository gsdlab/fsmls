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
package ca.uwaterloo.gsd.fsml.fsml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ca.uwaterloo.gsd.fsml.fsml.FsmlPackage;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.fsml.impl.ModelContainerImpl#getAssertedModel <em>Asserted Model</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.fsml.impl.ModelContainerImpl#getLastReconciledModel <em>Last Reconciled Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelContainerImpl extends EObjectImpl implements ModelContainer {
	/**
	 * The cached value of the '{@link #getAssertedModel() <em>Asserted Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssertedModel()
	 * @generated
	 * @ordered
	 */
	protected Model assertedModel;

	/**
	 * The cached value of the '{@link #getLastReconciledModel() <em>Last Reconciled Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastReconciledModel()
	 * @generated
	 * @ordered
	 */
	protected Model lastReconciledModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmlPackage.Literals.MODEL_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getAssertedModel() {
		return assertedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssertedModel(Model newAssertedModel, NotificationChain msgs) {
		Model oldAssertedModel = assertedModel;
		assertedModel = newAssertedModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL, oldAssertedModel, newAssertedModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssertedModel(Model newAssertedModel) {
		if (newAssertedModel != assertedModel) {
			NotificationChain msgs = null;
			if (assertedModel != null)
				msgs = ((InternalEObject)assertedModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL, null, msgs);
			if (newAssertedModel != null)
				msgs = ((InternalEObject)newAssertedModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL, null, msgs);
			msgs = basicSetAssertedModel(newAssertedModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL, newAssertedModel, newAssertedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getLastReconciledModel() {
		return lastReconciledModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLastReconciledModel(Model newLastReconciledModel, NotificationChain msgs) {
		Model oldLastReconciledModel = lastReconciledModel;
		lastReconciledModel = newLastReconciledModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL, oldLastReconciledModel, newLastReconciledModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastReconciledModel(Model newLastReconciledModel) {
		if (newLastReconciledModel != lastReconciledModel) {
			NotificationChain msgs = null;
			if (lastReconciledModel != null)
				msgs = ((InternalEObject)lastReconciledModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL, null, msgs);
			if (newLastReconciledModel != null)
				msgs = ((InternalEObject)newLastReconciledModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL, null, msgs);
			msgs = basicSetLastReconciledModel(newLastReconciledModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL, newLastReconciledModel, newLastReconciledModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL:
				return basicSetAssertedModel(null, msgs);
			case FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL:
				return basicSetLastReconciledModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL:
				return getAssertedModel();
			case FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL:
				return getLastReconciledModel();
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
			case FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL:
				setAssertedModel((Model)newValue);
				return;
			case FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL:
				setLastReconciledModel((Model)newValue);
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
			case FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL:
				setAssertedModel((Model)null);
				return;
			case FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL:
				setLastReconciledModel((Model)null);
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
			case FsmlPackage.MODEL_CONTAINER__ASSERTED_MODEL:
				return assertedModel != null;
			case FsmlPackage.MODEL_CONTAINER__LAST_RECONCILED_MODEL:
				return lastReconciledModel != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelContainerImpl
