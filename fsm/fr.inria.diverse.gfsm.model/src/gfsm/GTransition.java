/**
 */
package gfsm;

import expression.BooleanExpression;

import fsm.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GTransition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gfsm.GTransition#getGuard <em>Guard</em>}</li>
 * </ul>
 *
 * @see gfsm.GfsmPackage#getGTransition()
 * @model
 * @generated
 */
public interface GTransition extends Transition {
	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(BooleanExpression)
	 * @see gfsm.GfsmPackage#getGTransition_Guard()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanExpression getGuard();

	/**
	 * Sets the value of the '{@link gfsm.GTransition#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(BooleanExpression value);

} // GTransition
