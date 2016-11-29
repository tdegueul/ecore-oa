package test;

import exp.Add;
import exp.Exp;
import exp.ExpFactory;
import exp.Lit;
import mul.Mul;
import mul.MulFactory;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import test.Eval;
import test.ExpAlg;
import test.MulEvalExp;
import test.MulPrintExp;
import test.Print;

@SuppressWarnings("all")
public class Main {
  public Exp createModel() {
    final ExpFactory expF = ExpFactory.eINSTANCE;
    final MulFactory mulF = MulFactory.eINSTANCE;
    Add _createAdd = expF.createAdd();
    final Procedure1<Add> _function = (Add it) -> {
      Lit _createLit = expF.createLit();
      final Procedure1<Lit> _function_1 = (Lit it_1) -> {
        it_1.setValue(2);
      };
      Lit _doubleArrow = ObjectExtensions.<Lit>operator_doubleArrow(_createLit, _function_1);
      it.setLhs(_doubleArrow);
      Mul _createMul = mulF.createMul();
      final Procedure1<Mul> _function_2 = (Mul it_1) -> {
        Lit _createLit_1 = expF.createLit();
        final Procedure1<Lit> _function_3 = (Lit it_2) -> {
          it_2.setValue(3);
        };
        Lit _doubleArrow_1 = ObjectExtensions.<Lit>operator_doubleArrow(_createLit_1, _function_3);
        it_1.setLhs(_doubleArrow_1);
        Lit _createLit_2 = expF.createLit();
        final Procedure1<Lit> _function_4 = (Lit it_2) -> {
          it_2.setValue(5);
        };
        Lit _doubleArrow_2 = ObjectExtensions.<Lit>operator_doubleArrow(_createLit_2, _function_4);
        it_1.setRhs(_doubleArrow_2);
      };
      Mul _doubleArrow_1 = ObjectExtensions.<Mul>operator_doubleArrow(_createMul, _function_2);
      it.setRhs(_doubleArrow_1);
    };
    return ObjectExtensions.<Add>operator_doubleArrow(_createAdd, _function);
  }
  
  public <E extends Object> E make(final ExpAlg<E> f) {
    final Exp exp = this.createModel();
    return f.add(((Add) exp));
  }
  
  public void foo() {
    MulEvalExp _mulEvalExp = new MulEvalExp();
    final Eval evalExp = this.<Eval>make(_mulEvalExp);
    MulPrintExp _mulPrintExp = new MulPrintExp();
    final Print printExp = this.<Print>make(_mulPrintExp);
    int _eval = evalExp.eval();
    String _plus = ("Eval = " + Integer.valueOf(_eval));
    InputOutput.<String>println(_plus);
    String _print = printExp.print();
    String _plus_1 = ("Print = " + _print);
    InputOutput.<String>println(_plus_1);
  }
  
  public static void main(final String[] args) {
    Main _main = new Main();
    _main.foo();
  }
}
