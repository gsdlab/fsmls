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
package ca.uwaterloo.gsd.fsml.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class ShowModelCodeNavigationView implements IObjectActionDelegate {
	protected IWorkbenchPart targetPart;
	protected ISelection selection;
	
	public ShowModelCodeNavigationView() {
	}
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}
	public void run(IAction action) {
		if (targetPart != null) {
			try {
				IViewPart view = targetPart.getSite().getPage().showView("ca.uwaterloo.gsd.fsml.GoToView");
				if (view instanceof ISelectionListener)
					((ISelectionListener)view).selectionChanged(targetPart, selection);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}

	}
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
