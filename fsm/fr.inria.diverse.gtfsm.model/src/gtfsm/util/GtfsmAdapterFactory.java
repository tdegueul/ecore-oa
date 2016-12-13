/**
 */
package gtfsm.util;

import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;

import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;

import gtfsm.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tfsm.TimedFSM;
import tfsm.TimedFinalState;
import tfsm.TimedInitialState;
import tfsm.TimedState;
import tfsm.TimedTransition;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gtfsm.GtfsmPackage
 * @generated
 */
public class GtfsmAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GtfsmPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GtfsmAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GtfsmPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GtfsmSwitch<Adapter> modelSwitch =
		new GtfsmSwitch<Adapter>() {
			@Override
			public Adapter caseGTFSM(GTFSM object) {
				return createGTFSMAdapter();
			}
			@Override
			public Adapter caseGTState(GTState object) {
				return createGTStateAdapter();
			}
			@Override
			public Adapter caseGTInitialState(GTInitialState object) {
				return createGTInitialStateAdapter();
			}
			@Override
			public Adapter caseGTFinalState(GTFinalState object) {
				return createGTFinalStateAdapter();
			}
			@Override
			public Adapter caseGTTransition(GTTransition object) {
				return createGTTransitionAdapter();
			}
			@Override
			public Adapter caseFSM(FSM object) {
				return createFSMAdapter();
			}
			@Override
			public Adapter caseTimedFSM(TimedFSM object) {
				return createTimedFSMAdapter();
			}
			@Override
			public Adapter caseGFSM(GFSM object) {
				return createGFSMAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseGState(GState object) {
				return createGStateAdapter();
			}
			@Override
			public Adapter caseTimedState(TimedState object) {
				return createTimedStateAdapter();
			}
			@Override
			public Adapter caseInitialState(InitialState object) {
				return createInitialStateAdapter();
			}
			@Override
			public Adapter caseTimedInitialState(TimedInitialState object) {
				return createTimedInitialStateAdapter();
			}
			@Override
			public Adapter caseGInitialState(GInitialState object) {
				return createGInitialStateAdapter();
			}
			@Override
			public Adapter caseFinalState(FinalState object) {
				return createFinalStateAdapter();
			}
			@Override
			public Adapter caseGFinalState(GFinalState object) {
				return createGFinalStateAdapter();
			}
			@Override
			public Adapter caseTimedFinalState(TimedFinalState object) {
				return createTimedFinalStateAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseTimedTransition(TimedTransition object) {
				return createTimedTransitionAdapter();
			}
			@Override
			public Adapter caseGTransition(GTransition object) {
				return createGTransitionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link gtfsm.GTFSM <em>GTFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gtfsm.GTFSM
	 * @generated
	 */
	public Adapter createGTFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gtfsm.GTState <em>GT State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gtfsm.GTState
	 * @generated
	 */
	public Adapter createGTStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gtfsm.GTInitialState <em>GT Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gtfsm.GTInitialState
	 * @generated
	 */
	public Adapter createGTInitialStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gtfsm.GTFinalState <em>GT Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gtfsm.GTFinalState
	 * @generated
	 */
	public Adapter createGTFinalStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gtfsm.GTTransition <em>GT Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gtfsm.GTTransition
	 * @generated
	 */
	public Adapter createGTTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsm.FSM <em>FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsm.FSM
	 * @generated
	 */
	public Adapter createFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm.TimedFSM <em>Timed FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm.TimedFSM
	 * @generated
	 */
	public Adapter createTimedFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gfsm.GFSM <em>GFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gfsm.GFSM
	 * @generated
	 */
	public Adapter createGFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsm.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsm.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gfsm.GState <em>GState</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gfsm.GState
	 * @generated
	 */
	public Adapter createGStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm.TimedState <em>Timed State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm.TimedState
	 * @generated
	 */
	public Adapter createTimedStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsm.InitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsm.InitialState
	 * @generated
	 */
	public Adapter createInitialStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm.TimedInitialState <em>Timed Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm.TimedInitialState
	 * @generated
	 */
	public Adapter createTimedInitialStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gfsm.GInitialState <em>GInitial State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gfsm.GInitialState
	 * @generated
	 */
	public Adapter createGInitialStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsm.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsm.FinalState
	 * @generated
	 */
	public Adapter createFinalStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gfsm.GFinalState <em>GFinal State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gfsm.GFinalState
	 * @generated
	 */
	public Adapter createGFinalStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm.TimedFinalState <em>Timed Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm.TimedFinalState
	 * @generated
	 */
	public Adapter createTimedFinalStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsm.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsm.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm.TimedTransition <em>Timed Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm.TimedTransition
	 * @generated
	 */
	public Adapter createTimedTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gfsm.GTransition <em>GTransition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gfsm.GTransition
	 * @generated
	 */
	public Adapter createGTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GtfsmAdapterFactory
