/*******************************************************************************
 * Copyright (c) 2010 Herman Lee.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Herman Lee - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.codeAssist;

import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.internal.corext.dom.NodeFinder;

public class FSMLCodeAssistUtil {
	public final static String[] supportedFrameworks = new String[]{"applet","struts","wpi","spring"};
	
	/**
	 * @param project
	 * @return
	 */
	public static List<IFile> findModelFile(IProject project) {
		return findModelFile(project,supportedFrameworks);
	}
	
	/**
	 * @param project
	 * @param frameworksToCheck
	 * @return
	 */
	public static List<IFile> findModelFile(IProject project,String[] frameworksToCheck) {
		int retryAttempt = 0;
		boolean foundFile = false;
		String modelFileNumbering=null;
		List<IFile> files = new Vector<IFile>();
		
		while (retryAttempt<10 ){
			for (int j = 0; j < frameworksToCheck.length; j++) {
				modelFileNumbering = (retryAttempt==0)?"":"_"+retryAttempt;
				IFile fsmlModelFile = ResourcesPlugin
				.getWorkspace()
				.getRoot()
				.getFile(
						project
								.getFullPath()
								.append(
										project
												.getName().toString()+modelFileNumbering
												+ "."+frameworksToCheck[j]));
				if (fsmlModelFile.exists()){
					files.add(fsmlModelFile);
					foundFile = true;
				}
			}
			if (foundFile){
				break;
			}
			retryAttempt++;
		}
		
		return files;
	}

	
	/**
	 * @param cu
	 * @param offset
	 * @param length
	 * @return
	 */
	public static ASTNode getCoveringNode(ICompilationUnit cu, int offset,int length){
		//TODO: cache the parsed cu
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		
		parser.setSource(cu);
		parser.setStatementsRecovery(true);
		parser.setResolveBindings(true);
		NodeFinder finder = new NodeFinder(offset, length);
		
		parser.createAST(null).accept(finder);
		return finder.getCoveringNode();
	}

}
