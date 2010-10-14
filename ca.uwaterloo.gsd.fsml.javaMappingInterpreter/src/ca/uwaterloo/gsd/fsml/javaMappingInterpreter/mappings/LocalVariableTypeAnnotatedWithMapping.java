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
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class LocalVariableTypeAnnotatedWithMapping extends JavaMapping {
	public LocalVariableTypeAnnotatedWithMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public LocalVariableTypeAnnotatedWithMapping(EObject element, EStructuralFeature feature, EStructuralFeature essentialFeature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, essentialFeature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public LocalVariableTypeAnnotatedWithMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
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
		
		VariableDeclarationStatement bodyDeclaration = null;
		if (FSMLEcoreUtil.getEAnnotation(element.eClass(),JavaMappingInterpreter.CONTEXT_LOCAL_VARIABLE) != null)
			bodyDeclaration = (VariableDeclarationStatement) contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor).getParent(); 
		else
			return setFeature(false); 
		
		if (!(bodyDeclaration instanceof VariableDeclarationStatement)){
			return setFeature(false);
		}
		VariableDeclarationStatement vds = (VariableDeclarationStatement) bodyDeclaration;
		for (IAnnotationBinding annotationBinding : vds.getType().resolveBinding().getAnnotations()) {
			if (fullyQualifiedName.equalsIgnoreCase(annotationBinding.getAnnotationType().getQualifiedName())|| simpleAnnotationType.equalsIgnoreCase(annotationBinding.getAnnotationType().getName())){
				return setFeatureContextAndMarker(true, vds, vds , null);	
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
						
			if (FSMLEcoreUtil.getEAnnotation(concreteChildType, JavaMappingInterpreter.CONTEXT_LOCAL_VARIABLE) != null) {
				TypeDeclaration contextTypeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);				
				//now check methods
				for (MethodDeclaration md : contextTypeDeclaration.getMethods()) {
					if (md.getBody() == null){
						continue; 
					}
					for (Object objStatement : md.getBody().statements()) {
						if (objStatement instanceof VariableDeclarationStatement){
							checkVariableDeclarationStatementForAppropriateFragments((VariableDeclarationStatement)objStatement);
						}
						else if (objStatement instanceof TryStatement){
							for (Object objInnerStatement : ((TryStatement)objStatement).getBody().statements()) {
								if (objInnerStatement instanceof VariableDeclarationStatement){
									checkVariableDeclarationStatementForAppropriateFragments((VariableDeclarationStatement)objInnerStatement);
								}
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
	/**
	 * @param objStatement
	 * @throws FSMLMappingException
	 */
	private void checkVariableDeclarationStatementForAppropriateFragments(
			VariableDeclarationStatement vds) throws FSMLMappingException {
		for (IAnnotationBinding annotationBinding : vds.getType().resolveBinding().getAnnotations()) {
			if (fullyQualifiedName.equalsIgnoreCase(annotationBinding.getAnnotationType().getQualifiedName())){
				for (Object objVDF : vds.fragments()) {
					VariableDeclarationFragment vdf = (VariableDeclarationFragment) objVDF;
					EObject child = EcoreUtil.create(concreteChildType);
					contextManager.associateContext(child, vdf);
					setFeatureContextAndMarker(true, vdf, vdf, null);								
				}
			}
		}
	}
}
