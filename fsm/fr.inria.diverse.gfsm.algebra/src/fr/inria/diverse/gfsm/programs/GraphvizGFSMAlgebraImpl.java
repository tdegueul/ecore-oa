package fr.inria.diverse.gfsm.programs;

import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.gfsm.abstr.GFSMAlgebraDispatcherDefault;
import fr.inria.diverse.gfsm.impl.GraphvizGFSMAlgebra;

public interface GraphvizGFSMAlgebraImpl extends GraphvizGFSMAlgebra, GFSMAlgebraDispatcherDefault<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {

}
