package test;

import exp.Add;
import exp.Exp;
import exp.Lit;
import test.Eval;
import test.ExpAlg;

@SuppressWarnings("all")
public class EvalExp implements ExpAlg<Eval> {
  @Override
  public Eval lit(final Lit l) {
    final Eval _function = () -> {
      return l.getValue();
    };
    return _function;
  }
  
  @Override
  public Eval add(final Add a) {
    final Eval _function = () -> {
      Exp _lhs = a.getLhs();
      Eval _exp = this.exp(_lhs);
      int _eval = _exp.eval();
      Exp _rhs = a.getRhs();
      Eval _exp_1 = this.exp(_rhs);
      int _eval_1 = _exp_1.eval();
      return (_eval + _eval_1);
    };
    return _function;
  }
}
