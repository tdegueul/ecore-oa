package fr.inria.diverse.abstractvalues.algebra.impl;

import abstractvalues.ConstExpression;
import abstractvalues.VarRefExpression;
import fr.inria.diverse.abstractvalues.algebra.abstr.AbstractvaluesAlgebra;
import fr.inria.diverse.abstractvalues.algebra.operation.PrettyPrintExp;

public interface PrettyPrintAbstractvaluesAlgebra<F> extends AbstractvaluesAlgebra<PrettyPrintExp, F> {

	@Override
	default PrettyPrintExp varRefExpression(VarRefExpression<F> expression) {
		return () -> expression.getName() + "<- " + expression.getExpression();
	}

	@Override
	default PrettyPrintExp constExpression(ConstExpression<F> expression) {
		return () -> expression.getValue().toString();
	}

}
