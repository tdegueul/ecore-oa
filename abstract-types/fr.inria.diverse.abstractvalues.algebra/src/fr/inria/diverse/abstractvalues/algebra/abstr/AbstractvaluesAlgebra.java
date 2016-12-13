package fr.inria.diverse.abstractvalues.algebra.abstr;

import abstractvalues.ConstExpression;
import abstractvalues.Expression;
import abstractvalues.VarRefExpression;

public interface AbstractvaluesAlgebra<E, F> {

	public default E $E(Expression<F> expression) {
		final E ret;
		if (expression instanceof ConstExpression) {
			ret = constExpression((ConstExpression<F>) expression);
		} else if (expression instanceof VarRefExpression) {
			ret = varRefExpression((VarRefExpression<F>) expression);
		} else {
			throw new RuntimeException("Unknow Expression " + expression);
		}
		return ret;
	}

	E varRefExpression(VarRefExpression<F> expression);

	E constExpression(ConstExpression<F> expression);

}
