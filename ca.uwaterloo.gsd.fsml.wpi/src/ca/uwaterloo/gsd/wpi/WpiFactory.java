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
 * $Id: WpiFactory.java,v 1.10 2008/06/26 19:28:43 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.wpi.WpiPackage
 * @generated
 */
public interface WpiFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WpiFactory eINSTANCE = ca.uwaterloo.gsd.wpi.impl.WpiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Workbench Part Interactions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workbench Part Interactions</em>'.
	 * @generated
	 */
	WorkbenchPartInteractions createWorkbenchPartInteractions();

	/**
	 * Returns a new object of class '<em>View Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View Part</em>'.
	 * @generated
	 */
	ViewPart createViewPart();

	/**
	 * Returns a new object of class '<em>Implements IView Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implements IView Part</em>'.
	 * @generated
	 */
	ImplementsIViewPart createImplementsIViewPart();

	/**
	 * Returns a new object of class '<em>Extends View Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends View Part</em>'.
	 * @generated
	 */
	ExtendsViewPart createExtendsViewPart();

	/**
	 * Returns a new object of class '<em>Editor Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Editor Part</em>'.
	 * @generated
	 */
	EditorPart createEditorPart();

	/**
	 * Returns a new object of class '<em>Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contributor</em>'.
	 * @generated
	 */
	Contributor createContributor();

	/**
	 * Returns a new object of class '<em>Extends Editor Action Bar Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Editor Action Bar Contributor</em>'.
	 * @generated
	 */
	ExtendsEditorActionBarContributor createExtendsEditorActionBarContributor();

	/**
	 * Returns a new object of class '<em>Implements IEditor Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implements IEditor Part</em>'.
	 * @generated
	 */
	ImplementsIEditorPart createImplementsIEditorPart();

	/**
	 * Returns a new object of class '<em>Extends Editor Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extends Editor Part</em>'.
	 * @generated
	 */
	ExtendsEditorPart createExtendsEditorPart();

	/**
	 * Returns a new object of class '<em>Selection Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Provider</em>'.
	 * @generated
	 */
	SelectionProvider createSelectionProvider();

	/**
	 * Returns a new object of class '<em>Registers As Selection Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registers As Selection Provider</em>'.
	 * @generated
	 */
	RegistersAsSelectionProvider createRegistersAsSelectionProvider();

	/**
	 * Returns a new object of class '<em>This Selection Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>This Selection Provider</em>'.
	 * @generated
	 */
	ThisSelectionProvider createThisSelectionProvider();

	/**
	 * Returns a new object of class '<em>Field Selection Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field Selection Provider</em>'.
	 * @generated
	 */
	FieldSelectionProvider createFieldSelectionProvider();

	/**
	 * Returns a new object of class '<em>Selection Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Listener</em>'.
	 * @generated
	 */
	SelectionListener createSelectionListener();

	/**
	 * Returns a new object of class '<em>Registers As</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registers As</em>'.
	 * @generated
	 */
	RegistersAs createRegistersAs();

	/**
	 * Returns a new object of class '<em>Global Selection Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Selection Listener</em>'.
	 * @generated
	 */
	GlobalSelectionListener createGlobalSelectionListener();

	/**
	 * Returns a new object of class '<em>Global Post Selection Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Post Selection Listener</em>'.
	 * @generated
	 */
	GlobalPostSelectionListener createGlobalPostSelectionListener();

	/**
	 * Returns a new object of class '<em>Specific Selection Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific Selection Listener</em>'.
	 * @generated
	 */
	SpecificSelectionListener createSpecificSelectionListener();

	/**
	 * Returns a new object of class '<em>Deregisters Same Part Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deregisters Same Part Id</em>'.
	 * @generated
	 */
	DeregistersSamePartId createDeregistersSamePartId();

	/**
	 * Returns a new object of class '<em>Part Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Part Listener</em>'.
	 * @generated
	 */
	PartListener createPartListener();

	/**
	 * Returns a new object of class '<em>Registers APart Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registers APart Listener</em>'.
	 * @generated
	 */
	RegistersAPartListener createRegistersAPartListener();

	/**
	 * Returns a new object of class '<em>Registers As Part Listener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registers As Part Listener</em>'.
	 * @generated
	 */
	RegistersAsPartListener createRegistersAsPartListener();

	/**
	 * Returns a new object of class '<em>Registers As Part Listener2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Registers As Part Listener2</em>'.
	 * @generated
	 */
	RegistersAsPartListener2 createRegistersAsPartListener2();

	/**
	 * Returns a new object of class '<em>Deregisters</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deregisters</em>'.
	 * @generated
	 */
	Deregisters createDeregisters();

	/**
	 * Returns a new object of class '<em>Deregisters Same Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deregisters Same Object</em>'.
	 * @generated
	 */
	DeregistersSameObject createDeregistersSameObject();

	/**
	 * Returns a new object of class '<em>Adapter Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Provider</em>'.
	 * @generated
	 */
	AdapterProvider createAdapterProvider();

	/**
	 * Returns a new object of class '<em>Provides Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Provides Adapter</em>'.
	 * @generated
	 */
	ProvidesAdapter createProvidesAdapter();

	/**
	 * Returns a new object of class '<em>Adapter Requestor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Requestor</em>'.
	 * @generated
	 */
	AdapterRequestor createAdapterRequestor();

	/**
	 * Returns a new object of class '<em>Requests Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requests Adapter</em>'.
	 * @generated
	 */
	RequestsAdapter createRequestsAdapter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WpiPackage getWpiPackage();

} //WpiFactory
