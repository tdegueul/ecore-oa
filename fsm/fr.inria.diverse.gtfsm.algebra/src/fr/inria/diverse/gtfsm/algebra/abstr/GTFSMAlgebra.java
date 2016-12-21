package fr.inria.diverse.gtfsm.algebra.abstr;

import fr.inria.diverse.gfsm.abstr.GFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.abstr.TfsmAlgebra;
import fsm.FSM;
import fsm.State;
import fsm.Transition;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;

public interface GTFSMAlgebra<A, B, C, D, E, F, G, H, I>
		extends TfsmAlgebra<A, B, C, D, E, F>, GFSMAlgebra<A, B, C, G, H, I> {

	A gtfsm(GTFSM gtfsm);

	B gtInitialState(GTInitialState gtInitialState);

	B gtFinalState(GTFinalState gtFinalState);

	B gtState(GTState gtState);

	C gtTransition(GTTransition gtTransition);

	@Override
	default B $(final State state) {
		B ret;
		if (state instanceof GTFinalState) {
			ret = this.gtFinalState((GTFinalState) state);
		} else if (state instanceof GTInitialState) {
			ret = this.gtInitialState((GTInitialState) state);
		} else if (state instanceof GTState) {
			ret = this.gtState((GTState) state);
		} else {
			try {
				ret = GFSMAlgebra.super.$(state);
			} catch (final RuntimeException e) {
				ret = TfsmAlgebra.super.$(state);
			}
		}
		return ret;
	}

	@Override
	default A $(final FSM fsm) {
		A ret;
		if (fsm instanceof GTFSM) {
			ret = this.gtfsm((GTFSM) fsm);
		} else {
			try {
				ret = GFSMAlgebra.super.$(fsm);
			} catch (final RuntimeException e) {
				ret = TfsmAlgebra.super.$(fsm);
			}
		}
		return ret;
	}

	@Override
	default C $(final Transition transition) {
		C ret;
		if (transition instanceof GTTransition) {
			ret = this.gtTransition((GTTransition) transition);
		} else {
			try {
				ret = GFSMAlgebra.super.$(transition);
			} catch (final RuntimeException e) {
				ret = TfsmAlgebra.super.$(transition);
			}
		}
		return ret;
	}

}
