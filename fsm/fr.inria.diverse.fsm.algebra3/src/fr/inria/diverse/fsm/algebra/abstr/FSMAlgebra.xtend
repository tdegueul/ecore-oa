package fr.inria.diverse.fsm.algebra.abstr

import fsm.FSM
import fsm.FinalState
import fsm.InitialState
import fsm.State
import fsm.Transition
import org.eclipse.emf.ecore.EObject

interface FSMAlgebra<T, S, F> {
	def T transition(Transition transition)

	def S state(State state)

	def S finalState(FinalState finalState)

	def S initialState(InitialState initialState)

	def F fsm(FSM fsm)

	def T $T(Transition transition) {
		return if (transition instanceof Transition) {
			val tmp = transition(transition)
			tmp
		} else {
			throw new RuntimeException('''unkown EObject «transition»''')
		}
	}

	def S $S(State state) {
		return if (state instanceof InitialState) {
			initialState(state)
		} else if (state instanceof FinalState) {
			finalState(state)
		} else if (state instanceof State) {
			state(state)
		} else {
			throw new RuntimeException('''unkown EObject «state»''')
		}
	}

	def F $F(FSM fsm) {
		return if (fsm instanceof FSM) {
			fsm(fsm)
		} else {
			throw new RuntimeException('''unkown EObject «fsm»''')
		}
	}

}
