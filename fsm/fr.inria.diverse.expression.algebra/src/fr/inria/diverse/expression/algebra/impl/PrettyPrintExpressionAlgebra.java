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
		return () -> MessageFormat.format("-{0}", $(intNeg.getExpression()).result());
	}

	@Override
	public default GraphvizExp intAdd(final IntAdd intAdd) {
		return () ->
			MessageFormat.format("({0} + {1})",
				$(intAdd.getExpression1()).result(),
				$(intAdd.getExpression2()).result());
	}

	@Override
	public default GraphvizExp intMult(final IntMult mult) {
		return () ->
			MessageFormat.format("({0} * {1})",
				$(mult.getExpression1()).result(),
				$(mult.getExpression2()).result());
	}

	@Override
	public default GraphvizExp constExpr(final ConstExpr constExpr) {
		return () -> String.valueOf(constExpr.getValue());
	}

	@Override
	public default GraphvizExp intVarAssign(final IntVarAssign intVarAssign) {
		return () ->
			MessageFormat.format("{0} := {1}",
				intVarAssign.getName(),
				$(intVarAssign.getExpression()).result());
	}

	@Override
	public default GraphvizExp intBlock(final IntBlock intBlock) {
		return () ->
			intBlock.getOperations().stream()
			.map(t -> $(t).result())
			.collect(Collectors.joining("\n"));
	}

	@Override
	public default GraphvizExp booleanEqual(final BooleanEqual booleanEqual) {
		return () ->
			MessageFormat.format("{0} == {1}",
				$(booleanEqual.getExpression1()).result(),
				$(booleanEqual.getExpression2()).result());
	}

	@Override
	public default GraphvizExp booleanAnd(final BooleanAnd booleanAnd) {
		return () ->
			MessageFormat.format("{0} && {1}",
				$(booleanAnd.getBoolExpression1()).result(),
				$(booleanAnd.getBoolExpression2()).result());
	}

	@Override
	public default GraphvizExp booleanOr(final BooleanOr booleanOr) {
		return () ->
			MessageFormat.format("{0} && {1}",
				$(booleanOr.getBoolExpression1()).result(),
				$(booleanOr.getBoolExpression2()).result());
	}

	@Override
	public default GraphvizExp booleanGreaterThan(final BooleanGreaterThan booleanGreaterThan) {
		return () ->
			MessageFormat.format("{0} >= {1}",
				$(booleanGreaterThan.getExpression1()).result(),
				$(booleanGreaterThan.getExpression2()).result());
	}
}
