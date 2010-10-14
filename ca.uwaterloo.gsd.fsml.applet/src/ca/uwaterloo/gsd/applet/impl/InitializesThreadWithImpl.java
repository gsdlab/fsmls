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
 * $Id: InitializesThreadWithImpl.java,v 1.5 2008/01/23 03:47:52 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.InitializesThreadWith;
import ca.uwaterloo.gsd.applet.RunnableField;
import ca.uwaterloo.gsd.applet.ThisRunnable;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initializes Thread With</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadWithImpl#getThis <em>This</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadWithImpl#isHelper <em>Helper</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadWithImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadWithImpl#getRunnableField <em>Runnable Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitializesThreadWithImpl extends ConceptImpl implements InitializesThreadWith {
	/**
	 * The cached value of the '{@link #getThis() <em>This</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThis()
	 * @generated
	 * @ordered
	 */
	protected ThisRunnable this_;

	/**
	 * The default value of the '{@link #isHelper() <em>Helper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHelper()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HELPER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHelper() <em>Helper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHelper()
	 * @generated
	 * @ordered
	 */
	protected boolean helper = HELPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariable() <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected String variable = VARIABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRunnableField() <em>Runnable Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunnableField()
	 * @generated
	 * @ordered
	 */
	protected RunnableField runnableField;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InitializesThreadWithImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.INITIALIZES_THREAD_WITH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisRunnable getThis() {
		return this_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThis(ThisRunnable newThis, NotificationChain msgs) {
		ThisRunnable oldThis = this_;
		this_ = newThis;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_WITH__THIS, oldThis, newThis);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThis(ThisRunnable newThis) {
		if (newThis != this_) {
			NotificationChain msgs = null;
			if (this_ != null)
				msgs = ((InternalEObject)this_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.INITIALIZES_THREAD_WITH__THIS, null, msgs);
			if (newThis != null)
				msgs = ((InternalEObject)newThis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.INITIALIZES_THREAD_WITH__THIS, null, msgs);
			msgs = basicSetThis(newThis, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_WITH__THIS, newThis, newThis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHelper() {
		return helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelper(boolean newHelper) {
		boolean oldHelper = helper;
		helper = newHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_WITH__HELPER, oldHelper, helper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(String newVariable) {
		String oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_WITH__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunnableField getRunnableField() {
		return runnableField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRunnableField(RunnableField newRunnableField, NotificationChain msgs) {
		RunnableField oldRunnableField = runnableField;
		runnableField = newRunnableField;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD, oldRunnableField, newRunnableField);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunnableField(RunnableField newRunnableField) {
		if (newRunnableField != runnableField) {
			NotificationChain msgs = null;
			if (runnableField != null)
				msgs = ((InternalEObject)runnableField).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD, null, msgs);
			if (newRunnableField != null)
				msgs = ((InternalEObject)newRunnableField).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD, null, msgs);
			msgs = basicSetRunnableField(newRunnableField, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD, newRunnableField, newRunnableField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.INITIALIZES_THREAD_WITH__THIS:
				return basicSetThis(null, msgs);
			case AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD:
				return basicSetRunnableField(null, msgs);
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
			case AppletPackage.INITIALIZES_THREAD_WITH__THIS:
				return getThis();
			case AppletPackage.INITIALIZES_THREAD_WITH__HELPER:
				return isHelper() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.INITIALIZES_THREAD_WITH__VARIABLE:
				return getVariable();
			case AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD:
				return getRunnableField();
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
			case AppletPackage.INITIALIZES_THREAD_WITH__THIS:
				setThis((ThisRunnable)newValue);
				return;
			case AppletPackage.INITIALIZES_THREAD_WITH__HELPER:
				setHelper(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.INITIALIZES_THREAD_WITH__VARIABLE:
				setVariable((String)newValue);
				return;
			case AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD:
				setRunnableField((RunnableField)newValue);
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
			case AppletPackage.INITIALIZES_THREAD_WITH__THIS:
				setThis((ThisRunnable)null);
				return;
			case AppletPackage.INITIALIZES_THREAD_WITH__HELPER:
				setHelper(HELPER_EDEFAULT);
				return;
			case AppletPackage.INITIALIZES_THREAD_WITH__VARIABLE:
				setVariable(VARIABLE_EDEFAULT);
				return;
			case AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD:
				setRunnableField((RunnableField)null);
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
			case AppletPackage.INITIALIZES_THREAD_WITH__THIS:
				return this_ != null;
			case AppletPackage.INITIALIZES_THREAD_WITH__HELPER:
				return helper != HELPER_EDEFAULT;
			case AppletPackage.INITIALIZES_THREAD_WITH__VARIABLE:
				return VARIABLE_EDEFAULT == null ? variable != null : !VARIABLE_EDEFAULT.equals(variable);
			case AppletPackage.INITIALIZES_THREAD_WITH__RUNNABLE_FIELD:
				return runnableField != null;
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
		result.append(" (helper: ");
		result.append(helper);
		result.append(", variable: ");
		result.append(variable);
		result.append(')');
		return result.toString();
	}

} //InitializesThreadWithImpl
