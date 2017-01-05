package fr.inria.diverse.gtfsm.algebra.program;

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

import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.gtfsm.algebra.impl.ExecutableGTFSMAlgebra;
import fr.inria.diverse.gtfsm.algebra.impl.GraphvizGTFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.State;
import gfsm.GFSM;
import gfsm.GfsmPackage;
import gtfsm.GTFSM;
import gtfsm.GtfsmPackage;
import gtfsm.algebra.GtfsmAlgebra;

public class Program1 {

	private final class ExecutableGtfsmAlgebraImplementation implements ExecutableGTFSMAlgebra {
		private Map<String, Integer> ctx = new HashMap<>();
		private State currentState;
		private Map<Integer, String> timedActions;
		private Integer time = 0;

		private ExecutableGtfsmAlgebraImplementation(final Map<Integer, String> initTimedActions) {
			this.timedActions = initTimedActions;
		}

		@Override
		public Queue<String> getUserinput() {
			return new LinkedList<>(this.timedActions.values());
		}

		@Override
		public void setCtx(final Map<String, Integer> ctx) {
			this.ctx = ctx;

		}

		@Override
		public Map<String, Integer> getCtx() {
			return this.ctx;
		}

		@Override
		public void setCurrentState(final State state) {
			this.currentState = state;

		}

		@Override
		public State getCurrentState() {
			return this.currentState;
		}

		@Override
		public void setTime(final Integer time) {
			this.time = time;

		}

		@Override
		public Map<Integer, String> getTimedActions() {
			return this.timedActions;
		}

		@Override
		public Integer getTime() {
			return this.time;
		}
	}

	public static void main(final String[] args) {
		new Program1().execute();
	}

	private GTFSM createModel(final String progName) {
		final ResourceSetImpl resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("gtfsm", new XMIResourceFactoryImpl());
		final GtfsmPackage gtFsmPackage = GtfsmPackage.eINSTANCE;
		final URI createURI = URI.createURI(progName);
		final Resource resource = resSet.getResource(createURI, true);
		final EList<EObject> contents = resource.getContents();
		return (GTFSM) contents.get(0);

	}

	private GFSM createModel2(final String progName) {
		final ResourceSetImpl resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("gfsm", new XMIResourceFactoryImpl());
		final GfsmPackage gtFsmPackage = GfsmPackage.eINSTANCE;
		final URI createURI = URI.createURI(progName);
		final Resource resource = resSet.getResource(createURI, true);
		final EList<EObject> contents = resource.getContents();
		return (GFSM) contents.get(0);
	}

	private void execute() {

		// TODO: Replacing with System.getProperty("user.dir")
		final String gtfsm1 = "/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.gtfsm.algebra/model/GTFSM1.gtfsm";
		final String gtfsm2 = "/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.gtfsm.algebra/model/GFSM1.gtfsm";
		final String gfsm1 = "/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.gfsm.algebra/model/GFSM1.gfsm";
		System.out.println(this.make(gtfsm1, new GraphvizGTFSMAlgebra() {
		}).result(new GraphvizRep()));

		System.out.println(this.make(gtfsm2, new GraphvizGTFSMAlgebra() {
		}).result(new GraphvizRep()));

		final Map<Integer, String> initTimedActions = new HashMap<Integer, String>();
		initTimedActions.put(0, "t1");
		this.make(gtfsm2, new ExecutableGtfsmAlgebraImplementation(initTimedActions)).execute();

		System.out.println(this.make2(gfsm1, new GraphvizGTFSMAlgebra() {
		}).result(new GraphvizRep()));

		final Map<Integer, String> initTimedActions2 = new HashMap<Integer, String>();
		initTimedActions2.put(0, "t1");
		final ExecutableExp make2 = this.make2(gfsm1, new ExecutableGtfsmAlgebraImplementation(initTimedActions2));
		make2.execute();
	}

	private <A, B, C, D, E, F, G, H, I> F make(final String progName,
			final GtfsmAlgebra<A, B, C, D, E, F, G, H, I> graphvizGFSMAlgebra) {
		final GTFSM model = this.createModel(progName);
		return graphvizGFSMAlgebra.$(model);

	}

	private <A, B, C, D, E, F, G, H, I> F make2(final String progName,
			final GtfsmAlgebra<A, B, C, D, E, F, G, H, I> graphvizGFSMAlgebra) {
		final GFSM model = this.createModel2(progName);
		return graphvizGFSMAlgebra.$(model);
	}

}
