package fr.inria.diverse.expression.algebra.impl;

import java.text.MessageFormat;
import java.util.stream.Collectors;

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
import expression.algebra.ExpressionAlgebra;
import fr.inria.diverse.algebras.expressions.GraphvizExp;

public interface PrettyPrintExpressionAlgebra extends ExpressionAlgebra<GraphvizExp, GraphvizExp, GraphvizExp> {

	@Override
	public default GraphvizExp intVarRef(final IntVarRef intVarRef) {
		return () -> intVarRef.getName();
	}

	@Override
	public default GraphvizExp intNeg(final IntNeg intNeg) {
		return () -> MessageFormat.format("-{0}", this.$(intNeg.getExpression()).result());
	}

	@Override
	public default GraphvizExp intAdd(final IntAdd intAdd) {
		return () -> MessageFormat.format("({0} + {1})", this.$(intAdd.getExpression1()).result(),
				this.$(intAdd.getExpression2()).result());
	}

	@Override
	public default GraphvizExp intMult(final IntMult mult) {
		return () -> MessageFormat.format("({0} * {1})", this.$(mult.getExpression1()).result(),
				this.$(mult.getExpression2()).result());
	}

	@Override
	public default GraphvizExp constExpr(final ConstExpr constExpr) {
		return () -> String.valueOf(constExpr.getValue());
	}

	@Override
	public default GraphvizExp intVarAssign(final IntVarAssign intVarAssign) {
		return () -> MessageFormat.format("{0} := {1}", intVarAssign.getName(),
				this.$(intVarAssign.getExpression()).result());
	}

	@Override
	public default GraphvizExp intBlock(final IntBlock intBlock) {
		return () -> intBlock.getOperations().stream().map(t -> this.$(t).result()).collect(Collectors.joining("\n"));
	}

	@Override
	public default GraphvizExp booleanEqual(final BooleanEqual booleanEqual) {
		return () -> MessageFormat.format("{0} == {1}", this.$(booleanEqual.getExpression1()).result(),
				this.$(booleanEqual.getExpression2()).result());
	}

	@Override
	public default GraphvizExp booleanAnd(final BooleanAnd booleanAnd) {
		return () -> MessageFormat.format("{0} && {1}", this.$(booleanAnd.getBoolExpression1()).result(),
				this.$(booleanAnd.getBoolExpression2()).result());
	}

	@Override
	public default GraphvizExp booleanOr(final BooleanOr booleanOr) {
		return () -> MessageFormat.format("{0} && {1}", this.$(booleanOr.getBoolExpression1()).result(),
				this.$(booleanOr.getBoolExpression2()).result());
	}

	@Override
	public default GraphvizExp booleanGreaterThan(final BooleanGreaterThan booleanGreaterThan) {
		return () -> MessageFormat.format("{0} >= {1}", this.$(booleanGreaterThan.getExpression1()).result(),
				this.$(booleanGreaterThan.getExpression2()).result());
	}

}
