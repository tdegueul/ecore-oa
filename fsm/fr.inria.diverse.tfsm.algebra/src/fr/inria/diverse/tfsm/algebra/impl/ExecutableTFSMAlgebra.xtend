package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import java.util.Map
import tfsm.AndClockConstraint
import tfsm.BinaryClockConstraint
import tfsm.Clock
import tfsm.ClockConstraint
import tfsm.ClockConstraintOperation
import tfsm.ClockReset
import tfsm.LowerClockConstraint
import tfsm.LowerEqualClockConstraint
import tfsm.OrClockConstraint
import tfsm.TimedFSM
import tfsm.TimedFinalState
import tfsm.TimedInitialState
import tfsm.TimedState
import tfsm.TimedTransition
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint

class ExecutableTFSMAlgebra extends ExecutableFSMAlgebra implements TFSMAlgebra<ExecutableExp, Boolean> {

	Map<Integer, String> timedActions

	Integer time

	new(Map<Integer, String> timedActions) {
		super(newLinkedList())
		this.timedActions = timedActions
	}

	override Boolean lowerClockConstraint(LowerClockConstraint operation) {
		operation.clock.tick < operation.threshold
	}

	override Boolean upperClockConstraint(UpperClockConstraint operation) {
		operation.clock.tick > operation.threshold
	}

	override Boolean upperEqualClockConstraint(UpperEqualClockConstraint operation) {
		operation.clock.tick >= operation.threshold
	}

	override Boolean lowerEqualClockConstraint(LowerEqualClockConstraint operation) {
		operation.clock.tick <= operation.threshold
	}

	override Boolean andClockConstraint(AndClockConstraint operation) {
		$F(operation.left) && $F(operation.right)
	}

	override orClockConstraint(OrClockConstraint operation) {
		$F(operation.left) || $F(operation.right)
	}

	override clock(Clock clock) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockConstraint(ClockConstraint clockConstraint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockReset(ClockReset clockReset) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockConstraintOperation(ClockConstraintOperation clockConstraintOperation) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override binaryClockConstraint(BinaryClockConstraint binaryClockConstraint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override timedFSM(TimedFSM timedFSM) {
		[
			this.currentState = timedFSM.initialstate
			this.time = 0
			while (this.currentState != null) {
				val exp = $E(this.currentState)
				exp.execute
				timedFSM.clocks.forEach[e|e.tick = e.tick + 1]
				this.time++
			}
		]
	}

	override timedInitialState(TimedInitialState timedInitialState) {
		this.timedState(timedInitialState)
	}

	override timedFinalState(TimedFinalState timedFinalState) {
		this.timedState(timedFinalState)
	}

	override timedTransition(TimedTransition timedTransition) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override timedState(TimedState state) {
		[
			val action = this.timedActions.get(this.time)

			// action with time in the future.
			val futureActions = this.timedActions.filter[p1, p2|p1 >= this.time].size
			if (futureActions == 0) {
				if (!(this.currentState instanceof TimedFinalState)) {
					println("[ERROR] no action available but final state not reached")
					this.currentState = null
				}
			} else if (action != null) {
				val nonGardedRes = state.outgoingtransitions.filter[e|e.event == action]
				// aweful downcast !!
				val res0 = nonGardedRes.filter [ e |
					e instanceof TimedTransition && (e as TimedTransition).transitionguard == null ||
						$F((e as TimedTransition).transitionguard)
				]
				val Iterable<TimedTransition> res = res0.map[e|(e as TimedTransition)]
				if (res.size > 1) {
					println('''[ERROR] non deterministic: «res.length» outgoing transitions matches event «action»''')
					this.currentState = null
				} else if (res.size == 1) {
					val transition = res.get(
						0)
					println('''transition (time «this.time»): event «action» - «this.currentState.name» -> «transition.to.name»''')
					transition.clockresets.forEach[e|e.clock.tick = 0]
					println('''
						clocks :
						«FOR clock : (state.eContainer as TimedFSM).clocks»
							- clock «clock.name» = «clock.tick»
						«ENDFOR»
					''')
					this.currentState = transition.to
				}
			}
			if (!$F((this.currentState as TimedState).
				stateguard)) {
				println('''[ERROR] deadlock! State guard triggered at time «this.time» on state «this.currentState.name»''')
				println('''
					clocks :
					«FOR clock : (state.eContainer as TimedFSM).clocks»
						- clock «clock.name» = «clock.tick»
					«ENDFOR»
				''')

				this.currentState = null
			}
		]
	}
}
