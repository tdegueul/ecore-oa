package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableClockExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableGuardExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableTimedStateExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableTimedStateExp.ExecutableTimedStateData
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableTimedTransitionExp
import java.util.List
import java.util.Map

class ExecutableTFSMAlgebra /*extends ExecutableFSMAlgebra*/ implements TFSMAlgebra<ExecutableTimedTransitionExp, ExecutableTimedStateExp, ExecutableExp, ExecutableClockExp, ExecutableGuardExp, ExecutableExp> {
	Map<Integer, String> timedActions

	private ExecutableFSMAlgebra delegatedAlgebra = new ExecutableFSMAlgebra(newLinkedList())

	new(Map<Integer, String> userinput) {
//		super(newLinkedList())
		this.timedActions = userinput
	}

	override timedFsm(List<? extends ExecutableTimedStateExp> states,
		List<? extends ExecutableTimedTransitionExp> transitions, ExecutableTimedStateExp initialState, String name,
		List<? extends ExecutableClockExp> clocks) {
		[
			val e1 = initialState.execute
//			e1.time = 0
			if (e1 instanceof ExecutableTimedStateData) {
				e1.time = 0
			}
			e1.final = false
			e1.execute().execute
		]
	}

	override ExecutableTimedStateExp timedState(String stateName, ExecutableExp fsm,
		List<? extends ExecutableTimedTransitionExp> outgoingtransitions,
		List<? extends ExecutableTimedTransitionExp> incommingtransitions, ExecutableGuardExp stateguard) {
		[
			new ExecutableTimedStateData {

				var Integer ctime

				Boolean isFinal = false

				override setTime(Integer time) {
					this.ctime = time;
				}

				override name() {
					stateName
				}

				override setFinal(Boolean isFinal) {
					this.isFinal = isFinal
				}

				override execute() {
					new ExecutableExp {

						override execute() {

							while (!executeB()) {
								ctime++
							}
						}

						def boolean executeB() {
							val action = timedActions.get(ctime)
							val futureActions = timedActions.filter[p1, p2|p1 >= ctime].size
							val res = if (futureActions == 0) {
									if (!isFinal) {
										println("[ERROR] no action available but final state not reached")
									}
									true
								} else if (action != null) {
									val nonGardedRes = outgoingtransitions.filter [ e |
										e.event == action
									]

									// FIXME : still some awkward downcasts
									val executed = nonGardedRes.map [ e |
//										if (e instanceof ExecutableTimedTransitionExp)
// FIXME : this is not possible since java does not allow Proxy casting except on declared interface. Should we allow the Delegate to specify sub-interfaces t the initialization ?
										(e as ExecutableTimedTransitionExp).time = ctime;
										e.execute
									]

									val res = executed.filter [ e |
										if(e instanceof ExecutableTimedTransitionExp) e.guard else false
									]
									if (res.size >
										1) {
										println('''[ERROR] non deterministic: «res.length» outgoing transitions matches event «action»''')
										true
									} else if (res.size == 1) {
//										println('''transition (time «ctime»): event «action» - «name» -> «res.head.event»''')
										val h = res.head
										if (h instanceof ExecutableTimedTransitionExp) {
											h.time = ctime
										}
										h.execute
										true
									} else {
										false
									}
								}

							// test state guard !
							val res2 = res && if (stateguard != null && !isFinal && ! stateguard.execute) {
								true
							} else {
								false
							}

							res2
						}

					}
				}

			}
		]
	}

	override timedInitialState(String name, ExecutableExp fsm,
		List<? extends ExecutableTimedTransitionExp> outgoingtransitions,
		List<? extends ExecutableTimedTransitionExp> incommingtransitions, ExecutableGuardExp stateguard) {
		this.timedState(name, fsm, outgoingtransitions, incommingtransitions, stateguard)
	}

	override timedFinalState(String stateName, ExecutableExp fsm,
		List<? extends ExecutableTimedTransitionExp> outgoingtransitions,
		List<? extends ExecutableTimedTransitionExp> incommingtransitions, ExecutableGuardExp stateguard) {
		val tmp = this.timedState(stateName, fsm, outgoingtransitions, incommingtransitions, stateguard)
		if (tmp instanceof ExecutableTimedStateData) {
			tmp.final = true
		}
		tmp
	}

