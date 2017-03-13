package fr.inria.diverse.algebras.expressions;

import java.util.Optional;

public interface EvalExp<T> {
	public Optional<T> result();
}
