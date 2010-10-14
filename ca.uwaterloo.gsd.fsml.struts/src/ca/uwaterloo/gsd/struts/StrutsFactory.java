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
/**
  *
 *
 *
 * $Id: StrutsFactory.java,v 1.8 2008/03/20 04:01:54 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.struts.StrutsPackage
 * @generated
 */
public interface StrutsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StrutsFactory eINSTANCE = ca.uwaterloo.gsd.struts.impl.StrutsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application</em>'.
	 * @generated
	 */
	StrutsApplication createStrutsApplication();

	/**
	 * Returns a new object of class '<em>Form Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Impl</em>'.
	 * @generated
	 */
	FormImpl createFormImpl();

	/**
	 * Returns a new object of class '<em>Extends Action Form</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Action Form</em>'.
	 * @generated
	 */
	ExtendsActionForm createExtendsActionForm();

	/**
	 * Returns a new object of class '<em>Action Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Impl</em>'.
	 * @generated
	 */
	ActionImpl createActionImpl();

	/**
	 * Returns a new object of class '<em>Forward Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forward Impl</em>'.
	 * @generated
	 */
	ForwardImpl createForwardImpl();

	/**
	 * Returns a new object of class '<em>Input Forward Impl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Forward Impl</em>'.
	 * @generated
	 */
	InputForwardImpl createInputForwardImpl();

	/**
	 * Returns a new object of class '<em>Forward</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forward</em>'.
	 * @generated
	 */
	Forward createForward();

	/**
	 * Returns a new object of class '<em>Extends Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Action</em>'.
	 * @generated
	 */
	ExtendsAction createExtendsAction();

	/**
	 * Returns a new object of class '<em>Extends Dispatch Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Dispatch Action</em>'.
	 * @generated
	 */
	ExtendsDispatchAction createExtendsDispatchAction();

	/**
	 * Returns a new object of class '<em>Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Config</em>'.
	 * @generated
	 */
	StrutsConfig createStrutsConfig();

	/**
	 * Returns a new object of class '<em>Action Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Decl</em>'.
	 * @generated
	 */
	ActionDecl createActionDecl();

	/**
	 * Returns a new object of class '<em>Form Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Decl</em>'.
	 * @generated
	 */
	FormDecl createFormDecl();

	/**
	 * Returns a new object of class '<em>Forward Decl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forward Decl</em>'.
	 * @generated
	 */
	ForwardDecl createForwardDecl();

	/**
	 * Returns a new object of class '<em>Form Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Property</em>'.
	 * @generated
	 */
	FormProperty createFormProperty();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StrutsPackage getStrutsPackage();

} //StrutsFactory
