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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.IMethodBinding;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreterPlugin;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.JavaModelUtils;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.preferences.JavaPreferenceConstants;
import ca.uwaterloo.gsd.fsml.stats.Stats;

/**
 * Keeps track of the method calls that may happen for a given context (a type).
 * 
 * This class is a manager for information regarding a type. Its interface defines
 * methods to add relationships between methods, like "in type A (the context), method
 * m directly calls method n and method n directly calls method q". Later, information 
 * can be retrieved making questions such as "given a context A, can m reach q"? The 
 * class is equipped with methods that recursively search for the connection m-n-q. 
 * 
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class ContextualCallsManager {

	/**
	 * Should the manager "learn" partial (true) results to calls()?
	 */
	public static final boolean CACHE = true;
	
	/**
	 * Should the manager "learn" partial (false) results to calls()?
	 */
	public static final boolean NEGATIVE_CACHE = true;
	
	/**
	 * Prints the trace of matched "calls" questions, i.e., the path in the call graph that lead to the match
	 */
	public static boolean printMatchedCallsTrace() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getBoolean(JavaPreferenceConstants.PRINT_MATCHED_CALLS_TRACE_ID);
	}
	
	/**
	 * Prints the trace of matched "calls" questions, i.e., the path in the call graph that lead to the match.
	 * Note that if CACHE == true it will just work the first time, then we will "learn" that a path exists. It is
	 * then recommended to use at least "1" as minimum path.
	 */
	public static int matchedCallsTraceLength() {
		return JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore().getInt(JavaPreferenceConstants.MATCHED_CALLS_TRACE_LENGTH_ID);
	}
	
	/**
	 * To speed up during a single call
	 */
	public boolean printMatchedCallsTrace = false;
	public int matchedCallsTraceLength = 1;
	
	/**
	 * Maps a given context (type) to another map that links a given method to the list of other
	 * methods it directly calls.
	 */
	protected Map<IType, ContextInfo> contexts = new HashMap<IType, ContextInfo>();
	
	/**
	 * Given a method, the list of bindings to the methods called by it (polymorphic calls).
	 */
	protected Map<IMethod, List<IMethodBinding>> bindings = new HashMap<IMethod, List<IMethodBinding>>();
	
	/**
	 * For a given method, keeps a list of the methods that it statically calls (including super calls)
	 */
	protected Map<IMethod, List<IMethod>> staticCalls = new HashMap<IMethod, List<IMethod>>();
	
	/**
	 * List of methods being processed while searching the graph
	 */
	protected List<IMethod> processingMethods = new ArrayList<IMethod>();
	
	/**
	 * A stack that keeps track of the path in the call graph that matched a certain call
	 */
	protected List<IMethod> callStack = new ArrayList<IMethod>();
	
	/**
	 * The call graph using this manager
	 */
	protected HierarchicalCallGraphManager callGraph = null;
	
	/**
	 * Creates a new contextual calls manager
	 * 
	 * @param callGraph
	 */
	public ContextualCallsManager(HierarchicalCallGraphManager callGraph) {
		this.callGraph = callGraph;
	}
	
	/**
	 * Adds the information that in this context, this caller directly calls the callee.
	 * 
	 * @param context
	 * @param caller
	 * @param callee
	 */
	public void addCall(IType context, IMethod caller, IMethod callee) {
		getMethodInfo(context, caller).addCall(callee);
	}
	
	/**
	 * Adds the information that whenever we reach this caller (independently of context), it makes a 
	 * static call to the callee. The static call can really be a static method or a call to super.x(); 
	 * 
	 * 
	 * @param caller
	 * @param callee
	 */
	public void addStaticCall(IMethod caller, IMethod callee) {
		List<IMethod> targets = getStaticTargets(caller);
		if (! targets.contains(callee)) {
			targets.add(callee);
		}
	}
	
	/**
	 * Registers the information that this method calls the method pointed by this binding.
	 * 
	 * @param caller
	 * @param binding
	 */
	public void addBinding(IMethod caller, IMethodBinding binding) {
		List<IMethodBinding> bindings = getBindings(caller);
		if (! bindings.contains(binding)) {
			bindings.add(binding);
		}
	}
	
	/**
	 * Checks if there are bindings registered for this method.
	 * 
	 * @param caller
	 * @return
	 */
	public boolean hasBindings(IMethod caller) {
		return bindings.containsKey(caller);
	}
	
	/**
	 * Gets the list of bindings for this method, creating if needed.
	 * 
	 * @param caller
	 * @return
	 */
	public List<IMethodBinding> getBindings(IMethod caller) {

		List<IMethodBinding> targets = bindings.get(caller);
		if (targets == null) {
			targets = new ArrayList<IMethodBinding>(1);
			bindings.put(caller, targets);
		}
		return targets;
	}
		
	/**
	 * Gets the list of static targets (callees) of this caller, creating
	 * if needed.
	 * 
	 * @param caller
	 * @return
	 */
	protected List<IMethod> getStaticTargets(IMethod caller) {
		
		List<IMethod> targets = staticCalls.get(caller);
		if (targets == null) {
			targets = new ArrayList<IMethod>(1);
			staticCalls.put(caller, targets);
		}
		return targets;
	}

	/**
	 * Gets the method info for this method in this context. This method
	 * should be used if you want to add something to the method info. To
	 * only check if it exists, use hasMethodInfo(context, method)
	 * 
	 * @param context
	 * @param method
	 * @return
	 */
	protected MethodInfo getMethodInfo(IType context, IMethod method) {
		if (! contexts.containsKey(context)) {
			contexts.put(context, new ContextInfo());
		}
		return contexts.get(context).getMethodInfo(method);
	}
	
	/**
	 * Checks if this method, in this context, has non calls
	 * 
	 * @param context
	 * @param method
	 * @return
	 */
	protected boolean hasNonCalls(IType context, IMethod method) {
		return
			contexts.containsKey(context) &&
			contexts.get(context).hasMethodInfo(method) &&
			contexts.get(context).getMethodInfo(method).hasNonCalls();
	}
	
	/**
	 * Checks if this method, in this context, has calls
	 * 
	 * @param context
	 * @param method
	 * @return
	 */
	protected boolean hasCalls(IType context, IMethod method) {
		return
			contexts.containsKey(context) &&
			contexts.get(context).hasMethodInfo(method) &&
			contexts.get(context).getMethodInfo(method).hasCalls();
	}
	
	/**
	 * Gets the non calls for this method, in this context
	 * 
	 * @param context
	 * @param method
	 * @return
	 */
	protected List<IMethod> getNonCalls(IType context, IMethod method) {
		return getMethodInfo(context, method).getNonCalls();
	}
	
	/**
	 * Gets the calls for this method, in this context
	 * 
	 * @param context
	 * @param method
	 * @return
	 */
	protected List<IMethod> getCalls(IType context, IMethod method) {
		return getMethodInfo(context, method).getCalls();
	}
	
	/**
	 * Initializes the calls manager
	 */
	public void init() {
		printMatchedCallsTrace = printMatchedCallsTrace();
		matchedCallsTraceLength = matchedCallsTraceLength();
	}
	
	/**
	 * Checks if there is a path between this caller and this callee in the graph, using this
	 * context.
	 * 
	 * @param context
	 * @param caller
	 * @param callee
	 * @return
	 */
	public boolean calls(IType context, IMethod caller, IMethod callee) {
		
		try {
			
			return internalCalls(context, caller, callee);
		} finally {
			if (printMatchedCallsTrace && callStack.size() >= matchedCallsTraceLength) { 
				printStack(caller, callee);
			}
			callStack.clear();
			processingMethods.clear();
		}	
	}
	
	/**
	 * Recursively search for a path between the caller and this callee, having this
	 * context as the type of the object.
	 * 
	 * This method will use the processing methods list to keep track of callers that
	 * have been already processed, so that we don't get into an infinite loop.
	 * 
	 * @param context
	 * @param caller
	 * @param callee
	 * @return
	 */
	protected boolean internalCalls(IType context, IMethod caller, IMethod callee) {
		
		// check for the cache
		if (NEGATIVE_CACHE && hasNonCalls(context, caller) && getNonCalls(context, caller).contains(callee)) {
			Stats.INSTANCE.logMessage("Used negative cache!");
			return false;
		}
		
		// in case we are searching for ourselves
		if (caller.equals(callee)) {
			return true;
		}
		
		// already processed
		if (processingMethods.contains(caller) || ! contexts.containsKey(context)) {
			if (NEGATIVE_CACHE) getMethodInfo(context, caller).addNonCall(callee);
			return false;
		}

		processingMethods.add(caller);
		
		// makes sure that all bindings are resolved for this caller in this context
		// this is needed because we must resolve bindings of overridden methods in a new context
		// (if they were called by super.m() for example)
		ContextInfo info = contexts.get(context);
		if (bindings.containsKey(caller) && ! info.hasMethodInfo(caller)) {
			callGraph.resolveBindings(context, caller);
		}
		
		// search for a regular call
		if (info.hasMethodInfo(caller) &&  info.getMethodInfo(caller).calls(callee)) {
			if (printMatchedCallsTrace) { callStack.add(caller); }
			return true;			
		}
		
		// search for a static call
		if (staticCalls.containsKey(caller) && getStaticTargets(caller).contains(callee)) {
			if (printMatchedCallsTrace) { callStack.add(caller); }
			return true;
		}
		
		// must recursively search
		if (staticCalls.containsKey(caller) && 
			iterateInternalCalls(getStaticTargets(caller), null, caller, callee))
			return true;
			
		if (hasCalls(context, caller) &&
			iterateInternalCalls(getCalls(context, caller), context, caller, callee))
			return true;
		
		// learn it
		if (NEGATIVE_CACHE) info.getMethodInfo(caller).addNonCall(callee);
		return false;
	}
	
	/**
	 * Helper method that iterates the internal calls query over the methods in the list, returning true if found.
	 * 
	 * Note that dynamic calls are only the ones in the same hierarchy of the context. If there is a call to a method
	 * outside the hierarchy, it MUST be a static call, i.e., it can be i) a static method call, ii) a constructor call
	 * or iii) a polymorphic method call that was marked here as a static link to another method.
	 * Therefore, if we are dealing with static calls, the context parameter must be NULL, and we iterate using the target
	 * type as the new context. 
	 * 
	 * 
	 * @param list
	 * @param context
	 * @param caller
	 * @param callee
	 * @return
	 */
	protected boolean iterateInternalCalls(List<IMethod> list, IType context, IMethod caller, IMethod callee) {

		IType typeContext = context;
		for(IMethod target : list) {
			// if context is null, the context will be the target class
			if (context == null) {
				try {
					typeContext = JavaModelUtils.getDeclaringType(target);
				} catch (JavaModelException e) {
					e.printStackTrace();
					continue;
				}
			}
			if (internalCalls(typeContext, target, callee)) {
				// also learn partials
				if (CACHE) getMethodInfo(context, caller).addCall(callee);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Prints the stack of calls that make the path between this caller and the callee
	 * 
	 * @param caller
	 * @param callee
	 */
	protected void printStack(IMethod caller, IMethod callee) {
		// Remove the case where the only caller in the stack is this caller here
		if (callStack.size() == 1 && callStack.contains(caller)) {
			return;
		}
		// String Buffer are MUCH faster than "adding" strings
		StringBuffer buf = new StringBuffer();
		buf.append("Trace from ");
		buf.append(JavaModelUtils.formatMethod(caller));
		buf.append(" to ");
		buf.append(JavaModelUtils.formatMethod(callee));
		buf.append("\n");
		for(IMethod method : callStack) {
			if (! method.equals(caller)) {
				buf.append("  ");
				buf.append(JavaModelUtils.formatMethod(method));
				buf.append("\n");
			}
		}
		Stats.INSTANCE.logMessage(buf.toString());
	}
	
	/**
	 * Removes all information in this object
	 */
	public void clear() {
		contexts.clear();
		bindings.clear();
		processingMethods.clear();
		staticCalls.clear();
	}
	
	/**
	 * Keeps method information for a certain context.
	 *  
	 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
	 */
	protected class ContextInfo {
		/**
		 * The methodInfos for a certain method
		 */
		protected Map<IMethod, MethodInfo> methodInfos = new HashMap<IMethod, MethodInfo>();
		
		/**
		 * Gets the method info for this method, creating if needed.
		 * 
		 * If the intent is to check if there is method infor for a certain method,
		 * it is more efficient to use hasMethodInfo instead
		 * 
		 * @param method
		 * @return
		 */
		public MethodInfo getMethodInfo(IMethod method) {
			if (! methodInfos.containsKey(method)) {
				methodInfos.put(method, new MethodInfo());
			}
			return methodInfos.get(method);
		}
		
		/**
		 * Checks if the method info for this method exists.
		 * 
		 * @param method
		 * @return
		 */
		public boolean hasMethodInfo(IMethod method) {
			return methodInfos.containsKey(method);
		}
	}
	
	/**
	 * Keeps method call and non call information for a certain method.
	 *  
	 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
	 */
	protected class MethodInfo {
		
		/**
		 * The set of calls made by this method
		 */
		protected List<IMethod> calls = null;
		
		/**
		 * The set of methods we know for sure this method does not call
		 */
		protected List<IMethod> nonCalls = null;
		
		/**
		 * Adds a new call to the list of calls, creating the list if needed.
		 * 
		 * @param call
		 */
		public void addCall(IMethod call) {
			if (calls == null) {
				calls = new ArrayList<IMethod>(5);
			}
			if (! calls.contains(call))
				calls.add(call);
		}
		
		/**
		 * Adds a new Non Call to the list of non calls, creating the list of needed
		 * 
		 * @param nonCall
		 */
		public void addNonCall(IMethod nonCall) {
			if (nonCalls == null) {
				nonCalls = new ArrayList<IMethod>(5);
			}
			if (! nonCalls.contains(nonCall))
				nonCalls.add(nonCall);
		}
		
		/**
		 * Checks if this method calls this callee
		 * 
		 * @param method
		 * @return
		 */
		public boolean calls(IMethod callee) {
			return
				calls != null &&
				calls.contains(callee);
		}
		
		/**
		 * Checks if we know that this method does not call this callee
		 * 
		 * @param callee
		 * @return
		 */
		public boolean doesNotCall(IMethod callee) {
			return
				nonCalls != null &&
				nonCalls.contains(callee);
		}
		
		/**
		 * Checks if we have information about calls
		 * 
		 * @return
		 */
		public boolean hasCalls() {
			return calls != null;
		}
		
		/**
		 * Checks if we have information about non calls
		 * 
		 * @return
		 */
		public boolean hasNonCalls() {
			return nonCalls != null;
		}

		/**
		 * Gets the set of calls
		 * 
		 * @return
		 */
		public List<IMethod> getCalls() {
			return calls;
		}
		
		/**
		 * Gets the set of non calls
		 * 
		 * @return
		 */
		public List<IMethod> getNonCalls() {
			return nonCalls;
		}
	}
}
