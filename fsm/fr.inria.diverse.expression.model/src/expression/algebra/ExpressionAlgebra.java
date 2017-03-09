package expression.algebra;

import expression.BooleanAnd;
import expression.BooleanEqual;
import expression.BooleanExpression;
import expression.BooleanGreaterThan;
import expression.BooleanOr;
import expression.ConstExpr;
import expression.IntAdd;
import expression.IntBlock;
import expression.IntExpression;
import expression.IntMult;
import expression.IntNeg;
import expression.IntOperation;
import expression.IntVarAssign;
import expression.IntVarRef;
import java.util.Map;

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

	
	Map<BooleanExpression, A> getBooleanExpressionMemo();
	
	public default A $(final BooleanExpression booleanExpression) {
		final A ret;
		Map<BooleanExpression, A> memo = getBooleanExpressionMemo();
		if(memo.containsKey(booleanExpression)) {
			ret = memo.get(booleanExpression);
		} else {
			if (booleanExpression.eClass().getName().equals("BooleanAnd")) {
				ret = this.booleanAnd((BooleanAnd) booleanExpression);
			} else if (booleanExpression.eClass().getName().equals("BooleanEqual")) {
				ret = this.booleanEqual((BooleanEqual) booleanExpression);
			} else if (booleanExpression.eClass().getName().equals("BooleanGreaterThan")) {
				ret = this.booleanGreaterThan((BooleanGreaterThan) booleanExpression);
			} else if (booleanExpression.eClass().getName().equals("BooleanOr")) {
				ret = this.booleanOr((BooleanOr) booleanExpression);
			} else {
				throw new RuntimeException("Unknow BooleanExpression " + booleanExpression);
		}
			memo.put(booleanExpression, ret);
		}
		return ret;
	}
	
	Map<IntExpression, B> getIntExpressionMemo();
	
	public default B $(final IntExpression intExpression) {
		final B ret;
		Map<IntExpression, B> memo = getIntExpressionMemo();
		if(memo.containsKey(intExpression)) {
			ret = memo.get(intExpression);
		} else {
			if (intExpression.eClass().getName().equals("ConstExpr")) {
				ret = this.constExpr((ConstExpr) intExpression);
			} else if (intExpression.eClass().getName().equals("IntAdd")) {
				ret = this.intAdd((IntAdd) intExpression);
			} else if (intExpression.eClass().getName().equals("IntMult")) {
				ret = this.intMult((IntMult) intExpression);
			} else if (intExpression.eClass().getName().equals("IntNeg")) {
				ret = this.intNeg((IntNeg) intExpression);
			} else if (intExpression.eClass().getName().equals("IntVarRef")) {
				ret = this.intVarRef((IntVarRef) intExpression);
			} else {
				throw new RuntimeException("Unknow IntExpression " + intExpression);
		}
			memo.put(intExpression, ret);
		}
		return ret;
	}
	
	Map<IntOperation, C> getIntOperationMemo();
	
	public default C $(final IntOperation intOperation) {
		final C ret;
		Map<IntOperation, C> memo = getIntOperationMemo();
		if(memo.containsKey(intOperation)) {
			ret = memo.get(intOperation);
		} else {
			if (intOperation.eClass().getName().equals("IntBlock")) {
				ret = this.intBlock((IntBlock) intOperation);
			} else if (intOperation.eClass().getName().equals("IntVarAssign")) {
				ret = this.intVarAssign((IntVarAssign) intOperation);
			} else {
				throw new RuntimeException("Unknow IntOperation " + intOperation);
		}
			memo.put(intOperation, ret);
		}
		return ret;
	}
}