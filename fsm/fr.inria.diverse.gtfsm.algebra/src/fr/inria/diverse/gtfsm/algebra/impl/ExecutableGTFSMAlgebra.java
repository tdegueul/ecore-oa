package fr.inria.diverse.gtfsm.algebra.impl;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;

import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;
import fr.inria.diverse.fsm.algebra.exprs.CtxExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.gfsm.impl.ExecutableGFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.impl.ExecutableTFSMAlgebra;
import fsm.Transition;
import gfsm.GTransition;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;
import gtfsm.algebra.GtfsmAlgebra;
import tfsm.ClockConstraintOperation;
import tfsm.TimedFSM;
import tfsm.TimedTransition;

public interface ExecutableGTFSMAlgebra extends
//ExecutableExp, ExecutableExp, ExecutableExp, Void, Boolean, CtxExecutableExp, CtxEvalExp<Integer, Boolean>, CtxEvalExp<Integer, Integer>, EvalOpExp<Integer>
		GtfsmAlgebra<Boolean, CtxEvalExp<Integer, Boolean>, Void, CtxExecutableExp, CtxEvalExp<Integer, Integer>, ExecutableExp, ExecutableExp, ExecutableExp,EvalOpExp<Integer> >,
		ExecutableTFSMAlgebra, ExecutableGFSMAlgebra {

	@Override
	default ExecutableExp gTFSM(final GTFSM gtfsm) {
		return () -> {
			this.setCurrentState(gtfsm.getInitialstate());
			this._processInExpression(this.getCurrentState());
			while (this.getCurrentState() != null) {
				this.$(this.getCurrentState()).execute();
				gtfsm.getClocks().forEach(e -> {
					e.setTick(e.getTick() + 1);
				});
				this.setTime(this.getTime() + 1);
			}
		};
	}

	@Override
	default ExecutableExp gTInitialState(final GTInitialState gtInitialState) {
		return this.gTState(gtInitialState);
	}

	@Override
	default ExecutableExp gTFinalState(final GTFinalState gtFinalState) {
		return this.gTState(gtFinalState);
	}

	@Override
	default ExecutableExp gTState(final GTState gtState) {
		return () -> {
			final String action = this.getTimedActions().get(this.getTime());

			final Long futureActions = this.getTimedActions().entrySet().stream()
					.filter(t -> t.getKey() >= this.getTime()).collect(Collectors.counting());
			if (futureActions == 0) {
				if (!(this.getCurrentState() instanceof GTFinalState)) {
					System.out.println(
							"[ERROR] no action available but final state not reached (" + gtState.getName() + ")");
				}
				this.setCurrentState(null);
			} else if (action != null) {
				final EList<Transition> outgoingtransitions = gtState.getOutgoingtransitions();
				final Stream<Transition> filter = outgoingtransitions.stream().filter(t -> t.getEvent().equals(action));
				final List<Transition> res = filter.filter(t -> {
					final boolean ret;
					if (t instanceof GTransition) {
						final Map<String, Integer> ctx = this.getCtx();
						ret = this.$(((GTransition) t).getGuard()).result(ctx).orElseThrow(
								() -> new RuntimeException("failed to process " + t.getEvent() + " guard"));
					} else {
						ret = false;
					}
					return ret;
				}).filter(t -> {
					final boolean ret;
					if (t instanceof TimedTransition) {
						final ClockConstraintOperation transitionguard = ((TimedTransition) t).getTransitionguard();
						ret = transitionguard == null || this.$(transitionguard);
					} else {
						ret = false;
					}

					return ret;
				}).collect(Collectors.toList());

				final int size = res.size();
				if (size == 1) {
					final GTTransition transition = (GTTransition) res.get(0);
					System.out.println("transition: event " + action + " - " + gtState.getName() + " -> "
							+ transition.getTo().getName());
					transition.getClockresets().forEach(c -> c.getClock().setTick(0));

					System.out.println("clocks:");
					((TimedFSM) gtState.eContainer()).getClocks().forEach(c -> {
						System.out.println(" - clock " + c.getName() + " = " + c.getTick());
					});
					this._printCtx();
					this._processOutExpression(this.getCurrentState());
					this._printCtx();
					this.setCurrentState(transition.getTo());
					this._processInExpression(this.getCurrentState());
					this._printCtx();
				} else if (size > 1) {
					System.out.println(
							"[ERROR] Non deterministic " + size + " outgoing transitions matches event " + action);
					this.setCurrentState(null);
				} else {
					System.out.println("[ERROR] Deadlock");
					this.setCurrentState(null);
				}
			}

		};
	}

	@Override
	default ExecutableExp gTTransition(final GTTransition gtTransition) {
		return null;
	}

}
