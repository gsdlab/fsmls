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
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class MethodNameMapping extends JavaMapping {

	public MethodNameMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}

	private MethodNameMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}

	@Context(mode=Mode.REVERSE)
	public IMethod contextIMethod;
	
	@Context(mode=Mode.REVERSE)
	public MethodDeclaration contextMethodDeclaration;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		// TODO Implement rename
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		if (contextIMethod != null){
			return setFeatureContextAndMarker(contextIMethod.getElementName(), null, contextIMethod, null);
		}
		if (contextMethodDeclaration != null){
			return setFeatureContextAndMarker(contextMethodDeclaration.getName().getFullyQualifiedName(), null, contextMethodDeclaration, null);
		}
		return setFeature(false); 
	}
}
