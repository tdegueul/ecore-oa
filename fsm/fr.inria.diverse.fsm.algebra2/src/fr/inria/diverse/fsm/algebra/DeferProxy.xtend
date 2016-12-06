package fr.inria.diverse.fsm.algebra

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fsm.FSM
import fsm.State
import fsm.Transition
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil

class DeferProxy<T, S, F, IS extends S, FS extends S> {

	FSMAlgebra<T, S, F, IS, FS> concreteAlgebra

	private static class LazyProxy<T> implements InvocationHandler {

		T target

		new(T target) {
			this.target = target
		}

		override invoke(Object proxy, Method method, Object[] args) throws Throwable {
			method.invoke(target, args)
		}

	}

	Map<URI, F> mapFsm = newHashMap()
	Map<URI, T> mapTransition = newHashMap()
	Map<URI, S> mapState = newHashMap()
	Class<F> fsmClass
	Class<T> transitionClass
	Class<S> stateClass

	new(FSMAlgebra<T, S, F, IS, FS> concreteAlgebra, Class<F> fsmClass, Class<T> transitionClass, Class<S> stateClass) {
		this.concreteAlgebra = concreteAlgebra
		this.fsmClass = fsmClass
		this.transitionClass = transitionClass
		this.stateClass = stateClass
	}

	def F fsm(FSM fsm) {
		val fsmId = EcoreUtil.getURI(fsm)
		if (!mapState.containsKey(fsmId)) {
			mapFsm.put(fsmId,
				Proxy.newProxyInstance(fsmClass.classLoader, #[fsmClass],
					new InvocationHandler() {

						override invoke(Object proxy, Method method, Object[] args) throws Throwable {
							method.invoke(
								concreteAlgebra.fsm(fsm.states.map[state], fsm.transitions.map[transition],
									state(fsm.initialstate), fsm.name), args)
						}

					}) as F)
		}

		mapFsm.get(fsmId)
	}

	def T transition(Transition transition) {
		val transitionId = EcoreUtil.getURI(transition)
		if (!mapTransition.containsKey(transitionId)) {
			mapTransition.put(transitionId,
				Proxy.newProxyInstance(transitionClass.classLoader, #[transitionClass],
					new InvocationHandler() {

						override invoke(Object proxy, Method method, Object[] args) throws Throwable {
							method.invoke(
								concreteAlgebra.transition(state(transition.from), state(transition.to),
									fsm(transition.fsm), transition.event), args)
						}

					}) as T)
		}

		mapTransition.get(transitionId)
	}

	def S state(State state) {
		val stateId = EcoreUtil.getURI(state)
		if (!mapTransition.containsKey(stateId)) {
			mapState.put(stateId,
				Proxy.newProxyInstance(stateClass.classLoader, #[stateClass], new InvocationHandler() {

					override invoke(Object proxy, Method method, Object[] args) throws Throwable {
						method.invoke(concreteAlgebra.state(state.name, fsm(state.fsm), state.outgoingtransitions.map [
							transition
						], state.incommingtransitions.map[transition]), args)
					}

				}) as S)
		}

		mapState.get(stateId)
	}

}
