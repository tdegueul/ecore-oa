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
import tfsm.FSM
import tfsm.FinalState
import tfsm.InitialState
import tfsm.LowerEqualClockConstraint
import tfsm.OrClockConstraint
import tfsm.State
import tfsm.Transition
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint

class GraphvizTFSMAlgebra implements TFSMAlgebra<GraphvizExp> {

	private GraphvizRep rep = new GraphvizRep

	override fsm(FSM fsm) {
		[
			this.rep.name = fsm.name
			fsm.transitions.forEach[e|exp(e).evalGraph]
			rep.show
		]
	}

	override state(State state) {
		[
			val statename = state.name
			val attrs = if (state.stateguard != null) {
					newHashMap("label" -> '''"«exp(state.stateguard).evalGraph»"''')
				} else {
					newHashMap("label" -> '''""''')
				}

			this.rep.addNode(statename, attrs)
			statename
		]
	}

	override transition(Transition transition) {
		[
			this.rep.edges.
				add('''«exp(transition.from).evalGraph» -> «exp(transition.to).evalGraph» [label="«transition.event»«IF transition.transitionguard != null»\n«exp(transition.transitionguard).evalGraph»«ENDIF»«IF transition.clockresets != null && !transition.clockresets.empty»\n«FOR reset:transition.clockresets SEPARATOR '\n'»«exp(reset).evalGraph»«ENDFOR»«ENDIF»"]''')
			""
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

	override lowerClockConstraint(ClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» <=«clockConstraint.clock.name»''']
	}

	override lowerEqualClockConstraint(LowerEqualClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» <= «clockConstraint.clock.name»''']
	}

	override upperClockConstaint(UpperClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» > «clockConstraint.clock.name»''']
	}

	override upperEqualClockConstraint(UpperEqualClockConstraint clockConstraint) {
		['''«clockConstraint.threshold» >= «clockConstraint.clock.name»''']
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

	override finalState(FinalState finalState) {
		[
			val nodename = state(finalState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "green", "xlabel" -> nodename))
			nodename
		]
	}

	override initialState(InitialState initialState) {
		[
			val nodename = state(initialState).evalGraph
			this.rep.addNode(nodename, newHashMap("shape" -> "box", "color" -> "red", "xlabel" -> nodename))
			nodename
		]
	}

}
