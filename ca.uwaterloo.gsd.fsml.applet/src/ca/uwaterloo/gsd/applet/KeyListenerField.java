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
 * $Id: KeyListenerField.java,v 1.1 2008/02/24 20:36:08 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Listener Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.KeyListenerField#getListenerField <em>Listener Field</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.KeyListenerField#isTypedKeyListener <em>Typed Key Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.KeyListenerField#getDeregisters <em>Deregisters</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.KeyListenerField#isInitialized <em>Initialized</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getKeyListenerField()
 * @model
 * @generated
 */
public interface KeyListenerField extends Concept {
	/**
	 * Returns the value of the '<em><b>Listener Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Listener Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Listener Field</em>' attribute.
	 * @see #setListenerField(String)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getKeyListenerField_ListenerField()
	 * @model required="true"
	 * @generated
	 */
	String getListenerField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.KeyListenerField#getListenerField <em>Listener Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listener Field</em>' attribute.
	 * @see #getListenerField()
	 * @generated
	 */
	void setListenerField(String value);

	/**
	 * Returns the value of the '<em><b>Typed Key Listener</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Key Listener</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Key Listener</em>' attribute.
	 * @see #setTypedKeyListener(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getKeyListenerField_TypedKeyListener()
	 * @model default="true" required="true"
	 *        annotation="typedWith name='java.awt.event.KeyListener'"
	 * @generated
	 */
	boolean isTypedKeyListener();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.KeyListenerField#isTypedKeyListener <em>Typed Key Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Key Listener</em>' attribute.
	 * @see #isTypedKeyListener()
	 * @generated
	 */
	void setTypedKeyListener(boolean value);

	/**
	 * Returns the value of the '<em><b>Deregisters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregisters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregisters</em>' containment reference.
	 * @see #setDeregisters(DeregistersField)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getKeyListenerField_Deregisters()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='java.awt.Component' name='removeKeyListener' signature='(Ljava.awt.event.KeyListener;)V' in='hierarchy' locationName='destroy'"
	 * @generated
	 */
	DeregistersField getDeregisters();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.KeyListenerField#getDeregisters <em>Deregisters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregisters</em>' containment reference.
	 * @see #getDeregisters()
	 * @generated
	 */
	void setDeregisters(DeregistersField value);

	/**
	 * Returns the value of the '<em><b>Initialized</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized</em>' attribute.
	 * @see #setInitialized(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getKeyListenerField_Initialized()
	 * @model default="true" required="true"
	 *        annotation="assignedWithNew class='java.awt.event.KeyListener' signature='()V' initializer='true'"
	 * @generated
	 */
	boolean isInitialized();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.KeyListenerField#isInitialized <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized</em>' attribute.
	 * @see #isInitialized()
	 * @generated
	 */
	void setInitialized(boolean value);

} // KeyListenerField
