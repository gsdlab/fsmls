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
/**
  *
 *
 *
 * $Id: AppletAnalysisWizard.java,v 1.12 2008/01/25 15:51:36 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.code.ui;


import org.eclipse.core.resources.IProject;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.provider.AppletEditPlugin;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.ui.FsmlAnalysisWizard;


/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 * 
 * This is a simple wizard for creating a new model file.
 */
public class AppletAnalysisWizard extends FsmlAnalysisWizard {
	public AppletAnalysisWizard() {
		super(
			AppletPackage.eINSTANCE.getAppletModel(),
			"applet", 
			"Applet Analysis Model", 
			"Create a new Applet model", 
			AppletEditPlugin.INSTANCE.getImage("full/wizban/NewApplet")
		);
	}
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
		// HTML custom interpreter could be added here
		Queries.INSTANCE.registerCustomInterpreter(new JavaMappingInterpreter());
	}
}
