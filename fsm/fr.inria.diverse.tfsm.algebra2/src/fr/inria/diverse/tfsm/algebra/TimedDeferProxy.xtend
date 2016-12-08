package fr.inria.diverse.tfsm.algebra

import fr.inria.diverse.fsm.algebra.DeferProxy
import fr.inria.diverse.fsm.algebra.DeferProxy.GetMe
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import fsm.FSM
import fsm.State
import fsm.Transition
import tfsm.AndClockConstraint
import tfsm.BinaryClockConstraint
import tfsm.Clock
import tfsm.ClockConstraint
import tfsm.ClockConstraintOperation
import tfsm.ClockReset
import tfsm.LowerClockConstraint
import tfsm.LowerEqualClockConstraint
import tfsm.OrClockConstraint
import tfsm.TimedFSM
import tfsm.TimedFinalState
import tfsm.TimedInitialState
import tfsm.TimedState
import tfsm.TimedTransition
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint
import java.util.List

class TimedDeferProxy<T, S, F, IS extends S, FS extends S, TF extends F, TS extends S, TIS extends TS, TFS extends TS, TT extends T, C, CCO, CC extends CCO, CR, LCC extends CC, LECC extends CC, UCC extends CC, UECC extends CC, BCC extends CCO, ACC extends BCC, OCC extends BCC> extends DeferProxy<T, S, F, IS, FS> {

	TFSMAlgebra<T, S, F, IS, FS, TF, TS, TIS, TFS, TT, C, CCO, CC, CR, LCC, LECC, UCC, UECC, BCC, ACC, OCC> concreteAlgebra

	Class<TF> timedFsmClass

	Class<C> clockClass

	Class<TS> timedStateClass

	Class<TIS> timedInitalStateClass

	Class<TFS> timedFinalStateClass

	Class<CCO> clockConstraintOperationClass

	Class<TT> timedTransitionClass

	Class<CC> clockConstraintClass

	Class<LCC> lowerClockConstraintClass

	Class<LECC> lowerEqualClockConstraintClass

	Class<UCC> upperClockConstraintClass

	Class<UECC> upperEqualClockConstraintClass

	Class<ACC> andClockConstraintClass

	Class<OCC> orClockConstraintClass

	Class<BCC> binaryClockConstraintClass

	Class<CR> clockResetClass

	new(
		TFSMAlgebra<T, S, F, IS, FS, TF, TS, TIS, TFS, TT, C, CCO, CC, CR, LCC, LECC, UCC, UECC, BCC, ACC, OCC> concreteAlgebra,
		Class<T> transitionClass, Class<S> stateClass, Class<F> fsmClass, Class<IS> initialStateClass,
		Class<FS> finalStateClass, Class<TF> timedFsmClass, Class<TS> timedStateClass, Class<TIS> timedInitalStateClass,
		Class<TFS> timedFinalStateClass, Class<TT> timedTransitionClass, Class<C> clockClass,
		Class<CCO> clockConstraintOperationClass, Class<CC> clockConstraintClass, Class<CR> clockResetClass,
		Class<LCC> lowerClockConstraintClass, Class<LECC> lowerEqualClockConstraintClass,
		Class<UCC> upperClockConstraintClass, Class<UECC> upperEqualClockConstraintClass,
		Class<BCC> binaryClockConstraintClass, Class<ACC> andClockConstraintClass, Class<OCC> orClockConstraintClass) {
		super(concreteAlgebra, fsmClass, transitionClass, stateClass, initialStateClass, finalStateClass)
		this.concreteAlgebra = concreteAlgebra
		this.timedFsmClass = timedFsmClass

		this.clockClass = clockClass

		this.timedStateClass = timedStateClass

		this.timedInitalStateClass = timedInitalStateClass

		this.timedFinalStateClass = timedFinalStateClass

		this.clockConstraintOperationClass = clockConstraintOperationClass

		this.clockResetClass = clockResetClass

		this.timedTransitionClass = timedTransitionClass

		this.clockConstraintClass = clockConstraintClass

		this.lowerClockConstraintClass = lowerClockConstraintClass

		this.lowerEqualClockConstraintClass = lowerEqualClockConstraintClass

		this.upperClockConstraintClass = upperClockConstraintClass

		this.upperEqualClockConstraintClass = upperEqualClockConstraintClass

		this.andClockConstraintClass = andClockConstraintClass

		this.orClockConstraintClass = orClockConstraintClass

		this.binaryClockConstraintClass = binaryClockConstraintClass
	}

	override def dispatch F fsm(FSM fsm) {
		super.fsm(fsm)
	}

	def dispatch TF fsm(TimedFSM timedFsm) {
		init(new GetMe<TF> {

			override get() {
				val List<S> v1 = timedFsm.states.map[state]
				val List<T> v2 = timedFsm.transitions.map[transition]
				val S v3 = state(timedFsm.initialstate)
				val List<C> v5 = timedFsm.clocks.map[clock]
				val res = concreteAlgebra.timedFsm(v1, v2, v3, timedFsm.name, v5)
				res
			}

		}, timedFsm)
	}

	def dispatch C clock(Clock clock) {
		init(new GetMe<C> {

			override get() { concreteAlgebra.clock(clock.name, clock.tick) }
		}, clock)
	}

	override def dispatch S state(State state) {
		super.state(state)
	}

