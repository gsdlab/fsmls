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
 * $Id: ExtendsViewPart.java,v 1.2 2007/03/06 03:26:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extends View Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ExtendsViewPart#isExtendsPageBookView <em>Extends Page Book View</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getExtendsViewPart()
 * @model
 * @generated
 */
public interface ExtendsViewPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Extends Page Book View</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Page Book View</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Page Book View</em>' attribute.
	 * @see #setExtendsPageBookView(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getExtendsViewPart_ExtendsPageBookView()
	 * @model default="false"
	 *        annotation="extendsClass name='org.eclipse.ui.part.PageBookView'"
	 * @generated
	 */
	boolean isExtendsPageBookView();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.ExtendsViewPart#isExtendsPageBookView <em>Extends Page Book View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Page Book View</em>' attribute.
	 * @see #isExtendsPageBookView()
	 * @generated
	 */
	void setExtendsPageBookView(boolean value);

} // ExtendsViewPart
