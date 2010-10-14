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
 * $Id: ExtendsEditorActionBarContributorImpl.java,v 1.3 2007/07/17 04:18:34 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends Editor Action Bar Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ExtendsEditorActionBarContributorImpl#isExtendsMultiPageEditorActionBarContributor <em>Extends Multi Page Editor Action Bar Contributor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsEditorActionBarContributorImpl extends ConceptImpl implements ExtendsEditorActionBarContributor {
	/**
	 * The default value of the '{@link #isExtendsMultiPageEditorActionBarContributor() <em>Extends Multi Page Editor Action Bar Contributor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsMultiPageEditorActionBarContributor()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtendsMultiPageEditorActionBarContributor() <em>Extends Multi Page Editor Action Bar Contributor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsMultiPageEditorActionBarContributor()
	 * @generated
	 * @ordered
	 */
	protected boolean extendsMultiPageEditorActionBarContributor = EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsEditorActionBarContributorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtendsMultiPageEditorActionBarContributor() {
		return extendsMultiPageEditorActionBarContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsMultiPageEditorActionBarContributor(boolean newExtendsMultiPageEditorActionBarContributor) {
		boolean oldExtendsMultiPageEditorActionBarContributor = extendsMultiPageEditorActionBarContributor;
		extendsMultiPageEditorActionBarContributor = newExtendsMultiPageEditorActionBarContributor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR__EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR, oldExtendsMultiPageEditorActionBarContributor, extendsMultiPageEditorActionBarContributor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR__EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR:
				return isExtendsMultiPageEditorActionBarContributor() ? Boolean.TRUE : Boolean.FALSE;
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
			case WpiPackage.EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR__EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR:
				setExtendsMultiPageEditorActionBarContributor(((Boolean)newValue).booleanValue());
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
			case WpiPackage.EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR__EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR:
				setExtendsMultiPageEditorActionBarContributor(EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR_EDEFAULT);
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
			case WpiPackage.EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR__EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR:
				return extendsMultiPageEditorActionBarContributor != EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR_EDEFAULT;
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
		result.append(" (extendsMultiPageEditorActionBarContributor: ");
		result.append(extendsMultiPageEditorActionBarContributor);
		result.append(')');
		return result.toString();
	}

} //ExtendsEditorActionBarContributorImpl
