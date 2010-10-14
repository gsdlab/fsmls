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
 * $Id: InitializesThreadWith.java,v 1.6 2008/01/23 03:47:53 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initializes Thread With</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getThis <em>This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#isHelper <em>Helper</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getVariable <em>Variable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getRunnableField <em>Runnable Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadWith()
 * @model annotation="featureGroup lowerBound='1' upperBound='1'"
 * @generated
 */
public interface InitializesThreadWith extends Concept {
	/**
	 * Returns the value of the '<em><b>This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>This</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>This</em>' containment reference.
	 * @see #setThis(ThisRunnable)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadWith_This()
	 * @model containment="true"
	 *        annotation="argumentIsThis index='1'"
	 * @generated
	 */
	ThisRunnable getThis();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getThis <em>This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>This</em>' containment reference.
	 * @see #getThis()
	 * @generated
	 */
	void setThis(ThisRunnable value);

	/**
	 * Returns the value of the '<em><b>Helper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper</em>' attribute.
	 * @see #setHelper(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadWith_Helper()
	 * @model annotation="argumentIsNew index='1' class='java.lang.Runnable' signature='()V'"
	 * @generated
	 */
	boolean isHelper();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#isHelper <em>Helper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Helper</em>' attribute.
	 * @see #isHelper()
	 * @generated
	 */
	void setHelper(boolean value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadWith_Variable()
	 * @model annotation="argumentIsVariable index='1' class='java.lang.Runnable' signature='()V'"
	 * @generated
	 */
	String getVariable();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(String value);

	/**
	 * Returns the value of the '<em><b>Runnable Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runnable Field</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runnable Field</em>' containment reference.
	 * @see #setRunnableField(RunnableField)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadWith_RunnableField()
	 * @model containment="true"
	 *        annotation="argumentIsField index='1'"
	 * @generated
	 */
	RunnableField getRunnableField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getRunnableField <em>Runnable Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runnable Field</em>' containment reference.
	 * @see #getRunnableField()
	 * @generated
	 */
	void setRunnableField(RunnableField value);

} // InitializesThreadWith
