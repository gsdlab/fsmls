/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Michal Antkiewicz - extensions
 *******************************************************************************/
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.PrefixExpression.Operator;
import org.eclipse.jdt.internal.corext.dom.ASTNodes;
import org.eclipse.jdt.internal.corext.dom.Bindings;
import org.eclipse.jdt.internal.corext.dom.NodeFinder;
import org.eclipse.jdt.internal.ui.search.IOccurrencesFinder;
import org.eclipse.jdt.internal.ui.search.SearchMessages;

public class OccurrencesFinder extends ASTVisitor implements IOccurrencesFinder {
	
	public static final String ID= "OccurrencesFinder"; //$NON-NLS-1$
	
	public static final String IS_WRITEACCESS= "writeAccess"; //$NON-NLS-1$
	public static final String IS_VARIABLE= "variable"; //$NON-NLS-1$
	
	private CompilationUnit fRoot;
	private Name fSelectedNode;
	private IBinding fTarget;
	private List<ASTNode> fUsages= new ArrayList<ASTNode>();
	
	public List<ASTNode> getAllUsages() {
		return fUsages;
	}
	
	private List<ASTNode> fWriteUsages= new ArrayList<ASTNode>();
	public List<ASTNode> getWriteUsages() {
		return fWriteUsages;
	}
	private boolean fTargetIsStaticMethodImport;

	public OccurrencesFinder(IBinding target) {
		super(true);
		fTarget= target;
	}
	
	public OccurrencesFinder() {
		super(true);
	}
	
	public String initialize(CompilationUnit root, int offset, int length) {
		return initialize(root, NodeFinder.perform(root, offset, length));
	}
	
	public String initialize(CompilationUnit root, ASTNode node) {
		if (!(node instanceof Name))
			return SearchMessages.OccurrencesFinder_no_element; 
		fRoot= root;
		fSelectedNode= (Name)node;
		fTarget= fSelectedNode.resolveBinding();
		if (fTarget == null)
			return SearchMessages.OccurrencesFinder_no_binding; 
		fTarget= getBindingDeclaration(fTarget);
		
		fTargetIsStaticMethodImport= isStaticImport(fSelectedNode.getParent());
		return null;
	}
	
	/**
	 * @return list of matches in the entire compilation unit (@see initialize).
	 */
	public List<ASTNode> performGlobally() {
		fRoot.accept(this);
		return fUsages;
	}
	public List perform() {
		return performGlobally();
	}
	/**
	 * @return list of matches in the body of the provided @param methodDeclaration.
	 */
	public List<ASTNode> performLocally(ASTNode scope) {
		if (scope != null)
			scope.accept(this);
		else
			performGlobally();
		return fUsages;
	}
	
	/*
	 * @see org.eclipse.jdt.internal.ui.search.IOccurrencesFinder#getJobLabel()
	 */
	public String getJobLabel() {
		return SearchMessages.OccurrencesFinder_searchfor ; 
	}
	
	public String getElementName() {
		if (fSelectedNode != null) {
			return ASTNodes.asString(fSelectedNode);
		}
		return null;
	}
	
	public String getUnformattedPluralLabel() {
		return SearchMessages.OccurrencesFinder_label_plural;
	}
	
	public String getUnformattedSingularLabel() {
		return SearchMessages.OccurrencesFinder_label_singular;
	}
	
	public boolean visit(QualifiedName node) {
		final IBinding binding= node.resolveBinding();
		if (binding instanceof IVariableBinding && ((IVariableBinding)binding).isField()) {
			SimpleName name= node.getName();
			return !match(name, fUsages, name.resolveBinding());
		}
		if (binding instanceof IMethodBinding) {
			if (isStaticImport(node)) {
				SimpleName name= node.getName();
				return !matchStaticImport(name, fUsages, (IMethodBinding)binding);
			}
		}
		return !match(node, fUsages, binding);
	}
	
	private static boolean isStaticImport(ASTNode node) {
		if (!(node instanceof QualifiedName))
			return false;
		
		ASTNode parent= ((QualifiedName)node).getParent();
		return parent  instanceof ImportDeclaration && ((ImportDeclaration)parent).isStatic();
	}

	public boolean visit(MethodInvocation node) {
		if (fTargetIsStaticMethodImport)
			return !matchStaticImport(node.getName(), fUsages, node.resolveMethodBinding());
		
		return true;
	}
	