	def dispatch TS state(TimedState timedState) {
		init(new GetMe<TS> {

			override get() {
				concreteAlgebra.timedState(timedState.name, fsm(timedState.fsm), timedState.outgoingtransitions.map [
					transition
				], timedState.incommingtransitions.map[transition], clockConstraintOperation(timedState.stateguard))
			}
		}, timedState)
	}

	def dispatch TIS state(TimedInitialState timedInitalState) {
		init(
			new GetMe<TIS> {

				override get() {
					concreteAlgebra.timedInitialState(timedInitalState.name,
						fsm(timedInitalState.fsm), timedInitalState.outgoingtransitions.map [
							transition
						], timedInitalState.incommingtransitions.map[transition],
						clockConstraintOperation(timedInitalState.stateguard))
				}
			}, timedInitalState)
	}

	def dispatch TFS state(TimedFinalState timedFinalState) {
		init(
			new GetMe<TFS> {

				override get() {
					concreteAlgebra.timedFinalState(timedFinalState.name, fsm(timedFinalState.fsm), timedFinalState.
						outgoingtransitions.map [
							transition
						], timedFinalState.incommingtransitions.map[transition],
						clockConstraintOperation(timedFinalState.stateguard))
				}
			}, timedFinalState)
	}

	def dispatch CCO clockConstraintOperation(ClockConstraintOperation clockConstraintOperation) {
		init(new GetMe<CCO> {

			override get() { concreteAlgebra.clockConstraintOperation() }
		}, clockConstraintOperation)
	}

	override def dispatch T transition(Transition transition) {
		super.transition(transition)
	}

	def dispatch TT transition(TimedTransition timedTransition) {
		init(
			new GetMe<TT> {

				override get() {
					concreteAlgebra.timedTransition(state(timedTransition.from), state(timedTransition.to),
						fsm(timedTransition.fsm), timedTransition.event, timedTransition.clockresets.map [
							clockResets
						], clockConstraintOperation(timedTransition.transitionguard))
				}
			}, timedTransition)
	}

	/* NOTE: we might have to generate a method for each level of inheritance of a object in the metamodel. e.g clockConstraintOperation and clockContraint for ClockConstraint since ClockConstraint inherits from ClockConstraintOperation 
	 * and everything must have a dispatch in order to be niherited later !*/
	def dispatch CC clockConstraintOperation(ClockConstraint clockConstraint) {
		init(new GetMe<CC> {

			override get() { concreteAlgebra.clockConstraint(clockConstraint.threshold, clock(clockConstraint.clock)) }
		}, clockConstraint)
	}

	def dispatch CR clockResets(ClockReset clockReset) {
		init(new GetMe<CR> {

			override get() { concreteAlgebra.clockReset(clock(clockReset.clock)) }
		}, clockReset)
	}

	def dispatch LCC clockConstraintOperation(LowerClockConstraint lowerClockConstraint) {
		init(new GetMe<LCC> {

			override get() {
				concreteAlgebra.lowerClockConstraint(lowerClockConstraint.threshold, clock(lowerClockConstraint.clock))
			}
		}, lowerClockConstraint)
	}

	def dispatch LECC clockConstraintOperation(LowerEqualClockConstraint lowerEqualClockConstraint) {
		init(
			new GetMe<LECC> {

				override get() {
					concreteAlgebra.lowerEqualClockConstraint(lowerEqualClockConstraint.threshold,
						clock(lowerEqualClockConstraint.clock))
				}
			}, lowerEqualClockConstraint)
	}

	def dispatch UCC clockConstraintOperation(UpperClockConstraint upperClockConstraint) {
		init(new GetMe<UCC> {

			override get() {
				concreteAlgebra.upperClockConstraint(upperClockConstraint.threshold, clock(upperClockConstraint.clock))
			}
		}, upperClockConstraint)
	}

	def dispatch UECC clockConstraintOperation(UpperEqualClockConstraint upperEqualClockConstraint) {
		init(
			new GetMe<UECC> {

				override get() {
					concreteAlgebra.upperEqualClockConstraint(upperEqualClockConstraint.threshold,
						clock(upperEqualClockConstraint.clock))
				}
			}, upperEqualClockConstraint)
	}

	def dispatch ACC clockConstraintOperation(AndClockConstraint andClockConstraint) {
		init(
			new GetMe<ACC> {

				override get() {
					concreteAlgebra.andClockConstraint(clockConstraintOperation(andClockConstraint.left),
						clockConstraintOperation(andClockConstraint.right))
				}
			}, andClockConstraint)
	}

	def dispatch OCC clockConstraintOperation(OrClockConstraint orClockConstraint) {
		init(
			new GetMe<OCC> {

				override get() {
					concreteAlgebra.orClockConstraint(clockConstraintOperation(orClockConstraint.left),
						clockConstraintOperation(orClockConstraint.right))
				}
			}, orClockConstraint)
	}

	def dispatch BCC clockConstraintOperation(BinaryClockConstraint binaryClockConstraint) {
		init(
			new GetMe<BCC> {

				override get() {
					concreteAlgebra.binaryClockConstraint(clockConstraintOperation(binaryClockConstraint.left),
						clockConstraintOperation(binaryClockConstraint.right))
				}
			}, binaryClockConstraint)
	}
}
