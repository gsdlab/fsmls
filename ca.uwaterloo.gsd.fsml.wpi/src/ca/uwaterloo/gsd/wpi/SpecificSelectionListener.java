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
 * $Id: SpecificSelectionListener.java,v 1.5 2008/02/29 22:33:02 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Selection Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getRegistrationPartId <em>Registration Part Id</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getProvider <em>Provider</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getProviderName <em>Provider Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getDeregisters <em>Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSpecificSelectionListener()
 * @model
 * @generated
 */
public interface SpecificSelectionListener extends Concept {
	/**
	 * Returns the value of the '<em><b>Registration Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Part Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Part Id</em>' attribute.
	 * @see #setRegistrationPartId(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSpecificSelectionListener_RegistrationPartId()
	 * @model required="true"
	 *        annotation="argumentValue index='1'"
	 * @generated
	 */
	String getRegistrationPartId();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getRegistrationPartId <em>Registration Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Part Id</em>' attribute.
	 * @see #getRegistrationPartId()
	 * @generated
	 */
	void setRegistrationPartId(String value);

	/**
	 * Returns the value of the '<em><b>Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider</em>' reference.
	 * @see #setProvider(Part)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSpecificSelectionListener_Provider()
	 * @model required="true"
	 *        annotation="where attribute='partId' equalsTo='../registrationPartId'"
	 * @generated
	 */
	Part getProvider();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getProvider <em>Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' reference.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(Part value);

	/**
	 * Returns the value of the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provider Name</em>' attribute.
	 * @see #isSetProviderName()
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSpecificSelectionListener_ProviderName()
	 * @model unique="false" unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getProviderName();

	/**
	 * Returns whether the value of the '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getProviderName <em>Provider Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Provider Name</em>' attribute is set.
	 * @see #getProviderName()
	 * @generated
	 */
	boolean isSetProviderName();

	/**
	 * Returns the value of the '<em><b>Deregisters</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregisters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregisters</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSpecificSelectionListener_Deregisters()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='org.eclipse.ui.ISelectionService' name='removeSelectionListener' signature='(Ljava.lang.String;Lorg.eclipse.ui.ISelectionListener;)V;' in='hierarchy' locationName='dispose' receiverExpr='getSite().getPage()' position='after'"
	 * @generated
	 */
	EList<DeregistersSamePartId> getDeregisters();

} // SpecificSelectionListener
