package fr.inria.diverse.tfsm.algebra.abstr

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import java.util.List

// For TimedInitialState and TimedFinalState it has been arbitrarily defined that the "main" class to inherit from what TimedState
interface TFSMAlgebra<T, S, F, IS extends S, FS extends S, TF extends F, TS extends S, 
TIS extends TS, TFS extends TS, TT extends T, C, CCO, CC extends CCO, 
CR, LCC extends CC, LECC extends CC, UCC extends CC, UECC extends CC, BCC extends CCO, 
ACC extends BCC, OCC extends BCC> extends FSMAlgebra<T, S, F, IS, FS> {

	def TF timedFsm(List<S> states, List<T> transitions, S initialState, String name, List<C> clocks)

	def TS timedState(String name, F fsm, List<T> outgoingtransitions, List<T> incommingtransitions, CCO stateguard)

	def TIS timedInitialState(String name, F fsm, List<T> outgoingtransitions, List<T> incommingtransitions,
		CCO stateguard)

	def TFS timedFinalState(String name, F fsm, List<T> outgoingtransitions, List<T> incommingtransitions,
		CCO stateguard)

	def TT timedTransition(S from, S to, F fsm, String event, List<CR> clockresets, CCO transitionguard)

	def C clock(String name, Integer tick)

	def CCO clockConstraintOperation()

	def CC clockConstraint(Integer threshold, C clock)

	def CR clockReset(C clock)

	def LCC lowerClockConstraint(Integer threshold, C clock)

	def LECC lowerEqualClockConstraint(Integer threshold, C clock)

	def UCC upperClockConstraint(Integer threshold, C clock)

	def UECC upperEqualClockConstraint(Integer threshold, C clock)

	def BCC binaryClockConstraint(CCO left, CCO right)

	def ACC andClockConstraint(CCO left, CCO right)

	def OCC orClockConstraint(CCO left, CCO right)

}
