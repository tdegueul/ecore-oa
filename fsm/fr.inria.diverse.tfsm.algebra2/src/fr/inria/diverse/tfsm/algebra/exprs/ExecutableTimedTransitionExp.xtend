package fr.inria.diverse.tfsm.algebra.exprs

import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp

interface ExecutableTimedTransitionExp extends ExecutableTransitionExp {
	interface TimedTransitionData {
		def String event()

		def Boolean guard()

		def void execute()

	}

	def TimedTransitionData executeWithTime(Integer time)
}
