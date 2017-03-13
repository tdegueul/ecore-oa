/**
 */
package tfsm.util;

import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tfsm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see tfsm.TfsmPackage
 * @generated
 */
public class TfsmSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TfsmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TfsmSwitch() {
		if (modelPackage == null) {
			modelPackage = TfsmPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TfsmPackage.TIMED_FSM: {
				TimedFSM timedFSM = (TimedFSM)theEObject;
				T result = caseTimedFSM(timedFSM);
				if (result == null) result = caseFSM(timedFSM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.TIMED_STATE: {
				TimedState timedState = (TimedState)theEObject;
				T result = caseTimedState(timedState);
				if (result == null) result = caseState(timedState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.TIMED_TRANSITION: {
				TimedTransition timedTransition = (TimedTransition)theEObject;
				T result = caseTimedTransition(timedTransition);
				if (result == null) result = caseTransition(timedTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.CLOCK: {
				Clock clock = (Clock)theEObject;
				T result = caseClock(clock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.CLOCK_CONSTRAINT: {
				ClockConstraint clockConstraint = (ClockConstraint)theEObject;
				T result = caseClockConstraint(clockConstraint);
				if (result == null) result = caseClockConstraintOperation(clockConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.CLOCK_RESET: {
				ClockReset clockReset = (ClockReset)theEObject;
				T result = caseClockReset(clockReset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.LOWER_CLOCK_CONSTRAINT: {
				LowerClockConstraint lowerClockConstraint = (LowerClockConstraint)theEObject;
				T result = caseLowerClockConstraint(lowerClockConstraint);
				if (result == null) result = caseClockConstraint(lowerClockConstraint);
				if (result == null) result = caseClockConstraintOperation(lowerClockConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.LOWER_EQUAL_CLOCK_CONSTRAINT: {
				LowerEqualClockConstraint lowerEqualClockConstraint = (LowerEqualClockConstraint)theEObject;
				T result = caseLowerEqualClockConstraint(lowerEqualClockConstraint);
				if (result == null) result = caseClockConstraint(lowerEqualClockConstraint);
				if (result == null) result = caseClockConstraintOperation(lowerEqualClockConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.UPPER_CLOCK_CONSTRAINT: {
				UpperClockConstraint upperClockConstraint = (UpperClockConstraint)theEObject;
				T result = caseUpperClockConstraint(upperClockConstraint);
				if (result == null) result = caseClockConstraint(upperClockConstraint);
				if (result == null) result = caseClockConstraintOperation(upperClockConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.UPPER_EQUAL_CLOCK_CONSTRAINT: {
				UpperEqualClockConstraint upperEqualClockConstraint = (UpperEqualClockConstraint)theEObject;
				T result = caseUpperEqualClockConstraint(upperEqualClockConstraint);
				if (result == null) result = caseClockConstraint(upperEqualClockConstraint);
				if (result == null) result = caseClockConstraintOperation(upperEqualClockConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.CLOCK_CONSTRAINT_OPERATION: {
				ClockConstraintOperation clockConstraintOperation = (ClockConstraintOperation)theEObject;
				T result = caseClockConstraintOperation(clockConstraintOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.AND_CLOCK_CONSTRAINT: {
				AndClockConstraint andClockConstraint = (AndClockConstraint)theEObject;
				T result = caseAndClockConstraint(andClockConstraint);
				if (result == null) result = caseBinaryClockConstraint(andClockConstraint);
				if (result == null) result = caseClockConstraintOperation(andClockConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.OR_CLOCK_CONSTRAINT: {
				OrClockConstraint orClockConstraint = (OrClockConstraint)theEObject;
				T result = caseOrClockConstraint(orClockConstraint);
				if (result == null) result = caseBinaryClockConstraint(orClockConstraint);
				if (result == null) result = caseClockConstraintOperation(orClockConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.BINARY_CLOCK_CONSTRAINT: {
				BinaryClockConstraint binaryClockConstraint = (BinaryClockConstraint)theEObject;
				T result = caseBinaryClockConstraint(binaryClockConstraint);
				if (result == null) result = caseClockConstraintOperation(binaryClockConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.TIMED_FINAL_STATE: {
				TimedFinalState timedFinalState = (TimedFinalState)theEObject;
				T result = caseTimedFinalState(timedFinalState);
				if (result == null) result = caseFinalState(timedFinalState);
				if (result == null) result = caseTimedState(timedFinalState);
				if (result == null) result = caseState(timedFinalState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TfsmPackage.TIMED_INITIAL_STATE: {
				TimedInitialState timedInitialState = (TimedInitialState)theEObject;
				T result = caseTimedInitialState(timedInitialState);
				if (result == null) result = caseTimedState(timedInitialState);
				if (result == null) result = caseInitialState(timedInitialState);
				if (result == null) result = caseState(timedInitialState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timed FSM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timed FSM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimedFSM(TimedFSM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timed State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timed State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimedState(TimedState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timed Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timed Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimedTransition(TimedTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clock</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clock</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClock(Clock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clock Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClockConstraint(ClockConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clock Reset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clock Reset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClockReset(ClockReset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lower Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lower Clock Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLowerClockConstraint(LowerClockConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lower Equal Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lower Equal Clock Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLowerEqualClockConstraint(LowerEqualClockConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Upper Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Upper Clock Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpperClockConstraint(UpperClockConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Upper Equal Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Upper Equal Clock Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpperEqualClockConstraint(UpperEqualClockConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clock Constraint Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clock Constraint Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClockConstraintOperation(ClockConstraintOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Clock Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndClockConstraint(AndClockConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Clock Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrClockConstraint(OrClockConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Clock Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryClockConstraint(BinaryClockConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timed Final State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timed Final State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimedFinalState(TimedFinalState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timed Initial State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timed Initial State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimedInitialState(TimedInitialState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSM(FSM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Final State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinalState(FinalState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialState(InitialState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //TfsmSwitch
