package fr.inria.diverse.fsm.algebra.abstr;

import java.util.List;

@SuppressWarnings("all")
public interface FSMAlgebra<T extends Object, S extends Object, F extends Object, IS extends Object, FS extends Object> {
  public abstract F fsm(final List<? extends S> states, final List<? extends T> transitions, final S initialState, final String name);
  
  public abstract IS initialState(final String name, final F fsm, final List<? extends T> outgoingtransitions, final List<? extends T> incommingtransitions);
  
  public abstract S state(final String name, final F fsm, final List<? extends T> outgoingtransitions, final List<? extends T> incommingtransitions);
  
  public abstract FS finalState(final String name, final F fsm, final List<? extends T> outgoingtransitions, final List<? extends T> incommingtransitions);
  
  public abstract T transition(final S from, final S to, final F fsm, final String event);
}
