package fr.inria.diverse.fsm.algebra.programs;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebraDispatcherDefault;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;

public interface ExecutableFSMAlgebraImpl extends ExecutableFSMAlgebra, FSMAlgebraDispatcherDefault<ExecutableExp, ExecutableExp, ExecutableExp> {

}
