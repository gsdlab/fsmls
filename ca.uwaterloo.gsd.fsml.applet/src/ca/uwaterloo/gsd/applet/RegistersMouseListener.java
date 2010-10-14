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
 * $Id: RegistersMouseListener.java,v 1.4 2008/01/23 03:47:53 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registers Mouse Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.RegistersMouseListener#getThis <em>This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.RegistersMouseListener#getMouseListenerField <em>Mouse Listener Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersMouseListener()
 * @model annotation="featureGroup lowerBound='1' upperBound='1'"
 * @generated
 */
public interface RegistersMouseListener extends Concept {
	/**
	 * Returns the value of the '<em><b>This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>This</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>This</em>' containment reference.
	 * @see #setThis(ThisMouseListener)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersMouseListener_This()
	 * @model containment="true"
	 *        annotation="argumentIsThis index='1'"
	 * @generated
	 */
	ThisMouseListener getThis();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RegistersMouseListener#getThis <em>This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>This</em>' containment reference.
	 * @see #getThis()
	 * @generated
	 */
	void setThis(ThisMouseListener value);

	/**
	 * Returns the value of the '<em><b>Mouse Listener Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mouse Listener Field</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mouse Listener Field</em>' containment reference.
	 * @see #setMouseListenerField(MouseListenerField)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersMouseListener_MouseListenerField()
	 * @model containment="true"
	 *        annotation="argumentIsField index='1'"
	 * @generated
	 */
	MouseListenerField getMouseListenerField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RegistersMouseListener#getMouseListenerField <em>Mouse Listener Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mouse Listener Field</em>' containment reference.
	 * @see #getMouseListenerField()
	 * @generated
	 */
	void setMouseListenerField(MouseListenerField value);

} // RegistersMouseListener
