package fr.inria.diverse.gfsm.abstr;

import fr.inria.diverse.expression.algebra.abstr.ExpressionAlgebraDispatcherDefault;
import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebraDispatcherDefault;
import fsm.FSM;
import fsm.State;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;

public interface GFSMAlgebraDispatcherDefault<T, F, S, IE, BE, IO> extends GFSMAlgebra<T, F, S, IE, BE, IO>,
		FSMAlgebraDispatcherDefault<T, F, S>, ExpressionAlgebraDispatcherDefault<IE, BE, IO> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.inria.diverse.gfsm.abstr.GFSMAlgebraDispatcher#$(fsm.Transition)
	 */
	@Override
	default T $(final Transition transition) {
		final T ret;
		if (transition instanceof GTransition) {
			ret = this.gTransition((GTransition) transition);
		} else {
			 ret = FSMAlgebraDispatcherDefault.super.$(transition);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.inria.diverse.gfsm.abstr.GFSMAlgebraDispatcher#$(fsm.State)
	 */
	@Override
	default S $(final State state) {
		final S ret;
		if (state instanceof GFinalState) {
			ret = this.gFinalState((GFinalState) state);
		} else if (state instanceof GInitialState) {
			ret = this.gInitialState((GInitialState) state);
		} else if (state instanceof GState) {
			ret = this.gState((GState) state);
		} else {
			 ret = FSMAlgebraDispatcherDefault.super.$(state);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.inria.diverse.gfsm.abstr.GFSMAlgebraDispatcher#$(fsm.FSM)
	 */
	@Override
	default F $(final FSM fsm) {
		final F ret;
		if (fsm instanceof GFSM) {
			ret = this.gFSM((GFSM) fsm);
		} else {
			 ret = FSMAlgebraDispatcherDefault.super.$(fsm);
//			throw new RuntimeException("TODO");
		}
		return ret;
	}
}
