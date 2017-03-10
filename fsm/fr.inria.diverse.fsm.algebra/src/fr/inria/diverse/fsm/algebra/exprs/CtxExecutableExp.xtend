package fr.inria.diverse.fsm.algebra.exprs

import java.util.Queue

interface CtxExecutableExp {
	def void execute(Queue<String> userinput);
}
