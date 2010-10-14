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
 * $Id: RegistersAPartListener.java,v 1.3 2008/02/29 22:33:03 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registers APart Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAPartListener#getRegisters <em>Registers</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.RegistersAPartListener#getRegisters2 <em>Registers2</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAPartListener()
 * @model annotation="featureGroup lowerBound='1' upperBound='2' essential='true'"
 * @generated
 */
public interface RegistersAPartListener extends Concept {
	/**
	 * Returns the value of the '<em><b>Registers</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.RegistersAsPartListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAPartListener_Registers()
	 * @model containment="true"
	 *        annotation="methodCalls class='org.eclipse.ui.IPartService' name='addPartListener' signature='(Lorg.eclipse.ui.IPartListener;)V;' in='hierarchy' locationName='createPartControl' locationSig='(Lorg.eclipse.swt.widgets.Composite;)V' receiverExpr='getSite().getPage()' position='after'"
	 * @generated
	 */
	EList<RegistersAsPartListener> getRegisters();

	/**
	 * Returns the value of the '<em><b>Registers2</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.RegistersAsPartListener2}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers2</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getRegistersAPartListener_Registers2()
	 * @model containment="true"
	 *        annotation="methodCalls class='org.eclipse.ui.IPartService' name='addPartListener' signature='(Lorg.eclipse.ui.IPartListener2;)V;' in='hierarchy' locationName='createPartControl' locationSig='(Lorg.eclipse.swt.widgets.Composite;)V' receiverExpr='getSite().getPage()' position='after'"
	 * @generated
	 */
	EList<RegistersAsPartListener2> getRegisters2();

} // RegistersAPartListener
