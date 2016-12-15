package fr.inria.diverse.fsm.algebra.abstr;

import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;

public interface FSMAlgebra<T, F, S> extends FSMAlgebraDispatcher<T, F, S> {
	T transition(Transition transition);

	S state(State state);

	S finalState(FinalState finalState);

	S initialState(InitialState initialState);

	F fsm(FSM fsm);

}
