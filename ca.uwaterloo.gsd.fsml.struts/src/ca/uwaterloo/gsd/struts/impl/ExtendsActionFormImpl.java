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
 * $Id: ExtendsActionFormImpl.java,v 1.4 2007/12/06 03:28:19 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.struts.ExtendsActionForm;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends Action Form</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ExtendsActionFormImpl#isExtendsDynaActionForm <em>Extends Dyna Action Form</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsActionFormImpl extends ConceptImpl implements ExtendsActionForm {
	/**
	 * The default value of the '{@link #isExtendsDynaActionForm() <em>Extends Dyna Action Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsDynaActionForm()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTENDS_DYNA_ACTION_FORM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExtendsDynaActionForm() <em>Extends Dyna Action Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExtendsDynaActionForm()
	 * @generated
	 * @ordered
	 */
	protected boolean extendsDynaActionForm = EXTENDS_DYNA_ACTION_FORM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsActionFormImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.EXTENDS_ACTION_FORM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExtendsDynaActionForm() {
		return extendsDynaActionForm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsDynaActionForm(boolean newExtendsDynaActionForm) {
		boolean oldExtendsDynaActionForm = extendsDynaActionForm;
		extendsDynaActionForm = newExtendsDynaActionForm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.EXTENDS_ACTION_FORM__EXTENDS_DYNA_ACTION_FORM, oldExtendsDynaActionForm, extendsDynaActionForm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StrutsPackage.EXTENDS_ACTION_FORM__EXTENDS_DYNA_ACTION_FORM:
				return isExtendsDynaActionForm() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StrutsPackage.EXTENDS_ACTION_FORM__EXTENDS_DYNA_ACTION_FORM:
				setExtendsDynaActionForm(((Boolean)newValue).booleanValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StrutsPackage.EXTENDS_ACTION_FORM__EXTENDS_DYNA_ACTION_FORM:
				setExtendsDynaActionForm(EXTENDS_DYNA_ACTION_FORM_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StrutsPackage.EXTENDS_ACTION_FORM__EXTENDS_DYNA_ACTION_FORM:
				return extendsDynaActionForm != EXTENDS_DYNA_ACTION_FORM_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (extendsDynaActionForm: ");
		result.append(extendsDynaActionForm);
		result.append(')');
		return result.toString();
	}

} //ExtendsActionFormImpl
