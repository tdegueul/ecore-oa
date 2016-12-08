package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import tfsm.TimedFSM
import tfsm.TimedInitialState
import tfsm.TimedFinalState
import tfsm.TimedTransition
import tfsm.TimedState
import tfsm.Clock
import tfsm.ClockConstraint
import tfsm.ClockReset
import tfsm.LowerClockConstraint
import tfsm.LowerEqualClockConstraint
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint
import tfsm.ClockConstraintOperation
import tfsm.AndClockConstraint
import tfsm.OrClockConstraint
import tfsm.BinaryClockConstraint

class GraphvizTFSMAlgebra extends GraphvizFSMAlgebra implements TFSMAlgebra<GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {

	override timedFSM(TimedFSM timedFSM) {
		this.fsm(timedFSM)
	}

	override timedInitialState(TimedInitialState timedInitialState) {
		[
			val nodename = timedState(timedInitialState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "red", "xlabel" -> nodename))
			nodename
		]
	}

	override timedFinalState(TimedFinalState timedFinalState) {
		[
			val nodename = timedState(timedFinalState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "green", "xlabel" -> nodename))
			nodename
		]
	}

	override timedTransition(TimedTransition timedTransition) {
		[
			this.rep.edges.
				add('''«$S(timedTransition.from).evalGraph» -> «$S(timedTransition.to).evalGraph» [label="«timedTransition.event»«IF timedTransition.transitionguard != null»\n«$CCO(timedTransition.transitionguard).evalGraph»«ENDIF»«IF timedTransition.clockresets != null && !timedTransition.clockresets.empty»\n«FOR reset:timedTransition.clockresets SEPARATOR '\n'»«$CR(reset).evalGraph»«ENDFOR»«ENDIF»"]''')
			""
		]
	}

	override timedState(TimedState timedState) {
		[
			val statename = this.state(timedState).evalGraph
			val attrs = if (timedState.stateguard != null) {
					val guard = $CCO(timedState.stateguard).evalGraph
					newHashMap("label" -> '''"«guard»"''')
				} else {
					newHashMap("label" -> '''""''')
				}

			this.rep.addNode(statename, attrs)
			statename
		]
	}

	override clock(Clock clock) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockConstraint(ClockConstraint clockConstraint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockReset(ClockReset clockReset) {
		['''«clockReset.clock.name» = 0''']
	}

	override lowerClockConstraint(LowerClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» > «clockConstraint.clock.name»''']
	}

	override lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint) {
		['''«lowerEqualClockConstraint.threshold» >= «lowerEqualClockConstraint.clock.name»''']
	}

	override upperClockConstraint(UpperClockConstraint upperClockConstraint) {
		['''«upperClockConstraint.threshold» < «upperClockConstraint.clock.name»''']
	}

	override upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint) {
		['''«upperEqualClockConstraint.threshold» <= «upperEqualClockConstraint.clock.name»''']
	}

	override clockConstraintOperation(ClockConstraintOperation clockConstraintOperation) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override andClockConstraint(AndClockConstraint andClockConstraint) {
		['''(«$CCO(andClockConstraint.left).evalGraph» AND «$CCO(andClockConstraint.right).evalGraph»)''']

	}

	override orClockConstraint(OrClockConstraint orClockConstraint) {
		['''(«$CCO(orClockConstraint.left).evalGraph» OR «$CCO(orClockConstraint.right).evalGraph»)''']
	}

	override binaryClockConstraint(BinaryClockConstraint binaryClockConstraint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
