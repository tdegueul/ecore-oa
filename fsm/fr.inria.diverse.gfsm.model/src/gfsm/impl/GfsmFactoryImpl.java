/**
 */
package gfsm.impl;

import gfsm.*;

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
public class GfsmFactoryImpl extends EFactoryImpl implements GfsmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GfsmFactory init() {
		try {
			GfsmFactory theGfsmFactory = (GfsmFactory)EPackage.Registry.INSTANCE.getEFactory(GfsmPackage.eNS_URI);
			if (theGfsmFactory != null) {
				return theGfsmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GfsmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GfsmFactoryImpl() {
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
			case GfsmPackage.GTRANSITION: return createGTransition();
			case GfsmPackage.GSTATE: return createGState();
			case GfsmPackage.GFINAL_STATE: return createGFinalState();
			case GfsmPackage.GINITIAL_STATE: return createGInitialState();
			case GfsmPackage.GFSM: return createGFSM();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GTransition createGTransition() {
		GTransitionImpl gTransition = new GTransitionImpl();
		return gTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GState createGState() {
		GStateImpl gState = new GStateImpl();
		return gState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GFinalState createGFinalState() {
		GFinalStateImpl gFinalState = new GFinalStateImpl();
		return gFinalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GInitialState createGInitialState() {
		GInitialStateImpl gInitialState = new GInitialStateImpl();
		return gInitialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GFSM createGFSM() {
		GFSMImpl gfsm = new GFSMImpl();
		return gfsm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GfsmPackage getGfsmPackage() {
		return (GfsmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GfsmPackage getPackage() {
		return GfsmPackage.eINSTANCE;
	}

} //GfsmFactoryImpl
