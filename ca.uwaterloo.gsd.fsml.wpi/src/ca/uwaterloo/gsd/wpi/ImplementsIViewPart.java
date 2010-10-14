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
 * $Id: ImplementsIViewPart.java,v 1.4 2008/04/10 19:07:30 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implements IView Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ImplementsIViewPart#getExtendsViewPart <em>Extends View Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getImplementsIViewPart()
 * @model
 * @generated
 */
public interface ImplementsIViewPart extends Concept {
	/**
	 * Returns the value of the '<em><b>Extends View Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends View Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends View Part</em>' containment reference.
	 * @see #setExtendsViewPart(ExtendsViewPart)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getImplementsIViewPart_ExtendsViewPart()
	 * @model containment="true"
	 *        annotation="extendsClass name='org.eclipse.ui.part.ViewPart'"
	 *        annotation="subsumedBy feature='extendsPageBookView'"
	 * @generated
	 */
	ExtendsViewPart getExtendsViewPart();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.ImplementsIViewPart#getExtendsViewPart <em>Extends View Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends View Part</em>' containment reference.
	 * @see #getExtendsViewPart()
	 * @generated
	 */
	void setExtendsViewPart(ExtendsViewPart value);

} // ImplementsIViewPart
