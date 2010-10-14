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
 * $Id: RequestsAdapterImpl.java,v 1.7 2007/07/17 04:18:36 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.AdapterProvider;
import ca.uwaterloo.gsd.wpi.RequestsAdapter;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requests Adapter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RequestsAdapterImpl#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RequestsAdapterImpl#getAdapterProvider <em>Adapter Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequestsAdapterImpl extends ConceptImpl implements RequestsAdapter {
	/**
	 * The default value of the '{@link #getAdapter() <em>Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapter()
	 * @generated
	 * @ordered
	 */
	protected static final String ADAPTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdapter() <em>Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapter()
	 * @generated
	 * @ordered
	 */
	protected String adapter = ADAPTER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdapterProvider() <em>Adapter Provider</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapterProvider()
	 * @generated
	 * @ordered
	 */
	protected EList<AdapterProvider> adapterProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequestsAdapterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.REQUESTS_ADAPTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdapter() {
		return adapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapter(String newAdapter) {
		String oldAdapter = adapter;
		adapter = newAdapter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.REQUESTS_ADAPTER__ADAPTER, oldAdapter, adapter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdapterProvider> getAdapterProvider() {
		if (adapterProvider == null) {
			adapterProvider = new EObjectResolvingEList<AdapterProvider>(AdapterProvider.class, this, WpiPackage.REQUESTS_ADAPTER__ADAPTER_PROVIDER);
		}
		return adapterProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER:
				return getAdapter();
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER_PROVIDER:
				return getAdapterProvider();
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
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER:
				setAdapter((String)newValue);
				return;
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER_PROVIDER:
				getAdapterProvider().clear();
				getAdapterProvider().addAll((Collection<? extends AdapterProvider>)newValue);
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
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER:
				setAdapter(ADAPTER_EDEFAULT);
				return;
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER_PROVIDER:
				getAdapterProvider().clear();
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
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER:
				return ADAPTER_EDEFAULT == null ? adapter != null : !ADAPTER_EDEFAULT.equals(adapter);
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER_PROVIDER:
				return adapterProvider != null && !adapterProvider.isEmpty();
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
		result.append(" (adapter: ");
		result.append(adapter);
		result.append(')');
		return result.toString();
	}

} //RequestsAdapterImpl
