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
 * $Id: AdapterProviderImpl.java,v 1.7 2008/01/23 03:48:15 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.AdapterProvider;
import ca.uwaterloo.gsd.wpi.Part;
import ca.uwaterloo.gsd.wpi.ProvidesAdapter;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adapter Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.AdapterProviderImpl#getAdapterProvider <em>Adapter Provider</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.AdapterProviderImpl#getProvidesAdapter <em>Provides Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdapterProviderImpl extends ConceptImpl implements AdapterProvider {
	/**
	 * The cached value of the '{@link #getAdapterProvider() <em>Adapter Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapterProvider()
	 * @generated
	 * @ordered
	 */
	protected Part adapterProvider;

	/**
	 * The cached value of the '{@link #getProvidesAdapter() <em>Provides Adapter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidesAdapter()
	 * @generated
	 * @ordered
	 */
	protected ProvidesAdapter providesAdapter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.ADAPTER_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getAdapterProvider() {
		if (adapterProvider != null && adapterProvider.eIsProxy()) {
			InternalEObject oldAdapterProvider = (InternalEObject)adapterProvider;
			adapterProvider = (Part)eResolveProxy(oldAdapterProvider);
			if (adapterProvider != oldAdapterProvider) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WpiPackage.ADAPTER_PROVIDER__ADAPTER_PROVIDER, oldAdapterProvider, adapterProvider));
			}
		}
		return adapterProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetAdapterProvider() {
		return adapterProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdapterProvider(Part newAdapterProvider) {
		Part oldAdapterProvider = adapterProvider;
		adapterProvider = newAdapterProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.ADAPTER_PROVIDER__ADAPTER_PROVIDER, oldAdapterProvider, adapterProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesAdapter getProvidesAdapter() {
		return providesAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvidesAdapter(ProvidesAdapter newProvidesAdapter, NotificationChain msgs) {
		ProvidesAdapter oldProvidesAdapter = providesAdapter;
		providesAdapter = newProvidesAdapter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER, oldProvidesAdapter, newProvidesAdapter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidesAdapter(ProvidesAdapter newProvidesAdapter) {
		if (newProvidesAdapter != providesAdapter) {
			NotificationChain msgs = null;
			if (providesAdapter != null)
				msgs = ((InternalEObject)providesAdapter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER, null, msgs);
			if (newProvidesAdapter != null)
				msgs = ((InternalEObject)newProvidesAdapter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER, null, msgs);
			msgs = basicSetProvidesAdapter(newProvidesAdapter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER, newProvidesAdapter, newProvidesAdapter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER:
				return basicSetProvidesAdapter(null, msgs);
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
			case WpiPackage.ADAPTER_PROVIDER__ADAPTER_PROVIDER:
				if (resolve) return getAdapterProvider();
				return basicGetAdapterProvider();
			case WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER:
				return getProvidesAdapter();
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
			case WpiPackage.ADAPTER_PROVIDER__ADAPTER_PROVIDER:
				setAdapterProvider((Part)newValue);
				return;
			case WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER:
				setProvidesAdapter((ProvidesAdapter)newValue);
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
			case WpiPackage.ADAPTER_PROVIDER__ADAPTER_PROVIDER:
				setAdapterProvider((Part)null);
				return;
			case WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER:
				setProvidesAdapter((ProvidesAdapter)null);
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
			case WpiPackage.ADAPTER_PROVIDER__ADAPTER_PROVIDER:
				return adapterProvider != null;
			case WpiPackage.ADAPTER_PROVIDER__PROVIDES_ADAPTER:
				return providesAdapter != null;
		}
		return super.eIsSet(featureID);
	}

} //AdapterProviderImpl