	public boolean visit(SimpleName node) {
		return !match(node, fUsages, node.resolveBinding());
	}

	/*
	 * @see org.eclipse.jdt.core.dom.ASTVisitor#visit(org.eclipse.jdt.core.dom.ConstructorInvocation)
	 */
	public boolean visit(ClassInstanceCreation node) {
		// match with the constructor and the type.
		Type type= node.getType();
		if (type instanceof ParameterizedType) {
			type= ((ParameterizedType) type).getType();
		}
		if (type instanceof SimpleType) {
			Name name= ((SimpleType) type).getName();
			if (name instanceof QualifiedName)
				name= ((QualifiedName)name).getName();
			match(name, fUsages, node.resolveConstructorBinding());
		}
		return super.visit(node);
	}
	
	public boolean visit(Assignment node) {
		Expression lhs= node.getLeftHandSide();
		SimpleName name= getSimpleName(lhs);
		if (name != null) 
			match(name, fWriteUsages, name.resolveBinding());	
		lhs.accept(this);
		node.getRightHandSide().accept(this);
		return false;
	}
	
	public boolean visit(SingleVariableDeclaration node) {
		match(node.getName(), fWriteUsages, node.resolveBinding());
		return super.visit(node);
	}
	
	public boolean visit(VariableDeclarationFragment node) {
		if (node.getParent().getNodeType() == ASTNode.FIELD_DECLARATION || node.getInitializer() != null)
			match(node.getName(), fWriteUsages, node.resolveBinding());
		return super.visit(node);
	}

	public boolean visit(PrefixExpression node) {
		PrefixExpression.Operator operator= node.getOperator();	
		if (operator == Operator.INCREMENT || operator == Operator.DECREMENT) {
			Expression operand= node.getOperand();
			SimpleName name= getSimpleName(operand);
			if (name != null) 
				match(name, fWriteUsages, name.resolveBinding());				
		}
		return super.visit(node);
	}

	public boolean visit(PostfixExpression node) {
		Expression operand= node.getOperand();
		SimpleName name= getSimpleName(operand);
		if (name != null) 
			match(name, fWriteUsages, name.resolveBinding());
		return super.visit(node);
	}
	
	private boolean match(Name node, List result, IBinding binding) {
		if (binding != null && Bindings.equals(getBindingDeclaration(binding), fTarget)) {
			result.add(node);
			return true;
		}
		return false;
	}
	
	private boolean matchStaticImport(Name node, List result, IMethodBinding binding) {
		if (binding == null || node == null || !(fTarget instanceof IMethodBinding) || !Modifier.isStatic(binding.getModifiers()))
			return false;
		
		IMethodBinding targetMethodBinding= (IMethodBinding)fTarget;
		if ((fTargetIsStaticMethodImport || Modifier.isStatic(targetMethodBinding.getModifiers())) && (targetMethodBinding.getDeclaringClass().getTypeDeclaration() == binding.getDeclaringClass().getTypeDeclaration())) {
			if (node.getFullyQualifiedName().equals(targetMethodBinding.getName())) {
				result.add(node);
				return true;
			}
		}
		return false;
	}

	private SimpleName getSimpleName(Expression expression) {
		if (expression instanceof SimpleName)
			return ((SimpleName)expression);
		else if (expression instanceof QualifiedName)
			return (((QualifiedName) expression).getName());
		else if (expression instanceof FieldAccess)
			return ((FieldAccess)expression).getName();
		return null;
	}
	
	private IBinding getBindingDeclaration(IBinding binding) {
		switch (binding.getKind()) {
			case IBinding.TYPE :
				return ((ITypeBinding)binding).getTypeDeclaration();
			case IBinding.METHOD :
				return ((IMethodBinding)binding).getMethodDeclaration();
			case IBinding.VARIABLE :
				return ((IVariableBinding)binding).getVariableDeclaration();
			default:
				return binding;
		}
	}
	
	public int getSearchKind() {
		return K_OCCURRENCE;
	}
	
	public String getID() {
		return ID;
	}
	public CompilationUnit getASTRoot() {
		return fRoot;
	}
	
	public OccurrenceLocation[] getOccurrences() {
		return null;
	}
}
