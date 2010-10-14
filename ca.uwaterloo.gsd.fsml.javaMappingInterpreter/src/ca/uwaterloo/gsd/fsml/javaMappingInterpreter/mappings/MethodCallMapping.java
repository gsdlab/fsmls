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
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil.NavigationResult;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

/**
 * Mapping: method call x occurs before method call y in the control flow of class c given callback sequence s.
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class MethodCallMapping extends JavaMapping {

	public MethodCallMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		
		NavigationResult navigationResult1 = FSMLEcoreUtil.navigateToEObject(element, call);
		if (navigationResult1.errorMessage == null)
			methodInvocation1 = contextManager.getContextMethodInvocation(navigationResult1.eObject, true, progressMonitor);
		else
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, JavaMappingInterpreter.DETAIL_OF_METHOD_CALL);
		
		NavigationResult navigationResult2 = FSMLEcoreUtil.navigateToEObject(element, before);
		if (navigationResult2.errorMessage == null)
			methodInvocation2 = contextManager.getContextMethodInvocation(navigationResult2.eObject, true, progressMonitor);
		else
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, JavaMappingInterpreter.DETAIL_OF_CALL);
	}

	public MethodCallMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}

	
	@Parameter(name=JavaMappingInterpreter.DETAIL_CALL, mode=Mode.REVERSE, required=true)
	public String call;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_BEFORE, mode=Mode.REVERSE, required=true)
	public String before;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_GIVEN_CALLBACK_SEQ, mode=Mode.REVERSE, required=true)
	public String givenCallbackSeq;
	
	MethodInvocation methodInvocation1;
	MethodInvocation methodInvocation2;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		return true;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		// see if the calls are in the bodies of callback methods
		MethodDeclaration methodDeclaration1 = (MethodDeclaration) ASTUtils.getAncestorOfType(methodInvocation1, ASTNode.METHOD_DECLARATION);
		CompilationUnit compilationUnit1 = (CompilationUnit) methodInvocation1.getRoot();
		
		MethodDeclaration methodDeclaration2 = (MethodDeclaration) ASTUtils.getAncestorOfType(methodInvocation2, ASTNode.METHOD_DECLARATION);
		CompilationUnit compilationUnit2 = (CompilationUnit) methodInvocation2.getRoot();
		
		if (methodDeclaration1.equals(methodDeclaration2)) {
			// intraprocedural analysis
			Block block1 = (Block) ASTUtils.getAncestorOfType(methodInvocation1, ASTNode.BLOCK);
			Block block2 = (Block) ASTUtils.getAncestorOfType(methodInvocation2, ASTNode.BLOCK);
			
			if (block1 != block2) 
				// most likely are alternative
				return setFeature(false);
			else {
				// in the same block
				if (methodInvocation1.getParent() == methodInvocation2.getParent() && methodInvocation1.getParent().getNodeType() == ASTNode.IF_STATEMENT)
					// directly under if statement, must be in different branches
					return setFeature(false);
				
				else
					// in the same block, not directly in an if statement
					if (methodInvocation1.getStartPosition() < methodInvocation2.getStartPosition())
						return setFeature(true);
			}
		}
		else if (compilationUnit1 == compilationUnit2){
			try {
				IType contextIType = (IType) javaInterpreter.getContext(element, IType.class, true);
				IMethod iMethod1 = (IMethod) methodDeclaration1.resolveBinding().getJavaElement();
				// see if any is a constructor
				boolean methodInvocation1InConstructor = methodDeclaration1.isConstructor();
				List<IMethod> allMethods = callGraphManager.getAvailableMethods(contextIType);
				
				// get all constructors
				if (!methodInvocation1InConstructor) {
					// maybe in cflow of a constructor?
					for (IMethod method : allMethods) {
						if (method.isConstructor()) {
							if (callGraphManager.calls(method, iMethod1))
								methodInvocation1InConstructor = true;
						}
					}
				}
				IMethod iMethod2 = (IMethod) methodDeclaration2.resolveBinding().getJavaElement();
				boolean methodInvocation2InConstructor = methodDeclaration2.isConstructor();
				// get all constructors
				if (!methodInvocation2InConstructor) {
					// maybe in cflow of a constructor?
					for (IMethod method : allMethods) {
						if (method.isConstructor()) {
							if (callGraphManager.calls(method, iMethod2))
								methodInvocation2InConstructor = true;
						}
					}
				}
				
				if (methodInvocation1InConstructor && !methodInvocation2InConstructor)
					return setFeature(true);
				else if (methodInvocation1InConstructor && methodInvocation2InConstructor)
					// the calls are in different constructors of the same compilation unit.
					;
				else if (!methodInvocation1InConstructor && methodInvocation2InConstructor)
					// the second call is first
					;
				else {
					// both method calls are not in constructors: check if both are directly in the callback sequence
					int index1 = givenCallbackSeq.indexOf(methodDeclaration1.getName().getIdentifier());
					int index2 = givenCallbackSeq.indexOf(methodDeclaration2.getName().getIdentifier());
					
					if (index1 != -1 && index2 != -1) {
						if (index1 < index2)
							return setFeature(true);
					}
					else {
						ArrayList<IMethod> callbackMethods = new ArrayList<IMethod>();
						// tokenize
						
						StringTokenizer tokenizer = new StringTokenizer(givenCallbackSeq);
						for ( ; tokenizer.hasMoreTokens() ;) {
							String methodName = tokenizer.nextToken();
							for (IMethod method : allMethods) {
								if (methodName.equals(method.getElementName()))
									callbackMethods.add(method);
							}
						}
						
						// need to see whether methodDeclarations are reachable from the callback methods
						for (int i = 0; i < callbackMethods.size(); i++) {
							IMethod callbackMethod = callbackMethods.get(i);
							if (callGraphManager.calls(callbackMethod, iMethod1)) {
								index1 = i;
								break;
							}
						}
								
						for (int i = 0; i < callbackMethods.size(); i++) {
							IMethod callbackMethod = callbackMethods.get(i);
							if (callGraphManager.calls(callbackMethod, iMethod2)) {
								index2 = i;
								break;
							}
						}
				
						if (index1 != -1 && index2 != -1 && index1 < index2)
							return setFeature(true);
					}
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		return setFeature(false);
	}

}
