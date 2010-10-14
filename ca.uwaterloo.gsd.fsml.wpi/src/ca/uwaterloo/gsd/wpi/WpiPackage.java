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
 * $Id: WpiPackage.java,v 1.20 2008/06/26 19:28:43 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

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
 * @see ca.uwaterloo.gsd.wpi.WpiFactory
 * @model kind="package"
 * @generated
 */
public interface WpiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wpi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ca.uwaterloo.gsd/wpi";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wpi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WpiPackage eINSTANCE = ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl <em>Workbench Part Interactions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getWorkbenchPartInteractions()
	 * @generated
	 */
	int WORKBENCH_PART_INTERACTIONS = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_INTERACTIONS__PROJECT = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_INTERACTIONS__PARTS = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Selection Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Selection Listeners</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Part Listeners</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_INTERACTIONS__PART_LISTENERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Adapter Providers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Adapter Requestors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS = FsmlPackage.CONCEPT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Workbench Part Interactions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_INTERACTIONS_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.PartImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getPart()
	 * @generated
	 */
	int PART = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__PACKAGE = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__LOCAL = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ViewPartImpl <em>View Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ViewPartImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getViewPart()
	 * @generated
	 */
	int VIEW_PART = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PART__NAME = PART__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PART__PACKAGE = PART__PACKAGE;

	/**
	 * The feature id for the '<em><b>Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PART__LOCAL = PART__LOCAL;

	/**
	 * The feature id for the '<em><b>Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PART__PART_ID = PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implements IView Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PART__IMPLEMENTS_IVIEW_PART = PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>View Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_PART_FEATURE_COUNT = PART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ImplementsIViewPartImpl <em>Implements IView Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ImplementsIViewPartImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getImplementsIViewPart()
	 * @generated
	 */
	int IMPLEMENTS_IVIEW_PART = 3;

	/**
	 * The feature id for the '<em><b>Extends View Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Implements IView Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTS_IVIEW_PART_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ExtendsViewPartImpl <em>Extends View Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ExtendsViewPartImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getExtendsViewPart()
	 * @generated
	 */
	int EXTENDS_VIEW_PART = 4;

	/**
	 * The feature id for the '<em><b>Extends Page Book View</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_VIEW_PART__EXTENDS_PAGE_BOOK_VIEW = 0;

	/**
	 * The number of structural features of the '<em>Extends View Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_VIEW_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.EditorPartImpl <em>Editor Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.EditorPartImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getEditorPart()
	 * @generated
	 */
	int EDITOR_PART = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART__NAME = PART__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART__PACKAGE = PART__PACKAGE;

	/**
	 * The feature id for the '<em><b>Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART__LOCAL = PART__LOCAL;

	/**
	 * The feature id for the '<em><b>Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART__PART_ID = PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contributor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART__CONTRIBUTOR = PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implements IEditor Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART__IMPLEMENTS_IEDITOR_PART = PART_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Editor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PART_FEATURE_COUNT = PART_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ContributorImpl <em>Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ContributorImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getContributor()
	 * @generated
	 */
	int CONTRIBUTOR = 6;

	/**
	 * The feature id for the '<em><b>Contributor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__CONTRIBUTOR = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends Editor Action Bar Contributor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ExtendsEditorActionBarContributorImpl <em>Extends Editor Action Bar Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ExtendsEditorActionBarContributorImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getExtendsEditorActionBarContributor()
	 * @generated
	 */
	int EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR = 7;

	/**
	 * The feature id for the '<em><b>Extends Multi Page Editor Action Bar Contributor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR__EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extends Editor Action Bar Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ImplementsIEditorPartImpl <em>Implements IEditor Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ImplementsIEditorPartImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getImplementsIEditorPart()
	 * @generated
	 */
	int IMPLEMENTS_IEDITOR_PART = 8;

	/**
	 * The feature id for the '<em><b>Extends Editor Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Implements IEditor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTS_IEDITOR_PART_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ExtendsEditorPartImpl <em>Extends Editor Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ExtendsEditorPartImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getExtendsEditorPart()
	 * @generated
	 */
	int EXTENDS_EDITOR_PART = 9;

	/**
	 * The feature id for the '<em><b>Extends Multi Page Editor Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_EDITOR_PART__EXTENDS_MULTI_PAGE_EDITOR_PART = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extends Editor Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_EDITOR_PART_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.SelectionProviderImpl <em>Selection Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.SelectionProviderImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getSelectionProvider()
	 * @generated
	 */
	int SELECTION_PROVIDER = 10;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROVIDER__PROVIDER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Registers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROVIDER__REGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Selection Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROVIDER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsSelectionProviderImpl <em>Registers As Selection Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAsSelectionProviderImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAsSelectionProvider()
	 * @generated
	 */
	int REGISTERS_AS_SELECTION_PROVIDER = 11;

	/**
	 * The feature id for the '<em><b>Registers This</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Registers Helper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_HELPER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Registers Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_VARIABLE = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Registers Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Registers As Selection Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_SELECTION_PROVIDER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ThisSelectionProviderImpl <em>This Selection Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ThisSelectionProviderImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getThisSelectionProvider()
	 * @generated
	 */
	int THIS_SELECTION_PROVIDER = 12;

	/**
	 * The feature id for the '<em><b>Implements ISelection Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_SELECTION_PROVIDER__IMPLEMENTS_ISELECTION_PROVIDER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>This Selection Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_SELECTION_PROVIDER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.FieldSelectionProviderImpl <em>Field Selection Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.FieldSelectionProviderImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getFieldSelectionProvider()
	 * @generated
	 */
	int FIELD_SELECTION_PROVIDER = 13;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_SELECTION_PROVIDER__FIELD = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Typed ISelection Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_SELECTION_PROVIDER__TYPED_ISELECTION_PROVIDER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_SELECTION_PROVIDER__INITIALIZED = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Field Selection Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_SELECTION_PROVIDER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.SelectionListenerImpl <em>Selection Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.SelectionListenerImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getSelectionListener()
	 * @generated
	 */
	int SELECTION_LISTENER = 14;

	/**
	 * The feature id for the '<em><b>Listener</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_LISTENER__LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Registers As</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_LISTENER__REGISTERS_AS = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Selection Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsImpl <em>Registers As</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAsImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAs()
	 * @generated
	 */
	int REGISTERS_AS = 15;

	/**
	 * The feature id for the '<em><b>Global Selection Listener</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS__GLOBAL_SELECTION_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global Post Selection Listener</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Specific Selection Listener</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS__SPECIFIC_SELECTION_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Registers As</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.GlobalSelectionListenerImpl <em>Global Selection Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.GlobalSelectionListenerImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getGlobalSelectionListener()
	 * @generated
	 */
	int GLOBAL_SELECTION_LISTENER = 16;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SELECTION_LISTENER__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Global Selection Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SELECTION_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.GlobalPostSelectionListenerImpl <em>Global Post Selection Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.GlobalPostSelectionListenerImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getGlobalPostSelectionListener()
	 * @generated
	 */
	int GLOBAL_POST_SELECTION_LISTENER = 17;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_POST_SELECTION_LISTENER__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Global Post Selection Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_POST_SELECTION_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.SpecificSelectionListenerImpl <em>Specific Selection Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.SpecificSelectionListenerImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getSpecificSelectionListener()
	 * @generated
	 */
	int SPECIFIC_SELECTION_LISTENER = 18;

	/**
	 * The feature id for the '<em><b>Registration Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION_LISTENER__REGISTRATION_PART_ID = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION_LISTENER__PROVIDER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provider Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION_LISTENER__PROVIDER_NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION_LISTENER__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Specific Selection Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.DeregistersSamePartIdImpl <em>Deregisters Same Part Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.DeregistersSamePartIdImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getDeregistersSamePartId()
	 * @generated
	 */
	int DEREGISTERS_SAME_PART_ID = 19;

	/**
	 * The feature id for the '<em><b>Deregistration Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_SAME_PART_ID__DEREGISTRATION_PART_ID = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deregisters Same Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_SAME_PART_ID__DEREGISTERS_SAME_OBJECT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Deregisters Same Part Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_SAME_PART_ID_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.PartListenerImpl <em>Part Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.PartListenerImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getPartListener()
	 * @generated
	 */
	int PART_LISTENER = 20;

	/**
	 * The feature id for the '<em><b>Listener</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_LISTENER__LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Registers APart Listener</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_LISTENER__REGISTERS_APART_LISTENER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Part Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAPartListenerImpl <em>Registers APart Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAPartListenerImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAPartListener()
	 * @generated
	 */
	int REGISTERS_APART_LISTENER = 21;

	/**
	 * The feature id for the '<em><b>Registers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_APART_LISTENER__REGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Registers2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_APART_LISTENER__REGISTERS2 = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Registers APart Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_APART_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsPartListenerImpl <em>Registers As Part Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAsPartListenerImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAsPartListener()
	 * @generated
	 */
	int REGISTERS_AS_PART_LISTENER = 22;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_PART_LISTENER__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Registers As Part Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_PART_LISTENER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsPartListener2Impl <em>Registers As Part Listener2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAsPartListener2Impl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAsPartListener2()
	 * @generated
	 */
	int REGISTERS_AS_PART_LISTENER2 = 23;

	/**
	 * The feature id for the '<em><b>Deregisters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_PART_LISTENER2__DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Registers As Part Listener2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTERS_AS_PART_LISTENER2_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.DeregistersImpl <em>Deregisters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.DeregistersImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getDeregisters()
	 * @generated
	 */
	int DEREGISTERS = 24;

	/**
	 * The feature id for the '<em><b>Deregisters Same Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS__DEREGISTERS_SAME_OBJECT = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deregisters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.DeregistersSameObjectImpl <em>Deregisters Same Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.DeregistersSameObjectImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getDeregistersSameObject()
	 * @generated
	 */
	int DEREGISTERS_SAME_OBJECT = 25;

	/**
	 * The feature id for the '<em><b>Registers Before Deregisters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_SAME_OBJECT__REGISTERS_BEFORE_DEREGISTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Deregisters Same Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEREGISTERS_SAME_OBJECT_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.AdapterProviderImpl <em>Adapter Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.AdapterProviderImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getAdapterProvider()
	 * @generated
	 */
	int ADAPTER_PROVIDER = 26;

	/**
	 * The feature id for the '<em><b>Adapter Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PROVIDER__ADAPTER_PROVIDER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provides Adapter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PROVIDER__PROVIDES_ADAPTER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Adapter Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_PROVIDER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.ProvidesAdapterImpl <em>Provides Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.ProvidesAdapterImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getProvidesAdapter()
	 * @generated
	 */
	int PROVIDES_ADAPTER = 27;

	/**
	 * The feature id for the '<em><b>Adapters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_ADAPTER__ADAPTERS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Provides Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_ADAPTER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.AdapterRequestorImpl <em>Adapter Requestor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.AdapterRequestorImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getAdapterRequestor()
	 * @generated
	 */
	int ADAPTER_REQUESTOR = 28;

	/**
	 * The feature id for the '<em><b>Adapter Requestor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_REQUESTOR__ADAPTER_REQUESTOR = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Requests Adapter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_REQUESTOR__REQUESTS_ADAPTER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Adapter Requestor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_REQUESTOR_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.wpi.impl.RequestsAdapterImpl <em>Requests Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.wpi.impl.RequestsAdapterImpl
	 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRequestsAdapter()
	 * @generated
	 */
	int REQUESTS_ADAPTER = 29;

	/**
	 * The feature id for the '<em><b>Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUESTS_ADAPTER__ADAPTER = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Adapter Provider</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUESTS_ADAPTER__ADAPTER_PROVIDER = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Requests Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUESTS_ADAPTER_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions <em>Workbench Part Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workbench Part Interactions</em>'.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions
	 * @generated
	 */
	EClass getWorkbenchPartInteractions();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project</em>'.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getProject()
	 * @see #getWorkbenchPartInteractions()
	 * @generated
	 */
	EAttribute getWorkbenchPartInteractions_Project();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getParts()
	 * @see #getWorkbenchPartInteractions()
	 * @generated
	 */
	EReference getWorkbenchPartInteractions_Parts();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getSelectionProviders <em>Selection Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selection Providers</em>'.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getSelectionProviders()
	 * @see #getWorkbenchPartInteractions()
	 * @generated
	 */
	EReference getWorkbenchPartInteractions_SelectionProviders();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getSelectionListeners <em>Selection Listeners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selection Listeners</em>'.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getSelectionListeners()
	 * @see #getWorkbenchPartInteractions()
	 * @generated
	 */
	EReference getWorkbenchPartInteractions_SelectionListeners();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getPartListeners <em>Part Listeners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part Listeners</em>'.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getPartListeners()
	 * @see #getWorkbenchPartInteractions()
	 * @generated
	 */
	EReference getWorkbenchPartInteractions_PartListeners();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getAdapterProviders <em>Adapter Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adapter Providers</em>'.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getAdapterProviders()
	 * @see #getWorkbenchPartInteractions()
	 * @generated
	 */
	EReference getWorkbenchPartInteractions_AdapterProviders();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getAdapterRequestors <em>Adapter Requestors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adapter Requestors</em>'.
	 * @see ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions#getAdapterRequestors()
	 * @see #getWorkbenchPartInteractions()
	 * @generated
	 */
	EReference getWorkbenchPartInteractions_AdapterRequestors();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.Part#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Part#getName()
	 * @see #getPart()
	 * @generated
	 */
	EAttribute getPart_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.Part#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Part#getPackage()
	 * @see #getPart()
	 * @generated
	 */
	EAttribute getPart_Package();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.Part#isLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Part#isLocal()
	 * @see #getPart()
	 * @generated
	 */
	EAttribute getPart_Local();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.ViewPart <em>View Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ViewPart
	 * @generated
	 */
	EClass getViewPart();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.ViewPart#getPartId <em>Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Id</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ViewPart#getPartId()
	 * @see #getViewPart()
	 * @generated
	 */
	EAttribute getViewPart_PartId();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.ViewPart#getImplementsIViewPart <em>Implements IView Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implements IView Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ViewPart#getImplementsIViewPart()
	 * @see #getViewPart()
	 * @generated
	 */
	EReference getViewPart_ImplementsIViewPart();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.ImplementsIViewPart <em>Implements IView Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implements IView Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ImplementsIViewPart
	 * @generated
	 */
	EClass getImplementsIViewPart();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.ImplementsIViewPart#getExtendsViewPart <em>Extends View Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends View Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ImplementsIViewPart#getExtendsViewPart()
	 * @see #getImplementsIViewPart()
	 * @generated
	 */
	EReference getImplementsIViewPart_ExtendsViewPart();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.ExtendsViewPart <em>Extends View Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extends View Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsViewPart
	 * @generated
	 */
	EClass getExtendsViewPart();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.ExtendsViewPart#isExtendsPageBookView <em>Extends Page Book View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends Page Book View</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsViewPart#isExtendsPageBookView()
	 * @see #getExtendsViewPart()
	 * @generated
	 */
	EAttribute getExtendsViewPart_ExtendsPageBookView();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.EditorPart <em>Editor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.EditorPart
	 * @generated
	 */
	EClass getEditorPart();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.EditorPart#getPartId <em>Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Id</em>'.
	 * @see ca.uwaterloo.gsd.wpi.EditorPart#getPartId()
	 * @see #getEditorPart()
	 * @generated
	 */
	EAttribute getEditorPart_PartId();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.EditorPart#getContributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contributor</em>'.
	 * @see ca.uwaterloo.gsd.wpi.EditorPart#getContributor()
	 * @see #getEditorPart()
	 * @generated
	 */
	EReference getEditorPart_Contributor();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.EditorPart#getImplementsIEditorPart <em>Implements IEditor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implements IEditor Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.EditorPart#getImplementsIEditorPart()
	 * @see #getEditorPart()
	 * @generated
	 */
	EReference getEditorPart_ImplementsIEditorPart();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.Contributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contributor</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Contributor
	 * @generated
	 */
	EClass getContributor();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.Contributor#getContributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contributor</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Contributor#getContributor()
	 * @see #getContributor()
	 * @generated
	 */
	EAttribute getContributor_Contributor();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.Contributor#getExtendsEditorActionBarContributor <em>Extends Editor Action Bar Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends Editor Action Bar Contributor</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Contributor#getExtendsEditorActionBarContributor()
	 * @see #getContributor()
	 * @generated
	 */
	EReference getContributor_ExtendsEditorActionBarContributor();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor <em>Extends Editor Action Bar Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extends Editor Action Bar Contributor</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor
	 * @generated
	 */
	EClass getExtendsEditorActionBarContributor();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor#isExtendsMultiPageEditorActionBarContributor <em>Extends Multi Page Editor Action Bar Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends Multi Page Editor Action Bar Contributor</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsEditorActionBarContributor#isExtendsMultiPageEditorActionBarContributor()
	 * @see #getExtendsEditorActionBarContributor()
	 * @generated
	 */
	EAttribute getExtendsEditorActionBarContributor_ExtendsMultiPageEditorActionBarContributor();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.ImplementsIEditorPart <em>Implements IEditor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implements IEditor Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ImplementsIEditorPart
	 * @generated
	 */
	EClass getImplementsIEditorPart();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.ImplementsIEditorPart#getExtendsEditorPart <em>Extends Editor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends Editor Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ImplementsIEditorPart#getExtendsEditorPart()
	 * @see #getImplementsIEditorPart()
	 * @generated
	 */
	EReference getImplementsIEditorPart_ExtendsEditorPart();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.ExtendsEditorPart <em>Extends Editor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extends Editor Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsEditorPart
	 * @generated
	 */
	EClass getExtendsEditorPart();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.ExtendsEditorPart#isExtendsMultiPageEditorPart <em>Extends Multi Page Editor Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends Multi Page Editor Part</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ExtendsEditorPart#isExtendsMultiPageEditorPart()
	 * @see #getExtendsEditorPart()
	 * @generated
	 */
	EAttribute getExtendsEditorPart_ExtendsMultiPageEditorPart();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.SelectionProvider <em>Selection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SelectionProvider
	 * @generated
	 */
	EClass getSelectionProvider();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.wpi.SelectionProvider#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SelectionProvider#getProvider()
	 * @see #getSelectionProvider()
	 * @generated
	 */
	EReference getSelectionProvider_Provider();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.SelectionProvider#getRegisters <em>Registers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SelectionProvider#getRegisters()
	 * @see #getSelectionProvider()
	 * @generated
	 */
	EReference getSelectionProvider_Registers();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider <em>Registers As Selection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registers As Selection Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider
	 * @generated
	 */
	EClass getRegistersAsSelectionProvider();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersThis <em>Registers This</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Registers This</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersThis()
	 * @see #getRegistersAsSelectionProvider()
	 * @generated
	 */
	EReference getRegistersAsSelectionProvider_RegistersThis();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersField <em>Registers Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Registers Field</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersField()
	 * @see #getRegistersAsSelectionProvider()
	 * @generated
	 */
	EReference getRegistersAsSelectionProvider_RegistersField();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.ThisSelectionProvider <em>This Selection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Selection Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ThisSelectionProvider
	 * @generated
	 */
	EClass getThisSelectionProvider();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.ThisSelectionProvider#isImplementsISelectionProvider <em>Implements ISelection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implements ISelection Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ThisSelectionProvider#isImplementsISelectionProvider()
	 * @see #getThisSelectionProvider()
	 * @generated
	 */
	EAttribute getThisSelectionProvider_ImplementsISelectionProvider();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider <em>Field Selection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Selection Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.FieldSelectionProvider
	 * @generated
	 */
	EClass getFieldSelectionProvider();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see ca.uwaterloo.gsd.wpi.FieldSelectionProvider#getField()
	 * @see #getFieldSelectionProvider()
	 * @generated
	 */
	EAttribute getFieldSelectionProvider_Field();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#isTypedISelectionProvider <em>Typed ISelection Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Typed ISelection Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.FieldSelectionProvider#isTypedISelectionProvider()
	 * @see #getFieldSelectionProvider()
	 * @generated
	 */
	EAttribute getFieldSelectionProvider_TypedISelectionProvider();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.FieldSelectionProvider#isInitialized <em>Initialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized</em>'.
	 * @see ca.uwaterloo.gsd.wpi.FieldSelectionProvider#isInitialized()
	 * @see #getFieldSelectionProvider()
	 * @generated
	 */
	EAttribute getFieldSelectionProvider_Initialized();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#isRegistersHelper <em>Registers Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registers Helper</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#isRegistersHelper()
	 * @see #getRegistersAsSelectionProvider()
	 * @generated
	 */
	EAttribute getRegistersAsSelectionProvider_RegistersHelper();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersVariable <em>Registers Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registers Variable</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsSelectionProvider#getRegistersVariable()
	 * @see #getRegistersAsSelectionProvider()
	 * @generated
	 */
	EAttribute getRegistersAsSelectionProvider_RegistersVariable();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.SelectionListener <em>Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SelectionListener
	 * @generated
	 */
	EClass getSelectionListener();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.wpi.SelectionListener#getListener <em>Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SelectionListener#getListener()
	 * @see #getSelectionListener()
	 * @generated
	 */
	EReference getSelectionListener_Listener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.SelectionListener#getRegistersAs <em>Registers As</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Registers As</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SelectionListener#getRegistersAs()
	 * @see #getSelectionListener()
	 * @generated
	 */
	EReference getSelectionListener_RegistersAs();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.RegistersAs <em>Registers As</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registers As</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAs
	 * @generated
	 */
	EClass getRegistersAs();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.RegistersAs#getGlobalSelectionListener <em>Global Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Selection Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAs#getGlobalSelectionListener()
	 * @see #getRegistersAs()
	 * @generated
	 */
	EReference getRegistersAs_GlobalSelectionListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.RegistersAs#getGlobalPostSelectionListener <em>Global Post Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Post Selection Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAs#getGlobalPostSelectionListener()
	 * @see #getRegistersAs()
	 * @generated
	 */
	EReference getRegistersAs_GlobalPostSelectionListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.RegistersAs#getSpecificSelectionListener <em>Specific Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specific Selection Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAs#getSpecificSelectionListener()
	 * @see #getRegistersAs()
	 * @generated
	 */
	EReference getRegistersAs_SpecificSelectionListener();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.GlobalSelectionListener <em>Global Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Selection Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.GlobalSelectionListener
	 * @generated
	 */
	EClass getGlobalSelectionListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.GlobalSelectionListener#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.wpi.GlobalSelectionListener#getDeregisters()
	 * @see #getGlobalSelectionListener()
	 * @generated
	 */
	EReference getGlobalSelectionListener_Deregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener <em>Global Post Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Post Selection Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener
	 * @generated
	 */
	EClass getGlobalPostSelectionListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.wpi.GlobalPostSelectionListener#getDeregisters()
	 * @see #getGlobalPostSelectionListener()
	 * @generated
	 */
	EReference getGlobalPostSelectionListener_Deregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener <em>Specific Selection Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Selection Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SpecificSelectionListener
	 * @generated
	 */
	EClass getSpecificSelectionListener();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getRegistrationPartId <em>Registration Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registration Part Id</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getRegistrationPartId()
	 * @see #getSpecificSelectionListener()
	 * @generated
	 */
	EAttribute getSpecificSelectionListener_RegistrationPartId();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getProvider()
	 * @see #getSpecificSelectionListener()
	 * @generated
	 */
	EReference getSpecificSelectionListener_Provider();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getProviderName <em>Provider Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider Name</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getProviderName()
	 * @see #getSpecificSelectionListener()
	 * @generated
	 */
	EAttribute getSpecificSelectionListener_ProviderName();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.wpi.SpecificSelectionListener#getDeregisters()
	 * @see #getSpecificSelectionListener()
	 * @generated
	 */
	EReference getSpecificSelectionListener_Deregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId <em>Deregisters Same Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deregisters Same Part Id</em>'.
	 * @see ca.uwaterloo.gsd.wpi.DeregistersSamePartId
	 * @generated
	 */
	EClass getDeregistersSamePartId();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId#getDeregistrationPartId <em>Deregistration Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deregistration Part Id</em>'.
	 * @see ca.uwaterloo.gsd.wpi.DeregistersSamePartId#getDeregistrationPartId()
	 * @see #getDeregistersSamePartId()
	 * @generated
	 */
	EAttribute getDeregistersSamePartId_DeregistrationPartId();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.DeregistersSamePartId#getDeregistersSameObject <em>Deregisters Same Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deregisters Same Object</em>'.
	 * @see ca.uwaterloo.gsd.wpi.DeregistersSamePartId#getDeregistersSameObject()
	 * @see #getDeregistersSamePartId()
	 * @generated
	 */
	EReference getDeregistersSamePartId_DeregistersSameObject();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.PartListener <em>Part Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.PartListener
	 * @generated
	 */
	EClass getPartListener();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.wpi.PartListener#getListener <em>Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.PartListener#getListener()
	 * @see #getPartListener()
	 * @generated
	 */
	EReference getPartListener_Listener();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.PartListener#getRegistersAPartListener <em>Registers APart Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Registers APart Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.PartListener#getRegistersAPartListener()
	 * @see #getPartListener()
	 * @generated
	 */
	EReference getPartListener_RegistersAPartListener();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.RegistersAPartListener <em>Registers APart Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registers APart Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAPartListener
	 * @generated
	 */
	EClass getRegistersAPartListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.RegistersAPartListener#getRegisters <em>Registers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAPartListener#getRegisters()
	 * @see #getRegistersAPartListener()
	 * @generated
	 */
	EReference getRegistersAPartListener_Registers();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.RegistersAPartListener#getRegisters2 <em>Registers2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Registers2</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAPartListener#getRegisters2()
	 * @see #getRegistersAPartListener()
	 * @generated
	 */
	EReference getRegistersAPartListener_Registers2();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.RegistersAsPartListener <em>Registers As Part Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registers As Part Listener</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsPartListener
	 * @generated
	 */
	EClass getRegistersAsPartListener();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.RegistersAsPartListener#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsPartListener#getDeregisters()
	 * @see #getRegistersAsPartListener()
	 * @generated
	 */
	EReference getRegistersAsPartListener_Deregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.RegistersAsPartListener2 <em>Registers As Part Listener2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registers As Part Listener2</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsPartListener2
	 * @generated
	 */
	EClass getRegistersAsPartListener2();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.RegistersAsPartListener2#getDeregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RegistersAsPartListener2#getDeregisters()
	 * @see #getRegistersAsPartListener2()
	 * @generated
	 */
	EReference getRegistersAsPartListener2_Deregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.Deregisters <em>Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Deregisters
	 * @generated
	 */
	EClass getDeregisters();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.Deregisters#getDeregistersSameObject <em>Deregisters Same Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deregisters Same Object</em>'.
	 * @see ca.uwaterloo.gsd.wpi.Deregisters#getDeregistersSameObject()
	 * @see #getDeregisters()
	 * @generated
	 */
	EReference getDeregisters_DeregistersSameObject();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.DeregistersSameObject <em>Deregisters Same Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deregisters Same Object</em>'.
	 * @see ca.uwaterloo.gsd.wpi.DeregistersSameObject
	 * @generated
	 */
	EClass getDeregistersSameObject();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.DeregistersSameObject#isRegistersBeforeDeregisters <em>Registers Before Deregisters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registers Before Deregisters</em>'.
	 * @see ca.uwaterloo.gsd.wpi.DeregistersSameObject#isRegistersBeforeDeregisters()
	 * @see #getDeregistersSameObject()
	 * @generated
	 */
	EAttribute getDeregistersSameObject_RegistersBeforeDeregisters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.AdapterProvider <em>Adapter Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.AdapterProvider
	 * @generated
	 */
	EClass getAdapterProvider();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.wpi.AdapterProvider#getAdapterProvider <em>Adapter Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Adapter Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.AdapterProvider#getAdapterProvider()
	 * @see #getAdapterProvider()
	 * @generated
	 */
	EReference getAdapterProvider_AdapterProvider();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.wpi.AdapterProvider#getProvidesAdapter <em>Provides Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Provides Adapter</em>'.
	 * @see ca.uwaterloo.gsd.wpi.AdapterProvider#getProvidesAdapter()
	 * @see #getAdapterProvider()
	 * @generated
	 */
	EReference getAdapterProvider_ProvidesAdapter();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.ProvidesAdapter <em>Provides Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provides Adapter</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ProvidesAdapter
	 * @generated
	 */
	EClass getProvidesAdapter();

	/**
	 * Returns the meta object for the attribute list '{@link ca.uwaterloo.gsd.wpi.ProvidesAdapter#getAdapters <em>Adapters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Adapters</em>'.
	 * @see ca.uwaterloo.gsd.wpi.ProvidesAdapter#getAdapters()
	 * @see #getProvidesAdapter()
	 * @generated
	 */
	EAttribute getProvidesAdapter_Adapters();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.AdapterRequestor <em>Adapter Requestor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Requestor</em>'.
	 * @see ca.uwaterloo.gsd.wpi.AdapterRequestor
	 * @generated
	 */
	EClass getAdapterRequestor();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.wpi.AdapterRequestor#getAdapterRequestor <em>Adapter Requestor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Adapter Requestor</em>'.
	 * @see ca.uwaterloo.gsd.wpi.AdapterRequestor#getAdapterRequestor()
	 * @see #getAdapterRequestor()
	 * @generated
	 */
	EReference getAdapterRequestor_AdapterRequestor();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.wpi.AdapterRequestor#getRequestsAdapter <em>Requests Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requests Adapter</em>'.
	 * @see ca.uwaterloo.gsd.wpi.AdapterRequestor#getRequestsAdapter()
	 * @see #getAdapterRequestor()
	 * @generated
	 */
	EReference getAdapterRequestor_RequestsAdapter();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.wpi.RequestsAdapter <em>Requests Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requests Adapter</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RequestsAdapter
	 * @generated
	 */
	EClass getRequestsAdapter();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.wpi.RequestsAdapter#getAdapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adapter</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RequestsAdapter#getAdapter()
	 * @see #getRequestsAdapter()
	 * @generated
	 */
	EAttribute getRequestsAdapter_Adapter();

	/**
	 * Returns the meta object for the reference list '{@link ca.uwaterloo.gsd.wpi.RequestsAdapter#getAdapterProvider <em>Adapter Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Adapter Provider</em>'.
	 * @see ca.uwaterloo.gsd.wpi.RequestsAdapter#getAdapterProvider()
	 * @see #getRequestsAdapter()
	 * @generated
	 */
	EReference getRequestsAdapter_AdapterProvider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WpiFactory getWpiFactory();

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
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl <em>Workbench Part Interactions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getWorkbenchPartInteractions()
		 * @generated
		 */
		EClass WORKBENCH_PART_INTERACTIONS = eINSTANCE.getWorkbenchPartInteractions();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKBENCH_PART_INTERACTIONS__PROJECT = eINSTANCE.getWorkbenchPartInteractions_Project();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKBENCH_PART_INTERACTIONS__PARTS = eINSTANCE.getWorkbenchPartInteractions_Parts();

		/**
		 * The meta object literal for the '<em><b>Selection Providers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS = eINSTANCE.getWorkbenchPartInteractions_SelectionProviders();

		/**
		 * The meta object literal for the '<em><b>Selection Listeners</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS = eINSTANCE.getWorkbenchPartInteractions_SelectionListeners();

		/**
		 * The meta object literal for the '<em><b>Part Listeners</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKBENCH_PART_INTERACTIONS__PART_LISTENERS = eINSTANCE.getWorkbenchPartInteractions_PartListeners();

		/**
		 * The meta object literal for the '<em><b>Adapter Providers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS = eINSTANCE.getWorkbenchPartInteractions_AdapterProviders();

		/**
		 * The meta object literal for the '<em><b>Adapter Requestors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS = eINSTANCE.getWorkbenchPartInteractions_AdapterRequestors();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.PartImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getPart()
		 * @generated
		 */
		EClass PART = eINSTANCE.getPart();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PART__NAME = eINSTANCE.getPart_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PART__PACKAGE = eINSTANCE.getPart_Package();

		/**
		 * The meta object literal for the '<em><b>Local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PART__LOCAL = eINSTANCE.getPart_Local();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ViewPartImpl <em>View Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ViewPartImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getViewPart()
		 * @generated
		 */
		EClass VIEW_PART = eINSTANCE.getViewPart();

		/**
		 * The meta object literal for the '<em><b>Part Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_PART__PART_ID = eINSTANCE.getViewPart_PartId();

		/**
		 * The meta object literal for the '<em><b>Implements IView Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_PART__IMPLEMENTS_IVIEW_PART = eINSTANCE.getViewPart_ImplementsIViewPart();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ImplementsIViewPartImpl <em>Implements IView Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ImplementsIViewPartImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getImplementsIViewPart()
		 * @generated
		 */
		EClass IMPLEMENTS_IVIEW_PART = eINSTANCE.getImplementsIViewPart();

		/**
		 * The meta object literal for the '<em><b>Extends View Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTS_IVIEW_PART__EXTENDS_VIEW_PART = eINSTANCE.getImplementsIViewPart_ExtendsViewPart();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ExtendsViewPartImpl <em>Extends View Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ExtendsViewPartImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getExtendsViewPart()
		 * @generated
		 */
		EClass EXTENDS_VIEW_PART = eINSTANCE.getExtendsViewPart();

		/**
		 * The meta object literal for the '<em><b>Extends Page Book View</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDS_VIEW_PART__EXTENDS_PAGE_BOOK_VIEW = eINSTANCE.getExtendsViewPart_ExtendsPageBookView();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.EditorPartImpl <em>Editor Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.EditorPartImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getEditorPart()
		 * @generated
		 */
		EClass EDITOR_PART = eINSTANCE.getEditorPart();

		/**
		 * The meta object literal for the '<em><b>Part Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR_PART__PART_ID = eINSTANCE.getEditorPart_PartId();

		/**
		 * The meta object literal for the '<em><b>Contributor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDITOR_PART__CONTRIBUTOR = eINSTANCE.getEditorPart_Contributor();

		/**
		 * The meta object literal for the '<em><b>Implements IEditor Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDITOR_PART__IMPLEMENTS_IEDITOR_PART = eINSTANCE.getEditorPart_ImplementsIEditorPart();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ContributorImpl <em>Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ContributorImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getContributor()
		 * @generated
		 */
		EClass CONTRIBUTOR = eINSTANCE.getContributor();

		/**
		 * The meta object literal for the '<em><b>Contributor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTOR__CONTRIBUTOR = eINSTANCE.getContributor_Contributor();

		/**
		 * The meta object literal for the '<em><b>Extends Editor Action Bar Contributor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTOR__EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR = eINSTANCE.getContributor_ExtendsEditorActionBarContributor();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ExtendsEditorActionBarContributorImpl <em>Extends Editor Action Bar Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ExtendsEditorActionBarContributorImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getExtendsEditorActionBarContributor()
		 * @generated
		 */
		EClass EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR = eINSTANCE.getExtendsEditorActionBarContributor();

		/**
		 * The meta object literal for the '<em><b>Extends Multi Page Editor Action Bar Contributor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDS_EDITOR_ACTION_BAR_CONTRIBUTOR__EXTENDS_MULTI_PAGE_EDITOR_ACTION_BAR_CONTRIBUTOR = eINSTANCE.getExtendsEditorActionBarContributor_ExtendsMultiPageEditorActionBarContributor();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ImplementsIEditorPartImpl <em>Implements IEditor Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ImplementsIEditorPartImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getImplementsIEditorPart()
		 * @generated
		 */
		EClass IMPLEMENTS_IEDITOR_PART = eINSTANCE.getImplementsIEditorPart();

		/**
		 * The meta object literal for the '<em><b>Extends Editor Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTS_IEDITOR_PART__EXTENDS_EDITOR_PART = eINSTANCE.getImplementsIEditorPart_ExtendsEditorPart();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ExtendsEditorPartImpl <em>Extends Editor Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ExtendsEditorPartImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getExtendsEditorPart()
		 * @generated
		 */
		EClass EXTENDS_EDITOR_PART = eINSTANCE.getExtendsEditorPart();

		/**
		 * The meta object literal for the '<em><b>Extends Multi Page Editor Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDS_EDITOR_PART__EXTENDS_MULTI_PAGE_EDITOR_PART = eINSTANCE.getExtendsEditorPart_ExtendsMultiPageEditorPart();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.SelectionProviderImpl <em>Selection Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.SelectionProviderImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getSelectionProvider()
		 * @generated
		 */
		EClass SELECTION_PROVIDER = eINSTANCE.getSelectionProvider();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROVIDER__PROVIDER = eINSTANCE.getSelectionProvider_Provider();

		/**
		 * The meta object literal for the '<em><b>Registers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROVIDER__REGISTERS = eINSTANCE.getSelectionProvider_Registers();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsSelectionProviderImpl <em>Registers As Selection Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAsSelectionProviderImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAsSelectionProvider()
		 * @generated
		 */
		EClass REGISTERS_AS_SELECTION_PROVIDER = eINSTANCE.getRegistersAsSelectionProvider();

		/**
		 * The meta object literal for the '<em><b>Registers This</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_THIS = eINSTANCE.getRegistersAsSelectionProvider_RegistersThis();

		/**
		 * The meta object literal for the '<em><b>Registers Field</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_FIELD = eINSTANCE.getRegistersAsSelectionProvider_RegistersField();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ThisSelectionProviderImpl <em>This Selection Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ThisSelectionProviderImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getThisSelectionProvider()
		 * @generated
		 */
		EClass THIS_SELECTION_PROVIDER = eINSTANCE.getThisSelectionProvider();

		/**
		 * The meta object literal for the '<em><b>Implements ISelection Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THIS_SELECTION_PROVIDER__IMPLEMENTS_ISELECTION_PROVIDER = eINSTANCE.getThisSelectionProvider_ImplementsISelectionProvider();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.FieldSelectionProviderImpl <em>Field Selection Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.FieldSelectionProviderImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getFieldSelectionProvider()
		 * @generated
		 */
		EClass FIELD_SELECTION_PROVIDER = eINSTANCE.getFieldSelectionProvider();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_SELECTION_PROVIDER__FIELD = eINSTANCE.getFieldSelectionProvider_Field();

		/**
		 * The meta object literal for the '<em><b>Typed ISelection Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_SELECTION_PROVIDER__TYPED_ISELECTION_PROVIDER = eINSTANCE.getFieldSelectionProvider_TypedISelectionProvider();

		/**
		 * The meta object literal for the '<em><b>Initialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_SELECTION_PROVIDER__INITIALIZED = eINSTANCE.getFieldSelectionProvider_Initialized();

		/**
		 * The meta object literal for the '<em><b>Registers Helper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_HELPER = eINSTANCE.getRegistersAsSelectionProvider_RegistersHelper();

		/**
		 * The meta object literal for the '<em><b>Registers Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTERS_AS_SELECTION_PROVIDER__REGISTERS_VARIABLE = eINSTANCE.getRegistersAsSelectionProvider_RegistersVariable();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.SelectionListenerImpl <em>Selection Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.SelectionListenerImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getSelectionListener()
		 * @generated
		 */
		EClass SELECTION_LISTENER = eINSTANCE.getSelectionListener();

		/**
		 * The meta object literal for the '<em><b>Listener</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_LISTENER__LISTENER = eINSTANCE.getSelectionListener_Listener();

		/**
		 * The meta object literal for the '<em><b>Registers As</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_LISTENER__REGISTERS_AS = eINSTANCE.getSelectionListener_RegistersAs();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsImpl <em>Registers As</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAsImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAs()
		 * @generated
		 */
		EClass REGISTERS_AS = eINSTANCE.getRegistersAs();

		/**
		 * The meta object literal for the '<em><b>Global Selection Listener</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_AS__GLOBAL_SELECTION_LISTENER = eINSTANCE.getRegistersAs_GlobalSelectionListener();

		/**
		 * The meta object literal for the '<em><b>Global Post Selection Listener</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_AS__GLOBAL_POST_SELECTION_LISTENER = eINSTANCE.getRegistersAs_GlobalPostSelectionListener();

		/**
		 * The meta object literal for the '<em><b>Specific Selection Listener</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_AS__SPECIFIC_SELECTION_LISTENER = eINSTANCE.getRegistersAs_SpecificSelectionListener();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.GlobalSelectionListenerImpl <em>Global Selection Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.GlobalSelectionListenerImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getGlobalSelectionListener()
		 * @generated
		 */
		EClass GLOBAL_SELECTION_LISTENER = eINSTANCE.getGlobalSelectionListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_SELECTION_LISTENER__DEREGISTERS = eINSTANCE.getGlobalSelectionListener_Deregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.GlobalPostSelectionListenerImpl <em>Global Post Selection Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.GlobalPostSelectionListenerImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getGlobalPostSelectionListener()
		 * @generated
		 */
		EClass GLOBAL_POST_SELECTION_LISTENER = eINSTANCE.getGlobalPostSelectionListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_POST_SELECTION_LISTENER__DEREGISTERS = eINSTANCE.getGlobalPostSelectionListener_Deregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.SpecificSelectionListenerImpl <em>Specific Selection Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.SpecificSelectionListenerImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getSpecificSelectionListener()
		 * @generated
		 */
		EClass SPECIFIC_SELECTION_LISTENER = eINSTANCE.getSpecificSelectionListener();

		/**
		 * The meta object literal for the '<em><b>Registration Part Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SELECTION_LISTENER__REGISTRATION_PART_ID = eINSTANCE.getSpecificSelectionListener_RegistrationPartId();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_SELECTION_LISTENER__PROVIDER = eINSTANCE.getSpecificSelectionListener_Provider();

		/**
		 * The meta object literal for the '<em><b>Provider Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SELECTION_LISTENER__PROVIDER_NAME = eINSTANCE.getSpecificSelectionListener_ProviderName();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_SELECTION_LISTENER__DEREGISTERS = eINSTANCE.getSpecificSelectionListener_Deregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.DeregistersSamePartIdImpl <em>Deregisters Same Part Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.DeregistersSamePartIdImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getDeregistersSamePartId()
		 * @generated
		 */
		EClass DEREGISTERS_SAME_PART_ID = eINSTANCE.getDeregistersSamePartId();

		/**
		 * The meta object literal for the '<em><b>Deregistration Part Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEREGISTERS_SAME_PART_ID__DEREGISTRATION_PART_ID = eINSTANCE.getDeregistersSamePartId_DeregistrationPartId();

		/**
		 * The meta object literal for the '<em><b>Deregisters Same Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEREGISTERS_SAME_PART_ID__DEREGISTERS_SAME_OBJECT = eINSTANCE.getDeregistersSamePartId_DeregistersSameObject();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.PartListenerImpl <em>Part Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.PartListenerImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getPartListener()
		 * @generated
		 */
		EClass PART_LISTENER = eINSTANCE.getPartListener();

		/**
		 * The meta object literal for the '<em><b>Listener</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART_LISTENER__LISTENER = eINSTANCE.getPartListener_Listener();

		/**
		 * The meta object literal for the '<em><b>Registers APart Listener</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART_LISTENER__REGISTERS_APART_LISTENER = eINSTANCE.getPartListener_RegistersAPartListener();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAPartListenerImpl <em>Registers APart Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAPartListenerImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAPartListener()
		 * @generated
		 */
		EClass REGISTERS_APART_LISTENER = eINSTANCE.getRegistersAPartListener();

		/**
		 * The meta object literal for the '<em><b>Registers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_APART_LISTENER__REGISTERS = eINSTANCE.getRegistersAPartListener_Registers();

		/**
		 * The meta object literal for the '<em><b>Registers2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_APART_LISTENER__REGISTERS2 = eINSTANCE.getRegistersAPartListener_Registers2();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsPartListenerImpl <em>Registers As Part Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAsPartListenerImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAsPartListener()
		 * @generated
		 */
		EClass REGISTERS_AS_PART_LISTENER = eINSTANCE.getRegistersAsPartListener();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_AS_PART_LISTENER__DEREGISTERS = eINSTANCE.getRegistersAsPartListener_Deregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.RegistersAsPartListener2Impl <em>Registers As Part Listener2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.RegistersAsPartListener2Impl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRegistersAsPartListener2()
		 * @generated
		 */
		EClass REGISTERS_AS_PART_LISTENER2 = eINSTANCE.getRegistersAsPartListener2();

		/**
		 * The meta object literal for the '<em><b>Deregisters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTERS_AS_PART_LISTENER2__DEREGISTERS = eINSTANCE.getRegistersAsPartListener2_Deregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.DeregistersImpl <em>Deregisters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.DeregistersImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getDeregisters()
		 * @generated
		 */
		EClass DEREGISTERS = eINSTANCE.getDeregisters();

		/**
		 * The meta object literal for the '<em><b>Deregisters Same Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEREGISTERS__DEREGISTERS_SAME_OBJECT = eINSTANCE.getDeregisters_DeregistersSameObject();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.DeregistersSameObjectImpl <em>Deregisters Same Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.DeregistersSameObjectImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getDeregistersSameObject()
		 * @generated
		 */
		EClass DEREGISTERS_SAME_OBJECT = eINSTANCE.getDeregistersSameObject();

		/**
		 * The meta object literal for the '<em><b>Registers Before Deregisters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEREGISTERS_SAME_OBJECT__REGISTERS_BEFORE_DEREGISTERS = eINSTANCE.getDeregistersSameObject_RegistersBeforeDeregisters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.AdapterProviderImpl <em>Adapter Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.AdapterProviderImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getAdapterProvider()
		 * @generated
		 */
		EClass ADAPTER_PROVIDER = eINSTANCE.getAdapterProvider();

		/**
		 * The meta object literal for the '<em><b>Adapter Provider</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_PROVIDER__ADAPTER_PROVIDER = eINSTANCE.getAdapterProvider_AdapterProvider();

		/**
		 * The meta object literal for the '<em><b>Provides Adapter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_PROVIDER__PROVIDES_ADAPTER = eINSTANCE.getAdapterProvider_ProvidesAdapter();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.ProvidesAdapterImpl <em>Provides Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.ProvidesAdapterImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getProvidesAdapter()
		 * @generated
		 */
		EClass PROVIDES_ADAPTER = eINSTANCE.getProvidesAdapter();

		/**
		 * The meta object literal for the '<em><b>Adapters</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDES_ADAPTER__ADAPTERS = eINSTANCE.getProvidesAdapter_Adapters();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.AdapterRequestorImpl <em>Adapter Requestor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.AdapterRequestorImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getAdapterRequestor()
		 * @generated
		 */
		EClass ADAPTER_REQUESTOR = eINSTANCE.getAdapterRequestor();

		/**
		 * The meta object literal for the '<em><b>Adapter Requestor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_REQUESTOR__ADAPTER_REQUESTOR = eINSTANCE.getAdapterRequestor_AdapterRequestor();

		/**
		 * The meta object literal for the '<em><b>Requests Adapter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_REQUESTOR__REQUESTS_ADAPTER = eINSTANCE.getAdapterRequestor_RequestsAdapter();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.wpi.impl.RequestsAdapterImpl <em>Requests Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.wpi.impl.RequestsAdapterImpl
		 * @see ca.uwaterloo.gsd.wpi.impl.WpiPackageImpl#getRequestsAdapter()
		 * @generated
		 */
		EClass REQUESTS_ADAPTER = eINSTANCE.getRequestsAdapter();

		/**
		 * The meta object literal for the '<em><b>Adapter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUESTS_ADAPTER__ADAPTER = eINSTANCE.getRequestsAdapter_Adapter();

		/**
		 * The meta object literal for the '<em><b>Adapter Provider</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUESTS_ADAPTER__ADAPTER_PROVIDER = eINSTANCE.getRequestsAdapter_AdapterProvider();

	}

} //WpiPackage
