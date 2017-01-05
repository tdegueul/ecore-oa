package fr.inria.diverse.gfsm.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import expression.IntOperation;
import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;
import fr.inria.diverse.expression.algebra.impl.EvalExpressionAlgebra;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;
import fsm.State;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;
import gfsm.algebra.GfsmAlgebra;

public interface ExecutableGFSMAlgebra extends ExecutableFSMAlgebra, EvalExpressionAlgebra,
		GfsmAlgebra<CtxEvalExp<Integer, Boolean>, CtxEvalExp<Integer, Integer>, ExecutableExp, ExecutableExp, ExecutableExp, EvalOpExp<Integer>> {

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
				final List<Transition> res = gState.getOutgoingtransitions().stream()
						.filter(t -> t.getEvent().equals(action)).filter(t -> {
					final boolean ret;
					if (t instanceof GTransition) {
						ret = $(((GTransition) t).getGuard())
								.result(ExecutableGFSMAlgebra.this.getCtx()).orElseThrow(
										() -> new RuntimeException("failed to process " + t.getEvent() + " guard"));
					} else {
						ret = false;
					}
					return ret;
				}).collect(Collectors.toList());

				if (res.size() == 1) {
					System.out.println("transition: event " + action + " - " + gState.getName() + " -> "
							+ res.get(0).getTo().getName());
					this._printCtx();
					this._processOutExpression(this.getCurrentState());
					this._printCtx();
					this.setCurrentState(res.get(0).getTo());
					this._processInExpression(this.getCurrentState());
					this._printCtx();
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

	public default void _printCtx() {
		System.out.println("Context : ");
		for (final Entry<String, Integer> e : this.getCtx().entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
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
			this._processInExpression(this.getCurrentState());
			while (this.getCurrentState() != null) {
				this.$(this.getCurrentState()).execute();
			}
		};
	}

	public default void _processOutExpression(final State currentState) {
		if (currentState instanceof GState) {
			this.$(((GState) this.getCurrentState()).getOutExpression()).eval(this.getCtx());
		}
	}

	public default void _processInExpression(final State currentState) {
		if (currentState instanceof GState) {

			final IntOperation inExpression = ((GState) this.getCurrentState()).getInExpression();
			this.$(inExpression).eval(this.getCtx());
		}
	}
}
