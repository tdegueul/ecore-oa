package fr.inria.diverse.fsm.algebra.exprs

interface ExecutableStateExp {

	interface ExecutableStateData {
		def String name()
		def void setFinal(Boolean isFinal)
		def ExecutableExp execute()
	}

	def ExecutableStateData execute();
}
