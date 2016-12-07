package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableGuardExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableTimedStateExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableTimedTransitionExp
import java.util.List
import java.util.Map
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableClockExp

class ExecutableTFSMAlgebra extends ExecutableFSMAlgebra implements TFSMAlgebra<ExecutableTransitionExp, // T
ExecutableStateExp, // S
ExecutableExp, // F
ExecutableStateExp, // IS extends S 
ExecutableStateExp, // FS extends S
ExecutableExp, // TF extends F
ExecutableTimedStateExp, // TS extends S
ExecutableTimedStateExp, //TIS extends TS
ExecutableTimedStateExp, // TFS extends TS
ExecutableTimedTransitionExp, // TT extends T
ExecutableClockExp, // C
ExecutableGuardExp, // CCO
ExecutableGuardExp, // CC extends CCO
ExecutableExp, // CR
ExecutableGuardExp, // LCC extends CC
ExecutableGuardExp, //LECC EXTENDS CC
ExecutableGuardExp, // UCC extends CC
ExecutableGuardExp, // UECC EXTENDS CC
ExecutableGuardExp, // BCC extends CCO
ExecutableGuardExp, // ACC extends BCC
ExecutableGuardExp> { // OCC extends BCC
	Map<Integer, String> timedActions

	new(Map<Integer, String> userinput) {
		super(newLinkedList())
		this.timedActions = userinput
	}

	override timedFsm(List<ExecutableStateExp> states, List<ExecutableTransitionExp> transitions,
		ExecutableStateExp initialState, String name, List<ExecutableClockExp> clocks) {
//		this.fsm(states, transitions, initialState, name)
		[
			(initialState as ExecutableTimedStateExp).executeWithTime.value.apply(false).apply(0).execute
		]
	}

	override ExecutableTimedStateExp timedState(String name, ExecutableExp fsm,
		List<ExecutableTransitionExp> outgoingtransitions, List<ExecutableTransitionExp> incommingtransitions,
		ExecutableGuardExp stateguard) {
		new ExecutableTimedStateExp {

			override executeWithTime() {
				val Pair<String, (Boolean)=>(Integer)=>ExecutableExp> ret = name ->
					[ isFinal |
						[ time |
							new ExecutableExp {
								override def execute() {
									var timeb = time;
									while (!execute(timeb)) {
										timeb++
									}
								}

								def boolean execute(Integer time) {
									val action = timedActions.get(time)
									val futureActions = timedActions.filter[p1, p2|p1 >= time].size
									val res = if (futureActions == 0) {
											if (!isFinal) {
												println("[ERROR] no action available but final state not reached")
											}
											true
										} else if (action != null) {
											// FIXME : ugly downcast !
											val timedOutgoingTransitions = outgoingtransitions.map [ e |
												e as ExecutableTimedTransitionExp
											]
											val executedWithTimeOutgoingTransitions = timedOutgoingTransitions.map [ a |
												a.executeWithTime(time)
											]
											val nonGardedRes = executedWithTimeOutgoingTransitions.filter [ e |
												e.event == action
											]
											val res = nonGardedRes.filter[e|e.guard]
											if (res.size >
												1) {
												println('''[ERROR] non deterministic: «res.length» outgoing transitions matches event «action»''')
												true
											} else if (res.size ==
												1) {
												println('''transition (time «time»): event «action» - «name» -> «res.head.event»''')
												res.head.execute
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
						]

					]

				ret
			}

			override execute() {
				throw new UnsupportedOperationException("TODO: auto-generated method stub")
			}

		}
	}

	override timedInitialState(String name, ExecutableExp fsm, List<ExecutableTransitionExp> outgoingtransitions,
		List<ExecutableTransitionExp> incommingtransitions, ExecutableGuardExp stateguard) {
		this.timedState(name, fsm, outgoingtransitions, incommingtransitions, stateguard)
	}

	override timedFinalState(String stateName, ExecutableExp fsm, List<ExecutableTransitionExp> outgoingtransitions,
		List<ExecutableTransitionExp> incommingtransitions, ExecutableGuardExp stateguard) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override timedTransition(ExecutableStateExp from, ExecutableStateExp to, ExecutableExp fsm, String eventName,
		List<ExecutableExp> clockresets, ExecutableGuardExp transitionguard) {
		new ExecutableTimedTransitionExp {

			override executeWithTime(Integer time) {
				new fr.inria.diverse.tfsm.algebra.exprs.ExecutableTimedTransitionExp.TimedTransitionData {

					override event() {
						eventName
					}

					override guard() {
						transitionguard.execute
					}

					override execute() {
						(to as ExecutableTimedStateExp).executeWithTime.value.apply(false).apply(time + 1).execute
					}

				}
			}

			override execute() {
				throw new UnsupportedOperationException("TODO: auto-generated method stub")
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

}
