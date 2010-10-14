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
 * $Id: ExtendsDispatchAction.java,v 1.11 2007/12/06 03:28:19 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extends Dispatch Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.ExtendsDispatchAction#getActionMethod <em>Action Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getExtendsDispatchAction()
 * @model
 * @generated
 */
public interface ExtendsDispatchAction extends Concept {
	/**
	 * Returns the value of the '<em><b>Action Method</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Method</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Method</em>' attribute list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getExtendsDispatchAction_ActionMethod()
	 * @model annotation="methods signature='(Lorg.apache.struts.action.ActionMapping;Lorg.apache.struts.action.ActionForm;Ljavax.servlet.http.HttpServletRequest;Ljavax.servlet.http.HttpServletResponse;)Lorg.apache.struts.action.ActionForward;' inherited='false'"
	 * @generated
	 */
	EList<String> getActionMethod();

} // ExtendsDispatchAction
