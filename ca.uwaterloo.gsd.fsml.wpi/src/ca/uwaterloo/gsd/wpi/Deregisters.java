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
 * $Id: Deregisters.java,v 1.3 2008/01/23 03:48:16 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deregisters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.Deregisters#getDeregistersSameObject <em>Deregisters Same Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregisters()
 * @model
 * @generated
 */
public interface Deregisters extends Concept {
	/**
	 * Returns the value of the '<em><b>Deregisters Same Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregisters Same Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregisters Same Object</em>' containment reference.
	 * @see #setDeregistersSameObject(DeregistersSameObject)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregisters_DeregistersSameObject()
	 * @model containment="true" required="true"
	 *        annotation="argument argument='1' ofMethodCall='../../' sameAsArg='1' ofCall='../'"
	 * @generated
	 */
	DeregistersSameObject getDeregistersSameObject();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.Deregisters#getDeregistersSameObject <em>Deregisters Same Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregisters Same Object</em>' containment reference.
	 * @see #getDeregistersSameObject()
	 * @generated
	 */
	void setDeregistersSameObject(DeregistersSameObject value);

} // Deregisters
