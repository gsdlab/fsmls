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

import java.util.HashMap;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import ca.uwaterloo.gsd.fsml.sync.SynchronizationResult;

/**
 * This is the central singleton for the Sync edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class SyncEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SyncEditPlugin INSTANCE = new SyncEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SyncEditPlugin() {
		super(new ResourceLocator [] {   
		});
		model2synchronizationResultMap = new HashMap<EObject, SynchronizationResult>();
		package2adapterFactoryMap = new HashMap<EPackage, AdapterFactory>();
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}
	/**
	 * map between fsml models and their synchronization results
	 */
	HashMap<EObject, SynchronizationResult> model2synchronizationResultMap;
	
	public SynchronizationResult getSynchronizationResult(EObject model) {
		return model2synchronizationResultMap.get(model);
	}
	public void putSynchronizationResult(EObject model, SynchronizationResult result) {
		model2synchronizationResultMap.put(model, result);
	}
	public void removeObject2syncItemMap(EObject model) {
		model2synchronizationResultMap.remove(model);
	}
	/**
	 * map between fsml packages and their adapter factories
	 */
	HashMap<EPackage, AdapterFactory> package2adapterFactoryMap;
	
	public AdapterFactory getAdapterFactory(EPackage ePackage) {
		return package2adapterFactoryMap.get(ePackage);
	}
	public AdapterFactory getAdapterFactory(EObject eObject) {
		return package2adapterFactoryMap.get(eObject.eClass().getEPackage());
	}
	public void putAdapterFactory(EPackage ePackage, AdapterFactory adapterFactory) {
		package2adapterFactoryMap.put(ePackage, adapterFactory);
	}
	public void removeAdapterFactory(EPackage ePackage) {
		package2adapterFactoryMap.remove(ePackage);
	}
}
