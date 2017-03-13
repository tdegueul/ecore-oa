package fr.inria.diverse.tfsm.algebra.impl;

import java.text.MessageFormat;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
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
	public default RepGraphvizExp timedFSM(final TimedFSM tfsm) {
		return (GraphvizRep rep) -> {
			rep.name = tfsm.getName();
			tfsm.getTransitions().forEach(t -> $(t).result(rep));
			return "";
		};
	}

	@Override
	public default RepGraphvizExp timedInitialState(final TimedInitialState s) {
		return (GraphvizRep rep) -> {
			String nodeName = timedState(s).result(rep);
			rep.addNode(nodeName, ImmutableMap.of(
				"shape",  "box",
				"color",  "red",
				"xlabel", nodeName
			));
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp timedFinalState(final TimedFinalState s) {
		return (GraphvizRep rep) -> {
			String nodeName = timedState(s).result(rep);
			rep.addNode(nodeName, ImmutableMap.of(
				"shape",  "box",
				"color",  "green",
				"xlabel", nodeName
			));
			return nodeName;
		};
	}

	@Override
	public default RepGraphvizExp timedTransition(final TimedTransition tt) {
		//add('''«$(timedTransition.from).result(rep)» -> «$(timedTransition.to).result(rep)» [label="«timedTransition.event»«IF timedTransition.transitionguard != null»\n«$(timedTransition.transitionguard).result(rep)»«ENDIF»«IF timedTransition.clockresets != null && !timedTransition.clockresets.empty»\n«FOR reset:timedTransition.clockresets SEPARATOR '\n'»«$(reset).result(rep)»«ENDFOR»«ENDIF»"]''')
		return (GraphvizRep rep) -> {
			rep.edges.add(
				MessageFormat.format("{0} -> {1} [label=\"{2}\"]",
					$(tt.getFrom()).result(rep), $(tt.getTo()).result(rep),
					tt.getEvent() + (tt.getTransitionguard() != null ? "\n" + $(tt.getTransitionguard()).result(rep) : ""))
					// TODO: Complete me following comment above, I'm too lazy :/
			);
			return "";
		};
	}

	@Override
	public default RepGraphvizExp timedState(final TimedState s) {
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
	public default RepGraphvizExp clock(final Clock c) {
		// FIXME: Is this normal?
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	@Override
	public default RepGraphvizExp clockReset(final ClockReset cr) {
		return (GraphvizRep rep) -> cr.getClock().getName() + " = 0";
	}

	@Override
	public default RepGraphvizExp lowerClockConstraint(final LowerClockConstraint clockConstraint) {
		return (GraphvizRep rep) -> clockConstraint.getThreshold() + " > " + clockConstraint.getClock().getName();
	}

	@Override
	public default RepGraphvizExp lowerEqualClockConstraint(final LowerEqualClockConstraint lowerEqualClockConstraint) {
		return (GraphvizRep rep) -> lowerEqualClockConstraint.getThreshold() + " >= " + lowerEqualClockConstraint.getClock().getName();
	}

	@Override
	public default RepGraphvizExp upperClockConstraint(final UpperClockConstraint upperClockConstraint) {
		return (GraphvizRep rep) -> upperClockConstraint.getThreshold() + " < " + upperClockConstraint.getClock().getName();
	}

	@Override
	public default RepGraphvizExp upperEqualClockConstraint(final UpperEqualClockConstraint upperEqualClockConstraint) {
		return (GraphvizRep rep) -> upperEqualClockConstraint.getThreshold() + " <= " + upperEqualClockConstraint.getClock().getName();
	}

	@Override
	public default RepGraphvizExp andClockConstraint(final AndClockConstraint andClockConstraint) {
		return (GraphvizRep rep) -> $(andClockConstraint.getLeft()).result(rep) + " AND " + $(andClockConstraint.getRight()).result(rep);
	}

	@Override
	public default RepGraphvizExp orClockConstraint(final OrClockConstraint orClockConstraint) {
		return (GraphvizRep rep) -> $(orClockConstraint.getLeft()).result(rep) + " OR " + $(orClockConstraint.getRight()).result(rep);
	}
}
