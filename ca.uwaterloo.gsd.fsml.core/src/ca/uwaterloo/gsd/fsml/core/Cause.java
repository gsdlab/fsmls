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

public enum Cause {
	UNKNOWN,
	UNKNOWN_PARAMETER, 
	UNKNOWN_MAPPING,
	MISSING_CONTEXT,
	MISSING_CONCRETE_CHILD_TYPE, 
	MISSING_PARAMETER, 
	MISSING_ATTRIBUTE,
	MODEL_NAVIGATION_ERROR, 
	INCORRECT_VALUE, 
	INCORRECT_TYPE,
	MAPPING_REQUIRES_ATTRIBUTE, 
	REQUIRED_CONTEXT_MISSING
}
