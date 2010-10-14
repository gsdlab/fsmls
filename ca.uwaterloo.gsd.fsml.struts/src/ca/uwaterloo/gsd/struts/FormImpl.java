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
 * $Id: FormImpl.java,v 1.7 2007/03/23 16:38:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;


import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Form Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormImpl#isLocal <em>Local</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.FormImpl#getExtendsActionForm <em>Extends Action Form</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormImpl()
 * @model
 * @generated
 */
public interface FormImpl extends Concept {
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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormImpl_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.FormImpl#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormImpl_Package()
	 * @model
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.FormImpl#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormImpl_QualifiedName()
	 * @model default="" required="true" derived="true"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.FormImpl#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local</em>' attribute.
	 * @see #setLocal(boolean)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormImpl_Local()
	 * @model
	 * @generated
	 */
	boolean isLocal();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.FormImpl#isLocal <em>Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local</em>' attribute.
	 * @see #isLocal()
	 * @generated
	 */
	void setLocal(boolean value);

	/**
	 * Returns the value of the '<em><b>Extends Action Form</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Action Form</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Action Form</em>' containment reference.
	 * @see #setExtendsActionForm(ExtendsActionForm)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getFormImpl_ExtendsActionForm()
	 * @model containment="true" required="true"
	 *        annotation="extendsClass name='org.apache.struts.action.ActionForm'"
	 * @generated
	 */
	ExtendsActionForm getExtendsActionForm();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.FormImpl#getExtendsActionForm <em>Extends Action Form</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Action Form</em>' containment reference.
	 * @see #getExtendsActionForm()
	 * @generated
	 */
	void setExtendsActionForm(ExtendsActionForm value);

} // FormImpl
