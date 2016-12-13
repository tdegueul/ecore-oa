package fr.inria.diverse.tfsm.algebra.programs

import fr.inria.diverse.algebras.expressions.RepGraphvizExp
import fr.inria.diverse.fsm.algebra.exprs.CtxExecutableExp
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import fr.inria.diverse.tfsm.algebra.impl.ExecutableTFSMAlgebra
import fr.inria.diverse.tfsm.algebra.impl.GraphvizTFSMAlgebra
import fr.inria.diverse.utils.GraphvizRep
import fsm.State
import java.util.Map
import java.util.Queue
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import tfsm.TfsmPackage
import tfsm.TimedFSM

class Program1 {
	def static void main(String[] args) {
		new Program1().
			execute();
	}

	def execute() {

		val TFSMAlgebra<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp> algGraphviz = new GraphvizTFSMAlgebra() {
		};

		val TFSMAlgebra<ExecutableExp, ExecutableExp, ExecutableExp, Void, Boolean, CtxExecutableExp> algExec = new ExecutableTFSMAlgebra() {

			var Map<Integer, String> timedActions = newHashMap(3 -> "a", 7 -> "b", 9 -> "a");

			override setTimedActions(Map<Integer, String> timedActions) {
				this.timedActions = timedActions
			}

			override getTimedActions() {
				timedActions
			}

			var Integer time = 0;

			override setTime(Integer time) {
				this.time = time;
			}

			override getTime() {
				time
			}

			override getUserinput() {
				throw new UnsupportedOperationException("TODO: auto-generated method stub")
			}

			override setUserInput(Queue<String> userinput) {
				throw new UnsupportedOperationException("TODO: auto-generated method stub")
			}

			var State currentState

			override getCurrentState() {
				this.currentState
			}

			override setCurrentState(State state) {
				this.currentState = state
			}

		};
		println(make(algGraphviz).result(new GraphvizRep))
		val made = make(algExec);
		made.execute
	}

	def <T, S, F, C, CCO, CR> F make(TFSMAlgebra<T, S, F, C, CCO, CR> f) {
		val exp = createModel

		return f.$F(exp)
	}

	def TimedFSM createModel() {
		val resSet = new ResourceSetImpl
		resSet.resourceFactoryRegistry.extensionToFactoryMap.put("tfsm", new XMIResourceFactoryImpl)
		val fsmPackage = TfsmPackage.eINSTANCE
		val createURI = URI.createURI(
			"/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.tfsm.algebra3/model/TFSM1.tfsm")
		val resource = resSet.getResource(createURI, true)
		resource.contents.head as TimedFSM
	}

}
