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
 * $Id: WpiSwitch.java,v 1.20 2008/06/26 19:28:43 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import ca.uwaterloo.gsd.fsml.fsml.Concept;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.wpi.AdapterProvider;
import ca.uwaterloo.gsd.wpi.AdapterRequestor;
import ca.uwaterloo.gsd.wpi.Contributor;
import ca.uwaterloo.gsd.wpi.Deregisters;
import ca.uwaterloo.gsd.wpi.DeregistersSameObject;
import ca.uwaterloo.gsd.wpi.DeregistersSamePartId;
import ca.uwaterloo.gsd.wpi.EditorPart;
import ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor;
import ca.uwaterloo.gsd.wpi.ExtendsEditorPart;
import ca.uwaterloo.gsd.wpi.ExtendsViewPart;
import ca.uwaterloo.gsd.wpi.FieldSelectionProvider;
import ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener;
import ca.uwaterloo.gsd.wpi.GlobalSelectionListener;
import ca.uwaterloo.gsd.wpi.ImplementsIEditorPart;
import ca.uwaterloo.gsd.wpi.ImplementsIViewPart;
import ca.uwaterloo.gsd.wpi.Part;
import ca.uwaterloo.gsd.wpi.PartListener;
import ca.uwaterloo.gsd.wpi.ProvidesAdapter;
import ca.uwaterloo.gsd.wpi.RegistersAPartListener;
import ca.uwaterloo.gsd.wpi.RegistersAs;
import ca.uwaterloo.gsd.wpi.RegistersAsPartListener;
import ca.uwaterloo.gsd.wpi.RegistersAsPartListener2;
import ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider;
import ca.uwaterloo.gsd.wpi.RequestsAdapter;
import ca.uwaterloo.gsd.wpi.SelectionListener;
import ca.uwaterloo.gsd.wpi.SelectionProvider;
import ca.uwaterloo.gsd.wpi.SpecificSelectionListener;
import ca.uwaterloo.gsd.wpi.ThisSelectionProvider;
import ca.uwaterloo.gsd.wpi.ViewPart;
import ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions;
import ca.uwaterloo.gsd.wpi.WpiPackage;

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
 * @see ca.uwaterloo.gsd.wpi.WpiPackage
 * @generated
 */
