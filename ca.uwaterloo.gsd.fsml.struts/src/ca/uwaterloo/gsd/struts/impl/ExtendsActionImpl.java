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
 * $Id: ExtendsActionImpl.java,v 1.8 2007/12/06 03:28:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.struts.ExtendsAction;
import ca.uwaterloo.gsd.struts.ExtendsDispatchAction;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ExtendsActionImpl#getExtendsDispatchAction <em>Extends Dispatch Action</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ExtendsActionImpl#isOverridesExecute <em>Overrides Execute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsActionImpl extends ConceptImpl implements ExtendsAction {
	/**
	 * The cached value of the '{@link #getExtendsDispatchAction() <em>Extends Dispatch Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsDispatchAction()
	 * @generated
	 * @ordered
	 */
	protected ExtendsDispatchAction extendsDispatchAction;

	/**
	 * The default value of the '{@link #isOverridesExecute() <em>Overrides Execute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverridesExecute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERRIDES_EXECUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOverridesExecute() <em>Overrides Execute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverridesExecute()
	 * @generated
	 * @ordered
	 */
	protected boolean overridesExecute = OVERRIDES_EXECUTE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.EXTENDS_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsDispatchAction getExtendsDispatchAction() {
		return extendsDispatchAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendsDispatchAction(ExtendsDispatchAction newExtendsDispatchAction, NotificationChain msgs) {
		ExtendsDispatchAction oldExtendsDispatchAction = extendsDispatchAction;
		extendsDispatchAction = newExtendsDispatchAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION, oldExtendsDispatchAction, newExtendsDispatchAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsDispatchAction(ExtendsDispatchAction newExtendsDispatchAction) {
		if (newExtendsDispatchAction != extendsDispatchAction) {
			NotificationChain msgs = null;
			if (extendsDispatchAction != null)
				msgs = ((InternalEObject)extendsDispatchAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION, null, msgs);
			if (newExtendsDispatchAction != null)
				msgs = ((InternalEObject)newExtendsDispatchAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION, null, msgs);
			msgs = basicSetExtendsDispatchAction(newExtendsDispatchAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION, newExtendsDispatchAction, newExtendsDispatchAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverridesExecute() {
		return overridesExecute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverridesExecute(boolean newOverridesExecute) {
		boolean oldOverridesExecute = overridesExecute;
		overridesExecute = newOverridesExecute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.EXTENDS_ACTION__OVERRIDES_EXECUTE, oldOverridesExecute, overridesExecute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION:
				return basicSetExtendsDispatchAction(null, msgs);
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
			case StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION:
				return getExtendsDispatchAction();
			case StrutsPackage.EXTENDS_ACTION__OVERRIDES_EXECUTE:
				return isOverridesExecute() ? Boolean.TRUE : Boolean.FALSE;
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
			case StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION:
				setExtendsDispatchAction((ExtendsDispatchAction)newValue);
				return;
			case StrutsPackage.EXTENDS_ACTION__OVERRIDES_EXECUTE:
				setOverridesExecute(((Boolean)newValue).booleanValue());
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
			case StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION:
				setExtendsDispatchAction((ExtendsDispatchAction)null);
				return;
			case StrutsPackage.EXTENDS_ACTION__OVERRIDES_EXECUTE:
				setOverridesExecute(OVERRIDES_EXECUTE_EDEFAULT);
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
			case StrutsPackage.EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION:
				return extendsDispatchAction != null;
			case StrutsPackage.EXTENDS_ACTION__OVERRIDES_EXECUTE:
				return overridesExecute != OVERRIDES_EXECUTE_EDEFAULT;
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
		result.append(" (overridesExecute: ");
		result.append(overridesExecute);
		result.append(')');
		return result.toString();
	}

} //ExtendsActionImpl
