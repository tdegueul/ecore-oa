package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.algebras.expressions.RepGraphvizExp
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

interface GraphvizTFSMAlgebra extends GraphvizFSMAlgebra, TFSMAlgebra<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp> {

	override RepGraphvizExp timedFSM(TimedFSM timedFSM) {
		[ rep |
			rep.name = timedFSM.name
			timedFSM.transitions.forEach[e|$(e).result(rep)]
			rep.show
		]
	}

	override timedInitialState(TimedInitialState timedInitialState) {
		[ rep |
			val nodename = timedState(timedInitialState).result(rep)
			rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "red", "xlabel" -> nodename))
			nodename
		]
	}

	override timedFinalState(TimedFinalState timedFinalState) {
		[ rep |
			val nodename = timedState(timedFinalState).result(rep)
			rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "green", "xlabel" -> nodename))
			nodename
		]
	}

	override timedTransition(TimedTransition timedTransition) {
		[ rep |
			rep.edges.
				add('''«$(timedTransition.from).result(rep)» -> «$(timedTransition.to).result(rep)» [label="«timedTransition.event»«IF timedTransition.transitionguard != null»\n«$(timedTransition.transitionguard).result(rep)»«ENDIF»«IF timedTransition.clockresets != null && !timedTransition.clockresets.empty»\n«FOR reset:timedTransition.clockresets SEPARATOR '\n'»«$(reset).result(rep)»«ENDFOR»«ENDIF»"]''')
			""
		]
	}

	override timedState(TimedState timedState) {
		[ rep |
			val statename = this.state(timedState).result(rep)
			val attrs = if (timedState.stateguard != null) {
					val guard = $(timedState.stateguard).result(rep)
					newHashMap("label" -> guard)
				} else {
					newHashMap("label" -> '')
				}

			rep.addNode(statename, attrs)
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
		[rep|'''(«$(andClockConstraint.left).result(rep)» AND «$(andClockConstraint.right).result(rep)»)''']

	}

	override orClockConstraint(OrClockConstraint orClockConstraint) {
		[rep|'''(«$(orClockConstraint.left).result(rep)» OR «$(orClockConstraint.right).result(rep)»)''']
	}

}
