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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class ArgumentIsNewMapping extends ArgumentIs_Mapping {
	public ArgumentIsNewMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public ArgumentIsNewMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SAME_AS, mode=Mode.NONE)
	public String detailSameAs;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		String detailClass = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_CLASS, true);
		String detailClassSimple = Signature.getSimpleName(detailClass);
		String signature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, "()V");
		
		EObject contextMethodInvocationElement = FSMLEcoreUtil.retrieveContextElement(syncItem, JavaMappingInterpreter.CONTEXT_METHOD_CALL);
		
		if (contextMethodInvocationElement == null)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, JavaMappingInterpreter.CONTEXT_METHOD_CALL);

		// construct the new instance creation statement
		IType instanceType;
		try {
			instanceType = contextIJavaProject.findType(detailClass);
			String newExpression = "new " + detailClassSimple + CodeTransforms.constructDefaultCallParameters(signature);
			
			if (instanceType.isInterface() || (instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()))) {
				// create anonymous subclass for interfaces and abstract classes
				newExpression += " {\n\t";
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
						contents.append(CodeTransforms.createMethodString(contextIJavaProject, (CompilationUnit)(contextMethodInvocation == null ? contextClassInstanceCreation : contextMethodInvocation).getRoot(), null, visibility, method.getElementName(), method.getSignature(), null, progressMonitor));
						contents.append("\n");						
					}
				}	*/		
				contents.append("}");
				newExpression += contents.toString();	
			}
			switch (syncItem.getReconciliationAction()) {
			case CODE_ADD:
				if (contextMethodInvocation != null) {
					Expression expression = CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, newExpression, progressMonitor);
					if (expression != null) {
						CodeTransforms.organizeImports(contextMethodInvocation, detailClass);
						return true;
					}
				}	
				if (contextClassInstanceCreation != null) {
					Expression expression =  CodeTransforms.replaceMethodCallArgument(null, contextClassInstanceCreation, index, newExpression, progressMonitor);
					if (expression != null) {
						CodeTransforms.organizeImports(contextClassInstanceCreation, detailClass);
						return true;
					}
				}
			case CODE_REMOVE:
				if (contextMethodInvocation != null)
					return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
				if (contextClassInstanceCreation != null)
					return CodeTransforms.replaceMethodCallArgument(null, contextClassInstanceCreation, index, "null", progressMonitor) != null;
			}
			
		} catch (JavaModelException e) {
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, feature);
		}
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		// could be a method invocation or class instance creation
		
		// exactly one of them must be non-null
		assert(!(contextMethodInvocation == null && contextClassInstanceCreation == null) &&
			   !(contextMethodInvocation != null && contextClassInstanceCreation != null));
		
		String indexString = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_INDEX, true);
		int index = Integer.valueOf(indexString) - 1;
		
		ASTNode argument = null;
		if (contextMethodInvocation != null)
			argument = (ASTNode) contextMethodInvocation.arguments().get(index);
		if (contextClassInstanceCreation != null)
			argument = (ASTNode) contextClassInstanceCreation.arguments().get(index);
		
		if (argument instanceof ClassInstanceCreation)
			Stats.INSTANCE.logMessage(element.eClass().getName() + "::" + feature.getName() + " <argumentIsNew> argument is a class instance creation expression");
		else
			return setFeature(false);
		
		return setFeatureContextAndMarker(true, argument, argument, null);	
	}

}
