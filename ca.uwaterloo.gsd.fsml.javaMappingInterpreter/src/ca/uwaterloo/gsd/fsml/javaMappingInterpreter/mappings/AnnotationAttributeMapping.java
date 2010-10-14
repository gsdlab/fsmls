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
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeLiteral;

import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class AnnotationAttributeMapping extends JavaMapping {

	public AnnotationAttributeMapping(EObject element,
			EStructuralFeature feature, EAnnotation annotation,
			EClass concreteChildType, JavaMappingInterpreter interpreter,
			IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter,
				progressMonitor);
		
		// Michal: the default attribute name is the name of the feature
		if (attributeName.isEmpty())
			attributeName = feature.getName();
	}

	public AnnotationAttributeMapping(SyncItem syncItem,
			EAnnotation annotation, JavaMappingInterpreter interpreter,
			IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);

		// Michal: the default attribute name is the name of the feature
		if (attributeName.isEmpty())
			attributeName = feature.getName();
	}

	@Parameter(name=JavaMappingInterpreter.DETAIL_ATTRIBUTE_NAME, mode=Mode.ALL) 
	public String attributeName; 
	
	@Context(mode=Mode.REVERSE)
	public Annotation currentAnnotation;
	@Override
	protected boolean forward() throws FSMLMappingException {
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
			Expression expressionValue = null;
			
			if (currentAnnotation.getNodeType() == ASTNode.NORMAL_ANNOTATION){
				NormalAnnotation normalJavaAnnotation = (NormalAnnotation) currentAnnotation;
				for (Object valueObject : normalJavaAnnotation.values()) {
					MemberValuePair mvp = (MemberValuePair) valueObject;
					if (mvp.getName().getFullyQualifiedName().equalsIgnoreCase(attributeName)){
						//the name of the attribute is the desired one.
						expressionValue = mvp.getValue();
						break;
					}
				}
			}
			else if (currentAnnotation.getNodeType() == ASTNode.SINGLE_MEMBER_ANNOTATION){
				SingleMemberAnnotation singleJavaAnnotation = (SingleMemberAnnotation) currentAnnotation;
				expressionValue = singleJavaAnnotation.getValue();
			}
			if (expressionValue != null){
				if (expressionValue instanceof TypeLiteral){
					return handleTypeLiteralExpression(expressionValue);
				}
				else if (expressionValue instanceof ArrayInitializer){
					ArrayInitializer ai = (ArrayInitializer) expressionValue;
					for (Object objExpression : ai.expressions()) {
						Expression currentExpression = (Expression)objExpression;
						if (currentExpression instanceof TypeLiteral){
							handleTypeLiteralExpression(currentExpression);
						}
						else{
							handleNonTypeLiteralExpression(currentExpression);
						}
					}
				}
				else{
					handleNonTypeLiteralExpression(expressionValue);
				}
				return true; 
			}
			return setFeature(false);	
	}

	private void handleNonTypeLiteralExpression(Expression expressionValue)
			throws FSMLMappingException {
		Object objectValue = expressionValue.resolveConstantExpressionValue();
		String stringValue = null;
		if (objectValue != null){
			stringValue = objectValue.toString();
		}
		else {
			// not a constant
			if (expressionValue.getNodeType() == ASTNode.QUALIFIED_NAME) {
				QualifiedName qualifiedName = (QualifiedName) expressionValue;
				stringValue = qualifiedName.getName().getIdentifier();
			}
		}
		if (stringValue != null){
			setFeatureContextAndMarker(stringValue, null, currentAnnotation, null);
		}
	}

	private boolean handleTypeLiteralExpression(Expression expressionValue)
			throws FSMLMappingException {
		TypeLiteral tl = (TypeLiteral) expressionValue;
		IJavaElement javaElement = tl.resolveTypeBinding().getJavaElement();
		String fullyQualifiedName = tl.resolveTypeBinding().getQualifiedName();
		fullyQualifiedName = fullyQualifiedName.substring(fullyQualifiedName.indexOf('<')+1, fullyQualifiedName.indexOf('>'));
		IType iType = null;
		try {
			iType = contextIJavaProject.findType(fullyQualifiedName);
			if (iType != null && iType.exists()){
				setContextAndMarker(iType, iType, null);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		if (feature instanceof EAttribute){
			return setFeatureContextAndMarker(fullyQualifiedName, iType, tl, null);	
		}
		else{
			return setFeatureContextAndMarker(true, iType, tl, null);
		}
	}
}
