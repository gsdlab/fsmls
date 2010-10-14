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
package ca.uwaterloo.gsd.fsml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class Markers {
	public static Markers INSTANCE = new Markers();
	protected IProject project;
	
	/**
	 * prohibit instantiation
	 */
	private Markers() {
	}
	/**
	 * This sets the current project and caches FSML markers
	 * @param project
	 */
	public void setProject(IProject project) { 
		this.project = project;
		cacheMarkers();
	}
	
	HashMap<String, List<IMarker>> id2markerMap = null;
	/**
	 * @param element
	 * @return
	 */
	public static MarkerDescriptor createMarkerDescriptor(IResource resource) {
		return new MarkerDescriptor(resource);
	}
	/**
	 * Searches the project for FSML markers and caches them together indexed by their id.
	 * This method will clear old caches.
	 * 
	 */
	protected void cacheMarkers() {
		id2markerMap = new HashMap<String, List<IMarker>>();
		try {
			IMarker[] markers = project.findMarkers("ca.uwaterloo.gsd.fsml.marker", false, IResource.DEPTH_INFINITE);
			for (IMarker marker : markers) {
				String id = marker.getAttribute(MarkerDescriptor.ATTRIBUTE_ID, null);
				if (! id2markerMap.containsKey(id)) {
					id2markerMap.put(id, new ArrayList<IMarker>());
				}
				id2markerMap.get(id).add(marker);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Removes all FSML markers from the project and clears the cache.
	 */
	public void removeMarkers() {
		try {
			project.deleteMarkers("ca.uwaterloo.gsd.fsml.marker", false, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		id2markerMap = null;
	}
	/**
	 * Gets the markers cached for the given id.
	 * 
	 * @param id the id representing the markers
	 * @return the list of markers from the cache for a concept or a feature with the given id. It will return an empty
	 * list if there are no markers with this id.
	 */
	public List<IMarker> getMarkers(String id) {
		if (id2markerMap == null || id2markerMap.isEmpty())
			cacheMarkers();
		if (id2markerMap.containsKey(id)) {
			return id2markerMap.get(id);
		}
		return new ArrayList<IMarker>();
	}
	
	/**
	 * Innermost markers first
	 * @param marker
	 */
	public static Vector<IMarker> sortMarkers(Vector<IMarker> marker){
		Collections.sort(marker, new Comparator<IMarker>(){

			@Override
			public int compare(IMarker o1, IMarker o2) {
				try {
					int markerStartPos1 = ((Integer)o1.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START)).intValue();
					int markerEndPos1 = ((Integer)o1.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END)).intValue();
					int markerStartPos2 = ((Integer)o2.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START)).intValue();
					int markerEndPos2 = ((Integer)o2.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END)).intValue();
					if (markerEndPos1-markerStartPos1<=markerEndPos2-markerStartPos2){
						return -1;
					} else {
						return 1;
					}
					
				} catch (CoreException e) {
					e.printStackTrace();
				}
				return -1;
			}
			
		});
		return marker;
	}
	
	/**
	 * Get markers covered by offset and length in the given file
	 */
	public Vector<IMarker> getCoveringMarkers(IFile file, int offset, int length) {
		Vector<IMarker> result = new Vector<IMarker>();
		
		if (id2markerMap == null || id2markerMap.isEmpty())
			cacheMarkers();
		
		Collection<List<IMarker>> values = id2markerMap.values();
		for (List<IMarker> list : values) {
			for (IMarker marker : list) {
				if (file.getLocation().equals(marker.getResource().getLocation())){
						try {
							int markerStartPos = ((Integer)marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START)).intValue();
							int markerEndPos = ((Integer)marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END)).intValue();
							if (markerStartPos<=offset&&
									markerEndPos>=offset+length){
								result.add(marker);
							}
						} catch (CoreException e) {
							e.printStackTrace();
						}
				}
			}
		}
		return  sortMarkers(result);
	}
	
	public Vector<IMarker> getMarkersFromResourceAtPosition(IResource resource, int startPos, int endPos) {
		Vector<IMarker> result = new Vector<IMarker>();
		if (id2markerMap == null || id2markerMap.isEmpty() )
			cacheMarkers();
		
		Collection<List<IMarker>> values = id2markerMap.values();
		for (List<IMarker> list : values) {
			for (IMarker marker : list) {
				if (resource.equals(marker.getResource())){
					try {
						int markerStartPos = ((Integer)marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_START)).intValue();
						int markerEndPos = ((Integer)marker.getAttribute(MarkerDescriptor.ATTRIBUTE_CHAR_END)).intValue();
						if (markerStartPos<=startPos && markerEndPos>=endPos)
							result.add(marker);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
		
	}
}
