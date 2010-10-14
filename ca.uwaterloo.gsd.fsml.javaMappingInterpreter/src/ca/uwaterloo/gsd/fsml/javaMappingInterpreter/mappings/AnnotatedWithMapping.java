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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.core.search.TypeReferenceMatch;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class AnnotatedWithMapping extends JavaMapping {
	public AnnotatedWithMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public AnnotatedWithMapping(EObject element, EStructuralFeature feature, EStructuralFeature essentialFeature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, essentialFeature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public AnnotatedWithMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}

	@Parameter(name=JavaMappingInterpreter.DETAIL_FULLY_QUALIFIED_TYPE, mode=Mode.ALL, required=true) 
	public String fullyQualifiedName; 
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		
		String simpleAnnotationType = Signature.getSimpleName(fullyQualifiedName); 
		
		BodyDeclaration bodyDeclaration = null;
		if (FSMLEcoreUtil.getEAnnotation(element.eClass(),JavaMappingInterpreter.CONTEXT_METHOD) != null)
			//we have a method
			bodyDeclaration = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
		else if (FSMLEcoreUtil.getEAnnotation(element.eClass(),JavaMappingInterpreter.CONTEXT_FIELD) != null)
			bodyDeclaration = (BodyDeclaration) contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor).getParent(); 
		else if (FSMLEcoreUtil.getEAnnotation(element.eClass(),JavaMappingInterpreter.CONTEXT_CLASS) != null)
			//we have a class
			bodyDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
		else
			return setFeature(false); 
		
		boolean foundDesiredAnnotation = false; 
		Annotation foundAnnotation = null;
		for (Object modifier : bodyDeclaration.modifiers()) {
			if (modifier instanceof Annotation){
				String modifierType = ((Annotation)modifier).getTypeName().getFullyQualifiedName(); 
				if (fullyQualifiedName.equalsIgnoreCase(modifierType)
						|| simpleAnnotationType.equalsIgnoreCase(modifierType)){
					foundDesiredAnnotation = true;
					foundAnnotation  = (Annotation) modifier;
					break; 
				}
			}
		}
		if (!foundDesiredAnnotation){
			return setFeature(false); 
		}
		return setFeatureContextAndMarker(true, foundAnnotation, feature instanceof EAttribute ? bodyDeclaration : foundAnnotation, null);
	}
	@Override
	protected boolean reverseEssential() throws FSMLMappingException {
		try {
			IType annotationType = contextIJavaProject.findType(fullyQualifiedName);
			if (annotationType == null || !annotationType.exists())
				return false; 
			
			if (FSMLEcoreUtil.getEAnnotation(concreteChildType, JavaMappingInterpreter.CONTEXT_FIELD) != null) {
				TypeDeclaration contextTypeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
				List<VariableDeclarationFragment> fields = ASTUtils.getFieldsAnnotatedWithType(contextTypeDeclaration, fullyQualifiedName, progressMonitor);
				for (VariableDeclarationFragment field : fields)
					setFeatureContextAndMarker(true, field, field, null);
				
				return FSMLEcoreUtil.isFeaturePresent(element, feature);
			}
			if (FSMLEcoreUtil.getEAnnotation(concreteChildType, JavaMappingInterpreter.CONTEXT_METHOD) != null) {
				TypeDeclaration contextTypeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
				List<MethodDeclaration> methods = ASTUtils.getMethodsAnnotatedWithType(contextTypeDeclaration, fullyQualifiedName, progressMonitor);
				for (MethodDeclaration method : methods)
					setFeatureContextAndMarker(true, method, method, null);
				
				return FSMLEcoreUtil.isFeaturePresent(element, feature);
			}
			else if (FSMLEcoreUtil.getEAnnotation(concreteChildType, JavaMappingInterpreter.CONTEXT_CLASS) != null) {
				final ArrayList<TypeReferenceMatch> found =  new ArrayList<TypeReferenceMatch>();
				SearchPattern pattern = SearchPattern.createPattern(annotationType, IJavaSearchConstants.REFERENCES);
			    // Create search scope
			    IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { contextIJavaProject });
			    SearchRequestor requestor = new SearchRequestor(){
			    	@Override
			    	public void acceptSearchMatch(SearchMatch match) throws CoreException {
			    		
			    		if (match instanceof TypeReferenceMatch){
			    			if (match.getElement() instanceof IType){
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
					IType type = (IType) typeReferenceMatch.getElement();
					setFeatureContextAndMarker(true, type, type, null);
				}
				return FSMLEcoreUtil.isFeaturePresent(element, feature);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return false;
	}
}
