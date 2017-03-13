package fr.inria.diverse.exp.algebras;

import exp.Add;
import exp.Exp;
import exp.Lit;
import mul.Mul;

// Exp + PP
interface ExpAlg<E> {
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

interface IPrint {
	public String print();
}

interface PrintExp extends ExpAlg<IPrint> {
	@Override public default IPrint lit(Lit l) {
		return () -> Integer.toString(l.getValue());
	}
	@Override public default IPrint add(Add a) {
		return () -> $(a.getLhs()).print() + " + " + $(a.getRhs()).print();
	}
}

// Add Mul
interface MulAlg<E> extends ExpAlg<E> {
	public E mul(Mul l);
	@Override public default E $(Exp e) {
		if (e instanceof Mul)
			return mul((Mul) e);
		return ExpAlg.super.$(e);
	}
}

interface PrintMul extends PrintExp, MulAlg<IPrint> {
	@Override public default IPrint mul(Mul m) {
		return () -> $(m.getLhs()).print() + " * " + $(m.getRhs()).print();
	}
}

// Add Eval
interface IEval {
	public int eval();
}

interface EvalExp extends ExpAlg<IEval> {
	@Override public default IEval lit(Lit l) {
		return () -> l.getValue();
	}
	@Override public default IEval add(Add a) {
		return () -> $(a.getLhs()).eval() + $(a.getRhs()).eval();
	}
}

interface EvalMul extends EvalExp, MulAlg<IEval> {
	@Override public default IEval mul(Mul m) {
		return () -> $(m.getLhs()).eval() * $(m.getRhs()).eval();
	}
}
