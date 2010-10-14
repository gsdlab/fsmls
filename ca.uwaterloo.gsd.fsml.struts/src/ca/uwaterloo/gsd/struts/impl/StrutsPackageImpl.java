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
 * $Id: StrutsPackageImpl.java,v 1.22 2009/04/21 16:47:57 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import ca.uwaterloo.gsd.fsml.fsml.FsmlPackage;
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
import ca.uwaterloo.gsd.struts.StrutsFactory;
import ca.uwaterloo.gsd.struts.StrutsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StrutsPackageImpl extends EPackageImpl implements StrutsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strutsApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsActionFormEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forwardImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputForwardImplEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forwardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendsDispatchActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strutsConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forwardDeclEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formPropertyEClass = null;

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
	 * @see ca.uwaterloo.gsd.struts.StrutsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StrutsPackageImpl() {
		super(eNS_URI, StrutsFactory.eINSTANCE);
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
	public static StrutsPackage init() {
		if (isInited) return (StrutsPackage)EPackage.Registry.INSTANCE.getEPackage(StrutsPackage.eNS_URI);

		// Obtain or create and register package
		StrutsPackageImpl theStrutsPackage = (StrutsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof StrutsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new StrutsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		FsmlPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStrutsPackage.createPackageContents();

		// Initialize created meta-data
		theStrutsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStrutsPackage.freeze();

		return theStrutsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrutsApplication() {
		return strutsApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrutsApplication_StrutsConfig() {
		return (EReference)strutsApplicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStrutsApplication_Name() {
		return (EAttribute)strutsApplicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrutsApplication_Forms() {
		return (EReference)strutsApplicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrutsApplication_Actions() {
		return (EReference)strutsApplicationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormImpl() {
		return formImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormImpl_Name() {
		return (EAttribute)formImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormImpl_Package() {
		return (EAttribute)formImplEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormImpl_QualifiedName() {
		return (EAttribute)formImplEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormImpl_Local() {
		return (EAttribute)formImplEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormImpl_ExtendsActionForm() {
		return (EReference)formImplEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsActionForm() {
		return extendsActionFormEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsActionForm_ExtendsDynaActionForm() {
		return (EAttribute)extendsActionFormEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionImpl() {
		return actionImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionImpl_Name() {
		return (EAttribute)actionImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionImpl_Package() {
		return (EAttribute)actionImplEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionImpl_QualifiedName() {
		return (EAttribute)actionImplEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionImpl_Local() {
		return (EAttribute)actionImplEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionImpl_ExtendsAction() {
		return (EReference)actionImplEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionImpl_Forwards() {
		return (EReference)actionImplEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionImpl_InputForwards() {
		return (EReference)actionImplEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForwardImpl() {
		return forwardImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForwardImpl_Name() {
		return (EAttribute)forwardImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForwardImpl_Forward() {
		return (EReference)forwardImplEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputForwardImpl() {
		return inputForwardImplEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputForwardImpl_Name() {
		return (EAttribute)inputForwardImplEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForward() {
		return forwardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForward_LocalForward() {
		return (EReference)forwardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForward_GlobalForward() {
		return (EReference)forwardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsAction() {
		return extendsActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendsAction_ExtendsDispatchAction() {
		return (EReference)extendsActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsAction_OverridesExecute() {
		return (EAttribute)extendsActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendsDispatchAction() {
		return extendsDispatchActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendsDispatchAction_ActionMethod() {
		return (EAttribute)extendsDispatchActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrutsConfig() {
		return strutsConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrutsConfig_Forms() {
		return (EReference)strutsConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrutsConfig_Forwards() {
		return (EReference)strutsConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrutsConfig_Actions() {
		return (EReference)strutsConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionDecl() {
		return actionDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionDecl_Path() {
		return (EAttribute)actionDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionDecl_Name() {
		return (EAttribute)actionDeclEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionDecl_Type() {
		return (EAttribute)actionDeclEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionDecl_ActionImpl() {
		return (EReference)actionDeclEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionDecl_Forwards() {
		return (EReference)actionDeclEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionDecl_Input() {
		return (EAttribute)actionDeclEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormDecl() {
		return formDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormDecl_Name() {
		return (EAttribute)formDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormDecl_FormType() {
		return (EAttribute)formDeclEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormDecl_IsDynaActionForm() {
		return (EAttribute)formDeclEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormDecl_FormProperty() {
		return (EReference)formDeclEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForwardDecl() {
		return forwardDeclEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForwardDecl_Name() {
		return (EAttribute)forwardDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForwardDecl_Path() {
		return (EAttribute)forwardDeclEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForwardDecl_Target() {
		return (EReference)forwardDeclEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormProperty() {
		return formPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormProperty_Name() {
		return (EAttribute)formPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormProperty_Type() {
		return (EAttribute)formPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsFactory getStrutsFactory() {
		return (StrutsFactory)getEFactoryInstance();
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
		strutsApplicationEClass = createEClass(STRUTS_APPLICATION);
		createEAttribute(strutsApplicationEClass, STRUTS_APPLICATION__NAME);
		createEReference(strutsApplicationEClass, STRUTS_APPLICATION__STRUTS_CONFIG);
		createEReference(strutsApplicationEClass, STRUTS_APPLICATION__FORMS);
		createEReference(strutsApplicationEClass, STRUTS_APPLICATION__ACTIONS);

		formImplEClass = createEClass(FORM_IMPL);
		createEAttribute(formImplEClass, FORM_IMPL__NAME);
		createEAttribute(formImplEClass, FORM_IMPL__PACKAGE);
		createEAttribute(formImplEClass, FORM_IMPL__QUALIFIED_NAME);
		createEAttribute(formImplEClass, FORM_IMPL__LOCAL);
		createEReference(formImplEClass, FORM_IMPL__EXTENDS_ACTION_FORM);

		extendsActionFormEClass = createEClass(EXTENDS_ACTION_FORM);
		createEAttribute(extendsActionFormEClass, EXTENDS_ACTION_FORM__EXTENDS_DYNA_ACTION_FORM);

		actionImplEClass = createEClass(ACTION_IMPL);
		createEAttribute(actionImplEClass, ACTION_IMPL__NAME);
		createEAttribute(actionImplEClass, ACTION_IMPL__PACKAGE);
		createEAttribute(actionImplEClass, ACTION_IMPL__QUALIFIED_NAME);
		createEAttribute(actionImplEClass, ACTION_IMPL__LOCAL);
		createEReference(actionImplEClass, ACTION_IMPL__EXTENDS_ACTION);
		createEReference(actionImplEClass, ACTION_IMPL__FORWARDS);
		createEReference(actionImplEClass, ACTION_IMPL__INPUT_FORWARDS);

		forwardImplEClass = createEClass(FORWARD_IMPL);
		createEAttribute(forwardImplEClass, FORWARD_IMPL__NAME);
		createEReference(forwardImplEClass, FORWARD_IMPL__FORWARD);

		inputForwardImplEClass = createEClass(INPUT_FORWARD_IMPL);
		createEAttribute(inputForwardImplEClass, INPUT_FORWARD_IMPL__NAME);

		forwardEClass = createEClass(FORWARD);
		createEReference(forwardEClass, FORWARD__LOCAL_FORWARD);
		createEReference(forwardEClass, FORWARD__GLOBAL_FORWARD);

		extendsActionEClass = createEClass(EXTENDS_ACTION);
		createEReference(extendsActionEClass, EXTENDS_ACTION__EXTENDS_DISPATCH_ACTION);
		createEAttribute(extendsActionEClass, EXTENDS_ACTION__OVERRIDES_EXECUTE);

		extendsDispatchActionEClass = createEClass(EXTENDS_DISPATCH_ACTION);
		createEAttribute(extendsDispatchActionEClass, EXTENDS_DISPATCH_ACTION__ACTION_METHOD);

		strutsConfigEClass = createEClass(STRUTS_CONFIG);
		createEReference(strutsConfigEClass, STRUTS_CONFIG__FORMS);
		createEReference(strutsConfigEClass, STRUTS_CONFIG__FORWARDS);
		createEReference(strutsConfigEClass, STRUTS_CONFIG__ACTIONS);

		actionDeclEClass = createEClass(ACTION_DECL);
		createEAttribute(actionDeclEClass, ACTION_DECL__PATH);
		createEAttribute(actionDeclEClass, ACTION_DECL__NAME);
		createEAttribute(actionDeclEClass, ACTION_DECL__TYPE);
		createEReference(actionDeclEClass, ACTION_DECL__ACTION_IMPL);
		createEReference(actionDeclEClass, ACTION_DECL__FORWARDS);
		createEAttribute(actionDeclEClass, ACTION_DECL__INPUT);

		formDeclEClass = createEClass(FORM_DECL);
		createEAttribute(formDeclEClass, FORM_DECL__NAME);
		createEAttribute(formDeclEClass, FORM_DECL__FORM_TYPE);
		createEAttribute(formDeclEClass, FORM_DECL__IS_DYNA_ACTION_FORM);
		createEReference(formDeclEClass, FORM_DECL__FORM_PROPERTY);

		forwardDeclEClass = createEClass(FORWARD_DECL);
		createEAttribute(forwardDeclEClass, FORWARD_DECL__NAME);
		createEAttribute(forwardDeclEClass, FORWARD_DECL__PATH);
		createEReference(forwardDeclEClass, FORWARD_DECL__TARGET);

		formPropertyEClass = createEClass(FORM_PROPERTY);
		createEAttribute(formPropertyEClass, FORM_PROPERTY__NAME);
		createEAttribute(formPropertyEClass, FORM_PROPERTY__TYPE);
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
		strutsApplicationEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		strutsApplicationEClass.getESuperTypes().add(theFsmlPackage.getModel());
		formImplEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		extendsActionFormEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		actionImplEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		forwardImplEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		inputForwardImplEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		forwardEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		extendsActionEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		extendsDispatchActionEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		strutsConfigEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		actionDeclEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		formDeclEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		forwardDeclEClass.getESuperTypes().add(theFsmlPackage.getConcept());
		formPropertyEClass.getESuperTypes().add(theFsmlPackage.getConcept());

		// Initialize classes and features; add operations and parameters
		initEClass(strutsApplicationEClass, StrutsApplication.class, "StrutsApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStrutsApplication_Name(), ecorePackage.getEString(), "name", null, 1, 1, StrutsApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrutsApplication_StrutsConfig(), this.getStrutsConfig(), null, "strutsConfig", null, 1, 1, StrutsApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrutsApplication_Forms(), this.getFormImpl(), null, "forms", null, 0, -1, StrutsApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrutsApplication_Actions(), this.getActionImpl(), null, "actions", null, 0, -1, StrutsApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formImplEClass, FormImpl.class, "FormImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormImpl_Name(), ecorePackage.getEString(), "name", null, 1, 1, FormImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormImpl_Package(), ecorePackage.getEString(), "package", null, 0, 1, FormImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormImpl_QualifiedName(), ecorePackage.getEString(), "qualifiedName", "", 1, 1, FormImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormImpl_Local(), ecorePackage.getEBoolean(), "local", null, 0, 1, FormImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormImpl_ExtendsActionForm(), this.getExtendsActionForm(), null, "extendsActionForm", null, 1, 1, FormImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsActionFormEClass, ExtendsActionForm.class, "ExtendsActionForm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsActionForm_ExtendsDynaActionForm(), ecorePackage.getEBoolean(), "extendsDynaActionForm", null, 0, 1, ExtendsActionForm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionImplEClass, ActionImpl.class, "ActionImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionImpl_Name(), ecorePackage.getEString(), "name", null, 1, 1, ActionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionImpl_Package(), ecorePackage.getEString(), "package", null, 0, 1, ActionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionImpl_QualifiedName(), ecorePackage.getEString(), "qualifiedName", "", 1, 1, ActionImpl.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionImpl_Local(), ecorePackage.getEBoolean(), "local", null, 0, 1, ActionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionImpl_ExtendsAction(), this.getExtendsAction(), null, "extendsAction", null, 1, 1, ActionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionImpl_Forwards(), this.getForwardImpl(), null, "forwards", null, 0, -1, ActionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionImpl_InputForwards(), this.getInputForwardImpl(), null, "inputForwards", null, 0, -1, ActionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forwardImplEClass, ForwardImpl.class, "ForwardImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForwardImpl_Name(), ecorePackage.getEString(), "name", null, 1, 1, ForwardImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForwardImpl_Forward(), this.getForward(), null, "forward", null, 1, 1, ForwardImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputForwardImplEClass, InputForwardImpl.class, "InputForwardImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputForwardImpl_Name(), ecorePackage.getEString(), "name", null, 1, 1, InputForwardImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forwardEClass, Forward.class, "Forward", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForward_LocalForward(), this.getForwardDecl(), null, "localForward", null, 0, 1, Forward.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForward_GlobalForward(), this.getForwardDecl(), null, "globalForward", null, 0, 1, Forward.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsActionEClass, ExtendsAction.class, "ExtendsAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendsAction_ExtendsDispatchAction(), this.getExtendsDispatchAction(), null, "extendsDispatchAction", null, 0, 1, ExtendsAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendsAction_OverridesExecute(), ecorePackage.getEBoolean(), "overridesExecute", null, 0, 1, ExtendsAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendsDispatchActionEClass, ExtendsDispatchAction.class, "ExtendsDispatchAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendsDispatchAction_ActionMethod(), ecorePackage.getEString(), "actionMethod", null, 0, -1, ExtendsDispatchAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(strutsConfigEClass, StrutsConfig.class, "StrutsConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStrutsConfig_Forms(), this.getFormDecl(), null, "forms", null, 0, -1, StrutsConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrutsConfig_Forwards(), this.getForwardDecl(), null, "forwards", null, 0, -1, StrutsConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrutsConfig_Actions(), this.getActionDecl(), null, "actions", null, 0, -1, StrutsConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionDeclEClass, ActionDecl.class, "ActionDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionDecl_Path(), ecorePackage.getEString(), "path", null, 1, 1, ActionDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionDecl_Name(), ecorePackage.getEString(), "name", null, 0, 1, ActionDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionDecl_Type(), ecorePackage.getEString(), "type", null, 0, 1, ActionDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionDecl_ActionImpl(), this.getActionImpl(), null, "actionImpl", null, 1, 1, ActionDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionDecl_Forwards(), this.getForwardDecl(), null, "forwards", null, 0, -1, ActionDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActionDecl_Input(), ecorePackage.getEString(), "input", null, 0, 1, ActionDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formDeclEClass, FormDecl.class, "FormDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormDecl_Name(), ecorePackage.getEString(), "name", null, 1, 1, FormDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormDecl_FormType(), ecorePackage.getEString(), "formType", null, 1, 1, FormDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormDecl_IsDynaActionForm(), ecorePackage.getEBoolean(), "isDynaActionForm", null, 0, 1, FormDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormDecl_FormProperty(), this.getFormProperty(), null, "formProperty", null, 0, -1, FormDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forwardDeclEClass, ForwardDecl.class, "ForwardDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForwardDecl_Name(), ecorePackage.getEString(), "name", null, 1, 1, ForwardDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForwardDecl_Path(), ecorePackage.getEString(), "path", null, 1, 1, ForwardDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForwardDecl_Target(), this.getActionDecl(), null, "target", null, 1, 1, ForwardDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formPropertyEClass, FormProperty.class, "FormProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormProperty_Type(), ecorePackage.getEString(), "type", null, 0, 1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// project
		createProjectAnnotations();
		// essential
		createEssentialAnnotations();
		// projectName
		createProjectNameAnnotations();
		// key
		createKeyAnnotations();
		// class
		createClassAnnotations();
		// className
		createClassNameAnnotations();
		// qualifier
		createQualifierAnnotations();
		// isLocal
		createIsLocalAnnotations();
		// extendsClass
		createExtendsClassAnnotations();
		// parentKey
		createParentKeyAnnotations();
		// methodCalls
		createMethodCallsAnnotations();
		// methodCall
		createMethodCallAnnotations();
		// indexKey
		createIndexKeyAnnotations();
		// argumentValue
		createArgumentValueAnnotations();
		// valueOf
		createValueOfAnnotations();
		// where
		createWhereAnnotations();
		// featureGroup
		createFeatureGroupAnnotations();
		// constraints
		createConstraintsAnnotations();
		// and
		createAndAnnotations();
		// andParentIs
		createAndParentIsAnnotations();
		// methods
		createMethodsAnnotations();
		// xmlDocument
		createXmlDocumentAnnotations();
		// xmlElement
		createXmlElementAnnotations();
		// xmlElements
		createXmlElementsAnnotations();
		// xmlAttribute
		createXmlAttributeAnnotations();
		// fullyQualifiedName
		createFullyQualifiedNameAnnotations();
		// valueEqualsTo
		createValueEqualsToAnnotations();
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
		  (strutsApplicationEClass, 
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
		  (getStrutsApplication_Name(), 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (getFormImpl_Name(), 
		   source, 
		   new String[] {
		   });							
		addAnnotation
		  (getFormImpl_ExtendsActionForm(), 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (getActionImpl_Name(), 
		   source, 
		   new String[] {
		   });							
		addAnnotation
		  (getActionImpl_ExtendsAction(), 
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
		  (getStrutsApplication_Name(), 
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
		  (formImplEClass, 
		   source, 
		   new String[] {
		   });												
		addAnnotation
		  (actionImplEClass, 
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
		  (getFormImpl_Name(), 
		   source, 
		   new String[] {
		   });												
		addAnnotation
		  (getActionImpl_Name(), 
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
		  (getStrutsApplication_Name(), 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (getFormImpl_Name(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getFormImpl_Package(), 
		   source, 
		   new String[] {
		   });										
		addAnnotation
		  (getActionImpl_Name(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getActionImpl_Package(), 
		   source, 
		   new String[] {
		   });											
		addAnnotation
		  (getForwardImpl_Name(), 
		   source, 
		   new String[] {
		   });																	
		addAnnotation
		  (getExtendsDispatchAction_ActionMethod(), 
		   source, 
		   new String[] {
		   });										
		addAnnotation
		  (getActionDecl_Path(), 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (getActionDecl_Type(), 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (getFormDecl_Name(), 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (getForwardDecl_Name(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getForwardDecl_Path(), 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (getFormProperty_Name(), 
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
		  (getFormImpl_Package(), 
		   source, 
		   new String[] {
		   });												
		addAnnotation
		  (getActionImpl_Package(), 
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
		  (getFormImpl_Local(), 
		   source, 
		   new String[] {
		   });												
		addAnnotation
		  (getActionImpl_Local(), 
		   source, 
		   new String[] {
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
		  (getFormImpl_ExtendsActionForm(), 
		   source, 
		   new String[] {
			 "name", "org.apache.struts.action.ActionForm"
		   });			
		addAnnotation
		  (getExtendsActionForm_ExtendsDynaActionForm(), 
		   source, 
		   new String[] {
			 "name", "org.apache.struts.action.DynaActionForm"
		   });										
		addAnnotation
		  (getActionImpl_ExtendsAction(), 
		   source, 
		   new String[] {
			 "name", "org.apache.struts.action.Action"
		   });																					
		addAnnotation
		  (getExtendsAction_ExtendsDispatchAction(), 
		   source, 
		   new String[] {
			 "name", "org.apache.struts.actions.DispatchAction"
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
		  (extendsActionFormEClass, 
		   source, 
		   new String[] {
		   });															
		addAnnotation
		  (forwardImplEClass, 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (inputForwardImplEClass, 
		   source, 
		   new String[] {
		   });											
		addAnnotation
		  (extendsActionEClass, 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (extendsDispatchActionEClass, 
		   source, 
		   new String[] {
		   });																											
		addAnnotation
		  (forwardDeclEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (formPropertyEClass, 
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
		  (getActionImpl_Forwards(), 
		   source, 
		   new String[] {
			 "class", "org.apache.struts.action.ActionMapping",
			 "name", "findForward",
			 "signature", "(Ljava.lang.String;)Lorg.apache.struts.ActionForward;",
			 "in", "class",
			 "locationName", "execute",
			 "locationSig", "(Lorg.apache.struts.action.ActionMapping;Lorg.apache.struts.action.ActionForm;Ljavax.servlet.http.HttpServletRequest;Ljavax.servlet.http.HttpServletResponse;)Lorg.apache.struts.action.ActionForward;|Ljava.lang.Exception;",
			 "position", "after"
		   });		
		addAnnotation
		  (getActionImpl_InputForwards(), 
		   source, 
		   new String[] {
			 "class", "org.apache.struts.action.ActionMapping",
			 "name", "getInputForward",
			 "signature", "()Lorg.apache.struts.ActionForward;",
			 "in", "class"
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
		  (forwardImplEClass, 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (inputForwardImplEClass, 
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
		  (forwardImplEClass, 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (inputForwardImplEClass, 
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
		  (getForwardImpl_Name(), 
		   source, 
		   new String[] {
			 "index", "1"
		   });																																																				
	}

	/**
	 * Initializes the annotations for <b>valueOf</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createValueOfAnnotations() {
		String source = "valueOf";																																				
		addAnnotation
		  (getInputForwardImpl_Name(), 
		   source, 
		   new String[] {
			 "attribute", "input",
			 "class", "ActionDecl"
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
		  (forwardEClass, 
		   source, 
		   new String[] {
			 "lowerBound", "1",
			 "upperBound", "2"
		   });																																													
	}

	/**
	 * Initializes the annotations for <b>constraints</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createConstraintsAnnotations() {
		String source = "constraints";																																							
		addAnnotation
		  (forwardEClass, 
		   source, 
		   new String[] {
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
		  (getInputForwardImpl_Name(), 
		   source, 
		   new String[] {
			 "attribute", "type",
			 "equalsTo", "../../qualifiedName"
		   });				
		addAnnotation
		  (getForward_LocalForward(), 
		   source, 
		   new String[] {
			 "attribute", "name",
			 "equalsTo", "../../name"
		   });			
		addAnnotation
		  (getForward_GlobalForward(), 
		   source, 
		   new String[] {
			 "attribute", "name",
			 "equalsTo", "../../name"
		   });																					
		addAnnotation
		  (getActionDecl_ActionImpl(), 
		   source, 
		   new String[] {
			 "attribute", "qualifiedName",
			 "equalsTo", "../type"
		   });																	
		addAnnotation
		  (getForwardDecl_Target(), 
		   source, 
		   new String[] {
			 "attribute", "path",
			 "equalsTo", "../path"
		   });					
	}

	/**
	 * Initializes the annotations for <b>and</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createAndAnnotations() {
		String source = "and";																																									
		addAnnotation
		  (getForward_LocalForward(), 
		   source, 
		   new String[] {
			 "attribute", "../../type",
			 "equalsTo", "../../../qualifiedName"
		   });																																										
	}

	/**
	 * Initializes the annotations for <b>andParentIs</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createAndParentIsAnnotations() {
		String source = "andParentIs";																																											
		addAnnotation
		  (getForward_GlobalForward(), 
		   source, 
		   new String[] {
			 "instanceOf", "StrutsConfig"
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
		  (getExtendsAction_OverridesExecute(), 
		   source, 
		   new String[] {
			 "name", "execute",
			 "signature", "(Lorg.apache.struts.action.ActionMapping;Lorg.apache.struts.action.ActionForm;Ljavax.servlet.http.HttpServletRequest;Ljavax.servlet.http.HttpServletResponse;)Lorg.apache.struts.action.ActionForward;",
			 "inherited", "false"
		   });				
		addAnnotation
		  (getExtendsDispatchAction_ActionMethod(), 
		   source, 
		   new String[] {
			 "signature", "(Lorg.apache.struts.action.ActionMapping;Lorg.apache.struts.action.ActionForm;Ljavax.servlet.http.HttpServletRequest;Ljavax.servlet.http.HttpServletResponse;)Lorg.apache.struts.action.ActionForward;",
			 "inherited", "false"
		   });																																		
	}

	/**
	 * Initializes the annotations for <b>xmlDocument</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXmlDocumentAnnotations() {
		String source = "xmlDocument";																																																		
		addAnnotation
		  (strutsConfigEClass, 
		   source, 
		   new String[] {
			 "path", "/WEB-INF/struts-config.xml"
		   });																																	
	}

	/**
	 * Initializes the annotations for <b>xmlElements</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXmlElementsAnnotations() {
		String source = "xmlElements";																																																				
		addAnnotation
		  (getStrutsConfig_Forms(), 
		   source, 
		   new String[] {
			 "path", "form-beans/form-bean"
		   });		
		addAnnotation
		  (getStrutsConfig_Forwards(), 
		   source, 
		   new String[] {
			 "path", "global-forwards/forward"
		   });		
		addAnnotation
		  (getStrutsConfig_Actions(), 
		   source, 
		   new String[] {
			 "path", "action-mappings/action"
		   });										
		addAnnotation
		  (getActionDecl_Forwards(), 
		   source, 
		   new String[] {
			 "path", "forward"
		   });									
		addAnnotation
		  (getFormDecl_FormProperty(), 
		   source, 
		   new String[] {
			 "path", "form-property"
		   });												
	}

	/**
	 * Initializes the annotations for <b>xmlAttribute</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXmlAttributeAnnotations() {
		String source = "xmlAttribute";																																																								
		addAnnotation
		  (getActionDecl_Path(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getActionDecl_Name(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getActionDecl_Type(), 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (getActionDecl_Input(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getFormDecl_Name(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getFormDecl_FormType(), 
		   source, 
		   new String[] {
			 "name", "type"
		   });							
		addAnnotation
		  (getForwardDecl_Name(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getForwardDecl_Path(), 
		   source, 
		   new String[] {
		   });						
		addAnnotation
		  (getFormProperty_Name(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getFormProperty_Type(), 
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
		  (getActionDecl_Type(), 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (getFormDecl_FormType(), 
		   source, 
		   new String[] {
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
		  (getFormDecl_IsDynaActionForm(), 
		   source, 
		   new String[] {
			 "attribute", "../formType",
			 "value", "org.apache.struts.action.DynaActionForm"
		   });													
	}

	/**
	 * Initializes the annotations for <b>xmlElement</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXmlElementAnnotations() {
		String source = "xmlElement";																																																			
		addAnnotation
		  (strutsConfigEClass, 
		   source, 
		   new String[] {
			 "name", "struts-config"
		   });					
		addAnnotation
		  (actionDeclEClass, 
		   source, 
		   new String[] {
		   });											
		addAnnotation
		  (formDeclEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (forwardDeclEClass, 
		   source, 
		   new String[] {
		   });								
		addAnnotation
		  (formPropertyEClass, 
		   source, 
		   new String[] {
		   });				
	}

} //StrutsPackageImpl
