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
 * $Id: WorkbenchPartInteractions.java,v 1.6 2008/01/23 03:24:45 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;
import ca.uwaterloo.gsd.fsml.fsml.Model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workbench Part Interactions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getProject <em>Project</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getParts <em>Parts</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getSelectionProviders <em>Selection Providers</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getSelectionListeners <em>Selection Listeners</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getPartListeners <em>Part Listeners</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getAdapterProviders <em>Adapter Providers</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getAdapterRequestors <em>Adapter Requestors</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getWorkbenchPartInteractions()
 * @model
 * @generated
 */
public interface WorkbenchPartInteractions extends Concept, Model {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' attribute.
	 * @see #setProject(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getWorkbenchPartInteractions_Project()
	 * @model required="true"
	 * @generated
	 */
	String getProject();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getProject <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' attribute.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(String value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.Part}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getWorkbenchPartInteractions_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Part> getParts();

	/**
	 * Returns the value of the '<em><b>Selection Providers</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.SelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Providers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Providers</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getWorkbenchPartInteractions_SelectionProviders()
	 * @model containment="true"
	 * @generated
	 */
	EList<SelectionProvider> getSelectionProviders();

	/**
	 * Returns the value of the '<em><b>Selection Listeners</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.SelectionListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Listeners</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Listeners</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getWorkbenchPartInteractions_SelectionListeners()
	 * @model containment="true"
	 * @generated
	 */
	EList<SelectionListener> getSelectionListeners();

	/**
	 * Returns the value of the '<em><b>Part Listeners</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.PartListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Listeners</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Listeners</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getWorkbenchPartInteractions_PartListeners()
	 * @model containment="true"
	 * @generated
	 */
	EList<PartListener> getPartListeners();

	/**
	 * Returns the value of the '<em><b>Adapter Providers</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.AdapterProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter Providers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter Providers</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getWorkbenchPartInteractions_AdapterProviders()
	 * @model containment="true"
	 * @generated
	 */
	EList<AdapterProvider> getAdapterProviders();

	/**
	 * Returns the value of the '<em><b>Adapter Requestors</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.AdapterRequestor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter Requestors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter Requestors</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getWorkbenchPartInteractions_AdapterRequestors()
	 * @model containment="true"
	 * @generated
	 */
	EList<AdapterRequestor> getAdapterRequestors();

} // WorkbenchPartInteractions
