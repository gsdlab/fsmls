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

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.AssertStatement;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.BreakStatement;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.EmptyStatement;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.Initializer;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LabeledStatement;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.MethodRef;
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.SwitchCase;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.WildcardType;

/**
 * Simpler visitor pattern for JDT AST nodes. 
 * This is a generated class (see ASTVisitorGen)
 */
public class JDTVisitor
{
	public void visitASTNode(ASTNode node) {
		switch(node.getNodeType()) {
			case ASTNode.ANONYMOUS_CLASS_DECLARATION:
				visit((AnonymousClassDeclaration)node);
				break;
			case ASTNode.ARRAY_ACCESS:
				visit((ArrayAccess)node);
				break;
			case ASTNode.ARRAY_CREATION:
				visit((ArrayCreation)node);
				break;
			case ASTNode.ARRAY_INITIALIZER:
				visit((ArrayInitializer)node);
				break;
			case ASTNode.ARRAY_TYPE:
				visit((ArrayType)node);
				break;
			case ASTNode.ASSERT_STATEMENT:
				visit((AssertStatement)node);
				break;
			case ASTNode.ASSIGNMENT:
				visit((Assignment)node);
				break;
			case ASTNode.BLOCK:
				visit((Block)node);
				break;
			case ASTNode.BOOLEAN_LITERAL:
				visit((BooleanLiteral)node);
				break;
			case ASTNode.BREAK_STATEMENT:
				visit((BreakStatement)node);
				break;
			case ASTNode.CAST_EXPRESSION:
				visit((CastExpression)node);
				break;
			case ASTNode.CATCH_CLAUSE:
				visit((CatchClause)node);
				break;
			case ASTNode.CHARACTER_LITERAL:
				visit((CharacterLiteral)node);
				break;
			case ASTNode.CLASS_INSTANCE_CREATION:
				visit((ClassInstanceCreation)node);
				break;
			case ASTNode.COMPILATION_UNIT:
				visit((CompilationUnit)node);
				break;
			case ASTNode.CONDITIONAL_EXPRESSION:
				visit((ConditionalExpression)node);
				break;
			case ASTNode.CONSTRUCTOR_INVOCATION:
				visit((ConstructorInvocation)node);
				break;
			case ASTNode.CONTINUE_STATEMENT:
				visit((ContinueStatement)node);
				break;
			case ASTNode.DO_STATEMENT:
				visit((DoStatement)node);
				break;
			case ASTNode.EMPTY_STATEMENT:
				visit((EmptyStatement)node);
				break;
			case ASTNode.EXPRESSION_STATEMENT:
				visit((ExpressionStatement)node);
				break;
			case ASTNode.FIELD_ACCESS:
				visit((FieldAccess)node);
				break;
			case ASTNode.FIELD_DECLARATION:
				visit((FieldDeclaration)node);
				break;
			case ASTNode.FOR_STATEMENT:
				visit((ForStatement)node);
				break;
			case ASTNode.IF_STATEMENT:
				visit((IfStatement)node);
				break;
			case ASTNode.IMPORT_DECLARATION:
				visit((ImportDeclaration)node);
				break;
			case ASTNode.INFIX_EXPRESSION:
				visit((InfixExpression)node);
				break;
			case ASTNode.INITIALIZER:
				visit((Initializer)node);
				break;
			case ASTNode.JAVADOC:
				visit((Javadoc)node);
				break;
			case ASTNode.LABELED_STATEMENT:
				visit((LabeledStatement)node);
				break;
			case ASTNode.METHOD_DECLARATION:
				visit((MethodDeclaration)node);
				break;
			case ASTNode.METHOD_INVOCATION:
				visit((MethodInvocation)node);
				break;
			case ASTNode.NULL_LITERAL:
				visit((NullLiteral)node);
				break;
			case ASTNode.NUMBER_LITERAL:
				visit((NumberLiteral)node);
				break;
			case ASTNode.PACKAGE_DECLARATION:
				visit((PackageDeclaration)node);
				break;
			case ASTNode.PARENTHESIZED_EXPRESSION:
				visit((ParenthesizedExpression)node);
				break;
			case ASTNode.POSTFIX_EXPRESSION:
				visit((PostfixExpression)node);
				break;
			case ASTNode.PREFIX_EXPRESSION:
				visit((PrefixExpression)node);
				break;
			case ASTNode.PRIMITIVE_TYPE:
				visit((PrimitiveType)node);
				break;
			case ASTNode.QUALIFIED_NAME:
				visit((QualifiedName)node);
				break;
			case ASTNode.RETURN_STATEMENT:
				visit((ReturnStatement)node);
				break;
			case ASTNode.SIMPLE_NAME:
				visit((SimpleName)node);
				break;
			case ASTNode.SIMPLE_TYPE:
				visit((SimpleType)node);
				break;
			case ASTNode.SINGLE_VARIABLE_DECLARATION:
				visit((SingleVariableDeclaration)node);
				break;
			case ASTNode.STRING_LITERAL:
				visit((StringLiteral)node);
				break;
			case ASTNode.SUPER_CONSTRUCTOR_INVOCATION:
				visit((SuperConstructorInvocation)node);
				break;
			case ASTNode.SUPER_FIELD_ACCESS:
				visit((SuperFieldAccess)node);
				break;
			case ASTNode.SUPER_METHOD_INVOCATION:
				visit((SuperMethodInvocation)node);
				break;
			case ASTNode.SWITCH_CASE:
				visit((SwitchCase)node);
				break;
			case ASTNode.SWITCH_STATEMENT:
				visit((SwitchStatement)node);
				break;
			case ASTNode.SYNCHRONIZED_STATEMENT:
				visit((SynchronizedStatement)node);
				break;
			case ASTNode.THIS_EXPRESSION:
				visit((ThisExpression)node);
				break;
			case ASTNode.THROW_STATEMENT:
				visit((ThrowStatement)node);
				break;
			case ASTNode.TRY_STATEMENT:
				visit((TryStatement)node);
				break;
			case ASTNode.TYPE_DECLARATION:
				visit((TypeDeclaration)node);
				break;
			case ASTNode.TYPE_DECLARATION_STATEMENT:
				visit((TypeDeclarationStatement)node);
				break;
			case ASTNode.TYPE_LITERAL:
				visit((TypeLiteral)node);
				break;
			case ASTNode.VARIABLE_DECLARATION_EXPRESSION:
				visit((VariableDeclarationExpression)node);
				break;
			case ASTNode.VARIABLE_DECLARATION_FRAGMENT:
				visit((VariableDeclarationFragment)node);
				break;
			case ASTNode.VARIABLE_DECLARATION_STATEMENT:
				visit((VariableDeclarationStatement)node);
				break;
			case ASTNode.WHILE_STATEMENT:
				visit((WhileStatement)node);
				break;
			case ASTNode.INSTANCEOF_EXPRESSION:
				visit((InstanceofExpression)node);
				break;
			case ASTNode.LINE_COMMENT:
				visit((LineComment)node);
				break;
			case ASTNode.BLOCK_COMMENT:
				visit((BlockComment)node);
				break;
			case ASTNode.TAG_ELEMENT:
				visit((TagElement)node);
				break;
			case ASTNode.TEXT_ELEMENT:
				visit((TextElement)node);
				break;
			case ASTNode.MEMBER_REF:
				visit((MemberRef)node);
				break;
			case ASTNode.METHOD_REF:
				visit((MethodRef)node);
				break;
			case ASTNode.METHOD_REF_PARAMETER:
				visit((MethodRefParameter)node);
				break;
			case ASTNode.ENHANCED_FOR_STATEMENT:
				visit((EnhancedForStatement)node);
				break;
			case ASTNode.ENUM_DECLARATION:
				visit((EnumDeclaration)node);
				break;
			case ASTNode.ENUM_CONSTANT_DECLARATION:
				visit((EnumConstantDeclaration)node);
				break;
			case ASTNode.TYPE_PARAMETER:
				visit((TypeParameter)node);
				break;
			case ASTNode.PARAMETERIZED_TYPE:
				visit((ParameterizedType)node);
				break;
			case ASTNode.QUALIFIED_TYPE:
				visit((QualifiedType)node);
				break;
			case ASTNode.WILDCARD_TYPE:
				visit((WildcardType)node);
				break;
			case ASTNode.NORMAL_ANNOTATION:
				visit((NormalAnnotation)node);
				break;
			case ASTNode.MARKER_ANNOTATION:
				visit((MarkerAnnotation)node);
				break;
			case ASTNode.SINGLE_MEMBER_ANNOTATION:
				visit((SingleMemberAnnotation)node);
				break;
			case ASTNode.MEMBER_VALUE_PAIR:
				visit((MemberValuePair)node);
				break;
			case ASTNode.ANNOTATION_TYPE_DECLARATION:
				visit((AnnotationTypeDeclaration)node);
				break;
			case ASTNode.ANNOTATION_TYPE_MEMBER_DECLARATION:
				visit((AnnotationTypeMemberDeclaration)node);
				break;
			case ASTNode.MODIFIER:
				visit((Modifier)node);
				break;
		}
	}

