package fr.inria.diverse.gtfsm.algebra.abstr;

import fr.inria.diverse.gfsm.abstr.GFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;

public interface GTFSMAlgebra<T, F, S, C, CCO, CR, IE, BE, IO>
		extends TFSMAlgebra<T, F, S, C, CCO, CR>, GFSMAlgebra<T, F, S, IE, BE, IO>, GTFSMAlgebraDispatch {

	F gtfsm(GTFSM gtfsm);

	S gtInitialState(GTInitialState gtInitialState);

	S gtFinalState(GTFinalState gtFinalState);

	S gtState(GTState gtState);

	T gtTransition(GTTransition gtTransition);

}
