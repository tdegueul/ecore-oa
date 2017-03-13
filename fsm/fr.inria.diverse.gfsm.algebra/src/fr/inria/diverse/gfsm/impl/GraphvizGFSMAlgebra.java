package fr.inria.diverse.gfsm.impl;

import java.text.MessageFormat;
import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

import fr.inria.diverse.expression.algebra.impl.PrettyPrintExpressionAlgebra;
import fr.inria.diverse.expression.algebra.semantics.GraphvizExp;
import fr.inria.diverse.expression.algebra.semantics.RepGraphvizExp;
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;
import gfsm.algebra.GfsmAlgebra;

public interface GraphvizGFSMAlgebra extends
	GraphvizFSMAlgebra,
	PrettyPrintExpressionAlgebra,
	GfsmAlgebra<GraphvizExp, GraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, GraphvizExp> {

	@Override
	public default RepGraphvizExp transition(final Transition transition) {
		return GraphvizFSMAlgebra.super.transition(transition);
	}

	@Override
	public default RepGraphvizExp gTransition(final GTransition gTransition) {
		return (GraphvizRep rep) -> {
			String guard = gTransition.getGuard() != null ? $(gTransition.getGuard()).result() : "";
			rep.edges.add(MessageFormat.format("{0} -> {1} [label=\"{2}\"]",
				$(gTransition.getFrom()).result(rep),
				$(gTransition.getTo()).result(rep),
				gTransition.getEvent() + (guard.isEmpty() ? "" : "\\n") + guard));
			return "";
		};
	}

	@Override
	public default RepGraphvizExp gState(final GState gState) {
		return (GraphvizRep rep) -> {
			String stateName = state(gState).result(rep);
			HashMap<String, String> attrs = new HashMap<>();

			if (gState.getInExpression() != null) {
				// FIXME : Line breaks replacement is not so nice...
				String guard1 = $(gState.getInExpression()).result().replaceAll("\n", "\\\\n");
				attrs.put("label", "IN:\\n" + guard1);
			}

			if (gState.getOutExpression() != null) {
				String guard2 = $(gState.getOutExpression()).result().replaceAll("\n", "\\\\n");
				String orDefault = attrs.getOrDefault("label", "");
				String value = orDefault + (orDefault.equals("") ? "" : "\\n") + "OUT:\\n" + guard2;
				attrs.put("label", value);
			}

			rep.addNode(stateName, attrs);
			return stateName;
		};
	}

	@Override
	public default RepGraphvizExp gInitialState(final GInitialState gInitialState) {
		return (GraphvizRep rep) -> {
			String nodeName = gState(gInitialState).result(rep);
			rep.addNode(nodeName, ImmutableMap.of("shape", "box", "color", "red"));
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp gFinalState(final GFinalState gFinalState) {
		return (GraphvizRep rep) -> {
			String nodeName = gState(gFinalState).result(rep);
			rep.addNode(nodeName, ImmutableMap.of("shape", "box", "color", "green"));
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp gFSM(final GFSM gfsm) {
		return (GraphvizRep rep) -> {
			rep.name = gfsm.getName();
			gfsm.getTransitions().forEach(t -> $(t).result(rep));
			return rep.show();
		};
	}
}
