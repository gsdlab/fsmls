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
 * $Id: ExtendsEditorPartImpl.java,v 1.4 2007/07/17 04:18:35 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.ExtendsEditorPart;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends Editor Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ExtendsEditorPartImpl#isExtendsMultiPageEditorPart <em>Extends Multi Page Editor Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsEditorPartImpl extends ConceptImpl implements ExtendsEditorPart {
	/**
	 * The default value of the '{@link #isExtendsMultiPageEditorPart() <em>Extends Multi Page Editor Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsMultiPageEditorPart()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDS_MULTI_PAGE_EDITOR_PART_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtendsMultiPageEditorPart() <em>Extends Multi Page Editor Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsMultiPageEditorPart()
	 * @generated
	 * @ordered
	 */
	protected boolean extendsMultiPageEditorPart = EXTENDS_MULTI_PAGE_EDITOR_PART_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsEditorPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.EXTENDS_EDITOR_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtendsMultiPageEditorPart() {
		return extendsMultiPageEditorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsMultiPageEditorPart(boolean newExtendsMultiPageEditorPart) {
		boolean oldExtendsMultiPageEditorPart = extendsMultiPageEditorPart;
		extendsMultiPageEditorPart = newExtendsMultiPageEditorPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.EXTENDS_EDITOR_PART__EXTENDS_MULTI_PAGE_EDITOR_PART, oldExtendsMultiPageEditorPart, extendsMultiPageEditorPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.EXTENDS_EDITOR_PART__EXTENDS_MULTI_PAGE_EDITOR_PART:
				return isExtendsMultiPageEditorPart() ? Boolean.TRUE : Boolean.FALSE;
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
			case WpiPackage.EXTENDS_EDITOR_PART__EXTENDS_MULTI_PAGE_EDITOR_PART:
				setExtendsMultiPageEditorPart(((Boolean)newValue).booleanValue());
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
			case WpiPackage.EXTENDS_EDITOR_PART__EXTENDS_MULTI_PAGE_EDITOR_PART:
				setExtendsMultiPageEditorPart(EXTENDS_MULTI_PAGE_EDITOR_PART_EDEFAULT);
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
			case WpiPackage.EXTENDS_EDITOR_PART__EXTENDS_MULTI_PAGE_EDITOR_PART:
				return extendsMultiPageEditorPart != EXTENDS_MULTI_PAGE_EDITOR_PART_EDEFAULT;
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
		result.append(" (extendsMultiPageEditorPart: ");
		result.append(extendsMultiPageEditorPart);
		result.append(')');
		return result.toString();
	}

} //ExtendsEditorPartImpl
