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

import org.eclipse.jface.action.Action;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.wst.sse.ui.internal.editor.StructuredModelDocumentProvider;

public class XMLEditor extends TextEditor {

	private ColorManager colorManager;

	public XMLEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(StructuredModelDocumentProvider.getInstance());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}
	
	
	
	@Override
	protected void createActions() {
		super.createActions();
		
		Action action = new ContentAssistAction(new MyResources(), "ContentAssistProposal.", this); 
		String id = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
		action.setActionDefinitionId(id);
		setAction("ContentAssistProposal", action); 
		markAsStateDependentAction("ContentAssistProposal", true);
	}
}
