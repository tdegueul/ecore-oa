package fr.inria.diverse.tfsm.algebra.abstr;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebraDispatcherDefault;
import fsm.*;
import fsm.State;
import fsm.Transition;
import tfsm.*;

public interface TFSMAlgebraDispatchDefault<T, F, S, C, CCO, CR>
		extends TFSMAlgebra<T, F, S, C, CCO, CR>, FSMAlgebraDispatcherDefault<T, F, S> {

	@Override
	default T $(final Transition transition) {
		final T ret;
		if (transition instanceof TimedTransition) {
			ret = this.timedTransition((TimedTransition) transition);
		} else {
			ret = FSMAlgebraDispatcherDefault.super.$(transition);
		}
		return ret;
	}

	@Override
	default S $(final State state) {
		final S ret;
		if (state instanceof TimedFinalState) {
			ret = this.timedFinalState((TimedFinalState) state);
		} else if (state instanceof TimedInitialState) {
			ret = this.timedInitialState((TimedInitialState) state);
		} else if (state instanceof TimedState) {
			ret = this.timedState((TimedState) state);
		} else {
			ret = FSMAlgebraDispatcherDefault.super.$(state);
		}
		return ret;
	}

	@Override
	default F $(final FSM fsm) {
		final F ret;
		if (fsm instanceof TimedFSM) {
			ret = this.timedFSM((TimedFSM) fsm);
		} else {
			ret = FSMAlgebraDispatcherDefault.super.$(fsm);
		}
		return ret;

	}

	@Override
	default C $(final Clock clock) {
		final C ret;
		if (clock instanceof Clock) {
			ret = this.clock(clock);
		} else {
			throw new RuntimeException("unkown Clock " + clock);
		}
		return ret;
	}

	@Override
	default CR $(final ClockReset clockReset) {
		final CR ret;
		if (clockReset instanceof ClockReset) {
			ret = this.clockReset(clockReset);
		} else {
			throw new RuntimeException("unkown ClockReset " + clockReset);
		}
		return ret;
	}

	@Override
	default CCO $(final ClockConstraintOperation clockConstraint) {
		final CCO ret;

		if (clockConstraint instanceof LowerClockConstraint) {
			ret = this.lowerClockConstraint((LowerClockConstraint) clockConstraint);
		} else if (clockConstraint instanceof LowerEqualClockConstraint) {
			ret = this.lowerEqualClockConstraint((LowerEqualClockConstraint) clockConstraint);
		} else if (clockConstraint instanceof UpperClockConstraint) {
			ret = this.upperClockConstraint((UpperClockConstraint) clockConstraint);
		} else if (clockConstraint instanceof UpperEqualClockConstraint) {
			ret = this.upperEqualClockConstraint((UpperEqualClockConstraint) clockConstraint);
		} else if (clockConstraint instanceof AndClockConstraint) {
			ret = this.andClockConstraint((AndClockConstraint) clockConstraint);
		} else if (clockConstraint instanceof OrClockConstraint) {
			ret = this.orClockConstraint((OrClockConstraint) clockConstraint);
		} else {
			throw new RuntimeException("unkown ClockConstraint " + clockConstraint);
		}
		return ret;
	}

}
