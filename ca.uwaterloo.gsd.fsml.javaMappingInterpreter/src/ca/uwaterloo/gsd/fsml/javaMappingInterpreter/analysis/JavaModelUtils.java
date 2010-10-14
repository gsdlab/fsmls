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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.BindingKey;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.search.FieldReferenceMatch;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.MethodReferenceMatch;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.SuperHierarchyScope;
import ca.uwaterloo.gsd.fsml.stats.Stats;

/**
 * Utility methods for manipulating the Java Model.
 *
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class JavaModelUtils {

	/**
	 * Gets the reference to the default constructor of this type, if it declares one.
	 * 
	 * @param type the type to search for the default constructor
	 * @return the default constructor, or null if not found
	 */
	public static IMethod getDefaultConstructor(IType type) {
		if (type == null) return null;
		
		try {
			for (IMethod method : type.getMethods()) {
				if (method.isConstructor() && method.getParameterTypes().length == 0) {
					return method;
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Checks if this type has an implicit default constructor, i.e., it does not
	 * declare the default constructor nor another constructor with parameters
	 * 
	 * @param type
	 * @return
	 */
	public static boolean hasImplicitDefaultConstructor(IType type) {
		if (type == null) return false;
		
		boolean hasConcreteDefault = false;
		boolean hasOtherConcrete = false;
		try {
			for (IMethod method : type.getMethods()) {
				if (method.isConstructor()) {
					if (method.getParameterTypes().length == 0) {
						hasConcreteDefault = true;
					} else {
						hasOtherConcrete = true;
					}
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return ! hasConcreteDefault && ! hasOtherConcrete;
	}
	
	/**
	 * Gets the first occurrence of a concrete default constructor in the hierarchy of this type.
	 * 
	 * This method will search for a default constructor somewhere, eventually getting to Object.
	 *  
	 * @param hierarchy
	 * @param type
	 * @return the concrete default constructor that will be executed if an object of type is created
	 * with a default constructor. Null if there is no such constructor.
	 */
	public static IMethod getConcreteDefaultConstructor(ITypeHierarchy hierarchy, IType type) {
		
		if (type == null) return null;
		
		// check if the type itself declares the constructor
		IMethod constructor = getDefaultConstructor(type);
		if (constructor != null) {
			return constructor;
		}
		// if it does not have an implicit, there is no way to get a default
		if (! hasImplicitDefaultConstructor(type)) 
			return null;
		
		// get it from the super class
		return getConcreteDefaultConstructor(hierarchy, hierarchy.getSuperclass(type));
	}
	
	/**
	 * Returns the type root of this element (a compilation unit or a class file), or null
	 * if cannot get it.
	 * 
	 * This method should be used instead of calling IJavaElement.getTypeRoot() because we
	 * get the right class file for nested types.
	 * 
	 * @param e
	 * @return
	 */
	public static ITypeRoot getTypeRoot(IJavaElement e) {
		
		if (e == null) return null;
		
		try {
			// the element we will really search for
			IJavaElement target = getTopLevelType(e);
			// could not find a type, check the element directly
			if (target == null) {
				target = e;
			}
			
			IJavaElement root = target.getAncestor(IJavaElement.COMPILATION_UNIT);
			if (root != null) {
				return (ITypeRoot) root;
			}
			root = target.getAncestor(IJavaElement.CLASS_FILE);
			if (root != null) {
				return (ITypeRoot) root;
			}
		} catch (JavaModelException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Gets the top level type declaring this element.
	 * 
	 * The top level type is a type that is not nested in other types. 
	 * 
	 * @param e
	 * @return
	 */
	public static IType getTopLevelType(IJavaElement e) throws JavaModelException {
		
		if (e == null) return null;
		
		IType type = (IType) e.getAncestor(IJavaElement.TYPE);
		IType declaringType = type;
		if (type != null) {
			while(true) {
				IType auxDeclaringType = getDeclaringType(declaringType);
				if (auxDeclaringType == null)
					break;
				declaringType = auxDeclaringType;
			}
		}
		return declaringType;
	}
	
	/**
	 * Finds the type on the top of the hierarchy
	 * 
	 * @param h
	 * @return
	 */
	public static IType getTopType(ITypeHierarchy h) {
		IType top = h.getType();
		if (top == null) return null;
		while(h.getSuperclass(top) != null)
			top = h.getSuperclass(top);
		return top;
	}
	
	/**
	 * Gets the declaring type of this type.
	 * 
	 * The declaring type is the outer type. If this is a top level type, this method will return null.
	 * Otherwise, it will return the IType representing the type where this type was declared.
	 * 
	 * This implementation should be used instead of IType.getDeclaringType() because it fixes Bug 8716
	 * that prevented getting the declaring type of anonymous binary nested types. If the type is
	 * not anonymous binary, this implementation just calls the regular IType.getDeclaringType method.
	 * Otherwise, we parse the type's name and try to resolve the outer type using the package fragment.
	 * 
	 * @param type
	 * @return
	 * @throws JavaModelException
	 */
	public static IType getDeclaringType(IType type) throws JavaModelException {
		
		if (type == null) return null;
		
		// do our magic for anonymous binary types
		if (type.isAnonymous() && type.isBinary()) {
			// retrieve the top level type
			String topLevelName = type.getTypeQualifiedName();
			topLevelName = topLevelName.substring(0, topLevelName.lastIndexOf('$')) + ".class";
			IType topLevelType = type.getPackageFragment().getClassFile(topLevelName).getType();
			// now get the type exactly in that place of the source (could be nested type)
			IJavaElement spot = topLevelType.getClassFile().getElementAt(type.getSourceRange().getOffset());
			if (spot == null) {
				IType declaringType = type.getDeclaringType();
				if (declaringType != null)
					return declaringType;
				IJavaElement parent = type.getParent();
				if (parent instanceof IType)
					return (IType) parent;
				String key = type.getKey();
				BindingKey bindingKey = new BindingKey(key);
				String signature = bindingKey.toSignature();
				signature = signature.substring(0, signature.indexOf('$')) + ";";
				String fqName = Signature.toString(signature);
				return type.getJavaProject().findType(fqName);
			}
			return (IType) spot.getAncestor(IJavaElement.TYPE);
		}
		return type.getDeclaringType();
	}
	
	public static IType getDeclaringType(IJavaElement e) throws JavaModelException {
		
		if (e == null) return null;

		if (e instanceof IType) {
			return JavaModelUtils.getDeclaringType((IType) e);
		}
		return (IType) e.getAncestor(IJavaElement.TYPE);
	}

	public static Collection<SearchMatch> getMethodCallsInProject(IJavaProject project, IMethod method, IProgressMonitor progressMonitor) throws JavaModelException {
		return getMethodCalls(project, null, null, null, method, Scope.PROJECT, progressMonitor);
	}

	public static Collection<SearchMatch> getMethodCalls(IJavaProject project, IIncrementalTypeHierarchy hierarchy, IMember member, IType destType, IMethod method, Scope searchScope, IProgressMonitor progressMonitor) throws JavaModelException {
		// stats
		final String searchSuccessful = "method reference found to '" + method.getElementName() + "'";
		final String searchUnsuccessful = "callsMethod: Unable to perform method reference search";
		
		SearchPattern pattern = SearchPattern.createPattern(method, IJavaSearchConstants.REFERENCES);
	
		final ArrayList<SearchMatch> found =  new ArrayList<SearchMatch>();
		
		IJavaSearchScope scope = null;
		switch (searchScope) {
		case NO_HIERARCHY:
			scope = SearchEngine.createJavaSearchScope(new IJavaElement[] {member} );
			break;
		case SOURCE_HIERARCHY:
			if (member instanceof IType)
				// Now using our own scope that gets only super types (and the type itself)
				//scope = SearchEngine.createHierarchyScope((IType) member);
				scope = new SuperHierarchyScope((IType) member, hierarchy);
			break;
		case TARGET_HIERARCHY:
			scope = SearchEngine.createHierarchyScope(destType);
			break;
		case PROJECT:
			scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { project } );
			break;
		default:
			return found;
		}
		
		// Get the search requestor
		SearchRequestor requestor = new SearchRequestor() {
			@Override
			public void acceptSearchMatch(SearchMatch match) throws CoreException {
				if (match instanceof MethodReferenceMatch)
					found.add(match);
			}
		};
		// Search
		SearchEngine searchEngine = new SearchEngine();
		try {
			searchEngine.search(pattern, new SearchParticipant[] {SearchEngine.getDefaultSearchParticipant()}, scope, requestor, progressMonitor);
		} catch (CoreException e) {
			// stats
			Stats.INSTANCE.logMessage(searchUnsuccessful);
			e.printStackTrace();
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
		for (Iterator<SearchMatch> i = found.iterator(); i.hasNext(); ) {
			SearchMatch match = i.next();
			int accuracy = match.getAccuracy();
			Stats.INSTANCE.logMessage("callsMethod: " +(accuracy == SearchMatch.A_ACCURATE ? "Accurate " : "Inaccurate ") + searchSuccessful);
			/*if (accuracy == SearchMatch.A_INACCURATE)
				Stats.INSTANCE.log("Inaccurate method call match: " + match);*/
			// filter out inaccurate matches
			if (accuracy == SearchMatch.A_INACCURATE)
				i.remove();
		}
		// stats
		return found;
	}

	public static Collection<FieldReferenceMatch> writesToField(IJavaProject project, IField field, IProgressMonitor progressMonitor) throws JavaModelException {
		// stats
		final String searchSuccessful = "field write access found to '" + field.getElementName() +"'";
		final String searchUnsuccessful = "callsMethod: Unable to perform field write access search";
		
		SearchPattern pattern = SearchPattern.createPattern(field, IJavaSearchConstants.WRITE_ACCESSES);
		// get all superclasses of type
		IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { project });
		final ArrayList<FieldReferenceMatch> found =  new ArrayList<FieldReferenceMatch>();
		// Get the search requestor
		SearchRequestor requestor = new SearchRequestor() {
			@Override
			public void acceptSearchMatch(SearchMatch match) throws CoreException {
				if (match instanceof FieldReferenceMatch)
					found.add((FieldReferenceMatch) match);
			}
		};
		// Search
		SearchEngine searchEngine = new SearchEngine();
		try {
			searchEngine.search(pattern, new SearchParticipant[] {SearchEngine.getDefaultSearchParticipant()}, scope, requestor, progressMonitor);
		} catch (CoreException e) {
			// stats
			Stats.INSTANCE.logMessage(searchUnsuccessful);
			e.printStackTrace();
		}
		for (SearchMatch match : found) {
			int accuracy = match.getAccuracy();
			Stats.INSTANCE.logMessage("writesToField: " +(accuracy == SearchMatch.A_ACCURATE ? "Accurate " : "Inaccurate ") + searchSuccessful);
		}
		return found;
	}

	public static List<IType> getSubtypesOfType(IType iType, IJavaProject javaProject, boolean localOnly, boolean concreteOnly, boolean abstractOnly, IProgressMonitor progressMonitor) throws JavaModelException {
		ITypeHierarchy iTypeHierarchy = iType.newTypeHierarchy(javaProject, progressMonitor);
		List<IType> subtypes = new ArrayList<IType>();
		String queriesProject = javaProject.getHandleIdentifier();
		
		IType[] alltypes = iTypeHierarchy.getAllSubtypes(iType);
		for (IType aux : alltypes) {
			if (localOnly) {
				if (aux.isBinary())
					continue;
				String elementsProject = aux.getJavaProject().getHandleIdentifier();
				if (!elementsProject.equals(queriesProject))
					continue;
			}
			if (concreteOnly && abstractOnly) {
				Stats.INSTANCE.logBug("getSubtypesOfType(): concreteOnly && abstractOnly");
				continue;
			}
			if (concreteOnly) {
				if (aux.isInterface() || Flags.isAbstract(aux.getFlags()))
					continue;
			}
			if (abstractOnly) {
				if (!aux.isInterface() && !Flags.isAbstract(aux.getFlags()))
					continue;
			}
			if (!subtypes.contains(aux))
				subtypes.add(aux);
		}
		return subtypes;
	}

	/**
	 * Locates a method in the given IType. 
	 * The returned method is guaranteed to exist.
	 * @param project TODO
	 * @param lookupName
	 * @param lookupSignature
	 * @param type
	 * @param includeLocal
	 * @param includeInherited
	 * @param progressMonitor
	 * @return
	 * @throws JavaModelException
	 */
	public static IMethod findMethod(IJavaProject project, String lookupName, String lookupSignature, IType type, boolean includeLocal, boolean includeInherited, IProgressMonitor progressMonitor) throws JavaModelException {
		String[] lookupParameterNames = Signature.getParameterTypes(lookupSignature);
		String[] lookupParameterSimpleNames = new String[lookupParameterNames.length];
	
		for (int i = 0; i < lookupParameterNames.length; i++) {
			String erasure = Signature.getTypeErasure(lookupParameterNames[i]);
			lookupParameterSimpleNames[i] = Signature.getSimpleName(Signature.toString(erasure));
		}
		
		if (includeLocal) {
			IMethod result = type.getMethod(lookupName, lookupParameterNames);
			if (result != null && result.exists())
				return result;
	
			for (IMethod iMethod : type.getMethods())
				if (iMethod.getElementName().equals(lookupName))
					if (iMethod.isSimilar(result))
						return iMethod;
		}
		if (includeInherited) {
			// look in supertype
			IType superIType = (IType) project.findType(type.getSuperclassName());
			if (superIType != null && superIType.exists())
				return findMethod(project, lookupName, lookupSignature, superIType, true, includeInherited, progressMonitor);
		}
		return null;
	}

	
	
	/**
	 * A Range to compare for an unknown range
	 */
	public static final ISourceRange UNKNOWN_RANGE = new ISourceRange() {
		public int getLength() { return 0; }
		public int getOffset() { return -1; }
	};
	
	/**
	 * Checks if this source reference has a valid range.
	 * 
	 * This is useful to check is a certain method that is in the Java Model really exists in
	 * the source. This is the case, for example, for implicit constructors. If the constructor
	 * source range is unknown, this means we cannot parse it (it has no source!)
	 * 
	 * @param ref
	 * @return
	 */
	public static boolean hasSourceRange(ISourceReference ref) {
		try {
			
			ISourceRange refRange = ref.getSourceRange();
			return refRange != null && ! refRange.equals(JavaModelUtils.UNKNOWN_RANGE);
			
		} catch (JavaModelException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Formats the method to be printed
	 * 
	 * @param method
	 * @return
	 */
	public static StringBuffer formatMethod(IMethod method) {
		StringBuffer buf = new StringBuffer();
		buf.append(method.getDeclaringType().getElementName());
		buf.append('.');
		buf.append(method.getElementName());
		buf.append("(...)");
		return buf;
	}
}
