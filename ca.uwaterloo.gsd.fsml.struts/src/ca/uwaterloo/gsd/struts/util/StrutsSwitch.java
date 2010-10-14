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
 * $Id: StrutsSwitch.java,v 1.23 2009/04/21 16:47:57 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import ca.uwaterloo.gsd.fsml.fsml.Concept;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.struts.ActionDecl;
import ca.uwaterloo.gsd.struts.ActionImpl;
import ca.uwaterloo.gsd.struts.ExtendsAction;
import ca.uwaterloo.gsd.struts.ExtendsActionForm;
import ca.uwaterloo.gsd.struts.ExtendsDispatchAction;
import ca.uwaterloo.gsd.struts.FormDecl;
import ca.uwaterloo.gsd.struts.FormImpl;
import ca.uwaterloo.gsd.struts.FormProperty;
import ca.uwaterloo.gsd.struts.Forward;
import ca.uwaterloo.gsd.struts.ForwardDecl;
import ca.uwaterloo.gsd.struts.ForwardImpl;
import ca.uwaterloo.gsd.struts.InputForwardImpl;
import ca.uwaterloo.gsd.struts.StrutsApplication;
import ca.uwaterloo.gsd.struts.StrutsConfig;
import ca.uwaterloo.gsd.struts.StrutsPackage;

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
 * @see ca.uwaterloo.gsd.struts.StrutsPackage
 * @generated
 */
public class StrutsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StrutsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsSwitch() {
		if (modelPackage == null) {
			modelPackage = StrutsPackage.eINSTANCE;
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
			case StrutsPackage.STRUTS_APPLICATION: {
				StrutsApplication strutsApplication = (StrutsApplication)theEObject;
				T result = caseStrutsApplication(strutsApplication);
				if (result == null) result = caseConcept(strutsApplication);
				if (result == null) result = caseModel(strutsApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.FORM_IMPL: {
				FormImpl formImpl = (FormImpl)theEObject;
				T result = caseFormImpl(formImpl);
				if (result == null) result = caseConcept(formImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.EXTENDS_ACTION_FORM: {
				ExtendsActionForm extendsActionForm = (ExtendsActionForm)theEObject;
				T result = caseExtendsActionForm(extendsActionForm);
				if (result == null) result = caseConcept(extendsActionForm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.ACTION_IMPL: {
				ActionImpl actionImpl = (ActionImpl)theEObject;
				T result = caseActionImpl(actionImpl);
				if (result == null) result = caseConcept(actionImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.FORWARD_IMPL: {
				ForwardImpl forwardImpl = (ForwardImpl)theEObject;
				T result = caseForwardImpl(forwardImpl);
				if (result == null) result = caseConcept(forwardImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.INPUT_FORWARD_IMPL: {
				InputForwardImpl inputForwardImpl = (InputForwardImpl)theEObject;
				T result = caseInputForwardImpl(inputForwardImpl);
				if (result == null) result = caseConcept(inputForwardImpl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.FORWARD: {
				Forward forward = (Forward)theEObject;
				T result = caseForward(forward);
				if (result == null) result = caseConcept(forward);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.EXTENDS_ACTION: {
				ExtendsAction extendsAction = (ExtendsAction)theEObject;
				T result = caseExtendsAction(extendsAction);
				if (result == null) result = caseConcept(extendsAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.EXTENDS_DISPATCH_ACTION: {
				ExtendsDispatchAction extendsDispatchAction = (ExtendsDispatchAction)theEObject;
				T result = caseExtendsDispatchAction(extendsDispatchAction);
				if (result == null) result = caseConcept(extendsDispatchAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.STRUTS_CONFIG: {
				StrutsConfig strutsConfig = (StrutsConfig)theEObject;
				T result = caseStrutsConfig(strutsConfig);
				if (result == null) result = caseConcept(strutsConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.ACTION_DECL: {
				ActionDecl actionDecl = (ActionDecl)theEObject;
				T result = caseActionDecl(actionDecl);
				if (result == null) result = caseConcept(actionDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.FORM_DECL: {
				FormDecl formDecl = (FormDecl)theEObject;
				T result = caseFormDecl(formDecl);
				if (result == null) result = caseConcept(formDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.FORWARD_DECL: {
				ForwardDecl forwardDecl = (ForwardDecl)theEObject;
				T result = caseForwardDecl(forwardDecl);
				if (result == null) result = caseConcept(forwardDecl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrutsPackage.FORM_PROPERTY: {
				FormProperty formProperty = (FormProperty)theEObject;
				T result = caseFormProperty(formProperty);
				if (result == null) result = caseConcept(formProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrutsApplication(StrutsApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormImpl(FormImpl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Action Form</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Action Form</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsActionForm(ExtendsActionForm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionImpl(ActionImpl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forward Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forward Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForwardImpl(ForwardImpl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Forward Impl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Forward Impl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputForwardImpl(InputForwardImpl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forward</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forward</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForward(Forward object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsAction(ExtendsAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Dispatch Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Dispatch Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsDispatchAction(ExtendsDispatchAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrutsConfig(StrutsConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionDecl(ActionDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormDecl(FormDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forward Decl</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forward Decl</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForwardDecl(ForwardDecl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormProperty(FormProperty object) {
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

} //StrutsSwitch
