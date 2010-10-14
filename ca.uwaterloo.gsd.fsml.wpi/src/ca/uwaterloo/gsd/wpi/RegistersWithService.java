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
 * $Id: RegistersWithService.java,v 1.1 2007/04/13 01:00:08 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registers With Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersWithService#getRegistrationPartId <em>Registration Part Id</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersWithService#getProvider <em>Provider</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersWithService#getDeregistersWithService <em>Deregisters With Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersWithService()
 * @model
 * @generated
 */
public interface RegistersWithService extends EObject {
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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersWithService_RegistrationPartId()
	 * @model required="true"
	 *        annotation="argumentValue index='1'"
	 * @generated
	 */
	String getRegistrationPartId();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.RegistersWithService#getRegistrationPartId <em>Registration Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Part Id</em>' attribute.
	 * @see #getRegistrationPartId()
	 * @generated
	 */
	void setRegistrationPartId(String value);

	/**
	 * Returns the value of the '<em><b>Deregisters With Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregisters With Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregisters With Service</em>' containment reference.
	 * @see #setDeregistersWithService(DeregistersWithService)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersWithService_DeregistersWithService()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='org.eclipse.ui.ISelectionService' name='removeSelectionListener' signature='(Ljava.lang.String;Lorg.eclipse.ui.ISelectionListener;)V;' in='hierarchy'"
	 * @generated
	 */
	DeregistersWithService getDeregistersWithService();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.RegistersWithService#getDeregistersWithService <em>Deregisters With Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregisters With Service</em>' containment reference.
	 * @see #getDeregistersWithService()
	 * @generated
	 */
	void setDeregistersWithService(DeregistersWithService value);

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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersWithService_Provider()
	 * @model required="true"
	 *        annotation="where attribute='partId' equalsTo='../registrationPartId'"
	 * @generated
	 */
	Part getProvider();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.RegistersWithService#getProvider <em>Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' reference.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(Part value);

} // RegistersWithService
