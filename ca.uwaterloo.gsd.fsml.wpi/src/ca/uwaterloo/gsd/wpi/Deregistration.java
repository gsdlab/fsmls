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
 * $Id: Deregistration.java,v 1.2 2007/05/25 17:12:56 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deregistration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.Deregistration#isRegistersBeforeDeregisters <em>Registers Before Deregisters</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.Deregistration#isDeregistersSameObject <em>Deregisters Same Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistration()
 * @model
 * @generated
 */
public interface Deregistration extends EObject {
	/**
	 * Returns the value of the '<em><b>Registers Before Deregisters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers Before Deregisters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers Before Deregisters</em>' attribute.
	 * @see #setRegistersBeforeDeregisters(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistration_RegistersBeforeDeregisters()
	 * @model required="true"
	 *        annotation="methodCall call='../../registersWithService' before='..' givenCallbackSeq='init createPartControl dispose'"
	 * @generated
	 */
	boolean isRegistersBeforeDeregisters();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.Deregistration#isRegistersBeforeDeregisters <em>Registers Before Deregisters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registers Before Deregisters</em>' attribute.
	 * @see #isRegistersBeforeDeregisters()
	 * @generated
	 */
	void setRegistersBeforeDeregisters(boolean value);

	/**
	 * Returns the value of the '<em><b>Deregisters Same Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregisters Same Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregisters Same Object</em>' attribute.
	 * @see #setDeregistersSameObject(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistration_DeregistersSameObject()
	 * @model required="true"
	 *        annotation="argument argument='1' ofMethodCall='../../registersWithService' sameAsArg='1' ofCall='..'"
	 * @generated
	 */
	boolean isDeregistersSameObject();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.Deregistration#isDeregistersSameObject <em>Deregisters Same Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregisters Same Object</em>' attribute.
	 * @see #isDeregistersSameObject()
	 * @generated
	 */
	void setDeregistersSameObject(boolean value);

} // Deregistration
