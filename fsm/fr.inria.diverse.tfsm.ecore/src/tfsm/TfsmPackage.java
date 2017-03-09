/**
 */
package tfsm;

import fsm.FsmPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tfsm.TfsmFactory
 * @model kind="package"
 * @generated
 */
public interface TfsmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tfsm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://diverse.inria.fr/tfsm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tfsm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TfsmPackage eINSTANCE = tfsm.impl.TfsmPackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsm.impl.TimedFSMImpl <em>Timed FSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TimedFSMImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTimedFSM()
	 * @generated
	 */
	int TIMED_FSM = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FSM__STATES = FsmPackage.FSM__STATES;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FSM__TRANSITIONS = FsmPackage.FSM__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Initialstate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FSM__INITIALSTATE = FsmPackage.FSM__INITIALSTATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FSM__NAME = FsmPackage.FSM__NAME;

	/**
	 * The feature id for the '<em><b>Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FSM__CLOCKS = FsmPackage.FSM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Timed FSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FSM_FEATURE_COUNT = FsmPackage.FSM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Timed FSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FSM_OPERATION_COUNT = FsmPackage.FSM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.TimedStateImpl <em>Timed State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TimedStateImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTimedState()
	 * @generated
	 */
	int TIMED_STATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_STATE__NAME = FsmPackage.STATE__NAME;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_STATE__FSM = FsmPackage.STATE__FSM;

	/**
	 * The feature id for the '<em><b>Outgoingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_STATE__OUTGOINGTRANSITIONS = FsmPackage.STATE__OUTGOINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Incommingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_STATE__INCOMMINGTRANSITIONS = FsmPackage.STATE__INCOMMINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Stateguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_STATE__STATEGUARD = FsmPackage.STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Timed State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_STATE_FEATURE_COUNT = FsmPackage.STATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Timed State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_STATE_OPERATION_COUNT = FsmPackage.STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.TimedTransitionImpl <em>Timed Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TimedTransitionImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTimedTransition()
	 * @generated
	 */
	int TIMED_TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION__FSM = FsmPackage.TRANSITION__FSM;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION__FROM = FsmPackage.TRANSITION__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION__TO = FsmPackage.TRANSITION__TO;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION__EVENT = FsmPackage.TRANSITION__EVENT;

	/**
	 * The feature id for the '<em><b>Clockresets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION__CLOCKRESETS = FsmPackage.TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transitionguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION__TRANSITIONGUARD = FsmPackage.TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Timed Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION_FEATURE_COUNT = FsmPackage.TRANSITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Timed Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_TRANSITION_OPERATION_COUNT = FsmPackage.TRANSITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.ClockImpl <em>Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.ClockImpl
	 * @see tfsm.impl.TfsmPackageImpl#getClock()
	 * @generated
	 */
	int CLOCK = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Tick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__TICK = 1;

	/**
	 * The number of structural features of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.ClockConstraintOperationImpl <em>Clock Constraint Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.ClockConstraintOperationImpl
	 * @see tfsm.impl.TfsmPackageImpl#getClockConstraintOperation()
	 * @generated
	 */
	int CLOCK_CONSTRAINT_OPERATION = 10;

	/**
	 * The number of structural features of the '<em>Clock Constraint Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT_OPERATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Clock Constraint Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.ClockConstraintImpl <em>Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.ClockConstraintImpl
	 * @see tfsm.impl.TfsmPackageImpl#getClockConstraint()
	 * @generated
	 */
	int CLOCK_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__THRESHOLD = CLOCK_CONSTRAINT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__CLOCK = CLOCK_CONSTRAINT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT_FEATURE_COUNT = CLOCK_CONSTRAINT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT_OPERATION_COUNT = CLOCK_CONSTRAINT_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.ClockResetImpl <em>Clock Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.ClockResetImpl
	 * @see tfsm.impl.TfsmPackageImpl#getClockReset()
	 * @generated
	 */
	int CLOCK_RESET = 5;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESET__CLOCK = 0;

	/**
	 * The number of structural features of the '<em>Clock Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Clock Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.LowerClockConstraintImpl <em>Lower Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.LowerClockConstraintImpl
	 * @see tfsm.impl.TfsmPackageImpl#getLowerClockConstraint()
	 * @generated
	 */
	int LOWER_CLOCK_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CLOCK_CONSTRAINT__THRESHOLD = CLOCK_CONSTRAINT__THRESHOLD;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CLOCK_CONSTRAINT__CLOCK = CLOCK_CONSTRAINT__CLOCK;

	/**
	 * The number of structural features of the '<em>Lower Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CLOCK_CONSTRAINT_FEATURE_COUNT = CLOCK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Lower Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_CLOCK_CONSTRAINT_OPERATION_COUNT = CLOCK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.LowerEqualClockConstraintImpl <em>Lower Equal Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.LowerEqualClockConstraintImpl
	 * @see tfsm.impl.TfsmPackageImpl#getLowerEqualClockConstraint()
	 * @generated
	 */
	int LOWER_EQUAL_CLOCK_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_EQUAL_CLOCK_CONSTRAINT__THRESHOLD = CLOCK_CONSTRAINT__THRESHOLD;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_EQUAL_CLOCK_CONSTRAINT__CLOCK = CLOCK_CONSTRAINT__CLOCK;

	/**
	 * The number of structural features of the '<em>Lower Equal Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_EQUAL_CLOCK_CONSTRAINT_FEATURE_COUNT = CLOCK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Lower Equal Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_EQUAL_CLOCK_CONSTRAINT_OPERATION_COUNT = CLOCK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.UpperClockConstraintImpl <em>Upper Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.UpperClockConstraintImpl
	 * @see tfsm.impl.TfsmPackageImpl#getUpperClockConstraint()
	 * @generated
	 */
	int UPPER_CLOCK_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CLOCK_CONSTRAINT__THRESHOLD = CLOCK_CONSTRAINT__THRESHOLD;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CLOCK_CONSTRAINT__CLOCK = CLOCK_CONSTRAINT__CLOCK;

	/**
	 * The number of structural features of the '<em>Upper Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CLOCK_CONSTRAINT_FEATURE_COUNT = CLOCK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Upper Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_CLOCK_CONSTRAINT_OPERATION_COUNT = CLOCK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.UpperEqualClockConstraintImpl <em>Upper Equal Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.UpperEqualClockConstraintImpl
	 * @see tfsm.impl.TfsmPackageImpl#getUpperEqualClockConstraint()
	 * @generated
	 */
	int UPPER_EQUAL_CLOCK_CONSTRAINT = 9;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_EQUAL_CLOCK_CONSTRAINT__THRESHOLD = CLOCK_CONSTRAINT__THRESHOLD;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_EQUAL_CLOCK_CONSTRAINT__CLOCK = CLOCK_CONSTRAINT__CLOCK;

	/**
	 * The number of structural features of the '<em>Upper Equal Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_EQUAL_CLOCK_CONSTRAINT_FEATURE_COUNT = CLOCK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Upper Equal Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_EQUAL_CLOCK_CONSTRAINT_OPERATION_COUNT = CLOCK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.BinaryClockConstraintImpl <em>Binary Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.BinaryClockConstraintImpl
	 * @see tfsm.impl.TfsmPackageImpl#getBinaryClockConstraint()
	 * @generated
	 */
	int BINARY_CLOCK_CONSTRAINT = 13;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLOCK_CONSTRAINT__LEFT = CLOCK_CONSTRAINT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLOCK_CONSTRAINT__RIGHT = CLOCK_CONSTRAINT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLOCK_CONSTRAINT_FEATURE_COUNT = CLOCK_CONSTRAINT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLOCK_CONSTRAINT_OPERATION_COUNT = CLOCK_CONSTRAINT_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.AndClockConstraintImpl <em>And Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.AndClockConstraintImpl
	 * @see tfsm.impl.TfsmPackageImpl#getAndClockConstraint()
	 * @generated
	 */
	int AND_CLOCK_CONSTRAINT = 11;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CLOCK_CONSTRAINT__LEFT = BINARY_CLOCK_CONSTRAINT__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CLOCK_CONSTRAINT__RIGHT = BINARY_CLOCK_CONSTRAINT__RIGHT;

	/**
	 * The number of structural features of the '<em>And Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CLOCK_CONSTRAINT_FEATURE_COUNT = BINARY_CLOCK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_CLOCK_CONSTRAINT_OPERATION_COUNT = BINARY_CLOCK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.OrClockConstraintImpl <em>Or Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.OrClockConstraintImpl
	 * @see tfsm.impl.TfsmPackageImpl#getOrClockConstraint()
	 * @generated
	 */
	int OR_CLOCK_CONSTRAINT = 12;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CLOCK_CONSTRAINT__LEFT = BINARY_CLOCK_CONSTRAINT__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CLOCK_CONSTRAINT__RIGHT = BINARY_CLOCK_CONSTRAINT__RIGHT;

	/**
	 * The number of structural features of the '<em>Or Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CLOCK_CONSTRAINT_FEATURE_COUNT = BINARY_CLOCK_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_CLOCK_CONSTRAINT_OPERATION_COUNT = BINARY_CLOCK_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.TimedFinalStateImpl <em>Timed Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TimedFinalStateImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTimedFinalState()
	 * @generated
	 */
	int TIMED_FINAL_STATE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FINAL_STATE__NAME = FsmPackage.FINAL_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FINAL_STATE__FSM = FsmPackage.FINAL_STATE__FSM;

	/**
	 * The feature id for the '<em><b>Outgoingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FINAL_STATE__OUTGOINGTRANSITIONS = FsmPackage.FINAL_STATE__OUTGOINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Incommingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FINAL_STATE__INCOMMINGTRANSITIONS = FsmPackage.FINAL_STATE__INCOMMINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Stateguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FINAL_STATE__STATEGUARD = FsmPackage.FINAL_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Timed Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FINAL_STATE_FEATURE_COUNT = FsmPackage.FINAL_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Timed Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_FINAL_STATE_OPERATION_COUNT = FsmPackage.FINAL_STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.TimedInitialStateImpl <em>Timed Initial State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TimedInitialStateImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTimedInitialState()
	 * @generated
	 */
	int TIMED_INITIAL_STATE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INITIAL_STATE__NAME = TIMED_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INITIAL_STATE__FSM = TIMED_STATE__FSM;

	/**
	 * The feature id for the '<em><b>Outgoingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INITIAL_STATE__OUTGOINGTRANSITIONS = TIMED_STATE__OUTGOINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Incommingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INITIAL_STATE__INCOMMINGTRANSITIONS = TIMED_STATE__INCOMMINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Stateguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INITIAL_STATE__STATEGUARD = TIMED_STATE__STATEGUARD;

	/**
	 * The number of structural features of the '<em>Timed Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INITIAL_STATE_FEATURE_COUNT = TIMED_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Timed Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INITIAL_STATE_OPERATION_COUNT = TIMED_STATE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link tfsm.TimedFSM <em>Timed FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed FSM</em>'.
	 * @see tfsm.TimedFSM
	 * @generated
	 */
	EClass getTimedFSM();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm.TimedFSM#getClocks <em>Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clocks</em>'.
	 * @see tfsm.TimedFSM#getClocks()
	 * @see #getTimedFSM()
	 * @generated
	 */
	EReference getTimedFSM_Clocks();

	/**
	 * Returns the meta object for class '{@link tfsm.TimedState <em>Timed State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed State</em>'.
	 * @see tfsm.TimedState
	 * @generated
	 */
	EClass getTimedState();

	/**
	 * Returns the meta object for the containment reference '{@link tfsm.TimedState#getStateguard <em>Stateguard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stateguard</em>'.
	 * @see tfsm.TimedState#getStateguard()
	 * @see #getTimedState()
	 * @generated
	 */
	EReference getTimedState_Stateguard();

	/**
	 * Returns the meta object for class '{@link tfsm.TimedTransition <em>Timed Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Transition</em>'.
	 * @see tfsm.TimedTransition
	 * @generated
	 */
	EClass getTimedTransition();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm.TimedTransition#getClockresets <em>Clockresets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clockresets</em>'.
	 * @see tfsm.TimedTransition#getClockresets()
	 * @see #getTimedTransition()
	 * @generated
	 */
	EReference getTimedTransition_Clockresets();

	/**
	 * Returns the meta object for the containment reference '{@link tfsm.TimedTransition#getTransitionguard <em>Transitionguard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transitionguard</em>'.
	 * @see tfsm.TimedTransition#getTransitionguard()
	 * @see #getTimedTransition()
	 * @generated
	 */
	EReference getTimedTransition_Transitionguard();

	/**
	 * Returns the meta object for class '{@link tfsm.Clock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock</em>'.
	 * @see tfsm.Clock
	 * @generated
	 */
	EClass getClock();

	/**
	 * Returns the meta object for the attribute '{@link tfsm.Clock#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tfsm.Clock#getName()
	 * @see #getClock()
	 * @generated
	 */
	EAttribute getClock_Name();

	/**
	 * Returns the meta object for the attribute '{@link tfsm.Clock#getTick <em>Tick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tick</em>'.
	 * @see tfsm.Clock#getTick()
	 * @see #getClock()
	 * @generated
	 */
	EAttribute getClock_Tick();

	/**
	 * Returns the meta object for class '{@link tfsm.ClockConstraint <em>Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock Constraint</em>'.
	 * @see tfsm.ClockConstraint
	 * @generated
	 */
	EClass getClockConstraint();

	/**
	 * Returns the meta object for the attribute '{@link tfsm.ClockConstraint#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see tfsm.ClockConstraint#getThreshold()
	 * @see #getClockConstraint()
	 * @generated
	 */
	EAttribute getClockConstraint_Threshold();

	/**
	 * Returns the meta object for the reference '{@link tfsm.ClockConstraint#getClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clock</em>'.
	 * @see tfsm.ClockConstraint#getClock()
	 * @see #getClockConstraint()
	 * @generated
	 */
	EReference getClockConstraint_Clock();

	/**
	 * Returns the meta object for class '{@link tfsm.ClockReset <em>Clock Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock Reset</em>'.
	 * @see tfsm.ClockReset
	 * @generated
	 */
	EClass getClockReset();

	/**
	 * Returns the meta object for the reference '{@link tfsm.ClockReset#getClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clock</em>'.
	 * @see tfsm.ClockReset#getClock()
	 * @see #getClockReset()
	 * @generated
	 */
	EReference getClockReset_Clock();

	/**
	 * Returns the meta object for class '{@link tfsm.LowerClockConstraint <em>Lower Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lower Clock Constraint</em>'.
	 * @see tfsm.LowerClockConstraint
	 * @generated
	 */
	EClass getLowerClockConstraint();

	/**
	 * Returns the meta object for class '{@link tfsm.LowerEqualClockConstraint <em>Lower Equal Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lower Equal Clock Constraint</em>'.
	 * @see tfsm.LowerEqualClockConstraint
	 * @generated
	 */
	EClass getLowerEqualClockConstraint();

	/**
	 * Returns the meta object for class '{@link tfsm.UpperClockConstraint <em>Upper Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upper Clock Constraint</em>'.
	 * @see tfsm.UpperClockConstraint
	 * @generated
	 */
	EClass getUpperClockConstraint();

	/**
	 * Returns the meta object for class '{@link tfsm.UpperEqualClockConstraint <em>Upper Equal Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upper Equal Clock Constraint</em>'.
	 * @see tfsm.UpperEqualClockConstraint
	 * @generated
	 */
	EClass getUpperEqualClockConstraint();

	/**
	 * Returns the meta object for class '{@link tfsm.ClockConstraintOperation <em>Clock Constraint Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock Constraint Operation</em>'.
	 * @see tfsm.ClockConstraintOperation
	 * @generated
	 */
	EClass getClockConstraintOperation();

	/**
	 * Returns the meta object for class '{@link tfsm.AndClockConstraint <em>And Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Clock Constraint</em>'.
	 * @see tfsm.AndClockConstraint
	 * @generated
	 */
	EClass getAndClockConstraint();

	/**
	 * Returns the meta object for class '{@link tfsm.OrClockConstraint <em>Or Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Clock Constraint</em>'.
	 * @see tfsm.OrClockConstraint
	 * @generated
	 */
	EClass getOrClockConstraint();

	/**
	 * Returns the meta object for class '{@link tfsm.BinaryClockConstraint <em>Binary Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Clock Constraint</em>'.
	 * @see tfsm.BinaryClockConstraint
	 * @generated
	 */
	EClass getBinaryClockConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link tfsm.BinaryClockConstraint#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see tfsm.BinaryClockConstraint#getLeft()
	 * @see #getBinaryClockConstraint()
	 * @generated
	 */
	EReference getBinaryClockConstraint_Left();

	/**
	 * Returns the meta object for the containment reference '{@link tfsm.BinaryClockConstraint#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see tfsm.BinaryClockConstraint#getRight()
	 * @see #getBinaryClockConstraint()
	 * @generated
	 */
	EReference getBinaryClockConstraint_Right();

	/**
	 * Returns the meta object for class '{@link tfsm.TimedFinalState <em>Timed Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Final State</em>'.
	 * @see tfsm.TimedFinalState
	 * @generated
	 */
	EClass getTimedFinalState();

	/**
	 * Returns the meta object for class '{@link tfsm.TimedInitialState <em>Timed Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Initial State</em>'.
	 * @see tfsm.TimedInitialState
	 * @generated
	 */
	EClass getTimedInitialState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TfsmFactory getTfsmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tfsm.impl.TimedFSMImpl <em>Timed FSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TimedFSMImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTimedFSM()
		 * @generated
		 */
		EClass TIMED_FSM = eINSTANCE.getTimedFSM();

		/**
		 * The meta object literal for the '<em><b>Clocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_FSM__CLOCKS = eINSTANCE.getTimedFSM_Clocks();

		/**
		 * The meta object literal for the '{@link tfsm.impl.TimedStateImpl <em>Timed State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TimedStateImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTimedState()
		 * @generated
		 */
		EClass TIMED_STATE = eINSTANCE.getTimedState();

		/**
		 * The meta object literal for the '<em><b>Stateguard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_STATE__STATEGUARD = eINSTANCE.getTimedState_Stateguard();

		/**
		 * The meta object literal for the '{@link tfsm.impl.TimedTransitionImpl <em>Timed Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TimedTransitionImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTimedTransition()
		 * @generated
		 */
		EClass TIMED_TRANSITION = eINSTANCE.getTimedTransition();

		/**
		 * The meta object literal for the '<em><b>Clockresets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_TRANSITION__CLOCKRESETS = eINSTANCE.getTimedTransition_Clockresets();

		/**
		 * The meta object literal for the '<em><b>Transitionguard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_TRANSITION__TRANSITIONGUARD = eINSTANCE.getTimedTransition_Transitionguard();

		/**
		 * The meta object literal for the '{@link tfsm.impl.ClockImpl <em>Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.ClockImpl
		 * @see tfsm.impl.TfsmPackageImpl#getClock()
		 * @generated
		 */
		EClass CLOCK = eINSTANCE.getClock();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK__NAME = eINSTANCE.getClock_Name();

		/**
		 * The meta object literal for the '<em><b>Tick</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK__TICK = eINSTANCE.getClock_Tick();

		/**
		 * The meta object literal for the '{@link tfsm.impl.ClockConstraintImpl <em>Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.ClockConstraintImpl
		 * @see tfsm.impl.TfsmPackageImpl#getClockConstraint()
		 * @generated
		 */
		EClass CLOCK_CONSTRAINT = eINSTANCE.getClockConstraint();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK_CONSTRAINT__THRESHOLD = eINSTANCE.getClockConstraint_Threshold();

		/**
		 * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_CONSTRAINT__CLOCK = eINSTANCE.getClockConstraint_Clock();

		/**
		 * The meta object literal for the '{@link tfsm.impl.ClockResetImpl <em>Clock Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.ClockResetImpl
		 * @see tfsm.impl.TfsmPackageImpl#getClockReset()
		 * @generated
		 */
		EClass CLOCK_RESET = eINSTANCE.getClockReset();

		/**
		 * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_RESET__CLOCK = eINSTANCE.getClockReset_Clock();

		/**
		 * The meta object literal for the '{@link tfsm.impl.LowerClockConstraintImpl <em>Lower Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.LowerClockConstraintImpl
		 * @see tfsm.impl.TfsmPackageImpl#getLowerClockConstraint()
		 * @generated
		 */
		EClass LOWER_CLOCK_CONSTRAINT = eINSTANCE.getLowerClockConstraint();

		/**
		 * The meta object literal for the '{@link tfsm.impl.LowerEqualClockConstraintImpl <em>Lower Equal Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.LowerEqualClockConstraintImpl
		 * @see tfsm.impl.TfsmPackageImpl#getLowerEqualClockConstraint()
		 * @generated
		 */
		EClass LOWER_EQUAL_CLOCK_CONSTRAINT = eINSTANCE.getLowerEqualClockConstraint();

		/**
		 * The meta object literal for the '{@link tfsm.impl.UpperClockConstraintImpl <em>Upper Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.UpperClockConstraintImpl
		 * @see tfsm.impl.TfsmPackageImpl#getUpperClockConstraint()
		 * @generated
		 */
		EClass UPPER_CLOCK_CONSTRAINT = eINSTANCE.getUpperClockConstraint();

		/**
		 * The meta object literal for the '{@link tfsm.impl.UpperEqualClockConstraintImpl <em>Upper Equal Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.UpperEqualClockConstraintImpl
		 * @see tfsm.impl.TfsmPackageImpl#getUpperEqualClockConstraint()
		 * @generated
		 */
		EClass UPPER_EQUAL_CLOCK_CONSTRAINT = eINSTANCE.getUpperEqualClockConstraint();

		/**
		 * The meta object literal for the '{@link tfsm.impl.ClockConstraintOperationImpl <em>Clock Constraint Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.ClockConstraintOperationImpl
		 * @see tfsm.impl.TfsmPackageImpl#getClockConstraintOperation()
		 * @generated
		 */
		EClass CLOCK_CONSTRAINT_OPERATION = eINSTANCE.getClockConstraintOperation();

		/**
		 * The meta object literal for the '{@link tfsm.impl.AndClockConstraintImpl <em>And Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.AndClockConstraintImpl
		 * @see tfsm.impl.TfsmPackageImpl#getAndClockConstraint()
		 * @generated
		 */
		EClass AND_CLOCK_CONSTRAINT = eINSTANCE.getAndClockConstraint();

		/**
		 * The meta object literal for the '{@link tfsm.impl.OrClockConstraintImpl <em>Or Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.OrClockConstraintImpl
		 * @see tfsm.impl.TfsmPackageImpl#getOrClockConstraint()
		 * @generated
		 */
		EClass OR_CLOCK_CONSTRAINT = eINSTANCE.getOrClockConstraint();

		/**
		 * The meta object literal for the '{@link tfsm.impl.BinaryClockConstraintImpl <em>Binary Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.BinaryClockConstraintImpl
		 * @see tfsm.impl.TfsmPackageImpl#getBinaryClockConstraint()
		 * @generated
		 */
		EClass BINARY_CLOCK_CONSTRAINT = eINSTANCE.getBinaryClockConstraint();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_CLOCK_CONSTRAINT__LEFT = eINSTANCE.getBinaryClockConstraint_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_CLOCK_CONSTRAINT__RIGHT = eINSTANCE.getBinaryClockConstraint_Right();

		/**
		 * The meta object literal for the '{@link tfsm.impl.TimedFinalStateImpl <em>Timed Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TimedFinalStateImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTimedFinalState()
		 * @generated
		 */
		EClass TIMED_FINAL_STATE = eINSTANCE.getTimedFinalState();

		/**
		 * The meta object literal for the '{@link tfsm.impl.TimedInitialStateImpl <em>Timed Initial State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TimedInitialStateImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTimedInitialState()
		 * @generated
		 */
		EClass TIMED_INITIAL_STATE = eINSTANCE.getTimedInitialState();

	}

} //TfsmPackage
