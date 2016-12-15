package expression;

public interface ExpressionAlgebra<A, B, C> {

	A booleanAnd(final BooleanAnd booleanAnd);

	A booleanEqual(final BooleanEqual booleanEqual);

	A booleanGreaterThan(final BooleanGreaterThan booleanGreaterThan);

	A booleanOr(final BooleanOr booleanOr);

	B constExpr(final ConstExpr constExpr);

	B intAdd(final IntAdd intAdd);

	C intBlock(final IntBlock intBlock);

	B intMult(final IntMult intMult);

	B intNeg(final IntNeg intNeg);

	C intVarAssign(final IntVarAssign intVarAssign);

	B intVarRef(final IntVarRef intVarRef);
}
