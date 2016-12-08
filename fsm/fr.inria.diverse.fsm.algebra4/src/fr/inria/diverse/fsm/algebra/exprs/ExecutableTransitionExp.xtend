package fr.inria.diverse.fsm.algebra.exprs

interface ExecutableTransitionExp {
	def String event()
	
	def ExecutableExp execute()
}
