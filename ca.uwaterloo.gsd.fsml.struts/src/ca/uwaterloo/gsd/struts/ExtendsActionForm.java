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
 * $Id: ExtendsActionForm.java,v 1.3 2007/03/08 20:37:31 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extends Action Form</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.ExtendsActionForm#isExtendsDynaActionForm <em>Extends Dyna Action Form</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getExtendsActionForm()
 * @model
 * @generated
 */
public interface ExtendsActionForm extends Concept {
	/**
	 * Returns the value of the '<em><b>Extends Dyna Action Form</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Dyna Action Form</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Dyna Action Form</em>' attribute.
	 * @see #setExtendsDynaActionForm(boolean)
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#getExtendsActionForm_ExtendsDynaActionForm()
	 * @model annotation="extendsClass name='org.apache.struts.action.DynaActionForm'"
	 * @generated
	 */
	boolean isExtendsDynaActionForm();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.struts.ExtendsActionForm#isExtendsDynaActionForm <em>Extends Dyna Action Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Dyna Action Form</em>' attribute.
	 * @see #isExtendsDynaActionForm()
	 * @generated
	 */
	void setExtendsDynaActionForm(boolean value);

} // ExtendsActionForm
