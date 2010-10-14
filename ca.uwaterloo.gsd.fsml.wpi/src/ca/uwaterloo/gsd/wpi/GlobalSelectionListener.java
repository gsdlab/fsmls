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
 * $Id: GlobalSelectionListener.java,v 1.6 2008/02/29 22:33:02 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Selection Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.GlobalSelectionListener#getDeregisters <em>Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getGlobalSelectionListener()
 * @model
 * @generated
 */
public interface GlobalSelectionListener extends Concept {
	/**
	 * Returns the value of the '<em><b>Deregisters</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.Deregisters}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deregisters</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deregisters</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getGlobalSelectionListener_Deregisters()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='org.eclipse.ui.ISelectionService' name='removeSelectionListener' signature='(Lorg.eclipse.ui.ISelectionListener;)V;' in='hierarchy' locationName='dispose' receiverExpr='getSite().getPage()' position='after'"
	 * @generated
	 */
	EList<Deregisters> getDeregisters();

} // GlobalSelectionListener
