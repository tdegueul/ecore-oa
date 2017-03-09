/**
 */
package tfsm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Clock Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm.BinaryClockConstraint#getLeft <em>Left</em>}</li>
 *   <li>{@link tfsm.BinaryClockConstraint#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see tfsm.TfsmPackage#getBinaryClockConstraint()
 * @model abstract="true"
 * @generated
 */
public interface BinaryClockConstraint extends ClockConstraintOperation {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(ClockConstraintOperation)
	 * @see tfsm.TfsmPackage#getBinaryClockConstraint_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ClockConstraintOperation getLeft();

	/**
	 * Sets the value of the '{@link tfsm.BinaryClockConstraint#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(ClockConstraintOperation value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(ClockConstraintOperation)
	 * @see tfsm.TfsmPackage#getBinaryClockConstraint_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ClockConstraintOperation getRight();

	/**
	 * Sets the value of the '{@link tfsm.BinaryClockConstraint#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(ClockConstraintOperation value);

} // BinaryClockConstraint
