/**
 */
package fsm.impl;

import fsm.FSM;
import fsm.FsmPackage;
import fsm.State;
import fsm.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fsm.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link fsm.impl.StateImpl#getFsm <em>Fsm</em>}</li>
 *   <li>{@link fsm.impl.StateImpl#getOutgoingtransitions <em>Outgoingtransitions</em>}</li>
 *   <li>{@link fsm.impl.StateImpl#getIncommingtransitions <em>Incommingtransitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateImpl extends MinimalEObjectImpl.Container implements State {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoingtransitions() <em>Outgoingtransitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingtransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoingtransitions;

	/**
	 * The cached value of the '{@link #getIncommingtransitions() <em>Incommingtransitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncommingtransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> incommingtransitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSM getFsm() {
		if (eContainerFeatureID() != FsmPackage.STATE__FSM) return null;
		return (FSM)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFsm(FSM newFsm, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFsm, FsmPackage.STATE__FSM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFsm(FSM newFsm) {
		if (newFsm != eInternalContainer() || (eContainerFeatureID() != FsmPackage.STATE__FSM && newFsm != null)) {
			if (EcoreUtil.isAncestor(this, newFsm))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFsm != null)
				msgs = ((InternalEObject)newFsm).eInverseAdd(this, FsmPackage.FSM__STATES, FSM.class, msgs);
			msgs = basicSetFsm(newFsm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.STATE__FSM, newFsm, newFsm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutgoingtransitions() {
		if (outgoingtransitions == null) {
			outgoingtransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FsmPackage.STATE__OUTGOINGTRANSITIONS, FsmPackage.TRANSITION__FROM);
		}
		return outgoingtransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getIncommingtransitions() {
		if (incommingtransitions == null) {
			incommingtransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FsmPackage.STATE__INCOMMINGTRANSITIONS, FsmPackage.TRANSITION__TO);
		}
		return incommingtransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.STATE__FSM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFsm((FSM)otherEnd, msgs);
			case FsmPackage.STATE__OUTGOINGTRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingtransitions()).basicAdd(otherEnd, msgs);
			case FsmPackage.STATE__INCOMMINGTRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncommingtransitions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.STATE__FSM:
				return basicSetFsm(null, msgs);
			case FsmPackage.STATE__OUTGOINGTRANSITIONS:
				return ((InternalEList<?>)getOutgoingtransitions()).basicRemove(otherEnd, msgs);
			case FsmPackage.STATE__INCOMMINGTRANSITIONS:
				return ((InternalEList<?>)getIncommingtransitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FsmPackage.STATE__FSM:
				return eInternalContainer().eInverseRemove(this, FsmPackage.FSM__STATES, FSM.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FsmPackage.STATE__NAME:
				return getName();
			case FsmPackage.STATE__FSM:
				return getFsm();
			case FsmPackage.STATE__OUTGOINGTRANSITIONS:
				return getOutgoingtransitions();
			case FsmPackage.STATE__INCOMMINGTRANSITIONS:
				return getIncommingtransitions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FsmPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case FsmPackage.STATE__FSM:
				setFsm((FSM)newValue);
				return;
			case FsmPackage.STATE__OUTGOINGTRANSITIONS:
				getOutgoingtransitions().clear();
				getOutgoingtransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case FsmPackage.STATE__INCOMMINGTRANSITIONS:
				getIncommingtransitions().clear();
				getIncommingtransitions().addAll((Collection<? extends Transition>)newValue);
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
			case FsmPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FsmPackage.STATE__FSM:
				setFsm((FSM)null);
				return;
			case FsmPackage.STATE__OUTGOINGTRANSITIONS:
				getOutgoingtransitions().clear();
				return;
			case FsmPackage.STATE__INCOMMINGTRANSITIONS:
				getIncommingtransitions().clear();
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
			case FsmPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FsmPackage.STATE__FSM:
				return getFsm() != null;
			case FsmPackage.STATE__OUTGOINGTRANSITIONS:
				return outgoingtransitions != null && !outgoingtransitions.isEmpty();
			case FsmPackage.STATE__INCOMMINGTRANSITIONS:
				return incommingtransitions != null && !incommingtransitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //StateImpl
