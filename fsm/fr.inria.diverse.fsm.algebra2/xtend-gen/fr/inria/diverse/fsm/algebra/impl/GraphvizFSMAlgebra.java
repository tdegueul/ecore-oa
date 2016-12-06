package fr.inria.diverse.fsm.algebra.impl;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp;
import fr.inria.diverse.fsm.algebra.exprs.GraphvizStateExp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class GraphvizFSMAlgebra implements FSMAlgebra<GraphvizExp, GraphvizStateExp, GraphvizExp, GraphvizStateExp, GraphvizStateExp> {
  @Override
  public GraphvizExp fsm(final List<GraphvizStateExp> states, final List<GraphvizExp> transitions, final GraphvizStateExp initialState, final String name) {
    final GraphvizExp _function = () -> {
      String _xblockexpression = null;
      {
        final Function1<GraphvizStateExp, GraphvizStateExp.StateData> _function_1 = (GraphvizStateExp e) -> {
          return e.evalGraph();
        };
        final List<GraphvizStateExp.StateData> evalStates = ListExtensions.<GraphvizStateExp, GraphvizStateExp.StateData>map(states, _function_1);
        final Function1<GraphvizExp, String> _function_2 = (GraphvizExp e) -> {
          return e.evalGraph();
        };
        final List<String> evalTransitions = ListExtensions.<GraphvizExp, String>map(transitions, _function_2);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("digraph ");
        _builder.append(name, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        {
          for(final GraphvizStateExp.StateData state : evalStates) {
            _builder.append("\t");
            _builder.append(state.name, "\t");
            _builder.append(" ");
            {
              Set<Map.Entry<String, String>> _entrySet = state.attributes.entrySet();
              boolean _hasElements = false;
              for(final Map.Entry<String, String> attr : _entrySet) {
                if (!_hasElements) {
                  _hasElements = true;
                  _builder.append("[", "\t");
                } else {
                  _builder.appendImmediate(", ", "\t");
                }
                String _key = attr.getKey();
                _builder.append(_key, "\t");
                _builder.append("=\"");
                String _value = attr.getValue();
                _builder.append(_value, "\t");
                _builder.append("\"");
              }
              if (_hasElements) {
                _builder.append("]", "\t");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        {
          for(final String transition : evalTransitions) {
            _builder.append("\t");
            _builder.append(transition, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _xblockexpression = _builder.toString();
      }
      return _xblockexpression;
    };
    return _function;
  }
  
  @Override
  public GraphvizStateExp initialState(final String name, final GraphvizExp fsm, final List<GraphvizExp> outgoingtransitions, final List<GraphvizExp> incommingtransitions) {
    final GraphvizStateExp _function = () -> {
      GraphvizStateExp.StateData _xblockexpression = null;
      {
        GraphvizStateExp _state = this.state(name, fsm, outgoingtransitions, incommingtransitions);
        final GraphvizStateExp.StateData stateRes = _state.evalGraph();
        Pair<String, String> _mappedTo = Pair.<String, String>of("shape", "box");
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of("color", "red");
        HashMap<String, String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1);
        stateRes.attributes.putAll(_newHashMap);
        _xblockexpression = stateRes;
      }
      return _xblockexpression;
    };
    return _function;
  }
  
  @Override
  public GraphvizStateExp state(final String name, final GraphvizExp fsm, final List<GraphvizExp> outgoingtransitions, final List<GraphvizExp> incommingtransitions) {
    final GraphvizStateExp _function = () -> {
      return new GraphvizStateExp.StateData(name);
    };
    return _function;
  }
  
  @Override
  public GraphvizStateExp finalState(final String name, final GraphvizExp fsm, final List<GraphvizExp> outgoingtransitions, final List<GraphvizExp> incommingtransitions) {
    final GraphvizStateExp _function = () -> {
      GraphvizStateExp.StateData _xblockexpression = null;
      {
        GraphvizStateExp _state = this.state(name, fsm, outgoingtransitions, incommingtransitions);
        final GraphvizStateExp.StateData stateRes = _state.evalGraph();
        Pair<String, String> _mappedTo = Pair.<String, String>of("shape", "box");
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of("color", "green");
        HashMap<String, String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1);
        stateRes.attributes.putAll(_newHashMap);
        _xblockexpression = stateRes;
      }
      return _xblockexpression;
    };
    return _function;
  }
  
  @Override
  public GraphvizExp transition(final GraphvizStateExp from, final GraphvizStateExp to, final GraphvizExp fsm, final String event) {
    final GraphvizExp _function = () -> {
      StringConcatenation _builder = new StringConcatenation();
      GraphvizStateExp.StateData _evalGraph = from.evalGraph();
      _builder.append(_evalGraph.name, "");
      _builder.append(" -> ");
      GraphvizStateExp.StateData _evalGraph_1 = to.evalGraph();
      _builder.append(_evalGraph_1.name, "");
      _builder.append(" [label=\"");
      _builder.append(event, "");
      _builder.append("\"]");
      return _builder.toString();
    };
    return _function;
  }
}
