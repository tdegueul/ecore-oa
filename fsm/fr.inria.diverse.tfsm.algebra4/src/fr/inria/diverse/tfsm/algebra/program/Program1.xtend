package fr.inria.diverse.tfsm.algebra.program

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.algebra.exprs.GraphvizStateExp
import fr.inria.diverse.tfsm.algebra.TimedDeferProxy
import fr.inria.diverse.tfsm.algebra.impl.ExecutableTFSMAlgebra
import fr.inria.diverse.tfsm.algebra.impl.GraphvizTFSMAlgebra
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import tfsm.TfsmPackage
import tfsm.TimedFSM
import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableTimedStateExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableTimedTransitionExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableClockExp
import fr.inria.diverse.tfsm.algebra.exprs.ExecutableGuardExp
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra

class Program1 {
	def TimedFSM createModel() {

		val resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tfsm", new XMIResourceFactoryImpl());

		// do not remove this, needed to load some context. Side effects...
		val fsmPackage = TfsmPackage.eINSTANCE;

		// TODO: Replacing with System.getProperty("user.dir")
		val resource = resSet.getResource(
			URI.createURI("/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.tfsm.algebra2/models/FSM1.tfsm"), true)
		resource.contents.head as TimedFSM
	}

	def <T, S, F, C, CCO, CR> F make(
		TFSMAlgebra<T, S, F, C, CCO, CR> concreteAlgebra,
		Class<T> transitionClass,
		Class<S> stateClass,
		Class<F> fsmClass,
		Class<C> clockClass,
		Class<CCO> clockConstraintOperationClass,
		Class<CR> clockReset
	) {
		val TimedFSM exp = createModel

		val df = new TimedDeferProxy(
			concreteAlgebra,
			transitionClass,
			stateClass,
			fsmClass,
			clockClass,
			clockConstraintOperationClass,
			clockReset
		)
		df.fsm(exp)
	}

	def static void main(String[] args) {
		new Program1().execute()
	}

	def execute() {
		val evalAlg = make(new GraphvizTFSMAlgebra, typeof(GraphvizExp), typeof(GraphvizStateExp), typeof(GraphvizExp),
			typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizExp))
		println(evalAlg.evalGraph)
		make(new ExecutableTFSMAlgebra(newHashMap(3 -> "a", 7 -> "b", 9 -> "a")), typeof(ExecutableTimedTransitionExp),
			typeof(ExecutableTimedStateExp), typeof(ExecutableExp), typeof(ExecutableClockExp), typeof(ExecutableGuardExp),
			typeof(ExecutableExp)).execute
	}
}
