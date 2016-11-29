/**
 */
package exp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link exp.Add#getLhs <em>Lhs</em>}</li>
 *   <li>{@link exp.Add#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see exp.ExpPackage#getAdd()
 * @model
 * @generated
 */
public interface Add extends Exp {
	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lhs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' reference.
	 * @see #setLhs(Exp)
	 * @see exp.ExpPackage#getAdd_Lhs()
	 * @model
	 * @generated
	 */
	Exp getLhs();

	/**
	 * Sets the value of the '{@link exp.Add#getLhs <em>Lhs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(Exp value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' reference.
	 * @see #setRhs(Exp)
	 * @see exp.ExpPackage#getAdd_Rhs()
	 * @model
	 * @generated
	 */
	Exp getRhs();

	/**
	 * Sets the value of the '{@link exp.Add#getRhs <em>Rhs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(Exp value);

} // Add
