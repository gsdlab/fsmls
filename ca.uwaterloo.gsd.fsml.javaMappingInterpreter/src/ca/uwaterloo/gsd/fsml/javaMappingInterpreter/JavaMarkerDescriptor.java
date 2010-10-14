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
package ca.uwaterloo.gsd.fsml.javaMappingInterpreter;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.search.SearchMatch;

import ca.uwaterloo.gsd.fsml.core.MarkerDescriptor;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 */
public class JavaMarkerDescriptor extends MarkerDescriptor {
	public static final String FULLY_QUALIFIED_NAME = "fullyQualifiedName";
	/**
	 * Marker descriptor for sources.
	 * @param resource
	 */
	public JavaMarkerDescriptor(IResource resource) {
		super(resource);
	}
	/**
	 * Marker descriptor for binaries.
	 * @param resource
	 * @param fullyQualifiedName
	 */
	public JavaMarkerDescriptor(IResource resource, String fullyQualifiedName) {
		super(resource);
		customAttribute = FULLY_QUALIFIED_NAME;
		customAttributeValue = fullyQualifiedName;
	}
	public JavaMarkerDescriptor(String id) {
		super(id);
	}
	/**
	 * Convenience function. Retrieves name of the feature, and charStart, charEnd from the match.
	 * @param feature
	 * @param astNode
	 */
	public void setAttributes(EStructuralFeature feature, ASTNode astNode) {
		if (feature != null)
			this.feature = feature;
		setCharStartCharEnd(astNode);
	}
	public void setCharStartCharEnd(SearchMatch match) {
		this.charStart = match.getOffset();
		this.charEnd = match.getOffset()+match.getLength();
	}
	public void setCharStartCharEnd(ISourceRange range) {
		this.charStart = range.getOffset();
		this.charEnd = range.getOffset()+range.getLength();
	}
	public void setCharStartCharEnd(IMember iMember) {
		try {
			// first try to get name range
			ISourceRange nameRange = iMember.getNameRange();
			//if (nameRange != null) {
			if (false) {
				setCharStartCharEnd(nameRange);
			}
			else {
				this.charStart = iMember.getSourceRange().getOffset();
				this.charEnd = charStart + iMember.getSourceRange().getLength();
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	public void setCharStartCharEnd(ASTNode astNode) {
		this.charStart = astNode.getStartPosition();
		this.charEnd = charStart+astNode.getLength();
	}
	public void setCharStartCharEnd(ITypeRoot iRootType) {
		try {
			setCharStartCharEnd(iRootType.getSourceRange());
		} catch (JavaModelException e) {
			e.printStackTrace();
		}		
	}
}
