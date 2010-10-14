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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage;
import ca.uwaterloo.gsd.fsml.implModel.default_callsReceived;
import ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>default calls Received</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_callsReceivedImpl#getVariant <em>Variant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class default_callsReceivedImpl extends DefaultImpl implements default_callsReceived {
	/**
	 * The cached value of the '{@link #getVariant() <em>Variant</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariant()
	 * @generated
	 * @ordered
	 */
	protected EList<variant_callsReceived> variant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected default_callsReceivedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplModelPackage.Literals.DEFAULT_CALLS_RECEIVED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<variant_callsReceived> getVariant() {
		if (variant == null) {
			variant = new EObjectContainmentEList<variant_callsReceived>(variant_callsReceived.class, this, ImplModelPackage.DEFAULT_CALLS_RECEIVED__VARIANT);
		}
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImplModelPackage.DEFAULT_CALLS_RECEIVED__VARIANT:
				return ((InternalEList<?>)getVariant()).basicRemove(otherEnd, msgs);
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
			case ImplModelPackage.DEFAULT_CALLS_RECEIVED__VARIANT:
				return getVariant();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImplModelPackage.DEFAULT_CALLS_RECEIVED__VARIANT:
				getVariant().clear();
				getVariant().addAll((Collection<? extends variant_callsReceived>)newValue);
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
			case ImplModelPackage.DEFAULT_CALLS_RECEIVED__VARIANT:
				getVariant().clear();
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
			case ImplModelPackage.DEFAULT_CALLS_RECEIVED__VARIANT:
				return variant != null && !variant.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //default_callsReceivedImpl
