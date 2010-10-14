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
package editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

public class Editor1 extends EditorBase implements ISelectionListener {
	IContentProvider contentProvider;
	
	public Editor1() {
	}
	public void createPartControl(Composite parent) {
		getSite().getPage().addSelectionListener(this);
		getSite().getPage().addPostSelectionListener(this);
	}
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		getSite().getPage().removePostSelectionListener(this);
		
	}
	boolean specificSelectionListenerOn = false;
	
	public void toogleSpecificSelectionListener() {
		if (!specificSelectionListenerOn) {
			getSite().getPage().addSelectionListener("ca.uwaterloo.gsd.fsml.wpi.examples.view1", this);
			specificSelectionListenerOn = true;
		}
		else {
			getSite().getPage().removeSelectionListener("ca.uwaterloo.gsd.fsml.wpi.examples.view1", this);
			specificSelectionListenerOn = false;
		}
	}
	public Object getAdapter(Class aClass) {
		if (IContentProvider.class.equals(aClass)) {
			if (contentProvider == null)
				contentProvider = createIContentProviderAdapter();
			return contentProvider;
		}
		else if (ILabelProvider.class.equals(aClass))
			return new ILabelProvider() {
				public Image getImage(Object element) {
					return null;
				}
				public String getText(Object element) {
					return null;
				}
				public void addListener(ILabelProviderListener listener) {
				}
				public void dispose() {
				}
				public boolean isLabelProperty(Object element, String property) {
					return false;
				}
				public void removeListener(ILabelProviderListener listener) {
				}
			};
		else if (Object.class.equals(aClass))
			return null;
		else if (Editor1.class.equals(aClass))
			return this;
		return super.getAdapter(aClass);
	}

	protected IContentProvider createIContentProviderAdapter() {
		IContentProvider result = new Editor1ContentProvider(); 
		return result;
	}
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
	}
	public void doSave(IProgressMonitor monitor) {
	}
	public void doSaveAs() {
	}
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
	}
	public boolean isDirty() {
		return false;
	}
	public boolean isSaveAsAllowed() {
		return false;
	}
	public void setFocus() {
	}
}
