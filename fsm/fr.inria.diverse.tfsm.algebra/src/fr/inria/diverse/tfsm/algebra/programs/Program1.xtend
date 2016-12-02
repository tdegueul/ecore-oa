package fr.inria.diverse.tfsm.algebra.programs

import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import fr.inria.diverse.tfsm.algebra.impl.ExecutableTFSMAlgebra
import fr.inria.diverse.tfsm.algebra.impl.GraphvizTFSMAlgebra
import tfsm.FSM
import tfsm.TfsmFactory

class Program1 {
	def static void main(String[] args) {
		new Program1().execute();
	}

	def execute() {
		println(make(new GraphvizTFSMAlgebra).evalGraph)
		val made = make(new ExecutableTFSMAlgebra(newHashMap(3 -> "a", 7 -> "b", 9 -> "a")))
		made.execute
	}

	def <E> E make(TFSMAlgebra<E> f) {
		val exp = createModel

		return f.exp(exp)
	}

	def FSM createModel() {
		val expF = TfsmFactory::eINSTANCE

		val xClock = expF.createClock => [name = "x"]
		val yClock = expF.createClock => [name = "y"]

		val s0 = expF.createInitialState => [
			name = "s0"
			stateguard = expF.createLowerEqualClockConstraint => [
				threshold = 5
				clock = yClock
			]
		]

		val s1 = expF.createFinalState => [
			name = "s1"
			stateguard = expF.createAndClockConstraint => [
				left = expF.createLowerEqualClockConstraint => [
					threshold = 10
					clock = yClock

				]
				right = expF.createLowerEqualClockConstraint => [
					threshold = 8
					clock = xClock

				]
			]
		]

		val ta = expF.createTransition => [
			event = "a"
			from = s0
			to = s1
			clockresets.add(expF.createClockReset => [clock = yClock])
			transitionguard = expF.createUpperEqualClockConstraint => [
				threshold = 3
				clock = yClock
			]
		]

		val tb = expF.createTransition => [
			event = "b"
			from = s1
			to = s0
			clockresets.add(expF.createClockReset => [clock = xClock])
			transitionguard = expF.createAndClockConstraint => [
				left = expF.createUpperEqualClockConstraint => [
					threshold = 4
					clock = yClock
				]
				right = expF.createUpperEqualClockConstraint => [
					threshold = 6
					clock = xClock
				]
			]
		]

		return expF.createFSM => [
			states.addAll(newArrayList(s0, s1))
			transitions.addAll(newArrayList(ta, tb))
			initialstate = s0
			clocks.addAll(newArrayList(xClock, yClock))
		]
	}

}
