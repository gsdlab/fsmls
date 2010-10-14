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
 * $Id: ImplementsIViewPartImpl.java,v 1.5 2007/07/17 04:18:37 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.ExtendsViewPart;
import ca.uwaterloo.gsd.wpi.ImplementsIViewPart;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implements IView Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ImplementsIViewPartImpl#getExtendsViewPart <em>Extends View Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementsIViewPartImpl extends ConceptImpl implements ImplementsIViewPart {
	/**
	 * The cached value of the '{@link #getExtendsViewPart() <em>Extends View Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsViewPart()
	 * @generated
	 * @ordered
	 */
	protected ExtendsViewPart extendsViewPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementsIViewPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.IMPLEMENTS_IVIEW_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsViewPart getExtendsViewPart() {
		return extendsViewPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendsViewPart(ExtendsViewPart newExtendsViewPart, NotificationChain msgs) {
		ExtendsViewPart oldExtendsViewPart = extendsViewPart;
		extendsViewPart = newExtendsViewPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART, oldExtendsViewPart, newExtendsViewPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsViewPart(ExtendsViewPart newExtendsViewPart) {
		if (newExtendsViewPart != extendsViewPart) {
			NotificationChain msgs = null;
			if (extendsViewPart != null)
				msgs = ((InternalEObject)extendsViewPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART, null, msgs);
			if (newExtendsViewPart != null)
				msgs = ((InternalEObject)newExtendsViewPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART, null, msgs);
			msgs = basicSetExtendsViewPart(newExtendsViewPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART, newExtendsViewPart, newExtendsViewPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART:
				return basicSetExtendsViewPart(null, msgs);
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
			case WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART:
				return getExtendsViewPart();
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
			case WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART:
				setExtendsViewPart((ExtendsViewPart)newValue);
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
			case WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART:
				setExtendsViewPart((ExtendsViewPart)null);
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
			case WpiPackage.IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART:
				return extendsViewPart != null;
		}
		return super.eIsSet(featureID);
	}

} //ImplementsIViewPartImpl
