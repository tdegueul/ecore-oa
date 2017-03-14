package fr.inria.diverse.exp.impls;

import exp.Add;
import exp.Lit;
import fr.inria.diverse.exp.algebras.ExpAlg;
import fr.inria.diverse.exp.semantics.IPrint;

public interface PrintExp extends ExpAlg<IPrint> {
	@Override public default IPrint lit(Lit l) {
		return () -> Integer.toString(l.getValue());
	}
	@Override public default IPrint add(Add a) {
		return () -> $(a.getLhs()).print() + " + " + $(a.getRhs()).print();
	}
}
