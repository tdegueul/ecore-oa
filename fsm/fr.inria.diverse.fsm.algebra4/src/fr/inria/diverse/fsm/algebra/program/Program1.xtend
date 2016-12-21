package fr.inria.diverse.fsm.algebra.program

import fr.inria.diverse.fsm.algebra.DeferProxy
import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.algebra.exprs.GraphvizStateExp
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra
import fsm.FSM
import fsm.FsmPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp

class Program1 {
	def FSM createModel() {

		val resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("fsm", new XMIResourceFactoryImpl());

		// do not remove this, needed to load some context. Side effects...
		val fsmPackage = FsmPackage.eINSTANCE;

		// TODO: Replacing with System.getProperty("user.dir")
		val resource = resSet.getResource(
			URI.createURI("/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.fsm.algebra2/models/FSM1.fsm"), true)
		resource.contents.head as FSM
	}

	def <T, S, F> F make(FSMAlgebra<T, S, F> concreteAlgebra, Class<F> fsmClass, Class<T> transitionClass,
		Class<S> stateClass) {
		val exp = createModel

		// TODO : rebuild the whole algebra meta-programmatically.
		val df = new DeferProxy(concreteAlgebra, fsmClass, transitionClass, stateClass)
		df.fsm(exp)
	}

	def static void main(String[] args) {
		new Program1().execute()
	}

	def execute() {
		val evalAlg = make(new GraphvizFSMAlgebra, typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizStateExp))
		println(evalAlg.evalGraph)
		make(new ExecutableFSMAlgebra(newLinkedList('a', 'b', 'a', 'a', 'b')), typeof(ExecutableExp),
			typeof(ExecutableTransitionExp), typeof(ExecutableStateExp)).execute
	}
}
