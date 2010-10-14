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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import ca.uwaterloo.gsd.fsml.core.FSMLMappingException;

public interface IJavaContextManager {

	public abstract IJavaProject getContextIJavaProject(EObject element);

	/**
	 * Retrieves an IType for the @param element based on fully qualified name.
	 * The returned IType is guaranteed to exist, i.e., null means the IType does not exist.
	 * @return
	 * @throws FSMLMappingException 
	 * @throws FSMLMappingException 
	 */
	public abstract IType getContextIType(EObject element, boolean required)
			throws FSMLMappingException;

	public abstract TypeDeclaration getContextTypeDeclaration(EObject element,
			boolean required, IProgressMonitor progressMonitor)
			throws FSMLMappingException;

	public abstract IMethod getContextIMethod(EObject element, boolean required);

	public abstract MethodDeclaration getContextMethodDeclaration(
			EObject element, boolean required, IProgressMonitor progressMonitor)
			throws FSMLMappingException;

	public abstract IField getContextIField(EObject element, boolean required)
			throws FSMLMappingException;

	public abstract VariableDeclarationFragment getContextVariableDeclarationFragment(
			EObject element, boolean required, IProgressMonitor progressMonitor)
			throws FSMLMappingException;

	public abstract MethodInvocation getContextMethodInvocation(
			EObject element, boolean required, IProgressMonitor progressMonitor)
			throws FSMLMappingException;

	public abstract ClassInstanceCreation getContextClassInstanceCreation(
			EObject element, boolean required, IProgressMonitor progressMonitor)
			throws FSMLMappingException;

	public abstract Annotation getContextAnnotation(EObject element,
			boolean required, IProgressMonitor progressMonitor)
			throws FSMLMappingException;

	/**
	 * @param object
	 * @param javaElement
	 * This associates given model element with java element using appropriate feature2* hashmaps. 
	 * Intended to be used by custom FSMLAnnotationInterpreters to set contexts supported by the default interpreter.
	 */
	public abstract void associateContext(EObject object, Object context);

	public abstract Object getContext(EObject element,
			IProgressMonitor progressMonitor);

	public abstract Object getContext(EObject element, Class contextClass,
			boolean required, IProgressMonitor progressMonitor);

	public abstract void removeContext(EObject element);

	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init();
	
	public abstract void finish();

}
