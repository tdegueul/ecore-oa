package fr.inria.diverse.algebras.expressions;

import java.util.Optional;

public interface EvalExp<T> {
	Optional<T> result();
}
