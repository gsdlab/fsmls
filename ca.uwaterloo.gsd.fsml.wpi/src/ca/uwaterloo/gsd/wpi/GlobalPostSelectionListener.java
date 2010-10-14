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
 * $Id: GlobalPostSelectionListener.java,v 1.5 2008/02/29 22:33:03 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Post Selection Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener#getDeregisters <em>Deregisters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getGlobalPostSelectionListener()
 * @model
 * @generated
 */
public interface GlobalPostSelectionListener extends Concept {
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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getGlobalPostSelectionListener_Deregisters()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='org.eclipse.ui.ISelectionService' name='removePostSelectionListener' signature='(Lorg.eclipse.ui.ISelectionListener;)V;' in='hierarchy' locationName='dispose' receiverExpr='getSite().getPage()' position='after'"
	 * @generated
	 */
	EList<Deregisters> getDeregisters();

} // GlobalPostSelectionListener
