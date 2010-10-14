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
 * $Id: ThisRunnableImpl.java,v 1.3 2008/01/23 03:47:52 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.ThisRunnable;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>This Runnable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.ThisRunnableImpl#isImplementsRunnable <em>Implements Runnable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThisRunnableImpl extends ConceptImpl implements ThisRunnable {
	/**
	 * The default value of the '{@link #isImplementsRunnable() <em>Implements Runnable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplementsRunnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLEMENTS_RUNNABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isImplementsRunnable() <em>Implements Runnable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplementsRunnable()
	 * @generated
	 * @ordered
	 */
	protected boolean implementsRunnable = IMPLEMENTS_RUNNABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThisRunnableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.THIS_RUNNABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplementsRunnable() {
		return implementsRunnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementsRunnable(boolean newImplementsRunnable) {
		boolean oldImplementsRunnable = implementsRunnable;
		implementsRunnable = newImplementsRunnable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.THIS_RUNNABLE__IMPLEMENTS_RUNNABLE, oldImplementsRunnable, implementsRunnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppletPackage.THIS_RUNNABLE__IMPLEMENTS_RUNNABLE:
				return isImplementsRunnable() ? Boolean.TRUE : Boolean.FALSE;
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
			case AppletPackage.THIS_RUNNABLE__IMPLEMENTS_RUNNABLE:
				setImplementsRunnable(((Boolean)newValue).booleanValue());
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
			case AppletPackage.THIS_RUNNABLE__IMPLEMENTS_RUNNABLE:
				setImplementsRunnable(IMPLEMENTS_RUNNABLE_EDEFAULT);
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
			case AppletPackage.THIS_RUNNABLE__IMPLEMENTS_RUNNABLE:
				return implementsRunnable != IMPLEMENTS_RUNNABLE_EDEFAULT;
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
		result.append(" (implementsRunnable: ");
		result.append(implementsRunnable);
		result.append(')');
		return result.toString();
	}

} //ThisRunnableImpl
