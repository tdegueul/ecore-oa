package fr.inria.diverse.tfsm.algebra.abstr

import org.eclipse.emf.ecore.EObject
import tfsm.AndClockConstraint
import tfsm.BinaryClockConstraint
import tfsm.Clock
import tfsm.ClockConstraint
import tfsm.ClockConstraintOperation
import tfsm.ClockReset
import tfsm.FSM
import tfsm.LowerEqualClockConstraint
import tfsm.OrClockConstraint
import tfsm.State
import tfsm.Transition
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint
import tfsm.LowerClockConstraint
import tfsm.FinalState
import tfsm.InitialState

interface TFSMAlgebra<E> {

	def E fsm(FSM fsm)

	def E state(State state)

	def E transition(Transition transition)

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

	def E finalState(FinalState finalState)

	def E initialState(InitialState initialState)

	def E exp(EObject eObject) {
		return if (eObject instanceof FSM) {
			fsm(eObject)
		} else if (eObject instanceof FinalState) {
			finalState(eObject)
		} else if (eObject instanceof InitialState) {
			initialState(eObject)
		} else if (eObject instanceof State) {
			state(eObject)
		} else if (eObject instanceof Transition) {
			transition(eObject)
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
			throw new RuntimeException('''unkown EObject «eObject»''')
		}

	}

}
