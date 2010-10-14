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
 * $Id: ActionDecl.java,v 1.9 2008/02/26 21:18:39 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionDecl#getPath <em>Path</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionDecl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionDecl#getType <em>Type</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionDecl#getActionImpl <em>Action Impl</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionDecl#getForwards <em>Forwards</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionDecl#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionDecl()
 * @model
 * @generated
 */
public interface ActionDecl extends Concept {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionDecl_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionDecl#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionDecl_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionDecl#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionDecl_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionDecl#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Action Impl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Impl</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Impl</em>' reference.
	 * @see #setActionImpl(ActionImpl)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionDecl_ActionImpl()
	 * @model required="true"
	 *        annotation="where attribute='qualifiedName' equalsTo='../type'"
	 * @generated
	 */
	ActionImpl getActionImpl();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionDecl#getActionImpl <em>Action Impl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Impl</em>' reference.
	 * @see #getActionImpl()
	 * @generated
	 */
	void setActionImpl(ActionImpl value);

	/**
	 * Returns the value of the '<em><b>Forwards</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.struts.ForwardDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forwards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forwards</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionDecl_Forwards()
	 * @model containment="true"
	 *        annotation="xmlElements path='forward'"
	 * @generated
	 */
	EList<ForwardDecl> getForwards();

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(String)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionDecl_Input()
	 * @model
	 * @generated
	 */
	String getInput();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionDecl#getInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(String value);

} // ActionDecl
