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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import ca.uwaterloo.gsd.fsml.sync.SyncItem;
import ca.uwaterloo.gsd.fsml.sync.SyncPackage;
import ca.uwaterloo.gsd.fsml.sync.SynchronizationState;

/**
 * This is the item provider adapter for a {@link ca.uwaterloo.gsd.fsml.sync.SyncItem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SyncItemItemProvider
	extends ItemProviderAdapter
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
	public SyncItemItemProvider(AdapterFactory adapterFactory) {
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

			addSynchronizationStatePropertyDescriptor(object);
			addReconciliationDecisionPropertyDescriptor(object);
			addResultPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Synchronization State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSynchronizationStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SyncItem_synchronizationState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SyncItem_synchronizationState_feature", "_UI_SyncItem_type"),
				 SyncPackage.Literals.SYNC_ITEM__SYNCHRONIZATION_STATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Reconciliation Decision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReconciliationDecisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SyncItem_reconciliationDecision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SyncItem_reconciliationDecision_feature", "_UI_SyncItem_type"),
				 SyncPackage.Literals.SYNC_ITEM__RECONCILIATION_DECISION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Result feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SyncItem_result_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SyncItem_result_feature", "_UI_SyncItem_type"),
				 SyncPackage.Literals.SYNC_ITEM__RESULT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns SyncItem.gif.
	 * <!-- begin-user-doc -->
	 * Michal: depends on synchronization state
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage(Object object) {
		SyncItem syncItem = (SyncItem) object;
		switch (syncItem.getSynchronizationState().getValue()) {
		case SynchronizationState.CHANGED_INCONSISTENTLY:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/changedInconsistently"));
		case SynchronizationState.ADDED_INCONSISTENTLY:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/addedInconsistently"));
		case SynchronizationState.REMOVED_CODE_CHANGED_MODEL:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/removedCodeChangedModel"));
		case SynchronizationState.REMOVED_MODEL_CHANGED_CODE:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/removedModelChangedCode"));
		case SynchronizationState.ADDED_MODEL:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/addedModel"));
		case SynchronizationState.CHANGED_MODEL:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/changedModel"));
		case SynchronizationState.REMOVED_MODEL:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/removedModel"));
		case SynchronizationState.ADDED_CODE:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/addedCode"));
		case SynchronizationState.CHANGED_CODE:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/changedCode"));
		case SynchronizationState.REMOVED_CODE:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/removedCode"));
		case SynchronizationState.UNCHANGED:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/unchanged"));
		case SynchronizationState.CHANGED:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/changed"));
		case SynchronizationState.UNSPECIFIED:
			return overlayImage(object, getResourceLocator().getImage("full/syncStates/unspecified"));
		default:
			return null;
		}
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		SynchronizationState labelValue = ((SyncItem)object).getSynchronizationState();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_SyncItem_type") :
			getString("_UI_SyncItem_type") + " " + label;
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

		switch (notification.getFeatureID(SyncItem.class)) {
			case SyncPackage.SYNC_ITEM__SYNCHRONIZATION_STATE:
			case SyncPackage.SYNC_ITEM__RECONCILIATION_DECISION:
			case SyncPackage.SYNC_ITEM__RESULT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
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
