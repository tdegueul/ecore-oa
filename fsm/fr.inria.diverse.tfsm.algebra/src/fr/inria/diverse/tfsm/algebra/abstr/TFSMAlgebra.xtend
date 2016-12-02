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

interface TFSMAlgebra<E> extends FSMAlgebra<E> {

	def E timedFSM(TimedFSM timedFSM)

	def E timedInitialState(TimedInitialState timedInitialState)

	def E timedFinalState(TimedFinalState timedFinalState)

	def E timedTransition(TimedTransition timedTransition)

	def E timedState(TimedState timedState)

	def E clock(Clock clock)

	def E clockConstraint(ClockConstraint clockConstraint)

	def E clockReset(ClockReset clockReset)

	def E lowerClockConstraint(ClockConstraint clockConstraint)

	def E lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint)

	def E upperClockConstaint(UpperClockConstraint upperClockConstraint)

	def E upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint)

	def E clockConstaintOperation(ClockConstraintOperation clockConstraintOperation)

	def E andClockConstraint(AndClockConstraint andClockConstraint)

	def E orClockConstraint(OrClockConstraint orClockConstraint)

	def E binaryClockConstraint(BinaryClockConstraint binaryClockConstraint)

	override def E exp(EObject eObject) {
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
		} else if (eObject instanceof LowerClockConstraint) {
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
		} else if (eObject instanceof ClockReset) {
			clockReset(eObject)
		} else {
			FSMAlgebra.super.exp(eObject)
		}

	}

}
