package fr.inria.diverse.gfsm.abstr;

import fr.inria.diverse.expression.algebra.abstr.ExpressionAlgebra;
import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;

public interface GFSMAlgebra<T, F, S, IE, BE, IO>
		extends FSMAlgebra<T, F, S>, ExpressionAlgebra<IE, BE, IO>, GFSMAlgebraDispatcher {
	T gTransition(GTransition gTransition);

	S gState(GState gState);

	S gInitialState(GInitialState gInitialState);

	S gFinalState(GFinalState gFinalState);

	F gFSM(GFSM gfsm);

}
