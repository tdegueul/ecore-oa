package fr.inria.diverse.gtfsm.algebra.impl;

import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.gfsm.impl.GraphvizGFSMAlgebra;
import fr.inria.diverse.tfsm.algebra.impl.GraphvizTFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import gtfsm.GTFSM;
import gtfsm.GTFinalState;
import gtfsm.GTInitialState;
import gtfsm.GTState;
import gtfsm.GTTransition;
import gtfsm.algebra.GtfsmAlgebra;

/*
 * TODO : Magically ... the concrete types are all matching since I am the developper of both previously implemented algebras ! 
 * We need to test a case when, for example, the interface used to define F, S or T is not the same for gfsm and tfsm;
 */
public interface GraphvizGTFSMAlgebra extends
	GraphvizTFSMAlgebra,
	GraphvizGFSMAlgebra,
	GtfsmAlgebra<RepGraphvizExp, GraphvizExp, RepGraphvizExp, RepGraphvizExp, GraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, GraphvizExp> {

	@Override
	default RepGraphvizExp gTFSM(final GTFSM gtfsm) {
		return (GraphvizRep rep) -> {
			rep.name = gtfsm.getName();
			gtfsm.getTransitions().forEach(t -> $(t).result(rep));
			return rep.show();
		};
	}

	@Override
	default RepGraphvizExp gTInitialState(final GTInitialState gtInitialState) {
		return (GraphvizRep rep) -> {
			String nodeName = gTState(gtInitialState).result(rep);
			rep.addNode(nodeName, ImmutableMap.of("shape", "box", "color", "red"));
			return nodeName;
		};
	}

	@Override
	default RepGraphvizExp gTFinalState(final GTFinalState gtFinalState) {
		return (GraphvizRep rep) -> {
			String nodeName = gTState(gtFinalState).result(rep);
			rep.addNode(nodeName, ImmutableMap.of("shape", "box", "color", "green"));
			return nodeName;
		};
	}

	@Override
	default RepGraphvizExp gTState(final GTState gtState) {
		return (GraphvizRep rep) -> {
			String stateName = GraphvizGTFSMAlgebra.this.state(gtState).result(rep);
			HashMap<String, String> attrs = new HashMap<>();

			if (gtState.getInExpression() != null) {
				// FIXME : Line breaks replacement is not so nice...
				String guard1 = GraphvizGTFSMAlgebra.this.$(gtState.getInExpression()).result().replaceAll("\n", "\\\\n");
				attrs.put("label", "IN:\\n" + guard1);
			}

			if (gtState.getOutExpression() != null) {
				String guard2 = GraphvizGTFSMAlgebra.this.$(gtState.getOutExpression()).result().replaceAll("\n", "\\\\n");
				String orDefault1 = attrs.getOrDefault("label", "");
				String value = orDefault1 + (orDefault1.equals("") ? "" : "\\n") + "OUT:\\n" + guard2;
				attrs.put("label", value);
			}

			if (gtState.getStateguard() != null) {
				String guard = GraphvizGTFSMAlgebra.this.$(gtState.getStateguard()).result(rep);
				String orDefault2 = attrs.getOrDefault("label", "");
				attrs.put("label", orDefault2 + (orDefault2.equals("") ? "" : "\\n") + "GUARD:\\n" + guard);
			}

			return stateName;
		};
	}

	@Override
	default RepGraphvizExp gTTransition(final GTTransition gtTransition) {
		return gTransition(gtTransition);
	}
}
