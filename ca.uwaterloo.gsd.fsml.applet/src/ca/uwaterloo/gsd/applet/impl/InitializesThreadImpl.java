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
 * $Id: InitializesThreadImpl.java,v 1.2 2008/02/21 20:09:37 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.InitializesThread;
import ca.uwaterloo.gsd.applet.InitializesThreadSubclass;
import ca.uwaterloo.gsd.applet.InitializesThreadWith;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initializes Thread</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadImpl#getInitializesThreadWithRunnable <em>Initializes Thread With Runnable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadImpl#getInitializesWithThreadSubclass <em>Initializes With Thread Subclass</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitializesThreadImpl extends EObjectImpl implements InitializesThread {
	/**
	 * The cached value of the '{@link #getInitializesThreadWithRunnable() <em>Initializes Thread With Runnable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializesThreadWithRunnable()
	 * @generated
	 * @ordered
	 */
	protected InitializesThreadWith initializesThreadWithRunnable;

	/**
	 * The cached value of the '{@link #getInitializesWithThreadSubclass() <em>Initializes With Thread Subclass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializesWithThreadSubclass()
	 * @generated
	 * @ordered
	 */
	protected InitializesThreadSubclass initializesWithThreadSubclass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitializesThreadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.INITIALIZES_THREAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializesThreadWith getInitializesThreadWithRunnable() {
		return initializesThreadWithRunnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializesThreadWithRunnable(InitializesThreadWith newInitializesThreadWithRunnable, NotificationChain msgs) {
		InitializesThreadWith oldInitializesThreadWithRunnable = initializesThreadWithRunnable;
		initializesThreadWithRunnable = newInitializesThreadWithRunnable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE, oldInitializesThreadWithRunnable, newInitializesThreadWithRunnable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializesThreadWithRunnable(InitializesThreadWith newInitializesThreadWithRunnable) {
		if (newInitializesThreadWithRunnable != initializesThreadWithRunnable) {
			NotificationChain msgs = null;
			if (initializesThreadWithRunnable != null)
				msgs = ((InternalEObject)initializesThreadWithRunnable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE, null, msgs);
			if (newInitializesThreadWithRunnable != null)
				msgs = ((InternalEObject)newInitializesThreadWithRunnable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE, null, msgs);
			msgs = basicSetInitializesThreadWithRunnable(newInitializesThreadWithRunnable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE, newInitializesThreadWithRunnable, newInitializesThreadWithRunnable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializesThreadSubclass getInitializesWithThreadSubclass() {
		return initializesWithThreadSubclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializesWithThreadSubclass(InitializesThreadSubclass newInitializesWithThreadSubclass, NotificationChain msgs) {
		InitializesThreadSubclass oldInitializesWithThreadSubclass = initializesWithThreadSubclass;
		initializesWithThreadSubclass = newInitializesWithThreadSubclass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS, oldInitializesWithThreadSubclass, newInitializesWithThreadSubclass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializesWithThreadSubclass(InitializesThreadSubclass newInitializesWithThreadSubclass) {
		if (newInitializesWithThreadSubclass != initializesWithThreadSubclass) {
			NotificationChain msgs = null;
			if (initializesWithThreadSubclass != null)
				msgs = ((InternalEObject)initializesWithThreadSubclass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS, null, msgs);
			if (newInitializesWithThreadSubclass != null)
				msgs = ((InternalEObject)newInitializesWithThreadSubclass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS, null, msgs);
			msgs = basicSetInitializesWithThreadSubclass(newInitializesWithThreadSubclass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS, newInitializesWithThreadSubclass, newInitializesWithThreadSubclass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE:
				return basicSetInitializesThreadWithRunnable(null, msgs);
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS:
				return basicSetInitializesWithThreadSubclass(null, msgs);
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
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE:
				return getInitializesThreadWithRunnable();
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS:
				return getInitializesWithThreadSubclass();
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
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE:
				setInitializesThreadWithRunnable((InitializesThreadWith)newValue);
				return;
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS:
				setInitializesWithThreadSubclass((InitializesThreadSubclass)newValue);
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
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE:
				setInitializesThreadWithRunnable((InitializesThreadWith)null);
				return;
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS:
				setInitializesWithThreadSubclass((InitializesThreadSubclass)null);
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
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE:
				return initializesThreadWithRunnable != null;
			case AppletPackage.INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS:
				return initializesWithThreadSubclass != null;
		}
		return super.eIsSet(featureID);
	}

} //InitializesThreadImpl
