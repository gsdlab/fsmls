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
 * $Id: ThisSelectionProvider.java,v 1.1 2008/06/26 19:28:42 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This Selection Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ThisSelectionProvider#isImplementsISelectionProvider <em>Implements ISelection Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getThisSelectionProvider()
 * @model
 * @generated
 */
public interface ThisSelectionProvider extends Concept {
	/**
	 * Returns the value of the '<em><b>Implements ISelection Provider</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements ISelection Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements ISelection Provider</em>' attribute.
	 * @see #setImplementsISelectionProvider(boolean)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getThisSelectionProvider_ImplementsISelectionProvider()
	 * @model default="true" required="true"
	 *        annotation="implementsInterface name='org.eclipse.jface.viewers.ISelectionProvider'"
	 * @generated
	 */
	boolean isImplementsISelectionProvider();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.ThisSelectionProvider#isImplementsISelectionProvider <em>Implements ISelection Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements ISelection Provider</em>' attribute.
	 * @see #isImplementsISelectionProvider()
	 * @generated
	 */
	void setImplementsISelectionProvider(boolean value);

} // ThisSelectionProvider
