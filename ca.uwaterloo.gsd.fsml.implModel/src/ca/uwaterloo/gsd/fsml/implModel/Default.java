/*******************************************************************************
 * Copyright (c) 2010 Herman Lee.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Herman Lee - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.implModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.Default#isOverridden <em>Overridden</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.Default#getEClass <em>EClass</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.Default#getEStructuralFeature <em>EStructural Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage#getDefault()
 * @model abstract="true"
 * @generated
 */
public interface Default extends EObject {
	/**
	 * Returns the value of the '<em><b>Overridden</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridden</em>' attribute.
	 * @see #setOverridden(boolean)
	 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage#getDefault_Overridden()
	 * @model default="" unique="false" required="true"
	 * @generated
	 */
	boolean isOverridden();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.implModel.Default#isOverridden <em>Overridden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overridden</em>' attribute.
	 * @see #isOverridden()
	 * @generated
	 */
	void setOverridden(boolean value);

	/**
	 * Returns the value of the '<em><b>EClass</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass</em>' attribute.
	 * @see #setEClass(String)
	 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage#getDefault_EClass()
	 * @model default="" required="true"
	 * @generated
	 */
	String getEClass();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.implModel.Default#getEClass <em>EClass</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass</em>' attribute.
	 * @see #getEClass()
	 * @generated
	 */
	void setEClass(String value);

	/**
	 * Returns the value of the '<em><b>EStructural Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EStructural Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EStructural Feature</em>' attribute.
	 * @see #setEStructuralFeature(String)
	 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage#getDefault_EStructuralFeature()
	 * @model required="true"
	 * @generated
	 */
	String getEStructuralFeature();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.implModel.Default#getEStructuralFeature <em>EStructural Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EStructural Feature</em>' attribute.
	 * @see #getEStructuralFeature()
	 * @generated
	 */
	void setEStructuralFeature(String value);

} // Default