public class WpiSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WpiPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpiSwitch() {
		if (modelPackage == null) {
			modelPackage = WpiPackage.eINSTANCE;
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
			case WpiPackage.WORKBENCH_PART_INTERACTIONS: {
				WorkbenchPartInteractions workbenchPartInteractions = (WorkbenchPartInteractions)theEObject;
				T result = caseWorkbenchPartInteractions(workbenchPartInteractions);
				if (result == null) result = caseConcept(workbenchPartInteractions);
				if (result == null) result = caseModel(workbenchPartInteractions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.PART: {
				Part part = (Part)theEObject;
				T result = casePart(part);
				if (result == null) result = caseConcept(part);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.VIEW_PART: {
				ViewPart viewPart = (ViewPart)theEObject;
				T result = caseViewPart(viewPart);
				if (result == null) result = casePart(viewPart);
				if (result == null) result = caseConcept(viewPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.IMPLEMENTS_IVIEW_PART: {
				ImplementsIViewPart implementsIViewPart = (ImplementsIViewPart)theEObject;
				T result = caseImplementsIViewPart(implementsIViewPart);
				if (result == null) result = caseConcept(implementsIViewPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.EXTENDS_VIEW_PART: {
				ExtendsViewPart extendsViewPart = (ExtendsViewPart)theEObject;
				T result = caseExtendsViewPart(extendsViewPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.EDITOR_PART: {
				EditorPart editorPart = (EditorPart)theEObject;
				T result = caseEditorPart(editorPart);
				if (result == null) result = casePart(editorPart);
				if (result == null) result = caseConcept(editorPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.CONTRIBUTOR: {
				Contributor contributor = (Contributor)theEObject;
				T result = caseContributor(contributor);
				if (result == null) result = caseConcept(contributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR: {
				ExtendsEditorActionBarContributor extendsEditorActionBarContributor = (ExtendsEditorActionBarContributor)theEObject;
				T result = caseExtendsEditorActionBarContributor(extendsEditorActionBarContributor);
				if (result == null) result = caseConcept(extendsEditorActionBarContributor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.IMPLEMENTS_IEDITOR_PART: {
				ImplementsIEditorPart implementsIEditorPart = (ImplementsIEditorPart)theEObject;
				T result = caseImplementsIEditorPart(implementsIEditorPart);
				if (result == null) result = caseConcept(implementsIEditorPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.EXTENDS_EDITOR_PART: {
				ExtendsEditorPart extendsEditorPart = (ExtendsEditorPart)theEObject;
				T result = caseExtendsEditorPart(extendsEditorPart);
				if (result == null) result = caseConcept(extendsEditorPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.SELECTION_PROVIDER: {
				SelectionProvider selectionProvider = (SelectionProvider)theEObject;
				T result = caseSelectionProvider(selectionProvider);
				if (result == null) result = caseConcept(selectionProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER: {
				RegistersAsSelectionProvider registersAsSelectionProvider = (RegistersAsSelectionProvider)theEObject;
				T result = caseRegistersAsSelectionProvider(registersAsSelectionProvider);
				if (result == null) result = caseConcept(registersAsSelectionProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.THIS_SELECTION_PROVIDER: {
				ThisSelectionProvider thisSelectionProvider = (ThisSelectionProvider)theEObject;
				T result = caseThisSelectionProvider(thisSelectionProvider);
				if (result == null) result = caseConcept(thisSelectionProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.FIELD_SELECTION_PROVIDER: {
				FieldSelectionProvider fieldSelectionProvider = (FieldSelectionProvider)theEObject;
				T result = caseFieldSelectionProvider(fieldSelectionProvider);
				if (result == null) result = caseConcept(fieldSelectionProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.SELECTION_LISTENER: {
				SelectionListener selectionListener = (SelectionListener)theEObject;
				T result = caseSelectionListener(selectionListener);
				if (result == null) result = caseConcept(selectionListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.REGISTERS_AS: {
				RegistersAs registersAs = (RegistersAs)theEObject;
				T result = caseRegistersAs(registersAs);
				if (result == null) result = caseConcept(registersAs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.GLOBAL_SELECTION_LISTENER: {
				GlobalSelectionListener globalSelectionListener = (GlobalSelectionListener)theEObject;
				T result = caseGlobalSelectionListener(globalSelectionListener);
				if (result == null) result = caseConcept(globalSelectionListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.GLOBAL_POST_SELECTION_LISTENER: {
				GlobalPostSelectionListener globalPostSelectionListener = (GlobalPostSelectionListener)theEObject;
				T result = caseGlobalPostSelectionListener(globalPostSelectionListener);
				if (result == null) result = caseConcept(globalPostSelectionListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.SPECIFIC_SELECTION_LISTENER: {
				SpecificSelectionListener specificSelectionListener = (SpecificSelectionListener)theEObject;
				T result = caseSpecificSelectionListener(specificSelectionListener);
				if (result == null) result = caseConcept(specificSelectionListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.DEREGISTERS_SAME_PART_ID: {
				DeregistersSamePartId deregistersSamePartId = (DeregistersSamePartId)theEObject;
				T result = caseDeregistersSamePartId(deregistersSamePartId);
				if (result == null) result = caseConcept(deregistersSamePartId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.PART_LISTENER: {
				PartListener partListener = (PartListener)theEObject;
				T result = casePartListener(partListener);
				if (result == null) result = caseConcept(partListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.REGISTERS_APART_LISTENER: {
				RegistersAPartListener registersAPartListener = (RegistersAPartListener)theEObject;
				T result = caseRegistersAPartListener(registersAPartListener);
				if (result == null) result = caseConcept(registersAPartListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.REGISTERS_AS_PART_LISTENER: {
				RegistersAsPartListener registersAsPartListener = (RegistersAsPartListener)theEObject;
				T result = caseRegistersAsPartListener(registersAsPartListener);
				if (result == null) result = caseConcept(registersAsPartListener);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.REGISTERS_AS_PART_LISTENER2: {
				RegistersAsPartListener2 registersAsPartListener2 = (RegistersAsPartListener2)theEObject;
				T result = caseRegistersAsPartListener2(registersAsPartListener2);
				if (result == null) result = caseConcept(registersAsPartListener2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.DEREGISTERS: {
				Deregisters deregisters = (Deregisters)theEObject;
				T result = caseDeregisters(deregisters);
				if (result == null) result = caseConcept(deregisters);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.DEREGISTERS_SAME_OBJECT: {
				DeregistersSameObject deregistersSameObject = (DeregistersSameObject)theEObject;
				T result = caseDeregistersSameObject(deregistersSameObject);
				if (result == null) result = caseConcept(deregistersSameObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.ADAPTER_PROVIDER: {
				AdapterProvider adapterProvider = (AdapterProvider)theEObject;
				T result = caseAdapterProvider(adapterProvider);
				if (result == null) result = caseConcept(adapterProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.PROVIDES_ADAPTER: {
				ProvidesAdapter providesAdapter = (ProvidesAdapter)theEObject;
				T result = caseProvidesAdapter(providesAdapter);
				if (result == null) result = caseConcept(providesAdapter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.ADAPTER_REQUESTOR: {
				AdapterRequestor adapterRequestor = (AdapterRequestor)theEObject;
				T result = caseAdapterRequestor(adapterRequestor);
				if (result == null) result = caseConcept(adapterRequestor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WpiPackage.REQUESTS_ADAPTER: {
				RequestsAdapter requestsAdapter = (RequestsAdapter)theEObject;
				T result = caseRequestsAdapter(requestsAdapter);
				if (result == null) result = caseConcept(requestsAdapter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workbench Part Interactions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workbench Part Interactions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkbenchPartInteractions(WorkbenchPartInteractions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePart(Part object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewPart(ViewPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implements IView Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implements IView Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementsIViewPart(ImplementsIViewPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends View Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends View Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsViewPart(ExtendsViewPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditorPart(EditorPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContributor(Contributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Editor Action Bar Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Editor Action Bar Contributor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsEditorActionBarContributor(ExtendsEditorActionBarContributor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implements IEditor Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implements IEditor Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementsIEditorPart(ImplementsIEditorPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extends Editor Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extends Editor Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendsEditorPart(ExtendsEditorPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionProvider(SelectionProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registers As Selection Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registers As Selection Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistersAsSelectionProvider(RegistersAsSelectionProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>This Selection Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>This Selection Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThisSelectionProvider(ThisSelectionProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field Selection Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field Selection Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFieldSelectionProvider(FieldSelectionProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionListener(SelectionListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registers As</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registers As</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistersAs(RegistersAs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Selection Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Selection Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalSelectionListener(GlobalSelectionListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Post Selection Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Post Selection Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalPostSelectionListener(GlobalPostSelectionListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Selection Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Selection Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificSelectionListener(SpecificSelectionListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deregisters Same Part Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deregisters Same Part Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeregistersSamePartId(DeregistersSamePartId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Part Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Part Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartListener(PartListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registers APart Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registers APart Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistersAPartListener(RegistersAPartListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registers As Part Listener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registers As Part Listener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistersAsPartListener(RegistersAsPartListener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Registers As Part Listener2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Registers As Part Listener2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegistersAsPartListener2(RegistersAsPartListener2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deregisters</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deregisters</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeregisters(Deregisters object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deregisters Same Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deregisters Same Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeregistersSameObject(DeregistersSameObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter Requestor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter Requestor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdapterRequestor(AdapterRequestor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requests Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requests Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequestsAdapter(RequestsAdapter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdapterProvider(AdapterProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Provides Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provides Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProvidesAdapter(ProvidesAdapter object) {
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

} //WpiSwitch
