package fr.inria.diverse.fsm.algebra.exprs

interface ExecutableTransitionExp {
	def Pair<String, ExecutableExp> execute();
}
