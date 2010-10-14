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
 * $Id: SelectionListenerImpl.java,v 1.9 2008/01/23 03:48:15 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.Part;
import ca.uwaterloo.gsd.wpi.RegistersAs;
import ca.uwaterloo.gsd.wpi.SelectionListener;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.SelectionListenerImpl#getListener <em>Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.SelectionListenerImpl#getRegistersAs <em>Registers As</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionListenerImpl extends ConceptImpl implements SelectionListener {
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
	 * The cached value of the '{@link #getRegistersAs() <em>Registers As</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersAs()
	 * @generated
	 * @ordered
	 */
	protected RegistersAs registersAs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectionListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.SELECTION_LISTENER;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WpiPackage.SELECTION_LISTENER__LISTENER, oldListener, listener));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.SELECTION_LISTENER__LISTENER, oldListener, listener));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersAs getRegistersAs() {
		return registersAs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegistersAs(RegistersAs newRegistersAs, NotificationChain msgs) {
		RegistersAs oldRegistersAs = registersAs;
		registersAs = newRegistersAs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.SELECTION_LISTENER__REGISTERS_AS, oldRegistersAs, newRegistersAs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistersAs(RegistersAs newRegistersAs) {
		if (newRegistersAs != registersAs) {
			NotificationChain msgs = null;
			if (registersAs != null)
				msgs = ((InternalEObject)registersAs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.SELECTION_LISTENER__REGISTERS_AS, null, msgs);
			if (newRegistersAs != null)
				msgs = ((InternalEObject)newRegistersAs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.SELECTION_LISTENER__REGISTERS_AS, null, msgs);
			msgs = basicSetRegistersAs(newRegistersAs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.SELECTION_LISTENER__REGISTERS_AS, newRegistersAs, newRegistersAs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.SELECTION_LISTENER__REGISTERS_AS:
				return basicSetRegistersAs(null, msgs);
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
			case WpiPackage.SELECTION_LISTENER__LISTENER:
				if (resolve) return getListener();
				return basicGetListener();
			case WpiPackage.SELECTION_LISTENER__REGISTERS_AS:
				return getRegistersAs();
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
			case WpiPackage.SELECTION_LISTENER__LISTENER:
				setListener((Part)newValue);
				return;
			case WpiPackage.SELECTION_LISTENER__REGISTERS_AS:
				setRegistersAs((RegistersAs)newValue);
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
			case WpiPackage.SELECTION_LISTENER__LISTENER:
				setListener((Part)null);
				return;
			case WpiPackage.SELECTION_LISTENER__REGISTERS_AS:
				setRegistersAs((RegistersAs)null);
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
			case WpiPackage.SELECTION_LISTENER__LISTENER:
				return listener != null;
			case WpiPackage.SELECTION_LISTENER__REGISTERS_AS:
				return registersAs != null;
		}
		return super.eIsSet(featureID);
	}

} //SelectionListenerImpl
