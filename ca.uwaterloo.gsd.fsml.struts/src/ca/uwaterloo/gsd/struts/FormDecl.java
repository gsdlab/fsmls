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
 * $Id: FormDecl.java,v 1.6 2008/03/20 04:01:54 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Form Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormDecl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormDecl#getFormType <em>Form Type</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormDecl#isIsDynaActionForm <em>Is Dyna Action Form</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormDecl#getFormProperty <em>Form Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormDecl()
 * @model
 * @generated
 */
public interface FormDecl extends Concept {
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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormDecl_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.FormDecl#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Form Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Form Type</em>' attribute.
	 * @see #setFormType(String)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormDecl_FormType()
	 * @model required="true"
	 *        annotation="xmlAttribute name='type'"
	 * @generated
	 */
	String getFormType();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.FormDecl#getFormType <em>Form Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Form Type</em>' attribute.
	 * @see #getFormType()
	 * @generated
	 */
	void setFormType(String value);

	/**
	 * Returns the value of the '<em><b>Is Dyna Action Form</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Dyna Action Form</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Dyna Action Form</em>' attribute.
	 * @see #setIsDynaActionForm(boolean)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormDecl_IsDynaActionForm()
	 * @model annotation="valueEqualsTo attribute='../formType' value='org.apache.struts.action.DynaActionForm'"
	 * @generated
	 */
	boolean isIsDynaActionForm();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.FormDecl#isIsDynaActionForm <em>Is Dyna Action Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Dyna Action Form</em>' attribute.
	 * @see #isIsDynaActionForm()
	 * @generated
	 */
	void setIsDynaActionForm(boolean value);

	/**
	 * Returns the value of the '<em><b>Form Property</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.struts.FormProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Form Property</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormDecl_FormProperty()
	 * @model containment="true"
	 *        annotation="xmlElements path='form-property'"
	 * @generated
	 */
	EList<FormProperty> getFormProperty();

} // FormDecl
