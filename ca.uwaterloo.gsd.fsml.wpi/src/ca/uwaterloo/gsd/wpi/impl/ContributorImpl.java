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
 * $Id: ContributorImpl.java,v 1.5 2007/07/17 04:18:36 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.Contributor;
import ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contributor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ContributorImpl#getContributor <em>Contributor</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ContributorImpl#getExtendsEditorActionBarContributor <em>Extends Editor Action Bar Contributor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContributorImpl extends ConceptImpl implements Contributor {
	/**
	 * The default value of the '{@link #getContributor() <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTRIBUTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContributor() <em>Contributor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected String contributor = CONTRIBUTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtendsEditorActionBarContributor() <em>Extends Editor Action Bar Contributor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsEditorActionBarContributor()
	 * @generated
	 * @ordered
	 */
	protected ExtendsEditorActionBarContributor extendsEditorActionBarContributor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContributorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.CONTRIBUTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContributor() {
		return contributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContributor(String newContributor) {
		String oldContributor = contributor;
		contributor = newContributor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.CONTRIBUTOR__CONTRIBUTOR, oldContributor, contributor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsEditorActionBarContributor getExtendsEditorActionBarContributor() {
		return extendsEditorActionBarContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendsEditorActionBarContributor(ExtendsEditorActionBarContributor newExtendsEditorActionBarContributor, NotificationChain msgs) {
		ExtendsEditorActionBarContributor oldExtendsEditorActionBarContributor = extendsEditorActionBarContributor;
		extendsEditorActionBarContributor = newExtendsEditorActionBarContributor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR, oldExtendsEditorActionBarContributor, newExtendsEditorActionBarContributor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsEditorActionBarContributor(ExtendsEditorActionBarContributor newExtendsEditorActionBarContributor) {
		if (newExtendsEditorActionBarContributor != extendsEditorActionBarContributor) {
			NotificationChain msgs = null;
			if (extendsEditorActionBarContributor != null)
				msgs = ((InternalEObject)extendsEditorActionBarContributor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR, null, msgs);
			if (newExtendsEditorActionBarContributor != null)
				msgs = ((InternalEObject)newExtendsEditorActionBarContributor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR, null, msgs);
			msgs = basicSetExtendsEditorActionBarContributor(newExtendsEditorActionBarContributor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR, newExtendsEditorActionBarContributor, newExtendsEditorActionBarContributor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR:
				return basicSetExtendsEditorActionBarContributor(null, msgs);
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
			case WpiPackage.CONTRIBUTOR__CONTRIBUTOR:
				return getContributor();
			case WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR:
				return getExtendsEditorActionBarContributor();
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
			case WpiPackage.CONTRIBUTOR__CONTRIBUTOR:
				setContributor((String)newValue);
				return;
			case WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR:
				setExtendsEditorActionBarContributor((ExtendsEditorActionBarContributor)newValue);
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
			case WpiPackage.CONTRIBUTOR__CONTRIBUTOR:
				setContributor(CONTRIBUTOR_EDEFAULT);
				return;
			case WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR:
				setExtendsEditorActionBarContributor((ExtendsEditorActionBarContributor)null);
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
			case WpiPackage.CONTRIBUTOR__CONTRIBUTOR:
				return CONTRIBUTOR_EDEFAULT == null ? contributor != null : !CONTRIBUTOR_EDEFAULT.equals(contributor);
			case WpiPackage.CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR:
				return extendsEditorActionBarContributor != null;
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
		result.append(" (contributor: ");
		result.append(contributor);
		result.append(')');
		return result.toString();
	}

} //ContributorImpl
