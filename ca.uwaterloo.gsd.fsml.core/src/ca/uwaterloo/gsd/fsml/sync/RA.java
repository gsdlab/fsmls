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
package ca.uwaterloo.gsd.fsml.sync;
/**
 * Reconcilation Action
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public enum RA {
	MODEL_ADD, 
	MODEL_CHANGE, 
	MODEL_REMOVE,
	CODE_ADD, 
	CODE_CHANGE, 
	CODE_REMOVE,
	PROCEED, 
	STOP
}
