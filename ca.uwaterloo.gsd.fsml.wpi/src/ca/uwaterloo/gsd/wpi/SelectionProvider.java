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
 * $Id: SelectionProvider.java,v 1.8 2008/01/23 03:48:16 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.SelectionProvider#getProvider <em>Provider</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.SelectionProvider#getRegisters <em>Registers</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSelectionProvider()
 * @model
 * @generated
 */
public interface SelectionProvider extends Concept {
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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSelectionProvider_Provider()
	 * @model required="true"
	 * @generated
	 */
	Part getProvider();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.SelectionProvider#getProvider <em>Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provider</em>' reference.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(Part value);

	/**
	 * Returns the value of the '<em><b>Registers</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getSelectionProvider_Registers()
	 * @model containment="true" required="true"
	 *        annotation="methodCalls class='org.eclipse.ui.IWorkbenchSite' name='setSelectionProvider' signature='(Lorg.eclipse.jface.viewers.ISelectionProvider;)V;' in='hierarchy' locationName='createPartControl' locationSig='(Lorg.eclipse.swt.widgets.Composite;)V' receiverExpr='getSite()' position='after'"
	 * @generated
	 */
	EList<RegistersAsSelectionProvider> getRegisters();

} // SelectionProvider
