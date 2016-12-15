package fr.inria.diverse.tfsm.algebra.abstr;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
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

public interface TFSMAlgebra<T, F, S, C, CCO, CR> extends FSMAlgebra<T, F, S>, TFSMAlgebraDispatcher<C,CCO,CR> {
	F timedFSM(TimedFSM timedFSM);

	S timedInitialState(TimedInitialState timedInitialState);

	S timedFinalState(TimedFinalState timedFinalState);

	T timedTransition(TimedTransition timedTransition);

	S timedState(TimedState timedState);

	C clock(Clock clock);

	CR clockReset(ClockReset clockReset);

	CCO lowerClockConstraint(LowerClockConstraint clockConstraint);

	CCO lowerEqualClockConstraint(LowerEqualClockConstraint lowerEqualClockConstraint);

	CCO upperClockConstraint(UpperClockConstraint upperClockConstraint);

	CCO upperEqualClockConstraint(UpperEqualClockConstraint upperEqualClockConstraint);

	CCO andClockConstraint(AndClockConstraint andClockConstraint);

	CCO orClockConstraint(OrClockConstraint orClockConstraint);

}
