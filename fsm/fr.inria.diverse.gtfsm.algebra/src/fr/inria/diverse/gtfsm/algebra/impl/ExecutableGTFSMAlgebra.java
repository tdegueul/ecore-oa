package fr.inria.diverse.gtfsm.algebra.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import fr.inria.diverse.expression.algebra.semantics.CtxEvalExp;
import fr.inria.diverse.expression.algebra.semantics.EvalOpExp;
import fr.inria.diverse.fsm.algebra.semantics.CtxExecutableExp;
import fr.inria.diverse.fsm.algebra.semantics.ExecutableExp;
import fr.inria.diverse.fsm.algebra.semantics.ExecutableTransition;
import fr.inria.diverse.gfsm.impl.ExecutableGFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.impl.ExecutableTFSMAlgebra;
import fsm.Transition;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;
import gtfsm.algebra.GtfsmAlgebra;
import tfsm.TimedFSM;

public interface ExecutableGTFSMAlgebra extends
	ExecutableTFSMAlgebra,
	ExecutableGFSMAlgebra,
	GtfsmAlgebra<Boolean, CtxEvalExp<Integer, Boolean>, Void, CtxExecutableExp, CtxEvalExp<Integer, Integer>, ExecutableExp, ExecutableExp, ExecutableTransition, EvalOpExp<Integer> > {

	@Override
	default ExecutableExp gTFSM(final GTFSM gtfsm) {
		return () -> {
			setCurrentState(gtfsm.getInitialstate());
			_processInExpression(getCurrentState());
			while (getCurrentState() != null) {
				$(getCurrentState()).execute();
				gtfsm.getClocks().forEach(e -> e.setTick(e.getTick() + 1));
				setTime(getTime() + 1);
			}
		};
	}

	@Override
	default ExecutableExp gTInitialState(final GTInitialState gtInitialState) {
		return gTState(gtInitialState);
	}

	@Override
	default ExecutableExp gTFinalState(final GTFinalState gtFinalState) {
		return gTState(gtFinalState);
	}

	@Override
	default ExecutableExp gTState(final GTState gtState) {
		return () -> {
			String action = getTimedActions().get(getTime());
			long futureActions =
				getTimedActions().entrySet().stream()
				.filter(t -> t.getKey() >= getTime())
				.collect(Collectors.counting());

			if (futureActions == 0) {
				if (!(getCurrentState() instanceof GTFinalState))
					System.out.println(
						"[ERROR] no action available but final state not reached (" + gtState.getName() + ")");
				setCurrentState(null);
			} else if (action != null) {
				List<Transition> res =
					gtState.getOutgoingtransitions().stream()
					.filter(t -> t.getEvent().equals(action) && $(t).execute())
					.collect(Collectors.toList());
				int resSize = res.size();

				if (resSize == 1) {
					GTTransition transition = (GTTransition) res.get(0); // FIXME: Avoid casts
					System.out.println(MessageFormat.format("transition: event {0} - {1} -> {2}",
						action, gtState.getName(), transition.getTo().getName()));
					transition.getClockresets().forEach(c -> c.getClock().setTick(0));

					System.out.println("clocks:");
					((TimedFSM) gtState.getFsm()).getClocks().forEach(c ->  // FIXME: Avoid casts
						System.out.println(" - clock " + c.getName() + " = " + c.getTick())
					);
					_printCtx();
					_processOutExpression(getCurrentState());
					_printCtx();
					setCurrentState(transition.getTo());
					_processInExpression(getCurrentState());
					_printCtx();
				} else if (resSize > 1) {
					System.out.println(MessageFormat.format("[ERROR] Non deterministic {0} outgoing transitions match event {1}",
						resSize, action));
					setCurrentState(null);
				} else {
					System.out.println("[ERROR] Deadlock");
					setCurrentState(null);
				}
			}
		};
	}

	@Override
	default ExecutableTransition gTTransition(final GTTransition gtTransition) {
		return null; // FIXME: Mh. Is that normal?
	}
}
