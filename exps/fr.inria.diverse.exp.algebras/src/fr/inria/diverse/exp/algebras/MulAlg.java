package fr.inria.diverse.exp.algebras;

import exp.Exp;
import mul.Mul;

public interface MulAlg<E> extends ExpAlg<E> {
	public E mul(Mul l);
	@Override public default E $(Exp e) {
		if (e instanceof Mul)
			return mul((Mul) e);
		return ExpAlg.super.$(e);
	}
}
