package fr.inria.diverse.abstractcompare.algebra.impl;

import java.text.MessageFormat;

import abstractcompare.Equal;
import fr.inria.diverse.abstractcompare.algebra.abstr.AbstractcompareAlgebra;
import fr.inria.diverse.abstractcompare.algebra.operation.PrettyPrintExp;

public interface PrettyPrintAbstractcompareAlgebra<E> extends AbstractcompareAlgebra<PrettyPrintExp, E> {

	@Override
	default PrettyPrintExp equal(Equal<E> abstractCompare) {

		return () -> MessageFormat.format("{0} == {1}", abstractCompare.getLeft(), abstractCompare.getRight());
	}

}
