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
 * $Id: ThisKeyListener.java,v 1.1 2008/02/24 20:36:08 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This Key Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.ThisKeyListener#isImplementsKeyListener <em>Implements Key Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.ThisKeyListener#getDeregisters <em>Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisKeyListener()
 * @model
 * @generated
 */
public interface ThisKeyListener extends Concept {
	/**
	 * Returns the value of the '<em><b>Implements Key Listener</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements Key Listener</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements Key Listener</em>' attribute.
	 * @see #setImplementsKeyListener(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisKeyListener_ImplementsKeyListener()
	 * @model default="true" required="true"
	 *        annotation="implementsInterface name='java.awt.event.KeyListener'"
	 * @generated
	 */
	boolean isImplementsKeyListener();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.ThisKeyListener#isImplementsKeyListener <em>Implements Key Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements Key Listener</em>' attribute.
	 * @see #isImplementsKeyListener()
	 * @generated
	 */
	void setImplementsKeyListener(boolean value);

	/**
	 * Returns the value of the '<em><b>Deregisters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregisters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregisters</em>' containment reference.
	 * @see #setDeregisters(DeregistersThis)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisKeyListener_Deregisters()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='java.awt.Component' name='removeKeyListener' signature='(Ljava.awt.event.KeyListener;)V' in='hierarchy' locationName='destroy'"
	 * @generated
	 */
	DeregistersThis getDeregisters();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.ThisKeyListener#getDeregisters <em>Deregisters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregisters</em>' containment reference.
	 * @see #getDeregisters()
	 * @generated
	 */
	void setDeregisters(DeregistersThis value);

} // ThisKeyListener
