/**
 */
package tfsm;

import fsm.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm.TimedState#getStateguard <em>Stateguard</em>}</li>
 * </ul>
 *
 * @see tfsm.TfsmPackage#getTimedState()
 * @model
 * @generated
 */
public interface TimedState extends State {
	/**
	 * Returns the value of the '<em><b>Stateguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stateguard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stateguard</em>' containment reference.
	 * @see #setStateguard(ClockConstraintOperation)
	 * @see tfsm.TfsmPackage#getTimedState_Stateguard()
	 * @model containment="true"
	 * @generated
	 */
	ClockConstraintOperation getStateguard();

	/**
	 * Sets the value of the '{@link tfsm.TimedState#getStateguard <em>Stateguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stateguard</em>' containment reference.
	 * @see #getStateguard()
	 * @generated
	 */
	void setStateguard(ClockConstraintOperation value);

} // TimedState
