package fr.inria.diverse.tfsm.algebra.abstr;

import fsm.FSM;
import fsm.State;
import fsm.Transition;
import fsm.algebra.FsmAlgebra;
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

public interface TfsmAlgebra<A, B, C, D, E, F> extends FsmAlgebra<A, B, C> {

	E andClockConstraint(final AndClockConstraint andClockConstraint);

	D clock(final Clock clock);

	F clockReset(final ClockReset clockReset);

	E lowerClockConstraint(final LowerClockConstraint lowerClockConstraint);

	E lowerEqualClockConstraint(final LowerEqualClockConstraint lowerEqualClockConstraint);

	E orClockConstraint(final OrClockConstraint orClockConstraint);

	A timedFSM(final TimedFSM timedFSM);

	B timedFinalState(final TimedFinalState timedFinalState);

	B timedInitialState(final TimedInitialState timedInitialState);

	B timedState(final TimedState timedState);

	C timedTransition(final TimedTransition timedTransition);

	E upperClockConstraint(final UpperClockConstraint upperClockConstraint);

	E upperEqualClockConstraint(final UpperEqualClockConstraint upperEqualClockConstraint);

	@Override
	public default A $(final FSM fSM) {
		final A ret;
		if (fSM instanceof TimedFSM) {
			ret = this.timedFSM((TimedFSM) fSM);
		} else {
			ret = FsmAlgebra.super.$(fSM);
		}
		return ret;
		
	}

	@Override
	public default B $(final State state) {
		final B ret;
		if (state instanceof TimedFinalState) {
			ret = this.timedFinalState((TimedFinalState) state);
		} else if (state instanceof TimedInitialState) {
			ret = this.timedInitialState((TimedInitialState) state);
		} else if (state instanceof TimedState) {
			ret = this.timedState((TimedState) state);
		} else {
			ret = FsmAlgebra.super.$(state);
		}
		return ret;
	}
	
	@Override
	public default C $(final Transition transition) {
		final C ret;
		if (transition instanceof TimedTransition) {
			ret = this.timedTransition((TimedTransition) transition);
		} else {
			ret = FsmAlgebra.super.$(transition);
		}
		return ret;
	}
	
	public default D $(final Clock clock) {
		final D ret;
		if (clock instanceof Clock) {
			ret = this.clock((Clock) clock);
		} else {
			throw new RuntimeException("Unknow Clock " + clock);
		}
		return ret;
	}

	public default E $(final ClockConstraintOperation clockConstraintOperation) {
		final E ret;
		if (clockConstraintOperation instanceof LowerClockConstraint) {
			ret = this.lowerClockConstraint((LowerClockConstraint) clockConstraintOperation);
		} else if (clockConstraintOperation instanceof LowerEqualClockConstraint) {
			ret = this.lowerEqualClockConstraint((LowerEqualClockConstraint) clockConstraintOperation);
		} else if (clockConstraintOperation instanceof UpperClockConstraint) {
			ret = this.upperClockConstraint((UpperClockConstraint) clockConstraintOperation);
		} else if (clockConstraintOperation instanceof UpperEqualClockConstraint) {
			ret = this.upperEqualClockConstraint((UpperEqualClockConstraint) clockConstraintOperation);
		} else if (clockConstraintOperation instanceof AndClockConstraint) {
			ret = this.andClockConstraint((AndClockConstraint) clockConstraintOperation);
		} else if (clockConstraintOperation instanceof OrClockConstraint) {
			ret = this.orClockConstraint((OrClockConstraint) clockConstraintOperation);
		} else {
			throw new RuntimeException("Unknow ClockConstraintOperation " + clockConstraintOperation);
		}
		return ret;
	}

	public default F $(final ClockReset clockReset) {
		final F ret;
		if (clockReset instanceof ClockReset) {
			ret = this.clockReset((ClockReset) clockReset);
		} else {
			throw new RuntimeException("Unknow ClockReset " + clockReset);
		}
		return ret;
	}
}
