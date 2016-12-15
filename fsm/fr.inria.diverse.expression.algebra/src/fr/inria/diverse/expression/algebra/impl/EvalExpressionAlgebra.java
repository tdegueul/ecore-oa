package fr.inria.diverse.expression.algebra.impl;

import java.util.Optional;

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
import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;

public interface EvalExpressionAlgebra
		extends ExpressionAlgebra<CtxEvalExp<Integer, Boolean>, CtxEvalExp<Integer, Integer>, EvalOpExp<Integer>> {

	@Override
	public default CtxEvalExp<Integer, Integer> intVarRef(final IntVarRef intVarRef) {
		return ctx -> {
			Optional<Integer> ret;
			if (ctx.containsKey(intVarRef.getName())) {
				ret = Optional.of(ctx.get(intVarRef.getName()));
			} else {
				ret = Optional.empty();
			}
			return ret;
		};
	}

	@Override
	public default CtxEvalExp<Integer, Integer> intNeg(final IntNeg intNeg) {
		return ctx -> this.$(intNeg.getExpression()).result(ctx).map(e -> -e);
	}

	@Override
	public default CtxEvalExp<Integer, Integer> intAdd(final IntAdd intAdd) {
		return ctx -> this.$(intAdd.getExpression1()).result(ctx)
				.flatMap(e1 -> this.$(intAdd.getExpression2()).result(ctx).map(e2 -> e1 + e2));
	}

	@Override
	public default CtxEvalExp<Integer, Integer> intMult(final IntMult intMult) {
		return ctx -> this.$(intMult.getExpression1()).result(ctx)
				.flatMap(e1 -> this.$(intMult.getExpression2()).result(ctx).map(e2 -> e1 * e2));
	}

	@Override
	public default CtxEvalExp<Integer, Integer> constExpr(final ConstExpr constExpr) {
		return ctx -> Optional.of(constExpr.getValue());
	}

	@Override
	public default EvalOpExp<Integer> intVarAssign(final IntVarAssign intVarAssign) {

		return ctx -> {
			final Optional<Integer> result = EvalExpressionAlgebra.this.$(intVarAssign.getExpression()).result(ctx);
			result.ifPresent(res -> {
				final String name = intVarAssign.getName();
				ctx.put(name, res);
			});
			return result.isPresent();
		};
	}

	@Override
	public default EvalOpExp<Integer> intBlock(final IntBlock intBlock) {
		return ctx -> !intBlock.getOperations().stream().map(operation -> this.$(operation).eval(ctx)).filter(x -> !x)
				.findAny().isPresent();
	}

	@Override
	public default CtxEvalExp<Integer, Boolean> booleanEqual(final BooleanEqual booleanEqual) {
		return ctx -> this.$(booleanEqual.getExpression1()).result(ctx)
				.flatMap(e1 -> this.$(booleanEqual.getExpression2()).result(ctx).map(e2 -> e1.equals(e2)));
	}

	@Override
	public default CtxEvalExp<Integer, Boolean> booleanAnd(final BooleanAnd booleanAnd) {
		return ctx -> this.$(booleanAnd.getBoolExpression1()).result(ctx)
				.flatMap(e1 -> this.$(booleanAnd.getBoolExpression2()).result(ctx).map(e2 -> e1 && e2));
	}

	@Override
	public default CtxEvalExp<Integer, Boolean> booleanGreaterThan(final BooleanGreaterThan booleanGreaterThan) {
		return ctx -> this.$(booleanGreaterThan.getExpression1()).result(ctx)
				.flatMap(e1 -> this.$(booleanGreaterThan.getExpression2()).result(ctx).map(e2 -> e1 > e2));
	}

	@Override
	public default CtxEvalExp<Integer, Boolean> booleanOr(final BooleanOr booleanOr) {
		return ctx -> this.$(booleanOr.getBoolExpression1()).result(ctx)
				.flatMap(e1 -> this.$(booleanOr.getBoolExpression2()).result(ctx).map(e2 -> e1 || e2));
	}

}
