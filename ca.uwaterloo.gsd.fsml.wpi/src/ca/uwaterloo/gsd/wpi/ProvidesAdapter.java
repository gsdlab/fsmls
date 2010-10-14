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
 * $Id: ProvidesAdapter.java,v 1.11 2008/06/28 18:34:36 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provides Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ProvidesAdapter#getAdapters <em>Adapters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getProvidesAdapter()
 * @model
 * @generated
 */
public interface ProvidesAdapter extends Concept {
	/**
	 * Returns the value of the '<em><b>Adapters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapters</em>' attribute list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getProvidesAdapter_Adapters()
	 * @model default="true" required="true"
	 *        annotation="typesOfReturnedObjects anonymous='true' ifkey='1'"
	 * @generated
	 */
	EList<String> getAdapters();

} // ProvidesAdapter
