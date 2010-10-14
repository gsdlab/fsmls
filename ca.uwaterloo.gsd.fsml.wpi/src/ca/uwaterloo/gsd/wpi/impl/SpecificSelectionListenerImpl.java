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
 * $Id: SpecificSelectionListenerImpl.java,v 1.4 2008/02/29 22:33:02 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
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
import ca.uwaterloo.gsd.wpi.DeregistersSamePartId;
import ca.uwaterloo.gsd.wpi.Part;
import ca.uwaterloo.gsd.wpi.SpecificSelectionListener;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Selection Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.SpecificSelectionListenerImpl#getRegistrationPartId <em>Registration Part Id</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.SpecificSelectionListenerImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.SpecificSelectionListenerImpl#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.SpecificSelectionListenerImpl#getDeregisters <em>Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificSelectionListenerImpl extends ConceptImpl implements SpecificSelectionListener {
	/**
	 * The default value of the '{@link #getRegistrationPartId() <em>Registration Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationPartId()
	 * @generated
	 * @ordered
	 */
	protected static final String REGISTRATION_PART_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegistrationPartId() <em>Registration Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistrationPartId()
	 * @generated
	 * @ordered
	 */
	protected String registrationPartId = REGISTRATION_PART_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected Part provider;

	/**
	 * The default value of the '{@link #getProviderName() <em>Provider Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeregisters() <em>Deregisters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeregisters()
	 * @generated
	 * @ordered
	 */
	protected EList<DeregistersSamePartId> deregisters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificSelectionListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.SPECIFIC_SELECTION_LISTENER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegistrationPartId() {
		return registrationPartId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistrationPartId(String newRegistrationPartId) {
		String oldRegistrationPartId = registrationPartId;
		registrationPartId = newRegistrationPartId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.SPECIFIC_SELECTION_LISTENER__REGISTRATION_PART_ID, oldRegistrationPartId, registrationPartId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part getProvider() {
		if (provider != null && provider.eIsProxy()) {
			InternalEObject oldProvider = (InternalEObject)provider;
			provider = (Part)eResolveProxy(oldProvider);
			if (provider != oldProvider) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WpiPackage.SPECIFIC_SELECTION_LISTENER__PROVIDER, oldProvider, provider));
			}
		}
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part basicGetProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvider(Part newProvider) {
		Part oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.SPECIFIC_SELECTION_LISTENER__PROVIDER, oldProvider, provider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getProviderName() {
		return provider != null ?
				provider.getName() :
				"<unknown provider>";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetProviderName() {
		return provider != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeregistersSamePartId> getDeregisters() {
		if (deregisters == null) {
			deregisters = new EObjectContainmentEList<DeregistersSamePartId>(DeregistersSamePartId.class, this, WpiPackage.SPECIFIC_SELECTION_LISTENER__DEREGISTERS);
		}
		return deregisters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__DEREGISTERS:
				return ((InternalEList<?>)getDeregisters()).basicRemove(otherEnd, msgs);
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
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__REGISTRATION_PART_ID:
				return getRegistrationPartId();
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__PROVIDER:
				if (resolve) return getProvider();
				return basicGetProvider();
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__PROVIDER_NAME:
				return getProviderName();
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__DEREGISTERS:
				return getDeregisters();
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
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__REGISTRATION_PART_ID:
				setRegistrationPartId((String)newValue);
				return;
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__PROVIDER:
				setProvider((Part)newValue);
				return;
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__DEREGISTERS:
				getDeregisters().clear();
				getDeregisters().addAll((Collection<? extends DeregistersSamePartId>)newValue);
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
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__REGISTRATION_PART_ID:
				setRegistrationPartId(REGISTRATION_PART_ID_EDEFAULT);
				return;
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__PROVIDER:
				setProvider((Part)null);
				return;
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__DEREGISTERS:
				getDeregisters().clear();
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
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__REGISTRATION_PART_ID:
				return REGISTRATION_PART_ID_EDEFAULT == null ? registrationPartId != null : !REGISTRATION_PART_ID_EDEFAULT.equals(registrationPartId);
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__PROVIDER:
				return provider != null;
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__PROVIDER_NAME:
				return isSetProviderName();
			case WpiPackage.SPECIFIC_SELECTION_LISTENER__DEREGISTERS:
				return deregisters != null && !deregisters.isEmpty();
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
		result.append(" (registrationPartId: ");
		result.append(registrationPartId);
		result.append(')');
		return result.toString();
	}

} //SpecificSelectionListenerImpl
