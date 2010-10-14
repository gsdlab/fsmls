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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeQueries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.RA;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class TypesOfReturnedObjectsMapping extends JavaMapping {

	public TypesOfReturnedObjectsMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		
		if (!feature.getEType().getName().equals("EString"))
			throw new FSMLMappingException(Cause.MAPPING_REQUIRES_ATTRIBUTE, "of type EString");
	}

	public TypesOfReturnedObjectsMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
		
		try {
			keyParameterIndex = Integer.parseInt(detailKeyParameterIndex);
		} catch (NumberFormatException e) {
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, JavaMappingInterpreter.DETAIL_IFKEY + " cannot be parsed as integer.");
		}
		if (keyParameterIndex > contextMethodDeclaration.parameters().size())
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, JavaMappingInterpreter.DETAIL_IFKEY + " should be smaller than the number of parameters");
		
		// 1-based in the metamodel, 0-based in AST
		keyParameterIndex--;
	}

	@Context(mode=Mode.ALL, required=true)
	public MethodDeclaration contextMethodDeclaration;
	
	@Context(mode=Mode.REVERSE, required=true)
	public IType contextIType;
	
	@Parameter(name = JavaMappingInterpreter.DETAIL_IFKEY, mode = Mode.FORWARD, required = true)
	public String detailKeyParameterIndex;
	
	protected int keyParameterIndex;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		boolean result = false;
		ArrayList<String> types = new ArrayList<String>();
		
		Object value = element.eGet(feature);
		if (feature.isMany())
			types.addAll((EList<String>) value);
		else 
			types.add((String) value);
		
		RA action = syncItem.getReconciliationAction();
		switch (action) {
		case CODE_ADD:
			// retrieve the name of the ith argument that is to be used in the if statement
			SingleVariableDeclaration keyParameterDeclaration = (SingleVariableDeclaration) contextMethodDeclaration.parameters().get(keyParameterIndex);
			String keyParameterName = keyParameterDeclaration.getName().getIdentifier();
			// add return statements for each type
			for (String type : types) {
				String ifExpression = "if (" + Signature.getSimpleName(type) + ".class.equals(" + keyParameterName + "))";
				String returnExpression = "return new " + Signature.getSimpleName(type) + "()";
				try {
					// construct the new instance creation statement
					IType instanceType = contextIJavaProject.findType(type);
					//Michal: what if the type cannot be found? Should we add a plug-in dependency?
					if (instanceType == null)
						return false;
					if (instanceType.isInterface() || (instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()))) {
						// create anonymous subclass for interfaces and abstract classes
						returnExpression += " {\n\t  }";
					}
					returnExpression += ";";
					
					CodeTransforms.weaveAdvice(CodeTransforms.BEFORE_ADVICE, null, contextMethodDeclaration, ifExpression + "\n\t" + returnExpression, progressMonitor);
					CodeTransforms.organizeImports(contextMethodDeclaration, type);
				}
				catch (JavaModelException e) {
					e.printStackTrace();
				}
			}
			result = true;
			break;
		case CODE_REMOVE:
			// remove return statements for each type
			break;
		case CODE_CHANGE:
			// TODO:
		}
		return result;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		if (contextMethodDeclaration == null) {
			Stats.INSTANCE.logError("TypesOfReturnedObjects::reverse(): missing required contextMethodDeclaration");
			return false;
		}
		if (contextIType == null) {
			Stats.INSTANCE.logError("TypesOfReturnedObjects::reverse(): missing required contextIType");
			return false;
		}
		if (feature.getEType().getName().equals("EString")) {
			// make sure feature is not there in case there is a default
			element.eUnset(feature);
			boolean includeNonTypesReturnStatements = true;
			
			callGraphManager.addCompilationUnit(JavaModelUtils.getTypeRoot(contextIType));
			
			ArrayList<Expression> expressions;
			try {
				/*if (contextIType.getElementName().equals("XSDEditor"))
					Stats.INSTANCE.printMessage("XSDEditor encountered");*/
				expressions = CodeQueries.getExpressionWithMostSpecificTypeForMethodDeclaration(contextMethodDeclaration, contextIType, new ArrayList<MethodDeclaration>(), analysisManagers, progressMonitor);
			} catch (StackOverflowError e) {
				Stats.INSTANCE.printMessage("TypesOfReturnedObjectsMapping::reverse(): stack overflow error during most-specific type inference for method: " + contextMethodDeclaration.resolveBinding().getKey());
				return false;
			}

			String typeOfThis = contextIType.getFullyQualifiedName();

			for (Expression expression : expressions) {
				if (expression == null)
					continue;
				if (includeNonTypesReturnStatements) {
					if (expression instanceof SuperMethodInvocation) {
						Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation, "super");
						continue;
					} else if (expression instanceof NullLiteral) {
						Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation, "null");
						continue;
					} else {
						ITypeBinding iTypeBinding = expression.resolveTypeBinding(); 
						if (iTypeBinding == null || ((IType)(iTypeBinding.getJavaElement())).getFullyQualifiedName().equals("java.lang.Object"))
							continue;
						if (iTypeBinding.isTypeVariable() || iTypeBinding.isWildcardType())
							continue;
						
					}
				}
				
				String name;
				if (expression.getNodeType() == ASTNode.CLASS_INSTANCE_CREATION) {
					Type cicType = ((ClassInstanceCreation) expression).getType();
					
					ITypeBinding typeBinding = cicType.resolveBinding();
					if (typeBinding == null)
						continue;
					name = typeBinding.getQualifiedName();
					
					if (name == null || name.isEmpty())
						name = typeBinding.getBinaryName();
				}
				else if (expression.getNodeType() == ASTNode.THIS_EXPRESSION) {
					// the literal can reside outside of the hierarchy in which case simply use it's binding.
					TypeDeclaration typeDeclarationOfThis = ASTUtils.getDeclaringType(expression);
					String thisTypeName = typeDeclarationOfThis.resolveBinding().getQualifiedName();
					if (thisTypeName == null || thisTypeName.isEmpty())
						thisTypeName = typeDeclarationOfThis.resolveBinding().getBinaryName();
					
					if (typeOfThis.equals(thisTypeName))
						name = typeOfThis;
					else {
						try {
							if (typeHierarchy.implementsOrExtendsType(contextIType, thisTypeName))
								name = typeOfThis;
							else {
								name = ((ThisExpression) expression).resolveTypeBinding().getQualifiedName();
								if (name == null || name.isEmpty())
									name = ((ThisExpression) expression).resolveTypeBinding().getBinaryName();
							}
						} catch (JavaModelException e) {
							e.printStackTrace();
							name = typeOfThis;
						}
					}
				}
				else {
					ITypeBinding typeBinding = expression.resolveTypeBinding();
					if (typeBinding == null)
						continue;
					
					name = typeBinding.getQualifiedName();
				}
				
				setFeatureContextAndMarker(name, null, expression, feature.isMany() ? name : null, Signature.getSimpleName(name));
				
				if (JavaMappingInterpreter.analyzeImplVariants()) {
					//analyze implementation variants
					
					while (expression instanceof ParenthesizedExpression) {
						expression = ((ParenthesizedExpression)expression).getExpression();
					}
					if (expression instanceof ConditionalExpression) {
						Expression elseExpression =((ConditionalExpression)expression).getElseExpression();
						Expression thenExpression =((ConditionalExpression)expression).getThenExpression();
						if (!(elseExpression instanceof InfixExpression) && !(elseExpression instanceof NullLiteral)) {
							expression=((ConditionalExpression)expression).getElseExpression();
						} else if(!(thenExpression instanceof InfixExpression) && !(thenExpression instanceof NullLiteral)) {
							expression = ((ConditionalExpression)expression).getThenExpression(); 
						} else {
							Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"failed to analyze ParenthesizedExpression or ConditionalExpression");
							continue;
						}
					}
					
					if (expression instanceof MethodInvocation) {
						Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"method of return type "+((MethodInvocation)expression).resolveMethodBinding().getReturnType().getName());
					} else if (expression instanceof ThisExpression) {
						Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"this");
					} else if (expression instanceof SimpleName) {
						Stats.INSTANCE.logImplVariant(element.eClass(),feature,annotation,"variable");
					} else if (expression instanceof ClassInstanceCreation) {
						if (((ClassInstanceCreation)expression).getAnonymousClassDeclaration()!=null) {
							Stats.INSTANCE.logImplVariant(element.eClass(),feature,annotation, "anon");
						} else {
							Stats.INSTANCE.logImplVariant(element.eClass(),feature,annotation,"new");
						}
					} else {
						Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,expression.getClass().getSimpleName());
					}
				}
			}
			return expressions.size() > 0;
		}
		return setFeature(false);
	}
}
