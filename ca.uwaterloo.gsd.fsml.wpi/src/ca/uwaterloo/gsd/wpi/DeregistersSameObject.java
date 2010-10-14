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
 * $Id: DeregistersSameObject.java,v 1.4 2008/04/09 15:22:55 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deregisters Same Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.DeregistersSameObject#isRegistersBeforeDeregisters <em>Registers Before Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistersSameObject()
 * @model
 * @generated
 */
public interface DeregistersSameObject extends Concept {
	/**
	 * Returns the value of the '<em><b>Registers Before Deregisters</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers Before Deregisters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers Before Deregisters</em>' attribute.
	 * @see #setRegistersBeforeDeregisters(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistersSameObject_RegistersBeforeDeregisters()
	 * @model default="true" required="true"
	 *        annotation="methodCall call='../../../' before='../../' givenCallbackSeq='init createPartControl dispose'"
	 * @generated
	 */
	boolean isRegistersBeforeDeregisters();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.DeregistersSameObject#isRegistersBeforeDeregisters <em>Registers Before Deregisters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registers Before Deregisters</em>' attribute.
	 * @see #isRegistersBeforeDeregisters()
	 * @generated
	 */
	void setRegistersBeforeDeregisters(boolean value);

} // DeregistersSameObject
