package fr.inria.diverse.fsm.algebra.exprs

interface ExecutableStateExp  {
	def Pair<String, (Boolean) => ExecutableExp> execute();
}
