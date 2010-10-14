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
 * $Id: AdapterRequestor.java,v 1.8 2008/01/23 03:48:16 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adapter Requestor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.AdapterRequestor#getAdapterRequestor <em>Adapter Requestor</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.AdapterRequestor#getRequestsAdapter <em>Requests Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getAdapterRequestor()
 * @model
 * @generated
 */
public interface AdapterRequestor extends Concept {
	/**
	 * Returns the value of the '<em><b>Adapter Requestor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapter Requestor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapter Requestor</em>' reference.
	 * @see #setAdapterRequestor(Part)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getAdapterRequestor_AdapterRequestor()
	 * @model required="true"
	 * @generated
	 */
	Part getAdapterRequestor();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.AdapterRequestor#getAdapterRequestor <em>Adapter Requestor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adapter Requestor</em>' reference.
	 * @see #getAdapterRequestor()
	 * @generated
	 */
	void setAdapterRequestor(Part value);

	/**
	 * Returns the value of the '<em><b>Requests Adapter</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.RequestsAdapter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requests Adapter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requests Adapter</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getAdapterRequestor_RequestsAdapter()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='org.eclipse.core.runtime.IAdaptable' name='getAdapter' signature='(Ljava.lang.Class;)Ljava.lang.Object;' receiver='org.eclipse.ui.IWorkbenchPart' in='hierarchy' locationName='requestAdapters' locationSig='(Lorg.eclipse.ui.IWorkbenchPart;)V' receiverExpr='iWorkbenchPart' position='after'"
	 * @generated
	 */
	EList<RequestsAdapter> getRequestsAdapter();

} // AdapterRequestor
