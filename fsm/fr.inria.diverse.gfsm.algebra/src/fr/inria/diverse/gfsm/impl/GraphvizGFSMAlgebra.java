package fr.inria.diverse.gfsm.impl;

import java.util.HashMap;

import expression.BooleanAnd;
import expression.BooleanEqual;
import expression.BooleanGreaterThan;
import expression.BooleanOr;
import expression.ConstExpr;
import expression.IntAdd;
import expression.IntBlock;
import expression.IntMult;
import expression.IntNeg;
import expression.IntVarAssign;
import expression.IntVarRef;
import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.expression.algebra.impl.PrettyPrintExpressionAlgebra;
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra;
import fr.inria.diverse.gfsm.abstr.GFSMAlgebra;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;

public class GraphvizGFSMAlgebra extends GraphvizFSMAlgebra
		implements GFSMAlgebra<GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {

	private final PrettyPrintExpressionAlgebra ppea = new PrettyPrintExpressionAlgebra();

	@Override
	public GraphvizExp intVarRef(final IntVarRef intVarRef) {
		return ppea.intVarRef(intVarRef);
	}

	@Override
	public GraphvizExp intNeg(final IntNeg intNeg) {
		return ppea.intNeg(intNeg);
	}

	@Override
	public GraphvizExp intAdd(final IntAdd intAdd) {
		return ppea.intAdd(intAdd);
	}

	@Override
	public GraphvizExp intMult(final IntMult mult) {
		return ppea.intMult(mult);
	}

	@Override
	public GraphvizExp constExpr(final ConstExpr constExpr) {
		return ppea.constExpr(constExpr);
	}

	@Override
	public GraphvizExp intVarAssign(final IntVarAssign intVarAssign) {
		return ppea.intVarAssign(intVarAssign);
	}

	@Override
	public GraphvizExp intBlock(final IntBlock intBlock) {
		return ppea.intBlock(intBlock);
	}

	@Override
	public GraphvizExp booleanEqual(final BooleanEqual booleanEqual) {
		return ppea.booleanEqual(booleanEqual);
	}

	@Override
	public GraphvizExp booleanAnd(final BooleanAnd booleanAnd) {
		return ppea.booleanAnd(booleanAnd);
	}

	@Override
	public GraphvizExp booleanOr(final BooleanOr booleanOr) {
		return ppea.booleanOr(booleanOr);
	}

	@Override
	public GraphvizExp booleanGreaterThan(final BooleanGreaterThan booleanGreaterThan) {
		return ppea.booleanGreaterThan(booleanGreaterThan);
	}

	@Override
	public GraphvizExp gTransition(final GTransition gTransition) {
		return () -> {

			final String guard;
			if (gTransition.getGuard() != null) {
				guard = $BE(gTransition.getGuard()).result();
			} else {
				guard = "";
			}

			rep.edges.add($S(gTransition.getFrom()).result() + " -> " + $S(gTransition.getTo()).result() + "[label=\""
					+ gTransition.getEvent() + (guard.equals("") ? "" : "\\n") + guard + "\"]");
			return "";
		};
	}

	@Override
	public GraphvizExp gState(final GState gState) {
		return () -> {
			final String stateName = state(gState).result();

			final HashMap<String, String> attrs = new HashMap<String, String>();
			if (gState.getInExpression() != null) {

				// FIXME : Line breaks replacement is not so nice...
				final String guard1 = $IO(gState.getInExpression()).result().replaceAll("\n", "\\\\n");
				attrs.put("label", "IN:\\n" + guard1);
			}

			if (gState.getOutExpression() != null) {
				final String guard2 = $IO(gState.getOutExpression()).result().replaceAll("\n", "\\\\n");
				final String orDefault = attrs.getOrDefault("label", "");
				final String value = orDefault + (orDefault.equals("") ? "" : "\\n") + "OUT:\\n" + guard2;
				attrs.put("label", value);
			}

			rep.addNode(stateName, attrs);
			return stateName;
		};
	}

	@Override
	public GraphvizExp gInitialState(final GInitialState gInitialState) {
		return () -> {
			final String nodeName = gState(gInitialState).result();
			final HashMap<String, String> properties = new HashMap<>();
			properties.put("shape", "box");
			properties.put("color", "red");
			rep.addNode(nodeName, properties);
			return nodeName;
		};
	}

	@Override
	public GraphvizExp gFinalState(final GFinalState gFinalState) {
		return () -> {
			final String nodeName = gState(gFinalState).result();
			final HashMap<String, String> properties = new HashMap<>();
			properties.put("shape", "box");
			properties.put("color", "green");
			rep.addNode(nodeName, properties);
			return nodeName;
		};
	}

	@Override
	public GraphvizExp gFSM(final GFSM gfsm) {
		return () -> {
			rep.name = gfsm.getName();
			gfsm.getTransitions().forEach(t -> $T(t).result());
			return rep.show();
		};
	}

}
