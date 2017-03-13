package fr.inria.diverse.gfsm.programs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.Maps;

import expression.BooleanExpression;
import expression.IntExpression;
import expression.IntOperation;
import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;
import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransition;
import fr.inria.diverse.gfsm.impl.ExecutableGFSMAlgebra;
import fr.inria.diverse.gfsm.impl.GraphvizGFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.FSM;
import fsm.State;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.algebra.GfsmAlgebra;

public class Program1 {

	public static void main(final String[] args) {
		new Program1().execute("GFSM1.gfsm");
	}

	private void execute(final String progName) {
		final Queue<String> initUserInput = new LinkedList<>();
		initUserInput.add("t1");
		System.out.println(this.make(new GraphvizGFSMAlgebra() {
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
			public Map<BooleanExpression, GraphvizExp> getBooleanExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntExpression, GraphvizExp> getIntExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntOperation, GraphvizExp> getIntOperationMemo() {
				return Maps.newHashMap();
			}
		}, progName).result(new GraphvizRep()));
		this.make(new ExecutableGFSMAlgebra() {

			private Map<String, Integer> ctx = new HashMap<>();
			private State currentState;
			private Queue<String> userinput = initUserInput;

			@Override
			public Queue<String> getUserinput() {
				return this.userinput;
			}

			@Override
			public State getCurrentState() {
				return this.currentState;
			}

			@Override
			public void setCurrentState(final State state) {
				this.currentState = state;

			}

			@Override
			public void setCtx(final Map<String, Integer> ctx) {
				this.ctx = ctx;

			}

			@Override
			public Map<String, Integer> getCtx() {
				return this.ctx;
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

			@Override
			public Map<BooleanExpression, CtxEvalExp<Integer, Boolean>> getBooleanExpressionMemo() {
				return Maps.newHashMap();
			}
	
			@Override
			public Map<IntExpression, CtxEvalExp<Integer, Integer>> getIntExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntOperation, EvalOpExp<Integer>> getIntOperationMemo() {
				return Maps.newHashMap();
			}

		}, progName).execute();
	}

	private <A, B, F, C, D, E> F make(final GfsmAlgebra<A, B, F, C, D, E> graphvizGFSMAlgebra,
			final String progName) {
		final GFSM model = this.createModel(progName);
		return graphvizGFSMAlgebra.$(model);
	}

	private GFSM createModel(final String progName) {
		final ResourceSetImpl resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("gfsm", new XMIResourceFactoryImpl());
		// TODO: Replacing with System.getProperty("user.dir")
		final URI createURI = URI
				.createURI("model/" + progName);
		final Resource resource = resSet.getResource(createURI, true);
		final EList<EObject> contents = resource.getContents();
		return (GFSM) contents.get(0);
	}
}
