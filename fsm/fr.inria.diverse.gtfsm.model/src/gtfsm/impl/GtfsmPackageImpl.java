/**
 */
package gtfsm.impl;

import gfsm.GfsmPackage;

import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;
import gtfsm.GtfsmFactory;
import gtfsm.GtfsmPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tfsm.TfsmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GtfsmPackageImpl extends EPackageImpl implements GtfsmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gtfsmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gtStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gtInitialStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gtFinalStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gtTransitionEClass = null;

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
	 * @see gtfsm.GtfsmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GtfsmPackageImpl() {
		super(eNS_URI, GtfsmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GtfsmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GtfsmPackage init() {
		if (isInited) return (GtfsmPackage)EPackage.Registry.INSTANCE.getEPackage(GtfsmPackage.eNS_URI);

		// Obtain or create and register package
		GtfsmPackageImpl theGtfsmPackage = (GtfsmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GtfsmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GtfsmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GfsmPackage.eINSTANCE.eClass();
		TfsmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGtfsmPackage.createPackageContents();

		// Initialize created meta-data
		theGtfsmPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGtfsmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GtfsmPackage.eNS_URI, theGtfsmPackage);
		return theGtfsmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGTFSM() {
		return gtfsmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGTState() {
		return gtStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGTInitialState() {
		return gtInitialStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGTFinalState() {
		return gtFinalStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGTTransition() {
		return gtTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GtfsmFactory getGtfsmFactory() {
		return (GtfsmFactory)getEFactoryInstance();
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
		gtfsmEClass = createEClass(GTFSM);

		gtStateEClass = createEClass(GT_STATE);

		gtInitialStateEClass = createEClass(GT_INITIAL_STATE);

		gtFinalStateEClass = createEClass(GT_FINAL_STATE);

		gtTransitionEClass = createEClass(GT_TRANSITION);
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
		TfsmPackage theTfsmPackage = (TfsmPackage)EPackage.Registry.INSTANCE.getEPackage(TfsmPackage.eNS_URI);
		GfsmPackage theGfsmPackage = (GfsmPackage)EPackage.Registry.INSTANCE.getEPackage(GfsmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		gtfsmEClass.getESuperTypes().add(theTfsmPackage.getTimedFSM());
		gtfsmEClass.getESuperTypes().add(theGfsmPackage.getGFSM());
		gtStateEClass.getESuperTypes().add(theGfsmPackage.getGState());
		gtStateEClass.getESuperTypes().add(theTfsmPackage.getTimedState());
		gtInitialStateEClass.getESuperTypes().add(this.getGTState());
		gtInitialStateEClass.getESuperTypes().add(theTfsmPackage.getTimedInitialState());
		gtInitialStateEClass.getESuperTypes().add(theGfsmPackage.getGInitialState());
		gtFinalStateEClass.getESuperTypes().add(theGfsmPackage.getGFinalState());
		gtFinalStateEClass.getESuperTypes().add(theTfsmPackage.getTimedFinalState());
		gtFinalStateEClass.getESuperTypes().add(this.getGTState());
		gtTransitionEClass.getESuperTypes().add(theTfsmPackage.getTimedTransition());
		gtTransitionEClass.getESuperTypes().add(theGfsmPackage.getGTransition());

		// Initialize classes, features, and operations; add parameters
		initEClass(gtfsmEClass, gtfsm.GTFSM.class, "GTFSM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gtStateEClass, GTState.class, "GTState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gtInitialStateEClass, GTInitialState.class, "GTInitialState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gtFinalStateEClass, GTFinalState.class, "GTFinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gtTransitionEClass, GTTransition.class, "GTTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //GtfsmPackageImpl
