package fr.inria.diverse.expression.algebra.impl;

import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;
import fr.inria.diverse.expression.algebra.abstr.ExpressionAlgebraDispatcherDefault;

public interface EvalExpressionAlgebraDispatcher extends EvalExpressionAlgebra,
		ExpressionAlgebraDispatcherDefault<CtxEvalExp<Integer, Integer>, CtxEvalExp<Integer, Boolean>, EvalOpExp<Integer>> {

}
