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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage
 * @generated
 */
public class ImplModelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImplModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplModelSwitch() {
		if (modelPackage == null) {
			modelPackage = ImplModelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ImplModelPackage.IMPL_MODEL: {
				implModel implModel = (implModel)theEObject;
				T result = caseimplModel(implModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.DEFAULT: {
				Default default_ = (Default)theEObject;
				T result = caseDefault(default_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT: {
				Variant variant = (Variant)theEObject;
				T result = caseVariant(variant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.DEFAULT_ASSIGNED_WITH_NEW: {
				default_assignedWithNew default_assignedWithNew = (default_assignedWithNew)theEObject;
				T result = casedefault_assignedWithNew(default_assignedWithNew);
				if (result == null) result = caseDefault(default_assignedWithNew);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.DEFAULT_ASSIGNED_WITH_NULL: {
				default_assignedWithNull default_assignedWithNull = (default_assignedWithNull)theEObject;
				T result = casedefault_assignedWithNull(default_assignedWithNull);
				if (result == null) result = caseDefault(default_assignedWithNull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.DEFAULT_EXTENDS_CLASS: {
				default_extendsClass default_extendsClass = (default_extendsClass)theEObject;
				T result = casedefault_extendsClass(default_extendsClass);
				if (result == null) result = caseDefault(default_extendsClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.DEFAULT_IMPLEMENTS_INTERFACE: {
				default_implementsInterface default_implementsInterface = (default_implementsInterface)theEObject;
				T result = casedefault_implementsInterface(default_implementsInterface);
				if (result == null) result = caseDefault(default_implementsInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.DEFAULT_CALLS_RECEIVED: {
				default_callsReceived default_callsReceived = (default_callsReceived)theEObject;
				T result = casedefault_callsReceived(default_callsReceived);
				if (result == null) result = caseDefault(default_callsReceived);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.DEFAULT_METHOD_CALLS: {
				default_methodCalls default_methodCalls = (default_methodCalls)theEObject;
				T result = casedefault_methodCalls(default_methodCalls);
				if (result == null) result = caseDefault(default_methodCalls);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.DEFAULT_TYPED_WITH: {
				default_typedWith default_typedWith = (default_typedWith)theEObject;
				T result = casedefault_typedWith(default_typedWith);
				if (result == null) result = caseDefault(default_typedWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NEW: {
				variant_assignedWithNew variant_assignedWithNew = (variant_assignedWithNew)theEObject;
				T result = casevariant_assignedWithNew(variant_assignedWithNew);
				if (result == null) result = caseVariant(variant_assignedWithNew);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL: {
				variant_assignedWithNull variant_assignedWithNull = (variant_assignedWithNull)theEObject;
				T result = casevariant_assignedWithNull(variant_assignedWithNull);
				if (result == null) result = caseVariant(variant_assignedWithNull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_EXTENDS_CLASS: {
				variant_extendsClass variant_extendsClass = (variant_extendsClass)theEObject;
				T result = casevariant_extendsClass(variant_extendsClass);
				if (result == null) result = caseVariant(variant_extendsClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_IMPLEMENTS_INTERFACE: {
				variant_implementsInterface variant_implementsInterface = (variant_implementsInterface)theEObject;
				T result = casevariant_implementsInterface(variant_implementsInterface);
				if (result == null) result = caseVariant(variant_implementsInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_CALLS_RECEIVED: {
				variant_callsReceived variant_callsReceived = (variant_callsReceived)theEObject;
				T result = casevariant_callsReceived(variant_callsReceived);
				if (result == null) result = caseVariant(variant_callsReceived);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_METHOD_CALLS: {
				variant_methodCalls variant_methodCalls = (variant_methodCalls)theEObject;
				T result = casevariant_methodCalls(variant_methodCalls);
				if (result == null) result = caseVariant(variant_methodCalls);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_TYPED_WITH: {
				variant_typedWith variant_typedWith = (variant_typedWith)theEObject;
				T result = casevariant_typedWith(variant_typedWith);
				if (result == null) result = caseVariant(variant_typedWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NEW_INITIALIZER: {
				variant_assignedWithNew_Initializer variant_assignedWithNew_Initializer = (variant_assignedWithNew_Initializer)theEObject;
				T result = casevariant_assignedWithNew_Initializer(variant_assignedWithNew_Initializer);
				if (result == null) result = casevariant_assignedWithNew(variant_assignedWithNew_Initializer);
				if (result == null) result = caseVariant(variant_assignedWithNew_Initializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NEW_IN_METHOD: {
				variant_assignedWithNew_InMethod variant_assignedWithNew_InMethod = (variant_assignedWithNew_InMethod)theEObject;
				T result = casevariant_assignedWithNew_InMethod(variant_assignedWithNew_InMethod);
				if (result == null) result = casevariant_assignedWithNew(variant_assignedWithNew_InMethod);
				if (result == null) result = caseVariant(variant_assignedWithNew_InMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_EXTENDS_CLASS_DIRECTLY: {
				variant_extendsClass_Directly variant_extendsClass_Directly = (variant_extendsClass_Directly)theEObject;
				T result = casevariant_extendsClass_Directly(variant_extendsClass_Directly);
				if (result == null) result = casevariant_extendsClass(variant_extendsClass_Directly);
				if (result == null) result = caseVariant(variant_extendsClass_Directly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_EXTENDS_CLASS_INDIRECTLY: {
				variant_extendsClass_Indirectly variant_extendsClass_Indirectly = (variant_extendsClass_Indirectly)theEObject;
				T result = casevariant_extendsClass_Indirectly(variant_extendsClass_Indirectly);
				if (result == null) result = casevariant_extendsClass(variant_extendsClass_Indirectly);
				if (result == null) result = caseVariant(variant_extendsClass_Indirectly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_IMPLEMENTS_INTERFACE_DIRECTLY: {
				variant_implementsInterface_Directly variant_implementsInterface_Directly = (variant_implementsInterface_Directly)theEObject;
				T result = casevariant_implementsInterface_Directly(variant_implementsInterface_Directly);
				if (result == null) result = casevariant_implementsInterface(variant_implementsInterface_Directly);
				if (result == null) result = caseVariant(variant_implementsInterface_Directly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY: {
				variant_implementsInterface_Indirectly variant_implementsInterface_Indirectly = (variant_implementsInterface_Indirectly)theEObject;
				T result = casevariant_implementsInterface_Indirectly(variant_implementsInterface_Indirectly);
				if (result == null) result = casevariant_implementsInterface(variant_implementsInterface_Indirectly);
				if (result == null) result = caseVariant(variant_implementsInterface_Indirectly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_CALLS_RECEIVED_IN_METHOD: {
				variant_callsReceived_InMethod variant_callsReceived_InMethod = (variant_callsReceived_InMethod)theEObject;
				T result = casevariant_callsReceived_InMethod(variant_callsReceived_InMethod);
				if (result == null) result = casevariant_callsReceived(variant_callsReceived_InMethod);
				if (result == null) result = caseVariant(variant_callsReceived_InMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_METHOD_CALLS_IN_METHOD: {
				variant_methodCalls_InMethod variant_methodCalls_InMethod = (variant_methodCalls_InMethod)theEObject;
				T result = casevariant_methodCalls_InMethod(variant_methodCalls_InMethod);
				if (result == null) result = casevariant_methodCalls(variant_methodCalls_InMethod);
				if (result == null) result = caseVariant(variant_methodCalls_InMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_TYPED_WITH_DIRECTLY: {
				variant_typedWith_Directly variant_typedWith_Directly = (variant_typedWith_Directly)theEObject;
				T result = casevariant_typedWith_Directly(variant_typedWith_Directly);
				if (result == null) result = casevariant_typedWith(variant_typedWith_Directly);
				if (result == null) result = caseVariant(variant_typedWith_Directly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_TYPED_WITH_INDIRECTLY: {
				variant_typedWith_Indirectly variant_typedWith_Indirectly = (variant_typedWith_Indirectly)theEObject;
				T result = casevariant_typedWith_Indirectly(variant_typedWith_Indirectly);
				if (result == null) result = casevariant_typedWith(variant_typedWith_Indirectly);
				if (result == null) result = caseVariant(variant_typedWith_Indirectly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_INITIALIZER: {
				variant_assignedWithNull_Initializer variant_assignedWithNull_Initializer = (variant_assignedWithNull_Initializer)theEObject;
				T result = casevariant_assignedWithNull_Initializer(variant_assignedWithNull_Initializer);
				if (result == null) result = casevariant_assignedWithNull(variant_assignedWithNull_Initializer);
				if (result == null) result = caseVariant(variant_assignedWithNull_Initializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_IN_METHOD: {
				variant_assignedWithNull_InMethod variant_assignedWithNull_InMethod = (variant_assignedWithNull_InMethod)theEObject;
				T result = casevariant_assignedWithNull_InMethod(variant_assignedWithNull_InMethod);
				if (result == null) result = casevariant_assignedWithNull(variant_assignedWithNull_InMethod);
				if (result == null) result = caseVariant(variant_assignedWithNull_InMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>impl Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>impl Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseimplModel(implModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefault(Default object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariant(Variant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>default assigned With New</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>default assigned With New</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedefault_assignedWithNew(default_assignedWithNew object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>default assigned With Null</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>default assigned With Null</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedefault_assignedWithNull(default_assignedWithNull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>default extends Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>default extends Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedefault_extendsClass(default_extendsClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>default implements Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>default implements Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedefault_implementsInterface(default_implementsInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>default calls Received</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>default calls Received</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedefault_callsReceived(default_callsReceived object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>default method Calls</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>default method Calls</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedefault_methodCalls(default_methodCalls object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>default typed With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>default typed With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casedefault_typedWith(default_typedWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant assigned With New</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant assigned With New</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_assignedWithNew(variant_assignedWithNew object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant assigned With Null</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant assigned With Null</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_assignedWithNull(variant_assignedWithNull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant extends Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant extends Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_extendsClass(variant_extendsClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant implements Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant implements Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_implementsInterface(variant_implementsInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant calls Received</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant calls Received</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_callsReceived(variant_callsReceived object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant method Calls</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant method Calls</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_methodCalls(variant_methodCalls object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant typed With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant typed With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_typedWith(variant_typedWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant assigned With New Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant assigned With New Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_assignedWithNew_Initializer(variant_assignedWithNew_Initializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant assigned With New In Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant assigned With New In Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_assignedWithNew_InMethod(variant_assignedWithNew_InMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant extends Class Directly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant extends Class Directly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_extendsClass_Directly(variant_extendsClass_Directly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant extends Class Indirectly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant extends Class Indirectly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_extendsClass_Indirectly(variant_extendsClass_Indirectly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant implements Interface Directly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant implements Interface Directly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_implementsInterface_Directly(variant_implementsInterface_Directly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant implements Interface Indirectly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant implements Interface Indirectly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_implementsInterface_Indirectly(variant_implementsInterface_Indirectly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant calls Received In Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant calls Received In Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_callsReceived_InMethod(variant_callsReceived_InMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant method Calls In Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant method Calls In Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_methodCalls_InMethod(variant_methodCalls_InMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant typed With Directly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant typed With Directly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_typedWith_Directly(variant_typedWith_Directly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant typed With Indirectly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant typed With Indirectly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_typedWith_Indirectly(variant_typedWith_Indirectly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant assigned With Null Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant assigned With Null Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_assignedWithNull_Initializer(variant_assignedWithNull_Initializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>variant assigned With Null In Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>variant assigned With Null In Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casevariant_assignedWithNull_InMethod(variant_assignedWithNull_InMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ImplModelSwitch
