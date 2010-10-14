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
/**
  *
 *
 *
 * $Id: RequestsAdapterItemProvider.java,v 1.8 2008/01/16 04:12:46 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import ca.uwaterloo.gsd.fsml.fsml.provider.ConceptItemProvider;
import ca.uwaterloo.gsd.wpi.AdapterProvider;
import ca.uwaterloo.gsd.wpi.Part;
import ca.uwaterloo.gsd.wpi.RequestsAdapter;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * This is the item provider adapter for a {@link ca.uwaterloo.gsd.wpi.RequestsAdapter} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RequestsAdapterItemProvider
	extends ConceptItemProvider
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
	public RequestsAdapterItemProvider(AdapterFactory adapterFactory) {
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

			addAdapterPropertyDescriptor(object);
			addAdapterProviderPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Adapter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdapterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RequestsAdapter_adapter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RequestsAdapter_adapter_feature", "_UI_RequestsAdapter_type"),
				 WpiPackage.Literals.REQUESTS_ADAPTER__ADAPTER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Adapter Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdapterProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RequestsAdapter_adapterProvider_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RequestsAdapter_adapterProvider_feature", "_UI_RequestsAdapter_type"),
				 WpiPackage.Literals.REQUESTS_ADAPTER__ADAPTER_PROVIDER,
				 false,
				 true,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns RequestsAdapter.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RequestsAdapter"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		RequestsAdapter requestsAdapter = (RequestsAdapter)object;
		String label = requestsAdapter.getAdapter();
		EList<AdapterProvider> providers = requestsAdapter.getAdapterProvider();
		
		StringBuffer providersLabel = new StringBuffer();
		boolean isFirst = true;
		for (Object aux : providers) {
			AdapterProvider provider = (AdapterProvider) aux;
			Part part = provider.getAdapterProvider();
			
			providersLabel.append((isFirst ? "'" : ", '") + (part != null ? part.getName() : "<unknown part>") + "'");
			isFirst = false;
		}
		if (providersLabel.length() == 0)
			providersLabel.append("<unknown provider>");
		return (label == null || label.length() == 0 ? "<unknown>" : "'" + label +"'") + " adapter from " + providersLabel;
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

		switch (notification.getFeatureID(RequestsAdapter.class)) {
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER:
			case WpiPackage.REQUESTS_ADAPTER__ADAPTER_PROVIDER:
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
		return WpiEditPlugin.INSTANCE;
	}

}
