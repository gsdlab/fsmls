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
 * $Id: WpiPackageImpl.java,v 1.42 2008/07/01 19:45:30 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import ca.uwaterloo.gsd.fsml.fsml.FsmlPackage;
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
import ca.uwaterloo.gsd.wpi.WpiFactory;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WpiPackageImpl extends EPackageImpl implements WpiPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workbenchPartInteractionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementsIViewPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsViewPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editorPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsEditorActionBarContributorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementsIEditorPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsEditorPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registersAsSelectionProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thisSelectionProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldSelectionProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registersAsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalSelectionListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalPostSelectionListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificSelectionListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deregistersSamePartIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registersAPartListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registersAsPartListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registersAsPartListener2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deregistersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deregistersSameObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterRequestorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestsAdapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providesAdapterEClass = null;

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
	 * @see ca.uwaterloo.gsd.wpi.WpiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WpiPackageImpl() {
		super(eNS_URI, WpiFactory.eINSTANCE);
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
	public static WpiPackage init() {
		if (isInited) return (WpiPackage)EPackage.Registry.INSTANCE.getEPackage(WpiPackage.eNS_URI);

		// Obtain or create and register package
		WpiPackageImpl theWpiPackage = (WpiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WpiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WpiPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		FsmlPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWpiPackage.createPackageContents();

		// Initialize created meta-data
		theWpiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWpiPackage.freeze();

		return theWpiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkbenchPartInteractions() {
		return workbenchPartInteractionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorkbenchPartInteractions_Project() {
		return (EAttribute)workbenchPartInteractionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkbenchPartInteractions_Parts() {
		return (EReference)workbenchPartInteractionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkbenchPartInteractions_SelectionProviders() {
		return (EReference)workbenchPartInteractionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkbenchPartInteractions_SelectionListeners() {
		return (EReference)workbenchPartInteractionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkbenchPartInteractions_PartListeners() {
		return (EReference)workbenchPartInteractionsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkbenchPartInteractions_AdapterProviders() {
		return (EReference)workbenchPartInteractionsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkbenchPartInteractions_AdapterRequestors() {
		return (EReference)workbenchPartInteractionsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPart() {
		return partEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPart_Name() {
		return (EAttribute)partEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPart_Package() {
		return (EAttribute)partEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPart_Local() {
		return (EAttribute)partEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewPart() {
		return viewPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewPart_PartId() {
		return (EAttribute)viewPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewPart_ImplementsIViewPart() {
		return (EReference)viewPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementsIViewPart() {
		return implementsIViewPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementsIViewPart_ExtendsViewPart() {
		return (EReference)implementsIViewPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsViewPart() {
		return extendsViewPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsViewPart_ExtendsPageBookView() {
		return (EAttribute)extendsViewPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditorPart() {
		return editorPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditorPart_PartId() {
		return (EAttribute)editorPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditorPart_Contributor() {
		return (EReference)editorPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditorPart_ImplementsIEditorPart() {
		return (EReference)editorPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContributor() {
		return contributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContributor_Contributor() {
		return (EAttribute)contributorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContributor_ExtendsEditorActionBarContributor() {
		return (EReference)contributorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsEditorActionBarContributor() {
		return extendsEditorActionBarContributorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsEditorActionBarContributor_ExtendsMultiPageEditorActionBarContributor() {
		return (EAttribute)extendsEditorActionBarContributorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementsIEditorPart() {
		return implementsIEditorPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementsIEditorPart_ExtendsEditorPart() {
		return (EReference)implementsIEditorPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsEditorPart() {
		return extendsEditorPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsEditorPart_ExtendsMultiPageEditorPart() {
		return (EAttribute)extendsEditorPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionProvider() {
		return selectionProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionProvider_Provider() {
		return (EReference)selectionProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionProvider_Registers() {
		return (EReference)selectionProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistersAsSelectionProvider() {
		return registersAsSelectionProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAsSelectionProvider_RegistersThis() {
		return (EReference)registersAsSelectionProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAsSelectionProvider_RegistersField() {
		return (EReference)registersAsSelectionProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThisSelectionProvider() {
		return thisSelectionProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThisSelectionProvider_ImplementsISelectionProvider() {
		return (EAttribute)thisSelectionProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFieldSelectionProvider() {
		return fieldSelectionProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldSelectionProvider_Field() {
		return (EAttribute)fieldSelectionProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldSelectionProvider_TypedISelectionProvider() {
		return (EAttribute)fieldSelectionProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldSelectionProvider_Initialized() {
		return (EAttribute)fieldSelectionProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistersAsSelectionProvider_RegistersHelper() {
		return (EAttribute)registersAsSelectionProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegistersAsSelectionProvider_RegistersVariable() {
		return (EAttribute)registersAsSelectionProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionListener() {
		return selectionListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionListener_Listener() {
		return (EReference)selectionListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionListener_RegistersAs() {
		return (EReference)selectionListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistersAs() {
		return registersAsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAs_GlobalSelectionListener() {
		return (EReference)registersAsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAs_GlobalPostSelectionListener() {
		return (EReference)registersAsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAs_SpecificSelectionListener() {
		return (EReference)registersAsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalSelectionListener() {
		return globalSelectionListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalSelectionListener_Deregisters() {
		return (EReference)globalSelectionListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalPostSelectionListener() {
		return globalPostSelectionListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalPostSelectionListener_Deregisters() {
		return (EReference)globalPostSelectionListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificSelectionListener() {
		return specificSelectionListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecificSelectionListener_RegistrationPartId() {
		return (EAttribute)specificSelectionListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificSelectionListener_Provider() {
		return (EReference)specificSelectionListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecificSelectionListener_ProviderName() {
		return (EAttribute)specificSelectionListenerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificSelectionListener_Deregisters() {
		return (EReference)specificSelectionListenerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeregistersSamePartId() {
		return deregistersSamePartIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeregistersSamePartId_DeregistrationPartId() {
		return (EAttribute)deregistersSamePartIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeregistersSamePartId_DeregistersSameObject() {
		return (EReference)deregistersSamePartIdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartListener() {
		return partListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartListener_Listener() {
		return (EReference)partListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartListener_RegistersAPartListener() {
		return (EReference)partListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistersAPartListener() {
		return registersAPartListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAPartListener_Registers() {
		return (EReference)registersAPartListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAPartListener_Registers2() {
		return (EReference)registersAPartListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistersAsPartListener() {
		return registersAsPartListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAsPartListener_Deregisters() {
		return (EReference)registersAsPartListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegistersAsPartListener2() {
		return registersAsPartListener2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegistersAsPartListener2_Deregisters() {
		return (EReference)registersAsPartListener2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeregisters() {
		return deregistersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeregisters_DeregistersSameObject() {
		return (EReference)deregistersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeregistersSameObject() {
		return deregistersSameObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeregistersSameObject_RegistersBeforeDeregisters() {
		return (EAttribute)deregistersSameObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterRequestor() {
		return adapterRequestorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterRequestor_AdapterRequestor() {
		return (EReference)adapterRequestorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterRequestor_RequestsAdapter() {
		return (EReference)adapterRequestorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequestsAdapter() {
		return requestsAdapterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestsAdapter_Adapter() {
		return (EAttribute)requestsAdapterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequestsAdapter_AdapterProvider() {
		return (EReference)requestsAdapterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapterProvider() {
		return adapterProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterProvider_AdapterProvider() {
		return (EReference)adapterProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdapterProvider_ProvidesAdapter() {
		return (EReference)adapterProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidesAdapter() {
		return providesAdapterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidesAdapter_Adapters() {
		return (EAttribute)providesAdapterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WpiFactory getWpiFactory() {
		return (WpiFactory)getEFactoryInstance();
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
		workbenchPartInteractionsEClass = createEClass(WORKBENCH_PART_INTERACTIONS);
		createEAttribute(workbenchPartInteractionsEClass, WORKBENCH_PART_INTERACTIONS__PROJECT);
		createEReference(workbenchPartInteractionsEClass, WORKBENCH_PART_INTERACTIONS__PARTS);
		createEReference(workbenchPartInteractionsEClass, WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS);
		createEReference(workbenchPartInteractionsEClass, WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS);
		createEReference(workbenchPartInteractionsEClass, WORKBENCH_PART_INTERACTIONS__PART_LISTENERS);
		createEReference(workbenchPartInteractionsEClass, WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS);
		createEReference(workbenchPartInteractionsEClass, WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS);

		partEClass = createEClass(PART);
		createEAttribute(partEClass, PART__NAME);
		createEAttribute(partEClass, PART__PACKAGE);
		createEAttribute(partEClass, PART__LOCAL);

		viewPartEClass = createEClass(VIEW_PART);
		createEAttribute(viewPartEClass, VIEW_PART__PART_ID);
		createEReference(viewPartEClass, VIEW_PART__IMPLEMENTS_IVIEW_PART);

		implementsIViewPartEClass = createEClass(IMPLEMENTS_IVIEW_PART);
		createEReference(implementsIViewPartEClass, IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART);

		extendsViewPartEClass = createEClass(EXTENDS_VIEW_PART);
		createEAttribute(extendsViewPartEClass, EXTENDS_VIEW_PART__EXTENDS_PAGE_BOOK_VIEW);

		editorPartEClass = createEClass(EDITOR_PART);
		createEAttribute(editorPartEClass, EDITOR_PART__PART_ID);
		createEReference(editorPartEClass, EDITOR_PART__CONTRIBUTOR);
		createEReference(editorPartEClass, EDITOR_PART__IMPLEMENTS_IEDITOR_PART);

		contributorEClass = createEClass(CONTRIBUTOR);
		createEAttribute(contributorEClass, CONTRIBUTOR__CONTRIBUTOR);
		createEReference(contributorEClass, CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR);

		extendsEditorActionBarContributorEClass = createEClass(EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR);
		createEAttribute(extendsEditorActionBarContributorEClass, EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR__EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR);

		implementsIEditorPartEClass = createEClass(IMPLEMENTS_IEDITOR_PART);
		createEReference(implementsIEditorPartEClass, IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART);

		extendsEditorPartEClass = createEClass(EXTENDS_EDITOR_PART);
		createEAttribute(extendsEditorPartEClass, EXTENDS_EDITOR_PART__EXTENDS_MULTI_PAGE_EDITOR_PART);

		selectionProviderEClass = createEClass(SELECTION_PROVIDER);
		createEReference(selectionProviderEClass, SELECTION_PROVIDER__PROVIDER);
		createEReference(selectionProviderEClass, SELECTION_PROVIDER__REGISTERS);

		registersAsSelectionProviderEClass = createEClass(REGISTERS_AS_SELECTION_PROVIDER);
		createEReference(registersAsSelectionProviderEClass, REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS);
		createEAttribute(registersAsSelectionProviderEClass, REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_HELPER);
		createEAttribute(registersAsSelectionProviderEClass, REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_VARIABLE);
		createEReference(registersAsSelectionProviderEClass, REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD);

		thisSelectionProviderEClass = createEClass(THIS_SELECTION_PROVIDER);
		createEAttribute(thisSelectionProviderEClass, THIS_SELECTION_PROVIDER__IMPLEMENTS_ISELECTION_PROVIDER);

		fieldSelectionProviderEClass = createEClass(FIELD_SELECTION_PROVIDER);
		createEAttribute(fieldSelectionProviderEClass, FIELD_SELECTION_PROVIDER__FIELD);
		createEAttribute(fieldSelectionProviderEClass, FIELD_SELECTION_PROVIDER__TYPED_ISELECTION_PROVIDER);
		createEAttribute(fieldSelectionProviderEClass, FIELD_SELECTION_PROVIDER__INITIALIZED);

		selectionListenerEClass = createEClass(SELECTION_LISTENER);
		createEReference(selectionListenerEClass, SELECTION_LISTENER__LISTENER);
		createEReference(selectionListenerEClass, SELECTION_LISTENER__REGISTERS_AS);

		registersAsEClass = createEClass(REGISTERS_AS);
		createEReference(registersAsEClass, REGISTERS_AS__GLOBAL_SELECTION_LISTENER);
		createEReference(registersAsEClass, REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER);
		createEReference(registersAsEClass, REGISTERS_AS__SPECIFIC_SELECTION_LISTENER);

		globalSelectionListenerEClass = createEClass(GLOBAL_SELECTION_LISTENER);
		createEReference(globalSelectionListenerEClass, GLOBAL_SELECTION_LISTENER__DEREGISTERS);

		globalPostSelectionListenerEClass = createEClass(GLOBAL_POST_SELECTION_LISTENER);
		createEReference(globalPostSelectionListenerEClass, GLOBAL_POST_SELECTION_LISTENER__DEREGISTERS);

		specificSelectionListenerEClass = createEClass(SPECIFIC_SELECTION_LISTENER);
		createEAttribute(specificSelectionListenerEClass, SPECIFIC_SELECTION_LISTENER__REGISTRATION_PART_ID);
		createEReference(specificSelectionListenerEClass, SPECIFIC_SELECTION_LISTENER__PROVIDER);
		createEAttribute(specificSelectionListenerEClass, SPECIFIC_SELECTION_LISTENER__PROVIDER_NAME);
		createEReference(specificSelectionListenerEClass, SPECIFIC_SELECTION_LISTENER__DEREGISTERS);

		deregistersSamePartIdEClass = createEClass(DEREGISTERS_SAME_PART_ID);
		createEAttribute(deregistersSamePartIdEClass, DEREGISTERS_SAME_PART_ID__DEREGISTRATION_PART_ID);
		createEReference(deregistersSamePartIdEClass, DEREGISTERS_SAME_PART_ID__DEREGISTERS_SAME_OBJECT);

		partListenerEClass = createEClass(PART_LISTENER);
		createEReference(partListenerEClass, PART_LISTENER__LISTENER);
		createEReference(partListenerEClass, PART_LISTENER__REGISTERS_APART_LISTENER);

		registersAPartListenerEClass = createEClass(REGISTERS_APART_LISTENER);
		createEReference(registersAPartListenerEClass, REGISTERS_APART_LISTENER__REGISTERS);
		createEReference(registersAPartListenerEClass, REGISTERS_APART_LISTENER__REGISTERS2);

		registersAsPartListenerEClass = createEClass(REGISTERS_AS_PART_LISTENER);
		createEReference(registersAsPartListenerEClass, REGISTERS_AS_PART_LISTENER__DEREGISTERS);

		registersAsPartListener2EClass = createEClass(REGISTERS_AS_PART_LISTENER2);
		createEReference(registersAsPartListener2EClass, REGISTERS_AS_PART_LISTENER2__DEREGISTERS);

		deregistersEClass = createEClass(DEREGISTERS);
		createEReference(deregistersEClass, DEREGISTERS__DEREGISTERS_SAME_OBJECT);

		deregistersSameObjectEClass = createEClass(DEREGISTERS_SAME_OBJECT);
		createEAttribute(deregistersSameObjectEClass, DEREGISTERS_SAME_OBJECT__REGISTERS_BEFORE_DEREGISTERS);

		adapterProviderEClass = createEClass(ADAPTER_PROVIDER);
		createEReference(adapterProviderEClass, ADAPTER_PROVIDER__ADAPTER_PROVIDER);
		createEReference(adapterProviderEClass, ADAPTER_PROVIDER__PROVIDES_ADAPTER);

		providesAdapterEClass = createEClass(PROVIDES_ADAPTER);
		createEAttribute(providesAdapterEClass, PROVIDES_ADAPTER__ADAPTERS);

		adapterRequestorEClass = createEClass(ADAPTER_REQUESTOR);
		createEReference(adapterRequestorEClass, ADAPTER_REQUESTOR__ADAPTER_REQUESTOR);
		createEReference(adapterRequestorEClass, ADAPTER_REQUESTOR__REQUESTS_ADAPTER);

		requestsAdapterEClass = createEClass(REQUESTS_ADAPTER);
		createEAttribute(requestsAdapterEClass, REQUESTS_ADAPTER__ADAPTER);
		createEReference(requestsAdapterEClass, REQUESTS_ADAPTER__ADAPTER_PROVIDER);
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
		workbenchPartInteractionsEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		workbenchPartInteractionsEClass.getESuperTypes().add(theFsmlPackage.getModel());
		partEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		viewPartEClass.getESuperTypes().add(this.getPart());
		implementsIViewPartEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		editorPartEClass.getESuperTypes().add(this.getPart());
		contributorEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		extendsEditorActionBarContributorEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		implementsIEditorPartEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		extendsEditorPartEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		selectionProviderEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		registersAsSelectionProviderEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		thisSelectionProviderEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		fieldSelectionProviderEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		selectionListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		registersAsEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		globalSelectionListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		globalPostSelectionListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		specificSelectionListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		deregistersSamePartIdEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		partListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		registersAPartListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		registersAsPartListenerEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		registersAsPartListener2EClass.getESuperTypes().add(theFsmlPackage.getConcept());
		deregistersEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		deregistersSameObjectEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		adapterProviderEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		providesAdapterEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		adapterRequestorEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		requestsAdapterEClass.getESuperTypes().add(theFsmlPackage.getConcept());

		// Initialize classes and features; add operations and parameters
		initEClass(workbenchPartInteractionsEClass, WorkbenchPartInteractions.class, "WorkbenchPartInteractions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkbenchPartInteractions_Project(), ecorePackage.getEString(), "project", null, 1, 1, WorkbenchPartInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchPartInteractions_Parts(), this.getPart(), null, "parts", null, 0, -1, WorkbenchPartInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchPartInteractions_SelectionProviders(), this.getSelectionProvider(), null, "selectionProviders", null, 0, -1, WorkbenchPartInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchPartInteractions_SelectionListeners(), this.getSelectionListener(), null, "selectionListeners", null, 0, -1, WorkbenchPartInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchPartInteractions_PartListeners(), this.getPartListener(), null, "partListeners", null, 0, -1, WorkbenchPartInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchPartInteractions_AdapterProviders(), this.getAdapterProvider(), null, "adapterProviders", null, 0, -1, WorkbenchPartInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchPartInteractions_AdapterRequestors(), this.getAdapterRequestor(), null, "adapterRequestors", null, 0, -1, WorkbenchPartInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partEClass, Part.class, "Part", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPart_Name(), ecorePackage.getEString(), "name", null, 1, 1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPart_Package(), ecorePackage.getEString(), "package", null, 0, 1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPart_Local(), ecorePackage.getEBoolean(), "local", "true", 0, 1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewPartEClass, ViewPart.class, "ViewPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewPart_PartId(), ecorePackage.getEString(), "partId", null, 0, 1, ViewPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewPart_ImplementsIViewPart(), this.getImplementsIViewPart(), null, "implementsIViewPart", null, 1, 1, ViewPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementsIViewPartEClass, ImplementsIViewPart.class, "ImplementsIViewPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImplementsIViewPart_ExtendsViewPart(), this.getExtendsViewPart(), null, "extendsViewPart", null, 0, 1, ImplementsIViewPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsViewPartEClass, ExtendsViewPart.class, "ExtendsViewPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsViewPart_ExtendsPageBookView(), ecorePackage.getEBoolean(), "extendsPageBookView", "false", 0, 1, ExtendsViewPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editorPartEClass, EditorPart.class, "EditorPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEditorPart_PartId(), ecorePackage.getEString(), "partId", null, 0, 1, EditorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditorPart_Contributor(), this.getContributor(), null, "contributor", null, 0, 1, EditorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditorPart_ImplementsIEditorPart(), this.getImplementsIEditorPart(), null, "implementsIEditorPart", null, 1, 1, EditorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contributorEClass, Contributor.class, "Contributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContributor_Contributor(), ecorePackage.getEString(), "contributor", null, 1, 1, Contributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContributor_ExtendsEditorActionBarContributor(), this.getExtendsEditorActionBarContributor(), null, "extendsEditorActionBarContributor", null, 1, 1, Contributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsEditorActionBarContributorEClass, ExtendsEditorActionBarContributor.class, "ExtendsEditorActionBarContributor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsEditorActionBarContributor_ExtendsMultiPageEditorActionBarContributor(), ecorePackage.getEBoolean(), "extendsMultiPageEditorActionBarContributor", "false", 0, 1, ExtendsEditorActionBarContributor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementsIEditorPartEClass, ImplementsIEditorPart.class, "ImplementsIEditorPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImplementsIEditorPart_ExtendsEditorPart(), this.getExtendsEditorPart(), null, "extendsEditorPart", null, 0, 1, ImplementsIEditorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsEditorPartEClass, ExtendsEditorPart.class, "ExtendsEditorPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsEditorPart_ExtendsMultiPageEditorPart(), ecorePackage.getEBoolean(), "extendsMultiPageEditorPart", "false", 0, 1, ExtendsEditorPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionProviderEClass, SelectionProvider.class, "SelectionProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectionProvider_Provider(), this.getPart(), null, "provider", null, 1, 1, SelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectionProvider_Registers(), this.getRegistersAsSelectionProvider(), null, "registers", null, 1, -1, SelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registersAsSelectionProviderEClass, RegistersAsSelectionProvider.class, "RegistersAsSelectionProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistersAsSelectionProvider_RegistersThis(), this.getThisSelectionProvider(), null, "registersThis", null, 0, 1, RegistersAsSelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegistersAsSelectionProvider_RegistersHelper(), ecorePackage.getEBoolean(), "registersHelper", "false", 0, 1, RegistersAsSelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegistersAsSelectionProvider_RegistersVariable(), ecorePackage.getEString(), "registersVariable", null, 0, 1, RegistersAsSelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegistersAsSelectionProvider_RegistersField(), this.getFieldSelectionProvider(), null, "registersField", null, 0, 1, RegistersAsSelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thisSelectionProviderEClass, ThisSelectionProvider.class, "ThisSelectionProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThisSelectionProvider_ImplementsISelectionProvider(), ecorePackage.getEBoolean(), "implementsISelectionProvider", "true", 1, 1, ThisSelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldSelectionProviderEClass, FieldSelectionProvider.class, "FieldSelectionProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFieldSelectionProvider_Field(), ecorePackage.getEString(), "field", null, 1, 1, FieldSelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFieldSelectionProvider_TypedISelectionProvider(), ecorePackage.getEBoolean(), "typedISelectionProvider", "true", 1, 1, FieldSelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFieldSelectionProvider_Initialized(), ecorePackage.getEBoolean(), "initialized", "true", 1, 1, FieldSelectionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionListenerEClass, SelectionListener.class, "SelectionListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectionListener_Listener(), this.getPart(), null, "listener", null, 1, 1, SelectionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectionListener_RegistersAs(), this.getRegistersAs(), null, "registersAs", null, 1, 1, SelectionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registersAsEClass, RegistersAs.class, "RegistersAs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistersAs_GlobalSelectionListener(), this.getGlobalSelectionListener(), null, "globalSelectionListener", null, 0, -1, RegistersAs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegistersAs_GlobalPostSelectionListener(), this.getGlobalPostSelectionListener(), null, "globalPostSelectionListener", null, 0, -1, RegistersAs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegistersAs_SpecificSelectionListener(), this.getSpecificSelectionListener(), null, "specificSelectionListener", null, 0, -1, RegistersAs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalSelectionListenerEClass, GlobalSelectionListener.class, "GlobalSelectionListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalSelectionListener_Deregisters(), this.getDeregisters(), null, "deregisters", null, 1, -1, GlobalSelectionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalPostSelectionListenerEClass, GlobalPostSelectionListener.class, "GlobalPostSelectionListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalPostSelectionListener_Deregisters(), this.getDeregisters(), null, "deregisters", null, 1, -1, GlobalPostSelectionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specificSelectionListenerEClass, SpecificSelectionListener.class, "SpecificSelectionListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpecificSelectionListener_RegistrationPartId(), ecorePackage.getEString(), "registrationPartId", null, 1, 1, SpecificSelectionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificSelectionListener_Provider(), this.getPart(), null, "provider", null, 1, 1, SpecificSelectionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecificSelectionListener_ProviderName(), ecorePackage.getEString(), "providerName", null, 0, 1, SpecificSelectionListener.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificSelectionListener_Deregisters(), this.getDeregistersSamePartId(), null, "deregisters", null, 1, -1, SpecificSelectionListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deregistersSamePartIdEClass, DeregistersSamePartId.class, "DeregistersSamePartId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeregistersSamePartId_DeregistrationPartId(), ecorePackage.getEString(), "deregistrationPartId", null, 1, 1, DeregistersSamePartId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeregistersSamePartId_DeregistersSameObject(), this.getDeregistersSameObject(), null, "deregistersSameObject", null, 1, 1, DeregistersSamePartId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partListenerEClass, PartListener.class, "PartListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartListener_Listener(), this.getPart(), null, "listener", null, 1, 1, PartListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartListener_RegistersAPartListener(), this.getRegistersAPartListener(), null, "registersAPartListener", null, 1, 1, PartListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registersAPartListenerEClass, RegistersAPartListener.class, "RegistersAPartListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistersAPartListener_Registers(), this.getRegistersAsPartListener(), null, "registers", null, 0, -1, RegistersAPartListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegistersAPartListener_Registers2(), this.getRegistersAsPartListener2(), null, "registers2", null, 0, -1, RegistersAPartListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registersAsPartListenerEClass, RegistersAsPartListener.class, "RegistersAsPartListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistersAsPartListener_Deregisters(), this.getDeregisters(), null, "deregisters", null, 1, -1, RegistersAsPartListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registersAsPartListener2EClass, RegistersAsPartListener2.class, "RegistersAsPartListener2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegistersAsPartListener2_Deregisters(), this.getDeregisters(), null, "deregisters", null, 1, -1, RegistersAsPartListener2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deregistersEClass, Deregisters.class, "Deregisters", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeregisters_DeregistersSameObject(), this.getDeregistersSameObject(), null, "deregistersSameObject", null, 1, 1, Deregisters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deregistersSameObjectEClass, DeregistersSameObject.class, "DeregistersSameObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeregistersSameObject_RegistersBeforeDeregisters(), ecorePackage.getEBoolean(), "registersBeforeDeregisters", "true", 1, 1, DeregistersSameObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterProviderEClass, AdapterProvider.class, "AdapterProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapterProvider_AdapterProvider(), this.getPart(), null, "adapterProvider", null, 1, 1, AdapterProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapterProvider_ProvidesAdapter(), this.getProvidesAdapter(), null, "providesAdapter", null, 1, 1, AdapterProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(providesAdapterEClass, ProvidesAdapter.class, "ProvidesAdapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProvidesAdapter_Adapters(), ecorePackage.getEString(), "adapters", "true", 1, -1, ProvidesAdapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterRequestorEClass, AdapterRequestor.class, "AdapterRequestor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdapterRequestor_AdapterRequestor(), this.getPart(), null, "adapterRequestor", null, 1, 1, AdapterRequestor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdapterRequestor_RequestsAdapter(), this.getRequestsAdapter(), null, "requestsAdapter", null, 1, -1, AdapterRequestor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestsAdapterEClass, RequestsAdapter.class, "RequestsAdapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequestsAdapter_Adapter(), ecorePackage.getEString(), "adapter", null, 1, 1, RequestsAdapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequestsAdapter_AdapterProvider(), this.getAdapterProvider(), null, "adapterProvider", null, 0, -1, RequestsAdapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// project
		createProjectAnnotations();
		// projectName
		createProjectNameAnnotations();
		// class
		createClassAnnotations();
		// essential
		createEssentialAnnotations();
		// className
		createClassNameAnnotations();
		// key
		createKeyAnnotations();
		// qualifier
		createQualifierAnnotations();
		// isLocal
		createIsLocalAnnotations();
		// viewPartId
		createViewPartIdAnnotations();
		// implementsInterface
		createImplementsInterfaceAnnotations();
		// subsumedBy
		createSubsumedByAnnotations();
		// parentKey
		createParentKeyAnnotations();
		// extendsClass
		createExtendsClassAnnotations();
		// editorPartId
		createEditorPartIdAnnotations();
		// editorContributor
		createEditorContributorAnnotations();
		// fullyQualifiedName
		createFullyQualifiedNameAnnotations();
		// baseConcept
		createBaseConceptAnnotations();
		// methodCalls
		createMethodCallsAnnotations();
		// methodCall
		createMethodCallAnnotations();
		// indexKey
		createIndexKeyAnnotations();
		// featureGroup
		createFeatureGroupAnnotations();
		// argumentIsThis
		createArgumentIsThisAnnotations();
		// argumentIsNew
		createArgumentIsNewAnnotations();
		// argumentIsVariable
		createArgumentIsVariableAnnotations();
		// argumentIsField
		createArgumentIsFieldAnnotations();
		// field
		createFieldAnnotations();
		// fieldName
		createFieldNameAnnotations();
		// typedWith
		createTypedWithAnnotations();
		// assignedWithNew
		createAssignedWithNewAnnotations();
		// argumentValue
		createArgumentValueAnnotations();
		// where
		createWhereAnnotations();
		// valueEqualsTo
		createValueEqualsToAnnotations();
		// argument
		createArgumentAnnotations();
		// methods
		createMethodsAnnotations();
		// method
		createMethodAnnotations();
		// typesOfReturnedObjects
		createTypesOfReturnedObjectsAnnotations();
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
		  (workbenchPartInteractionsEClass, 
		   source, 
		   new String[] {
		   });																																																																																																																																											
	}

	/**
	 * Initializes the annotations for <b>projectName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createProjectNameAnnotations() {
		String source = "projectName";			
		addAnnotation
		  (getWorkbenchPartInteractions_Project(), 
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
		  (partEClass, 
		   source, 
		   new String[] {
		   });																					
		addAnnotation
		  (contributorEClass, 
		   source, 
		   new String[] {
		   });														
		addAnnotation
		  (selectionProviderEClass, 
		   source, 
		   new String[] {
		   });																									
		addAnnotation
		  (selectionListenerEClass, 
		   source, 
		   new String[] {
		   });																																				
		addAnnotation
		  (partListenerEClass, 
		   source, 
		   new String[] {
		   });																									
		addAnnotation
		  (adapterProviderEClass, 
		   source, 
		   new String[] {
		   });											
		addAnnotation
		  (adapterRequestorEClass, 
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
		  (getPart_Name(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getPart_Package(), 
		   source, 
		   new String[] {
		   });																			
		addAnnotation
		  (getContributor_Contributor(), 
		   source, 
		   new String[] {
		   });												
		addAnnotation
		  (getSelectionProvider_Provider(), 
		   source, 
		   new String[] {
		   });												
		addAnnotation
		  (getRegistersAsSelectionProvider_RegistersHelper(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getRegistersAsSelectionProvider_RegistersVariable(), 
		   source, 
		   new String[] {
		   });							
		addAnnotation
		  (getFieldSelectionProvider_Field(), 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (getSelectionListener_Listener(), 
		   source, 
		   new String[] {
		   });																					
		addAnnotation
		  (getSpecificSelectionListener_RegistrationPartId(), 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (getDeregistersSamePartId_DeregistrationPartId(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getPartListener_Listener(), 
		   source, 
		   new String[] {
		   });																									
		addAnnotation
		  (getAdapterProvider_AdapterProvider(), 
		   source, 
		   new String[] {
		   });												
		addAnnotation
		  (getAdapterRequestor_AdapterRequestor(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getRequestsAdapter_Adapter(), 
		   source, 
		   new String[] {
		   });		
	}

	/**
	 * Initializes the annotations for <b>qualifier</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createQualifierAnnotations() {
		String source = "qualifier";								
		addAnnotation
		  (getPart_Package(), 
		   source, 
		   new String[] {
		   });																																																																																																																																					
	}

	/**
	 * Initializes the annotations for <b>isLocal</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createIsLocalAnnotations() {
		String source = "isLocal";										
		addAnnotation
		  (getPart_Local(), 
		   source, 
		   new String[] {
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
		  (getSelectionProvider_Registers(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.IWorkbenchSite",
			 "name", "setSelectionProvider",
			 "signature", "(Lorg.eclipse.jface.viewers.ISelectionProvider;)V;",
			 "in", "hierarchy",
			 "locationName", "createPartControl",
			 "locationSig", "(Lorg.eclipse.swt.widgets.Composite;)V",
			 "receiverExpr", "getSite()",
			 "position", "after"
		   });																												
		addAnnotation
		  (getRegistersAs_GlobalSelectionListener(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.ISelectionService",
			 "name", "addSelectionListener",
			 "signature", "(Lorg.eclipse.ui.ISelectionListener;)V;",
			 "in", "hierarchy",
			 "locationName", "createPartControl",
			 "locationSig", "(Lorg.eclipse.swt.widgets.Composite;)V",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });		
		addAnnotation
		  (getRegistersAs_GlobalPostSelectionListener(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.ISelectionService",
			 "name", "addPostSelectionListener",
			 "signature", "(Lorg.eclipse.ui.ISelectionListener;)V;",
			 "in", "hierarchy",
			 "locationName", "createPartControl",
			 "locationSig", "(Lorg.eclipse.swt.widgets.Composite;)V",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });		
		addAnnotation
		  (getRegistersAs_SpecificSelectionListener(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.ISelectionService",
			 "name", "addSelectionListener",
			 "signature", "(Ljava.lang.String;Lorg.eclipse.ui.ISelectionListener;)V;",
			 "in", "hierarchy",
			 "locationName", "createPartControl",
			 "locationSig", "(Lorg.eclipse.swt.widgets.Composite;)V",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });					
		addAnnotation
		  (getGlobalSelectionListener_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.ISelectionService",
			 "name", "removeSelectionListener",
			 "signature", "(Lorg.eclipse.ui.ISelectionListener;)V;",
			 "in", "hierarchy",
			 "locationName", "dispose",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });					
		addAnnotation
		  (getGlobalPostSelectionListener_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.ISelectionService",
			 "name", "removePostSelectionListener",
			 "signature", "(Lorg.eclipse.ui.ISelectionListener;)V;",
			 "in", "hierarchy",
			 "locationName", "dispose",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });									
		addAnnotation
		  (getSpecificSelectionListener_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.ISelectionService",
			 "name", "removeSelectionListener",
			 "signature", "(Ljava.lang.String;Lorg.eclipse.ui.ISelectionListener;)V;",
			 "in", "hierarchy",
			 "locationName", "dispose",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });																		
		addAnnotation
		  (getRegistersAPartListener_Registers(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.IPartService",
			 "name", "addPartListener",
			 "signature", "(Lorg.eclipse.ui.IPartListener;)V;",
			 "in", "hierarchy",
			 "locationName", "createPartControl",
			 "locationSig", "(Lorg.eclipse.swt.widgets.Composite;)V",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });		
		addAnnotation
		  (getRegistersAPartListener_Registers2(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.IPartService",
			 "name", "addPartListener",
			 "signature", "(Lorg.eclipse.ui.IPartListener2;)V;",
			 "in", "hierarchy",
			 "locationName", "createPartControl",
			 "locationSig", "(Lorg.eclipse.swt.widgets.Composite;)V",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });					
		addAnnotation
		  (getRegistersAsPartListener_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.IPartService",
			 "name", "removePartListener",
			 "signature", "(Lorg.eclipse.ui.IPartListener;)V;",
			 "in", "hierarchy",
			 "locationName", "dispose",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });					
		addAnnotation
		  (getRegistersAsPartListener2_Deregisters(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.ui.IPartService",
			 "name", "removePartListener",
			 "signature", "(Lorg.eclipse.ui.IPartListener2;)V;",
			 "in", "hierarchy",
			 "locationName", "dispose",
			 "receiverExpr", "getSite().getPage()",
			 "position", "after"
		   });																							
		addAnnotation
		  (getAdapterRequestor_RequestsAdapter(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.core.runtime.IAdaptable",
			 "name", "getAdapter",
			 "signature", "(Ljava.lang.Class;)Ljava.lang.Object;",
			 "receiver", "org.eclipse.ui.IWorkbenchPart",
			 "in", "hierarchy",
			 "locationName", "requestAdapters",
			 "locationSig", "(Lorg.eclipse.ui.IWorkbenchPart;)V",
			 "receiverExpr", "iWorkbenchPart",
			 "position", "after"
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
		  (getRegistersAsSelectionProvider_RegistersThis(), 
		   source, 
		   new String[] {
			 "index", "1"
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
		  (getRegistersAsSelectionProvider_RegistersField(), 
		   source, 
		   new String[] {
			 "index", "1"
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
		  (fieldSelectionProviderEClass, 
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
		  (getFieldSelectionProvider_Field(), 
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
		  (getFieldSelectionProvider_TypedISelectionProvider(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.jface.viewers.ISelectionProvider"
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
		  (getFieldSelectionProvider_Initialized(), 
		   source, 
		   new String[] {
			 "class", "org.eclipse.jface.viewers.ISelectionProvider",
			 "signature", "()V",
			 "initializer", "true"
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
		  (getRegistersAsSelectionProvider_RegistersHelper(), 
		   source, 
		   new String[] {
			 "index", "1",
			 "class", "org.eclipse.jface.viewers.ISelectionProvider",
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
		  (getRegistersAsSelectionProvider_RegistersVariable(), 
		   source, 
		   new String[] {
			 "index", "1",
			 "class", "org.eclipse.jface.viewers.ISelectionProvider",
			 "signature", "()V"
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
		  (registersAsSelectionProviderEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "1"
		   });																					
		addAnnotation
		  (registersAsEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "3",
			 "essential", "true"
		   });																																				
		addAnnotation
		  (registersAPartListenerEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "2",
			 "essential", "true"
		   });																																								
	}

	/**
	 * Initializes the annotations for <b>viewPartId</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createViewPartIdAnnotations() {
		String source = "viewPartId";											
		addAnnotation
		  (getViewPart_PartId(), 
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
		  (getPart_Name(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getViewPart_ImplementsIViewPart(), 
		   source, 
		   new String[] {
		   });										
		addAnnotation
		  (getEditorPart_ImplementsIEditorPart(), 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (getContributor_Contributor(), 
		   source, 
		   new String[] {
		   });																
		addAnnotation
		  (getSelectionProvider_Provider(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getSelectionProvider_Registers(), 
		   source, 
		   new String[] {
		   });																							
		addAnnotation
		  (getSelectionListener_Listener(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getSelectionListener_RegistersAs(), 
		   source, 
		   new String[] {
		   });																			
		addAnnotation
		  (getSpecificSelectionListener_RegistrationPartId(), 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (getDeregistersSamePartId_DeregistrationPartId(), 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (getDeregistersSamePartId_DeregistersSameObject(), 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (getPartListener_Listener(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getPartListener_RegistersAPartListener(), 
		   source, 
		   new String[] {
		   });																		
		addAnnotation
		  (getDeregisters_DeregistersSameObject(), 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (getAdapterProvider_AdapterProvider(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getAdapterProvider_ProvidesAdapter(), 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (getProvidesAdapter_Adapters(), 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (getAdapterRequestor_AdapterRequestor(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getAdapterRequestor_RequestsAdapter(), 
		   source, 
		   new String[] {
		   });						
	}

	/**
	 * Initializes the annotations for <b>className</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createClassNameAnnotations() {
		String source = "className";						
		addAnnotation
		  (getPart_Name(), 
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
		  (getViewPart_ImplementsIViewPart(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.ui.IViewPart",
			 "concrete", "true"
		   });										
		addAnnotation
		  (getEditorPart_ImplementsIEditorPart(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.ui.IEditorPart",
			 "concrete", "true"
		   });																																	
		addAnnotation
		  (getThisSelectionProvider_ImplementsISelectionProvider(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.jface.viewers.ISelectionProvider"
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
		  (getViewPart_ImplementsIViewPart(), 
		   source, 
		   new String[] {
			 "feature", "extendsViewPart/"
		   });				
		addAnnotation
		  (getImplementsIViewPart_ExtendsViewPart(), 
		   source, 
		   new String[] {
			 "feature", "extendsPageBookView"
		   });							
		addAnnotation
		  (getEditorPart_ImplementsIEditorPart(), 
		   source, 
		   new String[] {
			 "feature", "extendsEditorPart/"
		   });												
		addAnnotation
		  (getImplementsIEditorPart_ExtendsEditorPart(), 
		   source, 
		   new String[] {
			 "feature", "extendsMultiPageEditorPart"
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
		  (getImplementsIViewPart_ExtendsViewPart(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.ui.part.ViewPart"
		   });				
		addAnnotation
		  (getExtendsViewPart_ExtendsPageBookView(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.ui.part.PageBookView"
		   });											
		addAnnotation
		  (getContributor_ExtendsEditorActionBarContributor(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.ui.part.EditorActionBarContributor"
		   });			
		addAnnotation
		  (getExtendsEditorActionBarContributor_ExtendsMultiPageEditorActionBarContributor(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.ui.part.MultiPageEditorActionBarContributor"
		   });			
		addAnnotation
		  (getImplementsIEditorPart_ExtendsEditorPart(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.ui.part.EditorPart"
		   });				
		addAnnotation
		  (getExtendsEditorPart_ExtendsMultiPageEditorPart(), 
		   source, 
		   new String[] {
			 "name", "org.eclipse.ui.part.MultiPageEditorPart"
		   });																																																																																																									
	}

	/**
	 * Initializes the annotations for <b>editorPartId</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEditorPartIdAnnotations() {
		String source = "editorPartId";																				
		addAnnotation
		  (getEditorPart_PartId(), 
		   source, 
		   new String[] {
		   });																																																																																																																									
	}

	/**
	 * Initializes the annotations for <b>editorContributor</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEditorContributorAnnotations() {
		String source = "editorContributor";																										
		addAnnotation
		  (getContributor_Contributor(), 
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
		  (getContributor_Contributor(), 
		   source, 
		   new String[] {
		   });																																																																																																																	
	}

	/**
	 * Initializes the annotations for <b>baseConcept</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createBaseConceptAnnotations() {
		String source = "baseConcept";																																							
		addAnnotation
		  (getSelectionProvider_Provider(), 
		   source, 
		   new String[] {
		   });																									
		addAnnotation
		  (getSelectionListener_Listener(), 
		   source, 
		   new String[] {
		   });																																				
		addAnnotation
		  (getPartListener_Listener(), 
		   source, 
		   new String[] {
		   });																										
		addAnnotation
		  (getAdapterProvider_AdapterProvider(), 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (getAdapterRequestor_AdapterRequestor(), 
		   source, 
		   new String[] {
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
		  (registersAsSelectionProviderEClass, 
		   source, 
		   new String[] {
		   });																												
		addAnnotation
		  (globalSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (globalPostSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (specificSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (deregistersSamePartIdEClass, 
		   source, 
		   new String[] {
		   });																			
		addAnnotation
		  (registersAsPartListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (registersAsPartListener2EClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (deregistersEClass, 
		   source, 
		   new String[] {
		   });							
		addAnnotation
		  (getDeregistersSameObject_RegistersBeforeDeregisters(), 
		   source, 
		   new String[] {
			 "call", "../../../",
			 "before", "../../",
			 "givenCallbackSeq", "init createPartControl dispose"
		   });																		
		addAnnotation
		  (requestsAdapterEClass, 
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
		  (registersAsSelectionProviderEClass, 
		   source, 
		   new String[] {
		   });																													
		addAnnotation
		  (globalSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (globalPostSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (specificSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (deregistersSamePartIdEClass, 
		   source, 
		   new String[] {
		   });																			
		addAnnotation
		  (registersAsPartListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (registersAsPartListener2EClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (deregistersEClass, 
		   source, 
		   new String[] {
		   });																								
		addAnnotation
		  (requestsAdapterEClass, 
		   source, 
		   new String[] {
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
		  (implementsIViewPartEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (extendsViewPartEClass, 
		   source, 
		   new String[] {
		   });													
		addAnnotation
		  (extendsEditorActionBarContributorEClass, 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (implementsIEditorPartEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (extendsEditorPartEClass, 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (registersAsSelectionProviderEClass, 
		   source, 
		   new String[] {
		   });											
		addAnnotation
		  (thisSelectionProviderEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (fieldSelectionProviderEClass, 
		   source, 
		   new String[] {
		   });												
		addAnnotation
		  (registersAsEClass, 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (globalSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (globalPostSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (specificSelectionListenerEClass, 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (deregistersSamePartIdEClass, 
		   source, 
		   new String[] {
		   });															
		addAnnotation
		  (registersAPartListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (registersAsPartListenerEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (registersAsPartListener2EClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (deregistersEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (deregistersSameObjectEClass, 
		   source, 
		   new String[] {
		   });										
		addAnnotation
		  (providesAdapterEClass, 
		   source, 
		   new String[] {
		   });											
		addAnnotation
		  (requestsAdapterEClass, 
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
		  (getSpecificSelectionListener_RegistrationPartId(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });									
		addAnnotation
		  (getDeregistersSamePartId_DeregistrationPartId(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });																																																	
		addAnnotation
		  (getRequestsAdapter_Adapter(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });	
	}

	/**
	 * Initializes the annotations for <b>where</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createWhereAnnotations() {
		String source = "where";																																																																																					
		addAnnotation
		  (getSpecificSelectionListener_Provider(), 
		   source, 
		   new String[] {
			 "attribute", "partId",
			 "equalsTo", "../registrationPartId"
		   });																																																									
		addAnnotation
		  (getRequestsAdapter_AdapterProvider(), 
		   source, 
		   new String[] {
			 "attribute", "providesAdapter/adapters",
			 "contains", "../adapter"
		   });
	}

	/**
	 * Initializes the annotations for <b>valueEqualsTo</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createValueEqualsToAnnotations() {
		String source = "valueEqualsTo";																																																																																													
		addAnnotation
		  (getDeregistersSamePartId_DeregistrationPartId(), 
		   source, 
		   new String[] {
			 "attribute", "../../registrationPartId"
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
		  (getAdapterProvider_ProvidesAdapter(), 
		   source, 
		   new String[] {
			 "name", "getAdapter",
			 "signature", "(Ljava.lang.Class;)Ljava.lang.Object;",
			 "inherited", "true"
		   });																
	}

	/**
	 * Initializes the annotations for <b>method</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMethodAnnotations() {
		String source = "method";																																																																																																																														
		addAnnotation
		  (providesAdapterEClass, 
		   source, 
		   new String[] {
		   });															
	}

	/**
	 * Initializes the annotations for <b>typesOfReturnedObjects</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTypesOfReturnedObjectsAnnotations() {
		String source = "typesOfReturnedObjects";																																																																																																																																	
		addAnnotation
		  (getProvidesAdapter_Adapters(), 
		   source, 
		   new String[] {
			 "anonymous", "true",
			 "ifkey", "1"
		   });												
	}

	/**
	 * Initializes the annotations for <b>argument</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createArgumentAnnotations() {
		String source = "argument";																																																																																														
		addAnnotation
		  (getDeregistersSamePartId_DeregistersSameObject(), 
		   source, 
		   new String[] {
			 "argument", "2",
			 "ofMethodCall", "../../",
			 "sameAsArg", "2",
			 "ofCall", "../"
		   });																							
		addAnnotation
		  (getDeregisters_DeregistersSameObject(), 
		   source, 
		   new String[] {
			 "argument", "1",
			 "ofMethodCall", "../../",
			 "sameAsArg", "1",
			 "ofCall", "../"
		   });																									
	}

} //WpiPackageImpl
