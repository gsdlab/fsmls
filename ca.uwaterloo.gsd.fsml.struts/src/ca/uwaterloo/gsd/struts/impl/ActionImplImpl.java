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
 * $Id: ActionImplImpl.java,v 1.10 2008/02/26 21:18:38 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.struts.ActionImpl;
import ca.uwaterloo.gsd.struts.ExtendsAction;
import ca.uwaterloo.gsd.struts.ForwardImpl;
import ca.uwaterloo.gsd.struts.InputForwardImpl;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Impl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl#isLocal <em>Local</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl#getExtendsAction <em>Extends Action</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl#getForwards <em>Forwards</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl#getInputForwards <em>Input Forwards</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImplImpl extends ConceptImpl implements ActionImpl {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #isLocal() <em>Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOCAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLocal() <em>Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocal()
	 * @generated
	 * @ordered
	 */
	protected boolean local = LOCAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtendsAction() <em>Extends Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsAction()
	 * @generated
	 * @ordered
	 */
	protected ExtendsAction extendsAction;

	/**
	 * The cached value of the '{@link #getForwards() <em>Forwards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwards()
	 * @generated
	 * @ordered
	 */
	protected EList<ForwardImpl> forwards;

	/**
	 * The cached value of the '{@link #getInputForwards() <em>Input Forwards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputForwards()
	 * @generated
	 * @ordered
	 */
	protected EList<InputForwardImpl> inputForwards;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImplImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.ACTION_IMPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_IMPL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_IMPL__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		return (package_ != null && package_ != "" ? package_ + "." : "") + name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocal() {
		return local;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocal(boolean newLocal) {
		boolean oldLocal = local;
		local = newLocal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_IMPL__LOCAL, oldLocal, local));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsAction getExtendsAction() {
		return extendsAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendsAction(ExtendsAction newExtendsAction, NotificationChain msgs) {
		ExtendsAction oldExtendsAction = extendsAction;
		extendsAction = newExtendsAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_IMPL__EXTENDS_ACTION, oldExtendsAction, newExtendsAction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsAction(ExtendsAction newExtendsAction) {
		if (newExtendsAction != extendsAction) {
			NotificationChain msgs = null;
			if (extendsAction != null)
				msgs = ((InternalEObject)extendsAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrutsPackage.ACTION_IMPL__EXTENDS_ACTION, null, msgs);
			if (newExtendsAction != null)
				msgs = ((InternalEObject)newExtendsAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrutsPackage.ACTION_IMPL__EXTENDS_ACTION, null, msgs);
			msgs = basicSetExtendsAction(newExtendsAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_IMPL__EXTENDS_ACTION, newExtendsAction, newExtendsAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForwardImpl> getForwards() {
		if (forwards == null) {
			forwards = new EObjectContainmentEList<ForwardImpl>(ForwardImpl.class, this, StrutsPackage.ACTION_IMPL__FORWARDS);
		}
		return forwards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputForwardImpl> getInputForwards() {
		if (inputForwards == null) {
			inputForwards = new EObjectContainmentEList<InputForwardImpl>(InputForwardImpl.class, this, StrutsPackage.ACTION_IMPL__INPUT_FORWARDS);
		}
		return inputForwards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrutsPackage.ACTION_IMPL__EXTENDS_ACTION:
				return basicSetExtendsAction(null, msgs);
			case StrutsPackage.ACTION_IMPL__FORWARDS:
				return ((InternalEList<?>)getForwards()).basicRemove(otherEnd, msgs);
			case StrutsPackage.ACTION_IMPL__INPUT_FORWARDS:
				return ((InternalEList<?>)getInputForwards()).basicRemove(otherEnd, msgs);
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
			case StrutsPackage.ACTION_IMPL__NAME:
				return getName();
			case StrutsPackage.ACTION_IMPL__PACKAGE:
				return getPackage();
			case StrutsPackage.ACTION_IMPL__QUALIFIED_NAME:
				return getQualifiedName();
			case StrutsPackage.ACTION_IMPL__LOCAL:
				return isLocal() ? Boolean.TRUE : Boolean.FALSE;
			case StrutsPackage.ACTION_IMPL__EXTENDS_ACTION:
				return getExtendsAction();
			case StrutsPackage.ACTION_IMPL__FORWARDS:
				return getForwards();
			case StrutsPackage.ACTION_IMPL__INPUT_FORWARDS:
				return getInputForwards();
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
			case StrutsPackage.ACTION_IMPL__NAME:
				setName((String)newValue);
				return;
			case StrutsPackage.ACTION_IMPL__PACKAGE:
				setPackage((String)newValue);
				return;
			case StrutsPackage.ACTION_IMPL__LOCAL:
				setLocal(((Boolean)newValue).booleanValue());
				return;
			case StrutsPackage.ACTION_IMPL__EXTENDS_ACTION:
				setExtendsAction((ExtendsAction)newValue);
				return;
			case StrutsPackage.ACTION_IMPL__FORWARDS:
				getForwards().clear();
				getForwards().addAll((Collection<? extends ForwardImpl>)newValue);
				return;
			case StrutsPackage.ACTION_IMPL__INPUT_FORWARDS:
				getInputForwards().clear();
				getInputForwards().addAll((Collection<? extends InputForwardImpl>)newValue);
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
			case StrutsPackage.ACTION_IMPL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StrutsPackage.ACTION_IMPL__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case StrutsPackage.ACTION_IMPL__LOCAL:
				setLocal(LOCAL_EDEFAULT);
				return;
			case StrutsPackage.ACTION_IMPL__EXTENDS_ACTION:
				setExtendsAction((ExtendsAction)null);
				return;
			case StrutsPackage.ACTION_IMPL__FORWARDS:
				getForwards().clear();
				return;
			case StrutsPackage.ACTION_IMPL__INPUT_FORWARDS:
				getInputForwards().clear();
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
			case StrutsPackage.ACTION_IMPL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StrutsPackage.ACTION_IMPL__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case StrutsPackage.ACTION_IMPL__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case StrutsPackage.ACTION_IMPL__LOCAL:
				return local != LOCAL_EDEFAULT;
			case StrutsPackage.ACTION_IMPL__EXTENDS_ACTION:
				return extendsAction != null;
			case StrutsPackage.ACTION_IMPL__FORWARDS:
				return forwards != null && !forwards.isEmpty();
			case StrutsPackage.ACTION_IMPL__INPUT_FORWARDS:
				return inputForwards != null && !inputForwards.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", package: ");
		result.append(package_);
		result.append(", local: ");
		result.append(local);
		result.append(')');
		return result.toString();
	}

} //ActionImplImpl
