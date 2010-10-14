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
 * $Id: WpiFactoryImpl.java,v 1.17 2008/06/26 19:28:45 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import ca.uwaterloo.gsd.wpi.WpiFactory;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WpiFactoryImpl extends EFactoryImpl implements WpiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WpiFactory init() {
		try {
			WpiFactory theWpiFactory = (WpiFactory)EPackage.Registry.INSTANCE.getEFactory("http://ca.uwaterloo.gsd/wpi"); 
			if (theWpiFactory != null) {
				return theWpiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WpiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpiFactoryImpl() {
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
			case WpiPackage.WORKBENCH_PART_INTERACTIONS: return createWorkbenchPartInteractions();
			case WpiPackage.VIEW_PART: return createViewPart();
			case WpiPackage.IMPLEMENTS_IVIEW_PART: return createImplementsIViewPart();
			case WpiPackage.EXTENDS_VIEW_PART: return createExtendsViewPart();
			case WpiPackage.EDITOR_PART: return createEditorPart();
			case WpiPackage.CONTRIBUTOR: return createContributor();
			case WpiPackage.EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR: return createExtendsEditorActionBarContributor();
			case WpiPackage.IMPLEMENTS_IEDITOR_PART: return createImplementsIEditorPart();
			case WpiPackage.EXTENDS_EDITOR_PART: return createExtendsEditorPart();
			case WpiPackage.SELECTION_PROVIDER: return createSelectionProvider();
			case WpiPackage.REGISTERS_AS_SELECTION_PROVIDER: return createRegistersAsSelectionProvider();
			case WpiPackage.THIS_SELECTION_PROVIDER: return createThisSelectionProvider();
			case WpiPackage.FIELD_SELECTION_PROVIDER: return createFieldSelectionProvider();
			case WpiPackage.SELECTION_LISTENER: return createSelectionListener();
			case WpiPackage.REGISTERS_AS: return createRegistersAs();
			case WpiPackage.GLOBAL_SELECTION_LISTENER: return createGlobalSelectionListener();
			case WpiPackage.GLOBAL_POST_SELECTION_LISTENER: return createGlobalPostSelectionListener();
			case WpiPackage.SPECIFIC_SELECTION_LISTENER: return createSpecificSelectionListener();
			case WpiPackage.DEREGISTERS_SAME_PART_ID: return createDeregistersSamePartId();
			case WpiPackage.PART_LISTENER: return createPartListener();
			case WpiPackage.REGISTERS_APART_LISTENER: return createRegistersAPartListener();
			case WpiPackage.REGISTERS_AS_PART_LISTENER: return createRegistersAsPartListener();
			case WpiPackage.REGISTERS_AS_PART_LISTENER2: return createRegistersAsPartListener2();
			case WpiPackage.DEREGISTERS: return createDeregisters();
			case WpiPackage.DEREGISTERS_SAME_OBJECT: return createDeregistersSameObject();
			case WpiPackage.ADAPTER_PROVIDER: return createAdapterProvider();
			case WpiPackage.PROVIDES_ADAPTER: return createProvidesAdapter();
			case WpiPackage.ADAPTER_REQUESTOR: return createAdapterRequestor();
			case WpiPackage.REQUESTS_ADAPTER: return createRequestsAdapter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkbenchPartInteractions createWorkbenchPartInteractions() {
		WorkbenchPartInteractionsImpl workbenchPartInteractions = new WorkbenchPartInteractionsImpl();
		return workbenchPartInteractions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewPart createViewPart() {
		ViewPartImpl viewPart = new ViewPartImpl();
		return viewPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementsIViewPart createImplementsIViewPart() {
		ImplementsIViewPartImpl implementsIViewPart = new ImplementsIViewPartImpl();
		return implementsIViewPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsViewPart createExtendsViewPart() {
		ExtendsViewPartImpl extendsViewPart = new ExtendsViewPartImpl();
		return extendsViewPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorPart createEditorPart() {
		EditorPartImpl editorPart = new EditorPartImpl();
		return editorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contributor createContributor() {
		ContributorImpl contributor = new ContributorImpl();
		return contributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsEditorActionBarContributor createExtendsEditorActionBarContributor() {
		ExtendsEditorActionBarContributorImpl extendsEditorActionBarContributor = new ExtendsEditorActionBarContributorImpl();
		return extendsEditorActionBarContributor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementsIEditorPart createImplementsIEditorPart() {
		ImplementsIEditorPartImpl implementsIEditorPart = new ImplementsIEditorPartImpl();
		return implementsIEditorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsEditorPart createExtendsEditorPart() {
		ExtendsEditorPartImpl extendsEditorPart = new ExtendsEditorPartImpl();
		return extendsEditorPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionProvider createSelectionProvider() {
		SelectionProviderImpl selectionProvider = new SelectionProviderImpl();
		return selectionProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersAsSelectionProvider createRegistersAsSelectionProvider() {
		RegistersAsSelectionProviderImpl registersAsSelectionProvider = new RegistersAsSelectionProviderImpl();
		return registersAsSelectionProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisSelectionProvider createThisSelectionProvider() {
		ThisSelectionProviderImpl thisSelectionProvider = new ThisSelectionProviderImpl();
		return thisSelectionProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldSelectionProvider createFieldSelectionProvider() {
		FieldSelectionProviderImpl fieldSelectionProvider = new FieldSelectionProviderImpl();
		return fieldSelectionProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionListener createSelectionListener() {
		SelectionListenerImpl selectionListener = new SelectionListenerImpl();
		return selectionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersAs createRegistersAs() {
		RegistersAsImpl registersAs = new RegistersAsImpl();
		return registersAs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalSelectionListener createGlobalSelectionListener() {
		GlobalSelectionListenerImpl globalSelectionListener = new GlobalSelectionListenerImpl();
		return globalSelectionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalPostSelectionListener createGlobalPostSelectionListener() {
		GlobalPostSelectionListenerImpl globalPostSelectionListener = new GlobalPostSelectionListenerImpl();
		return globalPostSelectionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificSelectionListener createSpecificSelectionListener() {
		SpecificSelectionListenerImpl specificSelectionListener = new SpecificSelectionListenerImpl();
		return specificSelectionListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeregistersSamePartId createDeregistersSamePartId() {
		DeregistersSamePartIdImpl deregistersSamePartId = new DeregistersSamePartIdImpl();
		return deregistersSamePartId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartListener createPartListener() {
		PartListenerImpl partListener = new PartListenerImpl();
		return partListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersAPartListener createRegistersAPartListener() {
		RegistersAPartListenerImpl registersAPartListener = new RegistersAPartListenerImpl();
		return registersAPartListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersAsPartListener createRegistersAsPartListener() {
		RegistersAsPartListenerImpl registersAsPartListener = new RegistersAsPartListenerImpl();
		return registersAsPartListener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistersAsPartListener2 createRegistersAsPartListener2() {
		RegistersAsPartListener2Impl registersAsPartListener2 = new RegistersAsPartListener2Impl();
		return registersAsPartListener2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deregisters createDeregisters() {
		DeregistersImpl deregisters = new DeregistersImpl();
		return deregisters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeregistersSameObject createDeregistersSameObject() {
		DeregistersSameObjectImpl deregistersSameObject = new DeregistersSameObjectImpl();
		return deregistersSameObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterRequestor createAdapterRequestor() {
		AdapterRequestorImpl adapterRequestor = new AdapterRequestorImpl();
		return adapterRequestor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestsAdapter createRequestsAdapter() {
		RequestsAdapterImpl requestsAdapter = new RequestsAdapterImpl();
		return requestsAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterProvider createAdapterProvider() {
		AdapterProviderImpl adapterProvider = new AdapterProviderImpl();
		return adapterProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesAdapter createProvidesAdapter() {
		ProvidesAdapterImpl providesAdapter = new ProvidesAdapterImpl();
		return providesAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpiPackage getWpiPackage() {
		return (WpiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WpiPackage getPackage() {
		return WpiPackage.eINSTANCE;
	}

} //WpiFactoryImpl
