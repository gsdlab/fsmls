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
 * $Id: WpiAdapterFactory.java,v 1.19 2008/06/26 19:28:44 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.wpi.WpiPackage
 * @generated
 */
public class WpiAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WpiPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpiAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WpiPackage.eINSTANCE;
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
	protected WpiSwitch<Adapter> modelSwitch =
		new WpiSwitch<Adapter>() {
			@Override
			public Adapter caseWorkbenchPartInteractions(WorkbenchPartInteractions object) {
				return createWorkbenchPartInteractionsAdapter();
			}
			@Override
			public Adapter casePart(Part object) {
				return createPartAdapter();
			}
			@Override
			public Adapter caseViewPart(ViewPart object) {
				return createViewPartAdapter();
			}
			@Override
			public Adapter caseImplementsIViewPart(ImplementsIViewPart object) {
				return createImplementsIViewPartAdapter();
			}
			@Override
			public Adapter caseExtendsViewPart(ExtendsViewPart object) {
				return createExtendsViewPartAdapter();
			}
			@Override
			public Adapter caseEditorPart(EditorPart object) {
				return createEditorPartAdapter();
			}
			@Override
			public Adapter caseContributor(Contributor object) {
				return createContributorAdapter();
			}
			@Override
			public Adapter caseExtendsEditorActionBarContributor(ExtendsEditorActionBarContributor object) {
				return createExtendsEditorActionBarContributorAdapter();
			}
			@Override
			public Adapter caseImplementsIEditorPart(ImplementsIEditorPart object) {
				return createImplementsIEditorPartAdapter();
			}
			@Override
			public Adapter caseExtendsEditorPart(ExtendsEditorPart object) {
				return createExtendsEditorPartAdapter();
			}
			@Override
			public Adapter caseSelectionProvider(SelectionProvider object) {
				return createSelectionProviderAdapter();
			}
			@Override
			public Adapter caseRegistersAsSelectionProvider(RegistersAsSelectionProvider object) {
				return createRegistersAsSelectionProviderAdapter();
			}
			@Override
			public Adapter caseThisSelectionProvider(ThisSelectionProvider object) {
				return createThisSelectionProviderAdapter();
			}
			@Override
			public Adapter caseFieldSelectionProvider(FieldSelectionProvider object) {
				return createFieldSelectionProviderAdapter();
			}
			@Override
			public Adapter caseSelectionListener(SelectionListener object) {
				return createSelectionListenerAdapter();
			}
			@Override
			public Adapter caseRegistersAs(RegistersAs object) {
				return createRegistersAsAdapter();
			}
			@Override
			public Adapter caseGlobalSelectionListener(GlobalSelectionListener object) {
				return createGlobalSelectionListenerAdapter();
			}
			@Override
			public Adapter caseGlobalPostSelectionListener(GlobalPostSelectionListener object) {
				return createGlobalPostSelectionListenerAdapter();
			}
			@Override
			public Adapter caseSpecificSelectionListener(SpecificSelectionListener object) {
				return createSpecificSelectionListenerAdapter();
			}
			@Override
			public Adapter caseDeregistersSamePartId(DeregistersSamePartId object) {
				return createDeregistersSamePartIdAdapter();
			}
			@Override
			public Adapter casePartListener(PartListener object) {
				return createPartListenerAdapter();
			}
			@Override
			public Adapter caseRegistersAPartListener(RegistersAPartListener object) {
				return createRegistersAPartListenerAdapter();
			}
			@Override
			public Adapter caseRegistersAsPartListener(RegistersAsPartListener object) {
				return createRegistersAsPartListenerAdapter();
			}
			@Override
			public Adapter caseRegistersAsPartListener2(RegistersAsPartListener2 object) {
				return createRegistersAsPartListener2Adapter();
			}
			@Override
			public Adapter caseDeregisters(Deregisters object) {
				return createDeregistersAdapter();
			}
			@Override
			public Adapter caseDeregistersSameObject(DeregistersSameObject object) {
				return createDeregistersSameObjectAdapter();
			}
			@Override
			public Adapter caseAdapterProvider(AdapterProvider object) {
				return createAdapterProviderAdapter();
			}
			@Override
			public Adapter caseProvidesAdapter(ProvidesAdapter object) {
				return createProvidesAdapterAdapter();
			}
			@Override
			public Adapter caseAdapterRequestor(AdapterRequestor object) {
				return createAdapterRequestorAdapter();
			}
			@Override
			public Adapter caseRequestsAdapter(RequestsAdapter object) {
				return createRequestsAdapterAdapter();
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
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions <em>Workbench Part Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions
	 * @generated
	 */
	public Adapter createWorkbenchPartInteractionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.Part
	 * @generated
	 */
	public Adapter createPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.ViewPart <em>View Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.ViewPart
	 * @generated
	 */
	public Adapter createViewPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.ImplementsIViewPart <em>Implements IView Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.ImplementsIViewPart
	 * @generated
	 */
	public Adapter createImplementsIViewPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.ExtendsViewPart <em>Extends View Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsViewPart
	 * @generated
	 */
	public Adapter createExtendsViewPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.EditorPart <em>Editor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.EditorPart
	 * @generated
	 */
	public Adapter createEditorPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.Contributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.Contributor
	 * @generated
	 */
	public Adapter createContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor <em>Extends Editor Action Bar Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor
	 * @generated
	 */
	public Adapter createExtendsEditorActionBarContributorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.ImplementsIEditorPart <em>Implements IEditor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.ImplementsIEditorPart
	 * @generated
	 */
	public Adapter createImplementsIEditorPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.ExtendsEditorPart <em>Extends Editor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsEditorPart
	 * @generated
	 */
	public Adapter createExtendsEditorPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.SelectionProvider <em>Selection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.SelectionProvider
	 * @generated
	 */
	public Adapter createSelectionProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider <em>Registers As Selection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider
	 * @generated
	 */
	public Adapter createRegistersAsSelectionProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.ThisSelectionProvider <em>This Selection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.ThisSelectionProvider
	 * @generated
	 */
	public Adapter createThisSelectionProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider <em>Field Selection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.FieldSelectionProvider
	 * @generated
	 */
	public Adapter createFieldSelectionProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.SelectionListener <em>Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.SelectionListener
	 * @generated
	 */
	public Adapter createSelectionListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.RegistersAs <em>Registers As</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAs
	 * @generated
	 */
	public Adapter createRegistersAsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.GlobalSelectionListener <em>Global Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.GlobalSelectionListener
	 * @generated
	 */
	public Adapter createGlobalSelectionListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener <em>Global Post Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener
	 * @generated
	 */
	public Adapter createGlobalPostSelectionListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener <em>Specific Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.SpecificSelectionListener
	 * @generated
	 */
	public Adapter createSpecificSelectionListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId <em>Deregisters Same Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.DeregistersSamePartId
	 * @generated
	 */
	public Adapter createDeregistersSamePartIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.PartListener <em>Part Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.PartListener
	 * @generated
	 */
	public Adapter createPartListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.RegistersAPartListener <em>Registers APart Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAPartListener
	 * @generated
	 */
	public Adapter createRegistersAPartListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.RegistersAsPartListener <em>Registers As Part Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsPartListener
	 * @generated
	 */
	public Adapter createRegistersAsPartListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.RegistersAsPartListener2 <em>Registers As Part Listener2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsPartListener2
	 * @generated
	 */
	public Adapter createRegistersAsPartListener2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.Deregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.Deregisters
	 * @generated
	 */
	public Adapter createDeregistersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.DeregistersSameObject <em>Deregisters Same Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.DeregistersSameObject
	 * @generated
	 */
	public Adapter createDeregistersSameObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.AdapterRequestor <em>Adapter Requestor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.AdapterRequestor
	 * @generated
	 */
	public Adapter createAdapterRequestorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.RequestsAdapter <em>Requests Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.RequestsAdapter
	 * @generated
	 */
	public Adapter createRequestsAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.AdapterProvider <em>Adapter Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.AdapterProvider
	 * @generated
	 */
	public Adapter createAdapterProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.wpi.ProvidesAdapter <em>Provides Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.wpi.ProvidesAdapter
	 * @generated
	 */
	public Adapter createProvidesAdapterAdapter() {
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

} //WpiAdapterFactory
