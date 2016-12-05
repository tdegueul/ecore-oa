package fr.inria.diverse.fsm.algebra.program;

import fr.inria.diverse.fsm.algebra.DeferProxy;
import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp;
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra;
import fsm.FSM;
import fsm.FinalState;
import fsm.FsmFactory;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Program1 {
  public FSM createModel() {
    final FsmFactory expF = FsmFactory.eINSTANCE;
    InitialState _createInitialState = expF.createInitialState();
    final Procedure1<InitialState> _function = (InitialState it) -> {
      it.setName("first");
    };
    final InitialState initial = ObjectExtensions.<InitialState>operator_doubleArrow(_createInitialState, _function);
    State _createState = expF.createState();
    final Procedure1<State> _function_1 = (State it) -> {
      it.setName("A");
    };
    final State nodea = ObjectExtensions.<State>operator_doubleArrow(_createState, _function_1);
    State _createState_1 = expF.createState();
    final Procedure1<State> _function_2 = (State it) -> {
      it.setName("B");
    };
    final State nodeb = ObjectExtensions.<State>operator_doubleArrow(_createState_1, _function_2);
    FinalState _createFinalState = expF.createFinalState();
    final Procedure1<FinalState> _function_3 = (FinalState it) -> {
      it.setName("last");
    };
    final FinalState end = ObjectExtensions.<FinalState>operator_doubleArrow(_createFinalState, _function_3);
    Transition _createTransition = expF.createTransition();
    final Procedure1<Transition> _function_4 = (Transition it) -> {
      it.setFrom(initial);
      it.setTo(nodea);
      it.setEvent("a");
    };
    final Transition t1 = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition, _function_4);
    Transition _createTransition_1 = expF.createTransition();
    final Procedure1<Transition> _function_5 = (Transition it) -> {
      it.setFrom(initial);
      it.setTo(nodeb);
      it.setEvent("c");
    };
    final Transition t2 = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition_1, _function_5);
    Transition _createTransition_2 = expF.createTransition();
    final Procedure1<Transition> _function_6 = (Transition it) -> {
      it.setFrom(nodea);
      it.setTo(end);
      it.setEvent("b");
    };
    final Transition t3 = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition_2, _function_6);
    FSM _createFSM = expF.createFSM();
    final Procedure1<FSM> _function_7 = (FSM it) -> {
      EList<Transition> _transitions = it.getTransitions();
      ArrayList<Transition> _newArrayList = CollectionLiterals.<Transition>newArrayList(t1, t2, t3);
      _transitions.addAll(_newArrayList);
      it.setInitialstate(initial);
    };
    return ObjectExtensions.<FSM>operator_doubleArrow(_createFSM, _function_7);
  }
  
  public <T extends Object, S extends Object, F extends Object, IS extends S, FS extends S> F make(final FSMAlgebra<T, S, F, IS, FS> f) {
    F _xblockexpression = null;
    {
      final FSM exp = this.createModel();
      final DeferProxy<T, S, F, IS, FS> df = new DeferProxy<T, S, F, IS, FS>(f);
      _xblockexpression = df.fsm(exp);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    Program1 _program1 = new Program1();
    _program1.execute();
  }
  
  public String execute() {
    GraphvizFSMAlgebra _graphvizFSMAlgebra = new GraphvizFSMAlgebra();
    GraphvizExp _make = this.<GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp>make(_graphvizFSMAlgebra);
    String _evalGraph = _make.evalGraph();
    return InputOutput.<String>println(_evalGraph);
  }
}
