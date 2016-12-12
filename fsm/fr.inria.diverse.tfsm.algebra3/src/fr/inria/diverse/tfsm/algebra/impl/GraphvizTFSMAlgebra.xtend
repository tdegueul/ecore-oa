package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import tfsm.AndClockConstraint
import tfsm.Clock
import tfsm.ClockReset
import tfsm.LowerClockConstraint
import tfsm.LowerEqualClockConstraint
import tfsm.OrClockConstraint
import tfsm.TimedFSM
import tfsm.TimedFinalState
import tfsm.TimedInitialState
import tfsm.TimedState
import tfsm.TimedTransition
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint
import fr.inria.diverse.algebras.expressions.GraphvizExp

class GraphvizTFSMAlgebra extends GraphvizFSMAlgebra implements TFSMAlgebra<GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {

	override timedFSM(TimedFSM timedFSM) {
		[
			this.rep.name = timedFSM.name
			timedFSM.transitions.forEach[e|$T(e).result]
			rep.show
		]
	}

	override timedInitialState(TimedInitialState timedInitialState) {
		[
			val nodename = timedState(timedInitialState).result
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "red", "xlabel" -> nodename))
			nodename
		]
	}

	override timedFinalState(TimedFinalState timedFinalState) {
		[
			val nodename = timedState(timedFinalState).result
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "green", "xlabel" -> nodename))
			nodename
		]
	}

	override timedTransition(TimedTransition timedTransition) {
		[
			this.rep.edges.
				add('''«$S(timedTransition.from).result» -> «$S(timedTransition.to).result» [label="«timedTransition.event»«IF timedTransition.transitionguard != null»\n«$CCO(timedTransition.transitionguard).result»«ENDIF»«IF timedTransition.clockresets != null && !timedTransition.clockresets.empty»\n«FOR reset:timedTransition.clockresets SEPARATOR '\n'»«$CR(reset).result»«ENDFOR»«ENDIF»"]''')
			""
		]
	}

	override timedState(TimedState timedState) {
		[
			val statename = this.state(timedState).result
			val attrs = if (timedState.stateguard != null) {
					val guard = $CCO(timedState.stateguard).result
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

	override andClockConstraint(AndClockConstraint andClockConstraint) {
		['''(«$CCO(andClockConstraint.left).result» AND «$CCO(andClockConstraint.right).result»)''']

	}

	override orClockConstraint(OrClockConstraint orClockConstraint) {
		['''(«$CCO(orClockConstraint.left).result» OR «$CCO(orClockConstraint.right).result»)''']
	}

}
