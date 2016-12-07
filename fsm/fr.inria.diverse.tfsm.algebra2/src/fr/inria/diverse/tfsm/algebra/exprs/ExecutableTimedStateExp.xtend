package fr.inria.diverse.tfsm.algebra.exprs

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp

interface ExecutableTimedStateExp extends ExecutableStateExp {
	def Pair<String, (Boolean) => (Integer) => ExecutableExp> executeWithTime()
}
