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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeQueries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class ArgumentValueMapping extends ArgumentIs_Mapping {

	private StructuralFeatureSyncItem structuralFeatureSyncItem;

	public ArgumentValueMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}

	public ArgumentValueMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
		if (syncItem instanceof StructuralFeatureSyncItem)
			structuralFeatureSyncItem = (StructuralFeatureSyncItem) syncItem;
		else
			throw new FSMLMappingException(Cause.INCORRECT_TYPE, "StructuralFeatureSyncItem required.");
	}

	@Context(mode=Mode.REVERSE, required = true)
	public IType contextIType;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		Expression call =  contextMethodInvocation != null ? contextMethodInvocation : contextClassInstanceCreation;
		
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD: 
		case CODE_CHANGE:
			String type = retrieveTypeOfArgumentFromSignature(syncItem, index);
			
			// remove semi-colon at the end of string if it exists
			if (type.charAt(type.length()-1) == ';') {
				type = type.substring(0, type.length()-1);
			}
			
			EAttribute attribute = (EAttribute) structuralFeatureSyncItem.getStructuralFeature();
			
			// support for multiple values
			int numValues = 0;			
			String[] literalValues = null;
			String[] attributeValues = null;
			if (attribute.isMany()) {
				EList valuesList = (EList) element.eGet(attribute);
				numValues = valuesList.size();
				literalValues = new String[numValues];
				attributeValues = new String[numValues];
				for (int i = 0; i < numValues; ++i) {
					attributeValues[i] = valuesList.get(i).toString();
				}
			}
			else {
				Object singleValue = element.eGet(attribute);
				while (singleValue==null){
					singleValue = FSMLEcoreUtil.getAttributeValueFromAttributeValueWizard(attribute);
					if (singleValue!=null){
						element.eSet(attribute, singleValue);
						break;
					}
				}
				if (singleValue != null) {
					numValues = 1;
					literalValues = new String[numValues];
					attributeValues = new String[numValues];
					attributeValues[0] = singleValue.toString();
				} 
			}		
			String value = "";
			
			for (int i = 0; i < numValues; ++i) {
				if (type.equals("Ljava.lang.String")) {
					literalValues[i] = '"' + attributeValues[i] + '"';
				} else if (type.equals("Ljava.lang.Class")) {
					String fullyQualifiedClassName = attributeValues[i];
					literalValues[i] = Signature.getSimpleName(fullyQualifiedClassName) + ".class";					
					if (CodeTransforms.recordModifications((CompilationUnit)call.getRoot())) {						
						CodeTransforms.organizeImports(call.getRoot(), fullyQualifiedClassName);	
					}
				} else if (type.equals(Signature.SIG_VOID)) {
					literalValues[i] = "";
				} else if (type.equals(Signature.SIG_CHAR)) {
					literalValues[i] = "'" + attributeValues[i] + "'";
				} else if (type.equals(Signature.SIG_DOUBLE)) {
					literalValues[i] = attributeValues[i] + "d";
				} else if (type.equals(Signature.SIG_FLOAT)) {
					literalValues[i] = attributeValues[i] + "f";
				} else if (type.equals(Signature.SIG_LONG)) {
					literalValues[i] = attributeValues[i] + "L";
				} else if (type.equals(Signature.SIG_BOOLEAN) || 
						type.equals(Signature.SIG_BYTE) ||
						type.equals(Signature.SIG_INT) ||					
						type.equals(Signature.SIG_SHORT)) {				
					literalValues[i] = attributeValues[i];
				} else {
					// user defined class types
					literalValues[i] = attributeValues[i];
				}
			}			

			if (numValues > 1) {
				// variable name is simply the name of the feature
				String variableName = attribute.getName();
								
				// cannot use boolean, since "visit" method can only access final variables 
				final ArrayList<SimpleName> foundVariables = new ArrayList<SimpleName>();
				int newID = 0;
				// find the closest parent which is a Statement
				ASTNode aux = call;
				while (!(aux instanceof Statement) && aux != null) {
					aux = aux.getParent();
				}
				while (true) {
					foundVariables.clear();
					final String potentialUniqueVar = variableName + newID;
					call.getRoot().accept(new ASTVisitor() {
						public boolean visit(SimpleName simpleName) {
							// don't need to keep looking if we already found a duplicate
							if (!foundVariables.isEmpty()) return false;
							if (simpleName.getIdentifier().equals(potentialUniqueVar)) {				           
								foundVariables.add(simpleName);
							}
							return true;
						}
					}
					);
					if (foundVariables.isEmpty()) {
						// this variable identifier is unique
						variableName = potentialUniqueVar;
						break;
					} else {
						++newID;
					}
				}
				
				// insert above the actual method call					
				CodeTransforms.declareVariable(contextIJavaProject, null, call, variableName, type, literalValues[0], null, false, progressMonitor);
				if (numValues > 1)
					for (int i = 1; i < numValues; ++i) {
						CodeTransforms.assignVariableValue(null, call, variableName, literalValues[i], progressMonitor);
					}				
				
				// use the variable as the method call argument
				value = variableName;				 
			}
			else {
				// handle the case where the parameter is *NOT* multi-value
				value = "";
				if (numValues > 0) {
					value = literalValues[0];
				}
			}
			
			return CodeTransforms.replaceMethodCallArgument(null, call, index, value, progressMonitor) != null;
		case CODE_REMOVE:
			return CodeTransforms.replaceMethodCallArgument(null, call, index, "null", progressMonitor) != null;
		}
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		if (feature.getEType().getName().equals("EString")) {
			Expression argument = null;
			if (contextMethodInvocation != null)
				argument = (Expression) contextMethodInvocation.arguments().get(index);
			else if (contextClassInstanceCreation != null)
				argument = (Expression) contextClassInstanceCreation.arguments().get(index);
			
			ArrayList<Expression> valueExpressions = new ArrayList<Expression>();
			
			try {
				CodeQueries.getStaticExpressionsForExpression(argument, contextIType, valueExpressions, analysisManagers, progressMonitor);
			}
			catch (StackOverflowError e) {
				Stats.INSTANCE.logError("ArgumentValueMapping::reverse(): Stack overflow for '" + contextIType.getFullyQualifiedName() + "' and argument '" + argument.toString() + "'");
			}
			// remove null literals
			for (Iterator<Expression> i = valueExpressions.iterator(); i.hasNext(); ) {
				if (i.next().getNodeType() == ASTNode.NULL_LITERAL) 
					i.remove();
			}
			if (valueExpressions != null || !valueExpressions.isEmpty()) {
				if (valueExpressions.size() == 1) {
					Expression expression = valueExpressions.get(0);
					String expressionValue = ASTUtils.getStringValue(expression);
					
					// check equalTo constraint
					EAnnotation equalToAnnotation = feature.getEAnnotation("valueEqualsTo"); 
					if (equalToAnnotation != null) {
						String featurePath = (String) FSMLEcoreUtil.retrieveParameterValue(equalToAnnotation, JavaMappingInterpreter.QUERY_ATTRIBUTE, true);
						
						// navigate to the String feature that holds the value this feature is expected to be equal to
						FSMLEcoreUtil.NavigationResult target = FSMLEcoreUtil.navigateToEObject(element, featurePath);
						
						// TODO: 'valueEqualsTo' constraint: handle all types
						String targetValue = (String) target.eObject.eGet(target.eAttribute);
						
						if (!expressionValue.equals(targetValue))
							return setFeature(false);
					}
					return setFeatureContextAndMarker(expressionValue, null, expression, expressionValue, expressionValue);
					
				}
				
				if (feature.isMany()) {
					for (Expression expression : valueExpressions) {
						String expressionValue = ASTUtils.getStringValue(expression);
						setFeatureContextAndMarker(expressionValue, null, expression, expressionValue, expressionValue);
					}
				}
				else {
					String value = "";
					for (Iterator<Expression> i = valueExpressions.iterator(); i.hasNext(); ) {
						Expression expression = i.next();
						String expressionValue = ASTUtils.getStringValue(expression);
						value += expressionValue + (i.hasNext() ? "', '" : "");
					}
					for (Expression expression : valueExpressions) {
						setFeatureContextAndMarker(value, null, expression, null, ASTUtils.getStringValue(expression));
					}
					
					Stats.INSTANCE.logMessage("ArgumentValueMapping:reverse(): [0..1] a feature with multiple values. " + FSMLEcoreUtil.getFSMLId(element, feature, value));
				}
				return FSMLEcoreUtil.isFeaturePresent(element, feature);
			}
			Stats.INSTANCE.logImplVariant(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","Unable to retrieve value");
		}
		return setFeature(false);
	}
}
