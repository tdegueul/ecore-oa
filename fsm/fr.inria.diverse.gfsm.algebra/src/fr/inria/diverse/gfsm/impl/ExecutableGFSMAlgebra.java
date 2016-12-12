package fr.inria.diverse.gfsm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import expression.BooleanAnd;
import expression.BooleanEqual;
import expression.BooleanGreaterThan;
import expression.BooleanOr;
import expression.ConstExpr;
import expression.IntAdd;
import expression.IntBlock;
import expression.IntMult;
import expression.IntNeg;
import expression.IntVarAssign;
import expression.IntVarRef;
import fr.inria.diverse.expression.algebra.exprs.EvalExp;
import fr.inria.diverse.expression.algebra.exprs.EvalOpExp;
import fr.inria.diverse.expression.algebra.impl.EvalExpressionAlgebra;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.fsm.algebra.impl.ExecutableFSMAlgebra;
import fr.inria.diverse.gfsm.abstr.GFSMAlgebra;
import fsm.Transition;
import gfsm.GFSM;
import gfsm.GFinalState;
import gfsm.GInitialState;
import gfsm.GState;
import gfsm.GTransition;

public class ExecutableGFSMAlgebra extends ExecutableFSMAlgebra implements
		GFSMAlgebra<ExecutableExp, ExecutableExp, ExecutableExp, EvalExp<Integer>, EvalExp<Boolean>, EvalOpExp> {
	public ExecutableGFSMAlgebra(final Queue<String> userinput) {
		super(userinput);
	}

	private final Map<String, Integer> ctx = new HashMap<String, Integer>();
	private final EvalExpressionAlgebra eea = new EvalExpressionAlgebra(this.ctx);

	@Override
	public EvalExp<Integer> intVarRef(final IntVarRef intVarRef) {
		return eea.intVarRef(intVarRef);
	}

	@Override
	public EvalExp<Integer> intNeg(final IntNeg intNeg) {
		return eea.intNeg(intNeg);
	}

	@Override
	public EvalExp<Integer> intAdd(final IntAdd intAdd) {
		return eea.intAdd(intAdd);
	}

	@Override
	public EvalExp<Integer> intMult(final IntMult intMult) {
		return eea.intMult(intMult);
	}

	@Override
	public EvalExp<Integer> constExpr(final ConstExpr constExpr) {
		return eea.constExpr(constExpr);
	}

	@Override
	public EvalOpExp intVarAssign(final IntVarAssign intVarAssign) {
		return eea.intVarAssign(intVarAssign);
	}

	@Override
	public EvalOpExp intBlock(final IntBlock intBlock) {
		return eea.intBlock(intBlock);
	}

	@Override
	public EvalExp<Boolean> booleanEqual(final BooleanEqual booleanEqual) {
		return eea.booleanEqual(booleanEqual);
	}

	@Override
	public EvalExp<Boolean> booleanAnd(final BooleanAnd booleanAnd) {
		return eea.booleanAnd(booleanAnd);
	}

	@Override
	public EvalExp<Boolean> booleanGreaterThan(final BooleanGreaterThan booleanGreaterThan) {
		return eea.booleanGreaterThan(booleanGreaterThan);
	}

	@Override
	public EvalExp<Boolean> booleanOr(final BooleanOr booleanOr) {
		return eea.booleanOr(booleanOr);
	}

	@Override
	public String toString() {
		return eea.toString();
	}

	@Override
	public ExecutableExp gTransition(final GTransition gTransition) {
		throw new RuntimeException("gTransition");
	}

	@Override
	public ExecutableExp gState(final GState gState) {
		return new ExecutableExp() {

			@Override
			public void execute() {
				final String action = userinput.poll();
				if (action == null) {
					if (!(currentState instanceof GFinalState)) {
						System.out.println("[ERROR] no action available but final state not reached");
						currentState = null;
					}
				} else {
					final List<Transition> res = gState.getOutgoingtransitions().stream().filter(t -> {
						final boolean ret;
						if (t instanceof GTransition) {
							ret = $BE(((GTransition) t).getGuard()).result().orElseThrow(
									() -> new RuntimeException("failed to process " + t.getEvent() + " guard"));
						} else {
							ret = false;
						}
						return ret;
					}).collect(Collectors.toList());

					if (res.size() == 1) {
						System.out.println("transition: event " + action + " - " + gState.getName() + " -> "
								+ res.get(0).getTo().getName());
					} else if (res.size() > 1) {
						System.out.println("[ERROR] Non deterministic " + res.size()
								+ " outgoing transitions matches event " + action);
						currentState = null;
					} else {
						System.out.println("[ERROR] Deadlock");
						currentState = null;
					}
				}

			}
		};
	}

	@Override
	public ExecutableExp gInitialState(final GInitialState gInitialState) {
		return this.gState(gInitialState);
	}

	@Override
	public ExecutableExp gFinalState(final GFinalState gFinalState) {
		return this.gState(gFinalState);
	}

	@Override
	public ExecutableExp gFSM(final GFSM gfsm) {

		return () -> {
			currentState = gfsm.getInitialstate();
			while (currentState != null) {
				$S(currentState).execute();
			}
		};
	}
}
