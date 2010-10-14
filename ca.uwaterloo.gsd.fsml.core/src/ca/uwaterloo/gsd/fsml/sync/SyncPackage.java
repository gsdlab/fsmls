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
package ca.uwaterloo.gsd.fsml.sync;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.sync.SyncFactory
 * @model kind="package"
 * @generated
 */
public interface SyncPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sync";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ca.uwaterloo.gsd/sync";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sync";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SyncPackage eINSTANCE = ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.sync.impl.SyncItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncItemImpl
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getSyncItem()
	 * @generated
	 */
	int SYNC_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Synchronization State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_ITEM__SYNCHRONIZATION_STATE = 0;

	/**
	 * The feature id for the '<em><b>Reconciliation Decision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_ITEM__RECONCILIATION_DECISION = 1;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_ITEM__RESULT = 2;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_ITEM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.sync.impl.SynchronizationResultImpl <em>Synchronization Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.SynchronizationResultImpl
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getSynchronizationResult()
	 * @generated
	 */
	int SYNCHRONIZATION_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Asserted Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESULT__ASSERTED_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Implementation Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Class Sync Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS = 2;

	/**
	 * The number of structural features of the '<em>Synchronization Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.sync.impl.ClassSyncItemImpl <em>Class Sync Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.ClassSyncItemImpl
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getClassSyncItem()
	 * @generated
	 */
	int CLASS_SYNC_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Synchronization State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SYNC_ITEM__SYNCHRONIZATION_STATE = SYNC_ITEM__SYNCHRONIZATION_STATE;

	/**
	 * The feature id for the '<em><b>Reconciliation Decision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SYNC_ITEM__RECONCILIATION_DECISION = SYNC_ITEM__RECONCILIATION_DECISION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SYNC_ITEM__RESULT = SYNC_ITEM__RESULT;

	/**
	 * The feature id for the '<em><b>Sync Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SYNC_ITEM__SYNC_ITEMS = SYNC_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SYNC_ITEM__MODEL = SYNC_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Code</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SYNC_ITEM__CODE = SYNC_ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class Sync Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_SYNC_ITEM_FEATURE_COUNT = SYNC_ITEM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.sync.impl.StructuralFeatureSyncItemImpl <em>Structural Feature Sync Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.StructuralFeatureSyncItemImpl
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getStructuralFeatureSyncItem()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_SYNC_ITEM = 3;

	/**
	 * The feature id for the '<em><b>Synchronization State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_SYNC_ITEM__SYNCHRONIZATION_STATE = SYNC_ITEM__SYNCHRONIZATION_STATE;

	/**
	 * The feature id for the '<em><b>Reconciliation Decision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_SYNC_ITEM__RECONCILIATION_DECISION = SYNC_ITEM__RECONCILIATION_DECISION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_SYNC_ITEM__RESULT = SYNC_ITEM__RESULT;

	/**
	 * The feature id for the '<em><b>Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_SYNC_ITEM__STRUCTURAL_FEATURE = SYNC_ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structural Feature Sync Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_SYNC_ITEM_FEATURE_COUNT = SYNC_ITEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationState <em>Synchronization State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationState
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getSynchronizationState()
	 * @generated
	 */
	int SYNCHRONIZATION_STATE = 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision <em>Reconciliation Decision</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision
	 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getReconciliationDecision()
	 * @generated
	 */
	int RECONCILIATION_DECISION = 5;


	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.sync.SyncItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncItem
	 * @generated
	 */
	EClass getSyncItem();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getSynchronizationState <em>Synchronization State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synchronization State</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncItem#getSynchronizationState()
	 * @see #getSyncItem()
	 * @generated
	 */
	EAttribute getSyncItem_SynchronizationState();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getReconciliationDecision <em>Reconciliation Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reconciliation Decision</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncItem#getReconciliationDecision()
	 * @see #getSyncItem()
	 * @generated
	 */
	EAttribute getSyncItem_ReconciliationDecision();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.sync.SyncItem#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncItem#getResult()
	 * @see #getSyncItem()
	 * @generated
	 */
	EAttribute getSyncItem_Result();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult <em>Synchronization Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Synchronization Result</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationResult
	 * @generated
	 */
	EClass getSynchronizationResult();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getAssertedModel <em>Asserted Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Asserted Model</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getAssertedModel()
	 * @see #getSynchronizationResult()
	 * @generated
	 */
	EReference getSynchronizationResult_AssertedModel();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getImplementationModel <em>Implementation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Model</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getImplementationModel()
	 * @see #getSynchronizationResult()
	 * @generated
	 */
	EReference getSynchronizationResult_ImplementationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getClassSyncItems <em>Class Sync Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Sync Items</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getClassSyncItems()
	 * @see #getSynchronizationResult()
	 * @generated
	 */
	EReference getSynchronizationResult_ClassSyncItems();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem <em>Class Sync Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Sync Item</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.ClassSyncItem
	 * @generated
	 */
	EClass getClassSyncItem();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getSyncItems <em>Sync Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sync Items</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getSyncItems()
	 * @see #getClassSyncItem()
	 * @generated
	 */
	EReference getClassSyncItem_SyncItems();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getModel()
	 * @see #getClassSyncItem()
	 * @generated
	 */
	EReference getClassSyncItem_Model();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Code</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.ClassSyncItem#getCode()
	 * @see #getClassSyncItem()
	 * @generated
	 */
	EReference getClassSyncItem_Code();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem <em>Structural Feature Sync Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature Sync Item</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem
	 * @generated
	 */
	EClass getStructuralFeatureSyncItem();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem#getStructuralFeature <em>Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Structural Feature</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem#getStructuralFeature()
	 * @see #getStructuralFeatureSyncItem()
	 * @generated
	 */
	EReference getStructuralFeatureSyncItem_StructuralFeature();

	/**
	 * Returns the meta object for enum '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationState <em>Synchronization State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Synchronization State</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationState
	 * @generated
	 */
	EEnum getSynchronizationState();

	/**
	 * Returns the meta object for enum '{@link ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision <em>Reconciliation Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Reconciliation Decision</em>'.
	 * @see ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision
	 * @generated
	 */
	EEnum getReconciliationDecision();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SyncFactory getSyncFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.sync.impl.SyncItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncItemImpl
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getSyncItem()
		 * @generated
		 */
		EClass SYNC_ITEM = eINSTANCE.getSyncItem();

		/**
		 * The meta object literal for the '<em><b>Synchronization State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNC_ITEM__SYNCHRONIZATION_STATE = eINSTANCE.getSyncItem_SynchronizationState();

		/**
		 * The meta object literal for the '<em><b>Reconciliation Decision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNC_ITEM__RECONCILIATION_DECISION = eINSTANCE.getSyncItem_ReconciliationDecision();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNC_ITEM__RESULT = eINSTANCE.getSyncItem_Result();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.sync.impl.SynchronizationResultImpl <em>Synchronization Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.SynchronizationResultImpl
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getSynchronizationResult()
		 * @generated
		 */
		EClass SYNCHRONIZATION_RESULT = eINSTANCE.getSynchronizationResult();

		/**
		 * The meta object literal for the '<em><b>Asserted Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONIZATION_RESULT__ASSERTED_MODEL = eINSTANCE.getSynchronizationResult_AssertedModel();

		/**
		 * The meta object literal for the '<em><b>Implementation Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL = eINSTANCE.getSynchronizationResult_ImplementationModel();

		/**
		 * The meta object literal for the '<em><b>Class Sync Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS = eINSTANCE.getSynchronizationResult_ClassSyncItems();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.sync.impl.ClassSyncItemImpl <em>Class Sync Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.ClassSyncItemImpl
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getClassSyncItem()
		 * @generated
		 */
		EClass CLASS_SYNC_ITEM = eINSTANCE.getClassSyncItem();

		/**
		 * The meta object literal for the '<em><b>Sync Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SYNC_ITEM__SYNC_ITEMS = eINSTANCE.getClassSyncItem_SyncItems();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SYNC_ITEM__MODEL = eINSTANCE.getClassSyncItem_Model();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_SYNC_ITEM__CODE = eINSTANCE.getClassSyncItem_Code();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.sync.impl.StructuralFeatureSyncItemImpl <em>Structural Feature Sync Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.StructuralFeatureSyncItemImpl
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getStructuralFeatureSyncItem()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_SYNC_ITEM = eINSTANCE.getStructuralFeatureSyncItem();

		/**
		 * The meta object literal for the '<em><b>Structural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_SYNC_ITEM__STRUCTURAL_FEATURE = eINSTANCE.getStructuralFeatureSyncItem_StructuralFeature();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationState <em>Synchronization State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.sync.SynchronizationState
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getSynchronizationState()
		 * @generated
		 */
		EEnum SYNCHRONIZATION_STATE = eINSTANCE.getSynchronizationState();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision <em>Reconciliation Decision</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision
		 * @see ca.uwaterloo.gsd.fsml.sync.impl.SyncPackageImpl#getReconciliationDecision()
		 * @generated
		 */
		EEnum RECONCILIATION_DECISION = eINSTANCE.getReconciliationDecision();

	}

} //SyncPackage
