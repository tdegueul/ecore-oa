package fr.inria.diverse.concretecompare.algebra.impl;

import fr.inria.diverse.abstractcompare.algebra.impl.PrettyPrintAbstractcompareAlgebra;
import fr.inria.diverse.abstractcompare.algebra.operation.PrettyPrintExp;
import fr.inria.diverse.abstractvalues.algebra.impl.PrettyPrintAbstractvaluesAlgebra;
import fr.inria.diverse.concretecompare.algebra.abstr.ConcretecompareAlgebra;

public interface PrettyPrintConcretecompareAlgebra extends
		ConcretecompareAlgebra<PrettyPrintExp, fr.inria.diverse.abstractvalues.algebra.operation.PrettyPrintExp, Integer>,
		PrettyPrintAbstractcompareAlgebra<Integer>, PrettyPrintAbstractvaluesAlgebra<Integer> {

}
