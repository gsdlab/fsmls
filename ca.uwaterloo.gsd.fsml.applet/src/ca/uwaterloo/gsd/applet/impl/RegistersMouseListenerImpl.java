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
 * $Id: RegistersMouseListenerImpl.java,v 1.5 2008/01/23 03:47:52 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.MouseListenerField;
import ca.uwaterloo.gsd.applet.RegistersMouseListener;
import ca.uwaterloo.gsd.applet.ThisMouseListener;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registers Mouse Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.RegistersMouseListenerImpl#getThis <em>This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.RegistersMouseListenerImpl#getMouseListenerField <em>Mouse Listener Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistersMouseListenerImpl extends ConceptImpl implements RegistersMouseListener {
	/**
	 * The cached value of the '{@link #getThis() <em>This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThis()
	 * @generated
	 * @ordered
	 */
	protected ThisMouseListener this_;

	/**
	 * The cached value of the '{@link #getMouseListenerField() <em>Mouse Listener Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMouseListenerField()
	 * @generated
	 * @ordered
	 */
	protected MouseListenerField mouseListenerField;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegistersMouseListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.REGISTERS_MOUSE_LISTENER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisMouseListener getThis() {
		return this_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThis(ThisMouseListener newThis, NotificationChain msgs) {
		ThisMouseListener oldThis = this_;
		this_ = newThis;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_MOUSE_LISTENER__THIS, oldThis, newThis);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThis(ThisMouseListener newThis) {
		if (newThis != this_) {
			NotificationChain msgs = null;
			if (this_ != null)
				msgs = ((InternalEObject)this_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_MOUSE_LISTENER__THIS, null, msgs);
			if (newThis != null)
				msgs = ((InternalEObject)newThis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_MOUSE_LISTENER__THIS, null, msgs);
			msgs = basicSetThis(newThis, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_MOUSE_LISTENER__THIS, newThis, newThis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseListenerField getMouseListenerField() {
		return mouseListenerField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMouseListenerField(MouseListenerField newMouseListenerField, NotificationChain msgs) {
		MouseListenerField oldMouseListenerField = mouseListenerField;
		mouseListenerField = newMouseListenerField;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD, oldMouseListenerField, newMouseListenerField);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMouseListenerField(MouseListenerField newMouseListenerField) {
		if (newMouseListenerField != mouseListenerField) {
			NotificationChain msgs = null;
			if (mouseListenerField != null)
				msgs = ((InternalEObject)mouseListenerField).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD, null, msgs);
			if (newMouseListenerField != null)
				msgs = ((InternalEObject)newMouseListenerField).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD, null, msgs);
			msgs = basicSetMouseListenerField(newMouseListenerField, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD, newMouseListenerField, newMouseListenerField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.REGISTERS_MOUSE_LISTENER__THIS:
				return basicSetThis(null, msgs);
			case AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD:
				return basicSetMouseListenerField(null, msgs);
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
			case AppletPackage.REGISTERS_MOUSE_LISTENER__THIS:
				return getThis();
			case AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD:
				return getMouseListenerField();
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
			case AppletPackage.REGISTERS_MOUSE_LISTENER__THIS:
				setThis((ThisMouseListener)newValue);
				return;
			case AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD:
				setMouseListenerField((MouseListenerField)newValue);
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
			case AppletPackage.REGISTERS_MOUSE_LISTENER__THIS:
				setThis((ThisMouseListener)null);
				return;
			case AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD:
				setMouseListenerField((MouseListenerField)null);
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
			case AppletPackage.REGISTERS_MOUSE_LISTENER__THIS:
				return this_ != null;
			case AppletPackage.REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD:
				return mouseListenerField != null;
		}
		return super.eIsSet(featureID);
	}

} //RegistersMouseListenerImpl
