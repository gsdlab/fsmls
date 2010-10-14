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
 * $Id: DeregistersSamePartId.java,v 1.3 2008/01/23 03:48:16 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deregisters Same Part Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId#getDeregistrationPartId <em>Deregistration Part Id</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId#getDeregistersSameObject <em>Deregisters Same Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistersSamePartId()
 * @model
 * @generated
 */
public interface DeregistersSamePartId extends Concept {
	/**
	 * Returns the value of the '<em><b>Deregistration Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregistration Part Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregistration Part Id</em>' attribute.
	 * @see #setDeregistrationPartId(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistersSamePartId_DeregistrationPartId()
	 * @model required="true"
	 *        annotation="argumentValue index='1'"
	 *        annotation="valueEqualsTo attribute='../../registrationPartId'"
	 * @generated
	 */
	String getDeregistrationPartId();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId#getDeregistrationPartId <em>Deregistration Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregistration Part Id</em>' attribute.
	 * @see #getDeregistrationPartId()
	 * @generated
	 */
	void setDeregistrationPartId(String value);

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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistersSamePartId_DeregistersSameObject()
	 * @model containment="true" required="true"
	 *        annotation="argument argument='2' ofMethodCall='../../' sameAsArg='2' ofCall='../'"
	 * @generated
	 */
	DeregistersSameObject getDeregistersSameObject();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId#getDeregistersSameObject <em>Deregisters Same Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregisters Same Object</em>' containment reference.
	 * @see #getDeregistersSameObject()
	 * @generated
	 */
	void setDeregistersSameObject(DeregistersSameObject value);

} // DeregistersSamePartId
