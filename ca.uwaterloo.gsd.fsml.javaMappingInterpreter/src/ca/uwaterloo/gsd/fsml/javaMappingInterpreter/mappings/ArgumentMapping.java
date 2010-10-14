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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.search.FieldReferenceMatch;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil.NavigationResult;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.OccurrencesFinder;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class ArgumentMapping extends JavaMapping {
	public ArgumentMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		
		argument1Index = Integer.parseInt(argument);
		argument2Index = Integer.parseInt(sameAsArg);
		
		NavigationResult navigationResult1 = FSMLEcoreUtil.navigateToEObject(element, ofMethodCall);
		if (navigationResult1.errorMessage == null)
			methodInvocation1 = contextManager.getContextMethodInvocation(navigationResult1.eObject, true, progressMonitor);
		else
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, JavaMappingInterpreter.DETAIL_OF_METHOD_CALL);
		
		NavigationResult navigationResult2 = FSMLEcoreUtil.navigateToEObject(element, ofCall);
		if (navigationResult2.errorMessage == null)
			methodInvocation2 = contextManager.getContextMethodInvocation(navigationResult2.eObject, true, progressMonitor);
		else
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, JavaMappingInterpreter.DETAIL_OF_CALL);
	}

	public ArgumentMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
		
		argument1Index = Integer.parseInt(argument);
		argument2Index = Integer.parseInt(sameAsArg);
		
		NavigationResult navigationResult1 = FSMLEcoreUtil.navigateToEObject(syncItem, ofMethodCall + "../");
		if (navigationResult1.errorMessage == null) {
			SyncItem contextSyncItem = (SyncItem) navigationResult1.eObject;
			EObject contextElement = contextSyncItem.getCode() != null ? contextSyncItem.getCode() : contextSyncItem.getModel();
					
			methodInvocation1 = contextManager.getContextMethodInvocation(contextElement, true, progressMonitor);
		}
		else
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, JavaMappingInterpreter.DETAIL_OF_METHOD_CALL);
		
		NavigationResult navigationResult2 = FSMLEcoreUtil.navigateToEObject(syncItem, ofCall + "../");
		if (navigationResult2.errorMessage == null) {
			SyncItem contextSyncItem = (SyncItem) navigationResult2.eObject;
			EObject contextElement = contextSyncItem.getCode() != null ? contextSyncItem.getCode() : contextSyncItem.getModel();
			
			methodInvocation2 = contextManager.getContextMethodInvocation(contextElement, true, progressMonitor);
		}
		else
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, JavaMappingInterpreter.DETAIL_OF_CALL);
	}

	@Parameter(name=JavaMappingInterpreter.DETAIL_ARGUMENT, mode=Mode.ALL, required=true)
	public String argument;
	
	int argument1Index;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_OF_METHOD_CALL, mode=Mode.ALL, required=true)
	public String ofMethodCall;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SAME_AS_ARG, mode=Mode.ALL, required=true)
	public String sameAsArg;
	
	int argument2Index;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_OF_CALL, mode=Mode.ALL, required=true)
	public String ofCall;
	
	MethodInvocation methodInvocation1;
	MethodInvocation methodInvocation2;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		// variant with 'this'
		
		boolean result = false;
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			if (methodInvocation1 != null)
				result = CodeTransforms.replaceMethodCallArgument(null, methodInvocation1, argument1Index, "this", progressMonitor) != null;
			if (methodInvocation2 != null)
				result = result && CodeTransforms.replaceMethodCallArgument(null, methodInvocation2, argument2Index, "this", progressMonitor) != null;
			
			if (result) {
				// make sure that 'this' implements an appropriate interface
				// TODO: cannot rely on bindings since the code hasn't compiled yet!!!
				String typeSignature = retrieveTypeOfArgumentFromSignature(syncItem, argument1Index);
				String requiredTypeName = Signature.toString(typeSignature);
				
				TypeDeclaration typeDeclaration = (TypeDeclaration) ASTUtils.getAncestorOfType(methodInvocation1, ASTNode.TYPE_DECLARATION);
				
				boolean found = false;
				
				Type superclassType = typeDeclaration.getSuperclassType();
				
				if (superclassType != null) {
					String superClassFQName = ASTUtils.getFullyQualifiedName(superclassType);
					if (requiredTypeName.equals(superClassFQName))
						found = true;
				}
				else 
					found = false;
				
				if (!found) {
					// check interfaces
					for (Object superInterface : typeDeclaration.superInterfaceTypes()) {
						if (requiredTypeName.equals(ASTUtils.getFullyQualifiedName((Type) superInterface))) {
							found = true;
							break;
						}
					}
				}
				
				if (!found) {
					try {
						IType requiredIType = contextIJavaProject.findType(requiredTypeName);
						if (requiredIType.isInterface())
							CodeTransforms.addInterfaceDeclaration(contextIJavaProject, null, typeDeclaration, requiredTypeName, progressMonitor);
						else if (requiredIType.isClass())
							CodeTransforms.addExtendsDeclaration(contextIJavaProject, null, typeDeclaration, requiredTypeName, progressMonitor);
					} catch (JavaModelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			break;
		case CODE_REMOVE:
			
			if (methodInvocation1 != null)
				result = CodeTransforms.replaceMethodCallArgument(null, methodInvocation1, argument1Index, "null", progressMonitor) != null;
			if (methodInvocation2 != null)
				result = result && CodeTransforms.replaceMethodCallArgument(null, methodInvocation2, argument2Index, "null", progressMonitor) != null;
			break;
		}
		return result;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		// indexes are 1-based in the metamodel and 0-based in the AST
		argument1Index--;
		argument2Index--;
		
		// get the arguments
		Expression argument1 = (Expression) methodInvocation1.arguments().get(argument1Index);
		Expression argument2 = (Expression) methodInvocation2.arguments().get(argument2Index);
		
		if (argument1.getNodeType() == ASTNode.CAST_EXPRESSION)
			argument1 = ((CastExpression) argument1).getExpression();

		if (argument2.getNodeType() == ASTNode.CAST_EXPRESSION)
			argument2 = ((CastExpression) argument2).getExpression();

		boolean result = false;
		
		if (argument1.getNodeType() == ASTNode.THIS_EXPRESSION && 
			argument2.getNodeType() == ASTNode.THIS_EXPRESSION) {
			// need to check whether 'this' resolves to the same type
			ThisExpression thisExpression1 = (ThisExpression) argument1;
			ThisExpression thisExpression2 = (ThisExpression) argument2;
			ITypeBinding typeBinding1 = thisExpression1.resolveTypeBinding();
			ITypeBinding typeBinding2 = thisExpression2.resolveTypeBinding();

			if (typeBinding1 == null || typeBinding2 == null) {
				Stats.INSTANCE.logMessage("ArgumentMapping::reverse(): type binding is null. returning false.");
				return setFeature(false);
			}
			
			if (typeBinding1.isEqualTo(typeBinding2))
				result = true;
			else {
				// need to see whether dynamically resolve to the same type
				// TODO:
				Stats.INSTANCE.logMessage("ArgumentMapping::reverse(): two 'this' literals with different bindings");				
			}
		}
		else if (argument1.getNodeType() == ASTNode.SIMPLE_NAME && 
			argument2.getNodeType() == ASTNode.SIMPLE_NAME){
			// private field assigned once?
			SimpleName simpleName1 = (SimpleName) argument1;
			SimpleName simpleName2 = (SimpleName) argument2;
			
			IBinding argument1Binding = simpleName1.resolveBinding();
			IBinding argument2Binding = simpleName2.resolveBinding();
			if (argument1Binding == null || argument2Binding == null)
				return setFeature(false);
			
			if (argument1Binding.isEqualTo(argument2Binding)) {
				// refer to the same field or variable
				// see how many times it is assigned with non-null.
				CompilationUnit compilationUnit = (CompilationUnit) methodInvocation1.getRoot();
				// check the initializer first.
				VariableDeclarationFragment variableDeclarationFragment = ASTUtils.getVariableDeclarationFragmentNode((IVariableBinding) argument1Binding, compilationUnit);
				
				// return true if the field is private.
				FieldDeclaration fieldDeclaration = (FieldDeclaration) variableDeclarationFragment.getParent();
				
				// assume true, because the default visibility is private
				result = true;
				for (Object modifierObject : fieldDeclaration.modifiers()) {
					if (modifierObject instanceof Modifier) {
						Modifier modifier = (Modifier) modifierObject;
						if (modifier.isPublic() || modifier.isProtected()) {
							// See if the field is assigned outside of the context class.
							IField iField = (IField) ((IVariableBinding) argument1Binding).getJavaElement();
							try {
								Collection<FieldReferenceMatch> writeAccesses = JavaModelUtils.writesToField(contextIJavaProject, iField, progressMonitor);
								IType fieldTopLevelType = JavaModelUtils.getTopLevelType(iField);
								String fieldTopLevelTypeKey = fieldTopLevelType.getKey();
								
								for (FieldReferenceMatch writeAccess : writeAccesses) {
									Object matchElement = writeAccess.getElement();
									if (matchElement instanceof IJavaElement) {
										IJavaElement matchJavaElement = (IJavaElement) matchElement;
										IType writeAccessIType = JavaModelUtils.getTopLevelType(matchJavaElement);
										String topLevelKey = writeAccessIType.getKey();
										if (writeAccessIType != null && !fieldTopLevelTypeKey.equals(topLevelKey))
											createMarkerDescriptor(writeAccess, null, "external assignment");
									}
								}
							} catch (JavaModelException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
				
				OccurrencesFinder occurrencesFinder = new OccurrencesFinder();
				occurrencesFinder.initialize(compilationUnit, variableDeclarationFragment.getName());
				
				occurrencesFinder.performGlobally();
				
				for (ASTNode astNode : occurrencesFinder.getWriteUsages())
					createMarkerDescriptor(astNode.getParent(), null, "assignment");
			}
		}
		if (result) {
			createMarkerDescriptor(argument1, null, "object");
			createMarkerDescriptor(argument2, null, "object");
		}
		return setFeature(result);
	}
}
