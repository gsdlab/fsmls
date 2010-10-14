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
 * $Id: FieldSelectionProviderImpl.java,v 1.1 2008/06/26 19:28:45 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.FieldSelectionProvider;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Selection Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.FieldSelectionProviderImpl#getField <em>Field</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.FieldSelectionProviderImpl#isTypedISelectionProvider <em>Typed ISelection Provider</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.FieldSelectionProviderImpl#isInitialized <em>Initialized</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldSelectionProviderImpl extends ConceptImpl implements FieldSelectionProvider {
	/**
	 * The default value of the '{@link #getField() <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getField() <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected String field = FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #isTypedISelectionProvider() <em>Typed ISelection Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypedISelectionProvider()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TYPED_ISELECTION_PROVIDER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTypedISelectionProvider() <em>Typed ISelection Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypedISelectionProvider()
	 * @generated
	 * @ordered
	 */
	protected boolean typedISelectionProvider = TYPED_ISELECTION_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isInitialized() <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isInitialized() <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialized()
	 * @generated
	 * @ordered
	 */
	protected boolean initialized = INITIALIZED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FieldSelectionProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.FIELD_SELECTION_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getField() {
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField(String newField) {
		String oldField = field;
		field = newField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.FIELD_SELECTION_PROVIDER__FIELD, oldField, field));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypedISelectionProvider() {
		return typedISelectionProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedISelectionProvider(boolean newTypedISelectionProvider) {
		boolean oldTypedISelectionProvider = typedISelectionProvider;
		typedISelectionProvider = newTypedISelectionProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.FIELD_SELECTION_PROVIDER__TYPED_ISELECTION_PROVIDER, oldTypedISelectionProvider, typedISelectionProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitialized() {
		return initialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialized(boolean newInitialized) {
		boolean oldInitialized = initialized;
		initialized = newInitialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.FIELD_SELECTION_PROVIDER__INITIALIZED, oldInitialized, initialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.FIELD_SELECTION_PROVIDER__FIELD:
				return getField();
			case WpiPackage.FIELD_SELECTION_PROVIDER__TYPED_ISELECTION_PROVIDER:
				return isTypedISelectionProvider() ? Boolean.TRUE : Boolean.FALSE;
			case WpiPackage.FIELD_SELECTION_PROVIDER__INITIALIZED:
				return isInitialized() ? Boolean.TRUE : Boolean.FALSE;
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
			case WpiPackage.FIELD_SELECTION_PROVIDER__FIELD:
				setField((String)newValue);
				return;
			case WpiPackage.FIELD_SELECTION_PROVIDER__TYPED_ISELECTION_PROVIDER:
				setTypedISelectionProvider(((Boolean)newValue).booleanValue());
				return;
			case WpiPackage.FIELD_SELECTION_PROVIDER__INITIALIZED:
				setInitialized(((Boolean)newValue).booleanValue());
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
			case WpiPackage.FIELD_SELECTION_PROVIDER__FIELD:
				setField(FIELD_EDEFAULT);
				return;
			case WpiPackage.FIELD_SELECTION_PROVIDER__TYPED_ISELECTION_PROVIDER:
				setTypedISelectionProvider(TYPED_ISELECTION_PROVIDER_EDEFAULT);
				return;
			case WpiPackage.FIELD_SELECTION_PROVIDER__INITIALIZED:
				setInitialized(INITIALIZED_EDEFAULT);
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
			case WpiPackage.FIELD_SELECTION_PROVIDER__FIELD:
				return FIELD_EDEFAULT == null ? field != null : !FIELD_EDEFAULT.equals(field);
			case WpiPackage.FIELD_SELECTION_PROVIDER__TYPED_ISELECTION_PROVIDER:
				return typedISelectionProvider != TYPED_ISELECTION_PROVIDER_EDEFAULT;
			case WpiPackage.FIELD_SELECTION_PROVIDER__INITIALIZED:
				return initialized != INITIALIZED_EDEFAULT;
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
		result.append(" (field: ");
		result.append(field);
		result.append(", typedISelectionProvider: ");
		result.append(typedISelectionProvider);
		result.append(", initialized: ");
		result.append(initialized);
		result.append(')');
		return result.toString();
	}

} //FieldSelectionProviderImpl
