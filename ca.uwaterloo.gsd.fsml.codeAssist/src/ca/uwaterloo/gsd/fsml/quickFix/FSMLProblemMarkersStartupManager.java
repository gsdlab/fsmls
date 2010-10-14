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
import org.eclipse.ui.IStartup;


public class FSMLProblemMarkersStartupManager implements IStartup {

	@Override
	public void earlyStartup() {
		System.out.println ("Periodic FSML Problem Markers Creation Running at "+(FSMLProblemMarkersJob.TIME_INTERVAL/1000)+" seconds interval");
		FSMLProblemMarkersJob task = new FSMLProblemMarkersJob();
		task.schedule();
		
		
		
		
	}

}
