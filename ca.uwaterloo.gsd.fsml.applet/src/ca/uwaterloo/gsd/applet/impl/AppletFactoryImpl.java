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
 * $Id: AppletFactoryImpl.java,v 1.15 2008/04/10 20:33:14 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import ca.uwaterloo.gsd.applet.Applet;
import ca.uwaterloo.gsd.applet.AppletFactory;
import ca.uwaterloo.gsd.applet.AppletModel;
import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.DeregistersField;
import ca.uwaterloo.gsd.applet.DeregistersThis;
import ca.uwaterloo.gsd.applet.ExtendsApplet;
import ca.uwaterloo.gsd.applet.InitializesThread;
import ca.uwaterloo.gsd.applet.InitializesThreadSubclass;
import ca.uwaterloo.gsd.applet.InitializesThreadWith;
import ca.uwaterloo.gsd.applet.KeyListenerField;
import ca.uwaterloo.gsd.applet.MouseListenerField;
import ca.uwaterloo.gsd.applet.MouseMotionListenerField;
import ca.uwaterloo.gsd.applet.OverridesLifecycleMethods;
import ca.uwaterloo.gsd.applet.Parameter;
import ca.uwaterloo.gsd.applet.RegistersKeyListener;
import ca.uwaterloo.gsd.applet.RegistersMouseListener;
import ca.uwaterloo.gsd.applet.RegistersMouseMotionListener;
import ca.uwaterloo.gsd.applet.RunnableField;
import ca.uwaterloo.gsd.applet.ShowsStatus;
import ca.uwaterloo.gsd.applet.SingleTaskThread;
import ca.uwaterloo.gsd.applet.ThisKeyListener;
import ca.uwaterloo.gsd.applet.ThisMouseListener;
import ca.uwaterloo.gsd.applet.ThisMouseMotionListener;
import ca.uwaterloo.gsd.applet.ThisRunnable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AppletFactoryImpl extends EFactoryImpl implements AppletFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AppletFactory init() {
		try {
			AppletFactory theAppletFactory = (AppletFactory)EPackage.Registry.INSTANCE.getEFactory("http://ca.uwaterloo.gsd/applet"); 
			if (theAppletFactory != null) {
				return theAppletFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AppletFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppletFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AppletPackage.APPLET_MODEL: return createAppletModel();
			case AppletPackage.APPLET: return createApplet();
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS: return createOverridesLifecycleMethods();
			case AppletPackage.PARAMETER: return createParameter();
			case AppletPackage.EXTENDS_APPLET: return createExtendsApplet();
			case AppletPackage.REGISTERS_MOUSE_LISTENER: return createRegistersMouseListener();
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER: return createRegistersMouseMotionListener();
			case AppletPackage.REGISTERS_KEY_LISTENER: return createRegistersKeyListener();
			case AppletPackage.THIS_MOUSE_LISTENER: return createThisMouseListener();
			case AppletPackage.THIS_MOUSE_MOTION_LISTENER: return createThisMouseMotionListener();
			case AppletPackage.THIS_KEY_LISTENER: return createThisKeyListener();
			case AppletPackage.DEREGISTERS_THIS: return createDeregistersThis();
			case AppletPackage.MOUSE_LISTENER_FIELD: return createMouseListenerField();
			case AppletPackage.MOUSE_MOTION_LISTENER_FIELD: return createMouseMotionListenerField();
			case AppletPackage.KEY_LISTENER_FIELD: return createKeyListenerField();
			case AppletPackage.THREAD: return createThread();
			case AppletPackage.INITIALIZES_THREAD: return createInitializesThread();
			case AppletPackage.INITIALIZES_THREAD_WITH: return createInitializesThreadWith();
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS: return createInitializesThreadSubclass();
			case AppletPackage.THIS_RUNNABLE: return createThisRunnable();
			case AppletPackage.RUNNABLE_FIELD: return createRunnableField();
			case AppletPackage.DEREGISTERS_FIELD: return createDeregistersField();
			case AppletPackage.SHOWS_STATUS: return createShowsStatus();
			case AppletPackage.SINGLE_TASK_THREAD: return createSingleTaskThread();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Applet createApplet() {
		AppletImpl applet = new AppletImpl();
		return applet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverridesLifecycleMethods createOverridesLifecycleMethods() {
		OverridesLifecycleMethodsImpl overridesLifecycleMethods = new OverridesLifecycleMethodsImpl();
		return overridesLifecycleMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsApplet createExtendsApplet() {
		ExtendsAppletImpl extendsApplet = new ExtendsAppletImpl();
		return extendsApplet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersMouseListener createRegistersMouseListener() {
		RegistersMouseListenerImpl registersMouseListener = new RegistersMouseListenerImpl();
		return registersMouseListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersMouseMotionListener createRegistersMouseMotionListener() {
		RegistersMouseMotionListenerImpl registersMouseMotionListener = new RegistersMouseMotionListenerImpl();
		return registersMouseMotionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersKeyListener createRegistersKeyListener() {
		RegistersKeyListenerImpl registersKeyListener = new RegistersKeyListenerImpl();
		return registersKeyListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisMouseListener createThisMouseListener() {
		ThisMouseListenerImpl thisMouseListener = new ThisMouseListenerImpl();
		return thisMouseListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisMouseMotionListener createThisMouseMotionListener() {
		ThisMouseMotionListenerImpl thisMouseMotionListener = new ThisMouseMotionListenerImpl();
		return thisMouseMotionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisKeyListener createThisKeyListener() {
		ThisKeyListenerImpl thisKeyListener = new ThisKeyListenerImpl();
		return thisKeyListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeregistersThis createDeregistersThis() {
		DeregistersThisImpl deregistersThis = new DeregistersThisImpl();
		return deregistersThis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseListenerField createMouseListenerField() {
		MouseListenerFieldImpl mouseListenerField = new MouseListenerFieldImpl();
		return mouseListenerField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseMotionListenerField createMouseMotionListenerField() {
		MouseMotionListenerFieldImpl mouseMotionListenerField = new MouseMotionListenerFieldImpl();
		return mouseMotionListenerField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyListenerField createKeyListenerField() {
		KeyListenerFieldImpl keyListenerField = new KeyListenerFieldImpl();
		return keyListenerField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppletModel createAppletModel() {
		AppletModelImpl appletModel = new AppletModelImpl();
		return appletModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ca.uwaterloo.gsd.applet.Thread createThread() {
		ThreadImpl thread = new ThreadImpl();
		return thread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializesThread createInitializesThread() {
		InitializesThreadImpl initializesThread = new InitializesThreadImpl();
		return initializesThread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializesThreadWith createInitializesThreadWith() {
		InitializesThreadWithImpl initializesThreadWith = new InitializesThreadWithImpl();
		return initializesThreadWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializesThreadSubclass createInitializesThreadSubclass() {
		InitializesThreadSubclassImpl initializesThreadSubclass = new InitializesThreadSubclassImpl();
		return initializesThreadSubclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisRunnable createThisRunnable() {
		ThisRunnableImpl thisRunnable = new ThisRunnableImpl();
		return thisRunnable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunnableField createRunnableField() {
		RunnableFieldImpl runnableField = new RunnableFieldImpl();
		return runnableField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeregistersField createDeregistersField() {
		DeregistersFieldImpl deregistersField = new DeregistersFieldImpl();
		return deregistersField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShowsStatus createShowsStatus() {
		ShowsStatusImpl showsStatus = new ShowsStatusImpl();
		return showsStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleTaskThread createSingleTaskThread() {
		SingleTaskThreadImpl singleTaskThread = new SingleTaskThreadImpl();
		return singleTaskThread;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppletPackage getAppletPackage() {
		return (AppletPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AppletPackage getPackage() {
		return AppletPackage.eINSTANCE;
	}

} //AppletFactoryImpl
