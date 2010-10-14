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
 * $Id: ImplementsIEditorPart.java,v 1.3 2008/05/05 15:34:34 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implements IEditor Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ImplementsIEditorPart#getExtendsEditorPart <em>Extends Editor Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getImplementsIEditorPart()
 * @model
 * @generated
 */
public interface ImplementsIEditorPart extends Concept {
	/**
	 * Returns the value of the '<em><b>Extends Editor Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Editor Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Editor Part</em>' containment reference.
	 * @see #setExtendsEditorPart(ExtendsEditorPart)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getImplementsIEditorPart_ExtendsEditorPart()
	 * @model containment="true"
	 *        annotation="extendsClass name='org.eclipse.ui.part.EditorPart'"
	 *        annotation="subsumedBy feature='extendsMultiPageEditorPart'"
	 * @generated
	 */
	ExtendsEditorPart getExtendsEditorPart();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.ImplementsIEditorPart#getExtendsEditorPart <em>Extends Editor Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Editor Part</em>' containment reference.
	 * @see #getExtendsEditorPart()
	 * @generated
	 */
	void setExtendsEditorPart(ExtendsEditorPart value);

} // ImplementsIEditorPart
