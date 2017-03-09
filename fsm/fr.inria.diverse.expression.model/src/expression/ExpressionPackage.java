/**
 */
package expression;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see expression.ExpressionFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expression";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://inria.fr/expression";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fr.inria.diverse.expression.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionPackage eINSTANCE = expression.impl.ExpressionPackageImpl.init();

	/**
	 * The meta object id for the '{@link expression.impl.IntExpressionImpl <em>Int Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntExpressionImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntExpression()
	 * @generated
	 */
	int INT_EXPRESSION = 16;

	/**
	 * The number of structural features of the '<em>Int Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Int Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link expression.impl.IntBinaryExpressionImpl <em>Int Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntBinaryExpressionImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntBinaryExpression()
	 * @generated
	 */
	int INT_BINARY_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_BINARY_EXPRESSION__EXPRESSION1 = INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_BINARY_EXPRESSION__EXPRESSION2 = INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Int Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_BINARY_EXPRESSION_FEATURE_COUNT = INT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Int Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_BINARY_EXPRESSION_OPERATION_COUNT = INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.IntAddImpl <em>Int Add</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntAddImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntAdd()
	 * @generated
	 */
	int INT_ADD = 1;

	/**
	 * The feature id for the '<em><b>Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ADD__EXPRESSION1 = INT_BINARY_EXPRESSION__EXPRESSION1;

	/**
	 * The feature id for the '<em><b>Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ADD__EXPRESSION2 = INT_BINARY_EXPRESSION__EXPRESSION2;

	/**
	 * The number of structural features of the '<em>Int Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ADD_FEATURE_COUNT = INT_BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Int Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_ADD_OPERATION_COUNT = INT_BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.IntMultImpl <em>Int Mult</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntMultImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntMult()
	 * @generated
	 */
	int INT_MULT = 2;

	/**
	 * The feature id for the '<em><b>Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_MULT__EXPRESSION1 = INT_BINARY_EXPRESSION__EXPRESSION1;

	/**
	 * The feature id for the '<em><b>Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_MULT__EXPRESSION2 = INT_BINARY_EXPRESSION__EXPRESSION2;

	/**
	 * The number of structural features of the '<em>Int Mult</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_MULT_FEATURE_COUNT = INT_BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Int Mult</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_MULT_OPERATION_COUNT = INT_BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.IntNegImpl <em>Int Neg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntNegImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntNeg()
	 * @generated
	 */
	int INT_NEG = 3;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_NEG__EXPRESSION = INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Neg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_NEG_FEATURE_COUNT = INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Neg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_NEG_OPERATION_COUNT = INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.IntVarRefImpl <em>Int Var Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntVarRefImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntVarRef()
	 * @generated
	 */
	int INT_VAR_REF = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VAR_REF__NAME = INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Var Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VAR_REF_FEATURE_COUNT = INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Var Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VAR_REF_OPERATION_COUNT = INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.ConstExprImpl <em>Const Expr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.ConstExprImpl
	 * @see expression.impl.ExpressionPackageImpl#getConstExpr()
	 * @generated
	 */
	int CONST_EXPR = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_EXPR__VALUE = INT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Const Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_EXPR_FEATURE_COUNT = INT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Const Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_EXPR_OPERATION_COUNT = INT_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.BooleanExpressionImpl
	 * @see expression.impl.ExpressionPackageImpl#getBooleanExpression()
	 * @generated
	 */
	int BOOLEAN_EXPRESSION = 6;

	/**
	 * The number of structural features of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link expression.impl.IntOperationImpl <em>Int Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntOperationImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntOperation()
	 * @generated
	 */
	int INT_OPERATION = 7;

	/**
	 * The number of structural features of the '<em>Int Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_OPERATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Int Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link expression.impl.IntVarAssignImpl <em>Int Var Assign</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntVarAssignImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntVarAssign()
	 * @generated
	 */
	int INT_VAR_ASSIGN = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VAR_ASSIGN__NAME = INT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VAR_ASSIGN__EXPRESSION = INT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Int Var Assign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VAR_ASSIGN_FEATURE_COUNT = INT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Int Var Assign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VAR_ASSIGN_OPERATION_COUNT = INT_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.IntBlockImpl <em>Int Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.IntBlockImpl
	 * @see expression.impl.ExpressionPackageImpl#getIntBlock()
	 * @generated
	 */
	int INT_BLOCK = 9;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_BLOCK__OPERATIONS = INT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_BLOCK_FEATURE_COUNT = INT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_BLOCK_OPERATION_COUNT = INT_OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.BooleanCompareExpressionImpl <em>Boolean Compare Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.BooleanCompareExpressionImpl
	 * @see expression.impl.ExpressionPackageImpl#getBooleanCompareExpression()
	 * @generated
	 */
	int BOOLEAN_COMPARE_EXPRESSION = 15;

	/**
	 * The feature id for the '<em><b>Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COMPARE_EXPRESSION__EXPRESSION1 = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COMPARE_EXPRESSION__EXPRESSION2 = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Compare Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COMPARE_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Boolean Compare Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_COMPARE_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.BooleanEqualImpl <em>Boolean Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.BooleanEqualImpl
	 * @see expression.impl.ExpressionPackageImpl#getBooleanEqual()
	 * @generated
	 */
	int BOOLEAN_EQUAL = 10;

	/**
	 * The feature id for the '<em><b>Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL__EXPRESSION1 = BOOLEAN_COMPARE_EXPRESSION__EXPRESSION1;

	/**
	 * The feature id for the '<em><b>Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL__EXPRESSION2 = BOOLEAN_COMPARE_EXPRESSION__EXPRESSION2;

	/**
	 * The number of structural features of the '<em>Boolean Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL_FEATURE_COUNT = BOOLEAN_COMPARE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EQUAL_OPERATION_COUNT = BOOLEAN_COMPARE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.BooleanBinaryExpressionImpl <em>Boolean Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.BooleanBinaryExpressionImpl
	 * @see expression.impl.ExpressionPackageImpl#getBooleanBinaryExpression()
	 * @generated
	 */
	int BOOLEAN_BINARY_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Bool Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BINARY_EXPRESSION__BOOL_EXPRESSION1 = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bool Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BINARY_EXPRESSION__BOOL_EXPRESSION2 = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BINARY_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Boolean Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_BINARY_EXPRESSION_OPERATION_COUNT = BOOLEAN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.BooleanOrImpl <em>Boolean Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.BooleanOrImpl
	 * @see expression.impl.ExpressionPackageImpl#getBooleanOr()
	 * @generated
	 */
	int BOOLEAN_OR = 11;

	/**
	 * The feature id for the '<em><b>Bool Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR__BOOL_EXPRESSION1 = BOOLEAN_BINARY_EXPRESSION__BOOL_EXPRESSION1;

	/**
	 * The feature id for the '<em><b>Bool Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR__BOOL_EXPRESSION2 = BOOLEAN_BINARY_EXPRESSION__BOOL_EXPRESSION2;

	/**
	 * The number of structural features of the '<em>Boolean Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_FEATURE_COUNT = BOOLEAN_BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_OPERATION_COUNT = BOOLEAN_BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.BooleanAndImpl <em>Boolean And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.BooleanAndImpl
	 * @see expression.impl.ExpressionPackageImpl#getBooleanAnd()
	 * @generated
	 */
	int BOOLEAN_AND = 12;

	/**
	 * The feature id for the '<em><b>Bool Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND__BOOL_EXPRESSION1 = BOOLEAN_BINARY_EXPRESSION__BOOL_EXPRESSION1;

	/**
	 * The feature id for the '<em><b>Bool Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND__BOOL_EXPRESSION2 = BOOLEAN_BINARY_EXPRESSION__BOOL_EXPRESSION2;

	/**
	 * The number of structural features of the '<em>Boolean And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_FEATURE_COUNT = BOOLEAN_BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_OPERATION_COUNT = BOOLEAN_BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link expression.impl.BooleanGreaterThanImpl <em>Boolean Greater Than</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see expression.impl.BooleanGreaterThanImpl
	 * @see expression.impl.ExpressionPackageImpl#getBooleanGreaterThan()
	 * @generated
	 */
	int BOOLEAN_GREATER_THAN = 13;

	/**
	 * The feature id for the '<em><b>Expression1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_GREATER_THAN__EXPRESSION1 = BOOLEAN_COMPARE_EXPRESSION__EXPRESSION1;

	/**
	 * The feature id for the '<em><b>Expression2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_GREATER_THAN__EXPRESSION2 = BOOLEAN_COMPARE_EXPRESSION__EXPRESSION2;

	/**
	 * The number of structural features of the '<em>Boolean Greater Than</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_GREATER_THAN_FEATURE_COUNT = BOOLEAN_COMPARE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Greater Than</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_GREATER_THAN_OPERATION_COUNT = BOOLEAN_COMPARE_EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link expression.IntBinaryExpression <em>Int Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Binary Expression</em>'.
	 * @see expression.IntBinaryExpression
	 * @generated
	 */
	EClass getIntBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link expression.IntBinaryExpression#getExpression1 <em>Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression1</em>'.
	 * @see expression.IntBinaryExpression#getExpression1()
	 * @see #getIntBinaryExpression()
	 * @generated
	 */
	EReference getIntBinaryExpression_Expression1();

	/**
	 * Returns the meta object for the containment reference '{@link expression.IntBinaryExpression#getExpression2 <em>Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression2</em>'.
	 * @see expression.IntBinaryExpression#getExpression2()
	 * @see #getIntBinaryExpression()
	 * @generated
	 */
	EReference getIntBinaryExpression_Expression2();

	/**
	 * Returns the meta object for class '{@link expression.IntAdd <em>Int Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Add</em>'.
	 * @see expression.IntAdd
	 * @generated
	 */
	EClass getIntAdd();

	/**
	 * Returns the meta object for class '{@link expression.IntMult <em>Int Mult</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Mult</em>'.
	 * @see expression.IntMult
	 * @generated
	 */
	EClass getIntMult();

	/**
	 * Returns the meta object for class '{@link expression.IntNeg <em>Int Neg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Neg</em>'.
	 * @see expression.IntNeg
	 * @generated
	 */
	EClass getIntNeg();

	/**
	 * Returns the meta object for the containment reference '{@link expression.IntNeg#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see expression.IntNeg#getExpression()
	 * @see #getIntNeg()
	 * @generated
	 */
	EReference getIntNeg_Expression();

	/**
	 * Returns the meta object for class '{@link expression.IntVarRef <em>Int Var Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Var Ref</em>'.
	 * @see expression.IntVarRef
	 * @generated
	 */
	EClass getIntVarRef();

	/**
	 * Returns the meta object for the attribute '{@link expression.IntVarRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see expression.IntVarRef#getName()
	 * @see #getIntVarRef()
	 * @generated
	 */
	EAttribute getIntVarRef_Name();

	/**
	 * Returns the meta object for class '{@link expression.ConstExpr <em>Const Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const Expr</em>'.
	 * @see expression.ConstExpr
	 * @generated
	 */
	EClass getConstExpr();

	/**
	 * Returns the meta object for the attribute '{@link expression.ConstExpr#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see expression.ConstExpr#getValue()
	 * @see #getConstExpr()
	 * @generated
	 */
	EAttribute getConstExpr_Value();

	/**
	 * Returns the meta object for class '{@link expression.BooleanExpression <em>Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Expression</em>'.
	 * @see expression.BooleanExpression
	 * @generated
	 */
	EClass getBooleanExpression();

	/**
	 * Returns the meta object for class '{@link expression.IntOperation <em>Int Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Operation</em>'.
	 * @see expression.IntOperation
	 * @generated
	 */
	EClass getIntOperation();

	/**
	 * Returns the meta object for class '{@link expression.IntVarAssign <em>Int Var Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Var Assign</em>'.
	 * @see expression.IntVarAssign
	 * @generated
	 */
	EClass getIntVarAssign();

	/**
	 * Returns the meta object for the attribute '{@link expression.IntVarAssign#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see expression.IntVarAssign#getName()
	 * @see #getIntVarAssign()
	 * @generated
	 */
	EAttribute getIntVarAssign_Name();

	/**
	 * Returns the meta object for the containment reference '{@link expression.IntVarAssign#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see expression.IntVarAssign#getExpression()
	 * @see #getIntVarAssign()
	 * @generated
	 */
	EReference getIntVarAssign_Expression();

	/**
	 * Returns the meta object for class '{@link expression.IntBlock <em>Int Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Block</em>'.
	 * @see expression.IntBlock
	 * @generated
	 */
	EClass getIntBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link expression.IntBlock#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see expression.IntBlock#getOperations()
	 * @see #getIntBlock()
	 * @generated
	 */
	EReference getIntBlock_Operations();

	/**
	 * Returns the meta object for class '{@link expression.BooleanEqual <em>Boolean Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Equal</em>'.
	 * @see expression.BooleanEqual
	 * @generated
	 */
	EClass getBooleanEqual();

	/**
	 * Returns the meta object for class '{@link expression.BooleanOr <em>Boolean Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Or</em>'.
	 * @see expression.BooleanOr
	 * @generated
	 */
	EClass getBooleanOr();

	/**
	 * Returns the meta object for class '{@link expression.BooleanAnd <em>Boolean And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean And</em>'.
	 * @see expression.BooleanAnd
	 * @generated
	 */
	EClass getBooleanAnd();

	/**
	 * Returns the meta object for class '{@link expression.BooleanGreaterThan <em>Boolean Greater Than</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Greater Than</em>'.
	 * @see expression.BooleanGreaterThan
	 * @generated
	 */
	EClass getBooleanGreaterThan();

	/**
	 * Returns the meta object for class '{@link expression.BooleanBinaryExpression <em>Boolean Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Binary Expression</em>'.
	 * @see expression.BooleanBinaryExpression
	 * @generated
	 */
	EClass getBooleanBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link expression.BooleanBinaryExpression#getBoolExpression1 <em>Bool Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bool Expression1</em>'.
	 * @see expression.BooleanBinaryExpression#getBoolExpression1()
	 * @see #getBooleanBinaryExpression()
	 * @generated
	 */
	EReference getBooleanBinaryExpression_BoolExpression1();

	/**
	 * Returns the meta object for the containment reference '{@link expression.BooleanBinaryExpression#getBoolExpression2 <em>Bool Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bool Expression2</em>'.
	 * @see expression.BooleanBinaryExpression#getBoolExpression2()
	 * @see #getBooleanBinaryExpression()
	 * @generated
	 */
	EReference getBooleanBinaryExpression_BoolExpression2();

	/**
	 * Returns the meta object for class '{@link expression.BooleanCompareExpression <em>Boolean Compare Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Compare Expression</em>'.
	 * @see expression.BooleanCompareExpression
	 * @generated
	 */
	EClass getBooleanCompareExpression();

	/**
	 * Returns the meta object for the containment reference '{@link expression.BooleanCompareExpression#getExpression1 <em>Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression1</em>'.
	 * @see expression.BooleanCompareExpression#getExpression1()
	 * @see #getBooleanCompareExpression()
	 * @generated
	 */
	EReference getBooleanCompareExpression_Expression1();

	/**
	 * Returns the meta object for the containment reference '{@link expression.BooleanCompareExpression#getExpression2 <em>Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression2</em>'.
	 * @see expression.BooleanCompareExpression#getExpression2()
	 * @see #getBooleanCompareExpression()
	 * @generated
	 */
	EReference getBooleanCompareExpression_Expression2();

	/**
	 * Returns the meta object for class '{@link expression.IntExpression <em>Int Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Expression</em>'.
	 * @see expression.IntExpression
	 * @generated
	 */
	EClass getIntExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionFactory getExpressionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link expression.impl.IntBinaryExpressionImpl <em>Int Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntBinaryExpressionImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntBinaryExpression()
		 * @generated
		 */
		EClass INT_BINARY_EXPRESSION = eINSTANCE.getIntBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_BINARY_EXPRESSION__EXPRESSION1 = eINSTANCE.getIntBinaryExpression_Expression1();

		/**
		 * The meta object literal for the '<em><b>Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_BINARY_EXPRESSION__EXPRESSION2 = eINSTANCE.getIntBinaryExpression_Expression2();

		/**
		 * The meta object literal for the '{@link expression.impl.IntAddImpl <em>Int Add</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntAddImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntAdd()
		 * @generated
		 */
		EClass INT_ADD = eINSTANCE.getIntAdd();

		/**
		 * The meta object literal for the '{@link expression.impl.IntMultImpl <em>Int Mult</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntMultImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntMult()
		 * @generated
		 */
		EClass INT_MULT = eINSTANCE.getIntMult();

		/**
		 * The meta object literal for the '{@link expression.impl.IntNegImpl <em>Int Neg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntNegImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntNeg()
		 * @generated
		 */
		EClass INT_NEG = eINSTANCE.getIntNeg();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_NEG__EXPRESSION = eINSTANCE.getIntNeg_Expression();

		/**
		 * The meta object literal for the '{@link expression.impl.IntVarRefImpl <em>Int Var Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntVarRefImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntVarRef()
		 * @generated
		 */
		EClass INT_VAR_REF = eINSTANCE.getIntVarRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_VAR_REF__NAME = eINSTANCE.getIntVarRef_Name();

		/**
		 * The meta object literal for the '{@link expression.impl.ConstExprImpl <em>Const Expr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.ConstExprImpl
		 * @see expression.impl.ExpressionPackageImpl#getConstExpr()
		 * @generated
		 */
		EClass CONST_EXPR = eINSTANCE.getConstExpr();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONST_EXPR__VALUE = eINSTANCE.getConstExpr_Value();

		/**
		 * The meta object literal for the '{@link expression.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.BooleanExpressionImpl
		 * @see expression.impl.ExpressionPackageImpl#getBooleanExpression()
		 * @generated
		 */
		EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

		/**
		 * The meta object literal for the '{@link expression.impl.IntOperationImpl <em>Int Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntOperationImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntOperation()
		 * @generated
		 */
		EClass INT_OPERATION = eINSTANCE.getIntOperation();

		/**
		 * The meta object literal for the '{@link expression.impl.IntVarAssignImpl <em>Int Var Assign</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntVarAssignImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntVarAssign()
		 * @generated
		 */
		EClass INT_VAR_ASSIGN = eINSTANCE.getIntVarAssign();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_VAR_ASSIGN__NAME = eINSTANCE.getIntVarAssign_Name();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_VAR_ASSIGN__EXPRESSION = eINSTANCE.getIntVarAssign_Expression();

		/**
		 * The meta object literal for the '{@link expression.impl.IntBlockImpl <em>Int Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntBlockImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntBlock()
		 * @generated
		 */
		EClass INT_BLOCK = eINSTANCE.getIntBlock();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_BLOCK__OPERATIONS = eINSTANCE.getIntBlock_Operations();

		/**
		 * The meta object literal for the '{@link expression.impl.BooleanEqualImpl <em>Boolean Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.BooleanEqualImpl
		 * @see expression.impl.ExpressionPackageImpl#getBooleanEqual()
		 * @generated
		 */
		EClass BOOLEAN_EQUAL = eINSTANCE.getBooleanEqual();

		/**
		 * The meta object literal for the '{@link expression.impl.BooleanOrImpl <em>Boolean Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.BooleanOrImpl
		 * @see expression.impl.ExpressionPackageImpl#getBooleanOr()
		 * @generated
		 */
		EClass BOOLEAN_OR = eINSTANCE.getBooleanOr();

		/**
		 * The meta object literal for the '{@link expression.impl.BooleanAndImpl <em>Boolean And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.BooleanAndImpl
		 * @see expression.impl.ExpressionPackageImpl#getBooleanAnd()
		 * @generated
		 */
		EClass BOOLEAN_AND = eINSTANCE.getBooleanAnd();

		/**
		 * The meta object literal for the '{@link expression.impl.BooleanGreaterThanImpl <em>Boolean Greater Than</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.BooleanGreaterThanImpl
		 * @see expression.impl.ExpressionPackageImpl#getBooleanGreaterThan()
		 * @generated
		 */
		EClass BOOLEAN_GREATER_THAN = eINSTANCE.getBooleanGreaterThan();

		/**
		 * The meta object literal for the '{@link expression.impl.BooleanBinaryExpressionImpl <em>Boolean Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.BooleanBinaryExpressionImpl
		 * @see expression.impl.ExpressionPackageImpl#getBooleanBinaryExpression()
		 * @generated
		 */
		EClass BOOLEAN_BINARY_EXPRESSION = eINSTANCE.getBooleanBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Bool Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_BINARY_EXPRESSION__BOOL_EXPRESSION1 = eINSTANCE.getBooleanBinaryExpression_BoolExpression1();

		/**
		 * The meta object literal for the '<em><b>Bool Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_BINARY_EXPRESSION__BOOL_EXPRESSION2 = eINSTANCE.getBooleanBinaryExpression_BoolExpression2();

		/**
		 * The meta object literal for the '{@link expression.impl.BooleanCompareExpressionImpl <em>Boolean Compare Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.BooleanCompareExpressionImpl
		 * @see expression.impl.ExpressionPackageImpl#getBooleanCompareExpression()
		 * @generated
		 */
		EClass BOOLEAN_COMPARE_EXPRESSION = eINSTANCE.getBooleanCompareExpression();

		/**
		 * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_COMPARE_EXPRESSION__EXPRESSION1 = eINSTANCE.getBooleanCompareExpression_Expression1();

		/**
		 * The meta object literal for the '<em><b>Expression2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_COMPARE_EXPRESSION__EXPRESSION2 = eINSTANCE.getBooleanCompareExpression_Expression2();

		/**
		 * The meta object literal for the '{@link expression.impl.IntExpressionImpl <em>Int Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see expression.impl.IntExpressionImpl
		 * @see expression.impl.ExpressionPackageImpl#getIntExpression()
		 * @generated
		 */
		EClass INT_EXPRESSION = eINSTANCE.getIntExpression();

	}

} //ExpressionPackage
