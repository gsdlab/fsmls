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
 * $Id: ViewPart.java,v 1.5 2008/04/10 19:07:30 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ViewPart#getPartId <em>Part Id</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.ViewPart#getImplementsIViewPart <em>Implements IView Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getViewPart()
 * @model
 * @generated
 */
public interface ViewPart extends Part {
	/**
	 * Returns the value of the '<em><b>Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Id</em>' attribute.
	 * @see #setPartId(String)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getViewPart_PartId()
	 * @model
	 * @generated
	 */
	String getPartId();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.ViewPart#getPartId <em>Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Id</em>' attribute.
	 * @see #getPartId()
	 * @generated
	 */
	void setPartId(String value);

	/**
	 * Returns the value of the '<em><b>Implements IView Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements IView Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements IView Part</em>' containment reference.
	 * @see #setImplementsIViewPart(ImplementsIViewPart)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getViewPart_ImplementsIViewPart()
	 * @model containment="true" required="true"
	 *        annotation="implementsInterface name='org.eclipse.ui.IViewPart' concrete='true'"
	 *        annotation="subsumedBy feature='extendsViewPart/'"
	 * @generated
	 */
	ImplementsIViewPart getImplementsIViewPart();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.ViewPart#getImplementsIViewPart <em>Implements IView Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements IView Part</em>' containment reference.
	 * @see #getImplementsIViewPart()
	 * @generated
	 */
	void setImplementsIViewPart(ImplementsIViewPart value);

} // ViewPart
