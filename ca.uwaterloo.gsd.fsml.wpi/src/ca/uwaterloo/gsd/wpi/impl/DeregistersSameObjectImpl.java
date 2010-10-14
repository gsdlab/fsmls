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
/**
  *
 *
 *
 * $Id: DeregistersSameObjectImpl.java,v 1.4 2008/04/09 15:22:55 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.DeregistersSameObject;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deregisters Same Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.DeregistersSameObjectImpl#isRegistersBeforeDeregisters <em>Registers Before Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeregistersSameObjectImpl extends ConceptImpl implements DeregistersSameObject {
	/**
	 * The default value of the '{@link #isRegistersBeforeDeregisters() <em>Registers Before Deregisters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRegistersBeforeDeregisters()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REGISTERS_BEFORE_DEREGISTERS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRegistersBeforeDeregisters() <em>Registers Before Deregisters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRegistersBeforeDeregisters()
	 * @generated
	 * @ordered
	 */
	protected boolean registersBeforeDeregisters = REGISTERS_BEFORE_DEREGISTERS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeregistersSameObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.DEREGISTERS_SAME_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRegistersBeforeDeregisters() {
		return registersBeforeDeregisters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistersBeforeDeregisters(boolean newRegistersBeforeDeregisters) {
		boolean oldRegistersBeforeDeregisters = registersBeforeDeregisters;
		registersBeforeDeregisters = newRegistersBeforeDeregisters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.DEREGISTERS_SAME_OBJECT__REGISTERS_BEFORE_DEREGISTERS, oldRegistersBeforeDeregisters, registersBeforeDeregisters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.DEREGISTERS_SAME_OBJECT__REGISTERS_BEFORE_DEREGISTERS:
				return isRegistersBeforeDeregisters() ? Boolean.TRUE : Boolean.FALSE;
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
			case WpiPackage.DEREGISTERS_SAME_OBJECT__REGISTERS_BEFORE_DEREGISTERS:
				setRegistersBeforeDeregisters(((Boolean)newValue).booleanValue());
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
			case WpiPackage.DEREGISTERS_SAME_OBJECT__REGISTERS_BEFORE_DEREGISTERS:
				setRegistersBeforeDeregisters(REGISTERS_BEFORE_DEREGISTERS_EDEFAULT);
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
			case WpiPackage.DEREGISTERS_SAME_OBJECT__REGISTERS_BEFORE_DEREGISTERS:
				return registersBeforeDeregisters != REGISTERS_BEFORE_DEREGISTERS_EDEFAULT;
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
		result.append(" (registersBeforeDeregisters: ");
		result.append(registersBeforeDeregisters);
		result.append(')');
		return result.toString();
	}

} //DeregistersSameObjectImpl
