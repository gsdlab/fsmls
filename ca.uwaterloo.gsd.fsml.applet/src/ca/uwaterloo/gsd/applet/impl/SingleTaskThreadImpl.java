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
 * $Id: SingleTaskThreadImpl.java,v 1.1 2008/03/12 16:58:21 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.RunnableField;
import ca.uwaterloo.gsd.applet.SingleTaskThread;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Task Thread</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.SingleTaskThreadImpl#isRunnable <em>Runnable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.SingleTaskThreadImpl#getRunnableField <em>Runnable Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SingleTaskThreadImpl extends EObjectImpl implements SingleTaskThread {
	/**
	 * The default value of the '{@link #isRunnable() <em>Runnable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRunnable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RUNNABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRunnable() <em>Runnable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRunnable()
	 * @generated
	 * @ordered
	 */
	protected boolean runnable = RUNNABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRunnableField() <em>Runnable Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunnableField()
	 * @generated
	 * @ordered
	 */
	protected RunnableField runnableField;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleTaskThreadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.SINGLE_TASK_THREAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRunnable() {
		return runnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunnable(boolean newRunnable) {
		boolean oldRunnable = runnable;
		runnable = newRunnable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.SINGLE_TASK_THREAD__RUNNABLE, oldRunnable, runnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunnableField getRunnableField() {
		return runnableField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRunnableField(RunnableField newRunnableField, NotificationChain msgs) {
		RunnableField oldRunnableField = runnableField;
		runnableField = newRunnableField;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD, oldRunnableField, newRunnableField);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunnableField(RunnableField newRunnableField) {
		if (newRunnableField != runnableField) {
			NotificationChain msgs = null;
			if (runnableField != null)
				msgs = ((InternalEObject)runnableField).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD, null, msgs);
			if (newRunnableField != null)
				msgs = ((InternalEObject)newRunnableField).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD, null, msgs);
			msgs = basicSetRunnableField(newRunnableField, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD, newRunnableField, newRunnableField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD:
				return basicSetRunnableField(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE:
				return isRunnable() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD:
				return getRunnableField();
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
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE:
				setRunnable(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD:
				setRunnableField((RunnableField)newValue);
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
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE:
				setRunnable(RUNNABLE_EDEFAULT);
				return;
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD:
				setRunnableField((RunnableField)null);
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
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE:
				return runnable != RUNNABLE_EDEFAULT;
			case AppletPackage.SINGLE_TASK_THREAD__RUNNABLE_FIELD:
				return runnableField != null;
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
		result.append(" (runnable: ");
		result.append(runnable);
		result.append(')');
		return result.toString();
	}

} //SingleTaskThreadImpl
