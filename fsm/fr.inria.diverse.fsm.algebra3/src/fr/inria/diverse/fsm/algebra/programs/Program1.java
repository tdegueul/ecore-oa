package fr.inria.diverse.fsm.algebra.programs;

import java.util.LinkedList;
import java.util.Queue;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.FSM;
import fsm.FinalState;
import fsm.FsmFactory;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;

public class Program1 {

	public static void main(final String[] args) {
		new Program1().execute();

	}

	private void execute() {
		System.out.println(make(new GraphvizFSMAlgebra() {
		}).result(new GraphvizRep()));

		final Queue<String> defaultUserInput = new LinkedList<String>();
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

			public void setUserInput(final Queue<String> userinput) {
				this.userInput = userinput;
			}

		}).execute();
	}

	private <T, F, S> F make(final FSMAlgebra<T, F, S> f) {
		final FSM exp = createModel();

		return f.$(exp);
	}

	private FSM createModel() {
		final FsmFactory expF = FsmFactory.eINSTANCE;

		final InitialState initial = expF.createInitialState();
		initial.setName("first");
		final State nodea = expF.createState();
		nodea.setName("A");
		final State nodeb = expF.createState();
		nodeb.setName("B");
		final FinalState end = expF.createFinalState();
		end.setName("last");

		final Transition t1 = expF.createTransition();
		t1.setFrom(initial);
		t1.setTo(nodea);
		t1.setEvent("a");
		final Transition t2 = expF.createTransition();
		t2.setFrom(initial);
		t2.setTo(nodeb);
		t2.setEvent("c");
		final Transition t3 = expF.createTransition();
		t3.setFrom(nodea);
		t3.setTo(end);
		t3.setEvent("b");

		final FSM ret = expF.createFSM();

		ret.getTransitions().add(t1);
		ret.getTransitions().add(t2);
		ret.getTransitions().add(t3);
		ret.setInitialstate(initial);
		return ret;
	}

}
