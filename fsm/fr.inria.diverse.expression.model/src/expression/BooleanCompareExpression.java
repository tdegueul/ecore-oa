/**
 */
package expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Compare Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link expression.BooleanCompareExpression#getLhs <em>Lhs</em>}</li>
 *   <li>{@link expression.BooleanCompareExpression#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see expression.ExpressionPackage#getBooleanCompareExpression()
 * @model abstract="true"
 * @generated
 */
public interface BooleanCompareExpression extends BooleanExpression {
	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' containment reference.
	 * @see #setLhs(IntExpression)
	 * @see expression.ExpressionPackage#getBooleanCompareExpression_Lhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getLhs();

	/**
	 * Sets the value of the '{@link expression.BooleanCompareExpression#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(IntExpression)
	 * @see expression.ExpressionPackage#getBooleanCompareExpression_Rhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getRhs();

	/**
	 * Sets the value of the '{@link expression.BooleanCompareExpression#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(IntExpression value);

} // BooleanCompareExpression
