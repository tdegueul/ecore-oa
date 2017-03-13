package fr.inria.diverse.expression.algebra.semantics;

import java.util.Map;
import java.util.Optional;

public interface CtxEvalExp<C, R> {
	public Optional<R> result(final Map<String, C> ctx);
}
