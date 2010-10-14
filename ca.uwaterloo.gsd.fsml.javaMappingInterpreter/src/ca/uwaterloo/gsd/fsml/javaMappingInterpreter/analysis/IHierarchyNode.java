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

import org.eclipse.jdt.core.IType;

/**
 * An Hierarchy Node is a decorator to an IType that keeps track 
 * of the inheritance hierarchy.
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public interface IHierarchyNode {

	/**
	 * The type being decorated by this hierarchy node
	 * 
	 * @return the decorated type
	 */
	public IType getType();
	
	/**
	 * Returns a list with all super types (classes and interfaces) of the
	 * decorated type. This list is equivalent to SuperInterfaces + SuperClass.
	 * 
	 * @return
	 */
	public IType[] getSuperTypes();
	
	/**
	 * Returns the super class of the decorated type.
	 * 
	 * @return
	 */
	public IType getSuperClass();
	
	/**
	 * Returns the super interfaces of the decorated type.
	 * 
	 * @return
	 */
	public IType[] getSuperInterfaces();
	
	/**
	 * Returns the list of known sub types of the decorated type.
	 * This list is equivalent to SubClasses + SubInterfaces.
	 * 
	 * @return
	 */
	public IType[] getSubTypes();
	
	/**
	 * Returns the list of known sub classes of the decorated type.
	 * 
	 * @return
	 */
	public IType[] getSubClasses();
	
	/**
	 * Returns the list of known sub interfaces of the decorated type.
	 * Note that this list is always empty if the type is a class.
	 * 
	 * @return
	 */
	public IType[] getSubInterfaces();
	
	/**
	 * Returns the list of known anonymous types declared directly on
	 * the decorated type.
	 * 
	 * @return
	 */
	public IType[] getAnonymousTypes();
	
	/**
	 * Checks if there is at least one anonymous type between this
	 * type's nested types.
	 * 
	 * @return
	 */
	public boolean hasAnonymousType();
	
	/**
	 * Returns the immediate declaring type.
	 * 
	 * For nested and anonymous types, returns the outer type. For top level
	 * types, return null.
	 * 
	 * @return
	 */
	public IType getDeclaringType();
	
	/**
	 * Gets the depth of this node in the inheritance hierarchy.
	 * java.lang.Object is at depth 0.
	 * 
	 * @return
	 */
	public int depth();
	
	/**
	 * Checks if this type has already been exhaustively searched for sub types 
	 * 
	 * @return
	 */
	public boolean hasExhaustiveSubtypes();
	
	/**
	 * Checks if this node represents a buggy anonymous type.
	 * 
	 * Buggy anonymous types don't have direct representation in disk (or it is in the wrong
	 * place), and their IType objects should not be used.
	 * 
	 * @return
	 */
	public boolean isBuggyAnonymous();
}
