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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.IJavaContextManager;

/**
 * This interface declares access methods for managers used during analysis.
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public interface IAnalysisManagers {

	/**
	 * Gets the java AST manager being used in the analysis
	 * 
	 * @return the java AST manager
	 */
	public IJavaASTManager getJavaASTManager();
	
	/**
	 * Gets the hierarchical call graph manager being used in the analysis
	 * 
	 * @return the HierarchicalCallGraphManager
	 */
	public IHierarchicalCallGraphManager getHierarchicalCallGraphManager();
	
	/**
	 * Gets the java context manager being used in the analysis
	 * 
	 * @return the java context manager
	 */
	public IJavaContextManager getJavaContextManager();
	
	/**
	 * Gets the java implVariant manager being used in the analysis
	 * 
	 * @return the java implVariant manager
	 */
	public IJavaImplVariantManager getJavaImplVariantManager();
	
	/**
	 * Gets the incremental type hierarchy being used in the analysis
	 * 
	 * @return the incremental type hierarchy
	 */
	public IIncrementalTypeHierarchy getTypeHierarchy();
	
	/**
	 * Called before starting the analysis, so that all managers have a chance to initialize
	 */
	public void init();
	
	/**
	 * Tear down for all the managers
	 */
	public void finish();
}
