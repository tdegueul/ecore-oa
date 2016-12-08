package fr.inria.diverse.tfsm.algebra

import fr.inria.diverse.fsm.algebra.DeferProxy
import fr.inria.diverse.fsm.algebra.DeferProxy.GetMe
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
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra

class TimedDeferProxy<T, S, F, C, CCO, CR> extends DeferProxy<T, S, F> {

	TFSMAlgebra<T, S, F, C, CCO, CR> concreteAlgebra

	Class<C> clockClass

	Class<CCO> clockConstraintOperationClass

	Class<CR> clockResetClass

	new(
		TFSMAlgebra<T, S, F, C, CCO, CR> concreteAlgebra,
		Class<T> transitionClass,
		Class<S> stateClass,
		Class<F> fsmClass,
		Class<C> clockClass,
		Class<CCO> clockConstraintOperationClass,
		Class<CR> clockResetClass
	) {
		super(concreteAlgebra, fsmClass, transitionClass, stateClass)
		this.concreteAlgebra = concreteAlgebra

		this.clockClass = clockClass

		this.clockConstraintOperationClass = clockConstraintOperationClass

		this.clockResetClass = clockResetClass

	}

	override def dispatch F fsm(FSM fsm) {
		super.fsm(fsm)
	}

	def dispatch F fsm(TimedFSM timedFsm) {
		init(new GetMe<F> {

			override get() {
				val List<S> v1 = timedFsm.states.map[state]
				val List<T> v2 = timedFsm.transitions.map[transition]
				val S v3 = state(timedFsm.initialstate)
				val List<C> v5 = timedFsm.clocks.map[clock]
				val res = concreteAlgebra.timedFsm(v1, v2, v3, timedFsm.name, v5)
				res
			}
		}, timedFsm, fsmClass)
	}

	def dispatch C clock(Clock clock) {
		init(new GetMe<C> {

			override get() { concreteAlgebra.clock(clock.name, clock.tick) }
		}, clock, clockClass)
	}

	override def dispatch S state(State state) {
		super.state(state)
	}

	def dispatch S state(TimedState timedState) {
		init(new GetMe<S> {

			override get() {
				concreteAlgebra.timedState(timedState.name, fsm(timedState.fsm), timedState.outgoingtransitions.map [
					transition
				], timedState.incommingtransitions.map[transition], clockConstraintOperation(timedState.stateguard))
			}
		}, timedState, stateClass)
	}

	def dispatch S state(TimedInitialState timedInitalState) {
		init(
			new GetMe<S> {

				override get() {
					concreteAlgebra.timedInitialState(timedInitalState.name,
						fsm(timedInitalState.fsm), timedInitalState.outgoingtransitions.map [
							transition
						], timedInitalState.incommingtransitions.map[transition],
						clockConstraintOperation(timedInitalState.stateguard))
				}
			}, timedInitalState, stateClass)
	}

	def dispatch S state(TimedFinalState timedFinalState) {
		init(
			new GetMe<S> {

				override get() {
					concreteAlgebra.timedFinalState(timedFinalState.name, fsm(timedFinalState.fsm), timedFinalState.
						outgoingtransitions.map [
							transition
						], timedFinalState.incommingtransitions.map[transition],
						clockConstraintOperation(timedFinalState.stateguard))
				}
			}, timedFinalState, stateClass)
	}

	def dispatch CCO clockConstraintOperation(ClockConstraintOperation clockConstraintOperation) {
		init(new GetMe<CCO> {

			override get() { concreteAlgebra.clockConstraintOperation() }
		}, clockConstraintOperation, clockConstraintOperationClass)
	}

	override def dispatch T transition(Transition transition) {
		super.transition(transition)
	}

	def dispatch T transition(TimedTransition timedTransition) {
		init(
			new GetMe<T> {

				override get() {
					concreteAlgebra.timedTransition(state(timedTransition.from), state(timedTransition.to),
						fsm(timedTransition.fsm), timedTransition.event, timedTransition.clockresets.map [
							clockResets
						], clockConstraintOperation(timedTransition.transitionguard))
				}
			}, timedTransition, transitionClass)
	}

	/* NOTE: we might have to generate a method for each level of inheritance of a object in the metamodel. e.g clockConstraintOperation and clockContraint for ClockConstraint since ClockConstraint inherits from ClockConstraintOperation 
	 * and everything must have a dispatch in order to be niherited later !*/
	def dispatch CCO clockConstraintOperation(ClockConstraint clockConstraint) {
		init(new GetMe<CCO> {

			override get() { concreteAlgebra.clockConstraint(clockConstraint.threshold, clock(clockConstraint.clock)) }
		}, clockConstraint, clockConstraintOperationClass)
	}

	def dispatch CR clockResets(ClockReset clockReset) {
		init(new GetMe<CR> {

			override get() { concreteAlgebra.clockReset(clock(clockReset.clock)) }
		}, clockReset, clockResetClass)
	}

	def dispatch CCO clockConstraintOperation(LowerClockConstraint lowerClockConstraint) {
		init(new GetMe<CCO> {

			override get() {
				concreteAlgebra.lowerClockConstraint(lowerClockConstraint.threshold, clock(lowerClockConstraint.clock))
			}
		}, lowerClockConstraint, clockConstraintOperationClass)
	}

	def dispatch CCO clockConstraintOperation(LowerEqualClockConstraint lowerEqualClockConstraint) {
		init(
			new GetMe<CCO> {

				override get() {
					concreteAlgebra.lowerEqualClockConstraint(lowerEqualClockConstraint.threshold,
						clock(lowerEqualClockConstraint.clock))
				}
			}, lowerEqualClockConstraint, clockConstraintOperationClass)
	}

	def dispatch CCO clockConstraintOperation(UpperClockConstraint upperClockConstraint) {
		init(new GetMe<CCO> {

			override get() {
				concreteAlgebra.upperClockConstraint(upperClockConstraint.threshold, clock(upperClockConstraint.clock))
			}
		}, upperClockConstraint, clockConstraintOperationClass)
	}

	def dispatch CCO clockConstraintOperation(UpperEqualClockConstraint upperEqualClockConstraint) {
		init(
			new GetMe<CCO> {

				override get() {
					concreteAlgebra.upperEqualClockConstraint(upperEqualClockConstraint.threshold,
						clock(upperEqualClockConstraint.clock))
				}
			}, upperEqualClockConstraint, clockConstraintOperationClass)
	}

	def dispatch CCO clockConstraintOperation(AndClockConstraint andClockConstraint) {
		init(
			new GetMe<CCO> {

				override get() {
					concreteAlgebra.andClockConstraint(clockConstraintOperation(andClockConstraint.left),
						clockConstraintOperation(andClockConstraint.right))
				}
			}, andClockConstraint, clockConstraintOperationClass)
	}

	def dispatch CCO clockConstraintOperation(OrClockConstraint orClockConstraint) {
		init(
			new GetMe<CCO> {

				override get() {
					concreteAlgebra.orClockConstraint(clockConstraintOperation(orClockConstraint.left),
						clockConstraintOperation(orClockConstraint.right))
				}
			}, orClockConstraint, clockConstraintOperationClass)
	}

	def dispatch CCO clockConstraintOperation(BinaryClockConstraint binaryClockConstraint) {
		init(
			new GetMe<CCO> {

				override get() {
					concreteAlgebra.binaryClockConstraint(clockConstraintOperation(binaryClockConstraint.left),
						clockConstraintOperation(binaryClockConstraint.right))
				}
			}, binaryClockConstraint, clockConstraintOperationClass)
	}
}
