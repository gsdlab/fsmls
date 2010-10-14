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

import java.util.HashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.internal.corext.refactoring.structure.ASTNodeSearchUtil;

import ca.uwaterloo.gsd.fsml.core.Cause;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaASTManager;
import ca.uwaterloo.gsd.fsml.stats.Stats;

/**
 * Used for creating, maintaining, and querying context hashmaps. 
 * This class should only be used from JavaMappingInterpreter.
 * 
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class JavaContextManager implements IJavaContextManager {
	private IJavaProject project;
	// context elements:
	// iJavaProjects corresponding to model elements
	private HashMap<EObject, IJavaProject> feature2iJavaProject = new HashMap<EObject, IJavaProject>();
	
	// iTypes corresponding to model elements
	private HashMap<EObject, IType> feature2iType = new HashMap<EObject, IType>();
	// TypeDeclarations corresponding to model elements
	private HashMap<EObject, TypeDeclaration> feature2TypeDeclaration = new HashMap<EObject, TypeDeclaration>();
	
	// iMethods corresponding to model elements
	private HashMap<EObject, IMethod> feature2iMethod = new HashMap<EObject, IMethod>();
	// method declarations corresponding to model elements
	private HashMap<EObject, MethodDeclaration> feature2MethodDeclaration = new HashMap<EObject, MethodDeclaration>();
	
	// iFields corresponding to model elements
	private HashMap<EObject, IField> feature2iField = new HashMap<EObject, IField>();	
	// variable declaration fragments corresponding to model elements
	private HashMap<EObject, VariableDeclarationFragment> feature2VariableDeclarationFragment = new HashMap<EObject, VariableDeclarationFragment>();
	
	// MethodInvocations corresponding to model elements
	private HashMap<EObject, MethodInvocation> feature2MethodInvocation = new HashMap<EObject, MethodInvocation>();
	// ClassInstanceCreations corresponding to model elements
	private HashMap<EObject, ClassInstanceCreation> feature2ClassInstanceCreation = new HashMap<EObject, ClassInstanceCreation>();
	// Annotations corresponding to model elements
	private HashMap<EObject, Annotation> feature2Annotation = new HashMap<EObject, Annotation>();
	
	protected IJavaASTManager javaAstManager;
	
	@SuppressWarnings("unused")
	private JavaContextManager() {
	}
	public JavaContextManager(IJavaProject project, IJavaASTManager javaAstManager) {
		this.project = project;
		this.javaAstManager = javaAstManager;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextIJavaProject(org.eclipse.emf.ecore.EObject)
	 */
	public IJavaProject getContextIJavaProject(EObject element) {
		EObject contextProjectElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_PROJECT);
		IJavaProject result = feature2iJavaProject.get(contextProjectElement);
		if (result == null)
			// TODO: get rid of this hack!
			result = project;
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextIType(org.eclipse.emf.ecore.EObject, boolean)
	 */
	public IType getContextIType(EObject element, boolean required) throws FSMLMappingException {
		EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_CLASS);
		
		if (contextClassElement == null && required)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, element.eContainingFeature());
		
		// try the cache first
		IType result = feature2iType.get(contextClassElement);
		if (result != null)
			return result;
		
		// try the typed declarations cache
		TypeDeclaration typeDeclaration = feature2TypeDeclaration.get(contextClassElement);
		if (typeDeclaration != null) {
			String name = typeDeclaration.getName().getIdentifier();
			PackageDeclaration packageNode = ((CompilationUnit)typeDeclaration.getRoot()).getPackage();
			String qualifier  = null;
			if (packageNode != null)
				qualifier = packageNode.getName().getFullyQualifiedName();
			String fqName = qualifier == null || "".equals(qualifier) ? 
				name : 
					qualifier + "." + name;
			try {
				result = project.findType(fqName);
				if (result != null && result.exists()) {
					feature2iType.put(contextClassElement, result);
					return result;
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		
		// retrieve fully qualified name
		String fullyQualifiedName = null;
		
		EAttribute fullyQualifiedNameAttribute = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(contextClassElement.eClass(), new String[] { JavaMappingInterpreter.QUERY_FULLY_QUALIFIED_NAME });
		if (fullyQualifiedNameAttribute != null)
			fullyQualifiedName = (String) contextClassElement.eGet(fullyQualifiedNameAttribute);
		else {
			// try name and qualifier
			EAttribute nameAttribute = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(contextClassElement.eClass(), new String[] { JavaMappingInterpreter.QUERY_CLASS_NAME });
			EAttribute qualifierAttribute = (EAttribute) FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(contextClassElement.eClass(), new String[] { JavaMappingInterpreter.QUERY_QUALIFIER });
			if (nameAttribute != null && qualifierAttribute != null) {
				String name = (String) contextClassElement.eGet(nameAttribute);
				String qualifier = (String) contextClassElement.eGet(qualifierAttribute);
				if (qualifier == null || "".equals(qualifier)) 
					fullyQualifiedName = name;
				else 
					fullyQualifiedName = qualifier + "." + name;
			}
			else {
				// look for base concept reference
				EReference baseElementReference = FSMLEcoreUtil.findReferenceWithAnnotation(contextClassElement.eClass(), Queries.BASE_CONCEPT);
				if (baseElementReference != null) {
					EObject baseElement = (EObject) contextClassElement.eGet(baseElementReference);
					if (baseElement != null)
						return getContextIType(baseElement, required);
				}
			}
		}
		try {
			if (fullyQualifiedName != null) {
				result = project.findType(fullyQualifiedName);
				if (result != null && result.exists())
					feature2iType.put(contextClassElement, result);
				else 
					return null;
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextTypeDeclaration(org.eclipse.emf.ecore.EObject, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public TypeDeclaration getContextTypeDeclaration(EObject element, boolean required, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject contextClassElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_CLASS);
		
		if (contextClassElement == null && required)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, element.eContainingFeature());
		
		// try the cache first
		TypeDeclaration result = feature2TypeDeclaration.get(contextClassElement);
		if (result == null) {
			// cannot find in the cache retrieve from the IType
			IType resultIType = getContextIType(element, required);
			
			if (resultIType != null && resultIType.exists()) {
				CompilationUnit cu = javaAstManager.getCompilationUnit(resultIType);
				if (cu == null) {
					Stats.INSTANCE.logError("Unable to parse the type:" + resultIType.getFullyQualifiedName());
					return null;
				}
				try {
					result = ASTNodeSearchUtil.getTypeDeclarationNode(resultIType, cu);
				} catch (JavaModelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
				// store in the cache
				if (result != null)
					feature2TypeDeclaration.put(contextClassElement, result);
				else {
					Stats.INSTANCE.logError("Unable to locate typed declaration in cu:" + resultIType.getFullyQualifiedName());
					return null;
				}
			}
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextIMethod(org.eclipse.emf.ecore.EObject, boolean)
	 */
	public IMethod getContextIMethod(EObject element, boolean required) {
		IMethod result = feature2iMethod.get(element);
		if (result == null) {
			// retrieve the method by name from the context IType
			EObject contextMethodElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_METHOD);
			if (contextMethodElement != null) {
				EStructuralFeature nameFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(contextMethodElement.eClass(), new String[] {JavaMappingInterpreter.QUERY_METHOD_NAME});
				EStructuralFeature signatureFeature = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(contextMethodElement.eClass(), new String[] {JavaMappingInterpreter.QUERY_SIGNATURE});
				if (nameFeature != null && signatureFeature != null) {
					String methodName = (String) contextMethodElement.eGet(nameFeature);
					String methodSignature = (String) contextMethodElement.eGet(signatureFeature);
					try {
						IType contextIType = getContextIType(element, false);
						if (contextIType != null) {
							// TODO: need local and inherited?
						}
					} catch (FSMLMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextMethodDeclaration(org.eclipse.emf.ecore.EObject, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public MethodDeclaration getContextMethodDeclaration(EObject element, boolean required, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject contextMethodElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_METHOD);
		
		if (contextMethodElement == null && required)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, element.eContainingFeature());
		
		// try the cache first
		MethodDeclaration result = feature2MethodDeclaration.get(contextMethodElement);
		if (result == null) {
			// cannot find in the cache retrieve from the IType
			IMethod resultIMethod = getContextIMethod(element, required);
			
			if (resultIMethod != null && resultIMethod.exists()) {
				CompilationUnit cu = javaAstManager.getCompilationUnit(resultIMethod);
				if (cu == null) {
					Stats.INSTANCE.logError("JavaContextManager.getContextMethodDeclaration(): unable to obtain a compilation unit for " + resultIMethod.getKey());
					return null;
				}
				try {
					result = ASTNodeSearchUtil.getMethodDeclarationNode(resultIMethod, cu);
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
				// store in the cache
				if (result != null)
					feature2MethodDeclaration.put(contextMethodElement, result);
			}
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextIField(org.eclipse.emf.ecore.EObject, boolean)
	 */
	public IField getContextIField(EObject element, boolean required) throws FSMLMappingException {
		EObject contextFieldElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_FIELD);
		EStructuralFeature fieldNameAttribute = FSMLEcoreUtil.findEStructuralFeatureWithAnnotations(contextFieldElement.eClass(), new String[] {JavaMappingInterpreter.QUERY_FIELD_NAME} );
		String fieldName = (String) contextFieldElement.eGet(fieldNameAttribute);
		
		IField result = null;
		
		if (fieldName != null) {
			IType contextType = getContextIType(element, required);
			if (contextType == null)
				return null;
			
			result = contextType.getField(fieldName);
			if (!result.exists())
				return null;
		}
		
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextVariableDeclarationFragment(org.eclipse.emf.ecore.EObject, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public VariableDeclarationFragment getContextVariableDeclarationFragment(EObject element, boolean required, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject contextFieldElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_FIELD);
		EObject contextStatementElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_LOCAL_VARIABLE);
		if (contextFieldElement == null && contextStatementElement == null && required)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, element.eContainingFeature());
		
		// try the cache first
		VariableDeclarationFragment result = feature2VariableDeclarationFragment.get(contextFieldElement);
		if (result == null){
			result = feature2VariableDeclarationFragment.get(contextStatementElement);
		}
		if (result == null) {
			//TODO, do this for statements as well. 
			// cannot find in the cache retrieve from the IType
			IField resultIField = getContextIField(element, required);
			
			if (resultIField != null && resultIField.exists()) {
				CompilationUnit cu = javaAstManager.getCompilationUnit(resultIField);
				FieldDeclaration resultFieldDeclaration;
				try {
					resultFieldDeclaration = ASTNodeSearchUtil.getFieldDeclarationNode(resultIField, cu);
					result = (VariableDeclarationFragment) resultFieldDeclaration.fragments().get(0);
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
				// store in the cache
				if (result != null)
					feature2VariableDeclarationFragment.put(contextFieldElement, result);
			}
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextMethodInvocation(org.eclipse.emf.ecore.EObject, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public MethodInvocation getContextMethodInvocation(EObject element, boolean required, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject contextMethodInvocationElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_METHOD_CALL);
		
		if (contextMethodInvocationElement == null && required)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, element.eContainingFeature());
		
		// try the cache first
		MethodInvocation result = feature2MethodInvocation.get(contextMethodInvocationElement);
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextClassInstanceCreation(org.eclipse.emf.ecore.EObject, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public ClassInstanceCreation getContextClassInstanceCreation(EObject element, boolean required, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject contextClassInstanceCreationElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_METHOD_CALL);
		
		if (contextClassInstanceCreationElement == null && required)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, element.eContainingFeature());
		
		// try the cache first
		ClassInstanceCreation result = feature2ClassInstanceCreation.get(contextClassInstanceCreationElement);
		return result;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContextAnnotation(org.eclipse.emf.ecore.EObject, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public Annotation getContextAnnotation(EObject element, boolean required, IProgressMonitor progressMonitor) throws FSMLMappingException {
		EObject contextAnnotationElement = FSMLEcoreUtil.retrieveContextElement(element, JavaMappingInterpreter.CONTEXT_ANNOTATION);
		
		if (contextAnnotationElement == null && required)
			throw new FSMLMappingException(Cause.MISSING_CONTEXT, element.eContainingFeature());
		
		// try the cache first
		Annotation result = feature2Annotation.get(contextAnnotationElement);
		return result;
	}
	/**
	 * @param member
	 * @param progressMonitor
	 * @return a IClassFile for a binary member or a ICompilationUnit for source member 
	 */
	public static IJavaElement getIClassFileOrICompilationUnitForIMember(IMember member, IProgressMonitor progressMonitor) {
		try {
			if (!member.isStructureKnown()) {
				Stats.INSTANCE.logError("Structure is not known for member:" + member.getElementName());
				return null;
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		if (member.isBinary()) {
			IClassFile classFile = member.getClassFile();
			if (classFile == null || !classFile.exists())
				Stats.INSTANCE.logError("getIClassFileOrICompilationUnitForIMember(): IClassFile does not exist for member:" + member.getElementName());
			return classFile; 
		}
		ICompilationUnit iCompilationUnit = member.getCompilationUnit();
		if (iCompilationUnit == null || !iCompilationUnit.exists())
			Stats.INSTANCE.logError("getIClassFileOrICompilationUnitForIMember(): ICompilationUnit does not exist for member:" + member.getElementName());
		return iCompilationUnit;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#associateContext(org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	public void associateContext(EObject object, Object context) {
		if (context instanceof TypeDeclaration)
			feature2TypeDeclaration.put(object, (TypeDeclaration) context);
		else if (context instanceof IType)
			feature2iType.put(object, (IType) context);
		else if (context instanceof MethodDeclaration)
			feature2MethodDeclaration.put(object, (MethodDeclaration) context);
		else if (context instanceof IMethod)
			feature2iMethod.put(object, (IMethod) context);
		else if (context instanceof VariableDeclarationFragment)
			feature2VariableDeclarationFragment.put(object, (VariableDeclarationFragment) context);
		else if (context instanceof IField)
			feature2iField.put(object, (IField) context);
		else if (context instanceof Annotation)
			feature2Annotation.put(object,(Annotation)context);
		else if (context instanceof MethodInvocation)
			feature2MethodInvocation.put(object, (MethodInvocation) context);
		else if (context instanceof ClassInstanceCreation)
			feature2ClassInstanceCreation.put(object, (ClassInstanceCreation) context);
		else if (context instanceof IJavaProject)
			feature2iJavaProject.put(object, (IJavaProject) context);
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContext(org.eclipse.emf.ecore.EObject, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public Object getContext(EObject element, IProgressMonitor progressMonitor) {
		try {
			Object context = getContextIType(element, true);
			if (context == null)
				context = getContextTypeDeclaration(element, true, progressMonitor);
			else if (context == null)
				context = getContextIMethod(element, true);
			else if (context == null)
				context = getContextMethodDeclaration(element, true, progressMonitor);
			else if (context == null)
				context = getContextIField(element, true);
			else if (context == null)
				context = getContextVariableDeclarationFragment(element, true, progressMonitor);
			else if (context == null)
				context = getContextAnnotation(element, true, progressMonitor);
			else if (context == null)
				context = getContextMethodInvocation(element, true, progressMonitor);
			else if (context == null)
				context = getContextClassInstanceCreation(element, true, progressMonitor);
			else if (context == null)
				context = getContextIJavaProject(element);
			return context;
		} catch (FSMLMappingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#getContext(org.eclipse.emf.ecore.EObject, java.lang.Class, boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public Object getContext(EObject element, Class contextClass, boolean required, IProgressMonitor progressMonitor) {
		try {
			if (TypeDeclaration.class.equals(contextClass))
				return getContextTypeDeclaration(element, required, progressMonitor);
			if (MethodDeclaration.class.equals(contextClass))
				return getContextMethodDeclaration(element, required, progressMonitor);
			if (VariableDeclarationFragment.class.equals(contextClass))
				return getContextVariableDeclarationFragment(element, required, progressMonitor);
			if (MethodInvocation.class.equals(contextClass))
				return getContextMethodInvocation(element, required, progressMonitor);
			if (ClassInstanceCreation.class.equals(contextClass))
				return getContextClassInstanceCreation(element, required, progressMonitor);
			if (Annotation.class.equals(contextClass))
				return getContextAnnotation(element, required, progressMonitor);
			if (IJavaProject.class.equals(contextClass))
				return getContextIJavaProject(element);
			if (IType.class.equals(contextClass))
				return getContextIType(element, required);
			if (IMethod.class.equals(contextClass))
				return getContextIMethod(element, required);
			if (IField.class.equals(contextClass))
				return getContextIField(element, required);
		}
		catch (FSMLMappingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager#removeContext(org.eclipse.emf.ecore.EObject)
	 */
	public void removeContext(EObject element) {
		feature2iJavaProject.remove(element);
		feature2iType.remove(element);
		feature2TypeDeclaration.remove(element);
		feature2iMethod.remove(element);
		feature2MethodDeclaration.remove(element);
		feature2iField.remove(element);
		feature2VariableDeclarationFragment.remove(element);
		feature2MethodInvocation.remove(element);
		feature2ClassInstanceCreation.remove(element);
		feature2Annotation.remove(element);
	}
	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init() {	
	}
	
	@Override
	public void finish() {
		// should not clear cache, because it is needed for forward eng (ModelCodeReconcileAction).
		/*feature2iJavaProject.clear();
		feature2iType.clear();
		feature2TypeDeclaration.clear();
		feature2iMethod.clear();
		feature2MethodDeclaration.clear();
		feature2iField.clear();
		feature2VariableDeclarationFragment.clear();
		feature2MethodInvocation.clear();
		feature2ClassInstanceCreation.clear();
		feature2Annotation.clear();*/
	}
}
