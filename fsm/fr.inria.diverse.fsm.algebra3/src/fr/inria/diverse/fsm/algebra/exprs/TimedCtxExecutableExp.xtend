package fr.inria.diverse.fsm.algebra.exprs

import java.util.Map

interface TimedCtxExecutableExp  {
	def void execute(Map<Integer, String> timedActions, Integer time);
}
