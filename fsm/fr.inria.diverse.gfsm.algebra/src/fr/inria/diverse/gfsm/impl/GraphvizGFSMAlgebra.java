package fr.inria.diverse.gfsm.impl;

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
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;

public class GraphvizGFSMAlgebra extends GraphvizFSMAlgebra implements GFSMAlgebra<GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp>
{
	
	
	private PrettyPrintExpressionAlgebra ppea = new PrettyPrintExpressionAlgebra();

	public GraphvizExp intVarRef(IntVarRef intVarRef) {
		return ppea.intVarRef(intVarRef);
	}

	public GraphvizExp intNeg(IntNeg intNeg) {
		return ppea.intNeg(intNeg);
	}

	public GraphvizExp intAdd(IntAdd intAdd) {
		return ppea.intAdd(intAdd);
	}


	public GraphvizExp intMult(IntMult mult) {
		return ppea.intMult(mult);
	}

	public GraphvizExp constExpr(ConstExpr constExpr) {
		return ppea.constExpr(constExpr);
	}

	public GraphvizExp intVarAssign(IntVarAssign intVarAssign) {
		return ppea.intVarAssign(intVarAssign);
	}

	public GraphvizExp intBlock(IntBlock intBlock) {
		return ppea.intBlock(intBlock);
	}


	public GraphvizExp booleanEqual(BooleanEqual booleanEqual) {
		return ppea.booleanEqual(booleanEqual);
	}


	public GraphvizExp booleanAnd(BooleanAnd booleanAnd) {
		return ppea.booleanAnd(booleanAnd);
	}

	public GraphvizExp booleanOr(BooleanOr booleanOr) {
		return ppea.booleanOr(booleanOr);
	}

	public GraphvizExp booleanGreaterThan(
			BooleanGreaterThan booleanGreaterThan) {
		return ppea.booleanGreaterThan(booleanGreaterThan);
	}

	@Override
	public GraphvizExp gTransition(GTransition gTransition) {
		return () -> {
			return "TODO";
		};
	}

	@Override
	public GraphvizExp gState(GState gState) {
		return () -> {
			return "TODO";
		};
	}

	@Override
	public GraphvizExp gInitialState(GInitialState gInitialState) {
		return () -> {
			return "TODO";
		};
	}

	@Override
	public GraphvizExp gFinalState(GFinalState gFinalState) {
		return () -> {
			return "TODO";
		};
	}

}
