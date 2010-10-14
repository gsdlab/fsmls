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

package ca.uwaterloo.gsd.fsml.implModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>variant assigned With Null Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InitializerImpl#getInitializedType <em>Initialized Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class variant_assignedWithNull_InitializerImpl extends variant_assignedWithNullImpl implements variant_assignedWithNull_Initializer {
	/**
	 * The default value of the '{@link #getInitializedType() <em>Initialized Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedType()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIALIZED_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitializedType() <em>Initialized Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedType()
	 * @generated
	 * @ordered
	 */
	protected String initializedType = INITIALIZED_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected variant_assignedWithNull_InitializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplModelPackage.Literals.VARIANT_ASSIGNED_WITH_NULL_INITIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitializedType() {
		return initializedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedType(String newInitializedType) {
		String oldInitializedType = initializedType;
		initializedType = newInitializedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__INITIALIZED_TYPE, oldInitializedType, initializedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__INITIALIZED_TYPE:
				return getInitializedType();
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
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__INITIALIZED_TYPE:
				setInitializedType((String)newValue);
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
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__INITIALIZED_TYPE:
				setInitializedType(INITIALIZED_TYPE_EDEFAULT);
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
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__INITIALIZED_TYPE:
				return INITIALIZED_TYPE_EDEFAULT == null ? initializedType != null : !INITIALIZED_TYPE_EDEFAULT.equals(initializedType);
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
		result.append(" (initializedType: ");
		result.append(initializedType);
		result.append(')');
		return result.toString();
	}

} //variant_assignedWithNull_InitializerImpl
