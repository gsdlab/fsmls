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
 * $Id: StrutsFactoryImpl.java,v 1.14 2008/03/20 04:01:52 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StrutsFactoryImpl extends EFactoryImpl implements StrutsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StrutsFactory init() {
		try {
			StrutsFactory theStrutsFactory = (StrutsFactory)EPackage.Registry.INSTANCE.getEFactory("http://gsd.uwaterloo.ca/fsml/struts"); 
			if (theStrutsFactory != null) {
				return theStrutsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StrutsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsFactoryImpl() {
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
			case StrutsPackage.STRUTS_APPLICATION: return createStrutsApplication();
			case StrutsPackage.FORM_IMPL: return createFormImpl();
			case StrutsPackage.EXTENDS_ACTION_FORM: return createExtendsActionForm();
			case StrutsPackage.ACTION_IMPL: return createActionImpl();
			case StrutsPackage.FORWARD_IMPL: return createForwardImpl();
			case StrutsPackage.INPUT_FORWARD_IMPL: return createInputForwardImpl();
			case StrutsPackage.FORWARD: return createForward();
			case StrutsPackage.EXTENDS_ACTION: return createExtendsAction();
			case StrutsPackage.EXTENDS_DISPATCH_ACTION: return createExtendsDispatchAction();
			case StrutsPackage.STRUTS_CONFIG: return createStrutsConfig();
			case StrutsPackage.ACTION_DECL: return createActionDecl();
			case StrutsPackage.FORM_DECL: return createFormDecl();
			case StrutsPackage.FORWARD_DECL: return createForwardDecl();
			case StrutsPackage.FORM_PROPERTY: return createFormProperty();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsApplication createStrutsApplication() {
		StrutsApplicationImpl strutsApplication = new StrutsApplicationImpl();
		return strutsApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormImpl createFormImpl() {
		FormImplImpl formImpl = new FormImplImpl();
		return formImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsActionForm createExtendsActionForm() {
		ExtendsActionFormImpl extendsActionForm = new ExtendsActionFormImpl();
		return extendsActionForm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionImpl createActionImpl() {
		ActionImplImpl actionImpl = new ActionImplImpl();
		return actionImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardImpl createForwardImpl() {
		ForwardImplImpl forwardImpl = new ForwardImplImpl();
		return forwardImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputForwardImpl createInputForwardImpl() {
		InputForwardImplImpl inputForwardImpl = new InputForwardImplImpl();
		return inputForwardImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Forward createForward() {
		ca.uwaterloo.gsd.struts.impl.ForwardImpl forward = new ca.uwaterloo.gsd.struts.impl.ForwardImpl();
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsAction createExtendsAction() {
		ExtendsActionImpl extendsAction = new ExtendsActionImpl();
		return extendsAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendsDispatchAction createExtendsDispatchAction() {
		ExtendsDispatchActionImpl extendsDispatchAction = new ExtendsDispatchActionImpl();
		return extendsDispatchAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsConfig createStrutsConfig() {
		StrutsConfigImpl strutsConfig = new StrutsConfigImpl();
		return strutsConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionDecl createActionDecl() {
		ActionDeclImpl actionDecl = new ActionDeclImpl();
		return actionDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormDecl createFormDecl() {
		FormDeclImpl formDecl = new FormDeclImpl();
		return formDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForwardDecl createForwardDecl() {
		ForwardDeclImpl forwardDecl = new ForwardDeclImpl();
		return forwardDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormProperty createFormProperty() {
		FormPropertyImpl formProperty = new FormPropertyImpl();
		return formProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsPackage getStrutsPackage() {
		return (StrutsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StrutsPackage getPackage() {
		return StrutsPackage.eINSTANCE;
	}

} //StrutsFactoryImpl
