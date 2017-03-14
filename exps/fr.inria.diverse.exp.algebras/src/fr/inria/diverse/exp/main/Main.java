package fr.inria.diverse.exp.main;

import exp.Add;
import exp.Exp;
import exp.ExpFactory;
import exp.Lit;
import fr.inria.diverse.exp.algebras.ExpAlg;
import fr.inria.diverse.exp.impls.EvalExp;
import fr.inria.diverse.exp.impls.EvalMul;
import fr.inria.diverse.exp.impls.PrintExp;
import fr.inria.diverse.exp.semantics.IEval;
import fr.inria.diverse.exp.semantics.IPrint;
import fr.inria.diverse.exp.semantics.PrintMul;
import mul.Mul;
import mul.MulFactory;

public class Main {
	public static void main(String[] args) {
		// Make models
		Exp m1 = makeExpModel();
		Exp m2 = makeMulModel();

		// Print/Eval m1 with ExpAlg
		IPrint p1 = makeAlg(m1, new PrintExp(){});
		IEval  e1 = makeAlg(m1, new EvalExp() {});
		System.out.println(p1.print() + " = " + e1.eval());
		
		// Print/Eval m2 with MulAlg
		IPrint p2 = makeAlg(m2, new PrintMul(){});
		IEval  e2 = makeAlg(m2, new EvalMul() {});
		System.out.println(p2.print() + " = " + e2.eval());

		// So far so good.
		// Now, trying to apply MulAlg on a basic Exp
		IPrint p3 = makeAlg(m1, new PrintMul(){});
		IEval  e3 = makeAlg(m1, new EvalMul() {});
		System.out.println(p3.print() + " = " + e3.eval());
		
		// Well, still good.
		// Now, the other way around: ExpAlg on Mul
		IPrint p4 = makeAlg(m2, new PrintExp(){});
		IEval  e4 = makeAlg(m2, new EvalExp() {});
		// Argh.
		try {
			System.out.println(p4.print() + " = " + e4.eval());
		} catch (RuntimeException e) {
			System.err.println("Well, ExpAlg cannot handle Mul: " + e.getMessage());
		}
	}

	private static <E> E makeAlg(Exp m, ExpAlg<E> alg) {
		return alg.$(m);
	}

	private static Exp makeExpModel() {
		ExpFactory f = ExpFactory.eINSTANCE;
		Add root = f.createAdd();
		Lit l1 = f.createLit();
		l1.setValue(2);
		Lit l2 = f.createLit();
		l2.setValue(3);
		root.setLhs(l1);
		root.setRhs(l2);
		return root;
	}

	private static Exp makeMulModel() {
		ExpFactory fE = ExpFactory.eINSTANCE;
		MulFactory fM = MulFactory.eINSTANCE;
		Add root = fE.createAdd();
		Mul m = fM.createMul();
		Lit l1 = fE.createLit();
		l1.setValue(2);
		Lit l2 = fE.createLit();
		l2.setValue(3);
		Lit l3 = fE.createLit();
		l3.setValue(4);
		m.setLhs(l2);
		m.setRhs(l3);
		root.setLhs(l1);
		root.setRhs(m);
		return root;
	}
}
