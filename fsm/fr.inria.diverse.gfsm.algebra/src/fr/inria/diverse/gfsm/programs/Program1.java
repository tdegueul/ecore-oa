package fr.inria.diverse.gfsm.programs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.inria.diverse.gfsm.abstr.GFSMAlgebra;
import fr.inria.diverse.gfsm.impl.ExecutableGFSMAlgebra;
import fr.inria.diverse.gfsm.impl.GraphvizGFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.State;
import gfsm.GFSM;
import gfsm.GfsmPackage;

public class Program1 {

	public static void main(final String[] args) {
		new Program1().execute("GFSM1.gfsm");
	}

	private void execute(final String progName) {
		final Queue<String> initUserInput = new LinkedList<>();
		initUserInput.add("t1");
		System.out.println(this.make(new GraphvizGFSMAlgebra() {
		}, progName).result(new GraphvizRep()));
		this.make(new ExecutableGFSMAlgebra() {

			private Map<String, Integer> ctx = new HashMap<>();
			private State currentState;
			private Queue<String> userinput = initUserInput;

			@Override
			public Queue<String> getUserinput() {
				return this.userinput;
			}

			@Override
			public void setUserInput(final Queue<String> userinput) {
				this.userinput = userinput;

			}

			@Override
			public State getCurrentState() {
				return this.currentState;
			}

			@Override
			public void setCurrentState(final State state) {
				this.currentState = state;

			}

			@Override
			public void setCtx(final Map<String, Integer> ctx) {
				this.ctx = ctx;

			}

			@Override
			public Map<String, Integer> getCtx() {
				return this.ctx;
			}

		}, progName).execute();
	}

	private <T, S, F, IE, BE, IO> F make(final GFSMAlgebra<T, S, F, IE, BE, IO> graphvizGFSMAlgebra,
			final String progName) {
		final GFSM model = this.createModel(progName);
		return graphvizGFSMAlgebra.$(model);
	}

	private GFSM createModel(final String progName) {
		final ResourceSetImpl resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("gfsm", new XMIResourceFactoryImpl());
		final GfsmPackage gFsmPackage = GfsmPackage.eINSTANCE;
		final URI createURI = URI
				.createURI("/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.gfsm.algebra/model/" + progName);
		final Resource resource = resSet.getResource(createURI, true);
		final EList<EObject> contents = resource.getContents();
		return (GFSM) contents.get(0);
	}
}
