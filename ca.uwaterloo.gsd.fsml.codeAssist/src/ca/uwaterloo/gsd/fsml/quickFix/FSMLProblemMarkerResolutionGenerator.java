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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

public class FSMLProblemMarkerResolutionGenerator implements
		IMarkerResolutionGenerator {

	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		try {
            Object problem = marker.getAttribute("FSML");
            if (problem!=null){
            	if (((String)marker.getAttribute(IMarker.MESSAGE)).contains(" must be ")){
            		return new IMarkerResolution[] {
            				new FSMLProblemMarkersQuickFix("Add "+((String)marker.getAttribute(IMarker.MESSAGE)).
            			   replaceAll("ca.uwaterloo.gsd.| must be set| must be true" ,"").
 	            		   replaceAll("\\.impl\\."," "),(String)marker.getAttribute(IMarker.MESSAGE)),
            		};
            	} else {
            		return new IMarkerResolution[] {
            	
            				new FSMLProblemMarkersQuickFix("Complete "+((String)marker.getAttribute(IMarker.MESSAGE)).
	            		   replaceAll(".*invariant is violated on|ca.uwaterloo.gsd." ,"").
	            		   replaceAll("\\.impl\\."," "),(String)marker.getAttribute(IMarker.MESSAGE)),
            		};
	            }
            } else {
            	return new IMarkerResolution[0];
            }
         }
         catch (CoreException e) {
            return new IMarkerResolution[0];
         }
	}

}
