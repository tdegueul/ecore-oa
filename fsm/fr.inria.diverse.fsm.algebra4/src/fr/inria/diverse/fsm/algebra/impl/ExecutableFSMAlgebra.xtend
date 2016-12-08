package fr.inria.diverse.fsm.algebra.impl

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp
import java.util.List
import java.util.Queue
import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp.ExecutableStateData

class ExecutableFSMAlgebra implements FSMAlgebra<ExecutableTransitionExp, ExecutableStateExp, ExecutableExp> {

	private Queue<String> userinput

	new(Queue<String> userinput) {
		this.userinput = userinput
	}

	override fsm(List<? extends ExecutableStateExp> states, List<? extends ExecutableTransitionExp> transitions,
		ExecutableStateExp initialState, String name) {
		[
			initialState.execute.execute().execute
		]
	}

	override ExecutableStateExp initialState(String name, ExecutableExp fsm,
		List<? extends ExecutableTransitionExp> outgoingtransitions,
		List<? extends ExecutableTransitionExp> incommingtransitions) {
			state(name, fsm, outgoingtransitions, incommingtransitions)
		}

		override ExecutableStateExp state(String stateName, ExecutableExp fsm,
			List<? extends ExecutableTransitionExp> outgoingtransitions,
			List<? extends ExecutableTransitionExp> incommingtransitions) {
				[

					new ExecutableStateData {

						Boolean isFinal

						override name() {
							stateName
						}

						override setFinal(Boolean isFinal) {
							this.isFinal = isFinal
						}

						override execute() {
							[
								val action = userinput.poll
								if (action == null) {
									if (!isFinal)
										println("[ERROR] no action available but final state not reached")
								} else {
									val transitions = outgoingtransitions.filter[e|e.event == action]
									if (transitions.empty) {
										println("[ERROR] deadlock!")
									} else if (transitions.length == 1) {
										transitions.head.execute.
											execute
									} else {
										println('''[ERROR] non deterministic: «transitions.length» outgoing transitions matches event «action»''')
									}
								}
							]
						}

					}
				]
			}

			override ExecutableStateExp finalState(String name, ExecutableExp fsm,
				List<? extends ExecutableTransitionExp> outgoingtransitions,
				List<? extends ExecutableTransitionExp> incommingtransitions) {
					[
						val resState = this.state(name, fsm, outgoingtransitions, incommingtransitions).execute
						resState.final = true
						resState
					]
				}

				override transition(ExecutableStateExp from, ExecutableStateExp to, ExecutableExp fsm,
					String eventName) {
					new ExecutableTransitionExp {

						override event() {
							eventName
						}

						override execute() {
							println('''transition : event «eventName» - «from.execute.name» -> «to.execute.name»''')
							to.execute.execute
						}

					}
				}

			}
			