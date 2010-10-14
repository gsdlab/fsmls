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
package views;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.part.ViewPart;

public class View1 extends ViewPart implements ISelectionProvider, ISelectionListener, IPartListener {

	ISelectionListener listener = new ISelectionListener() {
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		}
	};
	private IPartListener2 fPartListener2 = new IPartListener2() {
		public void partActivated(IWorkbenchPartReference partRef) {
		}
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}
		public void partClosed(IWorkbenchPartReference partRef) {
		}
		public void partDeactivated(IWorkbenchPartReference partRef) {
		}
		public void partHidden(IWorkbenchPartReference partRef) {
		}
		public void partInputChanged(IWorkbenchPartReference partRef) {
		}
		public void partOpened(IWorkbenchPartReference partRef) {
		}
		public void partVisible(IWorkbenchPartReference partRef) {
		}
		
	};

	public View1() {
		getSite().getPage().addSelectionListener(listener);
	}

	@Override
	public void createPartControl(Composite parent) {
		getSite().setSelectionProvider(this);
		getSite().getPage().addSelectionListener("ca.uwaterloo.gsd.fsml.wpi.examples.editor1", this);
		
		listener = new ISelectionListener() {
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			}
		};
		
		getSite().getPage().addPartListener(this);
		getSite().getPage().addPartListener(fPartListener2);
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void dispose() {
		super.dispose();
		getSite().getPage().removeSelectionListener("ca.uwaterloo.gsd.fsml.wpi.examples.editor1", this);
		
		listener = null;
		
		getSite().getPage().removeSelectionListener(listener);
		getSite().getPage().removePartListener(this);
		getSite().getPage().removePartListener(fPartListener2);
	}
	
	public void requestAdapters(IWorkbenchPart part) {
		Class requestedClass = IContentProvider.class;
		
		part.getAdapter(requestedClass);

		part.getAdapter(ILabelProvider.class);
	}
	IContentProvider contentProvider;
	
	public Object getAdapter(Class aClass) {
		if (contentProvider == null)
			contentProvider = new IContentProvider() {
				@Override
				public void dispose() {
				}
				@Override
				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}
			};
		return contentProvider;
	}
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
	}
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
	}

	@Override
	public ISelection getSelection() {
		return null;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
	}

	@Override
	public void setSelection(ISelection selection) {
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

}
