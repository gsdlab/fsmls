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
 * $Id: ExtendsEditorActionBarContributor.java,v 1.2 2007/03/06 03:26:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extends Editor Action Bar Contributor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor#isExtendsMultiPageEditorActionBarContributor <em>Extends Multi Page Editor Action Bar Contributor</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getExtendsEditorActionBarContributor()
 * @model
 * @generated
 */
public interface ExtendsEditorActionBarContributor extends Concept {
	/**
	 * Returns the value of the '<em><b>Extends Multi Page Editor Action Bar Contributor</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Multi Page Editor Action Bar Contributor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Multi Page Editor Action Bar Contributor</em>' attribute.
	 * @see #setExtendsMultiPageEditorActionBarContributor(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getExtendsEditorActionBarContributor_ExtendsMultiPageEditorActionBarContributor()
	 * @model default="false"
	 *        annotation="extendsClass name='org.eclipse.ui.part.MultiPageEditorActionBarContributor'"
	 * @generated
	 */
	boolean isExtendsMultiPageEditorActionBarContributor();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor#isExtendsMultiPageEditorActionBarContributor <em>Extends Multi Page Editor Action Bar Contributor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Multi Page Editor Action Bar Contributor</em>' attribute.
	 * @see #isExtendsMultiPageEditorActionBarContributor()
	 * @generated
	 */
	void setExtendsMultiPageEditorActionBarContributor(boolean value);

} // ExtendsEditorActionBarContributor
