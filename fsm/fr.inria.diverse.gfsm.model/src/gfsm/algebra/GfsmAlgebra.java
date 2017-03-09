package gfsm.algebra;

import expression.algebra.ExpressionAlgebra;
import fsm.FSM;
import fsm.State;
import fsm.Transition;
import fsm.algebra.FsmAlgebra;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;
import java.util.Map;

public interface GfsmAlgebra<A, B, C, D, E, F> extends ExpressionAlgebra<A, B, F>, FsmAlgebra<C, D, E> {

	C gFSM(final GFSM gFSM);

	D gFinalState(final GFinalState gFinalState);

	D gInitialState(final GInitialState gInitialState);

	D gState(final GState gState);

	E gTransition(final GTransition gTransition);

	@Override
	
	Map<FSM, C> getFSMMemo();
	
	public default C $(final FSM fSM) {
		final C ret;
		Map<FSM, C> memo = getFSMMemo();
		if(memo.containsKey(fSM)) {
			ret = memo.get(fSM);
		} else {
			if (fSM.eClass().getName().equals("GFSM")) {
				ret = this.gFSM((GFSM) fSM);
			} else {
			ret = FsmAlgebra.super.$(fSM);
		}
			memo.put(fSM, ret);
		}
		return ret;
	}
		@Override
	
	Map<State, D> getStateMemo();
	
	public default D $(final State state) {
		final D ret;
		Map<State, D> memo = getStateMemo();
		if(memo.containsKey(state)) {
			ret = memo.get(state);
		} else {
			if (state.eClass().getName().equals("GFinalState")) {
				ret = this.gFinalState((GFinalState) state);
			} else if (state.eClass().getName().equals("GInitialState")) {
				ret = this.gInitialState((GInitialState) state);
			} else if (state.eClass().getName().equals("GState")) {
				ret = this.gState((GState) state);
			} else {
			ret = FsmAlgebra.super.$(state);
		}
			memo.put(state, ret);
		}
		return ret;
	}
		@Override
	
	Map<Transition, E> getTransitionMemo();
	
	public default E $(final Transition transition) {
		final E ret;
		Map<Transition, E> memo = getTransitionMemo();
		if(memo.containsKey(transition)) {
			ret = memo.get(transition);
		} else {
			if (transition.eClass().getName().equals("GTransition")) {
				ret = this.gTransition((GTransition) transition);
			} else {
			ret = FsmAlgebra.super.$(transition);
		}
			memo.put(transition, ret);
		}
		return ret;
	}
}