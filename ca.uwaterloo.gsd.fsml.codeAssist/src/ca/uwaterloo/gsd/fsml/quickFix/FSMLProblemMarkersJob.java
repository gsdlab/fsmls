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
package ca.uwaterloo.gsd.fsml.quickFix;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jdt.internal.ui.JavaPlugin;

import ca.uwaterloo.gsd.fsml.codeAssist.FSMLCodeAssistUtil;
import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;
import ca.uwaterloo.gsd.fsml.core.Markers;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.Model;
import ca.uwaterloo.gsd.fsml.fsml.ModelContainer;

public class FSMLProblemMarkersJob extends Job {
	public static final int TIME_INTERVAL = 20000;
	private boolean running = true;


	public FSMLProblemMarkersJob() {
		super("FSML Problem Markers Job");
		deleteMarkers();
	}

	private void deleteMarkers() {
		//code to delete markers created
		IProject[] projects = JavaPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			if (!projects[i].isOpen()){
				continue;
			}
			IProject project = projects[i];
			Markers.INSTANCE.setProject(project);
			
				//find the model file
				List<IFile> fsmlModelFiles = FSMLCodeAssistUtil.findModelFile(project);
				for (IFile fsmlModelFile : fsmlModelFiles) {
					if (fsmlModelFile !=null&&fsmlModelFile.exists()){
						
						EList<EObject> fsmlModel = null;
						ResourceSet resourceSet = new ResourceSetImpl();
						URI fsmlModelURI = URI.createPlatformResourceURI(
								fsmlModelFile.getFullPath().toString(), true);
						Resource resource = resourceSet.getResource(
								fsmlModelURI, true);
						
						fsmlModel = resource.getContents();
	
						Model assertedModel = ((ModelContainer) fsmlModel.get(0))
						.getAssertedModel();
					
						Diagnostician validator = new Diagnostician();
						Diagnostic validate = validator.validate(assertedModel);
						List<Diagnostic> children = validate.getChildren();
						for (Diagnostic diagnostic : children) {
							List<?> data = diagnostic.getData();
							for (Object object : data) {
								List<IMarker> markers = Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId((EObject)object,null));
								if (markers.size()==0){
									markers = Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId(((EObject)object).eContainer(),null));
								}
								if (markers.size()>0){
									try {
										IMarker[] currentProblemMarkers = markers.get(0).getResource().findMarkers(IMarker.PROBLEM, true,IResource.DEPTH_INFINITE);
										for (int k = 0; k < currentProblemMarkers.length; k++) {
												currentProblemMarkers[k].delete();
										}
									} catch (CoreException e) {
										e.printStackTrace();
									}
	
								}
								
							}
						}
					}
				}
		}
	}

	protected IStatus run(IProgressMonitor monitor) {
		//System.out.println ("problems marker creation task ran");
		schedule(TIME_INTERVAL);
		IProject[] projects = JavaPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			if (!projects[i].isOpen()){
				continue;
			}
			IProject project = projects[i];
			//clear all markers previously created
			try {	
				IMarker[] currentProblemMarkers = project.findMarkers(IMarker.PROBLEM, true,IResource.DEPTH_INFINITE);
				
					for (int j = 0; j < currentProblemMarkers.length; j++) {
						if (currentProblemMarkers[j].getAttribute("FSML")!=null ){
							currentProblemMarkers[j].delete();
						}
						
					}
			} catch (CoreException e) {
				e.printStackTrace();
			}

			

			Markers.INSTANCE.setProject(project);
			
				//find the model file
				List<IFile> fsmlModelFiles = FSMLCodeAssistUtil.findModelFile(project);
				for (IFile fsmlModelFile : fsmlModelFiles) {
					if (fsmlModelFile !=null&&fsmlModelFile.exists()){
						
						EList<EObject> fsmlModel = null;
						ResourceSet resourceSet = new ResourceSetImpl();
						URI fsmlModelURI = URI.createPlatformResourceURI(
								fsmlModelFile.getFullPath().toString(), true);
						Resource resource = resourceSet.getResource(
								fsmlModelURI, true);
						
						fsmlModel = resource.getContents();
	
						Model assertedModel = ((ModelContainer) fsmlModel.get(0))
						.getAssertedModel();
					
						Diagnostician validator = new Diagnostician();
						Diagnostic validate = validator.validate(assertedModel);
						List<Diagnostic> children = validate.getChildren();
						for (Diagnostic diagnostic : children) {
							List<?> data = diagnostic.getData();
							for (Object object : data) {
								List<IMarker> markers = Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId((EObject)object,null));
								if (markers.size()==0){
									markers = Markers.INSTANCE.getMarkers(FSMLEcoreUtil.getFSMLId(((EObject)object).eContainer(),null));
								}
								for (IMarker marker : markers) {
									try {
										IMarker problemMarker= marker.getResource().createMarker(IMarker.PROBLEM);
									
										problemMarker.setAttribute(IMarker.CHAR_START, marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START));
										problemMarker.setAttribute(IMarker.CHAR_END, marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END));
										problemMarker.setAttribute(IMarker.MESSAGE, diagnostic.getMessage().replaceFirst("@.*}", ""));
										problemMarker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
										problemMarker.setAttribute(IMarker.SEVERITY,IMarker.SEVERITY_ERROR);
										problemMarker.setAttribute("FSML","true");
									} catch (CoreException e) {
										e.printStackTrace();
									}
									
								} 
							}
						}
					}
				}
		}
							
		return Status.OK_STATUS;
	}


	public boolean shouldSchedule() {
		return running;
	}

	public void stop() {
		running = false;
	}

	


}
