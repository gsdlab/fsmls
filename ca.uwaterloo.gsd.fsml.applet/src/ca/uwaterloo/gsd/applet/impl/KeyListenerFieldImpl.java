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
 * $Id: KeyListenerFieldImpl.java,v 1.1 2008/02/24 20:36:03 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.DeregistersField;
import ca.uwaterloo.gsd.applet.KeyListenerField;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Listener Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.KeyListenerFieldImpl#getListenerField <em>Listener Field</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.KeyListenerFieldImpl#isTypedKeyListener <em>Typed Key Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.KeyListenerFieldImpl#getDeregisters <em>Deregisters</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.KeyListenerFieldImpl#isInitialized <em>Initialized</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyListenerFieldImpl extends ConceptImpl implements KeyListenerField {
	/**
	 * The default value of the '{@link #getListenerField() <em>Listener Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListenerField()
	 * @generated
	 * @ordered
	 */
	protected static final String LISTENER_FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getListenerField() <em>Listener Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListenerField()
	 * @generated
	 * @ordered
	 */
	protected String listenerField = LISTENER_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #isTypedKeyListener() <em>Typed Key Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypedKeyListener()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TYPED_KEY_LISTENER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isTypedKeyListener() <em>Typed Key Listener</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTypedKeyListener()
	 * @generated
	 * @ordered
	 */
	protected boolean typedKeyListener = TYPED_KEY_LISTENER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeregisters() <em>Deregisters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeregisters()
	 * @generated
	 * @ordered
	 */
	protected DeregistersField deregisters;

	/**
	 * The default value of the '{@link #isInitialized() <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isInitialized() <em>Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialized()
	 * @generated
	 * @ordered
	 */
	protected boolean initialized = INITIALIZED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyListenerFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.KEY_LISTENER_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getListenerField() {
		return listenerField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListenerField(String newListenerField) {
		String oldListenerField = listenerField;
		listenerField = newListenerField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.KEY_LISTENER_FIELD__LISTENER_FIELD, oldListenerField, listenerField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTypedKeyListener() {
		return typedKeyListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedKeyListener(boolean newTypedKeyListener) {
		boolean oldTypedKeyListener = typedKeyListener;
		typedKeyListener = newTypedKeyListener;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.KEY_LISTENER_FIELD__TYPED_KEY_LISTENER, oldTypedKeyListener, typedKeyListener));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeregistersField getDeregisters() {
		return deregisters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeregisters(DeregistersField newDeregisters, NotificationChain msgs) {
		DeregistersField oldDeregisters = deregisters;
		deregisters = newDeregisters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS, oldDeregisters, newDeregisters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeregisters(DeregistersField newDeregisters) {
		if (newDeregisters != deregisters) {
			NotificationChain msgs = null;
			if (deregisters != null)
				msgs = ((InternalEObject)deregisters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS, null, msgs);
			if (newDeregisters != null)
				msgs = ((InternalEObject)newDeregisters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS, null, msgs);
			msgs = basicSetDeregisters(newDeregisters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS, newDeregisters, newDeregisters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitialized() {
		return initialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialized(boolean newInitialized) {
		boolean oldInitialized = initialized;
		initialized = newInitialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.KEY_LISTENER_FIELD__INITIALIZED, oldInitialized, initialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS:
				return basicSetDeregisters(null, msgs);
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
			case AppletPackage.KEY_LISTENER_FIELD__LISTENER_FIELD:
				return getListenerField();
			case AppletPackage.KEY_LISTENER_FIELD__TYPED_KEY_LISTENER:
				return isTypedKeyListener() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS:
				return getDeregisters();
			case AppletPackage.KEY_LISTENER_FIELD__INITIALIZED:
				return isInitialized() ? Boolean.TRUE : Boolean.FALSE;
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
			case AppletPackage.KEY_LISTENER_FIELD__LISTENER_FIELD:
				setListenerField((String)newValue);
				return;
			case AppletPackage.KEY_LISTENER_FIELD__TYPED_KEY_LISTENER:
				setTypedKeyListener(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS:
				setDeregisters((DeregistersField)newValue);
				return;
			case AppletPackage.KEY_LISTENER_FIELD__INITIALIZED:
				setInitialized(((Boolean)newValue).booleanValue());
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
			case AppletPackage.KEY_LISTENER_FIELD__LISTENER_FIELD:
				setListenerField(LISTENER_FIELD_EDEFAULT);
				return;
			case AppletPackage.KEY_LISTENER_FIELD__TYPED_KEY_LISTENER:
				setTypedKeyListener(TYPED_KEY_LISTENER_EDEFAULT);
				return;
			case AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS:
				setDeregisters((DeregistersField)null);
				return;
			case AppletPackage.KEY_LISTENER_FIELD__INITIALIZED:
				setInitialized(INITIALIZED_EDEFAULT);
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
			case AppletPackage.KEY_LISTENER_FIELD__LISTENER_FIELD:
				return LISTENER_FIELD_EDEFAULT == null ? listenerField != null : !LISTENER_FIELD_EDEFAULT.equals(listenerField);
			case AppletPackage.KEY_LISTENER_FIELD__TYPED_KEY_LISTENER:
				return typedKeyListener != TYPED_KEY_LISTENER_EDEFAULT;
			case AppletPackage.KEY_LISTENER_FIELD__DEREGISTERS:
				return deregisters != null;
			case AppletPackage.KEY_LISTENER_FIELD__INITIALIZED:
				return initialized != INITIALIZED_EDEFAULT;
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
		result.append(" (listenerField: ");
		result.append(listenerField);
		result.append(", typedKeyListener: ");
		result.append(typedKeyListener);
		result.append(", initialized: ");
		result.append(initialized);
		result.append(')');
		return result.toString();
	}

} //KeyListenerFieldImpl
