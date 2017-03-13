package fr.inria.diverse.fsm.algebra.impl;

import java.text.MessageFormat;

import com.google.common.collect.ImmutableMap;

import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import fsm.algebra.FsmAlgebra;

public interface GraphvizFSMAlgebra extends FsmAlgebra<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp> {
	@Override
	public default RepGraphvizExp transition(final Transition t) {
		return (GraphvizRep rep) -> {
			rep.edges.add(
				MessageFormat.format("{0} -> {1} [label=\"{2}\"]",
					$(t.getFrom()).result(rep), $(t.getTo()).result(rep), t.getEvent())
			);
			return "";
		};
	}

	@Override
	public default RepGraphvizExp state(final State s) {
		return (GraphvizRep rep) -> s.getName();
	}

	@Override
	public default RepGraphvizExp finalState(final FinalState s) {
		return (GraphvizRep rep) -> {
			String nodeName = state(s).result(rep);
			rep.addNode(nodeName, ImmutableMap.of("shape", "box", "color", "green"));
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp initialState(final InitialState s) {
		return (GraphvizRep rep) -> {
			String nodeName = state(s).result(rep);
			rep.addNode(nodeName, ImmutableMap.of("shape", "box", "color", "red"));
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp fSM(final FSM fsm) {
		return (GraphvizRep rep) -> {
			rep.name = fsm.getName();
			// FIXME: Uh? Does it do anything at all?
			fsm.getTransitions().forEach(t -> $(t).result(rep));
			rep.show();
			return "";
		};
	}
}
