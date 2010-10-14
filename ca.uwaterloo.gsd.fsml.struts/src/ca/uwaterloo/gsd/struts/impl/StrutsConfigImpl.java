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
 * $Id: StrutsConfigImpl.java,v 1.7 2007/12/06 03:28:19 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.struts.ActionDecl;
import ca.uwaterloo.gsd.struts.FormDecl;
import ca.uwaterloo.gsd.struts.ForwardDecl;
import ca.uwaterloo.gsd.struts.StrutsConfig;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.StrutsConfigImpl#getForms <em>Forms</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.StrutsConfigImpl#getForwards <em>Forwards</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.StrutsConfigImpl#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StrutsConfigImpl extends ConceptImpl implements StrutsConfig {
	/**
	 * The cached value of the '{@link #getForms() <em>Forms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForms()
	 * @generated
	 * @ordered
	 */
	protected EList<FormDecl> forms;

	/**
	 * The cached value of the '{@link #getForwards() <em>Forwards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwards()
	 * @generated
	 * @ordered
	 */
	protected EList<ForwardDecl> forwards;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionDecl> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StrutsConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.STRUTS_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FormDecl> getForms() {
		if (forms == null) {
			forms = new EObjectContainmentEList<FormDecl>(FormDecl.class, this, StrutsPackage.STRUTS_CONFIG__FORMS);
		}
		return forms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForwardDecl> getForwards() {
		if (forwards == null) {
			forwards = new EObjectContainmentEList<ForwardDecl>(ForwardDecl.class, this, StrutsPackage.STRUTS_CONFIG__FORWARDS);
		}
		return forwards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionDecl> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<ActionDecl>(ActionDecl.class, this, StrutsPackage.STRUTS_CONFIG__ACTIONS);
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
			case StrutsPackage.STRUTS_CONFIG__FORMS:
				return ((InternalEList<?>)getForms()).basicRemove(otherEnd, msgs);
			case StrutsPackage.STRUTS_CONFIG__FORWARDS:
				return ((InternalEList<?>)getForwards()).basicRemove(otherEnd, msgs);
			case StrutsPackage.STRUTS_CONFIG__ACTIONS:
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
			case StrutsPackage.STRUTS_CONFIG__FORMS:
				return getForms();
			case StrutsPackage.STRUTS_CONFIG__FORWARDS:
				return getForwards();
			case StrutsPackage.STRUTS_CONFIG__ACTIONS:
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
			case StrutsPackage.STRUTS_CONFIG__FORMS:
				getForms().clear();
				getForms().addAll((Collection<? extends FormDecl>)newValue);
				return;
			case StrutsPackage.STRUTS_CONFIG__FORWARDS:
				getForwards().clear();
				getForwards().addAll((Collection<? extends ForwardDecl>)newValue);
				return;
			case StrutsPackage.STRUTS_CONFIG__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ActionDecl>)newValue);
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
			case StrutsPackage.STRUTS_CONFIG__FORMS:
				getForms().clear();
				return;
			case StrutsPackage.STRUTS_CONFIG__FORWARDS:
				getForwards().clear();
				return;
			case StrutsPackage.STRUTS_CONFIG__ACTIONS:
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
			case StrutsPackage.STRUTS_CONFIG__FORMS:
				return forms != null && !forms.isEmpty();
			case StrutsPackage.STRUTS_CONFIG__FORWARDS:
				return forwards != null && !forwards.isEmpty();
			case StrutsPackage.STRUTS_CONFIG__ACTIONS:
				return actions != null && !actions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StrutsConfigImpl
