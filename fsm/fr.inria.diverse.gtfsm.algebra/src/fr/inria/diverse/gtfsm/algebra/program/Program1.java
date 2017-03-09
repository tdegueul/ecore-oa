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

import expression.BooleanAnd;
import expression.BooleanEqual;
import expression.BooleanExpression;
import expression.BooleanGreaterThan;
import expression.BooleanOr;
import expression.ConstExpr;
import expression.IntAdd;
import expression.IntBlock;
import expression.IntExpression;
import expression.IntMult;
import expression.IntNeg;
import expression.IntOperation;
import expression.IntVarAssign;
import expression.IntVarRef;
import fr.inria.diverse.algebras.expressions.CtxEvalExp;
import fr.inria.diverse.algebras.expressions.EvalOpExp;
import fr.inria.diverse.algebras.expressions.GraphvizExp;
import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.fsm.algebra.exprs.CtxExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.gtfsm.algebra.impl.ExecutableGTFSMAlgebra;
import fr.inria.diverse.gtfsm.algebra.impl.GraphvizGTFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;
import gfsm.GfsmPackage;
import gtfsm.GTFSM;
import gtfsm.GtfsmPackage;
import gtfsm.algebra.GtfsmAlgebra;
import tfsm.AndClockConstraint;
import tfsm.Clock;
import tfsm.ClockConstraintOperation;
import tfsm.ClockReset;
import tfsm.LowerClockConstraint;
import tfsm.LowerEqualClockConstraint;
import tfsm.OrClockConstraint;
import tfsm.TimedFSM;
import tfsm.TimedFinalState;
import tfsm.TimedInitialState;
import tfsm.TimedState;
import tfsm.TimedTransition;
import tfsm.UpperClockConstraint;
import tfsm.UpperEqualClockConstraint;

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

		@Override
		public ExecutableExp gFSM(GFSM gFSM) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp gFinalState(GFinalState gFinalState) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp gInitialState(GInitialState gInitialState) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp gState(GState gState) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp gTransition(GTransition gTransition) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<FSM, ExecutableExp> getFSMMemo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<State, ExecutableExp> getStateMemo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Transition, ExecutableExp> getTransitionMemo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Boolean> booleanAnd(BooleanAnd booleanAnd) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Boolean> booleanEqual(BooleanEqual booleanEqual) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Boolean> booleanGreaterThan(BooleanGreaterThan booleanGreaterThan) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Boolean> booleanOr(BooleanOr booleanOr) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Integer> constExpr(ConstExpr constExpr) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Integer> intAdd(IntAdd intAdd) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EvalOpExp<Integer> intBlock(IntBlock intBlock) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Integer> intMult(IntMult intMult) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Integer> intNeg(IntNeg intNeg) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EvalOpExp<Integer> intVarAssign(IntVarAssign intVarAssign) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxEvalExp<Integer, Integer> intVarRef(IntVarRef intVarRef) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<BooleanExpression, CtxEvalExp<Integer, Boolean>> getBooleanExpressionMemo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<IntExpression, CtxEvalExp<Integer, Integer>> getIntExpressionMemo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<IntOperation, EvalOpExp<Integer>> getIntOperationMemo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp fSM(FSM fSM) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp finalState(FinalState finalState) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp initialState(InitialState initialState) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp state(State state) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp transition(Transition transition) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean andClockConstraint(AndClockConstraint andClockConstraint) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Void clock(Clock clock) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CtxExecutableExp clockReset(ClockReset clockReset) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean lowerClockConstraint(LowerClockConstraint lowerClockConstraint) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean orClockConstraint(OrClockConstraint orClockConstraint) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp timedFSM(TimedFSM timedFSM) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp timedFinalState(TimedFinalState timedFinalState) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp timedInitialState(TimedInitialState timedInitialState) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp timedState(TimedState timedState) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ExecutableExp timedTransition(TimedTransition timedTransition) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean upperClockConstraint(UpperClockConstraint upperClockConstraint) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<ClockConstraintOperation, Boolean> getClockConstraintOperationMemo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Clock, Void> getClockMemo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<ClockReset, CtxExecutableExp> getClockResetMemo() {
			// TODO Auto-generated method stub
			return null;
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
		final String gtfsm1 = "model/GTFSM1.gtfsm";
		final String gtfsm2 = "model/GFSM1.gtfsm";
		final String gfsm1 = "model/GFSM1.gfsm";
		System.out.println(this.make(gtfsm1, new GraphvizGTFSMAlgebra() {
			@Override
			public RepGraphvizExp gFSM(GFSM gFSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gFinalState(GFinalState gFinalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gInitialState(GInitialState gInitialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gState(GState gState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gTransition(GTransition gTransition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<FSM, RepGraphvizExp> getFSMMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<State, RepGraphvizExp> getStateMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<Transition, RepGraphvizExp> getTransitionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanAnd(BooleanAnd booleanAnd) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanEqual(BooleanEqual booleanEqual) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanGreaterThan(BooleanGreaterThan booleanGreaterThan) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanOr(BooleanOr booleanOr) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp constExpr(ConstExpr constExpr) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intAdd(IntAdd intAdd) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intBlock(IntBlock intBlock) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intMult(IntMult intMult) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intNeg(IntNeg intNeg) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intVarAssign(IntVarAssign intVarAssign) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intVarRef(IntVarRef intVarRef) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<BooleanExpression, GraphvizExp> getBooleanExpressionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<IntExpression, GraphvizExp> getIntExpressionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<IntOperation, GraphvizExp> getIntOperationMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp fSM(FSM fSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp finalState(FinalState finalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp initialState(InitialState initialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp state(State state) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp transition(Transition transition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp andClockConstraint(AndClockConstraint andClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp clock(Clock clock) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp clockReset(ClockReset clockReset) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp lowerClockConstraint(LowerClockConstraint lowerClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp orClockConstraint(OrClockConstraint orClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedFSM(TimedFSM timedFSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedFinalState(TimedFinalState timedFinalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedInitialState(TimedInitialState timedInitialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedState(TimedState timedState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedTransition(TimedTransition timedTransition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp upperClockConstraint(UpperClockConstraint upperClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<ClockConstraintOperation, RepGraphvizExp> getClockConstraintOperationMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<Clock, RepGraphvizExp> getClockMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<ClockReset, RepGraphvizExp> getClockResetMemo() {
				// TODO Auto-generated method stub
				return null;
			}
		}).result(new GraphvizRep()));

		System.out.println(this.make(gtfsm2, new GraphvizGTFSMAlgebra() {
			@Override
			public RepGraphvizExp gFSM(GFSM gFSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gFinalState(GFinalState gFinalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gInitialState(GInitialState gInitialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gState(GState gState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gTransition(GTransition gTransition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<FSM, RepGraphvizExp> getFSMMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<State, RepGraphvizExp> getStateMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<Transition, RepGraphvizExp> getTransitionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanAnd(BooleanAnd booleanAnd) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanEqual(BooleanEqual booleanEqual) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanGreaterThan(BooleanGreaterThan booleanGreaterThan) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanOr(BooleanOr booleanOr) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp constExpr(ConstExpr constExpr) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intAdd(IntAdd intAdd) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intBlock(IntBlock intBlock) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intMult(IntMult intMult) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intNeg(IntNeg intNeg) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intVarAssign(IntVarAssign intVarAssign) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intVarRef(IntVarRef intVarRef) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<BooleanExpression, GraphvizExp> getBooleanExpressionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<IntExpression, GraphvizExp> getIntExpressionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<IntOperation, GraphvizExp> getIntOperationMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp fSM(FSM fSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp finalState(FinalState finalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp initialState(InitialState initialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp state(State state) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp transition(Transition transition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp andClockConstraint(AndClockConstraint andClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp clock(Clock clock) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp clockReset(ClockReset clockReset) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp lowerClockConstraint(LowerClockConstraint lowerClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp orClockConstraint(OrClockConstraint orClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedFSM(TimedFSM timedFSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedFinalState(TimedFinalState timedFinalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedInitialState(TimedInitialState timedInitialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedState(TimedState timedState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedTransition(TimedTransition timedTransition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp upperClockConstraint(UpperClockConstraint upperClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<ClockConstraintOperation, RepGraphvizExp> getClockConstraintOperationMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<Clock, RepGraphvizExp> getClockMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<ClockReset, RepGraphvizExp> getClockResetMemo() {
				// TODO Auto-generated method stub
				return null;
			}
		}).result(new GraphvizRep()));

		final Map<Integer, String> initTimedActions = new HashMap<Integer, String>();
		initTimedActions.put(0, "t1");
		this.make(gtfsm2, new ExecutableGtfsmAlgebraImplementation(initTimedActions)).execute();

		System.out.println(this.make2(gfsm1, new GraphvizGTFSMAlgebra() {
			@Override
			public RepGraphvizExp gFSM(GFSM gFSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gFinalState(GFinalState gFinalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gInitialState(GInitialState gInitialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gState(GState gState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp gTransition(GTransition gTransition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<FSM, RepGraphvizExp> getFSMMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<State, RepGraphvizExp> getStateMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<Transition, RepGraphvizExp> getTransitionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanAnd(BooleanAnd booleanAnd) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanEqual(BooleanEqual booleanEqual) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanGreaterThan(BooleanGreaterThan booleanGreaterThan) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp booleanOr(BooleanOr booleanOr) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp constExpr(ConstExpr constExpr) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intAdd(IntAdd intAdd) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intBlock(IntBlock intBlock) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intMult(IntMult intMult) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intNeg(IntNeg intNeg) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intVarAssign(IntVarAssign intVarAssign) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public GraphvizExp intVarRef(IntVarRef intVarRef) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<BooleanExpression, GraphvizExp> getBooleanExpressionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<IntExpression, GraphvizExp> getIntExpressionMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<IntOperation, GraphvizExp> getIntOperationMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp fSM(FSM fSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp finalState(FinalState finalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp initialState(InitialState initialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp state(State state) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp transition(Transition transition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp andClockConstraint(AndClockConstraint andClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp clock(Clock clock) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp clockReset(ClockReset clockReset) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp lowerClockConstraint(LowerClockConstraint lowerClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp orClockConstraint(OrClockConstraint orClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedFSM(TimedFSM timedFSM) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedFinalState(TimedFinalState timedFinalState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedInitialState(TimedInitialState timedInitialState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedState(TimedState timedState) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp timedTransition(TimedTransition timedTransition) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp upperClockConstraint(UpperClockConstraint upperClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RepGraphvizExp upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<ClockConstraintOperation, RepGraphvizExp> getClockConstraintOperationMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<Clock, RepGraphvizExp> getClockMemo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<ClockReset, RepGraphvizExp> getClockResetMemo() {
				// TODO Auto-generated method stub
				return null;
			}
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
