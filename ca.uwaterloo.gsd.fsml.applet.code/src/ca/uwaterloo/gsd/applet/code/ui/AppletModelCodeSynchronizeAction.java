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
package ca.uwaterloo.gsd.applet.code.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IEditorPart;

import ca.uwaterloo.gsd.applet.presentation.AppletEditor;
import ca.uwaterloo.gsd.fsml.core.Queries;
import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreter;
import ca.uwaterloo.gsd.fsml.ui.ModelCodeSynchronizeAction;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class AppletModelCodeSynchronizeAction extends ModelCodeSynchronizeAction {
	public AppletModelCodeSynchronizeAction() {
	}
	@Override
	protected IRunnableWithProgress createSynchronizeRunnable() {
		return new AppletSynchronizeRunnable();
	}
	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if (targetEditor instanceof AppletEditor)
			super.setActiveEditor(action, targetEditor);
		else
			action.setEnabled(false);
	}
	protected final class AppletSynchronizeRunnable extends SynchronizeRunnable {
		@Override
		protected void registerCustomInterpreters() {
			// add custom annotation interpreter
			Queries.INSTANCE.registerCustomInterpreter(new JavaMappingInterpreter());
		}
	}
}
