package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import tfsm.AndClockConstraint
import tfsm.BinaryClockConstraint
import tfsm.Clock
import tfsm.ClockConstraint
import tfsm.ClockConstraintOperation
import tfsm.ClockReset
import tfsm.LowerEqualClockConstraint
import tfsm.OrClockConstraint
import tfsm.TimedFSM
import tfsm.TimedFinalState
import tfsm.TimedInitialState
import tfsm.TimedState
import tfsm.TimedTransition
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint

class GraphvizTFSMAlgebra extends GraphvizFSMAlgebra implements TFSMAlgebra<GraphvizExp, GraphvizExp> {

//	private GraphvizRep rep = new GraphvizRep

	override clock(Clock clock) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockConstraint(ClockConstraint clockConstraint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockReset(ClockReset clockReset) {
		['''«clockReset.clock.name» = 0''']
	}

	override lowerClockConstraint(ClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» > «clockConstraint.clock.name»''']
	}

	override lowerEqualClockConstraint(LowerEqualClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» >= «clockConstraint.clock.name»''']
	}

	override upperClockConstaint(UpperClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» < «clockConstraint.clock.name»''']
	}

	override upperEqualClockConstraint(UpperEqualClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» <= «clockConstraint.clock.name»''']
	}

	override clockConstaintOperation(ClockConstraintOperation clockConstraintOperation) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override andClockConstraint(AndClockConstraint andClockConstraint) {
		['''(«expF(andClockConstraint.left).evalGraph» AND «expF(andClockConstraint.right).evalGraph»)''']
	}

	override orClockConstraint(OrClockConstraint orClockConstraint) {
		['''(«expF(orClockConstraint.left).evalGraph» OR «expF(orClockConstraint.right).evalGraph»)''']
	}

	override binaryClockConstraint(BinaryClockConstraint binaryClockConstraint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override timedFSM(TimedFSM timedFSM) {
		this.fsm(timedFSM)
	}

	override timedInitialState(TimedInitialState timedInitialState) {
		[
			val nodename = initialState(timedInitialState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "red", "xlabel" -> nodename))
			nodename
		]
	}

	override timedFinalState(TimedFinalState timedFinalState) {
		[
			val nodename = finalState(timedFinalState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "green", "xlabel" -> nodename))
			nodename
		]
	}

	override timedTransition(TimedTransition timedTransition) {
		[
			this.rep.edges.
				add('''«expF(timedTransition.from).evalGraph» -> «expF(timedTransition.to).evalGraph» [label="«timedTransition.event»«IF timedTransition.transitionguard != null»\n«expF(timedTransition.transitionguard).evalGraph»«ENDIF»«IF timedTransition.clockresets != null && !timedTransition.clockresets.empty»\n«FOR reset:timedTransition.clockresets SEPARATOR '\n'»«expF(reset).evalGraph»«ENDFOR»«ENDIF»"]''')
			""
		]
	}

	override timedState(TimedState timedState) {
		[
			val statename = this.state(timedState).evalGraph
			val attrs = if (timedState.stateguard != null) {
					val guard = expF(timedState.stateguard).evalGraph
					newHashMap("label" -> '''"«guard»"''')
				} else {
					newHashMap("label" -> '''""''')
				}

			this.rep.addNode(statename, attrs)
			statename
		]
	}

}
