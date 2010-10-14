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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import ca.uwaterloo.gsd.fsml.stats.Stats;

public class FSMLMappingException extends Exception {
	private static final long serialVersionUID = 1163348668549150034L;

	public Cause cause = Cause.UNKNOWN;
	public String message = null;
	
	private FSMLMappingException() {	
	}
	
	public FSMLMappingException(Cause cause, String message) {
		this.cause = cause;
		this.message = message;
	}
	public FSMLMappingException(Cause cause, EStructuralFeature feature) {
		this.cause = cause;
		this.message = "for " + ((EClass) feature.eContainer()).getName() + "::" + feature.getName();
	}
	public FSMLMappingException(Cause cause, EStructuralFeature feature, String message) {
		this.cause = cause;
		this.message = message + " for " + ((EClass) feature.eContainer()).getName() + "::" + feature.getName();
	}
	@Override
	public void printStackTrace() {
		Stats.INSTANCE.printMessage("Message: " + message);
		super.printStackTrace();
	}
}
