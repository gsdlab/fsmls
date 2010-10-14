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
 * $Id: Contributor.java,v 1.4 2007/04/13 01:00:09 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.Contributor#getContributor <em>Contributor</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.Contributor#getExtendsEditorActionBarContributor <em>Extends Editor Action Bar Contributor</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getContributor()
 * @model
 * @generated
 */
public interface Contributor extends Concept {
	/**
	 * Returns the value of the '<em><b>Contributor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributor</em>' attribute.
	 * @see #setContributor(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getContributor_Contributor()
	 * @model required="true"
	 * @generated
	 */
	String getContributor();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.Contributor#getContributor <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contributor</em>' attribute.
	 * @see #getContributor()
	 * @generated
	 */
	void setContributor(String value);

	/**
	 * Returns the value of the '<em><b>Extends Editor Action Bar Contributor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Editor Action Bar Contributor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Editor Action Bar Contributor</em>' containment reference.
	 * @see #setExtendsEditorActionBarContributor(ExtendsEditorActionBarContributor)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getContributor_ExtendsEditorActionBarContributor()
	 * @model containment="true" required="true"
	 *        annotation="extendsClass name='org.eclipse.ui.part.EditorActionBarContributor'"
	 * @generated
	 */
	ExtendsEditorActionBarContributor getExtendsEditorActionBarContributor();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.Contributor#getExtendsEditorActionBarContributor <em>Extends Editor Action Bar Contributor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Editor Action Bar Contributor</em>' containment reference.
	 * @see #getExtendsEditorActionBarContributor()
	 * @generated
	 */
	void setExtendsEditorActionBarContributor(ExtendsEditorActionBarContributor value);

} // Contributor
