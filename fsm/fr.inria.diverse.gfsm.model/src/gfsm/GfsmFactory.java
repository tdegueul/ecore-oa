/**
 */
package gfsm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gfsm.GfsmPackage
 * @generated
 */
public interface GfsmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GfsmFactory eINSTANCE = gfsm.impl.GfsmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>GTransition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GTransition</em>'.
	 * @generated
	 */
	GTransition createGTransition();

	/**
	 * Returns a new object of class '<em>GState</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GState</em>'.
	 * @generated
	 */
	GState createGState();

	/**
	 * Returns a new object of class '<em>GFinal State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GFinal State</em>'.
	 * @generated
	 */
	GFinalState createGFinalState();

	/**
	 * Returns a new object of class '<em>GInitial State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GInitial State</em>'.
	 * @generated
	 */
	GInitialState createGInitialState();

	/**
	 * Returns a new object of class '<em>GFSM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GFSM</em>'.
	 * @generated
	 */
	GFSM createGFSM();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GfsmPackage getGfsmPackage();

} //GfsmFactory
