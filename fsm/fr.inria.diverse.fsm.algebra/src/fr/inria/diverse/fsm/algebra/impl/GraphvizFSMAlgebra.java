package fr.inria.diverse.fsm.algebra.impl;

import java.util.Map;

import com.google.common.collect.Maps;

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
	public default RepGraphvizExp transition(Transition t) {
		return (GraphvizRep rep) -> {
			rep.edges.add(
				$(t.getFrom()).result(rep) + " -> " + $(t.getTo()).result(rep) + " [label=" + t.getEvent() + "]"
			);
			return "";
		};
	}

	@Override
	public default RepGraphvizExp state(State s) {
		return (GraphvizRep rep) -> s.getName();
	}

	@Override
	public default RepGraphvizExp finalState(FinalState s) {
		return (GraphvizRep rep) -> {
			String nodeName = state(s).result(rep);
			Map<String, String> props = Maps.newHashMap();
			props.put("shape", "box");
			props.put("color", "green");
			rep.addNode(nodeName, props);
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp initialState(InitialState s) {
		return (GraphvizRep rep) -> {
			String nodeName = state(s).result(rep);
			Map<String, String> props = Maps.newHashMap();
			props.put("shape", "box");
			props.put("color", "red");
			rep.addNode(nodeName, props);
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp fSM(FSM fsm) {
		return (GraphvizRep rep) -> {
			rep.name = fsm.getName();
			// FIXME: Uh? Does it do anything at all?
			fsm.getTransitions().forEach(e -> $(e).result(rep));
			rep.show();
			return "";
		};
	}
}
