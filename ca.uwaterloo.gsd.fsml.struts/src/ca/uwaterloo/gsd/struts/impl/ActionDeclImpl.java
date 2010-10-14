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
 * $Id: ActionDeclImpl.java,v 1.9 2008/02/26 21:18:37 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
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
import ca.uwaterloo.gsd.struts.ActionDecl;
import ca.uwaterloo.gsd.struts.ActionImpl;
import ca.uwaterloo.gsd.struts.ForwardDecl;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionDeclImpl#getPath <em>Path</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionDeclImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionDeclImpl#getType <em>Type</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionDeclImpl#getActionImpl <em>Action Impl</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionDeclImpl#getForwards <em>Forwards</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.struts.impl.ActionDeclImpl#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionDeclImpl extends ConceptImpl implements ActionDecl {
	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActionImpl() <em>Action Impl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionImpl()
	 * @generated
	 * @ordered
	 */
	protected ActionImpl actionImpl;

	/**
	 * The cached value of the '{@link #getForwards() <em>Forwards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwards()
	 * @generated
	 * @ordered
	 */
	protected EList<ForwardDecl> forwards;

	/**
	 * The default value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected String input = INPUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrutsPackage.Literals.ACTION_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_DECL__PATH, oldPath, path));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_DECL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_DECL__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionImpl getActionImpl() {
		if (actionImpl != null && actionImpl.eIsProxy()) {
			InternalEObject oldActionImpl = (InternalEObject)actionImpl;
			actionImpl = (ActionImpl)eResolveProxy(oldActionImpl);
			if (actionImpl != oldActionImpl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StrutsPackage.ACTION_DECL__ACTION_IMPL, oldActionImpl, actionImpl));
			}
		}
		return actionImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionImpl basicGetActionImpl() {
		return actionImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionImpl(ActionImpl newActionImpl) {
		ActionImpl oldActionImpl = actionImpl;
		actionImpl = newActionImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_DECL__ACTION_IMPL, oldActionImpl, actionImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForwardDecl> getForwards() {
		if (forwards == null) {
			forwards = new EObjectContainmentEList<ForwardDecl>(ForwardDecl.class, this, StrutsPackage.ACTION_DECL__FORWARDS);
		}
		return forwards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(String newInput) {
		String oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrutsPackage.ACTION_DECL__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrutsPackage.ACTION_DECL__FORWARDS:
				return ((InternalEList<?>)getForwards()).basicRemove(otherEnd, msgs);
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
			case StrutsPackage.ACTION_DECL__PATH:
				return getPath();
			case StrutsPackage.ACTION_DECL__NAME:
				return getName();
			case StrutsPackage.ACTION_DECL__TYPE:
				return getType();
			case StrutsPackage.ACTION_DECL__ACTION_IMPL:
				if (resolve) return getActionImpl();
				return basicGetActionImpl();
			case StrutsPackage.ACTION_DECL__FORWARDS:
				return getForwards();
			case StrutsPackage.ACTION_DECL__INPUT:
				return getInput();
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
			case StrutsPackage.ACTION_DECL__PATH:
				setPath((String)newValue);
				return;
			case StrutsPackage.ACTION_DECL__NAME:
				setName((String)newValue);
				return;
			case StrutsPackage.ACTION_DECL__TYPE:
				setType((String)newValue);
				return;
			case StrutsPackage.ACTION_DECL__ACTION_IMPL:
				setActionImpl((ActionImpl)newValue);
				return;
			case StrutsPackage.ACTION_DECL__FORWARDS:
				getForwards().clear();
				getForwards().addAll((Collection<? extends ForwardDecl>)newValue);
				return;
			case StrutsPackage.ACTION_DECL__INPUT:
				setInput((String)newValue);
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
			case StrutsPackage.ACTION_DECL__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case StrutsPackage.ACTION_DECL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StrutsPackage.ACTION_DECL__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case StrutsPackage.ACTION_DECL__ACTION_IMPL:
				setActionImpl((ActionImpl)null);
				return;
			case StrutsPackage.ACTION_DECL__FORWARDS:
				getForwards().clear();
				return;
			case StrutsPackage.ACTION_DECL__INPUT:
				setInput(INPUT_EDEFAULT);
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
			case StrutsPackage.ACTION_DECL__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case StrutsPackage.ACTION_DECL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StrutsPackage.ACTION_DECL__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case StrutsPackage.ACTION_DECL__ACTION_IMPL:
				return actionImpl != null;
			case StrutsPackage.ACTION_DECL__FORWARDS:
				return forwards != null && !forwards.isEmpty();
			case StrutsPackage.ACTION_DECL__INPUT:
				return INPUT_EDEFAULT == null ? input != null : !INPUT_EDEFAULT.equals(input);
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
		result.append(" (path: ");
		result.append(path);
		result.append(", name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", input: ");
		result.append(input);
		result.append(')');
		return result.toString();
	}

} //ActionDeclImpl
