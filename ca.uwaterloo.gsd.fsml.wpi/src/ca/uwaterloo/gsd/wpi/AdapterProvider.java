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
 * $Id: AdapterProvider.java,v 1.6 2008/01/23 03:48:16 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import ca.uwaterloo.gsd.fsml.fsml.Concept;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adapter Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.AdapterProvider#getAdapterProvider <em>Adapter Provider</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.AdapterProvider#getProvidesAdapter <em>Provides Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getAdapterProvider()
 * @model
 * @generated
 */
public interface AdapterProvider extends Concept {
	/**
	 * Returns the value of the '<em><b>Adapter Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter Provider</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter Provider</em>' reference.
	 * @see #setAdapterProvider(Part)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getAdapterProvider_AdapterProvider()
	 * @model required="true"
	 * @generated
	 */
	Part getAdapterProvider();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.AdapterProvider#getAdapterProvider <em>Adapter Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter Provider</em>' reference.
	 * @see #getAdapterProvider()
	 * @generated
	 */
	void setAdapterProvider(Part value);

	/**
	 * Returns the value of the '<em><b>Provides Adapter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provides Adapter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provides Adapter</em>' containment reference.
	 * @see #setProvidesAdapter(ProvidesAdapter)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getAdapterProvider_ProvidesAdapter()
	 * @model containment="true" required="true"
	 *        annotation="methods name='getAdapter' signature='(Ljava.lang.Class;)Ljava.lang.Object;' inherited='true'"
	 * @generated
	 */
	ProvidesAdapter getProvidesAdapter();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.AdapterProvider#getProvidesAdapter <em>Provides Adapter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provides Adapter</em>' containment reference.
	 * @see #getProvidesAdapter()
	 * @generated
	 */
	void setProvidesAdapter(ProvidesAdapter value);

} // AdapterProvider
