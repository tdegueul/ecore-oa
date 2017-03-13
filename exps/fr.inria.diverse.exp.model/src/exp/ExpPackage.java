/**
 */
package exp;

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
 * @see exp.ExpFactory
 * @model kind="package"
 * @generated
 */
public interface ExpPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "exp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://exp/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "exp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpPackage eINSTANCE = exp.impl.ExpPackageImpl.init();

	/**
	 * The meta object id for the '{@link exp.impl.ExpImpl <em>Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see exp.impl.ExpImpl
	 * @see exp.impl.ExpPackageImpl#getExp()
	 * @generated
	 */
	int EXP = 0;

	/**
	 * The number of structural features of the '<em>Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link exp.impl.LitImpl <em>Lit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see exp.impl.LitImpl
	 * @see exp.impl.ExpPackageImpl#getLit()
	 * @generated
	 */
	int LIT = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIT__VALUE = EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIT_FEATURE_COUNT = EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Lit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIT_OPERATION_COUNT = EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link exp.impl.AddImpl <em>Add</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see exp.impl.AddImpl
	 * @see exp.impl.ExpPackageImpl#getAdd()
	 * @generated
	 */
	int ADD = 2;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__LHS = EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD__RHS = EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_COUNT = EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OPERATION_COUNT = EXP_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link exp.Exp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp</em>'.
	 * @see exp.Exp
	 * @generated
	 */
	EClass getExp();

	/**
	 * Returns the meta object for class '{@link exp.Lit <em>Lit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lit</em>'.
	 * @see exp.Lit
	 * @generated
	 */
	EClass getLit();

	/**
	 * Returns the meta object for the attribute '{@link exp.Lit#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see exp.Lit#getValue()
	 * @see #getLit()
	 * @generated
	 */
	EAttribute getLit_Value();

	/**
	 * Returns the meta object for class '{@link exp.Add <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add</em>'.
	 * @see exp.Add
	 * @generated
	 */
	EClass getAdd();

	/**
	 * Returns the meta object for the reference '{@link exp.Add#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lhs</em>'.
	 * @see exp.Add#getLhs()
	 * @see #getAdd()
	 * @generated
	 */
	EReference getAdd_Lhs();

	/**
	 * Returns the meta object for the reference '{@link exp.Add#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rhs</em>'.
	 * @see exp.Add#getRhs()
	 * @see #getAdd()
	 * @generated
	 */
	EReference getAdd_Rhs();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpFactory getExpFactory();

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
		 * The meta object literal for the '{@link exp.impl.ExpImpl <em>Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see exp.impl.ExpImpl
		 * @see exp.impl.ExpPackageImpl#getExp()
		 * @generated
		 */
		EClass EXP = eINSTANCE.getExp();

		/**
		 * The meta object literal for the '{@link exp.impl.LitImpl <em>Lit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see exp.impl.LitImpl
		 * @see exp.impl.ExpPackageImpl#getLit()
		 * @generated
		 */
		EClass LIT = eINSTANCE.getLit();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIT__VALUE = eINSTANCE.getLit_Value();

		/**
		 * The meta object literal for the '{@link exp.impl.AddImpl <em>Add</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see exp.impl.AddImpl
		 * @see exp.impl.ExpPackageImpl#getAdd()
		 * @generated
		 */
		EClass ADD = eINSTANCE.getAdd();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD__LHS = eINSTANCE.getAdd_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD__RHS = eINSTANCE.getAdd_Rhs();

	}

} //ExpPackage
