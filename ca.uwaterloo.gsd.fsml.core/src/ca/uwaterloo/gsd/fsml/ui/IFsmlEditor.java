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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;

import ca.uwaterloo.gsd.fsml.fsml.Model;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public interface IFsmlEditor extends IEditorPart, IEditingDomainProvider {
	/**
	 * Used by the synchronization view to retrieve the model
	 */
	public Model getModel();
	/**
	 * Used by the synchronization view to retrieve the adapter factory
	 */
	public AdapterFactory getAdapterFactory();
	/**
	 * Used by the ModelCodeReconcileAction to retrieve the viewer
	 */
	public Viewer getViewer();
}
