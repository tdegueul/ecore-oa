package fr.inria.diverse.gfsm.programs;

import java.util.LinkedList;
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
import gfsm.GFSM;
import gfsm.GfsmPackage;

public class Program1 {
	public static void main(final String[] args) {
		new Program1().execute("GFSM1.gfsm");
	}

	private void execute(String progName) {
		System.out.println(make(new GraphvizGFSMAlgebra(), progName).result());
		Queue<String> userinput = new LinkedList<>();
		make(new ExecutableGFSMAlgebra(userinput), progName).execute();
	}

	private <T, S, F, IE, BE, IO> F make(final GFSMAlgebra<T, S, F, IE, BE, IO> graphvizGFSMAlgebra, String progName) {
		final GFSM model = createModel(progName);
		return graphvizGFSMAlgebra.$F(model);
	}

	private GFSM createModel(String progName) {
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
