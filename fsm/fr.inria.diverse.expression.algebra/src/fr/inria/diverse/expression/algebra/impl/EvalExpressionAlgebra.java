package fr.inria.diverse.expression.algebra.impl;

import java.util.Map;
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

public interface EvalExpressionAlgebra extends ExpressionAlgebra<CtxEvalExp<Integer, Boolean>, CtxEvalExp<Integer, Integer>, EvalOpExp<Integer>> {
	@Override
	public default CtxEvalExp<Integer, Integer> intVarRef(final IntVarRef intVarRef) {
		return (Map<String, Integer> ctx) -> {
			if (ctx.containsKey(intVarRef.getName()))
				return Optional.of(ctx.get(intVarRef.getName()));
			else
				return Optional.empty();
		};
	}

	@Override
	public default CtxEvalExp<Integer, Integer> intNeg(final IntNeg intNeg) {
		return (Map<String, Integer> ctx) -> $(intNeg.getExpression()).result(ctx).map(e -> -e);
	}

	@Override
	public default CtxEvalExp<Integer, Integer> intAdd(final IntAdd intAdd) {
		return (Map<String, Integer> ctx) ->
			$(intAdd.getLhs()).result(ctx)
			.flatMap(e1 -> $(intAdd.getRhs()).result(ctx)
			.map(e2 -> e1 + e2));
	}

	@Override
	public default CtxEvalExp<Integer, Integer> intMult(final IntMult intMult) {
		return (Map<String, Integer> ctx) ->
			$(intMult.getLhs()).result(ctx)
			.flatMap(e1 -> $(intMult.getRhs()).result(ctx)
			.map(e2 -> e1 * e2));
	}

	@Override
	public default CtxEvalExp<Integer, Integer> constExpr(final ConstExpr constExpr) {
		return (Map<String, Integer> ctx) -> Optional.of(constExpr.getValue());
	}

	@Override
	public default EvalOpExp<Integer> intVarAssign(final IntVarAssign intVarAssign) {
		return (Map<String, Integer> ctx) -> {
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
		return (Map<String, Integer> ctx) ->
			!intBlock.getOperations().stream()
			.map(operation -> $(operation).eval(ctx))
			.filter(x -> !x)
			.findAny().isPresent();
	}

	@Override
	public default CtxEvalExp<Integer, Boolean> booleanEqual(final BooleanEqual booleanEqual) {
		return (Map<String, Integer> ctx) ->
			$(booleanEqual.getLhs()).result(ctx)
			.flatMap(e1 -> $(booleanEqual.getRhs()).result(ctx)
			.map(e2 -> e1.equals(e2)));
	}

	@Override
	public default CtxEvalExp<Integer, Boolean> booleanAnd(final BooleanAnd booleanAnd) {
		return (Map<String, Integer> ctx) ->
			$(booleanAnd.getLhs()).result(ctx)
			.flatMap(e1 -> $(booleanAnd.getRhs()).result(ctx)
			.map(e2 -> e1 && e2));
	}

	@Override
	public default CtxEvalExp<Integer, Boolean> booleanGreaterThan(final BooleanGreaterThan booleanGreaterThan) {
		return (Map<String, Integer> ctx) ->
			$(booleanGreaterThan.getLhs()).result(ctx)
			.flatMap(e1 -> $(booleanGreaterThan.getRhs()).result(ctx)
			.map(e2 -> e1 > e2));
	}

	@Override
	public default CtxEvalExp<Integer, Boolean> booleanOr(final BooleanOr booleanOr) {
		return (Map<String, Integer> ctx) ->
			$(booleanOr.getLhs()).result(ctx)
			.flatMap(e1 -> $(booleanOr.getRhs()).result(ctx)
			.map(e2 -> e1 || e2));
	}
}
