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
 * $Id: FormDeclImpl.java,v 1.7 2008/03/20 04:01:53 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.struts.FormDecl;
import ca.uwaterloo.gsd.struts.FormProperty;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Form Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormDeclImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormDeclImpl#getFormType <em>Form Type</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormDeclImpl#isIsDynaActionForm <em>Is Dyna Action Form</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormDeclImpl#getFormProperty <em>Form Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormDeclImpl extends ConceptImpl implements FormDecl {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormType() <em>Form Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormType()
	 * @generated
	 * @ordered
	 */
	protected static final String FORM_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormType() <em>Form Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormType()
	 * @generated
	 * @ordered
	 */
	protected String formType = FORM_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDynaActionForm() <em>Is Dyna Action Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDynaActionForm()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DYNA_ACTION_FORM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDynaActionForm() <em>Is Dyna Action Form</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDynaActionForm()
	 * @generated
	 * @ordered
	 */
	protected boolean isDynaActionForm = IS_DYNA_ACTION_FORM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFormProperty() <em>Form Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<FormProperty> formProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.FORM_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_DECL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormType() {
		return formType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormType(String newFormType) {
		String oldFormType = formType;
		formType = newFormType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_DECL__FORM_TYPE, oldFormType, formType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDynaActionForm() {
		return isDynaActionForm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDynaActionForm(boolean newIsDynaActionForm) {
		boolean oldIsDynaActionForm = isDynaActionForm;
		isDynaActionForm = newIsDynaActionForm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_DECL__IS_DYNA_ACTION_FORM, oldIsDynaActionForm, isDynaActionForm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FormProperty> getFormProperty() {
		if (formProperty == null) {
			formProperty = new EObjectContainmentEList<FormProperty>(FormProperty.class, this, StrutsPackage.FORM_DECL__FORM_PROPERTY);
		}
		return formProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrutsPackage.FORM_DECL__FORM_PROPERTY:
				return ((InternalEList<?>)getFormProperty()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StrutsPackage.FORM_DECL__NAME:
				return getName();
			case StrutsPackage.FORM_DECL__FORM_TYPE:
				return getFormType();
			case StrutsPackage.FORM_DECL__IS_DYNA_ACTION_FORM:
				return isIsDynaActionForm() ? Boolean.TRUE : Boolean.FALSE;
			case StrutsPackage.FORM_DECL__FORM_PROPERTY:
				return getFormProperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StrutsPackage.FORM_DECL__NAME:
				setName((String)newValue);
				return;
			case StrutsPackage.FORM_DECL__FORM_TYPE:
				setFormType((String)newValue);
				return;
			case StrutsPackage.FORM_DECL__IS_DYNA_ACTION_FORM:
				setIsDynaActionForm(((Boolean)newValue).booleanValue());
				return;
			case StrutsPackage.FORM_DECL__FORM_PROPERTY:
				getFormProperty().clear();
				getFormProperty().addAll((Collection<? extends FormProperty>)newValue);
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
			case StrutsPackage.FORM_DECL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StrutsPackage.FORM_DECL__FORM_TYPE:
				setFormType(FORM_TYPE_EDEFAULT);
				return;
			case StrutsPackage.FORM_DECL__IS_DYNA_ACTION_FORM:
				setIsDynaActionForm(IS_DYNA_ACTION_FORM_EDEFAULT);
				return;
			case StrutsPackage.FORM_DECL__FORM_PROPERTY:
				getFormProperty().clear();
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
			case StrutsPackage.FORM_DECL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StrutsPackage.FORM_DECL__FORM_TYPE:
				return FORM_TYPE_EDEFAULT == null ? formType != null : !FORM_TYPE_EDEFAULT.equals(formType);
			case StrutsPackage.FORM_DECL__IS_DYNA_ACTION_FORM:
				return isDynaActionForm != IS_DYNA_ACTION_FORM_EDEFAULT;
			case StrutsPackage.FORM_DECL__FORM_PROPERTY:
				return formProperty != null && !formProperty.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", formType: ");
		result.append(formType);
		result.append(", isDynaActionForm: ");
		result.append(isDynaActionForm);
		result.append(')');
		return result.toString();
	}

} //FormDeclImpl
