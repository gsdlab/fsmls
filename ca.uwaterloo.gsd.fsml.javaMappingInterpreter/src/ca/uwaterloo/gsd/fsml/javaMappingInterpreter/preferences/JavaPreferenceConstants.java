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

/**
 * Constant definitions for plug-in preferences
 */
public class JavaPreferenceConstants {
	public static final String ANALYZE_IMPL_VARIANTS_LABEL = "&Analyze Implementation Variants";
	public static final String ANALYZE_IMPL_VARIANTS_ID = "analyzeImplVariants";
	
	public static final String PRINT_MATCHED_CALLS_TRACE_LABEL = "Print Trace of Matched Calls";
	public static final String PRINT_MATCHED_CALLS_TRACE_ID = "printMatchedCallsTrace";
	
	public static final String MATCHED_CALLS_TRACE_LENGTH_LABEL = "Minimum Length of Trace of Matched Calls to Print";
	public static final String MATCHED_CALLS_TRACE_LENGTH_ID = "matchedCallsTraceLength";
	
	// search scope preference
	public static final String METHOD_CALLS_SEARCH_SCOPE_LABEL = "Method calls search scope";
	public static final String METHOD_CALLS_SEARCH_SCOPE_ID = "methodCallsSearchScope";
	// search scope values
	public static final String PROJECT_VALUE = "project";
	public static final String CALL_GRAPH_VALUE = "callGraph";
	public static final String HIERARCHY_UNITS_VALUE = "hierarchyUnits";
	public static final String HIERARCHY_VALUE = "hierarchy";
	
	// call graph type preference
	public static final String CALL_GRAPH_TYPE_LABEL = "Call graph type";
	public static final String CALL_GRAPH_TYPE_ID = "callGraphType";
	// search scope values
	public static final String HIERARCHICAL_VALUE = "hierarchical";
	public static final String PRECISE_VALUE = "precise";
	public static final String FULL_VALUE = "full";
	
}
