/**
 */
package tfsm.impl;

import fsm.impl.StateImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tfsm.ClockConstraintOperation;
import tfsm.TfsmPackage;
import tfsm.TimedState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsm.impl.TimedStateImpl#getStateguard <em>Stateguard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimedStateImpl extends StateImpl implements TimedState {
	/**
	 * The cached value of the '{@link #getStateguard() <em>Stateguard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateguard()
	 * @generated
	 * @ordered
	 */
	protected ClockConstraintOperation stateguard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimedStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmPackage.Literals.TIMED_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClockConstraintOperation getStateguard() {
		return stateguard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateguard(ClockConstraintOperation newStateguard, NotificationChain msgs) {
		ClockConstraintOperation oldStateguard = stateguard;
		stateguard = newStateguard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TfsmPackage.TIMED_STATE__STATEGUARD, oldStateguard, newStateguard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateguard(ClockConstraintOperation newStateguard) {
		if (newStateguard != stateguard) {
			NotificationChain msgs = null;
			if (stateguard != null)
				msgs = ((InternalEObject)stateguard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TfsmPackage.TIMED_STATE__STATEGUARD, null, msgs);
			if (newStateguard != null)
				msgs = ((InternalEObject)newStateguard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TfsmPackage.TIMED_STATE__STATEGUARD, null, msgs);
			msgs = basicSetStateguard(newStateguard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmPackage.TIMED_STATE__STATEGUARD, newStateguard, newStateguard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TfsmPackage.TIMED_STATE__STATEGUARD:
				return basicSetStateguard(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TfsmPackage.TIMED_STATE__STATEGUARD:
				return getStateguard();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TfsmPackage.TIMED_STATE__STATEGUARD:
				setStateguard((ClockConstraintOperation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TfsmPackage.TIMED_STATE__STATEGUARD:
				setStateguard((ClockConstraintOperation)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TfsmPackage.TIMED_STATE__STATEGUARD:
				return stateguard != null;
		}
		return super.eIsSet(featureID);
	}

} //TimedStateImpl
