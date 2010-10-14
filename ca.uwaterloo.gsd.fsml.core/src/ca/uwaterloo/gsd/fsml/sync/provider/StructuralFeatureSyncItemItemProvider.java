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
package ca.uwaterloo.gsd.fsml.sync.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;

/**
 * This is the item provider adapter for a {@link ca.uwaterloo.gsd.fsml.sync.StructuralFeatureSyncItem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuralFeatureSyncItemItemProvider
	extends SyncItemItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralFeatureSyncItemItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns AttributeSyncItem.gif.
	 * <!-- begin-user-doc -->
	 * Michal: use super
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage(Object object) {
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * Michal: just display feature name
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getText(Object object) {
		StructuralFeatureSyncItem attributeSyncItem = (StructuralFeatureSyncItem)object;
		String label = attributeSyncItem.getStructuralFeature().getName();
		// show value change and direction
		StringBuffer change = new StringBuffer();
		if (attributeSyncItem.getSynchronizationState() != SynchronizationState.UNCHANGED_LITERAL) {	
			ClassSyncItem parent = (ClassSyncItem) attributeSyncItem.eContainer();
			EObject model = parent.getModel();
			EObject code = parent.getCode();
			if (!attributeSyncItem.getStructuralFeature().getEType().getName().equals("EBoolean")) {
				Object modelValue = model != null ? model.eGet(attributeSyncItem.getStructuralFeature()) : "null";
				Object codeValue = code != null ? code.eGet(attributeSyncItem.getStructuralFeature()) : "null";
				change.append(" (");
				switch (attributeSyncItem.getSynchronizationState().getValue()) {
				case SynchronizationState.ADDED_MODEL:
				case SynchronizationState.REMOVED_MODEL:
					change.append(modelValue);
					break;
				case SynchronizationState.CHANGED_MODEL:
					change.append(modelValue + " |-> " + codeValue);
					break;
				case SynchronizationState.ADDED_CODE:
				case SynchronizationState.REMOVED_CODE:
					change.append(codeValue);
					break;
				case SynchronizationState.CHANGED_CODE:
					change.append(modelValue + " <-' " + codeValue);
					break;
				case SynchronizationState.ADDED_INCONSISTENTLY:
				case SynchronizationState.CHANGED_INCONSISTENTLY:
					change.append(modelValue + " <-> " + codeValue);
					break;
				case SynchronizationState.REMOVED_CODE_CHANGED_MODEL:
				case SynchronizationState.REMOVED_MODEL_CHANGED_CODE:
					change.append(modelValue + " <-' |-> " + codeValue);
					break;
				}
				change.append(") ");
			}
		}
		ReconciliationDecision decision = attributeSyncItem.getReconciliationDecision();
		String decisionLabel = "(" + decision.getName() +") ";
		String errorLabel = attributeSyncItem.getResult() != null ?
				"(Error: " + attributeSyncItem.getResult() +") " : "";
		return label == null || label.length() == 0 ?
			getString("_UI_StructuralFeatureSyncItem_type") :
			errorLabel + decisionLabel + label + change.toString();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SyncEditPlugin.INSTANCE;
	}

}
