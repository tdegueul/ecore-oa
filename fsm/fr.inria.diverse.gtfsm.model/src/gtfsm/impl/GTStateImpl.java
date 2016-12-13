/**
 */
package gtfsm.impl;

import gfsm.impl.GStateImpl;

import gtfsm.GTState;
import gtfsm.GtfsmPackage;

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
 * An implementation of the model object '<em><b>GT State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gtfsm.impl.GTStateImpl#getStateguard <em>Stateguard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GTStateImpl extends GStateImpl implements GTState {
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
	protected GTStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GtfsmPackage.Literals.GT_STATE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GtfsmPackage.GT_STATE__STATEGUARD, oldStateguard, newStateguard);
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
				msgs = ((InternalEObject)stateguard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GtfsmPackage.GT_STATE__STATEGUARD, null, msgs);
			if (newStateguard != null)
				msgs = ((InternalEObject)newStateguard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GtfsmPackage.GT_STATE__STATEGUARD, null, msgs);
			msgs = basicSetStateguard(newStateguard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GtfsmPackage.GT_STATE__STATEGUARD, newStateguard, newStateguard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GtfsmPackage.GT_STATE__STATEGUARD:
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
			case GtfsmPackage.GT_STATE__STATEGUARD:
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
			case GtfsmPackage.GT_STATE__STATEGUARD:
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
			case GtfsmPackage.GT_STATE__STATEGUARD:
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
			case GtfsmPackage.GT_STATE__STATEGUARD:
				return stateguard != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TimedState.class) {
			switch (derivedFeatureID) {
				case GtfsmPackage.GT_STATE__STATEGUARD: return TfsmPackage.TIMED_STATE__STATEGUARD;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TimedState.class) {
			switch (baseFeatureID) {
				case TfsmPackage.TIMED_STATE__STATEGUARD: return GtfsmPackage.GT_STATE__STATEGUARD;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //GTStateImpl
