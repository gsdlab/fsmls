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
 * $Id: RegistersAs.java,v 1.6 2008/02/29 22:33:03 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registers As</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAs#getGlobalSelectionListener <em>Global Selection Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAs#getGlobalPostSelectionListener <em>Global Post Selection Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAs#getSpecificSelectionListener <em>Specific Selection Listener</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAs()
 * @model annotation="featureGroup lowerBound='1' upperBound='3' essential='true'"
 * @generated
 */
public interface RegistersAs extends Concept {
	/**
	 * Returns the value of the '<em><b>Global Selection Listener</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.GlobalSelectionListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Selection Listener</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Selection Listener</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAs_GlobalSelectionListener()
	 * @model containment="true"
	 *        annotation="methodCalls class='org.eclipse.ui.ISelectionService' name='addSelectionListener' signature='(Lorg.eclipse.ui.ISelectionListener;)V;' in='hierarchy' locationName='createPartControl' locationSig='(Lorg.eclipse.swt.widgets.Composite;)V' receiverExpr='getSite().getPage()' position='after'"
	 * @generated
	 */
	EList<GlobalSelectionListener> getGlobalSelectionListener();

	/**
	 * Returns the value of the '<em><b>Global Post Selection Listener</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Post Selection Listener</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Post Selection Listener</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAs_GlobalPostSelectionListener()
	 * @model containment="true"
	 *        annotation="methodCalls class='org.eclipse.ui.ISelectionService' name='addPostSelectionListener' signature='(Lorg.eclipse.ui.ISelectionListener;)V;' in='hierarchy' locationName='createPartControl' locationSig='(Lorg.eclipse.swt.widgets.Composite;)V' receiverExpr='getSite().getPage()' position='after'"
	 * @generated
	 */
	EList<GlobalPostSelectionListener> getGlobalPostSelectionListener();

	/**
	 * Returns the value of the '<em><b>Specific Selection Listener</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific Selection Listener</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific Selection Listener</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAs_SpecificSelectionListener()
	 * @model containment="true"
	 *        annotation="methodCalls class='org.eclipse.ui.ISelectionService' name='addSelectionListener' signature='(Ljava.lang.String;Lorg.eclipse.ui.ISelectionListener;)V;' in='hierarchy' locationName='createPartControl' locationSig='(Lorg.eclipse.swt.widgets.Composite;)V' receiverExpr='getSite().getPage()' position='after'"
	 * @generated
	 */
	EList<SpecificSelectionListener> getSpecificSelectionListener();

} // RegistersAs
