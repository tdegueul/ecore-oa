package fr.inria.diverse.tfsm.algebra.programs;

import fr.inria.diverse.fsm.algebra.exprs.CtxExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebraDispatchDefault;
import fr.inria.diverse.tfsm.algebra.impl.ExecutableTFSMAlgebra;

public interface ExecutableTFSMAlgebraImpl
		extends ExecutableTFSMAlgebra, TFSMAlgebraDispatchDefault<ExecutableExp, ExecutableExp, ExecutableExp, Void, Boolean, CtxExecutableExp> {

}
