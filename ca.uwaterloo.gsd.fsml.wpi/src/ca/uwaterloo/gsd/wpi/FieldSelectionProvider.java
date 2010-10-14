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
 * $Id: FieldSelectionProvider.java,v 1.1 2008/06/26 19:28:43 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Selection Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#getField <em>Field</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#isTypedISelectionProvider <em>Typed ISelection Provider</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#isInitialized <em>Initialized</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getFieldSelectionProvider()
 * @model
 * @generated
 */
public interface FieldSelectionProvider extends Concept {
	/**
	 * Returns the value of the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' attribute.
	 * @see #setField(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getFieldSelectionProvider_Field()
	 * @model required="true"
	 * @generated
	 */
	String getField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#getField <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' attribute.
	 * @see #getField()
	 * @generated
	 */
	void setField(String value);

	/**
	 * Returns the value of the '<em><b>Typed ISelection Provider</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typed ISelection Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typed ISelection Provider</em>' attribute.
	 * @see #setTypedISelectionProvider(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getFieldSelectionProvider_TypedISelectionProvider()
	 * @model default="true" required="true"
	 *        annotation="typedWith name='org.eclipse.jface.viewers.ISelectionProvider'"
	 * @generated
	 */
	boolean isTypedISelectionProvider();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#isTypedISelectionProvider <em>Typed ISelection Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Typed ISelection Provider</em>' attribute.
	 * @see #isTypedISelectionProvider()
	 * @generated
	 */
	void setTypedISelectionProvider(boolean value);

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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getFieldSelectionProvider_Initialized()
	 * @model default="true" required="true"
	 *        annotation="assignedWithNew class='org.eclipse.jface.viewers.ISelectionProvider' signature='()V' initializer='true'"
	 * @generated
	 */
	boolean isInitialized();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#isInitialized <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized</em>' attribute.
	 * @see #isInitialized()
	 * @generated
	 */
	void setInitialized(boolean value);

} // FieldSelectionProvider
