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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis;

public enum Scope {
	NO_HIERARCHY,   // search in the context class only
	SOURCE_HIERARCHY, // search in the super class hierarchy of the context class
	PROJECT, // search in the entire context project
	CONTEXT_CLASS, 
	TARGET_HIERARCHY
}
