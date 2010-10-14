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
 * $Id: ThisRunnable.java,v 1.2 2008/01/23 03:47:53 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>This Runnable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.ThisRunnable#isImplementsRunnable <em>Implements Runnable</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisRunnable()
 * @model
 * @generated
 */
public interface ThisRunnable extends Concept {
	/**
	 * Returns the value of the '<em><b>Implements Runnable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements Runnable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements Runnable</em>' attribute.
	 * @see #setImplementsRunnable(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getThisRunnable_ImplementsRunnable()
	 * @model default="true" required="true"
	 *        annotation="implementsInterface name='java.lang.Runnable'"
	 * @generated
	 */
	boolean isImplementsRunnable();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.ThisRunnable#isImplementsRunnable <em>Implements Runnable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements Runnable</em>' attribute.
	 * @see #isImplementsRunnable()
	 * @generated
	 */
	void setImplementsRunnable(boolean value);

} // ThisRunnable
