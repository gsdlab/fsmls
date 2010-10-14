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
package ca.uwaterloo.gsd.fsml.sync;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import ca.uwaterloo.gsd.fsml.fsml.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synchronization Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getAssertedModel <em>Asserted Model</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getImplementationModel <em>Implementation Model</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getClassSyncItems <em>Class Sync Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSynchronizationResult()
 * @model
 * @generated
 */
public interface SynchronizationResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Asserted Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asserted Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asserted Model</em>' reference.
	 * @see #setAssertedModel(Model)
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSynchronizationResult_AssertedModel()
	 * @model required="true"
	 * @generated
	 */
	Model getAssertedModel();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getAssertedModel <em>Asserted Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asserted Model</em>' reference.
	 * @see #getAssertedModel()
	 * @generated
	 */
	void setAssertedModel(Model value);

	/**
	 * Returns the value of the '<em><b>Implementation Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Model</em>' reference.
	 * @see #setImplementationModel(Model)
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSynchronizationResult_ImplementationModel()
	 * @model required="true"
	 * @generated
	 */
	Model getImplementationModel();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.fsml.sync.SynchronizationResult#getImplementationModel <em>Implementation Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Model</em>' reference.
	 * @see #getImplementationModel()
	 * @generated
	 */
	void setImplementationModel(Model value);

	/**
	 * Returns the value of the '<em><b>Class Sync Items</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Sync Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Sync Items</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSynchronizationResult_ClassSyncItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassSyncItem> getClassSyncItems();

} // SynchronizationResult
