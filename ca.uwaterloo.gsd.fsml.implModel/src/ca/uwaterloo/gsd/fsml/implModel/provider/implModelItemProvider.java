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

package ca.uwaterloo.gsd.fsml.implModel.provider;


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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import ca.uwaterloo.gsd.fsml.implModel.ImplModelFactory;
import ca.uwaterloo.gsd.fsml.implModel.ImplModelPackage;
import ca.uwaterloo.gsd.fsml.implModel.implModel;

/**
 * This is the item provider adapter for a {@link ca.uwaterloo.gsd.fsml.implModel.implModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class implModelItemProvider
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
	public implModelItemProvider(AdapterFactory adapterFactory) {
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

			addDefaultsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Defaults feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_implModel_defaults_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_implModel_defaults_feature", "_UI_implModel_type"),
				 ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS);
			childrenFeatures.add(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS);
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
	 * This returns implModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/implModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_implModel_type");
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

		switch (notification.getFeatureID(implModel.class)) {
			case ImplModelPackage.IMPL_MODEL__DEFAULTS:
			case ImplModelPackage.IMPL_MODEL__VARIANTS:
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
				(ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS,
				 ImplModelFactory.eINSTANCE.createdefault_assignedWithNew()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS,
				 ImplModelFactory.eINSTANCE.createdefault_assignedWithNull()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS,
				 ImplModelFactory.eINSTANCE.createdefault_extendsClass()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS,
				 ImplModelFactory.eINSTANCE.createdefault_implementsInterface()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS,
				 ImplModelFactory.eINSTANCE.createdefault_callsReceived()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS,
				 ImplModelFactory.eINSTANCE.createdefault_methodCalls()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__DEFAULTS,
				 ImplModelFactory.eINSTANCE.createdefault_typedWith()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_assignedWithNew_Initializer()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_assignedWithNew_InMethod()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_extendsClass_Directly()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_extendsClass_Indirectly()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_implementsInterface_Directly()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_implementsInterface_Indirectly()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_callsReceived_InMethod()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_methodCalls_InMethod()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_typedWith_Directly()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_typedWith_Indirectly()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_assignedWithNull_Initializer()));

		newChildDescriptors.add
			(createChildParameter
				(ImplModelPackage.Literals.IMPL_MODEL__VARIANTS,
				 ImplModelFactory.eINSTANCE.createvariant_assignedWithNull_InMethod()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ImplModelEditPlugin.INSTANCE;
	}

}
