package fr.inria.diverse.exp.impls;

import exp.Add;
import exp.Lit;
import fr.inria.diverse.exp.algebras.ExpAlg;
import fr.inria.diverse.exp.semantics.IEval;

public interface EvalExp extends ExpAlg<IEval> {
	@Override public default IEval lit(Lit l) {
		return () -> l.getValue();
	}
	@Override public default IEval add(Add a) {
		return () -> $(a.getLhs()).eval() + $(a.getRhs()).eval();
	}
}
