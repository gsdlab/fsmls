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
 * $Id: DeregistersImpl.java,v 1.3 2008/01/23 03:48:15 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.Deregisters;
import ca.uwaterloo.gsd.wpi.DeregistersSameObject;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deregisters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.DeregistersImpl#getDeregistersSameObject <em>Deregisters Same Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeregistersImpl extends ConceptImpl implements Deregisters {
	/**
	 * The cached value of the '{@link #getDeregistersSameObject() <em>Deregisters Same Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeregistersSameObject()
	 * @generated
	 * @ordered
	 */
	protected DeregistersSameObject deregistersSameObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeregistersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.DEREGISTERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeregistersSameObject getDeregistersSameObject() {
		return deregistersSameObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeregistersSameObject(DeregistersSameObject newDeregistersSameObject, NotificationChain msgs) {
		DeregistersSameObject oldDeregistersSameObject = deregistersSameObject;
		deregistersSameObject = newDeregistersSameObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT, oldDeregistersSameObject, newDeregistersSameObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeregistersSameObject(DeregistersSameObject newDeregistersSameObject) {
		if (newDeregistersSameObject != deregistersSameObject) {
			NotificationChain msgs = null;
			if (deregistersSameObject != null)
				msgs = ((InternalEObject)deregistersSameObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT, null, msgs);
			if (newDeregistersSameObject != null)
				msgs = ((InternalEObject)newDeregistersSameObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT, null, msgs);
			msgs = basicSetDeregistersSameObject(newDeregistersSameObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT, newDeregistersSameObject, newDeregistersSameObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT:
				return basicSetDeregistersSameObject(null, msgs);
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
			case WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT:
				return getDeregistersSameObject();
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
			case WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT:
				setDeregistersSameObject((DeregistersSameObject)newValue);
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
			case WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT:
				setDeregistersSameObject((DeregistersSameObject)null);
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
			case WpiPackage.DEREGISTERS__DEREGISTERS_SAME_OBJECT:
				return deregistersSameObject != null;
		}
		return super.eIsSet(featureID);
	}

} //DeregistersImpl
