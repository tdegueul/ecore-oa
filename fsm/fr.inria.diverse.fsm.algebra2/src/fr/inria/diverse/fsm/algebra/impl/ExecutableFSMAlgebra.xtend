package fr.inria.diverse.fsm.algebra.impl

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp
import java.util.List
import java.util.Queue
import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp

class ExecutableFSMAlgebra implements FSMAlgebra<ExecutableTransitionExp, ExecutableStateExp, ExecutableExp, ExecutableStateExp, ExecutableStateExp> {

	private Queue<String> userinput

	new(Queue<String> userinput) {
		this.userinput = userinput
	}

	override fsm(List<? extends ExecutableStateExp> states, List<? extends ExecutableTransitionExp> transitions,
		ExecutableStateExp initialState, String name) {
		[
			initialState.execute.value.apply(false).execute
		]
	}

	override ExecutableStateExp initialState(String name, ExecutableExp fsm,
		List<? extends ExecutableTransitionExp> outgoingtransitions, List<? extends ExecutableTransitionExp> incommingtransitions) {
		[
			name -> this.state(name, fsm, outgoingtransitions, incommingtransitions).execute.value

		]
	}

	override ExecutableStateExp state(String name, ExecutableExp fsm, List<? extends ExecutableTransitionExp> outgoingtransitions,
		List<? extends ExecutableTransitionExp> incommingtransitions) {
		[

			val (Boolean)=>ExecutableExp effect = [ boolean isFinal |
				[
					val action = userinput.poll
					if (action == null) {
						if (!isFinal)
							println("[ERROR] no action available but final state not reached")
					} else {
						val executedTransitions = outgoingtransitions.map[execute]
						val transitions = executedTransitions.filter[e|e.key == action]
						if (transitions.empty) {
							println("[ERROR] deadlock!")
						} else if (transitions.length == 1) {
							transitions.head.value.
								execute
						} else {
							println('''[ERROR] non deterministic: «transitions.length» outgoing transitions matches event «action»''')
						}
					}
				]
			]
			name -> effect
		]
	}

	override ExecutableStateExp finalState(String name, ExecutableExp fsm,
		List<? extends ExecutableTransitionExp> outgoingtransitions, List<? extends ExecutableTransitionExp> incommingtransitions) {
		[
			val (Boolean)=>ExecutableExp effect = [ Boolean isFinal |
				[
					this.state(name, fsm, outgoingtransitions, incommingtransitions).execute.value.apply(true).execute
				]

			]
			name -> effect
		]
	}

	override transition(ExecutableStateExp from, ExecutableStateExp to, ExecutableExp fsm, String event) {
		[
			event -> [
				println('''transition : event «event» - «from.execute.key» -> «to.execute.key»''')
				to.execute.value.apply(false).execute
			]

		]
	}

}
