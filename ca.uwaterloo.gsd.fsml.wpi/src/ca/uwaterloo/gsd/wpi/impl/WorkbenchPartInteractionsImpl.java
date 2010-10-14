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
 * $Id: WorkbenchPartInteractionsImpl.java,v 1.6 2008/01/23 03:24:47 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.wpi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ca.uwaterloo.gsd.fsml.fsml.impl.ConceptImpl;
import ca.uwaterloo.gsd.wpi.AdapterProvider;
import ca.uwaterloo.gsd.wpi.AdapterRequestor;
import ca.uwaterloo.gsd.wpi.Part;
import ca.uwaterloo.gsd.wpi.PartListener;
import ca.uwaterloo.gsd.wpi.SelectionListener;
import ca.uwaterloo.gsd.wpi.SelectionProvider;
import ca.uwaterloo.gsd.wpi.WorkbenchPartInteractions;
import ca.uwaterloo.gsd.wpi.WpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workbench Part Interactions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl#getProject <em>Project</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl#getSelectionProviders <em>Selection Providers</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl#getSelectionListeners <em>Selection Listeners</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl#getPartListeners <em>Part Listeners</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl#getAdapterProviders <em>Adapter Providers</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.wpi.impl.WorkbenchPartInteractionsImpl#getAdapterRequestors <em>Adapter Requestors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkbenchPartInteractionsImpl extends ConceptImpl implements WorkbenchPartInteractions {
	/**
	 * The default value of the '{@link #getProject() <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected String project = PROJECT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<Part> parts;

	/**
	 * The cached value of the '{@link #getSelectionProviders() <em>Selection Providers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<SelectionProvider> selectionProviders;

	/**
	 * The cached value of the '{@link #getSelectionListeners() <em>Selection Listeners</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionListeners()
	 * @generated
	 * @ordered
	 */
	protected EList<SelectionListener> selectionListeners;

	/**
	 * The cached value of the '{@link #getPartListeners() <em>Part Listeners</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartListeners()
	 * @generated
	 * @ordered
	 */
	protected EList<PartListener> partListeners;

	/**
	 * The cached value of the '{@link #getAdapterProviders() <em>Adapter Providers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapterProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<AdapterProvider> adapterProviders;

	/**
	 * The cached value of the '{@link #getAdapterRequestors() <em>Adapter Requestors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapterRequestors()
	 * @generated
	 * @ordered
	 */
	protected EList<AdapterRequestor> adapterRequestors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkbenchPartInteractionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WpiPackage.Literals.WORKBENCH_PART_INTERACTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(String newProject) {
		String oldProject = project;
		project = newProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WpiPackage.WORKBENCH_PART_INTERACTIONS__PROJECT, oldProject, project));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Part> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentEList<Part>(Part.class, this, WpiPackage.WORKBENCH_PART_INTERACTIONS__PARTS);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SelectionProvider> getSelectionProviders() {
		if (selectionProviders == null) {
			selectionProviders = new EObjectContainmentEList<SelectionProvider>(SelectionProvider.class, this, WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS);
		}
		return selectionProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SelectionListener> getSelectionListeners() {
		if (selectionListeners == null) {
			selectionListeners = new EObjectContainmentEList<SelectionListener>(SelectionListener.class, this, WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS);
		}
		return selectionListeners;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PartListener> getPartListeners() {
		if (partListeners == null) {
			partListeners = new EObjectContainmentEList<PartListener>(PartListener.class, this, WpiPackage.WORKBENCH_PART_INTERACTIONS__PART_LISTENERS);
		}
		return partListeners;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdapterProvider> getAdapterProviders() {
		if (adapterProviders == null) {
			adapterProviders = new EObjectContainmentEList<AdapterProvider>(AdapterProvider.class, this, WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS);
		}
		return adapterProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdapterRequestor> getAdapterRequestors() {
		if (adapterRequestors == null) {
			adapterRequestors = new EObjectContainmentEList<AdapterRequestor>(AdapterRequestor.class, this, WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS);
		}
		return adapterRequestors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS:
				return ((InternalEList<?>)getSelectionProviders()).basicRemove(otherEnd, msgs);
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS:
				return ((InternalEList<?>)getSelectionListeners()).basicRemove(otherEnd, msgs);
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PART_LISTENERS:
				return ((InternalEList<?>)getPartListeners()).basicRemove(otherEnd, msgs);
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS:
				return ((InternalEList<?>)getAdapterProviders()).basicRemove(otherEnd, msgs);
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS:
				return ((InternalEList<?>)getAdapterRequestors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PROJECT:
				return getProject();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PARTS:
				return getParts();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS:
				return getSelectionProviders();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS:
				return getSelectionListeners();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PART_LISTENERS:
				return getPartListeners();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS:
				return getAdapterProviders();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS:
				return getAdapterRequestors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PROJECT:
				setProject((String)newValue);
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends Part>)newValue);
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS:
				getSelectionProviders().clear();
				getSelectionProviders().addAll((Collection<? extends SelectionProvider>)newValue);
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS:
				getSelectionListeners().clear();
				getSelectionListeners().addAll((Collection<? extends SelectionListener>)newValue);
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PART_LISTENERS:
				getPartListeners().clear();
				getPartListeners().addAll((Collection<? extends PartListener>)newValue);
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS:
				getAdapterProviders().clear();
				getAdapterProviders().addAll((Collection<? extends AdapterProvider>)newValue);
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS:
				getAdapterRequestors().clear();
				getAdapterRequestors().addAll((Collection<? extends AdapterRequestor>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PROJECT:
				setProject(PROJECT_EDEFAULT);
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PARTS:
				getParts().clear();
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS:
				getSelectionProviders().clear();
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS:
				getSelectionListeners().clear();
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PART_LISTENERS:
				getPartListeners().clear();
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS:
				getAdapterProviders().clear();
				return;
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS:
				getAdapterRequestors().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PROJECT:
				return PROJECT_EDEFAULT == null ? project != null : !PROJECT_EDEFAULT.equals(project);
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PARTS:
				return parts != null && !parts.isEmpty();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_PROVIDERS:
				return selectionProviders != null && !selectionProviders.isEmpty();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__SELECTION_LISTENERS:
				return selectionListeners != null && !selectionListeners.isEmpty();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__PART_LISTENERS:
				return partListeners != null && !partListeners.isEmpty();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_PROVIDERS:
				return adapterProviders != null && !adapterProviders.isEmpty();
			case WpiPackage.WORKBENCH_PART_INTERACTIONS__ADAPTER_REQUESTORS:
				return adapterRequestors != null && !adapterRequestors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (project: ");
		result.append(project);
		result.append(')');
		return result.toString();
	}

} //WorkbenchPartInteractionsImpl
