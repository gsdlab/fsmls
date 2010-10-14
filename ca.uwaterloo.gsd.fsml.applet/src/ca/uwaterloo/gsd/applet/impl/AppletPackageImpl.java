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
 * $Id: AppletPackageImpl.java,v 1.41 2009/04/21 18:26:18 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

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
import ca.uwaterloo.gsd.fsml.fsml.FsmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AppletPackageImpl extends EPackageImpl implements AppletPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appletEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass overridesLifecycleMethodsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsAppletEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registersMouseListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registersMouseMotionListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registersKeyListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thisMouseListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thisMouseMotionListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thisKeyListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deregistersThisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mouseListenerFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mouseMotionListenerFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyListenerFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appletModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initializesThreadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initializesThreadWithEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initializesThreadSubclassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thisRunnableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runnableFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deregistersFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass showsStatusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleTaskThreadEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AppletPackageImpl() {
		super(eNS_URI, AppletFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AppletPackage init() {
		if (isInited) return (AppletPackage)EPackage.Registry.INSTANCE.getEPackage(AppletPackage.eNS_URI);

		// Obtain or create and register package
		AppletPackageImpl theAppletPackage = (AppletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AppletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AppletPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		FsmlPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAppletPackage.createPackageContents();

		// Initialize created meta-data
		theAppletPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAppletPackage.freeze();

		return theAppletPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplet() {
		return appletEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplet_Name() {
		return (EAttribute)appletEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_ExtendsApplet() {
		return (EReference)appletEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_OverridesLifecycleMethods() {
		return (EReference)appletEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_ShowsStatus() {
		return (EReference)appletEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_RegistersMouseListener() {
		return (EReference)appletEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_RegistersMouseMotionListener() {
		return (EReference)appletEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_RegistersKeyListener() {
		return (EReference)appletEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_Thread() {
		return (EReference)appletEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_SingleTaskThread() {
		return (EReference)appletEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplet_Parameter() {
		return (EReference)appletEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplet_ProvidesParameterInfo() {
		return (EAttribute)appletEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplet_ProvidesInfoForParameters() {
		return (EAttribute)appletEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOverridesLifecycleMethods() {
		return overridesLifecycleMethodsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOverridesLifecycleMethods_Init() {
		return (EAttribute)overridesLifecycleMethodsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOverridesLifecycleMethods_Start() {
		return (EAttribute)overridesLifecycleMethodsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOverridesLifecycleMethods_Paint() {
		return (EAttribute)overridesLifecycleMethodsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOverridesLifecycleMethods_Stop() {
		return (EAttribute)overridesLifecycleMethodsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOverridesLifecycleMethods_Destroy() {
		return (EAttribute)overridesLifecycleMethodsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsApplet() {
		return extendsAppletEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsApplet_ExtendsJApplet() {
		return (EAttribute)extendsAppletEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistersMouseListener() {
		return registersMouseListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersMouseListener_This() {
		return (EReference)registersMouseListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersMouseListener_MouseListenerField() {
		return (EReference)registersMouseListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistersMouseMotionListener() {
		return registersMouseMotionListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersMouseMotionListener_This() {
		return (EReference)registersMouseMotionListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersMouseMotionListener_MouseMotionListenerField() {
		return (EReference)registersMouseMotionListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistersKeyListener() {
		return registersKeyListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersKeyListener_This() {
		return (EReference)registersKeyListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersKeyListener_KeyListenerField() {
		return (EReference)registersKeyListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThisMouseListener() {
		return thisMouseListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThisMouseListener_ImplementsMouseListener() {
		return (EAttribute)thisMouseListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThisMouseListener_Deregisters() {
		return (EReference)thisMouseListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThisMouseMotionListener() {
		return thisMouseMotionListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThisMouseMotionListener_ImplementsMouseMotionListener() {
		return (EAttribute)thisMouseMotionListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThisMouseMotionListener_Deregisters() {
		return (EReference)thisMouseMotionListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThisKeyListener() {
		return thisKeyListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThisKeyListener_ImplementsKeyListener() {
		return (EAttribute)thisKeyListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThisKeyListener_Deregisters() {
		return (EReference)thisKeyListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeregistersThis() {
		return deregistersThisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeregistersThis_This() {
		return (EAttribute)deregistersThisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMouseListenerField() {
		return mouseListenerFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseListenerField_ListenerField() {
		return (EAttribute)mouseListenerFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseListenerField_TypedMouseListener() {
		return (EAttribute)mouseListenerFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMouseListenerField_Deregisters() {
		return (EReference)mouseListenerFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseListenerField_Initialized() {
		return (EAttribute)mouseListenerFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMouseMotionListenerField() {
		return mouseMotionListenerFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseMotionListenerField_ListenerField() {
		return (EAttribute)mouseMotionListenerFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseMotionListenerField_TypedMouseMotionListener() {
		return (EAttribute)mouseMotionListenerFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMouseMotionListenerField_Deregisters() {
		return (EReference)mouseMotionListenerFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseMotionListenerField_Initialized() {
		return (EAttribute)mouseMotionListenerFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyListenerField() {
		return keyListenerFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyListenerField_ListenerField() {
		return (EAttribute)keyListenerFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyListenerField_TypedKeyListener() {
		return (EAttribute)keyListenerFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyListenerField_Deregisters() {
		return (EReference)keyListenerFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyListenerField_Initialized() {
		return (EAttribute)keyListenerFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAppletModel() {
		return appletModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppletModel_Applets() {
		return (EReference)appletModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThread() {
		return threadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThread_Thread() {
		return (EAttribute)threadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThread_TypedThread() {
		return (EAttribute)threadEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThread_InitializesThread() {
		return (EReference)threadEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThread_NullifiesThread() {
		return (EAttribute)threadEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitializesThread() {
		return initializesThreadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitializesThread_InitializesThreadWithRunnable() {
		return (EReference)initializesThreadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitializesThread_InitializesWithThreadSubclass() {
		return (EReference)initializesThreadEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitializesThreadWith() {
		return initializesThreadWithEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitializesThreadWith_This() {
		return (EReference)initializesThreadWithEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInitializesThreadWith_Helper() {
		return (EAttribute)initializesThreadWithEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInitializesThreadWith_Variable() {
		return (EAttribute)initializesThreadWithEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitializesThreadWith_RunnableField() {
		return (EReference)initializesThreadWithEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitializesThreadSubclass() {
		return initializesThreadSubclassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInitializesThreadSubclass_Name() {
		return (EAttribute)initializesThreadSubclassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInitializesThreadSubclass_OverriddesRun() {
		return (EAttribute)initializesThreadSubclassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInitializesThreadSubclass_ExtendsThread() {
		return (EAttribute)initializesThreadSubclassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThisRunnable() {
		return thisRunnableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThisRunnable_ImplementsRunnable() {
		return (EAttribute)thisRunnableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRunnableField() {
		return runnableFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunnableField_TypedRunnable() {
		return (EAttribute)runnableFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunnableField_Name() {
		return (EAttribute)runnableFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRunnableField_Initialized() {
		return (EAttribute)runnableFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeregistersField() {
		return deregistersFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeregistersField_Field() {
		return (EAttribute)deregistersFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShowsStatus() {
		return showsStatusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShowsStatus_Message() {
		return (EAttribute)showsStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleTaskThread() {
		return singleTaskThreadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleTaskThread_Runnable() {
		return (EAttribute)singleTaskThreadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleTaskThread_RunnableField() {
		return (EReference)singleTaskThreadEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppletFactory getAppletFactory() {
		return (AppletFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		appletModelEClass = createEClass(APPLET_MODEL);
		createEReference(appletModelEClass, APPLET_MODEL__APPLETS);

		appletEClass = createEClass(APPLET);
		createEAttribute(appletEClass, APPLET__NAME);
		createEReference(appletEClass, APPLET__EXTENDS_APPLET);
		createEReference(appletEClass, APPLET__OVERRIDES_LIFECYCLE_METHODS);
		createEReference(appletEClass, APPLET__SHOWS_STATUS);
		createEReference(appletEClass, APPLET__REGISTERS_MOUSE_LISTENER);
		createEReference(appletEClass, APPLET__REGISTERS_MOUSE_MOTION_LISTENER);
		createEReference(appletEClass, APPLET__REGISTERS_KEY_LISTENER);
		createEReference(appletEClass, APPLET__THREAD);
		createEReference(appletEClass, APPLET__SINGLE_TASK_THREAD);
		createEReference(appletEClass, APPLET__PARAMETER);
		createEAttribute(appletEClass, APPLET__PROVIDES_PARAMETER_INFO);
		createEAttribute(appletEClass, APPLET__PROVIDES_INFO_FOR_PARAMETERS);

		overridesLifecycleMethodsEClass = createEClass(OVERRIDES_LIFECYCLE_METHODS);
		createEAttribute(overridesLifecycleMethodsEClass, OVERRIDES_LIFECYCLE_METHODS__INIT);
		createEAttribute(overridesLifecycleMethodsEClass, OVERRIDES_LIFECYCLE_METHODS__START);
		createEAttribute(overridesLifecycleMethodsEClass, OVERRIDES_LIFECYCLE_METHODS__PAINT);
		createEAttribute(overridesLifecycleMethodsEClass, OVERRIDES_LIFECYCLE_METHODS__STOP);
		createEAttribute(overridesLifecycleMethodsEClass, OVERRIDES_LIFECYCLE_METHODS__DESTROY);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);

		extendsAppletEClass = createEClass(EXTENDS_APPLET);
		createEAttribute(extendsAppletEClass, EXTENDS_APPLET__EXTENDS_JAPPLET);

		registersMouseListenerEClass = createEClass(REGISTERS_MOUSE_LISTENER);
		createEReference(registersMouseListenerEClass, REGISTERS_MOUSE_LISTENER__THIS);
		createEReference(registersMouseListenerEClass, REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD);

		registersMouseMotionListenerEClass = createEClass(REGISTERS_MOUSE_MOTION_LISTENER);
		createEReference(registersMouseMotionListenerEClass, REGISTERS_MOUSE_MOTION_LISTENER__THIS);
		createEReference(registersMouseMotionListenerEClass, REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD);

		registersKeyListenerEClass = createEClass(REGISTERS_KEY_LISTENER);
		createEReference(registersKeyListenerEClass, REGISTERS_KEY_LISTENER__THIS);
		createEReference(registersKeyListenerEClass, REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD);

		thisMouseListenerEClass = createEClass(THIS_MOUSE_LISTENER);
		createEAttribute(thisMouseListenerEClass, THIS_MOUSE_LISTENER__IMPLEMENTS_MOUSE_LISTENER);
		createEReference(thisMouseListenerEClass, THIS_MOUSE_LISTENER__DEREGISTERS);

		thisMouseMotionListenerEClass = createEClass(THIS_MOUSE_MOTION_LISTENER);
		createEAttribute(thisMouseMotionListenerEClass, THIS_MOUSE_MOTION_LISTENER__IMPLEMENTS_MOUSE_MOTION_LISTENER);
		createEReference(thisMouseMotionListenerEClass, THIS_MOUSE_MOTION_LISTENER__DEREGISTERS);

		thisKeyListenerEClass = createEClass(THIS_KEY_LISTENER);
		createEAttribute(thisKeyListenerEClass, THIS_KEY_LISTENER__IMPLEMENTS_KEY_LISTENER);
		createEReference(thisKeyListenerEClass, THIS_KEY_LISTENER__DEREGISTERS);

		deregistersThisEClass = createEClass(DEREGISTERS_THIS);
		createEAttribute(deregistersThisEClass, DEREGISTERS_THIS__THIS);

		mouseListenerFieldEClass = createEClass(MOUSE_LISTENER_FIELD);
		createEAttribute(mouseListenerFieldEClass, MOUSE_LISTENER_FIELD__LISTENER_FIELD);
		createEAttribute(mouseListenerFieldEClass, MOUSE_LISTENER_FIELD__TYPED_MOUSE_LISTENER);
		createEReference(mouseListenerFieldEClass, MOUSE_LISTENER_FIELD__DEREGISTERS);
		createEAttribute(mouseListenerFieldEClass, MOUSE_LISTENER_FIELD__INITIALIZED);

		mouseMotionListenerFieldEClass = createEClass(MOUSE_MOTION_LISTENER_FIELD);
		createEAttribute(mouseMotionListenerFieldEClass, MOUSE_MOTION_LISTENER_FIELD__LISTENER_FIELD);
		createEAttribute(mouseMotionListenerFieldEClass, MOUSE_MOTION_LISTENER_FIELD__TYPED_MOUSE_MOTION_LISTENER);
		createEReference(mouseMotionListenerFieldEClass, MOUSE_MOTION_LISTENER_FIELD__DEREGISTERS);
		createEAttribute(mouseMotionListenerFieldEClass, MOUSE_MOTION_LISTENER_FIELD__INITIALIZED);

		keyListenerFieldEClass = createEClass(KEY_LISTENER_FIELD);
		createEAttribute(keyListenerFieldEClass, KEY_LISTENER_FIELD__LISTENER_FIELD);
		createEAttribute(keyListenerFieldEClass, KEY_LISTENER_FIELD__TYPED_KEY_LISTENER);
		createEReference(keyListenerFieldEClass, KEY_LISTENER_FIELD__DEREGISTERS);
		createEAttribute(keyListenerFieldEClass, KEY_LISTENER_FIELD__INITIALIZED);

		threadEClass = createEClass(THREAD);
		createEAttribute(threadEClass, THREAD__THREAD);
		createEAttribute(threadEClass, THREAD__TYPED_THREAD);
		createEReference(threadEClass, THREAD__INITIALIZES_THREAD);
		createEAttribute(threadEClass, THREAD__NULLIFIES_THREAD);

		initializesThreadEClass = createEClass(INITIALIZES_THREAD);
		createEReference(initializesThreadEClass, INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE);
		createEReference(initializesThreadEClass, INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS);

		initializesThreadWithEClass = createEClass(INITIALIZES_THREAD_WITH);
		createEReference(initializesThreadWithEClass, INITIALIZES_THREAD_WITH__THIS);
		createEAttribute(initializesThreadWithEClass, INITIALIZES_THREAD_WITH__HELPER);
		createEAttribute(initializesThreadWithEClass, INITIALIZES_THREAD_WITH__VARIABLE);
		createEReference(initializesThreadWithEClass, INITIALIZES_THREAD_WITH__RUNNABLE_FIELD);

		initializesThreadSubclassEClass = createEClass(INITIALIZES_THREAD_SUBCLASS);
		createEAttribute(initializesThreadSubclassEClass, INITIALIZES_THREAD_SUBCLASS__NAME);
		createEAttribute(initializesThreadSubclassEClass, INITIALIZES_THREAD_SUBCLASS__OVERRIDDES_RUN);
		createEAttribute(initializesThreadSubclassEClass, INITIALIZES_THREAD_SUBCLASS__EXTENDS_THREAD);

		thisRunnableEClass = createEClass(THIS_RUNNABLE);
		createEAttribute(thisRunnableEClass, THIS_RUNNABLE__IMPLEMENTS_RUNNABLE);

		runnableFieldEClass = createEClass(RUNNABLE_FIELD);
		createEAttribute(runnableFieldEClass, RUNNABLE_FIELD__TYPED_RUNNABLE);
		createEAttribute(runnableFieldEClass, RUNNABLE_FIELD__NAME);
		createEAttribute(runnableFieldEClass, RUNNABLE_FIELD__INITIALIZED);

		deregistersFieldEClass = createEClass(DEREGISTERS_FIELD);
		createEAttribute(deregistersFieldEClass, DEREGISTERS_FIELD__FIELD);

		showsStatusEClass = createEClass(SHOWS_STATUS);
		createEAttribute(showsStatusEClass, SHOWS_STATUS__MESSAGE);

		singleTaskThreadEClass = createEClass(SINGLE_TASK_THREAD);
		createEAttribute(singleTaskThreadEClass, SINGLE_TASK_THREAD__RUNNABLE);
		createEReference(singleTaskThreadEClass, SINGLE_TASK_THREAD__RUNNABLE_FIELD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		FsmlPackage theFsmlPackage = (FsmlPackage)EPackage.Registry.INSTANCE.getEPackage(FsmlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		appletModelEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		appletModelEClass.getESuperTypes().add(theFsmlPackage.getModel());
		appletEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		overridesLifecycleMethodsEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		parameterEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		extendsAppletEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		registersMouseListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		registersMouseMotionListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		registersKeyListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		thisMouseListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		thisMouseMotionListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		thisKeyListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		deregistersThisEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		mouseListenerFieldEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		mouseMotionListenerFieldEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		keyListenerFieldEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		threadEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		initializesThreadWithEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		thisRunnableEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		runnableFieldEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		deregistersFieldEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		showsStatusEClass.getESuperTypes().add(theFsmlPackage.getConcept());

		// Initialize classes and features; add operations and parameters
		initEClass(appletModelEClass, AppletModel.class, "AppletModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAppletModel_Applets(), this.getApplet(), null, "applets", null, 0, -1, AppletModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(appletEClass, Applet.class, "Applet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApplet_Name(), ecorePackage.getEString(), "name", null, 1, 1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_ExtendsApplet(), this.getExtendsApplet(), null, "extendsApplet", null, 1, 1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_OverridesLifecycleMethods(), this.getOverridesLifecycleMethods(), null, "overridesLifecycleMethods", null, 0, 1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_ShowsStatus(), this.getShowsStatus(), null, "showsStatus", null, 0, -1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_RegistersMouseListener(), this.getRegistersMouseListener(), null, "registersMouseListener", null, 0, -1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_RegistersMouseMotionListener(), this.getRegistersMouseMotionListener(), null, "registersMouseMotionListener", null, 0, -1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_RegistersKeyListener(), this.getRegistersKeyListener(), null, "registersKeyListener", null, 0, -1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_Thread(), this.getThread(), null, "thread", null, 0, -1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_SingleTaskThread(), this.getSingleTaskThread(), null, "singleTaskThread", null, 0, -1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplet_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplet_ProvidesParameterInfo(), ecorePackage.getEBoolean(), "providesParameterInfo", "true", 0, 1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplet_ProvidesInfoForParameters(), ecorePackage.getEBoolean(), "providesInfoForParameters", "true", 1, 1, Applet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(overridesLifecycleMethodsEClass, OverridesLifecycleMethods.class, "OverridesLifecycleMethods", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOverridesLifecycleMethods_Init(), ecorePackage.getEBoolean(), "init", null, 0, 1, OverridesLifecycleMethods.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOverridesLifecycleMethods_Start(), ecorePackage.getEBoolean(), "start", null, 0, 1, OverridesLifecycleMethods.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOverridesLifecycleMethods_Paint(), ecorePackage.getEBoolean(), "paint", null, 0, 1, OverridesLifecycleMethods.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOverridesLifecycleMethods_Stop(), ecorePackage.getEBoolean(), "stop", null, 0, 1, OverridesLifecycleMethods.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOverridesLifecycleMethods_Destroy(), ecorePackage.getEBoolean(), "destroy", null, 0, 1, OverridesLifecycleMethods.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, -1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsAppletEClass, ExtendsApplet.class, "ExtendsApplet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsApplet_ExtendsJApplet(), ecorePackage.getEBoolean(), "extendsJApplet", null, 0, 1, ExtendsApplet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registersMouseListenerEClass, RegistersMouseListener.class, "RegistersMouseListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistersMouseListener_This(), this.getThisMouseListener(), null, "this", null, 0, 1, RegistersMouseListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegistersMouseListener_MouseListenerField(), this.getMouseListenerField(), null, "mouseListenerField", null, 0, 1, RegistersMouseListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registersMouseMotionListenerEClass, RegistersMouseMotionListener.class, "RegistersMouseMotionListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistersMouseMotionListener_This(), this.getThisMouseMotionListener(), null, "this", null, 0, 1, RegistersMouseMotionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegistersMouseMotionListener_MouseMotionListenerField(), this.getMouseMotionListenerField(), null, "mouseMotionListenerField", null, 0, 1, RegistersMouseMotionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registersKeyListenerEClass, RegistersKeyListener.class, "RegistersKeyListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistersKeyListener_This(), this.getThisKeyListener(), null, "this", null, 0, 1, RegistersKeyListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegistersKeyListener_KeyListenerField(), this.getKeyListenerField(), null, "keyListenerField", null, 0, 1, RegistersKeyListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thisMouseListenerEClass, ThisMouseListener.class, "ThisMouseListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThisMouseListener_ImplementsMouseListener(), ecorePackage.getEBoolean(), "implementsMouseListener", "true", 1, 1, ThisMouseListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThisMouseListener_Deregisters(), this.getDeregistersThis(), null, "deregisters", null, 1, 1, ThisMouseListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thisMouseMotionListenerEClass, ThisMouseMotionListener.class, "ThisMouseMotionListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThisMouseMotionListener_ImplementsMouseMotionListener(), ecorePackage.getEBoolean(), "implementsMouseMotionListener", "true", 1, 1, ThisMouseMotionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThisMouseMotionListener_Deregisters(), this.getDeregistersThis(), null, "deregisters", null, 1, 1, ThisMouseMotionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thisKeyListenerEClass, ThisKeyListener.class, "ThisKeyListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThisKeyListener_ImplementsKeyListener(), ecorePackage.getEBoolean(), "implementsKeyListener", "true", 1, 1, ThisKeyListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThisKeyListener_Deregisters(), this.getDeregistersThis(), null, "deregisters", null, 1, 1, ThisKeyListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deregistersThisEClass, DeregistersThis.class, "DeregistersThis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeregistersThis_This(), ecorePackage.getEBoolean(), "this", "true", 1, 1, DeregistersThis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mouseListenerFieldEClass, MouseListenerField.class, "MouseListenerField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMouseListenerField_ListenerField(), ecorePackage.getEString(), "listenerField", null, 1, 1, MouseListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseListenerField_TypedMouseListener(), ecorePackage.getEBoolean(), "typedMouseListener", "true", 1, 1, MouseListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMouseListenerField_Deregisters(), this.getDeregistersField(), null, "deregisters", null, 1, 1, MouseListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseListenerField_Initialized(), ecorePackage.getEBoolean(), "initialized", "true", 1, 1, MouseListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mouseMotionListenerFieldEClass, MouseMotionListenerField.class, "MouseMotionListenerField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMouseMotionListenerField_ListenerField(), ecorePackage.getEString(), "listenerField", null, 1, 1, MouseMotionListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseMotionListenerField_TypedMouseMotionListener(), ecorePackage.getEBoolean(), "typedMouseMotionListener", "true", 1, 1, MouseMotionListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMouseMotionListenerField_Deregisters(), this.getDeregistersField(), null, "deregisters", null, 1, 1, MouseMotionListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseMotionListenerField_Initialized(), ecorePackage.getEBoolean(), "initialized", "true", 1, 1, MouseMotionListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyListenerFieldEClass, KeyListenerField.class, "KeyListenerField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKeyListenerField_ListenerField(), ecorePackage.getEString(), "listenerField", null, 1, 1, KeyListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKeyListenerField_TypedKeyListener(), ecorePackage.getEBoolean(), "typedKeyListener", "true", 1, 1, KeyListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyListenerField_Deregisters(), this.getDeregistersField(), null, "deregisters", null, 1, 1, KeyListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKeyListenerField_Initialized(), ecorePackage.getEBoolean(), "initialized", "true", 1, 1, KeyListenerField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threadEClass, ca.uwaterloo.gsd.applet.Thread.class, "Thread", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThread_Thread(), ecorePackage.getEString(), "thread", null, 1, 1, ca.uwaterloo.gsd.applet.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThread_TypedThread(), ecorePackage.getEBoolean(), "typedThread", "true", 1, 1, ca.uwaterloo.gsd.applet.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThread_InitializesThread(), this.getInitializesThread(), null, "initializesThread", null, 1, 1, ca.uwaterloo.gsd.applet.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThread_NullifiesThread(), ecorePackage.getEBoolean(), "nullifiesThread", "true", 1, 1, ca.uwaterloo.gsd.applet.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initializesThreadEClass, InitializesThread.class, "InitializesThread", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInitializesThread_InitializesThreadWithRunnable(), this.getInitializesThreadWith(), null, "initializesThreadWithRunnable", null, 0, 1, InitializesThread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInitializesThread_InitializesWithThreadSubclass(), this.getInitializesThreadSubclass(), null, "initializesWithThreadSubclass", null, 0, 1, InitializesThread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initializesThreadWithEClass, InitializesThreadWith.class, "InitializesThreadWith", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInitializesThreadWith_This(), this.getThisRunnable(), null, "this", null, 0, 1, InitializesThreadWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInitializesThreadWith_Helper(), ecorePackage.getEBoolean(), "helper", null, 0, 1, InitializesThreadWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInitializesThreadWith_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, InitializesThreadWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInitializesThreadWith_RunnableField(), this.getRunnableField(), null, "runnableField", null, 0, 1, InitializesThreadWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initializesThreadSubclassEClass, InitializesThreadSubclass.class, "InitializesThreadSubclass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInitializesThreadSubclass_Name(), ecorePackage.getEString(), "name", null, 1, 1, InitializesThreadSubclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInitializesThreadSubclass_OverriddesRun(), ecorePackage.getEBoolean(), "overriddesRun", "true", 1, 1, InitializesThreadSubclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInitializesThreadSubclass_ExtendsThread(), ecorePackage.getEBoolean(), "extendsThread", "true", 1, 1, InitializesThreadSubclass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thisRunnableEClass, ThisRunnable.class, "ThisRunnable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThisRunnable_ImplementsRunnable(), ecorePackage.getEBoolean(), "implementsRunnable", "true", 1, 1, ThisRunnable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(runnableFieldEClass, RunnableField.class, "RunnableField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRunnableField_TypedRunnable(), ecorePackage.getEBoolean(), "typedRunnable", "true", 1, 1, RunnableField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRunnableField_Name(), ecorePackage.getEString(), "name", null, 1, 1, RunnableField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRunnableField_Initialized(), ecorePackage.getEBoolean(), "initialized", "true", 1, 1, RunnableField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deregistersFieldEClass, DeregistersField.class, "DeregistersField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeregistersField_Field(), ecorePackage.getEBoolean(), "field", "true", 1, 1, DeregistersField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(showsStatusEClass, ShowsStatus.class, "ShowsStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShowsStatus_Message(), ecorePackage.getEString(), "message", null, 0, -1, ShowsStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleTaskThreadEClass, SingleTaskThread.class, "SingleTaskThread", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSingleTaskThread_Runnable(), ecorePackage.getEBoolean(), "runnable", null, 0, 1, SingleTaskThread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleTaskThread_RunnableField(), this.getRunnableField(), null, "runnableField", null, 0, 1, SingleTaskThread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// project
		createProjectAnnotations();
		// class
		createClassAnnotations();
		// key
		createKeyAnnotations();
		// fullyQualifiedName
		createFullyQualifiedNameAnnotations();
		// essential
		createEssentialAnnotations();
		// extendsClass
		createExtendsClassAnnotations();
		// subsumedBy
		createSubsumedByAnnotations();
		// callsReceived
		createCallsReceivedAnnotations();
		// methodCalls
		createMethodCallsAnnotations();
		// methods
		createMethodsAnnotations();
		// constraint
		createConstraintAnnotations();
		// parentKey
		createParentKeyAnnotations();
		// featureGroup
		createFeatureGroupAnnotations();
		// methodCall
		createMethodCallAnnotations();
		// indexKey
		createIndexKeyAnnotations();
		// argumentValue
		createArgumentValueAnnotations();
		// argumentIsThis
		createArgumentIsThisAnnotations();
		// argumentIsField
		createArgumentIsFieldAnnotations();
		// implementsInterface
		createImplementsInterfaceAnnotations();
		// field
		createFieldAnnotations();
		// fieldName
		createFieldNameAnnotations();
		// typedWith
		createTypedWithAnnotations();
		// assignedWithNew
		createAssignedWithNewAnnotations();
		// assignedWithNull
		createAssignedWithNullAnnotations();
		// argumentIsNew
		createArgumentIsNewAnnotations();
		// argumentIsVariable
		createArgumentIsVariableAnnotations();
		// fieldType
		createFieldTypeAnnotations();
	}

	/**
	 * Initializes the annotations for <b>project</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createProjectAnnotations() {
		String source = "project";		
		addAnnotation
		  (appletModelEClass, 
		   source, 
		   new String[] {
		   });																																																																																																																																		
	}

	/**
	 * Initializes the annotations for <b>class</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createClassAnnotations() {
		String source = "class";			
		addAnnotation
		  (appletEClass, 
		   source, 
		   new String[] {
		   });																																																																																																							
		addAnnotation
		  (initializesThreadSubclassEClass, 
		   source, 
		   new String[] {
		   });																											
	}

	/**
	 * Initializes the annotations for <b>key</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createKeyAnnotations() {
		String source = "key";				
		addAnnotation
		  (getApplet_Name(), 
		   source, 
		   new String[] {
		   });																																																																
		addAnnotation
		  (getMouseListenerField_ListenerField(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getMouseMotionListenerField_ListenerField(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getKeyListenerField_ListenerField(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getThread_Thread(), 
		   source, 
		   new String[] {
		   });																													
		addAnnotation
		  (getRunnableField_Name(), 
		   source, 
		   new String[] {
		   });																
	}

	/**
	 * Initializes the annotations for <b>fullyQualifiedName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createFullyQualifiedNameAnnotations() {
		String source = "fullyQualifiedName";					
		addAnnotation
		  (getApplet_Name(), 
		   source, 
		   new String[] {
		   });																																																																																																								
		addAnnotation
		  (getInitializesThreadSubclass_Name(), 
		   source, 
		   new String[] {
		   });																								
	}

	/**
	 * Initializes the annotations for <b>essential</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEssentialAnnotations() {
		String source = "essential";						
		addAnnotation
		  (getApplet_ExtendsApplet(), 
		   source, 
		   new String[] {
		   });																														
		addAnnotation
		  (registersMouseListenerEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersMouseMotionListenerEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersKeyListenerEClass, 
		   source, 
		   new String[] {
		   });															
		addAnnotation
		  (getDeregistersThis_This(), 
		   source, 
		   new String[] {
		   });																												
		addAnnotation
		  (getThread_TypedThread(), 
		   source, 
		   new String[] {
		   });																																
		addAnnotation
		  (getDeregistersField_Field(), 
		   source, 
		   new String[] {
		   });											
	}

	/**
	 * Initializes the annotations for <b>extendsClass</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendsClassAnnotations() {
		String source = "extendsClass";							
		addAnnotation
		  (getApplet_ExtendsApplet(), 
		   source, 
		   new String[] {
			 "name", "java.applet.Applet",
			 "local", "true"
		   });																								
		addAnnotation
		  (getExtendsApplet_ExtendsJApplet(), 
		   source, 
		   new String[] {
			 "name", "javax.swing.JApplet"
		   });																																																																																	
		addAnnotation
		  (getInitializesThreadSubclass_ExtendsThread(), 
		   source, 
		   new String[] {
			 "name", "java.lang.Thread"
		   });																						
	}

	/**
	 * Initializes the annotations for <b>subsumedBy</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSubsumedByAnnotations() {
		String source = "subsumedBy";								
		addAnnotation
		  (getApplet_ExtendsApplet(), 
		   source, 
		   new String[] {
			 "feature", "extendsJApplet"
		   });																																																																																																																												
	}

	/**
	 * Initializes the annotations for <b>callsReceived</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCallsReceivedAnnotations() {
		String source = "callsReceived";									
		addAnnotation
		  (getApplet_ShowsStatus(), 
		   source, 
		   new String[] {
			 "class", "java.applet.Applet",
			 "name", "showStatus",
			 "signature", "(Ljava.lang.String;)V",
			 "locationName", "init",
			 "position", "after"
		   });						
		addAnnotation
		  (getApplet_Parameter(), 
		   source, 
		   new String[] {
			 "class", "java.applet.Applet",
			 "name", "getParameter",
			 "signature", "(Ljava.lang.String;)Ljava.lang.String;",
			 "locationName", "init"
		   });																																																																																																																						
	}

	/**
	 * Initializes the annotations for <b>methodCalls</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMethodCallsAnnotations() {
		String source = "methodCalls";										
		addAnnotation
		  (getApplet_RegistersMouseListener(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "addMouseListener",
			 "signature", "(Ljava.awt.event.MouseListener;)V",
			 "in", "hierarchy",
			 "locationName", "init",
			 "position", "after"
		   });		
		addAnnotation
		  (getApplet_RegistersMouseMotionListener(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "addMouseMotionListener",
			 "signature", "(Ljava.awt.event.MouseMotionListener;)V",
			 "in", "hierarchy",
			 "locationName", "init",
			 "position", "after"
		   });		
		addAnnotation
		  (getApplet_RegistersKeyListener(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "addKeyListener",
			 "signature", "(Ljava.awt.event.KeyListener;)V",
			 "in", "hierarchy",
			 "locationName", "init",
			 "position", "after"
		   });		
		addAnnotation
		  (getApplet_SingleTaskThread(), 
		   source, 
		   new String[] {
			 "class", "java.lang.Thread",
			 "signature", "(Ljava.lang.Runnable;)V",
			 "in", "hierarchy",
			 "locationName", "init",
			 "position", "after",
			 "statement", "true"
		   });																																										
		addAnnotation
		  (getThisMouseListener_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "removeMouseListener",
			 "signature", "(Ljava.awt.event.MouseListener;)V",
			 "in", "hierarchy",
			 "locationName", "destroy"
		   });				
		addAnnotation
		  (getThisMouseMotionListener_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "removeMouseMotionListener",
			 "signature", "(Ljava.awt.event.MouseMotionListener;)V",
			 "in", "hierarchy",
			 "locationName", "destroy"
		   });				
		addAnnotation
		  (getThisKeyListener_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "removeKeyListener",
			 "signature", "(Ljava.awt.event.KeyListener;)V",
			 "in", "hierarchy",
			 "locationName", "destroy"
		   });											
		addAnnotation
		  (getMouseListenerField_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "removeMouseListener",
			 "signature", "(Ljava.awt.event.MouseListener;)V",
			 "in", "hierarchy",
			 "locationName", "destroy"
		   });								
		addAnnotation
		  (getMouseMotionListenerField_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "removeMouseMotionListener",
			 "signature", "(Ljava.awt.event.MouseMotionListener;)V",
			 "in", "hierarchy",
			 "locationName", "destroy"
		   });								
		addAnnotation
		  (getKeyListenerField_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "java.awt.Component",
			 "name", "removeKeyListener",
			 "signature", "(Ljava.awt.event.KeyListener;)V",
			 "in", "hierarchy",
			 "locationName", "destroy"
		   });																																																
	}

	/**
	 * Initializes the annotations for <b>methods</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMethodsAnnotations() {
		String source = "methods";															
		addAnnotation
		  (getApplet_ProvidesParameterInfo(), 
		   source, 
		   new String[] {
			 "name", "getParameterInfo",
			 "signature", "()[[Ljava.lang.String;",
			 "inherited", "false"
		   });					
		addAnnotation
		  (getOverridesLifecycleMethods_Init(), 
		   source, 
		   new String[] {
			 "name", "init",
			 "signature", "()V",
			 "inherited", "false"
		   });		
		addAnnotation
		  (getOverridesLifecycleMethods_Start(), 
		   source, 
		   new String[] {
			 "name", "start",
			 "signature", "()V",
			 "inherited", "false"
		   });		
		addAnnotation
		  (getOverridesLifecycleMethods_Paint(), 
		   source, 
		   new String[] {
			 "name", "paint",
			 "signature", "(Ljava.awt.Graphics;)V",
			 "inherited", "false"
		   });		
		addAnnotation
		  (getOverridesLifecycleMethods_Stop(), 
		   source, 
		   new String[] {
			 "name", "stop",
			 "signature", "()V",
			 "inherited", "false"
		   });		
		addAnnotation
		  (getOverridesLifecycleMethods_Destroy(), 
		   source, 
		   new String[] {
			 "name", "destroy",
			 "signature", "()V",
			 "inherited", "false"
		   });																																																																																							
		addAnnotation
		  (getInitializesThreadSubclass_OverriddesRun(), 
		   source, 
		   new String[] {
			 "name", "run",
			 "signature", "()V",
			 "inherited", "false"
		   });																							
	}

	/**
	 * Initializes the annotations for <b>constraint</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createConstraintAnnotations() {
		String source = "constraint";																
		addAnnotation
		  (getApplet_ProvidesInfoForParameters(), 
		   source, 
		   new String[] {
			 "feature", "../parameter",
			 "requires", "../providesParameterInfo"
		   });																																																																																																																				
	}

	/**
	 * Initializes the annotations for <b>featureGroup</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createFeatureGroupAnnotations() {
		String source = "featureGroup";																		
		addAnnotation
		  (overridesLifecycleMethodsEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "5",
			 "essential", "true"
		   });															
		addAnnotation
		  (registersMouseListenerEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "1"
		   });								
		addAnnotation
		  (registersMouseMotionListenerEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "1"
		   });								
		addAnnotation
		  (registersKeyListenerEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "1"
		   });																																																
		addAnnotation
		  (initializesThreadEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "1",
			 "essential", "true"
		   });							
		addAnnotation
		  (initializesThreadWithEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "1"
		   });																																
		addAnnotation
		  (singleTaskThreadEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "1"
		   });		
	}

	/**
	 * Initializes the annotations for <b>parentKey</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createParentKeyAnnotations() {
		String source = "parentKey";																	
		addAnnotation
		  (overridesLifecycleMethodsEClass, 
		   source, 
		   new String[] {
		   });										
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (extendsAppletEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getExtendsApplet_ExtendsJApplet(), 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (registersMouseListenerEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersMouseMotionListenerEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersKeyListenerEClass, 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (thisMouseListenerEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (thisMouseMotionListenerEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (thisKeyListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (deregistersThisEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (mouseListenerFieldEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (mouseMotionListenerFieldEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (keyListenerFieldEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (threadEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (initializesThreadEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (initializesThreadWithEClass, 
		   source, 
		   new String[] {
		   });							
		addAnnotation
		  (initializesThreadSubclassEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (thisRunnableEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (runnableFieldEClass, 
		   source, 
		   new String[] {
		   });							
		addAnnotation
		  (deregistersFieldEClass, 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (showsStatusEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (singleTaskThreadEClass, 
		   source, 
		   new String[] {
		   });				
	}

	/**
	 * Initializes the annotations for <b>implementsInterface</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImplementsInterfaceAnnotations() {
		String source = "implementsInterface";																																																					
		addAnnotation
		  (getThisMouseListener_ImplementsMouseListener(), 
		   source, 
		   new String[] {
			 "name", "java.awt.event.MouseListener"
		   });				
		addAnnotation
		  (getThisMouseMotionListener_ImplementsMouseMotionListener(), 
		   source, 
		   new String[] {
			 "name", "java.awt.event.MouseMotionListener"
		   });				
		addAnnotation
		  (getThisKeyListener_ImplementsKeyListener(), 
		   source, 
		   new String[] {
			 "name", "java.awt.event.KeyListener"
		   });																																																						
		addAnnotation
		  (getThisRunnable_ImplementsRunnable(), 
		   source, 
		   new String[] {
			 "name", "java.lang.Runnable"
		   });																				
	}

	/**
	 * Initializes the annotations for <b>field</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createFieldAnnotations() {
		String source = "field";																																																																	
		addAnnotation
		  (mouseListenerFieldEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (mouseMotionListenerFieldEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (keyListenerFieldEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (threadEClass, 
		   source, 
		   new String[] {
		   });																												
		addAnnotation
		  (runnableFieldEClass, 
		   source, 
		   new String[] {
		   });																			
	}

	/**
	 * Initializes the annotations for <b>fieldName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createFieldNameAnnotations() {
		String source = "fieldName";																																																																				
		addAnnotation
		  (getMouseListenerField_ListenerField(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getMouseMotionListenerField_ListenerField(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getKeyListenerField_ListenerField(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getThread_Thread(), 
		   source, 
		   new String[] {
		   });																													
		addAnnotation
		  (getRunnableField_Name(), 
		   source, 
		   new String[] {
		   });															
	}

	/**
	 * Initializes the annotations for <b>typedWith</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTypedWithAnnotations() {
		String source = "typedWith";																																																																					
		addAnnotation
		  (getMouseListenerField_TypedMouseListener(), 
		   source, 
		   new String[] {
			 "name", "java.awt.event.MouseListener"
		   });								
		addAnnotation
		  (getMouseMotionListenerField_TypedMouseMotionListener(), 
		   source, 
		   new String[] {
			 "name", "java.awt.event.MouseMotionListener"
		   });								
		addAnnotation
		  (getKeyListenerField_TypedKeyListener(), 
		   source, 
		   new String[] {
			 "name", "java.awt.event.KeyListener"
		   });									
		addAnnotation
		  (getThread_TypedThread(), 
		   source, 
		   new String[] {
			 "name", "java.lang.Thread"
		   });																									
		addAnnotation
		  (getRunnableField_TypedRunnable(), 
		   source, 
		   new String[] {
			 "name", "java.lang.Runnable"
		   });																	
	}

	/**
	 * Initializes the annotations for <b>assignedWithNew</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createAssignedWithNewAnnotations() {
		String source = "assignedWithNew";																																																																							
		addAnnotation
		  (getMouseListenerField_Initialized(), 
		   source, 
		   new String[] {
			 "class", "java.awt.event.MouseListener",
			 "signature", "()V",
			 "initializer", "true"
		   });								
		addAnnotation
		  (getMouseMotionListenerField_Initialized(), 
		   source, 
		   new String[] {
			 "class", "java.awt.event.MouseMotionListener",
			 "signature", "()V",
			 "initializer", "true"
		   });								
		addAnnotation
		  (getKeyListenerField_Initialized(), 
		   source, 
		   new String[] {
			 "class", "java.awt.event.KeyListener",
			 "signature", "()V",
			 "initializer", "true"
		   });											
		addAnnotation
		  (getInitializesThread_InitializesThreadWithRunnable(), 
		   source, 
		   new String[] {
			 "class", "java.lang.Thread",
			 "signature", "(Ljava.lang.Runnable;)V",
			 "locationName", "init",
			 "position", "after"
		   });		
		addAnnotation
		  (getInitializesThread_InitializesWithThreadSubclass(), 
		   source, 
		   new String[] {
			 "subtypeOf", "java.lang.Thread",
			 "initializer", "true"
		   });																							
		addAnnotation
		  (getRunnableField_Initialized(), 
		   source, 
		   new String[] {
			 "class", "java.lang.Runnable",
			 "signature", "()V",
			 "initializer", "true"
		   });														
	}

	/**
	 * Initializes the annotations for <b>assignedWithNull</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createAssignedWithNullAnnotations() {
		String source = "assignedWithNull";																																																																																												
		addAnnotation
		  (getThread_NullifiesThread(), 
		   source, 
		   new String[] {
			 "locationName", "destroy",
			 "position", "after"
		   });																																								
	}

	/**
	 * Initializes the annotations for <b>methodCall</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMethodCallAnnotations() {
		String source = "methodCall";																								
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersMouseListenerEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersMouseMotionListenerEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersKeyListenerEClass, 
		   source, 
		   new String[] {
		   });																	
		addAnnotation
		  (deregistersThisEClass, 
		   source, 
		   new String[] {
		   });																																					
		addAnnotation
		  (initializesThreadWithEClass, 
		   source, 
		   new String[] {
		   });										
		addAnnotation
		  (initializesThreadSubclassEClass, 
		   source, 
		   new String[] {
		   });														
		addAnnotation
		  (deregistersFieldEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (showsStatusEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (singleTaskThreadEClass, 
		   source, 
		   new String[] {
		   });					
	}

	/**
	 * Initializes the annotations for <b>indexKey</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createIndexKeyAnnotations() {
		String source = "indexKey";																									
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
		   });										
		addAnnotation
		  (registersMouseListenerEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersMouseMotionListenerEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (registersKeyListenerEClass, 
		   source, 
		   new String[] {
		   });																																																																													
		addAnnotation
		  (showsStatusEClass, 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (singleTaskThreadEClass, 
		   source, 
		   new String[] {
		   });			
	}

	/**
	 * Initializes the annotations for <b>argumentValue</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArgumentValueAnnotations() {
		String source = "argumentValue";																											
		addAnnotation
		  (getParameter_Name(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });																																																																																																				
		addAnnotation
		  (getShowsStatus_Message(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });						
	}

	/**
	 * Initializes the annotations for <b>argumentIsThis</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArgumentIsThisAnnotations() {
		String source = "argumentIsThis";																																				
		addAnnotation
		  (getRegistersMouseListener_This(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });								
		addAnnotation
		  (getRegistersMouseMotionListener_This(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });								
		addAnnotation
		  (getRegistersKeyListener_This(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });															
		addAnnotation
		  (getDeregistersThis_This(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });																																					
		addAnnotation
		  (getInitializesThreadWith_This(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });																																
	}

	/**
	 * Initializes the annotations for <b>argumentIsNew</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArgumentIsNewAnnotations() {
		String source = "argumentIsNew";																																																																																																					
		addAnnotation
		  (getInitializesThreadWith_Helper(), 
		   source, 
		   new String[] {
			 "index", "1",
			 "class", "java.lang.Runnable",
			 "signature", "()V"
		   });																															
		addAnnotation
		  (getSingleTaskThread_Runnable(), 
		   source, 
		   new String[] {
			 "index", "1",
			 "class", "java.lang.Runnable",
			 "signature", "()V"
		   });	
	}

	/**
	 * Initializes the annotations for <b>argumentIsVariable</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArgumentIsVariableAnnotations() {
		String source = "argumentIsVariable";																																																																																																						
		addAnnotation
		  (getInitializesThreadWith_Variable(), 
		   source, 
		   new String[] {
			 "index", "1",
			 "class", "java.lang.Runnable",
			 "signature", "()V"
		   });																														
	}

	/**
	 * Initializes the annotations for <b>fieldType</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createFieldTypeAnnotations() {
		String source = "fieldType";																																																																																																											
		addAnnotation
		  (getInitializesThreadSubclass_Name(), 
		   source, 
		   new String[] {
		   });																									
	}

	/**
	 * Initializes the annotations for <b>argumentIsField</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArgumentIsFieldAnnotations() {
		String source = "argumentIsField";																																					
		addAnnotation
		  (getRegistersMouseListener_MouseListenerField(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });								
		addAnnotation
		  (getRegistersMouseMotionListener_MouseMotionListenerField(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });								
		addAnnotation
		  (getRegistersKeyListener_KeyListenerField(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });																																																					
		addAnnotation
		  (getInitializesThreadWith_RunnableField(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });																				
		addAnnotation
		  (getDeregistersField_Field(), 
		   source, 
		   new String[] {
			 "index", "1",
			 "sameAs", "../../listenerField"
		   });											
		addAnnotation
		  (getSingleTaskThread_RunnableField(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });
	}

} //AppletPackageImpl
