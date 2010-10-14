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
 * $Id: EditorPart.java,v 1.5 2008/05/05 15:34:34 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Editor Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.EditorPart#getPartId <em>Part Id</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.EditorPart#getContributor <em>Contributor</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.EditorPart#getImplementsIEditorPart <em>Implements IEditor Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getEditorPart()
 * @model
 * @generated
 */
public interface EditorPart extends Part {
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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getEditorPart_PartId()
	 * @model
	 * @generated
	 */
	String getPartId();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.EditorPart#getPartId <em>Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Id</em>' attribute.
	 * @see #getPartId()
	 * @generated
	 */
	void setPartId(String value);

	/**
	 * Returns the value of the '<em><b>Contributor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contributor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contributor</em>' containment reference.
	 * @see #setContributor(Contributor)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getEditorPart_Contributor()
	 * @model containment="true"
	 * @generated
	 */
	Contributor getContributor();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.EditorPart#getContributor <em>Contributor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contributor</em>' containment reference.
	 * @see #getContributor()
	 * @generated
	 */
	void setContributor(Contributor value);

	/**
	 * Returns the value of the '<em><b>Implements IEditor Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements IEditor Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements IEditor Part</em>' containment reference.
	 * @see #setImplementsIEditorPart(ImplementsIEditorPart)
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#getEditorPart_ImplementsIEditorPart()
	 * @model containment="true" required="true"
	 *        annotation="implementsInterface name='org.eclipse.ui.IEditorPart' concrete='true'"
	 *        annotation="subsumedBy feature='extendsEditorPart/'"
	 * @generated
	 */
	ImplementsIEditorPart getImplementsIEditorPart();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.wpi.EditorPart#getImplementsIEditorPart <em>Implements IEditor Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implements IEditor Part</em>' containment reference.
	 * @see #getImplementsIEditorPart()
	 * @generated
	 */
	void setImplementsIEditorPart(ImplementsIEditorPart value);

} // EditorPart
