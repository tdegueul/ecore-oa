/**
 */
package tfsm;

import fsm.Transition;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm.TimedTransition#getClockresets <em>Clockresets</em>}</li>
 *   <li>{@link tfsm.TimedTransition#getTransitionguard <em>Transitionguard</em>}</li>
 * </ul>
 *
 * @see tfsm.TfsmPackage#getTimedTransition()
 * @model
 * @generated
 */
public interface TimedTransition extends Transition {
	/**
	 * Returns the value of the '<em><b>Clockresets</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm.ClockReset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clockresets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clockresets</em>' containment reference list.
	 * @see tfsm.TfsmPackage#getTimedTransition_Clockresets()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClockReset> getClockresets();

	/**
	 * Returns the value of the '<em><b>Transitionguard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitionguard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitionguard</em>' containment reference.
	 * @see #setTransitionguard(ClockConstraintOperation)
	 * @see tfsm.TfsmPackage#getTimedTransition_Transitionguard()
	 * @model containment="true"
	 * @generated
	 */
	ClockConstraintOperation getTransitionguard();

	/**
	 * Sets the value of the '{@link tfsm.TimedTransition#getTransitionguard <em>Transitionguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transitionguard</em>' containment reference.
	 * @see #getTransitionguard()
	 * @generated
	 */
	void setTransitionguard(ClockConstraintOperation value);

} // TimedTransition
