package fr.inria.diverse.gtfsm.algebra.impl;

import java.util.HashMap;

import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.gfsm.impl.GraphvizGFSMAlgebra;
import fr.inria.diverse.gtfsm.algebra.abstr.GTFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.impl.GraphvizTFSMAlgebra;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;

/*
 * TODO : Magically ... the concrete types are all matching since I am the developper of both previously implemented algebras ! 
 * We need to test a case when, for example, the interface used to define F, S or T is not the same for gfsm and tfsm;
 */
public interface GraphvizGTFSMAlgebra extends
		GTFSMAlgebra<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp>,
		GraphvizTFSMAlgebra, GraphvizGFSMAlgebra {

	@Override
	default RepGraphvizExp gtfsm(final GTFSM gtfsm) {
		return (rep) -> {
			rep.name = gtfsm.getName();
			gtfsm.getTransitions().forEach(t -> this.$T(t).result(rep));
			return rep.show();
		};
	}

	@Override
	default RepGraphvizExp gtInitialState(final GTInitialState gtInitialState) {
		return (rep) -> {
			final String nodeName = this.gtState(gtInitialState).result(rep);
			final HashMap<String, String> properties = new HashMap<>();
			properties.put("shape", "box");
			properties.put("color", "red");
			rep.addNode(nodeName, properties);
			return nodeName;
		};
	}

	@Override
	default RepGraphvizExp gtFinalState(final GTFinalState gtFinalState) {
		return (rep) -> {
			final String nodeName = this.gtState(gtFinalState).result(rep);
			final HashMap<String, String> properties = new HashMap<>();
			properties.put("shape", "box");
			properties.put("color", "green");
			rep.addNode(nodeName, properties);
			return nodeName;
		};
	}

	@Override
	default RepGraphvizExp gtState(final GTState gtState) {
		return rep -> {
			final String stateName = GraphvizGTFSMAlgebra.this.state(gtState).result(rep);

			final HashMap<String, String> attrs = new HashMap<String, String>();
			if (gtState.getInExpression() != null) {

				// FIXME : Line breaks replacement is not so nice...
				final String guard1 = GraphvizGTFSMAlgebra.this.$IO(gtState.getInExpression()).result().replaceAll("\n", "\\\\n");
				attrs.put("label", "IN:\\n" + guard1);
			}

			if (gtState.getOutExpression() != null) {
				final String guard2 = GraphvizGTFSMAlgebra.this.$IO(gtState.getOutExpression()).result().replaceAll("\n", "\\\\n");
				final String orDefault1 = attrs.getOrDefault("label", "");
				final String value = orDefault1 + (orDefault1.equals("") ? "" : "\\n") + "OUT:\\n" + guard2;
				attrs.put("label", value);
			}

			if (gtState.getStateguard() != null) {
				final String guard = GraphvizGTFSMAlgebra.this.$CCO(gtState.getStateguard()).result(rep);
				final String orDefault2 = attrs.getOrDefault("label", "");

				attrs.put("label", orDefault2 + (orDefault2.equals("") ? "" : "\\n") + "GUARD:\\n" + guard);
			}
			return stateName;
		};
	}

	@Override
	default RepGraphvizExp gtTransition(final GTTransition gtTransition) {
		return this.gTransition(gtTransition);
	}

}
