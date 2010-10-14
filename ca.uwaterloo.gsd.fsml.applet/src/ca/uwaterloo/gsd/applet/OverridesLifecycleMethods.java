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
 * $Id: OverridesLifecycleMethods.java,v 1.3 2008/04/10 20:33:14 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Overrides Lifecycle Methods</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isInit <em>Init</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isStart <em>Start</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isPaint <em>Paint</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isStop <em>Stop</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isDestroy <em>Destroy</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getOverridesLifecycleMethods()
 * @model annotation="featureGroup lowerBound='1' upperBound='5' essential='true'"
 * @generated
 */
public interface OverridesLifecycleMethods extends Concept {
	/**
	 * Returns the value of the '<em><b>Init</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init</em>' attribute.
	 * @see #setInit(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getOverridesLifecycleMethods_Init()
	 * @model annotation="methods name='init' signature='()V' inherited='false'"
	 * @generated
	 */
	boolean isInit();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isInit <em>Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' attribute.
	 * @see #isInit()
	 * @generated
	 */
	void setInit(boolean value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getOverridesLifecycleMethods_Start()
	 * @model annotation="methods name='start' signature='()V' inherited='false'"
	 * @generated
	 */
	boolean isStart();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #isStart()
	 * @generated
	 */
	void setStart(boolean value);

	/**
	 * Returns the value of the '<em><b>Paint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paint</em>' attribute.
	 * @see #setPaint(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getOverridesLifecycleMethods_Paint()
	 * @model annotation="methods name='paint' signature='(Ljava.awt.Graphics;)V' inherited='false'"
	 * @generated
	 */
	boolean isPaint();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isPaint <em>Paint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paint</em>' attribute.
	 * @see #isPaint()
	 * @generated
	 */
	void setPaint(boolean value);

	/**
	 * Returns the value of the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop</em>' attribute.
	 * @see #setStop(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getOverridesLifecycleMethods_Stop()
	 * @model annotation="methods name='stop' signature='()V' inherited='false'"
	 * @generated
	 */
	boolean isStop();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isStop <em>Stop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop</em>' attribute.
	 * @see #isStop()
	 * @generated
	 */
	void setStop(boolean value);

	/**
	 * Returns the value of the '<em><b>Destroy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destroy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destroy</em>' attribute.
	 * @see #setDestroy(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getOverridesLifecycleMethods_Destroy()
	 * @model annotation="methods name='destroy' signature='()V' inherited='false'"
	 * @generated
	 */
	boolean isDestroy();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isDestroy <em>Destroy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destroy</em>' attribute.
	 * @see #isDestroy()
	 * @generated
	 */
	void setDestroy(boolean value);

} // OverridesLifecycleMethods
