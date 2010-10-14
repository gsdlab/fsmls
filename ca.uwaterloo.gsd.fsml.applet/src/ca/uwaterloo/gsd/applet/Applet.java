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
package ca.uwaterloo.gsd.applet;

import org.eclipse.emf.common.util.EList;

import ca.uwaterloo.gsd.fsml.fsml.Concept;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Applet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getName <em>Name</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getExtendsApplet <em>Extends Applet</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getOverridesLifecycleMethods <em>Overrides Lifecycle Methods</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getShowsStatus <em>Shows Status</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getRegistersMouseListener <em>Registers Mouse Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getRegistersMouseMotionListener <em>Registers Mouse Motion Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getRegistersKeyListener <em>Registers Key Listener</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getThread <em>Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getSingleTaskThread <em>Single Task Thread</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#getParameter <em>Parameter</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#isProvidesParameterInfo <em>Provides Parameter Info</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.Applet#isProvidesInfoForParameters <em>Provides Info For Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet()
 * @model
 * @generated
 */
public interface Applet extends Concept {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Applet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Extends Applet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends Applet</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends Applet</em>' containment reference.
	 * @see #setExtendsApplet(ExtendsApplet)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_ExtendsApplet()
	 * @model containment="true" required="true"
	 *        annotation="extendsClass name='java.applet.Applet' local='true'"
	 *        annotation="subsumedBy feature='extendsJApplet'"
	 * @generated
	 */
	ExtendsApplet getExtendsApplet();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Applet#getExtendsApplet <em>Extends Applet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends Applet</em>' containment reference.
	 * @see #getExtendsApplet()
	 * @generated
	 */
	void setExtendsApplet(ExtendsApplet value);

	/**
	 * Returns the value of the '<em><b>Overrides Lifecycle Methods</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overrides Required Methods</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrides Lifecycle Methods</em>' containment reference.
	 * @see #setOverridesLifecycleMethods(OverridesLifecycleMethods)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_OverridesLifecycleMethods()
	 * @model containment="true"
	 * @generated
	 */
	OverridesLifecycleMethods getOverridesLifecycleMethods();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Applet#getOverridesLifecycleMethods <em>Overrides Lifecycle Methods</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overrides Lifecycle Methods</em>' containment reference.
	 * @see #getOverridesLifecycleMethods()
	 * @generated
	 */
	void setOverridesLifecycleMethods(OverridesLifecycleMethods value);

	/**
	 * Returns the value of the '<em><b>Shows Status</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.applet.ShowsStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shows Status</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shows Status</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_ShowsStatus()
	 * @model containment="true"
	 *        annotation="callsReceived class='java.applet.Applet' name='showStatus' signature='(Ljava.lang.String;)V' locationName='init' position='after'"
	 * @generated
	 */
	EList<ShowsStatus> getShowsStatus();

	/**
	 * Returns the value of the '<em><b>Registers Mouse Listener</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.applet.RegistersMouseListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers Mouse Listener</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers Mouse Listener</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_RegistersMouseListener()
	 * @model containment="true"
	 *        annotation="methodCalls class='java.awt.Component' name='addMouseListener' signature='(Ljava.awt.event.MouseListener;)V' in='hierarchy' locationName='init' position='after'"
	 * @generated
	 */
	EList<RegistersMouseListener> getRegistersMouseListener();

	/**
	 * Returns the value of the '<em><b>Registers Mouse Motion Listener</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers Mouse Motion Listener</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers Mouse Motion Listener</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_RegistersMouseMotionListener()
	 * @model containment="true"
	 *        annotation="methodCalls class='java.awt.Component' name='addMouseMotionListener' signature='(Ljava.awt.event.MouseMotionListener;)V' in='hierarchy' locationName='init' position='after'"
	 * @generated
	 */
	EList<RegistersMouseMotionListener> getRegistersMouseMotionListener();

	/**
	 * Returns the value of the '<em><b>Registers Key Listener</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.applet.RegistersKeyListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registers Key Listener</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registers Key Listener</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_RegistersKeyListener()
	 * @model containment="true"
	 *        annotation="methodCalls class='java.awt.Component' name='addKeyListener' signature='(Ljava.awt.event.KeyListener;)V' in='hierarchy' locationName='init' position='after'"
	 * @generated
	 */
	EList<RegistersKeyListener> getRegistersKeyListener();

	/**
	 * Returns the value of the '<em><b>Thread</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.applet.Thread}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_Thread()
	 * @model containment="true"
	 * @generated
	 */
	EList<ca.uwaterloo.gsd.applet.Thread> getThread();

	/**
	 * Returns the value of the '<em><b>Single Task Thread</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.applet.SingleTaskThread}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Single Task Thread</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Single Task Thread</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_SingleTaskThread()
	 * @model containment="true"
	 *        annotation="methodCalls class='java.lang.Thread' signature='(Ljava.lang.Runnable;)V' in='hierarchy' locationName='init' position='after' statement='true'"
	 * @generated
	 */
	EList<SingleTaskThread> getSingleTaskThread();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link ca.uwaterloo.gsd.applet.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_Parameter()
	 * @model containment="true"
	 *        annotation="callsReceived class='java.applet.Applet' name='getParameter' signature='(Ljava.lang.String;)Ljava.lang.String;' locationName='init'"
	 * @generated
	 */
	EList<Parameter> getParameter();

	/**
	 * Returns the value of the '<em><b>Provides Parameter Info</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provides Parameter Info</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provides Parameter Info</em>' attribute.
	 * @see #setProvidesParameterInfo(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_ProvidesParameterInfo()
	 * @model default="true"
	 *        annotation="methods name='getParameterInfo' signature='()[[Ljava.lang.String;' inherited='false'"
	 * @generated
	 */
	boolean isProvidesParameterInfo();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Applet#isProvidesParameterInfo <em>Provides Parameter Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provides Parameter Info</em>' attribute.
	 * @see #isProvidesParameterInfo()
	 * @generated
	 */
	void setProvidesParameterInfo(boolean value);

	/**
	 * Returns the value of the '<em><b>Provides Info For Parameters</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provides Info For Parameters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provides Info For Parameters</em>' attribute.
	 * @see #setProvidesInfoForParameters(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getApplet_ProvidesInfoForParameters()
	 * @model default="true" required="true"
	 *        annotation="constraint feature='../parameter' requires='../providesParameterInfo'"
	 * @generated
	 */
	boolean isProvidesInfoForParameters();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.Applet#isProvidesInfoForParameters <em>Provides Info For Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provides Info For Parameters</em>' attribute.
	 * @see #isProvidesInfoForParameters()
	 * @generated
	 */
	void setProvidesInfoForParameters(boolean value);

} // Applet
