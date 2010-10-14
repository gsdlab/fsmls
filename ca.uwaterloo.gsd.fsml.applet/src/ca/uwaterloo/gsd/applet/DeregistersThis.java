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

package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deregisters This</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.DeregistersThis#isThis <em>This</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getDeregistersThis()
 * @model
 * @generated
 */
public interface DeregistersThis extends Concept {
	/**
	 * Returns the value of the '<em><b>This</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>This</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>This</em>' attribute.
	 * @see #setThis(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getDeregistersThis_This()
	 * @model default="true" required="true"
	 *        annotation="argumentIsThis index='1'"
	 * @generated
	 */
	boolean isThis();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.DeregistersThis#isThis <em>This</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>This</em>' attribute.
	 * @see #isThis()
	 * @generated
	 */
	void setThis(boolean value);

} // DeregistersThis
