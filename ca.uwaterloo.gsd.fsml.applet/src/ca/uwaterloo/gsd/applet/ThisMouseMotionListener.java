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
 * $Id: ThisMouseMotionListener.java,v 1.1 2008/02/24 20:36:08 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This Mouse Motion Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.ThisMouseMotionListener#isImplementsMouseMotionListener <em>Implements Mouse Motion Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.ThisMouseMotionListener#getDeregisters <em>Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisMouseMotionListener()
 * @model
 * @generated
 */
public interface ThisMouseMotionListener extends Concept {
	/**
	 * Returns the value of the '<em><b>Implements Mouse Motion Listener</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements Mouse Motion Listener</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements Mouse Motion Listener</em>' attribute.
	 * @see #setImplementsMouseMotionListener(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisMouseMotionListener_ImplementsMouseMotionListener()
	 * @model default="true" required="true"
	 *        annotation="implementsInterface name='java.awt.event.MouseMotionListener'"
	 * @generated
	 */
	boolean isImplementsMouseMotionListener();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.ThisMouseMotionListener#isImplementsMouseMotionListener <em>Implements Mouse Motion Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements Mouse Motion Listener</em>' attribute.
	 * @see #isImplementsMouseMotionListener()
	 * @generated
	 */
	void setImplementsMouseMotionListener(boolean value);

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
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisMouseMotionListener_Deregisters()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='java.awt.Component' name='removeMouseMotionListener' signature='(Ljava.awt.event.MouseMotionListener;)V' in='hierarchy' locationName='destroy'"
	 * @generated
	 */
	DeregistersThis getDeregisters();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.ThisMouseMotionListener#getDeregisters <em>Deregisters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregisters</em>' containment reference.
	 * @see #getDeregisters()
	 * @generated
	 */
	void setDeregisters(DeregistersThis value);

} // ThisMouseMotionListener
