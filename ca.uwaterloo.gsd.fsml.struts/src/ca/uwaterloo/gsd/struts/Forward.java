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
 * $Id: Forward.java,v 1.4 2009/04/21 16:47:57 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forward</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.Forward#getLocalForward <em>Local Forward</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.Forward#getGlobalForward <em>Global Forward</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getForward()
 * @model annotation="featureGroup lowerBound='1' upperBound='2'"
 * @generated
 */
public interface Forward extends Concept {
	/**
	 * Returns the value of the '<em><b>Local Forward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Forward</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Forward</em>' reference.
	 * @see #setLocalForward(ForwardDecl)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getForward_LocalForward()
	 * @model annotation="where attribute='name' equalsTo='../../name'"
	 *        annotation="and attribute='../../type' equalsTo='../../../qualifiedName'"
	 * @generated
	 */
	ForwardDecl getLocalForward();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.Forward#getLocalForward <em>Local Forward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Forward</em>' reference.
	 * @see #getLocalForward()
	 * @generated
	 */
	void setLocalForward(ForwardDecl value);

	/**
	 * Returns the value of the '<em><b>Global Forward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Forward</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Forward</em>' reference.
	 * @see #setGlobalForward(ForwardDecl)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getForward_GlobalForward()
	 * @model annotation="where attribute='name' equalsTo='../../name'"
	 *        annotation="andParentIs instanceOf='StrutsConfig'"
	 * @generated
	 */
	ForwardDecl getGlobalForward();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.Forward#getGlobalForward <em>Global Forward</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Forward</em>' reference.
	 * @see #getGlobalForward()
	 * @generated
	 */
	void setGlobalForward(ForwardDecl value);

} // Forward
