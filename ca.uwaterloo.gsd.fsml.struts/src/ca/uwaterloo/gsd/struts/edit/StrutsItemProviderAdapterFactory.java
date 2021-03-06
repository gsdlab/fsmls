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
 * $Id: StrutsItemProviderAdapterFactory.java,v 1.11 2008/03/20 04:01:53 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.struts.edit;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import ca.uwaterloo.gsd.struts.util.StrutsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StrutsItemProviderAdapterFactory extends StrutsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrutsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.StrutsApplication} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StrutsApplicationItemProvider strutsApplicationItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.StrutsApplication}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStrutsApplicationAdapter() {
		if (strutsApplicationItemProvider == null) {
			strutsApplicationItemProvider = new StrutsApplicationItemProvider(this);
		}

		return strutsApplicationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.FormImpl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormImplItemProvider formImplItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.FormImpl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFormImplAdapter() {
		if (formImplItemProvider == null) {
			formImplItemProvider = new FormImplItemProvider(this);
		}

		return formImplItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.ExtendsActionForm} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsActionFormItemProvider extendsActionFormItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.ExtendsActionForm}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExtendsActionFormAdapter() {
		if (extendsActionFormItemProvider == null) {
			extendsActionFormItemProvider = new ExtendsActionFormItemProvider(this);
		}

		return extendsActionFormItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.ActionImpl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImplItemProvider actionImplItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.ActionImpl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActionImplAdapter() {
		if (actionImplItemProvider == null) {
			actionImplItemProvider = new ActionImplItemProvider(this);
		}

		return actionImplItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.ForwardImpl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForwardImplItemProvider forwardImplItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.ForwardImpl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createForwardImplAdapter() {
		if (forwardImplItemProvider == null) {
			forwardImplItemProvider = new ForwardImplItemProvider(this);
		}

		return forwardImplItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.InputForwardImpl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputForwardImplItemProvider inputForwardImplItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.InputForwardImpl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInputForwardImplAdapter() {
		if (inputForwardImplItemProvider == null) {
			inputForwardImplItemProvider = new InputForwardImplItemProvider(this);
		}

		return inputForwardImplItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.Forward} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForwardItemProvider forwardItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.Forward}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createForwardAdapter() {
		if (forwardItemProvider == null) {
			forwardItemProvider = new ForwardItemProvider(this);
		}

		return forwardItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.ExtendsAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsActionItemProvider extendsActionItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.ExtendsAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExtendsActionAdapter() {
		if (extendsActionItemProvider == null) {
			extendsActionItemProvider = new ExtendsActionItemProvider(this);
		}

		return extendsActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.ExtendsDispatchAction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendsDispatchActionItemProvider extendsDispatchActionItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.ExtendsDispatchAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExtendsDispatchActionAdapter() {
		if (extendsDispatchActionItemProvider == null) {
			extendsDispatchActionItemProvider = new ExtendsDispatchActionItemProvider(this);
		}

		return extendsDispatchActionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.StrutsConfig} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StrutsConfigItemProvider strutsConfigItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.StrutsConfig}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStrutsConfigAdapter() {
		if (strutsConfigItemProvider == null) {
			strutsConfigItemProvider = new StrutsConfigItemProvider(this);
		}

		return strutsConfigItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.ActionDecl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionDeclItemProvider actionDeclItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.ActionDecl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActionDeclAdapter() {
		if (actionDeclItemProvider == null) {
			actionDeclItemProvider = new ActionDeclItemProvider(this);
		}

		return actionDeclItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.FormDecl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormDeclItemProvider formDeclItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.FormDecl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFormDeclAdapter() {
		if (formDeclItemProvider == null) {
			formDeclItemProvider = new FormDeclItemProvider(this);
		}

		return formDeclItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.ForwardDecl} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForwardDeclItemProvider forwardDeclItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.ForwardDecl}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createForwardDeclAdapter() {
		if (forwardDeclItemProvider == null) {
			forwardDeclItemProvider = new ForwardDeclItemProvider(this);
		}

		return forwardDeclItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ca.uwaterloo.gsd.struts.FormProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormPropertyItemProvider formPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link ca.uwaterloo.gsd.struts.FormProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFormPropertyAdapter() {
		if (formPropertyItemProvider == null) {
			formPropertyItemProvider = new FormPropertyItemProvider(this);
		}

		return formPropertyItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (strutsApplicationItemProvider != null) strutsApplicationItemProvider.dispose();
		if (formImplItemProvider != null) formImplItemProvider.dispose();
		if (extendsActionFormItemProvider != null) extendsActionFormItemProvider.dispose();
		if (actionImplItemProvider != null) actionImplItemProvider.dispose();
		if (forwardImplItemProvider != null) forwardImplItemProvider.dispose();
		if (inputForwardImplItemProvider != null) inputForwardImplItemProvider.dispose();
		if (forwardItemProvider != null) forwardItemProvider.dispose();
		if (extendsActionItemProvider != null) extendsActionItemProvider.dispose();
		if (extendsDispatchActionItemProvider != null) extendsDispatchActionItemProvider.dispose();
		if (strutsConfigItemProvider != null) strutsConfigItemProvider.dispose();
		if (actionDeclItemProvider != null) actionDeclItemProvider.dispose();
		if (formDeclItemProvider != null) formDeclItemProvider.dispose();
		if (forwardDeclItemProvider != null) forwardDeclItemProvider.dispose();
		if (formPropertyItemProvider != null) formPropertyItemProvider.dispose();
	}

}
