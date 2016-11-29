package test;

import exp.Add;
import exp.Exp;
import exp.Lit;
import org.eclipse.xtend2.lib.StringConcatenation;
import test.ExpAlg;
import test.Print;

@SuppressWarnings("all")
public class PrintExp implements ExpAlg<Print> {
  @Override
  public Print lit(final Lit l) {
    final Print _function = () -> {
      int _value = l.getValue();
      return Integer.valueOf(_value).toString();
    };
    return _function;
  }
  
  @Override
  public Print add(final Add a) {
    final Print _function = () -> {
      StringConcatenation _builder = new StringConcatenation();
      Exp _lhs = a.getLhs();
      Print _exp = this.exp(_lhs);
      String _print = _exp.print();
      _builder.append(_print, "");
      _builder.append(" + ");
      Exp _rhs = a.getRhs();
      Print _exp_1 = this.exp(_rhs);
      String _print_1 = _exp_1.print();
      _builder.append(_print_1, "");
      return _builder.toString();
    };
    return _function;
  }
}
