package fr.inria.diverse.fsm.algebra.abstr;

import fsm.FSM;
import fsm.State;
import fsm.Transition;

public interface FSMAlgebraDispatcher<T, F, S> {

	T $(Transition transition);

	S $(State state);

	F $(FSM fsm);
}
