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

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.search.FieldReferenceMatch;
import org.eclipse.jdt.internal.core.ResolvedSourceMethod;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeQueries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.JavaImplVariantManagerConstants;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class AssignedWithNullMapping extends JavaMapping {

	public AssignedWithNullMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
	}

	public AssignedWithNullMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem, annotation, interpreter, progressMonitor);
		
		// exactly one of them must be non-null
		if ((contextMethodDeclaration == null && contextTypeDeclaration == null) ||
			   (contextMethodDeclaration != null && contextTypeDeclaration != null))
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, "MethodDeclaration XOR TypeDeclaration");
		
		if (detailPosition == null || detailPosition.equals("before"))
			position = CodeTransforms.BEFORE_ADVICE;
		else if (detailPosition.equals("after"))
			position = CodeTransforms.AFTER_ADVICE;
		else {
			try {
				position = Integer.parseInt(detailPosition);
			} catch (Exception e){
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, "for detail " + JavaMappingInterpreter.DETAIL_POSITION);
			}
		}

	}

	@Context(mode=Mode.REVERSE)
	public IField contextIField;

	@Context(mode=Mode.FORWARD)
	public VariableDeclarationFragment contextVariableDeclarationFragment;
	
	@Context(mode=Mode.FORWARD, excludes="contextMethodDeclaration")
	public TypeDeclaration contextTypeDeclaration;
	
	@Context(mode=Mode.FORWARD, excludes="contextTypeDeclaration")
	public MethodDeclaration contextMethodDeclaration;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCATION_NAME, mode=Mode.FORWARD, required=true)
	public String locationName;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCATION_SIG, mode=Mode.FORWARD, defaultValue="()V")
	public String locationSig;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_POSITION, mode=Mode.FORWARD, defaultValue="after")
	public String detailPosition;
	
	int position = 0;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		// construct an assignment
		String contents = contextVariableDeclarationFragment.getName().getIdentifier() + " = null;";
		
		// field assignment can be created in the context method or a context class
		if (contextMethodDeclaration != null) {
			CodeTransforms.weaveAdvice(position, null, contextMethodDeclaration, contents, progressMonitor);
			return true;
		}
		// no context method, try context class
		if (contextTypeDeclaration != null) { 
			MethodDeclaration contextMethod = ASTUtils.findMethod(javaAstManager, locationName, locationSig, contextTypeDeclaration, true, false, progressMonitor);
			if (contextMethod != null) {
				CodeTransforms.weaveAdvice(position, null, contextMethod, contents, progressMonitor);
				return true;
			}
			else {
				// create the method
				CodeTransforms.createMethod(contextIJavaProject, null, contextTypeDeclaration, "public", locationName, locationSig, "\t" + contents, progressMonitor);
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {		
		if (contextIField != null) {
			Collection<FieldReferenceMatch> result;
			try {
				result = JavaModelUtils.writesToField(contextIJavaProject, contextIField, progressMonitor);
				for (FieldReferenceMatch fieldReferenceMatch : result) {
					Expression rhs = CodeQueries.retrieveRHSFromMatch(javaAstManager, fieldReferenceMatch, progressMonitor);
					if (rhs instanceof NullLiteral){
						
						if (javaInterpreter.analyzeImplVariants()){
							EClass targetClass = javaImplVariantManager.getVariantEClass(JavaImplVariantManagerConstants.VARIANT+
									JavaImplVariantManagerConstants.DELIMITER+
									annotation.getSource() + JavaImplVariantManagerConstants.DELIMITER
									+ JavaImplVariantManagerConstants.IN_METHOD);
	
							EObject child = EcoreUtil.create(targetClass);
	
							((EList) javaImplVariantManager.getModel().eGet(javaImplVariantManager.getVariantsReference())).add(child);
							child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.METHOD_NAME),
									((ResolvedSourceMethod)fieldReferenceMatch.getElement()).getElementName() );
							child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ECLASS), element.eClass().getName());
							child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ESTRUCTURALFEATURE), feature.getName());
							Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation,"InMethod: "+((ResolvedSourceMethod)fieldReferenceMatch.getElement()).getElementName());
						}						
						return setFeatureContextAndMarker(true, null, rhs.getParent(), null);
					}
					else {
						// see if it is a variable with null value
						if (rhs.getNodeType() == ASTNode.SIMPLE_NAME)
							// TODO: 
							;
					}
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		return setFeature(false);
	}
}
