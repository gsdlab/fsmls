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
 * $Id: RunnableField.java,v 1.3 2008/01/23 03:47:53 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runnable Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.RunnableField#isTypedRunnable <em>Typed Runnable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.RunnableField#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.RunnableField#isInitialized <em>Initialized</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRunnableField()
 * @model
 * @generated
 */
public interface RunnableField extends Concept {
	/**
	 * Returns the value of the '<em><b>Typed Runnable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed Runnable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed Runnable</em>' attribute.
	 * @see #setTypedRunnable(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRunnableField_TypedRunnable()
	 * @model default="true" required="true"
	 *        annotation="typedWith name='java.lang.Runnable'"
	 * @generated
	 */
	boolean isTypedRunnable();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RunnableField#isTypedRunnable <em>Typed Runnable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed Runnable</em>' attribute.
	 * @see #isTypedRunnable()
	 * @generated
	 */
	void setTypedRunnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRunnableField_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RunnableField#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getRunnableField_Initialized()
	 * @model default="true" required="true"
	 *        annotation="assignedWithNew class='java.lang.Runnable' signature='()V' initializer='true'"
	 * @generated
	 */
	boolean isInitialized();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.RunnableField#isInitialized <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized</em>' attribute.
	 * @see #isInitialized()
	 * @generated
	 */
	void setInitialized(boolean value);

} // RunnableField
