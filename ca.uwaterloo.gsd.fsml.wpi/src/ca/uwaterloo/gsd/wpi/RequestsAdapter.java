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
 * $Id: RequestsAdapter.java,v 1.7 2007/08/02 04:33:01 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requests Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RequestsAdapter#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RequestsAdapter#getAdapterProvider <em>Adapter Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRequestsAdapter()
 * @model
 * @generated
 */
public interface RequestsAdapter extends Concept {
	/**
	 * Returns the value of the '<em><b>Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter</em>' attribute.
	 * @see #setAdapter(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRequestsAdapter_Adapter()
	 * @model required="true"
	 *        annotation="argumentValue index='1'"
	 * @generated
	 */
	String getAdapter();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.RequestsAdapter#getAdapter <em>Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter</em>' attribute.
	 * @see #getAdapter()
	 * @generated
	 */
	void setAdapter(String value);

	/**
	 * Returns the value of the '<em><b>Adapter Provider</b></em>' reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.AdapterProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter Provider</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter Provider</em>' reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRequestsAdapter_AdapterProvider()
	 * @model annotation="where attribute='providesAdapter/adapters' contains='../adapter'"
	 * @generated
	 */
	EList<AdapterProvider> getAdapterProvider();

} // RequestsAdapter
