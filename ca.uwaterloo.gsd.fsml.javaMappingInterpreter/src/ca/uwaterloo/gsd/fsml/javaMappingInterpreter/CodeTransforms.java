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

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IBuffer;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.ArrayType;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.SwitchStatement;
import org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.WildcardType;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.internal.corext.codemanipulation.AddUnimplementedMethodsOperation;
import org.eclipse.jdt.internal.corext.dom.ASTNodes;
import org.eclipse.jdt.internal.ui.text.correction.proposals.LinkedCorrectionProposal;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.stats.Stats;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class CodeTransforms {
	public static LinkedCorrectionProposal currentProposal=null;
	
	/**
	 * This method starts recoding modifications on the compilation unit. It should always be called before performing any 
	 * changes to AST.
	 * @param cu
	 * @return false if the compilation unit cannot be modified
	 */
	public static boolean recordModifications(CompilationUnit cu) {
		if ((cu.getFlags() & ASTNode.PROTECT) != 0)
			// cu is unmodifiable! Abort
			return false;
			
		// try to record modifications
		try {
			cu.recordModifications();
			// no exception means that the recording is turned on for the first time.
		} catch (IllegalArgumentException e) {
			if (!"AST modifications are already recorded".equals(e.getMessage()) &&
				!"AST is already modified".equals(e.getMessage()))
				// root belongs to different ast... Abort
				return false;
		}
		// otherwise it means that the modification recording has already been started. Proceed.
		return true;
	}
	
	
	public static IType createCompilationUnit(IJavaProject project, String className, String packageName, IProgressMonitor progressMonitor) {
		// first check if a compilation unit already exists
		String fqName = (packageName != null && !packageName.isEmpty()) ? packageName + "." + className : className;
		try {
			IType iType = project.findType(fqName);
			if (iType != null && iType.exists())
				return iType;
		} catch (JavaModelException e1) {
			e1.printStackTrace();
		}
		
		try {
			IPackageFragment[] allFragments = project.getPackageFragments();
			IPackageFragment fragment = null;
			for (int i = 0; i < allFragments.length; i++) {
				fragment = allFragments[i];
				if (fragment.getElementName().equals(packageName))
					break;
				else 
					fragment = null;
			}
			if (fragment != null) {
				// top-level classes only
				String contents = (packageName.length()>0)? "package " + packageName + ";\n":"\n";
				contents += "public class " + className + " {\n}";
				ICompilationUnit icu = fragment.createCompilationUnit(className+".java", contents, false, progressMonitor);
				icu.save(progressMonitor, true);
				return icu.getType(className);
			}
			else {
				// TODO: create the package?
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void removeIType(IType iType, IProgressMonitor progressMonitor) {
		try {
			iType.delete(true, progressMonitor);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	public static boolean removeCompilationUnit(String className, String packageName, IProgressMonitor progressMonitor) {
		// TODO: implement removeCompilationUnit
		return false;
	}
	public static Type addInterfaceDeclaration(IJavaProject project, CompilationUnit compilationUnit, TypeDeclaration typeDeclaration, String superInterfaceQName, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) typeDeclaration.getRoot());
		
		if (!recordModifications(cu))
			return null;
	
		organizeImports(cu, superInterfaceQName);
		
		// add interface
		String interfaceName = Signature.getSimpleName(superInterfaceQName);
		AST ast = typeDeclaration.getAST();
		SimpleName name = ast.newSimpleName(interfaceName);
		SimpleType newInterface = ast.newSimpleType(name);
		Type found = null;
		for (Iterator i = typeDeclaration.superInterfaceTypes().iterator(); i.hasNext(); ) {
			SimpleType aux = (SimpleType) i.next();
			if (aux.getName().toString().equals(interfaceName)) {
				found = aux;
				break;
			}
		}
		if (found == null) {	
			typeDeclaration.superInterfaceTypes().add(newInterface);
			// Michal: need to add unimplemented methods too
			createUnimplementedMethods(project, superInterfaceQName, typeDeclaration, progressMonitor);
			return newInterface;
		}
		else
			return found;
	}
	public static boolean removeInterfaceDeclaration(CompilationUnit compilationUnit, TypeDeclaration typeDeclaration, String superInterfaceQName, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) typeDeclaration.getRoot());
		
		if (!recordModifications(cu))
			return false;	
			
		// remove interface
		String interfaceName = Signature.getSimpleName(superInterfaceQName);
		for (ListIterator i = typeDeclaration.superInterfaceTypes().listIterator(); i.hasNext(); ) {
			Object ii = i.next();
			if (ii instanceof SimpleType) {
				SimpleType aux = (SimpleType) ii;
				if (aux.getName().getFullyQualifiedName().equals(superInterfaceQName) || aux.getName().toString().equals(interfaceName)) {
					i.remove();
					return true;
				}
			}
		}	
		return false;
	}
	/**
	 * 
	 * @param compilationUnit
	 * @param type
	 * @param superClassQName
	 * @param progressMonitor
	 * @return
	 */
	public static Type addExtendsDeclaration(IJavaProject project, CompilationUnit compilationUnit, TypeDeclaration typeDeclaration, String superClassQName, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) typeDeclaration.getRoot());
		
		if (!recordModifications(cu))
			return null;
		
		organizeImports(cu, superClassQName);
		
		// set the super type
		
		String superClassName = Signature.getSimpleName(superClassQName);
		AST ast = typeDeclaration.getAST();
		SimpleName name = ast .newSimpleName(superClassName);
		SimpleType newSuperclass = ast.newSimpleType(name);
		
		// simply add superclass type
		typeDeclaration.setSuperclassType(newSuperclass);
		createUnimplementedMethods(project, superClassQName, typeDeclaration, progressMonitor);
		
		return newSuperclass;
	}
	public static boolean removeExtendsDeclaration(CompilationUnit compilationUnit, TypeDeclaration typeDeclaration, String superClassQName, IProgressMonitor progressMonitor) {
		// TODO implement remove extends declaration		
		return false;
	}
	public static final int BEFORE_ADVICE = 0;
	public static final int AFTER_ADVICE = -1;
	
	public static List<ASTNode> weaveAdvice(int adviceType, CompilationUnit compilationUnit, MethodDeclaration methodDeclaration, String advice, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) methodDeclaration.getRoot());
		
		List<ASTNode> result = null;
		
		if (!recordModifications(cu))
			return result;
		
		// create AST for the advice
		ASTParser adviceParser = ASTParser.newParser(AST.JLS3);
		adviceParser.setSource(advice.toCharArray());
		adviceParser.setResolveBindings(true);
		adviceParser.setBindingsRecovery(true);
		adviceParser.setKind(ASTParser.K_STATEMENTS);
		Block adviceAst = (Block) adviceParser.createAST(progressMonitor);
		// get list of statements

		// weave the advice
		Block body = methodDeclaration.getBody();
		List<ASTNode> newStatements = ASTNode.copySubtrees(body.getAST(), adviceAst.statements());
		if (adviceType==BEFORE_ADVICE) {
				body.statements().addAll(0, newStatements);
		} else if (adviceType==AFTER_ADVICE){
			body.statements().addAll(newStatements);
		
		}else {
			newStatements=weaveAdviceHelper(adviceType, body,adviceAst,progressMonitor);
		}
		result = newStatements;
		// not sure that this will work. Probably need to apply the changes first and then lookup 
		// the nodes again in the committed working copy.
		return result;
	
	}


	private static List<ASTNode> weaveAdviceHelper(int adviceType, Block body, Block adviceAST, IProgressMonitor progressMonitor) {
		List<ASTNode> result=null;
		int targetLineNum= 0;
		int currentOffset = adviceType;
		List<ASTNode> statements = body.statements();
		List<ASTNode> newStatements = ASTNode.copySubtrees(body.getAST(), adviceAST.statements());
		
		for (ASTNode stmt : statements) {
			if (stmt.getStartPosition() < currentOffset && stmt.getStartPosition()+stmt.getLength()>currentOffset) {
				if (stmt instanceof SynchronizedStatement){
					body = ((SynchronizedStatement)stmt).getBody();
					return weaveAdviceHelper(currentOffset,body, adviceAST, progressMonitor);
				} else if (stmt instanceof WhileStatement){
					if (((WhileStatement)stmt).getBody() instanceof Block)
					body = (Block)((WhileStatement)stmt).getBody();
					return weaveAdviceHelper(currentOffset,body, adviceAST, progressMonitor);
				}else if (stmt instanceof IfStatement){
					if (((IfStatement)stmt).getThenStatement().getStartPosition()<currentOffset && 
							((IfStatement)stmt).getThenStatement().getStartPosition()+((IfStatement)stmt).getThenStatement().getLength()>currentOffset &&
							((IfStatement)stmt).getThenStatement() instanceof Block){
						 body = (Block)((IfStatement)stmt).getThenStatement();
						return weaveAdviceHelper(currentOffset,body, adviceAST, progressMonitor);
					}else if (((IfStatement)stmt).getElseStatement() instanceof Block){
						 body = (Block)((IfStatement)stmt).getElseStatement();
						return weaveAdviceHelper(currentOffset,body, adviceAST, progressMonitor);
					}
				} else if (stmt instanceof SwitchStatement){
					//special case since switch statements don't have a block as its body
					//doesn't handle things like nested switch statements
					List<ASTNode> switchStmts = ((SwitchStatement)stmt).statements();
					if (!switchStmts.isEmpty()){
						targetLineNum=0;
						for (ASTNode stmt2 : switchStmts) {
							if (stmt2.getStartPosition()<currentOffset){
								targetLineNum++;
							}
						}
						switchStmts.addAll(targetLineNum, newStatements);
						result = newStatements;
						return result;
					}
					
				}
				break;
			}
			else if (stmt.getStartPosition()<currentOffset){
				targetLineNum++;
			} 
		}	
		body.statements().addAll(targetLineNum, newStatements);
		// not sure that this will work. Probably need to apply the changes first and then lookup 
		// the nodes again in the committed working copy.
		result = newStatements;
		return result;
		
	}
	public static boolean commentOutASTNode(CompilationUnit compilationUnit, ASTNode astNode, EClass eClass, EStructuralFeature feature, IProgressMonitor progressMonitor) {
		// TODO:
		String message = "Commented out by an FSML during the removal of " + eClass.getName() + (feature != null ? "::" + feature.getName() : "");
		Stats.INSTANCE.printMessage(message);
		return false;
	}
	public static boolean commentOutSourceReference(IType type, ISourceReference sourceReference, String message, IProgressMonitor progressMonitor) {
		boolean result = true;
		
		ICompilationUnit workingCopy = null;
		if (sourceReference.exists()) {
				try {
					workingCopy = type.getCompilationUnit().getWorkingCopy(progressMonitor);
					
					int offset = sourceReference.getSourceRange().getOffset();
					int length = sourceReference.getSourceRange().getLength();
					
					IBuffer buffer = workingCopy.getBuffer();
					buffer.replace(offset, length, "/* Commented out by an FSML " + message + "\n    " + buffer.getText(offset, length) + " */");
					workingCopy.reconcile(ICompilationUnit.NO_AST, false, null, null);
					workingCopy.commitWorkingCopy(false, progressMonitor);
					return true;
				} catch (JavaModelException e) {
					e.printStackTrace();
				} catch (MalformedTreeException e) {
					e.printStackTrace();
				} finally {
					if (workingCopy != null) {
						try {
							workingCopy.discardWorkingCopy();
						} catch (JavaModelException e) { e.printStackTrace(); }
					}
					progressMonitor.done();
				}
		}
		return result;
	}
	public static String createMethodString(IJavaProject project, CompilationUnit compilationUnit, TypeDeclaration typeDeclaration, String visibility, String name, String signature, String body, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) typeDeclaration.getRoot());
		
		if (!recordModifications(cu))
			return null;

		StringBuffer contents = new StringBuffer();
		String[] parameterTypes = Signature.getParameterTypes(signature);
		String[] parameterNames = new String[parameterTypes.length];
		
		String returnType = Signature.getReturnType(signature);
		returnType = Signature.getElementType(returnType);
		organizeImports(cu, Signature.toString(returnType));
		
		for (int i = 0; i < parameterTypes.length; i++) {
			String parameterTypeSignature = Signature.getElementType(parameterTypes[i]);
			organizeImports(cu, Signature.toString(parameterTypeSignature));
			parameterNames[i] = Signature.getSimpleName(CodeTransforms.convertSlashPathsToDotPaths(parameterTypes[i]));
			char char0 = Character.toLowerCase(parameterNames[i].charAt(0));
			parameterNames[i] = char0 + (parameterNames[i].length() > 1 ? parameterNames[i].substring(1, parameterNames[i].length()-1) : "");
			if (parameterNames[i].equals("class"))
				parameterNames[i] = "aClass";
		}
		
		contents.append(visibility + " ");
		contents.append(Signature.toString(signature, name, parameterNames, false, true));
		
		if (body == null) {
			// Michal: need to add a call to super if the method overrides a method from the superclass
			// TODO: check all superclasses not just the direct one!
			String superInvocation = "";
			
			Type superclassType = typeDeclaration.getSuperclassType();
			if (superclassType != null) {
				String fqSuperclassName = ASTUtils.getFullyQualifiedName(superclassType);
				// check if the supertype has a similar method that has to be called super
				try {
					IType superIType = project.findType(fqSuperclassName);
					for (IMethod iMethod : superIType.getMethods()) {
						if (iMethod.getElementName().equals(name)) {
							// compare signature
							String iMethodSig = iMethod.getSignature(); 
							iMethodSig = convertSlashPathsToDotPaths(iMethodSig);
							if (iMethodSig.equals(signature)) {
								// construct super method invocation if the method is not abstract
								if (!Flags.isAbstract(iMethod.getFlags())) {
									superInvocation = "super." + name + "(";
									// add parameters
									for (String parameterName : parameterNames) {
										superInvocation += parameterName;
										if (!parameterNames[parameterNames.length-1].equals(parameterName))
											superInvocation += ", ";
									}
									superInvocation += ")";
									break;
								}
							}
								
						}
					}
				} catch (JavaModelException e) {
					// no problem. just continue.
					Stats.INSTANCE.logError("CodeTransforms.createMethodString(): cannot process methods of the supertype");
				}
			}
				
				
			// Michal: need to initialize here, otherwise 'null' could be in the body and the mehtod will not parse.
			body = "";
			
			if (Signature.toString(returnType).equals("void")) {
				if (!superInvocation.isEmpty())
					body = "\t" + superInvocation + ";";
			}
			else {
				body = "\treturn ";
				if (!superInvocation.isEmpty())
					 body += superInvocation + ";";
				else {
					if(signature.substring(signature.indexOf(')')+1).indexOf('[')!=-1) //return type is an array 
						body += "null;";
					else if (Signature.toString(returnType).equals("boolean"))
						body += "false;";
					else if (Signature.toString(returnType).equals("float"))
						body += "-1f;";
					else if (Signature.toString(returnType).equals("byte") || Signature.toString(returnType).equals("short") ||Signature.toString(returnType).equals("long")||Signature.toString(returnType).equals("double")||Signature.toString(returnType).equals("int"))
						body += "-1;";
					else if (Signature.toString(returnType).equals("char"))
						body += "'0';";
					else 
						body += "null;";
				}
			}
		}
		contents.append("{\n" + body + "\n}");
		return contents.toString();
	}
	private static boolean equalTypes(Type type1, Type type2) {
		if (type1.isArrayType() && type2.isArrayType()) {
			ArrayType casted_type1 = (ArrayType) type1;
			ArrayType casted_type2 = (ArrayType) type2;
			if (casted_type1.getDimensions() != casted_type2.getDimensions() ||
					!equalTypes(casted_type1.getComponentType(), casted_type2.getComponentType()) ||
					!equalTypes(casted_type1.getElementType(), casted_type2.getElementType())) {
				return false;
			}
			return true;
		}
		else if (type1.isParameterizedType() && type2.isParameterizedType()) {
			ParameterizedType casted_type1 = (ParameterizedType) type1;
			ParameterizedType casted_type2 = (ParameterizedType) type2;
			if (!equalTypes(casted_type1.getType(), casted_type2.getType()) ||
					casted_type1.typeArguments().size() != casted_type2.typeArguments().size()) {
				return false;
			}
			for (int i = 0; i < casted_type1.typeArguments().size(); ++i) {
				if (!equalTypes((Type)casted_type1.typeArguments().get(i), (Type)casted_type2.typeArguments().get(i))) {
					return false;
				}
			}
			return true;
		}
		else if (type1.isPrimitiveType() && type2.isPrimitiveType()) {
			PrimitiveType casted_type1 = (PrimitiveType) type1;
			PrimitiveType casted_type2 = (PrimitiveType) type2;
			if (!casted_type1.getPrimitiveTypeCode().toString().equals(casted_type2.getPrimitiveTypeCode().toString())) {
				return false;
			}
			return true;
		}
		else if (type1.isQualifiedType() && type2.isQualifiedType()) {
			QualifiedType casted_type1 = (QualifiedType) type1;
			QualifiedType casted_type2 = (QualifiedType) type2;
			if (casted_type1.getName().getIdentifier().equals(casted_type2.getName().getIdentifier()) ||
					!equalTypes(casted_type1.getQualifier(), casted_type2.getQualifier())) {
				return false;
			}
			return true;
		}
		else if (type1.isSimpleType() && type2.isSimpleType()) {
			SimpleType casted_type1 = (SimpleType) type1;
			SimpleType casted_type2 = (SimpleType) type2;
			return casted_type1.getName().getFullyQualifiedName().equals(casted_type2.getName().getFullyQualifiedName());
		}
		else if (type1.isWildcardType() && type2.isWildcardType()) {
			WildcardType casted_type1 = (WildcardType) type1;
			WildcardType casted_type2 = (WildcardType) type2;
			if (casted_type1.isUpperBound() != casted_type2.isUpperBound() ||
					!equalTypes(casted_type1.getBound(), casted_type2.getBound())) {
				return false;
			}
			return true;	
		}
		return false;
	}
	/**
	 * Creates a new method in the type declaration.
	 * @param project
	 * @param compilationUnit If null, the compilation unit is retrieved from the methodInvocation
	 * @param typeDeclaration
	 * @param visibility
	 * @param name
	 * @param signature
	 * @param body
	 * @param progressMonitor
	 * @return the created method declaration or null otherwise
	 */
	public static MethodDeclaration createMethod(IJavaProject project, CompilationUnit compilationUnit, TypeDeclaration typeDeclaration, String visibility, String name, String signature, String body, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) typeDeclaration.getRoot());
		
		if (!recordModifications(cu))
			return null;
		
		String contents = createMethodString(project, compilationUnit, typeDeclaration, visibility, name, signature, body, progressMonitor);
		
		// create a MethodDeclaration ast node
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(contents.toString().toCharArray());
		parser.setProject(project);
		parser.setKind(ASTParser.K_CLASS_BODY_DECLARATIONS);
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		ASTNode node = parser.createAST(progressMonitor);
		
		if (node instanceof TypeDeclaration) {
			node = ((TypeDeclaration) node).getMethods()[0];
		}
		if (node instanceof MethodDeclaration) {
			node = ASTNode.copySubtree(typeDeclaration.getAST(), node);
			MethodDeclaration newMethod = (MethodDeclaration) node;
			
			boolean methodAlreadyCreated = false;
			MethodDeclaration[] existingMethods = typeDeclaration.getMethods();			
			if (existingMethods != null) {
				for (MethodDeclaration m : existingMethods) {
					if (m.getName().getIdentifier().equals(newMethod.getName().getIdentifier()) &&
							equalTypes(m.getReturnType2(), newMethod.getReturnType2())) {
						methodAlreadyCreated = true;
						for (int i = 0; i < m.parameters().size(); ++i) {
							if (!equalTypes(((SingleVariableDeclaration)m.parameters().get(i)).getType(),
									((SingleVariableDeclaration)newMethod.parameters().get(i)).getType())) {
								methodAlreadyCreated = false;
								break;
							}
						}
						if (methodAlreadyCreated) {
							break;
						}
					}
				}
			}
			if (!methodAlreadyCreated) {
				typeDeclaration.bodyDeclarations().add(node);
			}
			return (MethodDeclaration) node;
		}
		
		return null;
	}
	/**
	 * Creates a new field in the type declaration.
	 * @param project
	 * @param compilationUnit If null, the compilation unit is retrieved from the methodInvocation
	 * @param typeDeclaration
	 * @param visibility
	 * @param fieldName
	 * @param fieldType
	 * @param progressMonitor
	 * @return the created field declaration fragment or null otherwise
	 */
	public static VariableDeclarationFragment createField(IJavaProject project, CompilationUnit compilationUnit, TypeDeclaration typeDeclaration, String visibility, String fieldName, String fieldType, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) typeDeclaration.getRoot());
		
		if (!recordModifications(cu))
			return null;
		
		organizeImports(cu, fieldType);
		
		StringBuffer contents = new StringBuffer();
		contents.append(visibility + " ");
		contents.append(Signature.getSimpleName(fieldType) + " ");
		contents.append(fieldName + ";");
		
		// create a FieldDeclaration ast node
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(contents.toString().toCharArray());
		parser.setProject(project);
		parser.setKind(ASTParser.K_CLASS_BODY_DECLARATIONS);
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		ASTNode node = parser.createAST(progressMonitor);
		
		if (node instanceof TypeDeclaration) {
			node = ((TypeDeclaration) node).getFields()[0];
		}
		if (node instanceof FieldDeclaration) {
			node = ASTNode.copySubtree(typeDeclaration.getAST(), node);
			MethodDeclaration[] methodDeclarations = typeDeclaration.getMethods();
			if (methodDeclarations.length > 0) {
				MethodDeclaration firstMethodDeclaration = methodDeclarations[0];
				int index = typeDeclaration.bodyDeclarations().indexOf(firstMethodDeclaration); 
				typeDeclaration.bodyDeclarations().add(index, node);
			}
			else
				// add at the end
				typeDeclaration.bodyDeclarations().add(node);
			
			FieldDeclaration fieldDeclaration = (FieldDeclaration) node;
			return (VariableDeclarationFragment) fieldDeclaration.fragments().get(0);
		}
		
		return null;
	}
	public static String convertSlashPathsToDotPaths(String slashPath) {
		StringBuilder dotPath = new StringBuilder();
		for (int i = 0; i < slashPath.length(); ++i) {
			char curChar = slashPath.charAt(i); 
			if (curChar == '/') {
				dotPath.append('.');
			}
			else {
				dotPath.append(curChar);
			}
		}
		return dotPath.toString();
	}
	/**
	 * WARNING: this can only be executed after a transformation that turned recording of modifications on.
	 * @param cu
	 * @param fullyQualifiedName
	 */
	public static void organizeImports(ASTNode astNode, String fullyQualifiedName) {
		CompilationUnit cu = (CompilationUnit) (astNode instanceof CompilationUnit ? astNode : astNode.getRoot());
		
		if (fullyQualifiedName.equals("void") ||
			fullyQualifiedName.equals("int") ||
			fullyQualifiedName.equals("String") ||
			fullyQualifiedName.equals("boolean") ||
			fullyQualifiedName.equals("float") ||
			fullyQualifiedName.equals("Thread") ||
			fullyQualifiedName.equals("double") ||
			fullyQualifiedName.equals("char") ||
			fullyQualifiedName.equals("short") ||
			fullyQualifiedName.equals("long") ||
			fullyQualifiedName.equals("byte") ||
			Signature.getQualifier(fullyQualifiedName).equals("java.lang"))
			return;

		// see if import declaration for the given type exists
		ImportDeclaration foundImportDeclaration = null;
		
		for (Iterator i = cu.imports().iterator(); i.hasNext(); ) {
			ImportDeclaration importDeclaration = (ImportDeclaration) i.next();
			if (importDeclaration.getName().getFullyQualifiedName().equals(CodeTransforms.convertSlashPathsToDotPaths(fullyQualifiedName))) {
				foundImportDeclaration = importDeclaration;
				break;
			}
		}
		AST ast = cu.getAST();
		
		if (foundImportDeclaration == null) {
			// need to create one...
			ImportDeclaration importDeclaration = ast.newImportDeclaration();			
			Name name = ast.newName(CodeTransforms.convertSlashPathsToDotPaths(fullyQualifiedName));
			importDeclaration.setName(name);
			cu.imports().add(importDeclaration);
		}
	}
	/**
	 * Sets the initializer of a fields declaration fragment
	 * @param compilationUnit
	 * @param variableDeclarationFragment
	 * @param expression
	 * @param progressMonitor
	 * @return
	 */
	public static Expression setFieldsInitializer(CompilationUnit compilationUnit, VariableDeclarationFragment variableDeclarationFragment, String expression, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) variableDeclarationFragment.getRoot());
		
		if (!recordModifications(cu))
			return null;
		
		ASTParser argExParser = ASTParser.newParser(AST.JLS3);
		argExParser.setSource(expression.toCharArray());
		argExParser.setResolveBindings(true);
		argExParser.setBindingsRecovery(true);
		argExParser.setKind(ASTParser.K_EXPRESSION);
		Expression newInitializer = (Expression) argExParser.createAST(progressMonitor);
		
		newInitializer = (Expression) ASTNode.copySubtree(variableDeclarationFragment.getAST(), newInitializer);
		variableDeclarationFragment.setInitializer(newInitializer);
		
		return newInitializer;
	}
	/**
	 * This replaces the index^th argument of the method invocation. 
	 * @param compilationUnit If null, the compilation unit is retrieved from the methodInvocation
	 * @param methodInvocation a MethodInvocation or a ClassInstanceCreation 
	 * @param index of the argument to replace. Index is 1-based.
	 * @param argumentExpression
	 * @param progressMonitor
	 * @return the replaced expression or null otherwise
	 */
	public static Expression replaceMethodCallArgument(CompilationUnit compilationUnit, Expression invocation, int index, String argumentExpression, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) invocation.getRoot());
		
		if (!recordModifications(cu))
			return null;
		
		// need to decrease index because indexes in AST are 0-based 
		if (index > 0)
			index--;
		String contents = argumentExpression;
		if (argumentExpression == null || argumentExpression == "") 
			contents = "null";
		
		ASTParser argExParser = ASTParser.newParser(AST.JLS3);
		argExParser.setSource(contents.toCharArray());
		argExParser.setResolveBindings(true);
		argExParser.setBindingsRecovery(true);
		argExParser.setKind(ASTParser.K_EXPRESSION);
		Expression newArgument = (Expression) argExParser.createAST(progressMonitor);
		newArgument = (Expression) ASTNode.copySubtree(invocation.getAST(), newArgument);
		
		if (invocation instanceof MethodInvocation)
			((MethodInvocation) invocation).arguments().set(index, newArgument);
		else
			((ClassInstanceCreation) invocation).arguments().set(index, newArgument);
		
		return newArgument;
	}
	public static void createUnimplementedMethods(IJavaProject project, String typeName, TypeDeclaration typeDeclaration, IProgressMonitor progressMonitor) {		
		// Michal: temporarily disable 
		return;
		
		/*IType instanceType;		
		try {
			instanceType = project.findType(typeName);
			if (instanceType == null) {
				return;
			}
			if (!instanceType.isInterface() && !(instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()))) {
				// if this type is not an interface or abstract class, then we don't need to travel up the
				// hierarchy any more
				return;
			}
			
			IMethod[] instanceMethods = instanceType.getMethods();
			for (IMethod method : instanceMethods) {
				if (!method.isConstructor() && (instanceType.isInterface() || Flags.isAbstract(method.getFlags()))) {
					String visibility = "";
					if (Flags.isPublic(method.getFlags())) {
						visibility = "public";
					} else if (Flags.isProtected(method.getFlags())) {
						visibility = "protected";
					}
					CodeTransforms.createMethod(project, null, typeDeclaration, visibility, method.getElementName(), method.getSignature(), null, progressMonitor);						
				}
			}			
			
			// super abstract class and interfaces
			String superClassName = instanceType.getSuperclassName();
			if (superClassName != null && !superClassName.equals("java.lang.Object")) {
				CodeTransforms.createUnimplementedMethods(project, superClassName, typeDeclaration, progressMonitor);
			}
			for (String superInterfaceName : instanceType.getSuperInterfaceNames()) {
				CodeTransforms.createUnimplementedMethods(project, superInterfaceName, typeDeclaration, progressMonitor);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}*/
	}
	public static VariableDeclarationStatement declareVariable(IJavaProject project, CompilationUnit compilationUnit, ASTNode astNode, String variableName, String variableType, String variableInitializerValue, String variableConstructorSignature, boolean annonymousSubclass, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) astNode.getRoot());
		
		if (!recordModifications(cu))
			return null;
		
		organizeImports(cu, variableType);
		
		// find the closest parent which is a Statement
		ASTNode aux = astNode;
		while (!(aux instanceof Statement) && aux != null) {
			aux = aux.getParent();
		}
		if (aux == null)
			return null;
		
		// else aux is a statement in which the variable is used
		// need to declare the variable before the statement
		
		String variableSimpleType = Signature.getSimpleName(variableType);
		
		String declaration = variableSimpleType + " " + variableName;
		if (variableConstructorSignature != null) {
			// create the initializer
			declaration += " = new " + variableSimpleType + constructDefaultCallParameters(variableConstructorSignature);
			
			if (annonymousSubclass) {
				// create annonymous subclass for interfaces and abstract classes
				//declaration += " {\n\t  }";
				
				IType instanceType;
				try {
					instanceType = project.findType(variableType);
					
					if (instanceType.isInterface() || (instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()))) {
						// create anonymous subclass for interfaces and abstract classes
						declaration += " {\n\t";
						IMethod[] instanceMethods = instanceType.getMethods();
						StringBuffer contents = new StringBuffer();	
						/* Michal: temporarily disable
						 * for (IMethod method : instanceMethods) {
							if (!method.isConstructor() && (instanceType.isInterface() || Flags.isAbstract(method.getFlags()))) {
								// if this is an interface, provide empty stub of methods
								// if this is an abstract class, ONLY provide empty stubs for abstract methods
								String visibility = "";
								if (Flags.isPublic(method.getFlags())) {
									visibility = "public";
								} else if (Flags.isProtected(method.getFlags())) {
									visibility = "protected";
								}
								contents.append(CodeTransforms.createMethodString(project, cu, null, visibility, method.getElementName(), method.getSignature(), null, progressMonitor));
								contents.append("\n");						
							}
						}		*/	
						contents.append("}");
						declaration += contents.toString();				
					}
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
			}		
		}
		else if (variableInitializerValue != null)
			declaration += " = " + variableInitializerValue;
					
		declaration += ";";
		
		ASTParser argExParser = ASTParser.newParser(AST.JLS3);
		argExParser.setSource(declaration.toCharArray());
		argExParser.setResolveBindings(true);
		argExParser.setBindingsRecovery(true);
		argExParser.setKind(ASTParser.K_STATEMENTS);
		Block block = (Block) argExParser.createAST(progressMonitor);
		VariableDeclarationStatement variableDeclaration = (VariableDeclarationStatement) block.statements().get(0);
		variableDeclaration = (VariableDeclarationStatement) ASTNode.copySubtree(aux.getAST(), variableDeclaration);
		
		// insert the declaration before the statement
		Statement statement = (Statement) aux;
		block = (Block) statement.getParent();
		int index = block.statements().indexOf(statement);
		block.statements().add(index, variableDeclaration);
		
		return variableDeclaration;
	}
	public static ExpressionStatement assignVariableValue(CompilationUnit compilationUnit, ASTNode astNode, String variableName, String value, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) astNode.getRoot());
		
		if (!recordModifications(cu))
			return null;
		
		// find the closest parent which is a Statement
		ASTNode aux = astNode;
		while (!(aux instanceof Statement) && aux != null) {
			aux = aux.getParent();
		}
		if (aux == null)
			return null;
		
		// else aux is a statement in which the variable is used
		// need to declare the variable before the statement
		
		
		String assignment = variableName + " = " + value + ";";
		
		ASTParser argExParser = ASTParser.newParser(AST.JLS3);
		argExParser.setSource(assignment.toCharArray());
		argExParser.setResolveBindings(true);
		argExParser.setBindingsRecovery(true);
		argExParser.setKind(ASTParser.K_STATEMENTS);
		Block block = (Block) argExParser.createAST(progressMonitor);
		ExpressionStatement variableAssignment = (ExpressionStatement) block.statements().get(0);
		variableAssignment = (ExpressionStatement) ASTNode.copySubtree(aux.getAST(), variableAssignment);
		
		// insert the declaration before the statement
		Statement statement = (Statement) aux;
		block = (Block) statement.getParent();
		int index = block.statements().indexOf(statement);
		block.statements().add(index, variableAssignment);
		
		return variableAssignment;
	}	
	public static String constructDefaultCallParameters(String[] parameterTypes) {
		
		StringBuffer result = new StringBuffer("(");
		
		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].equals("I;") ||
					parameterTypes[i].equals("L;") ||
					parameterTypes[i].equals("F;") ||
					parameterTypes[i].equals("B;"))
				result.append("0");
			else if (parameterTypes[i].equals("Z;"))
				result.append("false");
			else 
				result.append("null");
		
			if (i <	 parameterTypes.length - 1)
				result.append(", ");
		}
		result.append(")");
		return result.toString();
	}
	public static String constructDefaultCallParameters(String methodSignature) {
		return constructDefaultCallParameters(Signature.getParameterTypes(methodSignature));
	}
	
	
	
	
	
	
	
	
	
	
	
	// Old, non-incremental versions. Should never use, because they recreate ASTs and commit working copies.
	/**
	 * @deprecated 
	 */
	private static boolean createMethod(IType iType, String visibility, String name, String signature, String body, IProgressMonitor progressMonitor) {
		StringBuffer contents = new StringBuffer();
		
		String[] parameterTypes = Signature.getParameterTypes(signature);
		String[] parameterNames = new String[parameterTypes.length];
		
		for (int i = 0; i < parameterTypes.length; i++) {
			parameterNames[i] = Signature.getSimpleName(parameterTypes[i]);
			char char0 = Character.toLowerCase(parameterNames[i].charAt(0));
			parameterNames[i] = char0 + parameterNames[i].substring(1, parameterNames[i].length()-1);
		}
		
		Signature.toString(signature, name, parameterNames, false, true);
		
		contents.append(visibility + " ");
		contents.append(Signature.toString(signature, name, parameterNames, false, true));
		contents.append("{ \n" + body + "\n}");
		
		try {
			iType.createMethod(contents.toString(), null, false, progressMonitor);
		} catch (JavaModelException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * @deprecated 
	 */
	private static boolean createField(IType contextClass, String visibility, String fieldName, String fieldType, IProgressMonitor progressMonitor) {
		StringBuffer contents = new StringBuffer();
		contents.append(visibility + " ");
		contents.append(fieldType + " ");
		contents.append(fieldName + ";");
		try {
			contextClass.createField(contents.toString(), null, false, progressMonitor);
		} catch (JavaModelException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * @deprecated 
	 */
	private static boolean replaceMethodCallArgument(MethodInvocation contextMethodInvocation, int index, String argumentExpression, IProgressMonitor progressMonitor) {
		if (contextMethodInvocation == null)
			return false;
		
		// need to decrease index
		if (index > 0)
			index--;
		
		ASTNode astRoot = contextMethodInvocation.getRoot();
		CompilationUnit cu = (CompilationUnit) astRoot;
		IJavaElement je = cu.getJavaElement();
		if (!(je instanceof ICompilationUnit))
			return false;
		ICompilationUnit icu = (ICompilationUnit) je; 
		ICompilationUnit workingCopy = null;
		try {
			workingCopy = icu.getWorkingCopy(progressMonitor);
			Document document = new Document(workingCopy.getSource());
			
			ASTParser argExParser = ASTParser.newParser(AST.JLS3);
			argExParser.setSource(argumentExpression.toCharArray());
			argExParser.setResolveBindings(true);
			argExParser.setBindingsRecovery(true);
			argExParser.setKind(ASTParser.K_EXPRESSION);
			Expression newArgument = (Expression) argExParser.createAST(progressMonitor);
			Expression existingArgument = (Expression) contextMethodInvocation.arguments().get(index);
			
			// replace the ith argument of the context method call with the new argument
			ASTRewrite rewrite = ASTRewrite.create(astRoot.getAST());
			rewrite.replace(existingArgument, newArgument, null);
			
			TextEdit edits = rewrite.rewriteAST(document, icu.getJavaProject().getOptions(true));
			
			// computation of the new source code
		   edits.apply(document);
		   String newSource = document.get();
	
		   // update of the compilation unit
		   workingCopy.getBuffer().setContents(newSource);
		   workingCopy.commitWorkingCopy(true, progressMonitor);
		   return true;
		} catch (JavaModelException e) {
			e.printStackTrace();
			return false;
		} catch (MalformedTreeException e) {
			e.printStackTrace();
			return false;
		} catch (BadLocationException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (workingCopy != null) {
				try {
					workingCopy.discardWorkingCopy();
				} catch (JavaModelException e) { e.printStackTrace(); }
			}
			progressMonitor.done();
		}
	}
	/**
	 * @deprecated
	 */
	private static void addInterfaceDeclaration(IType type, String superInterfaceQName, IProgressMonitor progressMonitor) {
		ICompilationUnit cu = null;
		try {
			// create an import first
			cu = type.getCompilationUnit().getWorkingCopy(progressMonitor);
			if (!cu.getImport(superInterfaceQName).exists()) {
				cu.createImport(superInterfaceQName, null, progressMonitor);
				cu.reconcile(AST.JLS3, false, null, progressMonitor);
			}
			
			// add implements declaration
			ASTParser parser = ASTParser.newParser(AST.JLS3);
			parser.setSource(cu);
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			CompilationUnit astRoot = (CompilationUnit) parser.createAST(progressMonitor);
			
			String source = cu.getBuffer().getContents();
			Document document= new Document(source);
			// start modifications
			astRoot.recordModifications();
	
			// add interface
			TypeDeclaration typeDeclaration = (TypeDeclaration) astRoot.types().get(0);
			String interfaceName = Signature.getSimpleName(superInterfaceQName);
			SimpleName name = astRoot.getAST().newSimpleName(interfaceName);
			SimpleType newInterface = astRoot.getAST().newSimpleType(name);
			boolean found = false;
			for (Iterator i = typeDeclaration.superInterfaceTypes().iterator(); i.hasNext(); ) {
				SimpleType aux = (SimpleType) i.next();
				if (aux.getName().equals(interfaceName))
					found = true;
			}
			if (!found)	
				typeDeclaration.superInterfaceTypes().add(newInterface);
			
			// computation of the text edits
			TextEdit edits = astRoot.rewrite(document, cu.getJavaProject().getOptions(true));
	
			// computation of the new source code
			edits.apply(document);
			String newSource = document.get();
			
			// update of the compilation unit
			cu.getBuffer().setContents(newSource);
			
			cu.commitWorkingCopy(false, progressMonitor);
			cu.discardWorkingCopy();
			
			// add stubs for methods required by the interface 
			cu = type.getCompilationUnit().getWorkingCopy(progressMonitor);
			parser= ASTParser.newParser(AST.JLS3);
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			parser.setSource(cu);
			astRoot = (CompilationUnit) parser.createAST(progressMonitor);
			final ITypeBinding binding= ASTNodes.getTypeBinding(astRoot, type);
			AddUnimplementedMethodsOperation operation = new AddUnimplementedMethodsOperation(astRoot, binding, null, -1, true, true, true);
			operation.run(progressMonitor);
			
			cu.commitWorkingCopy(true, progressMonitor);
		} catch (JavaModelException e) {
			e.printStackTrace();
		} catch (MalformedTreeException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		} finally {
			if (cu != null) {
				try {
					cu.discardWorkingCopy();
				} catch (JavaModelException e) { e.printStackTrace(); }
			}
			progressMonitor.done();
		}
	}
	/**
	 * @deprecated 
	 */
	private static void removeInterfaceDeclaration(IType type, String superInterfaceQName, IProgressMonitor progressMonitor) {
		ICompilationUnit cu = null;
		try {
			// remove the import first
			cu = type.getCompilationUnit().getWorkingCopy(progressMonitor);
			IImportDeclaration importDeclaration = cu.getImport(superInterfaceQName); 
			if (importDeclaration.exists()) {
				importDeclaration.delete(true, progressMonitor);
				cu.reconcile(AST.JLS3, false, null, progressMonitor);
			}
			
			// remove implements declaration
			ASTParser parser = ASTParser.newParser(AST.JLS3);
			parser.setSource(cu);
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			CompilationUnit astRoot = (CompilationUnit) parser.createAST(progressMonitor);
			
			String source = cu.getBuffer().getContents();
			Document document= new Document(source);
			// start modifications
			astRoot.recordModifications();
	
			
			// remove interface
			String interfaceName = Signature.getSimpleName(superInterfaceQName);
			TypeDeclaration typeDeclaration = (TypeDeclaration) astRoot.types().get(0);
			for (ListIterator i = typeDeclaration.superInterfaceTypes().listIterator(); i.hasNext(); ) {
				Object ii = i.next();
				if (ii instanceof SimpleType) {
					SimpleType aux = (SimpleType) ii;
					if (aux.getName().getFullyQualifiedName().equals(superInterfaceQName) || aux.getName().toString().equals(interfaceName))
						i.remove();
				}
			}				
			
			// computation of the text edits
			TextEdit edits = astRoot.rewrite(document, cu.getJavaProject().getOptions(true));
	
			// computation of the new source code
			edits.apply(document);
			String newSource = document.get();
			
			// update of the compilation unit
			cu.getBuffer().setContents(newSource);
			
			cu.commitWorkingCopy(false, progressMonitor);
			cu.discardWorkingCopy();
			
			// add stubs for methods required by the interface 
			cu = type.getCompilationUnit().getWorkingCopy(progressMonitor);
			parser= ASTParser.newParser(AST.JLS3);
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			parser.setSource(cu);
			astRoot = (CompilationUnit) parser.createAST(progressMonitor);
			final ITypeBinding binding= ASTNodes.getTypeBinding(astRoot, type);
			AddUnimplementedMethodsOperation operation = new AddUnimplementedMethodsOperation(astRoot, binding, null, -1, true, true, true);
			operation.run(progressMonitor);
			
			cu.commitWorkingCopy(true, progressMonitor);
		} catch (JavaModelException e) {
			e.printStackTrace();
		} catch (MalformedTreeException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		} finally {
			if (cu != null) {
				try {
					cu.discardWorkingCopy();
				} catch (JavaModelException e) { e.printStackTrace(); }
			}
			progressMonitor.done();
		}
	}
	/**
	 * @deprecated 
	 */
	private static boolean addExtendsDeclaration(IType type, String superClassQName, IProgressMonitor progressMonitor) {
		ICompilationUnit cu = null;
		try {
			// create an import first
			cu = type.getCompilationUnit().getWorkingCopy(progressMonitor);
			if (!cu.getImport(superClassQName).exists()) {
				cu.createImport(superClassQName, null, progressMonitor);
				cu.reconcile(AST.JLS3, false, null, progressMonitor);
			}
			
			// add implements declaration
			ASTParser parser = ASTParser.newParser(AST.JLS3);
			parser.setSource(cu);
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			CompilationUnit astRoot = (CompilationUnit) parser.createAST(progressMonitor);
			
			String source = cu.getBuffer().getContents();
			Document document= new Document(source);
			// start modifications
			astRoot.recordModifications();
	
			// add supertype
			TypeDeclaration typeDeclaration = (TypeDeclaration) astRoot.types().get(0);
			String superClassName = Signature.getSimpleName(superClassQName);
			SimpleName name = astRoot.getAST().newSimpleName(superClassName);
			SimpleType newSuperclass = astRoot.getAST().newSimpleType(name);
			
			// simply add superclass type
			typeDeclaration.setSuperclassType(newSuperclass);
			
			// computation of the text edits
			TextEdit edits = astRoot.rewrite(document, cu.getJavaProject().getOptions(true));
	
			// computation of the new source code
			edits.apply(document);
			String newSource = document.get();
			
			// update of the compilation unit
			cu.getBuffer().setContents(newSource);
			
			cu.commitWorkingCopy(false, progressMonitor);
			cu.discardWorkingCopy();
			
			// add stubs for methods required by the interface 
			cu = type.getCompilationUnit().getWorkingCopy(progressMonitor);
			parser= ASTParser.newParser(AST.JLS3);
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			parser.setSource(cu);
			astRoot = (CompilationUnit) parser.createAST(progressMonitor);
			final ITypeBinding binding = ASTNodes.getTypeBinding(astRoot, type);
			AddUnimplementedMethodsOperation operation = new AddUnimplementedMethodsOperation(astRoot, binding, null, -1, true, true, true);
			operation.run(progressMonitor);
			cu.commitWorkingCopy(true, progressMonitor);
			return true;
		} catch (JavaModelException e) {
			e.printStackTrace();
		} catch (MalformedTreeException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		} finally {
			if (cu != null) {
				try {
					cu.discardWorkingCopy();
				} catch (JavaModelException e) { e.printStackTrace(); }
			}
			progressMonitor.done();
		}
		return false;
	}


	/**
	 * @deprecated
	 */
	private static List<ASTNode> weaveAdvice(int adviceType, IMethod targetMethod, String advice, IProgressMonitor progressMonitor) {
		List<ASTNode> result = null;
		
		ICompilationUnit cu = null;
		if (targetMethod.exists()) {
				try {
					IType type = targetMethod.getDeclaringType();
					cu = type.getCompilationUnit().getWorkingCopy(progressMonitor);
					
					// add implements declaration
					ASTParser parser = ASTParser.newParser(AST.JLS3);
					parser.setSource(cu);
					parser.setResolveBindings(true);
					parser.setBindingsRecovery(true);
					CompilationUnit astRoot = (CompilationUnit) parser.createAST(progressMonitor);
					
					String source = cu.getBuffer().getContents();
					Document document= new Document(source);
					// start modifications
					astRoot.recordModifications();
	
					// get body of the targetMethod
					AbstractTypeDeclaration abstractType = (AbstractTypeDeclaration) astRoot.types().get(0);
					MethodDeclaration methodDeclaration = null;
					for (Object aux : abstractType.bodyDeclarations()) {
						BodyDeclaration bodyDeclaration = (BodyDeclaration) aux;
						if (bodyDeclaration.getStartPosition() == targetMethod.getSourceRange().getOffset() &&
							bodyDeclaration instanceof MethodDeclaration) {
							methodDeclaration = (MethodDeclaration) bodyDeclaration;
							break;
						}
					}
					if (methodDeclaration != null) {
						// found!
						// create AST for the advice
						ASTParser adviceParser = ASTParser.newParser(AST.JLS3);
						adviceParser.setSource(advice.toCharArray());
						adviceParser.setResolveBindings(true);
						adviceParser.setBindingsRecovery(true);
						adviceParser.setKind(ASTParser.K_STATEMENTS);
						Block adviceAst = (Block) adviceParser.createAST(progressMonitor);
						// get list of statements
						Block body = methodDeclaration.getBody();
						List<ASTNode> newStatements = ASTNode.copySubtrees(body.getAST(), adviceAst.statements());
						// weave the advice
						switch (adviceType) {
						case BEFORE_ADVICE: 
							body.statements().addAll(0, newStatements);
							break;
						case AFTER_ADVICE:
							body.statements().addAll(newStatements);
							break;
						}
						// not sure that this will work. Probably need to apply the changes first and then lookup 
						// the nodes again in the committed working copy.
						result = newStatements;
					} else {
						// this should never occur, because targetMethod already exists
						// create new method similar to target method with given body
						// TODO create the method!
					}
					
					// computation of the text edits
					TextEdit edits = astRoot.rewrite(document, cu.getJavaProject().getOptions(true));
	
					// computation of the new source code
					edits.apply(document);
					String newSource = document.get();
					
					// update of the compilation unit
					cu.getBuffer().setContents(newSource);
					cu.commitWorkingCopy(false, progressMonitor);
					return result;
				} catch (JavaModelException e) {
					e.printStackTrace();
				} catch (MalformedTreeException e) {
					e.printStackTrace();
				} catch (BadLocationException e) {
					e.printStackTrace();
				} finally {
					if (cu != null) {
						try {
							cu.discardWorkingCopy();
						} catch (JavaModelException e) { e.printStackTrace(); }
					}
					progressMonitor.done();
				}
		}
		return result;
	}


	public static TypeDeclaration createNestedTypeDeclaration(IJavaProject project, CompilationUnit compilationUnit, TypeDeclaration topLevelTypeDeclaration, String nestedClassName, IProgressMonitor progressMonitor) {
		CompilationUnit cu = (compilationUnit != null ? compilationUnit : (CompilationUnit) topLevelTypeDeclaration.getRoot());
		
		if (!recordModifications(cu))
			return null;
		
		String contents = "class " + nestedClassName + " {\n }";
		
		// create a TypeDeclaration ast node
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(contents.toString().toCharArray());
		parser.setProject(project);
		parser.setKind(ASTParser.K_CLASS_BODY_DECLARATIONS);
		parser.setResolveBindings(true);
		parser.setBindingsRecovery(true);
		ASTNode node = parser.createAST(progressMonitor);
		
		if (node instanceof TypeDeclaration) {
			node = ((TypeDeclaration) node).getTypes()[0];
		}
		if (node instanceof TypeDeclaration) {
			node = ASTNode.copySubtree(topLevelTypeDeclaration.getAST(), node);
			topLevelTypeDeclaration.bodyDeclarations().add(node);
			return (TypeDeclaration) node;
		}
		
		return null;
	}
}
