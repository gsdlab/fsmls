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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IHierarchyNode;

/**
 * An Hierarchy Node is a decorator to an IType that keeps track 
 * of the inheritance hierarchy.
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class HierarchyNode implements IHierarchyNode {
	
	public static final IType[] EMPTY_TYPES_ARRAY = new IType[0];
	
	protected boolean buggyAnonymous = false;
	protected AnonymousClassDeclaration declaration = null;
	
	protected int depth = 0;
	protected boolean hasAnonymousType = false;
	protected boolean hasExhaustiveSubtypes = false;
	
	protected IType type = null;
	protected IType superClass = null;
	protected IType[] superInterfaces = null;
	protected List<IType> subClasses = null;
	protected List<IType> subInterfaces = null;
	protected List<IType> anonymousTypes = null;
	protected IType declaringType = null;
	
	public HierarchyNode(IType type) {
		this(type, null, null, 0);
	}
	
	public HierarchyNode(IType type, IType superClass) {
		this(type, superClass, null, 1);
	}
	
	public HierarchyNode(IType type, IType superClass, IType[] superInterfaces, int depth) {
		this.type = type;
		this.superClass = superClass;
		if (superInterfaces != null) {
			this.superInterfaces = superInterfaces;			
		} else {
			this.superInterfaces = EMPTY_TYPES_ARRAY;
		}
		this.depth = depth;
	}
	
	/**
	 * The type being decorated by this hierarchy node
	 * 
	 * @return the decorated type
	 */
	public IType getType() {
		return this.type;
	}
	
	/**
	 * Returns a list with all super types (classes and interfaces) of the
	 * decorated type. This list is equivalent to SuperInterfaces + SuperClass.
	 * 
	 * @return
	 */
	public IType[] getSuperTypes() {
		// Check if it is java.lang.Object or a root interface
		if (superClass == null && superInterfaces.length == 0) {
			return EMPTY_TYPES_ARRAY;
		}
		// Check if it a regular interface (no super class)
		if (superClass == null) {
			return superInterfaces;
		}
		// Regular class
		IType[] types = new IType[superInterfaces.length + 1];
		types[0] = superClass;
		System.arraycopy(superInterfaces, 0, types, 1, superInterfaces.length);
		return types;
	}
	
	/**
	 * Returns the super class of the decorated type.
	 * 
	 * @return
	 */
	public IType getSuperClass() {
		return this.superClass;
	}
	
	/**
	 * Returns the super interfaces of the decorated type.
	 * 
	 * @return
	 */
	public IType[] getSuperInterfaces() {
		return this.superInterfaces;
	}
	
	/**
	 * Returns the list of known sub types of the decorated type.
	 * This list is equivalent to SubClasses + SubInterfaces.
	 * 
	 * @return
	 */
	public IType[] getSubTypes() {
		if (subClasses == null && subInterfaces == null) {
			return new IType[0];
		}
		if (subClasses == null) {
			return getSubInterfaces();
		}
		if (subInterfaces == null) {
			return getSubClasses();
		}
		IType[] types = new IType[subClasses.size() + subInterfaces.size()];
		System.arraycopy(subClasses.toArray(EMPTY_TYPES_ARRAY), 0, types, 0, subClasses.size());
		System.arraycopy(subInterfaces.toArray(EMPTY_TYPES_ARRAY), 0, types, subClasses.size(), subInterfaces.size());
		return types;
	}
	
	/**
	 * Returns the list of known sub classes of the decorated type.
	 * 
	 * @return
	 */
	public IType[] getSubClasses() {
		if (subClasses == null) {
			return EMPTY_TYPES_ARRAY;
		}
		return subClasses.toArray(EMPTY_TYPES_ARRAY);
	}
	
	/**
	 * Returns the list of known sub interfaces of the decorated type.
	 * Note that this list is always empty if the type is a class.
	 * 
	 * @return
	 */
	public IType[] getSubInterfaces() {
		if (subInterfaces == null) {
			return EMPTY_TYPES_ARRAY;
		}
		return subInterfaces.toArray(EMPTY_TYPES_ARRAY);
	}
	
	/**
	 * Returns the list of known anonymous types declared directly on
	 * the decorated type.
	 * 
	 * @return
	 */
	public IType[] getAnonymousTypes() {
		if (anonymousTypes == null) {
			return EMPTY_TYPES_ARRAY;
		}
		return anonymousTypes.toArray(EMPTY_TYPES_ARRAY);
	}
	
	/**
	 * Checks if there is at least one anonymous type between this
	 * type's nested types.
	 * 
	 * @return
	 */
	public boolean hasAnonymousType() {
		return anonymousTypes != null;
	}
	
	/**
	 * Returns the immediate declaring type.
	 * 
	 * For nested and anonymous types, returns the outer type. For top level
	 * types, return null.
	 * 
	 * @return
	 */
	public IType getDeclaringType() {
		if (declaringType == null) {
			declaringType = type.getDeclaringType();
		}
		return declaringType;
	}
	
	/**
	 * Gets the depth of this node in the inheritance hierarchy.
	 * java.lang.Object is at depth 0.
	 * 
	 * @return
	 */
	public int depth() {
		return depth;
	}
	
	/**
	 * Sets the declaring type.
	 * 
	 * @param type
	 */
	public void setDeclaringType(IType type) {
		this.declaringType = type;
	}
	
	/**
	 * Adds this sub type to the node (can be a class or interface)
	 * 
	 * @param subType
	 */
	public void addSubType(IType subType) {
		try {
			if (subType.isInterface()) {
				if (subInterfaces == null) {
					subInterfaces = new ArrayList<IType>(1);
				}
				subInterfaces.add(subType);
				return;
			}
		} catch (JavaModelException e) {
		}
		// consider it a class (maybe was an exception)
		if (subClasses == null) {
			subClasses = new ArrayList<IType>(1);
		}
		subClasses.add(subType);
	}
	
	/**
	 * Adds this type to the list of nested types
	 * 
	 * @param nested
	 */
	public void addAnonymousType(IType nested) {
		if (anonymousTypes == null) {
			anonymousTypes = new ArrayList<IType>(1);
		}
		anonymousTypes.add(nested);
	}

	/**
	 * Checks if this type has already been exhaustively searched for sub types 
	 * 
	 * @return
	 */
	public boolean hasExhaustiveSubtypes() {
		return this.hasExhaustiveSubtypes;
	}
	
	/**
	 * Sets hasExhaustiveSubtypes 
	 * 
	 * @param hasExhaustiveSubtypes
	 */
	public void setHasExhaustiveSubtypes(boolean hasExhaustiveSubtypes) {
		this.hasExhaustiveSubtypes = hasExhaustiveSubtypes;
	}
	
	/**
	 * Checks if this node represents a buggy anonymous type.
	 * 
	 * Buggy anonymous types don't have direct representation in disk (or it is in the wrong
	 * place), and their IType objects should not be used.
	 * 
	 * @return
	 */
	public boolean isBuggyAnonymous() {
		return buggyAnonymous;
	}

	/**
	 * @param buggyAnonymous the buggyAnonymous to set
	 */
	public void setBuggyAnonymous(boolean buggyAnonymous) {
		this.buggyAnonymous = buggyAnonymous;
	}
	
	/**
	 * If this is a buggy anonymous, it carries the ASTNode from which it was created.
	 * TODO - REMOVE
	 * @return the ASTNode if it is a buggy anonymous, null otherwise
	 */
	public AnonymousClassDeclaration getDeclaration() {
		return declaration;
	}
	
	/**
	 * TODO - REMOVE
	 * @param declaration
	 */
	public void setDeclaration(AnonymousClassDeclaration declaration) {
		this.declaration = declaration;
	}
	
	public String toString() {
		return type.toString();
	}
}
