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
 * $Id: RegistersMouseMotionListener.java,v 1.1 2008/02/24 20:36:08 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registers Mouse Motion Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener#getThis <em>This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener#getMouseMotionListenerField <em>Mouse Motion Listener Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersMouseMotionListener()
 * @model annotation="featureGroup lowerBound='1' upperBound='1'"
 * @generated
 */
public interface RegistersMouseMotionListener extends Concept {
	/**
	 * Returns the value of the '<em><b>This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>This</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>This</em>' containment reference.
	 * @see #setThis(ThisMouseMotionListener)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersMouseMotionListener_This()
	 * @model containment="true"
	 *        annotation="argumentIsThis index='1'"
	 * @generated
	 */
	ThisMouseMotionListener getThis();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener#getThis <em>This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>This</em>' containment reference.
	 * @see #getThis()
	 * @generated
	 */
	void setThis(ThisMouseMotionListener value);

	/**
	 * Returns the value of the '<em><b>Mouse Motion Listener Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mouse Motion Listener Field</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mouse Motion Listener Field</em>' containment reference.
	 * @see #setMouseMotionListenerField(MouseMotionListenerField)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersMouseMotionListener_MouseMotionListenerField()
	 * @model containment="true"
	 *        annotation="argumentIsField index='1'"
	 * @generated
	 */
	MouseMotionListenerField getMouseMotionListenerField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener#getMouseMotionListenerField <em>Mouse Motion Listener Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mouse Motion Listener Field</em>' containment reference.
	 * @see #getMouseMotionListenerField()
	 * @generated
	 */
	void setMouseMotionListenerField(MouseMotionListenerField value);

} // RegistersMouseMotionListener
