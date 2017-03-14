package fr.inria.diverse.exp.algebras;

import exp.Add;
import exp.Exp;
import exp.Lit;

public interface ExpAlg<E> {
	public E lit(Lit l);
	public E add(Add a);
	public default E $(Exp e) {
		if (e instanceof Lit)
			return lit((Lit) e);
		if (e instanceof Add)
			return add((Add) e);
		else throw new RuntimeException("Snap! $() cannot handle " + e);
	}
}
