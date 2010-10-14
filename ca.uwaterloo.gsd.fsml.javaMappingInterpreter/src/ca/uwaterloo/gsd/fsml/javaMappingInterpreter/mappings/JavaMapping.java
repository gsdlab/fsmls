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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.search.SearchMatch;

import ca.uwaterloo.gsd.fsml.core.Context;
import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;
import ca.uwaterloo.gsd.fsml.core.Mapping;
import ca.uwaterloo.gsd.fsml.core.Mode;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMarkerDescriptor;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IAnalysisManagers;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IHierarchicalCallGraphManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IIncrementalTypeHierarchy;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaASTManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaImplVariantManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.stats.Stats;
import ca.uwaterloo.gsd.fsml.sync.SyncItem;

public abstract class JavaMapping extends Mapping {

	protected IAnalysisManagers analysisManagers;
	
	protected JavaMappingInterpreter javaInterpreter;
	protected IJavaContextManager contextManager;
	protected IJavaASTManager javaAstManager;
	protected IHierarchicalCallGraphManager callGraphManager;
	protected IJavaImplVariantManager javaImplVariantManager;
	protected IIncrementalTypeHierarchy typeHierarchy;
	
	/**
	 * Reverse
	 */
	public JavaMapping(
			EObject element, 
			EStructuralFeature feature, 
			EAnnotation annotation, 
			EClass concreteChildType, 
			JavaMappingInterpreter interpreter, 
			IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, annotation, concreteChildType, interpreter, progressMonitor);
		javaInterpreter = interpreter;
		getAnalysisManagers();
	}
	/**
	 * Reverse essential
	 */
	public JavaMapping(
			EObject element, 
			EStructuralFeature feature, 
			EStructuralFeature essentialFeature, 
			EAnnotation annotation, 
			EClass concreteChildType, 
			JavaMappingInterpreter interpreter, 
			IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(element, feature, essentialFeature, annotation, concreteChildType, interpreter, progressMonitor);
		javaInterpreter = interpreter;
		getAnalysisManagers();
	}
	/**
	 * Forward
	 */
	public JavaMapping(
			SyncItem syncItem, 
			EAnnotation annotation, 
			JavaMappingInterpreter interpreter, 
			IProgressMonitor progressMonitor) throws FSMLMappingException {
		super(syncItem.getModel() != null ? syncItem.getModel() : syncItem.getCode(), syncItem, annotation, null, interpreter, progressMonitor);
		javaInterpreter = interpreter;
		getAnalysisManagers();
	}
	private void getAnalysisManagers() {
		analysisManagers = javaInterpreter.getAnalysisManagers();
		javaAstManager = analysisManagers.getJavaASTManager();
		contextManager = analysisManagers.getJavaContextManager();
		callGraphManager = analysisManagers.getHierarchicalCallGraphManager();
		javaImplVariantManager = analysisManagers.getJavaImplVariantManager();
		typeHierarchy = analysisManagers.getTypeHierarchy();
	}
	@Context(mode=Mode.ALL)
	public IJavaProject contextIJavaProject;
	
	protected JavaMarkerDescriptor createJavaMarkerDescriptor(IResource resource, Object value, String explanation) {
		JavaMarkerDescriptor markerDescriptor = new JavaMarkerDescriptor(resource);
		markerDescriptor.setFeature(feature);
		markerDescriptor.setExplanation(explanation);
		if (value != null)
			markerDescriptor.setValue(value);
		addMarkerDescriptor(markerDescriptor);
		return markerDescriptor;
	}
	protected JavaMarkerDescriptor createJavaMarkerDescriptor(IResource resource, String fullyQualifiedName, Object value, String explanation) {
		JavaMarkerDescriptor markerDescriptor = new JavaMarkerDescriptor(resource, fullyQualifiedName);
		markerDescriptor.setFeature(feature);
		markerDescriptor.setExplanation(explanation);
		if (value != null)
			markerDescriptor.setValue(value);
		addMarkerDescriptor(markerDescriptor);
		return markerDescriptor;
	}
	
	public void createMarkerDescriptor(Object item) {
		createMarkerDescriptor(item, null, null);
	}
	
	public void createMarkerDescriptor(Object item, Object value) {
		createMarkerDescriptor(item, value, null);
	}
	/**
	 * @param item could be of one of the following types: IMemeber, SearchMatch, ASTNode 
	 * @param value
	 */
	public void createMarkerDescriptor(Object item, Object value, String explanation) {
		if (Stats.INSTANCE.logScatteringAndTangling)
			logScatteringAndTangling(item, value);
		if (item instanceof IMember) {
			IMember iMember = (IMember) item;
			if (iMember.isBinary()) {
				String fullyQualifiedName = iMember instanceof IType && ((IType) iMember).getDeclaringType() == null ? 
						((IType) iMember).getFullyQualifiedName() // top level type 
						: iMember.getDeclaringType().getFullyQualifiedName(); // member or inner type
				
				IResource resource = iMember.getJavaProject().getResource();
				JavaMarkerDescriptor markerDescriptor = createJavaMarkerDescriptor(resource, fullyQualifiedName, value, explanation);
				markerDescriptor.setCharStartCharEnd(iMember);
				return;
			}
			else {
				JavaMarkerDescriptor markerDescriptor = createJavaMarkerDescriptor(iMember.getResource(), value, explanation);
				markerDescriptor.setCharStartCharEnd(iMember);	
				return;
			}
		}
		else if (item instanceof IClassFile) {
			IClassFile classFile = (IClassFile) item;
			String fullyQualifiedName = classFile.findPrimaryType().getFullyQualifiedName();
			IResource resource = classFile.getJavaProject().getResource();
			JavaMarkerDescriptor markerDescriptor = createJavaMarkerDescriptor(resource, fullyQualifiedName, value, explanation);
			markerDescriptor.setCharStartCharEnd(classFile);
			return;
		}
		else if (item instanceof ICompilationUnit) {
			ICompilationUnit iCompilationUnit = (ICompilationUnit) item;
			IResource resource = iCompilationUnit.getResource();
			JavaMarkerDescriptor markerDescriptor = createJavaMarkerDescriptor(resource, value, explanation);
			markerDescriptor.setCharStartCharEnd(iCompilationUnit);
			return;
		}
		else if (item instanceof SearchMatch) {
			SearchMatch searchMatch = (SearchMatch) item;
			IJavaElement matchElement = (IJavaElement) searchMatch.getElement();
			JavaMarkerDescriptor markerDescriptor = null;
			ICompilationUnit iCompilationUnit = (ICompilationUnit) matchElement.getAncestor(IJavaElement.COMPILATION_UNIT); 
			if (iCompilationUnit != null)
				markerDescriptor = createJavaMarkerDescriptor(iCompilationUnit.getResource(), value, explanation);
			else {
				IClassFile iClassFile = (IClassFile) matchElement.getAncestor(IJavaElement.CLASS_FILE);
				String fqName = iClassFile.getType().getFullyQualifiedName();
				markerDescriptor = createJavaMarkerDescriptor(matchElement.getJavaProject().getResource(), fqName, value, explanation);
			}
			if (markerDescriptor != null) {
				markerDescriptor.setCharStartCharEnd(searchMatch);
				return;
			}
		}
		else if (item instanceof ASTNode) {
			ASTNode astNode = (ASTNode) item;
			CompilationUnit compilationUnit = (CompilationUnit) astNode.getRoot();
			ITypeRoot iTypeRoot = (ITypeRoot) compilationUnit.getJavaElement();
			JavaMarkerDescriptor markerDescriptor = null;
			if (iTypeRoot instanceof ICompilationUnit)
				markerDescriptor = createJavaMarkerDescriptor(((ICompilationUnit)iTypeRoot).getResource(), value, explanation);
			else {
				String fqName = ((IClassFile)iTypeRoot).getType().getFullyQualifiedName();
				markerDescriptor = createJavaMarkerDescriptor(iTypeRoot.getJavaProject().getResource(), fqName, value, explanation);
			}
			if (markerDescriptor != null) {
				markerDescriptor.setCharStartCharEnd(astNode);
				return;
			}
		}
		else {
			Stats.INSTANCE.logError("Marker not created for item: " + item.toString());
		}
	}
	public boolean setFeatureContextAndMarker(boolean result, Object context, Object markerObject, Object markerValue) throws FSMLMappingException {
		return setFeatureContextAndMarker(result, context, markerObject, markerValue, null);
	}
	public boolean setFeatureContextAndMarker(boolean result, Object context, Object markerObject, Object markerValue, String explanation) throws FSMLMappingException {
		if (setFeature(result, context)) {
			if (markerObject != null) {
				// setFeature might have set the child field
				// child != null for containment references, markerValue != null for attributes
				createMarkerDescriptor(markerObject, (child != null ? child : markerValue), explanation);
			}
			return true;
		}
		return false;
	}
	public boolean setFeatureContextAndMarker(String result, Object context, Object markerObject, Object markerValue) throws FSMLMappingException {
		return setFeatureContextAndMarker(result, context, markerObject, markerValue, null);
	}
	public boolean setFeatureContextAndMarker(String result, Object context, Object markerObject, Object markerValue, String explanation) throws FSMLMappingException {
		if (setFeature(result, context)) {
			// setFeature might have set the child field
			// child != null for containment references, markerValue != null for attributes
			createMarkerDescriptor(markerObject, (child != null ? child : markerValue), explanation);
			return true;
		}
		return false;
	}
	public void setContextAndMarker(Object context, Object markerObject, String explanation) {
		Queries.INSTANCE.associateContext(child, context);
		createMarkerDescriptor(markerObject, child, explanation);
	}
	protected void logScatteringAndTangling(Object item, Object value) {
		String location = "";
		if (item instanceof IMember) {
			IMember iMember = (IMember) item;
			try {
				IType iType = iMember instanceof IType ?
						(IType) iMember :
						JavaModelUtils.getDeclaringType(iMember);
				location = iType.getFullyQualifiedName();
				Stats.INSTANCE.logScatteringAndTangling(element, feature, value, location);
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		else if (item instanceof SearchMatch) {
			SearchMatch searchMatch = (SearchMatch) item;
			IJavaElement iJavaElement = (IJavaElement) searchMatch.getElement();
			try {
				IType iType = iJavaElement instanceof IType ?
						(IType) iJavaElement :
						JavaModelUtils.getDeclaringType(iJavaElement);
						
				location = iType.getFullyQualifiedName();
				Stats.INSTANCE.logScatteringAndTangling(element, feature, value, location);
				
				IMethod iMethod = (IMethod) iJavaElement.getAncestor(IJavaElement.METHOD);
				if (iMethod != null) {
					location = iType.getFullyQualifiedName() + "." + iMethod.getElementName() + "()";
					Stats.INSTANCE.logScatteringAndTangling(element, feature, value, location);
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		else if (item instanceof ASTNode) {
			ASTNode astNode = (ASTNode) item;
			TypeDeclaration typeDeclaration = (TypeDeclaration) ASTUtils.getAncestorOfType(astNode, ASTNode.TYPE_DECLARATION);
			if (typeDeclaration != null) {
				location =  ASTUtils.getFullyQualifiedName(typeDeclaration);
				Stats.INSTANCE.logScatteringAndTangling(element, feature, value, location);
				
				MethodDeclaration methodDeclaration = (MethodDeclaration) ASTUtils.getAncestorOfType(astNode, ASTNode.METHOD_DECLARATION);
				if (methodDeclaration != null) {
					IMethodBinding iMethodBinding = methodDeclaration.resolveBinding();
					if (iMethodBinding != null) {
						location =  ASTUtils.getFullyQualifiedName(typeDeclaration) + "." + iMethodBinding.getName() + "()";
						Stats.INSTANCE.logScatteringAndTangling(element, feature, value, location);
					}
				}
			}
		}
	}
	/**
	 * 
	 * @param syncItem
	 * @param index
	 * @return
	 */
	public static String retrieveTypeOfArgumentFromSignature(SyncItem syncItem, int index) {
		EObject element = FSMLEcoreUtil.retrieveContextElement(syncItem, JavaMappingInterpreter.CONTEXT_METHOD_CALL);
		EReference containingReference = (EReference) element.eContainingFeature();
		EAnnotation annotation = containingReference.getEAnnotation(JavaMappingInterpreter.QUERY_CALLS_RECEIVED);
		String signature = null;			
		if (annotation != null) {
			signature = annotation.getDetails().get(JavaMappingInterpreter.DETAIL_SIGNATURE);
		}
		else {
			annotation = containingReference.getEAnnotation(JavaMappingInterpreter.QUERY_METHOD_CALLS);
			if (annotation != null) {
				signature = annotation.getDetails().get(JavaMappingInterpreter.DETAIL_SIGNATURE);
			}
		}
		// variable "index" is 1-based, not 0-based
		String type = Signature.getParameterTypes(signature)[index-1];
		return type;
	}
}
