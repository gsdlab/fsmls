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
 * $Id: OverridesLifecycleMethodsImpl.java,v 1.3 2008/04/10 20:33:15 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.OverridesLifecycleMethods;
import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Overrides Lifecycle Methods</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl#isInit <em>Init</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl#isStart <em>Start</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl#isPaint <em>Paint</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl#isStop <em>Stop</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl#isDestroy <em>Destroy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OverridesLifecycleMethodsImpl extends ConceptImpl implements OverridesLifecycleMethods {
	/**
	 * The default value of the '{@link #isInit() <em>Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInit() <em>Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInit()
	 * @generated
	 * @ordered
	 */
	protected boolean init = INIT_EDEFAULT;

	/**
	 * The default value of the '{@link #isStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStart()
	 * @generated
	 * @ordered
	 */
	protected static final boolean START_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStart()
	 * @generated
	 * @ordered
	 */
	protected boolean start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #isPaint() <em>Paint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PAINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPaint() <em>Paint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaint()
	 * @generated
	 * @ordered
	 */
	protected boolean paint = PAINT_EDEFAULT;

	/**
	 * The default value of the '{@link #isStop() <em>Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STOP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStop() <em>Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStop()
	 * @generated
	 * @ordered
	 */
	protected boolean stop = STOP_EDEFAULT;

	/**
	 * The default value of the '{@link #isDestroy() <em>Destroy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDestroy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DESTROY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDestroy() <em>Destroy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDestroy()
	 * @generated
	 * @ordered
	 */
	protected boolean destroy = DESTROY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OverridesLifecycleMethodsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppletPackage.Literals.OVERRIDES_LIFECYCLE_METHODS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInit() {
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInit(boolean newInit) {
		boolean oldInit = init;
		init = newInit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.OVERRIDES_LIFECYCLE_METHODS__INIT, oldInit, init));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(boolean newStart) {
		boolean oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.OVERRIDES_LIFECYCLE_METHODS__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPaint() {
		return paint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaint(boolean newPaint) {
		boolean oldPaint = paint;
		paint = newPaint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.OVERRIDES_LIFECYCLE_METHODS__PAINT, oldPaint, paint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStop() {
		return stop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStop(boolean newStop) {
		boolean oldStop = stop;
		stop = newStop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.OVERRIDES_LIFECYCLE_METHODS__STOP, oldStop, stop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDestroy() {
		return destroy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestroy(boolean newDestroy) {
		boolean oldDestroy = destroy;
		destroy = newDestroy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppletPackage.OVERRIDES_LIFECYCLE_METHODS__DESTROY, oldDestroy, destroy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__INIT:
				return isInit() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__START:
				return isStart() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__PAINT:
				return isPaint() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__STOP:
				return isStop() ? Boolean.TRUE : Boolean.FALSE;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__DESTROY:
				return isDestroy() ? Boolean.TRUE : Boolean.FALSE;
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
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__INIT:
				setInit(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__START:
				setStart(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__PAINT:
				setPaint(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__STOP:
				setStop(((Boolean)newValue).booleanValue());
				return;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__DESTROY:
				setDestroy(((Boolean)newValue).booleanValue());
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
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__INIT:
				setInit(INIT_EDEFAULT);
				return;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__START:
				setStart(START_EDEFAULT);
				return;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__PAINT:
				setPaint(PAINT_EDEFAULT);
				return;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__STOP:
				setStop(STOP_EDEFAULT);
				return;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__DESTROY:
				setDestroy(DESTROY_EDEFAULT);
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
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__INIT:
				return init != INIT_EDEFAULT;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__START:
				return start != START_EDEFAULT;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__PAINT:
				return paint != PAINT_EDEFAULT;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__STOP:
				return stop != STOP_EDEFAULT;
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__DESTROY:
				return destroy != DESTROY_EDEFAULT;
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
		result.append(" (init: ");
		result.append(init);
		result.append(", start: ");
		result.append(start);
		result.append(", paint: ");
		result.append(paint);
		result.append(", stop: ");
		result.append(stop);
		result.append(", destroy: ");
		result.append(destroy);
		result.append(')');
		return result.toString();
	}

} //OverridesLifecycleMethodsImpl
