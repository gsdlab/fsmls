/*******************************************************************************
 * Copyright (c) 2010 Herman Lee.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Herman Lee - initial API and implementation
 ******************************************************************************/

package ca.uwaterloo.gsd.fsml.implModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import ca.uwaterloo.gsd.fsml.implModel.Default;
import ca.uwaterloo.gsd.fsml.implModel.ImplModelFactory;
import ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage;
import ca.uwaterloo.gsd.fsml.implModel.Position;
import ca.uwaterloo.gsd.fsml.implModel.Variant;
import ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNew;
import ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNull;
import ca.uwaterloo.gsd.fsml.implModel.default_callsReceived;
import ca.uwaterloo.gsd.fsml.implModel.default_extendsClass;
import ca.uwaterloo.gsd.fsml.implModel.default_implementsInterface;
import ca.uwaterloo.gsd.fsml.implModel.default_methodCalls;
import ca.uwaterloo.gsd.fsml.implModel.default_typedWith;
import ca.uwaterloo.gsd.fsml.implModel.implModel;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_InMethod;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_Initializer;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_InMethod;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer;
import ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived;
import ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived_InMethod;
import ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass;
import ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Directly;
import ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Indirectly;
import ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface;
import ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Directly;
import ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Indirectly;
import ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls;
import ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls_InMethod;
import ca.uwaterloo.gsd.fsml.implModel.variant_typedWith;
import ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Directly;
import ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Indirectly;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImplModelPackageImpl extends EPackageImpl implements ImplModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass default_assignedWithNewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass default_assignedWithNullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass default_extendsClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass default_implementsInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass default_callsReceivedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass default_methodCallsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass default_typedWithEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_assignedWithNewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_assignedWithNullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_extendsClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_implementsInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_callsReceivedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_methodCallsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_typedWithEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_assignedWithNew_InitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_assignedWithNew_InMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_extendsClass_DirectlyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_extendsClass_IndirectlyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_implementsInterface_DirectlyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_implementsInterface_IndirectlyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_callsReceived_InMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_methodCalls_InMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_typedWith_DirectlyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_typedWith_IndirectlyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_assignedWithNull_InitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variant_assignedWithNull_InMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum positionEEnum = null;

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
	 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImplModelPackageImpl() {
		super(eNS_URI, ImplModelFactory.eINSTANCE);
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
	public static ImplModelPackage init() {
		if (isInited) return (ImplModelPackage)EPackage.Registry.INSTANCE.getEPackage(ImplModelPackage.eNS_URI);

		// Obtain or create and register package
		ImplModelPackageImpl theImplModelPackage = (ImplModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ImplModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ImplModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImplModelPackage.createPackageContents();

		// Initialize created meta-data
		theImplModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImplModelPackage.freeze();

		return theImplModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getimplModel() {
		return implModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getimplModel_Defaults() {
		return (EReference)implModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getimplModel_Variants() {
		return (EReference)implModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefault() {
		return defaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefault_Overridden() {
		return (EAttribute)defaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefault_EClass() {
		return (EAttribute)defaultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefault_EStructuralFeature() {
		return (EAttribute)defaultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariant() {
		return variantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariant_EClass() {
		return (EAttribute)variantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariant_EStructuralFeature() {
		return (EAttribute)variantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdefault_assignedWithNew() {
		return default_assignedWithNewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdefault_assignedWithNew_Variant() {
		return (EReference)default_assignedWithNewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdefault_assignedWithNull() {
		return default_assignedWithNullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdefault_assignedWithNull_Variant() {
		return (EReference)default_assignedWithNullEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdefault_extendsClass() {
		return default_extendsClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdefault_extendsClass_Variant() {
		return (EReference)default_extendsClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdefault_implementsInterface() {
		return default_implementsInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdefault_implementsInterface_Variant() {
		return (EReference)default_implementsInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdefault_callsReceived() {
		return default_callsReceivedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdefault_callsReceived_Variant() {
		return (EReference)default_callsReceivedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdefault_methodCalls() {
		return default_methodCallsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdefault_methodCalls_Variant() {
		return (EReference)default_methodCallsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getdefault_typedWith() {
		return default_typedWithEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getdefault_typedWith_Variant() {
		return (EReference)default_typedWithEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_assignedWithNew() {
		return variant_assignedWithNewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_assignedWithNull() {
		return variant_assignedWithNullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_extendsClass() {
		return variant_extendsClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_implementsInterface() {
		return variant_implementsInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_callsReceived() {
		return variant_callsReceivedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_methodCalls() {
		return variant_methodCallsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_typedWith() {
		return variant_typedWithEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_assignedWithNew_Initializer() {
		return variant_assignedWithNew_InitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_assignedWithNew_Initializer_InitializedType() {
		return (EAttribute)variant_assignedWithNew_InitializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_assignedWithNew_InMethod() {
		return variant_assignedWithNew_InMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_assignedWithNew_InMethod_MethodName() {
		return (EAttribute)variant_assignedWithNew_InMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_extendsClass_Directly() {
		return variant_extendsClass_DirectlyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_extendsClass_Indirectly() {
		return variant_extendsClass_IndirectlyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_extendsClass_Indirectly_ClassName() {
		return (EAttribute)variant_extendsClass_IndirectlyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_implementsInterface_Directly() {
		return variant_implementsInterface_DirectlyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_implementsInterface_Indirectly() {
		return variant_implementsInterface_IndirectlyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_implementsInterface_Indirectly_InterfaceName() {
		return (EAttribute)variant_implementsInterface_IndirectlyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_callsReceived_InMethod() {
		return variant_callsReceived_InMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_callsReceived_InMethod_MethodName() {
		return (EAttribute)variant_callsReceived_InMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_methodCalls_InMethod() {
		return variant_methodCalls_InMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_methodCalls_InMethod_MethodName() {
		return (EAttribute)variant_methodCalls_InMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_typedWith_Directly() {
		return variant_typedWith_DirectlyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_typedWith_Indirectly() {
		return variant_typedWith_IndirectlyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_typedWith_Indirectly_ClassName() {
		return (EAttribute)variant_typedWith_IndirectlyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_assignedWithNull_Initializer() {
		return variant_assignedWithNull_InitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_assignedWithNull_Initializer_InitializedType() {
		return (EAttribute)variant_assignedWithNull_InitializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getvariant_assignedWithNull_InMethod() {
		return variant_assignedWithNull_InMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getvariant_assignedWithNull_InMethod_MethodName() {
		return (EAttribute)variant_assignedWithNull_InMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPosition() {
		return positionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplModelFactory getImplModelFactory() {
		return (ImplModelFactory)getEFactoryInstance();
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
		implModelEClass = createEClass(IMPL_MODEL);
		createEReference(implModelEClass, IMPL_MODEL__DEFAULTS);
		createEReference(implModelEClass, IMPL_MODEL__VARIANTS);

		defaultEClass = createEClass(DEFAULT);
		createEAttribute(defaultEClass, DEFAULT__OVERRIDDEN);
		createEAttribute(defaultEClass, DEFAULT__ECLASS);
		createEAttribute(defaultEClass, DEFAULT__ESTRUCTURAL_FEATURE);

		variantEClass = createEClass(VARIANT);
		createEAttribute(variantEClass, VARIANT__ECLASS);
		createEAttribute(variantEClass, VARIANT__ESTRUCTURAL_FEATURE);

		default_assignedWithNewEClass = createEClass(DEFAULT_ASSIGNED_WITH_NEW);
		createEReference(default_assignedWithNewEClass, DEFAULT_ASSIGNED_WITH_NEW__VARIANT);

		default_assignedWithNullEClass = createEClass(DEFAULT_ASSIGNED_WITH_NULL);
		createEReference(default_assignedWithNullEClass, DEFAULT_ASSIGNED_WITH_NULL__VARIANT);

		default_extendsClassEClass = createEClass(DEFAULT_EXTENDS_CLASS);
		createEReference(default_extendsClassEClass, DEFAULT_EXTENDS_CLASS__VARIANT);

		default_implementsInterfaceEClass = createEClass(DEFAULT_IMPLEMENTS_INTERFACE);
		createEReference(default_implementsInterfaceEClass, DEFAULT_IMPLEMENTS_INTERFACE__VARIANT);

		default_callsReceivedEClass = createEClass(DEFAULT_CALLS_RECEIVED);
		createEReference(default_callsReceivedEClass, DEFAULT_CALLS_RECEIVED__VARIANT);

		default_methodCallsEClass = createEClass(DEFAULT_METHOD_CALLS);
		createEReference(default_methodCallsEClass, DEFAULT_METHOD_CALLS__VARIANT);

		default_typedWithEClass = createEClass(DEFAULT_TYPED_WITH);
		createEReference(default_typedWithEClass, DEFAULT_TYPED_WITH__VARIANT);

		variant_assignedWithNewEClass = createEClass(VARIANT_ASSIGNED_WITH_NEW);

		variant_assignedWithNullEClass = createEClass(VARIANT_ASSIGNED_WITH_NULL);

		variant_extendsClassEClass = createEClass(VARIANT_EXTENDS_CLASS);

		variant_implementsInterfaceEClass = createEClass(VARIANT_IMPLEMENTS_INTERFACE);

		variant_callsReceivedEClass = createEClass(VARIANT_CALLS_RECEIVED);

		variant_methodCallsEClass = createEClass(VARIANT_METHOD_CALLS);

		variant_typedWithEClass = createEClass(VARIANT_TYPED_WITH);

		variant_assignedWithNew_InitializerEClass = createEClass(VARIANT_ASSIGNED_WITH_NEW_INITIALIZER);
		createEAttribute(variant_assignedWithNew_InitializerEClass, VARIANT_ASSIGNED_WITH_NEW_INITIALIZER__INITIALIZED_TYPE);

		variant_assignedWithNew_InMethodEClass = createEClass(VARIANT_ASSIGNED_WITH_NEW_IN_METHOD);
		createEAttribute(variant_assignedWithNew_InMethodEClass, VARIANT_ASSIGNED_WITH_NEW_IN_METHOD__METHOD_NAME);

		variant_extendsClass_DirectlyEClass = createEClass(VARIANT_EXTENDS_CLASS_DIRECTLY);

		variant_extendsClass_IndirectlyEClass = createEClass(VARIANT_EXTENDS_CLASS_INDIRECTLY);
		createEAttribute(variant_extendsClass_IndirectlyEClass, VARIANT_EXTENDS_CLASS_INDIRECTLY__CLASS_NAME);

		variant_implementsInterface_DirectlyEClass = createEClass(VARIANT_IMPLEMENTS_INTERFACE_DIRECTLY);

		variant_implementsInterface_IndirectlyEClass = createEClass(VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY);
		createEAttribute(variant_implementsInterface_IndirectlyEClass, VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY__INTERFACE_NAME);

		variant_callsReceived_InMethodEClass = createEClass(VARIANT_CALLS_RECEIVED_IN_METHOD);
		createEAttribute(variant_callsReceived_InMethodEClass, VARIANT_CALLS_RECEIVED_IN_METHOD__METHOD_NAME);

		variant_methodCalls_InMethodEClass = createEClass(VARIANT_METHOD_CALLS_IN_METHOD);
		createEAttribute(variant_methodCalls_InMethodEClass, VARIANT_METHOD_CALLS_IN_METHOD__METHOD_NAME);

		variant_typedWith_DirectlyEClass = createEClass(VARIANT_TYPED_WITH_DIRECTLY);

		variant_typedWith_IndirectlyEClass = createEClass(VARIANT_TYPED_WITH_INDIRECTLY);
		createEAttribute(variant_typedWith_IndirectlyEClass, VARIANT_TYPED_WITH_INDIRECTLY__CLASS_NAME);

		variant_assignedWithNull_InitializerEClass = createEClass(VARIANT_ASSIGNED_WITH_NULL_INITIALIZER);
		createEAttribute(variant_assignedWithNull_InitializerEClass, VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__INITIALIZED_TYPE);

		variant_assignedWithNull_InMethodEClass = createEClass(VARIANT_ASSIGNED_WITH_NULL_IN_METHOD);
		createEAttribute(variant_assignedWithNull_InMethodEClass, VARIANT_ASSIGNED_WITH_NULL_IN_METHOD__METHOD_NAME);

		// Create enums
		positionEEnum = createEEnum(POSITION);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		default_assignedWithNewEClass.getESuperTypes().add(this.getDefault());
		default_assignedWithNullEClass.getESuperTypes().add(this.getDefault());
		default_extendsClassEClass.getESuperTypes().add(this.getDefault());
		default_implementsInterfaceEClass.getESuperTypes().add(this.getDefault());
		default_callsReceivedEClass.getESuperTypes().add(this.getDefault());
		default_methodCallsEClass.getESuperTypes().add(this.getDefault());
		default_typedWithEClass.getESuperTypes().add(this.getDefault());
		variant_assignedWithNewEClass.getESuperTypes().add(this.getVariant());
		variant_assignedWithNullEClass.getESuperTypes().add(this.getVariant());
		variant_extendsClassEClass.getESuperTypes().add(this.getVariant());
		variant_implementsInterfaceEClass.getESuperTypes().add(this.getVariant());
		variant_callsReceivedEClass.getESuperTypes().add(this.getVariant());
		variant_methodCallsEClass.getESuperTypes().add(this.getVariant());
		variant_typedWithEClass.getESuperTypes().add(this.getVariant());
		variant_assignedWithNew_InitializerEClass.getESuperTypes().add(this.getvariant_assignedWithNew());
		variant_assignedWithNew_InMethodEClass.getESuperTypes().add(this.getvariant_assignedWithNew());
		variant_extendsClass_DirectlyEClass.getESuperTypes().add(this.getvariant_extendsClass());
		variant_extendsClass_IndirectlyEClass.getESuperTypes().add(this.getvariant_extendsClass());
		variant_implementsInterface_DirectlyEClass.getESuperTypes().add(this.getvariant_implementsInterface());
		variant_implementsInterface_IndirectlyEClass.getESuperTypes().add(this.getvariant_implementsInterface());
		variant_callsReceived_InMethodEClass.getESuperTypes().add(this.getvariant_callsReceived());
		variant_methodCalls_InMethodEClass.getESuperTypes().add(this.getvariant_methodCalls());
		variant_typedWith_DirectlyEClass.getESuperTypes().add(this.getvariant_typedWith());
		variant_typedWith_IndirectlyEClass.getESuperTypes().add(this.getvariant_typedWith());
		variant_assignedWithNull_InitializerEClass.getESuperTypes().add(this.getvariant_assignedWithNull());
		variant_assignedWithNull_InMethodEClass.getESuperTypes().add(this.getvariant_assignedWithNull());

		// Initialize classes and features; add operations and parameters
		initEClass(implModelEClass, implModel.class, "implModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getimplModel_Defaults(), this.getDefault(), null, "defaults", null, 0, -1, implModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getimplModel_Variants(), this.getVariant(), null, "variants", null, 0, -1, implModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultEClass, Default.class, "Default", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefault_Overridden(), theEcorePackage.getEBoolean(), "overridden", "", 1, 1, Default.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefault_EClass(), theEcorePackage.getEString(), "eClass", "", 1, 1, Default.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefault_EStructuralFeature(), theEcorePackage.getEString(), "eStructuralFeature", null, 1, 1, Default.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variantEClass, Variant.class, "Variant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariant_EClass(), theEcorePackage.getEString(), "eClass", "", 0, 1, Variant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariant_EStructuralFeature(), theEcorePackage.getEString(), "eStructuralFeature", null, 0, 1, Variant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(default_assignedWithNewEClass, default_assignedWithNew.class, "default_assignedWithNew", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdefault_assignedWithNew_Variant(), this.getvariant_assignedWithNew(), null, "variant", null, 1, -1, default_assignedWithNew.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(default_assignedWithNullEClass, default_assignedWithNull.class, "default_assignedWithNull", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdefault_assignedWithNull_Variant(), this.getvariant_assignedWithNull(), null, "variant", null, 1, -1, default_assignedWithNull.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(default_extendsClassEClass, default_extendsClass.class, "default_extendsClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdefault_extendsClass_Variant(), this.getvariant_extendsClass(), null, "variant", null, 1, -1, default_extendsClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(default_implementsInterfaceEClass, default_implementsInterface.class, "default_implementsInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdefault_implementsInterface_Variant(), this.getvariant_implementsInterface(), null, "variant", null, 1, -1, default_implementsInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(default_callsReceivedEClass, default_callsReceived.class, "default_callsReceived", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdefault_callsReceived_Variant(), this.getvariant_callsReceived(), null, "variant", null, 1, -1, default_callsReceived.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(default_methodCallsEClass, default_methodCalls.class, "default_methodCalls", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdefault_methodCalls_Variant(), this.getvariant_methodCalls(), null, "variant", null, 1, -1, default_methodCalls.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(default_typedWithEClass, default_typedWith.class, "default_typedWith", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getdefault_typedWith_Variant(), this.getvariant_typedWith(), null, "variant", null, 1, -1, default_typedWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_assignedWithNewEClass, variant_assignedWithNew.class, "variant_assignedWithNew", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_assignedWithNullEClass, variant_assignedWithNull.class, "variant_assignedWithNull", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_extendsClassEClass, variant_extendsClass.class, "variant_extendsClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_implementsInterfaceEClass, variant_implementsInterface.class, "variant_implementsInterface", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_callsReceivedEClass, variant_callsReceived.class, "variant_callsReceived", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_methodCallsEClass, variant_methodCalls.class, "variant_methodCalls", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_typedWithEClass, variant_typedWith.class, "variant_typedWith", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_assignedWithNew_InitializerEClass, variant_assignedWithNew_Initializer.class, "variant_assignedWithNew_Initializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_assignedWithNew_Initializer_InitializedType(), ecorePackage.getEString(), "initializedType", null, 0, 1, variant_assignedWithNew_Initializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_assignedWithNew_InMethodEClass, variant_assignedWithNew_InMethod.class, "variant_assignedWithNew_InMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_assignedWithNew_InMethod_MethodName(), theEcorePackage.getEString(), "methodName", null, 0, 1, variant_assignedWithNew_InMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_extendsClass_DirectlyEClass, variant_extendsClass_Directly.class, "variant_extendsClass_Directly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_extendsClass_IndirectlyEClass, variant_extendsClass_Indirectly.class, "variant_extendsClass_Indirectly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_extendsClass_Indirectly_ClassName(), theEcorePackage.getEString(), "className", null, 0, 1, variant_extendsClass_Indirectly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_implementsInterface_DirectlyEClass, variant_implementsInterface_Directly.class, "variant_implementsInterface_Directly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_implementsInterface_IndirectlyEClass, variant_implementsInterface_Indirectly.class, "variant_implementsInterface_Indirectly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_implementsInterface_Indirectly_InterfaceName(), theEcorePackage.getEString(), "interfaceName", null, 0, 1, variant_implementsInterface_Indirectly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_callsReceived_InMethodEClass, variant_callsReceived_InMethod.class, "variant_callsReceived_InMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_callsReceived_InMethod_MethodName(), theEcorePackage.getEString(), "methodName", null, 0, 1, variant_callsReceived_InMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_methodCalls_InMethodEClass, variant_methodCalls_InMethod.class, "variant_methodCalls_InMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_methodCalls_InMethod_MethodName(), theEcorePackage.getEString(), "methodName", null, 0, 1, variant_methodCalls_InMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_typedWith_DirectlyEClass, variant_typedWith_Directly.class, "variant_typedWith_Directly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variant_typedWith_IndirectlyEClass, variant_typedWith_Indirectly.class, "variant_typedWith_Indirectly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_typedWith_Indirectly_ClassName(), theEcorePackage.getEString(), "className", null, 0, 1, variant_typedWith_Indirectly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_assignedWithNull_InitializerEClass, variant_assignedWithNull_Initializer.class, "variant_assignedWithNull_Initializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_assignedWithNull_Initializer_InitializedType(), ecorePackage.getEString(), "initializedType", null, 0, 1, variant_assignedWithNull_Initializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variant_assignedWithNull_InMethodEClass, variant_assignedWithNull_InMethod.class, "variant_assignedWithNull_InMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getvariant_assignedWithNull_InMethod_MethodName(), theEcorePackage.getEString(), "methodName", null, 0, 1, variant_assignedWithNull_InMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(positionEEnum, Position.class, "Position");
		addEEnumLiteral(positionEEnum, Position.BEFORE);
		addEEnumLiteral(positionEEnum, Position.AFTER);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// key
		createKeyAnnotations();
	}

	/**
	 * Initializes the annotations for <b>key</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createKeyAnnotations() {
		String source = "key";		
		addAnnotation
		  (getVariant_EClass(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getVariant_EStructuralFeature(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getvariant_callsReceived_InMethod_MethodName(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getvariant_methodCalls_InMethod_MethodName(), 
		   source, 
		   new String[] {
		   });
	}

} //ImplModelPackageImpl
