/**
 */
package tfsm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clock</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm.Clock#getName <em>Name</em>}</li>
 *   <li>{@link tfsm.Clock#getTick <em>Tick</em>}</li>
 * </ul>
 *
 * @see tfsm.TfsmPackage#getClock()
 * @model
 * @generated
 */
public interface Clock extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see tfsm.TfsmPackage#getClock_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link tfsm.Clock#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Tick</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tick</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tick</em>' attribute.
	 * @see #setTick(int)
	 * @see tfsm.TfsmPackage#getClock_Tick()
	 * @model default="0"
	 * @generated
	 */
	int getTick();

	/**
	 * Sets the value of the '{@link tfsm.Clock#getTick <em>Tick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tick</em>' attribute.
	 * @see #getTick()
	 * @generated
	 */
	void setTick(int value);

} // Clock
