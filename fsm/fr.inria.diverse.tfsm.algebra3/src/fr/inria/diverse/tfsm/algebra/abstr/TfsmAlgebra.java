package fr.inria.diverse.tfsm.algebra.abstr;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fsm.FSM;
import fsm.State;
import fsm.Transition;
import tfsm.AndClockConstraint;
import tfsm.Clock;
import tfsm.ClockConstraintOperation;
import tfsm.ClockReset;
import tfsm.LowerClockConstraint;
import tfsm.LowerEqualClockConstraint;
import tfsm.OrClockConstraint;
import tfsm.TimedFSM;
import tfsm.TimedFinalState;
import tfsm.TimedInitialState;
import tfsm.TimedState;
import tfsm.TimedTransition;
import tfsm.UpperClockConstraint;
import tfsm.UpperEqualClockConstraint;

public interface TFSMAlgebra<T, F, S, C, CCO, CR> extends FSMAlgebra<T, F, S> {
	F timedFSM(TimedFSM timedFSM);

	S timedInitialState(TimedInitialState timedInitialState);

	S timedFinalState(TimedFinalState timedFinalState);

	T timedTransition(TimedTransition timedTransition);

	S timedState(TimedState timedState);

	C clock(Clock clock);

	CR clockReset(ClockReset clockReset);

	CCO lowerClockConstraint(LowerClockConstraint clockConstraint);

	CCO lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint);

	CCO upperClockConstraint(UpperClockConstraint upperClockConstraint);

	CCO upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint);

	CCO andClockConstraint(AndClockConstraint andClockConstraint);

	CCO orClockConstraint(OrClockConstraint orClockConstraint);

	@Override
	default T $(final Transition transition) {
		final T ret;
		if (transition instanceof TimedTransition) {
			ret = this.timedTransition((TimedTransition) transition);
		} else {
			ret = FSMAlgebra.super.$(transition);
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
			ret = FSMAlgebra.super.$(state);
		}
		return ret;
	}

	@Override
	default F $(final FSM fsm) {
		final F ret;
		if (fsm instanceof TimedFSM) {
			ret = this.timedFSM((TimedFSM) fsm);
		} else {
			ret = FSMAlgebra.super.$(fsm);
		}
		return ret;

	}

	default C $(final Clock clock) {
		final C ret;
		if (clock instanceof Clock) {
			ret = this.clock(clock);
		} else {
			throw new RuntimeException("unkown Clock " + clock);
		}
		return ret;
	}

	default CR $(final ClockReset clockReset) {
		final CR ret;
		if (clockReset instanceof ClockReset) {
			ret = this.clockReset(clockReset);
		} else {
			throw new RuntimeException("unkown ClockReset " + clockReset);
		}
		return ret;
	}

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
