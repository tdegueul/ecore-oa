package fr.inria.diverse.expression.algebra.semantics;

import java.util.Optional;

public interface EvalExp<T> {
	public Optional<T> result();
}
