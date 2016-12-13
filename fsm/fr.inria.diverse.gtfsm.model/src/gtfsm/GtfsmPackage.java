/**
 */
package gtfsm;

import gfsm.GfsmPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import tfsm.TfsmPackage;

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
 * @see gtfsm.GtfsmFactory
 * @model kind="package"
 * @generated
 */
public interface GtfsmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gtfsm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://diverse.inria.fr/gtfsm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gtfsm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GtfsmPackage eINSTANCE = gtfsm.impl.GtfsmPackageImpl.init();

	/**
	 * The meta object id for the '{@link gtfsm.impl.GTFSMImpl <em>GTFSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gtfsm.impl.GTFSMImpl
	 * @see gtfsm.impl.GtfsmPackageImpl#getGTFSM()
	 * @generated
	 */
	int GTFSM = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GTFSM__STATES = TfsmPackage.TIMED_FSM__STATES;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GTFSM__TRANSITIONS = TfsmPackage.TIMED_FSM__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Initialstate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GTFSM__INITIALSTATE = TfsmPackage.TIMED_FSM__INITIALSTATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GTFSM__NAME = TfsmPackage.TIMED_FSM__NAME;

	/**
	 * The feature id for the '<em><b>Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GTFSM__CLOCKS = TfsmPackage.TIMED_FSM__CLOCKS;

	/**
	 * The number of structural features of the '<em>GTFSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GTFSM_FEATURE_COUNT = TfsmPackage.TIMED_FSM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>GTFSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GTFSM_OPERATION_COUNT = TfsmPackage.TIMED_FSM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gtfsm.impl.GTStateImpl <em>GT State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gtfsm.impl.GTStateImpl
	 * @see gtfsm.impl.GtfsmPackageImpl#getGTState()
	 * @generated
	 */
	int GT_STATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE__NAME = GfsmPackage.GSTATE__NAME;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE__FSM = GfsmPackage.GSTATE__FSM;

	/**
	 * The feature id for the '<em><b>Outgoingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE__OUTGOINGTRANSITIONS = GfsmPackage.GSTATE__OUTGOINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Incommingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE__INCOMMINGTRANSITIONS = GfsmPackage.GSTATE__INCOMMINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE__IN_EXPRESSION = GfsmPackage.GSTATE__IN_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Out Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE__OUT_EXPRESSION = GfsmPackage.GSTATE__OUT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Stateguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE__STATEGUARD = GfsmPackage.GSTATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>GT State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE_FEATURE_COUNT = GfsmPackage.GSTATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>GT State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_STATE_OPERATION_COUNT = GfsmPackage.GSTATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gtfsm.impl.GTInitialStateImpl <em>GT Initial State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gtfsm.impl.GTInitialStateImpl
	 * @see gtfsm.impl.GtfsmPackageImpl#getGTInitialState()
	 * @generated
	 */
	int GT_INITIAL_STATE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE__NAME = GT_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE__FSM = GT_STATE__FSM;

	/**
	 * The feature id for the '<em><b>Outgoingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE__OUTGOINGTRANSITIONS = GT_STATE__OUTGOINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Incommingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE__INCOMMINGTRANSITIONS = GT_STATE__INCOMMINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE__IN_EXPRESSION = GT_STATE__IN_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Out Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE__OUT_EXPRESSION = GT_STATE__OUT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Stateguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE__STATEGUARD = GT_STATE__STATEGUARD;

	/**
	 * The number of structural features of the '<em>GT Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE_FEATURE_COUNT = GT_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>GT Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_INITIAL_STATE_OPERATION_COUNT = GT_STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gtfsm.impl.GTFinalStateImpl <em>GT Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gtfsm.impl.GTFinalStateImpl
	 * @see gtfsm.impl.GtfsmPackageImpl#getGTFinalState()
	 * @generated
	 */
	int GT_FINAL_STATE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE__NAME = GfsmPackage.GFINAL_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE__FSM = GfsmPackage.GFINAL_STATE__FSM;

	/**
	 * The feature id for the '<em><b>Outgoingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE__OUTGOINGTRANSITIONS = GfsmPackage.GFINAL_STATE__OUTGOINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>Incommingtransitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE__INCOMMINGTRANSITIONS = GfsmPackage.GFINAL_STATE__INCOMMINGTRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE__IN_EXPRESSION = GfsmPackage.GFINAL_STATE__IN_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Out Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE__OUT_EXPRESSION = GfsmPackage.GFINAL_STATE__OUT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Stateguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE__STATEGUARD = GfsmPackage.GFINAL_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>GT Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE_FEATURE_COUNT = GfsmPackage.GFINAL_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>GT Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_FINAL_STATE_OPERATION_COUNT = GfsmPackage.GFINAL_STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gtfsm.impl.GTTransitionImpl <em>GT Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gtfsm.impl.GTTransitionImpl
	 * @see gtfsm.impl.GtfsmPackageImpl#getGTTransition()
	 * @generated
	 */
	int GT_TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION__FSM = TfsmPackage.TIMED_TRANSITION__FSM;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION__FROM = TfsmPackage.TIMED_TRANSITION__FROM;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION__TO = TfsmPackage.TIMED_TRANSITION__TO;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION__EVENT = TfsmPackage.TIMED_TRANSITION__EVENT;

	/**
	 * The feature id for the '<em><b>Clockresets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION__CLOCKRESETS = TfsmPackage.TIMED_TRANSITION__CLOCKRESETS;

	/**
	 * The feature id for the '<em><b>Transitionguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION__TRANSITIONGUARD = TfsmPackage.TIMED_TRANSITION__TRANSITIONGUARD;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION__GUARD = TfsmPackage.TIMED_TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>GT Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION_FEATURE_COUNT = TfsmPackage.TIMED_TRANSITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>GT Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GT_TRANSITION_OPERATION_COUNT = TfsmPackage.TIMED_TRANSITION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link gtfsm.GTFSM <em>GTFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GTFSM</em>'.
	 * @see gtfsm.GTFSM
	 * @generated
	 */
	EClass getGTFSM();

	/**
	 * Returns the meta object for class '{@link gtfsm.GTState <em>GT State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GT State</em>'.
	 * @see gtfsm.GTState
	 * @generated
	 */
	EClass getGTState();

	/**
	 * Returns the meta object for class '{@link gtfsm.GTInitialState <em>GT Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GT Initial State</em>'.
	 * @see gtfsm.GTInitialState
	 * @generated
	 */
	EClass getGTInitialState();

	/**
	 * Returns the meta object for class '{@link gtfsm.GTFinalState <em>GT Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GT Final State</em>'.
	 * @see gtfsm.GTFinalState
	 * @generated
	 */
	EClass getGTFinalState();

	/**
	 * Returns the meta object for class '{@link gtfsm.GTTransition <em>GT Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GT Transition</em>'.
	 * @see gtfsm.GTTransition
	 * @generated
	 */
	EClass getGTTransition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GtfsmFactory getGtfsmFactory();

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
		 * The meta object literal for the '{@link gtfsm.impl.GTFSMImpl <em>GTFSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gtfsm.impl.GTFSMImpl
		 * @see gtfsm.impl.GtfsmPackageImpl#getGTFSM()
		 * @generated
		 */
		EClass GTFSM = eINSTANCE.getGTFSM();

		/**
		 * The meta object literal for the '{@link gtfsm.impl.GTStateImpl <em>GT State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gtfsm.impl.GTStateImpl
		 * @see gtfsm.impl.GtfsmPackageImpl#getGTState()
		 * @generated
		 */
		EClass GT_STATE = eINSTANCE.getGTState();

		/**
		 * The meta object literal for the '{@link gtfsm.impl.GTInitialStateImpl <em>GT Initial State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gtfsm.impl.GTInitialStateImpl
		 * @see gtfsm.impl.GtfsmPackageImpl#getGTInitialState()
		 * @generated
		 */
		EClass GT_INITIAL_STATE = eINSTANCE.getGTInitialState();

		/**
		 * The meta object literal for the '{@link gtfsm.impl.GTFinalStateImpl <em>GT Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gtfsm.impl.GTFinalStateImpl
		 * @see gtfsm.impl.GtfsmPackageImpl#getGTFinalState()
		 * @generated
		 */
		EClass GT_FINAL_STATE = eINSTANCE.getGTFinalState();

		/**
		 * The meta object literal for the '{@link gtfsm.impl.GTTransitionImpl <em>GT Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gtfsm.impl.GTTransitionImpl
		 * @see gtfsm.impl.GtfsmPackageImpl#getGTTransition()
		 * @generated
		 */
		EClass GT_TRANSITION = eINSTANCE.getGTTransition();

	}

} //GtfsmPackage
