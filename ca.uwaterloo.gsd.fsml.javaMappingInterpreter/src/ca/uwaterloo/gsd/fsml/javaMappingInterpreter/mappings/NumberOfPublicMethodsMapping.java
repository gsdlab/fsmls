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
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class NumberOfPublicMethodsMapping extends JavaMapping {
	public NumberOfPublicMethodsMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public NumberOfPublicMethodsMapping(EObject element, EStructuralFeature feature, EStructuralFeature essentialFeature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, essentialFeature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public NumberOfPublicMethodsMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		BodyDeclaration bodyDeclaration = null;
		if (FSMLEcoreUtil.getEAnnotation(element.eClass(),JavaMappingInterpreter.CONTEXT_CLASS) != null)
			//we have a class
			bodyDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
		else
			return setFeature(false);
		
		ArrayList<String> excludesList = new ArrayList<String>();
		if (annotation.getDetails().get("excludes") != null){
			StringTokenizer st = new StringTokenizer(annotation.getDetails().get("excludes"),",");
			while (st.hasMoreTokens()){
				excludesList.add(st.nextToken());
			}
		}
		int publicMethodCount = 0; 
		TypeDeclaration type = (TypeDeclaration) bodyDeclaration;
		for (org.eclipse.jdt.core.dom.MethodDeclaration method : type.getMethods()) {
			if (excludesList.contains(method.getName().getFullyQualifiedName())){
				continue; 
			}
			for (Object modifier : method.modifiers()) {
				if (modifier instanceof Modifier){
					if ("public".equalsIgnoreCase(((Modifier)modifier).getKeyword().toString())){
						publicMethodCount++;
						break;
					}
				}
			}
		}
		return setFeatureContextAndMarker(String.valueOf(publicMethodCount), bodyDeclaration, bodyDeclaration, null);
	}
}
