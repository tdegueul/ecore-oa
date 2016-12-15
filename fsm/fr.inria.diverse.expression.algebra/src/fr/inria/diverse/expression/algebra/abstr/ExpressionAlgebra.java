package fr.inria.diverse.expression.algebra.abstr;

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
import expression.IntVarRef;;

/**
 * 
 * @author mleduc
 *
 * @param <E>
 */
public interface ExpressionAlgebra<IE, BE, IO> extends ExpressionAlgebraDispatcher<IE, BE, IO> {

	IE intVarRef(final IntVarRef varRef);

	IE intNeg(final IntNeg neg);

	IE intAdd(final IntAdd add);

	IE intMult(final IntMult mult);

	IE constExpr(final ConstExpr constExpr);

	IO intVarAssign(final IntVarAssign intVarAssign);

	IO intBlock(final IntBlock intBlock);

	BE booleanEqual(final BooleanEqual booleanEqual);

	BE booleanAnd(final BooleanAnd booleanAnd);

	BE booleanOr(final BooleanOr booleanOr);

	BE booleanGreaterThan(final BooleanGreaterThan booleanGreaterThan);

}
