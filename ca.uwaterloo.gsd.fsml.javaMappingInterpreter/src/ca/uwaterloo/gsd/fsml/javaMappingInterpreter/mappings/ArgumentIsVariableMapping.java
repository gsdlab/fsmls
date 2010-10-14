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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class ArgumentIsVariableMapping extends ArgumentIs_Mapping {
	public ArgumentIsVariableMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		if (!feature.getEType().getName().equals("EString"))
			throw new FSMLMappingException(Cause.INCORRECT_TYPE, "feature must be of type EString: " + feature);
	}
	public ArgumentIsVariableMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SAME_AS, mode=Mode.NONE)
	public String detailSameAs;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		if (syncItem instanceof ClassSyncItem)
			throw new FSMLMappingException(Cause.MAPPING_REQUIRES_ATTRIBUTE, syncItem.getModel().eContainingFeature());
		
		StructuralFeatureSyncItem featureSyncItem = (StructuralFeatureSyncItem) syncItem;
		EAttribute variableNameFeature = (EAttribute) featureSyncItem.getStructuralFeature();
		
		
		String detailType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_CLASS, true);
		IType instanceType;
		try {
			instanceType = contextIJavaProject.findType(detailType);
			boolean annonymousSubclass = instanceType.isInterface() || (instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()));
			String detailSignature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, "()V");
			
			EObject element = syncItem.getModel();
			String variableName = (String) element.eGet(variableNameFeature);
			
			
			switch (syncItem.getReconciliationAction()) {
			case CODE_ADD:
				if (contextMethodInvocation != null) {
					Expression expression = CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, variableName, progressMonitor);
					CodeTransforms.declareVariable(contextIJavaProject, null, contextMethodInvocation, variableName, detailType, null, detailSignature, annonymousSubclass, progressMonitor);
					return expression != null;
				}	
				if (contextClassInstanceCreation != null) {
					Expression expression =  CodeTransforms.replaceMethodCallArgument(null, contextClassInstanceCreation, index, variableName, progressMonitor);
					CodeTransforms.declareVariable(contextIJavaProject, null, contextClassInstanceCreation, variableName, detailType, null, detailSignature, annonymousSubclass, progressMonitor);
					return expression != null;
				}
				break;
			case CODE_REMOVE:
				if (contextMethodInvocation != null)
					return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
				if (contextClassInstanceCreation != null)
					return CodeTransforms.replaceMethodCallArgument(null, contextClassInstanceCreation, index, "null", progressMonitor) != null;
				break;
			}
		} catch (JavaModelException e) {
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, feature);
		}
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		// could be a method invocation or class instance creation
		ASTNode argument = null;
		if (contextMethodInvocation != null)
			argument = (ASTNode) contextMethodInvocation.arguments().get(index);
		else if (contextClassInstanceCreation != null)
			argument = (ASTNode) contextClassInstanceCreation.arguments().get(index);
		
		if (argument instanceof SimpleName) {
			SimpleName simpleName = (SimpleName) argument;
			IBinding binding = simpleName.resolveBinding();
			if (binding instanceof IVariableBinding) {
				IVariableBinding variableBinding = (IVariableBinding) binding;
				if (!variableBinding.isField()) {
					Stats.INSTANCE.logMessage(element.eClass().getName() + "::" + feature.getName() + " <argumentIsVariable> argument is a variable");
					if (feature.getEType().getName().equals("EString"))
						return setFeatureContextAndMarker(simpleName.getIdentifier(), null, argument, null);
					else
						return setFeatureContextAndMarker(true, null, argument, null);
				}
			}
		}
		if (feature.getEType().getName().equals("EString"))
			return setFeature((String) null);
		else
			return setFeature(false);	
	}

}
