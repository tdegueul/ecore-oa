package fr.inria.diverse.fsm.algebra.exprs;

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;

@SuppressWarnings("all")
public interface ExecutableTransitionExp {
  public abstract String event();
  
  public abstract ExecutableExp execute();
}
