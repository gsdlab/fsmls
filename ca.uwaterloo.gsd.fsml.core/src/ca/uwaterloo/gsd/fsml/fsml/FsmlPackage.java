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
package ca.uwaterloo.gsd.fsml.fsml;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see ca.uwaterloo.gsd.fsml.fsml.FsmlFactory
 * @model kind="package"
 * @generated
 */
public interface FsmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fsml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ca.uwaterloo.gsd/fsml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fsml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmlPackage eINSTANCE = ca.uwaterloo.gsd.fsml.fsml.impl.FsmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.fsml.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.fsml.impl.ModelImpl
	 * @see ca.uwaterloo.gsd.fsml.fsml.impl.FsmlPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl <em>Concept</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl
	 * @see ca.uwaterloo.gsd.fsml.fsml.impl.FsmlPackageImpl#getConcept()
	 * @generated
	 */
	int CONCEPT = 1;

	/**
	 * The number of structural features of the '<em>Concept</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link ca.uwaterloo.gsd.fsml.fsml.impl.ModelContainerImpl <em>Model Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.uwaterloo.gsd.fsml.fsml.impl.ModelContainerImpl
	 * @see ca.uwaterloo.gsd.fsml.fsml.impl.FsmlPackageImpl#getModelContainer()
	 * @generated
	 */
	int MODEL_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Asserted Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__ASSERTED_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Last Reconciled Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER__LAST_RECONCILED_MODEL = 1;

	/**
	 * The number of structural features of the '<em>Model Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CONTAINER_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.fsml.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see ca.uwaterloo.gsd.fsml.fsml.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.fsml.Concept <em>Concept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept</em>'.
	 * @see ca.uwaterloo.gsd.fsml.fsml.Concept
	 * @generated
	 */
	EClass getConcept();

	/**
	 * Returns the meta object for class '{@link ca.uwaterloo.gsd.fsml.fsml.ModelContainer <em>Model Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Container</em>'.
	 * @see ca.uwaterloo.gsd.fsml.fsml.ModelContainer
	 * @generated
	 */
	EClass getModelContainer();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.fsml.fsml.ModelContainer#getAssertedModel <em>Asserted Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Asserted Model</em>'.
	 * @see ca.uwaterloo.gsd.fsml.fsml.ModelContainer#getAssertedModel()
	 * @see #getModelContainer()
	 * @generated
	 */
	EReference getModelContainer_AssertedModel();

	/**
	 * Returns the meta object for the containment reference '{@link ca.uwaterloo.gsd.fsml.fsml.ModelContainer#getLastReconciledModel <em>Last Reconciled Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last Reconciled Model</em>'.
	 * @see ca.uwaterloo.gsd.fsml.fsml.ModelContainer#getLastReconciledModel()
	 * @see #getModelContainer()
	 * @generated
	 */
	EReference getModelContainer_LastReconciledModel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FsmlFactory getFsmlFactory();

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
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.fsml.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.fsml.impl.ModelImpl
		 * @see ca.uwaterloo.gsd.fsml.fsml.impl.FsmlPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl <em>Concept</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl
		 * @see ca.uwaterloo.gsd.fsml.fsml.impl.FsmlPackageImpl#getConcept()
		 * @generated
		 */
		EClass CONCEPT = eINSTANCE.getConcept();

		/**
		 * The meta object literal for the '{@link ca.uwaterloo.gsd.fsml.fsml.impl.ModelContainerImpl <em>Model Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.uwaterloo.gsd.fsml.fsml.impl.ModelContainerImpl
		 * @see ca.uwaterloo.gsd.fsml.fsml.impl.FsmlPackageImpl#getModelContainer()
		 * @generated
		 */
		EClass MODEL_CONTAINER = eINSTANCE.getModelContainer();

		/**
		 * The meta object literal for the '<em><b>Asserted Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONTAINER__ASSERTED_MODEL = eINSTANCE.getModelContainer_AssertedModel();

		/**
		 * The meta object literal for the '<em><b>Last Reconciled Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CONTAINER__LAST_RECONCILED_MODEL = eINSTANCE.getModelContainer_LastReconciledModel();

}

} //FsmlPackage
