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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.SyncPackage;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationResult;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SyncFactoryImpl extends EFactoryImpl implements SyncFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SyncFactory init() {
		try {
			SyncFactory theSyncFactory = (SyncFactory)EPackage.Registry.INSTANCE.getEFactory("http://ca.uwaterloo.gsd/sync"); 
			if (theSyncFactory != null) {
				return theSyncFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SyncFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyncFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SyncPackage.SYNCHRONIZATION_RESULT: return createSynchronizationResult();
			case SyncPackage.CLASS_SYNC_ITEM: return createClassSyncItem();
			case SyncPackage.STRUCTURAL_FEATURE_SYNC_ITEM: return createStructuralFeatureSyncItem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SyncPackage.SYNCHRONIZATION_STATE:
				return createSynchronizationStateFromString(eDataType, initialValue);
			case SyncPackage.RECONCILIATION_DECISION:
				return createReconciliationDecisionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SyncPackage.SYNCHRONIZATION_STATE:
				return convertSynchronizationStateToString(eDataType, instanceValue);
			case SyncPackage.RECONCILIATION_DECISION:
				return convertReconciliationDecisionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationResult createSynchronizationResult() {
		SynchronizationResultImpl synchronizationResult = new SynchronizationResultImpl();
		return synchronizationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassSyncItem createClassSyncItem() {
		ClassSyncItemImpl classSyncItem = new ClassSyncItemImpl();
		return classSyncItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralFeatureSyncItem createStructuralFeatureSyncItem() {
		StructuralFeatureSyncItemImpl structuralFeatureSyncItem = new StructuralFeatureSyncItemImpl();
		return structuralFeatureSyncItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronizationState createSynchronizationStateFromString(EDataType eDataType, String initialValue) {
		SynchronizationState result = SynchronizationState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSynchronizationStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReconciliationDecision createReconciliationDecisionFromString(EDataType eDataType, String initialValue) {
		ReconciliationDecision result = ReconciliationDecision.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReconciliationDecisionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyncPackage getSyncPackage() {
		return (SyncPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SyncPackage getPackage() {
		return SyncPackage.eINSTANCE;
	}

} //SyncFactoryImpl
