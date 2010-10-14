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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation can be used in mappings to indicate fields that hold values of detail entries.
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Parameter {
	/**
	 * @return the name of the mapping parameter
	 */
	String name();
	/**
	 * @return the mode in which the parameter is used
	 * @see Mode
	 */
	Mode mode() default Mode.ALL;
	/**
	 * @return true if the parameter is required for the given mode
	 */
	boolean required() default false;
	/**
	 * @return default value of the mapping parameter
	 */
	String defaultValue() default "";
}
