package fr.inria.diverse.tfsm.algebra.exprs

import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp

interface ExecutableTimedTransitionExp extends ExecutableTransitionExp {
	def Boolean guard()
	
	def void setTime(Integer time)
	
}
