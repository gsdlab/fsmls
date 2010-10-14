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
package ca.uwaterloo.gsd.fsml.sync;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Reconciliation Decision</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getReconciliationDecision()
 * @model
 * @generated
 */
public enum ReconciliationDecision implements Enumerator
{
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED_LITERAL(-1, "unspecified", "unspecified"),
	/**
	 * The '<em><b>Ignore</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE
	 * @generated
	 * @ordered
	 */
	IGNORE_LITERAL(0, "ignore", "ignore"),
	/**
	 * The '<em><b>Enforce</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENFORCE
	 * @generated
	 * @ordered
	 */
	ENFORCE_LITERAL(1, "enforce", "enforce"),
	/**
	 * The '<em><b>Update</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE
	 * @generated
	 * @ordered
	 */
	UPDATE_LITERAL(2, "update", "update"),
	/**
	 * The '<em><b>Override And Enforce</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_AND_ENFORCE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_AND_ENFORCE_LITERAL(3, "overrideAndEnforce", "overrideAndEnforce"),
	/**
	 * The '<em><b>Override And Update</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_AND_UPDATE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_AND_UPDATE_LITERAL(4, "overrideAndUpdate", "overrideAndUpdate"),
	/**
	 * The '<em><b>Enforce And Update</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENFORCE_AND_UPDATE
	 * @generated
	 * @ordered
	 */
	ENFORCE_AND_UPDATE_LITERAL(5, "enforceAndUpdate", "enforceAndUpdate");
	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unspecified</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_LITERAL
	 * @model name="unspecified"
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED = -1;

	/**
	 * The '<em><b>Ignore</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ignore</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IGNORE_LITERAL
	 * @model name="ignore"
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE = 0;

	/**
	 * The '<em><b>Enforce</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Enforce</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENFORCE_LITERAL
	 * @model name="enforce"
	 * @generated
	 * @ordered
	 */
	public static final int ENFORCE = 1;

	/**
	 * The '<em><b>Update</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Update</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPDATE_LITERAL
	 * @model name="update"
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE = 2;

	/**
	 * The '<em><b>Override And Enforce</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Override And Enforce</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_AND_ENFORCE_LITERAL
	 * @model name="overrideAndEnforce"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_AND_ENFORCE = 3;

	/**
	 * The '<em><b>Override And Update</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Override And Update</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_AND_UPDATE_LITERAL
	 * @model name="overrideAndUpdate"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_AND_UPDATE = 4;

	/**
	 * The '<em><b>Enforce And Update</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Enforce And Update</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENFORCE_AND_UPDATE_LITERAL
	 * @model name="enforceAndUpdate"
	 * @generated
	 * @ordered
	 */
	public static final int ENFORCE_AND_UPDATE = 5;

	/**
	 * An array of all the '<em><b>Reconciliation Decision</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ReconciliationDecision[] VALUES_ARRAY =
		new ReconciliationDecision[] {
			UNSPECIFIED_LITERAL,
			IGNORE_LITERAL,
			ENFORCE_LITERAL,
			UPDATE_LITERAL,
			OVERRIDE_AND_ENFORCE_LITERAL,
			OVERRIDE_AND_UPDATE_LITERAL,
			ENFORCE_AND_UPDATE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Reconciliation Decision</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ReconciliationDecision> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Reconciliation Decision</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReconciliationDecision get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReconciliationDecision result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reconciliation Decision</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReconciliationDecision getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ReconciliationDecision result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Reconciliation Decision</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReconciliationDecision get(int value) {
		switch (value) {
			case UNSPECIFIED: return UNSPECIFIED_LITERAL;
			case IGNORE: return IGNORE_LITERAL;
			case ENFORCE: return ENFORCE_LITERAL;
			case UPDATE: return UPDATE_LITERAL;
			case OVERRIDE_AND_ENFORCE: return OVERRIDE_AND_ENFORCE_LITERAL;
			case OVERRIDE_AND_UPDATE: return OVERRIDE_AND_UPDATE_LITERAL;
			case ENFORCE_AND_UPDATE: return ENFORCE_AND_UPDATE_LITERAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ReconciliationDecision(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

	// helper functions
	/**
	 * @generated NOT
	 */
	public boolean isIgnore() {
		return getValue() == IGNORE;
	}

	/**
	 * @generated NOT
	 */
	public boolean isUnspecified() {
		return getValue() == UNSPECIFIED;
	}
}
