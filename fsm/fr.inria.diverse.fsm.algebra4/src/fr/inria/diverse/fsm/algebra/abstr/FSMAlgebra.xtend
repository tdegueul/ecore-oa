package fr.inria.diverse.fsm.algebra.abstr

import java.util.List

interface FSMAlgebra<T, S, F> {
	def F fsm(List<? extends S> states, List<? extends T> transitions, S initialState, String name)

	def S initialState(String name, F fsm, List<? extends T> outgoingtransitions,
		List<? extends T> incommingtransitions)

	def S state(String name, F fsm, List<? extends T> outgoingtransitions, List<? extends T> incommingtransitions)

	def S finalState(String name, F fsm, List<? extends T> outgoingtransitions, List<? extends T> incommingtransitions)

	def T transition(S from, S to, F fsm, String event)

}
