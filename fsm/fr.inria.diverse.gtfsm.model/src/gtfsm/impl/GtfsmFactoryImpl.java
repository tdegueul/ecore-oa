/**
 */
package gtfsm.impl;

import gtfsm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GtfsmFactoryImpl extends EFactoryImpl implements GtfsmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GtfsmFactory init() {
		try {
			GtfsmFactory theGtfsmFactory = (GtfsmFactory)EPackage.Registry.INSTANCE.getEFactory(GtfsmPackage.eNS_URI);
			if (theGtfsmFactory != null) {
				return theGtfsmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GtfsmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GtfsmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GtfsmPackage.GTFSM: return createGTFSM();
			case GtfsmPackage.GT_STATE: return createGTState();
			case GtfsmPackage.GT_INITIAL_STATE: return createGTInitialState();
			case GtfsmPackage.GT_FINAL_STATE: return createGTFinalState();
			case GtfsmPackage.GT_TRANSITION: return createGTTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GTFSM createGTFSM() {
		GTFSMImpl gtfsm = new GTFSMImpl();
		return gtfsm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GTState createGTState() {
		GTStateImpl gtState = new GTStateImpl();
		return gtState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GTInitialState createGTInitialState() {
		GTInitialStateImpl gtInitialState = new GTInitialStateImpl();
		return gtInitialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GTFinalState createGTFinalState() {
		GTFinalStateImpl gtFinalState = new GTFinalStateImpl();
		return gtFinalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GTTransition createGTTransition() {
		GTTransitionImpl gtTransition = new GTTransitionImpl();
		return gtTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GtfsmPackage getGtfsmPackage() {
		return (GtfsmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GtfsmPackage getPackage() {
		return GtfsmPackage.eINSTANCE;
	}

} //GtfsmFactoryImpl
