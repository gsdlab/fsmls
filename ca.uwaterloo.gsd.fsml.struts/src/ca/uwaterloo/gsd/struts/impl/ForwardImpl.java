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
 * $Id: ForwardImpl.java,v 1.4 2009/04/21 16:47:57 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.struts.Forward;
import ca.uwaterloo.gsd.struts.ForwardDecl;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forward</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ForwardImpl#getLocalForward <em>Local Forward</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ForwardImpl#getGlobalForward <em>Global Forward</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForwardImpl extends ConceptImpl implements Forward {
	/**
	 * The cached value of the '{@link #getLocalForward() <em>Local Forward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalForward()
	 * @generated
	 * @ordered
	 */
	protected ForwardDecl localForward;

	/**
	 * The cached value of the '{@link #getGlobalForward() <em>Global Forward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalForward()
	 * @generated
	 * @ordered
	 */
	protected ForwardDecl globalForward;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForwardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.FORWARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardDecl getLocalForward() {
		if (localForward != null && localForward.eIsProxy()) {
			InternalEObject oldLocalForward = (InternalEObject)localForward;
			localForward = (ForwardDecl)eResolveProxy(oldLocalForward);
			if (localForward != oldLocalForward) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StrutsPackage.FORWARD__LOCAL_FORWARD, oldLocalForward, localForward));
			}
		}
		return localForward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardDecl basicGetLocalForward() {
		return localForward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalForward(ForwardDecl newLocalForward) {
		ForwardDecl oldLocalForward = localForward;
		localForward = newLocalForward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORWARD__LOCAL_FORWARD, oldLocalForward, localForward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardDecl getGlobalForward() {
		if (globalForward != null && globalForward.eIsProxy()) {
			InternalEObject oldGlobalForward = (InternalEObject)globalForward;
			globalForward = (ForwardDecl)eResolveProxy(oldGlobalForward);
			if (globalForward != oldGlobalForward) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StrutsPackage.FORWARD__GLOBAL_FORWARD, oldGlobalForward, globalForward));
			}
		}
		return globalForward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardDecl basicGetGlobalForward() {
		return globalForward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalForward(ForwardDecl newGlobalForward) {
		ForwardDecl oldGlobalForward = globalForward;
		globalForward = newGlobalForward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORWARD__GLOBAL_FORWARD, oldGlobalForward, globalForward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StrutsPackage.FORWARD__LOCAL_FORWARD:
				if (resolve) return getLocalForward();
				return basicGetLocalForward();
			case StrutsPackage.FORWARD__GLOBAL_FORWARD:
				if (resolve) return getGlobalForward();
				return basicGetGlobalForward();
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
			case StrutsPackage.FORWARD__LOCAL_FORWARD:
				setLocalForward((ForwardDecl)newValue);
				return;
			case StrutsPackage.FORWARD__GLOBAL_FORWARD:
				setGlobalForward((ForwardDecl)newValue);
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
			case StrutsPackage.FORWARD__LOCAL_FORWARD:
				setLocalForward((ForwardDecl)null);
				return;
			case StrutsPackage.FORWARD__GLOBAL_FORWARD:
				setGlobalForward((ForwardDecl)null);
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
			case StrutsPackage.FORWARD__LOCAL_FORWARD:
				return localForward != null;
			case StrutsPackage.FORWARD__GLOBAL_FORWARD:
				return globalForward != null;
		}
		return super.eIsSet(featureID);
	}

} //ForwardImpl
