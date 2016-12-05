package fr.inria.diverse.fsm.algebra.abstr

import fsm.FSM
import fsm.FinalState
import fsm.InitialState
import fsm.State
import fsm.Transition
import org.eclipse.emf.ecore.EObject

interface FSMAlgebra<E> {
	def E transition(Transition transition)

	def E state(State state)

	def E finalState(FinalState finalState)

	def E initialState(InitialState initialState)

	def E fsm(FSM fsm)

	def E expE(EObject eObject) {
		return if (eObject instanceof Transition) {
			val tmp = transition(eObject)
			tmp
		} else if (eObject instanceof InitialState) {
			initialState(eObject)
		} else if (eObject instanceof FinalState) {
			finalState(eObject)
		} else if (eObject instanceof State) {
			state(eObject)
		} else if (eObject instanceof FSM) {
			fsm(eObject)
		} else {
			throw new RuntimeException('''unkown EObject «eObject»''')
		}
	}
}