	public void visit(AnonymousClassDeclaration node) {}
	public void visit(ArrayAccess node) {}
	public void visit(ArrayCreation node) {}
	public void visit(ArrayInitializer node) {}
	public void visit(ArrayType node) {}
	public void visit(AssertStatement node) {}
	public void visit(Assignment node) {}
	public void visit(Block node) {}
	public void visit(BooleanLiteral node) {}
	public void visit(BreakStatement node) {}
	public void visit(CastExpression node) {}
	public void visit(CatchClause node) {}
	public void visit(CharacterLiteral node) {}
	public void visit(ClassInstanceCreation node) {}
	public void visit(CompilationUnit node) {}
	public void visit(ConditionalExpression node) {}
	public void visit(ConstructorInvocation node) {}
	public void visit(ContinueStatement node) {}
	public void visit(DoStatement node) {}
	public void visit(EmptyStatement node) {}
	public void visit(ExpressionStatement node) {}
	public void visit(FieldAccess node) {}
	public void visit(FieldDeclaration node) {}
	public void visit(ForStatement node) {}
	public void visit(IfStatement node) {}
	public void visit(ImportDeclaration node) {}
	public void visit(InfixExpression node) {}
	public void visit(Initializer node) {}
	public void visit(Javadoc node) {}
	public void visit(LabeledStatement node) {}
	public void visit(MethodDeclaration node) {}
	public void visit(MethodInvocation node) {}
	public void visit(NullLiteral node) {}
	public void visit(NumberLiteral node) {}
	public void visit(PackageDeclaration node) {}
	public void visit(ParenthesizedExpression node) {}
	public void visit(PostfixExpression node) {}
	public void visit(PrefixExpression node) {}
	public void visit(PrimitiveType node) {}
	public void visit(QualifiedName node) {}
	public void visit(ReturnStatement node) {}
	public void visit(SimpleName node) {}
	public void visit(SimpleType node) {}
	public void visit(SingleVariableDeclaration node) {}
	public void visit(StringLiteral node) {}
	public void visit(SuperConstructorInvocation node) {}
	public void visit(SuperFieldAccess node) {}
	public void visit(SuperMethodInvocation node) {}
	public void visit(SwitchCase node) {}
	public void visit(SwitchStatement node) {}
	public void visit(SynchronizedStatement node) {}
	public void visit(ThisExpression node) {}
	public void visit(ThrowStatement node) {}
	public void visit(TryStatement node) {}
	public void visit(TypeDeclaration node) {}
	public void visit(TypeDeclarationStatement node) {}
	public void visit(TypeLiteral node) {}
	public void visit(VariableDeclarationExpression node) {}
	public void visit(VariableDeclarationFragment node) {}
	public void visit(VariableDeclarationStatement node) {}
	public void visit(WhileStatement node) {}
	public void visit(InstanceofExpression node) {}
	public void visit(LineComment node) {}
	public void visit(BlockComment node) {}
	public void visit(TagElement node) {}
	public void visit(TextElement node) {}
	public void visit(MemberRef node) {}
	public void visit(MethodRef node) {}
	public void visit(MethodRefParameter node) {}
	public void visit(EnhancedForStatement node) {}
	public void visit(EnumDeclaration node) {}
	public void visit(EnumConstantDeclaration node) {}
	public void visit(TypeParameter node) {}
	public void visit(ParameterizedType node) {}
	public void visit(QualifiedType node) {}
	public void visit(WildcardType node) {}
	public void visit(NormalAnnotation node) {}
	public void visit(MarkerAnnotation node) {}
	public void visit(SingleMemberAnnotation node) {}
	public void visit(MemberValuePair node) {}
	public void visit(AnnotationTypeDeclaration node) {}
	public void visit(AnnotationTypeMemberDeclaration node) {}
	public void visit(Modifier node) {}
}
