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
import org.eclipse.jdt.core.dom.BodyDeclaration;
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
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
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
import org.eclipse.jdt.core.dom.Statement;
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
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.TypeParameter;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.WildcardType;



class StackEntry {
	public final ASTNode node;
	public ASTNode nearestChild;
	public final List<VarDesc> vars;
	public StackEntry(ASTNode node) {
		this.node=node;
		vars=new ArrayList<VarDesc>();
	}
	public String toString() {
		return node.getClass().getSimpleName()+" ["+vars.size()+"]";
	}
}



public class VarCollector extends JDTVisitor 
{
	private String fSource;
	private int fOffset; 
//	private CumulativeProgressMonitor fMonitor;
	private int level;
	private final List<StackEntry> stack;
	
	public VarCollector() {
		this.stack=new ArrayList<StackEntry>();
		level=0;
	}
	public void collect(CompilationUnit cu, String source, int offset) {
		this.fOffset=offset;
		this.fSource=source;
//		fMonitor=new CumulativeProgressMonitor(monitor);
//		fMonitor.beginTask("", offset);
		expand(list(cu),true);
//		fMonitor.done();
	}
	public void printStack() {
		for(StackEntry entry: stack) {
			System.out.println(">>"+entry.node.getClass().getSimpleName());
			for(VarDesc var: entry.vars)
				System.out.println("++"+var.type+" "+var.name);
		}
	}
	public boolean isInsideMethod() {
		if(stack.isEmpty()) return false;
		for(int i=stack.size()-1;i>=0;i--) {
			ASTNode node = stack.get(i).node;
			switch(node.getNodeType()) {
				case ASTNode.METHOD_DECLARATION:
					if(!nodeContainsOffset(node, fOffset))
						return false;
					return true;
				case ASTNode.TYPE_DECLARATION:
				case ASTNode.ENUM_DECLARATION:
					return false;
			}
		}
		return false;
	}
	public VarDesc getExpectedType() {
		if(fSource==null) return null;
		if(stack.isEmpty()) return null;
		/*
		 * Assignment "=": VariableDeclarationFragment, Assignment, SingleVariableDeclaration??
		 * Call "(", ",": ClassInstanceCreation, ConstructorInvocation, MethodInvocation, SuperConstructorInvocation, SuperMethodInvocation
		 * Return "return": ReturnStatement
		 * Array Init "{", ",": ArrayInitializer
		 * Ternary "?", ":": ConditionalExpression
		 */
		int pos=fOffset-1;
		while(pos>=0 && Character.isWhitespace(fSource.charAt(pos))) pos--;
		if(pos<0) return null;
		char marker=fSource.charAt(pos);
		if(marker=='=') { //probably assignment
			//rewind further to finid the var name; the "=" will not be part of the AST when the assignment is incomplete
			pos--; while(pos>=0 && Character.isWhitespace(fSource.charAt(pos))) pos--;
			if(pos<0) return null;
			ASTNode assigner=lastNodeContaining(pos);
			if(assigner==null) return null;
			if(assigner.getNodeType()==ASTNode.VARIABLE_DECLARATION_FRAGMENT) {
				return makeDesc((VariableDeclarationFragment) assigner);
			} else if(assigner.getNodeType()==ASTNode.ASSIGNMENT) {
				ITypeBinding type=((Assignment)assigner).resolveTypeBinding();
				return makeDesc(type);
			}
		} else if(marker=='(') { //probably call
			ASTNode callNode=lastNodeContaining(pos);
			if(callNode==null) return null;
			return getParameterType(callNode, 0);
		} else if(marker=='{') { //possibly array init
			ASTNode initNode=lastNodeContaining(pos);
			if(initNode==null) return null;
			return getArrayInitType(initNode);
		} else if(marker==',') { //may be call or array init
			//walk back to try and find an opening brace, counting the numbr of commas
			int idx=0;
			int bscope=0, cscope=0;
			while(pos>=0) {
				marker=fSource.charAt(pos);
				if(marker=='(') {
					if(cscope==0) {
						if(bscope==0) break;
						bscope--;
					}
				} else if(marker==')') {
					if(cscope==0) bscope++;
				} else if(marker=='{') {
					if(bscope==0) {
						if(cscope==0) break;
						cscope--;
					}
				} else if(marker=='}') {
					if(bscope==0) cscope++;
				} else if(marker==',') {
					if(bscope==0 && cscope==0) idx++;
				}
				pos--;
			}
			if(pos<0) return null;
			ASTNode node=lastNodeContaining(pos);
			if(node==null) return null;
			if(marker=='(')
				return getParameterType(node, idx);
			else if(marker=='{')
				return getArrayInitType(node);
		} else if(marker=='n') { //"return"?
			if(pos<5) return null;
			if(!fSource.regionMatches(pos-5, "return", 0, 6)) return null;
			ASTNode method=lastNodeOfType(ASTNode.METHOD_DECLARATION);
			if(!(method instanceof MethodDeclaration)) return null;
			IMethodBinding methodBinding = ((MethodDeclaration)method).resolveBinding();
			if(methodBinding==null) return null;
			return makeDesc(methodBinding.getReturnType());
		}
		return null;
	}
	private VarDesc getArrayInitType(ASTNode initNode) {
		if(initNode.getNodeType()==ASTNode.ARRAY_INITIALIZER) {
			ITypeBinding binding=((ArrayInitializer)initNode).resolveTypeBinding();
			if(binding==null) return null;
			//the binding represents an array type, so peel off one dimension
			return makeDesc(binding.getComponentType());
		}
		return null;
	}
	private VarDesc getParameterType(ASTNode callNode, int argId) {
		IMethodBinding binding=null;
		if(callNode.getNodeType()==ASTNode.METHOD_INVOCATION) {
			binding = ((MethodInvocation)callNode).resolveMethodBinding();
		} else if(callNode.getNodeType()==ASTNode.CLASS_INSTANCE_CREATION) {
			binding = ((ClassInstanceCreation)callNode).resolveConstructorBinding();
		} else if(callNode.getNodeType()==ASTNode.CONSTRUCTOR_INVOCATION) {
			binding = ((ConstructorInvocation)callNode).resolveConstructorBinding();
		} else if(callNode.getNodeType()==ASTNode.SUPER_CONSTRUCTOR_INVOCATION) {
			binding = ((SuperConstructorInvocation)callNode).resolveConstructorBinding();
		} else if(callNode.getNodeType()==ASTNode.SUPER_METHOD_INVOCATION) {
			binding = ((SuperMethodInvocation)callNode).resolveMethodBinding();
		}
		if(binding==null) return null;
		ITypeBinding[] params = binding.getParameterTypes();
		if(argId>=params.length) return null;
		return makeDesc(params[argId]);
	}
	public ASTNode getLastContainingStatement() {
		if(stack.isEmpty()) return null;
		for(int i=stack.size()-1;i>=0;i--) {
			ASTNode node=stack.get(i).node;
			if(node instanceof Statement) {
				if(node.getNodeType()==ASTNode.BLOCK) return null;
				if(statementIsComplete(node) && !nodeContainsOffset(node, fOffset)) return null;
				return node;
			}
		}
		return null;
	}
	private ASTNode getLastNode() {
		if(stack.isEmpty()) return null;
		return stack.get(stack.size()-1).node;
	}
	public int getNewDeclarationOffset() {
		if(stack.size()<2) return -1;
		ASTNode lastNonBlock=getLastNode();
		if(lastNonBlock.getNodeType()==ASTNode.BLOCK) return fOffset;
		for(int i=stack.size()-2;i>=0;i--) {
			ASTNode node=stack.get(i).node;
			if(node.getNodeType()==ASTNode.BLOCK) {
				if(lastNonBlock==null) return -1;
				return lastNonBlock.getStartPosition();
			}
			lastNonBlock=node;
		}
		return -1;
	}
	public int getNewMethodOffset() {
		if(stack.size()<2) return -1;
		//first just try to find the method we're in and report its end
		for(int i=stack.size()-1;i>=0;i--) {
			ASTNode node=stack.get(i).node;
			if(node.getNodeType()==ASTNode.METHOD_DECLARATION) {
				return node.getStartPosition()+node.getLength()-1;
			}
		}
		//failing that, try to find a containing type declaration
		for(int i=stack.size()-1;i>=0;i--) {
			ASTNode node=stack.get(i).node;
			List<BodyDeclaration> declarations=null;
			if(node.getNodeType()==ASTNode.TYPE_DECLARATION) {
				declarations=((TypeDeclaration)node).bodyDeclarations();
			} else if(node.getNodeType()==ASTNode.ANONYMOUS_CLASS_DECLARATION) {
				declarations=((AnonymousClassDeclaration)node).bodyDeclarations();
			}
			//then pick the first body declaration that gets past our offset (or simply the last if all come before)
			if(declarations!=null && !declarations.isEmpty()) {
				BodyDeclaration last=null;
				for(BodyDeclaration decl: declarations) {
					last=decl;
					if(decl.getStartPosition()+decl.getLength()>=fOffset)
						break;
				}
				if(last!=null)
					return last.getStartPosition()+last.getLength()-1;
			}
		}
		return -1;
	}
	public List<VarDesc> getDeclarations() {
		List<VarDesc> vars=new ArrayList<VarDesc>();
		boolean doLocals=true;
		boolean doMemberFields=true;
		boolean inLastType=true;
		for(int i=stack.size()-1;i>=0;i--) {
			StackEntry entry = stack.get(i);
			for(int j=entry.vars.size()-1;j>=0;j--) {
				VarDesc desc=entry.vars.get(j);
				switch(desc.kind) {
					case VarDesc.LOCAL:
						if(doLocals)
							vars.add(desc);
						break;
					case VarDesc.MEMBER:
						if(doMemberFields)
							vars.add(desc);
						break;
					case VarDesc.STATIC:
						vars.add(desc);
						break;
				}
			}
			ASTNode node=entry.node;
			switch(node.getNodeType()) {
				case ASTNode.METHOD_DECLARATION: {
					doLocals=false;
					break;
				}
				case ASTNode.ANONYMOUS_CLASS_DECLARATION: {
					if(inLastType) {
						AnonymousClassDeclaration decl=(AnonymousClassDeclaration) node;
						if(decl.getParent().getNodeType()==ASTNode.CLASS_INSTANCE_CREATION) {
							ClassInstanceCreation cic=(ClassInstanceCreation) decl.getParent();
							vars.add(makeDesc(cic.getType(),0,VarDesc.SPECIAL,"this"));
						}
					}
					doLocals=false;
					inLastType=false;
					break;
				}
				case ASTNode.TYPE_DECLARATION: {
					TypeDeclaration decl=(TypeDeclaration) node;
					if(inLastType || doMemberFields) {
						Type type=null;
						type=decl.getSuperclassType();
						if(type==null && !decl.superInterfaceTypes().isEmpty()) {
							type=((List<Type>)decl.superInterfaceTypes()).get(0);
						}
						if(type!=null) {
							if(inLastType) {
								vars.add(makeDesc(type,0,VarDesc.SPECIAL,"this"));
							} else if(doMemberFields) {
								vars.add(makeDesc(type,0,VarDesc.SPECIAL,decl.getName().getIdentifier()+".this"));
							}
						}
					}
					if(hasStaticMod(decl.modifiers()))
						doMemberFields=false;
					doLocals=false;
					inLastType=false;
				}
			}
		}
		return vars;
	}
	private ASTNode lastNodeOfType(int type) {
		for(int i=stack.size()-1;i>=0;i--) {
			ASTNode node = stack.get(i).node;
			if(node.getNodeType()==type)
				return node;
		}
		return null;
	}
	private ASTNode lastNodeContaining(int offset) {
		for(int i=stack.size()-1;i>=0;i--) {
			ASTNode node = stack.get(i).node;
			if(nodeContainsOffset(node,offset) && node.getNodeType()!=ASTNode.SIMPLE_NAME)
				return node;
		}
		return null;
	}
	private void push(ASTNode node) {
		assert stack.size()==level;
		stack.add(new StackEntry(node));
	}
	private VarDesc makeDesc(VariableDeclarationFragment frag) {
		if(frag==null) return null;
		String name=frag.getName().getIdentifier();
		ASTNode parent=frag.getParent();
		switch(parent.getNodeType()) {
			case ASTNode.VARIABLE_DECLARATION_STATEMENT:
				return makeDesc(
					((VariableDeclarationStatement)parent).getType(),
					frag.getExtraDimensions(),
					VarDesc.LOCAL,name
				);
			case ASTNode.VARIABLE_DECLARATION_EXPRESSION:
				return makeDesc(
					((VariableDeclarationExpression)parent).getType(),
					frag.getExtraDimensions(),
					VarDesc.LOCAL,name
				);
			case ASTNode.FIELD_DECLARATION: {
				FieldDeclaration decl=(FieldDeclaration) parent;
				int kind=hasStaticMod(decl.modifiers())?VarDesc.STATIC:VarDesc.MEMBER;
				return makeDesc(
					decl.getType(),
					frag.getExtraDimensions(),
					kind,name
				);
			}
		}
		return null;
	}
	private VarDesc makeDesc(SingleVariableDeclaration svd) {
		if(svd==null) return null;
		return makeDesc(
			svd.getType(),
			svd.getExtraDimensions(),
			VarDesc.LOCAL,
			svd.getName().getIdentifier()
		);
	}
	private VarDesc makeDesc(Type type, int xtraDim, int kind, String name) {
		while(type.isArrayType()) {
			type=((ArrayType)type).getComponentType();
			xtraDim++;
		}
		return new VarDesc(type,xtraDim,kind,name);
	}
	private VarDesc makeDesc(ITypeBinding type) {
		if(type==null) return null;
		return new VarDesc(type);
	}
	private void add(VariableDeclarationFragment frag) {
		add(makeDesc(frag));
//		fMonitor.workedTotal(frag.getStartPosition());
	}
	private void add(SingleVariableDeclaration svd) {
		add(makeDesc(svd));
//		fMonitor.workedTotal(svd.getStartPosition());
	}
	private void add(VarDesc var) {
		List<VarDesc> varList=stack.get(level-1).vars;
		varList.add(var);
	}
	private void addFrags(List<VariableDeclarationFragment> frags) {
		for(VariableDeclarationFragment frag: frags) {
			add(frag);
		}
	}
	private boolean statementIsComplete(ASTNode stmt) {
		if(fSource==null) return true;
		int endpos=stmt.getStartPosition()+stmt.getLength()-1;
		return fSource.charAt(endpos)==';';
	}
	private void addFragsIfPast(ASTNode container, List<VariableDeclarationFragment> frags) {
		if(frags.isEmpty()) return;
		if(fSource==null) return;
		if(!statementIsComplete(container)) return;
		if(nodeContainsOffset(container, fOffset)) return;
		addFrags(frags);
	}
	private static boolean hasStaticMod(List<IExtendedModifier> modifiers) {
		for(IExtendedModifier mod: modifiers) {
			if(mod.isModifier())
				if(((Modifier)mod).isStatic())
					return true;
		}
		return false;
	}
	private boolean inNode(ASTNode node) {
		return nodeContainsOffset(node,fOffset) || node==getLastNode();
	}
	private boolean nodeContainsOffset(ASTNode node, int offset) {
		return (offset>=node.getStartPosition() && offset<node.getStartPosition()+node.getLength());
	}
	private boolean nodeisPastOffset(ASTNode node, int offset) {
		return (offset<node.getStartPosition());
	}
	private void expand(List<ASTNode> children, boolean stopWhenPassed) {
		if(children.isEmpty()) return;
		for(int i=0;i<children.size();i++) {
			boolean added=false;
			ASTNode child=children.get(i);
			if(nodeisPastOffset(child,fOffset)) {
				if(stopWhenPassed) break;
			} else {
				if(i==children.size()-1 || nodeisPastOffset(children.get(i+1),fOffset)) {
					//even if the node does not contain the offset, it's the only one that possibly could
					//so we push it on the stack
					push(child);
					added=true;
				}
			}
			if(added) level++;
			visitASTNode(child);
			if(added) level--;
		}
	}
	private List<ASTNode> list(Object... children) {
		List<ASTNode> ret=new ArrayList<ASTNode>();
		for(int i=0;i<children.length;i++) {
			if(children[i]==null) {
			} else if(children[i] instanceof ASTNode) {
				ret.add((ASTNode)children[i]);
			} else if(children[i] instanceof List) {
				ret.addAll((List<ASTNode>)children[i]);
			}
		}
		return ret;
	}
	/** the "common case" node handler */
	private void cc(ASTNode node, List<ASTNode> children) {
		if(!inNode(node)) return;
		expand(children,true);
	}

