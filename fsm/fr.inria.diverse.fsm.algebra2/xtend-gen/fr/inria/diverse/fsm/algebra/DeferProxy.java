package fr.inria.diverse.fsm.algebra;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fsm.FSM;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class DeferProxy<T extends Object, S extends Object, F extends Object, IS extends S, FS extends S> {
  private static class LazyProxy<T extends Object> implements InvocationHandler {
    private T target;
    
    public LazyProxy(final T target) {
      this.target = target;
    }
    
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
      return method.invoke(this.target, args);
    }
  }
  
  private FSMAlgebra<T, S, F, IS, FS> concreteAlgebra;
  
  private Map<URI, F> mapFsm = CollectionLiterals.<URI, F>newHashMap();
  
  private Map<URI, T> mapTransition = CollectionLiterals.<URI, T>newHashMap();
  
  private Map<URI, S> mapState = CollectionLiterals.<URI, S>newHashMap();
  
  private Class<F> fsmClass;
  
  private Class<T> transitionClass;
  
  private Class<S> stateClass;
  
  public DeferProxy(final FSMAlgebra<T, S, F, IS, FS> concreteAlgebra, final Class<F> fsmClass, final Class<T> transitionClass, final Class<S> stateClass) {
    this.concreteAlgebra = concreteAlgebra;
    this.fsmClass = fsmClass;
    this.transitionClass = transitionClass;
    this.stateClass = stateClass;
  }
  
  public F fsm(final FSM fsm) {
    F _xblockexpression = null;
    {
      final URI fsmId = EcoreUtil.getURI(fsm);
      boolean _containsKey = this.mapState.containsKey(fsmId);
      boolean _not = (!_containsKey);
      if (_not) {
        ClassLoader _classLoader = this.fsmClass.getClassLoader();
        Object _newProxyInstance = Proxy.newProxyInstance(_classLoader, new Class[] { this.fsmClass }, 
          new InvocationHandler() {
            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
              EList<State> _states = fsm.getStates();
              final Function1<State, S> _function = (State it) -> {
                return DeferProxy.this.state(it);
              };
              List<S> _map = ListExtensions.<State, S>map(_states, _function);
              EList<Transition> _transitions = fsm.getTransitions();
              final Function1<Transition, T> _function_1 = (Transition it) -> {
                return DeferProxy.this.transition(it);
              };
              List<T> _map_1 = ListExtensions.<Transition, T>map(_transitions, _function_1);
              InitialState _initialstate = fsm.getInitialstate();
              S _state = DeferProxy.this.state(_initialstate);
              String _name = fsm.getName();
              F _fsm = DeferProxy.this.concreteAlgebra.fsm(_map, _map_1, _state, _name);
              return method.invoke(_fsm, args);
            }
          });
        this.mapFsm.put(fsmId, 
          ((F) _newProxyInstance));
      }
      _xblockexpression = this.mapFsm.get(fsmId);
    }
    return _xblockexpression;
  }
  
  public T transition(final Transition transition) {
    T _xblockexpression = null;
    {
      final URI transitionId = EcoreUtil.getURI(transition);
      boolean _containsKey = this.mapTransition.containsKey(transitionId);
      boolean _not = (!_containsKey);
      if (_not) {
        ClassLoader _classLoader = this.transitionClass.getClassLoader();
        Object _newProxyInstance = Proxy.newProxyInstance(_classLoader, new Class[] { this.transitionClass }, 
          new InvocationHandler() {
            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
              State _from = transition.getFrom();
              S _state = DeferProxy.this.state(_from);
              State _to = transition.getTo();
              S _state_1 = DeferProxy.this.state(_to);
              FSM _fsm = transition.getFsm();
              F _fsm_1 = DeferProxy.this.fsm(_fsm);
              String _event = transition.getEvent();
              T _transition = DeferProxy.this.concreteAlgebra.transition(_state, _state_1, _fsm_1, _event);
              return method.invoke(_transition, args);
            }
          });
        this.mapTransition.put(transitionId, 
          ((T) _newProxyInstance));
      }
      _xblockexpression = this.mapTransition.get(transitionId);
    }
    return _xblockexpression;
  }
  
  public S state(final State state) {
    S _xblockexpression = null;
    {
      final URI stateId = EcoreUtil.getURI(state);
      boolean _containsKey = this.mapTransition.containsKey(stateId);
      boolean _not = (!_containsKey);
      if (_not) {
        ClassLoader _classLoader = this.stateClass.getClassLoader();
        Object _newProxyInstance = Proxy.newProxyInstance(_classLoader, new Class[] { this.stateClass }, new InvocationHandler() {
          @Override
          public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
            String _name = state.getName();
            FSM _fsm = state.getFsm();
            F _fsm_1 = DeferProxy.this.fsm(_fsm);
            EList<Transition> _outgoingtransitions = state.getOutgoingtransitions();
            final Function1<Transition, T> _function = (Transition it) -> {
              return DeferProxy.this.transition(it);
            };
            List<T> _map = ListExtensions.<Transition, T>map(_outgoingtransitions, _function);
            EList<Transition> _incommingtransitions = state.getIncommingtransitions();
            final Function1<Transition, T> _function_1 = (Transition it) -> {
              return DeferProxy.this.transition(it);
            };
            List<T> _map_1 = ListExtensions.<Transition, T>map(_incommingtransitions, _function_1);
            S _state = DeferProxy.this.concreteAlgebra.state(_name, _fsm_1, _map, _map_1);
            return method.invoke(_state, args);
          }
        });
        this.mapState.put(stateId, 
          ((S) _newProxyInstance));
      }
      _xblockexpression = this.mapState.get(stateId);
    }
    return _xblockexpression;
  }
}
