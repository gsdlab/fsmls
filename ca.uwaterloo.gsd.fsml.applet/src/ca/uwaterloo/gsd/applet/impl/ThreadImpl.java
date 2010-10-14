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
 * $Id: ThreadImpl.java,v 1.9 2008/02/21 20:09:37 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.InitializesThread;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.ThreadImpl#getThread <em>Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.ThreadImpl#isTypedThread <em>Typed Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.ThreadImpl#getInitializesThread <em>Initializes Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.ThreadImpl#isNullifiesThread <em>Nullifies Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThreadImpl extends ConceptImpl implements ca.uwaterloo.gsd.applet.Thread {
	/**
	 * The default value of the '{@link #getThread() <em>Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThread()
	 * @generated
	 * @ordered
	 */
	protected static final String THREAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThread() <em>Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThread()
	 * @generated
	 * @ordered
	 */
	protected String thread = THREAD_EDEFAULT;

	/**
	 * The default value of the '{@link #isTypedThread() <em>Typed Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypedThread()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TYPED_THREAD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTypedThread() <em>Typed Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypedThread()
	 * @generated
	 * @ordered
	 */
	protected boolean typedThread = TYPED_THREAD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInitializesThread() <em>Initializes Thread</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializesThread()
	 * @generated
	 * @ordered
	 */
	protected InitializesThread initializesThread;

	/**
	 * The default value of the '{@link #isNullifiesThread() <em>Nullifies Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullifiesThread()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULLIFIES_THREAD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isNullifiesThread() <em>Nullifies Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullifiesThread()
	 * @generated
	 * @ordered
	 */
	protected boolean nullifiesThread = NULLIFIES_THREAD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.THREAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThread() {
		return thread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThread(String newThread) {
		String oldThread = thread;
		thread = newThread;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.THREAD__THREAD, oldThread, thread));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypedThread() {
		return typedThread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedThread(boolean newTypedThread) {
		boolean oldTypedThread = typedThread;
		typedThread = newTypedThread;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.THREAD__TYPED_THREAD, oldTypedThread, typedThread));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializesThread getInitializesThread() {
		return initializesThread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializesThread(InitializesThread newInitializesThread, NotificationChain msgs) {
		InitializesThread oldInitializesThread = initializesThread;
		initializesThread = newInitializesThread;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.THREAD__INITIALIZES_THREAD, oldInitializesThread, newInitializesThread);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializesThread(InitializesThread newInitializesThread) {
		if (newInitializesThread != initializesThread) {
			NotificationChain msgs = null;
			if (initializesThread != null)
				msgs = ((InternalEObject)initializesThread).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.THREAD__INITIALIZES_THREAD, null, msgs);
			if (newInitializesThread != null)
				msgs = ((InternalEObject)newInitializesThread).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.THREAD__INITIALIZES_THREAD, null, msgs);
			msgs = basicSetInitializesThread(newInitializesThread, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.THREAD__INITIALIZES_THREAD, newInitializesThread, newInitializesThread));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullifiesThread() {
		return nullifiesThread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullifiesThread(boolean newNullifiesThread) {
		boolean oldNullifiesThread = nullifiesThread;
		nullifiesThread = newNullifiesThread;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.THREAD__NULLIFIES_THREAD, oldNullifiesThread, nullifiesThread));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.THREAD__INITIALIZES_THREAD:
				return basicSetInitializesThread(null, msgs);
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
			case AppletPackage.THREAD__THREAD:
				return getThread();
			case AppletPackage.THREAD__TYPED_THREAD:
				return isTypedThread() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.THREAD__INITIALIZES_THREAD:
				return getInitializesThread();
			case AppletPackage.THREAD__NULLIFIES_THREAD:
				return isNullifiesThread() ? Boolean.TRUE : Boolean.FALSE;
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
			case AppletPackage.THREAD__THREAD:
				setThread((String)newValue);
				return;
			case AppletPackage.THREAD__TYPED_THREAD:
				setTypedThread(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.THREAD__INITIALIZES_THREAD:
				setInitializesThread((InitializesThread)newValue);
				return;
			case AppletPackage.THREAD__NULLIFIES_THREAD:
				setNullifiesThread(((Boolean)newValue).booleanValue());
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
			case AppletPackage.THREAD__THREAD:
				setThread(THREAD_EDEFAULT);
				return;
			case AppletPackage.THREAD__TYPED_THREAD:
				setTypedThread(TYPED_THREAD_EDEFAULT);
				return;
			case AppletPackage.THREAD__INITIALIZES_THREAD:
				setInitializesThread((InitializesThread)null);
				return;
			case AppletPackage.THREAD__NULLIFIES_THREAD:
				setNullifiesThread(NULLIFIES_THREAD_EDEFAULT);
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
			case AppletPackage.THREAD__THREAD:
				return THREAD_EDEFAULT == null ? thread != null : !THREAD_EDEFAULT.equals(thread);
			case AppletPackage.THREAD__TYPED_THREAD:
				return typedThread != TYPED_THREAD_EDEFAULT;
			case AppletPackage.THREAD__INITIALIZES_THREAD:
				return initializesThread != null;
			case AppletPackage.THREAD__NULLIFIES_THREAD:
				return nullifiesThread != NULLIFIES_THREAD_EDEFAULT;
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
		result.append(" (thread: ");
		result.append(thread);
		result.append(", typedThread: ");
		result.append(typedThread);
		result.append(", nullifiesThread: ");
		result.append(nullifiesThread);
		result.append(')');
		return result.toString();
	}

} //ThreadImpl
