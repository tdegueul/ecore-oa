package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.util.GraphvizRep
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import tfsm.AndClockConstraint
import tfsm.BinaryClockConstraint
import tfsm.Clock
import tfsm.ClockConstraint
import tfsm.ClockConstraintOperation
import tfsm.ClockReset
import tfsm.LowerEqualClockConstraint
import tfsm.OrClockConstraint
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra
import tfsm.TimedFSM
import tfsm.TimedInitialState
import tfsm.TimedFinalState
import tfsm.TimedTransition
import tfsm.TimedState

class GraphvizTFSMAlgebra extends GraphvizFSMAlgebra implements TFSMAlgebra<GraphvizExp> {

	private GraphvizRep rep = new GraphvizRep

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
		['''(«exp(andClockConstraint.left).evalGraph» AND «exp(andClockConstraint.right).evalGraph»)''']
	}

	override orClockConstraint(OrClockConstraint orClockConstraint) {
		['''(«exp(orClockConstraint.left).evalGraph» OR «exp(orClockConstraint.right).evalGraph»)''']
	}

	override binaryClockConstraint(BinaryClockConstraint binaryClockConstraint) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override timedFSM(TimedFSM timedFSM) {
		[
			this.rep.name = timedFSM.name
			timedFSM.transitions.forEach[e|exp(e).evalGraph]
			rep.show
		]
	}

	override timedInitialState(TimedInitialState timedInitialState) {
		[
			val nodename = state(timedInitialState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "red", "xlabel" -> nodename))
			nodename
		]
	}

	override timedFinalState(TimedFinalState timedFinalState) {
		[
			val nodename = state(timedFinalState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "green", "xlabel" -> nodename))
			nodename
		]
	}

	override timedTransition(TimedTransition timedTransition) {
		[
			this.rep.edges.
				add('''«exp(timedTransition.from).evalGraph» -> «exp(timedTransition.to).evalGraph» [label="«timedTransition.event»«IF timedTransition.transitionguard != null»\n«exp(timedTransition.transitionguard).evalGraph»«ENDIF»«IF timedTransition.clockresets != null && !timedTransition.clockresets.empty»\n«FOR reset:timedTransition.clockresets SEPARATOR '\n'»«exp(reset).evalGraph»«ENDFOR»«ENDIF»"]''')
			""
		]
	}

	override timedState(TimedState timedState) {
		[
			val statename = timedState.name
			val attrs = if (timedState.stateguard != null) {
					val guard = exp(timedState.stateguard).evalGraph
					newHashMap("label" -> '''"«guard»"''')
				} else {
					newHashMap("label" -> '''""''')
				}

			this.rep.addNode(statename, attrs)
			statename
		]
	}

}
