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

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.JavaImplVariantManagerConstants;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class ImplementsInterfaceMapping extends JavaMapping {
	public ImplementsInterfaceMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public ImplementsInterfaceMapping(EObject element, EStructuralFeature feature, EStructuralFeature essentialFeature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, essentialFeature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public ImplementsInterfaceMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}
	@Context(mode=Mode.REVERSE)
	public IType contextIType;
	
	@Context(mode=Mode.FORWARD)
	public TypeDeclaration contextTypeDeclaration;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_NAME, mode=Mode.ALL, required=true)
	public String detailName;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCAL, mode=Mode.REVERSE_ESSENTIAL, defaultValue="false")
	public String detailLocal;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_CONCRETE, mode=Mode.REVERSE_ESSENTIAL, defaultValue="false")
	public String detailConcrete;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_ABSTRACT, mode=Mode.REVERSE_ESSENTIAL, defaultValue="false")
	public String detailAbstract;
	
	@Override
	protected boolean forward() {
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			CodeTransforms.addInterfaceDeclaration(contextIJavaProject, null, contextTypeDeclaration, detailName, progressMonitor);
			break;
		case CODE_REMOVE:
			CodeTransforms.removeInterfaceDeclaration(null, contextTypeDeclaration, detailName, progressMonitor);
			break;
		}
		return true;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		try {
			if (typeHierarchy.implementsOrExtendsType(contextIType, detailName)) {
				// find super interface type
				Type foundType = null;
				String foundTypefullyQuallifiedName="";
				
				TypeDeclaration typeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
				if (typeDeclaration != null) {
					for (Object auxSuperType : typeDeclaration.superInterfaceTypes()) {
						Type superInterface = (Type) auxSuperType;
						ITypeBinding binding = superInterface.resolveBinding();
						if (binding != null && binding.getQualifiedName().equals(detailName)) {
							foundType = superInterface;
							foundTypefullyQuallifiedName = binding.getQualifiedName();
							break;
						}
					}
				}
				boolean result = setFeatureContextAndMarker(true, null, foundType, null);
				if (javaInterpreter.analyzeImplVariants()) {
					//analyze implementation variants
						if (foundTypefullyQuallifiedName.equals(detailName)) {
							
							Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"directly");
							EClass targetClass = javaImplVariantManager.getVariantEClass(JavaImplVariantManagerConstants.VARIANT+
									JavaImplVariantManagerConstants.DELIMITER+
									annotation.getSource() + JavaImplVariantManagerConstants.DELIMITER
									+ JavaImplVariantManagerConstants.DIRECTLY);
							EObject child = EcoreUtil.create(targetClass);
							
							((EList) javaImplVariantManager.getModel().eGet(javaImplVariantManager.getVariantsReference())).add(child);
							child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ECLASS), element.eClass().getName());
							child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ESTRUCTURALFEATURE), feature.getName());
						} else {
							Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"indirectly: "+contextIType.getSuperclassName());
							EClass targetClass = javaImplVariantManager.getVariantEClass(JavaImplVariantManagerConstants.VARIANT+
									JavaImplVariantManagerConstants.DELIMITER+
									annotation.getSource() + JavaImplVariantManagerConstants.DELIMITER
									+ JavaImplVariantManagerConstants.INDIRECTLY);
							EObject child = EcoreUtil.create(targetClass);
							
							((EList) javaImplVariantManager.getModel().eGet(javaImplVariantManager.getVariantsReference())).add(child);
							child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.INTERFACE_NAME), foundTypefullyQuallifiedName);
							child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ECLASS), element.eClass().getName());
							child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ESTRUCTURALFEATURE), feature.getName());
						}
				}				
				return result;
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}	
		return setFeature(false);
	}
	@Override
	protected boolean reverseEssential() throws FSMLMappingException {
		boolean localOnly = "true".equals(detailLocal);
		boolean concreteOnly = "true".equals(detailConcrete);
		boolean abstractOnly = "true".equals(detailAbstract);
		
		try {
			IType iType = contextIJavaProject.findType(detailName);
			List<IType> subtypes = JavaModelUtils.getSubtypesOfType(iType, contextIJavaProject, localOnly, concreteOnly, abstractOnly, progressMonitor);
			for (IType type : subtypes) {
				setFeatureContextAndMarker(true, type, type, null);
			}
			return FSMLEcoreUtil.isFeaturePresent(element, feature);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return false;
	}
}
