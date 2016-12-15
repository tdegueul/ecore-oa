package fr.inria.diverse.gtfsm.algebra.program;

import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.gtfsm.algebra.abstr.GTFSMAlgebraDispatchDefault;
import fr.inria.diverse.gtfsm.algebra.impl.GraphvizGTFSMAlgebra;

public interface GraphvizGTFSMAlgebraImpl extends GraphvizGTFSMAlgebra, GTFSMAlgebraDispatchDefault<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {

}
