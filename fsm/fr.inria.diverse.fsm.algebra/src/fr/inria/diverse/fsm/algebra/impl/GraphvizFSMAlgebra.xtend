package fr.inria.diverse.fsm.algebra.impl

import fr.inria.diverse.algebras.expressions.RepGraphvizExp
import fsm.FSM
import fsm.FinalState
import fsm.InitialState
import fsm.State
import fsm.Transition
import fsm.algebra.FsmAlgebra

interface GraphvizFSMAlgebra extends FsmAlgebra<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp> {

	override transition(Transition transition) {
		[ rep |
			rep.edges.
				add('''«$(transition.from).result(rep)» -> «$(transition.to).result(rep)» [label=«transition.event»]''')
			""
		]
	}

	override state(State state) {
		[
			'''«state.name»'''
		]
	}

	override finalState(FinalState finalState) {
		[ rep |
			val nodename = state(finalState).result(rep)
			rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "green"))
			nodename
		]
	}

	override initialState(InitialState initialState) {
		[ rep |
			val nodename = state(initialState).result(rep)
			rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "red"))
			nodename
		]
	}

	override fSM(FSM fsm) {
		[ rep |
			rep.name = fsm.name
			fsm.transitions.forEach[e|$(e).result(rep)]
			rep.show
		]
	}

}
