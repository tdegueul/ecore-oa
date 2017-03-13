package fr.inria.diverse.fsm.algebra.exprs;

import java.util.Map;

interface TimedCtxExecutableExp  {
	public void execute(Map<Integer, String> timedActions, Integer time);
}
