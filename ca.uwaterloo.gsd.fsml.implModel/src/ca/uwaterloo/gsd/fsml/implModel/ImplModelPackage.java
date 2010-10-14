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

package ca.uwaterloo.gsd.fsml.implModel;

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
 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelFactory
 * @model kind="package"
 * @generated
 */
public interface ImplModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "implModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ca.uwaterloo.gsd/implModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "implModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImplModelPackage eINSTANCE = ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.implModelImpl <em>impl Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.implModelImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getimplModel()
	 * @generated
	 */
	int IMPL_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Defaults</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPL_MODEL__DEFAULTS = 0;

	/**
	 * The feature id for the '<em><b>Variants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPL_MODEL__VARIANTS = 1;

	/**
	 * The number of structural features of the '<em>impl Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPL_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.DefaultImpl <em>Default</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.DefaultImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getDefault()
	 * @generated
	 */
	int DEFAULT = 1;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__OVERRIDDEN = 0;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__ECLASS = 1;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT__ESTRUCTURAL_FEATURE = 2;

	/**
	 * The number of structural features of the '<em>Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.VariantImpl <em>Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.VariantImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getVariant()
	 * @generated
	 */
	int VARIANT = 2;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__ECLASS = 0;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__ESTRUCTURAL_FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_assignedWithNewImpl <em>default assigned With New</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_assignedWithNewImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_assignedWithNew()
	 * @generated
	 */
	int DEFAULT_ASSIGNED_WITH_NEW = 3;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NEW__OVERRIDDEN = DEFAULT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NEW__ECLASS = DEFAULT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NEW__ESTRUCTURAL_FEATURE = DEFAULT__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NEW__VARIANT = DEFAULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>default assigned With New</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NEW_FEATURE_COUNT = DEFAULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_assignedWithNullImpl <em>default assigned With Null</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_assignedWithNullImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_assignedWithNull()
	 * @generated
	 */
	int DEFAULT_ASSIGNED_WITH_NULL = 4;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NULL__OVERRIDDEN = DEFAULT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NULL__ECLASS = DEFAULT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NULL__ESTRUCTURAL_FEATURE = DEFAULT__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NULL__VARIANT = DEFAULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>default assigned With Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_ASSIGNED_WITH_NULL_FEATURE_COUNT = DEFAULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_extendsClassImpl <em>default extends Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_extendsClassImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_extendsClass()
	 * @generated
	 */
	int DEFAULT_EXTENDS_CLASS = 5;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXTENDS_CLASS__OVERRIDDEN = DEFAULT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXTENDS_CLASS__ECLASS = DEFAULT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXTENDS_CLASS__ESTRUCTURAL_FEATURE = DEFAULT__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXTENDS_CLASS__VARIANT = DEFAULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>default extends Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_EXTENDS_CLASS_FEATURE_COUNT = DEFAULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_implementsInterfaceImpl <em>default implements Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_implementsInterfaceImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_implementsInterface()
	 * @generated
	 */
	int DEFAULT_IMPLEMENTS_INTERFACE = 6;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_IMPLEMENTS_INTERFACE__OVERRIDDEN = DEFAULT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_IMPLEMENTS_INTERFACE__ECLASS = DEFAULT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_IMPLEMENTS_INTERFACE__ESTRUCTURAL_FEATURE = DEFAULT__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_IMPLEMENTS_INTERFACE__VARIANT = DEFAULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>default implements Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_IMPLEMENTS_INTERFACE_FEATURE_COUNT = DEFAULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_callsReceivedImpl <em>default calls Received</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_callsReceivedImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_callsReceived()
	 * @generated
	 */
	int DEFAULT_CALLS_RECEIVED = 7;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CALLS_RECEIVED__OVERRIDDEN = DEFAULT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CALLS_RECEIVED__ECLASS = DEFAULT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CALLS_RECEIVED__ESTRUCTURAL_FEATURE = DEFAULT__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CALLS_RECEIVED__VARIANT = DEFAULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>default calls Received</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CALLS_RECEIVED_FEATURE_COUNT = DEFAULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_methodCallsImpl <em>default method Calls</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_methodCallsImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_methodCalls()
	 * @generated
	 */
	int DEFAULT_METHOD_CALLS = 8;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_METHOD_CALLS__OVERRIDDEN = DEFAULT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_METHOD_CALLS__ECLASS = DEFAULT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_METHOD_CALLS__ESTRUCTURAL_FEATURE = DEFAULT__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_METHOD_CALLS__VARIANT = DEFAULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>default method Calls</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_METHOD_CALLS_FEATURE_COUNT = DEFAULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_typedWithImpl <em>default typed With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_typedWithImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_typedWith()
	 * @generated
	 */
	int DEFAULT_TYPED_WITH = 9;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_TYPED_WITH__OVERRIDDEN = DEFAULT__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_TYPED_WITH__ECLASS = DEFAULT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_TYPED_WITH__ESTRUCTURAL_FEATURE = DEFAULT__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_TYPED_WITH__VARIANT = DEFAULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>default typed With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_TYPED_WITH_FEATURE_COUNT = DEFAULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNewImpl <em>variant assigned With New</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNewImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNew()
	 * @generated
	 */
	int VARIANT_ASSIGNED_WITH_NEW = 10;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW__ECLASS = VARIANT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW__ESTRUCTURAL_FEATURE = VARIANT__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant assigned With New</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNullImpl <em>variant assigned With Null</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNullImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNull()
	 * @generated
	 */
	int VARIANT_ASSIGNED_WITH_NULL = 11;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL__ECLASS = VARIANT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL__ESTRUCTURAL_FEATURE = VARIANT__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant assigned With Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClassImpl <em>variant extends Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClassImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_extendsClass()
	 * @generated
	 */
	int VARIANT_EXTENDS_CLASS = 12;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS__ECLASS = VARIANT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS__ESTRUCTURAL_FEATURE = VARIANT__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant extends Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterfaceImpl <em>variant implements Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterfaceImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_implementsInterface()
	 * @generated
	 */
	int VARIANT_IMPLEMENTS_INTERFACE = 13;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE__ECLASS = VARIANT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE__ESTRUCTURAL_FEATURE = VARIANT__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant implements Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_callsReceivedImpl <em>variant calls Received</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_callsReceivedImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_callsReceived()
	 * @generated
	 */
	int VARIANT_CALLS_RECEIVED = 14;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_CALLS_RECEIVED__ECLASS = VARIANT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_CALLS_RECEIVED__ESTRUCTURAL_FEATURE = VARIANT__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant calls Received</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_CALLS_RECEIVED_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_methodCallsImpl <em>variant method Calls</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_methodCallsImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_methodCalls()
	 * @generated
	 */
	int VARIANT_METHOD_CALLS = 15;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_METHOD_CALLS__ECLASS = VARIANT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_METHOD_CALLS__ESTRUCTURAL_FEATURE = VARIANT__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant method Calls</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_METHOD_CALLS_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWithImpl <em>variant typed With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWithImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_typedWith()
	 * @generated
	 */
	int VARIANT_TYPED_WITH = 16;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH__ECLASS = VARIANT__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH__ESTRUCTURAL_FEATURE = VARIANT__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant typed With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH_FEATURE_COUNT = VARIANT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNew_InitializerImpl <em>variant assigned With New Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNew_InitializerImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNew_Initializer()
	 * @generated
	 */
	int VARIANT_ASSIGNED_WITH_NEW_INITIALIZER = 17;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_INITIALIZER__ECLASS = VARIANT_ASSIGNED_WITH_NEW__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_INITIALIZER__ESTRUCTURAL_FEATURE = VARIANT_ASSIGNED_WITH_NEW__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Initialized Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_INITIALIZER__INITIALIZED_TYPE = VARIANT_ASSIGNED_WITH_NEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant assigned With New Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_INITIALIZER_FEATURE_COUNT = VARIANT_ASSIGNED_WITH_NEW_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNew_InMethodImpl <em>variant assigned With New In Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNew_InMethodImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNew_InMethod()
	 * @generated
	 */
	int VARIANT_ASSIGNED_WITH_NEW_IN_METHOD = 18;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_IN_METHOD__ECLASS = VARIANT_ASSIGNED_WITH_NEW__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_IN_METHOD__ESTRUCTURAL_FEATURE = VARIANT_ASSIGNED_WITH_NEW__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_IN_METHOD__METHOD_NAME = VARIANT_ASSIGNED_WITH_NEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant assigned With New In Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NEW_IN_METHOD_FEATURE_COUNT = VARIANT_ASSIGNED_WITH_NEW_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClass_DirectlyImpl <em>variant extends Class Directly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClass_DirectlyImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_extendsClass_Directly()
	 * @generated
	 */
	int VARIANT_EXTENDS_CLASS_DIRECTLY = 19;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS_DIRECTLY__ECLASS = VARIANT_EXTENDS_CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS_DIRECTLY__ESTRUCTURAL_FEATURE = VARIANT_EXTENDS_CLASS__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant extends Class Directly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS_DIRECTLY_FEATURE_COUNT = VARIANT_EXTENDS_CLASS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClass_IndirectlyImpl <em>variant extends Class Indirectly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClass_IndirectlyImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_extendsClass_Indirectly()
	 * @generated
	 */
	int VARIANT_EXTENDS_CLASS_INDIRECTLY = 20;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS_INDIRECTLY__ECLASS = VARIANT_EXTENDS_CLASS__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS_INDIRECTLY__ESTRUCTURAL_FEATURE = VARIANT_EXTENDS_CLASS__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS_INDIRECTLY__CLASS_NAME = VARIANT_EXTENDS_CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant extends Class Indirectly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_EXTENDS_CLASS_INDIRECTLY_FEATURE_COUNT = VARIANT_EXTENDS_CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterface_DirectlyImpl <em>variant implements Interface Directly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterface_DirectlyImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_implementsInterface_Directly()
	 * @generated
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_DIRECTLY = 21;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_DIRECTLY__ECLASS = VARIANT_IMPLEMENTS_INTERFACE__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_DIRECTLY__ESTRUCTURAL_FEATURE = VARIANT_IMPLEMENTS_INTERFACE__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant implements Interface Directly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_DIRECTLY_FEATURE_COUNT = VARIANT_IMPLEMENTS_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterface_IndirectlyImpl <em>variant implements Interface Indirectly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterface_IndirectlyImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_implementsInterface_Indirectly()
	 * @generated
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY = 22;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY__ECLASS = VARIANT_IMPLEMENTS_INTERFACE__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY__ESTRUCTURAL_FEATURE = VARIANT_IMPLEMENTS_INTERFACE__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Interface Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY__INTERFACE_NAME = VARIANT_IMPLEMENTS_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant implements Interface Indirectly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY_FEATURE_COUNT = VARIANT_IMPLEMENTS_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_callsReceived_InMethodImpl <em>variant calls Received In Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_callsReceived_InMethodImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_callsReceived_InMethod()
	 * @generated
	 */
	int VARIANT_CALLS_RECEIVED_IN_METHOD = 23;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_CALLS_RECEIVED_IN_METHOD__ECLASS = VARIANT_CALLS_RECEIVED__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_CALLS_RECEIVED_IN_METHOD__ESTRUCTURAL_FEATURE = VARIANT_CALLS_RECEIVED__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_CALLS_RECEIVED_IN_METHOD__METHOD_NAME = VARIANT_CALLS_RECEIVED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant calls Received In Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_CALLS_RECEIVED_IN_METHOD_FEATURE_COUNT = VARIANT_CALLS_RECEIVED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_methodCalls_InMethodImpl <em>variant method Calls In Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_methodCalls_InMethodImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_methodCalls_InMethod()
	 * @generated
	 */
	int VARIANT_METHOD_CALLS_IN_METHOD = 24;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_METHOD_CALLS_IN_METHOD__ECLASS = VARIANT_METHOD_CALLS__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_METHOD_CALLS_IN_METHOD__ESTRUCTURAL_FEATURE = VARIANT_METHOD_CALLS__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_METHOD_CALLS_IN_METHOD__METHOD_NAME = VARIANT_METHOD_CALLS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant method Calls In Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_METHOD_CALLS_IN_METHOD_FEATURE_COUNT = VARIANT_METHOD_CALLS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWith_DirectlyImpl <em>variant typed With Directly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWith_DirectlyImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_typedWith_Directly()
	 * @generated
	 */
	int VARIANT_TYPED_WITH_DIRECTLY = 25;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH_DIRECTLY__ECLASS = VARIANT_TYPED_WITH__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH_DIRECTLY__ESTRUCTURAL_FEATURE = VARIANT_TYPED_WITH__ESTRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>variant typed With Directly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH_DIRECTLY_FEATURE_COUNT = VARIANT_TYPED_WITH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWith_IndirectlyImpl <em>variant typed With Indirectly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWith_IndirectlyImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_typedWith_Indirectly()
	 * @generated
	 */
	int VARIANT_TYPED_WITH_INDIRECTLY = 26;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH_INDIRECTLY__ECLASS = VARIANT_TYPED_WITH__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH_INDIRECTLY__ESTRUCTURAL_FEATURE = VARIANT_TYPED_WITH__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH_INDIRECTLY__CLASS_NAME = VARIANT_TYPED_WITH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant typed With Indirectly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPED_WITH_INDIRECTLY_FEATURE_COUNT = VARIANT_TYPED_WITH_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InitializerImpl <em>variant assigned With Null Initializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InitializerImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNull_Initializer()
	 * @generated
	 */
	int VARIANT_ASSIGNED_WITH_NULL_INITIALIZER = 27;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__ECLASS = VARIANT_ASSIGNED_WITH_NULL__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__ESTRUCTURAL_FEATURE = VARIANT_ASSIGNED_WITH_NULL__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Initialized Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__INITIALIZED_TYPE = VARIANT_ASSIGNED_WITH_NULL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant assigned With Null Initializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_INITIALIZER_FEATURE_COUNT = VARIANT_ASSIGNED_WITH_NULL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InMethodImpl <em>variant assigned With Null In Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InMethodImpl
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNull_InMethod()
	 * @generated
	 */
	int VARIANT_ASSIGNED_WITH_NULL_IN_METHOD = 28;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_IN_METHOD__ECLASS = VARIANT_ASSIGNED_WITH_NULL__ECLASS;

	/**
	 * The feature id for the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_IN_METHOD__ESTRUCTURAL_FEATURE = VARIANT_ASSIGNED_WITH_NULL__ESTRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_IN_METHOD__METHOD_NAME = VARIANT_ASSIGNED_WITH_NULL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>variant assigned With Null In Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_ASSIGNED_WITH_NULL_IN_METHOD_FEATURE_COUNT = VARIANT_ASSIGNED_WITH_NULL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.implModel.Position <em>Position</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.implModel.Position
	 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getPosition()
	 * @generated
	 */
	int POSITION = 29;


	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.implModel <em>impl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>impl Model</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.implModel
	 * @generated
	 */
	EClass getimplModel();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.implModel#getDefaults <em>Defaults</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defaults</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.implModel#getDefaults()
	 * @see #getimplModel()
	 * @generated
	 */
	EReference getimplModel_Defaults();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.implModel#getVariants <em>Variants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variants</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.implModel#getVariants()
	 * @see #getimplModel()
	 * @generated
	 */
	EReference getimplModel_Variants();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.Default <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Default
	 * @generated
	 */
	EClass getDefault();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.Default#isOverridden <em>Overridden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overridden</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Default#isOverridden()
	 * @see #getDefault()
	 * @generated
	 */
	EAttribute getDefault_Overridden();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.Default#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EClass</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Default#getEClass()
	 * @see #getDefault()
	 * @generated
	 */
	EAttribute getDefault_EClass();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.Default#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EStructural Feature</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Default#getEStructuralFeature()
	 * @see #getDefault()
	 * @generated
	 */
	EAttribute getDefault_EStructuralFeature();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Variant
	 * @generated
	 */
	EClass getVariant();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.Variant#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EClass</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Variant#getEClass()
	 * @see #getVariant()
	 * @generated
	 */
	EAttribute getVariant_EClass();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.Variant#getEStructuralFeature <em>EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EStructural Feature</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Variant#getEStructuralFeature()
	 * @see #getVariant()
	 * @generated
	 */
	EAttribute getVariant_EStructuralFeature();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNew <em>default assigned With New</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>default assigned With New</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNew
	 * @generated
	 */
	EClass getdefault_assignedWithNew();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNew#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNew#getVariant()
	 * @see #getdefault_assignedWithNew()
	 * @generated
	 */
	EReference getdefault_assignedWithNew_Variant();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNull <em>default assigned With Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>default assigned With Null</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNull
	 * @generated
	 */
	EClass getdefault_assignedWithNull();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNull#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNull#getVariant()
	 * @see #getdefault_assignedWithNull()
	 * @generated
	 */
	EReference getdefault_assignedWithNull_Variant();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.default_extendsClass <em>default extends Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>default extends Class</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_extendsClass
	 * @generated
	 */
	EClass getdefault_extendsClass();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.default_extendsClass#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_extendsClass#getVariant()
	 * @see #getdefault_extendsClass()
	 * @generated
	 */
	EReference getdefault_extendsClass_Variant();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.default_implementsInterface <em>default implements Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>default implements Interface</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_implementsInterface
	 * @generated
	 */
	EClass getdefault_implementsInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.default_implementsInterface#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_implementsInterface#getVariant()
	 * @see #getdefault_implementsInterface()
	 * @generated
	 */
	EReference getdefault_implementsInterface_Variant();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.default_callsReceived <em>default calls Received</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>default calls Received</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_callsReceived
	 * @generated
	 */
	EClass getdefault_callsReceived();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.default_callsReceived#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_callsReceived#getVariant()
	 * @see #getdefault_callsReceived()
	 * @generated
	 */
	EReference getdefault_callsReceived_Variant();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.default_methodCalls <em>default method Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>default method Calls</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_methodCalls
	 * @generated
	 */
	EClass getdefault_methodCalls();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.default_methodCalls#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_methodCalls#getVariant()
	 * @see #getdefault_methodCalls()
	 * @generated
	 */
	EReference getdefault_methodCalls_Variant();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.default_typedWith <em>default typed With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>default typed With</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_typedWith
	 * @generated
	 */
	EClass getdefault_typedWith();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.fsml.implModel.default_typedWith#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variant</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_typedWith#getVariant()
	 * @see #getdefault_typedWith()
	 * @generated
	 */
	EReference getdefault_typedWith_Variant();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew <em>variant assigned With New</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant assigned With New</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew
	 * @generated
	 */
	EClass getvariant_assignedWithNew();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull <em>variant assigned With Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant assigned With Null</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull
	 * @generated
	 */
	EClass getvariant_assignedWithNull();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass <em>variant extends Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant extends Class</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass
	 * @generated
	 */
	EClass getvariant_extendsClass();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface <em>variant implements Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant implements Interface</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface
	 * @generated
	 */
	EClass getvariant_implementsInterface();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived <em>variant calls Received</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant calls Received</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived
	 * @generated
	 */
	EClass getvariant_callsReceived();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls <em>variant method Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant method Calls</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls
	 * @generated
	 */
	EClass getvariant_methodCalls();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_typedWith <em>variant typed With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant typed With</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_typedWith
	 * @generated
	 */
	EClass getvariant_typedWith();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_Initializer <em>variant assigned With New Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant assigned With New Initializer</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_Initializer
	 * @generated
	 */
	EClass getvariant_assignedWithNew_Initializer();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_Initializer#getInitializedType <em>Initialized Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Type</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_Initializer#getInitializedType()
	 * @see #getvariant_assignedWithNew_Initializer()
	 * @generated
	 */
	EAttribute getvariant_assignedWithNew_Initializer_InitializedType();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_InMethod <em>variant assigned With New In Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant assigned With New In Method</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_InMethod
	 * @generated
	 */
	EClass getvariant_assignedWithNew_InMethod();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_InMethod#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_InMethod#getMethodName()
	 * @see #getvariant_assignedWithNew_InMethod()
	 * @generated
	 */
	EAttribute getvariant_assignedWithNew_InMethod_MethodName();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Directly <em>variant extends Class Directly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant extends Class Directly</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Directly
	 * @generated
	 */
	EClass getvariant_extendsClass_Directly();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Indirectly <em>variant extends Class Indirectly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant extends Class Indirectly</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Indirectly
	 * @generated
	 */
	EClass getvariant_extendsClass_Indirectly();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Indirectly#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Indirectly#getClassName()
	 * @see #getvariant_extendsClass_Indirectly()
	 * @generated
	 */
	EAttribute getvariant_extendsClass_Indirectly_ClassName();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Directly <em>variant implements Interface Directly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant implements Interface Directly</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Directly
	 * @generated
	 */
	EClass getvariant_implementsInterface_Directly();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Indirectly <em>variant implements Interface Indirectly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant implements Interface Indirectly</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Indirectly
	 * @generated
	 */
	EClass getvariant_implementsInterface_Indirectly();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Indirectly#getInterfaceName <em>Interface Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface Name</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Indirectly#getInterfaceName()
	 * @see #getvariant_implementsInterface_Indirectly()
	 * @generated
	 */
	EAttribute getvariant_implementsInterface_Indirectly_InterfaceName();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived_InMethod <em>variant calls Received In Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant calls Received In Method</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived_InMethod
	 * @generated
	 */
	EClass getvariant_callsReceived_InMethod();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived_InMethod#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived_InMethod#getMethodName()
	 * @see #getvariant_callsReceived_InMethod()
	 * @generated
	 */
	EAttribute getvariant_callsReceived_InMethod_MethodName();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls_InMethod <em>variant method Calls In Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant method Calls In Method</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls_InMethod
	 * @generated
	 */
	EClass getvariant_methodCalls_InMethod();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls_InMethod#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls_InMethod#getMethodName()
	 * @see #getvariant_methodCalls_InMethod()
	 * @generated
	 */
	EAttribute getvariant_methodCalls_InMethod_MethodName();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Directly <em>variant typed With Directly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant typed With Directly</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Directly
	 * @generated
	 */
	EClass getvariant_typedWith_Directly();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Indirectly <em>variant typed With Indirectly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant typed With Indirectly</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Indirectly
	 * @generated
	 */
	EClass getvariant_typedWith_Indirectly();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Indirectly#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Indirectly#getClassName()
	 * @see #getvariant_typedWith_Indirectly()
	 * @generated
	 */
	EAttribute getvariant_typedWith_Indirectly_ClassName();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer <em>variant assigned With Null Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant assigned With Null Initializer</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer
	 * @generated
	 */
	EClass getvariant_assignedWithNull_Initializer();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer#getInitializedType <em>Initialized Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Type</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer#getInitializedType()
	 * @see #getvariant_assignedWithNull_Initializer()
	 * @generated
	 */
	EAttribute getvariant_assignedWithNull_Initializer_InitializedType();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_InMethod <em>variant assigned With Null In Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>variant assigned With Null In Method</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_InMethod
	 * @generated
	 */
	EClass getvariant_assignedWithNull_InMethod();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_InMethod#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_InMethod#getMethodName()
	 * @see #getvariant_assignedWithNull_InMethod()
	 * @generated
	 */
	EAttribute getvariant_assignedWithNull_InMethod_MethodName();

	/**
	 * Returns the meta object for enum '{@link ca.uwaterloo.gsd.fsml.implModel.Position <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Position</em>'.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Position
	 * @generated
	 */
	EEnum getPosition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImplModelFactory getImplModelFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.implModelImpl <em>impl Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.implModelImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getimplModel()
		 * @generated
		 */
		EClass IMPL_MODEL = eINSTANCE.getimplModel();

		/**
		 * The meta object literal for the '<em><b>Defaults</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPL_MODEL__DEFAULTS = eINSTANCE.getimplModel_Defaults();

		/**
		 * The meta object literal for the '<em><b>Variants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPL_MODEL__VARIANTS = eINSTANCE.getimplModel_Variants();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.DefaultImpl <em>Default</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.DefaultImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getDefault()
		 * @generated
		 */
		EClass DEFAULT = eINSTANCE.getDefault();

		/**
		 * The meta object literal for the '<em><b>Overridden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT__OVERRIDDEN = eINSTANCE.getDefault_Overridden();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT__ECLASS = eINSTANCE.getDefault_EClass();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT__ESTRUCTURAL_FEATURE = eINSTANCE.getDefault_EStructuralFeature();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.VariantImpl <em>Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.VariantImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getVariant()
		 * @generated
		 */
		EClass VARIANT = eINSTANCE.getVariant();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT__ECLASS = eINSTANCE.getVariant_EClass();

		/**
		 * The meta object literal for the '<em><b>EStructural Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT__ESTRUCTURAL_FEATURE = eINSTANCE.getVariant_EStructuralFeature();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_assignedWithNewImpl <em>default assigned With New</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_assignedWithNewImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_assignedWithNew()
		 * @generated
		 */
		EClass DEFAULT_ASSIGNED_WITH_NEW = eINSTANCE.getdefault_assignedWithNew();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_ASSIGNED_WITH_NEW__VARIANT = eINSTANCE.getdefault_assignedWithNew_Variant();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_assignedWithNullImpl <em>default assigned With Null</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_assignedWithNullImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_assignedWithNull()
		 * @generated
		 */
		EClass DEFAULT_ASSIGNED_WITH_NULL = eINSTANCE.getdefault_assignedWithNull();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_ASSIGNED_WITH_NULL__VARIANT = eINSTANCE.getdefault_assignedWithNull_Variant();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_extendsClassImpl <em>default extends Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_extendsClassImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_extendsClass()
		 * @generated
		 */
		EClass DEFAULT_EXTENDS_CLASS = eINSTANCE.getdefault_extendsClass();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_EXTENDS_CLASS__VARIANT = eINSTANCE.getdefault_extendsClass_Variant();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_implementsInterfaceImpl <em>default implements Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_implementsInterfaceImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_implementsInterface()
		 * @generated
		 */
		EClass DEFAULT_IMPLEMENTS_INTERFACE = eINSTANCE.getdefault_implementsInterface();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_IMPLEMENTS_INTERFACE__VARIANT = eINSTANCE.getdefault_implementsInterface_Variant();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_callsReceivedImpl <em>default calls Received</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_callsReceivedImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_callsReceived()
		 * @generated
		 */
		EClass DEFAULT_CALLS_RECEIVED = eINSTANCE.getdefault_callsReceived();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_CALLS_RECEIVED__VARIANT = eINSTANCE.getdefault_callsReceived_Variant();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_methodCallsImpl <em>default method Calls</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_methodCallsImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_methodCalls()
		 * @generated
		 */
		EClass DEFAULT_METHOD_CALLS = eINSTANCE.getdefault_methodCalls();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_METHOD_CALLS__VARIANT = eINSTANCE.getdefault_methodCalls_Variant();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.default_typedWithImpl <em>default typed With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.default_typedWithImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getdefault_typedWith()
		 * @generated
		 */
		EClass DEFAULT_TYPED_WITH = eINSTANCE.getdefault_typedWith();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_TYPED_WITH__VARIANT = eINSTANCE.getdefault_typedWith_Variant();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNewImpl <em>variant assigned With New</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNewImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNew()
		 * @generated
		 */
		EClass VARIANT_ASSIGNED_WITH_NEW = eINSTANCE.getvariant_assignedWithNew();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNullImpl <em>variant assigned With Null</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNullImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNull()
		 * @generated
		 */
		EClass VARIANT_ASSIGNED_WITH_NULL = eINSTANCE.getvariant_assignedWithNull();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClassImpl <em>variant extends Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClassImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_extendsClass()
		 * @generated
		 */
		EClass VARIANT_EXTENDS_CLASS = eINSTANCE.getvariant_extendsClass();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterfaceImpl <em>variant implements Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterfaceImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_implementsInterface()
		 * @generated
		 */
		EClass VARIANT_IMPLEMENTS_INTERFACE = eINSTANCE.getvariant_implementsInterface();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_callsReceivedImpl <em>variant calls Received</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_callsReceivedImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_callsReceived()
		 * @generated
		 */
		EClass VARIANT_CALLS_RECEIVED = eINSTANCE.getvariant_callsReceived();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_methodCallsImpl <em>variant method Calls</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_methodCallsImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_methodCalls()
		 * @generated
		 */
		EClass VARIANT_METHOD_CALLS = eINSTANCE.getvariant_methodCalls();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWithImpl <em>variant typed With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWithImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_typedWith()
		 * @generated
		 */
		EClass VARIANT_TYPED_WITH = eINSTANCE.getvariant_typedWith();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNew_InitializerImpl <em>variant assigned With New Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNew_InitializerImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNew_Initializer()
		 * @generated
		 */
		EClass VARIANT_ASSIGNED_WITH_NEW_INITIALIZER = eINSTANCE.getvariant_assignedWithNew_Initializer();

		/**
		 * The meta object literal for the '<em><b>Initialized Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_ASSIGNED_WITH_NEW_INITIALIZER__INITIALIZED_TYPE = eINSTANCE.getvariant_assignedWithNew_Initializer_InitializedType();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNew_InMethodImpl <em>variant assigned With New In Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNew_InMethodImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNew_InMethod()
		 * @generated
		 */
		EClass VARIANT_ASSIGNED_WITH_NEW_IN_METHOD = eINSTANCE.getvariant_assignedWithNew_InMethod();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_ASSIGNED_WITH_NEW_IN_METHOD__METHOD_NAME = eINSTANCE.getvariant_assignedWithNew_InMethod_MethodName();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClass_DirectlyImpl <em>variant extends Class Directly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClass_DirectlyImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_extendsClass_Directly()
		 * @generated
		 */
		EClass VARIANT_EXTENDS_CLASS_DIRECTLY = eINSTANCE.getvariant_extendsClass_Directly();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClass_IndirectlyImpl <em>variant extends Class Indirectly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_extendsClass_IndirectlyImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_extendsClass_Indirectly()
		 * @generated
		 */
		EClass VARIANT_EXTENDS_CLASS_INDIRECTLY = eINSTANCE.getvariant_extendsClass_Indirectly();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_EXTENDS_CLASS_INDIRECTLY__CLASS_NAME = eINSTANCE.getvariant_extendsClass_Indirectly_ClassName();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterface_DirectlyImpl <em>variant implements Interface Directly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterface_DirectlyImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_implementsInterface_Directly()
		 * @generated
		 */
		EClass VARIANT_IMPLEMENTS_INTERFACE_DIRECTLY = eINSTANCE.getvariant_implementsInterface_Directly();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterface_IndirectlyImpl <em>variant implements Interface Indirectly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_implementsInterface_IndirectlyImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_implementsInterface_Indirectly()
		 * @generated
		 */
		EClass VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY = eINSTANCE.getvariant_implementsInterface_Indirectly();

		/**
		 * The meta object literal for the '<em><b>Interface Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY__INTERFACE_NAME = eINSTANCE.getvariant_implementsInterface_Indirectly_InterfaceName();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_callsReceived_InMethodImpl <em>variant calls Received In Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_callsReceived_InMethodImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_callsReceived_InMethod()
		 * @generated
		 */
		EClass VARIANT_CALLS_RECEIVED_IN_METHOD = eINSTANCE.getvariant_callsReceived_InMethod();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_CALLS_RECEIVED_IN_METHOD__METHOD_NAME = eINSTANCE.getvariant_callsReceived_InMethod_MethodName();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_methodCalls_InMethodImpl <em>variant method Calls In Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_methodCalls_InMethodImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_methodCalls_InMethod()
		 * @generated
		 */
		EClass VARIANT_METHOD_CALLS_IN_METHOD = eINSTANCE.getvariant_methodCalls_InMethod();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_METHOD_CALLS_IN_METHOD__METHOD_NAME = eINSTANCE.getvariant_methodCalls_InMethod_MethodName();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWith_DirectlyImpl <em>variant typed With Directly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWith_DirectlyImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_typedWith_Directly()
		 * @generated
		 */
		EClass VARIANT_TYPED_WITH_DIRECTLY = eINSTANCE.getvariant_typedWith_Directly();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWith_IndirectlyImpl <em>variant typed With Indirectly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_typedWith_IndirectlyImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_typedWith_Indirectly()
		 * @generated
		 */
		EClass VARIANT_TYPED_WITH_INDIRECTLY = eINSTANCE.getvariant_typedWith_Indirectly();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_TYPED_WITH_INDIRECTLY__CLASS_NAME = eINSTANCE.getvariant_typedWith_Indirectly_ClassName();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InitializerImpl <em>variant assigned With Null Initializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InitializerImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNull_Initializer()
		 * @generated
		 */
		EClass VARIANT_ASSIGNED_WITH_NULL_INITIALIZER = eINSTANCE.getvariant_assignedWithNull_Initializer();

		/**
		 * The meta object literal for the '<em><b>Initialized Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_ASSIGNED_WITH_NULL_INITIALIZER__INITIALIZED_TYPE = eINSTANCE.getvariant_assignedWithNull_Initializer_InitializedType();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InMethodImpl <em>variant assigned With Null In Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.variant_assignedWithNull_InMethodImpl
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getvariant_assignedWithNull_InMethod()
		 * @generated
		 */
		EClass VARIANT_ASSIGNED_WITH_NULL_IN_METHOD = eINSTANCE.getvariant_assignedWithNull_InMethod();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_ASSIGNED_WITH_NULL_IN_METHOD__METHOD_NAME = eINSTANCE.getvariant_assignedWithNull_InMethod_MethodName();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.implModel.Position <em>Position</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.implModel.Position
		 * @see ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelPackageImpl#getPosition()
		 * @generated
		 */
		EEnum POSITION = eINSTANCE.getPosition();

	}

} //ImplModelPackage
