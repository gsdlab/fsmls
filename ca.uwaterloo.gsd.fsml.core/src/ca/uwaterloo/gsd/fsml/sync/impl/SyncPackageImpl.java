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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import ca.uwaterloo.gsd.fsml.fsml.FsmlPackage;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncPackage;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationResult;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SyncPackageImpl extends EPackageImpl implements SyncPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syncItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synchronizationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classSyncItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureSyncItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum synchronizationStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reconciliationDecisionEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SyncPackageImpl() {
		super(eNS_URI, SyncFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SyncPackage init() {
		if (isInited) return (SyncPackage)EPackage.Registry.INSTANCE.getEPackage(SyncPackage.eNS_URI);

		// Obtain or create and register package
		SyncPackageImpl theSyncPackage = (SyncPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SyncPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SyncPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		FsmlPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSyncPackage.createPackageContents();

		// Initialize created meta-data
		theSyncPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSyncPackage.freeze();

		return theSyncPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyncItem() {
		return syncItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSyncItem_SynchronizationState() {
		return (EAttribute)syncItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSyncItem_ReconciliationDecision() {
		return (EAttribute)syncItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSyncItem_Result() {
		return (EAttribute)syncItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynchronizationResult() {
		return synchronizationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronizationResult_AssertedModel() {
		return (EReference)synchronizationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronizationResult_ImplementationModel() {
		return (EReference)synchronizationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronizationResult_ClassSyncItems() {
		return (EReference)synchronizationResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassSyncItem() {
		return classSyncItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSyncItem_SyncItems() {
		return (EReference)classSyncItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSyncItem_Model() {
		return (EReference)classSyncItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassSyncItem_Code() {
		return (EReference)classSyncItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeatureSyncItem() {
		return structuralFeatureSyncItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralFeatureSyncItem_StructuralFeature() {
		return (EReference)structuralFeatureSyncItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSynchronizationState() {
		return synchronizationStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReconciliationDecision() {
		return reconciliationDecisionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SyncFactory getSyncFactory() {
		return (SyncFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		syncItemEClass = createEClass(SYNC_ITEM);
		createEAttribute(syncItemEClass, SYNC_ITEM__SYNCHRONIZATION_STATE);
		createEAttribute(syncItemEClass, SYNC_ITEM__RECONCILIATION_DECISION);
		createEAttribute(syncItemEClass, SYNC_ITEM__RESULT);

		synchronizationResultEClass = createEClass(SYNCHRONIZATION_RESULT);
		createEReference(synchronizationResultEClass, SYNCHRONIZATION_RESULT__ASSERTED_MODEL);
		createEReference(synchronizationResultEClass, SYNCHRONIZATION_RESULT__IMPLEMENTATION_MODEL);
		createEReference(synchronizationResultEClass, SYNCHRONIZATION_RESULT__CLASS_SYNC_ITEMS);

		classSyncItemEClass = createEClass(CLASS_SYNC_ITEM);
		createEReference(classSyncItemEClass, CLASS_SYNC_ITEM__SYNC_ITEMS);
		createEReference(classSyncItemEClass, CLASS_SYNC_ITEM__MODEL);
		createEReference(classSyncItemEClass, CLASS_SYNC_ITEM__CODE);

		structuralFeatureSyncItemEClass = createEClass(STRUCTURAL_FEATURE_SYNC_ITEM);
		createEReference(structuralFeatureSyncItemEClass, STRUCTURAL_FEATURE_SYNC_ITEM__STRUCTURAL_FEATURE);

		// Create enums
		synchronizationStateEEnum = createEEnum(SYNCHRONIZATION_STATE);
		reconciliationDecisionEEnum = createEEnum(RECONCILIATION_DECISION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		FsmlPackage theFsmlPackage = (FsmlPackage)EPackage.Registry.INSTANCE.getEPackage(FsmlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		classSyncItemEClass.getESuperTypes().add(this.getSyncItem());
		structuralFeatureSyncItemEClass.getESuperTypes().add(this.getSyncItem());

		// Initialize classes and features; add operations and parameters
		initEClass(syncItemEClass, SyncItem.class, "SyncItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSyncItem_SynchronizationState(), this.getSynchronizationState(), "synchronizationState", null, 0, 1, SyncItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSyncItem_ReconciliationDecision(), this.getReconciliationDecision(), "reconciliationDecision", null, 0, 1, SyncItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSyncItem_Result(), ecorePackage.getEString(), "result", null, 0, 1, SyncItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(syncItemEClass, ecorePackage.getEBoolean(), "isStateForward", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(syncItemEClass, ecorePackage.getEBoolean(), "isStateReverse", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(syncItemEClass, ecorePackage.getEBoolean(), "isStateConflict", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(syncItemEClass, ecorePackage.getEBoolean(), "isStateChanged", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(syncItemEClass, ecorePackage.getEBoolean(), "isDecisionIgnore", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(syncItemEClass, ecorePackage.getEBoolean(), "isDecisionEnforce", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(syncItemEClass, ecorePackage.getEBoolean(), "isDecisionUpdate", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(syncItemEClass, ecorePackage.getEBoolean(), "isDecisionValid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getReconciliationDecision(), "decision", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(syncItemEClass, theEcorePackage.getEObject(), "getModel", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(syncItemEClass, theEcorePackage.getEObject(), "getCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(synchronizationResultEClass, SynchronizationResult.class, "SynchronizationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSynchronizationResult_AssertedModel(), theFsmlPackage.getModel(), null, "assertedModel", null, 1, 1, SynchronizationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynchronizationResult_ImplementationModel(), theFsmlPackage.getModel(), null, "implementationModel", null, 1, 1, SynchronizationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSynchronizationResult_ClassSyncItems(), this.getClassSyncItem(), null, "classSyncItems", null, 0, -1, SynchronizationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classSyncItemEClass, ClassSyncItem.class, "ClassSyncItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassSyncItem_SyncItems(), this.getSyncItem(), null, "syncItems", null, 0, -1, ClassSyncItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassSyncItem_Model(), ecorePackage.getEObject(), null, "model", null, 0, 1, ClassSyncItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassSyncItem_Code(), ecorePackage.getEObject(), null, "code", null, 0, 1, ClassSyncItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuralFeatureSyncItemEClass, StructuralFeatureSyncItem.class, "StructuralFeatureSyncItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuralFeatureSyncItem_StructuralFeature(), theEcorePackage.getEStructuralFeature(), null, "structuralFeature", null, 1, 1, StructuralFeatureSyncItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(synchronizationStateEEnum, SynchronizationState.class, "SynchronizationState");
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.UNSPECIFIED_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.UNCHANGED_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.ADDED_MODEL_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.CHANGED_MODEL_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.REMOVED_MODEL_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.ADDED_CODE_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.CHANGED_CODE_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.REMOVED_CODE_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.CHANGED_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.ADDED_CONSISTENTLY_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.CHANGED_CONSISTENTLY_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.REMOVED_CONSISTENTLY_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.ADDED_INCONSISTENTLY_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.CHANGED_INCONSISTENTLY_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.REMOVED_CODE_CHANGED_MODEL_LITERAL);
		addEEnumLiteral(synchronizationStateEEnum, SynchronizationState.REMOVED_MODEL_CHANGED_CODE_LITERAL);

		initEEnum(reconciliationDecisionEEnum, ReconciliationDecision.class, "ReconciliationDecision");
		addEEnumLiteral(reconciliationDecisionEEnum, ReconciliationDecision.UNSPECIFIED_LITERAL);
		addEEnumLiteral(reconciliationDecisionEEnum, ReconciliationDecision.IGNORE_LITERAL);
		addEEnumLiteral(reconciliationDecisionEEnum, ReconciliationDecision.ENFORCE_LITERAL);
		addEEnumLiteral(reconciliationDecisionEEnum, ReconciliationDecision.UPDATE_LITERAL);
		addEEnumLiteral(reconciliationDecisionEEnum, ReconciliationDecision.OVERRIDE_AND_ENFORCE_LITERAL);
		addEEnumLiteral(reconciliationDecisionEEnum, ReconciliationDecision.OVERRIDE_AND_UPDATE_LITERAL);
		addEEnumLiteral(reconciliationDecisionEEnum, ReconciliationDecision.ENFORCE_AND_UPDATE_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //SyncPackageImpl
