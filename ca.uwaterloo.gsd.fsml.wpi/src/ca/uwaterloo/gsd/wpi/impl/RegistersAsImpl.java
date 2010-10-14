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
 * $Id: RegistersAsImpl.java,v 1.3 2008/02/29 22:33:02 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
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
import ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener;
import ca.uwaterloo.gsd.wpi.GlobalSelectionListener;
import ca.uwaterloo.gsd.wpi.RegistersAs;
import ca.uwaterloo.gsd.wpi.SpecificSelectionListener;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registers As</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsImpl#getGlobalSelectionListener <em>Global Selection Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsImpl#getGlobalPostSelectionListener <em>Global Post Selection Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsImpl#getSpecificSelectionListener <em>Specific Selection Listener</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistersAsImpl extends ConceptImpl implements RegistersAs {
	/**
	 * The cached value of the '{@link #getGlobalSelectionListener() <em>Global Selection Listener</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalSelectionListener()
	 * @generated
	 * @ordered
	 */
	protected EList<GlobalSelectionListener> globalSelectionListener;

	/**
	 * The cached value of the '{@link #getGlobalPostSelectionListener() <em>Global Post Selection Listener</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalPostSelectionListener()
	 * @generated
	 * @ordered
	 */
	protected EList<GlobalPostSelectionListener> globalPostSelectionListener;

	/**
	 * The cached value of the '{@link #getSpecificSelectionListener() <em>Specific Selection Listener</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificSelectionListener()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecificSelectionListener> specificSelectionListener;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegistersAsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.REGISTERS_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GlobalSelectionListener> getGlobalSelectionListener() {
		if (globalSelectionListener == null) {
			globalSelectionListener = new EObjectContainmentEList<GlobalSelectionListener>(GlobalSelectionListener.class, this, WpiPackage.REGISTERS_AS__GLOBAL_SELECTION_LISTENER);
		}
		return globalSelectionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GlobalPostSelectionListener> getGlobalPostSelectionListener() {
		if (globalPostSelectionListener == null) {
			globalPostSelectionListener = new EObjectContainmentEList<GlobalPostSelectionListener>(GlobalPostSelectionListener.class, this, WpiPackage.REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER);
		}
		return globalPostSelectionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecificSelectionListener> getSpecificSelectionListener() {
		if (specificSelectionListener == null) {
			specificSelectionListener = new EObjectContainmentEList<SpecificSelectionListener>(SpecificSelectionListener.class, this, WpiPackage.REGISTERS_AS__SPECIFIC_SELECTION_LISTENER);
		}
		return specificSelectionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.REGISTERS_AS__GLOBAL_SELECTION_LISTENER:
				return ((InternalEList<?>)getGlobalSelectionListener()).basicRemove(otherEnd, msgs);
			case WpiPackage.REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER:
				return ((InternalEList<?>)getGlobalPostSelectionListener()).basicRemove(otherEnd, msgs);
			case WpiPackage.REGISTERS_AS__SPECIFIC_SELECTION_LISTENER:
				return ((InternalEList<?>)getSpecificSelectionListener()).basicRemove(otherEnd, msgs);
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
			case WpiPackage.REGISTERS_AS__GLOBAL_SELECTION_LISTENER:
				return getGlobalSelectionListener();
			case WpiPackage.REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER:
				return getGlobalPostSelectionListener();
			case WpiPackage.REGISTERS_AS__SPECIFIC_SELECTION_LISTENER:
				return getSpecificSelectionListener();
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
			case WpiPackage.REGISTERS_AS__GLOBAL_SELECTION_LISTENER:
				getGlobalSelectionListener().clear();
				getGlobalSelectionListener().addAll((Collection<? extends GlobalSelectionListener>)newValue);
				return;
			case WpiPackage.REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER:
				getGlobalPostSelectionListener().clear();
				getGlobalPostSelectionListener().addAll((Collection<? extends GlobalPostSelectionListener>)newValue);
				return;
			case WpiPackage.REGISTERS_AS__SPECIFIC_SELECTION_LISTENER:
				getSpecificSelectionListener().clear();
				getSpecificSelectionListener().addAll((Collection<? extends SpecificSelectionListener>)newValue);
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
			case WpiPackage.REGISTERS_AS__GLOBAL_SELECTION_LISTENER:
				getGlobalSelectionListener().clear();
				return;
			case WpiPackage.REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER:
				getGlobalPostSelectionListener().clear();
				return;
			case WpiPackage.REGISTERS_AS__SPECIFIC_SELECTION_LISTENER:
				getSpecificSelectionListener().clear();
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
			case WpiPackage.REGISTERS_AS__GLOBAL_SELECTION_LISTENER:
				return globalSelectionListener != null && !globalSelectionListener.isEmpty();
			case WpiPackage.REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER:
				return globalPostSelectionListener != null && !globalPostSelectionListener.isEmpty();
			case WpiPackage.REGISTERS_AS__SPECIFIC_SELECTION_LISTENER:
				return specificSelectionListener != null && !specificSelectionListener.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RegistersAsImpl
