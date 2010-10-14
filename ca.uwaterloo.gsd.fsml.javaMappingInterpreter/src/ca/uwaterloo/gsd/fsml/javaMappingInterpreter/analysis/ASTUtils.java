/*******************************************************************************
 * Copyright (c) 2010 Michal Antkiewicz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Michal Antkiewicz - initial API and implementation
 *     Thiago Tonelli Bartolomei - extensions
 ******************************************************************************/

package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IInitializer;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.internal.core.util.Util;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeQueries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.OccurrencesFinder;
import ca.uwaterloo.gsd.fsml.stats.Stats;

/**
 * Utility methods for manipulating AST nodes
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class ASTUtils {

	/**
	 * Returns the AST node relative to the search match, if it is inside this compilation unit.
	 * 
	 * This is just to remove this "discouraged access" from other classes.
	 * 
	 * @param match
	 * @param cu
	 * @return
	 */
	public static ASTNode getASTNode(SearchMatch match, CompilationUnit cu) {
		return ASTNodeSearchUtil.findNode(match, cu);
	}
	
	/**
	 * Returns the AST node relative to this member, if it is inside this compilation unit. The member
	 * can be an static initializer, a field initializer, a method (constructor) or a type declaration.
	 * 
	 * @param member
	 * @param cu
	 * @return
	 * @throws JavaModelException
	 */
	public static BodyDeclaration getASTNode(IMember member, CompilationUnit cu) throws JavaModelException {
		
		if (member instanceof IField) {
			return ASTNodeSearchUtil.getFieldDeclarationNode((IField) member, cu);
		}
		if (member instanceof IInitializer) {
			return ASTNodeSearchUtil.getInitializerNode((IInitializer) member, cu);
		}
		if (member instanceof IMethod) {
			return ASTNodeSearchUtil.getMethodDeclarationNode((IMethod) member, cu);
		}
		if (member instanceof IType) {
			return ASTNodeSearchUtil.getTypeDeclarationNode((IType) member, cu);
		}
		return null;
	}
	
	// types
	public static TypeDeclaration getTypeDeclarationNode(ITypeBinding typeBinding, CompilationUnit compilationUnit) {
		TypeDeclaration result = (TypeDeclaration) compilationUnit.findDeclaringNode(typeBinding);
		if (result == null)
			return getTypeDeclarationNode((IType) typeBinding.getJavaElement(), compilationUnit);
		return result;
	}
	public static TypeDeclaration getTypeDeclarationNode(IType iType, CompilationUnit compilationUnit) {
		TypeDeclaration result = (TypeDeclaration) compilationUnit.findDeclaringNode(iType.getKey());
		if (result == null) {
			try {
				return ASTNodeSearchUtil.getTypeDeclarationNode(iType, compilationUnit);
			} catch (JavaModelException e) {
			}
		}
		return result;
	}
	// methods
	public static MethodDeclaration getMethodDeclarationNode(IMethodBinding methodBinding, CompilationUnit compilationUnit) {
		MethodDeclaration result = (MethodDeclaration) compilationUnit.findDeclaringNode(methodBinding);
		if (result == null)
			return getMethodDeclarationNode((IMethod) methodBinding.getJavaElement(), compilationUnit);
		return result;
	}
	public static MethodDeclaration getMethodDeclarationNode(IMethod iMethod, CompilationUnit compilationUnit) {
		MethodDeclaration result = (MethodDeclaration) compilationUnit.findDeclaringNode(iMethod.getKey());
		if (result == null) {
			try {
				return ASTNodeSearchUtil.getMethodDeclarationNode(iMethod, compilationUnit);
			} catch (JavaModelException e) {
			}
		}
		return result;
	}	
	// fields
	public static VariableDeclarationFragment getVariableDeclarationFragmentNode(IVariableBinding iVariableBinding, CompilationUnit compilationUnit) {
		VariableDeclarationFragment result = (VariableDeclarationFragment) compilationUnit.findDeclaringNode(iVariableBinding);
		if (result == null)
			return getVariableDeclarationFragmentNode((IField) iVariableBinding.getJavaElement(), compilationUnit);
		return result;
	}
	public static VariableDeclarationFragment getVariableDeclarationFragmentNode(IField iField, CompilationUnit compilationUnit) {
		VariableDeclarationFragment result = (VariableDeclarationFragment) compilationUnit.findDeclaringNode(iField.getKey());
		if (result == null) {
			try {
				return ASTNodeSearchUtil.getFieldDeclarationFragmentNode(iField, compilationUnit);
			} catch (JavaModelException e) {
			}
		}
		return result;
	}
	/**
	 * Gets the first statement of this method declaration
	 * 
	 * @param decl a method (or constructor) declaration
	 * @return the first statement, or null if nothing found
	 */
	public static Statement getFirstStatement(MethodDeclaration decl) {
		
		try {
			return (Statement) decl.getBody().statements().get(0);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @param expression is any literal expression: BOOLEAN_LITERAL, CHARACTER_LITERAL, NULL_LITERAL, NUMBER_LITERAL, STRING_LITERAL, and TYPE_LITERAL.
	 * @return string representation
	 */
	public static String getStringValue(Expression expression) {
		switch (expression.getNodeType()) {
		case ASTNode.BOOLEAN_LITERAL:
			return ((BooleanLiteral) expression).booleanValue() ? "true" : "false";
		case ASTNode.CHARACTER_LITERAL:
			return ((CharacterLiteral) expression).getEscapedValue();
		case ASTNode.NULL_LITERAL:
			return "null";
		case ASTNode.NUMBER_LITERAL:
			return ((NumberLiteral)expression).getToken();
		case ASTNode.STRING_LITERAL:
			return ((StringLiteral) expression).getLiteralValue();
		case ASTNode.TYPE_LITERAL:
			TypeLiteral typeLiteral = (TypeLiteral) expression;
			if (typeLiteral.getType().resolveBinding() != null)
				return typeLiteral.getType().resolveBinding().getQualifiedName();
			else
				return getFullyQualifiedName(typeLiteral.getType());
		}
		return null;
	}

	public static Expression getInitializer(CompilationUnit compilationUnit, IVariableBinding iVariableBinding) {
		IVariableBinding variableDeclarationBinding = iVariableBinding.getVariableDeclaration();
		VariableDeclarationFragment variableDeclaration = getVariableDeclarationFragmentNode(variableDeclarationBinding, compilationUnit);
		if (variableDeclaration == null) {
			Stats.INSTANCE.logError("ASTUtils.getInitializer(): cannot find variable declaration for " + variableDeclarationBinding.getKey());
			return null;
		}
		return variableDeclaration.getInitializer();
	}

	/**
	 * @return the closes parent (ancestor) of the given @param astNode of given @param nodeType.
	 * The node type constants are located in the ASTNode class, e.g., ASTNode.METHOD_DECLARATION.
	 */
	public static ASTNode getAncestorOfType(ASTNode astNode, int nodeType) {
		ASTNode aux = astNode;
		while (aux != null && aux.getNodeType() != nodeType) 
			aux = aux.getParent();
		
		return aux;
	}
	/**
	 * Returns the type declaration where this node was declared.
	 * Note that if node was declared on a nested type, the closest type
	 * is returned.
	 * 
	 * @param node
	 * @return
	 */
	public static TypeDeclaration getDeclaringType(ASTNode astNode) {
		return (TypeDeclaration) getAncestorOfType(astNode, ASTNode.TYPE_DECLARATION);
	}
	public static List<ASTNode> findMathodInvocations(CompilationUnit compilationUnit, MethodDeclaration methodDeclaration) {
		return ASTUtils.findMathodInvocations(compilationUnit, methodDeclaration, methodDeclaration.resolveBinding());
	}

	public static List<ASTNode> findMathodInvocations(CompilationUnit compilationUnit, MethodDeclaration methodDeclaration, IMethodBinding iMethodBinding) {
		OccurrencesFinder occurrencesFinder = new OccurrencesFinder();
		occurrencesFinder.initialize(compilationUnit, methodDeclaration.getName());
		
		List<ASTNode> result = occurrencesFinder.performGlobally();
		for (Iterator<ASTNode> i = result.iterator(); i.hasNext(); ) {
			ASTNode node = i.next();
			switch (node.getParent().getNodeType()) {
			case ASTNode.METHOD_DECLARATION:
			case ASTNode.METHOD_REF:
			case ASTNode.METHOD_REF_PARAMETER:
				i.remove();
				break;
			}
		}
		return result;
	}

	public static List<ASTNode> findWriteAccesses(CompilationUnit compilationUnit, SimpleName variable) {
		IBinding iBinding = variable.resolveBinding();
		if (iBinding instanceof IVariableBinding)
			return findWriteAccesses(compilationUnit, variable, (IVariableBinding) iBinding);
		else
			return null;
	}

	/**
	 * @param compilationUnit
	 * @param variable a field, a local variable, a parameter
	 * @param iVariableBinding
	 * @return
	 */
	public static List<ASTNode> findWriteAccesses(CompilationUnit compilationUnit, SimpleName variable, IVariableBinding iVariableBinding) {
		OccurrencesFinder occurrencesFinder = new OccurrencesFinder();
		occurrencesFinder.initialize(compilationUnit, variable);
		
		if (iVariableBinding.isField())
			occurrencesFinder.performGlobally();
		else occurrencesFinder.performLocally(getAncestorOfType(variable, ASTNode.METHOD_DECLARATION));
		
		List<ASTNode> result = occurrencesFinder.getWriteUsages();
		for (Iterator<ASTNode> i = result.iterator(); i.hasNext(); ) {
			ASTNode node = i.next();
			switch (node.getParent().getNodeType()) {
			case ASTNode.SINGLE_VARIABLE_DECLARATION:
			case ASTNode.VARIABLE_DECLARATION_FRAGMENT:
				i.remove();
				break;
			}
		}
		return result;
	}

	public static String getFullyQualifiedName(Type type) {
		switch (type.getNodeType()) {
		case ASTNode.SIMPLE_TYPE:
			//try simple way first 
			String returnValue = null;
			// Michal: in forward engineering bindings are null
			ITypeBinding iTypeBinding = type.resolveBinding();
			if (iTypeBinding != null)
				returnValue = iTypeBinding.getQualifiedName();
			if (returnValue == null){
				String name = ((SimpleType) type).getName().getFullyQualifiedName();
				// find appropriate import declaration
				CompilationUnit compilationUnit = (CompilationUnit) type.getRoot();
				
				for (Object importObject : compilationUnit.imports()) {
					ImportDeclaration importDeclaration = (ImportDeclaration) importObject;
					QualifiedName importQualifiedName = (QualifiedName) importDeclaration.getName();
					SimpleName importLastName = importQualifiedName.getName();
					if (importLastName.getIdentifier().equals(name)) {
						returnValue=importQualifiedName.getFullyQualifiedName();
					}
				}
			}
			return returnValue;
		case ASTNode.QUALIFIED_TYPE:
			return ((QualifiedType) type).getName().getFullyQualifiedName();
		}
		return null;
	}
	public static String getFullyQualifiedName(TypeDeclaration typeDeclaration) {
		ITypeBinding iTypeBinding = typeDeclaration.resolveBinding();
		if (iTypeBinding != null)
			return iTypeBinding.getQualifiedName();
		else {
			String className = typeDeclaration.getName().getIdentifier();
			String packageName = ((CompilationUnit) typeDeclaration.getRoot()).getPackage().getName().getFullyQualifiedName();
			
			return packageName != null && !packageName.isEmpty() ? packageName + "." + className : className; 
		}
	}
	public static MethodDeclaration findMethod(IJavaASTManager javaAstManager, String lookupName, String lookupSignature, TypeDeclaration type, boolean includeLocal, boolean includeInherited, IProgressMonitor progressMonitor) {
		String[] lookupParameterNames = Signature.getParameterTypes(lookupSignature);
		String[] lookupParameterSimpleNames = new String[lookupParameterNames.length];
	
		for (int i = 0; i < lookupParameterNames.length; i++) {
			String erasure = Signature.getTypeErasure(lookupParameterNames[i]);
			lookupParameterSimpleNames[i] = Signature.getSimpleName(Signature.toString(erasure));
		}
		
		if (includeLocal) {			
			for (MethodDeclaration method : type.getMethods()) {
				if (method.getName().getIdentifier().equals(lookupName)) {
					// check the signature
					IMethodBinding methodBinding = method.resolveBinding();
					if (methodBinding != null) {
						IMethod iMethod = (IMethod) methodBinding.getJavaElement();
						String key = iMethod.getKey();
						String auxSignature = key.substring(key.indexOf('('));
						auxSignature = auxSignature.replace('/', '.');
						if (auxSignature.equals(lookupSignature))
							return method;
					} else {
						// need to match without the binding...
						int methodParameterCount = method.parameters().size();
						if (methodParameterCount == lookupParameterNames.length) {
							String[] methodParameterNames = new String[lookupParameterNames.length];
							int i = 0;
							for (Object aux : method.parameters()) {
								SingleVariableDeclaration parameter = (SingleVariableDeclaration) aux;
								methodParameterNames[i] = Util.getSignature(parameter.getType());
							}
							if (CodeQueries.areSimilarMethods(lookupName, lookupParameterNames, lookupName, methodParameterNames, lookupParameterSimpleNames))
								return method;
						}
					}
				}	
			}
		}
		if (includeInherited) {
			// look in supertype
			IType superIType = (IType) type.getSuperclassType().resolveBinding().getJavaElement();
			CompilationUnit cu = javaAstManager.getCompilationUnit(superIType);
			TypeDeclaration superType = null;
			try {
				superType = ASTNodeSearchUtil.getTypeDeclarationNode(superIType, cu);
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
			if (superType != null)
				return findMethod(javaAstManager, lookupName, lookupSignature, superType, true, includeInherited, progressMonitor);
		}
		return null;
	}

	public static String getStmtLocationInMethod(ASTNode node) {
		ASTNode currentNode = node;
		Statement stmt=null;
		while (!(currentNode instanceof Statement)) {
			currentNode=currentNode.getParent();
		}
		stmt=(Statement)currentNode;
		Block block=null;
		while (currentNode.getNodeType()!= ASTNode.METHOD_DECLARATION) {
			currentNode=currentNode.getParent();
			if (currentNode instanceof IfStatement) {
				return "middle";
			}
			if (currentNode instanceof Block) {
				block = (Block)currentNode;
			}
		}
		if (block.statements().size()==1 && block.statements().get(0).equals(stmt)){
			return "single";
		} else if (block.statements().get(0).equals(stmt)) {
			return "start";
		} else if (block.statements().get(block.statements().size()-1).equals(stmt)) {
			return "end";
		} else {
			return "middle";
		}
	}

	public static List<VariableDeclarationFragment> getFieldsTypedWithType(TypeDeclaration typeDeclaration, String fullyQualifiedName, IIncrementalTypeHierarchy typeHierarchy, IProgressMonitor progressMonitor) {
		List<VariableDeclarationFragment> fields = new ArrayList<VariableDeclarationFragment>();
		
		for (FieldDeclaration field : typeDeclaration.getFields()) {
			for (Object auxFragment : field.fragments()) {
				VariableDeclarationFragment variableDeclarationFragment = (VariableDeclarationFragment) auxFragment;
				ITypeBinding iTypeBinding = variableDeclarationFragment.resolveBinding().getType();
				if (fullyQualifiedName.equals(iTypeBinding.getQualifiedName()))
					fields.add(variableDeclarationFragment);
				else {
					// maybe the type is a subtype?
					try {
						IType iType = (IType) iTypeBinding.getJavaElement();
						if (typeHierarchy.implementsOrExtendsType(iType, fullyQualifiedName))
							fields.add(variableDeclarationFragment);
					} catch (JavaModelException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return fields;
	}

	public static List<VariableDeclarationFragment> getFieldsAnnotatedWithType(TypeDeclaration typeDeclaration, String fullyQualifiedName, IProgressMonitor progressMonitor) {
		List<VariableDeclarationFragment> fields = new ArrayList<VariableDeclarationFragment>();
		
		for (FieldDeclaration field : typeDeclaration.getFields()) {
			for (Object modifier : field.modifiers()) {
				if (modifier instanceof Annotation){
					Annotation annot = (Annotation) modifier;
					if (annot.resolveTypeBinding().getQualifiedName().equalsIgnoreCase(fullyQualifiedName)){
						for (Object auxFragment : field.fragments()) {
							VariableDeclarationFragment variableDeclarationFragment = (VariableDeclarationFragment) auxFragment;
							fields.add(variableDeclarationFragment);
						}
					}
				}
			}
		}
		return fields;
	}
	public static List<MethodDeclaration> getMethodsAnnotatedWithType(TypeDeclaration typeDeclaration, String fullyQualifiedName, IProgressMonitor progressMonitor) {
		List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
		
		for (MethodDeclaration method : typeDeclaration.getMethods()) {
			for (Object modifier : method.modifiers()) {
				if (modifier instanceof Annotation){
					Annotation annot = (Annotation) modifier;
					if (annot.resolveTypeBinding().getQualifiedName().equalsIgnoreCase(fullyQualifiedName))
						methods.add(method);
				}
			}
		}
		return methods;
	}
	/** 
	 * @param expression
	 * @return true iff the expression 1) is a literal, 2) static final (both array and non-array) variable, 3) enum literal
	 */
	public static boolean hasStaticValue(Expression expression) {
		if (ASTUtils.getStringValue(expression) != null)
			// the expression is a literal
			return true;
		
		if (expression.resolveConstantExpressionValue() != null)
			// the expression is a non-array static final variable or enum literal
			return true;
		switch (expression.getNodeType()) {
		case ASTNode.SIMPLE_NAME:
			SimpleName simpleName = (SimpleName) expression;
			IBinding iBinding = simpleName.resolveBinding();
			if (iBinding instanceof IVariableBinding) {
				IVariableBinding iVariableBinding = (IVariableBinding) iBinding;
				if (Modifier.isStatic(iVariableBinding.getModifiers()) && 
					Modifier.isFinal(iVariableBinding.getModifiers()) && 
					iVariableBinding.getType().isArray())
					// static final array
					return true;
			}
			break;
		case ASTNode.ARRAY_CREATION:
		case ASTNode.ARRAY_INITIALIZER:
			return true;
		}
		return false;
	}
	/**
	 * @param javaAstManager
	 * @param simpleName variable use or declaration.
	 * @return variable declaration: VariableDeclarationFragment for local variables or fields, SingleVariableDeclaration for parameters.
	 */
	public static ASTNode getVariableDeclarationNode(IJavaASTManager javaAstManager, SimpleName simpleName) {
		IBinding iBinding = simpleName.resolveBinding();
		if (iBinding instanceof IVariableBinding) {
			IVariableBinding iVariableBinding = (IVariableBinding) iBinding;
			IVariableBinding iVariableDeclarationBinding = iVariableBinding.getVariableDeclaration();
			
			CompilationUnit variableCompilationUnit = null;
			if (iVariableBinding.isField()) {
				IJavaElement iJavaElement = iVariableDeclarationBinding.getJavaElement();
				variableCompilationUnit = javaAstManager.getCompilationUnit(iJavaElement);
					
				if (variableCompilationUnit != null)
					return getVariableDeclarationFragmentNode(iVariableDeclarationBinding, variableCompilationUnit);
			}
			else {
				variableCompilationUnit = (CompilationUnit) simpleName.getRoot();
				ASTNode result = variableCompilationUnit.findDeclaringNode(iVariableDeclarationBinding);
				return result;
			}
		}
		return null;
	}
	public static boolean isStaticFinalField(IVariableBinding iVariableBinding) {
		return iVariableBinding.isField() && 
		 	Modifier.isStatic(iVariableBinding.getModifiers()) && 
		 	Modifier.isFinal(iVariableBinding.getModifiers());
	}
	public static boolean isStaticFinalArrayField(IVariableBinding iVariableBinding) {
		return iVariableBinding.isField() && 
		 	Modifier.isStatic(iVariableBinding.getModifiers()) && 
		 	Modifier.isFinal(iVariableBinding.getModifiers()) && 
		 	iVariableBinding.getType().isArray();
	}
}