	/* nodes that require some special handling go first */
	public void visit(TypeDeclaration node) {
		if(!inNode(node)) return;
		expand(node.bodyDeclarations(),false); //continue processing all fields
	}
	public void visit(AnonymousClassDeclaration node) {
		if(!inNode(node)) return;
		expand(node.bodyDeclarations(),false); //continue processing all fields
	}
	public void visit(FieldDeclaration node) {
		if(inNode(node)) {
			addFragsIfPast(node,node.fragments());
			expand(node.fragments(),true);
		} else {
			addFrags(node.fragments());
		}
	}
	public void visit(MethodDeclaration node) {
		if(!inNode(node)) return;
		for(SingleVariableDeclaration svd: (List<SingleVariableDeclaration>)node.parameters()) {
			add(svd);
		}
		expand(list(node.getBody()),true);
	}
	public void visit(VariableDeclarationStatement node) {
		if(inNode(node)) {
			addFragsIfPast(node,node.fragments());
			expand(node.fragments(),true);
		} else {
			addFrags(node.fragments());
		}
	}
	public void visit(VariableDeclarationExpression node) {
		if(inNode(node)) {
			addFragsIfPast(node,node.fragments());
			expand(node.fragments(),true);
		} else {
			addFrags(node.fragments());
		}
	}
	public void visit(EnhancedForStatement node) {
		if(!inNode(node)) return;
		add(node.getParameter());
		expand(list(node.getParameter(),node.getExpression(),node.getBody()),true);
	}
	public void visit(CatchClause node) {
		if(!inNode(node)) return;
		add(node.getException());
		expand(list(node.getBody()),true);
	}
	
