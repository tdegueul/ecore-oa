package fr.inria.diverse.fsm.algebra

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fsm.FSM
import fsm.FinalState
import fsm.InitialState
import fsm.State
import fsm.Transition
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class DeferProxy<T, S, F, IS extends S, FS extends S> {

	FSMAlgebra<T, S, F, IS, FS> concreteAlgebra

	// ugly, must get rid of this flatten stuff
	Class<F> fsmClass
	Class<T> transitionClass
	Class<S> stateClass
	Class<IS> initialStateClass
	Class<FS> finalStateClass

	new(
		FSMAlgebra<T, S, F, IS, FS> concreteAlgebra,
		Class<F> fsmClass,
		Class<T> transitionClass,
		Class<S> stateClass,
		Class<IS> initialStateClass,
		Class<FS> finalStateClass
	) {
		this.concreteAlgebra = concreteAlgebra
		this.fsmClass = fsmClass
		this.transitionClass = transitionClass
		this.stateClass = stateClass
		this.initialStateClass = initialStateClass
		this.finalStateClass = finalStateClass
	}

	def F fsm(FSM fsm) {
		Proxy.newProxyInstance(fsmClass.classLoader, #[fsmClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.fsm(fsm.states.map[state], fsm.transitions.map[transition],
							state(fsm.initialstate), fsm.name), args)
				}

			}) as F
	}

	def T transition(Transition transition) {
		Proxy.newProxyInstance(transitionClass.classLoader, #[transitionClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.transition(state(transition.from), state(transition.to), fsm(transition.fsm),
							transition.event), args)
				}

			}) as T
	}

	def dispatch S state(State state) {
		Proxy.newProxyInstance(stateClass.classLoader, #[stateClass], new InvocationHandler() {

			override invoke(Object proxy, Method method, Object[] args) throws Throwable {
				method.invoke(concreteAlgebra.state(state.name, fsm(state.fsm), state.outgoingtransitions.map [
					transition
				], state.incommingtransitions.map[transition]), args)
			}

		}) as S
	}

	def dispatch IS state(InitialState initialState) {
		Proxy.newProxyInstance(initialStateClass.classLoader, #[initialStateClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.initialState(initialState.name, fsm(initialState.fsm), initialState.
							outgoingtransitions.map [
								transition
							], initialState.incommingtransitions.map[transition]), args)
				}

			}) as IS
	}

	def dispatch FS state(FinalState finalState) {
		Proxy.newProxyInstance(finalStateClass.classLoader, #[finalStateClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.finalState(finalState.name, fsm(finalState.fsm), finalState.outgoingtransitions.
							map [
								transition
							], finalState.incommingtransitions.map[transition]), args)
				}

			}) as FS
	}

}
