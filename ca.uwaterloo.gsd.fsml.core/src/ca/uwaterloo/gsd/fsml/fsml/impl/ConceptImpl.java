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
package ca.uwaterloo.gsd.fsml.fsml.impl;

import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;

import ca.uwaterloo.gsd.fsml.fsml.Concept;
import ca.uwaterloo.gsd.fsml.fsml.FsmlPackage;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.util.FsmlValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concept</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ConceptImpl extends EObjectImpl implements Concept {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConceptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmlPackage.Literals.CONCEPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Michal: make sure that every mandatory feature is not null or true
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean inv_mandatoryFeatures(DiagnosticChain diagnostics, Map context) {
		// validate only the Asserted Model, ignore the Last Reconciled Model
		EObject aux = this;
		while (!(aux instanceof Model) && aux != null) {
			aux = aux.eContainer();
		}
		if (aux instanceof Model) {
			if (aux.eContainer() instanceof Model)
				return true;
		}
		StringBuffer msg = new StringBuffer();
		boolean valid = true;
		for (ListIterator i = this.eClass().getEAllStructuralFeatures().listIterator(); i.hasNext(); ) {
			EStructuralFeature feature = (EStructuralFeature) i.next();
			if (feature.getLowerBound() == 1 && feature.getUpperBound() == 1) {
				Object value = eGet(feature);
				if (feature.getEType().getName().equals("EBoolean")) {
					if (!((Boolean) value).booleanValue()) {
						msg.append("The mandatory feature '");
						msg.append(EObjectValidator.getFeatureLabel(feature, context) + "' of '" + EObjectValidator.getObjectLabel(this, context));
						msg.append("' must be true\n");
						valid = false;
					}
				}
				/* 
				 * this check is already taken care of by standard validator
				 * 
				 else if (value == null) {
					msg.append("The mandatory feature '");
					msg.append(EObjectValidator.getFeatureLabel(feature, context) + "' of '" + EObjectValidator.getObjectLabel(this, context));
					msg.append("' must be set");
					valid = false;
				}*/
			}
		}
		
		if (!valid) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 FsmlValidator.DIAGNOSTIC_SOURCE,
						 FsmlValidator.CONCEPT__INV_MANDATORY_FEATURES,
						 // EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "inv_mandatoryFeatures", EObjectValidator.getObjectLabel(this, context) }),
						 msg.toString(),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * Retrieve 'featureGroup<min, max>' metamodel annotation and check the constraint
	 * @generated NOT
	 */
	public boolean inv_featureGroupConstraint(DiagnosticChain diagnostics, Map context) {
		boolean featureGroupOk = true;
		
		EAnnotation featureGroupAnnotation = eClass().getEAnnotation("featureGroup");
		if (featureGroupAnnotation != null) {
			int min = Integer.parseInt((String) featureGroupAnnotation.getDetails().get("lowerBound"));
			int max = Integer.parseInt((String) featureGroupAnnotation.getDetails().get("upperBound"));
			
			// count existing subfeatures
			int subfeatures = 0;
			for (Object aux : eClass().getEAllStructuralFeatures()) {
				EStructuralFeature feature = (EStructuralFeature) aux;
				Object value = eGet(feature);
				if (feature.isMany()) 
					subfeatures += ((EList) value).size();
				else {
					if (feature.getEType().getName().equals("EBoolean")) {
						subfeatures += (((Boolean)value).booleanValue() ? 1 : 0 );
					}
					else
						subfeatures += (value != null ? 1 : 0);
				}
			}
			featureGroupOk = min <= subfeatures && subfeatures <= max;
		}
		if (!featureGroupOk) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 FsmlValidator.DIAGNOSTIC_SOURCE,
						 FsmlValidator.CONCEPT__INV_FEATURE_GROUP_CONSTRAINT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "inv_featureGroupConstraint", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
		}
		return featureGroupOk;
	}

} //ConceptImpl
