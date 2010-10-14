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
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.MethodInvocation;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public abstract class ArgumentIs_Mapping extends JavaMapping {
	/**
	 * Constructor used in reverse engineering.
	 * @param element
	 * @param feature
	 * @param annotation
	 * @param concreteChildType
	 * @param interpreter
	 * @param progressMonitor
	 * @throws FSMLMappingException
	 */
	public ArgumentIs_Mapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		// exactly one of them must be non-null
		if ((contextMethodInvocation == null && contextClassInstanceCreation == null) ||
			   (contextMethodInvocation != null && contextClassInstanceCreation != null))
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, "MethodInvocation XOR ClassInstanceCreation");
	}
	/**
	 * Constructor used in forward engineering.
	 * @param syncItem
	 * @param annotation
	 * @param interpreter
	 * @param progressMonitor
	 * @throws FSMLMappingException
	 */
	public ArgumentIs_Mapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
		
		if (detailIndex != null && !detailIndex.isEmpty()) {
			try {
				index = Integer.parseInt(detailIndex);
			}
			catch (NumberFormatException e) {
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, " of detail " + JavaMappingInterpreter.DETAIL_INDEX);
			}
		}
	}
	@Context(mode=Mode.FORWARD_AND_REVERSE, excludes="contextClassInstanceCreation")
	public MethodInvocation contextMethodInvocation;
	
	@Context(mode=Mode.FORWARD_AND_REVERSE, excludes="contextMethodInvocation")
	public ClassInstanceCreation contextClassInstanceCreation;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_INDEX, mode=Mode.ALL, required=true)
	public String detailIndex;
	
	int index;
}
