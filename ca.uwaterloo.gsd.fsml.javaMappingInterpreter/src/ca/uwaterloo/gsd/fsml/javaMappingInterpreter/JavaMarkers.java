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

import java.util.Vector;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

import ca.uwaterloo.gsd.fsml.core.Markers;

public class JavaMarkers {
	/**
	 * @param element
	 * @return
	 */
	public static JavaMarkerDescriptor createMarkerDescriptor(IJavaElement element) {
		if (element instanceof IType) {
			IType iType = (IType) element;
			if (iType.isBinary()) {
				String fullyQualifiedName = iType.getFullyQualifiedName();
				IResource resource = iType.getJavaProject().getResource();
				return new JavaMarkerDescriptor(resource, fullyQualifiedName);
			}
		}
		else if (element instanceof IMember) {
			IMember iMember = (IMember) element;
			if (iMember.isBinary()) {
				String fullyQualifiedName = iMember.getDeclaringType().getFullyQualifiedName();
				IResource resource = iMember.getJavaProject().getResource();
				return new JavaMarkerDescriptor(resource, fullyQualifiedName);
			}
		}
		else if (element instanceof IClassFile) {
			IClassFile classFile = (IClassFile) element;
			String fullyQualifiedName = classFile.findPrimaryType().getFullyQualifiedName();
			IResource resource = classFile.getJavaProject().getResource();
			return new JavaMarkerDescriptor(resource, fullyQualifiedName);
		}
		return new JavaMarkerDescriptor(element.getResource());
	}
	
	/**
	 * Get markers covered by an AST node
	 * @param node must not be null
	 */
	public static Vector<IMarker> getMarkersCoveredByNode(ASTNode node) {
		if (node.getRoot() instanceof CompilationUnit){
			return Markers.sortMarkers(
					Markers.INSTANCE.getMarkersFromResourceAtPosition(
							((CompilationUnit)node.getRoot()).getJavaElement().getResource(), 
							node.getStartPosition(), 
							node.getStartPosition()+node.getLength()
						)
					);
		}
		return null;
	}
}
