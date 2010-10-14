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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Synchronization State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see ca.uwaterloo.gsd.fsml.sync.SyncPackage#getSynchronizationState()
 * @model
 * @generated
 */
public enum SynchronizationState implements Enumerator
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
	 * The '<em><b>Unchanged</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNCHANGED
	 * @generated
	 * @ordered
	 */
	UNCHANGED_LITERAL(0, "unchanged", "unchanged"),
	/**
	 * The '<em><b>Added Model</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDED_MODEL
	 * @generated
	 * @ordered
	 */
	ADDED_MODEL_LITERAL(1, "addedModel", "addedModel"),
	/**
	 * The '<em><b>Changed Model</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGED_MODEL
	 * @generated
	 * @ordered
	 */
	CHANGED_MODEL_LITERAL(2, "changedModel", "changedModel"),
	/**
	 * The '<em><b>Removed Model</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVED_MODEL
	 * @generated
	 * @ordered
	 */
	REMOVED_MODEL_LITERAL(3, "removedModel", "removedModel"),
	/**
	 * The '<em><b>Added Code</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDED_CODE
	 * @generated
	 * @ordered
	 */
	ADDED_CODE_LITERAL(4, "addedCode", "addedCode"),
	/**
	 * The '<em><b>Changed Code</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGED_CODE
	 * @generated
	 * @ordered
	 */
	CHANGED_CODE_LITERAL(5, "changedCode", "changedCode"),
	/**
	 * The '<em><b>Removed Code</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVED_CODE
	 * @generated
	 * @ordered
	 */
	REMOVED_CODE_LITERAL(6, "removedCode", "removedCode"),
	/**
	 * The '<em><b>Changed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGED
	 * @generated
	 * @ordered
	 */
	CHANGED_LITERAL(7, "changed", "changed"),
	/**
	 * The '<em><b>Added Consistently</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDED_CONSISTENTLY
	 * @generated
	 * @ordered
	 */
	ADDED_CONSISTENTLY_LITERAL(8, "addedConsistently", "addedConsistently"),
	/**
	 * The '<em><b>Changed Consistently</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGED_CONSISTENTLY
	 * @generated
	 * @ordered
	 */
	CHANGED_CONSISTENTLY_LITERAL(9, "changedConsistently", "changedConsistently"),
	/**
	 * The '<em><b>Removed Consistently</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVED_CONSISTENTLY
	 * @generated
	 * @ordered
	 */
	REMOVED_CONSISTENTLY_LITERAL(10, "removedConsistently", "removedConsistently"),
	/**
	 * The '<em><b>Added Inconsistently</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDED_INCONSISTENTLY
	 * @generated
	 * @ordered
	 */
	ADDED_INCONSISTENTLY_LITERAL(11, "addedInconsistently", "addedInconsistently"),
	/**
	 * The '<em><b>Changed Inconsistently</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGED_INCONSISTENTLY
	 * @generated
	 * @ordered
	 */
	CHANGED_INCONSISTENTLY_LITERAL(12, "changedInconsistently", "changedInconsistently"),
	/**
	 * The '<em><b>Removed Code Changed Model</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVED_CODE_CHANGED_MODEL
	 * @generated
	 * @ordered
	 */
	REMOVED_CODE_CHANGED_MODEL_LITERAL(13, "removedCodeChangedModel", "removedCodeChangedModel"),
	/**
	 * The '<em><b>Removed Model Changed Code</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVED_MODEL_CHANGED_CODE
	 * @generated
	 * @ordered
	 */
	REMOVED_MODEL_CHANGED_CODE_LITERAL(14, "removedModelChangedCode", "removedModelChangedCode");
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
	 * The '<em><b>Unchanged</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unchanged</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNCHANGED_LITERAL
	 * @model name="unchanged"
	 * @generated
	 * @ordered
	 */
	public static final int UNCHANGED = 0;

	/**
	 * The '<em><b>Added Model</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Added Model</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDED_MODEL_LITERAL
	 * @model name="addedModel"
	 * @generated
	 * @ordered
	 */
	public static final int ADDED_MODEL = 1;

	/**
	 * The '<em><b>Changed Model</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Changed Model</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGED_MODEL_LITERAL
	 * @model name="changedModel"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGED_MODEL = 2;

	/**
	 * The '<em><b>Removed Model</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Removed Model</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVED_MODEL_LITERAL
	 * @model name="removedModel"
	 * @generated
	 * @ordered
	 */
	public static final int REMOVED_MODEL = 3;

	/**
	 * The '<em><b>Added Code</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Added Code</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDED_CODE_LITERAL
	 * @model name="addedCode"
	 * @generated
	 * @ordered
	 */
	public static final int ADDED_CODE = 4;

	/**
	 * The '<em><b>Changed Code</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Changed Code</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGED_CODE_LITERAL
	 * @model name="changedCode"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGED_CODE = 5;

	/**
	 * The '<em><b>Removed Code</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Removed Code</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVED_CODE_LITERAL
	 * @model name="removedCode"
	 * @generated
	 * @ordered
	 */
	public static final int REMOVED_CODE = 6;

	/**
	 * The '<em><b>Changed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Changed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGED_LITERAL
	 * @model name="changed"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGED = 7;

	/**
	 * The '<em><b>Added Consistently</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Added Consistently</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDED_CONSISTENTLY_LITERAL
	 * @model name="addedConsistently"
	 * @generated
	 * @ordered
	 */
	public static final int ADDED_CONSISTENTLY = 8;

	/**
	 * The '<em><b>Changed Consistently</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Changed Consistently</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGED_CONSISTENTLY_LITERAL
	 * @model name="changedConsistently"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGED_CONSISTENTLY = 9;

	/**
	 * The '<em><b>Removed Consistently</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Removed Consistently</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVED_CONSISTENTLY_LITERAL
	 * @model name="removedConsistently"
	 * @generated
	 * @ordered
	 */
	public static final int REMOVED_CONSISTENTLY = 10;

	/**
	 * The '<em><b>Added Inconsistently</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Added Inconsistently</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDED_INCONSISTENTLY_LITERAL
	 * @model name="addedInconsistently"
	 * @generated
	 * @ordered
	 */
	public static final int ADDED_INCONSISTENTLY = 11;

	/**
	 * The '<em><b>Changed Inconsistently</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Changed Inconsistently</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGED_INCONSISTENTLY_LITERAL
	 * @model name="changedInconsistently"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGED_INCONSISTENTLY = 12;

	/**
	 * The '<em><b>Removed Code Changed Model</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Removed Code Changed Model</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVED_CODE_CHANGED_MODEL_LITERAL
	 * @model name="removedCodeChangedModel"
	 * @generated
	 * @ordered
	 */
	public static final int REMOVED_CODE_CHANGED_MODEL = 13;

	/**
	 * The '<em><b>Removed Model Changed Code</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Removed Model Changed Code</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVED_MODEL_CHANGED_CODE_LITERAL
	 * @model name="removedModelChangedCode"
	 * @generated
	 * @ordered
	 */
	public static final int REMOVED_MODEL_CHANGED_CODE = 14;

	/**
	 * An array of all the '<em><b>Synchronization State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SynchronizationState[] VALUES_ARRAY =
		new SynchronizationState[] {
			UNSPECIFIED_LITERAL,
			UNCHANGED_LITERAL,
			ADDED_MODEL_LITERAL,
			CHANGED_MODEL_LITERAL,
			REMOVED_MODEL_LITERAL,
			ADDED_CODE_LITERAL,
			CHANGED_CODE_LITERAL,
			REMOVED_CODE_LITERAL,
			CHANGED_LITERAL,
			ADDED_CONSISTENTLY_LITERAL,
			CHANGED_CONSISTENTLY_LITERAL,
			REMOVED_CONSISTENTLY_LITERAL,
			ADDED_INCONSISTENTLY_LITERAL,
			CHANGED_INCONSISTENTLY_LITERAL,
			REMOVED_CODE_CHANGED_MODEL_LITERAL,
			REMOVED_MODEL_CHANGED_CODE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Synchronization State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SynchronizationState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Synchronization State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronizationState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SynchronizationState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Synchronization State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronizationState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SynchronizationState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Synchronization State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SynchronizationState get(int value) {
		switch (value) {
			case UNSPECIFIED: return UNSPECIFIED_LITERAL;
			case UNCHANGED: return UNCHANGED_LITERAL;
			case ADDED_MODEL: return ADDED_MODEL_LITERAL;
			case CHANGED_MODEL: return CHANGED_MODEL_LITERAL;
			case REMOVED_MODEL: return REMOVED_MODEL_LITERAL;
			case ADDED_CODE: return ADDED_CODE_LITERAL;
			case CHANGED_CODE: return CHANGED_CODE_LITERAL;
			case REMOVED_CODE: return REMOVED_CODE_LITERAL;
			case CHANGED: return CHANGED_LITERAL;
			case ADDED_CONSISTENTLY: return ADDED_CONSISTENTLY_LITERAL;
			case CHANGED_CONSISTENTLY: return CHANGED_CONSISTENTLY_LITERAL;
			case REMOVED_CONSISTENTLY: return REMOVED_CONSISTENTLY_LITERAL;
			case ADDED_INCONSISTENTLY: return ADDED_INCONSISTENTLY_LITERAL;
			case CHANGED_INCONSISTENTLY: return CHANGED_INCONSISTENTLY_LITERAL;
			case REMOVED_CODE_CHANGED_MODEL: return REMOVED_CODE_CHANGED_MODEL_LITERAL;
			case REMOVED_MODEL_CHANGED_CODE: return REMOVED_MODEL_CHANGED_CODE_LITERAL;
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
	private SynchronizationState(int value, String name, String literal) {
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
	public boolean isForward() {
		switch (getValue()) {
		case ADDED_MODEL:
		case CHANGED_MODEL:
		case REMOVED_MODEL:
			return true;
		}
		return false;
	}

	public boolean isReverse() {
		switch (getValue()) {
		case ADDED_CODE:
		case CHANGED_CODE:
		case REMOVED_CODE:
			return true;
		}
		return false; 
	}

	public boolean isChanged() {
		return getValue() == CHANGED; 
	}

	public boolean isAddition() {
		switch (getValue()) {
		case ADDED_CODE:
		case ADDED_MODEL:
			return true;
		}
		return false;
	}

	public boolean isRemoval() {
		switch (getValue()) {
		case REMOVED_CODE:
		case REMOVED_MODEL:
			return true;
		}
		return false;
	}

	public boolean isConflict() {
		switch (getValue()) {
		case CHANGED_INCONSISTENTLY:
		case ADDED_INCONSISTENTLY:
		case REMOVED_CODE_CHANGED_MODEL:
		case REMOVED_MODEL_CHANGED_CODE:
			return true;
		}
		return false;
	}

	public boolean isConsistent() {
		switch (getValue()) {
		case CHANGED_CONSISTENTLY:
		case ADDED_CONSISTENTLY:
		case UNCHANGED:
		case REMOVED_CONSISTENTLY:
			return true;
		}
		return false;
	}

	/**
	 * @param model - class instance from the asserted model
	 * @param code - class instance from the implementation model
	 * @param lrm - class instance from the last reconciled model
	 * @param hasConflict
	 * @param hasForward
	 * @param hasReverse
	 * @param hasChanged
	 * @return a synchronization state computed according to the class instance synchronization state decision table.
	 */
	public static SynchronizationState getClassInstanceSynchronizationState(EObject model, EObject code, EObject lrm, boolean hasConflict, boolean hasForward, boolean hasReverse, boolean hasChanged) {
		boolean allConsistent = !hasConflict && !hasForward && !hasReverse && !hasChanged;
	
		if (model != null) {
			if (code != null) {
				if (lrm != null) {
					if (allConsistent) 
						return UNCHANGED_LITERAL;				// #1
					else if (hasForward && hasReverse && !hasConflict)
						return CHANGED_LITERAL; 				// #2
					else if (hasForward && !hasReverse && !hasConflict)
						return CHANGED_MODEL_LITERAL;			// #3
					else if (!hasForward && hasReverse && !hasConflict)
						return CHANGED_CODE_LITERAL;			// #4
					else if (hasConflict)
						return CHANGED_INCONSISTENTLY_LITERAL;	// #5
				}
				else { // lrm == null
					if (allConsistent) 
						return ADDED_CONSISTENTLY_LITERAL;		// #6
					else 
						return ADDED_INCONSISTENTLY_LITERAL;	// #7
				}
			}
			else { // code == null
				if (lrm != null)
					return REMOVED_CODE_LITERAL;				// #8
				else // lrm == null
					return ADDED_MODEL_LITERAL;					// #9
			}
		}
		else { // model == null
			if (code != null) {
				if (lrm != null) 
					return REMOVED_MODEL_LITERAL;				// #10
				else // lrm == null
					return ADDED_CODE_LITERAL;					// #11
			}
			else { // code == null
				if (lrm != null) 
					return REMOVED_CONSISTENTLY_LITERAL;		// #12
				else // lrm == null
					return UNCHANGED_LITERAL;					// #13
			}
		}
		// this should never happen, because all possible cases have been already investigated.
		return UNSPECIFIED_LITERAL;
	}

	/**
	 * @param model - feature's value from the asserted model
	 * @param code - feature's value from the implementation model
	 * @param lrm - feature's value from the last reconciled model
	 * @return a synchronization state computed according to the attribute/non-containment reference synchronization state decision table.
	 */
	public static SynchronizationState getFeatureSynchronizationState(Object model, Object code, Object lrm) {
		if (model != null && code != null) {
			if (model.equals(code)) {
				if (lrm != null) {
					if (model.equals(lrm))
						return UNCHANGED_LITERAL;						// #1
					else 
						return CHANGED_CONSISTENTLY_LITERAL;			// #2
				}
				else
					return ADDED_CONSISTENTLY_LITERAL;					// #3
			}
			else { // model != code
				if (lrm != null) {
					if (!model.equals(code)) {
						if (model.equals(lrm))
							return CHANGED_CODE_LITERAL;				// #4
						else if (code.equals(lrm))
							return CHANGED_MODEL_LITERAL;				// #5
						else // model != lrm && code != lrm
							return CHANGED_INCONSISTENTLY_LITERAL;		// #6
					}
				}
				else
					return ADDED_INCONSISTENTLY_LITERAL;				// #7
			}
		}
		else if (model != null && code == null) {
			if (lrm != null) {
				if (model.equals(lrm))
					return REMOVED_CODE_LITERAL;						// #8
				else
					return REMOVED_CODE_CHANGED_MODEL_LITERAL;			// #9
			}
			else 
				return ADDED_MODEL_LITERAL;								// #12
		}
		else if (model == null && code != null) {
			if (lrm != null) {
				if (code.equals(lrm))
					return REMOVED_MODEL_LITERAL;						// #10
				else
					return REMOVED_MODEL_CHANGED_CODE_LITERAL;			// #11
			}
			else 
				return ADDED_CODE_LITERAL;								// #13
		}
		else if (model == null && code == null) {
			if (lrm != null)
				return REMOVED_CONSISTENTLY_LITERAL;					// #14
			else 
				return UNCHANGED_LITERAL;								// #15
		}		
		// this should never happen, because all possible cases have been already investigated.
		return UNSPECIFIED_LITERAL;
	}
}
