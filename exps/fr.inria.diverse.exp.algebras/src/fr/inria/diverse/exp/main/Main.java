package fr.inria.diverse.exp.main;

import exp.Add;
import exp.Exp;
import exp.ExpFactory;
import exp.Lit;
import fr.inria.diverse.exp.algebras.ExpAlg;
import fr.inria.diverse.exp.algebras.MulAlg;
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
		IPrint p1 = makeExpAlg(m1, new PrintExp(){});
		IEval  e1 = makeExpAlg(m1, new EvalExp() {});
		System.out.println(p1.print() + " = " + e1.eval());
		
		// Print/Eval m2 with MulAlg
		IPrint p2 = makeMulAlg(m2, new PrintMul(){});
		IEval  e2 = makeMulAlg(m2, new EvalMul() {});
		System.out.println(p2.print() + " = " + e2.eval());
	}

	private static <E> E makeExpAlg(Exp m, ExpAlg<E> alg) {
		return alg.$(m);
	}

	private static <E> E makeMulAlg(Exp m, MulAlg<E> alg) {
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
