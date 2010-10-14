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

import java.util.Stack;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ITypeBinding;

/**
 * An incremental type hierarchy implements a regular ITypeHierarchy from JDT
 * but in such a way that types can be incrementally added to the hierarchy. This
 * way, the hierarchy is kept in a cache and can be reused.
 * 
 * Furthermore, it defines new useful methods to query and manipulate the hierarchy. 
 * 
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public interface IIncrementalTypeHierarchy extends ITypeHierarchy {

	/**
	 * Adds the super type hierarchy of this type to the hierarchy.
	 * 
	 * This method must analyze the type and add the whole branch of super
	 * types until java.lang.Object is reached.
	 * 
	 * This method must guarantee that the hierarchy remains consistent after
	 * adding this type. This means that no types are left without super classes
	 * and only types that were fully analyzed remain in the hierarchy.
	 * 
	 * @param type the type which is the base of the hierarchy being added
	 * @throws JavaModelException if any problem occurs that the full super
	 * type hierarchy could not be added. The hierarchy is guaranteed to remain
	 * consistent after throwing this exception.
	 */
	public void addSuperTypeHierarchy(IType type) throws JavaModelException;
	
	/**
	 * Adds this buggy anonymous type to the hierarchy.
	 * 
	 * A buggy anonymous type is an anonymous type that has different names between
	 * the actual class on disk and the name JDT's parser gives. Those types always
	 * answer false to exists(), which renders them totally unusable as ITypes.
	 * 
	 * But we can use this small information that could be gathered during parsing.
	 * 
	 * @param anonymous
	 * @param superClass
	 * @param superInterfaces
	 * @throws JavaModelException
	 */
	public void addBuggyAnonymousType(IType anonymous,  ITypeBinding superClass, ITypeBinding[] superInterfaces) throws JavaModelException;
	
	/**
	 * Inform the hierarchy that the anonymous type is declared directly on the 
	 * declaring type (directly meaning it is not inside a nested or other anonymous
	 * type).
	 * 
	 * Both types most be already registered.
	 * 
	 * @param declaring
	 * @param anonymous
	 */
	public void addAnonymousType(IType declaring, IType anonymous);
	
	/**
	 * Gets the hierarchy node decorator stored for this type.
	 * 
	 * @param type
	 * @return the decorator node, or null if the type was not registered in 
	 * the hierarchy.
	 */
	public IHierarchyNode getNode(IType type);

	/**
	 * Gets a stack which represents the branch from this type (in the bottom
	 * of the stack) to java.lang.Object (which is in the top)
	 * 
	 * @param type
	 * @return the branch as a stack, or null if the type is not registered.
	 */
	public Stack<IType> getBranch(IType type);
	
	/**
	 * Checks if the type implements or extends the type identified by this fully qualified name.
	 * 
	 * @param type
	 * @return true if type extends or implements (directly or indirectly) the type with fullyQualifiedName. 
	 * @throws JavaModelException if any problem in the search occurs.
	 */
	public boolean implementsOrExtendsType(IType type, String fullyQualifiedName) throws JavaModelException;
	
	/**
	 * Checks if the type binding implements or extends the type identified by this fully qualified name.
	 * 
	 * @param type
	 * @return true if type binding extends or implements (directly or indirectly) the type with fullyQualifiedName. 
	 * @throws JavaModelException if any problem in the search occurs.
	 */
	public boolean implementsOrExtendsType(ITypeBinding typeBinding, String fullyQualifiedName) throws JavaModelException;
	
	/**
	 * Checks if the type implements the interface identified by this fully qualified name.
	 * 
	 * @param type
	 * @return true if type implements (directly or indirectly) the interface with fullyQualifiedName. 
	 * @throws JavaModelException if any problem in the search occurs.
	 */
	public boolean implementsInterface(IType type, String fullyQualifiedName) throws JavaModelException;
	
	/**
	 * Gets the sub classes of this type, forcing an exhaustive search (if it was not performed
	 * before for this type). 
	 * 
	 * @param type
	 * @return
	 */
	public IType[] getExhaustiveSubclasses(IType type);
	
	/**
	 * Gets the sub types of this type, forcing an exhaustive search (if it was not performed
	 * before for this type). 
	 * 
	 * @param type
	 * @return
	 */
	public IType[] getExhaustiveSubtypes(IType type);
	
	/**
	 * Retrieves the project for which this type hierarchy has been built.
	 * 
	 * @return the project
	 */
	public IJavaProject getProject();
	
	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init();
	
	/**
	 * Called when processing is over, giving opportunity for cleanup.
	 */
	public void finish();
}
