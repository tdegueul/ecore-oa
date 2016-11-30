package fr.inria.diverse.fsm.algebra

import fsm.Transition
import fsm.State
import fsm.FinalState
import fsm.InitialState
import fsm.FSM
import java.util.List

class GraphvizRep {
	public List<String> nodes = newArrayList()
	public List<String> edges = newArrayList()
	public String name;

	public def String show() {
		'''
			digraph «name» {
				«FOR node : nodes»
					«node»
				«ENDFOR»
				«FOR edge : edges»
					«edge»
				«ENDFOR»
			}
		'''
	}

}

class GraphvizFSMAlgebra implements FSMAlgebra<GraphvizExp> {

	private GraphvizRep rep = new GraphvizRep;

	override transition(Transition transition) {
		[
			this.rep.edges.
				add('''«exp(transition.from).evalGraph» -> «exp(transition.to).evalGraph» [label=«transition.event»]''')
			""
		]
	}

	override state(State state) {
		['''«state.name»''']
	}

	override finalState(FinalState finalState) {
		[
			this.rep.nodes.add('''«state(finalState).evalGraph» [shape=box, color=green]''')
			'''«state(finalState).evalGraph»'''
		]
	}

	override initialState(InitialState initialState) {
		[
			this.rep.nodes.add('''«state(initialState).evalGraph» [shape=box, color=red]''')
			'''«state(initialState).evalGraph»'''
		]
	}

	override fsm(FSM fsm) {
		[
			this.rep.name = fsm.name
			fsm.transitions.forEach[e|exp(e).evalGraph]
			rep.show
		]
	}

}
