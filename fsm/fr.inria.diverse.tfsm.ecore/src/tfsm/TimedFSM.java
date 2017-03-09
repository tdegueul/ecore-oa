/**
 */
package tfsm;

import fsm.FSM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed FSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm.TimedFSM#getClocks <em>Clocks</em>}</li>
 * </ul>
 *
 * @see tfsm.TfsmPackage#getTimedFSM()
 * @model
 * @generated
 */
public interface TimedFSM extends FSM {
	/**
	 * Returns the value of the '<em><b>Clocks</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm.Clock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clocks</em>' containment reference list.
	 * @see tfsm.TfsmPackage#getTimedFSM_Clocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Clock> getClocks();

} // TimedFSM
