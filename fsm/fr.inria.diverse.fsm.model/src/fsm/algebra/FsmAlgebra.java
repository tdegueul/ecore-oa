package fsm.algebra;

import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import java.util.Map;

public interface FsmAlgebra<A, B, C> {

	A fSM(final FSM fSM);

	B finalState(final FinalState finalState);

	B initialState(final InitialState initialState);

	B state(final State state);

	C transition(final Transition transition);

	
	Map<FSM, A> getFSMMemo();
	
	public default A $(final FSM fSM) {
		final A ret;
		Map<FSM, A> memo = getFSMMemo();
		if(memo.containsKey(fSM)) {
			ret = memo.get(fSM);
		} else {
			if (fSM.eClass().getName().equals("FSM")) {
				ret = this.fSM((FSM) fSM);
			} else {
				throw new RuntimeException("Unknow FSM " + fSM);
		}
			memo.put(fSM, ret);
		}
		return ret;
	}
	
	Map<State, B> getStateMemo();
	
	public default B $(final State state) {
		final B ret;
		Map<State, B> memo = getStateMemo();
		if(memo.containsKey(state)) {
			ret = memo.get(state);
		} else {
			if (state.eClass().getName().equals("FinalState")) {
				ret = this.finalState((FinalState) state);
			} else if (state.eClass().getName().equals("InitialState")) {
				ret = this.initialState((InitialState) state);
			} else if (state.eClass().getName().equals("State")) {
				ret = this.state((State) state);
			} else {
				throw new RuntimeException("Unknow State " + state);
		}
			memo.put(state, ret);
		}
		return ret;
	}
	
	Map<Transition, C> getTransitionMemo();
	
	public default C $(final Transition transition) {
		final C ret;
		Map<Transition, C> memo = getTransitionMemo();
		if(memo.containsKey(transition)) {
			ret = memo.get(transition);
		} else {
			if (transition.eClass().getName().equals("Transition")) {
				ret = this.transition((Transition) transition);
			} else {
				throw new RuntimeException("Unknow Transition " + transition);
		}
			memo.put(transition, ret);
		}
		return ret;
	}
}