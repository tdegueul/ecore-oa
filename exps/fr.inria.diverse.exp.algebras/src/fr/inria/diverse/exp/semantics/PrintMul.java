package fr.inria.diverse.exp.semantics;

import fr.inria.diverse.exp.algebras.MulAlg;
import fr.inria.diverse.exp.impls.PrintExp;
import mul.Mul;

public interface PrintMul extends PrintExp, MulAlg<IPrint> {
	@Override public default IPrint mul(Mul m) {
		return () -> $(m.getLhs()).print() + " * " + $(m.getRhs()).print();
	}
}
