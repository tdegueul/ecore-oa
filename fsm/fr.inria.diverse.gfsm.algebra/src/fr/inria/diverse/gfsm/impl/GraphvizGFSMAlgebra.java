package fr.inria.diverse.gfsm.impl;

import java.util.HashMap;

import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.expression.algebra.impl.PrettyPrintExpressionAlgebra;
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra;
import fr.inria.diverse.gfsm.abstr.GFSMAlgebra;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;

public interface GraphvizGFSMAlgebra extends GraphvizFSMAlgebra, PrettyPrintExpressionAlgebra, GFSMAlgebra<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {

	
	
	@Override
	public default RepGraphvizExp transition(final Transition transition) {
		return GraphvizFSMAlgebra.super.transition(transition);
	}

	@Override
	public default RepGraphvizExp gTransition(final GTransition gTransition) {
		return (rep) -> {

			final String guard;
			if (gTransition.getGuard() != null) {
				guard = this.$BE(gTransition.getGuard()).result();
			} else {
				guard = "";
			}

			rep.edges.add(this.$S(gTransition.getFrom()).result(rep) + " -> " + this.$S(gTransition.getTo()).result(rep) + "[label=\""
					+ gTransition.getEvent() + (guard.equals("") ? "" : "\\n") + guard + "\"]");
			return "";
		};
	}

	@Override
	public default RepGraphvizExp gState(final GState gState) {
		return (rep) -> {
			final String stateName = this.state(gState).result(rep);

			final HashMap<String, String> attrs = new HashMap<String, String>();
			if (gState.getInExpression() != null) {

				// FIXME : Line breaks replacement is not so nice...
				final String guard1 = this.$IO(gState.getInExpression()).result().replaceAll("\n", "\\\\n");
				attrs.put("label", "IN:\\n" + guard1);
			}

			if (gState.getOutExpression() != null) {
				final String guard2 = this.$IO(gState.getOutExpression()).result().replaceAll("\n", "\\\\n");
				final String orDefault = attrs.getOrDefault("label", "");
				final String value = orDefault + (orDefault.equals("") ? "" : "\\n") + "OUT:\\n" + guard2;
				attrs.put("label", value);
			}

			rep.addNode(stateName, attrs);
			return stateName;
		};
	}

	@Override
	public default RepGraphvizExp gInitialState(final GInitialState gInitialState) {
		return (rep) -> {
			final String nodeName = this.gState(gInitialState).result(rep);
			final HashMap<String, String> properties = new HashMap<>();
			properties.put("shape", "box");
			properties.put("color", "red");
			rep.addNode(nodeName, properties);
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp gFinalState(final GFinalState gFinalState) {
		return (rep) -> {
			final String nodeName = this.gState(gFinalState).result(rep);
			final HashMap<String, String> properties = new HashMap<>();
			properties.put("shape", "box");
			properties.put("color", "green");
			rep.addNode(nodeName, properties);
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp gFSM(final GFSM gfsm) {
		return (rep) -> {
			rep.name = gfsm.getName();
			gfsm.getTransitions().forEach(t -> this.$T(t).result(rep));
			return rep.show();
		};
	}

}
