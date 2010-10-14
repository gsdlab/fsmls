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
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.JavaImplVariantManagerConstants;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class TypedWithMapping extends JavaMapping {

	public TypedWithMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public TypedWithMapping(EObject element, EStructuralFeature feature, EStructuralFeature essentialFeature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, essentialFeature, annotation, concreteChildType, interpreter, progressMonitor);
	}
	public TypedWithMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
	}

	@Context(mode=Mode.REVERSE, required=true)
	public VariableDeclarationFragment contextVariableDeclarationFragment;
	
	@Context(mode=Mode.REVERSE_ESSENTIAL, required=true)
	public TypeDeclaration contextClass;

	@Parameter(name=JavaMappingInterpreter.DETAIL_NAME, mode=Mode.ALL, required=true)
	public String name;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		return true;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {		
		if (contextVariableDeclarationFragment != null) {
			String currentType = contextVariableDeclarationFragment.resolveBinding().getType().getQualifiedName();
			
			boolean result = name.equals(currentType);
			
			if (!result) {
				IType fieldIType = (IType) contextVariableDeclarationFragment.resolveBinding().getType().getJavaElement();
				try {
					result = typeHierarchy.implementsOrExtendsType(fieldIType, name);
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
			}
			
			
			if (result) {
				FieldDeclaration fieldDeclaration = (FieldDeclaration) contextVariableDeclarationFragment.getParent();


				if (javaInterpreter.analyzeImplVariants()) {
					//analyze implementation variants

						
					if (name.equals(currentType)) {
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
						EClass targetClass = javaImplVariantManager.getVariantEClass(JavaImplVariantManagerConstants.VARIANT+
								JavaImplVariantManagerConstants.DELIMITER+
								annotation.getSource() + JavaImplVariantManagerConstants.DELIMITER
								+ JavaImplVariantManagerConstants.INDIRECTLY);
						EObject child = EcoreUtil.create(targetClass);
						
						((EList) javaImplVariantManager.getModel().eGet(javaImplVariantManager.getVariantsReference())).add(child);
						child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.CLASS_NAME), currentType);
						child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ECLASS), element.eClass().getName());
						child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ESTRUCTURALFEATURE), feature.getName());
						Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"indirectly: "+currentType);
					}
				}			
				
				return setFeatureContextAndMarker(result, null, fieldDeclaration.getType(), null);
			}
		}
		return setFeature(false);
	}
	
	@Override
	protected boolean reverseEssential() throws FSMLMappingException {
		List<VariableDeclarationFragment> fields = ASTUtils.getFieldsTypedWithType(contextClass, name, typeHierarchy, progressMonitor);
		
		for (VariableDeclarationFragment field : fields)
			setFeatureContextAndMarker(true, field, field, null);
		
		return FSMLEcoreUtil.isFeaturePresent(element, feature);
	}
}
