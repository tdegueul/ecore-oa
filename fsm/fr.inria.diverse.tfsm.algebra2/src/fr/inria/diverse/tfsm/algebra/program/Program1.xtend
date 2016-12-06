package fr.inria.diverse.tfsm.algebra.program

import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp
import fr.inria.diverse.fsm.algebra.exprs.GraphvizStateExp
import fr.inria.diverse.tfsm.algebra.TimedDeferProxy
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import fr.inria.diverse.tfsm.algebra.impl.GraphvizTFSMAlgebra
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import tfsm.TfsmPackage
import tfsm.TimedFSM

class Program1 {
	def TimedFSM createModel() {

		val resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tfsm", new XMIResourceFactoryImpl());

		// do not remove this, needed to load some context. Side effects...
		val fsmPackage = TfsmPackage.eINSTANCE;

		val resource = resSet.getResource(
			URI.createURI("/home/mleduc/workspace-gemoc-tuto/fr.inria.diverse.tfsm.algebra2/models/FSM1.tfsm"), true)
		resource.contents.
			head as TimedFSM
	}

	def <T, S, F, IS extends S, FS extends S, TF extends F, TS extends S, TIS extends TS, TFS extends TS, TT extends T, C, CCO, CC extends CCO, CR, LCC extends CC, LECC extends CC, UCC extends CC, UECC extends CC, BCC extends CCO, ACC extends BCC, OCC extends BCC> TF make(
		TFSMAlgebra<T, S, F, IS, FS, TF, TS, TIS, TFS, TT, C, CCO, CC, CR, LCC, LECC, UCC, UECC, BCC, ACC, OCC> concreteAlgebra,
		Class<T> transitionClass,
		Class<S> stateClass,
		Class<F> fsmClass,
		Class<IS> initialStateClass,
		Class<FS> finalStateClass,
		Class<TF> timedFsmClass,
		Class<TS> timedStateClass,
		Class<TIS> timedInitalStateClass,
		Class<TFS> timedFinalStateClass,
		Class<TT> timedTransitionClass,
		Class<C> clockClass,
		Class<CCO> clockConstraintOperationClass,
		Class<CC> clockConstraintClass,
		Class<CR> clockReset,
		Class<LCC> lowerClockConstraintClass,
		Class<LECC> lowerEqualClockConstraintClass,
		Class<UCC> upperClockConstraintClass,
		Class<UECC> upperEqualClockConstraintClass,
		Class<BCC> binaryClockConstraintClass,
		Class<ACC> andClockConstraintClass,
		Class<OCC> orClockConstraintClass
	) {
		val TimedFSM exp = createModel

		// TODO : rebuild the whole algebra meta-programmatically.
		val df = new TimedDeferProxy(concreteAlgebra, transitionClass, stateClass, fsmClass, initialStateClass,
			finalStateClass, timedFsmClass, timedStateClass, timedInitalStateClass, timedFinalStateClass,
			timedTransitionClass, clockClass, clockConstraintOperationClass, clockConstraintClass, clockReset,
			lowerClockConstraintClass, lowerEqualClockConstraintClass, upperClockConstraintClass,
			upperEqualClockConstraintClass, binaryClockConstraintClass, andClockConstraintClass, orClockConstraintClass)
		df.fsm(exp) as TF // FIXME cast shouldn't be there!
	}

	def static void main(String[] args) {
		new Program1().execute()
	}

	def execute() {
		val evalAlg = make(new GraphvizTFSMAlgebra, typeof(GraphvizExp), typeof(GraphvizStateExp), typeof(GraphvizExp),
			typeof(GraphvizStateExp), typeof(GraphvizStateExp), typeof(GraphvizExp), typeof(GraphvizStateExp),
			typeof(GraphvizStateExp), typeof(GraphvizStateExp), typeof(GraphvizExp), typeof(GraphvizExp),
			typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizExp),
			typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizExp), typeof(GraphvizExp))
		println(evalAlg.evalGraph)
//		make(new ExecutableFSMAlgebra(newLinkedList('a', 'b', 'a', 'a', 'b')), typeof(ExecutableExp),
//			typeof(ExecutableTransitionExp), typeof(ExecutableStateExp), typeof(ExecutableStateExp),
//			typeof(ExecutableStateExp)).execute
	}
}
