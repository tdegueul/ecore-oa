/**
 */
package tfsm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tfsm.TfsmPackage
 * @generated
 */
public interface TfsmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TfsmFactory eINSTANCE = tfsm.impl.TfsmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Timed FSM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed FSM</em>'.
	 * @generated
	 */
	TimedFSM createTimedFSM();

	/**
	 * Returns a new object of class '<em>Timed State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed State</em>'.
	 * @generated
	 */
	TimedState createTimedState();

	/**
	 * Returns a new object of class '<em>Timed Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Transition</em>'.
	 * @generated
	 */
	TimedTransition createTimedTransition();

	/**
	 * Returns a new object of class '<em>Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock</em>'.
	 * @generated
	 */
	Clock createClock();

	/**
	 * Returns a new object of class '<em>Clock Reset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock Reset</em>'.
	 * @generated
	 */
	ClockReset createClockReset();

	/**
	 * Returns a new object of class '<em>Lower Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lower Clock Constraint</em>'.
	 * @generated
	 */
	LowerClockConstraint createLowerClockConstraint();

	/**
	 * Returns a new object of class '<em>Lower Equal Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lower Equal Clock Constraint</em>'.
	 * @generated
	 */
	LowerEqualClockConstraint createLowerEqualClockConstraint();

	/**
	 * Returns a new object of class '<em>Upper Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Upper Clock Constraint</em>'.
	 * @generated
	 */
	UpperClockConstraint createUpperClockConstraint();

	/**
	 * Returns a new object of class '<em>Upper Equal Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Upper Equal Clock Constraint</em>'.
	 * @generated
	 */
	UpperEqualClockConstraint createUpperEqualClockConstraint();

	/**
	 * Returns a new object of class '<em>And Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Clock Constraint</em>'.
	 * @generated
	 */
	AndClockConstraint createAndClockConstraint();

	/**
	 * Returns a new object of class '<em>Or Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Clock Constraint</em>'.
	 * @generated
	 */
	OrClockConstraint createOrClockConstraint();

	/**
	 * Returns a new object of class '<em>Timed Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Final State</em>'.
	 * @generated
	 */
	TimedFinalState createTimedFinalState();

	/**
	 * Returns a new object of class '<em>Timed Initial State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Initial State</em>'.
	 * @generated
	 */
	TimedInitialState createTimedInitialState();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TfsmPackage getTfsmPackage();

} //TfsmFactory
