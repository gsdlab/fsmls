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
 * A representation of the model object '<em><b>Initializes Thread Subclass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#isOverriddesRun <em>Overriddes Run</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#isExtendsThread <em>Extends Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadSubclass()
 * @model
 * @generated
 */
public interface InitializesThreadSubclass extends EObject {
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
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadSubclass_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Overriddes Run</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overriddes Run</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overriddes Run</em>' attribute.
	 * @see #setOverriddesRun(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadSubclass_OverriddesRun()
	 * @model default="true" required="true"
	 *        annotation="methods name='run' signature='()V' inherited='false'"
	 * @generated
	 */
	boolean isOverriddesRun();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#isOverriddesRun <em>Overriddes Run</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overriddes Run</em>' attribute.
	 * @see #isOverriddesRun()
	 * @generated
	 */
	void setOverriddesRun(boolean value);

	/**
	 * Returns the value of the '<em><b>Extends Thread</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Thread</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Thread</em>' attribute.
	 * @see #setExtendsThread(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getInitializesThreadSubclass_ExtendsThread()
	 * @model default="true" required="true"
	 *        annotation="extendsClass name='java.lang.Thread'"
	 * @generated
	 */
	boolean isExtendsThread();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#isExtendsThread <em>Extends Thread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Thread</em>' attribute.
	 * @see #isExtendsThread()
	 * @generated
	 */
	void setExtendsThread(boolean value);

} // InitializesThreadSubclass
