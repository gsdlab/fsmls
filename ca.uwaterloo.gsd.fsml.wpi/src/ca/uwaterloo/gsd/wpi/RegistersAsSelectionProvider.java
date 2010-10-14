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
 * $Id: RegistersAsSelectionProvider.java,v 1.9 2008/06/29 01:02:42 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registers As Selection Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersThis <em>Registers This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#isRegistersHelper <em>Registers Helper</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersVariable <em>Registers Variable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersField <em>Registers Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAsSelectionProvider()
 * @model annotation="featureGroup lowerBound='1' upperBound='1'"
 * @generated
 */
public interface RegistersAsSelectionProvider extends Concept {
	/**
	 * Returns the value of the '<em><b>Registers This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers This</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers This</em>' containment reference.
	 * @see #setRegistersThis(ThisSelectionProvider)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAsSelectionProvider_RegistersThis()
	 * @model containment="true"
	 *        annotation="argumentIsThis index='1'"
	 * @generated
	 */
	ThisSelectionProvider getRegistersThis();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersThis <em>Registers This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registers This</em>' containment reference.
	 * @see #getRegistersThis()
	 * @generated
	 */
	void setRegistersThis(ThisSelectionProvider value);

	/**
	 * Returns the value of the '<em><b>Registers Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers Field</em>' containment reference.
	 * @see #setRegistersField(FieldSelectionProvider)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAsSelectionProvider_RegistersField()
	 * @model containment="true"
	 *        annotation="argumentIsField index='1'"
	 * @generated
	 */
	FieldSelectionProvider getRegistersField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersField <em>Registers Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registers Field</em>' containment reference.
	 * @see #getRegistersField()
	 * @generated
	 */
	void setRegistersField(FieldSelectionProvider value);

	/**
	 * Returns the value of the '<em><b>Registers Helper</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers Helper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers Helper</em>' attribute.
	 * @see #setRegistersHelper(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAsSelectionProvider_RegistersHelper()
	 * @model default="false"
	 *        annotation="argumentIsNew index='1' class='org.eclipse.jface.viewers.ISelectionProvider' signature='()V'"
	 * @generated
	 */
	boolean isRegistersHelper();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#isRegistersHelper <em>Registers Helper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registers Helper</em>' attribute.
	 * @see #isRegistersHelper()
	 * @generated
	 */
	void setRegistersHelper(boolean value);

	/**
	 * Returns the value of the '<em><b>Registers Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers Variable</em>' attribute.
	 * @see #setRegistersVariable(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAsSelectionProvider_RegistersVariable()
	 * @model annotation="argumentIsVariable index='1' class='org.eclipse.jface.viewers.ISelectionProvider' signature='()V'"
	 * @generated
	 */
	String getRegistersVariable();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersVariable <em>Registers Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registers Variable</em>' attribute.
	 * @see #getRegistersVariable()
	 * @generated
	 */
	void setRegistersVariable(String value);

} // RegistersAsSelectionProvider
