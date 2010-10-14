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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage;
import ca.uwaterloo.gsd.fsml.implModel.Variant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.impl.VariantImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.impl.VariantImpl#getEStructuralFeature <em>EStructural Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VariantImpl extends EObjectImpl implements Variant {
	/**
	 * The default value of the '{@link #getEClass() <em>EClass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected static final String ECLASS_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected String eClass = ECLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEStructuralFeature() <em>EStructural Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEStructuralFeature()
	 * @generated
	 * @ordered
	 */
	protected static final String ESTRUCTURAL_FEATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEStructuralFeature() <em>EStructural Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEStructuralFeature()
	 * @generated
	 * @ordered
	 */
	protected String eStructuralFeature = ESTRUCTURAL_FEATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplModelPackage.Literals.VARIANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEClass() {
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEClass(String newEClass) {
		String oldEClass = eClass;
		eClass = newEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplModelPackage.VARIANT__ECLASS, oldEClass, eClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEStructuralFeature() {
		return eStructuralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEStructuralFeature(String newEStructuralFeature) {
		String oldEStructuralFeature = eStructuralFeature;
		eStructuralFeature = newEStructuralFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplModelPackage.VARIANT__ESTRUCTURAL_FEATURE, oldEStructuralFeature, eStructuralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImplModelPackage.VARIANT__ECLASS:
				return getEClass();
			case ImplModelPackage.VARIANT__ESTRUCTURAL_FEATURE:
				return getEStructuralFeature();
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
			case ImplModelPackage.VARIANT__ECLASS:
				setEClass((String)newValue);
				return;
			case ImplModelPackage.VARIANT__ESTRUCTURAL_FEATURE:
				setEStructuralFeature((String)newValue);
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
			case ImplModelPackage.VARIANT__ECLASS:
				setEClass(ECLASS_EDEFAULT);
				return;
			case ImplModelPackage.VARIANT__ESTRUCTURAL_FEATURE:
				setEStructuralFeature(ESTRUCTURAL_FEATURE_EDEFAULT);
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
			case ImplModelPackage.VARIANT__ECLASS:
				return ECLASS_EDEFAULT == null ? eClass != null : !ECLASS_EDEFAULT.equals(eClass);
			case ImplModelPackage.VARIANT__ESTRUCTURAL_FEATURE:
				return ESTRUCTURAL_FEATURE_EDEFAULT == null ? eStructuralFeature != null : !ESTRUCTURAL_FEATURE_EDEFAULT.equals(eStructuralFeature);
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
		result.append(" (eClass: ");
		result.append(eClass);
		result.append(", eStructuralFeature: ");
		result.append(eStructuralFeature);
		result.append(')');
		return result.toString();
	}

} //VariantImpl
