/**
 */
package expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link expression.IntBlock#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @see expression.ExpressionPackage#getIntBlock()
 * @model
 * @generated
 */
public interface IntBlock extends IntOperation {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link expression.IntVarAssign}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see expression.ExpressionPackage#getIntBlock_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntVarAssign> getOperations();

} // IntBlock
