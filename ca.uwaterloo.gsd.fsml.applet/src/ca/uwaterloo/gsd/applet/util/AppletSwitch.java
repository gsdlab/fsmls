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
 * $Id: AppletSwitch.java,v 1.18 2008/04/10 20:33:15 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.applet.AppletPackage
 * @generated
 */
public class AppletSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AppletPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppletSwitch() {
		if (modelPackage == null) {
			modelPackage = AppletPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AppletPackage.APPLET_MODEL: {
				AppletModel appletModel = (AppletModel)theEObject;
				T result = caseAppletModel(appletModel);
				if (result == null) result = caseConcept(appletModel);
				if (result == null) result = caseModel(appletModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.APPLET: {
				Applet applet = (Applet)theEObject;
				T result = caseApplet(applet);
				if (result == null) result = caseConcept(applet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS: {
				OverridesLifecycleMethods overridesLifecycleMethods = (OverridesLifecycleMethods)theEObject;
				T result = caseOverridesLifecycleMethods(overridesLifecycleMethods);
				if (result == null) result = caseConcept(overridesLifecycleMethods);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseConcept(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.EXTENDS_APPLET: {
				ExtendsApplet extendsApplet = (ExtendsApplet)theEObject;
				T result = caseExtendsApplet(extendsApplet);
				if (result == null) result = caseConcept(extendsApplet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.REGISTERS_MOUSE_LISTENER: {
				RegistersMouseListener registersMouseListener = (RegistersMouseListener)theEObject;
				T result = caseRegistersMouseListener(registersMouseListener);
				if (result == null) result = caseConcept(registersMouseListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.REGISTERS_MOUSE_MOTION_LISTENER: {
				RegistersMouseMotionListener registersMouseMotionListener = (RegistersMouseMotionListener)theEObject;
				T result = caseRegistersMouseMotionListener(registersMouseMotionListener);
				if (result == null) result = caseConcept(registersMouseMotionListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.REGISTERS_KEY_LISTENER: {
				RegistersKeyListener registersKeyListener = (RegistersKeyListener)theEObject;
				T result = caseRegistersKeyListener(registersKeyListener);
				if (result == null) result = caseConcept(registersKeyListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.THIS_MOUSE_LISTENER: {
				ThisMouseListener thisMouseListener = (ThisMouseListener)theEObject;
				T result = caseThisMouseListener(thisMouseListener);
				if (result == null) result = caseConcept(thisMouseListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.THIS_MOUSE_MOTION_LISTENER: {
				ThisMouseMotionListener thisMouseMotionListener = (ThisMouseMotionListener)theEObject;
				T result = caseThisMouseMotionListener(thisMouseMotionListener);
				if (result == null) result = caseConcept(thisMouseMotionListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.THIS_KEY_LISTENER: {
				ThisKeyListener thisKeyListener = (ThisKeyListener)theEObject;
				T result = caseThisKeyListener(thisKeyListener);
				if (result == null) result = caseConcept(thisKeyListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.DEREGISTERS_THIS: {
				DeregistersThis deregistersThis = (DeregistersThis)theEObject;
				T result = caseDeregistersThis(deregistersThis);
				if (result == null) result = caseConcept(deregistersThis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.MOUSE_LISTENER_FIELD: {
				MouseListenerField mouseListenerField = (MouseListenerField)theEObject;
				T result = caseMouseListenerField(mouseListenerField);
				if (result == null) result = caseConcept(mouseListenerField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.MOUSE_MOTION_LISTENER_FIELD: {
				MouseMotionListenerField mouseMotionListenerField = (MouseMotionListenerField)theEObject;
				T result = caseMouseMotionListenerField(mouseMotionListenerField);
				if (result == null) result = caseConcept(mouseMotionListenerField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.KEY_LISTENER_FIELD: {
				KeyListenerField keyListenerField = (KeyListenerField)theEObject;
				T result = caseKeyListenerField(keyListenerField);
				if (result == null) result = caseConcept(keyListenerField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.THREAD: {
				ca.uwaterloo.gsd.applet.Thread thread = (ca.uwaterloo.gsd.applet.Thread)theEObject;
				T result = caseThread(thread);
				if (result == null) result = caseConcept(thread);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.INITIALIZES_THREAD: {
				InitializesThread initializesThread = (InitializesThread)theEObject;
				T result = caseInitializesThread(initializesThread);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.INITIALIZES_THREAD_WITH: {
				InitializesThreadWith initializesThreadWith = (InitializesThreadWith)theEObject;
				T result = caseInitializesThreadWith(initializesThreadWith);
				if (result == null) result = caseConcept(initializesThreadWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.INITIALIZES_THREAD_SUBCLASS: {
				InitializesThreadSubclass initializesThreadSubclass = (InitializesThreadSubclass)theEObject;
				T result = caseInitializesThreadSubclass(initializesThreadSubclass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.THIS_RUNNABLE: {
				ThisRunnable thisRunnable = (ThisRunnable)theEObject;
				T result = caseThisRunnable(thisRunnable);
				if (result == null) result = caseConcept(thisRunnable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.RUNNABLE_FIELD: {
				RunnableField runnableField = (RunnableField)theEObject;
				T result = caseRunnableField(runnableField);
				if (result == null) result = caseConcept(runnableField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.DEREGISTERS_FIELD: {
				DeregistersField deregistersField = (DeregistersField)theEObject;
				T result = caseDeregistersField(deregistersField);
				if (result == null) result = caseConcept(deregistersField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.SHOWS_STATUS: {
				ShowsStatus showsStatus = (ShowsStatus)theEObject;
				T result = caseShowsStatus(showsStatus);
				if (result == null) result = caseConcept(showsStatus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AppletPackage.SINGLE_TASK_THREAD: {
				SingleTaskThread singleTaskThread = (SingleTaskThread)theEObject;
				T result = caseSingleTaskThread(singleTaskThread);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Applet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Applet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplet(Applet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Overrides Lifecycle Methods</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Overrides Lifecycle Methods</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOverridesLifecycleMethods(OverridesLifecycleMethods object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Applet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Applet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsApplet(ExtendsApplet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registers Mouse Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registers Mouse Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistersMouseListener(RegistersMouseListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registers Mouse Motion Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registers Mouse Motion Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistersMouseMotionListener(RegistersMouseMotionListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registers Key Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registers Key Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistersKeyListener(RegistersKeyListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>This Mouse Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>This Mouse Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThisMouseListener(ThisMouseListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>This Mouse Motion Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>This Mouse Motion Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThisMouseMotionListener(ThisMouseMotionListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>This Key Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>This Key Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThisKeyListener(ThisKeyListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deregisters This</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deregisters This</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeregistersThis(DeregistersThis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Listener Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Listener Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseListenerField(MouseListenerField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Motion Listener Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Motion Listener Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseMotionListenerField(MouseMotionListenerField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Listener Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Listener Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyListenerField(KeyListenerField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppletModel(AppletModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThread(ca.uwaterloo.gsd.applet.Thread object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initializes Thread</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initializes Thread</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitializesThread(InitializesThread object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initializes Thread With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initializes Thread With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitializesThreadWith(InitializesThreadWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initializes Thread Subclass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initializes Thread Subclass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitializesThreadSubclass(InitializesThreadSubclass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>This Runnable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>This Runnable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThisRunnable(ThisRunnable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Runnable Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Runnable Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRunnableField(RunnableField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deregisters Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deregisters Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeregistersField(DeregistersField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shows Status</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shows Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShowsStatus(ShowsStatus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Task Thread</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Task Thread</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleTaskThread(SingleTaskThread object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concept</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcept(Concept object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //AppletSwitch
