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
package ca.uwaterloo.gsd.fsml.sync.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Sync Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.ClassSyncItemImpl#getSyncItems <em>Sync Items</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.ClassSyncItemImpl#getModel <em>Model</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.ClassSyncItemImpl#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassSyncItemImpl extends SyncItemImpl implements ClassSyncItem {
	/**
	 * The cached value of the '{@link #getSyncItems() <em>Sync Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSyncItems()
	 * @generated
	 * @ordered
	 */
	protected EList<SyncItem> syncItems;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EObject model;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected EObject code;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassSyncItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SyncPackage.Literals.CLASS_SYNC_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SyncItem> getSyncItems() {
		if (syncItems == null) {
			syncItems = new EObjectContainmentEList<SyncItem>(SyncItem.class, this, SyncPackage.CLASS_SYNC_ITEM__SYNC_ITEMS);
		}
		return syncItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyncPackage.CLASS_SYNC_ITEM__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(EObject newModel) {
		EObject oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncPackage.CLASS_SYNC_ITEM__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getCode() {
		if (code != null && code.eIsProxy()) {
			InternalEObject oldCode = (InternalEObject)code;
			code = eResolveProxy(oldCode);
			if (code != oldCode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyncPackage.CLASS_SYNC_ITEM__CODE, oldCode, code));
			}
		}
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(EObject newCode) {
		EObject oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncPackage.CLASS_SYNC_ITEM__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SyncPackage.CLASS_SYNC_ITEM__SYNC_ITEMS:
				return ((InternalEList<?>)getSyncItems()).basicRemove(otherEnd, msgs);
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
			case SyncPackage.CLASS_SYNC_ITEM__SYNC_ITEMS:
				return getSyncItems();
			case SyncPackage.CLASS_SYNC_ITEM__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case SyncPackage.CLASS_SYNC_ITEM__CODE:
				if (resolve) return getCode();
				return basicGetCode();
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
			case SyncPackage.CLASS_SYNC_ITEM__SYNC_ITEMS:
				getSyncItems().clear();
				getSyncItems().addAll((Collection<? extends SyncItem>)newValue);
				return;
			case SyncPackage.CLASS_SYNC_ITEM__MODEL:
				setModel((EObject)newValue);
				return;
			case SyncPackage.CLASS_SYNC_ITEM__CODE:
				setCode((EObject)newValue);
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
			case SyncPackage.CLASS_SYNC_ITEM__SYNC_ITEMS:
				getSyncItems().clear();
				return;
			case SyncPackage.CLASS_SYNC_ITEM__MODEL:
				setModel((EObject)null);
				return;
			case SyncPackage.CLASS_SYNC_ITEM__CODE:
				setCode((EObject)null);
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
			case SyncPackage.CLASS_SYNC_ITEM__SYNC_ITEMS:
				return syncItems != null && !syncItems.isEmpty();
			case SyncPackage.CLASS_SYNC_ITEM__MODEL:
				return model != null;
			case SyncPackage.CLASS_SYNC_ITEM__CODE:
				return code != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassSyncItemImpl
