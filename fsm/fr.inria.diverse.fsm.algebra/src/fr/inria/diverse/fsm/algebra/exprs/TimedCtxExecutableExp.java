package fr.inria.diverse.fsm.algebra.exprs;

import java.util.Map;

interface TimedCtxExecutableExp  {
	public void execute(final Map<Integer, String> timedActions, final Integer time);
}
