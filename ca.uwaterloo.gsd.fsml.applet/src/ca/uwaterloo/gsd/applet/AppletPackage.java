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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import ca.uwaterloo.gsd.fsml.fsml.FsmlPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.applet.AppletFactory
 * @model kind="package"
 * @generated
 */
public interface AppletPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "applet";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ca.uwaterloo.gsd/applet";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "applet";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AppletPackage eINSTANCE = ca.uwaterloo.gsd.applet.impl.AppletPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.AppletModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.AppletModelImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getAppletModel()
	 * @generated
	 */
	int APPLET_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Applets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET_MODEL__APPLETS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET_MODEL_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.AppletImpl <em>Applet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.AppletImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getApplet()
	 * @generated
	 */
	int APPLET = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends Applet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__EXTENDS_APPLET = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overrides Lifecycle Methods</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__OVERRIDES_LIFECYCLE_METHODS = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Shows Status</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__SHOWS_STATUS = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Registers Mouse Listener</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__REGISTERS_MOUSE_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Registers Mouse Motion Listener</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__REGISTERS_MOUSE_MOTION_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Registers Key Listener</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__REGISTERS_KEY_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Thread</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__THREAD = FsmlPackage.CONCEPT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Single Task Thread</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__SINGLE_TASK_THREAD = FsmlPackage.CONCEPT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__PARAMETER = FsmlPackage.CONCEPT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Provides Parameter Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__PROVIDES_PARAMETER_INFO = FsmlPackage.CONCEPT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Provides Info For Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET__PROVIDES_INFO_FOR_PARAMETERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Applet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLET_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl <em>Overrides Lifecycle Methods</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getOverridesLifecycleMethods()
	 * @generated
	 */
	int OVERRIDES_LIFECYCLE_METHODS = 2;

	/**
	 * The feature id for the '<em><b>Init</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDES_LIFECYCLE_METHODS__INIT = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDES_LIFECYCLE_METHODS__START = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Paint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDES_LIFECYCLE_METHODS__PAINT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDES_LIFECYCLE_METHODS__STOP = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Destroy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDES_LIFECYCLE_METHODS__DESTROY = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Overrides Lifecycle Methods</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDES_LIFECYCLE_METHODS_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.ParameterImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.ExtendsAppletImpl <em>Extends Applet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.ExtendsAppletImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getExtendsApplet()
	 * @generated
	 */
	int EXTENDS_APPLET = 4;

	/**
	 * The feature id for the '<em><b>Extends JApplet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_APPLET__EXTENDS_JAPPLET = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extends Applet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_APPLET_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.RegistersMouseListenerImpl <em>Registers Mouse Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.RegistersMouseListenerImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getRegistersMouseListener()
	 * @generated
	 */
	int REGISTERS_MOUSE_LISTENER = 5;

	/**
	 * The feature id for the '<em><b>This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_MOUSE_LISTENER__THIS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mouse Listener Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Registers Mouse Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_MOUSE_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.RegistersMouseMotionListenerImpl <em>Registers Mouse Motion Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.RegistersMouseMotionListenerImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getRegistersMouseMotionListener()
	 * @generated
	 */
	int REGISTERS_MOUSE_MOTION_LISTENER = 6;

	/**
	 * The feature id for the '<em><b>This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_MOUSE_MOTION_LISTENER__THIS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mouse Motion Listener Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Registers Mouse Motion Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_MOUSE_MOTION_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.RegistersKeyListenerImpl <em>Registers Key Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.RegistersKeyListenerImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getRegistersKeyListener()
	 * @generated
	 */
	int REGISTERS_KEY_LISTENER = 7;

	/**
	 * The feature id for the '<em><b>This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_KEY_LISTENER__THIS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key Listener Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Registers Key Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_KEY_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.ThisMouseListenerImpl <em>This Mouse Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.ThisMouseListenerImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThisMouseListener()
	 * @generated
	 */
	int THIS_MOUSE_LISTENER = 8;

	/**
	 * The feature id for the '<em><b>Implements Mouse Listener</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_MOUSE_LISTENER__IMPLEMENTS_MOUSE_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_MOUSE_LISTENER__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>This Mouse Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_MOUSE_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.ThisMouseMotionListenerImpl <em>This Mouse Motion Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.ThisMouseMotionListenerImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThisMouseMotionListener()
	 * @generated
	 */
	int THIS_MOUSE_MOTION_LISTENER = 9;

	/**
	 * The feature id for the '<em><b>Implements Mouse Motion Listener</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_MOUSE_MOTION_LISTENER__IMPLEMENTS_MOUSE_MOTION_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_MOUSE_MOTION_LISTENER__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>This Mouse Motion Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_MOUSE_MOTION_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.ThisKeyListenerImpl <em>This Key Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.ThisKeyListenerImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThisKeyListener()
	 * @generated
	 */
	int THIS_KEY_LISTENER = 10;

	/**
	 * The feature id for the '<em><b>Implements Key Listener</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_KEY_LISTENER__IMPLEMENTS_KEY_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_KEY_LISTENER__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>This Key Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_KEY_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.DeregistersThisImpl <em>Deregisters This</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.DeregistersThisImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getDeregistersThis()
	 * @generated
	 */
	int DEREGISTERS_THIS = 11;

	/**
	 * The feature id for the '<em><b>This</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_THIS__THIS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deregisters This</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_THIS_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.MouseListenerFieldImpl <em>Mouse Listener Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.MouseListenerFieldImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getMouseListenerField()
	 * @generated
	 */
	int MOUSE_LISTENER_FIELD = 12;

	/**
	 * The feature id for the '<em><b>Listener Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_LISTENER_FIELD__LISTENER_FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Mouse Listener</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_LISTENER_FIELD__TYPED_MOUSE_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_LISTENER_FIELD__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_LISTENER_FIELD__INITIALIZED = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mouse Listener Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_LISTENER_FIELD_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.MouseMotionListenerFieldImpl <em>Mouse Motion Listener Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.MouseMotionListenerFieldImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getMouseMotionListenerField()
	 * @generated
	 */
	int MOUSE_MOTION_LISTENER_FIELD = 13;

	/**
	 * The feature id for the '<em><b>Listener Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOTION_LISTENER_FIELD__LISTENER_FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Mouse Motion Listener</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOTION_LISTENER_FIELD__TYPED_MOUSE_MOTION_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOTION_LISTENER_FIELD__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOTION_LISTENER_FIELD__INITIALIZED = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mouse Motion Listener Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOTION_LISTENER_FIELD_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.KeyListenerFieldImpl <em>Key Listener Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.KeyListenerFieldImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getKeyListenerField()
	 * @generated
	 */
	int KEY_LISTENER_FIELD = 14;

	/**
	 * The feature id for the '<em><b>Listener Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LISTENER_FIELD__LISTENER_FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Key Listener</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LISTENER_FIELD__TYPED_KEY_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LISTENER_FIELD__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LISTENER_FIELD__INITIALIZED = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Key Listener Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_LISTENER_FIELD_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.ThreadImpl <em>Thread</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.ThreadImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThread()
	 * @generated
	 */
	int THREAD = 15;

	/**
	 * The feature id for the '<em><b>Thread</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__THREAD = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed Thread</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__TYPED_THREAD = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initializes Thread</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__INITIALIZES_THREAD = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Nullifies Thread</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__NULLIFIES_THREAD = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Thread</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadImpl <em>Initializes Thread</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.InitializesThreadImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getInitializesThread()
	 * @generated
	 */
	int INITIALIZES_THREAD = 16;

	/**
	 * The feature id for the '<em><b>Initializes Thread With Runnable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE = 0;

	/**
	 * The feature id for the '<em><b>Initializes With Thread Subclass</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS = 1;

	/**
	 * The number of structural features of the '<em>Initializes Thread</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadWithImpl <em>Initializes Thread With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.InitializesThreadWithImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getInitializesThreadWith()
	 * @generated
	 */
	int INITIALIZES_THREAD_WITH = 17;

	/**
	 * The feature id for the '<em><b>This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_WITH__THIS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Helper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_WITH__HELPER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_WITH__VARIABLE = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Runnable Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_WITH__RUNNABLE_FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Initializes Thread With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_WITH_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadSubclassImpl <em>Initializes Thread Subclass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.InitializesThreadSubclassImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getInitializesThreadSubclass()
	 * @generated
	 */
	int INITIALIZES_THREAD_SUBCLASS = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_SUBCLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Overriddes Run</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_SUBCLASS__OVERRIDDES_RUN = 1;

	/**
	 * The feature id for the '<em><b>Extends Thread</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_SUBCLASS__EXTENDS_THREAD = 2;

	/**
	 * The number of structural features of the '<em>Initializes Thread Subclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZES_THREAD_SUBCLASS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.ThisRunnableImpl <em>This Runnable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.ThisRunnableImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThisRunnable()
	 * @generated
	 */
	int THIS_RUNNABLE = 19;

	/**
	 * The feature id for the '<em><b>Implements Runnable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_RUNNABLE__IMPLEMENTS_RUNNABLE = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>This Runnable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_RUNNABLE_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.RunnableFieldImpl <em>Runnable Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.RunnableFieldImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getRunnableField()
	 * @generated
	 */
	int RUNNABLE_FIELD = 20;

	/**
	 * The feature id for the '<em><b>Typed Runnable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNNABLE_FIELD__TYPED_RUNNABLE = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNNABLE_FIELD__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNNABLE_FIELD__INITIALIZED = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Runnable Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNNABLE_FIELD_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.DeregistersFieldImpl <em>Deregisters Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.DeregistersFieldImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getDeregistersField()
	 * @generated
	 */
	int DEREGISTERS_FIELD = 21;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_FIELD__FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deregisters Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_FIELD_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.ShowsStatusImpl <em>Shows Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.ShowsStatusImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getShowsStatus()
	 * @generated
	 */
	int SHOWS_STATUS = 22;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOWS_STATUS__MESSAGE = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shows Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOWS_STATUS_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.applet.impl.SingleTaskThreadImpl <em>Single Task Thread</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.applet.impl.SingleTaskThreadImpl
	 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getSingleTaskThread()
	 * @generated
	 */
	int SINGLE_TASK_THREAD = 23;

	/**
	 * The feature id for the '<em><b>Runnable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TASK_THREAD__RUNNABLE = 0;

	/**
	 * The feature id for the '<em><b>Runnable Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TASK_THREAD__RUNNABLE_FIELD = 1;

	/**
	 * The number of structural features of the '<em>Single Task Thread</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_TASK_THREAD_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.AppletModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see ca.uwaterloo.gsd.applet.AppletModel
	 * @generated
	 */
	EClass getAppletModel();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.applet.AppletModel#getApplets <em>Applets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applets</em>'.
	 * @see ca.uwaterloo.gsd.applet.AppletModel#getApplets()
	 * @see #getAppletModel()
	 * @generated
	 */
	EReference getAppletModel_Applets();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.Applet <em>Applet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Applet</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet
	 * @generated
	 */
	EClass getApplet();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.Applet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getName()
	 * @see #getApplet()
	 * @generated
	 */
	EAttribute getApplet_Name();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.Applet#getExtendsApplet <em>Extends Applet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends Applet</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getExtendsApplet()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_ExtendsApplet();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.Applet#getOverridesLifecycleMethods <em>Overrides Lifecycle Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Overrides Lifecycle Methods</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getOverridesLifecycleMethods()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_OverridesLifecycleMethods();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.applet.Applet#getShowsStatus <em>Shows Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Shows Status</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getShowsStatus()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_ShowsStatus();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.applet.Applet#getRegistersMouseListener <em>Registers Mouse Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers Mouse Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getRegistersMouseListener()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_RegistersMouseListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.applet.Applet#getRegistersMouseMotionListener <em>Registers Mouse Motion Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers Mouse Motion Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getRegistersMouseMotionListener()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_RegistersMouseMotionListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.applet.Applet#getRegistersKeyListener <em>Registers Key Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers Key Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getRegistersKeyListener()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_RegistersKeyListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.applet.Applet#getThread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getThread()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_Thread();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.applet.Applet#getSingleTaskThread <em>Single Task Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Single Task Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getSingleTaskThread()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_SingleTaskThread();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.applet.Applet#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#getParameter()
	 * @see #getApplet()
	 * @generated
	 */
	EReference getApplet_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.Applet#isProvidesParameterInfo <em>Provides Parameter Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provides Parameter Info</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#isProvidesParameterInfo()
	 * @see #getApplet()
	 * @generated
	 */
	EAttribute getApplet_ProvidesParameterInfo();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.Applet#isProvidesInfoForParameters <em>Provides Info For Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provides Info For Parameters</em>'.
	 * @see ca.uwaterloo.gsd.applet.Applet#isProvidesInfoForParameters()
	 * @see #getApplet()
	 * @generated
	 */
	EAttribute getApplet_ProvidesInfoForParameters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods <em>Overrides Lifecycle Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Overrides Lifecycle Methods</em>'.
	 * @see ca.uwaterloo.gsd.applet.OverridesLifecycleMethods
	 * @generated
	 */
	EClass getOverridesLifecycleMethods();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init</em>'.
	 * @see ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isInit()
	 * @see #getOverridesLifecycleMethods()
	 * @generated
	 */
	EAttribute getOverridesLifecycleMethods_Init();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isStart()
	 * @see #getOverridesLifecycleMethods()
	 * @generated
	 */
	EAttribute getOverridesLifecycleMethods_Start();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isPaint <em>Paint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paint</em>'.
	 * @see ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isPaint()
	 * @see #getOverridesLifecycleMethods()
	 * @generated
	 */
	EAttribute getOverridesLifecycleMethods_Paint();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isStop <em>Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop</em>'.
	 * @see ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isStop()
	 * @see #getOverridesLifecycleMethods()
	 * @generated
	 */
	EAttribute getOverridesLifecycleMethods_Stop();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isDestroy <em>Destroy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destroy</em>'.
	 * @see ca.uwaterloo.gsd.applet.OverridesLifecycleMethods#isDestroy()
	 * @see #getOverridesLifecycleMethods()
	 * @generated
	 */
	EAttribute getOverridesLifecycleMethods_Destroy();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see ca.uwaterloo.gsd.applet.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute list '{@link ca.uwaterloo.gsd.applet.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.applet.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.ExtendsApplet <em>Extends Applet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extends Applet</em>'.
	 * @see ca.uwaterloo.gsd.applet.ExtendsApplet
	 * @generated
	 */
	EClass getExtendsApplet();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.ExtendsApplet#isExtendsJApplet <em>Extends JApplet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends JApplet</em>'.
	 * @see ca.uwaterloo.gsd.applet.ExtendsApplet#isExtendsJApplet()
	 * @see #getExtendsApplet()
	 * @generated
	 */
	EAttribute getExtendsApplet_ExtendsJApplet();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.RegistersMouseListener <em>Registers Mouse Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registers Mouse Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersMouseListener
	 * @generated
	 */
	EClass getRegistersMouseListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.RegistersMouseListener#getThis <em>This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>This</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersMouseListener#getThis()
	 * @see #getRegistersMouseListener()
	 * @generated
	 */
	EReference getRegistersMouseListener_This();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.RegistersMouseListener#getMouseListenerField <em>Mouse Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mouse Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersMouseListener#getMouseListenerField()
	 * @see #getRegistersMouseListener()
	 * @generated
	 */
	EReference getRegistersMouseListener_MouseListenerField();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener <em>Registers Mouse Motion Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registers Mouse Motion Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersMouseMotionListener
	 * @generated
	 */
	EClass getRegistersMouseMotionListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener#getThis <em>This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>This</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersMouseMotionListener#getThis()
	 * @see #getRegistersMouseMotionListener()
	 * @generated
	 */
	EReference getRegistersMouseMotionListener_This();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener#getMouseMotionListenerField <em>Mouse Motion Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mouse Motion Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersMouseMotionListener#getMouseMotionListenerField()
	 * @see #getRegistersMouseMotionListener()
	 * @generated
	 */
	EReference getRegistersMouseMotionListener_MouseMotionListenerField();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.RegistersKeyListener <em>Registers Key Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registers Key Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersKeyListener
	 * @generated
	 */
	EClass getRegistersKeyListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.RegistersKeyListener#getThis <em>This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>This</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersKeyListener#getThis()
	 * @see #getRegistersKeyListener()
	 * @generated
	 */
	EReference getRegistersKeyListener_This();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.RegistersKeyListener#getKeyListenerField <em>Key Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.RegistersKeyListener#getKeyListenerField()
	 * @see #getRegistersKeyListener()
	 * @generated
	 */
	EReference getRegistersKeyListener_KeyListenerField();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.ThisMouseListener <em>This Mouse Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Mouse Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisMouseListener
	 * @generated
	 */
	EClass getThisMouseListener();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.ThisMouseListener#isImplementsMouseListener <em>Implements Mouse Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implements Mouse Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisMouseListener#isImplementsMouseListener()
	 * @see #getThisMouseListener()
	 * @generated
	 */
	EAttribute getThisMouseListener_ImplementsMouseListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.ThisMouseListener#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisMouseListener#getDeregisters()
	 * @see #getThisMouseListener()
	 * @generated
	 */
	EReference getThisMouseListener_Deregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.ThisMouseMotionListener <em>This Mouse Motion Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Mouse Motion Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisMouseMotionListener
	 * @generated
	 */
	EClass getThisMouseMotionListener();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.ThisMouseMotionListener#isImplementsMouseMotionListener <em>Implements Mouse Motion Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implements Mouse Motion Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisMouseMotionListener#isImplementsMouseMotionListener()
	 * @see #getThisMouseMotionListener()
	 * @generated
	 */
	EAttribute getThisMouseMotionListener_ImplementsMouseMotionListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.ThisMouseMotionListener#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisMouseMotionListener#getDeregisters()
	 * @see #getThisMouseMotionListener()
	 * @generated
	 */
	EReference getThisMouseMotionListener_Deregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.ThisKeyListener <em>This Key Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Key Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisKeyListener
	 * @generated
	 */
	EClass getThisKeyListener();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.ThisKeyListener#isImplementsKeyListener <em>Implements Key Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implements Key Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisKeyListener#isImplementsKeyListener()
	 * @see #getThisKeyListener()
	 * @generated
	 */
	EAttribute getThisKeyListener_ImplementsKeyListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.ThisKeyListener#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisKeyListener#getDeregisters()
	 * @see #getThisKeyListener()
	 * @generated
	 */
	EReference getThisKeyListener_Deregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.DeregistersThis <em>Deregisters This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deregisters This</em>'.
	 * @see ca.uwaterloo.gsd.applet.DeregistersThis
	 * @generated
	 */
	EClass getDeregistersThis();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.DeregistersThis#isThis <em>This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>This</em>'.
	 * @see ca.uwaterloo.gsd.applet.DeregistersThis#isThis()
	 * @see #getDeregistersThis()
	 * @generated
	 */
	EAttribute getDeregistersThis_This();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.MouseListenerField <em>Mouse Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseListenerField
	 * @generated
	 */
	EClass getMouseListenerField();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.MouseListenerField#getListenerField <em>Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseListenerField#getListenerField()
	 * @see #getMouseListenerField()
	 * @generated
	 */
	EAttribute getMouseListenerField_ListenerField();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.MouseListenerField#isTypedMouseListener <em>Typed Mouse Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typed Mouse Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseListenerField#isTypedMouseListener()
	 * @see #getMouseListenerField()
	 * @generated
	 */
	EAttribute getMouseListenerField_TypedMouseListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.MouseListenerField#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseListenerField#getDeregisters()
	 * @see #getMouseListenerField()
	 * @generated
	 */
	EReference getMouseListenerField_Deregisters();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.MouseListenerField#isInitialized <em>Initialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseListenerField#isInitialized()
	 * @see #getMouseListenerField()
	 * @generated
	 */
	EAttribute getMouseListenerField_Initialized();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField <em>Mouse Motion Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Motion Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseMotionListenerField
	 * @generated
	 */
	EClass getMouseMotionListenerField();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#getListenerField <em>Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseMotionListenerField#getListenerField()
	 * @see #getMouseMotionListenerField()
	 * @generated
	 */
	EAttribute getMouseMotionListenerField_ListenerField();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#isTypedMouseMotionListener <em>Typed Mouse Motion Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typed Mouse Motion Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseMotionListenerField#isTypedMouseMotionListener()
	 * @see #getMouseMotionListenerField()
	 * @generated
	 */
	EAttribute getMouseMotionListenerField_TypedMouseMotionListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseMotionListenerField#getDeregisters()
	 * @see #getMouseMotionListenerField()
	 * @generated
	 */
	EReference getMouseMotionListenerField_Deregisters();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField#isInitialized <em>Initialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized</em>'.
	 * @see ca.uwaterloo.gsd.applet.MouseMotionListenerField#isInitialized()
	 * @see #getMouseMotionListenerField()
	 * @generated
	 */
	EAttribute getMouseMotionListenerField_Initialized();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.KeyListenerField <em>Key Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.KeyListenerField
	 * @generated
	 */
	EClass getKeyListenerField();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.KeyListenerField#getListenerField <em>Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Listener Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.KeyListenerField#getListenerField()
	 * @see #getKeyListenerField()
	 * @generated
	 */
	EAttribute getKeyListenerField_ListenerField();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.KeyListenerField#isTypedKeyListener <em>Typed Key Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typed Key Listener</em>'.
	 * @see ca.uwaterloo.gsd.applet.KeyListenerField#isTypedKeyListener()
	 * @see #getKeyListenerField()
	 * @generated
	 */
	EAttribute getKeyListenerField_TypedKeyListener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.KeyListenerField#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.applet.KeyListenerField#getDeregisters()
	 * @see #getKeyListenerField()
	 * @generated
	 */
	EReference getKeyListenerField_Deregisters();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.KeyListenerField#isInitialized <em>Initialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized</em>'.
	 * @see ca.uwaterloo.gsd.applet.KeyListenerField#isInitialized()
	 * @see #getKeyListenerField()
	 * @generated
	 */
	EAttribute getKeyListenerField_Initialized();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.Thread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.Thread
	 * @generated
	 */
	EClass getThread();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.Thread#getThread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.Thread#getThread()
	 * @see #getThread()
	 * @generated
	 */
	EAttribute getThread_Thread();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.Thread#isTypedThread <em>Typed Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typed Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.Thread#isTypedThread()
	 * @see #getThread()
	 * @generated
	 */
	EAttribute getThread_TypedThread();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.Thread#getInitializesThread <em>Initializes Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializes Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.Thread#getInitializesThread()
	 * @see #getThread()
	 * @generated
	 */
	EReference getThread_InitializesThread();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.Thread#isNullifiesThread <em>Nullifies Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullifies Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.Thread#isNullifiesThread()
	 * @see #getThread()
	 * @generated
	 */
	EAttribute getThread_NullifiesThread();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.InitializesThread <em>Initializes Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initializes Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThread
	 * @generated
	 */
	EClass getInitializesThread();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.InitializesThread#getInitializesThreadWithRunnable <em>Initializes Thread With Runnable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializes Thread With Runnable</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThread#getInitializesThreadWithRunnable()
	 * @see #getInitializesThread()
	 * @generated
	 */
	EReference getInitializesThread_InitializesThreadWithRunnable();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.InitializesThread#getInitializesWithThreadSubclass <em>Initializes With Thread Subclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializes With Thread Subclass</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThread#getInitializesWithThreadSubclass()
	 * @see #getInitializesThread()
	 * @generated
	 */
	EReference getInitializesThread_InitializesWithThreadSubclass();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith <em>Initializes Thread With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initializes Thread With</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadWith
	 * @generated
	 */
	EClass getInitializesThreadWith();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getThis <em>This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>This</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadWith#getThis()
	 * @see #getInitializesThreadWith()
	 * @generated
	 */
	EReference getInitializesThreadWith_This();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#isHelper <em>Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Helper</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadWith#isHelper()
	 * @see #getInitializesThreadWith()
	 * @generated
	 */
	EAttribute getInitializesThreadWith_Helper();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadWith#getVariable()
	 * @see #getInitializesThreadWith()
	 * @generated
	 */
	EAttribute getInitializesThreadWith_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith#getRunnableField <em>Runnable Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Runnable Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadWith#getRunnableField()
	 * @see #getInitializesThreadWith()
	 * @generated
	 */
	EReference getInitializesThreadWith_RunnableField();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass <em>Initializes Thread Subclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initializes Thread Subclass</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadSubclass
	 * @generated
	 */
	EClass getInitializesThreadSubclass();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadSubclass#getName()
	 * @see #getInitializesThreadSubclass()
	 * @generated
	 */
	EAttribute getInitializesThreadSubclass_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#isOverriddesRun <em>Overriddes Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overriddes Run</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadSubclass#isOverriddesRun()
	 * @see #getInitializesThreadSubclass()
	 * @generated
	 */
	EAttribute getInitializesThreadSubclass_OverriddesRun();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass#isExtendsThread <em>Extends Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadSubclass#isExtendsThread()
	 * @see #getInitializesThreadSubclass()
	 * @generated
	 */
	EAttribute getInitializesThreadSubclass_ExtendsThread();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.ThisRunnable <em>This Runnable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Runnable</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisRunnable
	 * @generated
	 */
	EClass getThisRunnable();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.ThisRunnable#isImplementsRunnable <em>Implements Runnable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implements Runnable</em>'.
	 * @see ca.uwaterloo.gsd.applet.ThisRunnable#isImplementsRunnable()
	 * @see #getThisRunnable()
	 * @generated
	 */
	EAttribute getThisRunnable_ImplementsRunnable();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.RunnableField <em>Runnable Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runnable Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.RunnableField
	 * @generated
	 */
	EClass getRunnableField();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.RunnableField#isTypedRunnable <em>Typed Runnable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typed Runnable</em>'.
	 * @see ca.uwaterloo.gsd.applet.RunnableField#isTypedRunnable()
	 * @see #getRunnableField()
	 * @generated
	 */
	EAttribute getRunnableField_TypedRunnable();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.RunnableField#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.applet.RunnableField#getName()
	 * @see #getRunnableField()
	 * @generated
	 */
	EAttribute getRunnableField_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.RunnableField#isInitialized <em>Initialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized</em>'.
	 * @see ca.uwaterloo.gsd.applet.RunnableField#isInitialized()
	 * @see #getRunnableField()
	 * @generated
	 */
	EAttribute getRunnableField_Initialized();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.DeregistersField <em>Deregisters Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deregisters Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.DeregistersField
	 * @generated
	 */
	EClass getDeregistersField();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.DeregistersField#isField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.DeregistersField#isField()
	 * @see #getDeregistersField()
	 * @generated
	 */
	EAttribute getDeregistersField_Field();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.ShowsStatus <em>Shows Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shows Status</em>'.
	 * @see ca.uwaterloo.gsd.applet.ShowsStatus
	 * @generated
	 */
	EClass getShowsStatus();

	/**
	 * Returns the meta object for the attribute list '{@link ca.uwaterloo.gsd.applet.ShowsStatus#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Message</em>'.
	 * @see ca.uwaterloo.gsd.applet.ShowsStatus#getMessage()
	 * @see #getShowsStatus()
	 * @generated
	 */
	EAttribute getShowsStatus_Message();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.applet.SingleTaskThread <em>Single Task Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Task Thread</em>'.
	 * @see ca.uwaterloo.gsd.applet.SingleTaskThread
	 * @generated
	 */
	EClass getSingleTaskThread();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.applet.SingleTaskThread#isRunnable <em>Runnable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runnable</em>'.
	 * @see ca.uwaterloo.gsd.applet.SingleTaskThread#isRunnable()
	 * @see #getSingleTaskThread()
	 * @generated
	 */
	EAttribute getSingleTaskThread_Runnable();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.applet.SingleTaskThread#getRunnableField <em>Runnable Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Runnable Field</em>'.
	 * @see ca.uwaterloo.gsd.applet.SingleTaskThread#getRunnableField()
	 * @see #getSingleTaskThread()
	 * @generated
	 */
	EReference getSingleTaskThread_RunnableField();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AppletFactory getAppletFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.AppletModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.AppletModelImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getAppletModel()
		 * @generated
		 */
		EClass APPLET_MODEL = eINSTANCE.getAppletModel();

		/**
		 * The meta object literal for the '<em><b>Applets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET_MODEL__APPLETS = eINSTANCE.getAppletModel_Applets();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.AppletImpl <em>Applet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.AppletImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getApplet()
		 * @generated
		 */
		EClass APPLET = eINSTANCE.getApplet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLET__NAME = eINSTANCE.getApplet_Name();

		/**
		 * The meta object literal for the '<em><b>Extends Applet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__EXTENDS_APPLET = eINSTANCE.getApplet_ExtendsApplet();

		/**
		 * The meta object literal for the '<em><b>Overrides Lifecycle Methods</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__OVERRIDES_LIFECYCLE_METHODS = eINSTANCE.getApplet_OverridesLifecycleMethods();

		/**
		 * The meta object literal for the '<em><b>Shows Status</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__SHOWS_STATUS = eINSTANCE.getApplet_ShowsStatus();

		/**
		 * The meta object literal for the '<em><b>Registers Mouse Listener</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__REGISTERS_MOUSE_LISTENER = eINSTANCE.getApplet_RegistersMouseListener();

		/**
		 * The meta object literal for the '<em><b>Registers Mouse Motion Listener</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__REGISTERS_MOUSE_MOTION_LISTENER = eINSTANCE.getApplet_RegistersMouseMotionListener();

		/**
		 * The meta object literal for the '<em><b>Registers Key Listener</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__REGISTERS_KEY_LISTENER = eINSTANCE.getApplet_RegistersKeyListener();

		/**
		 * The meta object literal for the '<em><b>Thread</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__THREAD = eINSTANCE.getApplet_Thread();

		/**
		 * The meta object literal for the '<em><b>Single Task Thread</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__SINGLE_TASK_THREAD = eINSTANCE.getApplet_SingleTaskThread();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLET__PARAMETER = eINSTANCE.getApplet_Parameter();

		/**
		 * The meta object literal for the '<em><b>Provides Parameter Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLET__PROVIDES_PARAMETER_INFO = eINSTANCE.getApplet_ProvidesParameterInfo();

		/**
		 * The meta object literal for the '<em><b>Provides Info For Parameters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLET__PROVIDES_INFO_FOR_PARAMETERS = eINSTANCE.getApplet_ProvidesInfoForParameters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl <em>Overrides Lifecycle Methods</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.OverridesLifecycleMethodsImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getOverridesLifecycleMethods()
		 * @generated
		 */
		EClass OVERRIDES_LIFECYCLE_METHODS = eINSTANCE.getOverridesLifecycleMethods();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVERRIDES_LIFECYCLE_METHODS__INIT = eINSTANCE.getOverridesLifecycleMethods_Init();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVERRIDES_LIFECYCLE_METHODS__START = eINSTANCE.getOverridesLifecycleMethods_Start();

		/**
		 * The meta object literal for the '<em><b>Paint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVERRIDES_LIFECYCLE_METHODS__PAINT = eINSTANCE.getOverridesLifecycleMethods_Paint();

		/**
		 * The meta object literal for the '<em><b>Stop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVERRIDES_LIFECYCLE_METHODS__STOP = eINSTANCE.getOverridesLifecycleMethods_Stop();

		/**
		 * The meta object literal for the '<em><b>Destroy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVERRIDES_LIFECYCLE_METHODS__DESTROY = eINSTANCE.getOverridesLifecycleMethods_Destroy();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.ParameterImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.ExtendsAppletImpl <em>Extends Applet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.ExtendsAppletImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getExtendsApplet()
		 * @generated
		 */
		EClass EXTENDS_APPLET = eINSTANCE.getExtendsApplet();

		/**
		 * The meta object literal for the '<em><b>Extends JApplet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDS_APPLET__EXTENDS_JAPPLET = eINSTANCE.getExtendsApplet_ExtendsJApplet();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.RegistersMouseListenerImpl <em>Registers Mouse Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.RegistersMouseListenerImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getRegistersMouseListener()
		 * @generated
		 */
		EClass REGISTERS_MOUSE_LISTENER = eINSTANCE.getRegistersMouseListener();

		/**
		 * The meta object literal for the '<em><b>This</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_MOUSE_LISTENER__THIS = eINSTANCE.getRegistersMouseListener_This();

		/**
		 * The meta object literal for the '<em><b>Mouse Listener Field</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_MOUSE_LISTENER__MOUSE_LISTENER_FIELD = eINSTANCE.getRegistersMouseListener_MouseListenerField();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.RegistersMouseMotionListenerImpl <em>Registers Mouse Motion Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.RegistersMouseMotionListenerImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getRegistersMouseMotionListener()
		 * @generated
		 */
		EClass REGISTERS_MOUSE_MOTION_LISTENER = eINSTANCE.getRegistersMouseMotionListener();

		/**
		 * The meta object literal for the '<em><b>This</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_MOUSE_MOTION_LISTENER__THIS = eINSTANCE.getRegistersMouseMotionListener_This();

		/**
		 * The meta object literal for the '<em><b>Mouse Motion Listener Field</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_MOUSE_MOTION_LISTENER__MOUSE_MOTION_LISTENER_FIELD = eINSTANCE.getRegistersMouseMotionListener_MouseMotionListenerField();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.RegistersKeyListenerImpl <em>Registers Key Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.RegistersKeyListenerImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getRegistersKeyListener()
		 * @generated
		 */
		EClass REGISTERS_KEY_LISTENER = eINSTANCE.getRegistersKeyListener();

		/**
		 * The meta object literal for the '<em><b>This</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_KEY_LISTENER__THIS = eINSTANCE.getRegistersKeyListener_This();

		/**
		 * The meta object literal for the '<em><b>Key Listener Field</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_KEY_LISTENER__KEY_LISTENER_FIELD = eINSTANCE.getRegistersKeyListener_KeyListenerField();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.ThisMouseListenerImpl <em>This Mouse Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.ThisMouseListenerImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThisMouseListener()
		 * @generated
		 */
		EClass THIS_MOUSE_LISTENER = eINSTANCE.getThisMouseListener();

		/**
		 * The meta object literal for the '<em><b>Implements Mouse Listener</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THIS_MOUSE_LISTENER__IMPLEMENTS_MOUSE_LISTENER = eINSTANCE.getThisMouseListener_ImplementsMouseListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THIS_MOUSE_LISTENER__DEREGISTERS = eINSTANCE.getThisMouseListener_Deregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.ThisMouseMotionListenerImpl <em>This Mouse Motion Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.ThisMouseMotionListenerImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThisMouseMotionListener()
		 * @generated
		 */
		EClass THIS_MOUSE_MOTION_LISTENER = eINSTANCE.getThisMouseMotionListener();

		/**
		 * The meta object literal for the '<em><b>Implements Mouse Motion Listener</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THIS_MOUSE_MOTION_LISTENER__IMPLEMENTS_MOUSE_MOTION_LISTENER = eINSTANCE.getThisMouseMotionListener_ImplementsMouseMotionListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THIS_MOUSE_MOTION_LISTENER__DEREGISTERS = eINSTANCE.getThisMouseMotionListener_Deregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.ThisKeyListenerImpl <em>This Key Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.ThisKeyListenerImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThisKeyListener()
		 * @generated
		 */
		EClass THIS_KEY_LISTENER = eINSTANCE.getThisKeyListener();

		/**
		 * The meta object literal for the '<em><b>Implements Key Listener</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THIS_KEY_LISTENER__IMPLEMENTS_KEY_LISTENER = eINSTANCE.getThisKeyListener_ImplementsKeyListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THIS_KEY_LISTENER__DEREGISTERS = eINSTANCE.getThisKeyListener_Deregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.DeregistersThisImpl <em>Deregisters This</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.DeregistersThisImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getDeregistersThis()
		 * @generated
		 */
		EClass DEREGISTERS_THIS = eINSTANCE.getDeregistersThis();

		/**
		 * The meta object literal for the '<em><b>This</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEREGISTERS_THIS__THIS = eINSTANCE.getDeregistersThis_This();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.MouseListenerFieldImpl <em>Mouse Listener Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.MouseListenerFieldImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getMouseListenerField()
		 * @generated
		 */
		EClass MOUSE_LISTENER_FIELD = eINSTANCE.getMouseListenerField();

		/**
		 * The meta object literal for the '<em><b>Listener Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_LISTENER_FIELD__LISTENER_FIELD = eINSTANCE.getMouseListenerField_ListenerField();

		/**
		 * The meta object literal for the '<em><b>Typed Mouse Listener</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_LISTENER_FIELD__TYPED_MOUSE_LISTENER = eINSTANCE.getMouseListenerField_TypedMouseListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOUSE_LISTENER_FIELD__DEREGISTERS = eINSTANCE.getMouseListenerField_Deregisters();

		/**
		 * The meta object literal for the '<em><b>Initialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_LISTENER_FIELD__INITIALIZED = eINSTANCE.getMouseListenerField_Initialized();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.MouseMotionListenerFieldImpl <em>Mouse Motion Listener Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.MouseMotionListenerFieldImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getMouseMotionListenerField()
		 * @generated
		 */
		EClass MOUSE_MOTION_LISTENER_FIELD = eINSTANCE.getMouseMotionListenerField();

		/**
		 * The meta object literal for the '<em><b>Listener Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_MOTION_LISTENER_FIELD__LISTENER_FIELD = eINSTANCE.getMouseMotionListenerField_ListenerField();

		/**
		 * The meta object literal for the '<em><b>Typed Mouse Motion Listener</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_MOTION_LISTENER_FIELD__TYPED_MOUSE_MOTION_LISTENER = eINSTANCE.getMouseMotionListenerField_TypedMouseMotionListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOUSE_MOTION_LISTENER_FIELD__DEREGISTERS = eINSTANCE.getMouseMotionListenerField_Deregisters();

		/**
		 * The meta object literal for the '<em><b>Initialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_MOTION_LISTENER_FIELD__INITIALIZED = eINSTANCE.getMouseMotionListenerField_Initialized();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.KeyListenerFieldImpl <em>Key Listener Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.KeyListenerFieldImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getKeyListenerField()
		 * @generated
		 */
		EClass KEY_LISTENER_FIELD = eINSTANCE.getKeyListenerField();

		/**
		 * The meta object literal for the '<em><b>Listener Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_LISTENER_FIELD__LISTENER_FIELD = eINSTANCE.getKeyListenerField_ListenerField();

		/**
		 * The meta object literal for the '<em><b>Typed Key Listener</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_LISTENER_FIELD__TYPED_KEY_LISTENER = eINSTANCE.getKeyListenerField_TypedKeyListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_LISTENER_FIELD__DEREGISTERS = eINSTANCE.getKeyListenerField_Deregisters();

		/**
		 * The meta object literal for the '<em><b>Initialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_LISTENER_FIELD__INITIALIZED = eINSTANCE.getKeyListenerField_Initialized();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.ThreadImpl <em>Thread</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.ThreadImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThread()
		 * @generated
		 */
		EClass THREAD = eINSTANCE.getThread();

		/**
		 * The meta object literal for the '<em><b>Thread</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD__THREAD = eINSTANCE.getThread_Thread();

		/**
		 * The meta object literal for the '<em><b>Typed Thread</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD__TYPED_THREAD = eINSTANCE.getThread_TypedThread();

		/**
		 * The meta object literal for the '<em><b>Initializes Thread</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAD__INITIALIZES_THREAD = eINSTANCE.getThread_InitializesThread();

		/**
		 * The meta object literal for the '<em><b>Nullifies Thread</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD__NULLIFIES_THREAD = eINSTANCE.getThread_NullifiesThread();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadImpl <em>Initializes Thread</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.InitializesThreadImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getInitializesThread()
		 * @generated
		 */
		EClass INITIALIZES_THREAD = eINSTANCE.getInitializesThread();

		/**
		 * The meta object literal for the '<em><b>Initializes Thread With Runnable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALIZES_THREAD__INITIALIZES_THREAD_WITH_RUNNABLE = eINSTANCE.getInitializesThread_InitializesThreadWithRunnable();

		/**
		 * The meta object literal for the '<em><b>Initializes With Thread Subclass</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALIZES_THREAD__INITIALIZES_WITH_THREAD_SUBCLASS = eINSTANCE.getInitializesThread_InitializesWithThreadSubclass();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadWithImpl <em>Initializes Thread With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.InitializesThreadWithImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getInitializesThreadWith()
		 * @generated
		 */
		EClass INITIALIZES_THREAD_WITH = eINSTANCE.getInitializesThreadWith();

		/**
		 * The meta object literal for the '<em><b>This</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALIZES_THREAD_WITH__THIS = eINSTANCE.getInitializesThreadWith_This();

		/**
		 * The meta object literal for the '<em><b>Helper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INITIALIZES_THREAD_WITH__HELPER = eINSTANCE.getInitializesThreadWith_Helper();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INITIALIZES_THREAD_WITH__VARIABLE = eINSTANCE.getInitializesThreadWith_Variable();

		/**
		 * The meta object literal for the '<em><b>Runnable Field</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALIZES_THREAD_WITH__RUNNABLE_FIELD = eINSTANCE.getInitializesThreadWith_RunnableField();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.InitializesThreadSubclassImpl <em>Initializes Thread Subclass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.InitializesThreadSubclassImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getInitializesThreadSubclass()
		 * @generated
		 */
		EClass INITIALIZES_THREAD_SUBCLASS = eINSTANCE.getInitializesThreadSubclass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INITIALIZES_THREAD_SUBCLASS__NAME = eINSTANCE.getInitializesThreadSubclass_Name();

		/**
		 * The meta object literal for the '<em><b>Overriddes Run</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INITIALIZES_THREAD_SUBCLASS__OVERRIDDES_RUN = eINSTANCE.getInitializesThreadSubclass_OverriddesRun();

		/**
		 * The meta object literal for the '<em><b>Extends Thread</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INITIALIZES_THREAD_SUBCLASS__EXTENDS_THREAD = eINSTANCE.getInitializesThreadSubclass_ExtendsThread();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.ThisRunnableImpl <em>This Runnable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.ThisRunnableImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getThisRunnable()
		 * @generated
		 */
		EClass THIS_RUNNABLE = eINSTANCE.getThisRunnable();

		/**
		 * The meta object literal for the '<em><b>Implements Runnable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THIS_RUNNABLE__IMPLEMENTS_RUNNABLE = eINSTANCE.getThisRunnable_ImplementsRunnable();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.RunnableFieldImpl <em>Runnable Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.RunnableFieldImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getRunnableField()
		 * @generated
		 */
		EClass RUNNABLE_FIELD = eINSTANCE.getRunnableField();

		/**
		 * The meta object literal for the '<em><b>Typed Runnable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNNABLE_FIELD__TYPED_RUNNABLE = eINSTANCE.getRunnableField_TypedRunnable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNNABLE_FIELD__NAME = eINSTANCE.getRunnableField_Name();

		/**
		 * The meta object literal for the '<em><b>Initialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNNABLE_FIELD__INITIALIZED = eINSTANCE.getRunnableField_Initialized();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.DeregistersFieldImpl <em>Deregisters Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.DeregistersFieldImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getDeregistersField()
		 * @generated
		 */
		EClass DEREGISTERS_FIELD = eINSTANCE.getDeregistersField();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEREGISTERS_FIELD__FIELD = eINSTANCE.getDeregistersField_Field();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.ShowsStatusImpl <em>Shows Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.ShowsStatusImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getShowsStatus()
		 * @generated
		 */
		EClass SHOWS_STATUS = eINSTANCE.getShowsStatus();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHOWS_STATUS__MESSAGE = eINSTANCE.getShowsStatus_Message();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.applet.impl.SingleTaskThreadImpl <em>Single Task Thread</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.applet.impl.SingleTaskThreadImpl
		 * @see ca.uwaterloo.gsd.applet.impl.AppletPackageImpl#getSingleTaskThread()
		 * @generated
		 */
		EClass SINGLE_TASK_THREAD = eINSTANCE.getSingleTaskThread();

		/**
		 * The meta object literal for the '<em><b>Runnable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_TASK_THREAD__RUNNABLE = eINSTANCE.getSingleTaskThread_Runnable();

		/**
		 * The meta object literal for the '<em><b>Runnable Field</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_TASK_THREAD__RUNNABLE_FIELD = eINSTANCE.getSingleTaskThread_RunnableField();

	}

} //AppletPackage
