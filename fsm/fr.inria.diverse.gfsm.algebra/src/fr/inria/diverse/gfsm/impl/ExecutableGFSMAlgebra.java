package fr.inria.diverse.gfsm.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import expression.IntOperation;
import fr.inria.diverse.expression.algebra.impl.EvalExpressionAlgebra;
import fr.inria.diverse.expression.algebra.semantics.CtxEvalExp;
import fr.inria.diverse.expression.algebra.semantics.EvalOpExp;
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;
import fr.inria.diverse.fsm.algebra.semantics.ExecutableExp;
import fr.inria.diverse.fsm.algebra.semantics.ExecutableTransition;
import fsm.State;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;
import gfsm.algebra.GfsmAlgebra;

public interface ExecutableGFSMAlgebra extends
	ExecutableFSMAlgebra,
	EvalExpressionAlgebra,
	GfsmAlgebra<CtxEvalExp<Integer, Boolean>, CtxEvalExp<Integer, Integer>, ExecutableExp, ExecutableExp, ExecutableTransition, EvalOpExp<Integer>> {

	void setCtx(Map<String, Integer> ctx);

	Map<String, Integer> getCtx();

	@Override
	public default ExecutableTransition gTransition(final GTransition gTransition) {
		return () ->
			$(gTransition.getGuard())
			.result(ExecutableGFSMAlgebra.this.getCtx())
			.orElseThrow(() -> new RuntimeException("failed to process " + gTransition.getEvent() + " guard"));
	}

	@Override
	public default ExecutableExp gState(final GState gState) {
		return () -> {
			String action = ExecutableGFSMAlgebra.this.getUserinput().poll();
			if (action == null) {
				if (!(ExecutableGFSMAlgebra.this.getCurrentState() instanceof GFinalState)) {
					System.out.println("[ERROR] no action available but final state not reached");
					ExecutableGFSMAlgebra.this.setCurrentState(null);
				}
			} else {
				final List<Transition> res =
					gState.getOutgoingtransitions().stream()
					.filter(t -> t.getEvent().equals(action) && $(t).execute())
					.collect(Collectors.toList());
				int resSize = res.size();

				if (resSize == 1) {
					State next = res.get(0).getTo();
					System.out.println(
						MessageFormat.format("transition: event {0} - {1} -> {2}",
						action, gState.getName(), next.getName()));
					_printCtx();
					_processOutExpression(getCurrentState());
					_printCtx();
					setCurrentState(next);
					_processInExpression(getCurrentState());
					_printCtx();
				} else if (resSize > 1) {
					System.out.println(
						MessageFormat.format("[ERROR] Non deterministic {0} outgoing transitions match event {1}",
						action, resSize, action));
					ExecutableGFSMAlgebra.this.setCurrentState(null);
				} else {
					System.out.println("[ERROR] Deadlock");
					ExecutableGFSMAlgebra.this.setCurrentState(null);
				}
			}
		};
	}

	public default void _printCtx() {
		System.out.println("Context: ");
		for (final Entry<String, Integer> e : getCtx().entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}

	@Override
	public default ExecutableExp gInitialState(final GInitialState gInitialState) {
		return gState(gInitialState);
	}

	@Override
	public default ExecutableExp gFinalState(final GFinalState gFinalState) {
		return gState(gFinalState);
	}

	@Override
	public default ExecutableExp gFSM(final GFSM gfsm) {
		return () -> {
			setCurrentState(gfsm.getInitialstate());
			_processInExpression(getCurrentState());
			while (getCurrentState() != null)
				$(getCurrentState()).execute();
		};
	}

	public default void _processOutExpression(final State currentState) {
		if (currentState instanceof GState) // FIXME: Avoid casts
			$(((GState) getCurrentState()).getOutExpression()).eval(getCtx());
	}

	public default void _processInExpression(final State currentState) {
		if (currentState instanceof GState) {
			IntOperation inExpression = ((GState) getCurrentState()).getInExpression();
			$(inExpression).eval(getCtx());
		}
	}
}
