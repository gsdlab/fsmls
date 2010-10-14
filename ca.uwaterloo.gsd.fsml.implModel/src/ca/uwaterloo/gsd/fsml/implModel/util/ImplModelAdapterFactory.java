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

package ca.uwaterloo.gsd.fsml.implModel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import ca.uwaterloo.gsd.fsml.implModel.Default;
import ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage
 * @generated
 */
public class ImplModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImplModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ImplModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplModelSwitch<Adapter> modelSwitch =
		new ImplModelSwitch<Adapter>() {
			@Override
			public Adapter caseimplModel(implModel object) {
				return createimplModelAdapter();
			}
			@Override
			public Adapter caseDefault(Default object) {
				return createDefaultAdapter();
			}
			@Override
			public Adapter caseVariant(Variant object) {
				return createVariantAdapter();
			}
			@Override
			public Adapter casedefault_assignedWithNew(default_assignedWithNew object) {
				return createdefault_assignedWithNewAdapter();
			}
			@Override
			public Adapter casedefault_assignedWithNull(default_assignedWithNull object) {
				return createdefault_assignedWithNullAdapter();
			}
			@Override
			public Adapter casedefault_extendsClass(default_extendsClass object) {
				return createdefault_extendsClassAdapter();
			}
			@Override
			public Adapter casedefault_implementsInterface(default_implementsInterface object) {
				return createdefault_implementsInterfaceAdapter();
			}
			@Override
			public Adapter casedefault_callsReceived(default_callsReceived object) {
				return createdefault_callsReceivedAdapter();
			}
			@Override
			public Adapter casedefault_methodCalls(default_methodCalls object) {
				return createdefault_methodCallsAdapter();
			}
			@Override
			public Adapter casedefault_typedWith(default_typedWith object) {
				return createdefault_typedWithAdapter();
			}
			@Override
			public Adapter casevariant_assignedWithNew(variant_assignedWithNew object) {
				return createvariant_assignedWithNewAdapter();
			}
			@Override
			public Adapter casevariant_assignedWithNull(variant_assignedWithNull object) {
				return createvariant_assignedWithNullAdapter();
			}
			@Override
			public Adapter casevariant_extendsClass(variant_extendsClass object) {
				return createvariant_extendsClassAdapter();
			}
			@Override
			public Adapter casevariant_implementsInterface(variant_implementsInterface object) {
				return createvariant_implementsInterfaceAdapter();
			}
			@Override
			public Adapter casevariant_callsReceived(variant_callsReceived object) {
				return createvariant_callsReceivedAdapter();
			}
			@Override
			public Adapter casevariant_methodCalls(variant_methodCalls object) {
				return createvariant_methodCallsAdapter();
			}
			@Override
			public Adapter casevariant_typedWith(variant_typedWith object) {
				return createvariant_typedWithAdapter();
			}
			@Override
			public Adapter casevariant_assignedWithNew_Initializer(variant_assignedWithNew_Initializer object) {
				return createvariant_assignedWithNew_InitializerAdapter();
			}
			@Override
			public Adapter casevariant_assignedWithNew_InMethod(variant_assignedWithNew_InMethod object) {
				return createvariant_assignedWithNew_InMethodAdapter();
			}
			@Override
			public Adapter casevariant_extendsClass_Directly(variant_extendsClass_Directly object) {
				return createvariant_extendsClass_DirectlyAdapter();
			}
			@Override
			public Adapter casevariant_extendsClass_Indirectly(variant_extendsClass_Indirectly object) {
				return createvariant_extendsClass_IndirectlyAdapter();
			}
			@Override
			public Adapter casevariant_implementsInterface_Directly(variant_implementsInterface_Directly object) {
				return createvariant_implementsInterface_DirectlyAdapter();
			}
			@Override
			public Adapter casevariant_implementsInterface_Indirectly(variant_implementsInterface_Indirectly object) {
				return createvariant_implementsInterface_IndirectlyAdapter();
			}
			@Override
			public Adapter casevariant_callsReceived_InMethod(variant_callsReceived_InMethod object) {
				return createvariant_callsReceived_InMethodAdapter();
			}
			@Override
			public Adapter casevariant_methodCalls_InMethod(variant_methodCalls_InMethod object) {
				return createvariant_methodCalls_InMethodAdapter();
			}
			@Override
			public Adapter casevariant_typedWith_Directly(variant_typedWith_Directly object) {
				return createvariant_typedWith_DirectlyAdapter();
			}
			@Override
			public Adapter casevariant_typedWith_Indirectly(variant_typedWith_Indirectly object) {
				return createvariant_typedWith_IndirectlyAdapter();
			}
			@Override
			public Adapter casevariant_assignedWithNull_Initializer(variant_assignedWithNull_Initializer object) {
				return createvariant_assignedWithNull_InitializerAdapter();
			}
			@Override
			public Adapter casevariant_assignedWithNull_InMethod(variant_assignedWithNull_InMethod object) {
				return createvariant_assignedWithNull_InMethodAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.implModel <em>impl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.implModel
	 * @generated
	 */
	public Adapter createimplModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.Default <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Default
	 * @generated
	 */
	public Adapter createDefaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.Variant
	 * @generated
	 */
	public Adapter createVariantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNew <em>default assigned With New</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNew
	 * @generated
	 */
	public Adapter createdefault_assignedWithNewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNull <em>default assigned With Null</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNull
	 * @generated
	 */
	public Adapter createdefault_assignedWithNullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.default_extendsClass <em>default extends Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_extendsClass
	 * @generated
	 */
	public Adapter createdefault_extendsClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.default_implementsInterface <em>default implements Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_implementsInterface
	 * @generated
	 */
	public Adapter createdefault_implementsInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.default_callsReceived <em>default calls Received</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_callsReceived
	 * @generated
	 */
	public Adapter createdefault_callsReceivedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.default_methodCalls <em>default method Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_methodCalls
	 * @generated
	 */
	public Adapter createdefault_methodCallsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.default_typedWith <em>default typed With</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.default_typedWith
	 * @generated
	 */
	public Adapter createdefault_typedWithAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew <em>variant assigned With New</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew
	 * @generated
	 */
	public Adapter createvariant_assignedWithNewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull <em>variant assigned With Null</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull
	 * @generated
	 */
	public Adapter createvariant_assignedWithNullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass <em>variant extends Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass
	 * @generated
	 */
	public Adapter createvariant_extendsClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface <em>variant implements Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface
	 * @generated
	 */
	public Adapter createvariant_implementsInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived <em>variant calls Received</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived
	 * @generated
	 */
	public Adapter createvariant_callsReceivedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls <em>variant method Calls</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls
	 * @generated
	 */
	public Adapter createvariant_methodCallsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_typedWith <em>variant typed With</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_typedWith
	 * @generated
	 */
	public Adapter createvariant_typedWithAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_Initializer <em>variant assigned With New Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_Initializer
	 * @generated
	 */
	public Adapter createvariant_assignedWithNew_InitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_InMethod <em>variant assigned With New In Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_InMethod
	 * @generated
	 */
	public Adapter createvariant_assignedWithNew_InMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Directly <em>variant extends Class Directly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Directly
	 * @generated
	 */
	public Adapter createvariant_extendsClass_DirectlyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Indirectly <em>variant extends Class Indirectly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Indirectly
	 * @generated
	 */
	public Adapter createvariant_extendsClass_IndirectlyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Directly <em>variant implements Interface Directly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Directly
	 * @generated
	 */
	public Adapter createvariant_implementsInterface_DirectlyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Indirectly <em>variant implements Interface Indirectly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Indirectly
	 * @generated
	 */
	public Adapter createvariant_implementsInterface_IndirectlyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived_InMethod <em>variant calls Received In Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived_InMethod
	 * @generated
	 */
	public Adapter createvariant_callsReceived_InMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls_InMethod <em>variant method Calls In Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls_InMethod
	 * @generated
	 */
	public Adapter createvariant_methodCalls_InMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Directly <em>variant typed With Directly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Directly
	 * @generated
	 */
	public Adapter createvariant_typedWith_DirectlyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Indirectly <em>variant typed With Indirectly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Indirectly
	 * @generated
	 */
	public Adapter createvariant_typedWith_IndirectlyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer <em>variant assigned With Null Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer
	 * @generated
	 */
	public Adapter createvariant_assignedWithNull_InitializerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_InMethod <em>variant assigned With Null In Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_InMethod
	 * @generated
	 */
	public Adapter createvariant_assignedWithNull_InMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ImplModelAdapterFactory
