package fr.inria.diverse.fsm.algebra.program

import fr.inria.diverse.fsm.algebra.DeferProxy
import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra
import fsm.FSM
import fsm.FsmPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import fr.inria.diverse.fsm.algebra.exprs.GraphvizStateExp

class Program1 {
	def FSM createModel() {

		val resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("fsm", new XMIResourceFactoryImpl());

		// do not remove this, needed to load some context. Side effects...
		val fsmPackage = FsmPackage.eINSTANCE;

		val resource = resSet.getResource(
			URI.createURI("/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.fsm.algebra2/models/FSM1.fsm"), true)
		resource.contents.head as FSM
	}

	def <T, S, F, IS extends S, FS extends S> F make(FSMAlgebra<T, S, F, IS, FS> f, Class<F> fsmClass,
		Class<T> transitionClass, Class<S> stateClass, Class<IS> initialStateClass, Class<FS> finalStateClass) {
		val exp = createModel

		// TODO : rebuild the whole algebra meta-programmatically.
		val df = new DeferProxy(f, fsmClass, transitionClass, stateClass, initialStateClass, finalStateClass)
		df.fsm(exp)
	}

	def static void main(String[] args) {
		new Program1().execute()
	}

	def execute() {
		val evalAlg = make(new GraphvizFSMAlgebra, typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizStateExp),
			typeof(GraphvizStateExp), typeof(GraphvizStateExp))
		println(evalAlg.evalGraph)
//		make(new ExecutableFSMAlgebra(newLinkedList('a', 'b'))).execute
	}
}
