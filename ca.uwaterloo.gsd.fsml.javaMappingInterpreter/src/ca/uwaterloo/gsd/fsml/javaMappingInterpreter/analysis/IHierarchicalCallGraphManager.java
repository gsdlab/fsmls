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

import java.util.Collection;
import java.util.List;

import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.Expression;

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
public interface IHierarchicalCallGraphManager {

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
	public void addCompilationUnit(ITypeRoot root);
	
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
	 * @param context the context type (the type of the object receiving the call)
	 * @param target the method that is being called (can be retrieved from the method binding)
	 * @return the available method, i.e., the method that will be actually executed at runtime
	 * (can be target itself) or null if the method could not be found. 
	 */
	public IMethod getExecutingMethod(IType context, IMethod target);
	
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
	public List<IMethod> getAvailableMethods(IType type) throws JavaModelException;
	
	/**
	 * Checks if the given method is available in the given type, i.e., if it is between
	 * the methods declared or inherited by the type. 
	 * 
	 * @param type the source type
	 * @param method the method to search for
	 * @return true, if the method is between the available methods, false otherwise.
	 * @throws JavaModelException
	 */
	public boolean isMethodAvailable(IType type, IMethod method) throws JavaModelException;
	
	/**
	 * Checks if there is a path in the call graph between this caller and this callee.
	 * 
	 * This method will use the caller's declaring type as context
	 * 
	 * @param caller the method calling
	 * @param callee the method being called
	 * @return true if there is a possibility for callee being called from caller, false otherwise
	 */
	public boolean calls(IMethod caller, IMethod callee);
	
	/**
	 * Checks if there is a path in the call graph between this caller and this callee, having this
	 * type as a context.
	 * 
	 * @param context the context type
	 * @param caller the method calling
	 * @param callee the method being called
	 * @return true if there is a possibility for callee being called from caller, false otherwise
	 */
	public boolean calls(IType context, IMethod caller, IMethod callee);
	
	/**
	 * Checks if there is a path in the call graph between any method in this context and the callee
	 * 
	 * @param context the context type
	 * @param callee the method being called
	 * @return true if there is a possibility for callee being called from caller, false otherwise
	 */
	public boolean calls(IType context, IMethod callee);
	
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
	public boolean calls(IMember caller, IMethod callee);
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
	public List<IMethod> findImplementations(IType type, IMethod method);
	
	/**
	 * Called before starting the analysis, so that the manager has a chance to initialize
	 */
	public void init();
	
	/**
	 * Clears all cached information in this manager
	 */
	public void finish();

	/**
	 * Michal: related to the experimental 'callGraph' search scope
	 * This method should be called before the analysis starts to set the methods for which method calls will be recorded.
	 * @param targetMethods
	 */
	public void setTargetMethods(Collection<IMethod> targetMethods);
	/**
	 * Michal: related to the experimental 'callGraph' search scope
	 * @param targetMethod
	 * @return method invocations of the given target method reachable in the call graph.
	 */
	public List<Expression> getCalls(IMethod targetIMethod, IType contextIType);
}
