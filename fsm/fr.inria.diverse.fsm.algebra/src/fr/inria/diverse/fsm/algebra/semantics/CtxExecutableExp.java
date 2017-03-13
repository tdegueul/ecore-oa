package fr.inria.diverse.fsm.algebra.semantics;

import java.util.Queue;

public interface CtxExecutableExp {
	public void execute(final Queue<String> inputs);
}
