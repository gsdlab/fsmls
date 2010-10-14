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

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchyChangedListener;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.core.search.TypeDeclarationMatch;
import org.eclipse.jdt.core.search.TypeReferenceMatch;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IHierarchyNode;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IIncrementalTypeHierarchy;
import ca.uwaterloo.gsd.fsml.stats.Stats;

/**
 * An incremental type hierarchy implements a regular ITypeHierarchy from JDT
 * but in such a way that types can be incrementally added to the hierarchy. This
 * way, the hierarchy is kept in a cache and can be reused.
 * 
 * Furthermore, it defines new usefull methods to query and manipulate the hierarchy.
 * 
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class IncrementalTypeHierarchy implements IIncrementalTypeHierarchy {

	public static final IType[] EMPTY_TYPES_ARRAY = new IType[0];
	
	protected IJavaProject project = null;
	protected Lookup lookup = null;
	
	protected List<IType> classes = new ArrayList<IType>();
	protected IType object = null;
	protected List<IType> interfaces = new ArrayList<IType>();
	protected List<IType> interfaceRoots = new ArrayList<IType>();
	
	protected Map<IType, HierarchyNode> tree = new HashMap<IType, HierarchyNode>();
	
	/**
	 * Lazy list of change listeners
	 */
	protected List<ITypeHierarchyChangedListener> listeners = null;
	
	/**
	 * Lazy list of cached flags for types 
	 */
	protected Map<IType, Integer> flags = null;
	
	
	public IncrementalTypeHierarchy(IJavaProject project) {
		this.project = project;
		this.lookup = new Lookup(project);
	}
	
	/**
	 * Retrieves the project for which this type hierarchy has been built.
	 * 
	 * @return the project
	 */
	public IJavaProject getProject() {
		return project;
	}
	
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
	public void addSuperTypeHierarchy(IType type) throws JavaModelException {
		
		try {
			internalAddSuperTypeHierarchy(type);
		} finally {
			fireTypeHierarchyChanged();
		}
	}
	
	/**
	 * Returns the type of java.lang.Object
	 * 
	 * @return
	 */
	protected IType getJavaLangObject() {
		if (object == null) {
			try {
				object = lookup.findType("java.lang.Object");
				add(object, classes);
				tree.put(object, new HierarchyNode(object));
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		return object;
	}
	
	protected void internalAddSuperTypeHierarchy(IType type) throws JavaModelException {
		
		if (type == null) {
			System.err.println("internalAddSuperTypeHierarchy: type is null: ");
			throw new IllegalArgumentException("Parameter 'type' should not be null!");
		}
		
		// Ignore java.lang.Object (it gets added in getJavaLangObject())
		if (tree.containsKey(type) || type == getJavaLangObject()) {
			return;
		}
		
		// first add super types, so we are sure to be consistent
		IType superClass = null;
		if (type.isAnonymous() || type.getSuperclassName() == null) {
			superClass = getJavaLangObject();					
		} else {
			superClass = lookup.findType(type, type.getSuperclassName());
			if (superClass == null) {
				System.err.println("internalAddSuperTypeHierarchy: could not resolve superclass name: " + type.getSuperclassName());
				superClass = getJavaLangObject();
			}
		}
		
		internalAddSuperTypeHierarchy(superClass);
		
		String[] superInterfacesNames = type.getSuperInterfaceNames();
		List<IType> superInterfaces = new ArrayList<IType>();
		for (int i = 0; i < superInterfacesNames.length; i++) {
			IType superInterface = lookup.findType(type, superInterfacesNames[i]);
			// TODO - this breaks our assumption that we always have parents in the hierarchy
			// Maybe it is not a problem because this is an interface, but we have to fix
			// registerType to account for that and put this interface as a root interface
			if (superInterface == null)
				System.err.println("internalAddSuperTypeHierarchy: could not resolve superinterface name: " + superInterfacesNames[i] + ". Most likely a dependency is missing.");
			else {
				superInterfaces.add(superInterface);
				internalAddSuperTypeHierarchy(superInterface);
			}
		}
		
		// now we can add this type
		registerType(type, superClass, superInterfaces.toArray(EMPTY_TYPES_ARRAY));
	}

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
	public void addBuggyAnonymousType(IType anonymous, ITypeBinding superClass, ITypeBinding[] superInterfaces) throws JavaModelException {
		
		IType s = (IType) superClass.getJavaElement();
		addSuperTypeHierarchy(s);
		
		IType[] interfaces = new IType[superInterfaces.length];
		for(int i = 0; i < interfaces.length; i++) {
			interfaces[i] = (IType) superInterfaces[i].getJavaElement();
			addSuperTypeHierarchy(interfaces[i]);
		}
		add(anonymous, classes);
		
		HierarchyNode node = new HierarchyNode(anonymous, s, interfaces, tree.get(s).depth() + 1);
		node.setBuggyAnonymous(true);
		
		tree.put(anonymous, node);
		/*
		// register as sub type
		graph.get(s).addSubType(anonymous);
		for(IType superInterface : interfaces) {
			graph.get(superInterface).addSubType(anonymous);
		}*/
	}
	
	/**
	 * Registers this type in the graph, creating the needed hierarchy nodes.
	 * 
	 * @param type
	 * @param superClass
	 * @param superInterfaces
	 * @throws JavaModelException
	 */
	protected void registerType(IType type, IType superClass, IType[] superInterfaces) throws JavaModelException {
		
		IType sup = superClass;
		// first do things that can throw exceptions
		if (type.isInterface()) {
			add(type, interfaces);
			// remove Object as super type of root interfaces
			if (sup == object) { 
				sup = null;
				add(type, interfaceRoots);
			}
		} else {
			add(type, classes);
		}
		// here we are free of checked exceptions
		HierarchyNode node = new HierarchyNode(type, sup, superInterfaces, tree.get(superClass).depth() + 1);
		tree.put(type, node);
		// register as sub type]
		if (sup != null)
			tree.get(sup).addSubType(type);
		for(IType superInterface : superInterfaces) {
			tree.get(superInterface).addSubType(type);
		}
	}
	
	/**
	 * Inform the hierarchy that the anonymous type is declared directly on the 
	 * declaring type.
	 * 
	 * Both types most be already registered.
	 * 
	 * @param declaring
	 * @param anonymous
	 */
	public void addAnonymousType(IType declaring, IType anonymous) {
		if (declaring == null || anonymous == null ||
			! correctlyAdded(declaring) ||
			! correctlyAdded(anonymous)) return;
		
		// adds as a nested type
		tree.get(declaring).addAnonymousType(anonymous);

		// and set the declaring type
		tree.get(anonymous).setDeclaringType(declaring);
	}
	
	/**
	 * Gets the hierarchy node decorator stored for this type.
	 * 
	 * @param type
	 * @return the decorator node, or null if the type was not registered in 
	 * the hierarchy.
	 */
	public IHierarchyNode getNode(IType type) {
		if (type == null || ! correctlyAdded(type)) 
			return null;
		
		return tree.get(type);
	}
	
	/**
	 * Gets a stack which represents the branch from this type (in the bottom
	 * of the stack) to java.lang.Object (which is in the top)
	 * 
	 * @param type
	 * @return the branch as a stack, or null if the type is not registered.
	 */
	public Stack<IType> getBranch(IType type) {
		
		if (type == null || ! correctlyAdded(type)) 
			return null;
		
		Stack<IType> stack = new Stack<IType>();

		while(type != null) {
			stack.push(type);
			type = tree.get(type).getSuperClass();
		}
		return stack;
	}
	
	/**
	 * Checks if the type implements or extends the type identified by this fully qualified name.
	 * 
	 * @param type
	 * @return true if type extends or implements (directly or indirectly) the type with fullyQualifiedName. 
	 * @throws JavaModelException if any problem in the search occurs.
	 */
	public boolean implementsOrExtendsType(IType type, final String fullyQualifiedName) throws JavaModelException {
		
		if (type == null)
			return false;

		if (fullyQualifiedName.equals(type.getFullyQualifiedName())) {
			return true;
		}
		
		if (! correctlyAdded(type)) {
			return false;
		}
		
		return null != search(type, new ITypeCollector() {
			public IType[] getTypes(IHierarchyNode node) {
				return node.getSuperTypes();
			}
			public boolean collect(IHierarchyNode node) {
				return fullyQualifiedName.equals(node.getType().getFullyQualifiedName());
			}
		});
	}
	/**
	 * Checks if the type binding implements or extends the type identified by this fully qualified name.
	 * 
	 * @param type
	 * @return true if type binding extends or implements (directly or indirectly) the type with fullyQualifiedName. 
	 * @throws JavaModelException if any problem in the search occurs.
	 */
	public boolean implementsOrExtendsType(ITypeBinding typeBinding, final String fullyQualifiedName) throws JavaModelException {
		if (typeBinding == null)
			return false;

		if (fullyQualifiedName.equals(typeBinding.getQualifiedName())) {
			return true;
		}
		
		IType type = (IType) typeBinding.getJavaElement();
		
		if (! correctlyAdded(type)) {
			return false;
		}
		
		return null != search(type, new ITypeCollector() {
			public IType[] getTypes(IHierarchyNode node) {
				return node.getSuperTypes();
			}
			public boolean collect(IHierarchyNode node) {
				return fullyQualifiedName.equals(node.getType().getFullyQualifiedName());
			}
		});
	}
	
	/**
	 * Checks if the type implements the interface identified by this fully qualified name.
	 * 
	 * @param type
	 * @return true if type implements (directly or indirectly) the interface with fullyQualifiedName. 
	 * @throws JavaModelException if any problem in the search occurs.
	 */
	public boolean implementsInterface(IType type, final String fullyQualifiedName) throws JavaModelException {

		if (type == null || ! correctlyAdded(type))
			return false;
		
		return null != search(type, new ITypeCollector() {
			public IType[] getTypes(IHierarchyNode node) {
				return node.getSuperInterfaces();
			}
			public boolean collect(IHierarchyNode node) {
				return fullyQualifiedName.equals(node.getType().getFullyQualifiedName());
			}
		});
	}
	
	/**
	 * Returns whether the given type is part of this hierarchy.
	 * 
	 * @param type
	 *            the given type
	 * @return true if the given type is part of this hierarchy, false otherwise
	 */
	public boolean contains(IType type) {
		return tree.containsKey(type);
	}

	/**
	 * Returns whether the type and project this hierarchy was created on exist.
	 * 
	 * Since this implementation does not focus on a type, this method return if the
	 * project exists.
	 * 
	 * @return true if the project this hierarchy was created on exists,
	 *         false otherwise
	 */
	public boolean exists() {
		return project.exists();
	}

	/**
	 * Returns all types in this type hierarchy's graph, in no particular order.
	 * Any types in the creation region which were not resolved to have any
	 * subtypes or supertypes are not included in the result.
	 * 
	 * @return all types in this type hierarchy's grap
	 */
	public IType[] getAllTypes() {
		return tree.keySet().toArray(EMPTY_TYPES_ARRAY);
	}
	
	/**
	 * Returns all classes in this type hierarchy's graph, in no particular
	 * order. Any classes in the creation region which were not resolved to have
	 * any subtypes or supertypes are not included in the result.
	 * 
	 * @return all classes in this type hierarchy's graph
	 */
	public IType[] getAllClasses() {
		return classes.toArray(EMPTY_TYPES_ARRAY);
	}

	/**
	 * Returns all interfaces in this type hierarchy's graph, in no particular
	 * order. Any interfaces in the creation region which were not resolved to
	 * have any subtypes or supertypes are not included in the result.
	 * 
	 * @return all interfaces in this type hierarchy's graph
	 */
	public IType[] getAllInterfaces() {
		return interfaces.toArray(EMPTY_TYPES_ARRAY);
	}

	/**
	 * Returns all resolved subtypes (direct and indirect) of the given type, in
	 * no particular order, limited to the types in this type hierarchy's graph.
	 * An empty array is returned if there are no resolved subtypes for the
	 * given type.
	 * 
	 * @param type
	 *            the given type
	 * @return all resolved subtypes (direct and indirect) of the given type
	 */
	public IType[] getAllSubtypes(IType type) {
		
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		return collect(type, new ITypeCollector() {
			public IType[] getTypes(IHierarchyNode node) {
				return node.getSubTypes();
			}
		});
	}

	/**
	 * Returns all resolved superclasses of the given class, in bottom-up order.
	 * An empty array is returned if there are no resolved superclasses for the
	 * given class.
	 * 
	 * <p>
	 * NOTE: once a type hierarchy has been created, it is more efficient to
	 * query the hierarchy for superclasses than to query a class recursively up
	 * the superclass chain. Querying an element performs a dynamic resolution,
	 * whereas the hierarchy returns a pre-computed result.
	 * 
	 * @param type
	 *            the given type
	 * @return all resolved superclasses of the given class, in bottom-up order,
	 *         an empty array if none.
	 */
	public IType[] getAllSuperclasses(IType type) {
		
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		IHierarchyNode node = tree.get(type);
		int depth = node.depth();
		IType[] ret = new IType[node.depth()];
		for(int i = 0; i < depth; i++) {
			ret[i] = node.getSuperClass();
			node = tree.get(ret[i]);
		}
		
		return ret;
	}

	/**
	 * Returns all resolved superinterfaces (direct and indirect) of the given
	 * type. If the given type is a class, this includes all superinterfaces of
	 * all superclasses. An empty array is returned if there are no resolved
	 * superinterfaces for the given type.
	 * 
	 * <p>
	 * NOTE: once a type hierarchy has been created, it is more efficient to
	 * query the hierarchy for superinterfaces than to query a type recursively.
	 * Querying an element performs a dynamic resolution, whereas the hierarchy
	 * returns a pre-computed result.
	 * 
	 * @param type
	 *            the given type
	 * @return all resolved superinterfaces (direct and indirect) of the given
	 *         type, an empty array if none
	 */
	public IType[] getAllSuperInterfaces(IType type) {
		
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		return collect(type, new ITypeCollector() {
			public IType[] getTypes(IHierarchyNode node) {
				return node.getSuperInterfaces();
			}
		});
	}

	/**
	 * Returns all resolved supertypes of the given type, in bottom-up order. An
	 * empty array is returned if there are no resolved supertypes for the given
	 * type.
	 * <p>
	 * Note that <code>java.lang.Object</code> is NOT considered to be a
	 * supertype of any interface type.
	 * </p>
	 * <p>
	 * NOTE: once a type hierarchy has been created, it is more efficient to
	 * query the hierarchy for supertypes than to query a type recursively up
	 * the supertype chain. Querying an element performs a dynamic resolution,
	 * whereas the hierarchy returns a pre-computed result.
	 * 
	 * @param type
	 *            the given type
	 * @return all resolved supertypes of the given class, in bottom-up order,
	 *         an empty array if none
	 */
	public IType[] getAllSupertypes(IType type) {
		
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		return collect(type, new ITypeCollector() {
			public IType[] getTypes(IHierarchyNode node) {
				return node.getSuperTypes();
			}
		});
	}

	/**
	 * Returns all interfaces resolved to extend the given interface, in no
	 * particular order, limited to the interfaces in this hierarchy's graph.
	 * Returns an empty collection if the given type is a class, or if no
	 * interfaces were resolved to extend the given interface.
	 *  
	 * @param type
	 *            the given type
	 * @return all interfaces resolved to extend the given interface limited to
	 *         the interfaces in this hierarchy's graph, an empty array if none.
	 */
	public IType[] getExtendingInterfaces(IType type) {

		try {
			if (type == null || ! type.isInterface() || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		} catch (JavaModelException e) {
			return EMPTY_TYPES_ARRAY;
		}
		return collect(type, new ITypeCollector() {
			public IType[] getTypes(IHierarchyNode node) {
				return node.getSubInterfaces();
			}
		});
	}

	/**
	 * Returns all classes resolved to implement the given interface, in no
	 * particular order, limited to the classes in this type hierarchy's graph.
	 * Returns an empty collection if the given type is a class, or if no
	 * classes were resolved to implement the given interface.
	 * 
	 * 
	 * @param type
	 *            the given type
	 * @return all classes resolved to implement the given interface limited to
	 *         the classes in this type hierarchy's graph, an empty array if
	 *         none
	 */
	public IType[] getImplementingClasses(IType type) {
		
		try {
			if (type == null || ! type.isInterface() || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		} catch (JavaModelException e) {
			return EMPTY_TYPES_ARRAY;
		}
		return collect(type, new ITypeCollector() {
			public IType[] getTypes(IHierarchyNode node) {
				return node.getSubClasses();
			}
		});
	}

	/**
	 * Returns all classes in the graph which have no resolved superclass, in no
	 * particular order.
	 * 
	 * @return all classes in the graph which have no resolved superclass
	 */
	public IType[] getRootClasses() {
		return new IType[] { object };
	}

	/**
	 * Returns all interfaces in the graph which have no resolved
	 * superinterfaces, in no particular order.
	 * 
	 * @return all interfaces in the graph which have no resolved
	 *         superinterfaces
	 */
	public IType[] getRootInterfaces() {
		return this.interfaceRoots.toArray(EMPTY_TYPES_ARRAY);
	}

	/**
	 * Returns the direct resolved subclasses of the given class, in no
	 * particular order, limited to the classes in this type hierarchy's graph.
	 * Returns an empty collection if the given type is an interface, or if no
	 * classes were resolved to be subclasses of the given class.
	 * 
	 * @param type
	 *            the given type
	 * @return the direct resolved subclasses of the given class limited to the
	 *         classes in this type hierarchy's graph, an empty collection if
	 *         none.
	 */
	public IType[] getSubclasses(IType type) {		
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		return tree.get(type).getSubClasses();
	}

	/**
	 * Gets the sub types of this type, forcing an exhaustive search (if it was not performed
	 * before for this type). 
	 * 
	 * @param type
	 * @return
	 */
	public IType[] getExhaustiveSubtypes(IType type) {

		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		calculateExhaustiveSubtypes(type);
		
		return tree.get(type).getSubTypes();
	}
	
	/**
	 * Gets the sub classes of this type, forcing an exhaustive search (if it was not performed
	 * before for this type). 
	 * 
	 * @param type
	 * @return
	 */
	public IType[] getExhaustiveSubclasses(IType type) {
		
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		calculateExhaustiveSubtypes(type);
		
		return tree.get(type).getSubClasses();
	}
	
	/**
	 * Calculates the sub types of this type and add them to the hierarchy.
	 * After the calculation is done once, it is never repeated. 
	 * 
	 * @param type
	 * @return
	 */
	protected void calculateExhaustiveSubtypes(IType type) {
		
		HierarchyNode node = tree.get(type);
		
		// calculate exhaustive types only once
		if (! node.hasExhaustiveSubtypes()) {
			
			final List<String> subTypes = new ArrayList<String>();
			
			// search for implementors of the type in the project
			SearchPattern pattern = SearchPattern.createPattern(
					type, 
					IJavaSearchConstants.IMPLEMENTORS,
					SearchPattern.R_EXACT_MATCH);
			IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { project } );
			
			// the requestor will accumulate the matches
			SearchRequestor requestor = new SearchRequestor() {
				public void acceptSearchMatch(SearchMatch match) throws CoreException {
					IType type = null;
					if (match instanceof TypeReferenceMatch || match instanceof TypeDeclarationMatch) {
						if (match.getElement() instanceof IType) {
							type = (IType) match.getElement();
						}
					}
					// avoid nulls and repeated types
					if (type != null && ! subTypes.contains(type.getKey())) {
						subTypes.add(type.getKey());
						addSuperTypeHierarchy(type);
					}
				}
			};
			
			// search with the engine
			SearchEngine searchEngine = new SearchEngine();
			try {
				searchEngine.search(pattern, new SearchParticipant[] {SearchEngine.getDefaultSearchParticipant()}, scope, requestor, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}

			//Stats.INSTANCE.printMessage("Found " + subTypes.size() + " subtypes of " + type.getElementName() + " : " + subTypes);
			
			// makes sure this node is marked so that we don't repeat the search
			node.setHasExhaustiveSubtypes(true);
		}
	}
	
	/**
	 * Returns the direct resolved subtypes of the given type, in no particular
	 * order, limited to the types in this type hierarchy's graph. If the type
	 * is a class, this returns the resolved subclasses. If the type is an
	 * interface, this returns both the classes which implement the interface
	 * and the interfaces which extend it.
	 * 
	 * @param type
	 *            the given type
	 * @return the direct resolved subtypes of the given type limited to the
	 *         types in this type hierarchy's graph
	 */
	public IType[] getSubtypes(IType type) {
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		return tree.get(type).getSubTypes();
	}

	/**
	 * Returns the resolved superclass of the given class, or <code>null</code>
	 * if the given class has no superclass, the superclass could not be
	 * resolved, or if the given type is an interface.
	 * 
	 * @param type
	 *            the given type
	 * @return the resolved superclass of the given class, or <code>null</code>
	 *         if the given class has no superclass, the superclass could not be
	 *         resolved, or if the given type is an interface
	 */
	public IType getSuperclass(IType type) {
		if (type == null || ! correctlyAdded(type)) return null;
		
		return tree.get(type).getSuperClass();
	}
	
	/**
	 * Returns the direct resolved interfaces that the given type implements or
	 * extends, in no particular order, limited to the interfaces in this type
	 * hierarchy's graph. For classes, this gives the interfaces that the class
	 * implements. For interfaces, this gives the interfaces that the interface
	 * extends.
	 * 
	 * @param type
	 *            the given type
	 * @return the direct resolved interfaces that the given type implements or
	 *         extends limited to the interfaces in this type hierarchy's graph
	 */
	public IType[] getSuperInterfaces(IType type) {
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		return tree.get(type).getSuperInterfaces();
	}

	/**
	 * Returns the resolved supertypes of the given type, in no particular
	 * order, limited to the types in this type hierarchy's graph. For classes,
	 * this returns its superclass and the interfaces that the class implements.
	 * For interfaces, this returns the interfaces that the interface extends.
	 * As a consequence <code>java.lang.Object</code> is NOT considered to be
	 * a supertype of any interface type.
	 * 
	 * @param type
	 *            the given type
	 * @return the resolved supertypes of the given type limited to the types in
	 *         this type hierarchy's graph
	 */
	public IType[] getSupertypes(IType type) {
		if (type == null || ! correctlyAdded(type)) return EMPTY_TYPES_ARRAY;
		
		return tree.get(type).getSuperTypes();
	}

	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init() {	
	}
	
	/**
	 * Called when processing is over, giving opportunity for cleanup.
	 */
	public void finish() {
		// TODO
		tree.clear();
		classes.clear();
		interfaces.clear();
		lookup.clear();
	}
	
	/**
	 * Checks if the type was correctly added and try to add it if not.
	 * 
	 * @param type
	 * @return true if the type was already added or if it could be successfully added. False otherwise
	 */
	protected boolean correctlyAdded(IType type) {
		if (! tree.containsKey(type)) {
			try {
				this.addSuperTypeHierarchy(type);
			} catch (JavaModelException e) {
				Stats.INSTANCE.logError("IncrementalTypeHierarchy:correctlyAdded(): Swallowing JavaModelException : " + e);
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	// Flags
	/**
	 * Return the flags associated with the given type (would be equivalent to
	 * <code>IMember.getFlags()</code>), or <code>-1</code> if this
	 * information wasn't cached on the hierarchy during its computation.
	 * 
	 * @param type
	 *            the given type
	 * @return the modifier flags for this member
	 * @see Flags
	 * @since 2.0
	 */
	public int getCachedFlags(IType type) {
		Integer i = getFlags(type);
		if (i == null) return -1;
		return i;
	}
	
	/**
	 * Gets the flags for this type, or null if not cached
	 * 
	 * @param type
	 * @return
	 */
	public Integer getFlags(IType type) {
		return getFlags().get(type);
	}
	
	/**
	 * Gets the flags map, creating if needed.
	 * 
	 * @return
	 */
	public Map<IType, Integer> getFlags() {
		if (flags == null) {
			flags = new HashMap<IType, Integer>();
		}
		return flags;
	}
	
	/**
	 * Adds the type to the list, if it is not already there
	 * 
	 * @param type
	 * @param list
	 */
	protected void add(IType type, List<IType> list) {
		if (! list.contains(type)) {
			list.add(type);
		}
	}
	
	// Listeners
	/**
	 * Adds the given listener for changes to this type hierarchy. Listeners are
	 * notified when this type hierarchy changes and needs to be refreshed. Has
	 * no effect if an identical listener is already registered.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void addTypeHierarchyChangedListener(ITypeHierarchyChangedListener listener) {
		this.getListeners().add(listener);
	}

	/**
	 * Removes the given listener from this type hierarchy. Has no affect if an
	 * identical listener is not registered.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removeTypeHierarchyChangedListener(ITypeHierarchyChangedListener listener) {
		this.getListeners().remove(listener);
	}
	
	/**
	 * Gets the list of listeners, creating if needed
	 * 
	 * @return
	 */
	public List<ITypeHierarchyChangedListener> getListeners() {
		if (listeners == null) {
			listeners = new ArrayList<ITypeHierarchyChangedListener>();
		}
		return listeners;
	}
	
	/**
	 * Iterate over listeners firing the event
	 */
	public void fireTypeHierarchyChanged() {
		if (listeners != null) {
			for(ITypeHierarchyChangedListener listener : listeners) {
				listener.typeHierarchyChanged(this);
			}
		}
	}
	
	// No implementation for these methods
	/**
	 * Returns the type this hierarchy was computed for. Returns
	 * <code>null</code> if this hierarchy was computed for a region.
	 * 
	 * @return the type this hierarchy was computed for
	 */
	public IType getType() {
		// we never have a focus type
		return null;
	}

	/**
	 * Re-computes the type hierarchy reporting progress.
	 * 
	 * @param monitor
	 *            the given progress monitor
	 * @exception JavaModelException
	 *                if unable to refresh the hierarchy
	 */
	public void refresh(IProgressMonitor monitor) throws JavaModelException {
		// do nothing, this is an incremental implementation
	}

	/**
	 * Stores the type hierarchy in an output stream. This stored hierarchy can
	 * be load by IType#loadTypeHierachy(IJavaProject, InputStream,
	 * IProgressMonitor). Listeners of this hierarchy are not stored.
	 * 
	 * Only hierarchies created by the following methods can be store:
	 * <ul>
	 * <li>IType#newSupertypeHierarchy(IProgressMonitor)</li>
	 * <li>IType#newTypeHierarchy(IJavaProject, IProgressMonitor)</li>
	 * <li>IType#newTypeHierarchy(IProgressMonitor)</li>
	 * </ul>
	 * 
	 * @param outputStream
	 *            output stream where the hierarchy will be stored
	 * @param monitor
	 *            the given progress monitor
	 * @exception JavaModelException
	 *                if unable to store the hierarchy in the ouput stream
	 * @see IType#loadTypeHierachy(java.io.InputStream, IProgressMonitor)
	 * @since 2.1
	 */
	public void store(OutputStream outputStream, IProgressMonitor monitor) throws JavaModelException {
		// does nothing
	}
	
	/**
	 * Collects types using the operation defined by the type collector, starting with this type.
	 * 
	 * @param type the starting type
	 * @param collector the definition of the operation to get types from a type
	 * @return the collected types
	 */
	protected IType[] collect(IType type, ITypeCollector collector) {

		List<IType> collectedTypes = new ArrayList<IType>();
		
		Stack<IHierarchyNode> processingStack = new Stack<IHierarchyNode>();
		processingStack.push(tree.get(type));
		
		while(! processingStack.isEmpty()) {
			IHierarchyNode processingNode = processingStack.pop();
			for(IType t : collector.getTypes(processingNode)) {
				IHierarchyNode node = tree.get(t);
				if (collector.collect(node)) {
					collectedTypes.add(t);
				}
				processingStack.push(node);
			}
		}
		return collectedTypes.toArray(EMPTY_TYPES_ARRAY);
	}
	
	/**
	 * Searches for a type using the operation defined by the type collector, starting with this type.
	 * 
	 * @param type the starting type
	 * @param collector the definition of the operation to get types from a type and to determine that
	 * the node was found.
	 * @return the node representing the type that was found, or null if it was not found.
	 */
	protected IHierarchyNode search(IType type, ITypeCollector collector) {

		Stack<IHierarchyNode> processingStack = new Stack<IHierarchyNode>();
		processingStack.push(tree.get(type));
		
		while(! processingStack.isEmpty()) {
			IHierarchyNode processingNode = processingStack.pop();
			for(IType t : collector.getTypes(processingNode)) {
				IHierarchyNode node = tree.get(t);
				if (collector.collect(node)) {
					return node;
				}
				processingStack.push(node);
			}
		}
		return null;
	}
	
	/**
	 * An abstract class for a "functional style" type collector
	 * 
	 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
	 */
	protected abstract class ITypeCollector {
		
		/**
		 * Given a node, return the types we have to collect
		 * 
		 * @param type
		 * @return
		 */
		public abstract IType[] getTypes(IHierarchyNode node);
	
		/**
		 * Checks if this node should be collected. Note that, while
		 * getTypes() return the types that should be further processed,
		 * this method should check if the node will be collected or not.
		 * On a search, this means that the node was found.
		 * 
		 * @param node
		 * @return
		 */
		public boolean collect(IHierarchyNode node) {
			return true;
		}
	}
}
