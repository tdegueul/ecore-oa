package fr.inria.diverse.fsm.algebra.impl

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.algebra.exprs.GraphvizStateExp
import java.util.List

class GraphvizFSMAlgebra implements FSMAlgebra<GraphvizExp, GraphvizStateExp, GraphvizExp, GraphvizStateExp, GraphvizStateExp> {

	override fsm(List<GraphvizStateExp> states, List<GraphvizExp> transitions, GraphvizStateExp initialState,
		String name) {
		[

			val evalStates = states.map[e|e.evalGraph]
			val evalTransitions = transitions.map[e|e.evalGraph]
			'''
			digraph «name» {
				«FOR state : evalStates»
					«state.name» «FOR attr:state.attributes.entrySet BEFORE '[' SEPARATOR ', ' AFTER ']'  »«attr.key»="«attr.value»"«ENDFOR»
				«ENDFOR»
				«FOR transition : evalTransitions»
					«transition»
				«ENDFOR»
			}'''
		]
	}

	override initialState(String name, GraphvizExp fsm, List<GraphvizExp> outgoingtransitions,
		List<GraphvizExp> incommingtransitions) {
		[
			val stateRes = state(name, fsm, outgoingtransitions, incommingtransitions).evalGraph
			stateRes.attributes.putAll(newHashMap("shape" -> "box", "color" -> "red"))
			stateRes
		]
	}

	override state(String name, GraphvizExp fsm, List<GraphvizExp> outgoingtransitions,
		List<GraphvizExp> incommingtransitions) {
		[
			new GraphvizStateExp.StateData(name)
		]
	}

	override finalState(String name, GraphvizExp fsm, List<GraphvizExp> outgoingtransitions,
		List<GraphvizExp> incommingtransitions) {
		[
			val stateRes = state(name, fsm, outgoingtransitions, incommingtransitions).evalGraph
			stateRes.attributes.putAll(newHashMap("shape" -> "box", "color" -> "green"))
			stateRes
		]
	}

	override transition(GraphvizStateExp from, GraphvizStateExp to, GraphvizExp fsm, String event) {
		['''«from.evalGraph.name» -> «to.evalGraph.name» [label="«event»"]''']
	}

}
