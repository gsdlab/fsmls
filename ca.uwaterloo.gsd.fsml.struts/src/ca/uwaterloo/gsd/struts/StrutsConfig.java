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
 * $Id: StrutsConfig.java,v 1.8 2007/12/06 03:28:19 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.StrutsConfig#getForms <em>Forms</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.StrutsConfig#getForwards <em>Forwards</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.StrutsConfig#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsConfig()
 * @model annotation="xmlDocument path='/WEB-INF/struts-config.xml'"
 *        annotation="xmlElement name='struts-config'"
 * @generated
 */
public interface StrutsConfig extends Concept {
	/**
	 * Returns the value of the '<em><b>Forms</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.struts.FormDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forms</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsConfig_Forms()
	 * @model containment="true"
	 *        annotation="xmlElements path='form-beans/form-bean'"
	 * @generated
	 */
	EList<FormDecl> getForms();

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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsConfig_Forwards()
	 * @model containment="true"
	 *        annotation="xmlElements path='global-forwards/forward'"
	 * @generated
	 */
	EList<ForwardDecl> getForwards();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.struts.ActionDecl}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getStrutsConfig_Actions()
	 * @model containment="true"
	 *        annotation="xmlElements path='action-mappings/action'"
	 * @generated
	 */
	EList<ActionDecl> getActions();

} // StrutsConfig
