package test;

import exp.Exp;
import mul.Mul;
import org.eclipse.xtend2.lib.StringConcatenation;
import test.MulAlg;
import test.Print;
import test.PrintExp;

@SuppressWarnings("all")
public class MulPrintExp extends PrintExp implements MulAlg<Print> {
  @Override
  public Print mul(final Mul m) {
    final Print _function = () -> {
      StringConcatenation _builder = new StringConcatenation();
      Exp _lhs = m.getLhs();
      Print _exp = this.exp(_lhs);
      String _print = _exp.print();
      _builder.append(_print, "");
      _builder.append(" * ");
      Exp _rhs = m.getRhs();
      Print _exp_1 = this.exp(_rhs);
      String _print_1 = _exp_1.print();
      _builder.append(_print_1, "");
      return _builder.toString();
    };
    return _function;
  }
}
