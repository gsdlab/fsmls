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

package ca.uwaterloo.gsd.applet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initializes Thread</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThread#getInitializesThreadWithRunnable <em>Initializes Thread With Runnable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThread#getInitializesWithThreadSubclass <em>Initializes With Thread Subclass</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThread()
 * @model annotation="featureGroup lowerBound='1' upperBound='1' essential='true'"
 * @generated
 */
public interface InitializesThread extends EObject {
	/**
	 * Returns the value of the '<em><b>Initializes Thread With Runnable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializes Thread With Runnable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializes Thread With Runnable</em>' containment reference.
	 * @see #setInitializesThreadWithRunnable(InitializesThreadWith)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThread_InitializesThreadWithRunnable()
	 * @model containment="true"
	 *        annotation="assignedWithNew class='java.lang.Thread' signature='(Ljava.lang.Runnable;)V' locationName='init' position='after'"
	 * @generated
	 */
	InitializesThreadWith getInitializesThreadWithRunnable();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThread#getInitializesThreadWithRunnable <em>Initializes Thread With Runnable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializes Thread With Runnable</em>' containment reference.
	 * @see #getInitializesThreadWithRunnable()
	 * @generated
	 */
	void setInitializesThreadWithRunnable(InitializesThreadWith value);

	/**
	 * Returns the value of the '<em><b>Initializes With Thread Subclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializes With Thread Subclass</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializes With Thread Subclass</em>' containment reference.
	 * @see #setInitializesWithThreadSubclass(InitializesThreadSubclass)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThread_InitializesWithThreadSubclass()
	 * @model containment="true"
	 *        annotation="assignedWithNew subtypeOf='java.lang.Thread' initializer='true'"
	 * @generated
	 */
	InitializesThreadSubclass getInitializesWithThreadSubclass();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThread#getInitializesWithThreadSubclass <em>Initializes With Thread Subclass</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializes With Thread Subclass</em>' containment reference.
	 * @see #getInitializesWithThreadSubclass()
	 * @generated
	 */
	void setInitializesWithThreadSubclass(InitializesThreadSubclass value);

} // InitializesThread
