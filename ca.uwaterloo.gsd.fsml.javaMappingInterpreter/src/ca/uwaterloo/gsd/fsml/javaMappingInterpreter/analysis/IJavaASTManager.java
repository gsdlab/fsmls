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

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * A Manager for Java ASTs that were parsed during analysis. 
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public interface IJavaASTManager {

	/**
	 * Gets the compilation unit for this java element. If not in cache, this method will parse
	 * the AST and put it in the cache.
	 * 
	 * @param element the java element
	 * @return the compilation unit
	 */
	public CompilationUnit getCompilationUnit(IJavaElement element);
	
	/**
	 * Parses the type root referent to the element (or re-parses if it already was parsed) and 
	 * returns the compilation unit resulting from it. This method will cache the results. 
	 * 
	 * @param element the java element to be parsed
	 * @return the compilation unit
	 * @throws JavaModelException 
	 */
	public CompilationUnit parseTypeRoot(IJavaElement element) throws JavaModelException;
	
	/**
	 * Parses the element (or re-parses if it already was parsed) and returns the compilation unit 
	 * resulting from it. This method will cache the results. 
	 * 
	 * @param root the java element to be parsed
	 * @return the compilation unit
	 * @throws JavaModelException 
	 */
	public CompilationUnit parseTypeRoot(ITypeRoot root) throws JavaModelException;
	
	/**
	 * Gets a compilation unit that was parsed for this type root (a class file or a compilation unit
	 * from java model). If it was not parsed, it will parse.
	 * 
	 * @param root the key (a type root)
	 * @return the compilation unit, or null
	 */
	public CompilationUnit getCompilationUnit(ITypeRoot root);
	
	/**
	 * Caches the compilation unit for this type root.
	 *  
	 * @param root the type root
	 * @param unit the compilation unit
	 */
	public void setCompilationUnit(ITypeRoot root, CompilationUnit unit);
	
	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init();
	
	/**
	 * Clears the whole cache
	 */
	public void finish();
}
