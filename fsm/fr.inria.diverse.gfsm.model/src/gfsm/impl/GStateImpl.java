/**
 */
package gfsm.impl;

import expression.IntOperation;

import fsm.impl.StateImpl;

import gfsm.GState;
import gfsm.GfsmPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GState</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gfsm.impl.GStateImpl#getInExpression <em>In Expression</em>}</li>
 *   <li>{@link gfsm.impl.GStateImpl#getOutExpression <em>Out Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GStateImpl extends StateImpl implements GState {
	/**
	 * The cached value of the '{@link #getInExpression() <em>In Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInExpression()
	 * @generated
	 * @ordered
	 */
	protected IntOperation inExpression;

	/**
	 * The cached value of the '{@link #getOutExpression() <em>Out Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutExpression()
	 * @generated
	 * @ordered
	 */
	protected IntOperation outExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GfsmPackage.Literals.GSTATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntOperation getInExpression() {
		return inExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInExpression(IntOperation newInExpression, NotificationChain msgs) {
		IntOperation oldInExpression = inExpression;
		inExpression = newInExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GfsmPackage.GSTATE__IN_EXPRESSION, oldInExpression, newInExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInExpression(IntOperation newInExpression) {
		if (newInExpression != inExpression) {
			NotificationChain msgs = null;
			if (inExpression != null)
				msgs = ((InternalEObject)inExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GfsmPackage.GSTATE__IN_EXPRESSION, null, msgs);
			if (newInExpression != null)
				msgs = ((InternalEObject)newInExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GfsmPackage.GSTATE__IN_EXPRESSION, null, msgs);
			msgs = basicSetInExpression(newInExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GfsmPackage.GSTATE__IN_EXPRESSION, newInExpression, newInExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntOperation getOutExpression() {
		return outExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutExpression(IntOperation newOutExpression, NotificationChain msgs) {
		IntOperation oldOutExpression = outExpression;
		outExpression = newOutExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GfsmPackage.GSTATE__OUT_EXPRESSION, oldOutExpression, newOutExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutExpression(IntOperation newOutExpression) {
		if (newOutExpression != outExpression) {
			NotificationChain msgs = null;
			if (outExpression != null)
				msgs = ((InternalEObject)outExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GfsmPackage.GSTATE__OUT_EXPRESSION, null, msgs);
			if (newOutExpression != null)
				msgs = ((InternalEObject)newOutExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GfsmPackage.GSTATE__OUT_EXPRESSION, null, msgs);
			msgs = basicSetOutExpression(newOutExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GfsmPackage.GSTATE__OUT_EXPRESSION, newOutExpression, newOutExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GfsmPackage.GSTATE__IN_EXPRESSION:
				return basicSetInExpression(null, msgs);
			case GfsmPackage.GSTATE__OUT_EXPRESSION:
				return basicSetOutExpression(null, msgs);
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
			case GfsmPackage.GSTATE__IN_EXPRESSION:
				return getInExpression();
			case GfsmPackage.GSTATE__OUT_EXPRESSION:
				return getOutExpression();
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
			case GfsmPackage.GSTATE__IN_EXPRESSION:
				setInExpression((IntOperation)newValue);
				return;
			case GfsmPackage.GSTATE__OUT_EXPRESSION:
				setOutExpression((IntOperation)newValue);
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
			case GfsmPackage.GSTATE__IN_EXPRESSION:
				setInExpression((IntOperation)null);
				return;
			case GfsmPackage.GSTATE__OUT_EXPRESSION:
				setOutExpression((IntOperation)null);
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
			case GfsmPackage.GSTATE__IN_EXPRESSION:
				return inExpression != null;
			case GfsmPackage.GSTATE__OUT_EXPRESSION:
				return outExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //GStateImpl
