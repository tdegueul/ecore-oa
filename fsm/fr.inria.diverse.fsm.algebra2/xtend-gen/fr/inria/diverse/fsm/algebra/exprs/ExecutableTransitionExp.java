package fr.inria.diverse.fsm.algebra.exprs;

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public interface ExecutableTransitionExp {
  public abstract Pair<String, ExecutableExp> execute();
}
