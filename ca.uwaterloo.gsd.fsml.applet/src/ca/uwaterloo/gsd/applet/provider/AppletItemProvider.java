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
 * $Id: AppletItemProvider.java,v 1.16 2009/04/21 18:26:19 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import ca.uwaterloo.gsd.applet.Applet;
import ca.uwaterloo.gsd.applet.AppletFactory;
import ca.uwaterloo.gsd.applet.AppletPackage;
import ca.uwaterloo.gsd.fsml.ecore.FSMLEcoreUtil;
import ca.uwaterloo.gsd.fsml.fsml.provider.ConceptItemProvider;

/**
 * This is the item provider adapter for a {@link ca.uwaterloo.gsd.applet.Applet} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AppletItemProvider
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
	public AppletItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addProvidesParameterInfoPropertyDescriptor(object);
			addProvidesInfoForParametersPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Applet_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Applet_name_feature", "_UI_Applet_type"),
				 AppletPackage.Literals.APPLET__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provides Parameter Info feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidesParameterInfoPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Applet_providesParameterInfo_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Applet_providesParameterInfo_feature", "_UI_Applet_type"),
				 AppletPackage.Literals.APPLET__PROVIDES_PARAMETER_INFO,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provides Info For Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProvidesInfoForParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Applet_providesInfoForParameters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Applet_providesInfoForParameters_feature", "_UI_Applet_type"),
				 AppletPackage.Literals.APPLET__PROVIDES_INFO_FOR_PARAMETERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(AppletPackage.Literals.APPLET__EXTENDS_APPLET);
			childrenFeatures.add(AppletPackage.Literals.APPLET__OVERRIDES_LIFECYCLE_METHODS);
			childrenFeatures.add(AppletPackage.Literals.APPLET__SHOWS_STATUS);
			childrenFeatures.add(AppletPackage.Literals.APPLET__REGISTERS_MOUSE_LISTENER);
			childrenFeatures.add(AppletPackage.Literals.APPLET__REGISTERS_MOUSE_MOTION_LISTENER);
			childrenFeatures.add(AppletPackage.Literals.APPLET__REGISTERS_KEY_LISTENER);
			childrenFeatures.add(AppletPackage.Literals.APPLET__THREAD);
			childrenFeatures.add(AppletPackage.Literals.APPLET__SINGLE_TASK_THREAD);
			childrenFeatures.add(AppletPackage.Literals.APPLET__PARAMETER);
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
	 * This returns Applet.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Applet"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((Applet)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Applet_type") :
			getString("_UI_Applet_type") + " '" + label + "'";
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

		switch (notification.getFeatureID(Applet.class)) {
			case AppletPackage.APPLET__NAME:
			case AppletPackage.APPLET__PROVIDES_PARAMETER_INFO:
			case AppletPackage.APPLET__PROVIDES_INFO_FOR_PARAMETERS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AppletPackage.APPLET__EXTENDS_APPLET:
			case AppletPackage.APPLET__OVERRIDES_LIFECYCLE_METHODS:
			case AppletPackage.APPLET__SHOWS_STATUS:
			case AppletPackage.APPLET__REGISTERS_MOUSE_LISTENER:
			case AppletPackage.APPLET__REGISTERS_MOUSE_MOTION_LISTENER:
			case AppletPackage.APPLET__REGISTERS_KEY_LISTENER:
			case AppletPackage.APPLET__THREAD:
			case AppletPackage.APPLET__SINGLE_TASK_THREAD:
			case AppletPackage.APPLET__PARAMETER:
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
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__EXTENDS_APPLET,
				 FSMLEcoreUtil.instantiateSubtree(
						 AppletFactory.eINSTANCE.createExtendsApplet())));

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__OVERRIDES_LIFECYCLE_METHODS,
				 FSMLEcoreUtil.instantiateSubtree(
						 AppletFactory.eINSTANCE.createOverridesLifecycleMethods())));

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__SHOWS_STATUS,
				 FSMLEcoreUtil.instantiateSubtree(
						AppletFactory.eINSTANCE.createShowsStatus())));

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__REGISTERS_MOUSE_LISTENER,
					FSMLEcoreUtil.instantiateSubtree(
							AppletFactory.eINSTANCE.createRegistersMouseListener())));

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__REGISTERS_MOUSE_MOTION_LISTENER,
					FSMLEcoreUtil.instantiateSubtree(
							AppletFactory.eINSTANCE.createRegistersMouseMotionListener())));

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__REGISTERS_KEY_LISTENER,
					FSMLEcoreUtil.instantiateSubtree(AppletFactory.eINSTANCE.createRegistersKeyListener())));

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__THREAD,
					FSMLEcoreUtil.instantiateSubtree(AppletFactory.eINSTANCE.createThread())));

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__SINGLE_TASK_THREAD,
					FSMLEcoreUtil.instantiateSubtree(AppletFactory.eINSTANCE.createSingleTaskThread())));

		newChildDescriptors.add
			(createChildParameter
				(AppletPackage.Literals.APPLET__PARAMETER,
					FSMLEcoreUtil.instantiateSubtree(AppletFactory.eINSTANCE.createParameter())));
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
