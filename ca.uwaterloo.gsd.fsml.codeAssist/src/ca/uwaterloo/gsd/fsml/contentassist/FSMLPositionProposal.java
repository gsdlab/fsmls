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
package ca.uwaterloo.gsd.fsml.contentassist;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.internal.corext.fix.LinkedProposalPositionGroup;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.swt.graphics.Image;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;

public class FSMLPositionProposal extends LinkedProposalPositionGroup.Proposal {

	FSMLJavaProposal proposal;
	IEditorPart part;
	IDocument document;

	public FSMLPositionProposal(String groupId, String name, ICompilationUnit cu, ASTRewrite rewrite, 
			EObject element, EClass concreteClass, EStructuralFeature feature, ASTNode coveringNode, 
			int invocationOffset, Image image, int relevance, Resource resource, IEditorPart part, IDocument document) {
		super(name, image, relevance);
		this.part = part;
		this.document = document;
		//create an instance of FSMProposal
		proposal = new FSMLJavaProposal(name,cu,rewrite,relevance,image,element,concreteClass,feature,coveringNode,invocationOffset,resource,null);
		
	}

	@Override
	public TextEdit computeEdits(int offset, LinkedPosition position,
			char trigger, int stateMask, LinkedModeModel model)
			throws CoreException {
		//do the actual change
		proposal.performChange(part, document);
		//no text edit to return
		return null;
	}

}
