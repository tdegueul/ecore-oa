package fr.inria.diverse.expression.algebra.semantics;

import java.util.Map;

public interface EvalOpExp<T> {
	public boolean eval(final Map<String, T> ctx);
}
