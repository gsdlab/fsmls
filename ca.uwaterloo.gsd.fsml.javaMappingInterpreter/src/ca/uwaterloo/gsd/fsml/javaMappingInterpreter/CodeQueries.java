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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.search.FieldReferenceMatch;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IAnalysisManagers;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IHierarchicalCallGraphManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaASTManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.stats.Stats;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class CodeQueries {
	@SuppressWarnings("restriction")
	public static Expression retrieveRHSFromMatch(IJavaASTManager javaAstManager, FieldReferenceMatch match, IProgressMonitor progressMonitor) {
		// TODO: add support for markers!
		// stats
		final String logExpression = "retrieveRHSFromMatch: RHS expression retrieved";
		final String logFailure = "retrieveRHSFromMatch: Unable to retrieve RHS";
		
		Object object = ((IJavaElement) match.getElement()).getPrimaryElement();
		IType declaringType = null;
		if (object instanceof IMethod) {
			declaringType = ((IMethod) object).getDeclaringType();
			while (declaringType.getDeclaringType() != null)
				declaringType = declaringType.getDeclaringType();
		}
		else {
			Stats.INSTANCE.logError(logFailure);
			return null;
		}
		
		CompilationUnit cu = javaAstManager.getCompilationUnit(declaringType);		
		ASTNode astNode = ASTNodeSearchUtil.findNode(match, cu);
		
		if (astNode == null) 
			return null;
		astNode = astNode.getParent();
		if (astNode instanceof Assignment) {
			Assignment assignment = (Assignment) astNode;
			Stats.INSTANCE.logMessage(logExpression);
			return assignment.getRightHandSide();
		}			
		return null;
	}
	// methods factored out as individual mappings
	/**
	 * Copied from Member.class
	 */
	public static boolean areSimilarMethods(
			String name1, String[] params1, 
			String name2, String[] params2,
			String[] simpleNames1) {
		if (name1.equals(name2)) {
			int params1Length = params1.length;
			if (params1Length == params2.length) {
				for (int i = 0; i < params1Length; i++) {
					String simpleName1 = 
						simpleNames1 == null ? 
							Signature.getSimpleName(Signature.toString(Signature.getTypeErasure(params1[i]))) :
							simpleNames1[i];
					String simpleName2 = Signature.getSimpleName(Signature.toString(Signature.getTypeErasure(params2[i])));
					if (!simpleName1.equals(simpleName2)) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	public static IType findITypeContainingASTNode(IJavaProject project, ASTNode astNode) {
		// the node may not be inside the context class. Find IType of the node
		TypeDeclaration typeDeclaration = (TypeDeclaration) ASTUtils.getAncestorOfType(astNode, ASTNode.TYPE_DECLARATION);
		
		String fqName = null;
		if (typeDeclaration != null) {
			ITypeBinding binding = typeDeclaration.getName().resolveTypeBinding();
			if (binding != null)
				fqName = binding.getQualifiedName();
			else {
				String className = typeDeclaration.getName().getIdentifier();
				PackageDeclaration packageDeclaration = ((CompilationUnit) typeDeclaration.getRoot()).getPackage();
				String classQualifier = null;
				if (packageDeclaration != null)
					classQualifier = packageDeclaration.getName().getFullyQualifiedName() + ".";
				fqName = classQualifier + className;
			}
		}
		
		IType iTypeOfNode = null;
		try {
			iTypeOfNode = project.findType(fqName);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return iTypeOfNode;
	}
	/**
	 * @param fqTypeName
	 * @param signature
	 * @return true iff the signature represents fqTypeName
	 */
	public static boolean compareTypeSignatures(String fqTypeName, String signature) {
		String fqResolvedName = Signature.createTypeSignature(fqTypeName, true);
		String fqUnresolvedName = Signature.createTypeSignature(fqTypeName, false);
		String sResolvedName = Signature.createTypeSignature(Signature.getSimpleName(fqTypeName), true);
		String sUnresolvedName = Signature.createTypeSignature(Signature.getSimpleName(fqTypeName), false);
		
		boolean fqResolved = fqResolvedName.equals(signature);
		boolean fqUnresolved = fqUnresolvedName.equals(signature);
		boolean sResolved = sResolvedName.equals(signature);
		boolean sUnresolved = sUnresolvedName.equals(signature);
		
		return fqResolved || fqUnresolved || sResolved || sUnresolved;
	}	
	
	/**
	 * @param expression
	 * @param analysisManagers
	 * @return a list of expressions that are static values of the given expression. Null indicates unexpected problem during analysis.
	 * This method is an entry point for dataflow analysis.
	 */
	public static void getStaticExpressionsForExpression(Expression expression, IType contextIType, ArrayList<Expression> result, IAnalysisManagers analysisManagers, IProgressMonitor progressMonitor) {
		if (ASTUtils.hasStaticValue(expression)) {
			// the expression is a) a literal, 2) a static final (both array and non-array) variable, 3) enum literal
			if (expression.getNodeType() == ASTNode.SIMPLE_NAME) {
				IBinding iBinding = ((SimpleName) expression).resolveBinding();
				CompilationUnit compilationUnit = (CompilationUnit) expression.getRoot();
				// that is a static final variable, return the initializer instead of the identifier
				result.add(ASTUtils.getInitializer(compilationUnit, (IVariableBinding) iBinding));
			}
			else if (expression.getNodeType() == ASTNode.QUALIFIED_NAME)
				getStaticExpressionsForVariable((QualifiedName) expression, contextIType, result, analysisManagers, progressMonitor);
			else
				result.add(expression);
			return;
		}
		switch (expression.getNodeType()) {
		case ASTNode.SIMPLE_NAME:
			IBinding resolvedBinding = ((SimpleName) expression).resolveBinding();
			if (resolvedBinding instanceof IVariableBinding)
				// a variable
				CodeQueries.getStaticExpressionsForVariable((SimpleName) expression, contextIType, result, analysisManagers, progressMonitor);
			break;
		case ASTNode.QUALIFIED_NAME:
			resolvedBinding = ((QualifiedName) expression).resolveBinding();
			if (resolvedBinding instanceof IVariableBinding)
				// a variable
				CodeQueries.getStaticExpressionsForVariable((QualifiedName) expression, contextIType, result, analysisManagers, progressMonitor);
			break;
		case ASTNode.ARRAY_ACCESS:
			// navigate to the simpleName of the array
			Expression aux = expression;
			while (aux instanceof ArrayAccess) {
				ArrayAccess arrayAccess = (ArrayAccess) aux;
				aux = arrayAccess.getArray();
			}
			if (!(aux instanceof SimpleName))
				// should never happen!
				break;

			SimpleName arraySimpleName = (SimpleName) aux;
			
			ArrayList<Expression> valueExpressions = new ArrayList<Expression>(); 
			ArrayList<Expression> cellValueExpressions = new ArrayList<Expression>();
			CodeQueries.getStaticExpressionsForVariable(arraySimpleName, contextIType, valueExpressions, analysisManagers, progressMonitor);
			
			for (Expression valueExpression : valueExpressions) {
				ArrayInitializer arrayInitializer = null;
				switch (valueExpression.getNodeType()) {
				case ASTNode.ARRAY_INITIALIZER:
					arrayInitializer = (ArrayInitializer) valueExpression;
					break;
				case ASTNode.ARRAY_CREATION:
					arrayInitializer = ((ArrayCreation) valueExpression).getInitializer();
					break;
				}
					
				if (arrayInitializer != null) {
					// iterate over the array depending on which of the indexes
					// are not constants
					ArrayAccess arrayAccess = (ArrayAccess) aux.getParent();

					cellValueExpressions = CodeQueries.getStaticExpressionsForArrayAccess(arrayAccess, arrayInitializer);
					if (cellValueExpressions != null)
						result.addAll(cellValueExpressions);
				}
			}
			break;
		case ASTNode.METHOD_INVOCATION:
		case ASTNode.SUPER_METHOD_INVOCATION:
		case ASTNode.CLASS_INSTANCE_CREATION:
		case ASTNode.SUPER_CONSTRUCTOR_INVOCATION:
			getStaticExpressionsForMethodInvocation(expression, contextIType, result, analysisManagers, progressMonitor);
			break;
		case ASTNode.PARENTHESIZED_EXPRESSION:
			ParenthesizedExpression expression2 = (ParenthesizedExpression) expression;
			getStaticExpressionsForExpression(expression2.getExpression(), contextIType, result, analysisManagers, progressMonitor);
			break;
		case ASTNode.CONDITIONAL_EXPRESSION:
			ConditionalExpression conditionalExpression = (ConditionalExpression) expression;
			getStaticExpressionsForExpression(conditionalExpression.getThenExpression(), contextIType, result, analysisManagers, progressMonitor);
			getStaticExpressionsForExpression(conditionalExpression.getElseExpression(), contextIType, result, analysisManagers, progressMonitor);
			break;
		case ASTNode.CAST_EXPRESSION:
			CastExpression castExpression = (CastExpression) expression;
			getStaticExpressionsForExpression(castExpression.getExpression(), contextIType, result, analysisManagers, progressMonitor);
			break;
		}
		
	}
	public static void getStaticExpressionsForVariable(QualifiedName variable, IType contextIType, ArrayList<Expression> result, IAnalysisManagers analysisManagers, IProgressMonitor progressMonitor) {
		IVariableBinding iVariableBinding;
		if (variable.resolveBinding() instanceof IVariableBinding)
			iVariableBinding = (IVariableBinding) variable.resolveBinding();
		else
			throw new IllegalArgumentException("Parameter 'variable' must be an identfier of a variable");
		
		IVariableBinding iVariableDeclarationBinding = iVariableBinding.getVariableDeclaration();
		IJavaElement iJavaElement = iVariableDeclarationBinding.getJavaElement();
		
		IJavaASTManager astManager = analysisManagers.getJavaASTManager();
		CompilationUnit variableCompilationUnit = astManager.getCompilationUnit(iJavaElement);
		
		VariableDeclarationFragment variableDeclaration = ASTUtils.getVariableDeclarationFragmentNode(iVariableDeclarationBinding, variableCompilationUnit);
		getStaticExpressionsForVariable(variableDeclaration.getName(), contextIType, result, analysisManagers, progressMonitor);
	}
	public static void getStaticExpressionsForVariable(SimpleName variable, IType contextIType, ArrayList<Expression> result, IAnalysisManagers analysisManagers, IProgressMonitor progressMonitor) {
		IVariableBinding iVariableBinding;
		if (variable.resolveBinding() instanceof IVariableBinding)
			iVariableBinding = (IVariableBinding) variable.resolveBinding();
		else
			throw new IllegalArgumentException("Parameter 'variable' must be an identfier of a variable");
		
		CompilationUnit variableCompilationUnit = (CompilationUnit) variable.getRoot();
		
		// constant value first or static final array
		if (variable.resolveConstantExpressionValue() != null ||
			ASTUtils.isStaticFinalArrayField(iVariableBinding)) {
			// constant expression value is null for static arrays
			Expression initializer = ASTUtils.getInitializer(variableCompilationUnit, iVariableBinding);
			if (initializer != null) {
				getStaticExpressionsForExpression(initializer, contextIType, result, analysisManagers, progressMonitor);
				return;
			}
		}
		
		// regardless of the number of writes consider if a parameter and include the initalizer if present
		// need to see if the variable is a parameter and look for method calls
		if (iVariableBinding.isParameter()) {
			MethodDeclaration methodDeclaration = (MethodDeclaration) ASTUtils.getAncestorOfType(variable, ASTNode.METHOD_DECLARATION);
			SingleVariableDeclaration singleVariableDeclaration = null;
			for (Object parameterObject : methodDeclaration.parameters()) {
				SingleVariableDeclaration parameterVariableDeclaration = (SingleVariableDeclaration) parameterObject;
				if (iVariableBinding.isEqualTo(parameterVariableDeclaration.resolveBinding())) {
					singleVariableDeclaration = parameterVariableDeclaration;
					break;
				}
			}
			int index = methodDeclaration.parameters().indexOf(singleVariableDeclaration);
			IMethodBinding iMethodBinding = methodDeclaration.resolveBinding();
			
			for (ASTNode methodInvocationName : ASTUtils.findMathodInvocations(variableCompilationUnit, methodDeclaration, iMethodBinding)) {
				ASTNode methodInvocationNode = methodInvocationName.getParent();
				Expression argument = null;
				switch (methodInvocationNode.getNodeType()) {
				case ASTNode.METHOD_INVOCATION:
					argument = (Expression) ((MethodInvocation) methodInvocationNode).arguments().get(index);
					break;
				case ASTNode.CLASS_INSTANCE_CREATION:
					argument = (Expression) ((ClassInstanceCreation) methodInvocationNode).arguments().get(index);
					break;
				}
				getStaticExpressionsForExpression(argument, contextIType, result, analysisManagers, progressMonitor);
			}
		} else {
			Expression initializer = ASTUtils.getInitializer(variableCompilationUnit, iVariableBinding);
			if (initializer != null)
				getStaticExpressionsForExpression(initializer, contextIType, result, analysisManagers, progressMonitor);
		}
		// so there is no constant value. Need to find assignments.
		List<ASTNode> writeAccesses = ASTUtils.findWriteAccesses(variableCompilationUnit, variable, iVariableBinding);
		
		// Michal: include all write accesses
		for (ASTNode writeAccess : writeAccesses) {
			if (writeAccess.getParent() instanceof Assignment) {
				Expression rhs = ((Assignment) writeAccess.getParent()).getRightHandSide();
				getStaticExpressionsForExpression(rhs, contextIType, result, analysisManagers, progressMonitor);
			}
		}
	}
	/**
	 * @param call to a method or a constructor
	 * @param contextIType
	 * @param result
	 * @param analysisManagers
	 * @param progressMonitor
	 */
	public static void getStaticExpressionsForMethodInvocation(final Expression call, IType contextIType, ArrayList<Expression> result, final IAnalysisManagers analysisManagers, final IProgressMonitor progressMonitor) {
		final IJavaASTManager javaAstManager = analysisManagers.getJavaASTManager(); 
		final IHierarchicalCallGraphManager callGraphManager = analysisManagers.getHierarchicalCallGraphManager();
		
		IMethod targetIMethod = null;
		IMethod executingIMethod = null;
		try {
			switch (call.getNodeType()) {
			case ASTNode.METHOD_INVOCATION:
				MethodInvocation methodInvocation = (MethodInvocation) call;
				targetIMethod = (IMethod) methodInvocation.resolveMethodBinding().getJavaElement();
				
				if (methodInvocation.getExpression() == null || methodInvocation.getExpression().getNodeType() == ASTNode.THIS_EXPRESSION)
					// a call in the hierarchy of the context type
					executingIMethod = callGraphManager.getExecutingMethod(contextIType, targetIMethod);
				else {
					List<IMethod> implementations = callGraphManager.findImplementations(JavaModelUtils.getDeclaringType(targetIMethod), targetIMethod);
					if (implementations.size() == 1)
						executingIMethod = implementations.get(0);
					else 
						executingIMethod = targetIMethod;
					contextIType = JavaModelUtils.getDeclaringType(executingIMethod != null ? executingIMethod : targetIMethod);
				}
				break;
			case ASTNode.CLASS_INSTANCE_CREATION:
				ClassInstanceCreation classInstanceCreation = (ClassInstanceCreation) call;
				targetIMethod = (IMethod) classInstanceCreation.resolveConstructorBinding().getJavaElement();
				executingIMethod = callGraphManager.getExecutingMethod(contextIType, targetIMethod);
				contextIType = JavaModelUtils.getDeclaringType(executingIMethod != null ? executingIMethod : targetIMethod);
				break;
			case ASTNode.SUPER_METHOD_INVOCATION:
				SuperMethodInvocation superMethodInvocation = (SuperMethodInvocation) call;
				targetIMethod = (IMethod) superMethodInvocation.resolveMethodBinding().getJavaElement();
				executingIMethod = callGraphManager.getExecutingMethod(contextIType, targetIMethod);
				// context remains the same
				break;
			default:
				throw new IllegalArgumentException("Parameter 'call' must be either a MethodInvocation, a SuperMethodInvocation, or a ClassInstanceCreation");
			}
			
			callGraphManager.addCompilationUnit(JavaModelUtils.getTypeRoot(contextIType));
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		if (executingIMethod == null || !executingIMethod.exists())
			// perhaps outside the hierarchy, proceed with the statically known method
			executingIMethod = targetIMethod;
		
		CompilationUnit executingMethodCU = javaAstManager.getCompilationUnit(executingIMethod);
		if (executingMethodCU == null) {
			System.err.println("cannot get a compilation unit for: " + executingIMethod);
			return;
		}
		MethodDeclaration executingMethodDeclaration = ASTUtils.getMethodDeclarationNode(executingIMethod, executingMethodCU);
		
		getStaticExpressionsForMethodDeclaration(executingMethodDeclaration, contextIType, result, analysisManagers, progressMonitor);
	}
	/**
	 * @param methodDeclaration
	 * @param progressMonitor
	 * @param javaAstManager
	 * @param callGraphManager
	 * @param result2 
	 * @param argumentSummary contains 'true' at index i iff at the moment of method's invocation, the ith argument is known to have the static value. 
	 * @return a list of expressions used in return statements that have static values of both simple and array types. Never null.
	 */
	public static void getStaticExpressionsForMethodDeclaration(final MethodDeclaration methodDeclaration, final IType contextIType, final ArrayList<Expression> result, final IAnalysisManagers analysisManagers, final IProgressMonitor progressMonitor) {
		methodDeclaration.accept(new ASTVisitor() {
			public boolean visit(ReturnStatement returnStatement) {
				Expression expression = returnStatement.getExpression();
				
				getStaticExpressionsForExpression(expression, contextIType, result, analysisManagers, progressMonitor);
				return false;
			}
			@Override
			public boolean visit(ClassInstanceCreation node) {
				// prevent the analysis of the contents of the anonymous subclasses
				return false;
			}
		});
	}
	public static ArrayList<Expression> getStaticExpressionsForArrayAccess(ArrayAccess arrayAccess, ArrayInitializer arrayInitializer) {
		ArrayList<Expression> result = new ArrayList<Expression>();
		Expression indexExpression = arrayAccess.getIndex();
		
		if (indexExpression.getNodeType() == ASTNode.NUMBER_LITERAL) {
			// we pick particular row and proceed
			String indexString = ASTUtils.getStringValue(indexExpression);
			int index = Integer.parseInt(indexString);
			// if the code throws IndexOutOfBoundsException
			if (index >= arrayInitializer.expressions().size())
				return result;
			
			Expression rowExpression = (Expression) arrayInitializer.expressions().get(index);
			if (rowExpression.getNodeType() == ASTNode.ARRAY_INITIALIZER) {
				// process recursively
				if (arrayAccess.getParent().getNodeType() == ASTNode.ARRAY_ACCESS)
					result.addAll(getStaticExpressionsForArrayAccess((ArrayAccess) arrayAccess.getParent(), (ArrayInitializer) rowExpression));
			}
			else if (rowExpression.resolveConstantExpressionValue() != null)
				result.add(rowExpression);
		}
		else {
			// we iterate over all rows
			for (Object rowExpressionObject : arrayInitializer.expressions()) {
				Expression rowExpression = (Expression) rowExpressionObject;
			
				if (rowExpression.getNodeType() == ASTNode.ARRAY_INITIALIZER) {
					// process recursively
					if (arrayAccess.getParent().getNodeType() == ASTNode.ARRAY_ACCESS)
						result.addAll(getStaticExpressionsForArrayAccess((ArrayAccess) arrayAccess.getParent(), (ArrayInitializer) rowExpression));
				}
				else if (rowExpression.resolveConstantExpressionValue() != null)
					result.add(rowExpression);
			}
		}
		return result;
	}
	/**
	 * Convenience function for creating single element results.
	 * @param expression
	 * @return
	 */
	public static ArrayList<Expression> newArrayList(Expression expression) {
		ArrayList<Expression> result = new ArrayList<Expression>();
		result.add(expression);
		return result;
	}
	/**
	 * Convenience function for creating an empty result.
	 * @return
	 */
	public static ArrayList<Expression> newEmptyArrayList() {
		ArrayList<Expression> result = new ArrayList<Expression>();
		return result;
	}
	
	// most-specific-type inference
	public static boolean isMoreSpecific(ITypeBinding specificTypeBinding, ITypeBinding generalTypeBinding) {
		return !generalTypeBinding.getKey().equals(specificTypeBinding.getKey()) && 
				specificTypeBinding.isAssignmentCompatible(generalTypeBinding);
	}
	public static ArrayList<Expression> getExpressionWithMostSpecificType(ArrayList<Expression> expressions) {
		/*ArrayList<Expression> mostSpecificTypeExpression = new ArrayList<Expression>();
		
		for (Expression expression : expressions) {
			if (expression == null || expression instanceof NullLiteral)
				continue;
			if (mostSpecificTypeExpression == null) {
				mostSpecificTypeExpression = expression;
				continue;
			}
			if (isMoreSpecific(expression.resolveTypeBinding(), mostSpecificTypeExpression.resolveTypeBinding()))
				mostSpecificTypeExpression = expression;
		}
		
		if (mostSpecificTypeExpression == null)
			return null;
		return mostSpecificTypeExpression;*/
		// TODO: implement to remove false positives
		return expressions;
	}
	public static ArrayList<Expression> getExpressionWithMostSpecificTypeForExpression(Expression expression, final IType contextIType, ArrayList<MethodDeclaration> visitedMethodDeclarations, final IAnalysisManagers analysisManagers, final IProgressMonitor progressMonitor) {
		ArrayList<Expression> result = new ArrayList<Expression>();
		
		switch (expression.getNodeType()) {
		case ASTNode.SIMPLE_NAME:
			return getExpressionWithMostSpecificTypeForVariable((SimpleName) expression, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);	
		case ASTNode.QUALIFIED_NAME:
			return getExpressionWithMostSpecificTypeForVariable((QualifiedName) expression, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);
		case ASTNode.PARENTHESIZED_EXPRESSION:
			Expression subExpression = ((ParenthesizedExpression) expression).getExpression();
			return getExpressionWithMostSpecificTypeForExpression(subExpression, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);
		case ASTNode.CONDITIONAL_EXPRESSION:
			Expression thenExpression= ((ConditionalExpression) expression).getThenExpression();
			Expression elseExpression= ((ConditionalExpression) expression).getElseExpression();
			// get most-specific-type expressions
			ArrayList<Expression> thenExpressions = getExpressionWithMostSpecificTypeForExpression(thenExpression, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);
			ArrayList<Expression> elseExpressions = getExpressionWithMostSpecificTypeForExpression(elseExpression, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);
			ArrayList<Expression> allExpressions = new ArrayList<Expression>();
			allExpressions.addAll(thenExpressions);
			allExpressions.addAll(elseExpressions);
			result.addAll(getExpressionWithMostSpecificType(allExpressions));
			break;
		case ASTNode.CAST_EXPRESSION:
			CastExpression castExpression = (CastExpression) expression;
			// get most-specific-type expressions
			ArrayList<Expression> expressions = getExpressionWithMostSpecificTypeForExpression(castExpression.getExpression(), contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);
			if (expressions.size() <= 1) {
				result.add(castExpression);
				break;
			}
			else
				return expressions;
		case ASTNode.METHOD_INVOCATION:
		case ASTNode.SUPER_METHOD_INVOCATION:
			return getExpressionWithMostSpecificTypeForMethodInvocation(expression, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);
		default:
			result.add(expression);
		}
		// could not find anything with more specific type than the expression itself
		return result;
	}
	public static ArrayList<Expression> getExpressionWithMostSpecificTypeForVariable(SimpleName variable, final IType contextIType, ArrayList<MethodDeclaration> visitedMethodDeclarations, final IAnalysisManagers analysisManagers, final IProgressMonitor progressMonitor) {
		IVariableBinding iVariableBinding;
		if (variable.resolveBinding() ==null){
			return new ArrayList<Expression>();
		}
		if (variable.resolveBinding() instanceof IVariableBinding)
			iVariableBinding = (IVariableBinding) variable.resolveBinding();
		else
			throw new IllegalArgumentException("Parameter 'variable' must be an identfier of a variable");
		
		CompilationUnit variableCompilationUnit = (CompilationUnit) variable.getRoot();
		
		ArrayList<Expression> result = new ArrayList<Expression>();
		
		// find assignments
		List<ASTNode> writeAccesses = ASTUtils.findWriteAccesses(variableCompilationUnit, variable, iVariableBinding);
		
		for (ASTNode writeAccess : writeAccesses) {
			if (writeAccess.getParent() instanceof Assignment) {
				Expression rhs = ((Assignment) writeAccess.getParent()).getRightHandSide();
				if (rhs instanceof NullLiteral)
					continue;
				result.addAll(getExpressionWithMostSpecificTypeForExpression(rhs, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor));
			}
		}
		
		// need to see if the variable is a parameter and look for method calls
		if (iVariableBinding.isParameter()) {
			MethodDeclaration methodDeclaration = (MethodDeclaration) ASTUtils.getAncestorOfType(variable, ASTNode.METHOD_DECLARATION);
			SingleVariableDeclaration singleVariableDeclaration = null;
			for (Object parameterObject : methodDeclaration.parameters()) {
				SingleVariableDeclaration parameterVariableDeclaration = (SingleVariableDeclaration) parameterObject;
				if (iVariableBinding.isEqualTo(parameterVariableDeclaration.resolveBinding())) {
					singleVariableDeclaration = parameterVariableDeclaration;
					break;
				}
			}
			int index = methodDeclaration.parameters().indexOf(singleVariableDeclaration);
			IMethodBinding iMethodBinding = methodDeclaration.resolveBinding();
			
			for (ASTNode methodInvocationName : ASTUtils.findMathodInvocations(variableCompilationUnit, methodDeclaration, iMethodBinding)) {
				ASTNode methodInvocationNode = methodInvocationName.getParent();
				Expression argument = null;
				switch (methodInvocationNode.getNodeType()) {
				case ASTNode.METHOD_INVOCATION:
					argument = (Expression) ((MethodInvocation) methodInvocationNode).arguments().get(index);
					break;
				case ASTNode.CLASS_INSTANCE_CREATION:
					argument = (Expression) ((ClassInstanceCreation) methodInvocationNode).arguments().get(index);
					break;
				}
				result.addAll(getExpressionWithMostSpecificTypeForExpression(argument, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor));
			}
		}
		else {
			// get initializer
			Expression initializer = ASTUtils.getInitializer(variableCompilationUnit, iVariableBinding);
			if (initializer != null && initializer.getNodeType() != ASTNode.NULL_LITERAL)
				result.addAll(getExpressionWithMostSpecificTypeForExpression(initializer, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor));
		}
		if (result.isEmpty()) {
			result.add(variable);
			return result;
		}
		return getExpressionWithMostSpecificType(result);
	}
	public static ArrayList<Expression> getExpressionWithMostSpecificTypeForVariable(QualifiedName variable, final IType contextIType, ArrayList<MethodDeclaration> visitedMethodDeclarations, final IAnalysisManagers analysisManagers, final IProgressMonitor progressMonitor) {
		IVariableBinding iVariableBinding;
		if (variable.resolveBinding() instanceof IVariableBinding)
			iVariableBinding = (IVariableBinding) variable.resolveBinding();
		else
			throw new IllegalArgumentException("Parameter 'variable' must be an identfier of a variable");
		
		IVariableBinding iVariableDeclarationBinding = iVariableBinding.getVariableDeclaration();
		IJavaElement iJavaElement = iVariableDeclarationBinding.getJavaElement();
		
		IJavaASTManager astManager = analysisManagers.getJavaASTManager();
		CompilationUnit variableCompilationUnit = astManager.getCompilationUnit(iJavaElement);
		
		VariableDeclarationFragment variableDeclaration = ASTUtils.getVariableDeclarationFragmentNode(iVariableDeclarationBinding, variableCompilationUnit);
		TypeDeclaration typeDeclaration = ASTUtils.getDeclaringType(variableDeclaration);
		IType newContextIType = (IType) typeDeclaration.resolveBinding().getJavaElement();
		if (newContextIType != null)
			return getExpressionWithMostSpecificTypeForVariable(variableDeclaration.getName(), newContextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);
		return newArrayList(variable);
	}
	public static ArrayList<Expression> getExpressionWithMostSpecificTypeForMethodInvocation(Expression expression, IType contextIType, ArrayList<MethodDeclaration> visitedMethodDeclarations, final IAnalysisManagers analysisManagers, final IProgressMonitor progressMonitor) {
		final IJavaASTManager javaAstManager = analysisManagers.getJavaASTManager(); 
		final IHierarchicalCallGraphManager callGraphManager = analysisManagers.getHierarchicalCallGraphManager();
		
		// make sure the contextIType is in the call graph
		callGraphManager.addCompilationUnit(JavaModelUtils.getTypeRoot(contextIType));
		
		IMethod targetIMethod = null;
		IMethod executingIMethod = null;
		switch (expression.getNodeType()) {
		case ASTNode.METHOD_INVOCATION:
			MethodInvocation methodInvocation = (MethodInvocation) expression;
			IMethodBinding iMethodBinding = methodInvocation.resolveMethodBinding();
			if (iMethodBinding == null)
				return newEmptyArrayList();
			targetIMethod = (IMethod) iMethodBinding.getJavaElement();
			
			if (methodInvocation.getExpression() == null || methodInvocation.getExpression().getNodeType() == ASTNode.THIS_EXPRESSION)
				// a call in the hierarchy of the context type
				executingIMethod = callGraphManager.getExecutingMethod(contextIType, targetIMethod);
				// context remains the same
			else {
				try {
					List<IMethod> implementations = callGraphManager.findImplementations(JavaModelUtils.getDeclaringType(targetIMethod), targetIMethod);
					if (implementations.size() == 1)
						executingIMethod = implementations.get(0);
					else 
						executingIMethod = targetIMethod;
					contextIType = JavaModelUtils.getDeclaringType(executingIMethod != null ? executingIMethod : targetIMethod);
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
			}
			if (executingIMethod == null || !executingIMethod.exists())
				// perhaps outside the hierarchy, proceed with the statically known method
				executingIMethod = targetIMethod;
			break;
		case ASTNode.SUPER_METHOD_INVOCATION:
			SuperMethodInvocation superMethodInvocation = (SuperMethodInvocation) expression;
			iMethodBinding = superMethodInvocation.resolveMethodBinding();
			if (iMethodBinding == null)
				return newEmptyArrayList();
			
			targetIMethod = (IMethod) iMethodBinding.getJavaElement();
			executingIMethod = targetIMethod;
			break;
		default:
			throw new IllegalArgumentException("getExpressionWithMostSpecificTypeForMethodInvocation(): Parameter 'expression' must be either a MethodInvocation or a SuperMethodInvocation");
		}
		CompilationUnit executingMethodCU = javaAstManager.getCompilationUnit(executingIMethod);
		if (executingMethodCU == null) {
			System.err.println("getExpressionWithMostSpecificTypeForMethodInvocation(): Cannot get a compilation unit for: " + executingIMethod);
			// cannot follow the call, have to return the invocation expression 
			return newArrayList(expression);
		}
		MethodDeclaration executingMethodDeclaration = ASTUtils.getMethodDeclarationNode(executingIMethod, executingMethodCU);
		
		ArrayList<Expression> expressions = getExpressionWithMostSpecificTypeForMethodDeclaration(executingMethodDeclaration, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor);
		if (expressions == null)
			// the method declaration has been already analysed.
			return new ArrayList<Expression>();
		if (expressions.isEmpty())
			return newArrayList(expression);
		return getExpressionWithMostSpecificType(expressions);
	}
	/**
	 * @param methodDeclaration
	 * @param contextIType
	 * @param visitedMethodDeclarations
	 * @param analysisManagers
	 * @param progressMonitor
	 * @return expressions that have the most specific types of return expressions. 
	 * Returns null if the method was previously analysed.
	 */
	public static ArrayList<Expression> getExpressionWithMostSpecificTypeForMethodDeclaration(MethodDeclaration methodDeclaration, final IType contextIType, final ArrayList<MethodDeclaration> visitedMethodDeclarations, final IAnalysisManagers analysisManagers, final IProgressMonitor progressMonitor) {
		final ArrayList<Expression> result = new ArrayList<Expression>();
		// prevent infinite recursion
		if (visitedMethodDeclarations.contains(methodDeclaration))
			return null;
		else
			visitedMethodDeclarations.add(methodDeclaration);
		methodDeclaration.accept(new ASTVisitor() {
			@Override
			public boolean visit(ReturnStatement returnStatement) {
				Expression expression = returnStatement.getExpression();
				if (expression instanceof NullLiteral)
					return false;
				result.addAll(getExpressionWithMostSpecificTypeForExpression(expression, contextIType, visitedMethodDeclarations, analysisManagers, progressMonitor));
				return false;
			}
			@Override
			public boolean visit(ClassInstanceCreation node) {
				// prevent the analysis of the contents of the anonymous subclasses
				return false;
			}
		});
		return result;
	}
}
