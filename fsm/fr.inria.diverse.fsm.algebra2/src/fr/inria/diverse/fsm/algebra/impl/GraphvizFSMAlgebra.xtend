package fr.inria.diverse.fsm.algebra.impl

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import java.util.List

class GraphvizFSMAlgebra implements FSMAlgebra<GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {

	override fsm(List<GraphvizExp> states, List<GraphvizExp> transitions, GraphvizExp initialState, String name) {
		[
			'''digraph «name» {
			«FOR state : states»
				«state.evalGraph»
			«ENDFOR»
			«FOR transition : transitions»
				«transition.evalGraph»
			«ENDFOR»
			}'''
		]
	}

	override initialState(String name, GraphvizExp fsm, List<GraphvizExp> outgoingtransitions,
		List<GraphvizExp> incommingtransitions) {
		state(name, fsm, outgoingtransitions, incommingtransitions)
	}

	override state(String name, GraphvizExp fsm, List<GraphvizExp> outgoingtransitions,
		List<GraphvizExp> incommingtransitions) {
		// TODO : integrate initial state specificity
		[name]
	}

	override finalState(String name, GraphvizExp fsm, List<GraphvizExp> outgoingtransitions,
		List<GraphvizExp> incommingtransitions) {
		// TODO : integrate final state specificity
		[val stateRes = state(name, fsm, outgoingtransitions, incommingtransitions) '''«stateRes»Final''']
	}

	override transition(GraphvizExp from, GraphvizExp to, GraphvizExp fsm, String event) {
		['''«from.evalGraph» -> «to.evalGraph»''']
	}

}
