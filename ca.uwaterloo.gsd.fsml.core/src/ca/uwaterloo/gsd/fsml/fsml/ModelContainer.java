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
package ca.uwaterloo.gsd.fsml.fsml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.fsml.ModelContainer#getAssertedModel <em>Asserted Model</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.fsml.ModelContainer#getLastReconciledModel <em>Last Reconciled Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.fsml.fsml.FsmlPackage#getModelContainer()
 * @model
 * @generated
 */
public interface ModelContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Asserted Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asserted Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asserted Model</em>' containment reference.
	 * @see #setAssertedModel(Model)
	 * @see ca.uwaterloo.gsd.fsml.fsml.FsmlPackage#getModelContainer_AssertedModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Model getAssertedModel();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.fsml.ModelContainer#getAssertedModel <em>Asserted Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asserted Model</em>' containment reference.
	 * @see #getAssertedModel()
	 * @generated
	 */
	void setAssertedModel(Model value);

	/**
	 * Returns the value of the '<em><b>Last Reconciled Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Reconciled Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Reconciled Model</em>' containment reference.
	 * @see #setLastReconciledModel(Model)
	 * @see ca.uwaterloo.gsd.fsml.fsml.FsmlPackage#getModelContainer_LastReconciledModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Model getLastReconciledModel();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.fsml.ModelContainer#getLastReconciledModel <em>Last Reconciled Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Reconciled Model</em>' containment reference.
	 * @see #getLastReconciledModel()
	 * @generated
	 */
	void setLastReconciledModel(Model value);

} // ModelContainer