	override timedTransition(ExecutableTimedStateExp from, ExecutableTimedStateExp to, ExecutableExp fsm,
		String eventName, List<? extends ExecutableExp> clockresets, ExecutableGuardExp transitionguard) {
		new ExecutableTimedTransitionExp {

			var Integer ctime

			override execute() {
				println('''transition (time «ctime»): event «eventName» - «from.execute.name» -> «to.execute.name»''')

				val e1 = to.execute

				if (e1 instanceof ExecutableTimedStateData) {
					e1.setTime(ctime + 1)
				}

				e1.execute
			}

			override guard() {
				transitionguard.execute
			}

			override event() {
				eventName
			}

			override setTime(Integer time) {
				this.ctime = time
			}

		}
	}

	override clock(String name, Integer tick) {
		[tick]
	}

	override clockConstraintOperation() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockConstraint(Integer threshold, ExecutableClockExp clock) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockReset(ExecutableClockExp clock) {
		// TODO ???
	}

	override lowerClockConstraint(Integer threshold, ExecutableClockExp clock) {
		[
			threshold < clock.execute
		]
	}

	override lowerEqualClockConstraint(Integer threshold, ExecutableClockExp clock) {
		[
			threshold <= clock.execute
		]
	}

	override upperClockConstraint(Integer threshold, ExecutableClockExp clock) {
		[
			threshold > clock.execute
		]
	}

	override upperEqualClockConstraint(Integer threshold, ExecutableClockExp clock) {
		[
			threshold >= clock.execute
		]
	}

	override binaryClockConstraint(ExecutableGuardExp left, ExecutableGuardExp right) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override andClockConstraint(ExecutableGuardExp left, ExecutableGuardExp right) {
		[
			left.execute && right.execute
		]
	}

	override orClockConstraint(ExecutableGuardExp left, ExecutableGuardExp right) {
		[
			left.execute || right.execute
		]
	}

	override fsm(List<? extends ExecutableTimedStateExp> states,
		List<? extends ExecutableTimedTransitionExp> transitions, ExecutableTimedStateExp initialState, String name) {
		delegatedAlgebra.fsm(states, transitions, initialState, name)
	}

	override initialState(String name, ExecutableExp fsm,
		List<? extends ExecutableTimedTransitionExp> outgoingtransitions,
		List<? extends ExecutableTimedTransitionExp> incommingtransitions) {
			[
				val tmp = delegatedAlgebra.initialState(name, fsm, outgoingtransitions, incommingtransitions).execute
				new ExecutableTimedStateExp.ExecutableTimedStateData {

					Integer ctime

					override setTime(Integer time) {
						this.ctime = time
					}

					override name() {
						name
					}

					override setFinal(Boolean isFinal) {
						tmp.final = isFinal
					}

					override execute() {
						tmp.execute
					}

				}
			]
		}

		override state(String name, ExecutableExp fsm, List<? extends ExecutableTimedTransitionExp> outgoingtransitions,
			List<? extends ExecutableTimedTransitionExp> incommingtransitions) {
			[
				val tmp = delegatedAlgebra.initialState(name, fsm, outgoingtransitions, incommingtransitions).execute
				new ExecutableTimedStateExp.ExecutableTimedStateData {

					Integer ctime

					override setTime(Integer time) {
						this.ctime = time
					}

					override name() {
						name
					}

					override setFinal(Boolean isFinal) {
						tmp.final = isFinal
					}

					override execute() {
						tmp.execute
					}

				}
			]
		}

		override finalState(String name, ExecutableExp fsm,
			List<? extends ExecutableTimedTransitionExp> outgoingtransitions,
			List<? extends ExecutableTimedTransitionExp> incommingtransitions) {
			[
				val tmp = delegatedAlgebra.initialState(name, fsm, outgoingtransitions, incommingtransitions).execute
				new ExecutableTimedStateExp.ExecutableTimedStateData {

					Integer ctime

					override setTime(Integer time) {
						this.ctime = time
					}

					override name() {
						name
					}

					override setFinal(Boolean isFinal) {
						tmp.final = isFinal
					}

					override execute() {
						tmp.execute
					}

				}
			]
		}

		override transition(ExecutableTimedStateExp from, ExecutableTimedStateExp to, ExecutableExp fsm, String event) {
			this.transition(from, to, fsm, event)
		}

	}
	