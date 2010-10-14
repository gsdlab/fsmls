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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import ca.uwaterloo.gsd.fsml.implModel.ImplModelFactory;
import ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage;
import ca.uwaterloo.gsd.fsml.implModel.Position;
import ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNew;
import ca.uwaterloo.gsd.fsml.implModel.default_assignedWithNull;
import ca.uwaterloo.gsd.fsml.implModel.default_callsReceived;
import ca.uwaterloo.gsd.fsml.implModel.default_extendsClass;
import ca.uwaterloo.gsd.fsml.implModel.default_implementsInterface;
import ca.uwaterloo.gsd.fsml.implModel.default_methodCalls;
import ca.uwaterloo.gsd.fsml.implModel.default_typedWith;
import ca.uwaterloo.gsd.fsml.implModel.implModel;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_InMethod;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNew_Initializer;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_InMethod;
import ca.uwaterloo.gsd.fsml.implModel.variant_assignedWithNull_Initializer;
import ca.uwaterloo.gsd.fsml.implModel.variant_callsReceived_InMethod;
import ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Directly;
import ca.uwaterloo.gsd.fsml.implModel.variant_extendsClass_Indirectly;
import ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Directly;
import ca.uwaterloo.gsd.fsml.implModel.variant_implementsInterface_Indirectly;
import ca.uwaterloo.gsd.fsml.implModel.variant_methodCalls_InMethod;
import ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Directly;
import ca.uwaterloo.gsd.fsml.implModel.variant_typedWith_Indirectly;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImplModelFactoryImpl extends EFactoryImpl implements ImplModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplModelFactory init() {
		try {
			ImplModelFactory theImplModelFactory = (ImplModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://ca.uwaterloo.gsd/implModel"); 
			if (theImplModelFactory != null) {
				return theImplModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImplModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplModelFactoryImpl() {
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
			case ImplModelPackage.IMPL_MODEL: return createimplModel();
			case ImplModelPackage.DEFAULT_ASSIGNED_WITH_NEW: return createdefault_assignedWithNew();
			case ImplModelPackage.DEFAULT_ASSIGNED_WITH_NULL: return createdefault_assignedWithNull();
			case ImplModelPackage.DEFAULT_EXTENDS_CLASS: return createdefault_extendsClass();
			case ImplModelPackage.DEFAULT_IMPLEMENTS_INTERFACE: return createdefault_implementsInterface();
			case ImplModelPackage.DEFAULT_CALLS_RECEIVED: return createdefault_callsReceived();
			case ImplModelPackage.DEFAULT_METHOD_CALLS: return createdefault_methodCalls();
			case ImplModelPackage.DEFAULT_TYPED_WITH: return createdefault_typedWith();
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NEW_INITIALIZER: return createvariant_assignedWithNew_Initializer();
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NEW_IN_METHOD: return createvariant_assignedWithNew_InMethod();
			case ImplModelPackage.VARIANT_EXTENDS_CLASS_DIRECTLY: return createvariant_extendsClass_Directly();
			case ImplModelPackage.VARIANT_EXTENDS_CLASS_INDIRECTLY: return createvariant_extendsClass_Indirectly();
			case ImplModelPackage.VARIANT_IMPLEMENTS_INTERFACE_DIRECTLY: return createvariant_implementsInterface_Directly();
			case ImplModelPackage.VARIANT_IMPLEMENTS_INTERFACE_INDIRECTLY: return createvariant_implementsInterface_Indirectly();
			case ImplModelPackage.VARIANT_CALLS_RECEIVED_IN_METHOD: return createvariant_callsReceived_InMethod();
			case ImplModelPackage.VARIANT_METHOD_CALLS_IN_METHOD: return createvariant_methodCalls_InMethod();
			case ImplModelPackage.VARIANT_TYPED_WITH_DIRECTLY: return createvariant_typedWith_Directly();
			case ImplModelPackage.VARIANT_TYPED_WITH_INDIRECTLY: return createvariant_typedWith_Indirectly();
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_INITIALIZER: return createvariant_assignedWithNull_Initializer();
			case ImplModelPackage.VARIANT_ASSIGNED_WITH_NULL_IN_METHOD: return createvariant_assignedWithNull_InMethod();
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
			case ImplModelPackage.POSITION:
				return createPositionFromString(eDataType, initialValue);
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
			case ImplModelPackage.POSITION:
				return convertPositionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public implModel createimplModel() {
		implModelImpl implModel = new implModelImpl();
		return implModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public default_assignedWithNew createdefault_assignedWithNew() {
		default_assignedWithNewImpl default_assignedWithNew = new default_assignedWithNewImpl();
		return default_assignedWithNew;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public default_assignedWithNull createdefault_assignedWithNull() {
		default_assignedWithNullImpl default_assignedWithNull = new default_assignedWithNullImpl();
		return default_assignedWithNull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public default_extendsClass createdefault_extendsClass() {
		default_extendsClassImpl default_extendsClass = new default_extendsClassImpl();
		return default_extendsClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public default_implementsInterface createdefault_implementsInterface() {
		default_implementsInterfaceImpl default_implementsInterface = new default_implementsInterfaceImpl();
		return default_implementsInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public default_callsReceived createdefault_callsReceived() {
		default_callsReceivedImpl default_callsReceived = new default_callsReceivedImpl();
		return default_callsReceived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public default_methodCalls createdefault_methodCalls() {
		default_methodCallsImpl default_methodCalls = new default_methodCallsImpl();
		return default_methodCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public default_typedWith createdefault_typedWith() {
		default_typedWithImpl default_typedWith = new default_typedWithImpl();
		return default_typedWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_assignedWithNew_Initializer createvariant_assignedWithNew_Initializer() {
		variant_assignedWithNew_InitializerImpl variant_assignedWithNew_Initializer = new variant_assignedWithNew_InitializerImpl();
		return variant_assignedWithNew_Initializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_assignedWithNew_InMethod createvariant_assignedWithNew_InMethod() {
		variant_assignedWithNew_InMethodImpl variant_assignedWithNew_InMethod = new variant_assignedWithNew_InMethodImpl();
		return variant_assignedWithNew_InMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_extendsClass_Directly createvariant_extendsClass_Directly() {
		variant_extendsClass_DirectlyImpl variant_extendsClass_Directly = new variant_extendsClass_DirectlyImpl();
		return variant_extendsClass_Directly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_extendsClass_Indirectly createvariant_extendsClass_Indirectly() {
		variant_extendsClass_IndirectlyImpl variant_extendsClass_Indirectly = new variant_extendsClass_IndirectlyImpl();
		return variant_extendsClass_Indirectly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_implementsInterface_Directly createvariant_implementsInterface_Directly() {
		variant_implementsInterface_DirectlyImpl variant_implementsInterface_Directly = new variant_implementsInterface_DirectlyImpl();
		return variant_implementsInterface_Directly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_implementsInterface_Indirectly createvariant_implementsInterface_Indirectly() {
		variant_implementsInterface_IndirectlyImpl variant_implementsInterface_Indirectly = new variant_implementsInterface_IndirectlyImpl();
		return variant_implementsInterface_Indirectly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_callsReceived_InMethod createvariant_callsReceived_InMethod() {
		variant_callsReceived_InMethodImpl variant_callsReceived_InMethod = new variant_callsReceived_InMethodImpl();
		return variant_callsReceived_InMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_methodCalls_InMethod createvariant_methodCalls_InMethod() {
		variant_methodCalls_InMethodImpl variant_methodCalls_InMethod = new variant_methodCalls_InMethodImpl();
		return variant_methodCalls_InMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_typedWith_Directly createvariant_typedWith_Directly() {
		variant_typedWith_DirectlyImpl variant_typedWith_Directly = new variant_typedWith_DirectlyImpl();
		return variant_typedWith_Directly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_typedWith_Indirectly createvariant_typedWith_Indirectly() {
		variant_typedWith_IndirectlyImpl variant_typedWith_Indirectly = new variant_typedWith_IndirectlyImpl();
		return variant_typedWith_Indirectly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_assignedWithNull_Initializer createvariant_assignedWithNull_Initializer() {
		variant_assignedWithNull_InitializerImpl variant_assignedWithNull_Initializer = new variant_assignedWithNull_InitializerImpl();
		return variant_assignedWithNull_Initializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public variant_assignedWithNull_InMethod createvariant_assignedWithNull_InMethod() {
		variant_assignedWithNull_InMethodImpl variant_assignedWithNull_InMethod = new variant_assignedWithNull_InMethodImpl();
		return variant_assignedWithNull_InMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Position createPositionFromString(EDataType eDataType, String initialValue) {
		Position result = Position.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplModelPackage getImplModelPackage() {
		return (ImplModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImplModelPackage getPackage() {
		return ImplModelPackage.eINSTANCE;
	}

} //ImplModelFactoryImpl
