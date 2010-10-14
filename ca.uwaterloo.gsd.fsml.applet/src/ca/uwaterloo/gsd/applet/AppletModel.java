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

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;
import ca.uwaterloo.gsd.fsml.fsml.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.AppletModel#getApplets <em>Applets</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getAppletModel()
 * @model
 * @generated
 */
public interface AppletModel extends Concept, Model {
	/**
	 * Returns the value of the '<em><b>Applets</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.applet.Applet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applets</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getAppletModel_Applets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Applet> getApplets();

} // AppletModel
