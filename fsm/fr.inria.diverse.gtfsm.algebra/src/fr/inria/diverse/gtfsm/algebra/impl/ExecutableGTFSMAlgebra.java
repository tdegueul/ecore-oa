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
import fr.inria.diverse.gtfsm.algebra.abstr.GTFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.impl.ExecutableTFSMAlgebra;
import fsm.Transition;
import gfsm.GTransition;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;
import tfsm.ClockConstraintOperation;
import tfsm.TimedFSM;
import tfsm.TimedTransition;

public interface ExecutableGTFSMAlgebra extends
		GTFSMAlgebra<ExecutableExp, ExecutableExp, ExecutableExp, Void, Boolean, CtxExecutableExp, CtxEvalExp<Integer, Integer>, CtxEvalExp<Integer, Boolean>, EvalOpExp<Integer>>,
		ExecutableTFSMAlgebra, ExecutableGFSMAlgebra {

	@Override
	default void setUserInput(final Queue<String> userinput) {
		throw new RuntimeException("setUserInput forbidden");
	}

	@Override
	default Queue<String> getUserinput() {
		throw new RuntimeException("getUserInput forbidden");
	}

	@Override
	default ExecutableExp gtfsm(final GTFSM gtfsm) {
		return () -> {
			this.setCurrentState(gtfsm.getInitialstate());
			this._processInExpression(this.getCurrentState());
			while (this.getCurrentState() != null) {
				this.$S(this.getCurrentState()).execute();
				gtfsm.getClocks().forEach(e -> {
					e.setTick(e.getTick() + 1);
				});
				this.setTime(this.getTime() + 1);
			}
		};
	}

	@Override
	default ExecutableExp gtInitialState(final GTInitialState gtInitialState) {
		return this.gtState(gtInitialState);
	}

	@Override
	default ExecutableExp gtFinalState(final GTFinalState gtFinalState) {
		return this.gtState(gtFinalState);
	}

	@Override
	default ExecutableExp gtState(final GTState gtState) {
		return () -> {
			final String action = this.getTimedActions().get(this.getTime());

			final Long futureActions = this.getTimedActions().entrySet().stream().filter(t -> t.getKey() >= this.getTime())
					.collect(Collectors.counting());
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
						ret = this.$BE(((GTransition) t).getGuard()).result(ctx).orElseThrow(
								() -> new RuntimeException("failed to process " + t.getEvent() + " guard"));
					} else {
						ret = false;
					}
					return ret;
				}).filter(t -> {
					final boolean ret;
					if (t instanceof TimedTransition) {
						final ClockConstraintOperation transitionguard = ((TimedTransition) t).getTransitionguard();
						ret = transitionguard == null || this.$CCO(transitionguard);
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
	default ExecutableExp gtTransition(final GTTransition gtTransition) {
		return null;
	}

}
