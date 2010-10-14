/*******************************************************************************
 * Copyright (c) 2010 Herman Lee.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Herman Lee - initial API and implementation
 ******************************************************************************/

package ca.uwaterloo.gsd.fsml.implModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>impl Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.implModel#getDefaults <em>Defaults</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.implModel.implModel#getVariants <em>Variants</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage#getimplModel()
 * @model
 * @generated
 */
public interface implModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Defaults</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.fsml.implModel.Default}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defaults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defaults</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage#getimplModel_Defaults()
	 * @model containment="true"
	 * @generated
	 */
	EList<Default> getDefaults();

	/**
	 * Returns the value of the '<em><b>Variants</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.fsml.implModel.Variant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variants</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage#getimplModel_Variants()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variant> getVariants();

} // implModel
