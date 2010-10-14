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
 * $Id: RegistersKeyListenerImpl.java,v 1.1 2008/02/24 20:36:02 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.KeyListenerField;
import ca.uwaterloo.gsd.applet.RegistersKeyListener;
import ca.uwaterloo.gsd.applet.ThisKeyListener;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registers Key Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.RegistersKeyListenerImpl#getThis <em>This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.RegistersKeyListenerImpl#getKeyListenerField <em>Key Listener Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistersKeyListenerImpl extends ConceptImpl implements RegistersKeyListener {
	/**
	 * The cached value of the '{@link #getThis() <em>This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThis()
	 * @generated
	 * @ordered
	 */
	protected ThisKeyListener this_;

	/**
	 * The cached value of the '{@link #getKeyListenerField() <em>Key Listener Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyListenerField()
	 * @generated
	 * @ordered
	 */
	protected KeyListenerField keyListenerField;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegistersKeyListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.REGISTERS_KEY_LISTENER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisKeyListener getThis() {
		return this_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThis(ThisKeyListener newThis, NotificationChain msgs) {
		ThisKeyListener oldThis = this_;
		this_ = newThis;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_KEY_LISTENER__THIS, oldThis, newThis);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThis(ThisKeyListener newThis) {
		if (newThis != this_) {
			NotificationChain msgs = null;
			if (this_ != null)
				msgs = ((InternalEObject)this_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_KEY_LISTENER__THIS, null, msgs);
			if (newThis != null)
				msgs = ((InternalEObject)newThis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_KEY_LISTENER__THIS, null, msgs);
			msgs = basicSetThis(newThis, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_KEY_LISTENER__THIS, newThis, newThis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyListenerField getKeyListenerField() {
		return keyListenerField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKeyListenerField(KeyListenerField newKeyListenerField, NotificationChain msgs) {
		KeyListenerField oldKeyListenerField = keyListenerField;
		keyListenerField = newKeyListenerField;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD, oldKeyListenerField, newKeyListenerField);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyListenerField(KeyListenerField newKeyListenerField) {
		if (newKeyListenerField != keyListenerField) {
			NotificationChain msgs = null;
			if (keyListenerField != null)
				msgs = ((InternalEObject)keyListenerField).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD, null, msgs);
			if (newKeyListenerField != null)
				msgs = ((InternalEObject)newKeyListenerField).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD, null, msgs);
			msgs = basicSetKeyListenerField(newKeyListenerField, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD, newKeyListenerField, newKeyListenerField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.REGISTERS_KEY_LISTENER__THIS:
				return basicSetThis(null, msgs);
			case AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD:
				return basicSetKeyListenerField(null, msgs);
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
			case AppletPackage.REGISTERS_KEY_LISTENER__THIS:
				return getThis();
			case AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD:
				return getKeyListenerField();
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
			case AppletPackage.REGISTERS_KEY_LISTENER__THIS:
				setThis((ThisKeyListener)newValue);
				return;
			case AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD:
				setKeyListenerField((KeyListenerField)newValue);
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
			case AppletPackage.REGISTERS_KEY_LISTENER__THIS:
				setThis((ThisKeyListener)null);
				return;
			case AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD:
				setKeyListenerField((KeyListenerField)null);
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
			case AppletPackage.REGISTERS_KEY_LISTENER__THIS:
				return this_ != null;
			case AppletPackage.REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD:
				return keyListenerField != null;
		}
		return super.eIsSet(featureID);
	}

} //RegistersKeyListenerImpl
