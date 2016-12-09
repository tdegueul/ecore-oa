package test

import exp.Add
import exp.Exp
import exp.Lit
import mul.Mul
import mul.MulFactory
import exp.ExpFactory

interface ExpAlg<E> {
	def E lit(Lit l)

	def E add(Add a)

	// Grrrrr
	def E exp(Exp e) {
		return if (e instanceof Lit)
			lit(e)
		else if (e instanceof Add)
			add(e)
	}
}

interface MulAlg<E> extends ExpAlg<E> {
	def E mul(Mul m)

	// Grrrrr
	override E exp(Exp e) {
		return if (e instanceof Mul)
			mul(e)
		else
			ExpAlg.super.exp(e)
	}
}

interface Eval {
	def int eval()
}

interface Print {
	def String print()
}

class EvalExp implements ExpAlg<Eval> {
	override lit(Lit l) {
		return [l.value]
	}

	override add(Add a) {
		return [
			exp(a.lhs).eval + exp(a.rhs).eval
		]
	}
}

class MulEvalExp extends EvalExp implements MulAlg<Eval> {
	override mul(Mul m) {
		return [
			exp(m.lhs).eval * exp(m.rhs).eval
		]
	}
}

class PrintExp implements ExpAlg<Print> {
	override lit(Lit l) {
		return [l.value.toString]
	}

	override add(Add a) {
		return [
			'''«exp(a.lhs).print» + «exp(a.rhs).print»'''
		]
	}
}

class MulPrintExp extends PrintExp implements MulAlg<Print> {
	override mul(Mul m) {
		return [
			'''«exp(m.lhs).print» * «exp(m.rhs).print»'''
		]
	}
}

class Main {
	def Exp createModel() {
		val expF = ExpFactory::eINSTANCE
		val mulF = MulFactory::eINSTANCE

		return expF.createAdd => [
			lhs = expF.createLit => [value = 2]
			rhs = mulF.createMul => [
				lhs = expF.createLit => [value = 3]
				rhs = expF.createLit => [value = 5]
			]
		]
	}

	def <E> E make(ExpAlg<E> f) {
		val exp = createModel

		return f.add(exp as Add)
	}

	def void foo() {
		val evalExp = make(new MulEvalExp)
		val printExp = make(new MulPrintExp)
		println("Eval = " + evalExp.eval)
		println("Print = " + printExp.print)
	}

	def static void main(String[] args) {
		new Main().foo
	}
}
