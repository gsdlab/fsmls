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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ca.uwaterloo.gsd.fsml.javaMappingInterpreter.JavaMappingInterpreterPlugin;

public class JavaPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	public JavaPreferencePage() {
		super(GRID);
		
		setPreferenceStore(JavaMappingInterpreterPlugin.getPlugin().getPreferenceStore());
		setDescription("General Settings for Java Mapping Interpreter:");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
        Group group = new Group(getFieldEditorParent(), SWT.NONE);
        group.setText("Analysis");
        group.setLayout(new GridLayout());
        GridData layData = new GridData(GridData.FILL_HORIZONTAL);
        layData.horizontalSpan = 2;
        group.setLayoutData(layData);
        Composite analysisParent = new Composite(group, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        analysisParent.setLayout(layout);
        analysisParent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		addField(
				new BooleanFieldEditor(
					JavaPreferenceConstants.ANALYZE_IMPL_VARIANTS_ID,JavaPreferenceConstants.ANALYZE_IMPL_VARIANTS_LABEL,
					analysisParent));
		
		final RadioGroupFieldEditor searchScope = new RadioGroupFieldEditor(
				JavaPreferenceConstants.METHOD_CALLS_SEARCH_SCOPE_ID,
				JavaPreferenceConstants.METHOD_CALLS_SEARCH_SCOPE_LABEL,
				1,
				new String[][] { 
						{ "Supertype hierarchy of the context class (hierarchy)",  JavaPreferenceConstants.HIERARCHY_VALUE}, 
						{ "Supertype hierarchy of the context class extended with types from their compilation units (hierarchyUnits)",  JavaPreferenceConstants.HIERARCHY_UNITS_VALUE},
						{ "Methods encountered during call graph creation (callGraph) [experimental]",  JavaPreferenceConstants.CALL_GRAPH_VALUE},
						{ "Entire project (project)",  JavaPreferenceConstants.PROJECT_VALUE}
				},
				getFieldEditorParent()); 
		addField(searchScope);
		
		final RadioGroupFieldEditor callGraphType = new RadioGroupFieldEditor(
				JavaPreferenceConstants.CALL_GRAPH_TYPE_ID,
				JavaPreferenceConstants.CALL_GRAPH_TYPE_LABEL,
				1,
				new String[][] { 
						{ "Hierarchical call graph including static calls outside of the hierarchy (hierarchical)",  JavaPreferenceConstants.HIERARCHICAL_VALUE}, 
						{ "Full call graph limited to dynamic calls with single target method implementation (precise)",  JavaPreferenceConstants.PRECISE_VALUE}, 
						{ "Full call graph with all possible dynamic calls (full)",  JavaPreferenceConstants.FULL_VALUE}
				},
				getFieldEditorParent()); 
		addField(callGraphType);
		
		Group group4 = new Group(getFieldEditorParent(), SWT.NONE);
        group4.setText("Call traces printing");
        group4.setLayout(new GridLayout());
        GridData layData4 = new GridData(GridData.FILL_HORIZONTAL);
        layData4.horizontalSpan = 2;
        group4.setLayoutData(layData4);
        Composite callPrintingParent = new Composite(group4, SWT.NULL);
        GridLayout layout4 = new GridLayout();
        layout4.numColumns = 3;
        callPrintingParent.setLayout(layout4);
        callPrintingParent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
		// Printing call traces for matched calls
		final BooleanFieldEditor printMatchedCallsTrace = new BooleanFieldEditor(
				JavaPreferenceConstants.PRINT_MATCHED_CALLS_TRACE_ID,
				JavaPreferenceConstants.PRINT_MATCHED_CALLS_TRACE_LABEL,
				callPrintingParent);
		
		final IntegerFieldEditor matchedCallsTraceLength = new IntegerFieldEditor(
				JavaPreferenceConstants.MATCHED_CALLS_TRACE_LENGTH_ID,
				JavaPreferenceConstants.MATCHED_CALLS_TRACE_LENGTH_LABEL,
				callPrintingParent);
		matchedCallsTraceLength.setValidRange(1, 1000);
		
		addField(printMatchedCallsTrace);
		addField(matchedCallsTraceLength);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}
