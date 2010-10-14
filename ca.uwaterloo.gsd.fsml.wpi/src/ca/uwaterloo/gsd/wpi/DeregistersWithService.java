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
 * $Id: DeregistersWithService.java,v 1.1 2007/04/13 01:00:08 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deregisters With Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.DeregistersWithService#getDeregistrationPartId <em>Deregistration Part Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistersWithService()
 * @model
 * @generated
 */
public interface DeregistersWithService extends EObject {
	/**
	 * Returns the value of the '<em><b>Deregistration Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregistration Part Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregistration Part Id</em>' attribute.
	 * @see #setDeregistrationPartId(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getDeregistersWithService_DeregistrationPartId()
	 * @model required="true"
	 *        annotation="argumentValue index='1'"
	 *        annotation="valueEqualsTo attribute='../../registrationPartId'"
	 * @generated
	 */
	String getDeregistrationPartId();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.DeregistersWithService#getDeregistrationPartId <em>Deregistration Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deregistration Part Id</em>' attribute.
	 * @see #getDeregistrationPartId()
	 * @generated
	 */
	void setDeregistrationPartId(String value);

} // DeregistersWithService
