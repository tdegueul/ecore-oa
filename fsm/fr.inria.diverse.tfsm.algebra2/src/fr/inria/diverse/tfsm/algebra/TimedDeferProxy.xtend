package fr.inria.diverse.tfsm.algebra

import fr.inria.diverse.fsm.algebra.DeferProxy
import fr.inria.diverse.tfsm.algebra.abstr.TFSMAlgebra
import fsm.FSM
import fsm.State
import fsm.Transition
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import tfsm.Clock
import tfsm.ClockConstraintOperation
import tfsm.ClockReset
import tfsm.TimedFSM
import tfsm.TimedFinalState
import tfsm.TimedInitialState
import tfsm.TimedState
import tfsm.TimedTransition
import tfsm.ClockConstraint
import tfsm.LowerClockConstraint
import tfsm.LowerEqualClockConstraint
import tfsm.UpperClockConstraint
import tfsm.UpperEqualClockConstraint
import tfsm.AndClockConstraint
import tfsm.OrClockConstraint
import tfsm.BinaryClockConstraint

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

		Proxy.newProxyInstance(timedFsmClass.classLoader, #[timedFsmClass], new InvocationHandler() {

			override invoke(Object proxy, Method method, Object[] args) throws Throwable {
				method.invoke(concreteAlgebra.timedFsm(timedFsm.states.map[state], timedFsm.transitions.map [
					transition
				], state(timedFsm.initialstate), timedFsm.name, timedFsm.clocks.map[clock]), args)
			}

		}) as TF
	}

	def dispatch C clock(Clock clock) {
		Proxy.newProxyInstance(clockClass.classLoader, #[clockClass], new InvocationHandler() {

			override invoke(Object proxy, Method method, Object[] args) throws Throwable {
				method.invoke(concreteAlgebra.clock(clock.name, clock.tick), args)
			}

		}) as C
	}

	override def dispatch S state(State state) {
		super.state(state)
	}

	def dispatch TS state(TimedState timedState) {
		Proxy.newProxyInstance(timedStateClass.classLoader, #[timedStateClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke( // TESTFIXME : it should be a timeFsm instead of fsm but TimedFSM is not able to define a containement relation with TimedStates since ecore does not allow inheritance overloading?
					concreteAlgebra.timedState(timedState.name, fsm(timedState.fsm), timedState.outgoingtransitions.map [
						transition
					], timedState.incommingtransitions.map[transition],
						clockConstraintOperation(timedState.stateguard)), args)
				}

			}) as TS
	}

	def dispatch TIS state(TimedInitialState timedInitalState) {
		Proxy.newProxyInstance(timedInitalStateClass.classLoader, #[timedInitalStateClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					val ca = concreteAlgebra.timedInitialState(timedInitalState.name,
						fsm(timedInitalState.fsm), timedInitalState.outgoingtransitions.map [
							transition
						], timedInitalState.incommingtransitions.map[transition],
						clockConstraintOperation(timedInitalState.stateguard))
					method.invoke(ca, args)
				}

			}) as TIS
	}

	def dispatch TFS state(TimedFinalState timedFinalState) {
		Proxy.newProxyInstance(timedFinalStateClass.classLoader, #[timedFinalStateClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.timedInitialState(timedFinalState.name,
							fsm(timedFinalState.fsm), timedFinalState.outgoingtransitions.map [
								transition
							], timedFinalState.incommingtransitions.map[transition],
							clockConstraintOperation(timedFinalState.stateguard)), args)
				}

			}) as TFS
	}

	def dispatch CCO clockConstraintOperation(ClockConstraintOperation clockConstraintOperation) {
		Proxy.newProxyInstance(clockConstraintOperationClass.classLoader, #[clockConstraintOperationClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(concreteAlgebra.clockConstraintOperation(), args)
				}

			}) as CCO
	}

	override def dispatch T transition(Transition transition) {
		super.transition(transition)
	}

	def dispatch TT transition(TimedTransition timedTransition) {
		Proxy.newProxyInstance(timedTransitionClass.classLoader, #[timedTransitionClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.timedTransition(state(timedTransition.from), state(timedTransition.to),
							fsm(timedTransition.fsm), timedTransition.event, timedTransition.clockresets.map [
								clockResets
							], clockConstraintOperation(timedTransition.transitionguard)), args)
				}

			}) as TT
	}

	/* NOTE: we might have to generate a method for each level of inheritance of a object in the metamodel. e.g clockConstraintOperation and clockContraint for ClockConstraint since ClockConstraint inherits from ClockConstraintOperation 
	 * and everything must have a dispatch in order to be niherited later !*/
	def dispatch CC clockConstraintOperation(ClockConstraint clockConstraint) {
		Proxy.newProxyInstance(clockConstraintClass.classLoader, #[clockConstraintClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.clockConstraint(clockConstraint.threshold, clock(clockConstraint.clock)), args)
				}

			}) as CC
	}

	def dispatch CR clockResets(ClockReset clockReset) {
		Proxy.newProxyInstance(clockResetClass.classLoader, #[clockResetClass], new InvocationHandler() {

			override invoke(Object proxy, Method method, Object[] args) throws Throwable {
				method.invoke(concreteAlgebra.clockReset(clock(clockReset.clock)), args)
			}

		}) as CR
	}

	def dispatch LCC clockConstraintOperation(LowerClockConstraint lowerClockConstraint) {
		Proxy.newProxyInstance(lowerClockConstraintClass.classLoader, #[lowerClockConstraintClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.lowerClockConstraint(lowerClockConstraint.threshold,
							clock(lowerClockConstraint.clock)), args)
				}

			}) as LCC
	}

	def dispatch LECC clockConstraintOperation(LowerEqualClockConstraint lowerEqualClockConstraint) {
		Proxy.newProxyInstance(lowerEqualClockConstraintClass.classLoader, #[lowerEqualClockConstraintClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.lowerEqualClockConstraint(lowerEqualClockConstraint.threshold,
							clock(lowerEqualClockConstraint.clock)), args)
				}

			}) as LECC
	}

	def dispatch UCC clockConstraintOperation(UpperClockConstraint upperClockConstraint) {
		Proxy.newProxyInstance(upperClockConstraintClass.classLoader, #[upperClockConstraintClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.upperClockConstraint(upperClockConstraint.threshold,
							clock(upperClockConstraint.clock)), args)
				}

			}) as UCC
	}

	def dispatch UECC clockConstraintOperation(UpperEqualClockConstraint upperEqualClockConstraint) {
		Proxy.newProxyInstance(upperEqualClockConstraintClass.classLoader, #[upperEqualClockConstraintClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.upperEqualClockConstraint(upperEqualClockConstraint.threshold,
							clock(upperEqualClockConstraint.clock)), args)
				}

			}) as UECC
	}

	def dispatch ACC clockConstraintOperation(AndClockConstraint andClockConstraint) {
		Proxy.newProxyInstance(andClockConstraintClass.classLoader, #[andClockConstraintClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.andClockConstraint(clockConstraintOperation(andClockConstraint.left),
							clockConstraintOperation(andClockConstraint.right)), args)
				}

			}) as ACC
	}

	def dispatch OCC clockConstraintOperation(OrClockConstraint orClockConstraint) {
		Proxy.newProxyInstance(orClockConstraintClass.classLoader, #[orClockConstraintClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.orClockConstraint(clockConstraintOperation(orClockConstraint.left),
							clockConstraintOperation(orClockConstraint.right)), args)
				}

			}) as OCC
	}

	def dispatch BCC clockConstraintOperation(BinaryClockConstraint binaryClockConstraint) {
		Proxy.newProxyInstance(binaryClockConstraintClass.classLoader, #[binaryClockConstraintClass],
			new InvocationHandler() {

				override invoke(Object proxy, Method method, Object[] args) throws Throwable {
					method.invoke(
						concreteAlgebra.binaryClockConstraint(clockConstraintOperation(binaryClockConstraint.left),
							clockConstraintOperation(binaryClockConstraint.right)), args)
				}

			}) as BCC
	}
}
