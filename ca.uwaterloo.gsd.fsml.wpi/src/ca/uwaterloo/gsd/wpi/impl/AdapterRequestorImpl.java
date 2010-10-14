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
 * $Id: AdapterRequestorImpl.java,v 1.5 2008/01/23 03:48:15 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.AdapterRequestor;
import ca.uwaterloo.gsd.wpi.Part;
import ca.uwaterloo.gsd.wpi.RequestsAdapter;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adapter Requestor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.AdapterRequestorImpl#getAdapterRequestor <em>Adapter Requestor</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.AdapterRequestorImpl#getRequestsAdapter <em>Requests Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdapterRequestorImpl extends ConceptImpl implements AdapterRequestor {
	/**
	 * The cached value of the '{@link #getAdapterRequestor() <em>Adapter Requestor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapterRequestor()
	 * @generated
	 * @ordered
	 */
	protected Part adapterRequestor;

	/**
	 * The cached value of the '{@link #getRequestsAdapter() <em>Requests Adapter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestsAdapter()
	 * @generated
	 * @ordered
	 */
	protected EList<RequestsAdapter> requestsAdapter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterRequestorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.ADAPTER_REQUESTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getAdapterRequestor() {
		if (adapterRequestor != null && adapterRequestor.eIsProxy()) {
			InternalEObject oldAdapterRequestor = (InternalEObject)adapterRequestor;
			adapterRequestor = (Part)eResolveProxy(oldAdapterRequestor);
			if (adapterRequestor != oldAdapterRequestor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WpiPackage.ADAPTER_REQUESTOR__ADAPTER_REQUESTOR, oldAdapterRequestor, adapterRequestor));
			}
		}
		return adapterRequestor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetAdapterRequestor() {
		return adapterRequestor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapterRequestor(Part newAdapterRequestor) {
		Part oldAdapterRequestor = adapterRequestor;
		adapterRequestor = newAdapterRequestor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.ADAPTER_REQUESTOR__ADAPTER_REQUESTOR, oldAdapterRequestor, adapterRequestor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequestsAdapter> getRequestsAdapter() {
		if (requestsAdapter == null) {
			requestsAdapter = new EObjectContainmentEList<RequestsAdapter>(RequestsAdapter.class, this, WpiPackage.ADAPTER_REQUESTOR__REQUESTS_ADAPTER);
		}
		return requestsAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.ADAPTER_REQUESTOR__REQUESTS_ADAPTER:
				return ((InternalEList<?>)getRequestsAdapter()).basicRemove(otherEnd, msgs);
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
			case WpiPackage.ADAPTER_REQUESTOR__ADAPTER_REQUESTOR:
				if (resolve) return getAdapterRequestor();
				return basicGetAdapterRequestor();
			case WpiPackage.ADAPTER_REQUESTOR__REQUESTS_ADAPTER:
				return getRequestsAdapter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WpiPackage.ADAPTER_REQUESTOR__ADAPTER_REQUESTOR:
				setAdapterRequestor((Part)newValue);
				return;
			case WpiPackage.ADAPTER_REQUESTOR__REQUESTS_ADAPTER:
				getRequestsAdapter().clear();
				getRequestsAdapter().addAll((Collection<? extends RequestsAdapter>)newValue);
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
			case WpiPackage.ADAPTER_REQUESTOR__ADAPTER_REQUESTOR:
				setAdapterRequestor((Part)null);
				return;
			case WpiPackage.ADAPTER_REQUESTOR__REQUESTS_ADAPTER:
				getRequestsAdapter().clear();
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
			case WpiPackage.ADAPTER_REQUESTOR__ADAPTER_REQUESTOR:
				return adapterRequestor != null;
			case WpiPackage.ADAPTER_REQUESTOR__REQUESTS_ADAPTER:
				return requestsAdapter != null && !requestsAdapter.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AdapterRequestorImpl
