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
 * $Id: MouseMotionListenerField.java,v 1.1 2008/02/24 20:36:07 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mouse Motion Listener Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#getListenerField <em>Listener Field</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#isTypedMouseMotionListener <em>Typed Mouse Motion Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#getDeregisters <em>Deregisters</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#isInitialized <em>Initialized</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getMouseMotionListenerField()
 * @model
 * @generated
 */
public interface MouseMotionListenerField extends Concept {
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
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getMouseMotionListenerField_ListenerField()
	 * @model required="true"
	 * @generated
	 */
	String getListenerField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#getListenerField <em>Listener Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listener Field</em>' attribute.
	 * @see #getListenerField()
	 * @generated
	 */
	void setListenerField(String value);

	/**
	 * Returns the value of the '<em><b>Typed Mouse Motion Listener</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Mouse Motion Listener</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Mouse Motion Listener</em>' attribute.
	 * @see #setTypedMouseMotionListener(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getMouseMotionListenerField_TypedMouseMotionListener()
	 * @model default="true" required="true"
	 *        annotation="typedWith name='java.awt.event.MouseMotionListener'"
	 * @generated
	 */
	boolean isTypedMouseMotionListener();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#isTypedMouseMotionListener <em>Typed Mouse Motion Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Mouse Motion Listener</em>' attribute.
	 * @see #isTypedMouseMotionListener()
	 * @generated
	 */
	void setTypedMouseMotionListener(boolean value);

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
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getMouseMotionListenerField_Deregisters()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='java.awt.Component' name='removeMouseMotionListener' signature='(Ljava.awt.event.MouseMotionListener;)V' in='hierarchy' locationName='destroy'"
	 * @generated
	 */
	DeregistersField getDeregisters();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#getDeregisters <em>Deregisters</em>}' containment reference.
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
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getMouseMotionListenerField_Initialized()
	 * @model default="true" required="true"
	 *        annotation="assignedWithNew class='java.awt.event.MouseMotionListener' signature='()V' initializer='true'"
	 * @generated
	 */
	boolean isInitialized();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#isInitialized <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized</em>' attribute.
	 * @see #isInitialized()
	 * @generated
	 */
	void setInitialized(boolean value);

} // MouseMotionListenerField
