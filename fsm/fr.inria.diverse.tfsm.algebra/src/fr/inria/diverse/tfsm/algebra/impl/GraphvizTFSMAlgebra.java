package fr.inria.diverse.tfsm.algebra.impl;

import java.util.Map;

import com.google.common.collect.Maps;

import fr.inria.diverse.algebras.expressions.RepGraphvizExp;
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra;
import fr.inria.diverse.utils.GraphvizRep;
import tfsm.AndClockConstraint;
import tfsm.Clock;
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
import tfsm.algebra.TfsmAlgebra;

public interface GraphvizTFSMAlgebra extends GraphvizFSMAlgebra, TfsmAlgebra<RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp, RepGraphvizExp> {
	@Override
	public default RepGraphvizExp timedFSM(TimedFSM tfsm) {
		return (GraphvizRep rep) -> {
			rep.name = tfsm.getName();
			tfsm.getTransitions().forEach(t -> $(t).result(rep));
			return "";
		};
	}

	@Override
	public default RepGraphvizExp timedInitialState(TimedInitialState s) {
		return (GraphvizRep rep) -> {
			String nodeName = timedState(s).result(rep);
			Map<String, String> props = Maps.newHashMap();
			props.put("shape", "box");
			props.put("color", "red");
			props.put("xlabel", nodeName);
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp timedFinalState(TimedFinalState s) {
		return (GraphvizRep rep) -> {
			String nodeName = timedState(s).result(rep);
			Map<String, String> props = Maps.newHashMap();
			props.put("shape", "box");
			props.put("color", "green");
			props.put("xlabel", nodeName);
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp timedTransition(TimedTransition tt) {
		return (GraphvizRep rep) -> {
			rep.edges.add(
					$(tt.getFrom()).result(rep) + " -> " + $(tt.getTo()).result(rep) + " FIXME IM TOO LAZY"
			);
			return "";
		};
	}

	@Override
	public default RepGraphvizExp timedState(TimedState s) {
		return (GraphvizRep rep) -> {
			String stateName = state(s).result(rep);
			Map<String, String> attrs = Maps.newHashMap();
			if (s.getStateguard() != null)
				attrs.put("label", $(s.getStateguard()).result(rep));
			else
				attrs.put("label", "");
			return stateName;
		};
	}

	@Override
	public default RepGraphvizExp clock(Clock c) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	@Override
	public default RepGraphvizExp clockReset(ClockReset cr) {
		return (GraphvizRep rep) -> cr.getClock().getName() + " = 0";
	}

	@Override
	public default RepGraphvizExp lowerClockConstraint(LowerClockConstraint clockConstraint) {
		return (GraphvizRep rep) -> clockConstraint.getThreshold() + " > " + clockConstraint.getClock().getName();
	}

	@Override
	public default RepGraphvizExp lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint) {
		return (GraphvizRep rep) -> lowerEqualClockConstraint.getThreshold() + " >= " + lowerEqualClockConstraint.getClock().getName();
	}

	@Override
	public default RepGraphvizExp upperClockConstraint(UpperClockConstraint upperClockConstraint) {
		return (GraphvizRep rep) -> upperClockConstraint.getThreshold() + " < " + upperClockConstraint.getClock().getName();
	}

	@Override
	public default RepGraphvizExp upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint) {
		return (GraphvizRep rep) -> upperEqualClockConstraint.getThreshold() + " <= " + upperEqualClockConstraint.getClock().getName();
	}

	@Override
	public default RepGraphvizExp andClockConstraint(AndClockConstraint andClockConstraint) {
		return (GraphvizRep rep) -> $(andClockConstraint.getLeft()).result(rep) + " AND " + $(andClockConstraint.getRight()).result(rep);
	}

	@Override
	public default RepGraphvizExp orClockConstraint(OrClockConstraint orClockConstraint) {
		return (GraphvizRep rep) -> $(orClockConstraint.getLeft()).result(rep) + " OR " + $(orClockConstraint.getRight()).result(rep);
	}
}
