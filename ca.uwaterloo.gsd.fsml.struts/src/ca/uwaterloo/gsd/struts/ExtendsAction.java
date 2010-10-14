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
 * $Id: ExtendsAction.java,v 1.8 2007/03/23 16:38:17 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extends Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.ExtendsAction#getExtendsDispatchAction <em>Extends Dispatch Action</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.ExtendsAction#isOverridesExecute <em>Overrides Execute</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getExtendsAction()
 * @model
 * @generated
 */
public interface ExtendsAction extends Concept {
	/**
	 * Returns the value of the '<em><b>Extends Dispatch Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Dispatch Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Dispatch Action</em>' containment reference.
	 * @see #setExtendsDispatchAction(ExtendsDispatchAction)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getExtendsAction_ExtendsDispatchAction()
	 * @model containment="true"
	 *        annotation="extendsClass name='org.apache.struts.actions.DispatchAction'"
	 * @generated
	 */
	ExtendsDispatchAction getExtendsDispatchAction();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ExtendsAction#getExtendsDispatchAction <em>Extends Dispatch Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Dispatch Action</em>' containment reference.
	 * @see #getExtendsDispatchAction()
	 * @generated
	 */
	void setExtendsDispatchAction(ExtendsDispatchAction value);

	/**
	 * Returns the value of the '<em><b>Overrides Execute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overrides Execute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrides Execute</em>' attribute.
	 * @see #setOverridesExecute(boolean)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getExtendsAction_OverridesExecute()
	 * @model annotation="methods name='execute' signature='(Lorg.apache.struts.action.ActionMapping;Lorg.apache.struts.action.ActionForm;Ljavax.servlet.http.HttpServletRequest;Ljavax.servlet.http.HttpServletResponse;)Lorg.apache.struts.action.ActionForward;' inherited='false'"
	 * @generated
	 */
	boolean isOverridesExecute();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ExtendsAction#isOverridesExecute <em>Overrides Execute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overrides Execute</em>' attribute.
	 * @see #isOverridesExecute()
	 * @generated
	 */
	void setOverridesExecute(boolean value);

} // ExtendsAction
