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
 * $Id: ExtendsViewPartImpl.java,v 1.3 2007/07/17 04:18:36 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ca.uwaterloo.gsd.wpi.ExtendsViewPart;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends View Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ExtendsViewPartImpl#isExtendsPageBookView <em>Extends Page Book View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsViewPartImpl extends EObjectImpl implements ExtendsViewPart {
	/**
	 * The default value of the '{@link #isExtendsPageBookView() <em>Extends Page Book View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsPageBookView()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDS_PAGE_BOOK_VIEW_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtendsPageBookView() <em>Extends Page Book View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsPageBookView()
	 * @generated
	 * @ordered
	 */
	protected boolean extendsPageBookView = EXTENDS_PAGE_BOOK_VIEW_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsViewPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.EXTENDS_VIEW_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtendsPageBookView() {
		return extendsPageBookView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsPageBookView(boolean newExtendsPageBookView) {
		boolean oldExtendsPageBookView = extendsPageBookView;
		extendsPageBookView = newExtendsPageBookView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.EXTENDS_VIEW_PART__EXTENDS_PAGE_BOOK_VIEW, oldExtendsPageBookView, extendsPageBookView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.EXTENDS_VIEW_PART__EXTENDS_PAGE_BOOK_VIEW:
				return isExtendsPageBookView() ? Boolean.TRUE : Boolean.FALSE;
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
			case WpiPackage.EXTENDS_VIEW_PART__EXTENDS_PAGE_BOOK_VIEW:
				setExtendsPageBookView(((Boolean)newValue).booleanValue());
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
			case WpiPackage.EXTENDS_VIEW_PART__EXTENDS_PAGE_BOOK_VIEW:
				setExtendsPageBookView(EXTENDS_PAGE_BOOK_VIEW_EDEFAULT);
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
			case WpiPackage.EXTENDS_VIEW_PART__EXTENDS_PAGE_BOOK_VIEW:
				return extendsPageBookView != EXTENDS_PAGE_BOOK_VIEW_EDEFAULT;
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
		result.append(" (extendsPageBookView: ");
		result.append(extendsPageBookView);
		result.append(')');
		return result.toString();
	}

} //ExtendsViewPartImpl
