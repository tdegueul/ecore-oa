package test;

import exp.Exp;
import mul.Mul;
import test.ExpAlg;

@SuppressWarnings("all")
public interface MulAlg<E extends Object> extends ExpAlg<E> {
  public abstract E mul(final Mul m);
  
  @Override
  public default E exp(final Exp e) {
    E _xifexpression = null;
    if ((e instanceof Mul)) {
      _xifexpression = this.mul(((Mul)e));
    } else {
      _xifexpression = ExpAlg.super.exp(e);
    }
    return _xifexpression;
  }
}
