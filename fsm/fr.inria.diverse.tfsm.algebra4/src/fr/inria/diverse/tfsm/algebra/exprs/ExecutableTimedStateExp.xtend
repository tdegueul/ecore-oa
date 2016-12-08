package fr.inria.diverse.tfsm.algebra.exprs

import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp

interface ExecutableTimedStateExp extends ExecutableStateExp {


	interface ExecutableTimedStateData extends ExecutableStateData {
		def void setTime(Integer time)
	}
	

	override ExecutableTimedStateData execute()
}
