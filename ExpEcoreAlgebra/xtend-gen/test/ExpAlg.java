package test;

import exp.Add;
import exp.Exp;
import exp.Lit;

@SuppressWarnings("all")
public interface ExpAlg<E extends Object> {
  public abstract E lit(final Lit l);
  
  public abstract E add(final Add a);
  
  public default E exp(final Exp e) {
    E _xifexpression = null;
    if ((e instanceof Lit)) {
      _xifexpression = this.lit(((Lit)e));
    } else {
      E _xifexpression_1 = null;
      if ((e instanceof Add)) {
        _xifexpression_1 = this.add(((Add)e));
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
