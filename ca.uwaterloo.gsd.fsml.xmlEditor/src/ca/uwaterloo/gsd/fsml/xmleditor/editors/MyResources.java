/*******************************************************************************
 * Copyright (c) 2010 Herman Lee.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Herman Lee - initial API and implementation
 ******************************************************************************/
package ca.uwaterloo.gsd.fsml.xmleditor.editors;

import java.util.ListResourceBundle;

public class MyResources extends ListResourceBundle {
    public Object[][] getContents() {
            return contents;
    }
    static final Object[][] contents = {
    // LOCALIZE THIS
            {"ContentAssistProposal.label", "Content assist"},
            {"ContentAssistProposal.tooltip", "Content assist"},
            {"ContentAssistProposal.description", "Provides Content Assistance"},
    // END OF MATERIAL TO LOCALIZE
    };
}
