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

public enum Mode {
	// execution modes
	FORWARD, 
	REVERSE, 
	REVERSE_ESSENTIAL, 
	
	// context and parameter usage specifications
	ALL,
	FORWARD_AND_REVERSE,
	FORWARD_AND_REVERSE_ESSENTIAL,
	REVERSE_AND_REVERSE_ESSENTIAL,
	// FORWARD,
	// REVERSE,
	// REVERSE_ESSENTIAL,
	NONE,
}
