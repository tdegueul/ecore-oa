package gtfsm.algebra;

import fsm.FSM;
import fsm.State;
import fsm.Transition;
import gfsm.algebra.GfsmAlgebra;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;
import tfsm.algebra.TfsmAlgebra;

public interface GtfsmAlgebra<A, B, C, D, E, F, G, H, I> extends GfsmAlgebra<B, E, F, G, H, I>, TfsmAlgebra<A, C, D, F, G, H> {

	F gTFSM(final GTFSM gTFSM);

	G gTFinalState(final GTFinalState gTFinalState);

	G gTInitialState(final GTInitialState gTInitialState);

	G gTState(final GTState gTState);

	H gTTransition(final GTTransition gTTransition);

	@Override
	public default F $(final FSM fSM) {
		F ret;
		if (fSM instanceof GTFSM) {
			ret = this.gTFSM((GTFSM) fSM);
		} else {
		try {
			ret = GfsmAlgebra.super.$(fSM);
		} catch(RuntimeException e) {
			ret = TfsmAlgebra.super.$(fSM);
		}
		}
		return ret;
	}
		@Override
	public default G $(final State state) {
		G ret;
		if (state instanceof GTFinalState) {
			ret = this.gTFinalState((GTFinalState) state);
		} else if (state instanceof GTInitialState) {
			ret = this.gTInitialState((GTInitialState) state);
		} else if (state instanceof GTState) {
			ret = this.gTState((GTState) state);
		} else {
		try {
			ret = GfsmAlgebra.super.$(state);
		} catch(RuntimeException e) {
			ret = TfsmAlgebra.super.$(state);
		}
		}
		return ret;
	}
		@Override
	public default H $(final Transition transition) {
		H ret;
		if (transition instanceof GTTransition) {
			ret = this.gTTransition((GTTransition) transition);
		} else {
		try {
			ret = GfsmAlgebra.super.$(transition);
		} catch(RuntimeException e) {
			ret = TfsmAlgebra.super.$(transition);
		}
		}
		return ret;
	}
}