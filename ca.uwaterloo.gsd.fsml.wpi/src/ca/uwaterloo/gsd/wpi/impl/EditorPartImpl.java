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
 * $Id: EditorPartImpl.java,v 1.4 2007/07/17 04:18:36 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.wpi.Contributor;
import ca.uwaterloo.gsd.wpi.EditorPart;
import ca.uwaterloo.gsd.wpi.ImplementsIEditorPart;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.EditorPartImpl#getPartId <em>Part Id</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.EditorPartImpl#getContributor <em>Contributor</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.EditorPartImpl#getImplementsIEditorPart <em>Implements IEditor Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EditorPartImpl extends PartImpl implements EditorPart {
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
	 * The cached value of the '{@link #getContributor() <em>Contributor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributor()
	 * @generated
	 * @ordered
	 */
	protected Contributor contributor;

	/**
	 * The cached value of the '{@link #getImplementsIEditorPart() <em>Implements IEditor Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementsIEditorPart()
	 * @generated
	 * @ordered
	 */
	protected ImplementsIEditorPart implementsIEditorPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditorPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.EDITOR_PART;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.EDITOR_PART__PART_ID, oldPartId, partId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contributor getContributor() {
		return contributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContributor(Contributor newContributor, NotificationChain msgs) {
		Contributor oldContributor = contributor;
		contributor = newContributor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.EDITOR_PART__CONTRIBUTOR, oldContributor, newContributor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContributor(Contributor newContributor) {
		if (newContributor != contributor) {
			NotificationChain msgs = null;
			if (contributor != null)
				msgs = ((InternalEObject)contributor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.EDITOR_PART__CONTRIBUTOR, null, msgs);
			if (newContributor != null)
				msgs = ((InternalEObject)newContributor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.EDITOR_PART__CONTRIBUTOR, null, msgs);
			msgs = basicSetContributor(newContributor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.EDITOR_PART__CONTRIBUTOR, newContributor, newContributor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementsIEditorPart getImplementsIEditorPart() {
		return implementsIEditorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplementsIEditorPart(ImplementsIEditorPart newImplementsIEditorPart, NotificationChain msgs) {
		ImplementsIEditorPart oldImplementsIEditorPart = implementsIEditorPart;
		implementsIEditorPart = newImplementsIEditorPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART, oldImplementsIEditorPart, newImplementsIEditorPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementsIEditorPart(ImplementsIEditorPart newImplementsIEditorPart) {
		if (newImplementsIEditorPart != implementsIEditorPart) {
			NotificationChain msgs = null;
			if (implementsIEditorPart != null)
				msgs = ((InternalEObject)implementsIEditorPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART, null, msgs);
			if (newImplementsIEditorPart != null)
				msgs = ((InternalEObject)newImplementsIEditorPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART, null, msgs);
			msgs = basicSetImplementsIEditorPart(newImplementsIEditorPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART, newImplementsIEditorPart, newImplementsIEditorPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.EDITOR_PART__CONTRIBUTOR:
				return basicSetContributor(null, msgs);
			case WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART:
				return basicSetImplementsIEditorPart(null, msgs);
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
			case WpiPackage.EDITOR_PART__PART_ID:
				return getPartId();
			case WpiPackage.EDITOR_PART__CONTRIBUTOR:
				return getContributor();
			case WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART:
				return getImplementsIEditorPart();
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
			case WpiPackage.EDITOR_PART__PART_ID:
				setPartId((String)newValue);
				return;
			case WpiPackage.EDITOR_PART__CONTRIBUTOR:
				setContributor((Contributor)newValue);
				return;
			case WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART:
				setImplementsIEditorPart((ImplementsIEditorPart)newValue);
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
			case WpiPackage.EDITOR_PART__PART_ID:
				setPartId(PART_ID_EDEFAULT);
				return;
			case WpiPackage.EDITOR_PART__CONTRIBUTOR:
				setContributor((Contributor)null);
				return;
			case WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART:
				setImplementsIEditorPart((ImplementsIEditorPart)null);
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
			case WpiPackage.EDITOR_PART__PART_ID:
				return PART_ID_EDEFAULT == null ? partId != null : !PART_ID_EDEFAULT.equals(partId);
			case WpiPackage.EDITOR_PART__CONTRIBUTOR:
				return contributor != null;
			case WpiPackage.EDITOR_PART__IMPLEMENTS_IEDITOR_PART:
				return implementsIEditorPart != null;
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

} //EditorPartImpl
