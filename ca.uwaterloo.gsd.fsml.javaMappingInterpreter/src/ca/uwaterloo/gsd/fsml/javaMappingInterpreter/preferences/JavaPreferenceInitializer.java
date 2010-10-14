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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreterPlugin;


/**
 * Class used to initialize default preference values.
 */
public class JavaPreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore();
		store.setDefault(JavaPreferenceConstants.ANALYZE_IMPL_VARIANTS_ID, false);
		store.setDefault(JavaPreferenceConstants.METHOD_CALLS_SEARCH_SCOPE_ID, JavaPreferenceConstants.HIERARCHY_UNITS_VALUE);
		store.setDefault(JavaPreferenceConstants.CALL_GRAPH_TYPE_ID, JavaPreferenceConstants.PRECISE_VALUE);
		store.setDefault(JavaPreferenceConstants.PRINT_MATCHED_CALLS_TRACE_ID, false);
		store.setDefault(JavaPreferenceConstants.MATCHED_CALLS_TRACE_LENGTH_ID, 1);
	}
}
