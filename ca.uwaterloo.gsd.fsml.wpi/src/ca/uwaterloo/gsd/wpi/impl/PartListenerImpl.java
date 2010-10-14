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
 * $Id: PartListenerImpl.java,v 1.7 2008/01/23 03:48:15 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.Part;
import ca.uwaterloo.gsd.wpi.PartListener;
import ca.uwaterloo.gsd.wpi.RegistersAPartListener;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Part Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.PartListenerImpl#getListener <em>Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.PartListenerImpl#getRegistersAPartListener <em>Registers APart Listener</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartListenerImpl extends ConceptImpl implements PartListener {
	/**
	 * The cached value of the '{@link #getListener() <em>Listener</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListener()
	 * @generated
	 * @ordered
	 */
	protected Part listener;

	/**
	 * The cached value of the '{@link #getRegistersAPartListener() <em>Registers APart Listener</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersAPartListener()
	 * @generated
	 * @ordered
	 */
	protected RegistersAPartListener registersAPartListener;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.PART_LISTENER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getListener() {
		if (listener != null && listener.eIsProxy()) {
			InternalEObject oldListener = (InternalEObject)listener;
			listener = (Part)eResolveProxy(oldListener);
			if (listener != oldListener) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WpiPackage.PART_LISTENER__LISTENER, oldListener, listener));
			}
		}
		return listener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetListener() {
		return listener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListener(Part newListener) {
		Part oldListener = listener;
		listener = newListener;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.PART_LISTENER__LISTENER, oldListener, listener));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersAPartListener getRegistersAPartListener() {
		return registersAPartListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegistersAPartListener(RegistersAPartListener newRegistersAPartListener, NotificationChain msgs) {
		RegistersAPartListener oldRegistersAPartListener = registersAPartListener;
		registersAPartListener = newRegistersAPartListener;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER, oldRegistersAPartListener, newRegistersAPartListener);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistersAPartListener(RegistersAPartListener newRegistersAPartListener) {
		if (newRegistersAPartListener != registersAPartListener) {
			NotificationChain msgs = null;
			if (registersAPartListener != null)
				msgs = ((InternalEObject)registersAPartListener).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER, null, msgs);
			if (newRegistersAPartListener != null)
				msgs = ((InternalEObject)newRegistersAPartListener).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER, null, msgs);
			msgs = basicSetRegistersAPartListener(newRegistersAPartListener, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER, newRegistersAPartListener, newRegistersAPartListener));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER:
				return basicSetRegistersAPartListener(null, msgs);
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
			case WpiPackage.PART_LISTENER__LISTENER:
				if (resolve) return getListener();
				return basicGetListener();
			case WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER:
				return getRegistersAPartListener();
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
			case WpiPackage.PART_LISTENER__LISTENER:
				setListener((Part)newValue);
				return;
			case WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER:
				setRegistersAPartListener((RegistersAPartListener)newValue);
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
			case WpiPackage.PART_LISTENER__LISTENER:
				setListener((Part)null);
				return;
			case WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER:
				setRegistersAPartListener((RegistersAPartListener)null);
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
			case WpiPackage.PART_LISTENER__LISTENER:
				return listener != null;
			case WpiPackage.PART_LISTENER__REGISTERS_APART_LISTENER:
				return registersAPartListener != null;
		}
		return super.eIsSet(featureID);
	}

} //PartListenerImpl
