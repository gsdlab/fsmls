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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import ca.uwaterloo.gsd.fsml.fsml.provider.FsmlEditPlugin;

/**
 * Class used to initialize default preference values.
 */
public class FSMLPreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = FsmlEditPlugin.getPlugin().getPreferenceStore();
		store.setDefault(FSMLPreferenceConstants.LOG_FEATURE_INSTANCE_ID, true);
		store.setDefault(FSMLPreferenceConstants.LOG_METAMODEL_ANNOTATIONS_ID, false);
		store.setDefault(FSMLPreferenceConstants.LOG_CODE_PATTERN_VARIANTS_ID, false);
		store.setDefault(FSMLPreferenceConstants.LOG_ERRORS_ID, true);
		store.setDefault(FSMLPreferenceConstants.LOG_MESSAGES_ID, true);
		store.setDefault(FSMLPreferenceConstants.LOG_BUGS_ID, true);
		store.setDefault(FSMLPreferenceConstants.COMPUTE_SCATTERING_AND_TANGLING_MEASURES_ID, false);
	}

}
