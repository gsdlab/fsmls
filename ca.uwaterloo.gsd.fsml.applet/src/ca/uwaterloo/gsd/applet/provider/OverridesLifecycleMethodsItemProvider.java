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
 * $Id: OverridesLifecycleMethodsItemProvider.java,v 1.4 2008/06/25 00:13:01 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.provider;


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
import org.eclipse.emf.edit.provider.ViewerNotification;

import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.applet.OverridesLifecycleMethods;
import ca.uwaterloo.gsd.fsml.fsml.provider.ConceptItemProvider;

/**
 * This is the item provider adapter for a {@link ca.uwaterloo.gsd.applet.OverridesLifecycleMethods} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OverridesLifecycleMethodsItemProvider
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
	public OverridesLifecycleMethodsItemProvider(AdapterFactory adapterFactory) {
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

			addInitPropertyDescriptor(object);
			addStartPropertyDescriptor(object);
			addPaintPropertyDescriptor(object);
			addStopPropertyDescriptor(object);
			addDestroyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Init feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OverridesLifecycleMethods_init_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OverridesLifecycleMethods_init_feature", "_UI_OverridesLifecycleMethods_type"),
				 AppletPackage.Literals.OVERRIDES_LIFECYCLE_METHODS__INIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Start feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OverridesLifecycleMethods_start_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OverridesLifecycleMethods_start_feature", "_UI_OverridesLifecycleMethods_type"),
				 AppletPackage.Literals.OVERRIDES_LIFECYCLE_METHODS__START,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Paint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPaintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OverridesLifecycleMethods_paint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OverridesLifecycleMethods_paint_feature", "_UI_OverridesLifecycleMethods_type"),
				 AppletPackage.Literals.OVERRIDES_LIFECYCLE_METHODS__PAINT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Stop feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OverridesLifecycleMethods_stop_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OverridesLifecycleMethods_stop_feature", "_UI_OverridesLifecycleMethods_type"),
				 AppletPackage.Literals.OVERRIDES_LIFECYCLE_METHODS__STOP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Destroy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDestroyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OverridesLifecycleMethods_destroy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OverridesLifecycleMethods_destroy_feature", "_UI_OverridesLifecycleMethods_type"),
				 AppletPackage.Literals.OVERRIDES_LIFECYCLE_METHODS__DESTROY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns OverridesLifecycleMethods.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OverridesLifecycleMethods"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		OverridesLifecycleMethods overridesLifecycleMethods = (OverridesLifecycleMethods)object;
		String init = overridesLifecycleMethods.isInit() ? " 'init'" : "";
		String start = overridesLifecycleMethods.isStart() ? " 'start'" : "";
		String paint = overridesLifecycleMethods.isPaint() ? " 'paint'" : "";
		String stop = overridesLifecycleMethods.isStop() ? " 'stop'" : "";
		String destroy = overridesLifecycleMethods.isDestroy() ? " 'destroy'" : "";
		
		return getString("_UI_OverridesLifecycleMethods_type") + ": " + init + start + paint + stop + destroy;
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

		switch (notification.getFeatureID(OverridesLifecycleMethods.class)) {
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__INIT:
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__START:
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__PAINT:
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__STOP:
			case AppletPackage.OVERRIDES_LIFECYCLE_METHODS__DESTROY:
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
		return AppletEditPlugin.INSTANCE;
	}

}
