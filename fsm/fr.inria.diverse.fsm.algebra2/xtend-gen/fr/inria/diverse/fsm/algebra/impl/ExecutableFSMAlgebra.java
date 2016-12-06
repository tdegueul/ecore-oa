package fr.inria.diverse.fsm.algebra.impl;

import com.google.common.base.Objects;
import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableStateExp;
import fr.inria.diverse.fsm.algebra.exprs.ExecutableTransitionExp;
import java.util.List;
import java.util.Queue;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class ExecutableFSMAlgebra implements FSMAlgebra<ExecutableTransitionExp, ExecutableStateExp, ExecutableExp, ExecutableStateExp, ExecutableStateExp> {
  private Queue<String> userinput;
  
  public ExecutableFSMAlgebra(final Queue<String> userinput) {
    this.userinput = userinput;
  }
  
  @Override
  public ExecutableExp fsm(final List<ExecutableStateExp> states, final List<ExecutableTransitionExp> transitions, final ExecutableStateExp initialState, final String name) {
    final ExecutableExp _function = () -> {
      Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> _execute = initialState.execute();
      Function1<? super Boolean, ? extends ExecutableExp> _value = _execute.getValue();
      ExecutableExp _apply = _value.apply(Boolean.valueOf(false));
      _apply.execute();
    };
    return _function;
  }
  
  @Override
  public ExecutableStateExp initialState(final String name, final ExecutableExp fsm, final List<ExecutableTransitionExp> outgoingtransitions, final List<ExecutableTransitionExp> incommingtransitions) {
    final ExecutableStateExp _function = () -> {
      ExecutableStateExp _state = this.state(name, fsm, outgoingtransitions, incommingtransitions);
      Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> _execute = _state.execute();
      Function1<? super Boolean, ? extends ExecutableExp> _value = _execute.getValue();
      return Pair.<String, Function1<? super Boolean, ? extends ExecutableExp>>of(name, _value);
    };
    return _function;
  }
  
  @Override
  public ExecutableStateExp state(final String name, final ExecutableExp fsm, final List<ExecutableTransitionExp> outgoingtransitions, final List<ExecutableTransitionExp> incommingtransitions) {
    final ExecutableStateExp _function = () -> {
      Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> _xblockexpression = null;
      {
        final Function1<Boolean, ExecutableExp> _function_1 = (Boolean isFinal) -> {
          final ExecutableExp _function_2 = () -> {
            final String action = this.userinput.poll();
            boolean _equals = Objects.equal(action, null);
            if (_equals) {
              if ((!isFinal)) {
                InputOutput.<String>println("[ERROR] no action available but final state not reached");
              }
            } else {
              final Function1<ExecutableTransitionExp, Pair<String, ExecutableExp>> _function_3 = (ExecutableTransitionExp it) -> {
                return it.execute();
              };
              final List<Pair<String, ExecutableExp>> executedTransitions = ListExtensions.<ExecutableTransitionExp, Pair<String, ExecutableExp>>map(outgoingtransitions, _function_3);
              final Function1<Pair<String, ExecutableExp>, Boolean> _function_4 = (Pair<String, ExecutableExp> e) -> {
                String _key = e.getKey();
                return Boolean.valueOf(Objects.equal(_key, action));
              };
              final Iterable<Pair<String, ExecutableExp>> transitions = IterableExtensions.<Pair<String, ExecutableExp>>filter(executedTransitions, _function_4);
              boolean _isEmpty = IterableExtensions.isEmpty(transitions);
              if (_isEmpty) {
                InputOutput.<String>println("[ERROR] deadlock!");
              } else {
                int _length = ((Object[])Conversions.unwrapArray(transitions, Object.class)).length;
                boolean _equals_1 = (_length == 1);
                if (_equals_1) {
                  Pair<String, ExecutableExp> _head = IterableExtensions.<Pair<String, ExecutableExp>>head(transitions);
                  ExecutableExp _value = _head.getValue();
                  _value.execute();
                } else {
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("[ERROR] non deterministic: ");
                  int _length_1 = ((Object[])Conversions.unwrapArray(transitions, Object.class)).length;
                  _builder.append(_length_1, "");
                  _builder.append(" outgoing transitions matches event ");
                  _builder.append(action, "");
                  InputOutput.<String>println(_builder.toString());
                }
              }
            }
          };
          return _function_2;
        };
        final Function1<? super Boolean, ? extends ExecutableExp> effect = _function_1;
        _xblockexpression = Pair.<String, Function1<? super Boolean, ? extends ExecutableExp>>of(name, effect);
      }
      return _xblockexpression;
    };
    return _function;
  }
  
  @Override
  public ExecutableStateExp finalState(final String name, final ExecutableExp fsm, final List<ExecutableTransitionExp> outgoingtransitions, final List<ExecutableTransitionExp> incommingtransitions) {
    final ExecutableStateExp _function = () -> {
      Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> _xblockexpression = null;
      {
        final Function1<Boolean, ExecutableExp> _function_1 = (Boolean isFinal) -> {
          final ExecutableExp _function_2 = () -> {
            ExecutableStateExp _state = this.state(name, fsm, outgoingtransitions, incommingtransitions);
            Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> _execute = _state.execute();
            Function1<? super Boolean, ? extends ExecutableExp> _value = _execute.getValue();
            ExecutableExp _apply = _value.apply(Boolean.valueOf(true));
            _apply.execute();
          };
          return _function_2;
        };
        final Function1<? super Boolean, ? extends ExecutableExp> effect = _function_1;
        _xblockexpression = Pair.<String, Function1<? super Boolean, ? extends ExecutableExp>>of(name, effect);
      }
      return _xblockexpression;
    };
    return _function;
  }
  
  @Override
  public ExecutableTransitionExp transition(final ExecutableStateExp from, final ExecutableStateExp to, final ExecutableExp fsm, final String event) {
    final ExecutableTransitionExp _function = () -> {
      final ExecutableExp _function_1 = () -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("transition : event ");
        _builder.append(event, "");
        _builder.append(" - ");
        Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> _execute = from.execute();
        String _key = _execute.getKey();
        _builder.append(_key, "");
        _builder.append(" -> ");
        Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> _execute_1 = to.execute();
        String _key_1 = _execute_1.getKey();
        _builder.append(_key_1, "");
        InputOutput.<String>println(_builder.toString());
        Pair<String, Function1<? super Boolean, ? extends ExecutableExp>> _execute_2 = to.execute();
        Function1<? super Boolean, ? extends ExecutableExp> _value = _execute_2.getValue();
        ExecutableExp _apply = _value.apply(Boolean.valueOf(false));
        _apply.execute();
      };
      return Pair.<String, ExecutableExp>of(event, _function_1);
    };
    return _function;
  }
}
