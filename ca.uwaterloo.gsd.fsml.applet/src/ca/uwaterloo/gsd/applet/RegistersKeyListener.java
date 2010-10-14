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
 * $Id: RegistersKeyListener.java,v 1.1 2008/02/24 20:36:07 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registers Key Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.RegistersKeyListener#getThis <em>This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.RegistersKeyListener#getKeyListenerField <em>Key Listener Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersKeyListener()
 * @model annotation="featureGroup lowerBound='1' upperBound='1'"
 * @generated
 */
public interface RegistersKeyListener extends Concept {
	/**
	 * Returns the value of the '<em><b>This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>This</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>This</em>' containment reference.
	 * @see #setThis(ThisKeyListener)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersKeyListener_This()
	 * @model containment="true"
	 *        annotation="argumentIsThis index='1'"
	 * @generated
	 */
	ThisKeyListener getThis();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RegistersKeyListener#getThis <em>This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>This</em>' containment reference.
	 * @see #getThis()
	 * @generated
	 */
	void setThis(ThisKeyListener value);

	/**
	 * Returns the value of the '<em><b>Key Listener Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Listener Field</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Listener Field</em>' containment reference.
	 * @see #setKeyListenerField(KeyListenerField)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRegistersKeyListener_KeyListenerField()
	 * @model containment="true"
	 *        annotation="argumentIsField index='1'"
	 * @generated
	 */
	KeyListenerField getKeyListenerField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RegistersKeyListener#getKeyListenerField <em>Key Listener Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Listener Field</em>' containment reference.
	 * @see #getKeyListenerField()
	 * @generated
	 */
	void setKeyListenerField(KeyListenerField value);

} // RegistersKeyListener
