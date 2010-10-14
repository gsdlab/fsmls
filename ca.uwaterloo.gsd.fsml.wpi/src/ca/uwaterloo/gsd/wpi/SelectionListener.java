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
 * $Id: SelectionListener.java,v 1.8 2008/01/23 03:48:17 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.SelectionListener#getListener <em>Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.SelectionListener#getRegistersAs <em>Registers As</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSelectionListener()
 * @model
 * @generated
 */
public interface SelectionListener extends Concept {
	/**
	 * Returns the value of the '<em><b>Listener</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Listener</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Listener</em>' reference.
	 * @see #setListener(Part)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSelectionListener_Listener()
	 * @model required="true"
	 * @generated
	 */
	Part getListener();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.SelectionListener#getListener <em>Listener</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listener</em>' reference.
	 * @see #getListener()
	 * @generated
	 */
	void setListener(Part value);

	/**
	 * Returns the value of the '<em><b>Registers As</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers As</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers As</em>' containment reference.
	 * @see #setRegistersAs(RegistersAs)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSelectionListener_RegistersAs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RegistersAs getRegistersAs();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.SelectionListener#getRegistersAs <em>Registers As</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registers As</em>' containment reference.
	 * @see #getRegistersAs()
	 * @generated
	 */
	void setRegistersAs(RegistersAs value);

} // SelectionListener
