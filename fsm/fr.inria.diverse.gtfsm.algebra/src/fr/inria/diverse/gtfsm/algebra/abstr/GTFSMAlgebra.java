package fr.inria.diverse.gtfsm.algebra.abstr;

import fr.inria.diverse.gfsm.abstr.GFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra;
import fsm.FSM;
import fsm.State;
import fsm.Transition;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;

public interface GTFSMAlgebra<T, S, F, C, CCO, CR, IE, BE, IO>
		extends TFSMAlgebra<T, S, F, C, CCO, CR>, GFSMAlgebra<T, S, F, IE, BE, IO> {

	F gtfsm(GTFSM gtfsm);

	S gtInitialState(GTInitialState gtInitialState);

	S gtFinalState(GTFinalState gtFinalState);

	S gtState(GTState gtState);

	T gtTransition(GTTransition gtTransition);

	@Override
	default S $S(final State state) {
		S ret;
		if (state instanceof GTFinalState) {
			ret = this.gtFinalState((GTFinalState) state);
		} else if (state instanceof GTInitialState) {
			ret = this.gtInitialState((GTInitialState) state);
		} else if (state instanceof GTState) {
			ret = this.gtState((GTState) state);
		} else {
			try {
				ret = GFSMAlgebra.super.$S(state);
			} catch (final RuntimeException e) {
				ret = TFSMAlgebra.super.$S(state);
			}
		}
		return ret;
	}

	@Override
	default F $F(final FSM fsm) {
		F ret;
		if (fsm instanceof GTFSM) {
			ret = this.gtfsm((GTFSM) fsm);
		} else {
			try {
				ret = GFSMAlgebra.super.$F(fsm);
			} catch (final RuntimeException e) {
				ret = TFSMAlgebra.super.$F(fsm);
			}
		}
		return ret;
	}

	@Override
	default T $T(final Transition transition) {
		T ret;
		if (transition instanceof GTTransition) {
			ret = this.gtTransition((GTTransition) transition);
		} else {
			try {
				ret = GFSMAlgebra.super.$T(transition);
			} catch (final RuntimeException e) {
				ret = TFSMAlgebra.super.$T(transition);
			}
		}
		return ret;
	}

}
