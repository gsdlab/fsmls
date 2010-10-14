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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.applet.AppletPackage
 * @generated
 */
public interface AppletFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AppletFactory eINSTANCE = ca.uwaterloo.gsd.applet.impl.AppletFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	AppletModel createAppletModel();

	/**
	 * Returns a new object of class '<em>Applet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Applet</em>'.
	 * @generated
	 */
	Applet createApplet();

	/**
	 * Returns a new object of class '<em>Overrides Lifecycle Methods</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Overrides Lifecycle Methods</em>'.
	 * @generated
	 */
	OverridesLifecycleMethods createOverridesLifecycleMethods();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Extends Applet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Applet</em>'.
	 * @generated
	 */
	ExtendsApplet createExtendsApplet();

	/**
	 * Returns a new object of class '<em>Registers Mouse Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registers Mouse Listener</em>'.
	 * @generated
	 */
	RegistersMouseListener createRegistersMouseListener();

	/**
	 * Returns a new object of class '<em>Registers Mouse Motion Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registers Mouse Motion Listener</em>'.
	 * @generated
	 */
	RegistersMouseMotionListener createRegistersMouseMotionListener();

	/**
	 * Returns a new object of class '<em>Registers Key Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registers Key Listener</em>'.
	 * @generated
	 */
	RegistersKeyListener createRegistersKeyListener();

	/**
	 * Returns a new object of class '<em>This Mouse Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This Mouse Listener</em>'.
	 * @generated
	 */
	ThisMouseListener createThisMouseListener();

	/**
	 * Returns a new object of class '<em>This Mouse Motion Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This Mouse Motion Listener</em>'.
	 * @generated
	 */
	ThisMouseMotionListener createThisMouseMotionListener();

	/**
	 * Returns a new object of class '<em>This Key Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This Key Listener</em>'.
	 * @generated
	 */
	ThisKeyListener createThisKeyListener();

	/**
	 * Returns a new object of class '<em>Deregisters This</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deregisters This</em>'.
	 * @generated
	 */
	DeregistersThis createDeregistersThis();

	/**
	 * Returns a new object of class '<em>Mouse Listener Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Listener Field</em>'.
	 * @generated
	 */
	MouseListenerField createMouseListenerField();

	/**
	 * Returns a new object of class '<em>Mouse Motion Listener Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Motion Listener Field</em>'.
	 * @generated
	 */
	MouseMotionListenerField createMouseMotionListenerField();

	/**
	 * Returns a new object of class '<em>Key Listener Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Listener Field</em>'.
	 * @generated
	 */
	KeyListenerField createKeyListenerField();

	/**
	 * Returns a new object of class '<em>Thread</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Thread</em>'.
	 * @generated
	 */
	ca.uwaterloo.gsd.applet.Thread createThread();

	/**
	 * Returns a new object of class '<em>Initializes Thread</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initializes Thread</em>'.
	 * @generated
	 */
	InitializesThread createInitializesThread();

	/**
	 * Returns a new object of class '<em>Initializes Thread With</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initializes Thread With</em>'.
	 * @generated
	 */
	InitializesThreadWith createInitializesThreadWith();

	/**
	 * Returns a new object of class '<em>Initializes Thread Subclass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initializes Thread Subclass</em>'.
	 * @generated
	 */
	InitializesThreadSubclass createInitializesThreadSubclass();

	/**
	 * Returns a new object of class '<em>This Runnable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This Runnable</em>'.
	 * @generated
	 */
	ThisRunnable createThisRunnable();

	/**
	 * Returns a new object of class '<em>Runnable Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Runnable Field</em>'.
	 * @generated
	 */
	RunnableField createRunnableField();

	/**
	 * Returns a new object of class '<em>Deregisters Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deregisters Field</em>'.
	 * @generated
	 */
	DeregistersField createDeregistersField();

	/**
	 * Returns a new object of class '<em>Shows Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shows Status</em>'.
	 * @generated
	 */
	ShowsStatus createShowsStatus();

	/**
	 * Returns a new object of class '<em>Single Task Thread</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Task Thread</em>'.
	 * @generated
	 */
	SingleTaskThread createSingleTaskThread();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AppletPackage getAppletPackage();

} //AppletFactory
