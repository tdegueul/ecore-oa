package fr.inria.diverse.expression.algebra.program;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.Maps;

import expression.BooleanExpression;
import expression.ExpressionPackage;
import expression.IntExpression;
import expression.IntOperation;
import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;
import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.expression.algebra.impl.EvalExpressionAlgebra;
import fr.inria.diverse.expression.algebra.impl.PrettyPrintExpressionAlgebra;

public class Program1 {

	private final class PrettyPrintExpressionAlgebraImplementation implements PrettyPrintExpressionAlgebra {
		public PrettyPrintExpressionAlgebraImplementation() {
			
		}

		@Override
		public Map<BooleanExpression, GraphvizExp> getBooleanExpressionMemo() {
			return Maps.newHashMap();
		}

		@Override
		public Map<IntExpression, GraphvizExp> getIntExpressionMemo() {
			return Maps.newHashMap();
		}

		@Override
		public Map<IntOperation, GraphvizExp> getIntOperationMemo() {
			return Maps.newHashMap();
		}
	}

	public static void main(final String[] args) {
		new Program1().executeIntExpression("Expression1.expression");
		System.out.println("----------");
		new Program1().executeIntOperation("Expression2.expression");
		System.out.println("----------");
		new Program1().executeBoolExpression("Expression3.expression");

	}

	private void executeBoolExpression(final String progName) {
		final BooleanExpression model = (BooleanExpression) this.createModel(progName);
		System.out.println(new PrettyPrintExpressionAlgebraImplementation().$(model).result());
		final Map<String, Integer> ctx = new HashMap<>();
		ctx.put("a", 200);
		ctx.put("b", 200);
		System.out.println(new EvalExpressionAlgebra() {
			@Override
			public Map<BooleanExpression, CtxEvalExp<Integer, Boolean>> getBooleanExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntExpression, CtxEvalExp<Integer, Integer>> getIntExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntOperation, EvalOpExp<Integer>> getIntOperationMemo() {
				return Maps.newHashMap();
			}
		}.$(model).result(ctx));
		System.out.println(ctx);

	}

	private void executeIntOperation(final String progName) {
		final IntOperation model = (IntOperation) this.createModel(progName);
		System.out.println(new PrettyPrintExpressionAlgebraImplementation().$(model).result());
		final Map<String, Integer> ctx = new HashMap<>();
		ctx.put("a", 200);
		ctx.put("b", 200);
		System.out.println(new EvalExpressionAlgebra() {
			@Override
			public Map<BooleanExpression, CtxEvalExp<Integer, Boolean>> getBooleanExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntExpression, CtxEvalExp<Integer, Integer>> getIntExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntOperation, EvalOpExp<Integer>> getIntOperationMemo() {
				return Maps.newHashMap();
			}
		}.$(model).eval(ctx));
		System.out.println(ctx);
	}

	private void executeIntExpression(final String progName) {
		final IntExpression model = (IntExpression) this.createModel(progName);
		System.out.println(new PrettyPrintExpressionAlgebraImplementation().$(model).result());
		final Map<String, Integer> ctx = new HashMap<>();
		ctx.put("a", 200);
		ctx.put("b", 200);
		System.out.println(new EvalExpressionAlgebra() {
			@Override
			public Map<BooleanExpression, CtxEvalExp<Integer, Boolean>> getBooleanExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntExpression, CtxEvalExp<Integer, Integer>> getIntExpressionMemo() {
				return Maps.newHashMap();
			}

			@Override
			public Map<IntOperation, EvalOpExp<Integer>> getIntOperationMemo() {
				return Maps.newHashMap();
			}
		}.$(model).result(ctx));
		System.out.println(ctx);
	}

	private Object createModel(final String progName) {
		final ResourceSetImpl resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("expression", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(ExpressionPackage.eNS_URI, ExpressionPackage.eINSTANCE);
		// TODO: Replacing with System.getProperty("user.dir")
		final URI createURI = URI
				.createURI("model/" + progName);
		final Resource resource = resSet.getResource(createURI, true);
		final EList<EObject> contents = resource.getContents();
		final EObject head = contents.get(0);
		return head;
	}

}
