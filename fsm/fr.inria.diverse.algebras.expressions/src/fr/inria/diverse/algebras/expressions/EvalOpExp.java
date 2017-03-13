package fr.inria.diverse.algebras.expressions;

import java.util.Map;

public interface EvalOpExp<T> {
	public boolean eval(final Map<String, T> ctx);
}
