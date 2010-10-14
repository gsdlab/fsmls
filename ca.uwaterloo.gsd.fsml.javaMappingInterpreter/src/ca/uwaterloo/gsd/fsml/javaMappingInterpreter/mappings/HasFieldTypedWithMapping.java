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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.core.search.TypeReferenceMatch;
import org.eclipse.jdt.internal.core.ResolvedSourceField;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class HasFieldTypedWithMapping extends JavaMapping {
	public HasFieldTypedWithMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public HasFieldTypedWithMapping(EObject element, EStructuralFeature feature, EStructuralFeature essentialFeature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, essentialFeature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public HasFieldTypedWithMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}

	@Parameter(name=JavaMappingInterpreter.DETAIL_FULLY_QUALIFIED_NAME, mode=Mode.REVERSE, required=true) 
	public String fullyQualifiedName; 
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		
		String simpleAnnotationType = Signature.getSimpleName(fullyQualifiedName); 
		
		BodyDeclaration bodyDeclaration = null;
		if (FSMLEcoreUtil.getEAnnotation(element.eClass(),JavaMappingInterpreter.CONTEXT_CLASS) != null)
			//we have a class
			bodyDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
		else
			return setFeature(false);
		TypeDeclaration type = (TypeDeclaration) bodyDeclaration;
		boolean foundDesiredType = false; 
		FieldDeclaration fieldFound = null;
		for (FieldDeclaration field : type.getFields()) {
			String fieldType = field.getType().resolveBinding().getQualifiedName(); 
			if (fullyQualifiedName.equalsIgnoreCase(fieldType)){
				foundDesiredType = true;
				fieldFound = field;
				break; 
			}
		}
		if (!foundDesiredType){
			return setFeature(false); 
		}
		return setFeatureContextAndMarker(true, fieldFound, feature instanceof EAttribute ? bodyDeclaration : fieldFound, null);
	}
	@Override
	protected boolean reverseEssential() throws FSMLMappingException {
		try {
			IType desiredType = contextIJavaProject.findType(fullyQualifiedName);
			if (desiredType == null || !desiredType.exists())
				return false; 
			
			if (FSMLEcoreUtil.getEAnnotation(concreteChildType, JavaMappingInterpreter.CONTEXT_CLASS) != null) {
				final ArrayList<TypeReferenceMatch> found =  new ArrayList<TypeReferenceMatch>();
				SearchPattern pattern = SearchPattern.createPattern(desiredType, IJavaSearchConstants.REFERENCES);
			    // Create search scope
			    IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { contextIJavaProject });
			    SearchRequestor requestor = new SearchRequestor(){
			    	@Override
			    	public void acceptSearchMatch(SearchMatch match) throws CoreException {
			    		
			    		if (match instanceof TypeReferenceMatch){ 
			    			if (match.getElement() instanceof ResolvedSourceField){
			    				found.add((TypeReferenceMatch)match);
			    			}
			    		}
			    	}
			    };
			    SearchEngine searchEngine = new SearchEngine();
			    try {
					searchEngine.search(pattern, new SearchParticipant[] {SearchEngine.getDefaultSearchParticipant()}, scope, requestor, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}

				for (TypeReferenceMatch typeReferenceMatch : found) {
					IField field = (IField) typeReferenceMatch.getElement();
					IType declaringType = field.getDeclaringType();
					setFeatureContextAndMarker(true, declaringType, declaringType, null);
				}
				return FSMLEcoreUtil.isFeaturePresent(element, feature);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return false;
	}
}
