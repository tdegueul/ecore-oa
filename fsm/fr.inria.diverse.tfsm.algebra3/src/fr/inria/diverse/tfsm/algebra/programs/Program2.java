package fr.inria.diverse.tfsm.algebra.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.Maps;

import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.fsm.algebra.exprs.CtxExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.tfsm.algebra.impl.ExecutableTFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.impl.GraphvizTFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import tfsm.Clock;
import tfsm.ClockConstraintOperation;
import tfsm.ClockReset;
import tfsm.TfsmPackage;
import tfsm.algebra.TfsmAlgebra;

public class Program2 {

	public static void main(final String[] args) {
		new Program2().execute();
	}

	private void execute() {
		final TfsmAlgebra<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp> algGraphviz = new GraphvizTFSMAlgebra() {

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

			@Override
			public Map<ClockConstraintOperation, RepGraphvizExp> getClockConstraintOperationMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<Clock, RepGraphvizExp> getClockMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<ClockReset, RepGraphvizExp> getClockResetMemo() {
				return Maps.newHashMap();
			}

		};
		final Map<java.lang.Integer, String> defaultTimedActions = new HashMap<Integer, String>();
		defaultTimedActions.put(3, "a");
		defaultTimedActions.put(7, "b");
		defaultTimedActions.put(9, "a");

		final TfsmAlgebra<Boolean, Void, CtxExecutableExp, ExecutableExp, ExecutableExp, ExecutableExp> algExec = new ExecutableTFSMAlgebra() {

			Map<Integer, String> timedActions = defaultTimedActions;

			@Override
			public Map<Integer, String> getTimedActions() {
				return this.timedActions;
			}

			Integer time = 0;

			@Override
			public void setTime(final Integer time) {
				this.time = time;
			}

			@Override
			public Integer getTime() {
				return this.time;
			}

			@Override
			public Queue<String> getUserinput() {
				throw new UnsupportedOperationException("TODO: auto-generated method stub");
			}

			State currentState;

			@Override
			public State getCurrentState() {
				return this.currentState;
			}

			@Override
			public void setCurrentState(final State state) {
				this.currentState = state;
			}

			@Override
			public Map<ClockConstraintOperation, Boolean> getClockConstraintOperationMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<Clock, Void> getClockMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<ClockReset, CtxExecutableExp> getClockResetMemo() {
				return Maps.newHashMap();
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
			public Map<Transition, ExecutableExp> getTransitionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public ExecutableExp fSM(FSM fSM) {
				return null;
			}

			@Override
			public ExecutableExp finalState(FinalState finalState) {
				return null;
			}

			@Override
			public ExecutableExp initialState(InitialState initialState) {
				return null;
			}

			@Override
			public ExecutableExp state(State state) {
				return null;
			}

			@Override
			public ExecutableExp transition(Transition transition) {
				return null;
			}

		};
		System.out.println(this.make(algGraphviz).result(new GraphvizRep()));
		this.make(algExec).execute();

	}

	private <A, B, C, D, E, F> D make(final TfsmAlgebra<A, B, C, D, E, F> f) {
		final FSM exp = this.createModel();

		return f.$(exp);
	}

	private FSM createModel() {
		final ResourceSetImpl resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tfsm", new XMIResourceFactoryImpl());
		final TfsmPackage fsmPackage = TfsmPackage.eINSTANCE;
		// TODO: Replacing with System.getProperty("user.dir")
		final URI createURI = URI
				.createURI("/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.tfsm.algebra3/model/TFSM1.tfsm");
		final Resource resource = resSet.getResource(createURI, true);
		return (FSM) resource.getContents().get(0);
	}

}
