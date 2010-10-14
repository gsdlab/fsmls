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
 * $Id: Thread.java,v 1.16 2008/02/16 01:22:56 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.Thread#getThread <em>Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Thread#isTypedThread <em>Typed Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Thread#getInitializesThread <em>Initializes Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Thread#isNullifiesThread <em>Nullifies Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThread()
 * @model
 * @generated
 */
public interface Thread extends Concept {
	/**
	 * Returns the value of the '<em><b>Thread</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread</em>' attribute.
	 * @see #setThread(String)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThread_Thread()
	 * @model required="true"
	 * @generated
	 */
	String getThread();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Thread#getThread <em>Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread</em>' attribute.
	 * @see #getThread()
	 * @generated
	 */
	void setThread(String value);

	/**
	 * Returns the value of the '<em><b>Typed Thread</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Thread</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Thread</em>' attribute.
	 * @see #setTypedThread(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThread_TypedThread()
	 * @model default="true" required="true"
	 *        annotation="typedWith name='java.lang.Thread'"
	 * @generated
	 */
	boolean isTypedThread();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Thread#isTypedThread <em>Typed Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Thread</em>' attribute.
	 * @see #isTypedThread()
	 * @generated
	 */
	void setTypedThread(boolean value);

	/**
	 * Returns the value of the '<em><b>Initializes Thread</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializes Thread</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializes Thread</em>' containment reference.
	 * @see #setInitializesThread(InitializesThread)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThread_InitializesThread()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InitializesThread getInitializesThread();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Thread#getInitializesThread <em>Initializes Thread</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializes Thread</em>' containment reference.
	 * @see #getInitializesThread()
	 * @generated
	 */
	void setInitializesThread(InitializesThread value);

	/**
	 * Returns the value of the '<em><b>Nullifies Thread</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nullifies Thread</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nullifies Thread</em>' attribute.
	 * @see #setNullifiesThread(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThread_NullifiesThread()
	 * @model default="true" required="true"
	 *        annotation="assignedWithNull locationName='destroy' position='after'"
	 * @generated
	 */
	boolean isNullifiesThread();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Thread#isNullifiesThread <em>Nullifies Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nullifies Thread</em>' attribute.
	 * @see #isNullifiesThread()
	 * @generated
	 */
	void setNullifiesThread(boolean value);

} // Thread
