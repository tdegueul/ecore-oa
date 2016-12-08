package fr.inria.diverse.tfsm.algebra.abstr

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import java.util.List

// For TimedInitialState and TimedFinalState it has been arbitrarily defined that the "main" class to inherit from what TimedState
interface TFSMAlgebra<T, S, F, C, CCO, CR> extends FSMAlgebra<T, S, F> {

	def F timedFsm(List<? extends S> states, List<? extends T> transitions, S initialState, String name, List<? extends C> clocks)

	def S timedState(String name, F fsm, List<? extends T> outgoingtransitions, List<? extends T> incommingtransitions, CCO stateguard)

	def S timedInitialState(String name, F fsm, List<? extends T> outgoingtransitions, List<? extends T> incommingtransitions,
		CCO stateguard)

	def S timedFinalState(String name, F fsm, List<? extends T> outgoingtransitions, List<? extends T> incommingtransitions,
		CCO stateguard)

	def T timedTransition(S from, S to, F fsm, String event, List<? extends CR> clockresets, CCO transitionguard)

	def C clock(String name, Integer tick)

	def CCO clockConstraintOperation()

	def CCO clockConstraint(Integer threshold, C clock)

	def CR clockReset(C clock)

	def CCO lowerClockConstraint(Integer threshold, C clock)

	def CCO lowerEqualClockConstraint(Integer threshold, C clock)

	def CCO upperClockConstraint(Integer threshold, C clock)

	def CCO upperEqualClockConstraint(Integer threshold, C clock)

	def CCO binaryClockConstraint(CCO left, CCO right)

	def CCO andClockConstraint(CCO left, CCO right)

	def CCO orClockConstraint(CCO left, CCO right)

}
