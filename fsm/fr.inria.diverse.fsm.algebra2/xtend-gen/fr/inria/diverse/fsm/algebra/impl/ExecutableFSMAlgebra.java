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

@SuppressWarnings("all")
public class ExecutableFSMAlgebra implements FSMAlgebra<ExecutableTransitionExp, ExecutableStateExp, ExecutableExp, ExecutableStateExp, ExecutableStateExp> {
  private Queue<String> userinput;
  
  public ExecutableFSMAlgebra(final Queue<String> userinput) {
    this.userinput = userinput;
  }
  
  @Override
  public ExecutableExp fsm(final List<? extends ExecutableStateExp> states, final List<? extends ExecutableTransitionExp> transitions, final ExecutableStateExp initialState, final String name) {
    final ExecutableExp _function = () -> {
      ExecutableStateExp.ExecutableStateData _execute = initialState.execute();
      ExecutableExp _execute_1 = _execute.execute();
      _execute_1.execute();
    };
    return _function;
  }
  
  @Override
  public ExecutableStateExp initialState(final String name, final ExecutableExp fsm, final List<? extends ExecutableTransitionExp> outgoingtransitions, final List<? extends ExecutableTransitionExp> incommingtransitions) {
    return this.state(name, fsm, outgoingtransitions, incommingtransitions);
  }
  
  @Override
  public ExecutableStateExp state(final String stateName, final ExecutableExp fsm, final List<? extends ExecutableTransitionExp> outgoingtransitions, final List<? extends ExecutableTransitionExp> incommingtransitions) {
    abstract class __ExecutableFSMAlgebra_1 implements ExecutableStateExp.ExecutableStateData {
      final __ExecutableFSMAlgebra_1 _this__ExecutableFSMAlgebra_1 = this;
      
      Boolean isFinal;
    }
    
    final ExecutableStateExp _function = () -> {
      return new __ExecutableFSMAlgebra_1() {
        @Override
        public String name() {
          return stateName;
        }
        
        @Override
        public void setFinal(final Boolean isFinal) {
          this.isFinal = isFinal;
        }
        
        @Override
        public ExecutableExp execute() {
          final ExecutableExp _function = () -> {
            final String action = ExecutableFSMAlgebra.this.userinput.poll();
            boolean _equals = Objects.equal(action, null);
            if (_equals) {
              if ((!(this.isFinal).booleanValue())) {
                InputOutput.<String>println("[ERROR] no action available but final state not reached");
              }
            } else {
              final Function1<ExecutableTransitionExp, Boolean> _function_1 = (ExecutableTransitionExp e) -> {
                String _event = e.event();
                return Boolean.valueOf(Objects.equal(_event, action));
              };
              final Iterable<? extends ExecutableTransitionExp> transitions = IterableExtensions.filter(outgoingtransitions, _function_1);
              boolean _isEmpty = IterableExtensions.isEmpty(transitions);
              if (_isEmpty) {
                InputOutput.<String>println("[ERROR] deadlock!");
              } else {
                int _length = ((Object[])Conversions.unwrapArray(transitions, Object.class)).length;
                boolean _equals_1 = (_length == 1);
                if (_equals_1) {
                  ExecutableTransitionExp _head = IterableExtensions.head(transitions);
                  _head.execute();
                  this.execute();
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
          return _function;
        }
      };
    };
    return _function;
  }
  
  @Override
  public ExecutableStateExp finalState(final String name, final ExecutableExp fsm, final List<? extends ExecutableTransitionExp> outgoingtransitions, final List<? extends ExecutableTransitionExp> incommingtransitions) {
    final ExecutableStateExp _function = () -> {
      ExecutableStateExp.ExecutableStateData _xblockexpression = null;
      {
        ExecutableStateExp _state = this.state(name, fsm, outgoingtransitions, incommingtransitions);
        final ExecutableStateExp.ExecutableStateData resState = _state.execute();
        resState.setFinal(Boolean.valueOf(true));
        _xblockexpression = resState;
      }
      return _xblockexpression;
    };
    return _function;
  }
  
  @Override
  public ExecutableTransitionExp transition(final ExecutableStateExp from, final ExecutableStateExp to, final ExecutableExp fsm, final String eventName) {
    return new ExecutableTransitionExp() {
      @Override
      public String event() {
        return eventName;
      }
      
      @Override
      public ExecutableExp execute() {
        return this.execute();
      }
    };
  }
}
