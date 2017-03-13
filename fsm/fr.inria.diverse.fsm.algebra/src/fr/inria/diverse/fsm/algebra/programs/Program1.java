package fr.inria.diverse.fsm.algebra.programs;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.google.common.collect.Maps;

import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransition;
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.FSM;
import fsm.FinalState;
import fsm.FsmFactory;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import fsm.algebra.FsmAlgebra;

public class Program1 {
	public static void main(final String[] args) {
		new Program1().execute();
	}

	private void execute() {
		System.out.println(make(new GraphvizFSMAlgebra() {
			@Override
			public Map<FSM, RepGraphvizExp> getFSMMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<State, RepGraphvizExp> getStateMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<Transition, RepGraphvizExp> getTransitionMemo() {
				return Maps.newHashMap();
			}
		}).result(new GraphvizRep()));

		final Queue<String> defaultUserInput = new LinkedList<>();
		defaultUserInput.add("a");
		defaultUserInput.add("b");

		make(new ExecutableFSMAlgebra() {
			State state;
			Queue<String> userInput = defaultUserInput;

			public State getCurrentState() {
				return state;
			}

			public void setCurrentState(final State state) {
				this.state = state;
			}

			public Queue<String> getUserinput() {
				return userInput;
			}

			@Override
			public Map<FSM, ExecutableExp> getFSMMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<State, ExecutableExp> getStateMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<Transition, ExecutableTransition> getTransitionMemo() {
				return Maps.newHashMap();
			}
		}).execute();
	}

	private <F, S, T> F make(final FsmAlgebra<F, S, T> f) {
		FSM exp = createModel();
		return f.$(exp);
	}

	private FSM createModel() {
		FsmFactory expF = FsmFactory.eINSTANCE;

		InitialState initial = expF.createInitialState();
		initial.setName("first");

		State nodea = expF.createState();
		nodea.setName("A");

		State nodeb = expF.createState();
		nodeb.setName("B");

		FinalState end = expF.createFinalState();
		end.setName("last");

		Transition t1 = expF.createTransition();
		t1.setFrom(initial);
		t1.setTo(nodea);
		t1.setEvent("a");

		Transition t2 = expF.createTransition();
		t2.setFrom(initial);
		t2.setTo(nodeb);
		t2.setEvent("c");

		Transition t3 = expF.createTransition();
		t3.setFrom(nodea);
		t3.setTo(end);
		t3.setEvent("b");

		FSM ret = expF.createFSM();
		ret.getTransitions().add(t1);
		ret.getTransitions().add(t2);
		ret.getTransitions().add(t3);
		ret.setInitialstate(initial);
	
		return ret;
	}
}
