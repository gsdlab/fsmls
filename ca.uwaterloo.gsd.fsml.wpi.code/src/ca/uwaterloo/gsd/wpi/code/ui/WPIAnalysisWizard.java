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
package ca.uwaterloo.gsd.wpi.code.ui;

import org.eclipse.core.resources.IProject;

import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.ui.FsmlAnalysisWizard;
import ca.uwaterloo.gsd.wpi.WpiPackage;
import ca.uwaterloo.gsd.wpi.code.WpiMappingInterpreter;
import ca.uwaterloo.gsd.wpi.provider.WpiEditPlugin;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class WPIAnalysisWizard extends FsmlAnalysisWizard {

	public WPIAnalysisWizard() {
		super(
				WpiPackage.eINSTANCE.getWorkbenchPartInteractions(), 
				"wpi", 
				"Workbench Part Interaction Analysis Wizard", 
				"Create a new Workbench Part Interaction model", 
				WpiEditPlugin.INSTANCE.getImage("full/wizban/NewWpi")
			);
	}
	/**
	 * Check if the project is a plug-in project
	 
	public String validateProject(IProject project) {
		if (WPIQueries.INSTANCE.setProject(project))
			return null;
		else
			return "Workbench Part Interaction diagram can only be created in a Plug-in Project";
	}*/
	@Override
	public String validateProject(IProject project) {
		Queries.INSTANCE.setProject(project);
		if (Queries.hasNature(project, "org.eclipse.jdt.core.javanature"))
			return null;
		else
			return "Can only analyze Java projects";
	}
	@Override
	protected void registerCustomInterpreters() {
		// add custom annotation interpreter
		Queries.INSTANCE.registerCustomInterpreter(new JavaMappingInterpreter());
		Queries.INSTANCE.registerCustomInterpreter(new WpiMappingInterpreter());
	}
}
