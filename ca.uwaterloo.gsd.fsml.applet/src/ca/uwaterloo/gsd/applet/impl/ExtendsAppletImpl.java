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
 * $Id: ExtendsAppletImpl.java,v 1.3 2007/12/06 03:28:30 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.ExtendsApplet;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends Applet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.ExtendsAppletImpl#isExtendsJApplet <em>Extends JApplet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsAppletImpl extends ConceptImpl implements ExtendsApplet {
	/**
	 * The default value of the '{@link #isExtendsJApplet() <em>Extends JApplet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsJApplet()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDS_JAPPLET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtendsJApplet() <em>Extends JApplet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsJApplet()
	 * @generated
	 * @ordered
	 */
	protected boolean extendsJApplet = EXTENDS_JAPPLET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsAppletImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.EXTENDS_APPLET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtendsJApplet() {
		return extendsJApplet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsJApplet(boolean newExtendsJApplet) {
		boolean oldExtendsJApplet = extendsJApplet;
		extendsJApplet = newExtendsJApplet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.EXTENDS_APPLET__EXTENDS_JAPPLET, oldExtendsJApplet, extendsJApplet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppletPackage.EXTENDS_APPLET__EXTENDS_JAPPLET:
				return isExtendsJApplet() ? Boolean.TRUE : Boolean.FALSE;
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
			case AppletPackage.EXTENDS_APPLET__EXTENDS_JAPPLET:
				setExtendsJApplet(((Boolean)newValue).booleanValue());
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
			case AppletPackage.EXTENDS_APPLET__EXTENDS_JAPPLET:
				setExtendsJApplet(EXTENDS_JAPPLET_EDEFAULT);
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
			case AppletPackage.EXTENDS_APPLET__EXTENDS_JAPPLET:
				return extendsJApplet != EXTENDS_JAPPLET_EDEFAULT;
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
		result.append(" (extendsJApplet: ");
		result.append(extendsJApplet);
		result.append(')');
		return result.toString();
	}

} //ExtendsAppletImpl
