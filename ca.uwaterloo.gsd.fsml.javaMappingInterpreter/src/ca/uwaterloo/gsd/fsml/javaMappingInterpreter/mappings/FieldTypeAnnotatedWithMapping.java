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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class FieldTypeAnnotatedWithMapping extends JavaMapping {
	public FieldTypeAnnotatedWithMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public FieldTypeAnnotatedWithMapping(EObject element, EStructuralFeature feature, EStructuralFeature essentialFeature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, essentialFeature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public FieldTypeAnnotatedWithMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
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
		if (FSMLEcoreUtil.getEAnnotation(element.eClass(),JavaMappingInterpreter.CONTEXT_FIELD) != null)
			bodyDeclaration = (BodyDeclaration) contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor).getParent(); 
		else
			return false; 
		
		if (!(bodyDeclaration instanceof FieldDeclaration)){
			return false; 
		}
		FieldDeclaration fd = (FieldDeclaration) bodyDeclaration;
		for (IAnnotationBinding annotationBinding : fd.getType().resolveBinding().getAnnotations()) {
			if (fullyQualifiedName.equalsIgnoreCase(annotationBinding.getAnnotationType().getQualifiedName())|| simpleAnnotationType.equalsIgnoreCase(annotationBinding.getAnnotationType().getName())){
				return setFeatureContextAndMarker(true, fd, fd , null);	
			}
		}
		return setFeature(false);
	}
	@Override
	protected boolean reverseEssential() throws FSMLMappingException {
		try {
			IType annotationType = contextIJavaProject.findType(fullyQualifiedName);
			if (annotationType == null || !annotationType.exists())
				return false; 
						
			if (FSMLEcoreUtil.getEAnnotation(concreteChildType, JavaMappingInterpreter.CONTEXT_FIELD) != null) {
				TypeDeclaration contextTypeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
				for (FieldDeclaration fd : contextTypeDeclaration.getFields()) {
					for (IAnnotationBinding annotationBinding : fd.getType().resolveBinding().getAnnotations()) {
						if (fullyQualifiedName.equalsIgnoreCase(annotationBinding.getAnnotationType().getQualifiedName())){
							for (Object objVDF : fd.fragments()) {
								VariableDeclarationFragment vdf = (VariableDeclarationFragment) objVDF;
								EObject child = EcoreUtil.create(concreteChildType);
								contextManager.associateContext(child, vdf);
								setFeatureContextAndMarker(true, vdf, vdf, null);								
							}
						}
					}
				}
				return FSMLEcoreUtil.isFeaturePresent(element, feature);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return false;
	}
}
