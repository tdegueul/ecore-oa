package fr.inria.diverse.fsm.algebra.exprs;

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public interface ExecutableStateExp {
  public abstract Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> execute();
}
