/*******************************************************************************
 * Copyright (c) 2010 Thiago Tonelli Bartolomei.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Thiago Tonelli Bartolomei - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl;

import org.eclipse.jdt.core.IJavaProject;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaContextManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IAnalysisManagers;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IHierarchicalCallGraphManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IIncrementalTypeHierarchy;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaASTManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaImplVariantManager;

/**
 * Maintains the managers available for analysis
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class AnalysisManagers implements IAnalysisManagers {

	protected IJavaProject project = null;
	
	protected IJavaASTManager javaASTManager = null;
	protected IHierarchicalCallGraphManager hierarchicalCallGraphManager = null;
	protected IJavaImplVariantManager javaImplVariantManager = null;
	protected IIncrementalTypeHierarchy typeHierarchy = null;
	protected JavaContextManager javaContextManager;
	
	/**
	 * Creates a manager for this project
	 * 
	 * @param project
	 */
	public AnalysisManagers(IJavaProject project) {
		this.project = project;
	}
	
	/**
	 * Gets the java AST manager being used in the analysis
	 * 
	 * @return the java AST manager
	 */
	public IJavaASTManager getJavaASTManager() {
		if (javaASTManager == null) {
			javaASTManager = new JavaASTManager(project);
		}
		return javaASTManager;
	}
	
	/**
	 * Gets the hierarchical call graph manager being used in the analysis
	 * 
	 * @return the HierarchicalCallGraphManager
	 */
	public IHierarchicalCallGraphManager getHierarchicalCallGraphManager() {
		if (hierarchicalCallGraphManager == null) {
			hierarchicalCallGraphManager = 
				new HierarchicalCallGraphManager(this.getJavaASTManager(), this.getTypeHierarchy());
		}
		return hierarchicalCallGraphManager;
	}
	
	/**
	 * Gets the java context manager being used in the analysis
	 * 
	 * @return the java context manager
	 */
	public IJavaContextManager getJavaContextManager() {
		if (javaContextManager == null)
			javaContextManager = new JavaContextManager(project, getJavaASTManager());
		return javaContextManager;
	}

	/**
	 * Gets the java implVariant manager being used in the analysis
	 * 
	 * @return the java implVariant manager
	 */
	public IJavaImplVariantManager getJavaImplVariantManager() {
		if (javaImplVariantManager ==null)
			javaImplVariantManager = new JavaImplVariantManager (project);
		return javaImplVariantManager;
	}
	
	/**
	 * Gets the incremental type hierarchy being used in the analysis
	 * 
	 * @return the incremental type hierarchy
	 */
	public IIncrementalTypeHierarchy getTypeHierarchy() {
		if (typeHierarchy == null)
			typeHierarchy = new IncrementalTypeHierarchy(project);
		return typeHierarchy;
	}
	
	/**
	 * Called before starting the analysis, so that all managers have a chance to initialize
	 */
	public void init() {
		this.getJavaImplVariantManager().init();
		this.getJavaASTManager().init();
		this.getHierarchicalCallGraphManager().init();
		this.getJavaContextManager().init();
		this.getTypeHierarchy().init();
		/*
		if (javaASTManager != null)
			javaASTManager.init();
		if (hierarchicalCallGraphManager != null)
			hierarchicalCallGraphManager.init();
		if (javaContextManager != null)
			javaContextManager.init();
		if (typeHierarchy != null)
			typeHierarchy.init(); */
	}
	
	/**
	 * run the tear down for all the managers
	 */
	public void finish() {
		if (javaImplVariantManager != null)
			javaImplVariantManager.finish();
		if (javaASTManager != null)
			javaASTManager.finish();
		if (hierarchicalCallGraphManager != null)
			hierarchicalCallGraphManager.finish();
		if (javaContextManager != null)
			javaContextManager.finish();
		if (typeHierarchy != null)
			typeHierarchy.finish();
	}
}
