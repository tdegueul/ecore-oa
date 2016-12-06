package fr.inria.diverse.tfsm.algebra.abstr

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import org.eclipse.emf.ecore.EObject
import tfsm.AndClockConstraint
import tfsm.BinaryClockConstraint
import tfsm.Clock
import tfsm.ClockConstraint
import tfsm.ClockConstraintOperation
import tfsm.ClockReset
import tfsm.LowerClockConstraint
import tfsm.LowerEqualClockConstraint
import tfsm.OrClockConstraint
import tfsm.TimedFSM
import tfsm.TimedFinalState
import tfsm.TimedInitialState
import tfsm.TimedState
import tfsm.TimedTransition
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint

interface TFSMAlgebra<E, F> extends FSMAlgebra<E> {

	def E timedFSM(TimedFSM timedFSM)

	def E timedInitialState(TimedInitialState timedInitialState)

	def E timedFinalState(TimedFinalState timedFinalState)

	def E timedTransition(TimedTransition timedTransition)

	def E timedState(TimedState timedState)

	def E clock(Clock clock)

	def F clockConstraint(ClockConstraint clockConstraint)

	def E clockReset(ClockReset clockReset)

	def F lowerClockConstraint(LowerClockConstraint clockConstraint)

	def F lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint)

	def F upperClockConstaint(UpperClockConstraint upperClockConstraint)

	def F upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint)

	def F clockConstaintOperation(ClockConstraintOperation clockConstraintOperation)

	def F andClockConstraint(AndClockConstraint andClockConstraint)

	def F orClockConstraint(OrClockConstraint orClockConstraint)

	def F binaryClockConstraint(BinaryClockConstraint binaryClockConstraint)

	override def E expE(EObject eObject) {
		return if (eObject instanceof TimedFSM) {
			timedFSM(eObject)
		} else if (eObject instanceof TimedFinalState) {
			timedFinalState(eObject)
		} else if (eObject instanceof TimedInitialState) {
			timedInitialState(eObject)
		} else if (eObject instanceof TimedState) {
			timedState(eObject)
		} else if (eObject instanceof TimedTransition) {
			timedTransition(eObject)
		} else if (eObject instanceof Clock) {
			clock(eObject)
		} else if (eObject instanceof ClockReset) {
			clockReset(eObject)
		} else {
			FSMAlgebra.super.expE(eObject)
		}

	}

	def F expF(EObject eObject) {
		if (eObject instanceof LowerClockConstraint) {
			lowerClockConstraint(eObject)
		} else if (eObject instanceof LowerEqualClockConstraint) {
			lowerEqualClockConstraint(eObject)
		} else if (eObject instanceof UpperClockConstraint) {
			upperClockConstaint(eObject)
		} else if (eObject instanceof UpperEqualClockConstraint) {
			upperEqualClockConstraint(eObject)
		} else if (eObject instanceof ClockConstraint) {
			clockConstraint(eObject)
		} else if (eObject instanceof AndClockConstraint) {
			andClockConstraint(eObject)
		} else if (eObject instanceof OrClockConstraint) {
			orClockConstraint(eObject)
		} else if (eObject instanceof BinaryClockConstraint) {
			binaryClockConstraint(eObject)
		} else if (eObject instanceof ClockConstraintOperation) {
			clockConstaintOperation(eObject)
		} else {
			throw new RuntimeException('''unkown EObject «eObject»''')
		}
	}

}
