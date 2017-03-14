package fr.inria.diverse.exp.impls;

import fr.inria.diverse.exp.algebras.MulAlg;
import fr.inria.diverse.exp.semantics.IEval;
import mul.Mul;

public interface EvalMul extends EvalExp, MulAlg<IEval> {
	@Override public default IEval mul(Mul m) {
		return () -> $(m.getLhs()).eval() * $(m.getRhs()).eval();
	}
}
