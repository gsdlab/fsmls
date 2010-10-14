/*******************************************************************************
 * Copyright (c) 2010 Michal Antkiewicz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Michal Antkiewicz - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.struts.code.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.ui.FsmlAnalysisWizard;
import ca.uwaterloo.gsd.fsml.xmlMappingInterpreter.XMLMappingInterpreter;
import ca.uwaterloo.gsd.struts.StrutsPackage;
import ca.uwaterloo.gsd.struts.edit.StrutsEditPlugin;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class StrutsAnalysisWizard extends FsmlAnalysisWizard {

	public StrutsAnalysisWizard() {
		super(
			StrutsPackage.eINSTANCE.getStrutsApplication(), 
			"struts", 
			"Struts Analysis Wizard", 
			"Create a new Struts model", 
			StrutsEditPlugin.INSTANCE.getImage("full/wizban/NewStruts")
		);
	}
	@Override
	public String validateProject(IProject project) {
		Queries.INSTANCE.setProject(project);
		
		try {
			IJavaProject javaProject = JavaCore.create(project);
			IType action = javaProject.findType("org.apache.struts.action.Action");
			if (action != null && action.exists())
				return null;
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return "Can only analyze Java projects with Struts libraries (core and extras) in classpath";
	}
	@Override
	protected void registerCustomInterpreters() {
		Queries.INSTANCE.registerCustomInterpreter(new JavaMappingInterpreter());
		Queries.INSTANCE.registerCustomInterpreter(new XMLMappingInterpreter());
	}
}
