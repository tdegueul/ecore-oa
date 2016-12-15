package fr.inria.diverse.tfsm.algebra.abstr;

import tfsm.Clock;
import tfsm.ClockConstraintOperation;
import tfsm.ClockReset;

public interface TFSMAlgebraDispatcher<C, CCO, CR> {
	C $(Clock clock);

	CR $(ClockReset clockReset);

	CCO $(ClockConstraintOperation clockConstraint);
}
