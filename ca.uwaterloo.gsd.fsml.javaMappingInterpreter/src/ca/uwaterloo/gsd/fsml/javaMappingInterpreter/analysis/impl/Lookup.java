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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.internal.core.NameLookup;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;

/**
 * This class encapsulates name lookup in the project.
 * 
 * Name lookup has been encapsulated here for reuse, to concentrate "discouraged access" warnings in one
 * place and to make it easier to implement lookup optimizations.
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class Lookup {

	/**
	 * Should we cache results?
	 */
	public static final boolean CACHE = false;
	
	
	protected JavaProject project = null;
	protected NameLookup lookup = null;
	protected Map<String, IType> cache = null;
	
	public Lookup(IJavaProject project) {
		this.project = (JavaProject) project;
		if (CACHE) {
			cache = new HashMap<String, IType>();
		}
	}
	
	/**
	 * Finds the type identified by this simple name in the context of this type.
	 * 
	 * If the type is binary, the simple name is considered a fully qualified name!
	 * 
	 * If the simple name is ambiguous, this method returns an arbitrary resolved
	 * type. If the name cannot be resolved, it returns null. 
	 * 
	 * @param type
	 * @param simpleName
	 * @return
	 * @throws JavaModelException
	 */
	public IType findType(IType type, String simpleName) throws JavaModelException {
		
		String fullyQualifiedName = simpleName;
		if (! type.isBinary()) {
			type = JavaModelUtils.getTopLevelType(type);
			String[][] names = type.resolveType(simpleName);
			if (names.length != 0) {
				fullyQualifiedName = names[0][0] + '.' + names[0][1];
			}
		}
		return findType(fullyQualifiedName);
	}
	
	/**
	 * Finds the type identified by this fully qualified name in the project.
	 * 
	 * @param fullyQualifiedName
	 * @return
	 * @throws JavaModelException
	 */
	public IType findType(String fullyQualifiedName) throws JavaModelException {

		if (CACHE && cache.containsKey(fullyQualifiedName)) {
			return cache.get(fullyQualifiedName);
		}
		//IType type = getNameLookup().findType(fullyQualifiedName, false, NameLookup.ACCEPT_ALL);
		IType type = project.findType(fullyQualifiedName);
		
		if (CACHE && type != null)
			cache.put(fullyQualifiedName, type);
		
		return type;
	}
	
	protected NameLookup getNameLookup() throws JavaModelException {
		if (lookup == null) {
			lookup = ((JavaProject) project).newNameLookup(JavaMappingInterpreter.primaryWorkingCopyOwner);
		}
		return lookup;
	}

	public void clear() {
		lookup = null;
		if (CACHE)
			cache.clear();
	}
}
