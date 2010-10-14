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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.search.FieldReferenceMatch;
import org.eclipse.jdt.internal.core.ResolvedSourceMethod;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Parameter;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeQueries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.CodeTransforms;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.JavaImplVariantManagerConstants;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public class AssignedWithNewMapping extends JavaMapping {

	public AssignedWithNewMapping(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		
		subtypeOf = ! detailSubtypeOf.isEmpty();
	}

	public AssignedWithNewMapping(SyncItem syncItem, EAnnotation annotation, JavaMappingInterpreter interpreter, IProgressMonitor progressMonitor) throws FSMLMappingException {
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
		
		subtypeOf = ! detailSubtypeOf.isEmpty();
		
		if (subtypeOf) {
			// need to retrieve the type name
			EStructuralFeature fqNameFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(element.eClass(), new String[] { "fullyQualifiedName" } );
			if (fqNameFeature != null) {
				String fqName = (String) element.eGet(fqNameFeature);
				if (fqName == null || fqName.isEmpty())
					throw new FSMLMappingException(Cause.MISSING_ATTRIBUTE, JavaMappingInterpreter.QUERY_FULLY_QUALIFIED_NAME);
				detailClass = fqName;
			}
		}
	}

	@Context(mode=Mode.REVERSE)
	public IField contextIField;

	@Context(mode=Mode.FORWARD_AND_REVERSE)
	public VariableDeclarationFragment contextVariableDeclarationFragment;
	
	@Context(mode=Mode.FORWARD_AND_REVERSE, excludes="contextMethodDeclaration")
	public TypeDeclaration contextTypeDeclaration;
	
	@Context(mode=Mode.FORWARD_AND_REVERSE, excludes="contextTypeDeclaration")
	public MethodDeclaration contextMethodDeclaration;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_CLASS, mode=Mode.ALL)
	public String detailClass;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SIGNATURE, mode=Mode.FORWARD, defaultValue="()V")
	public String detailSignature;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCATION_NAME, mode=Mode.FORWARD)
	public String locationName;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_LOCATION_SIG, mode=Mode.FORWARD, defaultValue="()V")
	public String locationSig;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_POSITION, mode=Mode.FORWARD, defaultValue="after")
	public String detailPosition;
	
	int position = 0;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_INITIALIZER, mode=Mode.FORWARD, defaultValue="false")
	public String initializer;
	
	@Parameter(name=JavaMappingInterpreter.DETAIL_SUBTYPE_OF, mode=Mode.ALL, defaultValue="")
	public String detailSubtypeOf;
	
	boolean subtypeOf;
	
	@Override
	protected boolean forward() throws FSMLMappingException {
		// prepare class instance creation 
		String simpleName = Signature.getSimpleName(detailClass);
		int index = simpleName.indexOf('$'); 
		if (index > 0)
			// for a nested class take the name without the top-level class name and the '$' sign
			simpleName = simpleName.substring(index + 1);
		
		String newExpression = "new " + simpleName + CodeTransforms.constructDefaultCallParameters(detailSignature);
		
		try {
			// construct the new instance creation statement
			IType instanceType;
			if (subtypeOf) 
				// the detailClass does not exist yet, but it will be the subtype of detailSubtypeOf
				instanceType = contextIJavaProject.findType(detailSubtypeOf);
			else
				instanceType = contextIJavaProject.findType(detailClass);
			
			if (instanceType.isInterface() || (instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()))) {
				// create anonymous subclass for interfaces and abstract classes
				newExpression += " {\n\t";
				IMethod[] instanceMethods = instanceType.getMethods();
				StringBuffer contents = new StringBuffer();	
				/* Michal: temporarily remove
				 * for (IMethod method : instanceMethods) {
					if (!method.isConstructor() && (instanceType.isInterface() || Flags.isAbstract(method.getFlags()))) {
						// if this is an interface, provide empty stub of methods
						// if this is an abstract class, ONLY provide empty stubs for abstract methods
						String visibility = "";
						if (Flags.isPublic(method.getFlags())) {
							visibility = "public";
						} else if (Flags.isProtected(method.getFlags())) {
							visibility = "protected";
						}
						contents.append(CodeTransforms.createMethodString(contextIJavaProject, null, contextTypeDeclaration, visibility, method.getElementName(), method.getSignature(), null, progressMonitor));
						contents.append("\n");						
					}
				}		*/	
				contents.append("}");
				newExpression += contents.toString();				
			}
			
			String defaultVariant = "";
			
			if (JavaMappingInterpreter.analyzeImplVariants() && feature!=null){
				EObject defaultVariantParameters = javaImplVariantManager.getDefault(element.eClass().getName(),feature.getName(),annotation.getSource());
				if (defaultVariantParameters==null){
					defaultVariant = (initializer!=null && Boolean.parseBoolean(initializer))?JavaImplVariantManagerConstants.INITIALIZER:JavaImplVariantManagerConstants.IN_METHOD;
				} else {
					defaultVariant = javaImplVariantManager.getVariantName(defaultVariantParameters);
	
					//populate all the relevant values from implModel
					if (defaultVariant.equals(JavaImplVariantManagerConstants.IN_METHOD)) {
						locationName = (String)defaultVariantParameters.eGet(defaultVariantParameters.eClass().getEStructuralFeature(JavaImplVariantManagerConstants.METHOD_NAME));
					}
				}				
			} else {
				defaultVariant = (initializer!=null && Boolean.parseBoolean(initializer))?JavaImplVariantManagerConstants.INITIALIZER:JavaImplVariantManagerConstants.IN_METHOD;
			}
			
			
			
			if (defaultVariant.equals(JavaImplVariantManagerConstants.INITIALIZER)) {
				//variant1
				ClassInstanceCreation cic = (ClassInstanceCreation) CodeTransforms.setFieldsInitializer(null, contextVariableDeclarationFragment, newExpression, progressMonitor); 
				contextManager.associateContext(syncItem.getModel(), cic);
				return true;
			} else if (defaultVariant.equals(JavaImplVariantManagerConstants.IN_METHOD)){
				// variant2
				// construct an assignment
				// construct a call
				String contents = contextVariableDeclarationFragment.getName().getIdentifier() + " = " + newExpression + ";";
				
				// field assignment can be created in the context method or a context class
				if (contextMethodDeclaration != null) {
					List<ASTNode> result = CodeTransforms.weaveAdvice(position, null, contextMethodDeclaration, contents, progressMonitor);
					contextManager.associateContext(syncItem.getModel(), (ClassInstanceCreation) result.get(0));
					return true;
				}
				else {
					// no context method, try context class
					if (contextTypeDeclaration != null) {
						MethodDeclaration methodDeclaration = ASTUtils.findMethod(javaAstManager, locationName, locationSig, contextTypeDeclaration, true, false, progressMonitor);
						if (methodDeclaration == null)
							// create the method
							methodDeclaration = CodeTransforms.createMethod(contextIJavaProject, null, contextTypeDeclaration, "public", locationName, locationSig, null, progressMonitor);
						
						List<ASTNode> result = CodeTransforms.weaveAdvice(position, null, methodDeclaration, contents, progressMonitor);
						if (result.get(0) instanceof ExpressionStatement) {
							ExpressionStatement expressionStatement = (ExpressionStatement) result.get(0);
							Assignment assignment = (Assignment) expressionStatement.getExpression();
							ClassInstanceCreation cic = (ClassInstanceCreation) assignment.getRightHandSide();
							contextManager.associateContext(syncItem.getModel(), cic);
							return true;
						}
					}
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	protected boolean reverse() throws FSMLMappingException {		
		
		if (contextIField == null)
			return false;
		try {
			if (contextVariableDeclarationFragment != null) {
				// variant 1: initializer
				Expression initializer = contextVariableDeclarationFragment.getInitializer();
				if (initializer instanceof ClassInstanceCreation) {
					ClassInstanceCreation cic = (ClassInstanceCreation)initializer; 
					
					// we assume that the type of the constructor call is correct (assignable to the field type)
					boolean correctType = true;
					ITypeBinding instanceITypeBinding = cic.getType().resolveBinding();
					
					if (subtypeOf)
						correctType = ! instanceITypeBinding.getQualifiedName().equals(detailSubtypeOf);
					else
						correctType = instanceITypeBinding.getQualifiedName().equals(detailClass);
					
					if (correctType) {
						// begin: implementation variants
						String name = cic.getType().toString();
						Stats.INSTANCE.logImplVariant(element.eClass(), feature, annotation, "initializer");
					
						EClass targetClass = javaImplVariantManager.getVariantEClass(JavaImplVariantManagerConstants.VARIANT+
								JavaImplVariantManagerConstants.DELIMITER+
								annotation.getSource() + JavaImplVariantManagerConstants.DELIMITER
								+ JavaImplVariantManagerConstants.INITIALIZER);
			
						EObject child = EcoreUtil.create(targetClass);
			
						((EList) javaImplVariantManager.getModel().eGet(javaImplVariantManager.getVariantsReference())).add(child);
						child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.INITIALIZED_TYPE), name);
						child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ECLASS), element.eClass().getName());
						child.eSet(targetClass.getEStructuralFeature(JavaImplVariantManagerConstants.ESTRUCTURALFEATURE), feature.getName());
						// end: implementation variants
						
						if (subtypeOf) {
							IJavaElement fieldIType = cic.getType().resolveBinding().getJavaElement();
							if (setFeatureContextAndMarker(true, fieldIType, fieldIType, null, "type")) {
								setContextAndMarker(cic, cic, "creation");
								return true;
							}
						}
						else
							return setFeatureContextAndMarker(true, cic, cic, null);
					}
				}
				
				// variant 2: assignment in a method
				Collection<FieldReferenceMatch> result = JavaModelUtils.writesToField(contextIJavaProject, contextIField, progressMonitor);
				for (FieldReferenceMatch fieldReferenceMatch : result) {	
					Expression rhs = CodeQueries.retrieveRHSFromMatch(javaAstManager, fieldReferenceMatch, progressMonitor);
					if (rhs instanceof ClassInstanceCreation) {
						ClassInstanceCreation cic = (ClassInstanceCreation) rhs;
						
						boolean correctType = true;
						ITypeBinding instanceITypeBinding = cic.getType().resolveBinding();
						
						if (subtypeOf)
							correctType = ! instanceITypeBinding.getQualifiedName().equals(detailSubtypeOf);
						else
							correctType = instanceITypeBinding.getQualifiedName().equals(detailClass);

						if (correctType) {
							// end: implementation variants							
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
							
							// end: implementation variants
							
							if (subtypeOf) {
								IJavaElement fieldIType = cic.getType().resolveBinding().getJavaElement();
								if (setFeatureContextAndMarker(true, fieldIType, fieldIType, null, "type")) {
									setContextAndMarker(cic, cic, "creation");
									return true;
								}
							}
							else
								return setFeatureContextAndMarker(true, cic, cic, null);
						}
					}
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}			
		return setFeature(false);
	}
}
