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
 * $Id: SingleTaskThread.java,v 1.1 2008/03/12 16:58:21 Michal Antkiewicz <mantkiew@gsd.uwaterloo.ca> $
 */
package ca.uwaterloo.gsd.applet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Task Thread</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ca.uwaterloo.gsd.applet.SingleTaskThread#isRunnable <em>Runnable</em>}</li>
 *   <li>{@link ca.uwaterloo.gsd.applet.SingleTaskThread#getRunnableField <em>Runnable Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see ca.uwaterloo.gsd.applet.AppletPackage#getSingleTaskThread()
 * @model annotation="featureGroup lowerBound='1' upperBound='1'"
 * @generated
 */
public interface SingleTaskThread extends EObject {
	/**
	 * Returns the value of the '<em><b>Runnable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runnable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runnable</em>' attribute.
	 * @see #setRunnable(boolean)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getSingleTaskThread_Runnable()
	 * @model annotation="argumentIsNew index='1' class='java.lang.Runnable' signature='()V'"
	 * @generated
	 */
	boolean isRunnable();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.SingleTaskThread#isRunnable <em>Runnable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runnable</em>' attribute.
	 * @see #isRunnable()
	 * @generated
	 */
	void setRunnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Runnable Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runnable Field</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runnable Field</em>' containment reference.
	 * @see #setRunnableField(RunnableField)
	 * @see ca.uwaterloo.gsd.applet.AppletPackage#getSingleTaskThread_RunnableField()
	 * @model containment="true"
	 *        annotation="argumentIsField index='1'"
	 * @generated
	 */
	RunnableField getRunnableField();

	/**
	 * Sets the value of the '{@link ca.uwaterloo.gsd.applet.SingleTaskThread#getRunnableField <em>Runnable Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runnable Field</em>' containment reference.
	 * @see #getRunnableField()
	 * @generated
	 */
	void setRunnableField(RunnableField value);

} // SingleTaskThread
