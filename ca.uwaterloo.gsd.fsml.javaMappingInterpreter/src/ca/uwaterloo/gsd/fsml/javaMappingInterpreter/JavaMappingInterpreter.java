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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingInterpreter;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IAnalysisManagers;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IHierarchicalCallGraphManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaASTManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaImplVariantManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl.AnalysisManagers;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.AnnotatedWithMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.AnnotationAttributeMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.ArgumentIsFieldMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.ArgumentIsNewMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.ArgumentIsThisMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.ArgumentIsVariableMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.ArgumentMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.ArgumentValueMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.AssignedWithNewMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.AssignedWithNullMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.CallsReceivedMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.ExtendsClassMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.FieldTypeAnnotatedWithMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.HasFieldAnnotatedWithMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.HasFieldTypedWithMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.ImplementsInterfaceMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.LocalVariableTypeAnnotatedWithMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.MethodCallMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.MethodCallsMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.MethodNameMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.MethodsMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.NumberOfPublicMethodsMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.PublicMethodsMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.TypedWithMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.mappings.TypesOfReturnedObjectsMapping;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.preferences.JavaPreferenceConstants;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.RA;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class JavaMappingInterpreter extends FSMLMappingInterpreter {
	/**
	 * constants for context annotations
	 */
	public static final String CONTEXT_ANNOTATION = "annotation";
	public static final String CONTEXT_PROJECT = "project";
	public static final String CONTEXT_FIELD = "field";
	public static final String CONTEXT_LOCAL_VARIABLE = "localVariable";
	public static final String CONTEXT_METHOD = "method";
	public static final String CONTEXT_METHOD_CALL = "methodCall";
	public static final String CONTEXT_CLASS = "class";
	/**
	 * constants for query annotations
	 */
	public static final String QUERY_ATTRIBUTE = "attribute";
	public static final String QUERY_ARGUMENT = "argument";
	public static final String QUERY_METHOD_CALL = "methodCall";
	public static final String QUERY_ARGUMENT_IS_FIELD = "argumentIsField";
	public static final String QUERY_ARGUMENT_IS_VARIABLE = "argumentIsVariable";
	public static final String QUERY_ARGUMENT_IS_NEW = "argumentIsNew";
	public static final String QUERY_ARGUMENT_IS_THIS = "argumentIsThis";
	public static final String QUERY_ARGUMENT_VALUE = "argumentValue";
	public static final String QUERY_ARGUMENT_NAME = "argumentName";
	public static final String QUERY_CALLS_RECEIVED = "callsReceived";
	public static final String QUERY_ASSIGNED_WITH_NULL = "assignedWithNull";
	public static final String QUERY_ASSIGNED_WITH_NEW = "assignedWithNew";
	public static final String QUERY_TYPED_WITH = "typedWith";
	public static final String QUERY_FIELD_TYPE = "fieldType";
	public static final String QUERY_FIELD_NAME = "fieldName";
	public static final String QUERY_FIELD_TYPE_ANNOTATED_WITH = "fieldTypeAnnotatedWith";
	public static final String QUERY_LOCAL_VARIABLE_TYPE = "localVariableType";
	public static final String QUERY_LOCAL_VARIABLE_NAME = "localVariableName";
	public static final String QUERY_LOCAL_VARIABLE_TYPE_ANNOTATED_WITH = "localVariableTypeAnnotatedWith";
	public static final String QUERY_TYPES_OF_RETURNED_OBJECTS = "typesOfReturnedObjects";
	public static final String QUERY_RETURNS_OBJECT_OF_TYPE = "returnsObjectOfType";
	public static final String QUERY_RETURN_TYPES = "returnTypes";
	public static final String QUERY_METHODS = "methods";
	public static final String QUERY_SIGNATURE = "signature";
	public static final String QUERY_METHOD_NAME = "methodName";
	public static final String QUERY_ANNOTATED_WITH = "annotatedWith";
	public static final String QUERY_HAS_NO_ATTRIBUTE = "hasNoAttribute";
	public static final String QUERY_HAS_FIELD_ANNOTATED_WITH = "hasFieldAnnotatedWith";
	public static final String QUERY_HAS_FIELD_TYPED_WITH = "hasFieldTypedWith";
	public static final String QUERY_IS_LOCAL = "isLocal";
	public static final String QUERY_IMPLEMENTS_INTERFACE = "implementsInterface";
	public static final String QUERY_EXTENDS_CLASS = "extendsClass";
	public static final String QUERY_QUALIFIER = "qualifier";
	public static final String QUERY_CLASS_NAME = "className";
	public static final String QUERY_IS_CLASS = "isClass";
	public static final String QUERY_IS_INTERFACE = "isInterface";
	public static final String QUERY_FULLY_QUALIFIED_NAME = "fullyQualifiedName";
	public static final String QUERY_PROJECT_NAME = "projectName";
	public static final String QUERY_METHOD_CALLS = "methodCalls";
	public static final String QUERY_NUMBER_OF_PUBLIC_METHODS = "numberOfPublicMethods";
	public static final String QUERY_PUBLIC_METHODS = "publicMethods";
	/**
	 * constants for annotation details
	 */
	public static final String DETAIL_SAME_AS = "sameAs";
	public static final String DETAIL_RECEIVER = "receiver";
	public static final String DETAIL_IN = "in";
	public static final String DETAIL_ATTRIBUTE_NAME = "attributeName";
	public static final String DETAIL_INHERITED = "inherited";
	public static final String DETAIL_FEATURE_PATH = "featurePath";
	public static final String DETAIL_INDEX = "index";
	public static final String DETAIL_NAME = "name";
	public static final String DETAIL_CONCRETE = "concrete";
	public static final String DETAIL_ABSTRACT = "abstract";
	public static final String DETAIL_LOCAL = "local";
	public static final String DETAIL_FULLY_QUALIFIED_TYPE = "fullyQualifiedType";
	public static final String DETAIL_FULLY_QUALIFIED_NAME = "fullyQualifiedName";
	public static final String DETAIL_CLASS = "class";
	public static final String DETAIL_POSITION = "position";
	public static final String DETAIL_INITIALIZER = "initializer";
	public static final String DETAIL_SIGNATURE = "signature";
	public static final String DETAIL_LOCATION_SIG = "locationSig";
	public static final String DETAIL_LOCATION_NAME = "locationName";
	public static final String DETAIL_RECEIVER_EXPR = "receiverExpr";
	public static final String DETAIL_ARGUMENT = "argument";
	public static final String DETAIL_OF_METHOD_CALL = "ofMethodCall";
	public static final String DETAIL_SAME_AS_ARG = "sameAsArg";
	public static final String DETAIL_OF_CALL = "ofCall";
	public static final String DETAIL_CALL = "call";
	public static final String DETAIL_BEFORE = "before";
	public static final String DETAIL_GIVEN_CALLBACK_SEQ = "givenCallbackSeq";
	public static final String DETAIL_SUBTYPE_OF = "subtypeOf";
	public static final String DETAIL_STATEMENT = "statement";
	public static final String DETAIL_IFKEY = "ifkey";
	
	/**
	 * Herman: Whether to perform variant analysis and create generator model for a project.
	 */
	public static boolean analyzeImplVariants (){
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getBoolean(JavaPreferenceConstants.ANALYZE_IMPL_VARIANTS_ID);
	}
	
	/**
	 * A link to the owner being used in the interpreter
	 */
	public static final DefaultWorkingCopyOwner primaryWorkingCopyOwner = DefaultWorkingCopyOwner.PRIMARY;
	
	protected IAnalysisManagers analysisManagers = null;
	
	public String getDescription() {
		return "Default FSML Java Mapping Interpreter";
	}
	@Override
	public String[] getContextAnnotations() {
		return new String[] { CONTEXT_CLASS, CONTEXT_METHOD_CALL, CONTEXT_METHOD, CONTEXT_FIELD,CONTEXT_LOCAL_VARIABLE, CONTEXT_PROJECT, JavaMappingInterpreter.CONTEXT_ANNOTATION };
	}
	@Override
	public String[] getQueryAnnotations() {
		return new String[] { 
		QUERY_PROJECT_NAME, 
		QUERY_FULLY_QUALIFIED_NAME, QUERY_CLASS_NAME, QUERY_QUALIFIER, QUERY_EXTENDS_CLASS, QUERY_IMPLEMENTS_INTERFACE, QUERY_IS_LOCAL, QUERY_ANNOTATED_WITH,
		QUERY_IS_CLASS,QUERY_HAS_FIELD_ANNOTATED_WITH,QUERY_HAS_FIELD_TYPED_WITH,QUERY_NUMBER_OF_PUBLIC_METHODS,QUERY_PUBLIC_METHODS,
		// method
		QUERY_METHOD_NAME, QUERY_SIGNATURE, QUERY_METHODS, QUERY_RETURNS_OBJECT_OF_TYPE, QUERY_TYPES_OF_RETURNED_OBJECTS, QUERY_RETURN_TYPES, // + QUERY_ANNOTATED_WITH,
		// field
		QUERY_FIELD_NAME, QUERY_FIELD_TYPE, QUERY_TYPED_WITH, QUERY_ASSIGNED_WITH_NEW, QUERY_ASSIGNED_WITH_NULL, // + QUERY_ANNOTATED_WITH,
		QUERY_METHOD_CALLS, QUERY_CALLS_RECEIVED,QUERY_FIELD_TYPE_ANNOTATED_WITH,
		// method call argument
		QUERY_ARGUMENT_NAME, QUERY_ARGUMENT_VALUE, QUERY_ARGUMENT_IS_THIS, QUERY_ARGUMENT_IS_NEW, QUERY_ARGUMENT_IS_VARIABLE, QUERY_ARGUMENT_IS_FIELD, QUERY_METHOD_CALL, 
		// argument i of method call m1 same object as argument j of method call m2
		QUERY_ARGUMENT,
		// annotations 
		QUERY_ATTRIBUTE, QUERY_HAS_NO_ATTRIBUTE,
		//statements
		QUERY_LOCAL_VARIABLE_TYPE_ANNOTATED_WITH, QUERY_LOCAL_VARIABLE_NAME,QUERY_LOCAL_VARIABLE_TYPE
		};
	}
	
	public boolean createChildrenForQueryFeature(EObject element, EReference feature, EClass concreteChildType, EStructuralFeature queryFeature, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EAnnotation annotation = FSMLEcoreUtil.getEAnnotation(concreteChildType, CONTEXT_CLASS);
		if (annotation != null) {
			EAnnotation auxAnnotation = queryFeature.getEAnnotation(QUERY_IMPLEMENTS_INTERFACE);
			if (auxAnnotation != null)
				return new ImplementsInterfaceMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();
			auxAnnotation = queryFeature.getEAnnotation(QUERY_EXTENDS_CLASS);
			if (auxAnnotation != null)
				return new ExtendsClassMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();

			auxAnnotation = queryFeature.getEAnnotation(QUERY_ANNOTATED_WITH);
			if (auxAnnotation != null)
				return new AnnotatedWithMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();
			auxAnnotation = queryFeature.getEAnnotation(QUERY_HAS_FIELD_ANNOTATED_WITH);
			if (auxAnnotation != null)
				return new HasFieldAnnotatedWithMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();
			auxAnnotation = queryFeature.getEAnnotation(QUERY_HAS_FIELD_TYPED_WITH);
			if (auxAnnotation != null)
				return new HasFieldTypedWithMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();

		}
		annotation = FSMLEcoreUtil.getEAnnotation(concreteChildType, CONTEXT_METHOD);
		if (annotation != null) {
			EAnnotation auxAnnotation = queryFeature.getEAnnotation(QUERY_ANNOTATED_WITH);
			if (auxAnnotation != null)
				return new AnnotatedWithMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();
		}
		annotation = FSMLEcoreUtil.getEAnnotation(concreteChildType, CONTEXT_FIELD);
		if (annotation != null) {
			EAnnotation auxAnnotation = queryFeature.getEAnnotation(QUERY_TYPED_WITH);
			if (auxAnnotation != null)
				return new TypedWithMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();
			
			auxAnnotation = queryFeature.getEAnnotation(QUERY_ANNOTATED_WITH);
			if (auxAnnotation != null)
				return new AnnotatedWithMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();
			auxAnnotation = queryFeature.getEAnnotation(QUERY_FIELD_TYPE_ANNOTATED_WITH);
			if (auxAnnotation != null)
				return new FieldTypeAnnotatedWithMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();
		}
		annotation = FSMLEcoreUtil.getEAnnotation(concreteChildType, CONTEXT_LOCAL_VARIABLE);
		if (annotation != null) {
			EAnnotation auxAnnotation = queryFeature.getEAnnotation(QUERY_LOCAL_VARIABLE_TYPE_ANNOTATED_WITH);
			if (auxAnnotation != null)
				return new LocalVariableTypeAnnotatedWithMapping(element, feature, queryFeature, auxAnnotation, concreteChildType, this, progressMonitor).performReverseEssential();
		}		
		
		return false;
	}

	public EStructuralFeature findQueryFeature(EClass eClass) {
		EAnnotation annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_CLASS);
		if (annotation != null) {
			// retrieve essential implementsInterface or extendsClass annotation
			EStructuralFeature queryFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_IMPLEMENTS_INTERFACE} );
			if (queryFeature == null)
				queryFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_EXTENDS_CLASS } );
			if (queryFeature == null)
				queryFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_ANNOTATED_WITH } );
			if (queryFeature == null)
				queryFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_HAS_FIELD_ANNOTATED_WITH } );
			if (queryFeature == null)
				queryFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_HAS_FIELD_TYPED_WITH } );
			return queryFeature;
		}
		annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_LOCAL_VARIABLE);
		if (annotation != null){
			// retrieve essential typedWith annotation
			return FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_LOCAL_VARIABLE_TYPE_ANNOTATED_WITH } );
		}
		annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_FIELD);
		if (annotation != null){
			// retrieve essential typedWith annotation
			EStructuralFeature queryFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_TYPED_WITH } );
			if (queryFeature == null)
				queryFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_ANNOTATED_WITH } );
			if (queryFeature == null)
				queryFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_FIELD_TYPE_ANNOTATED_WITH } );
			return queryFeature;
		}
		annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_METHOD);
		if (annotation != null){
			// retrieve essential typedWith annotation
			return FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] { FSMLEcoreUtil.ESSENTIAL, QUERY_ANNOTATED_WITH } );
		}

		
		return null;
	}

	@Override
	public boolean forwardFeatureRepresentedAsClass(ClassSyncItem classSyncItem, IProgressMonitor progressMonitor) throws FSMLMappingException {
		RA action = classSyncItem.getReconciliationAction();
		EObject element = classSyncItem.getModel();
		if (element == null) 
			element = classSyncItem.getCode();
		EClass eClass = element.eClass();
		
		EAnnotation annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_CLASS);
		if (annotation != null) {
			EAttribute nameFeature = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] {QUERY_CLASS_NAME} );
			EAttribute qualifierFeature = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] {QUERY_QUALIFIER} );
			EAttribute fqNameFeature = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] {QUERY_FULLY_QUALIFIED_NAME} );
			
			assert (fqNameFeature != null || (nameFeature != null && qualifierFeature != null));
			
			String className = null;
			String packageName = null;
			if (fqNameFeature != null) {
				String fqName = (String) element.eGet(fqNameFeature);
				while (fqName==null || fqName.length()==0){
					fqName = (String)FSMLEcoreUtil.getAttributeValueFromAttributeValueWizard(fqNameFeature);
					if (fqName!=null && fqName.length()>0){
						element.eSet(fqNameFeature, fqName);
						break;
					}
				}
				className = Signature.getSimpleName(fqName);
				packageName = Signature.getQualifier(fqName);
			}
			else {
				className = (String) element.eGet(nameFeature);
				packageName = (String) element.eGet(qualifierFeature);
			}
			int index = className.indexOf('$');
			if (index == -1) {
				// top-level class
				IType iType;
				switch (action) {
				case CODE_ADD:
					iType = CodeTransforms.createCompilationUnit(project, className, packageName, progressMonitor);
					contextManager.associateContext(element, iType);
					break;
				case CODE_REMOVE:
					iType = (IType) contextManager.getContextIType(element, true);
					CodeTransforms.removeIType(iType, progressMonitor);
					contextManager.removeContext(element);
					break;
				}
			}
			else {
				// nested class
				String topLevelClassName = className.substring(0, index);
				String nestedClassName = className.substring(index+1);
				
				String fqName = (packageName != null && !packageName.isEmpty()) ? packageName + "." + topLevelClassName : topLevelClassName;
				TypeDeclaration topLevelTypeDeclaration;
				try {
					IType topLevelIType = project.findType(fqName);
					if (topLevelIType == null || !topLevelIType.exists()) {
						// need to create the top-level class	
						topLevelIType = CodeTransforms.createCompilationUnit(project, topLevelClassName, packageName, progressMonitor);
					}
					CompilationUnit cu = javaAstManager.getCompilationUnit(topLevelIType);
					topLevelTypeDeclaration = ASTUtils.getTypeDeclarationNode(topLevelIType, cu);
				
					TypeDeclaration typeDeclaration;
					switch (action) {
					case CODE_ADD:
						typeDeclaration = CodeTransforms.createNestedTypeDeclaration(project, cu, topLevelTypeDeclaration, nestedClassName, progressMonitor);
						contextManager.associateContext(element, typeDeclaration);
						break;
					case CODE_REMOVE:
						typeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
						CodeTransforms.commentOutASTNode(cu, typeDeclaration, eClass, null, progressMonitor);
						contextManager.removeContext(element);
						break;
					}
				} catch (JavaModelException e1) {
					e1.printStackTrace();
				}
			}
			return true;
		}
		annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_METHOD);
		if (annotation != null) {
			return new MethodsMapping(classSyncItem, annotation, this, progressMonitor).performForward();
		}
		annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_FIELD);
		if (annotation != null) {
			EAttribute nameFeature = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] {QUERY_FIELD_NAME} );
			String fieldName = (String) element.eGet(nameFeature);
			while (fieldName==null||fieldName.length()==0){
				fieldName = (String)FSMLEcoreUtil.getAttributeValueFromAttributeValueWizard(nameFeature);
				if (fieldName!=null && fieldName.length()>0){
					element.eSet(nameFeature, fieldName);
					break;
				}

			}
			String fieldType = null;
			EAttribute typedWithFeature = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] {QUERY_TYPED_WITH} );
			if (typedWithFeature != null) {
				EAnnotation typeAnnotation = typedWithFeature.getEAnnotation(QUERY_TYPED_WITH);
				fieldType = (String) FSMLEcoreUtil.retrieveParameterValue(typeAnnotation, DETAIL_NAME, true);
			}
			else {
				// try using fieldType value
				EAttribute fieldTypeFeature = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(eClass, new String[] {QUERY_FIELD_TYPE} );
				if (fieldTypeFeature != null)
					fieldType = (String) element.eGet(fieldTypeFeature);
			}
			if (fieldType != null && !fieldType.isEmpty()) {
				EObject contextFeature = FSMLEcoreUtil.retrieveContextElement(classSyncItem, CONTEXT_CLASS);
				TypeDeclaration contextTypeDeclaration = contextManager.getContextTypeDeclaration(contextFeature, true, progressMonitor);
				
				VariableDeclarationFragment variableDeclarationFragment;
				if (contextTypeDeclaration != null) {
					switch (action) {
					case CODE_ADD:
						variableDeclarationFragment = CodeTransforms.createField(project, null, contextTypeDeclaration, "public", fieldName, fieldType, progressMonitor);
						contextManager.associateContext(element, variableDeclarationFragment);
						break;
					case CODE_REMOVE:
						variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor); 
						variableDeclarationFragment.delete();
						break;
					}
				}
			}
		}
		annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_METHOD_CALL);
		if (annotation != null) {
			
		}
		return true;
	}
	public boolean reverseFeatureRepresentedAsAttribute(EObject element, EAttribute feature, IProgressMonitor progressMonitor) throws FSMLMappingException {
		try {
			EAnnotation annotation = feature.getEAnnotation(QUERY_EXTENDS_CLASS);
			if (annotation != null)
				return new ExtendsClassMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_IMPLEMENTS_INTERFACE);
			if (annotation != null)
				return new ImplementsInterfaceMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_VALUE);
			if (annotation != null)
				return new ArgumentValueMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_RETURNS_OBJECT_OF_TYPE);
			if (annotation != null)
				return doReturnsObjectOfType_reverse(element, feature, annotation, progressMonitor);
			annotation = feature.getEAnnotation(QUERY_TYPES_OF_RETURNED_OBJECTS);
			if (annotation != null)
				return new TypesOfReturnedObjectsMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_RETURN_TYPES);
			if (annotation != null)
				return doReturnTypes_reverse(element, feature, annotation, null, progressMonitor);
			annotation = feature.getEAnnotation(QUERY_METHODS);
			if (annotation != null)
				return new MethodsMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(JavaMappingInterpreter.QUERY_METHOD_CALLS);
			if (annotation != null)
				return new MethodCallsMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_CALLS_RECEIVED);
			if (annotation != null)
				return new CallsReceivedMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_TYPED_WITH);
			if (annotation != null)
				return new TypedWithMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ASSIGNED_WITH_NULL);
			if (annotation != null)
				return new AssignedWithNullMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ASSIGNED_WITH_NEW);
			if (annotation != null)
				return new AssignedWithNewMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_METHOD_NAME);
			if (annotation != null)
				return new MethodNameMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_METHOD_CALL);
			if (annotation != null)
				return new MethodCallMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT);
			if (annotation != null)
				return new ArgumentMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_THIS);
			if (annotation != null)
				return new ArgumentIsThisMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_NEW);
			if (annotation != null)
				return new ArgumentIsNewMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_VARIABLE);
			if (annotation != null)
				return new ArgumentIsVariableMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_FIELD);
			if (annotation != null)
				return new ArgumentIsFieldMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ANNOTATED_WITH);
			if (annotation != null)
				return new AnnotatedWithMapping(element, feature, annotation,null,this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_HAS_FIELD_ANNOTATED_WITH);
			if (annotation != null)
				return new HasFieldAnnotatedWithMapping(element, feature, annotation,null,this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_HAS_FIELD_TYPED_WITH);
			if (annotation != null)
				return new HasFieldTypedWithMapping(element, feature, annotation,null,this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_FIELD_TYPE_ANNOTATED_WITH);
			if (annotation != null)
				return new FieldTypeAnnotatedWithMapping(element, feature, annotation,null,this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_LOCAL_VARIABLE_TYPE_ANNOTATED_WITH);
			if (annotation != null)
				return new LocalVariableTypeAnnotatedWithMapping(element, feature, annotation,null,this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ATTRIBUTE);
			if (annotation != null)
				return new AnnotationAttributeMapping(element, feature, annotation,null,this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_NUMBER_OF_PUBLIC_METHODS);
			if (annotation != null)
				return new NumberOfPublicMethodsMapping(element, feature, annotation,null,this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_PUBLIC_METHODS);
			if (annotation != null)
				return new PublicMethodsMapping(element, feature, annotation,null,this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_HAS_NO_ATTRIBUTE);
			if (annotation != null)
				return doHasNoAttribute_reverse(element, feature, annotation, progressMonitor);
			annotation = feature.getEAnnotation(QUERY_FULLY_QUALIFIED_NAME);
			if (annotation != null) {
				IType auxClass = contextManager.getContextIType(element, true);
				if (auxClass == null)  {
					// try context TypeDeclaration
					TypeDeclaration typeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
					if (typeDeclaration != null) {
						PackageDeclaration packageDeclaration = ((CompilationUnit) typeDeclaration.getRoot()).getPackage();
						String qualifier = null;
						if (packageDeclaration != null)
							qualifier = packageDeclaration.getName().getFullyQualifiedName();
						String name = typeDeclaration.getName().getFullyQualifiedName();
						String fqName = qualifier != null && !"".equals(qualifier) ?
								qualifier + "." + name :
								name;
						element.eSet(feature, fqName);
						Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
						return true;
					}
					// there is not context!
					return false;
				}
				
				element.eSet(feature, auxClass.getFullyQualifiedName());
				Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
				return true;
			}
			annotation = feature.getEAnnotation(QUERY_CLASS_NAME);
			if (annotation != null) {
				IType auxClass = contextManager.getContextIType(element, true);
				if (auxClass == null) {
					// try context TypeDeclaration
					TypeDeclaration typeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
					if (typeDeclaration != null) {
						element.eSet(feature, typeDeclaration.getName().getIdentifier());
						Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
						return true;
					}
					// there is not context!
					return false;
				}
				
				element.eSet(feature, auxClass.getElementName());
				Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
				return true;
			}
			annotation = feature.getEAnnotation(QUERY_QUALIFIER);
			if (annotation != null) {
				IType auxClass = contextManager.getContextIType(element, true);
				if (auxClass == null) {
					// try context TypeDeclaration
					TypeDeclaration typeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
					if (typeDeclaration != null) {
						CompilationUnit cu = (CompilationUnit) typeDeclaration.getRoot();
						PackageDeclaration packageDeclaration = ((CompilationUnit) typeDeclaration.getRoot()).getPackage();
						String qualifier = null;
						if (packageDeclaration != null)
							qualifier = packageDeclaration.getName().getFullyQualifiedName();
						element.eSet(feature, qualifier);
						Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
						return true;
					}
					// there is not context!
					return false;
				}
				
				element.eSet(feature, auxClass.getPackageFragment().getElementName());
				Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
				return true;
			}
			annotation = feature.getEAnnotation(QUERY_FIELD_NAME);
			if (annotation != null) {
				VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor);

				if (variableDeclarationFragment != null) {
					element.eSet(feature, new String(variableDeclarationFragment.getName().getIdentifier()));
					
					Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
					return true;
				}
				return false;
			}
			annotation = feature.getEAnnotation(QUERY_LOCAL_VARIABLE_NAME);
			if (annotation != null) {
				VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor);

				if (variableDeclarationFragment != null) {
					element.eSet(feature, new String(variableDeclarationFragment.getName().getIdentifier()));
					
					Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
					return true;
				}
				return false;
			}
			
			annotation = feature.getEAnnotation(QUERY_IS_CLASS);
			if (annotation != null) {
				IType auxClass =contextManager.getContextIType(element, true);
				
				if (auxClass == null)
					return false;
				
				element.eSet(feature, auxClass.isClass());
				return auxClass.isClass();
			}
			annotation = feature.getEAnnotation(QUERY_IS_INTERFACE);
			if (annotation != null) {
				IType auxClass =contextManager.getContextIType(element, true);
				
				if (auxClass == null)
					return false;
				
				element.eSet(feature, auxClass.isInterface());
				return auxClass.isClass();
			}
			annotation = feature.getEAnnotation(QUERY_PROJECT_NAME);
			if (annotation != null && feature.getEAttributeType().getName().equals("EString")) {
				IJavaProject contextProject = contextManager.getContextIJavaProject(element);
				if (contextProject == null)
					return false;
			
				element.eSet(feature, new String(contextProject.getElementName()));
					
				Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
				return true;
			}
			annotation = feature.getEAnnotation(QUERY_IS_LOCAL);
			if (annotation != null) {
				IType auxClass = (IType)contextManager.getContextIType(element, true);
				if (auxClass == null)
					return false;
				
				String queriesProject = project.getHandleIdentifier();
				String elementsProject = auxClass.getJavaProject().getHandleIdentifier();
				
				boolean isLocal = !auxClass.isBinary() && elementsProject.equals(queriesProject);
				element.eSet(feature, new Boolean(isLocal));
				
				Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
				return true;
			}
			// unsupported mappings
			annotation = feature.getEAnnotation(QUERY_SIGNATURE);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_FIELD_TYPE);
			if (annotation != null){ 
				VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor);

				if (variableDeclarationFragment != null) {
					Type fieldType = ((FieldDeclaration)variableDeclarationFragment.getParent()).getType();
					String typeName = ASTUtils.getFullyQualifiedName(fieldType);
					element.eSet(feature, typeName);
					
					Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
					return true;
				}
				return false;
			}
			annotation = feature.getEAnnotation(QUERY_LOCAL_VARIABLE_TYPE);
			if (annotation != null){ 
				VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor);

				if (variableDeclarationFragment != null) {
					Type fieldType = ((VariableDeclarationStatement)variableDeclarationFragment.getParent()).getType();
					String typeName = ASTUtils.getFullyQualifiedName(fieldType);
					element.eSet(feature, typeName);
					
					Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
					return true;
				}
				return false;
			}
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_NAME);
			if (annotation != null)
				throw new UnsupportedOperationException();
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean forwardFeatureRepresentedAsAttribute(StructuralFeatureSyncItem featureSyncItem,  IProgressMonitor progressMonitor) {
		EStructuralFeature feature = featureSyncItem.getStructuralFeature();
		try {
			EAnnotation annotation = feature.getEAnnotation(QUERY_EXTENDS_CLASS);
			if (annotation != null)
				return new ExtendsClassMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_IMPLEMENTS_INTERFACE);
			if (annotation != null)
				return new ImplementsInterfaceMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_METHODS);
			if (annotation != null)
				return new MethodsMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(JavaMappingInterpreter.QUERY_METHOD_CALLS);
			if (annotation != null)
				return new MethodCallsMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_THIS);
			if (annotation != null)
				return new ArgumentIsThisMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_NEW);
			if (annotation != null)
				return new ArgumentIsNewMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_FIELD);
			if (annotation != null)
				return new ArgumentIsFieldMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_VARIABLE);
			if (annotation != null)
				return new ArgumentIsVariableMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ASSIGNED_WITH_NULL);
			if (annotation != null)
				return new AssignedWithNullMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ASSIGNED_WITH_NEW);
			if (annotation != null)
				return new AssignedWithNewMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_VALUE);
			if (annotation != null)
				return new ArgumentValueMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_TYPES_OF_RETURNED_OBJECTS);
			if (annotation != null)
				return new TypesOfReturnedObjectsMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT);
			if (annotation != null)
				return new ArgumentMapping(featureSyncItem, annotation, this, progressMonitor).performForward();
			return true;
		}  catch (FSMLMappingException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean reverseFeatureRepresentedAsReference(EObject element, EReference feature, EClass concreteChildType, IProgressMonitor progressMonitor) throws FSMLMappingException {
		try {
			EAnnotation annotation = feature.getEAnnotation(QUERY_EXTENDS_CLASS);
			if (annotation != null)
				return new ExtendsClassMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_IMPLEMENTS_INTERFACE);
			if (annotation != null)
				return new ImplementsInterfaceMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ANNOTATED_WITH);
			if (annotation != null)
				return new AnnotatedWithMapping(element,feature,annotation, concreteChildType,this,progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_METHODS);
			if (annotation != null)
				return new MethodsMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_RETURN_TYPES);
			if (annotation != null)
				return doReturnTypes_reverse(element, feature, annotation, concreteChildType, progressMonitor);
			annotation = feature.getEAnnotation(QUERY_TYPED_WITH);
			if (annotation != null)
				return new TypedWithMapping(element, feature, annotation, null, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ASSIGNED_WITH_NULL);
			if (annotation != null)
				return new AssignedWithNullMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ASSIGNED_WITH_NEW);
			if (annotation != null)
				return new AssignedWithNewMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(JavaMappingInterpreter.QUERY_METHOD_CALLS);
			if (annotation != null)
				return new MethodCallsMapping(element, feature, annotation, concreteChildType,  this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_CALLS_RECEIVED);
			if (annotation != null)
				return new CallsReceivedMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT);
			if (annotation != null)
				return new ArgumentMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_THIS);
			if (annotation != null)
				return new ArgumentIsThisMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_NEW);
			if (annotation != null)
				return new ArgumentIsNewMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_VARIABLE);
			if (annotation != null)
				return new ArgumentIsVariableMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_FIELD);
			if (annotation != null)
				return new ArgumentIsFieldMapping(element, feature, annotation, concreteChildType, this, progressMonitor).performReverse();
			annotation = feature.getEAnnotation(QUERY_ATTRIBUTE);
			if (annotation != null)
				return new AnnotationAttributeMapping(element,feature,annotation,concreteChildType,this,progressMonitor).performReverse();
				//return doAttributeRepresentedAsReference_reverse(element, feature, annotation, concreteChildType, progressMonitor);
			annotation = feature.getEAnnotation(QUERY_IS_CLASS);
			if (annotation != null) {
				IType auxClass =contextManager.getContextIType(element, true);
				
				if (auxClass == null || !auxClass.isClass())
					return false;
			
				EObject child = EcoreUtil.create(concreteChildType);
				element.eSet(feature, child);
				return reverseFeatureRepresentedAsClass(child, progressMonitor);
			}
			annotation = feature.getEAnnotation(QUERY_IS_INTERFACE);
			if (annotation != null) {
				IType auxClass =contextManager.getContextIType(element, true);
				
				if (auxClass == null || !auxClass.isInterface())
					return false;
				
				EObject child = EcoreUtil.create(concreteChildType);
				element.eSet(feature, child);
				return reverseFeatureRepresentedAsClass(child, progressMonitor);
			}
			annotation = feature.getEAnnotation(QUERY_IS_LOCAL);
			if (annotation != null) {
				IType auxClass = (IType)contextManager.getContextIType(element, true);
				if (auxClass == null)
					return false;
				
				String queriesProject = project.getHandleIdentifier();
				String elementsProject = auxClass.getJavaProject().getHandleIdentifier();
				
				boolean isLocal = !auxClass.isBinary() && elementsProject.equals(queriesProject);
				if (!isLocal) 
					return false;
				
				EObject child = EcoreUtil.create(concreteChildType);
				element.eSet(feature, child);
				return reverseFeatureRepresentedAsClass(child, progressMonitor);
			}
			
			// unsupported queries for references
			annotation = feature.getEAnnotation(QUERY_METHOD_NAME);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_SIGNATURE);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_FIELD_NAME);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_PROJECT_NAME);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_FULLY_QUALIFIED_NAME);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_CLASS_NAME);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_QUALIFIER);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_VALUE);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_FIELD_TYPE);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_NAME);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_METHOD_CALL);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_RETURNS_OBJECT_OF_TYPE);
			if (annotation != null)
				throw new UnsupportedOperationException();
			annotation = feature.getEAnnotation(QUERY_TYPES_OF_RETURNED_OBJECTS);
			if (annotation != null)
				throw new UnsupportedOperationException();
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean forwardFeatureRepresentedAsReference(ClassSyncItem classSyncItem, IProgressMonitor progressMonitor) {
		EObject element = classSyncItem.getModel() != null ? classSyncItem.getModel() : classSyncItem.getCode();
		EReference feature = element.eContainmentFeature();
		try {
			EAnnotation annotation = feature.getEAnnotation(QUERY_EXTENDS_CLASS);
			if (annotation != null)
				return new ExtendsClassMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_IMPLEMENTS_INTERFACE);
			if (annotation != null)
				return new ImplementsInterfaceMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_METHODS);
			if (annotation != null)
				return new MethodsMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_METHOD_CALLS);
			if (annotation != null)
				return new MethodCallsMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_CALLS_RECEIVED);
			if (annotation != null)
				return new CallsReceivedMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_THIS);
			if (annotation != null)
				return new ArgumentIsThisMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT_IS_FIELD);
			if (annotation != null)
				return new ArgumentIsFieldMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ASSIGNED_WITH_NEW);
			if (annotation != null)
				return new AssignedWithNewMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			annotation = feature.getEAnnotation(QUERY_ARGUMENT);
			if (annotation != null)
				return new ArgumentMapping(classSyncItem, annotation, this, progressMonitor).performForward();
			/*annotation = feature.getEAnnotation("typedWith");
			if (annotation != null)
				return doTypedWith_forward(classSyncItem, annotation, progressMonitor);
			annotation = feature.getEAnnotation("assignedWithNull");
			if (annotation != null)
				return doNullified_forward(classSyncItem, annotation, progressMonitor);
			annotation = feature.getEAnnotation("assignedWithNew");
			if (annotation != null)
				return doInitializedWithConstructorCall_forward(classSyncItem, annotation, progressMonitor);
			*/
		} catch (FSMLMappingException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean canHandleContext(Class contextClass) {
		return 	contextClass != null && (
				TypeDeclaration.class.isAssignableFrom(contextClass) || 
				MethodDeclaration.class.isAssignableFrom(contextClass) || 
				VariableDeclarationFragment.class.isAssignableFrom(contextClass) ||
				MethodInvocation.class.isAssignableFrom(contextClass) ||
				ClassInstanceCreation.class.isAssignableFrom(contextClass) ||
				Annotation.class.isAssignableFrom(contextClass) ||
				IJavaProject.class.isAssignableFrom(contextClass)) ||
				IType.class.isAssignableFrom(contextClass)  ||
				IMethod.class.isAssignableFrom(contextClass) ||
				IField.class.isAssignableFrom(contextClass);
	}
	@Override
	public boolean canForwardObjectUsingContextMapping(EClass eClass) {
		EAnnotation annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_CLASS);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_METHOD);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_FIELD);
		if (annotation != null)
			return true;
		/*annotation = FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_METHOD_CALL);
		if (annotation != null)
			return true;*/
		// no context annotation, check the containment reference
		return false;
	}
	@Override
	public boolean canForwardObjectUsingQueryMapping(EReference eReference) {
		EAnnotation annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_EXTENDS_CLASS);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_IMPLEMENTS_INTERFACE);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_METHOD_CALLS);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_CALLS_RECEIVED);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_ARGUMENT_IS_THIS);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_ARGUMENT_IS_FIELD);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_ASSIGNED_WITH_NULL);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_ASSIGNED_WITH_NEW);
		if (annotation != null)
			return true;
		annotation = FSMLEcoreUtil.getEAnnotation(eReference, QUERY_ARGUMENT);
		if (annotation != null)
			return true;

		return false;
	}
	/**
	 * @param object
	 * @param javaElement
	 * This associates given model element with java element using appropriate feature2* hashmaps. 
	 * Intended to be used by custom FSMLAnnotationInterpreters to set contexts supported by the default interpreter.
	 */
	public void associateContext(EObject element, Object context) {
		contextManager.associateContext(element, context);
	}
	public void removeContext(EObject element) {
		contextManager.removeContext(element);
	}
	public Object getContext(EObject element) {
		return contextManager.getContext(element, new NullProgressMonitor());
	}
	@Override
	public Object getContext(EObject element, Class contextClass, boolean required) {
		return contextManager.getContext(element, contextClass, required, new NullProgressMonitor());
	}
	@Override
	public boolean aliasContext(EObject source, EObject target) {
		Object context = getContext(source);
		if (context != null) {
			associateContext(target, context);
			return true;
		}
		return false;
	}
	
	// Java utilities
	
	HashMap<String, ReturnStatement> returnsObjectOfTypeCache = new HashMap<String, ReturnStatement>();;
	HashMap<String, Boolean> doesNotReturnObjectOfTypeCache = new HashMap<String, Boolean>();
	
	@SuppressWarnings("restriction")
	public ReturnStatement returnsObjectOfType(MethodDeclaration methodDeclaration, String fullyQualifiedName, IProgressMonitor progressMonitor) {
		IMethod contextMethod = (IMethod) methodDeclaration.resolveBinding().getJavaElement();
		// check cache first
		String key = contextMethod.getKey() + "<-" + fullyQualifiedName;
		Boolean returns = doesNotReturnObjectOfTypeCache.get(key);
		if (returns != null)
			// has been already checked so just return (it can be null)
			return returnsObjectOfTypeCache.get(key);
		
		final String requiredTypeName = fullyQualifiedName;
		final ReturnStatement[] result = new ReturnStatement[1];
		final SuperMethodInvocation[] superMethodInvocation = new SuperMethodInvocation[1];
		final JavaMappingInterpreter jmi = this; 
		final IProgressMonitor monitor = progressMonitor;
		result[0] = null;
		superMethodInvocation[0] = null;
		

		methodDeclaration.accept(new ASTVisitor() {
			public boolean visit(ReturnStatement node) {
				Expression expression = node.getExpression();
				if (!(expression instanceof NullLiteral)) {
					if (expression instanceof SuperMethodInvocation) {
						superMethodInvocation[0] = (SuperMethodInvocation) expression;
					}
					else {
						ITypeBinding typeBinding = expression.resolveTypeBinding();
						if (typeBinding == null) {
							superMethodInvocation[0] = null;
							return true;
						}
						
						IType iType = (IType) typeBinding.getJavaElement();
						
						try {
							if (iType != null && (iType.getFullyQualifiedName().equals(requiredTypeName) ||
								getAnalysisManagers().getTypeHierarchy().implementsOrExtendsType(iType, requiredTypeName)))	
								result[0] = node;
						} catch (JavaModelException e) {
						}
					}
				}
				return true;
			}
		});

		if (result[0] != null) {
			doesNotReturnObjectOfTypeCache.put(key, false);
			returnsObjectOfTypeCache.put(key, result[0]);
			Stats.INSTANCE.logMessage("returnsObjectOfType: " + contextMethod.getKey() + " returns: " + fullyQualifiedName);
			return result[0];
		}
		else if (superMethodInvocation[0] != null) {
			// analyze super method
			IMethodBinding superMethodBinding = superMethodInvocation[0].resolveMethodBinding();
			if (superMethodBinding == null)
				return null;
			IMethod superMethod = (IMethod) superMethodBinding.getJavaElement();
			CompilationUnit cu = javaAstManager.getCompilationUnit(superMethod);
			
			MethodDeclaration superMethodDeclaration;
			try {
				superMethodDeclaration = ASTNodeSearchUtil.getMethodDeclarationNode(superMethod, cu);
				return returnsObjectOfType(superMethodDeclaration, fullyQualifiedName, progressMonitor);
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		doesNotReturnObjectOfTypeCache.put(key, true);
		return null;
			 
	}
	
	/**
	 * 	annotations cache begin
	 */
	// iTypes used in extendsClass & implementsInterface annotations
	public HashMap<String, IType> iTypes = new HashMap<String, IType>();
	// iMethods used in calls method annotations
	public HashMap<String, IMethod> iMethods = new HashMap<String, IMethod>();
	// the project this interpreter operates on
	protected IJavaProject project;
	// cache for calls to a given method used by CallsReceivedMapping
	public HashMap<IMethod, Collection<SearchMatch>> callsCache = new HashMap<IMethod, Collection<SearchMatch>>();
	
	protected IJavaContextManager contextManager;
	protected IJavaASTManager javaAstManager;
	protected IJavaImplVariantManager javaImplVariantManager;
	protected IHierarchicalCallGraphManager callGraphManager;
	
	// search scope preferences
	public boolean hierarchyScope;
	public boolean hierarchyUnitsScope;
	public boolean callGraphScope;
	public boolean projectScope;
	
	
	public boolean hierarchyScope() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getString(JavaPreferenceConstants.METHOD_CALLS_SEARCH_SCOPE_ID).equals(
				JavaPreferenceConstants.HIERARCHY_VALUE);
	}
	public boolean hierarchyUnitsScope() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getString(JavaPreferenceConstants.METHOD_CALLS_SEARCH_SCOPE_ID).equals(
				JavaPreferenceConstants.HIERARCHY_UNITS_VALUE);
	}
	public boolean callGraphScope() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getString(JavaPreferenceConstants.METHOD_CALLS_SEARCH_SCOPE_ID).equals(
				JavaPreferenceConstants.CALL_GRAPH_VALUE);
	}
	public boolean projectScope() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getString(JavaPreferenceConstants.METHOD_CALLS_SEARCH_SCOPE_ID).equals(
				JavaPreferenceConstants.PROJECT_VALUE);
	}
	public boolean initialize(IProject project, Model model) {
		if (setProject(project)) {
			getAnalysisManagers().init();
			contextManager = this.getAnalysisManagers().getJavaContextManager();
			javaAstManager = this.getAnalysisManagers().getJavaASTManager();
			javaImplVariantManager = this.getAnalysisManagers().getJavaImplVariantManager();
			callGraphManager = this.getAnalysisManagers().getHierarchicalCallGraphManager();
			
			contextManager.associateContext(model, this.project);
			try {
				cacheJavaModelElementsUsedInAnnotations(model.eClass());
			} catch (FSMLMappingException e) {
				e.printStackTrace();
				return false;
			}
			
			// read the preferences
			// search scope
			hierarchyScope = hierarchyScope();
			hierarchyUnitsScope = hierarchyUnitsScope();
			callGraphScope = callGraphScope();
			projectScope = projectScope();
			
			// Michal: need to configure the call graph manager with the methods found during the metamodel traversal
			if (callGraphScope)
				callGraphManager.setTargetMethods(iMethods.values());
			
			return true;
		}
		return false;
	}
	@Override
	public void terminate(IProgressMonitor progressMonitor) {
		this.getAnalysisManagers().finish();
	}
	/**
	 * @param project
	 * @return true iff the project is a Java project
	 */
	public boolean setProject(IProject project) {
		if (Queries.hasNature(project, JavaCore.NATURE_ID)) {
			this.project = JavaCore.create(project);
			Markers.INSTANCE.setProject(project);
			return true;
		}
		this.project = null;
		return false;
	}
	/**
	 * Traverses the metamodel and stores ITypes and IMethods used in annotations.
	 * @param metaClass
	 * @throws FSMLMappingException
	 */
	private void cacheJavaModelElementsUsedInAnnotations(EClass metaClass) throws FSMLMappingException {
		Stats.INSTANCE.logMetamodelAnnotation(metaClass);
		
		for (Object aux : metaClass.getEAllStructuralFeatures()) {
			EStructuralFeature feature = (EStructuralFeature) aux;
			Stats.INSTANCE.logMetamodelAnnotation(feature);
			
			// iType annotations
			EAnnotation annotation = feature.getEAnnotation(QUERY_EXTENDS_CLASS); 
			if (annotation == null)
				annotation = feature.getEAnnotation(QUERY_IMPLEMENTS_INTERFACE);
			if (annotation != null) {
				String name = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
				try {
					IType iType = project.findType(name);
					if (iType != null && iType.exists()) {
						iTypes.put(FSMLEcoreUtil.computeAnnotationKey(annotation), iType);
						//Stats.INSTANCE.printMessage("iTypes: " + iType.getFullyQualifiedName());
					}
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
			}
			// iMethod annotations
			annotation = feature.getEAnnotation(JavaMappingInterpreter.QUERY_METHOD_CALLS);
			if (annotation == null)
				annotation = feature.getEAnnotation(QUERY_CALLS_RECEIVED);
			if (annotation == null)
				annotation = feature.getEAnnotation(QUERY_ASSIGNED_WITH_NEW);
			if (annotation != null) {
				String fieldType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_SUBTYPE_OF, false);
				if (fieldType != null)
					continue;
				String className = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_CLASS, true);
				try {
					IType iType = project.findType(className);
					if (iType != null && iType.exists()) {
						// Defaults to the class name, which will search for the constructor
						String methodName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, Signature.getSimpleName(className));
						String signature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, "()V");
						String[] parameterTypeSignatures = Signature.getParameterTypes(signature);
						IMethod iMethod = iType.getMethod(methodName, parameterTypeSignatures);
						if (iMethod != null && !iMethod.exists()) {
							// find a similar method directly in iType
							for (IMethod auxMethod : iType.getMethods())
								if (auxMethod.isSimilar(iMethod)) {
									iMethod = auxMethod;
									break;
								}
						}
						if (iMethod != null && iMethod.exists()) {
							String key = FSMLEcoreUtil.computeAnnotationKey(annotation);
							iTypes.put(key, iType);
							iMethods.put(key, iMethod);
							
							//Stats.INSTANCE.printMessage("iMethods: " + iMethod.getElementName() + " " +  iMethod.getSignature());
						}
					}
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
			}			
			if (feature instanceof EReference) {
				EReference reference = ((EReference)feature);
				if (reference.isContainment()) {
					EClassifier classifier = reference.getEType();
					// TODO: make sure there are no cycles to prevent infinite recursion
					if (classifier instanceof EClass && classifier != metaClass) {
						for (Object subclass : FSMLEcoreUtil.getSubclassesOfEClass((EClass) classifier, true)) {
							cacheJavaModelElementsUsedInAnnotations((EClass) subclass);
						}
					}
				}
			}
		}
	}
	public static int ALL_TYPES = 0;
	public static int SOURCE_ONLY = 1;
	public static int BINARY_ONLY = 2;

	/**
	 * @return true iff feature is present
	 * @throws FSMLMappingException 
	 */
	public boolean doReturnsObjectOfType_reverse(EObject element, EAttribute feature, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		MethodDeclaration contextMethod = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
		
	
		if (feature.getEAttributeType().getName().equals("EBoolean")) {
			// make sure feature is not there in case the default is true
			element.eSet(feature, false);
			
			String featurePath = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_FEATURE_PATH, false);
			
			// navigate to the String feature that holds the fqName of the expected type
			FSMLEcoreUtil.NavigationResult target = FSMLEcoreUtil.navigateToEObject(element, featurePath);
			
			if (target.eObject == null) {
				Stats.INSTANCE.logError(feature.getName() +  " <returnsObjectOfType> cannot find targetElement! " + target.errorMessage);
				return false;
			}	
			if (target.eAttribute == null) {
				Stats.INSTANCE.logError(feature.getName() + " <returnsObjectOfType> targetFeature is not an attribute! "  + target.errorMessage);
				return false;
			}
			
			if (!(target.eAttribute.getEAttributeType().getName().equals("EString"))) {
				Stats.INSTANCE.logError(feature.getName() + " <returnsObjectOfType> targetFeature is not a String!");
				return false;
			}
			String requiredTypeName = (String) target.eObject.eGet(target.eAttribute);
			
			ReturnStatement returnStatement = returnsObjectOfType(contextMethod, requiredTypeName, progressMonitor);
			
			boolean returnsType = returnStatement != null;
			
			element.eSet(feature, new Boolean(returnsType));
			if (returnsType) {
				JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(contextMethod.resolveBinding().getJavaElement());
				markerDescriptor.setAttributes(feature, returnStatement);
				markerDescriptor.create(element);
				
				Stats.INSTANCE.logFeatureInstance(element, feature, annotation);
				return true;
			}
		}
		return false;
	}
	/**
	 * Implements the reverse part of the "returnTypes" mapping.
	 * 
	 * This mapping is currently implemented only for References. It will search the context class for return types of methods, excluding
	 * void methods and constructors. For each return type it will create a child with the reference type (or just a single one if the
	 * feature is not *). For each method it will create a marker in the parent feature.
	 * 
	 * This mapping can be parameterized with the following annotation details:
	 *    name : the name of the methods to search. Default uses all methods
	 *    signature : the signature of methods to search. Default uses all methods
	 * 
	 * @return true if the feature is present
	 */
	public boolean doReturnTypes_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		
		// References must have a child type
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		TypeDeclaration contextClass = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
		IJavaProject project = contextManager.getContextIJavaProject(element);
	
		if (feature instanceof EReference) {
			// Get the value of some parameters (if they don't exist, ignore and return everything)
			String methodName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
			String methodSignature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, QUERY_SIGNATURE, "()V");
			
			// Collect the return types
			Map<TypeDeclaration, List<MethodDeclaration>> returnTypes = new HashMap<TypeDeclaration, List<MethodDeclaration>>();
			for (MethodDeclaration method : contextClass.getMethods()) {
				// filter by name
				if (methodName != null && ! methodName.equals(method.getName().getIdentifier())) {
					continue;
				}
				// filter by signature
				
				if (methodSignature != null && ! methodSignature.equals(((IMethod)method.resolveBinding().getJavaElement()).getSignature())) {
					continue;
				}
				// filter void types
				if ("V".equals(method.resolveBinding().getReturnType().getKey())) {
					continue;
				}
				// add the return type and method to the map/list
				
				
				IType returnIType = (IType) method.getReturnType2().resolveBinding().getJavaElement();
				CompilationUnit cu = javaAstManager.getCompilationUnit(returnIType);
				TypeDeclaration returnTypeDeclaration = ASTNodeSearchUtil.getTypeDeclarationNode(returnIType, cu);
				
				if (!returnTypes.containsKey(returnTypeDeclaration)) {
					List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
					returnTypes.put(returnTypeDeclaration, methods);
				}
				returnTypes.get(returnTypeDeclaration).add(method);
			}
			
			for(TypeDeclaration typeDeclaration : returnTypes.keySet()) {
				// Create a child for the return type
				EObject child = EcoreUtil.create(concreteChildType);
				if (feature.isMany()) {
					((EList) element.eGet(feature)).add(child);
				} else {
					element.eSet(feature, child);
				}
				contextManager.associateContext(child, typeDeclaration);
				
				// Recursively analyze the type
				if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
					return false;
				
				// Add one marker for each method that returns that type
				for(MethodDeclaration method : returnTypes.get(typeDeclaration)) {
					IJavaElement iMethod = method.resolveBinding().getJavaElement();
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iMethod);
					markerDescriptor.setAttributes(feature, method);
					// TODO - we are pointing the marker to the "method". We should search the AST for the return type
					// node and point the marker to it.
					markerDescriptor.setExplanation(typeDeclaration.getName().getFullyQualifiedName());
					markerDescriptor.create(element);
				}
				// If not is many, we just analyzed the first type and now leave
				if (! feature.isMany()) {
					break;
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * @return true iff feature is present
	 * @throws FSMLMappingException 
	 */
	public boolean doHasNoAttribute_reverse(EObject element, EAttribute feature, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		Annotation currentAnnotation = contextManager.getContextAnnotation(element, true, progressMonitor);
		if (currentAnnotation.getNodeType() == ASTNode.NORMAL_ANNOTATION){
			NormalAnnotation na = (NormalAnnotation) currentAnnotation;
			if (na.values().isEmpty()){
				element.eSet(feature, true);
			}
			else{
				element.eSet(feature, false);
			}
			return true;	
		}
		element.eSet(feature, currentAnnotation.getNodeType() == ASTNode.MARKER_ANNOTATION);
		return true; 
	}
	

	public IAnalysisManagers getAnalysisManagers() {
		if (analysisManagers == null) {
			analysisManagers = new AnalysisManagers(project);
		}
		return analysisManagers;
	}
	public IType findIType(String fullyQualifiedName) {
		try {
			return project.findType(fullyQualifiedName);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	public boolean doMethodCalls_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		String key = FSMLEcoreUtil.computeAnnotationKey(annotation);
		
		// search for method calls in the context of a method or a class
		EObject contextMethodElement = FSMLEcoreUtil.retrieveContextElement(element, CONTEXT_METHOD);
		EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(element, CONTEXT_CLASS);
		
		EObject contextElement = null;
		IType contextType = null;
		IMethod contextMethod = null;
		if (contextMethodElement == null && contextClassElement != null) {
			// only class
			contextElement = contextClassElement;
			contextType =contextManager.getContextIType(contextElement, true);
		}
		else if (contextMethodElement != null && contextClassElement == null) {
			// only method
			contextElement = contextMethodElement;
			contextMethod = (IMethod) contextManager.getContextIMethod(contextElement, true);
		}
		else if (contextMethodElement != null && contextClassElement != null) {
			// TODO: take the closest one. implement it properly
			// for now assume that the method is closer
			contextElement = contextMethodElement;
			contextMethod = (IMethod) contextManager.getContextIMethod(contextElement, true);
		}
		
		if (contextElement != null) {
			IType targetType = iTypes.get(key);
			IMethod targetMethod = iMethods.get(key);
			
			String scope = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_IN, false);
			// default is SOURCE_HIERARCHY for types and NO_HIERARCHY for methods
			int hierarchyConstant = contextType != null ? SOURCE_HIERARCHY : NO_HIERARCHY;
			if (scope != null) {
				if (scope.equals(CONTEXT_CLASS))
					hierarchyConstant = NO_HIERARCHY;
			}
			String receiver = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_RECEIVER, false);
			
			Collection<SearchMatch> result = callsMethod(contextType != null ? contextType : contextMethod, targetType, targetMethod, progressMonitor, hierarchyConstant);
			
			for (SearchMatch match : result) {
				IJavaElement iJavaElement = (IJavaElement) match.getElement();
				iJavaElement = (IJavaElement) iJavaElement.getPrimaryElement();
				CompilationUnit cu =contextManager.getCUforIJavaElement(iJavaElement, false, progressMonitor);		
				if (cu == null)
					continue;
				ASTNode astNode = ASTNodeSearchUtil.findNode(match, cu); 

				// for binary there may not be astNode!
				if (astNode != null) {
					if (astNode instanceof Name)
						astNode = astNode.getParent();
					if (astNode instanceof ExpressionStatement)
						astNode = ((ExpressionStatement) astNode).getExpression();

					if (astNode instanceof MethodDeclaration) {
						Stats.INSTANCE.log("Method reference which is a method declaration found. Ignoring");
						continue;
					}
					else if (astNode instanceof MethodRef) {
						Stats.INSTANCE.log("Method reference in JavaDoc found. Ignoring");
						continue;
					}
					else if (!(astNode instanceof MethodInvocation) && !(astNode instanceof ClassInstanceCreation)){
						//ignore TagElements and MethodRefs
						if (!(astNode instanceof TagElement) && !(astNode instanceof MethodRef) && !(astNode instanceof SuperMethodInvocation)) {
							Stats.INSTANCE.log("Method reference which is either method invocation nor class instance creation found: " + astNode.getClass() + "\n");
						}
					}
				} 
				else
					Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() +" <callsMethod> ASTNode for match not found: " + match + "\n");
				
				// check if expression is assignable to the required receiver
				if (receiver != null) {
					Expression expression = null;
					if (astNode instanceof MethodInvocation)
						expression = ((MethodInvocation) astNode).getExpression();
					else if (astNode instanceof ClassInstanceCreation)
						expression = ((ClassInstanceCreation) astNode).getExpression();
					if (expression != null) {
						while (expression instanceof ParenthesizedExpression)
							expression = ((ParenthesizedExpression) expression).getExpression();

						ITypeBinding typeBinding = expression.resolveTypeBinding();
						
						if (typeBinding == null) {
							continue;
						}
						IType iType = (IType) typeBinding.getJavaElement();
						if (!implementsOrExtendsType(iType, receiver, false, progressMonitor))
							continue;	
						else //analyze implementation variant
							if (analyzeImplVariants) {
								Stats.INSTANCE.log(element.eClass(), feature, annotation,"receiver is a "+expression.getClass().getSimpleName());
							}
							
					}
					else {
						// the receiver is 'this'
						// locate the containing method declaration
						IType containingType = findITypeContainingASTNode(astNode);
						if (!implementsOrExtendsType(containingType, receiver, false, progressMonitor))
							continue;
						else //analyze implementation variant
							if (analyzeImplVariants) {
								Stats.INSTANCE.log(element.eClass(), feature, annotation,"receiver is this");
							}
						
					}
				}
					
				boolean featureOk = false;
				// EReference
				if (feature instanceof EReference) {
					EObject child = EcoreUtil.create(concreteChildType);
						if (astNode instanceof MethodInvocation) {
							if (feature.isMany())
								((EList)element.eGet(feature)).add(child);
							else
								element.eSet(feature, child);
							
							
							contextManager.associateContext(child, astNode);					 			
							if (reverseFeatureRepresentedAsClass(child, progressMonitor)) {
								Stats.INSTANCE.log(element.eClass(), feature, annotation);
									if (analyzeImplVariants) {
										MethodInvocation methodInvocation = (MethodInvocation) astNode; 
										//analyze the implementation variants
										//find the method name
										ASTNode currentNode=astNode;
										while (currentNode.getNodeType()!=ASTNode.METHOD_DECLARATION) {
											currentNode=currentNode.getParent();
										}
										List<Expression> args = methodInvocation.arguments();
										for (Expression arg:args) {
											Stats.INSTANCE.log(element.eClass(), feature, annotation, "Arguments: "+arg.getClass().getSimpleName());
										}
										String methodName = ((MethodDeclaration)currentNode).getName().toString();
										if (hierarchyConstant==NO_HIERARCHY) {
											Stats.INSTANCE.log(element.eClass(), feature, annotation, "inMethod: "+methodName+", atLocation: "+getStmtLocationInMethod(astNode));
										} else { //we searched beyond the local file
											//try to see if we still get the method call if we just search locally
											Collection<SearchMatch> localResult =callsMethod(contextType != null ? contextType : contextMethod, targetType, targetMethod, progressMonitor, NO_HIERARCHY);
											if (localResult.contains(match)) {
												Stats.INSTANCE.log(element.eClass(), feature, annotation, "inMethod: "+methodName+", atLocation: "+getStmtLocationInMethod(astNode));
											} else if (contextType != null) {
												Stats.INSTANCE.log(element.eClass(), feature, annotation, "inheritsFrom: "+contextType.getSuperclassName());
											}
										}
									}								
								featureOk = true;
							}
							// no need to create the marker, because the child is a method call context
						}
						else if (astNode instanceof ClassInstanceCreation) {
							if (feature.isMany())
								((EList)element.eGet(feature)).add(child);
							else
								element.eSet(feature, child);
							
							ClassInstanceCreation classInstanceCreation = (ClassInstanceCreation) astNode; 
							contextManager.associateContext(child, classInstanceCreation);								
							if (reverseFeatureRepresentedAsClass(child, progressMonitor)) {
								Stats.INSTANCE.log(element.eClass(), feature, annotation);
								featureOk = true;
							}
							// no need to create the marker, because the child is a method call context
						}
				}   
				else {
					if (feature.isMany())
						((EList)element.eGet(feature)).add(true);
					else
						element.eSet(feature, true);
					
					Stats.INSTANCE.log(element.eClass(), feature, annotation);

					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor((IJavaElement) match.getElement());
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), match);
					markerDescriptor.create(element);
				}

				// break iteration if a correct value has been set
				if (!feature.isMany() && featureOk)
					break;
			}
		}
			
		if (feature.isMany()) {
			if (!((EList)element.eGet(feature)).isEmpty())
				return true;
		}
		else {
			if (element.eGet(feature) != null)
				return true;
		}
		return false;
	}
	*/
	/*
	public boolean doMethodCalls_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		String detailName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
		String detailLocationName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMapping.DETAIL_LOCATION_NAME, true);
		String detailLocationSig = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMapping.DETAIL_LOCATION_SIG, "()V");
		String detailPosition = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_POSITION, false);
		
		IMethod targetMethod = iMethods.get(FSMLEcoreUtil.computeAnnotationKey(annotation));
		String[] parameterTypes = targetMethod.getParameterTypes();
		
		// construct a call
		String contents = detailName + CodeTransforms.constructDefaultCallParameters(parameterTypes) + ";";
		
		int position = 0;
		if (detailPosition == null || detailPosition.equals("before"))
			position = CodeTransforms.BEFORE_ADVICE;
		else if (detailPosition.equals("after"))
			position = CodeTransforms.AFTER_ADVICE;
		else 
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, "for detail " + DETAIL_POSITION);
		
		List<ASTNode> result = null;
		
		// method calls can be create in the context method or a context class
		EObject contextMethodElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD);
		if (contextMethodElement != null) {
			MethodDeclaration methodDeclaration = contextManager.getContextMethodDeclaration(contextMethodElement, true, progressMonitor);
			result =  CodeTransforms.weaveAdvice(position, null, methodDeclaration, contents, progressMonitor);
		}
		// no context method, try context class
		EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_CLASS);
		if (contextClassElement != null) {
			TypeDeclaration contextClass = contextManager.getContextTypeDeclaration(contextClassElement, true, progressMonitor); 
			MethodDeclaration methodDeclaration = findMethod(detailLocationName, detailLocationSig, contextClass, true, false, progressMonitor);
			if (methodDeclaration == null)
				// create the method
				methodDeclaration = CodeTransforms.createMethod(project, null, contextClass, "public", detailLocationName, detailLocationSig, null, progressMonitor);
			
			result =  CodeTransforms.weaveAdvice(position, null, methodDeclaration, contents, progressMonitor);
		}

		// need to set up the call as a context and put the markers
		if (result != null && !result.isEmpty()) {
			// should be a single method call. However, in the future, different variants may
			// require some preparation statements, e.g., variable declarations, and the call will
			// the the last one
			ASTNode astNode = result.get(result.size()-1);
			if (astNode instanceof ExpressionStatement) 
				astNode = ((ExpressionStatement) astNode).getExpression();
			if (astNode instanceof MethodInvocation) {
				EObject element = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD_CALL);
				contextManager.associateContext(element, astNode);
			}
		}
		
		return result != null;
	}*/
	/*
	public boolean doExtendsClass_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);

		IType contextIType = contextManager.getContextIType(element, true);
		if (contextIType == null || !contextIType.exists())
			return false;
		
		String requiredSuperTypeName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
		
		if (implementsOrExtendsType(contextIType, requiredSuperTypeName, false, progressMonitor)) {
			if (feature instanceof EAttribute)
				element.eSet(feature, true);
			else {
				EObject child = EcoreUtil.create(concreteChildType);
				element.eSet(feature, child);
				if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
					return false;
			}
			Stats.INSTANCE.log(element.eClass(), feature, annotation);
			
			if (analyzeImplVariants) {
				//analyze implementation variants
				String contextClassTypeSuperClass = contextIType.getSuperclassName();
				if (contextClassTypeSuperClass.equals(requiredSuperTypeName)) {
					Stats.INSTANCE.log(element.eClass(), feature, annotation,"directly");
				} else {
					Stats.INSTANCE.log(element.eClass(), feature, annotation,"indirectly: "+contextClassTypeSuperClass);
				}
			}			
			
			CompilationUnit cu = contextManager.getCUforIJavaElement(contextIType, false, progressMonitor);
			if (cu == null)
				return false;
			
			TypeDeclaration typeDeclaration = ASTNodeSearchUtil.getTypeDeclarationNode(contextIType, cu); 
			if (typeDeclaration != null) {
				Type superClassType = typeDeclaration.getSuperclassType();
				if (superClassType != null) {
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(contextIType);
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), superClassType);
					markerDescriptor.create(element);
				}
				else
					Stats.INSTANCE.log(element.eClass(), feature, "doExtendsClass_reverse: Cannot retrieve SuperType AST node & set the marker.");
			}
			else
				Stats.INSTANCE.log(element.eClass(), feature, " doExtendsClass_reverse: Cannot retrieve TypeDeclaration AST node & set the marker.");			
			return true;
		}
		return false;
	}*/
	/*
	public boolean doExtendsClass_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_CLASS);
		TypeDeclaration contextClassDeclaration  = contextManager.getContextTypeDeclaration(contextClassElement, true, progressMonitor);
		if (contextClassDeclaration == null)
			return false;
	
		String requiredSuperType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true); 
		
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			CodeTransforms.addExtendsDeclaration(null, contextClassDeclaration, requiredSuperType, progressMonitor);
			break;
		case CODE_REMOVE:
			CodeTransforms.removeExtendsDeclaration(null, contextClassDeclaration, requiredSuperType, progressMonitor);
			break;
		}
		return true;
	}*/
	/*
	public boolean doCallsReceived_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		String key = FSMLEcoreUtil.computeAnnotationKey(annotation);
		EObject aux = FSMLEcoreUtil.retrieveContextElement(element, CONTEXT_CLASS);
		if (aux != null) {
			IType contextType =contextManager.getContextIType(element, true);
			String receiver = contextType.getFullyQualifiedName();
			IMethod targetMethod = iMethods.get(key);
		
			// check cache first
			Collection<SearchMatch> result = callsCache.get(targetMethod);
			if (result == null) {
				result = callsMethod(targetMethod, progressMonitor, PROJECT);
				callsCache.put(targetMethod, result);
			}
				
			for (SearchMatch match : result) {
				// remove calls which are not received by the contextType
				CompilationUnit cu =contextManager.getCUforIJavaElement(((IJavaElement) match.getElement()).getPrimaryElement(), false, progressMonitor);		
				if (cu == null)
					continue;
				ASTNode astNode = ASTNodeSearchUtil.findNode(match, cu); 

				// for binary there may not be astNode!
				if (astNode != null) {
					if (astNode instanceof Name)
						astNode = astNode.getParent();
					if (astNode instanceof ExpressionStatement)
						astNode = ((ExpressionStatement) astNode).getExpression();
					if (astNode instanceof MethodDeclaration) {
						Stats.INSTANCE.log("Method reference which is a method declaration found. Ignoring");
						continue;
					}
					else if (astNode instanceof MethodRef) {
						Stats.INSTANCE.log("Method reference in JavaDoc found. Ignoring");
						continue;
					}
					else {
						//ignore TagElements and MethodRefs
						if (!(astNode instanceof TagElement) && !(astNode instanceof MethodRef) && !(astNode instanceof SuperMethodInvocation))
							Stats.INSTANCE.log("Method reference which is either method invocation nor class instance creation found: " + astNode.getClass() + "\n");
					}
				} 
				else
					Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() +" <callsMethod> ASTNode for match not found: " + match + "\n");
				
				// check if expression is assignable to the required receiver
				IType auxType = null;
				if (receiver != null) {
					Expression expression = null;
					if (astNode instanceof MethodInvocation)
						expression = ((MethodInvocation) astNode).getExpression();
					else if (astNode instanceof ClassInstanceCreation)
						expression = ((ClassInstanceCreation) astNode).getExpression();
					if (expression != null) {
						ITypeBinding typeBinding = expression.resolveTypeBinding();
						auxType = (IType) typeBinding.getJavaElement();
						if (!implementsOrExtendsType(auxType, receiver, false, progressMonitor))
							continue;		
					}
					else {
						// the receiver is 'this'
						// locate the containing method declaration
						auxType = findITypeContainingASTNode(astNode);
						if (!implementsOrExtendsType(auxType, receiver, false, progressMonitor))
							continue;
					}
				}
					
				boolean featureOk = false;
				// EReference
				if (feature instanceof EReference) {
					EObject child = EcoreUtil.create(concreteChildType);
						if (astNode instanceof MethodInvocation) {
							if (feature.isMany())
								((EList)element.eGet(feature)).add(child);
							else
								element.eSet(feature, child);
							
							MethodInvocation methodInvocation = (MethodInvocation) astNode; 
							contextManager.associateContext(child, methodInvocation);								
							if (reverseFeatureRepresentedAsClass(child, progressMonitor)) {
								Stats.INSTANCE.log(element.eClass(), feature, annotation);
								featureOk = true;
							}
							// no need to create the marker, because the child is a method call context
						}
						else if (astNode instanceof ClassInstanceCreation) {
							if (feature.isMany())
								((EList)element.eGet(feature)).add(child);
							else
								element.eSet(feature, child);
							
							ClassInstanceCreation classInstanceCreation = (ClassInstanceCreation) astNode; 
							contextManager.associateContext(child, classInstanceCreation);								
							if (reverseFeatureRepresentedAsClass(child, progressMonitor))
								Stats.INSTANCE.log(element.eClass(), feature, annotation);
							// no need to create the marker, because the child is a method call context
						}
				}
				// EAttribute
				else {
					if (feature.isMany())
						((EList)element.eGet(feature)).add(true);
					else
						element.eSet(feature, true);
					
					Stats.INSTANCE.log(element.eClass(), feature, annotation);
					
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(auxType);
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), match);
					markerDescriptor.create(element);
				}
			
				// break iteration if a correct value has been set
				if (!feature.isMany() && featureOk)
					break;
			}
		}
			
		if (feature.isMany()) {
			if (!((EList)element.eGet(feature)).isEmpty())
				return true;
		}
		else {
			if (element.eGet(feature) != null)
				return true;
		}
		return false;
	}	 */
	/*public boolean doCallsReceived_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		String detailName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
		String detailLocationName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_LOCATION_NAME, false);
		String detailLocationSig = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_LOCATION_SIG, "()V");
		String detailPosition = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_POSITION, false);
		
		IMethod targetMethod = iMethods.get(FSMLEcoreUtil.computeAnnotationKey(annotation));
		String[] parameterTypes = targetMethod.getParameterTypes();
		
		// construct a call
		String contents = detailName + CodeTransforms.constructDefaultCallParameters(parameterTypes) + ";";
		
		int position = 0;
		if (detailPosition == null || detailPosition.equals("before"))
			position = CodeTransforms.BEFORE_ADVICE;
		else if (detailPosition.equals("after"))
			position = CodeTransforms.AFTER_ADVICE;
		else 
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, "for detail " + DETAIL_POSITION);
		
		List<ASTNode> result = null;
		
		// method calls can be create in the context method or a context class
		EObject contextMethodElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD);
		if (contextMethodElement != null) {
			MethodDeclaration contextMethod = contextManager.getContextMethodDeclaration(contextMethodElement, true, progressMonitor);
			result =  CodeTransforms.weaveAdvice(position, null, contextMethod, contents, progressMonitor);
		}
		else {
			// no context method, try context class
			EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_CLASS);
			if (contextClassElement != null) {
				TypeDeclaration contextClass = contextManager.getContextTypeDeclaration(contextClassElement, true, progressMonitor); 
		
				MethodDeclaration methodDeclaration = findMethod(detailLocationName, detailLocationSig, contextClass, true, false, progressMonitor);
				if (methodDeclaration == null)
					// create the method
					methodDeclaration = CodeTransforms.createMethod(project, null, contextClass, "public", detailLocationName, detailLocationSig, null, progressMonitor);
				
				result =  CodeTransforms.weaveAdvice(position, null, methodDeclaration, contents, progressMonitor);
			}
		}
		// need to set up the call as a context and put the markers
		if (result != null && !result.isEmpty()) {
			// should be a single method call. However, in the future, different variants may
			// require some preparation statements, e.g., variable declarations, and the call will
			// the the last one
			ASTNode astNode = result.get(result.size()-1);
			if (astNode instanceof ExpressionStatement)
				astNode = ((ExpressionStatement) astNode).getExpression();
			if (astNode instanceof MethodInvocation) {
				EObject element = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD_CALL);
				contextManager.associateContext(element, astNode);
			}
		}
		
		return result != null;
	}*/
	/*
	public boolean doMethods_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		IType contextIType = contextManager.getContextIType(element, true);
		
		if (contextIType == null || !contextIType.exists())
			return false;
		
		if (feature.getEType().getName().equals("EString")) {
			// expect <signature> parameter
			String methodSignature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, "()V");
			
			ArrayList<MarkerDescriptor> markerDescriptors = new ArrayList<MarkerDescriptor>();
			
			boolean found = false;
			for (IMethod iMethod : contextIType.getMethods()) { 
				if (iMethod.getSignature().equals(methodSignature)) {
					Stats.INSTANCE.log(element.eClass(), feature, annotation);
					
					if (analyzeImplVariants) {
						//still need to analyze implementation variants here?
						Stats.INSTANCE.log(element.eClass(), feature, annotation,"no variants...");
					}					
					
					
					found = true;
					
					String methodName = iMethod.getElementName();
					if (feature.isMany()) {
						((EList)element.eGet(feature)).add(methodName);
						
						JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iMethod);
						markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName() + "(" + methodName + ")", iMethod);
						markerDescriptor.setElementAndValue(element, methodName);
						markerDescriptors.add(markerDescriptor);
					}
					else {
						element.eSet(feature, methodName);
						
						JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iMethod);
						markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), iMethod);
						markerDescriptor.setElement(element);
						markerDescriptors.add(markerDescriptor);
						// ignore the rest of results!
						break;
					}
				}
			}
			for (MarkerDescriptor descriptor : markerDescriptors)
				descriptor.create();
			return found;
		} 
		else if (feature.getEType().getName().equals("EBoolean") || feature instanceof EReference) {
			// expect <name, signature> parameters
			String methodName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
			String methodSignature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, "()V");
			String inherited = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INHERITED, false);
			
			if (!feature.isMany()) {
				boolean includeInherited = inherited != null && inherited.equals("true");
				// if there is no name for the method, search for a constructor, using the name of the context class.
				if (methodName == null) {
					methodName = contextIType.getElementName();
				}
				IMethod method = findMethod(methodName, methodSignature, contextIType, true, includeInherited, progressMonitor);
				
				if (method != null && method.exists()) {
					if (feature instanceof EAttribute)
						element.eSet(feature, new Boolean(true));
					else {
						EObject child = EcoreUtil.create(concreteChildType);
						element.eSet(feature, child);
						
						CompilationUnit cu =contextManager.getCUforIJavaElement(method, false, progressMonitor);
						MethodDeclaration methodDeclaration = (MethodDeclaration) cu.findDeclaringNode(method.getKey());
						if (methodDeclaration == null)
							return false;
						contextManager.associateContext(child, methodDeclaration);
						
						if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
							return false;
					}
					Stats.INSTANCE.log(element.eClass(), feature, annotation);
					
					
					if (analyzeImplVariants) {
						//analyze implementation variants
						if (!includeInherited) {
							Stats.INSTANCE.log(element.eClass(), feature, annotation,"implements (as required)");
						} else {
							IMethod localMethod = findMethod(methodName, methodSignature, contextIType, true, false, progressMonitor);
							if (localMethod==null) {
								Stats.INSTANCE.log(element.eClass(), feature, annotation,"inheritsFrom: "+contextIType.getSuperclassName());							
							} else {
								//check if the method is in the super classes
								IMethod ancestorMethods = findMethod(methodName, methodSignature, contextIType, false, true, progressMonitor);
								if (ancestorMethods==null) {				
									Stats.INSTANCE.log(element.eClass(), feature, annotation,"implements");
								} else {
									Stats.INSTANCE.log(element.eClass(), feature, annotation,"overrides");
									
								}
							}
						}
					}					
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(method);
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), method);
					markerDescriptor.create(element);
					return true;
				}
			}
		}
		return false;
	}
	*/
	/*
	public boolean doMethods_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		// contains the feature
		EObject element = syncItem.getCode() != null ? syncItem.getCode() : syncItem.getModel();
		// structural feature of an element
		EStructuralFeature feature = null;

		if (syncItem instanceof ClassSyncItem) {
			// forwarding a containment reference
			ClassSyncItem classSyncItem = (ClassSyncItem) syncItem;
			feature = element.eContainmentFeature();
		}
		else if (syncItem instanceof StructuralFeatureSyncItem){
			// forwarding an attribute
			StructuralFeatureSyncItem featureSyncItem = (StructuralFeatureSyncItem) syncItem;
			feature = featureSyncItem.getStructuralFeature();
			ClassSyncItem classSyncItem = (ClassSyncItem) featureSyncItem.eContainer();
		}
		TypeDeclaration contextClass = contextManager.getContextTypeDeclaration(FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_CLASS), true, progressMonitor);
		
		String methodName = null;
		String methodSignature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, "()V");
		// Michal: the parameter does not have any effect. We create local methods only.
		//String inherited = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INHERITED);
		
		if (feature.getEType().getName().equals("EString"))
			methodName = (String) element.eGet(feature);
		else if (feature.getEType().getName().equals("EBoolean") || feature instanceof EReference)
			methodName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);

		// if there is no name for the method, create a constructor, using the name of the context class.
		if (methodName == null)
			methodName = contextClass.getName().getIdentifier();
		
		// create the method
		boolean result = false;
		MethodDeclaration methodDeclaration;
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			methodDeclaration = CodeTransforms.createMethod(project, null, contextClass, "public", methodName, methodSignature, null, progressMonitor);
			contextManager.associateContext(element, methodDeclaration);
			result = true;
			break;
		case CODE_REMOVE:
			methodDeclaration = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
			if (methodDeclaration != null)
				CodeTransforms.commentOutASTNode(null, methodDeclaration, element.eClass(), feature, progressMonitor);
			break;
		}
		
		// TODO: markers
		return result;
	}*/
	/*
		public boolean doImplementsInterface_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		IType iType = contextManager.getContextIType(element, true);
		if (iType == null)
			return false;
		String requiredSuperType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
		
		if (implementsOrExtendsType(iType, requiredSuperType, false, progressMonitor)) {
			if (feature instanceof EAttribute)
				element.eSet(feature, true);
			else {
				EObject child = EcoreUtil.create(concreteChildType);
				element.eSet(feature, child);
				if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
					return false;
			}
			Stats.INSTANCE.log(element.eClass(), feature, annotation);
			
			if (analyzeImplVariants) {
				//analyze implementation variants
				String[] implementedInterfaces=iType.getSuperInterfaceNames();
				boolean foundInterface = false;
				for (String implementedInterface: implementedInterfaces) {
					if (implementedInterface.equals(requiredSuperType)) {
						foundInterface = true;
						Stats.INSTANCE.log(element.eClass(), feature, annotation,"directly");
					}
				}
				if (!foundInterface) {
					Stats.INSTANCE.log(element.eClass(), feature, annotation,"indirectly: "+iType.getSuperclassName());
				}
			}				
			TypeDeclaration typeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
			if (typeDeclaration == null)
				return false;
			for (Object auxSuperType : typeDeclaration.superInterfaceTypes()) {
				Type superInterface = (Type) auxSuperType;
				ITypeBinding binding = superInterface.resolveBinding();
				if (binding != null && binding.getQualifiedName().equals(requiredSuperType)) {
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iType);
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), superInterface);
					markerDescriptor.create(element);
					break;
				}
			}
			return true;
		}
		return false;
	}
	 */
	/*	public boolean doImplementsInterface_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {		
	RA action = syncItem.getReconciliationAction();
	TypeDeclaration contextClass = contextManager.getContextTypeDeclaration(FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_CLASS), true, progressMonitor);

	String requiredSuperType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
	
	switch (action) {
	case CODE_ADD:
		CodeTransforms.addInterfaceDeclaration(null, contextClass, requiredSuperType, progressMonitor);
		break;
	case CODE_REMOVE:
		CodeTransforms.removeInterfaceDeclaration(null, contextClass, requiredSuperType, progressMonitor);
		break;
	}
	return true;
	}*/
	/*
	public boolean doArgumentIsField_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		
		// could be a method invocation or class instance creation
		MethodInvocation methodInvocation = contextManager.getContextMethodInvocation(element, true, progressMonitor);
		ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(element, true, progressMonitor);
		
		// exactly one of them must be non-null
		if((methodInvocation == null && classInstanceCreation == null) ||
		   (methodInvocation != null && classInstanceCreation != null))
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, feature);
		
		String indexString = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
		int index = Integer.valueOf(indexString) - 1;
		
		ASTNode argument = null;
		if (methodInvocation != null)
			argument = (ASTNode) methodInvocation.arguments().get(index);
		if (classInstanceCreation != null)
			argument = (ASTNode) classInstanceCreation.arguments().get(index);
		
		if (argument instanceof SimpleName) {
			SimpleName simpleName = (SimpleName) argument;
			IBinding binding = simpleName.resolveBinding();
			if (binding.getKind() == IBinding.VARIABLE) {
				IVariableBinding variableBinding = (IVariableBinding) binding;
				if (variableBinding.isField()) {
					Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentIsField> argument is a field");
					
					if (feature instanceof EAttribute)
						element.eSet(feature, true);
					else {
						EObject child = EcoreUtil.create(concreteChildType);
						element.eSet(feature, child);
						
						// check the sameAs constraint
						String sameAs = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_SAME_AS, false);
						
						if (sameAs != null && !sameAs.isEmpty()) {
							NavigationResult navigationResult = FSMLEcoreUtil.navigateToEObject(element, sameAs);
							VariableDeclarationFragment targetField = contextManager.getContextVariableDeclarationFragment(navigationResult.eObject, true, progressMonitor);
							
							if (targetField == null || !targetField.resolveBinding().getKey().equals(variableBinding.getKey())) {
								element.eUnset(feature);
								return false;
							}
						}
						IField field = (IField) variableBinding.getJavaElement();
						CompilationUnit cu =contextManager.getCUforIJavaElement(field, false, progressMonitor);
						VariableDeclarationFragment fieldDeclarationFragment = ASTNodeSearchUtil.getFieldDeclarationFragmentNode(field, cu);
						if (fieldDeclarationFragment != null)
							contextManager.associateContext(child, fieldDeclarationFragment);
						
						if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
							return false;
					}
					Stats.INSTANCE.log(element.eClass(), feature, annotation);
					
					IType iTypeOfArgument = findITypeContainingASTNode(argument);
					if (iTypeOfArgument == null)
						iTypeOfArgument = (IType) contextManager.getContextIType(element, true);
					
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iTypeOfArgument);
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), argument);
					markerDescriptor.create(element);
					return true;
				}
			}
		}
		return false;	
	}
	public boolean doArgumentIsField_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		String detailIndex = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
		int index = 0;
		if (detailIndex != null && !detailIndex.isEmpty()) {
			try {
				index = Integer.parseInt(detailIndex);
			}
			catch (NumberFormatException e) {
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, " of detail " + DETAIL_INDEX);
			}
		}
		EObject element = syncItem.getModel();

		MethodInvocation contextMethodInvocation = contextManager.getContextMethodInvocation(element, true, progressMonitor);
		ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(element, true, progressMonitor);

		
		String fieldName = null;
		// field name comes from either 
		// 1) an attribute annotated with QUERY_FIELD_NAME or 
		// 2) from other feature annotated with CONTEXT_FIELD pointed to by DETAIL_SAME_AS parameter
		
		EObject contextFieldElement = element;
		
		String detailSameAs = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_SAME_AS, false);
		if (detailSameAs != null) {
			NavigationResult target = FSMLEcoreUtil.navigateToEObject(element, detailSameAs);
			contextFieldElement = target.eObject;
			if (target == null || target.eObject == null)
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, detailSameAs + " of " + DETAIL_SAME_AS);
		}
		
		// the field name is the value of the attribute annotated with QUERY_FIELD_NAME
		EAnnotation contextFieldAnnotation = FSMLEcoreUtil.getEAnnotation(contextFieldElement.eClass(), CONTEXT_FIELD);
		if (contextFieldAnnotation != null) {
			// find an attribute annotated with QUERY_FIELD_NAME
			EStructuralFeature fieldNameFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(contextFieldElement.eClass(), new String[] { QUERY_FIELD_NAME });
			if (fieldNameFeature == null)
				throw new FSMLMappingException(Cause.MISSING_ATTRIBUTE, QUERY_FIELD_NAME);
			
			if (fieldNameFeature instanceof EAttribute)
				fieldName = (String) contextFieldElement.eGet(fieldNameFeature);
			else
				throw new FSMLMappingException(Cause.MAPPING_REQUIRES_ATTRIBUTE, fieldNameFeature);
		}
		else
			throw new FSMLMappingException(Cause.REQUIRED_CONTEXT_MISSING, CONTEXT_FIELD);
		
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			if (contextMethodInvocation != null) {
				Expression expression = CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, fieldName, progressMonitor);
				return expression != null;
			}	
			if (classInstanceCreation != null) {
				Expression expression =  CodeTransforms.replaceMethodCallArgument(null, classInstanceCreation, index, fieldName, progressMonitor);
				return expression != null;
			}
		case CODE_REMOVE:
			if (contextMethodInvocation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
			if (classInstanceCreation != null)
				return CodeTransforms.replaceMethodCallArgument(null, classInstanceCreation, index, "null", progressMonitor) != null;
		}
		return false;
	}
	 */
	/*
	public boolean doArgumentIsThis_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		// could be a method invocation or class instance creation
		MethodInvocation methodInvocation = contextManager.getContextMethodInvocation(element, true, progressMonitor);
		ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(element, true, progressMonitor);
		
		// exactly one of them must be non-null
		if ((methodInvocation == null && classInstanceCreation == null) ||
			   (methodInvocation != null && classInstanceCreation != null))
			return false;
		
		String indexString = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
		int index = Integer.valueOf(indexString) - 1;
		
		ASTNode argument = null;
		if (methodInvocation != null)
			argument = (ASTNode) methodInvocation.arguments().get(index);
		if (classInstanceCreation != null)
			argument = (ASTNode) classInstanceCreation.arguments().get(index);
		
		if (argument instanceof ThisExpression)
			Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentIsThis> argument is this expression");
		else
			return false;
		
		if (feature instanceof EAttribute)
			element.eSet(feature, true);
		else {
			EObject child = EcoreUtil.create(concreteChildType);
			element.eSet(feature, child);
			if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
				return false;
		}
		Stats.INSTANCE.log(element.eClass(), feature, annotation);
		
		IType iTypeOfArgument = findITypeContainingASTNode(argument);
		if (iTypeOfArgument == null)
			iTypeOfArgument = (IType) contextManager.getContextIType(element, true);
		
		JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iTypeOfArgument);
		markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), argument);
		markerDescriptor.create(element);
		return true;
	
	}
	public boolean doArgumentIsThis_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws FSMLMappingException {
		String detailIndex = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
		int index = 0;
		if (detailIndex != null && !detailIndex.isEmpty()) {
			try {
				index = Integer.parseInt(detailIndex);
			}
			catch (NumberFormatException e) {
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, " of detail " + DETAIL_INDEX);
			}
		}
		EObject contextMethodInvocationElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD_CALL);

		MethodInvocation contextMethodInvocation = contextManager.getContextMethodInvocation(contextMethodInvocationElement, true, progressMonitor);
		ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(contextMethodInvocationElement, true, progressMonitor);
		
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			if (contextMethodInvocation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "this", progressMonitor) != null;
			if (classInstanceCreation != null)
				return CodeTransforms.replaceMethodCallArgument(null, classInstanceCreation, index, "this", progressMonitor) != null;
		case CODE_REMOVE:
			if (contextMethodInvocation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
			if (classInstanceCreation != null)
				return CodeTransforms.replaceMethodCallArgument(null, classInstanceCreation, index, "null", progressMonitor) != null;
		}
		return false;
	}
	 */
	/*
	public boolean doAssignedWithNull_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		EObject fieldFeature = FSMLEcoreUtil.retrieveContextElement(element, CONTEXT_FIELD);
		EObject classFeature = FSMLEcoreUtil.retrieveContextElement(fieldFeature, CONTEXT_CLASS);
		
		if (fieldFeature == null)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, feature, CONTEXT_FIELD);
		if (classFeature == null)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, feature, CONTEXT_CLASS);
		
		VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(fieldFeature, true, progressMonitor);
		IField auxField = (IField) variableDeclarationFragment.resolveBinding().getJavaElement();
		
		if (variableDeclarationFragment != null) {
			Collection<FieldReferenceMatch> result = writesToField(auxField, progressMonitor);
			
			for (FieldReferenceMatch fieldReferenceMatch : result) {
				Expression rhs = retrieveRHSFromMatch(fieldReferenceMatch, progressMonitor);
				if (rhs instanceof NullLiteral) {
					if (feature instanceof EAttribute)
						element.eSet(feature, true);
					else {
						EObject child = EcoreUtil.create(concreteChildType);
						element.eSet(feature, child);
						if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
							return false;
					}
					Stats.INSTANCE.log(element.eClass(), feature, annotation);
					
					JavaMarkerDescriptor descriptor = JavaMarkers.createMarkerDescriptor(auxField);
					descriptor.setAttributes(feature, element.eClass().getName()+ "::" + feature.getName(), rhs.getParent());
					descriptor.create(element);
					return true;
				}
			}
		}
		return false;
	}
	public boolean doAssignedWithNull_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		
		String detailLocationName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_LOCATION_NAME, false);
		String detailLocationSig = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_LOCATION_SIG, false);
		if (detailLocationSig == null || detailLocationSig.isEmpty()) 
			detailLocationSig = "()V";
		String detailPosition = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_POSITION, false);
		VariableDeclarationFragment targetField = contextManager.getContextVariableDeclarationFragment(FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_FIELD), true, progressMonitor);
	
		// construct an assignment
		String contents = targetField.getName().getIdentifier() + " = null;";
		
		
		int position = 0;
		if (detailPosition == null || detailPosition.equals("before"))
			position = CodeTransforms.BEFORE_ADVICE;
		else if (detailPosition.equals("after"))
			position = CodeTransforms.AFTER_ADVICE;
		else 
			throw new FSMLMappingException(Cause.INCORRECT_VALUE, "for detail " + DETAIL_POSITION);
		
		// field assignment can be created in the context method or a context class
		EObject contextMethodElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD);
		if (contextMethodElement != null) {
			MethodDeclaration contextMethod = contextManager.getContextMethodDeclaration(contextMethodElement, true, progressMonitor);
			CodeTransforms.weaveAdvice(position, null, contextMethod, contents, progressMonitor);
			return true;
		}
		// no context method, try context class
		EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_CLASS);
		if (contextClassElement != null) {
			TypeDeclaration contextClass = contextManager.getContextTypeDeclaration(contextClassElement, true, progressMonitor); 
			MethodDeclaration contextMethod = findMethod(detailLocationName, detailLocationSig, contextClass, true, false, progressMonitor);
			if (contextMethod != null) {
				CodeTransforms.weaveAdvice(position, null, contextMethod, contents, progressMonitor);
				return true;
			}
			else {
				// create the method
				CodeTransforms.createMethod(project, null, contextClass, "public", detailLocationName, detailLocationSig, "\t" + contents, progressMonitor);
				return true;
			}
		}
		return false;
	}
	 */
	/*
	public boolean doAssignedWithNew_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		IField auxField = (IField) contextManager.getContextIField(element, true);
		if (auxField == null)
			return false;
		
		VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor);
		
		
		if (variableDeclarationFragment != null) {
			Expression initializer = variableDeclarationFragment.getInitializer();
			if (initializer instanceof ClassInstanceCreation) {
				// we assume that the code is correct
				if (feature instanceof EAttribute)
					element.eSet(feature, true);
				else {
					EObject child = EcoreUtil.create(concreteChildType);
					element.eSet(feature, child);
					
					contextManager.associateContext(child, initializer);
					if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
						return false;
				}
				
				Stats.INSTANCE.log(element.eClass(), feature, annotation);
				
				JavaMarkerDescriptor descriptor = JavaMarkers.createMarkerDescriptor(auxField);
				descriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), initializer);
				descriptor.create(element);
				return true;
			}
			Collection<FieldReferenceMatch> result = writesToField(auxField, progressMonitor);
			
			for (FieldReferenceMatch fieldReferenceMatch : result) {	
				Expression rhs = retrieveRHSFromMatch(fieldReferenceMatch, progressMonitor);
				if (rhs instanceof ClassInstanceCreation) {
					ClassInstanceCreation cic = (ClassInstanceCreation) rhs;
					
					Type instanceType = cic.getType();
					String requiredClassName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_CLASS, true);
					String instanceTypeSignature = null;
					
					if (instanceType instanceof QualifiedType) {
						QualifiedType qtype = (QualifiedType) instanceType;
						String qtypeName = qtype.getName().getFullyQualifiedName();
						instanceTypeSignature = Signature.createTypeSignature(qtypeName, true);
						
					}
					else if (instanceType instanceof SimpleType) {
						SimpleType stype = (SimpleType) instanceType;
						String stypeName = stype.getName().getFullyQualifiedName();
						instanceTypeSignature = Signature.createTypeSignature(stypeName, true);
					} 
					if (compareTypeSignatures(requiredClassName, instanceTypeSignature)) {
						if (feature instanceof EAttribute)
							element.eSet(feature, true);
						else {
							EObject child = EcoreUtil.create(concreteChildType);
							element.eSet(feature, child);
							
							contextManager.associateContext(child, cic);
							if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
								return false;
						}
						
						Stats.INSTANCE.log(element.eClass(), feature, annotation);
						
						JavaMarkerDescriptor descriptor = JavaMarkers.createMarkerDescriptor(auxField);
						descriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), cic);
						descriptor.create(element);
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean doAssignedWithNew_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		// recognize the variant
		// variant1: assignment in a method
		String detailClass = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_CLASS, true);
		String detailSignature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, false);
		String detailLocationName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_LOCATION_NAME, false);
		String detailLocationSig = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_LOCATION_SIG, false);
		// default location signature
		if (detailLocationSig == null || detailLocationSig.isEmpty()) 
			detailLocationSig = "()V";
		String detailPosition = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_POSITION, false);
		
		// variant2: assignment in the field's initializer
		String initializer = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INITIALIZER, false);

		// prepare class instance creation 
		String newExpression = "new " + Signature.getSimpleName(detailClass) + CodeTransforms.constructDefaultCallParameters(detailSignature);
		
		// construct the new instance creation statement
		IType instanceType = project.findType(detailClass);
		
		if (instanceType.isInterface() || (instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()))) {
			// create annonymous subclass for interfaces and abstract classes
			newExpression += " {\n\t  }";
		}
		
		VariableDeclarationFragment targetField = contextManager.getContextVariableDeclarationFragment(FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_FIELD), true, progressMonitor);
		if (initializer != null && initializer.equals("true")) {
			//variant1
			ClassInstanceCreation cic = (ClassInstanceCreation) CodeTransforms.setFieldsInitializer(null, targetField, newExpression, progressMonitor); 
			contextManager.associateContext(syncItem.getModel(), cic);
			return true;
		} else {
			// variant2
			// construct an assignment
			if (detailLocationName == null)
				throw new FSMLMappingException(Cause.MISSING_PARAMETER, JavaMappingInterpreter.DETAIL_LOCATION_NAME);
			// construct a call
			String contents = targetField.getName().getIdentifier() + " = " + newExpression + ";";
			
			int position = 0;
			if (detailPosition == null || detailPosition.equals("before"))
				position = CodeTransforms.BEFORE_ADVICE;
			else if (detailPosition.equals("after"))
				position = CodeTransforms.AFTER_ADVICE;
			else 
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, "for detail " + DETAIL_POSITION);
			
			// field assignment can be created in the context method or a context class
			EObject contextMethodElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD);
			if (contextMethodElement != null) {
				MethodDeclaration contextMethod = contextManager.getContextMethodDeclaration(contextMethodElement, true, progressMonitor);
				List<ASTNode> result = CodeTransforms.weaveAdvice(position, null, contextMethod, contents, progressMonitor);
				contextManager.associateContext(syncItem.getModel(), (ClassInstanceCreation) result.get(0));
				return true;
			}
			else {
				// no context method, try context class
				EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_CLASS);
				if (contextClassElement != null) {
					TypeDeclaration contextClass = contextManager.getContextTypeDeclaration(contextClassElement, true, progressMonitor); 
					MethodDeclaration methodDeclaration = findMethod(detailLocationName, detailLocationSig, contextClass, true, false, progressMonitor);
					if (methodDeclaration == null)
						// create the method
						methodDeclaration = CodeTransforms.createMethod(project, null, contextClass, "public", detailLocationName, detailLocationSig, null, progressMonitor);
					
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
		return false;
	}

	 */
	/*
	public boolean doArgumentIsNew_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		// could be a method invocation or class instance creation
		MethodInvocation methodInvocation = contextManager.getContextMethodInvocation(element, true, progressMonitor);
		ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(element, true, progressMonitor);
		
		// exactly one of them must be non-null
		assert(!(methodInvocation == null && classInstanceCreation == null) &&
			   !(methodInvocation != null && classInstanceCreation != null));
		
		String indexString = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
		int index = Integer.valueOf(indexString) - 1;
		
		ASTNode argument = null;
		if (methodInvocation != null)
			argument = (ASTNode) methodInvocation.arguments().get(index);
		if (classInstanceCreation != null)
			argument = (ASTNode) classInstanceCreation.arguments().get(index);
		
		if (argument instanceof ClassInstanceCreation)
			Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentIsNew> argument is a class instance creation expression");
		else
			return false;
		
		if (feature instanceof EAttribute)
			element.eSet(feature, true);
		else {
			EObject child = EcoreUtil.create(concreteChildType);
			element.eSet(feature, child);
			
			ClassInstanceCreation argumentClassInstanceCreation = (ClassInstanceCreation) argument; 
			contextManager.associateContext(child, argumentClassInstanceCreation);
			
			if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
				return false;
		}
		Stats.INSTANCE.log(element.eClass(), feature, annotation);
		
		IType iTypeOfArgument = findITypeContainingASTNode(argument);
		if (iTypeOfArgument == null)
			iTypeOfArgument = (IType) contextManager.getContextIType(element, true);
		
		JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iTypeOfArgument);
		markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), argument);
		markerDescriptor.create(element);
		return true;	
	}*/
	/*
	public boolean doArgumentIsNew_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		String detailIndex = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
		int index = 0;
		if (detailIndex != null && !detailIndex.isEmpty()) {
			try {
				index = Integer.parseInt(detailIndex);
			}
			catch (NumberFormatException e) {
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, " of detail " + DETAIL_INDEX);
			}
		}
		String detailClass = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_CLASS, true);
		String detailClassSimple = Signature.getSimpleName(detailClass);
		String signature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, "()V");
		
		EObject contextMethodInvocationElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD_CALL);
		
		if (contextMethodInvocationElement == null)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, CONTEXT_METHOD_CALL);

		MethodInvocation contextMethodInvocation = contextManager.getContextMethodInvocation(contextMethodInvocationElement, true, progressMonitor);
		ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(contextMethodInvocationElement, true, progressMonitor);
		
		// construct the new instance creation statement
		IType instanceType = project.findType(detailClass);
		
		String newExpression = "new " + detailClassSimple + CodeTransforms.constructDefaultCallParameters(signature);
		
		if (instanceType.isInterface() || (instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()))) {
			// create annonymous subclass for interfaces and abstract classes
			newExpression += " {\n\t  }";
		}
		
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			if (contextMethodInvocation != null) {
				Expression expression = CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, newExpression, progressMonitor);
				if (expression != null) {
					CodeTransforms.organizeImports(contextMethodInvocation, detailClass);
					return true;
				}
			}	
			if (classInstanceCreation != null) {
				Expression expression =  CodeTransforms.replaceMethodCallArgument(null, classInstanceCreation, index, newExpression, progressMonitor);
				if (expression != null) {
					CodeTransforms.organizeImports(classInstanceCreation, detailClass);
					return true;
				}
			}
		case CODE_REMOVE:
			if (contextMethodInvocation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
			if (classInstanceCreation != null)
				return CodeTransforms.replaceMethodCallArgument(null, classInstanceCreation, index, "null", progressMonitor) != null;
		}
		return false;
	}*/
	/*
	public boolean doArgumentIsVariable_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		EObject methodCallFeature = FSMLEcoreUtil.retrieveContextElement(element, CONTEXT_METHOD_CALL);
		if (methodCallFeature != null) {
			// could be a method invocation or class instance creation
			MethodInvocation methodInvocation = contextManager.getContextMethodInvocation(methodCallFeature, true, progressMonitor);
			ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(methodCallFeature, true, progressMonitor);
			
			// exactly one of them must be non-null
			assert(!(methodInvocation == null && classInstanceCreation == null) &&
				   !(methodInvocation != null && classInstanceCreation != null));
			
			String indexString = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
			int index = Integer.valueOf(indexString) - 1;
			
			ASTNode argument = null;
			if (methodInvocation != null)
				argument = (ASTNode) methodInvocation.arguments().get(index);
			if (classInstanceCreation != null)
				argument = (ASTNode) classInstanceCreation.arguments().get(index);
			
			if (argument instanceof SimpleName) {
				SimpleName simpleName = (SimpleName) argument;
				IBinding binding = simpleName.resolveBinding();
				if (binding.getKind() == IBinding.VARIABLE) {
					IVariableBinding variableBinding = (IVariableBinding) binding;
					if (!variableBinding.isField()) {
						Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentIsVariable> argument is a variable");
						
						if (feature instanceof EAttribute)
							element.eSet(feature, simpleName.getIdentifier());
						else {
							EObject child = EcoreUtil.create(concreteChildType);
							element.eSet(feature, child);
							
							if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
								return false;
						}
						Stats.INSTANCE.log(element.eClass(), feature, annotation);
						
						IType iTypeOfArgument = findITypeContainingASTNode(argument);
						if (iTypeOfArgument == null)
							iTypeOfArgument = (IType) contextManager.getContextIType(methodCallFeature, true);
						
						JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iTypeOfArgument);
						markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), argument);
						markerDescriptor.create(element);
						return true;
					}
				}
			}
		}
		else
			Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentIsNew> No context method call");
		return false;	
	}*/
	/*public boolean doArgumentIsVariable_forward(SyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (syncItem instanceof ClassSyncItem)
			throw new FSMLMappingException(Cause.MAPPING_REQUIRES_ATTRIBUTE, syncItem.getModel().eContainingFeature());
		
		StructuralFeatureSyncItem featureSyncItem = (StructuralFeatureSyncItem) syncItem;
		EAttribute variableNameFeature = (EAttribute) featureSyncItem.getStructuralFeature();
		
		String detailIndex = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
		int index = 0;
		if (detailIndex != null && !detailIndex.isEmpty()) {
			try {
				index = Integer.parseInt(detailIndex);
			}
			catch (NumberFormatException e) {
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, " of detail " + DETAIL_INDEX);
			}
		}
		String detailType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_CLASS, true);
		IType instanceType = project.findType(detailType);
		boolean annonymousSubclass = instanceType.isInterface() || (instanceType.isClass() && Flags.isAbstract(instanceType.getFlags()));
		String detailSignature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, JavaMappingInterpreter.DETAIL_SIGNATURE, "()V");
		
		EObject element = syncItem.getModel();
		
		MethodInvocation contextMethodInvocation = contextManager.getContextMethodInvocation(element, true, progressMonitor);
		ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(element, true, progressMonitor);

		
		String variableName = (String) element.eGet(variableNameFeature);
		
		
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD:
			if (contextMethodInvocation != null) {
				Expression expression = CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, variableName, progressMonitor);
				CodeTransforms.declareVariable(null, contextMethodInvocation, variableName, detailType, detailSignature, annonymousSubclass, progressMonitor);
				return expression != null;
			}	
			if (classInstanceCreation != null) {
				Expression expression =  CodeTransforms.replaceMethodCallArgument(null, classInstanceCreation, index, variableName, progressMonitor);
				CodeTransforms.declareVariable(null, classInstanceCreation, variableName, detailType, detailSignature, annonymousSubclass, progressMonitor);
				return expression != null;
			}
			break;
		case CODE_REMOVE:
			if (contextMethodInvocation != null)
				return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
			if (classInstanceCreation != null)
				return CodeTransforms.replaceMethodCallArgument(null, classInstanceCreation, index, "null", progressMonitor) != null;
			break;
		}
		return false;
	}*/
	/*
	public boolean doArgumentValue_reverse(EObject element, EAttribute feature, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		EObject methodCallFeature = FSMLEcoreUtil.retrieveContextElement(element, CONTEXT_METHOD_CALL);
		if (methodCallFeature != null) {
			// could be a method invocation or class instance creation
			MethodInvocation methodInvocation = contextManager.getContextMethodInvocation(methodCallFeature, true, progressMonitor);
			ClassInstanceCreation classInstanceCreation = contextManager.getContextClassInstanceCreation(methodCallFeature, true, progressMonitor);
			
			// exactly one of them must be non-null
			assert(!(methodInvocation == null && classInstanceCreation == null) &&
				   !(methodInvocation != null && classInstanceCreation != null));
			
			String indexString = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
			int index = Integer.valueOf(indexString) - 1;
			if (feature.getEAttributeType().getName().equals("EString")) {
				ASTNode argument = null;
				if (methodInvocation != null)
					argument = (ASTNode) methodInvocation.arguments().get(index);
				if (classInstanceCreation != null)
					argument = (ASTNode) classInstanceCreation.arguments().get(index);
				
				String value = null;
				if (argument instanceof StringLiteral) {
					value = ((StringLiteral) argument).getLiteralValue();
					Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>", "StringLiteral retrieved");
				}
				else if (argument instanceof TypeLiteral) {
					TypeLiteral typeLiteral = (TypeLiteral) argument;
					ITypeBinding binding = typeLiteral.getType().resolveBinding(); 
					if (binding != null) {
						value = binding.getQualifiedName();
						Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","TypeLiteral retrieved (binding)");
					}
					else {
						if (typeLiteral.getType().isQualifiedType()) {
							QualifiedType qualifiedType = (QualifiedType) typeLiteral.getType();
							value = qualifiedType.getQualifier() + "." + qualifiedType.getName();
							Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","TypeLiteral retrieved (QualifiedType)");
						}
						else if (typeLiteral.getType().isSimpleType()) {
							SimpleType simpleType = (SimpleType) typeLiteral.getType();
							String simpleTypeName = simpleType.getName().getFullyQualifiedName();
							
							// navigate to import declarations
							ASTNode rootNode = argument.getRoot();
							
							if (rootNode instanceof CompilationUnit) {
								CompilationUnit cu = (CompilationUnit) rootNode;
								for (Object aux : cu.imports()) {
									ImportDeclaration id = (ImportDeclaration) aux;
									QualifiedName importQualifiedName = (QualifiedName) id.getName();
									SimpleName importLastName = importQualifiedName.getName();
									if (importLastName.getIdentifier().equals(simpleTypeName)) {
										value = importQualifiedName.getFullyQualifiedName();
										Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","TypeLiteral retrieved. (ImportDeclaration)");
									}
								}
								if (value == null) {
									Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","TypeLiteral not retrieved. No binding. No QualifiedName. No ImportDeclaration.");
									return false;
								}
							}
						}		
					}
					if (value != null)
						Stats.INSTANCE.log("typedLiteral retrieved:" + value);
				}
				// handle both simple and qualified names
				else if (argument instanceof Name) {
					Object resolvedBinding = ((Name) argument).resolveBinding();
					if (resolvedBinding instanceof IVariableBinding) {
						IVariableBinding vb = (IVariableBinding) resolvedBinding;
						Object auxValue = vb.getConstantValue();
						if (auxValue instanceof String) {
							value = (String) auxValue;
							Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","Constant String retrieved");
						}
						else if (value == null) {
							auxValue = vb.getVariableDeclaration().getConstantValue();
							if (auxValue instanceof String) {
								value = (String) auxValue;
								Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","Constant String retrieved from VariableDeclaration");
							}
						}
					}
				}
				else 
					Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","Argument not name nor literal");

				if (value != null) {
					// check equalTo constraint
					EAnnotation equalToAnnotation = feature.getEAnnotation("valueEqualsTo"); 
					if (equalToAnnotation != null) {
						String featurePath = (String) FSMLEcoreUtil.retrieveParameterValue(equalToAnnotation, QUERY_ATTRIBUTE, true);
						assert (featurePath != null);
						
						// navigate to the String feature that holds the value this feature is expected to be equal to
						FSMLEcoreUtil.NavigationResult target = FSMLEcoreUtil.navigateToEObject(element, featurePath);
						
						// TODO: 'valueEqualsTo' constraint: handle all types
						String targetValue = (String) target.eObject.eGet(target.eAttribute);
						
						if (!value.equals(targetValue))
							return false;
					}
					
					element.eSet(feature, value);
					Stats.INSTANCE.log(element.eClass(), feature, annotation);
					
					EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(methodCallFeature, CONTEXT_CLASS);
					
					IType iTypeOfArgument = findITypeContainingASTNode(argument);
					if (iTypeOfArgument == null) {
						TypeDeclaration typeDeclaration = contextManager.getContextTypeDeclaration(contextClassElement, true, progressMonitor);
						iTypeOfArgument = (IType) typeDeclaration.resolveBinding().getJavaElement();
					}
					
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iTypeOfArgument);
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), argument);
					markerDescriptor.create(element);
					
					return true;
				}
				else
					Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","Unable to retrieve value");
			}
		}
		else
			Stats.INSTANCE.log(element.eClass().getName() + "::" + feature.getName() + " <argumentValue>","No context method call");
		return false;
	}
	public boolean doArgumentValue_forward(StructuralFeatureSyncItem syncItem, EAnnotation annotation, IProgressMonitor progressMonitor) throws FSMLMappingException {
		String detailIndex = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_INDEX, true);
		int index = 0;
		if (detailIndex != null && !detailIndex.isEmpty()) {
			try {
				index = Integer.parseInt(detailIndex);
			}
			catch (NumberFormatException e) {
				throw new FSMLMappingException(Cause.INCORRECT_VALUE, " of detail " + DETAIL_INDEX);
			}
		}
		EObject contextMethodInvocationElement = FSMLEcoreUtil.retrieveContextElement(syncItem, CONTEXT_METHOD_CALL);
		
		if (contextMethodInvocationElement == null)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, CONTEXT_METHOD_CALL);

		MethodInvocation contextMethodInvocation = contextManager.getContextMethodInvocation(contextMethodInvocationElement, true, progressMonitor);
		
		switch (syncItem.getReconciliationAction()) {
		case CODE_ADD: 
			EAttribute attribute = (EAttribute) syncItem.getStructuralFeature();
			EObject element = syncItem.getModel();
			
			// TODO: handle types other than String
			String value = '"' + (String) element.eGet(attribute) + '"';
			return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, value, progressMonitor) != null;
		case CODE_REMOVE:
			return CodeTransforms.replaceMethodCallArgument(null, contextMethodInvocation, index, "null", progressMonitor) != null;
		}
		return false;
	}
	 */
	/*
	public boolean doMethodName_reverse(EObject element, EAttribute feature, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		MethodDeclaration methodDeclaration = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
			
		IJavaElement method = methodDeclaration.resolveBinding().getJavaElement();
		element.eSet(feature, method.getElementName());
		
		Stats.INSTANCE.log(element.eClass(), feature, annotation);
		
		JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(method);
		//markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), method);
		markerDescriptor.create(element);
		
		return true;
	}
	 */
	/*
	public boolean doTypesOfReturnedObjects_reverse(EObject element, EAttribute feature, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		MethodDeclaration contextMethod = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
	
		if (feature.getEAttributeType().getName().equals("EString")) {
			// make sure feature is not there in case the default is true
			element.eUnset(feature);
			boolean returnNonTypesReturns = true;
			ReturnStatement[] returnStatements = typesOfReturnedObjects(contextMethod, progressMonitor,returnNonTypesReturns);
			ArrayList<MarkerDescriptor> markerDescriptors = new ArrayList<MarkerDescriptor>();
			
			for (ReturnStatement statement : returnStatements) {
				if (statement == null)
					continue;	
				Expression expression = statement.getExpression();
				if (expression == null)
					continue;
				if (returnNonTypesReturns) {
					if (expression instanceof SuperMethodInvocation) {
						Stats.INSTANCE.log(element.eClass(), feature, annotation,"super");
						continue;
					} else if (expression instanceof NullLiteral) {
						Stats.INSTANCE.log(element.eClass(), feature, annotation,"null");
						continue;
					} else if (((IType)(expression.resolveTypeBinding().getJavaElement())).getFullyQualifiedName().equals("java.lang.Object")) {
						continue;
					}
				}
					
				ITypeBinding typeBinding = expression.resolveTypeBinding();
				if (typeBinding == null)
					continue;
				IType iType = (IType) typeBinding.getJavaElement();
				if (iType == null || !iType.exists())
					continue;
				String name = iType.getFullyQualifiedName();
				
				if (feature.isMany()) {
					((EList)element.eGet(feature)).add(name);
					
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(contextMethod.resolveBinding().getJavaElement());
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName() + "(" + name + ")", statement);
					markerDescriptor.setElementAndValue(element, name);
					markerDescriptors.add(markerDescriptor);
				}
				else {
					element.eSet(feature, name);
					
					JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(contextMethod.resolveBinding().getJavaElement());
					markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), statement);
					markerDescriptor.setElement(element);
					markerDescriptors.add(markerDescriptor);
					// ignore the rest of results!
					break;
				}
				Stats.INSTANCE.log(element.eClass(), feature, annotation);
				
				if (analyzeImplVariants) {
					//analyze implementation variants
					
					Expression stmtExpression = statement.getExpression();
					while (stmtExpression instanceof ParenthesizedExpression) {
						stmtExpression = ((ParenthesizedExpression)stmtExpression).getExpression();
					}
					if (stmtExpression instanceof ConditionalExpression) {
						Expression elseExpression =((ConditionalExpression)stmtExpression).getElseExpression();
						Expression thenExpression =((ConditionalExpression)stmtExpression).getThenExpression();
						if (!(elseExpression instanceof InfixExpression) && !(elseExpression instanceof NullLiteral)) {
							stmtExpression=((ConditionalExpression)stmtExpression).getElseExpression();
						} else if(!(thenExpression instanceof InfixExpression) && !(thenExpression instanceof NullLiteral)) {
							stmtExpression = ((ConditionalExpression)stmtExpression).getThenExpression(); 
						} else {
							Stats.INSTANCE.log(element.eClass(), feature, annotation,"failed to analyze ParenthesizedExpression or ConditionalExpression");
							continue;
						}
					}
					
					if (stmtExpression instanceof MethodInvocation) {
						Stats.INSTANCE.log(element.eClass(), feature, annotation,"method of return type "+((MethodInvocation)stmtExpression).resolveMethodBinding().getReturnType().getName());
					} else if (stmtExpression instanceof ThisExpression) {
						Stats.INSTANCE.log(element.eClass(), feature, annotation,"this");
					} else if (stmtExpression instanceof SimpleName) {
						Stats.INSTANCE.log(element.eClass(),feature,annotation,"variable");
					} else if (stmtExpression instanceof ClassInstanceCreation) {
						if (((ClassInstanceCreation)stmtExpression).getAnonymousClassDeclaration()!=null) {
							Stats.INSTANCE.log(element.eClass(),feature,annotation, "anon");
						} else {
							Stats.INSTANCE.log(element.eClass(),feature,annotation,"new");
						}
					} else {
						Stats.INSTANCE.log(element.eClass(), feature, annotation,stmtExpression.getClass().getSimpleName());
					}
				}
			}
			for (MarkerDescriptor descriptor : markerDescriptors)
				descriptor.create();
			return returnStatements.length > 0;
		}
		return false;
	}
	 */
	/*
		public boolean doTypedWith_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		if (feature instanceof EReference && concreteChildType == null)
			throw new FSMLMappingException(Cause.MISSING_CONCRETE_CHILD_TYPE, feature);
		
		VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor);
		if (variableDeclarationFragment != null) {
			String desiredType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_NAME, true);
			FieldDeclaration fieldDeclaration = (FieldDeclaration) variableDeclarationFragment.getParent();
			
			String currentType = fieldDeclaration.getType().resolveBinding().getQualifiedName();
			
			boolean typesEqual = desiredType.equals(currentType);
			
			if (typesEqual) {
				if (feature instanceof EAttribute)
					element.eSet(feature, true);
				else {
					EObject child = EcoreUtil.create(concreteChildType);
					element.eSet(feature, child);
					if (!reverseFeatureRepresentedAsClass(child, progressMonitor))
						return false;
				}
				Stats.INSTANCE.log(element.eClass(), feature, annotation);
				
				IType iType = findITypeContainingASTNode(variableDeclarationFragment);
				JavaMarkerDescriptor descriptor = JavaMarkers.createMarkerDescriptor(iType);
				
				descriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), fieldDeclaration.getType());
				descriptor.create(element);
				return true;
			}
		}
		return false;
	}
	 */
	/*
	 * 	public boolean doAnnotatedWith_reverse(EObject element, EAttribute feature, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		String fullAnnotationType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_FULLY_QUALIFIED_TYPE, true);
		String simpleAnnotationType = Signature.getSimpleName(fullAnnotationType); 
		BodyDeclaration bodyDeclaration = null; 
		if (FSMLEcoreUtil.getEAnnotation(element.eClass(),CONTEXT_CLASS) != null)
			//we have a class
			bodyDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
		else if (FSMLEcoreUtil.getEAnnotation(element.eClass(),CONTEXT_METHOD) != null)
			//we have a method
			bodyDeclaration = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
		else if (FSMLEcoreUtil.getEAnnotation(element.eClass(),CONTEXT_FIELD) != null)
			bodyDeclaration = (BodyDeclaration) contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor).getParent(); 
		else
			return false; 
		
		boolean foundDesiredAnnotation = false; 
		for (Object modifier : bodyDeclaration.modifiers()) {
			if (modifier instanceof Annotation){
				String modifierType = ((Annotation)modifier).getTypeName().getFullyQualifiedName(); 
				if (fullAnnotationType.equalsIgnoreCase(modifierType)
						|| simpleAnnotationType.equalsIgnoreCase(modifierType)){
					element.eSet(feature, new Boolean(true));
					foundDesiredAnnotation = true; 
					break; 
				}
			}
		}
		if (!foundDesiredAnnotation){
			return false; 
		}
		Stats.INSTANCE.log(element.eClass(), feature, annotation);
		
		IJavaElement iJavaElement = findITypeContainingASTNode(bodyDeclaration);
		JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iJavaElement);
		markerDescriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), bodyDeclaration);
		markerDescriptor.create(element);
		return true;
		
		/*
		if (annotationFeature != null) {
			String stringValue = null;
			Annotation javaAnnotation = feature2Annotation.get(annotationFeature);
			if (javaAnnotation.getNodeType() == ASTNode.NORMAL_ANNOTATION){
				NormalAnnotation normalJavaAnnotation = (NormalAnnotation) javaAnnotation;
				for (Object valueObject : normalJavaAnnotation.values()) {
					MemberValuePair mvp = (MemberValuePair) valueObject;
					if (mvp.getName().getFullyQualifiedName().equalsIgnoreCase(attributeName)){
						//the name of the attribute is the desired one.
						expressionValue = mvp.getValue();
						Object objectValue = expressionValue.resolveConstantExpressionValue();
						stringValue = objectValue.toString();
						
						break;
					}
				}
			}		
		
	}

	 */
	/*
	 * 	public boolean doAnnotatedWithReference_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		String fullAnnotationType = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_FULLY_QUALIFIED_TYPE, true);
		String simpleAnnotationType = Signature.getSimpleName(fullAnnotationType); 
		BodyDeclaration bodyDeclaration = null; 
		if (FSMLEcoreUtil.getEAnnotation(element.eClass(),CONTEXT_CLASS) != null){
			//we have a class
			bodyDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
		}
		else if (FSMLEcoreUtil.getEAnnotation(element.eClass(),CONTEXT_METHOD) != null){
			//we have a method
			bodyDeclaration = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
		}
		else if (FSMLEcoreUtil.getEAnnotation(element.eClass(),CONTEXT_FIELD) != null){
			VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor);
			bodyDeclaration = (BodyDeclaration) variableDeclarationFragment.getParent();
		}
		else
			return false; 
		
		boolean foundDesiredAnnotation = false; 
		EObject child = null;
		Annotation foundAnnotation = null;
		for (Object modifier : bodyDeclaration.modifiers()) {
			if (modifier instanceof Annotation){
				String modifierType = ((Annotation)modifier).getTypeName().getFullyQualifiedName(); 
				if (fullAnnotationType.equalsIgnoreCase(modifierType)
						|| simpleAnnotationType.equalsIgnoreCase(modifierType)){
					//we've found the annotation
					
					if (feature instanceof EAttribute)
						element.eSet(feature, true);
					else {
						child = EcoreUtil.create(concreteChildType);
						element.eSet(feature, child);
						contextManager.associateContext(child, modifier);
						if (!reverseFeatureRepresentedAsClass(child, progressMonitor)){
							return false;
						}						
					}
					Stats.INSTANCE.log(element.eClass(), feature, annotation);
					foundDesiredAnnotation = true;
					foundAnnotation = (Annotation) modifier;
					break; 
				}
			}
		}
		if (!foundDesiredAnnotation){
			return false; 
		}
		Stats.INSTANCE.log(element.eClass(), feature, annotation);
		if (child != null){
			TypeDeclaration typeDeclaration = (TypeDeclaration) ((CompilationUnit) bodyDeclaration.getRoot()).types().get(0);
			IType iTypeForBodyDeclaration =  (IType) typeDeclaration.resolveBinding().getJavaElement();
			JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iTypeForBodyDeclaration);
			markerDescriptor.setAttributes(null, child.eClass().getName(),foundAnnotation);
			markerDescriptor.create(child);
			return true;
		}
		else{
			TypeDeclaration typeDeclaration = (TypeDeclaration) ((CompilationUnit) bodyDeclaration.getRoot()).types().get(0);
			IType iTypeForBodyDeclaration =  (IType) typeDeclaration.resolveBinding().getJavaElement();
			JavaMarkerDescriptor markerDescriptor = JavaMarkers.createMarkerDescriptor(iTypeForBodyDeclaration);
			markerDescriptor.setAttributes(feature, element.eClass().getName(),foundAnnotation);
			markerDescriptor.create(element);
			return true;
		}	
	}
*/
	/*
	 * 	public boolean doAttributeRepresentedAsAttribute_reverse(EObject element, EAttribute feature, EAnnotation annotation, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		String attributeName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_ATTRIBUTE_NAME, true);
		Annotation currentAnnotation = contextManager.getContextAnnotation(element, true, progressMonitor);
		Expression expressionValue = null;
		String stringValue = null;
		if (currentAnnotation.getNodeType() == ASTNode.NORMAL_ANNOTATION){
			NormalAnnotation normalJavaAnnotation = (NormalAnnotation) currentAnnotation;
			for (Object valueObject : normalJavaAnnotation.values()) {
				MemberValuePair mvp = (MemberValuePair) valueObject;
				if (mvp.getName().getFullyQualifiedName().equalsIgnoreCase(attributeName)){
					//the name of the attribute is the desired one.
					expressionValue = mvp.getValue();
				}
			}
		}
		else if (currentAnnotation.getNodeType() == ASTNode.SINGLE_MEMBER_ANNOTATION){
			SingleMemberAnnotation singleJavaAnnotation = (SingleMemberAnnotation) currentAnnotation;
			expressionValue = singleJavaAnnotation.getValue();
			if (expressionValue instanceof ArrayInitializer){
				ArrayInitializer ai = (ArrayInitializer) expressionValue;
				for (Object obj : ai.expressions()) {
					Expression exp = (Expression) obj;
				}
			}
		}
		if (expressionValue != null){
			if (expressionValue instanceof TypeLiteral){
				TypeLiteral tl = (TypeLiteral) expressionValue;
				String fullyQualifiedName = tl.resolveTypeBinding().getQualifiedName();
				fullyQualifiedName = fullyQualifiedName.substring(fullyQualifiedName.indexOf('<')+1, fullyQualifiedName.indexOf('>'));
				element.eSet(feature,fullyQualifiedName);
				return true;
			}
			Object objectValue = expressionValue.resolveConstantExpressionValue();
			if (objectValue != null){
				stringValue = objectValue.toString();
			}
			if (stringValue != null){
				element.eSet(feature,stringValue);
				return true;
			}
		}
		return false;		
	}
	 */
	/*
	 * 	public boolean doAttributeRepresentedAsReference_reverse(EObject element, EStructuralFeature feature, EAnnotation annotation, EClass concreteChildType, IProgressMonitor progressMonitor) throws JavaModelException, FSMLMappingException {
		String attributeName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_ATTRIBUTE_NAME, true);
		Annotation currentAnnotation = contextManager.getContextAnnotation(element, true, progressMonitor);
		Expression expressionValue = null;
		String stringValue = null;
		IType itype = null;
		if (currentAnnotation.getNodeType() == ASTNode.NORMAL_ANNOTATION){
			NormalAnnotation normalJavaAnnotation = (NormalAnnotation) currentAnnotation;
			for (Object valueObject : normalJavaAnnotation.values()) {
				MemberValuePair mvp = (MemberValuePair) valueObject;
				if (mvp.getName().getFullyQualifiedName().equalsIgnoreCase(attributeName)){
					//the name of the attribute is the desired one.
					expressionValue = mvp.getValue();
					if (expressionValue instanceof TypeLiteral){
						TypeLiteral tl = (TypeLiteral) expressionValue;
						String fullyQualifiedName = tl.resolveTypeBinding().getQualifiedName();
						fullyQualifiedName = fullyQualifiedName.substring(fullyQualifiedName.indexOf('<')+1, fullyQualifiedName.indexOf('>'));
						itype= project.findType(fullyQualifiedName);
						EObject child = EcoreUtil.create(concreteChildType);
						if (!feature.isMany()){
							element.eSet(feature, child);
						}
						else {
							EList list = (EList) element.eGet(feature);
							list.add(child);
						}
						CompilationUnit cu =contextManager.getCUforIJavaElement(itype, false, progressMonitor);
						TypeDeclaration typeDeclaration = ASTNodeSearchUtil.getTypeDeclarationNode(itype, cu);
						contextManager.associateContext(child, typeDeclaration);
					}
					//TODO do for arrays and single markers. 
				}
			}
		}
		Stats.INSTANCE.log(element.eClass(), feature, annotation);
		
		//JavaMarkerDescriptor descriptor = JavaMarkers.createMarkerDescriptor(itype);
		//descriptor.setAttributes(feature, element.eClass().getName() + "::" + feature.getName(), itype);
		//descriptor.create(element);
		return true;
	}
	 */
	/*public boolean canCreateChildrenForDefaultQuery(EClass eClass) {
	return FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_METHOD) != null ||
		   FSMLEcoreUtil.getEAnnotation(eClass, CONTEXT_ANNOTATION) != null;
	}*/
	/*public boolean createChildrenForDefaultQuery(EObject element, EReference feature, EClass concreteChildType, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EAnnotation annotation = FSMLEcoreUtil.getEAnnotation(concreteChildType, CONTEXT_METHOD);
		if (annotation != null) {
			// case 1: the method is statically specified
			String methodName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, QUERY_METHOD_NAME, false);
			String methodSignature = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_SIGNATURE, false);
			if (methodName != null && methodSignature != null) {
				TypeDeclaration contextTypeDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
				
				MethodDeclaration methodDeclaration = ASTUtils.findMethod(javaAstManager, methodName, methodSignature, contextTypeDeclaration, true,true, progressMonitor);
				
				if (methodDeclaration != null) {
					EObject child = EcoreUtil.create(concreteChildType);
					if (feature.isMany())
						((EList)element.eGet(feature)).add(child);
					else
						element.eSet(feature, child);
	
					contextManager.associateContext(child, methodDeclaration);
					if (reverseFeatureRepresentedAsClass(child, progressMonitor))
						Stats.INSTANCE.log(element.eClass(), feature, annotation);
				}
				return true;
			}
		}
		annotation = FSMLEcoreUtil.getEAnnotation(concreteChildType, JavaMappingInterpreter.CONTEXT_ANNOTATION);
		if (annotation != null) {
			String fullyQualifiedName = (String) FSMLEcoreUtil.retrieveParameterValue(annotation, DETAIL_FULLY_QUALIFIED_TYPE, true);
			String simpleAnnotationType = fullyQualifiedName.indexOf('.') != -1 ? fullyQualifiedName.substring(fullyQualifiedName.lastIndexOf('.')+1,fullyQualifiedName.length()): fullyQualifiedName;
			
			VariableDeclarationFragment variableDeclarationFragment = contextManager.getContextVariableDeclarationFragment(element, true, progressMonitor);
			BodyDeclaration bodyDeclaration = null;  
			
			if (variableDeclarationFragment != null)
				bodyDeclaration = (BodyDeclaration) variableDeclarationFragment.getParent();
			else {
				bodyDeclaration = contextManager.getContextMethodDeclaration(element, true, progressMonitor);
				if (bodyDeclaration == null)
					bodyDeclaration = contextManager.getContextTypeDeclaration(element, true, progressMonitor);
			}
			if (bodyDeclaration == null)
				return false;
			
			Annotation foundAnnotation = null;
	
			for (Object objectModifier : bodyDeclaration.modifiers()) {
				IExtendedModifier modifier = (IExtendedModifier) objectModifier;
				if (modifier instanceof Annotation){
					Annotation currentAnnotation = (Annotation)modifier;
					Name annotationNameObject = currentAnnotation.getTypeName();
					if (annotationNameObject.isSimpleName()){
						if (annotationNameObject.getFullyQualifiedName().equalsIgnoreCase(simpleAnnotationType)){
							foundAnnotation = currentAnnotation;
							break;
						}
					}
					else {
						QualifiedName qualifiedAnnotationName = (QualifiedName) annotationNameObject;
						if (qualifiedAnnotationName.getName().getFullyQualifiedName().equalsIgnoreCase(fullyQualifiedName)){
							foundAnnotation = currentAnnotation;
							break;
						}
					}
				}
			}
			if (foundAnnotation != null) {
				EObject child = EcoreUtil.create(concreteChildType);
				if (feature.isMany()){
					((EList)element.eGet(feature)).add(child);
				}
				else{
					element.eSet(feature, child);
				}
				contextManager.associateContext(child,foundAnnotation);
				if (reverseFeatureRepresentedAsClass(child, progressMonitor))
					Stats.INSTANCE.log(element.eClass(), feature, annotation);
			}
				return true;
		}
		return false;
	}*/
}
