package fr.inria.diverse.tfsm.algebra.exprs

import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp

interface ExecutableTimedTransitionExp extends ExecutableTransitionExp {
//	interface TimedTransitionData {
////		def String event()
//
//		def Boolean guard()
//
////		def void execute()
//
//	}
//
//	def TimedTransitionData executeWithTime(Integer time)
	def Boolean guard()
	
	def void setTime(Integer time)
	
	/*
	 * TODO : Recreate the same structure as in State and/or keep track of object creation in the Defer object in order to not create everything many time
	 */
}
