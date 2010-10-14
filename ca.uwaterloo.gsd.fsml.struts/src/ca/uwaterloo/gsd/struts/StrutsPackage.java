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
 * $Id: StrutsPackage.java,v 1.14 2009/04/21 16:47:57 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts;

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
 * @see ca.uwaterloo.gsd.struts.StrutsFactory
 * @model kind="package"
 * @generated
 */
public interface StrutsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "struts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://gsd.uwaterloo.ca/fsml/struts";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "struts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StrutsPackage eINSTANCE = ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.StrutsApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsApplicationImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getStrutsApplication()
	 * @generated
	 */
	int STRUTS_APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_APPLICATION__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Struts Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_APPLICATION__STRUTS_CONFIG = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Forms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_APPLICATION__FORMS = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_APPLICATION__ACTIONS = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_APPLICATION_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.FormImplImpl <em>Form Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.FormImplImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getFormImpl()
	 * @generated
	 */
	int FORM_IMPL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_IMPL__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_IMPL__PACKAGE = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_IMPL__QUALIFIED_NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_IMPL__LOCAL = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extends Action Form</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_IMPL__EXTENDS_ACTION_FORM = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Form Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_IMPL_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.ExtendsActionFormImpl <em>Extends Action Form</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.ExtendsActionFormImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getExtendsActionForm()
	 * @generated
	 */
	int EXTENDS_ACTION_FORM = 2;

	/**
	 * The feature id for the '<em><b>Extends Dyna Action Form</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_ACTION_FORM__EXTENDS_DYNA_ACTION_FORM = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extends Action Form</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_ACTION_FORM_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl <em>Action Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.ActionImplImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getActionImpl()
	 * @generated
	 */
	int ACTION_IMPL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_IMPL__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_IMPL__PACKAGE = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_IMPL__QUALIFIED_NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_IMPL__LOCAL = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extends Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_IMPL__EXTENDS_ACTION = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Forwards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_IMPL__FORWARDS = FsmlPackage.CONCEPT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Input Forwards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_IMPL__INPUT_FORWARDS = FsmlPackage.CONCEPT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Action Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_IMPL_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.ForwardImplImpl <em>Forward Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.ForwardImplImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getForwardImpl()
	 * @generated
	 */
	int FORWARD_IMPL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_IMPL__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Forward</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_IMPL__FORWARD = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Forward Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_IMPL_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.InputForwardImplImpl <em>Input Forward Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.InputForwardImplImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getInputForwardImpl()
	 * @generated
	 */
	int INPUT_FORWARD_IMPL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FORWARD_IMPL__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Forward Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FORWARD_IMPL_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.ForwardImpl <em>Forward</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.ForwardImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getForward()
	 * @generated
	 */
	int FORWARD = 6;

	/**
	 * The feature id for the '<em><b>Local Forward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD__LOCAL_FORWARD = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global Forward</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD__GLOBAL_FORWARD = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Forward</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.ExtendsActionImpl <em>Extends Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.ExtendsActionImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getExtendsAction()
	 * @generated
	 */
	int EXTENDS_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Extends Dispatch Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Overrides Execute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_ACTION__OVERRIDES_EXECUTE = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Extends Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_ACTION_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.ExtendsDispatchActionImpl <em>Extends Dispatch Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.ExtendsDispatchActionImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getExtendsDispatchAction()
	 * @generated
	 */
	int EXTENDS_DISPATCH_ACTION = 8;

	/**
	 * The feature id for the '<em><b>Action Method</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_DISPATCH_ACTION__ACTION_METHOD = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extends Dispatch Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDS_DISPATCH_ACTION_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.StrutsConfigImpl <em>Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsConfigImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getStrutsConfig()
	 * @generated
	 */
	int STRUTS_CONFIG = 9;

	/**
	 * The feature id for the '<em><b>Forms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_CONFIG__FORMS = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Forwards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_CONFIG__FORWARDS = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_CONFIG__ACTIONS = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUTS_CONFIG_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.ActionDeclImpl <em>Action Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.ActionDeclImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getActionDecl()
	 * @generated
	 */
	int ACTION_DECL = 10;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DECL__PATH = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DECL__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DECL__TYPE = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Action Impl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DECL__ACTION_IMPL = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Forwards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DECL__FORWARDS = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DECL__INPUT = FsmlPackage.CONCEPT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Action Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_DECL_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.FormDeclImpl <em>Form Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.FormDeclImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getFormDecl()
	 * @generated
	 */
	int FORM_DECL = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_DECL__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Form Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_DECL__FORM_TYPE = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Dyna Action Form</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_DECL__IS_DYNA_ACTION_FORM = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Form Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_DECL__FORM_PROPERTY = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Form Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_DECL_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.ForwardDeclImpl <em>Forward Decl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.ForwardDeclImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getForwardDecl()
	 * @generated
	 */
	int FORWARD_DECL = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_DECL__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_DECL__PATH = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_DECL__TARGET = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Forward Decl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORWARD_DECL_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.struts.impl.FormPropertyImpl <em>Form Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.struts.impl.FormPropertyImpl
	 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getFormProperty()
	 * @generated
	 */
	int FORM_PROPERTY = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PROPERTY__NAME = FsmlPackage.CONCEPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PROPERTY__TYPE = FsmlPackage.CONCEPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Form Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_PROPERTY_FEATURE_COUNT = FsmlPackage.CONCEPT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.StrutsApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsApplication
	 * @generated
	 */
	EClass getStrutsApplication();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.struts.StrutsApplication#getStrutsConfig <em>Struts Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Struts Config</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsApplication#getStrutsConfig()
	 * @see #getStrutsApplication()
	 * @generated
	 */
	EReference getStrutsApplication_StrutsConfig();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.StrutsApplication#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsApplication#getName()
	 * @see #getStrutsApplication()
	 * @generated
	 */
	EAttribute getStrutsApplication_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.StrutsApplication#getForms <em>Forms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forms</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsApplication#getForms()
	 * @see #getStrutsApplication()
	 * @generated
	 */
	EReference getStrutsApplication_Forms();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.StrutsApplication#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsApplication#getActions()
	 * @see #getStrutsApplication()
	 * @generated
	 */
	EReference getStrutsApplication_Actions();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.FormImpl <em>Form Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Impl</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormImpl
	 * @generated
	 */
	EClass getFormImpl();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormImpl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormImpl#getName()
	 * @see #getFormImpl()
	 * @generated
	 */
	EAttribute getFormImpl_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormImpl#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormImpl#getPackage()
	 * @see #getFormImpl()
	 * @generated
	 */
	EAttribute getFormImpl_Package();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormImpl#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormImpl#getQualifiedName()
	 * @see #getFormImpl()
	 * @generated
	 */
	EAttribute getFormImpl_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormImpl#isLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormImpl#isLocal()
	 * @see #getFormImpl()
	 * @generated
	 */
	EAttribute getFormImpl_Local();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.struts.FormImpl#getExtendsActionForm <em>Extends Action Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends Action Form</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormImpl#getExtendsActionForm()
	 * @see #getFormImpl()
	 * @generated
	 */
	EReference getFormImpl_ExtendsActionForm();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.ExtendsActionForm <em>Extends Action Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extends Action Form</em>'.
	 * @see ca.uwaterloo.gsd.struts.ExtendsActionForm
	 * @generated
	 */
	EClass getExtendsActionForm();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ExtendsActionForm#isExtendsDynaActionForm <em>Extends Dyna Action Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends Dyna Action Form</em>'.
	 * @see ca.uwaterloo.gsd.struts.ExtendsActionForm#isExtendsDynaActionForm()
	 * @see #getExtendsActionForm()
	 * @generated
	 */
	EAttribute getExtendsActionForm_ExtendsDynaActionForm();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.ActionImpl <em>Action Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Impl</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl
	 * @generated
	 */
	EClass getActionImpl();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ActionImpl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl#getName()
	 * @see #getActionImpl()
	 * @generated
	 */
	EAttribute getActionImpl_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ActionImpl#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl#getPackage()
	 * @see #getActionImpl()
	 * @generated
	 */
	EAttribute getActionImpl_Package();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ActionImpl#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl#getQualifiedName()
	 * @see #getActionImpl()
	 * @generated
	 */
	EAttribute getActionImpl_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ActionImpl#isLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl#isLocal()
	 * @see #getActionImpl()
	 * @generated
	 */
	EAttribute getActionImpl_Local();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.struts.ActionImpl#getExtendsAction <em>Extends Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends Action</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl#getExtendsAction()
	 * @see #getActionImpl()
	 * @generated
	 */
	EReference getActionImpl_ExtendsAction();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.ActionImpl#getForwards <em>Forwards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forwards</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl#getForwards()
	 * @see #getActionImpl()
	 * @generated
	 */
	EReference getActionImpl_Forwards();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.ActionImpl#getInputForwards <em>Input Forwards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Forwards</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl#getInputForwards()
	 * @see #getActionImpl()
	 * @generated
	 */
	EReference getActionImpl_InputForwards();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.ForwardImpl <em>Forward Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forward Impl</em>'.
	 * @see ca.uwaterloo.gsd.struts.ForwardImpl
	 * @generated
	 */
	EClass getForwardImpl();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ForwardImpl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.ForwardImpl#getName()
	 * @see #getForwardImpl()
	 * @generated
	 */
	EAttribute getForwardImpl_Name();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.struts.ForwardImpl#getForward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Forward</em>'.
	 * @see ca.uwaterloo.gsd.struts.ForwardImpl#getForward()
	 * @see #getForwardImpl()
	 * @generated
	 */
	EReference getForwardImpl_Forward();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.InputForwardImpl <em>Input Forward Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Forward Impl</em>'.
	 * @see ca.uwaterloo.gsd.struts.InputForwardImpl
	 * @generated
	 */
	EClass getInputForwardImpl();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.InputForwardImpl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.InputForwardImpl#getName()
	 * @see #getInputForwardImpl()
	 * @generated
	 */
	EAttribute getInputForwardImpl_Name();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.Forward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forward</em>'.
	 * @see ca.uwaterloo.gsd.struts.Forward
	 * @generated
	 */
	EClass getForward();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.struts.Forward#getLocalForward <em>Local Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Forward</em>'.
	 * @see ca.uwaterloo.gsd.struts.Forward#getLocalForward()
	 * @see #getForward()
	 * @generated
	 */
	EReference getForward_LocalForward();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.struts.Forward#getGlobalForward <em>Global Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Global Forward</em>'.
	 * @see ca.uwaterloo.gsd.struts.Forward#getGlobalForward()
	 * @see #getForward()
	 * @generated
	 */
	EReference getForward_GlobalForward();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.ExtendsAction <em>Extends Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extends Action</em>'.
	 * @see ca.uwaterloo.gsd.struts.ExtendsAction
	 * @generated
	 */
	EClass getExtendsAction();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.struts.ExtendsAction#getExtendsDispatchAction <em>Extends Dispatch Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends Dispatch Action</em>'.
	 * @see ca.uwaterloo.gsd.struts.ExtendsAction#getExtendsDispatchAction()
	 * @see #getExtendsAction()
	 * @generated
	 */
	EReference getExtendsAction_ExtendsDispatchAction();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ExtendsAction#isOverridesExecute <em>Overrides Execute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overrides Execute</em>'.
	 * @see ca.uwaterloo.gsd.struts.ExtendsAction#isOverridesExecute()
	 * @see #getExtendsAction()
	 * @generated
	 */
	EAttribute getExtendsAction_OverridesExecute();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.ExtendsDispatchAction <em>Extends Dispatch Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extends Dispatch Action</em>'.
	 * @see ca.uwaterloo.gsd.struts.ExtendsDispatchAction
	 * @generated
	 */
	EClass getExtendsDispatchAction();

	/**
	 * Returns the meta object for the attribute list '{@link ca.uwaterloo.gsd.struts.ExtendsDispatchAction#getActionMethod <em>Action Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Action Method</em>'.
	 * @see ca.uwaterloo.gsd.struts.ExtendsDispatchAction#getActionMethod()
	 * @see #getExtendsDispatchAction()
	 * @generated
	 */
	EAttribute getExtendsDispatchAction_ActionMethod();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.StrutsConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsConfig
	 * @generated
	 */
	EClass getStrutsConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.StrutsConfig#getForms <em>Forms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forms</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsConfig#getForms()
	 * @see #getStrutsConfig()
	 * @generated
	 */
	EReference getStrutsConfig_Forms();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.StrutsConfig#getForwards <em>Forwards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forwards</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsConfig#getForwards()
	 * @see #getStrutsConfig()
	 * @generated
	 */
	EReference getStrutsConfig_Forwards();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.StrutsConfig#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see ca.uwaterloo.gsd.struts.StrutsConfig#getActions()
	 * @see #getStrutsConfig()
	 * @generated
	 */
	EReference getStrutsConfig_Actions();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.ActionDecl <em>Action Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Decl</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionDecl
	 * @generated
	 */
	EClass getActionDecl();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ActionDecl#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionDecl#getPath()
	 * @see #getActionDecl()
	 * @generated
	 */
	EAttribute getActionDecl_Path();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ActionDecl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionDecl#getName()
	 * @see #getActionDecl()
	 * @generated
	 */
	EAttribute getActionDecl_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ActionDecl#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionDecl#getType()
	 * @see #getActionDecl()
	 * @generated
	 */
	EAttribute getActionDecl_Type();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.struts.ActionDecl#getActionImpl <em>Action Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action Impl</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionDecl#getActionImpl()
	 * @see #getActionDecl()
	 * @generated
	 */
	EReference getActionDecl_ActionImpl();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.ActionDecl#getForwards <em>Forwards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forwards</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionDecl#getForwards()
	 * @see #getActionDecl()
	 * @generated
	 */
	EReference getActionDecl_Forwards();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ActionDecl#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see ca.uwaterloo.gsd.struts.ActionDecl#getInput()
	 * @see #getActionDecl()
	 * @generated
	 */
	EAttribute getActionDecl_Input();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.FormDecl <em>Form Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Decl</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormDecl
	 * @generated
	 */
	EClass getFormDecl();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormDecl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormDecl#getName()
	 * @see #getFormDecl()
	 * @generated
	 */
	EAttribute getFormDecl_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormDecl#getFormType <em>Form Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Form Type</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormDecl#getFormType()
	 * @see #getFormDecl()
	 * @generated
	 */
	EAttribute getFormDecl_FormType();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormDecl#isIsDynaActionForm <em>Is Dyna Action Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Dyna Action Form</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormDecl#isIsDynaActionForm()
	 * @see #getFormDecl()
	 * @generated
	 */
	EAttribute getFormDecl_IsDynaActionForm();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.uwaterloo.gsd.struts.FormDecl#getFormProperty <em>Form Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Form Property</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormDecl#getFormProperty()
	 * @see #getFormDecl()
	 * @generated
	 */
	EReference getFormDecl_FormProperty();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.ForwardDecl <em>Forward Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forward Decl</em>'.
	 * @see ca.uwaterloo.gsd.struts.ForwardDecl
	 * @generated
	 */
	EClass getForwardDecl();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ForwardDecl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.ForwardDecl#getName()
	 * @see #getForwardDecl()
	 * @generated
	 */
	EAttribute getForwardDecl_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.ForwardDecl#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see ca.uwaterloo.gsd.struts.ForwardDecl#getPath()
	 * @see #getForwardDecl()
	 * @generated
	 */
	EAttribute getForwardDecl_Path();

	/**
	 * Returns the meta object for the reference '{@link ca.uwaterloo.gsd.struts.ForwardDecl#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see ca.uwaterloo.gsd.struts.ForwardDecl#getTarget()
	 * @see #getForwardDecl()
	 * @generated
	 */
	EReference getForwardDecl_Target();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.struts.FormProperty <em>Form Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Property</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormProperty
	 * @generated
	 */
	EClass getFormProperty();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormProperty#getName()
	 * @see #getFormProperty()
	 * @generated
	 */
	EAttribute getFormProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link ca.uwaterloo.gsd.struts.FormProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see ca.uwaterloo.gsd.struts.FormProperty#getType()
	 * @see #getFormProperty()
	 * @generated
	 */
	EAttribute getFormProperty_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StrutsFactory getStrutsFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.StrutsApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsApplicationImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getStrutsApplication()
		 * @generated
		 */
		EClass STRUTS_APPLICATION = eINSTANCE.getStrutsApplication();

		/**
		 * The meta object literal for the '<em><b>Struts Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUTS_APPLICATION__STRUTS_CONFIG = eINSTANCE.getStrutsApplication_StrutsConfig();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUTS_APPLICATION__NAME = eINSTANCE.getStrutsApplication_Name();

		/**
		 * The meta object literal for the '<em><b>Forms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUTS_APPLICATION__FORMS = eINSTANCE.getStrutsApplication_Forms();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUTS_APPLICATION__ACTIONS = eINSTANCE.getStrutsApplication_Actions();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.FormImplImpl <em>Form Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.FormImplImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getFormImpl()
		 * @generated
		 */
		EClass FORM_IMPL = eINSTANCE.getFormImpl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_IMPL__NAME = eINSTANCE.getFormImpl_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_IMPL__PACKAGE = eINSTANCE.getFormImpl_Package();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_IMPL__QUALIFIED_NAME = eINSTANCE.getFormImpl_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_IMPL__LOCAL = eINSTANCE.getFormImpl_Local();

		/**
		 * The meta object literal for the '<em><b>Extends Action Form</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_IMPL__EXTENDS_ACTION_FORM = eINSTANCE.getFormImpl_ExtendsActionForm();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.ExtendsActionFormImpl <em>Extends Action Form</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.ExtendsActionFormImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getExtendsActionForm()
		 * @generated
		 */
		EClass EXTENDS_ACTION_FORM = eINSTANCE.getExtendsActionForm();

		/**
		 * The meta object literal for the '<em><b>Extends Dyna Action Form</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDS_ACTION_FORM__EXTENDS_DYNA_ACTION_FORM = eINSTANCE.getExtendsActionForm_ExtendsDynaActionForm();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.ActionImplImpl <em>Action Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.ActionImplImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getActionImpl()
		 * @generated
		 */
		EClass ACTION_IMPL = eINSTANCE.getActionImpl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_IMPL__NAME = eINSTANCE.getActionImpl_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_IMPL__PACKAGE = eINSTANCE.getActionImpl_Package();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_IMPL__QUALIFIED_NAME = eINSTANCE.getActionImpl_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_IMPL__LOCAL = eINSTANCE.getActionImpl_Local();

		/**
		 * The meta object literal for the '<em><b>Extends Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_IMPL__EXTENDS_ACTION = eINSTANCE.getActionImpl_ExtendsAction();

		/**
		 * The meta object literal for the '<em><b>Forwards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_IMPL__FORWARDS = eINSTANCE.getActionImpl_Forwards();

		/**
		 * The meta object literal for the '<em><b>Input Forwards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_IMPL__INPUT_FORWARDS = eINSTANCE.getActionImpl_InputForwards();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.ForwardImplImpl <em>Forward Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.ForwardImplImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getForwardImpl()
		 * @generated
		 */
		EClass FORWARD_IMPL = eINSTANCE.getForwardImpl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORWARD_IMPL__NAME = eINSTANCE.getForwardImpl_Name();

		/**
		 * The meta object literal for the '<em><b>Forward</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORWARD_IMPL__FORWARD = eINSTANCE.getForwardImpl_Forward();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.InputForwardImplImpl <em>Input Forward Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.InputForwardImplImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getInputForwardImpl()
		 * @generated
		 */
		EClass INPUT_FORWARD_IMPL = eINSTANCE.getInputForwardImpl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_FORWARD_IMPL__NAME = eINSTANCE.getInputForwardImpl_Name();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.ForwardImpl <em>Forward</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.ForwardImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getForward()
		 * @generated
		 */
		EClass FORWARD = eINSTANCE.getForward();

		/**
		 * The meta object literal for the '<em><b>Local Forward</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORWARD__LOCAL_FORWARD = eINSTANCE.getForward_LocalForward();

		/**
		 * The meta object literal for the '<em><b>Global Forward</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORWARD__GLOBAL_FORWARD = eINSTANCE.getForward_GlobalForward();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.ExtendsActionImpl <em>Extends Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.ExtendsActionImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getExtendsAction()
		 * @generated
		 */
		EClass EXTENDS_ACTION = eINSTANCE.getExtendsAction();

		/**
		 * The meta object literal for the '<em><b>Extends Dispatch Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION = eINSTANCE.getExtendsAction_ExtendsDispatchAction();

		/**
		 * The meta object literal for the '<em><b>Overrides Execute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDS_ACTION__OVERRIDES_EXECUTE = eINSTANCE.getExtendsAction_OverridesExecute();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.ExtendsDispatchActionImpl <em>Extends Dispatch Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.ExtendsDispatchActionImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getExtendsDispatchAction()
		 * @generated
		 */
		EClass EXTENDS_DISPATCH_ACTION = eINSTANCE.getExtendsDispatchAction();

		/**
		 * The meta object literal for the '<em><b>Action Method</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDS_DISPATCH_ACTION__ACTION_METHOD = eINSTANCE.getExtendsDispatchAction_ActionMethod();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.StrutsConfigImpl <em>Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsConfigImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getStrutsConfig()
		 * @generated
		 */
		EClass STRUTS_CONFIG = eINSTANCE.getStrutsConfig();

		/**
		 * The meta object literal for the '<em><b>Forms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUTS_CONFIG__FORMS = eINSTANCE.getStrutsConfig_Forms();

		/**
		 * The meta object literal for the '<em><b>Forwards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUTS_CONFIG__FORWARDS = eINSTANCE.getStrutsConfig_Forwards();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUTS_CONFIG__ACTIONS = eINSTANCE.getStrutsConfig_Actions();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.ActionDeclImpl <em>Action Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.ActionDeclImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getActionDecl()
		 * @generated
		 */
		EClass ACTION_DECL = eINSTANCE.getActionDecl();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_DECL__PATH = eINSTANCE.getActionDecl_Path();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_DECL__NAME = eINSTANCE.getActionDecl_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_DECL__TYPE = eINSTANCE.getActionDecl_Type();

		/**
		 * The meta object literal for the '<em><b>Action Impl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_DECL__ACTION_IMPL = eINSTANCE.getActionDecl_ActionImpl();

		/**
		 * The meta object literal for the '<em><b>Forwards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_DECL__FORWARDS = eINSTANCE.getActionDecl_Forwards();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_DECL__INPUT = eINSTANCE.getActionDecl_Input();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.FormDeclImpl <em>Form Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.FormDeclImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getFormDecl()
		 * @generated
		 */
		EClass FORM_DECL = eINSTANCE.getFormDecl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_DECL__NAME = eINSTANCE.getFormDecl_Name();

		/**
		 * The meta object literal for the '<em><b>Form Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_DECL__FORM_TYPE = eINSTANCE.getFormDecl_FormType();

		/**
		 * The meta object literal for the '<em><b>Is Dyna Action Form</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_DECL__IS_DYNA_ACTION_FORM = eINSTANCE.getFormDecl_IsDynaActionForm();

		/**
		 * The meta object literal for the '<em><b>Form Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORM_DECL__FORM_PROPERTY = eINSTANCE.getFormDecl_FormProperty();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.ForwardDeclImpl <em>Forward Decl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.ForwardDeclImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getForwardDecl()
		 * @generated
		 */
		EClass FORWARD_DECL = eINSTANCE.getForwardDecl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORWARD_DECL__NAME = eINSTANCE.getForwardDecl_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORWARD_DECL__PATH = eINSTANCE.getForwardDecl_Path();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORWARD_DECL__TARGET = eINSTANCE.getForwardDecl_Target();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.struts.impl.FormPropertyImpl <em>Form Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.struts.impl.FormPropertyImpl
		 * @see ca.uwaterloo.gsd.struts.impl.StrutsPackageImpl#getFormProperty()
		 * @generated
		 */
		EClass FORM_PROPERTY = eINSTANCE.getFormProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_PROPERTY__NAME = eINSTANCE.getFormProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_PROPERTY__TYPE = eINSTANCE.getFormProperty_Type();

	}

} //StrutsPackage
