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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.search.SearchMatch;
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
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.VarCollector;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.VarDesc;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.Scope;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.JavaImplVariantManagerConstants;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class MethodCallsMapping extends JavaMapping {
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
	public MethodCallsMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		if ("true".equals(statement))
			statementOnly = true;
	}
	/**
	 * Constructor used in forward engineering.
	 * @param syncItem
	 * @param annotation
	 * @param interpreter
	 * @param progressMonitor
	 * @throws FSMLMappingException
	 */
	public MethodCallsMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
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
		
		if ("true".equals(statement))
			statementOnly = true;
	}
	
	@Context(mode=Mode.REVERSE)
	public IMethod contextIMethod;
	
	@Context(mode=Mode.REVERSE)
	public IType contextIType;
	
	@Context(mode=Mode.FORWARD)
	public MethodDeclaration contextMethodDeclaration;
	
	@Context(mode=Mode.FORWARD)
	public TypeDeclaration contextTypeDeclaration;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_CLASS, mode=Mode.ALL, required=true)
	public String type;
	
	/**
	 * Name can be empty for constructors
	 */
	@Parameter(name=JavaMappingInterpreter.DETAIL_NAME, mode=Mode.ALL, required=false, defaultValue="")
	public String name;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SIGNATURE, mode=Mode.ALL, defaultValue="()V")
	public String signature;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_IN, mode=Mode.REVERSE)
	public String scope;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_RECEIVER, mode=Mode.ALL)
	public String receiver;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_STATEMENT, mode=Mode.ALL)
	public String statement;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCATION_NAME, mode=Mode.FORWARD, required=true)
	public String detailLocationName;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCATION_SIG, mode=Mode.FORWARD, defaultValue="()V")
	public String detailLocationSig;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_POSITION, mode=Mode.FORWARD, defaultValue="after")
	public String detailPosition;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_RECEIVER_EXPR, mode=Mode.FORWARD)
	public String receiverExpr;
	
	protected int position = 0;
	protected boolean statementOnly = false;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		String key = FSMLEcoreUtil.computeAnnotationKey(annotation);
		IMethod targetMethod = javaInterpreter.iMethods.get(key);
		
		String[] parameterTypes = targetMethod.getParameterTypes();

		// construct a call
		String contents = "";
		boolean isConstructor = false;
		try {
			isConstructor = targetMethod.isConstructor(); 
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		if (isConstructor) {
			contents = "new " + Signature.getSimpleName(type) + CodeTransforms.constructDefaultCallParameters(parameterTypes) + ";";
		} else {
			contents = receiverExpr + ("".equals(receiverExpr) ? "" :  ".") + name + CodeTransforms.constructDefaultCallParameters(parameterTypes) + ";";
		}
		
		List<ASTNode> result = null;
		
		// method calls can be create in the context method or a context class
		if (contextMethodDeclaration != null) {
			result =  CodeTransforms.weaveAdvice(position, null, contextMethodDeclaration, contents, progressMonitor);
		}
		// no context method, try context class
		if (contextTypeDeclaration != null) { 
			MethodDeclaration methodDeclaration = null;
			
			methodDeclaration = ASTUtils.findMethod(javaAstManager, detailLocationName, detailLocationSig, contextTypeDeclaration, true, false, progressMonitor);
			if (methodDeclaration == null)
				// create the method
				methodDeclaration = CodeTransforms.createMethod(contextIJavaProject, null, contextTypeDeclaration, "public", detailLocationName, detailLocationSig, null, progressMonitor);
			if (receiverExpr.isEmpty()){
				VarCollector collector = new VarCollector();
				CompilationUnit cu = (CompilationUnit)methodDeclaration.getRoot();
				collector.collect(cu, cu.toString(), methodDeclaration.getStartPosition());
				List<VarDesc> declarations = collector.getDeclarations();
				try {
					
					for (VarDesc varDesc : declarations) {
						IType currentVarType=null;
						if (varDesc.type.isSimpleType()){
							SimpleType simpleType = (SimpleType)varDesc.type;
							if (simpleType.resolveBinding()!=null){
								currentVarType= contextIJavaProject.findType(simpleType.resolveBinding().getQualifiedName());
							}
						} else {
							currentVarType = contextIJavaProject.findType(varDesc.type.toString());
						}
						if (currentVarType!=null){
							ITypeHierarchy newSupertypeHierarchy = currentVarType.newSupertypeHierarchy(new NullProgressMonitor());
							if (!varDesc.name.equals("this") && newSupertypeHierarchy.contains(contextIJavaProject.findType(type))){
								contents =varDesc.name+"."+contents;
							}
						}else {
							continue;
						}
						
						
					} 
				}
				catch (JavaModelException e) {
					e.printStackTrace();
				}
			
			}
			result =  CodeTransforms.weaveAdvice(position, null, methodDeclaration, contents, progressMonitor);
		}

		// need to set up the call as a context and put the markers
		if (result != null && !result.isEmpty()) {
			// should be a single method call. However, in the future, different variants may
			// require some preparation statements, e.g., variable declarations, and the call will
			// the the last one
			ASTNode astNode = result.get(result.size()-1);
			if (astNode instanceof ExpressionStatement) 
				astNode = ((ExpressionStatement) astNode).getExpression();
			
			// ClassInstanceCreation:
			//    the case where this "method call" is an instantiation of a class
			// e.g. 
			// int x = 0;
			// new Thread();
			if (astNode instanceof MethodInvocation || astNode instanceof ClassInstanceCreation) {
				EObject element = FSMLEcoreUtil.retrieveContextElement(syncItem, JavaMappingInterpreter.CONTEXT_METHOD_CALL);
				contextManager.associateContext(element, astNode);
			}
		}
		
		return result != null;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		String key = FSMLEcoreUtil.computeAnnotationKey(annotation);
		IMethod targetIMethod = javaInterpreter.iMethods.get(key);
		
		IMember context = contextIMethod != null ? contextIMethod : contextIType;
		
		if (context == null) {
			Stats.INSTANCE.logBug("MethodCallsMapping::reverse(): BUG: context is null!");
			return FSMLEcoreUtil.isFeaturePresent(element, feature);
		}
		CompilationUnit contextCompilationUnit = javaAstManager.getCompilationUnit(context);
		if (contextCompilationUnit == null)
			return FSMLEcoreUtil.isFeaturePresent(element, feature);
		
		
		
		if (javaInterpreter.callGraphScope) {
			progressMonitor.beginTask("Checking method calls to " + targetIMethod.getElementName() + " in context " + context.getElementName(), 1);
			// make sure the compilation unit is added to the analysis
			progressMonitor.subTask("Adding type " + context.getElementName() + " to the call graph");
			callGraphManager.addCompilationUnit(JavaModelUtils.getTypeRoot(context));
			
			// get the calls reachable from the call graph
			List<Expression> methodCalls = callGraphManager.getCalls(targetIMethod, null);
			
			for (Expression call : methodCalls) {
				if (statementOnly && call.getParent().getNodeType() != ASTNode.EXPRESSION_STATEMENT)
					continue;
					
				if (!receiver.isEmpty()) {
					Expression receiverExpression = null;
					switch (call.getNodeType()) {
					case ASTNode.METHOD_INVOCATION:
						receiverExpression = ((MethodInvocation) call).getExpression();
						break;
					case ASTNode.CLASS_INSTANCE_CREATION:
						receiverExpression = ((ClassInstanceCreation) call).getExpression();
						break;
					}
					if (receiverExpression != null) {
						ITypeBinding receiverExpressionTypeBinding = receiverExpression.resolveTypeBinding();
						try {
							if (!typeHierarchy.implementsOrExtendsType(receiverExpressionTypeBinding, receiver))
								continue;
						} catch (JavaModelException e) {
							e.printStackTrace();
						}
					}
					MethodDeclaration methodDeclaration = (MethodDeclaration) ASTUtils.getAncestorOfType(call, ASTNode.METHOD_DECLARATION);
					IMethodBinding iMethodBinding = methodDeclaration.resolveBinding();
					if (iMethodBinding == null) {
						TypeDeclaration typeDeclaration = (TypeDeclaration) ASTUtils.getAncestorOfType(methodDeclaration, ASTNode.TYPE_DECLARATION);
						Stats.INSTANCE.logError("MethodCallsMapping::reverse(): Cannot resolve binding for method: " + typeDeclaration.getName() + "." + methodDeclaration.getName() + ". Ignoring - a potential false negative.");
						continue;
					}
						
					IMethod iMethod = (IMethod) iMethodBinding.getJavaElement();
					// if the method call is in a method declaration, check if it can be accessed from the context
					if (iMethod != null && iMethod.exists()) {
						progressMonitor.subTask(JavaModelUtils.formatMethod(iMethod).toString());
						if (! callGraphManager.calls(context, iMethod)) {
							//Stats.INSTANCE.log("MethodCallsMapping::reverse(): Method call to " + targetMethod.getElementName()+ "() found in " + enclosingMemberName + "() is unreachable from context: " + context.getElementName());
							continue;
						}
						if (setFeatureContextAndMarker(true, call, call, null) && !feature.isMany()) {
							break;
						}
					}
				}
			}
			progressMonitor.worked(1);
		}
		else {
			// the context can be a type or a method
			
			try {
				IType targetType = contextIJavaProject.findType(type);
	
				// default is SOURCE_HIERARCHY for types and NO_HIERARCHY for methods
				Scope scope = Scope.SOURCE_HIERARCHY;
				if (context instanceof IMethod)
					scope = Scope.NO_HIERARCHY;
	
				// search for method calls using eclipse's infrastructure
				Collection<SearchMatch> methodCalls;
				if (javaInterpreter.projectScope) {
					methodCalls = javaInterpreter.callsCache.get(targetIMethod);
					if (methodCalls == null) {
						methodCalls = JavaModelUtils.getMethodCallsInProject(contextIJavaProject, targetIMethod, progressMonitor);
						javaInterpreter.callsCache.put(targetIMethod, methodCalls);
					}
				}
				else 
					methodCalls = JavaModelUtils.getMethodCalls(contextIJavaProject, typeHierarchy, context, targetType, targetIMethod, scope, progressMonitor); 
	
				progressMonitor.beginTask("Checking method calls to " + targetIMethod.getElementName() + " in context " + context.getElementName(), methodCalls.size());
				for (SearchMatch match : methodCalls) {
					progressMonitor.worked(1);
					if (progressMonitor.isCanceled()) 
						return FSMLEcoreUtil.isFeaturePresent(element, feature);
					// make sure the compilation unit is added to the analysis
					callGraphManager.addCompilationUnit(JavaModelUtils.getTypeRoot(context));
					
					// it will be a method, constructor, field init or static initializer
					IJavaElement enclosingMember = ((IJavaElement) match.getElement()).getPrimaryElement();
					CompilationUnit matchCompilationUnit = javaAstManager.getCompilationUnit(enclosingMember);
					if (matchCompilationUnit == null)
						continue;
					
					ASTNode matchAstNode = ASTNodeSearchUtil.findNode(match, matchCompilationUnit);
					
					if (matchAstNode == null) {
						Stats.INSTANCE.logError("MethodCallsMapping::reverse(): " + element.eClass().getName() + "::" + feature.getName()+ " ASTNode for match not found: " + match + "\n");
						continue;
					}
					if (matchAstNode.getNodeType() != ASTNode.METHOD_INVOCATION && matchAstNode.getNodeType() != ASTNode.CLASS_INSTANCE_CREATION) {
						Stats.INSTANCE.logMessage("MethodCallsMapping::reverse(): matchASTNode which is either method invocation nor class instance creation found: " + matchAstNode.getClass() + "\n");
						continue;
					}
					
					if (statementOnly && matchAstNode.getParent().getNodeType() != ASTNode.EXPRESSION_STATEMENT)
						continue;
					
					// if the method call is in a method declaration, check if it can be accessed from the context
					if (enclosingMember instanceof IMethod) {
						progressMonitor.subTask(JavaModelUtils.formatMethod((IMethod) enclosingMember).toString());
						if (javaInterpreter.analyzeImplVariants()) {
							String declaringMethod = ((IMethod)enclosingMember).getKey().replaceFirst("L[^;]*;\\.", "");
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
							createMarkerDescriptor(enclosingMember, child, "marker for implModel");

						/*MethodInvocation methodInvocation = (MethodInvocation) astNode;
						// analyze the implementation variants
						// find the method name
						ASTNode currentNode = astNode;
						while (currentNode.getNodeType() != ASTNode.METHOD_DECLARATION) {
							currentNode = currentNode.getParent();
						}
						List<Expression> args = methodInvocation.arguments();
						for (Expression arg : args)
							Stats.INSTANCE.log(element.eClass(), feature, annotation, "Arguments: " + arg.getClass().getSimpleName());
		
						String methodName = ((MethodDeclaration) currentNode).getName().toString();
						if (hierarchyConstant == Scope.NO_HIERARCHY)
							Stats.INSTANCE.log(element.eClass(), feature, annotation, "inMethod: " + methodName + ", atLocation: " + ASTUtils.getStmtLocationInMethod(astNode));
						else {
							// we searched beyond the local file
							// try to see if we still get the method
							// call if we just search locally
							Collection<SearchMatch> localResult = CodeQueries.getMethodCalls(contextIType != null ? contextIType : contextIMethod, targetType, targetMethod, progressMonitor, Scope.NO_HIERARCHY);
							if (localResult.contains(match))
								Stats.INSTANCE.log(element.eClass(), feature, annotation, "inMethod: " + methodName + ", atLocation: " + ASTUtils.getStmtLocationInMethod(astNode));
							else if (contextIType != null)
								Stats.INSTANCE.log(element.eClass(), feature, annotation, "inheritsFrom: " + contextIType.getSuperclassName());
						*/
						}

						if (! callGraphManager.calls(context, (IMethod) enclosingMember)) {
							//Stats.INSTANCE.log("MethodCallsMapping::reverse(): Method call to " + targetMethod.getElementName()+ "() found in " + enclosingMemberName + "() is unreachable from context: " + context.getElementName());
							continue;
						}
					}
					
					// check if expression is assignable to the required
					// receiver
					if (!receiver.isEmpty()) {
						Expression receiverExpression = null;
						if (matchAstNode instanceof MethodInvocation)
							receiverExpression = ((MethodInvocation) matchAstNode).getExpression();
						else if (matchAstNode instanceof ClassInstanceCreation)
							receiverExpression = ((ClassInstanceCreation) matchAstNode).getExpression();
						
						if (receiverExpression != null) {
							ITypeBinding typeBinding = receiverExpression.resolveTypeBinding();
	
							if (typeBinding == null)
								continue;
	
							IType iType = (IType) typeBinding.getJavaElement();
							if (! typeHierarchy.implementsOrExtendsType(iType, receiver))
								continue;
							else {// analyze implementation variant
								if (JavaMappingInterpreter.analyzeImplVariants())
									Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation, "receiver is a " + receiverExpression.getClass().getSimpleName());
							}
						} else {
							// the receiver is 'this'
							IType receiverIType = CodeQueries.findITypeContainingASTNode(contextIJavaProject, matchAstNode);
							if (! typeHierarchy.implementsOrExtendsType(receiverIType, receiver))
								continue;
							
							if (JavaMappingInterpreter.analyzeImplVariants())
								Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation, "receiver is this");
						}
					}
					if (setFeatureContextAndMarker(true, matchAstNode, matchAstNode, null) && !feature.isMany()) {
						break;
					}
					
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		progressMonitor.done();
		return FSMLEcoreUtil.isFeaturePresent(element, feature);
	}
}
