package fr.inria.diverse.fsm.algebra.abstr;

import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;

public interface FSMAlgebraDispatcherDefault<T, F, S> extends FSMAlgebra<T, F, S> {

	@Override
	default T $(final Transition transition) {
		final T ret;
		if (transition instanceof Transition) {
			ret = transition(transition);
		} else {
			throw new RuntimeException("unknow Transition " + transition);
		}
		return ret;
	}

	@Override
	default S $(final State state) {
		final S ret;
		if (state instanceof InitialState) {
			ret = initialState((InitialState) state);
		} else if (state instanceof FinalState) {
			ret = finalState((FinalState) state);
		} else if (state instanceof State) {
			ret = state(state);
		} else {
			throw new RuntimeException("unknow State " + state);
		}
		return ret;
	}

	@Override
	default F $(final FSM fsm) {
		final F ret;
		if (fsm instanceof FSM) {
			ret = fsm(fsm);
		} else {
			throw new RuntimeException("unknow FSM " + fsm);
		}
		return ret;
	}

}
