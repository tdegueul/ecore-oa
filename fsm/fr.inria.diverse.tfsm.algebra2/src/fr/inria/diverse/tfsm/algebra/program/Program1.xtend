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

		val resource = resSet.getResource(
			URI.createURI("/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.tfsm.algebra2/models/FSM1.tfsm"), true)
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
		df.fsm(exp) as TF
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
		make(new ExecutableTFSMAlgebra(newHashMap(3 -> "a", 7 -> "b", 9 -> "a")), typeof(ExecutableTransitionExp), // T
		typeof(ExecutableStateExp), // S
		typeof(ExecutableExp), // F
		typeof(ExecutableStateExp), // IS extends S 
		typeof(ExecutableStateExp), // FS extends S
		typeof(ExecutableExp), // TF extends F
		typeof(ExecutableTimedStateExp), // TS extends S
		typeof(ExecutableTimedStateExp), // TIS extends TS
		typeof(ExecutableTimedStateExp), // TFS extends TS
		typeof(ExecutableTimedTransitionExp), // TT extends T
		typeof(ExecutableClockExp), // C
		typeof(ExecutableGuardExp), // CCO
		typeof(ExecutableGuardExp), // CC extends CCO
		typeof(ExecutableExp), // CR
		typeof(ExecutableGuardExp), // LCC extends CC
		typeof(ExecutableGuardExp), // LECC EXTENDS CC
		typeof(ExecutableGuardExp), // UCC extends CC
		typeof(ExecutableGuardExp), // UECC EXTENDS CC
		typeof(ExecutableGuardExp), // BCC extends CCO
		typeof(ExecutableGuardExp), // ACC extends BCC
		typeof(ExecutableGuardExp)).execute
	}
}
