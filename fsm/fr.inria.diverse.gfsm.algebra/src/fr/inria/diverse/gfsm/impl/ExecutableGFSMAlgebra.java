package fr.inria.diverse.gfsm.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;
import fr.inria.diverse.expression.algebra.impl.EvalExpressionAlgebra;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;
import fr.inria.diverse.gfsm.abstr.GFSMAlgebra;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;

public interface ExecutableGFSMAlgebra extends ExecutableFSMAlgebra, EvalExpressionAlgebra,
		GFSMAlgebra<ExecutableExp, ExecutableExp, ExecutableExp, CtxEvalExp<Integer, Integer>, CtxEvalExp<Integer, Boolean>, EvalOpExp<Integer>> {

	void setCtx(Map<String, Integer> ctx);

	Map<String, Integer> getCtx();

	@Override
	public default ExecutableExp gTransition(final GTransition gTransition) {
		throw new RuntimeException("gTransition");
	}

	@Override
	public default ExecutableExp gState(final GState gState) {
		return () -> {
			final String action = ExecutableGFSMAlgebra.this.getUserinput().poll();
			if (action == null) {
				if (!(ExecutableGFSMAlgebra.this.getCurrentState() instanceof GFinalState)) {
					System.out.println("[ERROR] no action available but final state not reached");
					ExecutableGFSMAlgebra.this.setCurrentState(null);
				}
			} else {
				final List<Transition> res = gState.getOutgoingtransitions().stream().filter(t -> {
					final boolean ret;
					if (t instanceof GTransition) {
						ret = ExecutableGFSMAlgebra.this.$BE(((GTransition) t).getGuard()).result(ExecutableGFSMAlgebra.this.getCtx()).orElseThrow(
								() -> new RuntimeException("failed to process " + t.getEvent() + " guard"));
					} else {
						ret = false;
					}
					return ret;
				}).collect(Collectors.toList());

				if (res.size() == 1) {
					System.out.println("transition: event " + action + " - " + gState.getName() + " -> "
							+ res.get(0).getTo().getName());
				} else if (res.size() > 1) {
					System.out.println("[ERROR] Non deterministic " + res.size()
							+ " outgoing transitions matches event " + action);
					ExecutableGFSMAlgebra.this.setCurrentState(null);
				} else {
					System.out.println("[ERROR] Deadlock");
					ExecutableGFSMAlgebra.this.setCurrentState(null);
				}
			}

		};
	}

	@Override
	public default ExecutableExp gInitialState(final GInitialState gInitialState) {
		return this.gState(gInitialState);
	}

	@Override
	public default ExecutableExp gFinalState(final GFinalState gFinalState) {
		return this.gState(gFinalState);
	}

	@Override
	public default ExecutableExp gFSM(final GFSM gfsm) {

		return () -> {
			this.setCurrentState(gfsm.getInitialstate());
			while (this.getCurrentState() != null) {
				this.$S(this.getCurrentState()).execute();
			}
		};
	}
}
