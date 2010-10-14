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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage
 * @generated
 */
public interface ImplModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImplModelFactory eINSTANCE = ca.uwaterloo.gsd.fsml.implModel.impl.ImplModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>impl Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>impl Model</em>'.
	 * @generated
	 */
	implModel createimplModel();

	/**
	 * Returns a new object of class '<em>default assigned With New</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>default assigned With New</em>'.
	 * @generated
	 */
	default_assignedWithNew createdefault_assignedWithNew();

	/**
	 * Returns a new object of class '<em>default assigned With Null</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>default assigned With Null</em>'.
	 * @generated
	 */
	default_assignedWithNull createdefault_assignedWithNull();

	/**
	 * Returns a new object of class '<em>default extends Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>default extends Class</em>'.
	 * @generated
	 */
	default_extendsClass createdefault_extendsClass();

	/**
	 * Returns a new object of class '<em>default implements Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>default implements Interface</em>'.
	 * @generated
	 */
	default_implementsInterface createdefault_implementsInterface();

	/**
	 * Returns a new object of class '<em>default calls Received</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>default calls Received</em>'.
	 * @generated
	 */
	default_callsReceived createdefault_callsReceived();

	/**
	 * Returns a new object of class '<em>default method Calls</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>default method Calls</em>'.
	 * @generated
	 */
	default_methodCalls createdefault_methodCalls();

	/**
	 * Returns a new object of class '<em>default typed With</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>default typed With</em>'.
	 * @generated
	 */
	default_typedWith createdefault_typedWith();

	/**
	 * Returns a new object of class '<em>variant assigned With New Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant assigned With New Initializer</em>'.
	 * @generated
	 */
	variant_assignedWithNew_Initializer createvariant_assignedWithNew_Initializer();

	/**
	 * Returns a new object of class '<em>variant assigned With New In Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant assigned With New In Method</em>'.
	 * @generated
	 */
	variant_assignedWithNew_InMethod createvariant_assignedWithNew_InMethod();

	/**
	 * Returns a new object of class '<em>variant extends Class Directly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant extends Class Directly</em>'.
	 * @generated
	 */
	variant_extendsClass_Directly createvariant_extendsClass_Directly();

	/**
	 * Returns a new object of class '<em>variant extends Class Indirectly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant extends Class Indirectly</em>'.
	 * @generated
	 */
	variant_extendsClass_Indirectly createvariant_extendsClass_Indirectly();

	/**
	 * Returns a new object of class '<em>variant implements Interface Directly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant implements Interface Directly</em>'.
	 * @generated
	 */
	variant_implementsInterface_Directly createvariant_implementsInterface_Directly();

	/**
	 * Returns a new object of class '<em>variant implements Interface Indirectly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant implements Interface Indirectly</em>'.
	 * @generated
	 */
	variant_implementsInterface_Indirectly createvariant_implementsInterface_Indirectly();

	/**
	 * Returns a new object of class '<em>variant calls Received In Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant calls Received In Method</em>'.
	 * @generated
	 */
	variant_callsReceived_InMethod createvariant_callsReceived_InMethod();

	/**
	 * Returns a new object of class '<em>variant method Calls In Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant method Calls In Method</em>'.
	 * @generated
	 */
	variant_methodCalls_InMethod createvariant_methodCalls_InMethod();

	/**
	 * Returns a new object of class '<em>variant typed With Directly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant typed With Directly</em>'.
	 * @generated
	 */
	variant_typedWith_Directly createvariant_typedWith_Directly();

	/**
	 * Returns a new object of class '<em>variant typed With Indirectly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant typed With Indirectly</em>'.
	 * @generated
	 */
	variant_typedWith_Indirectly createvariant_typedWith_Indirectly();

	/**
	 * Returns a new object of class '<em>variant assigned With Null Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant assigned With Null Initializer</em>'.
	 * @generated
	 */
	variant_assignedWithNull_Initializer createvariant_assignedWithNull_Initializer();

	/**
	 * Returns a new object of class '<em>variant assigned With Null In Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>variant assigned With Null In Method</em>'.
	 * @generated
	 */
	variant_assignedWithNull_InMethod createvariant_assignedWithNull_InMethod();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImplModelPackage getImplModelPackage();

} //ImplModelFactory
