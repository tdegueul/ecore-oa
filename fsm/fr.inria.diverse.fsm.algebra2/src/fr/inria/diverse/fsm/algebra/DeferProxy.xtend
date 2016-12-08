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

class DeferProxy<T, S, F, IS extends S, FS extends S> {

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

	protected def <X, Y extends EObject> X init(GetMe<X> param, Y elem) {
		val uri = EcoreUtil.getURI(elem)
		if (!mapObj.containsKey(uri)) {
			val proxy = Proxy.newProxyInstance(fsmClass.classLoader, #[fsmClass], new InvocHandlerPus {

				override initialize() {
					param.get
				}

			})

			mapObj.put(uri, proxy)
		}

		mapObj.get(uri) as X
	}

	FSMAlgebra<T, S, F, IS, FS> concreteAlgebra

	// ugly, must get rid of this flatten stuff
	Class<F> fsmClass
	Class<T> transitionClass
	Class<S> stateClass
	Class<IS> initialStateClass
	Class<FS> finalStateClass
	protected Map<URI, Object> mapObj = newHashMap()

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

	def dispatch F fsm(FSM fsm) {
		init(
			new GetMe<F> {

				override get() {
					concreteAlgebra.fsm(fsm.states.map[state], fsm.transitions.map[transition], state(fsm.initialstate),
						fsm.name)
				}
			}, fsm)
	}

	def dispatch T transition(Transition transition) {
		init(
			new GetMe<T> {

				override get() {
					concreteAlgebra.transition(state(transition.from), state(transition.to), fsm(transition.fsm),
						transition.event)
				}
			}, transition)
	}

	def dispatch S state(State state) {
		init(new GetMe<S> {

			override get() {
				concreteAlgebra.state(state.name, fsm(state.fsm), state.outgoingtransitions.map [
					transition
				], state.incommingtransitions.map[transition])
			}
		}, state)
	}

	def dispatch IS state(InitialState initialState) {

		init(
			new GetMe<IS> {

				override get() {
					concreteAlgebra.initialState(initialState.name, fsm(initialState.fsm), initialState.
						outgoingtransitions.map [
							transition
						], initialState.incommingtransitions.map[transition])
				}
			}, initialState)
	}

	def dispatch FS state(FinalState finalState) {
		init(new GetMe<FS> {

			override get() {
				concreteAlgebra.finalState(finalState.name, fsm(finalState.fsm), finalState.outgoingtransitions.map [
					transition
				], finalState.incommingtransitions.map[transition])
			}
		}, finalState)
	}

}
