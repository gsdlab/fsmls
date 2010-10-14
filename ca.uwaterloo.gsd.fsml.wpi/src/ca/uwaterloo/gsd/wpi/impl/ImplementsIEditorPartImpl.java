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
 * $Id: ImplementsIEditorPartImpl.java,v 1.4 2007/07/17 04:18:36 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.ExtendsEditorPart;
import ca.uwaterloo.gsd.wpi.ImplementsIEditorPart;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implements IEditor Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ImplementsIEditorPartImpl#getExtendsEditorPart <em>Extends Editor Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementsIEditorPartImpl extends ConceptImpl implements ImplementsIEditorPart {
	/**
	 * The cached value of the '{@link #getExtendsEditorPart() <em>Extends Editor Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsEditorPart()
	 * @generated
	 * @ordered
	 */
	protected ExtendsEditorPart extendsEditorPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementsIEditorPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.IMPLEMENTS_IEDITOR_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsEditorPart getExtendsEditorPart() {
		return extendsEditorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendsEditorPart(ExtendsEditorPart newExtendsEditorPart, NotificationChain msgs) {
		ExtendsEditorPart oldExtendsEditorPart = extendsEditorPart;
		extendsEditorPart = newExtendsEditorPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART, oldExtendsEditorPart, newExtendsEditorPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsEditorPart(ExtendsEditorPart newExtendsEditorPart) {
		if (newExtendsEditorPart != extendsEditorPart) {
			NotificationChain msgs = null;
			if (extendsEditorPart != null)
				msgs = ((InternalEObject)extendsEditorPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART, null, msgs);
			if (newExtendsEditorPart != null)
				msgs = ((InternalEObject)newExtendsEditorPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART, null, msgs);
			msgs = basicSetExtendsEditorPart(newExtendsEditorPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART, newExtendsEditorPart, newExtendsEditorPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART:
				return basicSetExtendsEditorPart(null, msgs);
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
			case WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART:
				return getExtendsEditorPart();
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
			case WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART:
				setExtendsEditorPart((ExtendsEditorPart)newValue);
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
			case WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART:
				setExtendsEditorPart((ExtendsEditorPart)null);
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
			case WpiPackage.IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART:
				return extendsEditorPart != null;
		}
		return super.eIsSet(featureID);
	}

} //ImplementsIEditorPartImpl
