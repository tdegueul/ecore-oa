package fr.inria.diverse.fsm.algebra.impl

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fsm.FSM
import fsm.FinalState
import fsm.InitialState
import fsm.State
import fsm.Transition
import java.util.Queue

interface ExecutableFSMAlgebra extends FSMAlgebra<ExecutableExp, ExecutableExp, ExecutableExp> {

	override transition(Transition transition) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	def Queue<String> getUserinput()

	def State getCurrentState()

	def void setCurrentState(State state)

	override state(State state) {
		[
			val action = userinput.poll
			if (action == null) {
				if (!(this.currentState instanceof FinalState))
					println("[ERROR] no action available but final state not reached")
				this.currentState = null
			} else {
				val res = state.outgoingtransitions.filter[e|e.event == action]
				if (res.length == 1) {
					println('''transition : event «action» - «this.currentState.name» -> «res.get(0).to.name»''')
					this.currentState = res.get(0).to
				} else if (res.length > 1) {
					println('''[ERROR] non deterministic: «res.length» outgoing transitions matches event «action»''')
					this.currentState = null
				} else {
					println("[ERROR] deadlock!")
					this.currentState = null
				}
			}
		]
	}

	override finalState(FinalState finalState) {
		this.state(finalState)
	}

	override initialState(InitialState initialState) {
		this.state(initialState)
	}

	override fsm(FSM fsm) {
		[
			this.currentState = fsm.initialstate
			while (this.currentState != null)
				if (this.currentState instanceof FinalState)
					this.currentState = null
				else
					$(this.currentState).execute
		]
	}

}
