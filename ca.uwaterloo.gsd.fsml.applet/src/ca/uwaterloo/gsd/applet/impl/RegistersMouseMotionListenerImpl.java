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
 * $Id: RegistersMouseMotionListenerImpl.java,v 1.1 2008/02/24 20:36:03 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.MouseMotionListenerField;
import ca.uwaterloo.gsd.applet.RegistersMouseMotionListener;
import ca.uwaterloo.gsd.applet.ThisMouseMotionListener;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registers Mouse Motion Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.RegistersMouseMotionListenerImpl#getThis <em>This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.RegistersMouseMotionListenerImpl#getMouseMotionListenerField <em>Mouse Motion Listener Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistersMouseMotionListenerImpl extends ConceptImpl implements RegistersMouseMotionListener {
	/**
	 * The cached value of the '{@link #getThis() <em>This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThis()
	 * @generated
	 * @ordered
	 */
	protected ThisMouseMotionListener this_;

	/**
	 * The cached value of the '{@link #getMouseMotionListenerField() <em>Mouse Motion Listener Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMouseMotionListenerField()
	 * @generated
	 * @ordered
	 */
	protected MouseMotionListenerField mouseMotionListenerField;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegistersMouseMotionListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.REGISTERS_MOUSE_MOTION_LISTENER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisMouseMotionListener getThis() {
		return this_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThis(ThisMouseMotionListener newThis, NotificationChain msgs) {
		ThisMouseMotionListener oldThis = this_;
		this_ = newThis;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS, oldThis, newThis);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThis(ThisMouseMotionListener newThis) {
		if (newThis != this_) {
			NotificationChain msgs = null;
			if (this_ != null)
				msgs = ((InternalEObject)this_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS, null, msgs);
			if (newThis != null)
				msgs = ((InternalEObject)newThis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS, null, msgs);
			msgs = basicSetThis(newThis, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS, newThis, newThis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseMotionListenerField getMouseMotionListenerField() {
		return mouseMotionListenerField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMouseMotionListenerField(MouseMotionListenerField newMouseMotionListenerField, NotificationChain msgs) {
		MouseMotionListenerField oldMouseMotionListenerField = mouseMotionListenerField;
		mouseMotionListenerField = newMouseMotionListenerField;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD, oldMouseMotionListenerField, newMouseMotionListenerField);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMouseMotionListenerField(MouseMotionListenerField newMouseMotionListenerField) {
		if (newMouseMotionListenerField != mouseMotionListenerField) {
			NotificationChain msgs = null;
			if (mouseMotionListenerField != null)
				msgs = ((InternalEObject)mouseMotionListenerField).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD, null, msgs);
			if (newMouseMotionListenerField != null)
				msgs = ((InternalEObject)newMouseMotionListenerField).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD, null, msgs);
			msgs = basicSetMouseMotionListenerField(newMouseMotionListenerField, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD, newMouseMotionListenerField, newMouseMotionListenerField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS:
				return basicSetThis(null, msgs);
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD:
				return basicSetMouseMotionListenerField(null, msgs);
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
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS:
				return getThis();
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD:
				return getMouseMotionListenerField();
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
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS:
				setThis((ThisMouseMotionListener)newValue);
				return;
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD:
				setMouseMotionListenerField((MouseMotionListenerField)newValue);
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
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS:
				setThis((ThisMouseMotionListener)null);
				return;
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD:
				setMouseMotionListenerField((MouseMotionListenerField)null);
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
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__THIS:
				return this_ != null;
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD:
				return mouseMotionListenerField != null;
		}
		return super.eIsSet(featureID);
	}

} //RegistersMouseMotionListenerImpl
