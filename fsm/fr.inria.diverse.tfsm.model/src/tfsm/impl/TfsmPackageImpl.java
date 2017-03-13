/**
 */
package tfsm.impl;

import fsm.FsmPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tfsm.AndClockConstraint;
import tfsm.BinaryClockConstraint;
import tfsm.Clock;
import tfsm.ClockConstraint;
import tfsm.ClockConstraintOperation;
import tfsm.ClockReset;
import tfsm.LowerClockConstraint;
import tfsm.LowerEqualClockConstraint;
import tfsm.OrClockConstraint;
import tfsm.TfsmFactory;
import tfsm.TfsmPackage;
import tfsm.TimedFSM;
import tfsm.TimedFinalState;
import tfsm.TimedInitialState;
import tfsm.TimedState;
import tfsm.TimedTransition;
import tfsm.UpperClockConstraint;
import tfsm.UpperEqualClockConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TfsmPackageImpl extends EPackageImpl implements TfsmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedFSMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clockConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clockResetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lowerClockConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lowerEqualClockConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass upperClockConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass upperEqualClockConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clockConstraintOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andClockConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orClockConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryClockConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedFinalStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedInitialStateEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see tfsm.TfsmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TfsmPackageImpl() {
		super(eNS_URI, TfsmFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TfsmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TfsmPackage init() {
		if (isInited) return (TfsmPackage)EPackage.Registry.INSTANCE.getEPackage(TfsmPackage.eNS_URI);

		// Obtain or create and register package
		TfsmPackageImpl theTfsmPackage = (TfsmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TfsmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TfsmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		FsmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTfsmPackage.createPackageContents();

		// Initialize created meta-data
		theTfsmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTfsmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TfsmPackage.eNS_URI, theTfsmPackage);
		return theTfsmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedFSM() {
		return timedFSMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedFSM_Clocks() {
		return (EReference)timedFSMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedState() {
		return timedStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedState_Stateguard() {
		return (EReference)timedStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedTransition() {
		return timedTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedTransition_Clockresets() {
		return (EReference)timedTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimedTransition_Transitionguard() {
		return (EReference)timedTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClock() {
		return clockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClock_Name() {
		return (EAttribute)clockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClock_Tick() {
		return (EAttribute)clockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClockConstraint() {
		return clockConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClockConstraint_Threshold() {
		return (EAttribute)clockConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClockConstraint_Clock() {
		return (EReference)clockConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClockReset() {
		return clockResetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClockReset_Clock() {
		return (EReference)clockResetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLowerClockConstraint() {
		return lowerClockConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLowerEqualClockConstraint() {
		return lowerEqualClockConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpperClockConstraint() {
		return upperClockConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpperEqualClockConstraint() {
		return upperEqualClockConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClockConstraintOperation() {
		return clockConstraintOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndClockConstraint() {
		return andClockConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrClockConstraint() {
		return orClockConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryClockConstraint() {
		return binaryClockConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryClockConstraint_Left() {
		return (EReference)binaryClockConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryClockConstraint_Right() {
		return (EReference)binaryClockConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedFinalState() {
		return timedFinalStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedInitialState() {
		return timedInitialStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TfsmFactory getTfsmFactory() {
		return (TfsmFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		timedFSMEClass = createEClass(TIMED_FSM);
		createEReference(timedFSMEClass, TIMED_FSM__CLOCKS);

		timedStateEClass = createEClass(TIMED_STATE);
		createEReference(timedStateEClass, TIMED_STATE__STATEGUARD);

		timedTransitionEClass = createEClass(TIMED_TRANSITION);
		createEReference(timedTransitionEClass, TIMED_TRANSITION__CLOCKRESETS);
		createEReference(timedTransitionEClass, TIMED_TRANSITION__TRANSITIONGUARD);

		clockEClass = createEClass(CLOCK);
		createEAttribute(clockEClass, CLOCK__NAME);
		createEAttribute(clockEClass, CLOCK__TICK);

		clockConstraintEClass = createEClass(CLOCK_CONSTRAINT);
		createEAttribute(clockConstraintEClass, CLOCK_CONSTRAINT__THRESHOLD);
		createEReference(clockConstraintEClass, CLOCK_CONSTRAINT__CLOCK);

		clockResetEClass = createEClass(CLOCK_RESET);
		createEReference(clockResetEClass, CLOCK_RESET__CLOCK);

		lowerClockConstraintEClass = createEClass(LOWER_CLOCK_CONSTRAINT);

		lowerEqualClockConstraintEClass = createEClass(LOWER_EQUAL_CLOCK_CONSTRAINT);

		upperClockConstraintEClass = createEClass(UPPER_CLOCK_CONSTRAINT);

		upperEqualClockConstraintEClass = createEClass(UPPER_EQUAL_CLOCK_CONSTRAINT);

		clockConstraintOperationEClass = createEClass(CLOCK_CONSTRAINT_OPERATION);

		andClockConstraintEClass = createEClass(AND_CLOCK_CONSTRAINT);

		orClockConstraintEClass = createEClass(OR_CLOCK_CONSTRAINT);

		binaryClockConstraintEClass = createEClass(BINARY_CLOCK_CONSTRAINT);
		createEReference(binaryClockConstraintEClass, BINARY_CLOCK_CONSTRAINT__LEFT);
		createEReference(binaryClockConstraintEClass, BINARY_CLOCK_CONSTRAINT__RIGHT);

		timedFinalStateEClass = createEClass(TIMED_FINAL_STATE);

		timedInitialStateEClass = createEClass(TIMED_INITIAL_STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		FsmPackage theFsmPackage = (FsmPackage)EPackage.Registry.INSTANCE.getEPackage(FsmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		timedFSMEClass.getESuperTypes().add(theFsmPackage.getFSM());
		timedStateEClass.getESuperTypes().add(theFsmPackage.getState());
		timedTransitionEClass.getESuperTypes().add(theFsmPackage.getTransition());
		clockConstraintEClass.getESuperTypes().add(this.getClockConstraintOperation());
		lowerClockConstraintEClass.getESuperTypes().add(this.getClockConstraint());
		lowerEqualClockConstraintEClass.getESuperTypes().add(this.getClockConstraint());
		upperClockConstraintEClass.getESuperTypes().add(this.getClockConstraint());
		upperEqualClockConstraintEClass.getESuperTypes().add(this.getClockConstraint());
		andClockConstraintEClass.getESuperTypes().add(this.getBinaryClockConstraint());
		orClockConstraintEClass.getESuperTypes().add(this.getBinaryClockConstraint());
		binaryClockConstraintEClass.getESuperTypes().add(this.getClockConstraintOperation());
		timedFinalStateEClass.getESuperTypes().add(theFsmPackage.getFinalState());
		timedFinalStateEClass.getESuperTypes().add(this.getTimedState());
		timedInitialStateEClass.getESuperTypes().add(this.getTimedState());
		timedInitialStateEClass.getESuperTypes().add(theFsmPackage.getInitialState());

		// Initialize classes, features, and operations; add parameters
		initEClass(timedFSMEClass, TimedFSM.class, "TimedFSM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimedFSM_Clocks(), this.getClock(), null, "clocks", null, 0, -1, TimedFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timedStateEClass, TimedState.class, "TimedState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimedState_Stateguard(), this.getClockConstraintOperation(), null, "stateguard", null, 0, 1, TimedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timedTransitionEClass, TimedTransition.class, "TimedTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimedTransition_Clockresets(), this.getClockReset(), null, "clockresets", null, 0, -1, TimedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimedTransition_Transitionguard(), this.getClockConstraintOperation(), null, "transitionguard", null, 0, 1, TimedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clockEClass, Clock.class, "Clock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClock_Name(), ecorePackage.getEString(), "name", null, 0, 1, Clock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClock_Tick(), ecorePackage.getEInt(), "tick", "0", 0, 1, Clock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clockConstraintEClass, ClockConstraint.class, "ClockConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClockConstraint_Threshold(), ecorePackage.getEInt(), "threshold", null, 0, 1, ClockConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClockConstraint_Clock(), this.getClock(), null, "clock", null, 1, 1, ClockConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clockResetEClass, ClockReset.class, "ClockReset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClockReset_Clock(), this.getClock(), null, "clock", null, 1, 1, ClockReset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lowerClockConstraintEClass, LowerClockConstraint.class, "LowerClockConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lowerEqualClockConstraintEClass, LowerEqualClockConstraint.class, "LowerEqualClockConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(upperClockConstraintEClass, UpperClockConstraint.class, "UpperClockConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(upperEqualClockConstraintEClass, UpperEqualClockConstraint.class, "UpperEqualClockConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(clockConstraintOperationEClass, ClockConstraintOperation.class, "ClockConstraintOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andClockConstraintEClass, AndClockConstraint.class, "AndClockConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orClockConstraintEClass, OrClockConstraint.class, "OrClockConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryClockConstraintEClass, BinaryClockConstraint.class, "BinaryClockConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryClockConstraint_Left(), this.getClockConstraintOperation(), null, "left", null, 1, 1, BinaryClockConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryClockConstraint_Right(), this.getClockConstraintOperation(), null, "right", null, 1, 1, BinaryClockConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timedFinalStateEClass, TimedFinalState.class, "TimedFinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timedInitialStateEClass, TimedInitialState.class, "TimedInitialState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TfsmPackageImpl
