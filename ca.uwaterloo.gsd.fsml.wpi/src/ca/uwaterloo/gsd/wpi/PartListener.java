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
 * $Id: PartListener.java,v 1.9 2008/01/23 03:48:16 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Part Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.PartListener#getListener <em>Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.PartListener#getRegistersAPartListener <em>Registers APart Listener</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getPartListener()
 * @model
 * @generated
 */
public interface PartListener extends Concept {
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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getPartListener_Listener()
	 * @model required="true"
	 * @generated
	 */
	Part getListener();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.PartListener#getListener <em>Listener</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listener</em>' reference.
	 * @see #getListener()
	 * @generated
	 */
	void setListener(Part value);

	/**
	 * Returns the value of the '<em><b>Registers APart Listener</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers APart Listener</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers APart Listener</em>' containment reference.
	 * @see #setRegistersAPartListener(RegistersAPartListener)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getPartListener_RegistersAPartListener()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RegistersAPartListener getRegistersAPartListener();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.PartListener#getRegistersAPartListener <em>Registers APart Listener</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registers APart Listener</em>' containment reference.
	 * @see #getRegistersAPartListener()
	 * @generated
	 */
	void setRegistersAPartListener(RegistersAPartListener value);

} // PartListener
