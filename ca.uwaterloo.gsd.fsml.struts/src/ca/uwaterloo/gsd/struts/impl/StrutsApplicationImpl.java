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
 * $Id: StrutsApplicationImpl.java,v 1.8 2007/12/06 03:28:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
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
import ca.uwaterloo.gsd.struts.ActionImpl;
import ca.uwaterloo.gsd.struts.FormImpl;
import ca.uwaterloo.gsd.struts.StrutsApplication;
import ca.uwaterloo.gsd.struts.StrutsConfig;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.StrutsApplicationImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.StrutsApplicationImpl#getStrutsConfig <em>Struts Config</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.StrutsApplicationImpl#getForms <em>Forms</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.StrutsApplicationImpl#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StrutsApplicationImpl extends ConceptImpl implements StrutsApplication {
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
	 * The cached value of the '{@link #getStrutsConfig() <em>Struts Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrutsConfig()
	 * @generated
	 * @ordered
	 */
	protected StrutsConfig strutsConfig;

	/**
	 * The cached value of the '{@link #getForms() <em>Forms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForms()
	 * @generated
	 * @ordered
	 */
	protected EList<FormImpl> forms;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionImpl> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StrutsApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.STRUTS_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsConfig getStrutsConfig() {
		return strutsConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStrutsConfig(StrutsConfig newStrutsConfig, NotificationChain msgs) {
		StrutsConfig oldStrutsConfig = strutsConfig;
		strutsConfig = newStrutsConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG, oldStrutsConfig, newStrutsConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrutsConfig(StrutsConfig newStrutsConfig) {
		if (newStrutsConfig != strutsConfig) {
			NotificationChain msgs = null;
			if (strutsConfig != null)
				msgs = ((InternalEObject)strutsConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG, null, msgs);
			if (newStrutsConfig != null)
				msgs = ((InternalEObject)newStrutsConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG, null, msgs);
			msgs = basicSetStrutsConfig(newStrutsConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG, newStrutsConfig, newStrutsConfig));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.STRUTS_APPLICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FormImpl> getForms() {
		if (forms == null) {
			forms = new EObjectContainmentEList<FormImpl>(FormImpl.class, this, StrutsPackage.STRUTS_APPLICATION__FORMS);
		}
		return forms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionImpl> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<ActionImpl>(ActionImpl.class, this, StrutsPackage.STRUTS_APPLICATION__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG:
				return basicSetStrutsConfig(null, msgs);
			case StrutsPackage.STRUTS_APPLICATION__FORMS:
				return ((InternalEList<?>)getForms()).basicRemove(otherEnd, msgs);
			case StrutsPackage.STRUTS_APPLICATION__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
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
			case StrutsPackage.STRUTS_APPLICATION__NAME:
				return getName();
			case StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG:
				return getStrutsConfig();
			case StrutsPackage.STRUTS_APPLICATION__FORMS:
				return getForms();
			case StrutsPackage.STRUTS_APPLICATION__ACTIONS:
				return getActions();
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
			case StrutsPackage.STRUTS_APPLICATION__NAME:
				setName((String)newValue);
				return;
			case StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG:
				setStrutsConfig((StrutsConfig)newValue);
				return;
			case StrutsPackage.STRUTS_APPLICATION__FORMS:
				getForms().clear();
				getForms().addAll((Collection<? extends FormImpl>)newValue);
				return;
			case StrutsPackage.STRUTS_APPLICATION__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ActionImpl>)newValue);
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
			case StrutsPackage.STRUTS_APPLICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG:
				setStrutsConfig((StrutsConfig)null);
				return;
			case StrutsPackage.STRUTS_APPLICATION__FORMS:
				getForms().clear();
				return;
			case StrutsPackage.STRUTS_APPLICATION__ACTIONS:
				getActions().clear();
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
			case StrutsPackage.STRUTS_APPLICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StrutsPackage.STRUTS_APPLICATION__STRUTS_CONFIG:
				return strutsConfig != null;
			case StrutsPackage.STRUTS_APPLICATION__FORMS:
				return forms != null && !forms.isEmpty();
			case StrutsPackage.STRUTS_APPLICATION__ACTIONS:
				return actions != null && !actions.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //StrutsApplicationImpl
