package fr.inria.diverse.expression.algebra.abstr;

import expression.BooleanExpression;
import expression.IntExpression;
import expression.IntOperation;

public interface ExpressionAlgebraDispatcher<IE, BE, IO> {

	BE $(BooleanExpression booleanExpression);

	IO $(IntOperation intOperation);

	IE $(IntExpression intExpression);

}