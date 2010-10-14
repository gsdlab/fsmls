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
 * $Id: StrutsApplication.java,v 1.7 2007/12/06 03:28:19 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;
import ca.uwaterloo.gsd.fsml.fsml.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.StrutsApplication#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.StrutsApplication#getStrutsConfig <em>Struts Config</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.StrutsApplication#getForms <em>Forms</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.StrutsApplication#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsApplication()
 * @model
 * @generated
 */
public interface StrutsApplication extends Concept, Model {
	/**
	 * Returns the value of the '<em><b>Struts Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Struts Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Struts Config</em>' containment reference.
	 * @see #setStrutsConfig(StrutsConfig)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsApplication_StrutsConfig()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StrutsConfig getStrutsConfig();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.StrutsApplication#getStrutsConfig <em>Struts Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Struts Config</em>' containment reference.
	 * @see #getStrutsConfig()
	 * @generated
	 */
	void setStrutsConfig(StrutsConfig value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsApplication_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.StrutsApplication#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Forms</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.struts.FormImpl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forms</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsApplication_Forms()
	 * @model containment="true"
	 * @generated
	 */
	EList<FormImpl> getForms();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.struts.ActionImpl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsApplication_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActionImpl> getActions();

} // StrutsApplication
