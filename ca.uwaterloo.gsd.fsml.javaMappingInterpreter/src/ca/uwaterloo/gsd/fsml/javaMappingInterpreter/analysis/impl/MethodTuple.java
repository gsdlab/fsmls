/*******************************************************************************
 * Copyright (c) 2010 Thiago Tonelli Bartolomei.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Thiago Tonelli Bartolomei - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.analysis.impl;

import org.eclipse.jdt.core.IMethod;

/**
 * Class that represents two methods in a relationship. For example, if the relationship
 * is "overrides", this can be used to show that the first method overrides the second.
 *
 * TODO - This is just used by the "overrides" structure in the call graph manager, which
 * is not actually been used. Maybe we can remove it. 
 * 
 * @author Thiago Tonelli Bartolomei <ttonelli@gsd.uwaterloo.ca>
 */
public class MethodTuple {
	
	public IMethod first = null;
	public IMethod second = null;

	public MethodTuple(IMethod first, IMethod second) {
		this.first = first;
		this.second = second;
	}
}
