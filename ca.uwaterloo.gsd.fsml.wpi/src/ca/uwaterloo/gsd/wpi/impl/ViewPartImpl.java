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
 * $Id: ViewPartImpl.java,v 1.4 2007/07/17 04:18:35 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.wpi.ImplementsIViewPart;
import ca.uwaterloo.gsd.wpi.ViewPart;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ViewPartImpl#getPartId <em>Part Id</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.ViewPartImpl#getImplementsIViewPart <em>Implements IView Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewPartImpl extends PartImpl implements ViewPart {
	/**
	 * The default value of the '{@link #getPartId() <em>Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartId()
	 * @generated
	 * @ordered
	 */
	protected static final String PART_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartId() <em>Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartId()
	 * @generated
	 * @ordered
	 */
	protected String partId = PART_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImplementsIViewPart() <em>Implements IView Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementsIViewPart()
	 * @generated
	 * @ordered
	 */
	protected ImplementsIViewPart implementsIViewPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.VIEW_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartId() {
		return partId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartId(String newPartId) {
		String oldPartId = partId;
		partId = newPartId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.VIEW_PART__PART_ID, oldPartId, partId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementsIViewPart getImplementsIViewPart() {
		return implementsIViewPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplementsIViewPart(ImplementsIViewPart newImplementsIViewPart, NotificationChain msgs) {
		ImplementsIViewPart oldImplementsIViewPart = implementsIViewPart;
		implementsIViewPart = newImplementsIViewPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART, oldImplementsIViewPart, newImplementsIViewPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementsIViewPart(ImplementsIViewPart newImplementsIViewPart) {
		if (newImplementsIViewPart != implementsIViewPart) {
			NotificationChain msgs = null;
			if (implementsIViewPart != null)
				msgs = ((InternalEObject)implementsIViewPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART, null, msgs);
			if (newImplementsIViewPart != null)
				msgs = ((InternalEObject)newImplementsIViewPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART, null, msgs);
			msgs = basicSetImplementsIViewPart(newImplementsIViewPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART, newImplementsIViewPart, newImplementsIViewPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART:
				return basicSetImplementsIViewPart(null, msgs);
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
			case WpiPackage.VIEW_PART__PART_ID:
				return getPartId();
			case WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART:
				return getImplementsIViewPart();
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
			case WpiPackage.VIEW_PART__PART_ID:
				setPartId((String)newValue);
				return;
			case WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART:
				setImplementsIViewPart((ImplementsIViewPart)newValue);
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
			case WpiPackage.VIEW_PART__PART_ID:
				setPartId(PART_ID_EDEFAULT);
				return;
			case WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART:
				setImplementsIViewPart((ImplementsIViewPart)null);
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
			case WpiPackage.VIEW_PART__PART_ID:
				return PART_ID_EDEFAULT == null ? partId != null : !PART_ID_EDEFAULT.equals(partId);
			case WpiPackage.VIEW_PART__IMPLEMENTS_IVIEW_PART:
				return implementsIViewPart != null;
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
		result.append(" (partId: ");
		result.append(partId);
		result.append(')');
		return result.toString();
	}

} //ViewPartImpl
