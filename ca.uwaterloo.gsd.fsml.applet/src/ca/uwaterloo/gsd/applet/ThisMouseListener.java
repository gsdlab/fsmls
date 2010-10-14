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
 * $Id: ThisMouseListener.java,v 1.4 2008/01/23 03:47:53 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This Mouse Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.ThisMouseListener#isImplementsMouseListener <em>Implements Mouse Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.ThisMouseListener#getDeregisters <em>Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisMouseListener()
 * @model
 * @generated
 */
public interface ThisMouseListener extends Concept {
	/**
	 * Returns the value of the '<em><b>Implements Mouse Listener</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements Mouse Listener</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements Mouse Listener</em>' attribute.
	 * @see #setImplementsMouseListener(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisMouseListener_ImplementsMouseListener()
	 * @model default="true" required="true"
	 *        annotation="implementsInterface name='java.awt.event.MouseListener'"
	 * @generated
	 */
	boolean isImplementsMouseListener();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.ThisMouseListener#isImplementsMouseListener <em>Implements Mouse Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements Mouse Listener</em>' attribute.
	 * @see #isImplementsMouseListener()
	 * @generated
	 */
	void setImplementsMouseListener(boolean value);

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
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisMouseListener_Deregisters()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='java.awt.Component' name='removeMouseListener' signature='(Ljava.awt.event.MouseListener;)V' in='hierarchy' locationName='destroy'"
	 * @generated
	 */
	DeregistersThis getDeregisters();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.ThisMouseListener#getDeregisters <em>Deregisters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregisters</em>' containment reference.
	 * @see #getDeregisters()
	 * @generated
	 */
	void setDeregisters(DeregistersThis value);

} // ThisMouseListener
