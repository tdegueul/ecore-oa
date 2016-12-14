package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.exprs.CtxExecutableExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import java.util.Map
import tfsm.AndClockConstraint
import tfsm.Clock
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

// find out a solution to overload types defined at an upper level at the level of the arguments (here timedActions vs userinput)
interface ExecutableTFSMAlgebra extends TFSMAlgebra<ExecutableExp, ExecutableExp, ExecutableExp, Void, Boolean, CtxExecutableExp>, ExecutableFSMAlgebra {

	def void setTimedActions(Map<Integer, String> timedActions)

	def Map<Integer, String> getTimedActions()

	def void setTime(Integer time)

	def Integer getTime()

	override timedFSM(TimedFSM timedFSM) {
		[
			this.currentState = timedFSM.initialstate
			while (this.currentState != null) {
				$S(this.currentState).execute
				timedFSM.clocks.forEach[e|e.tick = e.tick + 1]
				time = time + 1
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
			val action = timedActions.get(time)

			// action with time in the future.
			val futureActions = timedActions.filter[p1, p2|p1 >= time].size
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
						$CCO((e as TimedTransition).transitionguard)
				]
				val res = res0.map[e|(e as TimedTransition)]
				val resSize = res.size
				if (resSize > 1) {
					println('''[ERROR] non deterministic: «res.length» outgoing transitions matches event «action»''')
					this.currentState = null
				} else if (resSize == 1) {
					val transition = res.get(
						0)
					println('''transition (time «time»): event «action» - «this.currentState.name» -> «transition.to.name»''')
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
			if (!$CCO((this.currentState as TimedState).stateguard)) {
				println('''[ERROR] deadlock! State guard triggered at time «time» on state «this.currentState.name»''')
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

	override clock(Clock clock) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockReset(ClockReset clockReset) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override lowerClockConstraint(LowerClockConstraint clockConstraint) {
		clockConstraint.clock.tick < clockConstraint.threshold
	}

	override lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint) {
		lowerEqualClockConstraint.clock.tick <= lowerEqualClockConstraint.threshold
	}

	override upperClockConstraint(UpperClockConstraint upperClockConstraint) {
		upperClockConstraint.clock.tick > upperClockConstraint.threshold
	}

	override upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint) {
		upperEqualClockConstraint.clock.tick >= upperEqualClockConstraint.threshold
	}

	override andClockConstraint(AndClockConstraint andClockConstraint) {
		$CCO(andClockConstraint.left) && $CCO(andClockConstraint.right)
	}

	override orClockConstraint(OrClockConstraint orClockConstraint) {
		$CCO(orClockConstraint.left) || $CCO(orClockConstraint.right)
	}

}
