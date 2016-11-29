package test;

import exp.Exp;
import mul.Mul;
import test.Eval;
import test.EvalExp;
import test.MulAlg;

@SuppressWarnings("all")
public class MulEvalExp extends EvalExp implements MulAlg<Eval> {
  @Override
  public Eval mul(final Mul m) {
    final Eval _function = () -> {
      Exp _lhs = m.getLhs();
      Eval _exp = this.exp(_lhs);
      int _eval = _exp.eval();
      Exp _rhs = m.getRhs();
      Eval _exp_1 = this.exp(_rhs);
      int _eval_1 = _exp_1.eval();
      return (_eval * _eval_1);
    };
    return _function;
  }
}
