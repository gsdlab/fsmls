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
 * $Id: RegistersAPartListenerImpl.java,v 1.3 2008/02/29 22:33:02 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.RegistersAPartListener;
import ca.uwaterloo.gsd.wpi.RegistersAsPartListener;
import ca.uwaterloo.gsd.wpi.RegistersAsPartListener2;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registers APart Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAPartListenerImpl#getRegisters <em>Registers</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAPartListenerImpl#getRegisters2 <em>Registers2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistersAPartListenerImpl extends ConceptImpl implements RegistersAPartListener {
	/**
	 * The cached value of the '{@link #getRegisters() <em>Registers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisters()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistersAsPartListener> registers;

	/**
	 * The cached value of the '{@link #getRegisters2() <em>Registers2</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisters2()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistersAsPartListener2> registers2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegistersAPartListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.REGISTERS_APART_LISTENER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistersAsPartListener> getRegisters() {
		if (registers == null) {
			registers = new EObjectContainmentEList<RegistersAsPartListener>(RegistersAsPartListener.class, this, WpiPackage.REGISTERS_APART_LISTENER__REGISTERS);
		}
		return registers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistersAsPartListener2> getRegisters2() {
		if (registers2 == null) {
			registers2 = new EObjectContainmentEList<RegistersAsPartListener2>(RegistersAsPartListener2.class, this, WpiPackage.REGISTERS_APART_LISTENER__REGISTERS2);
		}
		return registers2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS:
				return ((InternalEList<?>)getRegisters()).basicRemove(otherEnd, msgs);
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS2:
				return ((InternalEList<?>)getRegisters2()).basicRemove(otherEnd, msgs);
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
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS:
				return getRegisters();
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS2:
				return getRegisters2();
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
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS:
				getRegisters().clear();
				getRegisters().addAll((Collection<? extends RegistersAsPartListener>)newValue);
				return;
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS2:
				getRegisters2().clear();
				getRegisters2().addAll((Collection<? extends RegistersAsPartListener2>)newValue);
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
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS:
				getRegisters().clear();
				return;
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS2:
				getRegisters2().clear();
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
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS:
				return registers != null && !registers.isEmpty();
			case WpiPackage.REGISTERS_APART_LISTENER__REGISTERS2:
				return registers2 != null && !registers2.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RegistersAPartListenerImpl
