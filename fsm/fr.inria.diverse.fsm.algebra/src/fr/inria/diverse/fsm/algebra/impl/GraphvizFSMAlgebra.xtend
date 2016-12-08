package fr.inria.diverse.fsm.algebra.impl

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.util.GraphvizRep
import fsm.FSM
import fsm.FinalState
import fsm.InitialState
import fsm.State
import fsm.Transition

class GraphvizFSMAlgebra implements FSMAlgebra<GraphvizExp> {

	protected GraphvizRep rep = new GraphvizRep;

	override fsm(FSM fsm) {
		[
			this.rep.name = fsm.name
			fsm.transitions.forEach[e|$E(e).evalGraph]
			rep.show
		]
	}
	
	override transition(Transition transition) {
		[
			this.rep.edges.
				add('''«$E(transition.from).evalGraph» -> «$E(transition.to).evalGraph» [label=«transition.event»]''')
			""
		]
	}

	override state(State state) {
		[
		'''«state.name»'''
		]
	}

	override finalState(FinalState finalState) {
		[
			val nodename = state(finalState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "green"))
			nodename
		]
	}

	override initialState(InitialState initialState) {
		[
			val nodename = state(initialState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "red"))
			nodename
		]
	}


}
