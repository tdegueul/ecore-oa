package fr.inria.diverse.tfsm.algebra.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.inria.diverse.fsm.algebra.exprs.CtxExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransition;
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;
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
	public default ExecutableExp timedFSM(TimedFSM tfsm) {
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
	public default ExecutableExp timedInitialState(TimedInitialState s) {
		return timedState(s);
	}

	@Override
	public default ExecutableExp timedFinalState(TimedFinalState s) {
		return timedState(s);
	}

	@Override
	public default ExecutableTransition timedTransition(TimedTransition tt) {
		// FIXME: Check clocks here
		return () -> true;
	}

	@Override
	public default ExecutableExp timedState(TimedState s) {
		return () -> {
			String action = getTimedActions().get(getTime());
			
			long futureActions = getTimedActions().keySet().stream().filter(p -> p > getTime()).count();
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
						.map(t -> (TimedTransition) t) // FIXME: Uh
						.collect(Collectors.toList());
				int size = nonGuardedRes.size();

				if (size > 1) {
					System.out.println("[ERROR] non deterministic: " + size + " outgoing transitions match event " + action);
					setCurrentState(null);
				} else if (size == 1) {
					TimedTransition trans = nonGuardedRes.get(0);
					State next = trans.getTo();
					System.out.println("transition (time " + getTime() + "): event " + action + " - " + getCurrentState().getName() + " -> " + next.getName());
					trans.getClockresets().forEach(r -> r.getClock().setTick(0));
					System.out.println("clocks:");
					for (Clock c : ((TimedFSM) s.eContainer()).getClocks()) // FIXME: Uh
						System.out.println("\t- clock " + c.getName() + " = " + c.getTick());
					System.out.println();
					setCurrentState(next);
				}
			}
			
			if (!$(((TimedState) getCurrentState()).getStateguard())) { // FIXME: Uh
				System.out.println("[ERROR] deadlock! State guard triggered at time " + getTime() + " on state " + getCurrentState().getName());
				System.out.println("clocks:");
				for (Clock c : ((TimedFSM) s.eContainer()).getClocks()) // FIXME: Uh
					System.out.println("\t- clock " + c.getName() + " = " + c.getTick());
				System.out.println();
				setCurrentState(null);
			}
		};
	}

	@Override
	public default Void clock(Clock c) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	@Override
	public default CtxExecutableExp clockReset(ClockReset cr) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	@Override
	public default Boolean lowerClockConstraint(LowerClockConstraint clockConstraint) {
		return clockConstraint.getClock().getTick() < clockConstraint.getThreshold();
	}

	@Override
	public default Boolean lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint) {
		return lowerEqualClockConstraint.getClock().getTick() <= lowerEqualClockConstraint.getThreshold();
	}

	@Override
	public default Boolean upperClockConstraint(UpperClockConstraint upperClockConstraint) {
		return upperClockConstraint.getClock().getTick() > upperClockConstraint.getThreshold();
	}

	@Override
	public default Boolean upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint) {
		return upperEqualClockConstraint.getClock().getTick() >= upperEqualClockConstraint.getThreshold();
	}

	@Override
	public default Boolean andClockConstraint(AndClockConstraint andClockConstraint) {
		return $(andClockConstraint.getLeft()) && $(andClockConstraint.getRight());
	}

	@Override
	public default Boolean orClockConstraint(OrClockConstraint orClockConstraint) {
		return $(orClockConstraint.getLeft()) || $(orClockConstraint.getRight());
	}

	// FIXME: What are these?
	public Map<Integer, String> getTimedActions();
	public Integer getTime();
	public void setTime(Integer t);
}
