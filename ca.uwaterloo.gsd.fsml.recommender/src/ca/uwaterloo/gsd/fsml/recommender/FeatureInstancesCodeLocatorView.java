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
package ca.uwaterloo.gsd.fsml.recommender;

import java.util.List;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;

public class FeatureInstancesCodeLocatorView extends ViewPart implements IDoubleClickListener {
	private TableViewer tableViewer;
	private Composite parent;
	private List<IMarker> markers;

	@Override
	public void createPartControl(Composite parent) {
		
		this.parent = parent;
		tableViewer = new TableViewer(parent);
		tableViewer.getContentProvider();
		TableColumn column1 = new TableColumn(tableViewer.getTable(),SWT.LEFT);
		column1.setText("Code");
		column1.setWidth(600);
		TableColumn column2 = new TableColumn(tableViewer.getTable(),SWT.RIGHT);
		column2.setText("Method Location");
		column2.setWidth(300);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);		
		tableViewer.addDoubleClickListener(this);
		tableViewer.addDragSupport(DND.DROP_MOVE|DND.DROP_COPY|DND.DROP_LINK, new Transfer[] { TextTransfer.getInstance() }, new DragSourceListener(){

			@Override
			public void dragFinished(DragSourceEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				if (!tableViewer.getSelection().isEmpty() && tableViewer.getSelection() instanceof IStructuredSelection){
					IStructuredSelection selection = (IStructuredSelection)tableViewer.getSelection();
					IMarker marker = ((MarkerAndMethodLocationName)selection.getFirstElement()).marker;
					IResource resource = resource = marker.getResource();
					ICompilationUnit cu = JavaCore.createCompilationUnitFrom(FileBuffers.getWorkspaceFileAtLocation(resource.getFullPath()));;
				
					try {
						int markerStartPos = ((Integer)marker
								.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START))
								.intValue();
						int markerEndPos = ((Integer) marker
								.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END))
								.intValue();
					
					
						event.data = cu.getSource().substring(markerStartPos, markerEndPos);
					} catch (CoreException e) {
						e.printStackTrace();
					}
			
				}
			}

			@Override
			public void dragStart(DragSourceEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		tableViewer.setLabelProvider(new ITableLabelProvider(){

			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getColumnText(Object element, int columnIndex) {
				// TODO Auto-generated method stub
				MarkerAndMethodLocationName currentElement = ((MarkerAndMethodLocationName)element);
				if (columnIndex==0){
					IResource resource = null;
					ICompilationUnit cu = null;
					int markerStartPos;
					int markerEndPos;
					
					IMarker marker = currentElement.marker;
						resource = marker.getResource();
						cu = JavaCore.createCompilationUnitFrom(FileBuffers.getWorkspaceFileAtLocation(resource.getFullPath()));
						
						try {
							markerStartPos = ((Integer)marker
									.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START))
									.intValue();
							markerEndPos = ((Integer) marker
									.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END))
									.intValue();
							System.out.println (cu.getSource().substring(markerStartPos, markerEndPos));
							return cu.getSource().substring(markerStartPos, markerEndPos);
							
						} catch (CoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}else if (columnIndex==1) {
					return currentElement.methodLocationName;
				}
				return null;
			}

			@Override
			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub
				
			}

		

			
		});
		tableViewer.setComparator(new ViewerComparator(){
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				// TODO Auto-generated method stub
				  IBaseLabelProvider prov = ((ContentViewer) viewer)
                  .getLabelProvider();
				  if (prov instanceof ITableLabelProvider) {
					  ITableLabelProvider lprov = (ITableLabelProvider) prov;
					  return getComparator().compare(lprov.getColumnText(e1, 0), lprov.getColumnText(e2,0));
				  }else {
					  return -1;
				  }
			}
		});
			
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	private class MarkerAndMethodLocationName{
		IMarker marker;
		String methodLocationName;
		public MarkerAndMethodLocationName(IMarker marker, String methodLocationName) {
			this.marker = marker;
			this.methodLocationName = methodLocationName;
			// TODO Auto-generated constructor stub
		}
	}
	

	public void showMarker(List<IMarker> markers,List<String>methodLocationNames){
		this.markers = markers;
		tableViewer.getTable().clearAll();
		tableViewer.refresh();
		for (int i = 0; i < markers.size(); i++) {
			tableViewer.add(new MarkerAndMethodLocationName(markers.get(i),methodLocationNames.get(i)));
		} 
		
		
		
		
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		if (!event.getSelection().isEmpty() && event.getSelection() instanceof IStructuredSelection){
			IStructuredSelection selection = (IStructuredSelection)event.getSelection();
			try {
				IDE.openEditor(getSite().getPage(), ((MarkerAndMethodLocationName)selection.getFirstElement()).marker, OpenStrategy.activateOnOpen());
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	
}
