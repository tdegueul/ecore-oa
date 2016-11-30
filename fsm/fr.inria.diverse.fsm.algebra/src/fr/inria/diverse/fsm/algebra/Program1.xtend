package fr.inria.diverse.fsm.algebra

import fsm.FSM
import fsm.FsmFactory

class Program1 {
	def FSM createModel() {
		val expF = FsmFactory::eINSTANCE

		val initial = expF.createInitialState => [name = "first"]
		val nodea = expF.createState => [name = "A"]
		val nodeb = expF.createState => [name = "B"]
		val end = expF.createFinalState => [name = "last"]

		val t1 = expF.createTransition => [
			from = initial
			to = nodea
			event = 'a'
		]
		val t2 = expF.createTransition => [
			from = initial
			to = nodeb
			event = 'c'
		]
		val t3 = expF.createTransition => [
			from = nodea
			to = end
			event = 'b'
		]
		return expF.createFSM => [
			transitions.addAll(newArrayList(t1, t2, t3))
			initialstate = initial
		]
	}

	def <E> E make(FSMAlgebra<E> f) {
		val exp = createModel

		return f.exp(exp)
	}

	def static void main(String[] args) {
		new Program1().execute()
	}

	def execute() {
		println(make(new GraphvizFSMAlgebra).evalGraph)
		make(new ExecutableFSMAlgebra(newLinkedList('a', 'b'))).execute
	}

}
