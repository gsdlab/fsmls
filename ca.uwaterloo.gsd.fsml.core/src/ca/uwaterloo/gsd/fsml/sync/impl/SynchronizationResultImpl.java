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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncPackage;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Synchronization Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.SynchronizationResultImpl#getAssertedModel <em>Asserted Model</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.SynchronizationResultImpl#getImplementationModel <em>Implementation Model</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.impl.SynchronizationResultImpl#getClassSyncItems <em>Class Sync Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SynchronizationResultImpl extends EObjectImpl implements SynchronizationResult {
	/**
	 * The cached value of the '{@link #getAssertedModel() <em>Asserted Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssertedModel()
	 * @generated
	 * @ordered
	 */
	protected Model assertedModel;

	/**
	 * The cached value of the '{@link #getImplementationModel() <em>Implementation Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationModel()
	 * @generated
	 * @ordered
	 */
	protected Model implementationModel;

	/**
	 * The cached value of the '{@link #getClassSyncItems() <em>Class Sync Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassSyncItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassSyncItem> classSyncItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SynchronizationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SyncPackage.Literals.SYNCHRONIZATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getAssertedModel() {
		if (assertedModel != null && assertedModel.eIsProxy()) {
			InternalEObject oldAssertedModel = (InternalEObject)assertedModel;
			assertedModel = (Model)eResolveProxy(oldAssertedModel);
			if (assertedModel != oldAssertedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyncPackage.SYNCHRONIZATION_RESULT__ASSERTED_MODEL, oldAssertedModel, assertedModel));
			}
		}
		return assertedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetAssertedModel() {
		return assertedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssertedModel(Model newAssertedModel) {
		Model oldAssertedModel = assertedModel;
		assertedModel = newAssertedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncPackage.SYNCHRONIZATION_RESULT__ASSERTED_MODEL, oldAssertedModel, assertedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getImplementationModel() {
		if (implementationModel != null && implementationModel.eIsProxy()) {
			InternalEObject oldImplementationModel = (InternalEObject)implementationModel;
			implementationModel = (Model)eResolveProxy(oldImplementationModel);
			if (implementationModel != oldImplementationModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SyncPackage.SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL, oldImplementationModel, implementationModel));
			}
		}
		return implementationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetImplementationModel() {
		return implementationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationModel(Model newImplementationModel) {
		Model oldImplementationModel = implementationModel;
		implementationModel = newImplementationModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyncPackage.SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL, oldImplementationModel, implementationModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassSyncItem> getClassSyncItems() {
		if (classSyncItems == null) {
			classSyncItems = new EObjectContainmentEList<ClassSyncItem>(ClassSyncItem.class, this, SyncPackage.SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS);
		}
		return classSyncItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SyncPackage.SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS:
				return ((InternalEList<?>)getClassSyncItems()).basicRemove(otherEnd, msgs);
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
			case SyncPackage.SYNCHRONIZATION_RESULT__ASSERTED_MODEL:
				if (resolve) return getAssertedModel();
				return basicGetAssertedModel();
			case SyncPackage.SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL:
				if (resolve) return getImplementationModel();
				return basicGetImplementationModel();
			case SyncPackage.SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS:
				return getClassSyncItems();
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
			case SyncPackage.SYNCHRONIZATION_RESULT__ASSERTED_MODEL:
				setAssertedModel((Model)newValue);
				return;
			case SyncPackage.SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL:
				setImplementationModel((Model)newValue);
				return;
			case SyncPackage.SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS:
				getClassSyncItems().clear();
				getClassSyncItems().addAll((Collection<? extends ClassSyncItem>)newValue);
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
			case SyncPackage.SYNCHRONIZATION_RESULT__ASSERTED_MODEL:
				setAssertedModel((Model)null);
				return;
			case SyncPackage.SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL:
				setImplementationModel((Model)null);
				return;
			case SyncPackage.SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS:
				getClassSyncItems().clear();
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
			case SyncPackage.SYNCHRONIZATION_RESULT__ASSERTED_MODEL:
				return assertedModel != null;
			case SyncPackage.SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL:
				return implementationModel != null;
			case SyncPackage.SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS:
				return classSyncItems != null && !classSyncItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SynchronizationResultImpl
