package fr.inria.diverse.concretecompare.algebra.abstr;

import fr.inria.diverse.abstractcompare.algebra.abstr.AbstractcompareAlgebra;
import fr.inria.diverse.abstractvalues.algebra.abstr.AbstractvaluesAlgebra;

public interface ConcretecompareAlgebra<A, B, C> extends AbstractcompareAlgebra<A, C>, AbstractvaluesAlgebra<B, C > {

}
