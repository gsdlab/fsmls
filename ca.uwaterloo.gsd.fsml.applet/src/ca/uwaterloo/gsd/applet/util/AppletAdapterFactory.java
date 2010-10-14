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
 * $Id: AppletAdapterFactory.java,v 1.15 2008/04/10 20:33:16 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import ca.uwaterloo.gsd.applet.Applet;
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
import ca.uwaterloo.gsd.fsml.fsml.Concept;
import ca.uwaterloo.gsd.fsml.fsml.Model;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.applet.AppletPackage
 * @generated
 */
public class AppletAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AppletPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppletAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AppletPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppletSwitch<Adapter> modelSwitch =
		new AppletSwitch<Adapter>() {
			@Override
			public Adapter caseAppletModel(AppletModel object) {
				return createAppletModelAdapter();
			}
			@Override
			public Adapter caseApplet(Applet object) {
				return createAppletAdapter();
			}
			@Override
			public Adapter caseOverridesLifecycleMethods(OverridesLifecycleMethods object) {
				return createOverridesLifecycleMethodsAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseExtendsApplet(ExtendsApplet object) {
				return createExtendsAppletAdapter();
			}
			@Override
			public Adapter caseRegistersMouseListener(RegistersMouseListener object) {
				return createRegistersMouseListenerAdapter();
			}
			@Override
			public Adapter caseRegistersMouseMotionListener(RegistersMouseMotionListener object) {
				return createRegistersMouseMotionListenerAdapter();
			}
			@Override
			public Adapter caseRegistersKeyListener(RegistersKeyListener object) {
				return createRegistersKeyListenerAdapter();
			}
			@Override
			public Adapter caseThisMouseListener(ThisMouseListener object) {
				return createThisMouseListenerAdapter();
			}
			@Override
			public Adapter caseThisMouseMotionListener(ThisMouseMotionListener object) {
				return createThisMouseMotionListenerAdapter();
			}
			@Override
			public Adapter caseThisKeyListener(ThisKeyListener object) {
				return createThisKeyListenerAdapter();
			}
			@Override
			public Adapter caseDeregistersThis(DeregistersThis object) {
				return createDeregistersThisAdapter();
			}
			@Override
			public Adapter caseMouseListenerField(MouseListenerField object) {
				return createMouseListenerFieldAdapter();
			}
			@Override
			public Adapter caseMouseMotionListenerField(MouseMotionListenerField object) {
				return createMouseMotionListenerFieldAdapter();
			}
			@Override
			public Adapter caseKeyListenerField(KeyListenerField object) {
				return createKeyListenerFieldAdapter();
			}
			@Override
			public Adapter caseThread(ca.uwaterloo.gsd.applet.Thread object) {
				return createThreadAdapter();
			}
			@Override
			public Adapter caseInitializesThread(InitializesThread object) {
				return createInitializesThreadAdapter();
			}
			@Override
			public Adapter caseInitializesThreadWith(InitializesThreadWith object) {
				return createInitializesThreadWithAdapter();
			}
			@Override
			public Adapter caseInitializesThreadSubclass(InitializesThreadSubclass object) {
				return createInitializesThreadSubclassAdapter();
			}
			@Override
			public Adapter caseThisRunnable(ThisRunnable object) {
				return createThisRunnableAdapter();
			}
			@Override
			public Adapter caseRunnableField(RunnableField object) {
				return createRunnableFieldAdapter();
			}
			@Override
			public Adapter caseDeregistersField(DeregistersField object) {
				return createDeregistersFieldAdapter();
			}
			@Override
			public Adapter caseShowsStatus(ShowsStatus object) {
				return createShowsStatusAdapter();
			}
			@Override
			public Adapter caseSingleTaskThread(SingleTaskThread object) {
				return createSingleTaskThreadAdapter();
			}
			@Override
			public Adapter caseConcept(Concept object) {
				return createConceptAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.Applet <em>Applet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.Applet
	 * @generated
	 */
	public Adapter createAppletAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods <em>Overrides Lifecycle Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.OverridesLifecycleMethods
	 * @generated
	 */
	public Adapter createOverridesLifecycleMethodsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.ExtendsApplet <em>Extends Applet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.ExtendsApplet
	 * @generated
	 */
	public Adapter createExtendsAppletAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.RegistersMouseListener <em>Registers Mouse Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.RegistersMouseListener
	 * @generated
	 */
	public Adapter createRegistersMouseListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.RegistersMouseMotionListener <em>Registers Mouse Motion Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.RegistersMouseMotionListener
	 * @generated
	 */
	public Adapter createRegistersMouseMotionListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.RegistersKeyListener <em>Registers Key Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.RegistersKeyListener
	 * @generated
	 */
	public Adapter createRegistersKeyListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.ThisMouseListener <em>This Mouse Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.ThisMouseListener
	 * @generated
	 */
	public Adapter createThisMouseListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.ThisMouseMotionListener <em>This Mouse Motion Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.ThisMouseMotionListener
	 * @generated
	 */
	public Adapter createThisMouseMotionListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.ThisKeyListener <em>This Key Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.ThisKeyListener
	 * @generated
	 */
	public Adapter createThisKeyListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.DeregistersThis <em>Deregisters This</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.DeregistersThis
	 * @generated
	 */
	public Adapter createDeregistersThisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.MouseListenerField <em>Mouse Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.MouseListenerField
	 * @generated
	 */
	public Adapter createMouseListenerFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.MouseMotionListenerField <em>Mouse Motion Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.MouseMotionListenerField
	 * @generated
	 */
	public Adapter createMouseMotionListenerFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.KeyListenerField <em>Key Listener Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.KeyListenerField
	 * @generated
	 */
	public Adapter createKeyListenerFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.AppletModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.AppletModel
	 * @generated
	 */
	public Adapter createAppletModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.Thread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.Thread
	 * @generated
	 */
	public Adapter createThreadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.InitializesThread <em>Initializes Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.InitializesThread
	 * @generated
	 */
	public Adapter createInitializesThreadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.InitializesThreadWith <em>Initializes Thread With</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadWith
	 * @generated
	 */
	public Adapter createInitializesThreadWithAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.InitializesThreadSubclass <em>Initializes Thread Subclass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.InitializesThreadSubclass
	 * @generated
	 */
	public Adapter createInitializesThreadSubclassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.ThisRunnable <em>This Runnable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.ThisRunnable
	 * @generated
	 */
	public Adapter createThisRunnableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.RunnableField <em>Runnable Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.RunnableField
	 * @generated
	 */
	public Adapter createRunnableFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.DeregistersField <em>Deregisters Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.DeregistersField
	 * @generated
	 */
	public Adapter createDeregistersFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.ShowsStatus <em>Shows Status</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.ShowsStatus
	 * @generated
	 */
	public Adapter createShowsStatusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.applet.SingleTaskThread <em>Single Task Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.applet.SingleTaskThread
	 * @generated
	 */
	public Adapter createSingleTaskThreadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.fsml.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.fsml.Concept
	 * @generated
	 */
	public Adapter createConceptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.fsml.fsml.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.fsml.fsml.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AppletAdapterFactory
