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
 * $Id: ThisKeyListenerImpl.java,v 1.1 2008/02/24 20:36:02 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.DeregistersThis;
import ca.uwaterloo.gsd.applet.ThisKeyListener;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>This Key Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.ThisKeyListenerImpl#isImplementsKeyListener <em>Implements Key Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.ThisKeyListenerImpl#getDeregisters <em>Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThisKeyListenerImpl extends ConceptImpl implements ThisKeyListener {
	/**
	 * The default value of the '{@link #isImplementsKeyListener() <em>Implements Key Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplementsKeyListener()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLEMENTS_KEY_LISTENER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isImplementsKeyListener() <em>Implements Key Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplementsKeyListener()
	 * @generated
	 * @ordered
	 */
	protected boolean implementsKeyListener = IMPLEMENTS_KEY_LISTENER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeregisters() <em>Deregisters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeregisters()
	 * @generated
	 * @ordered
	 */
	protected DeregistersThis deregisters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThisKeyListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.THIS_KEY_LISTENER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplementsKeyListener() {
		return implementsKeyListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementsKeyListener(boolean newImplementsKeyListener) {
		boolean oldImplementsKeyListener = implementsKeyListener;
		implementsKeyListener = newImplementsKeyListener;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.THIS_KEY_LISTENER__IMPLEMENTS_KEY_LISTENER, oldImplementsKeyListener, implementsKeyListener));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeregistersThis getDeregisters() {
		return deregisters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeregisters(DeregistersThis newDeregisters, NotificationChain msgs) {
		DeregistersThis oldDeregisters = deregisters;
		deregisters = newDeregisters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.THIS_KEY_LISTENER__DEREGISTERS, oldDeregisters, newDeregisters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeregisters(DeregistersThis newDeregisters) {
		if (newDeregisters != deregisters) {
			NotificationChain msgs = null;
			if (deregisters != null)
				msgs = ((InternalEObject)deregisters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.THIS_KEY_LISTENER__DEREGISTERS, null, msgs);
			if (newDeregisters != null)
				msgs = ((InternalEObject)newDeregisters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.THIS_KEY_LISTENER__DEREGISTERS, null, msgs);
			msgs = basicSetDeregisters(newDeregisters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.THIS_KEY_LISTENER__DEREGISTERS, newDeregisters, newDeregisters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.THIS_KEY_LISTENER__DEREGISTERS:
				return basicSetDeregisters(null, msgs);
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
			case AppletPackage.THIS_KEY_LISTENER__IMPLEMENTS_KEY_LISTENER:
				return isImplementsKeyListener() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.THIS_KEY_LISTENER__DEREGISTERS:
				return getDeregisters();
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
			case AppletPackage.THIS_KEY_LISTENER__IMPLEMENTS_KEY_LISTENER:
				setImplementsKeyListener(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.THIS_KEY_LISTENER__DEREGISTERS:
				setDeregisters((DeregistersThis)newValue);
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
			case AppletPackage.THIS_KEY_LISTENER__IMPLEMENTS_KEY_LISTENER:
				setImplementsKeyListener(IMPLEMENTS_KEY_LISTENER_EDEFAULT);
				return;
			case AppletPackage.THIS_KEY_LISTENER__DEREGISTERS:
				setDeregisters((DeregistersThis)null);
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
			case AppletPackage.THIS_KEY_LISTENER__IMPLEMENTS_KEY_LISTENER:
				return implementsKeyListener != IMPLEMENTS_KEY_LISTENER_EDEFAULT;
			case AppletPackage.THIS_KEY_LISTENER__DEREGISTERS:
				return deregisters != null;
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
		result.append(" (implementsKeyListener: ");
		result.append(implementsKeyListener);
		result.append(')');
		return result.toString();
	}

} //ThisKeyListenerImpl
