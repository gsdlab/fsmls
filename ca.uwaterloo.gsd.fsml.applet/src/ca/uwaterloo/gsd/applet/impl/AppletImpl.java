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
 * $Id: AppletImpl.java,v 1.17 2009/04/21 18:26:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.applet.Applet;
import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.ExtendsApplet;
import ca.uwaterloo.gsd.applet.OverridesLifecycleMethods;
import ca.uwaterloo.gsd.applet.Parameter;
import ca.uwaterloo.gsd.applet.RegistersKeyListener;
import ca.uwaterloo.gsd.applet.RegistersMouseListener;
import ca.uwaterloo.gsd.applet.RegistersMouseMotionListener;
import ca.uwaterloo.gsd.applet.ShowsStatus;
import ca.uwaterloo.gsd.applet.SingleTaskThread;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Applet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getExtendsApplet <em>Extends Applet</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getOverridesLifecycleMethods <em>Overrides Lifecycle Methods</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getShowsStatus <em>Shows Status</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getRegistersMouseListener <em>Registers Mouse Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getRegistersMouseMotionListener <em>Registers Mouse Motion Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getRegistersKeyListener <em>Registers Key Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getThread <em>Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getSingleTaskThread <em>Single Task Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#isProvidesParameterInfo <em>Provides Parameter Info</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.AppletImpl#isProvidesInfoForParameters <em>Provides Info For Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AppletImpl extends ConceptImpl implements Applet {
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
	 * The cached value of the '{@link #getExtendsApplet() <em>Extends Applet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendsApplet()
	 * @generated
	 * @ordered
	 */
	protected ExtendsApplet extendsApplet;

	/**
	 * The cached value of the '{@link #getOverridesLifecycleMethods() <em>Overrides Lifecycle Methods</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridesLifecycleMethods()
	 * @generated
	 * @ordered
	 */
	protected OverridesLifecycleMethods overridesLifecycleMethods;

	/**
	 * The cached value of the '{@link #getShowsStatus() <em>Shows Status</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowsStatus()
	 * @generated
	 * @ordered
	 */
	protected EList<ShowsStatus> showsStatus;

	/**
	 * The cached value of the '{@link #getRegistersMouseListener() <em>Registers Mouse Listener</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersMouseListener()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistersMouseListener> registersMouseListener;

	/**
	 * The cached value of the '{@link #getRegistersMouseMotionListener() <em>Registers Mouse Motion Listener</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersMouseMotionListener()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistersMouseMotionListener> registersMouseMotionListener;

	/**
	 * The cached value of the '{@link #getRegistersKeyListener() <em>Registers Key Listener</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegistersKeyListener()
	 * @generated
	 * @ordered
	 */
	protected EList<RegistersKeyListener> registersKeyListener;

	/**
	 * The cached value of the '{@link #getThread() <em>Thread</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThread()
	 * @generated
	 * @ordered
	 */
	protected EList<ca.uwaterloo.gsd.applet.Thread> thread;

	/**
	 * The cached value of the '{@link #getSingleTaskThread() <em>Single Task Thread</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleTaskThread()
	 * @generated
	 * @ordered
	 */
	protected EList<SingleTaskThread> singleTaskThread;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameter;

	/**
	 * The default value of the '{@link #isProvidesParameterInfo() <em>Provides Parameter Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProvidesParameterInfo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROVIDES_PARAMETER_INFO_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isProvidesParameterInfo() <em>Provides Parameter Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProvidesParameterInfo()
	 * @generated
	 * @ordered
	 */
	protected boolean providesParameterInfo = PROVIDES_PARAMETER_INFO_EDEFAULT;

	/**
	 * The default value of the '{@link #isProvidesInfoForParameters() <em>Provides Info For Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProvidesInfoForParameters()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROVIDES_INFO_FOR_PARAMETERS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isProvidesInfoForParameters() <em>Provides Info For Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProvidesInfoForParameters()
	 * @generated
	 * @ordered
	 */
	protected boolean providesInfoForParameters = PROVIDES_INFO_FOR_PARAMETERS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppletImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.APPLET;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.APPLET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsApplet getExtendsApplet() {
		return extendsApplet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendsApplet(ExtendsApplet newExtendsApplet, NotificationChain msgs) {
		ExtendsApplet oldExtendsApplet = extendsApplet;
		extendsApplet = newExtendsApplet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.APPLET__EXTENDS_APPLET, oldExtendsApplet, newExtendsApplet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendsApplet(ExtendsApplet newExtendsApplet) {
		if (newExtendsApplet != extendsApplet) {
			NotificationChain msgs = null;
			if (extendsApplet != null)
				msgs = ((InternalEObject)extendsApplet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.APPLET__EXTENDS_APPLET, null, msgs);
			if (newExtendsApplet != null)
				msgs = ((InternalEObject)newExtendsApplet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.APPLET__EXTENDS_APPLET, null, msgs);
			msgs = basicSetExtendsApplet(newExtendsApplet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.APPLET__EXTENDS_APPLET, newExtendsApplet, newExtendsApplet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverridesLifecycleMethods getOverridesLifecycleMethods() {
		return overridesLifecycleMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOverridesLifecycleMethods(OverridesLifecycleMethods newOverridesLifecycleMethods, NotificationChain msgs) {
		OverridesLifecycleMethods oldOverridesLifecycleMethods = overridesLifecycleMethods;
		overridesLifecycleMethods = newOverridesLifecycleMethods;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS, oldOverridesLifecycleMethods, newOverridesLifecycleMethods);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverridesLifecycleMethods(OverridesLifecycleMethods newOverridesLifecycleMethods) {
		if (newOverridesLifecycleMethods != overridesLifecycleMethods) {
			NotificationChain msgs = null;
			if (overridesLifecycleMethods != null)
				msgs = ((InternalEObject)overridesLifecycleMethods).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS, null, msgs);
			if (newOverridesLifecycleMethods != null)
				msgs = ((InternalEObject)newOverridesLifecycleMethods).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS, null, msgs);
			msgs = basicSetOverridesLifecycleMethods(newOverridesLifecycleMethods, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS, newOverridesLifecycleMethods, newOverridesLifecycleMethods));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ShowsStatus> getShowsStatus() {
		if (showsStatus == null) {
			showsStatus = new EObjectContainmentEList<ShowsStatus>(ShowsStatus.class, this, AppletPackage.APPLET__SHOWS_STATUS);
		}
		return showsStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistersMouseListener> getRegistersMouseListener() {
		if (registersMouseListener == null) {
			registersMouseListener = new EObjectContainmentEList<RegistersMouseListener>(RegistersMouseListener.class, this, AppletPackage.APPLET__REGISTERS_MOUSE_LISTENER);
		}
		return registersMouseListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistersMouseMotionListener> getRegistersMouseMotionListener() {
		if (registersMouseMotionListener == null) {
			registersMouseMotionListener = new EObjectContainmentEList<RegistersMouseMotionListener>(RegistersMouseMotionListener.class, this, AppletPackage.APPLET__REGISTERS_MOUSE_MOTION_LISTENER);
		}
		return registersMouseMotionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RegistersKeyListener> getRegistersKeyListener() {
		if (registersKeyListener == null) {
			registersKeyListener = new EObjectContainmentEList<RegistersKeyListener>(RegistersKeyListener.class, this, AppletPackage.APPLET__REGISTERS_KEY_LISTENER);
		}
		return registersKeyListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ca.uwaterloo.gsd.applet.Thread> getThread() {
		if (thread == null) {
			thread = new EObjectContainmentEList<ca.uwaterloo.gsd.applet.Thread>(ca.uwaterloo.gsd.applet.Thread.class, this, AppletPackage.APPLET__THREAD);
		}
		return thread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SingleTaskThread> getSingleTaskThread() {
		if (singleTaskThread == null) {
			singleTaskThread = new EObjectContainmentEList<SingleTaskThread>(SingleTaskThread.class, this, AppletPackage.APPLET__SINGLE_TASK_THREAD);
		}
		return singleTaskThread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, AppletPackage.APPLET__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProvidesParameterInfo() {
		return providesParameterInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidesParameterInfo(boolean newProvidesParameterInfo) {
		boolean oldProvidesParameterInfo = providesParameterInfo;
		providesParameterInfo = newProvidesParameterInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.APPLET__PROVIDES_PARAMETER_INFO, oldProvidesParameterInfo, providesParameterInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProvidesInfoForParameters() {
		return providesInfoForParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidesInfoForParameters(boolean newProvidesInfoForParameters) {
		boolean oldProvidesInfoForParameters = providesInfoForParameters;
		providesInfoForParameters = newProvidesInfoForParameters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.APPLET__PROVIDES_INFO_FOR_PARAMETERS, oldProvidesInfoForParameters, providesInfoForParameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppletPackage.APPLET__EXTENDS_APPLET:
				return basicSetExtendsApplet(null, msgs);
			case AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS:
				return basicSetOverridesLifecycleMethods(null, msgs);
			case AppletPackage.APPLET__SHOWS_STATUS:
				return ((InternalEList<?>)getShowsStatus()).basicRemove(otherEnd, msgs);
			case AppletPackage.APPLET__REGISTERS_MOUSE_LISTENER:
				return ((InternalEList<?>)getRegistersMouseListener()).basicRemove(otherEnd, msgs);
			case AppletPackage.APPLET__REGISTERS_MOUSE_MOTION_LISTENER:
				return ((InternalEList<?>)getRegistersMouseMotionListener()).basicRemove(otherEnd, msgs);
			case AppletPackage.APPLET__REGISTERS_KEY_LISTENER:
				return ((InternalEList<?>)getRegistersKeyListener()).basicRemove(otherEnd, msgs);
			case AppletPackage.APPLET__THREAD:
				return ((InternalEList<?>)getThread()).basicRemove(otherEnd, msgs);
			case AppletPackage.APPLET__SINGLE_TASK_THREAD:
				return ((InternalEList<?>)getSingleTaskThread()).basicRemove(otherEnd, msgs);
			case AppletPackage.APPLET__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case AppletPackage.APPLET__NAME:
				return getName();
			case AppletPackage.APPLET__EXTENDS_APPLET:
				return getExtendsApplet();
			case AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS:
				return getOverridesLifecycleMethods();
			case AppletPackage.APPLET__SHOWS_STATUS:
				return getShowsStatus();
			case AppletPackage.APPLET__REGISTERS_MOUSE_LISTENER:
				return getRegistersMouseListener();
			case AppletPackage.APPLET__REGISTERS_MOUSE_MOTION_LISTENER:
				return getRegistersMouseMotionListener();
			case AppletPackage.APPLET__REGISTERS_KEY_LISTENER:
				return getRegistersKeyListener();
			case AppletPackage.APPLET__THREAD:
				return getThread();
			case AppletPackage.APPLET__SINGLE_TASK_THREAD:
				return getSingleTaskThread();
			case AppletPackage.APPLET__PARAMETER:
				return getParameter();
			case AppletPackage.APPLET__PROVIDES_PARAMETER_INFO:
				return isProvidesParameterInfo() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.APPLET__PROVIDES_INFO_FOR_PARAMETERS:
				return isProvidesInfoForParameters() ? Boolean.TRUE : Boolean.FALSE;
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
			case AppletPackage.APPLET__NAME:
				setName((String)newValue);
				return;
			case AppletPackage.APPLET__EXTENDS_APPLET:
				setExtendsApplet((ExtendsApplet)newValue);
				return;
			case AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS:
				setOverridesLifecycleMethods((OverridesLifecycleMethods)newValue);
				return;
			case AppletPackage.APPLET__SHOWS_STATUS:
				getShowsStatus().clear();
				getShowsStatus().addAll((Collection<? extends ShowsStatus>)newValue);
				return;
			case AppletPackage.APPLET__REGISTERS_MOUSE_LISTENER:
				getRegistersMouseListener().clear();
				getRegistersMouseListener().addAll((Collection<? extends RegistersMouseListener>)newValue);
				return;
			case AppletPackage.APPLET__REGISTERS_MOUSE_MOTION_LISTENER:
				getRegistersMouseMotionListener().clear();
				getRegistersMouseMotionListener().addAll((Collection<? extends RegistersMouseMotionListener>)newValue);
				return;
			case AppletPackage.APPLET__REGISTERS_KEY_LISTENER:
				getRegistersKeyListener().clear();
				getRegistersKeyListener().addAll((Collection<? extends RegistersKeyListener>)newValue);
				return;
			case AppletPackage.APPLET__THREAD:
				getThread().clear();
				getThread().addAll((Collection<? extends ca.uwaterloo.gsd.applet.Thread>)newValue);
				return;
			case AppletPackage.APPLET__SINGLE_TASK_THREAD:
				getSingleTaskThread().clear();
				getSingleTaskThread().addAll((Collection<? extends SingleTaskThread>)newValue);
				return;
			case AppletPackage.APPLET__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case AppletPackage.APPLET__PROVIDES_PARAMETER_INFO:
				setProvidesParameterInfo(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.APPLET__PROVIDES_INFO_FOR_PARAMETERS:
				setProvidesInfoForParameters(((Boolean)newValue).booleanValue());
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
			case AppletPackage.APPLET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AppletPackage.APPLET__EXTENDS_APPLET:
				setExtendsApplet((ExtendsApplet)null);
				return;
			case AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS:
				setOverridesLifecycleMethods((OverridesLifecycleMethods)null);
				return;
			case AppletPackage.APPLET__SHOWS_STATUS:
				getShowsStatus().clear();
				return;
			case AppletPackage.APPLET__REGISTERS_MOUSE_LISTENER:
				getRegistersMouseListener().clear();
				return;
			case AppletPackage.APPLET__REGISTERS_MOUSE_MOTION_LISTENER:
				getRegistersMouseMotionListener().clear();
				return;
			case AppletPackage.APPLET__REGISTERS_KEY_LISTENER:
				getRegistersKeyListener().clear();
				return;
			case AppletPackage.APPLET__THREAD:
				getThread().clear();
				return;
			case AppletPackage.APPLET__SINGLE_TASK_THREAD:
				getSingleTaskThread().clear();
				return;
			case AppletPackage.APPLET__PARAMETER:
				getParameter().clear();
				return;
			case AppletPackage.APPLET__PROVIDES_PARAMETER_INFO:
				setProvidesParameterInfo(PROVIDES_PARAMETER_INFO_EDEFAULT);
				return;
			case AppletPackage.APPLET__PROVIDES_INFO_FOR_PARAMETERS:
				setProvidesInfoForParameters(PROVIDES_INFO_FOR_PARAMETERS_EDEFAULT);
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
			case AppletPackage.APPLET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AppletPackage.APPLET__EXTENDS_APPLET:
				return extendsApplet != null;
			case AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS:
				return overridesLifecycleMethods != null;
			case AppletPackage.APPLET__SHOWS_STATUS:
				return showsStatus != null && !showsStatus.isEmpty();
			case AppletPackage.APPLET__REGISTERS_MOUSE_LISTENER:
				return registersMouseListener != null && !registersMouseListener.isEmpty();
			case AppletPackage.APPLET__REGISTERS_MOUSE_MOTION_LISTENER:
				return registersMouseMotionListener != null && !registersMouseMotionListener.isEmpty();
			case AppletPackage.APPLET__REGISTERS_KEY_LISTENER:
				return registersKeyListener != null && !registersKeyListener.isEmpty();
			case AppletPackage.APPLET__THREAD:
				return thread != null && !thread.isEmpty();
			case AppletPackage.APPLET__SINGLE_TASK_THREAD:
				return singleTaskThread != null && !singleTaskThread.isEmpty();
			case AppletPackage.APPLET__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case AppletPackage.APPLET__PROVIDES_PARAMETER_INFO:
				return providesParameterInfo != PROVIDES_PARAMETER_INFO_EDEFAULT;
			case AppletPackage.APPLET__PROVIDES_INFO_FOR_PARAMETERS:
				return providesInfoForParameters != PROVIDES_INFO_FOR_PARAMETERS_EDEFAULT;
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
		result.append(", providesParameterInfo: ");
		result.append(providesParameterInfo);
		result.append(", providesInfoForParameters: ");
		result.append(providesInfoForParameters);
		result.append(')');
		return result.toString();
	}

} //AppletImpl
