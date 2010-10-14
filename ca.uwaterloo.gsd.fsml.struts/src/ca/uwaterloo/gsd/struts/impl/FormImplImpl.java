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
 * $Id: FormImplImpl.java,v 1.8 2007/12/06 03:28:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.struts.ExtendsActionForm;
import ca.uwaterloo.gsd.struts.FormImpl;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Form Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormImplImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormImplImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormImplImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormImplImpl#isLocal <em>Local</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.FormImplImpl#getExtendsActionForm <em>Extends Action Form</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormImplImpl extends ConceptImpl implements FormImpl {
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
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isLocal() <em>Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOCAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLocal() <em>Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocal()
	 * @generated
	 * @ordered
	 */
	protected boolean local = LOCAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtendsActionForm() <em>Extends Action Form</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsActionForm()
	 * @generated
	 * @ordered
	 */
	protected ExtendsActionForm extendsActionForm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.FORM_IMPL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_IMPL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_IMPL__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_IMPL__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocal() {
		return local;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocal(boolean newLocal) {
		boolean oldLocal = local;
		local = newLocal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_IMPL__LOCAL, oldLocal, local));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsActionForm getExtendsActionForm() {
		return extendsActionForm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendsActionForm(ExtendsActionForm newExtendsActionForm, NotificationChain msgs) {
		ExtendsActionForm oldExtendsActionForm = extendsActionForm;
		extendsActionForm = newExtendsActionForm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM, oldExtendsActionForm, newExtendsActionForm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsActionForm(ExtendsActionForm newExtendsActionForm) {
		if (newExtendsActionForm != extendsActionForm) {
			NotificationChain msgs = null;
			if (extendsActionForm != null)
				msgs = ((InternalEObject)extendsActionForm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM, null, msgs);
			if (newExtendsActionForm != null)
				msgs = ((InternalEObject)newExtendsActionForm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM, null, msgs);
			msgs = basicSetExtendsActionForm(newExtendsActionForm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM, newExtendsActionForm, newExtendsActionForm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM:
				return basicSetExtendsActionForm(null, msgs);
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
			case StrutsPackage.FORM_IMPL__NAME:
				return getName();
			case StrutsPackage.FORM_IMPL__PACKAGE:
				return getPackage();
			case StrutsPackage.FORM_IMPL__QUALIFIED_NAME:
				return getQualifiedName();
			case StrutsPackage.FORM_IMPL__LOCAL:
				return isLocal() ? Boolean.TRUE : Boolean.FALSE;
			case StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM:
				return getExtendsActionForm();
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
			case StrutsPackage.FORM_IMPL__NAME:
				setName((String)newValue);
				return;
			case StrutsPackage.FORM_IMPL__PACKAGE:
				setPackage((String)newValue);
				return;
			case StrutsPackage.FORM_IMPL__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case StrutsPackage.FORM_IMPL__LOCAL:
				setLocal(((Boolean)newValue).booleanValue());
				return;
			case StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM:
				setExtendsActionForm((ExtendsActionForm)newValue);
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
			case StrutsPackage.FORM_IMPL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StrutsPackage.FORM_IMPL__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case StrutsPackage.FORM_IMPL__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case StrutsPackage.FORM_IMPL__LOCAL:
				setLocal(LOCAL_EDEFAULT);
				return;
			case StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM:
				setExtendsActionForm((ExtendsActionForm)null);
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
			case StrutsPackage.FORM_IMPL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StrutsPackage.FORM_IMPL__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case StrutsPackage.FORM_IMPL__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case StrutsPackage.FORM_IMPL__LOCAL:
				return local != LOCAL_EDEFAULT;
			case StrutsPackage.FORM_IMPL__EXTENDS_ACTION_FORM:
				return extendsActionForm != null;
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
		result.append(", package: ");
		result.append(package_);
		result.append(", qualifiedName: ");
		result.append(qualifiedName);
		result.append(", local: ");
		result.append(local);
		result.append(')');
		return result.toString();
	}

} //FormImplImpl
