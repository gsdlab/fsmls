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
 * $Id: ExtendsEditorPart.java,v 1.2 2007/03/06 03:26:17 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extends Editor Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ExtendsEditorPart#isExtendsMultiPageEditorPart <em>Extends Multi Page Editor Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getExtendsEditorPart()
 * @model
 * @generated
 */
public interface ExtendsEditorPart extends Concept {
	/**
	 * Returns the value of the '<em><b>Extends Multi Page Editor Part</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Multi Page Editor Part</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Multi Page Editor Part</em>' attribute.
	 * @see #setExtendsMultiPageEditorPart(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getExtendsEditorPart_ExtendsMultiPageEditorPart()
	 * @model default="false"
	 *        annotation="extendsClass name='org.eclipse.ui.part.MultiPageEditorPart'"
	 * @generated
	 */
	boolean isExtendsMultiPageEditorPart();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.ExtendsEditorPart#isExtendsMultiPageEditorPart <em>Extends Multi Page Editor Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Multi Page Editor Part</em>' attribute.
	 * @see #isExtendsMultiPageEditorPart()
	 * @generated
	 */
	void setExtendsMultiPageEditorPart(boolean value);

} // ExtendsEditorPart
