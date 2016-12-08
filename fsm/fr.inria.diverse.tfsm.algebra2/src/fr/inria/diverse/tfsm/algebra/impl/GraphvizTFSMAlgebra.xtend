package fr.inria.diverse.tfsm.algebra.impl

import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.algebra.exprs.GraphvizStateExp
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra
import java.util.List
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra

class GraphvizTFSMAlgebra extends GraphvizFSMAlgebra implements TFSMAlgebra<GraphvizExp, GraphvizStateExp, GraphvizExp, GraphvizStateExp, GraphvizStateExp, GraphvizExp, GraphvizStateExp, GraphvizStateExp, GraphvizStateExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {

	override timedFsm(List<? extends GraphvizStateExp> states, List<? extends GraphvizExp> transitions, GraphvizStateExp initialState,
		String name, List<? extends GraphvizExp> clocks) {
		this.fsm(states, transitions, initialState, name)
	}

	override timedState(String name, GraphvizExp fsm, List<? extends GraphvizExp> outgoingtransitions,
		List<? extends GraphvizExp> incommingtransitions, GraphvizExp stateguard) {
		this.timedState(name, fsm, outgoingtransitions, incommingtransitions, stateguard)
	}

	override timedInitialState(String name, GraphvizExp fsm, List<? extends GraphvizExp> outgoingtransitions,
		List<? extends GraphvizExp> incommingtransitions, GraphvizExp stateguard) {
		[
			val res = this.initialState(name, fsm, outgoingtransitions, incommingtransitions).evalGraph
			res.attributes.put("xlabel", name)
			res.attributes.put("label", stateguard.evalGraph)
			res
		]
	}

	override timedFinalState(String name, GraphvizExp fsm, List<? extends GraphvizExp> outgoingtransitions,
		List<? extends GraphvizExp> incommingtransitions, GraphvizExp stateguard) {
		this.finalState(name, fsm, outgoingtransitions, incommingtransitions)
	}

	override clock(String name, Integer tick) {
		[
			'''«name»'''
		]
	}

	override clockConstraint(Integer threshold, GraphvizExp clock) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override clockReset(GraphvizExp clock) {
		['''«clock.evalGraph» = 0''']
	}

	override lowerClockConstraint(Integer threshold, GraphvizExp clock) {
		[
			'''«threshold» > «clock.evalGraph»'''
		]
	}

	override lowerEqualClockConstraint(Integer threshold, GraphvizExp clock) {
		[
			'''«threshold» >= «clock.evalGraph»'''
		]
	}

	override upperClockConstraint(Integer threshold, GraphvizExp clock) {
		['''«threshold» < «clock.evalGraph»''']
	}

	override upperEqualClockConstraint(Integer threshold, GraphvizExp clock) {
		[
			'''«threshold» <= «clock.evalGraph»'''
		]
	}

	override binaryClockConstraint(GraphvizExp left, GraphvizExp right) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override andClockConstraint(GraphvizExp left, GraphvizExp right) {
		['''(«left.evalGraph» AND «right.evalGraph»)''']
	}

	override orClockConstraint(GraphvizExp left, GraphvizExp right) {
		['''(«left.evalGraph» OR «right.evalGraph»)''']
	}

	override timedTransition(GraphvizStateExp from, GraphvizStateExp to, GraphvizExp fsm, String event,
		List<? extends GraphvizExp> clockresets, GraphvizExp transitionguard) {
		[
			val evaluatedGuard = transitionguard.evalGraph
			val evaluatedResets = clockresets.
				map[e|e.evalGraph]
			'''«from.evalGraph.name» -> «to.evalGraph.name» [label="«event»\n«evaluatedGuard»«FOR reset : evaluatedResets BEFORE '\\n' SEPARATOR '\\n'»«reset»«ENDFOR»"]'''
		]
	}

	override clockConstraintOperation() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
