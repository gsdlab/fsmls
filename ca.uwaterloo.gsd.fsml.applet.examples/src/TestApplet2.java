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
import java.applet.Applet;
public class TestApplet2 extends Applet {
	final String statusField = "static field value";
	public static final String[][] parameterNames = new String[][] {
		{ "arrayParam1", "arrayParam1Description" },
		{ "arrayParam2", "arrayParam2Description" },
		{ "arrayParam3", "arrayParam3Description" },
	};
	public Runnable oneTimeThread = new Runnable() {
		public void run() {
		}
	};
	public String[][] getParameterInfo() {
		return parameterNames;
	}
	public static void main(String[] args) {
		new TestApplet2().retrieveParameters();
	}
	public void init() {
		String status = "garbage";
		String status4 = null;
		
		final String status2 = "loading images...";
		
		{
			status = "initializing...";
		}
		
		String status3 = "initializer value";
		
		
		
		getParameter(  "fileName");
		
		specialShowStatus(status);
		
		specialShowStatus(status2);
		
		showStatus(status3);
		
		if (status == getParameter("X"))
			status4 = "parameter X = garbage";
		else
			status4 = "unknown value of status";
		
		showStatus(status4);
		
		new Thread(oneTimeThread);
	}

	protected void retrieveParameters() {
		/*for (int i = 0; i < parameterNames.length; i++) {
			getParameter(parameterNames[i][0]);
			//System.out.println(parameterNames[i][0]);
		}*/
		
		String[][] localParameterNames = getParameterInfo();
		for (int i = 0; i < localParameterNames.length; i++)
			getParameter(localParameterNames[i][0]);
	}
	public void specialShowStatus(String message) {
		// comment out this assignment to see "garbage" and "initializing..." as values
		//message = "stupid overridden message";
		
		if (message != null) {
			showStatus(message);
		}
	}
}
