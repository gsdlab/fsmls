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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreterPlugin;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.ASTUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IHierarchicalCallGraphManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IIncrementalTypeHierarchy;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.IJavaASTManager;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.preferences.JavaPreferenceConstants;
import ca.uwaterloo.gsd.fsml.stats.Measurements;
import ca.uwaterloo.gsd.fsml.stats.Stats;

/**
 * A Hierarchical Call Graph Manager implements data structures and methods to keep track
 * of call graphs related only to types of the same hierarchy. When a type is added to the
 * manager, its whole hierarchy will be analyzed with respect to the method declarations and
 * the possible call sequences they entail. 
 * 
 * Note that although this manager deals with call graphs and is able to find the exact method
 * that will be called in a given context (i.e., it understands polymorphism), it does NOT deal 
 * with control flow. This means that if there is a path in a method declaration that calls another
 * method in the hierarchy, the declaring method is assumed to call that method in any path.
 * 
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class HierarchicalCallGraphManager implements IHierarchicalCallGraphManager {
	
	// some keys for performance measurements
	public static final String ADDING_KEY = "HierarchicalCallGraphManager.adding";
	public static final String QUERYING_KEY = "HierarchicalCallGraphManager.querying";
	// some flags
	protected boolean fullCallGraph = false;
	
	/**
	 * If true, the created call graph will also have links for polymorphic calls that
	 * go outside the hierarchy.
	 */
	public boolean fullCallGraph() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getString(JavaPreferenceConstants.CALL_GRAPH_TYPE_ID).equals(
				JavaPreferenceConstants.FULL_VALUE);
	}
	
	protected boolean preciseCallGraph = false;
	/**
	 * This Flag is just considered if FULL_CALL_GRAPH is true.
	 * 
	 * If true, it means that a link for a polymorphic call is created only if it is precise,
	 * i.e., only if there is a single possibility for the target method in the project.
	 */
	public boolean preciseCallGraph() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getString(JavaPreferenceConstants.CALL_GRAPH_TYPE_ID).equals(
				JavaPreferenceConstants.PRECISE_VALUE);
	}
	
	protected boolean callGraphScope = false;
	/**
	 * If true, the call graph will record method calls to a preconfigured set of methods during call graph creation.
	 */
	public boolean callGraphScope() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getString(JavaPreferenceConstants.METHOD_CALLS_SEARCH_SCOPE_ID).equals(
				JavaPreferenceConstants.CALL_GRAPH_VALUE);
	}
	
	/**
	 * For a given type, the list of methods it overrides from its super type
	 * TODO - this is currently not used, maybe could be removed
	 */
	//protected Map<IType, List<MethodTuple>> overrides = new HashMap<IType, List<MethodTuple>>();
	
	/**
	 * For a given type, the list of methods it inherits from super types
	 */
	protected Map<IType, List<IMethod>> inherits = new HashMap<IType, List<IMethod>>();
	
	/**
	 * For a given type, its implicit default constructor, if it exists
	 */
	protected Map<IType, IMethod> implicitConstructor = new HashMap<IType, IMethod>();
	
	/**
	 * For a given member, the list of anonymous types it declares
	 */
	protected Map<IMember, List<IType>> anonymousTypes = new HashMap<IMember, List<IType>>();
	
	/**
	 * The list of types that were already processed
	 */
	protected List<IType> processedTypes = new ArrayList<IType>();
	
	/**
	 * Responsible for keeping calls depending on context
	 */
	protected final ContextualCallsManager callsManager = new ContextualCallsManager(this);
	
	/**
	 * An Java AST Manager
	 */
	protected IJavaASTManager astManager = null;
	
	/**
	 * A visitor which is reusable across visits
	 */
	protected InvocationSearchVisitor visitor = null;
	
	/**
	 * Keep the set of binding errors found during visiting
	 */
	protected Set<String> errors = new HashSet<String>();
	
	/**
	 * Keeps track of the type hierarchy
	 */
	protected IIncrementalTypeHierarchy hierarchy = null;
	
	/**
	 * Creates a new graph manager that will use this AST manager
	 * 
	 * @param astManager
	 */
	public HierarchicalCallGraphManager(IJavaASTManager astManager, IIncrementalTypeHierarchy hierarchy) {
		this.astManager = astManager;
		this.hierarchy = hierarchy;
	}
	
	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init() {
		this.fullCallGraph = fullCallGraph();
		this.preciseCallGraph = preciseCallGraph();
		this.callGraphScope = callGraphScope();
		this.callsManager.init();
	}
	
	/**
	 * Clears all cached information in this manager
	 */
	public synchronized void finish() {
		for(String error : errors) {
			Stats.INSTANCE.logError("HierarchicalCallGraphManager: " + error);
		}
		errors.clear();
		
		this.finishMeasurements();
		
		//overrides.clear();
		inherits.clear();
		implicitConstructor.clear();
		anonymousTypes.clear();
		processedTypes.clear();
		callsManager.clear();
	}
	
	/**
	 * Prints results on performance measurements
	 */
	protected void finishMeasurements() {
		Stats.INSTANCE.printMessage("\nHierarchical Call Graph Statistics");
		Measurements.instance(ADDING_KEY).printAndReset("Adding Compilation Units : ");
		Measurements.instance(QUERYING_KEY).printAndReset("Querying Method Calls    : ");
		Stats.INSTANCE.printMessage("");
	}
	
	/**
	 * Gets the method that really is going to be executed at runtime if the target method
	 * is called in this context type.
	 * 
	 * This method will check if the target method was overridden somewhere in the hierarchy
	 * of the context. If the method was not overridden, target itself will be returned.
	 * Otherwise, the method that is available to objects of the context type will be returned.
	 * 
	 * The target method must be a method in the hierarchy of the context.
	 * 
	 * If the context is an interface, the single implementation of the target is returned.
	 * If multiple implementations exist, null is returned.
	 * 
	 * @param context the context type (the type of the object receiving the call)
	 * @param target the method that is being called (can be retrieved from the method binding)
	 * @return the available method, i.e., the method that will be actually executed at runtime
	 * (can be target itself) or null if the method could not be found.
	 */
	public synchronized IMethod getExecutingMethod(IType context, IMethod target) {
		try {
			// return itself, if the target is private or static
			if (Modifier.isStatic(target.getFlags()) ||
				Modifier.isPrivate(target.getFlags()) ||
				target.isConstructor()) {
				return target;
			}
			IType declaringType = target.getDeclaringType();
			for (IType superIType : hierarchy.getSupertypes(context))
				if (superIType.equals(declaringType))
					// tries to find the polymorphic method
					return this.findMethod(context, null, target);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Return the list of methods available in this type, i.e., the methods
	 * declared in this type plus the ones it inherits from super types.
	 * 
	 * Note that if you just want to check if a certain method is available in the
	 * type, you should use isMethodAvailable, which is much more efficient. 
	 * 
	 * This method will process the compilation unit of the type if necessary.
	 * 
	 * @param type the source type
	 * @return the list of available methods
	 * @throws JavaModelException if cannot list the methods of this type
	 */
	public synchronized List<IMethod> getAvailableMethods(IType type) throws JavaModelException {

		if (! this.processedTypes.contains(type)) {
			this.addCompilationUnit(JavaModelUtils.getTypeRoot(type));
		}
		
		List<IMethod> list = new ArrayList<IMethod>();
		list.addAll(Arrays.asList(type.getMethods()));
		list.addAll(inherits.get(type));
		return list;
	}
	
	/**
	 * Checks if the given method is available in the given type, i.e., if it is between
	 * the methods declared or inherited by the type. 
	 * 
	 * @param type the source type
	 * @param method the method to search for
	 * @return true, if the method is between the available methods, false otherwise.
	 * @throws JavaModelException
	 */
	public synchronized boolean isMethodAvailable(IType type, IMethod method) throws JavaModelException {
		
		for (IMethod m : type.getMethods()) {
			if (method.equals(m)) {
				return true;
			}
		}
		
		if (! this.processedTypes.contains(type)) {
			this.addCompilationUnit(JavaModelUtils.getTypeRoot(type));
		}
		return inherits.containsKey(type) && inherits.get(type).contains(method);
	}
	
	/**
	 * Checks if there is a path in the call graph between this caller and this callee.
	 * 
	 * This method will use the caller's declaring type as context
	 * 
	 * @param caller the method calling
	 * @param callee the method being called
	 * @return true if there is a possibility for callee being called from caller, false otherwise
	 */
	public synchronized boolean calls(IMethod caller, IMethod callee) {
		return calls(caller.getDeclaringType(), caller, callee);
	}
	
	/**
	 * Checks if there is a path in the call graph between this caller and this callee, having this
	 * type as a context.
	 * 
	 * @param context the context type
	 * @param caller the method calling
	 * @param callee the method being called
	 * @return true if there is a possibility for callee being called from caller, false otherwise
	 */
	public synchronized boolean calls(IType context, IMethod caller, IMethod callee) {
		return callsManager.calls(context, caller, callee);
	}
	
	/**
	 * Checks if there is a path in the call graph between any method in this context and the callee
	 * 
	 * @param context the context type
	 * @param callee the method being called
	 * @return true if there is a possibility for callee being called from caller, false otherwise
	 */
	public synchronized boolean calls(IType context, IMethod callee) {
		Measurements.instance(QUERYING_KEY).start();
		
		try {
			
			// check if some of the declared methods calls
			for(IMethod method : context.getMethods()) {
				if (calls(context, method, callee)) return true;
			}
			// maybe some of the inherited
			if (inherits.containsKey(context)) {
				for(IMethod method : inherits.get(context)) {
					if (calls(context, method, callee)) return true;
				}
			}
			// or even an implicit default constructor
			if (implicitConstructor.containsKey(context)) {
				if (calls(context, implicitConstructor.get(context), callee)) 
					return true;
			}
			// or also in some inner type
			for(IType nested : context.getTypes()) {
				if (! nested.isAnonymous() && ! Modifier.isStatic(nested.getFlags())) {
					if (calls(nested, callee)) {
						return true;
					}
				}
			}
			// TODO - check for anonymous types that are reachable too
			
		} catch (JavaModelException e) {
			e.printStackTrace();
		} finally {
			Measurements.instance(QUERYING_KEY).stop();
		}
		
		return false;
	}

	/**
	 * Checks if there is a path in the call graph between this caller and this callee.
	 * 
	 * If the caller is an IType, we search for all methods in the type (and inherited). If it
	 * is an IMethod, we search only for a connection between this method and the callee.
	 * 
	 * @param caller the method or type calling
	 * @param callee the method being called
	 * @return true if there is a possibility for callee being called from caller, false otherwise
	 */
	public synchronized boolean calls(IMember caller, IMethod callee) {
		if (caller instanceof IType) {
			return calls((IType) caller, callee);
		}
		if (caller instanceof IMethod) {
			return calls((IMethod) caller, callee);
		}
		return false;
	}
	
	/**
	 * Adds the compilation unit indicated by this type root to the manager.
	 * 
	 * The Type Root can be an ICompilationUnit or an IClassFile. In any case, this method
	 * will analyze the inheritance hierarchy of the class regarding the methods that are
	 * inherited, overridden, etc. A certain hierarchy will be analyzed only once and the 
	 * results will be cached (until a clear() is called in the manager).
	 * 
	 * @param root the compilation unit to be added
	 */
	public synchronized void addCompilationUnit(ITypeRoot root) {
		
		try {
			Measurements.instance(ADDING_KEY).start();
			
			IType primary = root.findPrimaryType();
			if (primary != null) {
				processTypeHierarchy(primary);
			}
		} finally {
			Measurements.instance(ADDING_KEY).stop();
		}
	}

	/**
	 * Gets a type hierarchy for this type and processes it regarding available methods.
	 * 
	 * This method will create a type hierarchy for the given type, will get its top type
	 * (Object) and will process this hierarchy top-down, analyzing for each type the 
	 * available methods (checking for inheritance and overridden methods). 
	 * 
	 * @param type the type whose hierarchy is going to be processed
	 */
	protected void  processTypeHierarchy(IType type) {
		if (type != null && ! processedTypes.contains(type)) {
			// check if it is a buggy anonymous
			if (hierarchy.contains(type) && hierarchy.getNode(type).isBuggyAnonymous()) {
				// TODO - for now, just ignore it
				return;
			}
			try {
				hierarchy.addSuperTypeHierarchy(type);
				processTypes(hierarchy.getBranch(type));

			} catch (JavaModelException e) {
				e.printStackTrace();
				Stats.INSTANCE.logError("HierarchicalCallGraphManager: Could not process type hierarchy for " + type.getElementName() + " : " + e.getMessage());
			}
		}
	}
	
	/**
	 * Process the hierarchies of this list of types
	 * 
	 * @param types
	 */
	protected void  processTypeHierarchies(List<IType> types) {
		for(IType type : types) {
			processTypeHierarchy(type);
		}
	}
	
	/**
	 * Processes the stack of types top-down
	 * 
	 * @param top
	 * @throws JavaModelException
	 */
	protected void processTypes(Stack<IType> types) throws JavaModelException {

		while(! types.isEmpty()) {
			IType type = types.pop();
		
			// process this type, if we didn't before
			if (! processedTypes.contains(type)) {
				processedTypes.add(type);
				processTypeMethods(type);
				
				// process the hierarchies of the nested types
				for(IType nestedType : type.getTypes()) {
					processTypeHierarchy(nestedType);
				}
			}
			// go to the next sub type...
		}
	}

	/**
	 * Processes the methods of this type (calculating inherited and overridden)
	 * 
	 * The idea is to calculate the following formulas:
	 * 
	 * super.available = super.declares (not private/static) + super.inherits
	 * this.inherits = super.available - overridden
	 * 
	 * @param type
	 * @throws JavaModelException
	 */
	protected void processTypeMethods(IType type) throws JavaModelException {
		
		IType sup = hierarchy.getSuperclass(type);
		if (sup != null) {
			// process methods declared by the super type
			for(IMethod method : sup.getMethods()) {
				processMethod(type, method);
			}
			// add the methods that the super type had inherited
			if (inherits.containsKey(sup)) {
				for(IMethod method : this.inherits.get(sup)) {
					processMethod(type, method);
				}
			}
		}
		// now visit the methods declared in the type
		visitType(type);
		// process anonymous types declared in the type
		processAnonymousTypes(type);
		// and resolve bindings of all available methods in this context
		resolveBindings(type);
	}
	
	/**
	 * Adds this method to the appropriate list for this type (if overridden or inherited)
	 * 
	 * @param type
	 * @param method
	 * @throws JavaModelException
	 */
	protected void processMethod(IType type, IMethod method) throws JavaModelException {
		// static, private and constructors are discarded
		if (Modifier.isStatic(method.getFlags()) ||
			Modifier.isPrivate(method.getFlags()) ||
			method.isConstructor()) {
			return;
		}
		if (type.findMethods(method) != null) {
			// TODO overrides
			//getOverrides(type).add(new MethodTuple(type.findMethods(method)[0], method));
		} else {
			// inherits
			getInherits(type).add(method);
		}
	}
	
	/**
	 * Visits all methods that are available in this type, which include declared,
	 * inherited and implicit constructors. For each of these methods, this method
	 * constructs the AST and parses to check for method calls. The method calls
	 * that are found are informed to the Contexts manager.
	 * 
	 * Note that binary types are not visited and that this method recursively visits
	 * the sub types found in the type hierarchy.
	 * 
	 * @param type
	 * @throws JavaModelException
	 */
	protected void visitType(IType type) throws JavaModelException {
		
		if (type == null) return;
		
		// we cannot visit binary types without sources
		if (type.isStructureKnown()) {

			// visit this type, looking for method calls
			CompilationUnit unit = astManager.getCompilationUnit(type);
			for (IMethod method : type.getMethods()) {
				// this guarantees the method really exists in source
				if (JavaModelUtils.hasSourceRange(method)) {
					
					InvocationSearchVisitor v = getVisitor(type, method);
					if (! type.isAnonymous())
						visitor.b = ASTUtils.getTypeDeclarationNode(type, unit).resolveBinding();
					MethodDeclaration decl = ASTUtils.getMethodDeclarationNode(method, unit);
					decl.accept(v);
					checkConstructorCall(decl, callsManager, type, method);
				}
			}
			
			// and make sure this type calls a super constructor if needed
			if (JavaModelUtils.hasImplicitDefaultConstructor(type)) {
				IMethod constructor = 
					JavaModelUtils.getConcreteDefaultConstructor(hierarchy, type);
				if (constructor != null) {
					implicitConstructor.put(type, constructor);
				}
			}
		}
	}
	
	/**
	 * Checks if the constructor call:
	 *   1) is a constructor (does nothing if not)
	 *   2) has a call to another constructor (does nothing if yes)
	 *   
	 *   If this constructor does NOT call another constructor, we search for the default
	 *   constructor that should be called and add this call to the contexts manager.
	 *   
	 * @param decl
	 * @param contexts
	 * @param type
	 * @param constructor
	 * @throws JavaModelException
	 */
	protected void checkConstructorCall(
			MethodDeclaration decl, 
			ContextualCallsManager contexts, 
			IType type, 
			IMethod constructor) throws JavaModelException {

		if (! constructor.isConstructor()) return;
		
		Statement st = ASTUtils.getFirstStatement(decl);
		
		if (st == null || 
			! (st instanceof SuperConstructorInvocation) &&	st instanceof ConstructorInvocation) {
		
			IMethod concrete = 
				JavaModelUtils.getConcreteDefaultConstructor(hierarchy, hierarchy.getSuperclass(type));
			
			if (concrete != null)
				contexts.addStaticCall(constructor, concrete);
		}
	}
	
	protected void processAnonymousTypes(IType type) throws JavaModelException {

		if (hierarchy.getNode(type).hasAnonymousType()) {
			for (IMethod method : type.getMethods()) {
				if (anonymousTypes.containsKey(method)) {
					processTypeHierarchies(anonymousTypes.get(method));
				}
			}
		}
	}
	
	/**
	 * Resolve the bindings for method calls performed by this type.
	 * 
	 * This method will use this type as context and will try to resolve the bindings
	 * for method calls performed by methods declared and inherited by this type.
	 * 
	 * @param type
	 * @throws JavaModelException
	 */
	protected void resolveBindings(IType type) throws JavaModelException {
		
		// first the methods declared in the type
		for (IMethod method : type.getMethods()) {
			if (callsManager.hasBindings(method)) {
				resolveBindings(type, method);
			}
		}
		
		// then the methods it inherited
		if (inherits.containsKey(type)) {
			for (IMethod method : getInherits(type)) {
				if (callsManager.hasBindings(method)) {
					resolveBindings(type, method);
				}
			}
		}
	}
	
	/**
	 * Resolve the bindings of polymorphic calls made by this caller, now using this context type.
	 * 
	 * The bindings that can be resolved are going to be reported to the contexts manager. 
	 * 
	 * @param context
	 * @param caller
	 */
	public void resolveBindings(IType context, IMethod caller) {

		for(IMethodBinding binding : callsManager.getBindings(caller)) {
			IMethod target = findMethod(context, caller, binding);
			if (target != null)
				callsManager.addCall(context, caller, target);
			else
				Stats.INSTANCE.logError("HierarchicalCallGraphManager: Could not resolve " + binding.getName() + " in the context " + context.getFullyQualifiedName());
		}
	}
	
	/**
	 * Helper method that gets the IMethod from the binding and calls findMethod with it. 
	 * 
	 * @param context
	 * @param caller
	 * @param binding
	 * @return
	 */
	protected IMethod findMethod(IType context, IMethod caller, IMethodBinding binding) {
		if(context == null || binding == null) return null;
		try {
			return findMethod(context, caller, (IMethod) binding.getJavaElement());
		} catch (JavaModelException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * In the given context, find the IMethod that corresponds to the target.
	 * 
	 * In the context, the target IMethod could have been overridden by another
	 * method. So we search for the methods declared in the context for methods
	 * that override target. 
	 * 
	 * If not found, we search for the inherited methods.
	 * 
	 * Also, there is the case when the target method is actually a private 
	 * method in the context of the caller (when the caller gets inherited by
	 * the context and calls a private method). So we also search in the context 
	 * of the caller's context
	 * 
	 * @param context
	 * @param caller
	 * @param target
	 * @return the real IMethod that corresponds to target in this context, or null
	 * if not found.
	 */
	protected IMethod findMethod(IType context, IMethod caller, IMethod target) throws JavaModelException {
		
		//// FIRST look in the same hierarchy
		//// Note that even "private in the caller context" has precedence over outer types!
		// check if it was declared in the context
		for (IMethod method : context.getMethods()) {
			if (method.isSimilar(target)) return method;
		}
		
		// check if it was inherited by the context
		if (inherits.containsKey(context)) {
			for (IMethod method : getInherits(context)) {
				if (method.isSimilar(target)) return method;
			}
		}
		
		// check if it was private to the caller context
		if (caller != null) {
			IType callerContext = caller.getDeclaringType();
			if (! callerContext.getTypeQualifiedName().equals(context.getTypeQualifiedName())) {
				for (IMethod method : callerContext.getMethods()) {
					if (Modifier.isPrivate(method.getFlags()) && method.isSimilar(target))
						return method;
				}
			}
		}
		
		//// SECOND start looking for outer types
		// check if there is an outer type 
		IType outer = hierarchy.getNode(context).getDeclaringType();
		//IType outer = JavaModelUtils.getDeclaringType(context);
		if (outer != null && ! outer.equals(context)) {
			IMethod method = findMethod(outer, caller, target);
			if (method != null) {
				return method;
			}
		}
		// either we have a problem in the implementation, or somebody is asking for a method call
		// whose target is outside the hierarchy
		/*
		String name = context.getElementName();
		if (context.isAnonymous()) 
			name = context.getFullyQualifiedName();
		Stats.INSTANCE.logError(
				"HierarchicalCallGraph.findMethod() could not determine an available method for " +
				target.getElementName() + " in the context " + name);
				*/
		return null;
	}

	/**
	 * Finds the possible implementations of this method (which was found on this type) on the hierarchy
	 * of this type.
	 * 
	 * If the method is an actual implementation of itself (i.e., if it is not abstract or
	 * inside an interface), then it will also be returned in the list.
	 * 
	 * @param type
	 * @param method
	 * @return
	 */
	public List<IMethod> findImplementations(IType type, IMethod method) {
		
		List<IMethod> methods = new ArrayList<IMethod>();
		
		if(type == null || method == null) return methods;
		
		List<IType> types = new ArrayList<IType>();
		types.add(type);
		types.addAll(Arrays.asList(hierarchy.getExhaustiveSubclasses(type)));
		
		for (IType subType : types) {
			try {
				// no implementations in interfaces
				if (subType.isInterface()) continue;
				
				IMethod impl = findMethod(subType, null, method);
				if (impl != null && ! Modifier.isAbstract(impl.getFlags()) && ! methods.contains(impl)) {
					methods.add(impl);
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		//Stats.INSTANCE.printMessage("Found " + methods.size() + " implementations of " + method + " : " + methods);
		return methods;
	}
	
	/**
	 * Gets a visitor already configured with this context and caller
	 * 
	 * @param context
	 * @param caller
	 * @return
	 */
	protected InvocationSearchVisitor getVisitor(IType context, IMethod caller) {
		getVisitor().configure(context, caller);
		return visitor;
	}
	
	/**
	 * Gets a visitor, creating if needed
	 * 
	 * @return
	 */
	protected InvocationSearchVisitor getVisitor() {
		if (visitor == null) {
			visitor = new InvocationSearchVisitor(callsManager);	
		}
		return visitor;
	}
	
	/**
	 * Gets the list of inherited methods for this type, creating 
	 * the list if needed.
	 * 
	 * @param type
	 * @return
	 */
	protected List<IMethod> getInherits(IType type) {
		if (! inherits.containsKey(type)) {
			inherits.put(type, new ArrayList<IMethod>());
		}
		return inherits.get(type);
	}
	
	/**
	 * Gets the list of overridden methods for this type, creating
	 * the list if needed.
	 * 
	 * @param type
	 * @return
	 */
	/* TODO - OVERRIDES!
	protected List<MethodTuple> getOverrides(IType type) {
		if (! overrides.containsKey(type)) {
			overrides.put(type, new ArrayList<MethodTuple>());
		}
		return overrides.get(type);
	}*/
	
	/**
	 * Gets the list of anonymous types declared in this method,
	 * creating the list if needed.
	 * 
	 * @param method
	 * @return
	 */
	protected List<IType> getAnonymousTypes(IMethod method) {
		if (! anonymousTypes.containsKey(method)) {
			anonymousTypes.put(method, new ArrayList<IType>());
		}
		return anonymousTypes.get(method);
	}

	/**
	 * This visitor searches the AST for method calls.
	 * 
	 * The method calls can be:
	 * 
	 *  - super method invocation : super.m();
	 *  - super constructor invocation : super();
	 *  - constructor invocation : this();
	 *  - method invocation : m();
	 *  
	 *  The invocations found are reported to the Contexts manager.
	 *  
	 *  Note that method invocations are only dealt with when they are "this", i.e.,
	 *  the target is a method in the hierarchy of the declaring type.
	 *
	 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
	 */
	public class InvocationSearchVisitor extends ASTVisitor {
		
		protected ContextualCallsManager contexts = null;
		
		protected IType contextType = null;
		protected IMethod caller = null;
		protected ITypeBinding b = null;
		
		public InvocationSearchVisitor(ContextualCallsManager contexts) {
			this.contexts = contexts;
		}
		
		/**
		 * Configures the visitor for a new visit, reseting the dynamic calls flag
		 * 
		 * @param context
		 * @param caller
		 */
		public void configure(IType context, IMethod caller) {
			this.contextType = context;
			this.caller = caller;
		}
		
		/**
		 * Visits an instance creation, adding to the context
		 */
		public boolean visit(ClassInstanceCreation node) {

			IMethodBinding binding = node.resolveConstructorBinding();

			if (binding != null) {
				
				IMethod target = (IMethod) binding.getJavaElement();
				if (target == null) {	
					// maybe we already know its implicit constructor
					IType targetType = (IType) binding.getDeclaringClass().getJavaElement();
					target = implicitConstructor.get(targetType);
					if (target == null) {
						// maybe not... need to resolve it
						target = 
							JavaModelUtils.getConcreteDefaultConstructor(hierarchy, targetType);
					}
				}
				if (target != null)
					contexts.addStaticCall(caller, target);
			} else
				errors.add(
						"Could not resolve instance creation for " + 
						contextType.getElementName() + "-> new " + node.getExpression() + "(...)");

			return true;
		}
		
		/**
		 * Visits the super method invocation, adding to the context
		 */
		public boolean visit(SuperMethodInvocation node) {

			IMethodBinding binding = node.resolveMethodBinding();
			if (binding != null)
				contexts.addStaticCall(caller, (IMethod) binding.getJavaElement());
			 else
				errors.add(
						"Could not resolve super method binding for " + 
						contextType.getElementName() + "-> super." + node.getName() + "(...)");

			return true;
		}
		
		/**
		 * Visits the super constructor invocation, adding to the context
		 */
		public boolean visit(SuperConstructorInvocation node) {
			IMethodBinding binding = node.resolveConstructorBinding();
			if (binding != null)
				contexts.addStaticCall(caller, (IMethod) binding.getJavaElement());
			 else
				 errors.add(
						"Could not resolve super constructor binding for " + 
						contextType.getElementName() + "-> super(..)");

			return true;
		}
		
		/**
		 * Visits the constructor invocation, adding to the context
		 */
		public boolean visit(ConstructorInvocation node) {
			IMethodBinding binding = node.resolveConstructorBinding();
			if (binding != null)
				contexts.addStaticCall(caller, (IMethod) binding.getJavaElement());
			 else
				 errors.add(
						"Could not resolve constructor binding for " + 
						contextType.getElementName() + "-> new " + node.toString() + "(..)");
			
			return true;
		}
		
		/**
		 * Visits the method invocation, adding to the context if it is "this"
		 */
		public boolean visit(MethodInvocation node) {

			IMethodBinding binding = node.resolveMethodBinding();
			if (binding != null) {
				if (callGraphScope) {
					// Michal: related to the experimental callGraph scope
					// add to the target method calls list
					IMethod iMethod = (IMethod) binding.getJavaElement();
					List<Expression> calls = targetCalls.get(iMethod);
					if (calls != null) 
						calls.add(node);
				}
				// static and final invocations are always bound correctly
				if (
					Modifier.isStatic(binding.getModifiers()) ||
					Modifier.isFinal(binding.getModifiers()) ||
					Modifier.isFinal(binding.getDeclaringClass().getModifiers())) {
					contexts.addStaticCall(caller, (IMethod) binding.getJavaElement());
				} else {
					// check if it is a "this" call
					Expression s = node.getExpression();
					if (s == null || s instanceof ThisExpression) {
						contexts.addBinding(caller, binding);
					} else {
						if (fullCallGraph || preciseCallGraph) {
							List<IMethod> implementations =	findImplementations(
									(IType) binding.getDeclaringClass().getJavaElement(),
									(IMethod) binding.getJavaElement());
							
							if (! preciseCallGraph || implementations.size() == 1) {
								for(IMethod implementation : implementations) {
									// add static links to all possible implementations
									contexts.addStaticCall(caller, implementation);
								}
							}
						}
					}
				}
			} else {
				String expr = node.getExpression() != null ? node.getExpression().toString() : "this";
				errors.add(
						"Could not resolve method binding for " +
						contextType.getElementName() + "-> " + expr + "." + node.getName() + "(...)");
			}
			return false;
		}
		
		/**
		 * Don't go internally on anonymous classes since they cause problems
		 * to the analysis (eg., methods inside those classes should have a different
		 * context than the context in this visitor)
		 */
		public boolean visit(AnonymousClassDeclaration node) {
			
			ITypeBinding binding = node.resolveBinding();

			if (binding != null) {
				
				IType anonymous = (IType) binding.getJavaElement();

				try {
					hierarchy.addSuperTypeHierarchy(anonymous);
					getAnonymousTypes(caller).add(anonymous);
					
				} catch (JavaModelException e) {
					errors.add("Found buggy anonymous type at : " + caller);
					try {
						hierarchy.addBuggyAnonymousType(
							anonymous, binding.getSuperclass(), binding.getInterfaces());
					} catch (JavaModelException e2) {
						e2.printStackTrace();
					}
				}

				hierarchy.addAnonymousType(contextType, anonymous);
			} else {
				errors.add("Could not resolve type binding for anonymous class in " +
						contextType.getElementName() + "." + caller.getElementName() + "(...)");
			}
			return false;
		}
		
		/**
		 * Never visit nested types
		 */
		public boolean visit(TypeDeclaration node) {
			return false;
		}
	}
	HashMap<IMethod, List<Expression>> targetCalls;
	
	/**
	 * Michal: related to the experimental 'callGraph' search scope
	 * This method should be called before the analysis starts to set the methods for which method calls will be recorded.
	 * @param targetMethods
	 */
	public void setTargetMethods(Collection<IMethod> targetMethods) {
		targetCalls = new HashMap<IMethod, List<Expression>>();
		for (IMethod method : targetMethods) {
			targetCalls.put(method, new LinkedList<Expression>());
		}
	}
	/**
	 * Michal: related to the experimental 'callGraph' search scope
	 * @param targetMethod
	 * @return method invocations of the given target method reachable in the call graph.
	 */
	public List<Expression> getCalls(IMethod targetIMethod, IType contextIType) {
		if (targetCalls != null) 
			return targetCalls.get(targetIMethod);
		return null;
	}
}
