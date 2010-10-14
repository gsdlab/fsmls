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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import ca.uwaterloo.gsd.fsml.sync.ClassSyncItem;
import ca.uwaterloo.gsd.fsml.sync.ReconciliationDecision;
import ca.uwaterloo.gsd.fsml.sync.SyncFactory;
import ca.uwaterloo.gsd.fsml.sync.SyncPackage;

/**
 * This is the item provider adapter for a {@link ca.uwaterloo.gsd.fsml.sync.ClassSyncItem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassSyncItemItemProvider
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
	public ClassSyncItemItemProvider(AdapterFactory adapterFactory) {
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
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SyncPackage.Literals.CLASS_SYNC_ITEM__SYNC_ITEMS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * Michal: use super
	 * @generated NOT
	 */
	public Object getImage(Object object) {
		return super.getImage(object);
	}
	/**
	 * This returns the label text for the adapted class.
	 * Michal: display full concept info + reconciliation decision
	 * @generated NOT
	 */
	public String getText(Object object) {
		ClassSyncItem classSyncItem = (ClassSyncItem)object;
		EObject element = classSyncItem.getModel();
		if (element == null)
			element = classSyncItem.getCode();
		if (element == null)
			return "<eroor : element is null>";
		
		Adapter adapter = null;
		
		for (Object aux : element.eAdapters()) {
			if (aux instanceof IItemLabelProvider) {
				adapter =  (Adapter) aux;			}
		}
		if (adapter == null) {
			AdapterFactory adapterFactory = SyncEditPlugin.INSTANCE.getAdapterFactory(element);
			if (adapterFactory != null)
				adapter = adapterFactory.adapt(element, IItemLabelProvider.class);
		}
		ReconciliationDecision decision = classSyncItem.getReconciliationDecision();
		String decisionLabel = "(" + decision.getName() +") ";
		String errorLabel = classSyncItem.getResult() != null ?
				"(Error: " + classSyncItem.getResult() +") " : "";
		if (adapter != null && adapter instanceof IItemLabelProvider)
			return errorLabel + decisionLabel + ((IItemLabelProvider) adapter).getText(element);
		else {
			return errorLabel + decisionLabel + element.toString();
		}
			
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

		switch (notification.getFeatureID(ClassSyncItem.class)) {
			case SyncPackage.CLASS_SYNC_ITEM__SYNC_ITEMS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(SyncPackage.Literals.CLASS_SYNC_ITEM__SYNC_ITEMS,
				 SyncFactory.eINSTANCE.createClassSyncItem()));

		newChildDescriptors.add
			(createChildParameter
				(SyncPackage.Literals.CLASS_SYNC_ITEM__SYNC_ITEMS,
				 SyncFactory.eINSTANCE.createStructuralFeatureSyncItem()));
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
