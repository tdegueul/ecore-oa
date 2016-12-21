package fr.inria.diverse.gfsm.abstr;

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

public interface GFSMAlgebra<A, B, C, D, E, F> extends FsmAlgebra<A, B, C>, ExpressionAlgebra<D, E, F> {
	C gTransition(GTransition gTransition);

	B gState(GState gState);

	B gInitialState(GInitialState gInitialState);

	B gFinalState(GFinalState gFinalState);

	A gFSM(GFSM gfsm);

	@Override
	default C $(final Transition transition) {
		final C ret;
		if (transition instanceof GTransition) {
			ret = this.gTransition((GTransition) transition);
		} else {
			ret = FsmAlgebra.super.$(transition);
		}
		return ret;
	}

	@Override
	default B $(final State state) {
		final B ret;
		if (state instanceof GFinalState) {
			ret = this.gFinalState((GFinalState) state);
		} else if (state instanceof GInitialState) {
			ret = this.gInitialState((GInitialState) state);
		} else if (state instanceof GState) {
			ret = this.gState((GState) state);
		} else {
			ret = FsmAlgebra.super.$(state);
		}
		return ret;
	}

	@Override
	default A $(final FSM fsm) {
		final A ret;
		if (fsm instanceof GFSM) {
			ret = this.gFSM((GFSM) fsm);
		} else {
			ret = FsmAlgebra.super.$(fsm);
		}
		return ret;
	}

}
