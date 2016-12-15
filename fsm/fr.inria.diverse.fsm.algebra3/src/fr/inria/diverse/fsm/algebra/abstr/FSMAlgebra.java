package fr.inria.diverse.fsm.algebra.abstr;

import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;

public interface FSMAlgebra<T, F, S> {
	T transition(Transition transition);

	S state(State state);

	S finalState(FinalState finalState);

	S initialState(InitialState initialState);

	F fsm(FSM fsm);

	default T $(final Transition transition) {
		final T ret;
		if (transition instanceof Transition) {
			ret = transition(transition);
		} else {
			throw new RuntimeException("unknow Transition " + transition);
		}
		return ret;
	}

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
