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
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EObject

class DeferProxy<T, S, F> {

	abstract static class InvocHandlerPus<Z> implements InvocationHandler {
		abstract def Z initialize()

		Z initialized

		override invoke(Object proxy, Method method, Object[] args) throws Throwable {
			val target = if (initialized == null) {
					initialized = initialize()
				} else {
					initialized
				}
			method.invoke(target, args)
		}

	}

	interface GetMe<X> {
		def X get()
	}

	protected def <X, Y extends EObject> X init(GetMe<X> param, Y elem, Class<X> clazz) {
		val uri = EcoreUtil.getURI(elem)
		if (!mapObj.containsKey(uri)) {
			val proxy = Proxy.newProxyInstance(clazz.classLoader, #[clazz], new InvocHandlerPus {

				override initialize() {
					param.get
				}

			})

			mapObj.put(uri, proxy)
		}

		mapObj.get(uri) as X
	}

	FSMAlgebra<T, S, F> concreteAlgebra

	// ugly, must get rid of this flatten stuff
	protected Class<F> fsmClass
	protected Class<T> transitionClass
	protected Class<S> stateClass
	protected Map<URI, Object> mapObj = newHashMap()

	new(
		FSMAlgebra<T, S, F> concreteAlgebra,
		Class<F> fsmClass,
		Class<T> transitionClass,
		Class<S> stateClass
	) {
		this.concreteAlgebra = concreteAlgebra
		this.fsmClass = fsmClass
		this.transitionClass = transitionClass
		this.stateClass = stateClass
	}

	def dispatch F fsm(FSM fsm) {
		init(
			new GetMe<F> {

				override get() {
					concreteAlgebra.fsm(fsm.states.map[state], fsm.transitions.map[transition], state(fsm.initialstate),
						fsm.name)
				}
			}, fsm, fsmClass)
	}

	def dispatch T transition(Transition transition) {
		init(
			new GetMe<T> {

				override get() {
					concreteAlgebra.transition(state(transition.from), state(transition.to), fsm(transition.fsm),
						transition.event)
				}
			}, transition, transitionClass)
	}

	def dispatch S state(State state) {
		init(new GetMe<S> {

			override get() {
				concreteAlgebra.state(state.name, fsm(state.fsm), state.outgoingtransitions.map [
					transition
				], state.incommingtransitions.map[transition])
			}
		}, state, stateClass)
	}

	def dispatch S state(InitialState state) {
		init(new GetMe<S> {

			override get() {
				concreteAlgebra.initialState(state.name, fsm(state.fsm), state.outgoingtransitions.map [
					transition
				], state.incommingtransitions.map[transition])
			}
		}, state, stateClass)
	}

	def dispatch S state(FinalState state) {
		init(new GetMe<S> {

			override get() {
				concreteAlgebra.finalState(state.name, fsm(state.fsm), state.outgoingtransitions.map [
					transition
				], state.incommingtransitions.map[transition])
			}
		}, state, stateClass)
	}
}
