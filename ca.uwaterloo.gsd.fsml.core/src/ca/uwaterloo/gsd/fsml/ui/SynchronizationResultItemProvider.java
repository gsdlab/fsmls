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
package ca.uwaterloo.gsd.fsml.ui;

import java.util.Collection;

import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;

/**
 * @author Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca>
 *
 */
public class SynchronizationResultItemProvider 
	implements ITreeItemContentProvider {
	Collection<ClassSyncItem> target;
	
	public SynchronizationResultItemProvider(Collection<ClassSyncItem> result) {
		target = result;
	}

	public Collection getChildren(Object object) {
		return target;
	}

	public Object getParent(Object object) {
		return null;
	}

	public boolean hasChildren(Object object) {
		return target != null && target.size() > 0;
	}

	public Collection getElements(Object object) {
		return target;
	}

}
