/**
 */
package gtfsm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gtfsm.GtfsmPackage
 * @generated
 */
public interface GtfsmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GtfsmFactory eINSTANCE = gtfsm.impl.GtfsmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>GTFSM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GTFSM</em>'.
	 * @generated
	 */
	GTFSM createGTFSM();

	/**
	 * Returns a new object of class '<em>GT State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GT State</em>'.
	 * @generated
	 */
	GTState createGTState();

	/**
	 * Returns a new object of class '<em>GT Initial State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GT Initial State</em>'.
	 * @generated
	 */
	GTInitialState createGTInitialState();

	/**
	 * Returns a new object of class '<em>GT Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GT Final State</em>'.
	 * @generated
	 */
	GTFinalState createGTFinalState();

	/**
	 * Returns a new object of class '<em>GT Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GT Transition</em>'.
	 * @generated
	 */
	GTTransition createGTTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GtfsmPackage getGtfsmPackage();

} //GtfsmFactory
