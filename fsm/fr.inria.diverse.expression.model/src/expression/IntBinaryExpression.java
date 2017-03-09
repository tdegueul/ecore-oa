/**
 */
package expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link expression.IntBinaryExpression#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link expression.IntBinaryExpression#getExpression2 <em>Expression2</em>}</li>
 * </ul>
 *
 * @see expression.ExpressionPackage#getIntBinaryExpression()
 * @model abstract="true"
 * @generated
 */
public interface IntBinaryExpression extends IntExpression {
	/**
	 * Returns the value of the '<em><b>Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression1</em>' containment reference.
	 * @see #setExpression1(IntExpression)
	 * @see expression.ExpressionPackage#getIntBinaryExpression_Expression1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getExpression1();

	/**
	 * Sets the value of the '{@link expression.IntBinaryExpression#getExpression1 <em>Expression1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression1</em>' containment reference.
	 * @see #getExpression1()
	 * @generated
	 */
	void setExpression1(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression2</em>' containment reference.
	 * @see #setExpression2(IntExpression)
	 * @see expression.ExpressionPackage#getIntBinaryExpression_Expression2()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getExpression2();

	/**
	 * Sets the value of the '{@link expression.IntBinaryExpression#getExpression2 <em>Expression2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression2</em>' containment reference.
	 * @see #getExpression2()
	 * @generated
	 */
	void setExpression2(IntExpression value);

} // IntBinaryExpression