	/* then we have nodes that fit the common case, we just need to specify how to get the children */
	public void visit(CompilationUnit node) {
		cc(node,node.types());
	}
	public void visit(EnumDeclaration node) {
		cc(node,list(node.bodyDeclarations()));
	}
	public void visit(VariableDeclarationFragment node) {
		cc(node,list(node.getInitializer()));
	}
	public void visit(ClassInstanceCreation node) {
		cc(node,list(node.arguments(),node.getAnonymousClassDeclaration()));
	}
	public void visit(Block node) {
		cc(node,node.statements());
	}
	public void visit(Initializer node) {
		cc(node,list(node.getBody()));
	}
	public void visit(TypeDeclarationStatement node) {
		cc(node,list(node.getDeclaration()));
	}
	public void visit(ForStatement node) {
		cc(node,list(node.initializers(),node.getExpression(),node.updaters(),node.getBody()));
	}
	public void visit(DoStatement node) {
		cc(node,list(node.getBody(),node.getExpression()));
	}
	public void visit(ExpressionStatement node) {
		cc(node,list(node.getExpression()));
	}
	public void visit(IfStatement node) {
		cc(node,list(node.getExpression(),node.getThenStatement(),node.getElseStatement()));
	}
	public void visit(LabeledStatement node) {
		cc(node,list(node.getBody()));
	}
	public void visit(SwitchStatement node) {
		cc(node,list(node.getExpression(),node.statements()));
	}
	public void visit(SynchronizedStatement node) {
		cc(node,list(node.getExpression(),node.getBody()));
	}
	public void visit(TryStatement node) {
		cc(node,list(node.getBody(),node.catchClauses(),node.getFinally()));
	}
	public void visit(WhileStatement node) {
		cc(node,list(node.getExpression(),node.getBody()));
	}
	public void visit(Assignment node) {
		cc(node,list(node.getLeftHandSide(),node.getRightHandSide()));
	}
	public void visit(MethodInvocation node) {
		cc(node,list(node.getExpression(),node.arguments()));
	}
	public void visit(SingleVariableDeclaration node) { //should be handled by parent, but just in case...
		cc(node,list(node.getInitializer()));
	} 
	public void visit(ArrayAccess node) {
		cc(node,list(node.getArray(),node.getIndex()));
	}
	public void visit(ArrayCreation node) {
		cc(node,list(node.dimensions(),node.getInitializer()));
	}
	public void visit(ArrayInitializer node) {
		cc(node,list(node.expressions()));
	}
	public void visit(AssertStatement node) {
		cc(node,list(node.getExpression(),node.getMessage()));
	}
	public void visit(CastExpression node) {
		cc(node,list(node.getExpression()));
	}
	public void visit(ConditionalExpression node) {
		cc(node,list(node.getExpression(),node.getThenExpression(),node.getElseExpression()));
	}
	public void visit(ConstructorInvocation node) {
		cc(node,list(node.arguments()));
	}
	public void visit(EnumConstantDeclaration node) {
		cc(node,list(node.arguments(),node.getAnonymousClassDeclaration()));
	}
	public void visit(FieldAccess node) {
		cc(node,list(node.getExpression()));
	}
	public void visit(InfixExpression node) {
		cc(node,list(node.getLeftOperand(),node.getRightOperand(),node.extendedOperands()));
	}
	public void visit(InstanceofExpression node) {
		cc(node,list(node.getLeftOperand()));
	}
	public void visit(ParenthesizedExpression node) {
		cc(node,list(node.getExpression()));
	}
	public void visit(PostfixExpression node) {
		cc(node,list(node.getOperand()));
	}
	public void visit(PrefixExpression node) {
		cc(node,list(node.getOperand()));
	}
	public void visit(ReturnStatement node) {
		cc(node,list(node.getExpression()));
	}
	public void visit(SuperConstructorInvocation node) {
		cc(node,list(node.getExpression(),node.arguments()));
	}
	public void visit(SuperMethodInvocation node) {
		cc(node,list(node.arguments()));
	}
	public void visit(SwitchCase node) {
		cc(node,list(node.getExpression()));
	}
	public void visit(ThrowStatement node) {
		cc(node,list(node.getExpression()));
	}
	
