package fr.inria.diverse.gfsm.programs;

import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.gfsm.abstr.GFSMAlgebraDispatcherDefault;
import fr.inria.diverse.gfsm.impl.ExecutableGFSMAlgebra;

public interface ExecutableGFSMAlgebraImpl extends ExecutableGFSMAlgebra, GFSMAlgebraDispatcherDefault<ExecutableExp, ExecutableExp, ExecutableExp, CtxEvalExp<Integer, Integer>, CtxEvalExp<Integer, Boolean>, EvalOpExp<Integer>> {

}
