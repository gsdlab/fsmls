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
 * $Id: ExtendsDispatchActionImpl.java,v 1.8 2007/12/06 03:28:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.struts.ExtendsDispatchAction;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extends Dispatch Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ExtendsDispatchActionImpl#getActionMethod <em>Action Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtendsDispatchActionImpl extends ConceptImpl implements ExtendsDispatchAction {
	/**
	 * The cached value of the '{@link #getActionMethod() <em>Action Method</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionMethod()
	 * @generated
	 * @ordered
	 */
	protected EList<String> actionMethod;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsDispatchActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.EXTENDS_DISPATCH_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getActionMethod() {
		if (actionMethod == null) {
			actionMethod = new EDataTypeUniqueEList<String>(String.class, this, StrutsPackage.EXTENDS_DISPATCH_ACTION__ACTION_METHOD);
		}
		return actionMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StrutsPackage.EXTENDS_DISPATCH_ACTION__ACTION_METHOD:
				return getActionMethod();
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
			case StrutsPackage.EXTENDS_DISPATCH_ACTION__ACTION_METHOD:
				getActionMethod().clear();
				getActionMethod().addAll((Collection<? extends String>)newValue);
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
			case StrutsPackage.EXTENDS_DISPATCH_ACTION__ACTION_METHOD:
				getActionMethod().clear();
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
			case StrutsPackage.EXTENDS_DISPATCH_ACTION__ACTION_METHOD:
				return actionMethod != null && !actionMethod.isEmpty();
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
		result.append(" (actionMethod: ");
		result.append(actionMethod);
		result.append(')');
		return result.toString();
	}

} //ExtendsDispatchActionImpl
