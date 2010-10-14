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
 * This annotation can be used in mappings to indicate fields that are contexts.
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Context {
	/**
	 * @return the mode in which the context is used.
	 */
	Mode mode() default Mode.ALL;
	/**
	 * @return true if the context is required for the given mode
	 */
	boolean required() default false;
	/**
	 * @return name of the field that needs to be non-null in order to retrieve this context
	 */
	String dependsOn() default "";
	/**
	 * @return name of the field that cannot contain the context at the same time
	 */
	String excludes() default "";
}
