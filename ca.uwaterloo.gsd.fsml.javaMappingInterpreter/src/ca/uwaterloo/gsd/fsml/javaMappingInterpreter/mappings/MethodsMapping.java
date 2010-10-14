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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class MethodsMapping extends JavaMapping {
	
	public MethodsMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		javaInterpreter = interpreter;
		// if there is no name for the method, search for a constructor, using the name of the context class.
		if (!feature.getEType().getName().equals("EString") && name == null)
			name = contextIType != null ? contextIType.getElementName() : contextTypeDeclaration.getName().getIdentifier();
	}
	public MethodsMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(
			syncItem, 
			(syncItem instanceof ClassSyncItem ? 
				(syncItem.getModel() != null ?
						syncItem.getModel().eContainingFeature().getEAnnotation(JavaMappingInterpreter.QUERY_METHODS) :
						syncItem.getCode().eContainingFeature().getEAnnotation(JavaMappingInterpreter.QUERY_METHODS))
				: annotation), 
			interpreter, 
			progressMonitor);
		javaInterpreter = interpreter;
	}
	@Context(mode=Mode.REVERSE)
	public IType contextIType;
	
	@Context(mode=Mode.FORWARD)
	public TypeDeclaration contextTypeDeclaration;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_NAME, mode=Mode.ALL)
	public String name;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SIGNATURE, mode=Mode.ALL, defaultValue="()V")
	public String signature;

	@Parameter(name=JavaMappingInterpreter.DETAIL_INHERITED, mode=Mode.REVERSE, defaultValue="true")
	public String inherited;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		// create the method
		boolean result = false;
		MethodDeclaration methodDeclaration;
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			methodDeclaration = CodeTransforms.createMethod(contextIJavaProject, null, contextTypeDeclaration, "public", name, signature, null, progressMonitor);
			contextManager.associateContext(element, methodDeclaration);
			result = true;
			break;
		case CODE_REMOVE:
			methodDeclaration = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
			if (methodDeclaration != null)
				CodeTransforms.commentOutASTNode(null, methodDeclaration, element.eClass(), feature, progressMonitor);
			break;
		}
		return result;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {
		try {
			// get names of methods with the given signature
			if (feature.getEType().getName().equals("EString")) {
				boolean found = false;
				for (IMethod iMethod : contextIType.getMethods()) {
					String iMethodName = iMethod.getElementName();
					
					IMethod potentialTargetMethod = contextIType.getMethod(iMethodName, Signature.getParameterTypes(signature));
					
					if (iMethod.isSimilar(potentialTargetMethod)) {
						if (javaInterpreter.analyzeImplVariants()) {
							//still need to analyze implementation variants here?
							Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"no variants...");
						}					
						found = true;
						
						setFeatureContextAndMarker(iMethodName, iMethod, iMethod, feature.isMany() ? iMethodName : null);
					}
				}
				return setFeature(found);
			} 
			else if (feature.getEType().getName().equals("EBoolean") || feature instanceof EReference) {
				if (!feature.isMany()) {
					boolean includeInherited = inherited != null && inherited.equals("true");
					IMethod iMethod = JavaModelUtils.findMethod(contextIJavaProject, name, signature, contextIType, true, includeInherited, progressMonitor);
					
					if (iMethod != null && iMethod.exists()) {
						if (javaInterpreter.analyzeImplVariants()) {
							//analyze implementation variants
							if (!includeInherited) {
								Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"implements (as required)");
							} else {
								IMethod localMethod = JavaModelUtils.findMethod(contextIJavaProject, name, signature, contextIType, true, false, progressMonitor);
								if (localMethod==null) {
									Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"inheritsFrom: "+contextIType.getSuperclassName());							
								} else {
									//check if the method is in the super classes
									IMethod ancestorMethods = JavaModelUtils.findMethod(contextIJavaProject, name, signature, contextIType, false, true, progressMonitor);
									if (ancestorMethods==null) {				
										Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"implements");
									} else {
										Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"overrides");			
									}
								}
							}
						}
						return setFeatureContextAndMarker(true, iMethod, iMethod, null);
					}
				}
			}
			return setFeature(false); 
		} catch (JavaModelException e) {
			e.printStackTrace();
			return setFeature(false); 
		}
	}
}
