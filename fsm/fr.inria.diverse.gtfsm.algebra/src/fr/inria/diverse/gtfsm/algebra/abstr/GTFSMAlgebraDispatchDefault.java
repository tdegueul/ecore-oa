package fr.inria.diverse.gtfsm.algebra.abstr;

import fr.inria.diverse.gfsm.abstr.GFSMAlgebraDispatcherDefault;
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebraDispatchDefault;
import fsm.FSM;
import fsm.State;
import fsm.Transition;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;

public interface GTFSMAlgebraDispatchDefault<T, F, S, C, CCO, CR, IE, BE, IO>
		extends GTFSMAlgebra<T, F, S, C, CCO, CR, IE, BE, IO>, GFSMAlgebraDispatcherDefault<T, F, S, IE, BE, IO>,
		TFSMAlgebraDispatchDefault<T, F, S, C, CCO, CR> {
	@Override
	default S $(final State state) {
		S ret;
		if (state instanceof GTFinalState) {
			ret = this.gtFinalState((GTFinalState) state);
		} else if (state instanceof GTInitialState) {
			ret = this.gtInitialState((GTInitialState) state);
		} else if (state instanceof GTState) {
			ret = this.gtState((GTState) state);
		} else {
			try {
				ret = GFSMAlgebraDispatcherDefault.super.$(state);
			} catch (final RuntimeException e) {
				ret = TFSMAlgebraDispatchDefault.super.$(state);
			}
		}
		return ret;
	}

	@Override
	default F $(final FSM fsm) {
		F ret;
		if (fsm instanceof GTFSM) {
			ret = this.gtfsm((GTFSM) fsm);
		} else {
			try {
				ret = GFSMAlgebraDispatcherDefault.super.$(fsm);
			} catch (final RuntimeException e) {
				ret = TFSMAlgebraDispatchDefault.super.$(fsm);
			}
		}
		return ret;
	}

	@Override
	default T $(final Transition transition) {
		T ret;
		if (transition instanceof GTTransition) {
			ret = this.gtTransition((GTTransition) transition);
		} else {
			try {
				ret = GFSMAlgebraDispatcherDefault.super.$(transition);
			} catch (final RuntimeException e) {
				ret = TFSMAlgebraDispatchDefault.super.$(transition);
			}
		}
		return ret;
	}
}
