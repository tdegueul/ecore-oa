package fr.inria.diverse.fsm.algebra.impl;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class GraphvizFSMAlgebra implements FSMAlgebra<GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp> {
  @Override
  public GraphvizExp fsm(final List<GraphvizExp> states, final List<GraphvizExp> transitions, final GraphvizExp initialState, final String name) {
    final GraphvizExp _function = () -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("digraph ");
      _builder.append(name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        for(final GraphvizExp state : states) {
          _builder.append("\t\t\t");
          String _evalGraph = state.evalGraph();
          _builder.append(_evalGraph, "\t\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        for(final GraphvizExp transition : transitions) {
          _builder.append("\t\t\t");
          String _evalGraph_1 = transition.evalGraph();
          _builder.append(_evalGraph_1, "\t\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("}");
      return _builder.toString();
    };
    return _function;
  }
  
  @Override
  public GraphvizExp initialState(final String name, final GraphvizExp fsm, final List<GraphvizExp> outgoingtransitions, final List<GraphvizExp> incommingtransitions) {
    return this.state(name, fsm, outgoingtransitions, incommingtransitions);
  }
  
  @Override
  public GraphvizExp state(final String name, final GraphvizExp fsm, final List<GraphvizExp> outgoingtransitions, final List<GraphvizExp> incommingtransitions) {
    final GraphvizExp _function = () -> {
      return name;
    };
    return _function;
  }
  
  @Override
  public GraphvizExp finalState(final String name, final GraphvizExp fsm, final List<GraphvizExp> outgoingtransitions, final List<GraphvizExp> incommingtransitions) {
    return this.state(name, fsm, outgoingtransitions, incommingtransitions);
  }
  
  @Override
  public GraphvizExp transition(final GraphvizExp from, final GraphvizExp to, final GraphvizExp fsm, final String event) {
    final GraphvizExp _function = () -> {
      StringConcatenation _builder = new StringConcatenation();
      String _evalGraph = from.evalGraph();
      _builder.append(_evalGraph, "");
      _builder.append(" -> ");
      String _evalGraph_1 = to.evalGraph();
      _builder.append(_evalGraph_1, "");
      return _builder.toString();
    };
    return _function;
  }
}
