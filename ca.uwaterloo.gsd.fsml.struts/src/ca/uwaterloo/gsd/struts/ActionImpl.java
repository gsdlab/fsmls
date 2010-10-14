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
 * $Id: ActionImpl.java,v 1.11 2009/04/21 16:47:57 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionImpl#isLocal <em>Local</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionImpl#getExtendsAction <em>Extends Action</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionImpl#getForwards <em>Forwards</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ActionImpl#getInputForwards <em>Input Forwards</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionImpl()
 * @model
 * @generated
 */
public interface ActionImpl extends Concept {
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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionImpl_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionImpl#getName <em>Name</em>}' attribute.
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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionImpl_Package()
	 * @model
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionImpl#getPackage <em>Package</em>}' attribute.
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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionImpl_QualifiedName()
	 * @model default="" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getQualifiedName();

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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionImpl_Local()
	 * @model
	 * @generated
	 */
	boolean isLocal();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionImpl#isLocal <em>Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local</em>' attribute.
	 * @see #isLocal()
	 * @generated
	 */
	void setLocal(boolean value);

	/**
	 * Returns the value of the '<em><b>Extends Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Action</em>' containment reference.
	 * @see #setExtendsAction(ExtendsAction)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionImpl_ExtendsAction()
	 * @model containment="true" required="true"
	 *        annotation="extendsClass name='org.apache.struts.action.Action'"
	 * @generated
	 */
	ExtendsAction getExtendsAction();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ActionImpl#getExtendsAction <em>Extends Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Action</em>' containment reference.
	 * @see #getExtendsAction()
	 * @generated
	 */
	void setExtendsAction(ExtendsAction value);

	/**
	 * Returns the value of the '<em><b>Forwards</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.struts.ForwardImpl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forwards</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forwards</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionImpl_Forwards()
	 * @model containment="true"
	 *        annotation="methodCalls class='org.apache.struts.action.ActionMapping' name='findForward' signature='(Ljava.lang.String;)Lorg.apache.struts.ActionForward;' in='class' locationName='execute' locationSig='(Lorg.apache.struts.action.ActionMapping;Lorg.apache.struts.action.ActionForm;Ljavax.servlet.http.HttpServletRequest;Ljavax.servlet.http.HttpServletResponse;)Lorg.apache.struts.action.ActionForward;|Ljava.lang.Exception;' position='after'"
	 * @generated
	 */
	EList<ForwardImpl> getForwards();

	/**
	 * Returns the value of the '<em><b>Input Forwards</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.struts.InputForwardImpl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Forwards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Forwards</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getActionImpl_InputForwards()
	 * @model containment="true"
	 *        annotation="methodCalls class='org.apache.struts.action.ActionMapping' name='getInputForward' signature='()Lorg.apache.struts.ActionForward;' in='class'"
	 * @generated
	 */
	EList<InputForwardImpl> getInputForwards();

} // ActionImpl
