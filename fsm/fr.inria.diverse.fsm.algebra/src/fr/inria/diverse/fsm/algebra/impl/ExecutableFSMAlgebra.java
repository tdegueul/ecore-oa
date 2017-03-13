package fr.inria.diverse.fsm.algebra.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import fr.inria.diverse.fsm.algebra.semantics.ExecutableExp;
import fr.inria.diverse.fsm.algebra.semantics.ExecutableTransition;
import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import fsm.algebra.FsmAlgebra;

public interface ExecutableFSMAlgebra extends FsmAlgebra<ExecutableExp, ExecutableExp, ExecutableTransition> {
	@Override
	public default ExecutableTransition transition(final Transition t) {
		return () -> true;
	}

	@Override
	public default ExecutableExp state(final State s) {
		return () -> {
			String action = getUserinput().poll();
			if (action == null) {
				if (!(getCurrentState() instanceof FinalState))
					System.out.println("[ERROR] no action available but final state not reached");
			} else {
				List<Transition> res =
					s.getOutgoingtransitions().stream()
					.filter(t -> t.getEvent().equals(action))
					.collect(Collectors.toList());

				if (res.size() == 1) {
					State next = res.get(0).getTo();
					System.out.println(MessageFormat.format("transition : event {0} - {1} -> {2}",
						action, getCurrentState().getName(), next.getName()));
					setCurrentState(next);
				} else if (res.size() > 1) {
					System.out.println(MessageFormat.format("[ERROR] non deterministic: {0} outgoing transitions match event {1}",
						res.size(), action));
					setCurrentState(null);
				} else {
					System.out.println("[ERROR] deadlock!");
					setCurrentState(null);
				}
			}
		};
	}

	@Override
	public default ExecutableExp finalState(final FinalState s) {
		return state(s);
	}

	@Override
	public default ExecutableExp initialState(final InitialState s) {
		return state(s);
	}

	@Override
	public default ExecutableExp fSM(final FSM fsm) {
		return () -> {
			setCurrentState(fsm.getInitialstate());
			while(getCurrentState() != null)
				if (getCurrentState() instanceof FinalState)
					setCurrentState(null);
				else
					$(getCurrentState()).execute();
		};
	}

	// FIXME: What are these?
	public Queue<String> getUserinput();
	public State getCurrentState();
	public void setCurrentState(final State s);
}
