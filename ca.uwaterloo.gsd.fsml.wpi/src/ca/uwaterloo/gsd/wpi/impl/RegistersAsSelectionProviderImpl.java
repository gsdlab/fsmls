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
 * $Id: RegistersAsSelectionProviderImpl.java,v 1.7 2008/06/26 19:28:44 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.FieldSelectionProvider;
import ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider;
import ca.uwaterloo.gsd.wpi.ThisSelectionProvider;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registers As Selection Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsSelectionProviderImpl#getRegistersThis <em>Registers This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsSelectionProviderImpl#isRegistersHelper <em>Registers Helper</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsSelectionProviderImpl#getRegistersVariable <em>Registers Variable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsSelectionProviderImpl#getRegistersField <em>Registers Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistersAsSelectionProviderImpl extends ConceptImpl implements RegistersAsSelectionProvider {
	/**
	 * The cached value of the '{@link #getRegistersThis() <em>Registers This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersThis()
	 * @generated
	 * @ordered
	 */
	protected ThisSelectionProvider registersThis;

	/**
	 * The default value of the '{@link #isRegistersHelper() <em>Registers Helper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRegistersHelper()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REGISTERS_HELPER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRegistersHelper() <em>Registers Helper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRegistersHelper()
	 * @generated
	 * @ordered
	 */
	protected boolean registersHelper = REGISTERS_HELPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegistersVariable() <em>Registers Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String REGISTERS_VARIABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegistersVariable() <em>Registers Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersVariable()
	 * @generated
	 * @ordered
	 */
	protected String registersVariable = REGISTERS_VARIABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRegistersField() <em>Registers Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersField()
	 * @generated
	 * @ordered
	 */
	protected FieldSelectionProvider registersField;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegistersAsSelectionProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.REGISTERS_AS_SELECTION_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisSelectionProvider getRegistersThis() {
		return registersThis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegistersThis(ThisSelectionProvider newRegistersThis, NotificationChain msgs) {
		ThisSelectionProvider oldRegistersThis = registersThis;
		registersThis = newRegistersThis;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS, oldRegistersThis, newRegistersThis);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistersThis(ThisSelectionProvider newRegistersThis) {
		if (newRegistersThis != registersThis) {
			NotificationChain msgs = null;
			if (registersThis != null)
				msgs = ((InternalEObject)registersThis).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS, null, msgs);
			if (newRegistersThis != null)
				msgs = ((InternalEObject)newRegistersThis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS, null, msgs);
			msgs = basicSetRegistersThis(newRegistersThis, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS, newRegistersThis, newRegistersThis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldSelectionProvider getRegistersField() {
		return registersField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegistersField(FieldSelectionProvider newRegistersField, NotificationChain msgs) {
		FieldSelectionProvider oldRegistersField = registersField;
		registersField = newRegistersField;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD, oldRegistersField, newRegistersField);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistersField(FieldSelectionProvider newRegistersField) {
		if (newRegistersField != registersField) {
			NotificationChain msgs = null;
			if (registersField != null)
				msgs = ((InternalEObject)registersField).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD, null, msgs);
			if (newRegistersField != null)
				msgs = ((InternalEObject)newRegistersField).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD, null, msgs);
			msgs = basicSetRegistersField(newRegistersField, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD, newRegistersField, newRegistersField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS:
				return basicSetRegistersThis(null, msgs);
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD:
				return basicSetRegistersField(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRegistersHelper() {
		return registersHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistersHelper(boolean newRegistersHelper) {
		boolean oldRegistersHelper = registersHelper;
		registersHelper = newRegistersHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_HELPER, oldRegistersHelper, registersHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegistersVariable() {
		return registersVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistersVariable(String newRegistersVariable) {
		String oldRegistersVariable = registersVariable;
		registersVariable = newRegistersVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_VARIABLE, oldRegistersVariable, registersVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS:
				return getRegistersThis();
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_HELPER:
				return isRegistersHelper() ? Boolean.TRUE : Boolean.FALSE;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_VARIABLE:
				return getRegistersVariable();
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD:
				return getRegistersField();
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
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS:
				setRegistersThis((ThisSelectionProvider)newValue);
				return;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_HELPER:
				setRegistersHelper(((Boolean)newValue).booleanValue());
				return;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_VARIABLE:
				setRegistersVariable((String)newValue);
				return;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD:
				setRegistersField((FieldSelectionProvider)newValue);
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
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS:
				setRegistersThis((ThisSelectionProvider)null);
				return;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_HELPER:
				setRegistersHelper(REGISTERS_HELPER_EDEFAULT);
				return;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_VARIABLE:
				setRegistersVariable(REGISTERS_VARIABLE_EDEFAULT);
				return;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD:
				setRegistersField((FieldSelectionProvider)null);
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
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS:
				return registersThis != null;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_HELPER:
				return registersHelper != REGISTERS_HELPER_EDEFAULT;
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_VARIABLE:
				return REGISTERS_VARIABLE_EDEFAULT == null ? registersVariable != null : !REGISTERS_VARIABLE_EDEFAULT.equals(registersVariable);
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD:
				return registersField != null;
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
		result.append(" (registersHelper: ");
		result.append(registersHelper);
		result.append(", registersVariable: ");
		result.append(registersVariable);
		result.append(')');
		return result.toString();
	}

} //RegistersAsSelectionProviderImpl
