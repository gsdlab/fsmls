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
 * $Id: ThisSelectionProviderImpl.java,v 1.1 2008/06/26 19:28:45 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.ThisSelectionProvider;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>This Selection Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ThisSelectionProviderImpl#isImplementsISelectionProvider <em>Implements ISelection Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThisSelectionProviderImpl extends ConceptImpl implements ThisSelectionProvider {
	/**
	 * The default value of the '{@link #isImplementsISelectionProvider() <em>Implements ISelection Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplementsISelectionProvider()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLEMENTS_ISELECTION_PROVIDER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isImplementsISelectionProvider() <em>Implements ISelection Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplementsISelectionProvider()
	 * @generated
	 * @ordered
	 */
	protected boolean implementsISelectionProvider = IMPLEMENTS_ISELECTION_PROVIDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThisSelectionProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.THIS_SELECTION_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplementsISelectionProvider() {
		return implementsISelectionProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementsISelectionProvider(boolean newImplementsISelectionProvider) {
		boolean oldImplementsISelectionProvider = implementsISelectionProvider;
		implementsISelectionProvider = newImplementsISelectionProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.THIS_SELECTION_PROVIDER__IMPLEMENTS_ISELECTION_PROVIDER, oldImplementsISelectionProvider, implementsISelectionProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.THIS_SELECTION_PROVIDER__IMPLEMENTS_ISELECTION_PROVIDER:
				return isImplementsISelectionProvider() ? Boolean.TRUE : Boolean.FALSE;
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
			case WpiPackage.THIS_SELECTION_PROVIDER__IMPLEMENTS_ISELECTION_PROVIDER:
				setImplementsISelectionProvider(((Boolean)newValue).booleanValue());
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
			case WpiPackage.THIS_SELECTION_PROVIDER__IMPLEMENTS_ISELECTION_PROVIDER:
				setImplementsISelectionProvider(IMPLEMENTS_ISELECTION_PROVIDER_EDEFAULT);
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
			case WpiPackage.THIS_SELECTION_PROVIDER__IMPLEMENTS_ISELECTION_PROVIDER:
				return implementsISelectionProvider != IMPLEMENTS_ISELECTION_PROVIDER_EDEFAULT;
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
		result.append(" (implementsISelectionProvider: ");
		result.append(implementsISelectionProvider);
		result.append(')');
		return result.toString();
	}

} //ThisSelectionProviderImpl
