package fr.inria.diverse.fsm.algebra

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fsm.FSM
import fsm.State
import fsm.Transition
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil

class DeferProxy<T, S, F, IS extends S, FS extends S> {

	FSMAlgebra<T, S, F, IS, FS> concreteAlgebra

	private static class LazyProxy implements InvocationHandler {

		Object res = null

		override invoke(Object proxy, Method method, Object[] args) throws Throwable {
			method.invoke(res, args)
		}

	}

	Map<URI, LazyProxy> mapUri = newHashMap()

	new(FSMAlgebra<T, S, F, IS, FS> concreteAlgebra) {
		this.concreteAlgebra = concreteAlgebra
	}

	def F fsm(FSM fsm) {
		val stateId = EcoreUtil.getURI(fsm);
		if (!mapUri.containsKey(stateId)) {
			mapUri.put(stateId, new LazyProxy)
		}
		if (fsm.eContainmentFeature === null || !fsm.eContainmentFeature.containment) {
			val res = concreteAlgebra.fsm(fsm.states.map[s|this.state(s)], fsm.transitions.map[t|this.transition(t)],
				this.state(fsm.initialstate), fsm.name)
			mapUri.get(stateId).res = res
			res

		} else {
			mapUri.get(stateId) as F
		}
	}

	def T transition(Transition transition) {
		val stateId = EcoreUtil.getURI(transition);
		if (!mapUri.containsKey(stateId)) {
			mapUri.put(stateId, new LazyProxy)
		}
		if (transition.eContainmentFeature === null || !transition.eContainmentFeature.containment) {
			val res = concreteAlgebra.transition(this.state(transition.from), this.state(transition.to),
				this.fsm(transition.fsm), transition.event)
			mapUri.get(stateId).res = res
			res

		} else {
			mapUri.get(stateId) as T
		}
	}

	def S state(State state) {
		val stateId = EcoreUtil.getURI(state);
		if (!mapUri.containsKey(stateId)) {
			mapUri.put(stateId, new LazyProxy)
		}
		if (state.eContainmentFeature === null || !state.eContainmentFeature.containment) {
			val res = concreteAlgebra.state(state.name, this.fsm(state.fsm), state.outgoingtransitions.map [ ot |
				this.transition(ot)
			], state.incommingtransitions.map[itr|this.transition(itr)])
			mapUri.get(stateId).res = res
			res

		} else {
			mapUri.get(stateId) as S
		}
	}

}
