package fr.inria.diverse.abstractcompare.algebra.abstr;

import abstractcompare.AbstractCompare;
import abstractcompare.Equal;

public interface AbstractcompareAlgebra<AC, E> {
	public default AC $AC(AbstractCompare<E> abstractCompare) {
		final AC ret;
		if (abstractCompare instanceof Equal) {
			ret = equal((Equal<E>) abstractCompare);
		} else {
			throw new RuntimeException("Unknow AbstractCompare " + abstractCompare);
		}
		return ret;
	}

	AC equal(Equal<E> abstractCompare);
}
