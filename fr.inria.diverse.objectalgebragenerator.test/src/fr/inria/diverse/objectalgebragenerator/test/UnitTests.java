package fr.inria.diverse.objectalgebragenerator.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import fr.inria.diverse.objectalgebragenerator.popup.actions.GenerateAlgebra;

public class UnitTests {

	private static final String ROOT_PATH = "/home/mleduc/dev/ecore/ecore-oa/fr.inria.diverse.objectalgebragenerator.test/";

	@Test
	public void simpleTest() throws Exception {
		testCompare("simpleTest");
	}
	
	@Test
	public void oneClass() throws Exception {
		testCompare("oneClass");
	}
	
	@Test
	public void oneAbstractClass() throws Exception {
		testCompare("oneAbstractClass");
	}
	
	@Test
	public void simpleInheritance1() throws Exception {
		testCompare("SimpleInheritance1");
	}
	
	@Test
	public void simpleInheritance2() throws Exception {
		testCompare("SimpleInheritance2");
	}
	
	@Test
	public void oARootInheritance1() throws Exception {
		testCompare("OARootInheritance1");
	}
	
	

	private void testCompare(String file) throws IOException {
		final URI uri = URI.createURI(ROOT_PATH + "model/" + file + ".ecore");

		final ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		final Resource resource = resourceSet.getResource(uri, true);
		final EPackage ePackage = (EPackage) resource.getContents().get(0);
		final String fileContent = new GenerateAlgebra().process(ePackage);

		final String expected = Files.readAllLines(new File(ROOT_PATH + "results/" + file + ".java").toPath()).stream()
				.collect(Collectors.joining("\n"));
		assertEquals(expected, fileContent);
	}
}
