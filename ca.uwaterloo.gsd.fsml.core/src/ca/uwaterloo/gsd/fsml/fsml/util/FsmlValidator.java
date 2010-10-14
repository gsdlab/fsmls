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
package ca.uwaterloo.gsd.fsml.fsml.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import ca.uwaterloo.gsd.fsml.fsml.Concept;
import ca.uwaterloo.gsd.fsml.fsml.FsmlPackage;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.fsml.FsmlPackage
 * @generated
 */
public class FsmlValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FsmlValidator INSTANCE = new FsmlValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ca.uwaterloo.gsd.fsml.fsml";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inv mandatory Features' of 'Concept'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONCEPT__INV_MANDATORY_FEATURES = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Inv feature Group Constraint' of 'Concept'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CONCEPT__INV_FEATURE_GROUP_CONSTRAINT = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmlValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return FsmlPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case FsmlPackage.MODEL:
				return validateModel((Model)value, diagnostics, context);
			case FsmlPackage.CONCEPT:
				return validateConcept((Concept)value, diagnostics, context);
			case FsmlPackage.MODEL_CONTAINER:
				return validateModelContainer((ModelContainer)value, diagnostics, context);
			default: 
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModel(Model model, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(model, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConcept(Concept concept, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validateConcept_inv_mandatoryFeatures(concept, diagnostics, context);
		if (result || diagnostics != null) result &= validateConcept_inv_featureGroupConstraint(concept, diagnostics, context);
		return result;
	}

	/**
	 * Validates the inv_mandatoryFeatures constraint of '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConcept_inv_mandatoryFeatures(Concept concept, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return concept.inv_mandatoryFeatures(diagnostics, context);
	}

	/**
	 * Validates the inv_featureGroupConstraint constraint of '<em>Concept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConcept_inv_featureGroupConstraint(Concept concept, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return concept.inv_featureGroupConstraint(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelContainer(ModelContainer modelContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelContainer, diagnostics, context);
	}

} //FsmlValidator
