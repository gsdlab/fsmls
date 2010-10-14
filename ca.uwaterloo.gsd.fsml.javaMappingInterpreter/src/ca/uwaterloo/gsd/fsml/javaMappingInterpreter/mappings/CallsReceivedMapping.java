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

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.search.MethodReferenceMatch;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.internal.core.ResolvedSourceMethod;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeQueries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.JavaImplVariantManagerConstants;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class CallsReceivedMapping extends JavaMapping {
	/**
	 * Constructor used in reverse engineering.
	 * @param element
	 * @param feature
	 * @param annotation
	 * @param concreteChildType
	 * @param interpreter
	 * @param progressMonitor
	 * @throws FSMLMappingException
	 */
	public CallsReceivedMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	/**
	 * Constructor used in forward engineering.
	 * @param syncItem
	 * @param annotation
	 * @param interpreter
	 * @param progressMonitor
	 * @throws FSMLMappingException
	 */
	public CallsReceivedMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
		
		if (detailPosition == null || detailPosition.equals("before"))
			position = CodeTransforms.BEFORE_ADVICE;
		else if (detailPosition.equals("after"))
			position = CodeTransforms.AFTER_ADVICE;
		else {
			try {
				position = Integer.parseInt(detailPosition);
			} catch (Exception e){
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, "for detail " + JavaMappingInterpreter.DETAIL_POSITION);
			}
		}
	}
	
	@Context(mode=Mode.REVERSE, required=true)
	public IType contextIType;
	
	@Context(mode=Mode.FORWARD, excludes="contextTypeDeclaration")
	public MethodDeclaration contextMethodDeclaration;
	
	@Context(mode=Mode.FORWARD, excludes="contextMethodDeclaration")
	public TypeDeclaration contextTypeDeclaration;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_CLASS, mode=Mode.ALL, required=true)
	public String type;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_NAME, mode=Mode.FORWARD, required=true)
	public String name;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SIGNATURE, mode=Mode.FORWARD, defaultValue="()V")
	public String signature;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCATION_NAME, mode=Mode.FORWARD, required=true)
	public String detailLocationName;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCATION_SIG, mode=Mode.FORWARD, defaultValue="()V")
	public String detailLocationSig;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_POSITION, mode=Mode.FORWARD, defaultValue="after")
	public String detailPosition;
	
	int position = 0;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		IMethod targetMethod = javaInterpreter.iMethods.get(FSMLEcoreUtil.computeAnnotationKey(annotation));
		String[] parameterTypes = targetMethod.getParameterTypes();
		
		// construct a call
		String contents = name + CodeTransforms.constructDefaultCallParameters(parameterTypes) + ";";
		
		List<ASTNode> result = null;
		
		// method calls can be create in the context method or a context class
		
		if (contextMethodDeclaration != null) {
			result =  CodeTransforms.weaveAdvice(position, null, contextMethodDeclaration, contents, progressMonitor);
		}
		else {
			// no context method, try context class
			if (contextTypeDeclaration != null) {
				MethodDeclaration methodDeclaration = ASTUtils.findMethod(javaAstManager, detailLocationName, detailLocationSig, contextTypeDeclaration, true, false, progressMonitor);
				if (methodDeclaration == null)
					// create the method
					methodDeclaration = CodeTransforms.createMethod(contextIJavaProject, null, contextTypeDeclaration, "public", detailLocationName, detailLocationSig, null, progressMonitor);
				result =  CodeTransforms.weaveAdvice(position, null, methodDeclaration, contents, progressMonitor);
			}
		}
		// need to set up the call as a context and put the markers
		if (result != null && !result.isEmpty()) {
			// should be a single method call. However, in the future, different variants may
			// require some preparation statements, e.g., variable declarations, and the call will
			// the the last one
			ASTNode astNode = result.get(result.size()-1);
			if (astNode instanceof ExpressionStatement)
				astNode = ((ExpressionStatement) astNode).getExpression();
			if (astNode instanceof MethodInvocation) {
				EObject element = FSMLEcoreUtil.retrieveContextElement(syncItem, JavaMappingInterpreter.CONTEXT_METHOD_CALL);
				contextManager.associateContext(element, astNode);
			}
		}
		
		return result != null;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {		
		String key = FSMLEcoreUtil.computeAnnotationKey(annotation);
		IMethod targetMethod = javaInterpreter.iMethods.get(key);
		
		try {
			// check cache first
			Collection<SearchMatch> methodCalls = javaInterpreter.callsCache.get(targetMethod);
			if (methodCalls == null) {
				methodCalls = JavaModelUtils.getMethodCallsInProject(contextIJavaProject, targetMethod, progressMonitor);
				javaInterpreter.callsCache.put(targetMethod, methodCalls);
			}
					
			for (SearchMatch match : methodCalls) {
				// remove calls which are not received by the contextType
				CompilationUnit matchCompilationUnit = javaAstManager.getCompilationUnit(((IJavaElement) match.getElement()).getPrimaryElement());		
				if (matchCompilationUnit == null)
					continue;
				ASTNode matchAstNode = ASTNodeSearchUtil.findNode(match, matchCompilationUnit); 
				
				if (matchAstNode == null) {
					Stats.INSTANCE.logError("CallsReceivedMapping::reverse(): " + element.eClass().getName() + "::" + feature.getName()+ " ASTNode for match not found: " + match + "\n");
					continue;
				}
				if (matchAstNode.getNodeType() != ASTNode.METHOD_INVOCATION && 
					matchAstNode.getNodeType() != ASTNode.CLASS_INSTANCE_CREATION) {
					Stats.INSTANCE.logMessage("CallsReceivedMapping::reverse(): matchASTNode which is either method invocation nor class instance creation found: " + matchAstNode.getClass() + "\n");
					continue;
				}
				
				// check if expression is assignable to the required receiver
				IType actualReceiverType = null;
				String requiredReceiverName = contextIType.getFullyQualifiedName();
				if (requiredReceiverName != null) {
					Expression receiverExpression = null;
					if (matchAstNode instanceof MethodInvocation)
						receiverExpression = ((MethodInvocation) matchAstNode).getExpression();
					else if (matchAstNode instanceof ClassInstanceCreation)
						receiverExpression = ((ClassInstanceCreation) matchAstNode).getExpression();
					
					if (receiverExpression == null) {
						// the receiver is 'this'
						// locate the containing method declaration
						actualReceiverType = CodeQueries.findITypeContainingASTNode(contextIJavaProject, matchAstNode);
						if (typeHierarchy.implementsOrExtendsType(actualReceiverType, requiredReceiverName)) {
							// break iteration if a correct value has been set
							
							if (javaInterpreter.analyzeImplVariants()) {
								String declaringMethod = ((ResolvedSourceMethod)((MethodReferenceMatch)match).getElement()).getKey();
								Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,declaringMethod );
								EClass targetClass = javaImplVariantManager.getVariantEClass(JavaImplVariantManagerConstants.VARIANT+
										JavaImplVariantManagerConstants.DELIMITER+
										annotation.getSource() + JavaImplVariantManagerConstants.DELIMITER
										+ JavaImplVariantManagerConstants.IN_METHOD);
								EObject child = EcoreUtil.create(targetClass);
								
								((EList) javaImplVariantManager.getModel().eGet(javaImplVariantManager.getVariantsReference())).add(child);
								child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ECLASS), element.eClass().getName());
								child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ESTRUCTURALFEATURE), feature.getName());
								child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.METHOD_NAME), declaringMethod);
								//createMarkerDescriptor((ResolvedSourceMethod)((MethodReferenceMatch)match).getElement(), JavaImplVariantManager.computeVariantKey(child), "marker for implModel");
								createMarkerDescriptor((ResolvedSourceMethod)((MethodReferenceMatch)match).getElement(), child, "marker for implModel");
							}
							if (setFeatureContextAndMarker(true, matchAstNode, matchAstNode, null) && !feature.isMany())
								break;
						}
					} else {
						ITypeBinding typeBinding = receiverExpression.resolveTypeBinding();
						actualReceiverType = (IType) typeBinding.getJavaElement();
						if (typeHierarchy.implementsOrExtendsType(actualReceiverType, requiredReceiverName)) { 
							// correct receiver
							// break iteration if a correct value has been set
							if (setFeatureContextAndMarker(true, matchAstNode, matchAstNode, null) && !feature.isMany())
								break;
						}
						else {
							if (! typeHierarchy.implementsOrExtendsType(contextIType, actualReceiverType.getFullyQualifiedName()))
								continue;
							// need to check dataflow
							if (receiverExpression.getNodeType() == ASTNode.SIMPLE_NAME) {
								SimpleName simpleName = (SimpleName) receiverExpression;
								IVariableBinding iVariableBinding = (IVariableBinding) simpleName.resolveBinding();
								if (iVariableBinding.isParameter()) {
									IVariableBinding iVariableDeclarationBinding = iVariableBinding.getVariableDeclaration();
									CompilationUnit compilationUnit = (CompilationUnit) receiverExpression.getRoot();
									SingleVariableDeclaration variableDeclaration = (SingleVariableDeclaration) compilationUnit.findDeclaringNode(iVariableDeclarationBinding);
									MethodDeclaration methodDeclaration = (MethodDeclaration) variableDeclaration.getParent();
									IMethodBinding iMethodBinding = methodDeclaration.resolveBinding();
									
									int index = methodDeclaration.parameters().indexOf(variableDeclaration);
									
									for (ASTNode methodInvocationName : ASTUtils.findMathodInvocations(compilationUnit, methodDeclaration, iMethodBinding)) {
										ASTNode methodInvocationNode = methodInvocationName.getParent();
										if (methodInvocationNode instanceof Type)
											methodInvocationNode = methodInvocationNode.getParent();
										if (methodInvocationNode.getNodeType() == ASTNode.METHOD_DECLARATION)
											continue;
										Expression argument = null;
										switch (methodInvocationNode.getNodeType()) {
										case ASTNode.METHOD_INVOCATION:
											argument = (Expression) ((MethodInvocation) methodInvocationNode).arguments().get(index);
											break;
										case ASTNode.CLASS_INSTANCE_CREATION:
											argument = (Expression) ((ClassInstanceCreation) methodInvocationNode).arguments().get(index);
											break;
										}
										if (argument == null)
											continue;
										
										typeBinding = argument.resolveTypeBinding();
										actualReceiverType = (IType) typeBinding.getJavaElement();
										if (typeHierarchy.implementsOrExtendsType(actualReceiverType, requiredReceiverName)) {  
											// break iteration if a correct value has been set
											if (setFeatureContextAndMarker(true, matchAstNode, matchAstNode, null))
												break;
										}
										continue;
									}
								}
								else if (iVariableBinding.isField()) {
									continue;
								}
							}
						}
					}
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return FSMLEcoreUtil.isFeaturePresent(element, feature);
	}
}
