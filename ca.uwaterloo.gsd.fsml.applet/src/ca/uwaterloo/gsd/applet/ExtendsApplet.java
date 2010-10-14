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
 * A representation of the model object '<em><b>Extends Applet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.ExtendsApplet#isExtendsJApplet <em>Extends JApplet</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getExtendsApplet()
 * @model
 * @generated
 */
public interface ExtendsApplet extends Concept {
	/**
	 * Returns the value of the '<em><b>Extends JApplet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends JApplet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends JApplet</em>' attribute.
	 * @see #setExtendsJApplet(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getExtendsApplet_ExtendsJApplet()
	 * @model annotation="extendsClass name='javax.swing.JApplet'"
	 * @generated
	 */
	boolean isExtendsJApplet();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.ExtendsApplet#isExtendsJApplet <em>Extends JApplet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends JApplet</em>' attribute.
	 * @see #isExtendsJApplet()
	 * @generated
	 */
	void setExtendsJApplet(boolean value);

} // ExtendsApplet
