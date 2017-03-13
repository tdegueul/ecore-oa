package fr.inria.diverse.tfsm.algebra.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;
import fr.inria.diverse.fsm.algebra.semantics.CtxExecutableExp;
import fr.inria.diverse.fsm.algebra.semantics.ExecutableExp;
import fr.inria.diverse.fsm.algebra.semantics.ExecutableTransition;
import fsm.State;
import tfsm.AndClockConstraint;
import tfsm.Clock;
import tfsm.ClockReset;
import tfsm.LowerClockConstraint;
import tfsm.LowerEqualClockConstraint;
import tfsm.OrClockConstraint;
import tfsm.TimedFSM;
import tfsm.TimedFinalState;
import tfsm.TimedInitialState;
import tfsm.TimedState;
import tfsm.TimedTransition;
import tfsm.UpperClockConstraint;
import tfsm.UpperEqualClockConstraint;
import tfsm.algebra.TfsmAlgebra;

public interface ExecutableTFSMAlgebra extends TfsmAlgebra<Boolean, Void, CtxExecutableExp, ExecutableExp, ExecutableExp, ExecutableTransition>, ExecutableFSMAlgebra {
	@Override
	public default ExecutableExp timedFSM(final TimedFSM tfsm) {
		return () -> {
			setCurrentState(tfsm.getInitialstate());
			while (getCurrentState() != null) {
				$(getCurrentState()).execute();
				tfsm.getClocks().forEach(c -> c.setTick(c.getTick() + 1));
				setTime(getTime() + 1);
			}
		};
	}

	@Override
	public default ExecutableExp timedInitialState(final TimedInitialState s) {
		return timedState(s);
	}

	@Override
	public default ExecutableExp timedFinalState(final TimedFinalState s) {
		return timedState(s);
	}

	@Override
	public default ExecutableTransition timedTransition(final TimedTransition tt) {
		return () -> tt.getTransitionguard() == null || $(tt.getTransitionguard());
	}

	@Override
	public default ExecutableExp timedState(final TimedState s) {
		return () -> {
			String action = getTimedActions().get(getTime());
			long futureActions =
				getTimedActions().keySet().stream()
				.filter(p -> p > getTime())
				.collect(Collectors.counting());

			if (futureActions == 0) {
				if (!(getCurrentState() instanceof TimedFinalState)) {
					System.out.println("[ERROR] no action available but final state not reached");
					setCurrentState(null);
				}
			} else if (action != null) {
				List<TimedTransition> nonGuardedRes =
						s.getOutgoingtransitions()
						.stream()
						.filter(t -> t.getEvent().equals(action) && $(t).execute())
						.map(t -> (TimedTransition) t) // FIXME: Avoid casts
						.collect(Collectors.toList());
				int size = nonGuardedRes.size();

				if (size > 1) {
					System.out.println(MessageFormat.format("[ERROR] non deterministic: {0} outgoing transitions match event {1}",
						size, action));
					setCurrentState(null);
				} else if (size == 1) {
					TimedTransition trans = nonGuardedRes.get(0);
					State next = trans.getTo();
					System.out.println(MessageFormat.format("transition (time {0}): event {1} - {2} -> {3}",
						getTime(), action, getCurrentState().getName(), next.getName()));
					trans.getClockresets().forEach(r -> r.getClock().setTick(0));
					System.out.println("clocks:");
					for (Clock c : ((TimedFSM) s.getFsm()).getClocks())
						System.out.println("\t- clock " + c.getName() + " = " + c.getTick());
					System.out.println();
					setCurrentState(next);
				}
			}
			
			if (!$(((TimedState) getCurrentState()).getStateguard())) { // FIXME: Uh, avoid casts
				System.out.println(MessageFormat.format("ERROR] deadlock! State guard triggered at time {0} on state {1}",
					getTime(), getCurrentState().getName()));
				System.out.println("clocks:");
				for (Clock c : ((TimedFSM) s.getFsm()).getClocks())
					System.out.println("\t- clock " + c.getName() + " = " + c.getTick());
				System.out.println();
				setCurrentState(null);
			}
		};
	}

	@Override
	public default Void clock(final Clock c) {
		// FIXME: Is this normal?
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	@Override
	public default CtxExecutableExp clockReset(final ClockReset cr) {
		// FIXME: Is this normal?
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	@Override
	public default Boolean lowerClockConstraint(final LowerClockConstraint clockConstraint) {
		return clockConstraint.getClock().getTick() < clockConstraint.getThreshold();
	}

	@Override
	public default Boolean lowerEqualClockConstraint(final LowerEqualClockConstraint lowerEqualClockConstraint) {
		return lowerEqualClockConstraint.getClock().getTick() <= lowerEqualClockConstraint.getThreshold();
	}

	@Override
	public default Boolean upperClockConstraint(final UpperClockConstraint upperClockConstraint) {
		return upperClockConstraint.getClock().getTick() > upperClockConstraint.getThreshold();
	}

	@Override
	public default Boolean upperEqualClockConstraint(final UpperEqualClockConstraint upperEqualClockConstraint) {
		return upperEqualClockConstraint.getClock().getTick() >= upperEqualClockConstraint.getThreshold();
	}

	@Override
	public default Boolean andClockConstraint(final AndClockConstraint andClockConstraint) {
		return $(andClockConstraint.getLeft()) && $(andClockConstraint.getRight());
	}

	@Override
	public default Boolean orClockConstraint(final OrClockConstraint orClockConstraint) {
		return $(orClockConstraint.getLeft()) || $(orClockConstraint.getRight());
	}

	// FIXME: What are these?
	public Map<Integer, String> getTimedActions();
	public Integer getTime();
	public void setTime(final Integer t);
}
