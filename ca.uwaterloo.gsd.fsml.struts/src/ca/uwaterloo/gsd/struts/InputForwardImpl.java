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
 * $Id: InputForwardImpl.java,v 1.1 2008/02/26 21:18:38 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Forward Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.InputForwardImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getInputForwardImpl()
 * @model
 * @generated
 */
public interface InputForwardImpl extends Concept {
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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getInputForwardImpl_Name()
	 * @model required="true"
	 *        annotation="valueOf attribute='input' class='ActionDecl'"
	 *        annotation="where attribute='type' equalsTo='../../qualifiedName'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.InputForwardImpl#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // InputForwardImpl
