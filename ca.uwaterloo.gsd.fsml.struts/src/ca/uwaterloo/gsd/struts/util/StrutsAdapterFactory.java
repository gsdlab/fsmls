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
 * $Id: StrutsAdapterFactory.java,v 1.22 2008/07/03 05:54:49 Herman Lee <hlee@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.struts.StrutsPackage
 * @generated
 */
public class StrutsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StrutsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StrutsPackage.eINSTANCE;
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
	protected StrutsSwitch<Adapter> modelSwitch =
		new StrutsSwitch<Adapter>() {
			@Override
			public Adapter caseStrutsApplication(StrutsApplication object) {
				return createStrutsApplicationAdapter();
			}
			@Override
			public Adapter caseFormImpl(FormImpl object) {
				return createFormImplAdapter();
			}
			@Override
			public Adapter caseExtendsActionForm(ExtendsActionForm object) {
				return createExtendsActionFormAdapter();
			}
			@Override
			public Adapter caseActionImpl(ActionImpl object) {
				return createActionImplAdapter();
			}
			@Override
			public Adapter caseForwardImpl(ForwardImpl object) {
				return createForwardImplAdapter();
			}
			@Override
			public Adapter caseInputForwardImpl(InputForwardImpl object) {
				return createInputForwardImplAdapter();
			}
			@Override
			public Adapter caseForward(Forward object) {
				return createForwardAdapter();
			}
			@Override
			public Adapter caseExtendsAction(ExtendsAction object) {
				return createExtendsActionAdapter();
			}
			@Override
			public Adapter caseExtendsDispatchAction(ExtendsDispatchAction object) {
				return createExtendsDispatchActionAdapter();
			}
			@Override
			public Adapter caseStrutsConfig(StrutsConfig object) {
				return createStrutsConfigAdapter();
			}
			@Override
			public Adapter caseActionDecl(ActionDecl object) {
				return createActionDeclAdapter();
			}
			@Override
			public Adapter caseFormDecl(FormDecl object) {
				return createFormDeclAdapter();
			}
			@Override
			public Adapter caseForwardDecl(ForwardDecl object) {
				return createForwardDeclAdapter();
			}
			@Override
			public Adapter caseFormProperty(FormProperty object) {
				return createFormPropertyAdapter();
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
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.StrutsApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.StrutsApplication
	 * @generated
	 */
	public Adapter createStrutsApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.FormImpl <em>Form Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.FormImpl
	 * @generated
	 */
	public Adapter createFormImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.ExtendsActionForm <em>Extends Action Form</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.ExtendsActionForm
	 * @generated
	 */
	public Adapter createExtendsActionFormAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.ActionImpl <em>Action Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.ActionImpl
	 * @generated
	 */
	public Adapter createActionImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.ForwardImpl <em>Forward Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.ForwardImpl
	 * @generated
	 */
	public Adapter createForwardImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.InputForwardImpl <em>Input Forward Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.InputForwardImpl
	 * @generated
	 */
	public Adapter createInputForwardImplAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.Forward <em>Forward</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.Forward
	 * @generated
	 */
	public Adapter createForwardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.ExtendsAction <em>Extends Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.ExtendsAction
	 * @generated
	 */
	public Adapter createExtendsActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.ExtendsDispatchAction <em>Extends Dispatch Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.ExtendsDispatchAction
	 * @generated
	 */
	public Adapter createExtendsDispatchActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.StrutsConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.StrutsConfig
	 * @generated
	 */
	public Adapter createStrutsConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.ActionDecl <em>Action Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.ActionDecl
	 * @generated
	 */
	public Adapter createActionDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.FormDecl <em>Form Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.FormDecl
	 * @generated
	 */
	public Adapter createFormDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.ForwardDecl <em>Forward Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.ForwardDecl
	 * @generated
	 */
	public Adapter createForwardDeclAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.uwaterloo.gsd.struts.FormProperty <em>Form Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.uwaterloo.gsd.struts.FormProperty
	 * @generated
	 */
	public Adapter createFormPropertyAdapter() {
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

} //StrutsAdapterFactory
