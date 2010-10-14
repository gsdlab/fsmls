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
package ca.uwaterloo.gsd.fsml.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ca.uwaterloo.gsd.fsml.fsml.provider.FsmlEditPlugin;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class FSMLPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	
	public FSMLPreferencePage() {
		super(GRID);
		
		setPreferenceStore(FsmlEditPlugin.getPlugin().getPreferenceStore());
		setDescription("General Settings for FSML Code Analysis:");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		
		   // Logging
        Group group = new Group(getFieldEditorParent(), SWT.NONE);
        group.setText("Logging");
        group.setLayout(new GridLayout());
        GridData layData = new GridData(GridData.FILL_HORIZONTAL);
        layData.horizontalSpan = 2;
        group.setLayoutData(layData);
        Composite loggingParent = new Composite(group, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        loggingParent.setLayout(layout);
        loggingParent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
       
		
		addField(
				new BooleanFieldEditor(
					FSMLPreferenceConstants.LOG_BUGS_ID,FSMLPreferenceConstants.LOG_BUGS_LABEL,
					loggingParent));
		addField(
				new BooleanFieldEditor(
					FSMLPreferenceConstants.LOG_CODE_PATTERN_VARIANTS_ID,FSMLPreferenceConstants.LOG_CODE_PATTERN_VARIANTS_LABEL,
					loggingParent));

		addField(
				new BooleanFieldEditor(
					FSMLPreferenceConstants.LOG_ERRORS_ID,FSMLPreferenceConstants.LOG_ERRORS_LABEL,
					loggingParent));
		addField(
				new BooleanFieldEditor(
					FSMLPreferenceConstants.LOG_FEATURE_INSTANCE_ID,FSMLPreferenceConstants.LOG_FEATURE_INSTANCE_LABEL,
					loggingParent));
		addField(
				new BooleanFieldEditor(
					FSMLPreferenceConstants.LOG_MESSAGES_ID,FSMLPreferenceConstants.LOG_MESSAGES_LABEL,
					loggingParent));
		addField(
				new BooleanFieldEditor(
					FSMLPreferenceConstants.LOG_METAMODEL_ANNOTATIONS_ID,FSMLPreferenceConstants.LOG_METAMODEL_ANNOTATIONS_LABEL,
					loggingParent));
		addField(
				new BooleanFieldEditor(
						FSMLPreferenceConstants.COMPUTE_SCATTERING_AND_TANGLING_MEASURES_ID, FSMLPreferenceConstants.COMPUTE_SCATTERING_AND_TANGLING_MEASURES_LABEL,
					loggingParent));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}
