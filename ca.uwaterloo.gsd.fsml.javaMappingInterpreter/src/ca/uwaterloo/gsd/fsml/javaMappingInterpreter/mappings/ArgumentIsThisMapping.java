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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ThisExpression;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class ArgumentIsThisMapping extends ArgumentIs_Mapping {
	public ArgumentIsThisMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public ArgumentIsThisMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SAME_AS, mode=Mode.NONE)
	public String detailSameAs;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			if (contextMethodInvocation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "this", progressMonitor) != null;
			if (contextClassInstanceCreation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextClassInstanceCreation, index, "this", progressMonitor) != null;
		case CODE_REMOVE:
			if (contextMethodInvocation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
			if (contextClassInstanceCreation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextClassInstanceCreation, index, "null", progressMonitor) != null;
		}
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		ASTNode argument = null;
		if (contextMethodInvocation != null)
			argument = (ASTNode) contextMethodInvocation.arguments().get(index);
		if (contextClassInstanceCreation != null)
			argument = (ASTNode) contextClassInstanceCreation.arguments().get(index);
		
		if (argument instanceof ThisExpression)
			Stats.INSTANCE.logMessage(element.eClass().getName() + "::" + feature.getName() + " <argumentIsThis> argument is this expression");
		else
			return setFeature(false);
		
		return setFeatureContextAndMarker(true, argument, argument, null);
	}
}
