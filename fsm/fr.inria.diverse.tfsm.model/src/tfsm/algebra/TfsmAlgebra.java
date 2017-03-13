package tfsm.algebra;

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
import java.util.Map;

public interface TfsmAlgebra<A, B, C, D, E, F> extends FsmAlgebra<D, E, F> {

	A andClockConstraint(final AndClockConstraint andClockConstraint);

	B clock(final Clock clock);

	C clockReset(final ClockReset clockReset);

	A lowerClockConstraint(final LowerClockConstraint lowerClockConstraint);

	A lowerEqualClockConstraint(final LowerEqualClockConstraint lowerEqualClockConstraint);

	A orClockConstraint(final OrClockConstraint orClockConstraint);

	D timedFSM(final TimedFSM timedFSM);

	E timedFinalState(final TimedFinalState timedFinalState);

	E timedInitialState(final TimedInitialState timedInitialState);

	E timedState(final TimedState timedState);

	F timedTransition(final TimedTransition timedTransition);

	A upperClockConstraint(final UpperClockConstraint upperClockConstraint);

	A upperEqualClockConstraint(final UpperEqualClockConstraint upperEqualClockConstraint);

	
	Map<ClockConstraintOperation, A> getClockConstraintOperationMemo();
	
	public default A $(final ClockConstraintOperation clockConstraintOperation) {
		final A ret;
		Map<ClockConstraintOperation, A> memo = getClockConstraintOperationMemo();
		if(memo.containsKey(clockConstraintOperation)) {
			ret = memo.get(clockConstraintOperation);
		} else {
			if (clockConstraintOperation.eClass().getName().equals("AndClockConstraint")) {
				ret = this.andClockConstraint((AndClockConstraint) clockConstraintOperation);
			} else if (clockConstraintOperation.eClass().getName().equals("LowerClockConstraint")) {
				ret = this.lowerClockConstraint((LowerClockConstraint) clockConstraintOperation);
			} else if (clockConstraintOperation.eClass().getName().equals("LowerEqualClockConstraint")) {
				ret = this.lowerEqualClockConstraint((LowerEqualClockConstraint) clockConstraintOperation);
			} else if (clockConstraintOperation.eClass().getName().equals("OrClockConstraint")) {
				ret = this.orClockConstraint((OrClockConstraint) clockConstraintOperation);
			} else if (clockConstraintOperation.eClass().getName().equals("UpperClockConstraint")) {
				ret = this.upperClockConstraint((UpperClockConstraint) clockConstraintOperation);
			} else if (clockConstraintOperation.eClass().getName().equals("UpperEqualClockConstraint")) {
				ret = this.upperEqualClockConstraint((UpperEqualClockConstraint) clockConstraintOperation);
			} else {
				throw new RuntimeException("Unknow ClockConstraintOperation " + clockConstraintOperation);
		}
			memo.put(clockConstraintOperation, ret);
		}
		return ret;
	}
	
	Map<Clock, B> getClockMemo();
	
	public default B $(final Clock clock) {
		final B ret;
		Map<Clock, B> memo = getClockMemo();
		if(memo.containsKey(clock)) {
			ret = memo.get(clock);
		} else {
			if (clock.eClass().getName().equals("Clock")) {
				ret = this.clock((Clock) clock);
			} else {
				throw new RuntimeException("Unknow Clock " + clock);
		}
			memo.put(clock, ret);
		}
		return ret;
	}
	
	Map<ClockReset, C> getClockResetMemo();
	
	public default C $(final ClockReset clockReset) {
		final C ret;
		Map<ClockReset, C> memo = getClockResetMemo();
		if(memo.containsKey(clockReset)) {
			ret = memo.get(clockReset);
		} else {
			if (clockReset.eClass().getName().equals("ClockReset")) {
				ret = this.clockReset((ClockReset) clockReset);
			} else {
				throw new RuntimeException("Unknow ClockReset " + clockReset);
		}
			memo.put(clockReset, ret);
		}
		return ret;
	}
		@Override
	
	Map<FSM, D> getFSMMemo();
	
	public default D $(final FSM fSM) {
		final D ret;
		Map<FSM, D> memo = getFSMMemo();
		if(memo.containsKey(fSM)) {
			ret = memo.get(fSM);
		} else {
			if (fSM.eClass().getName().equals("TimedFSM")) {
				ret = this.timedFSM((TimedFSM) fSM);
			} else {
			ret = FsmAlgebra.super.$(fSM);
		}
			memo.put(fSM, ret);
		}
		return ret;
	}
		@Override
	
	Map<State, E> getStateMemo();
	
	public default E $(final State state) {
		final E ret;
		Map<State, E> memo = getStateMemo();
		if(memo.containsKey(state)) {
			ret = memo.get(state);
		} else {
			if (state.eClass().getName().equals("TimedFinalState")) {
				ret = this.timedFinalState((TimedFinalState) state);
			} else if (state.eClass().getName().equals("TimedInitialState")) {
				ret = this.timedInitialState((TimedInitialState) state);
			} else if (state.eClass().getName().equals("TimedState")) {
				ret = this.timedState((TimedState) state);
			} else {
			ret = FsmAlgebra.super.$(state);
		}
			memo.put(state, ret);
		}
		return ret;
	}
		@Override
	
	Map<Transition, F> getTransitionMemo();
	
	public default F $(final Transition transition) {
		final F ret;
		Map<Transition, F> memo = getTransitionMemo();
		if(memo.containsKey(transition)) {
			ret = memo.get(transition);
		} else {
			if (transition.eClass().getName().equals("TimedTransition")) {
				ret = this.timedTransition((TimedTransition) transition);
			} else {
			ret = FsmAlgebra.super.$(transition);
		}
			memo.put(transition, ret);
		}
		return ret;
	}
}