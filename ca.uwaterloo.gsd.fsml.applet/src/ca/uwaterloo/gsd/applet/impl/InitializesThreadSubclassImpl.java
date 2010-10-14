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
 * $Id: InitializesThreadSubclassImpl.java,v 1.4 2008/06/25 00:46:11 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.InitializesThreadSubclass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initializes Thread Subclass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadSubclassImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadSubclassImpl#isOverriddesRun <em>Overriddes Run</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadSubclassImpl#isExtendsThread <em>Extends Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitializesThreadSubclassImpl extends EObjectImpl implements InitializesThreadSubclass {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isOverriddesRun() <em>Overriddes Run</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverriddesRun()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERRIDDES_RUN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isOverriddesRun() <em>Overriddes Run</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverriddesRun()
	 * @generated
	 * @ordered
	 */
	protected boolean overriddesRun = OVERRIDDES_RUN_EDEFAULT;

	/**
	 * The default value of the '{@link #isExtendsThread() <em>Extends Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsThread()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDS_THREAD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isExtendsThread() <em>Extends Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsThread()
	 * @generated
	 * @ordered
	 */
	protected boolean extendsThread = EXTENDS_THREAD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitializesThreadSubclassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.INITIALIZES_THREAD_SUBCLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_SUBCLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverriddesRun() {
		return overriddesRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverriddesRun(boolean newOverriddesRun) {
		boolean oldOverriddesRun = overriddesRun;
		overriddesRun = newOverriddesRun;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_SUBCLASS__OVERRIDDES_RUN, oldOverriddesRun, overriddesRun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtendsThread() {
		return extendsThread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsThread(boolean newExtendsThread) {
		boolean oldExtendsThread = extendsThread;
		extendsThread = newExtendsThread;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_SUBCLASS__EXTENDS_THREAD, oldExtendsThread, extendsThread));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__NAME:
				return getName();
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__OVERRIDDES_RUN:
				return isOverriddesRun() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__EXTENDS_THREAD:
				return isExtendsThread() ? Boolean.TRUE : Boolean.FALSE;
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
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__NAME:
				setName((String)newValue);
				return;
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__OVERRIDDES_RUN:
				setOverriddesRun(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__EXTENDS_THREAD:
				setExtendsThread(((Boolean)newValue).booleanValue());
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
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__OVERRIDDES_RUN:
				setOverriddesRun(OVERRIDDES_RUN_EDEFAULT);
				return;
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__EXTENDS_THREAD:
				setExtendsThread(EXTENDS_THREAD_EDEFAULT);
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
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__OVERRIDDES_RUN:
				return overriddesRun != OVERRIDDES_RUN_EDEFAULT;
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS__EXTENDS_THREAD:
				return extendsThread != EXTENDS_THREAD_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", overriddesRun: ");
		result.append(overriddesRun);
		result.append(", extendsThread: ");
		result.append(extendsThread);
		result.append(')');
		return result.toString();
	}

} //InitializesThreadSubclassImpl
