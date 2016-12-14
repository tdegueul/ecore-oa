package fr.inria.diverse.tfsm.algebra.abstr

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fsm.FSM
import fsm.State
import fsm.Transition
import tfsm.AndClockConstraint
import tfsm.Clock
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

interface TFSMAlgebra<T, S, F, C, CCO, CR> extends FSMAlgebra<T, S, F> {

	def F timedFSM(TimedFSM timedFSM)

	def S timedInitialState(TimedInitialState timedInitialState)

	def S timedFinalState(TimedFinalState timedFinalState)

	def T timedTransition(TimedTransition timedTransition)

	def S timedState(TimedState timedState)

	def C clock(Clock clock)

	def CR clockReset(ClockReset clockReset)

	def CCO lowerClockConstraint(LowerClockConstraint clockConstraint)

	def CCO lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint)

	def CCO upperClockConstraint(UpperClockConstraint upperClockConstraint)

	def CCO upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint)

	def CCO andClockConstraint(AndClockConstraint andClockConstraint)

	def CCO orClockConstraint(OrClockConstraint orClockConstraint)

	override def T $(Transition transition) {
		return if (transition instanceof TimedTransition) {
			timedTransition(transition)
		} else {
			FSMAlgebra.super.$(transition)
		}

	}

	override def S $(State state) {
		return if (state instanceof TimedFinalState) {
			timedFinalState(state)
		} else if (state instanceof TimedInitialState) {
			timedInitialState(state)
		} else if (state instanceof TimedState) {
			timedState(state)
		} else {
			FSMAlgebra.super.$(state)
		}

	}

	override def F $(FSM fsm) {
		return if (fsm instanceof TimedFSM) {
			timedFSM(fsm)
		} else {
			FSMAlgebra.super.$(fsm)
		}

	}

	def C $(Clock clock) {
		return if (clock instanceof Clock) {
			clock(clock)
		} else {
			throw new RuntimeException('''unkown Clock «clock»''')
		}

	}

	def CR $(ClockReset clockReset) {
		return if (clockReset instanceof ClockReset) {
			clockReset(clockReset)
		} else {
			throw new RuntimeException('''unkown ClockReset «clockReset»''')
		}

	}

	def CCO $(ClockConstraintOperation clockConstraint) {
		if (clockConstraint instanceof LowerClockConstraint) {
			lowerClockConstraint(clockConstraint)
		} else if (clockConstraint instanceof LowerEqualClockConstraint) {
			lowerEqualClockConstraint(clockConstraint)
		} else if (clockConstraint instanceof UpperClockConstraint) {
			upperClockConstraint(clockConstraint)
		} else if (clockConstraint instanceof UpperEqualClockConstraint) {
			upperEqualClockConstraint(clockConstraint)
		} else if (clockConstraint instanceof AndClockConstraint) {
			andClockConstraint(clockConstraint)
		} else if (clockConstraint instanceof OrClockConstraint) {
			orClockConstraint(clockConstraint)
		} else {
			throw new RuntimeException('''unkown ClockConstraint «clockConstraint»''')
		}
	}

}
