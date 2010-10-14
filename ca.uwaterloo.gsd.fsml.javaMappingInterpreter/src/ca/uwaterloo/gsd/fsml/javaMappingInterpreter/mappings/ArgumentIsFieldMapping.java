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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil.NavigationResult;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class ArgumentIsFieldMapping extends ArgumentIs_Mapping {
	public ArgumentIsFieldMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public ArgumentIsFieldMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SAME_AS, mode=Mode.NONE)
	public String detailSameAs;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		String fieldName = null;
		// field name comes from either 
		// 1) an attribute annotated with QUERY_FIELD_NAME or 
		// 2) from other feature annotated with CONTEXT_FIELD pointed to by DETAIL_SAME_AS parameter
		
		EObject contextFieldElement = element;
		
		String detailSameAs = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SAME_AS, false);
		if (detailSameAs != null) {
			NavigationResult target = FSMLEcoreUtil.navigateToEObject(element, detailSameAs);
			contextFieldElement = target.eObject;
			if (target == null || target.eObject == null)
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, detailSameAs + " of " + JavaMappingInterpreter.DETAIL_SAME_AS);
		}
		
		// the field name is the value of the attribute annotated with QUERY_FIELD_NAME
		EAnnotation contextFieldAnnotation = FSMLEcoreUtil.getEAnnotation(contextFieldElement.eClass(), JavaMappingInterpreter.CONTEXT_FIELD);
		if (contextFieldAnnotation != null) {
			// find an attribute annotated with QUERY_FIELD_NAME
			EStructuralFeature fieldNameFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(contextFieldElement.eClass(), new String[] { JavaMappingInterpreter.QUERY_FIELD_NAME });
			if (fieldNameFeature == null)
				throw new FSMLMappingException(Cause.MISSING_ATTRIBUTE, JavaMappingInterpreter.QUERY_FIELD_NAME);
			
			if (fieldNameFeature instanceof EAttribute){
				fieldName = (String) contextFieldElement.eGet(fieldNameFeature);
				while(fieldName==null || fieldName.length()==0){
					fieldName = (String)FSMLEcoreUtil.getAttributeValueFromAttributeValueWizard((EAttribute)fieldNameFeature);
					if (fieldName!=null && fieldName.length()>0){
						contextFieldElement.eSet(fieldNameFeature, fieldName);
						break;
					}
				}
			}
			else
				throw new FSMLMappingException(Cause.MAPPING_REQUIRES_ATTRIBUTE, fieldNameFeature);
		}
		else
			throw new FSMLMappingException(Cause.REQUIRED_CONTEXT_MISSING, JavaMappingInterpreter.CONTEXT_FIELD);
		
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			if (contextMethodInvocation != null) {
				Expression expression = CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, fieldName, progressMonitor);
				return expression != null;
			}	
			if (contextClassInstanceCreation != null) {
				Expression expression =  CodeTransforms.replaceMethodCallArgument(null, contextClassInstanceCreation, index, fieldName, progressMonitor);
				return expression != null;
			}
			break;
		case CODE_REMOVE:
			if (contextMethodInvocation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
			if (contextClassInstanceCreation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextClassInstanceCreation, index, "null", progressMonitor) != null;
		}
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		ASTNode argument = null;
		if (contextMethodInvocation != null)
			argument = (ASTNode) contextMethodInvocation.arguments().get(index);
		if (contextClassInstanceCreation != null)
			argument = (ASTNode) contextClassInstanceCreation.arguments().get(index);
		
		if (argument instanceof SimpleName) {
			SimpleName simpleName = (SimpleName) argument;
			IBinding binding = simpleName.resolveBinding();
			if (binding instanceof IVariableBinding) {
				IVariableBinding variableBinding = (IVariableBinding) binding;
				if (variableBinding.isField()) {
					if (detailSameAs != null && !detailSameAs.isEmpty()) {
						NavigationResult navigationResult = FSMLEcoreUtil.navigateToEObject(element, detailSameAs);
						VariableDeclarationFragment targetField = contextManager.getContextVariableDeclarationFragment(navigationResult.eObject, true, progressMonitor);
						
						if (targetField == null || !targetField.resolveBinding().getKey().equals(variableBinding.getKey()))
							return setFeature(false);
						// else ok, proceed
					}
					IField field = (IField) variableBinding.getJavaElement();
					CompilationUnit cu = javaAstManager.getCompilationUnit(field);
					try {
						VariableDeclarationFragment fieldDeclarationFragment = ASTNodeSearchUtil.getFieldDeclarationFragmentNode(field, cu);
						if (feature.getEType().getName().equals("EString"))
							return setFeatureContextAndMarker(fieldDeclarationFragment.getName().getIdentifier(), fieldDeclarationFragment, argument, null);
						else
							return setFeatureContextAndMarker(true, fieldDeclarationFragment, argument, null);
					} catch (JavaModelException e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (feature.getEType().getName().equals("EString"))
			return setFeature((String) null);
		else
			return setFeature(false);	
	}

}