	/* finally we have useless nodes */
	public void visit(AnnotationTypeDeclaration node) {} //skip
	public void visit(AnnotationTypeMemberDeclaration node) {} //skip
	public void visit(ArrayType node) {} //skip
	public void visit(BlockComment node) {} //skip
	public void visit(BooleanLiteral node) {} //skip
	public void visit(BreakStatement node) {} //skip
	public void visit(CharacterLiteral node) {} //skip
	public void visit(ContinueStatement node) {} //skip
	public void visit(EmptyStatement node) {} //skip
	public void visit(ImportDeclaration node) {} //skip
	public void visit(Javadoc node) {} //skip
	public void visit(LineComment node) {} //skip
	public void visit(MarkerAnnotation node) {} //skip
	public void visit(MemberRef node) {} //skip
	public void visit(MemberValuePair node) {} //skip
	public void visit(MethodRef node) {} //skip
	public void visit(MethodRefParameter node) {} //skip
	public void visit(Modifier node) {} //skip
	public void visit(NormalAnnotation node) {} //skip
	public void visit(NullLiteral node) {} //skip
	public void visit(NumberLiteral node) {} //skip
	public void visit(PackageDeclaration node) {} //skip
	public void visit(ParameterizedType node) {} //skip
	public void visit(PrimitiveType node) {} //skip
	public void visit(QualifiedName node) {} //skip
	public void visit(QualifiedType node) {} //skip
	public void visit(SimpleName node) {} //skip
	public void visit(SimpleType node) {} //skip
	public void visit(SingleMemberAnnotation node) {} //skip
	public void visit(StringLiteral node) {} //skip
	public void visit(SuperFieldAccess node) {} //skip
	public void visit(TagElement node) {} //skip
	public void visit(TextElement node) {} //skip
	public void visit(ThisExpression node) {} //skip
	public void visit(TypeLiteral node) {} //skip
	public void visit(TypeParameter node) {} //skip
	public void visit(WildcardType node) {} //skip
}
