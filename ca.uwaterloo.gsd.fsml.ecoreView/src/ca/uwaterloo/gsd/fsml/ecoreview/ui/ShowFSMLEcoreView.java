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
package ca.uwaterloo.gsd.fsml.ecoreview.ui;

import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class ShowFSMLEcoreView implements IObjectActionDelegate {
	IWorkbenchPart part;
	
	public ShowFSMLEcoreView() {
	}
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		part = targetPart;
		action.setEnabled(part instanceof EcoreEditor);
	}
	public void run(IAction action) {
		if (part != null) {
			try {
				IViewPart view = part.getSite().getPage().showView("ca.uwaterloo.gsd.fsml.ecoreview.ui.FSMLEcoreView");
				if (view instanceof IPartListener)
					((IPartListener)view).partActivated(part);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}

	}
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
