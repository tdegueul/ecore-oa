package fr.inria.diverse.fsm.algebra;

import com.google.common.base.Objects;
import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fsm.FSM;
import fsm.FinalState;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class DeferProxy<T extends Object, S extends Object, F extends Object, IS extends S, FS extends S> {
  public static abstract class InvocHandlerPus<Z extends Object> implements InvocationHandler {
    public abstract Z initialize();
    
    private Z initialized;
    
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
      Object _xblockexpression = null;
      {
        Z _xifexpression = null;
        boolean _equals = Objects.equal(this.initialized, null);
        if (_equals) {
          Z _initialize = this.initialize();
          _xifexpression = this.initialized = _initialize;
        } else {
          _xifexpression = this.initialized;
        }
        final Z target = _xifexpression;
        _xblockexpression = method.invoke(target, args);
      }
      return _xblockexpression;
    }
  }
  
  public interface GetMe<X extends Object> {
    public abstract X get();
  }
  
  protected <X extends Object, Y extends EObject> X init(final DeferProxy.GetMe<X> param, final Y elem, final Class<X> clazz) {
    X _xblockexpression = null;
    {
      final URI uri = EcoreUtil.getURI(elem);
      boolean _containsKey = this.mapObj.containsKey(uri);
      boolean _not = (!_containsKey);
      if (_not) {
        ClassLoader _classLoader = clazz.getClassLoader();
        final Object proxy = Proxy.newProxyInstance(_classLoader, new Class[] { clazz }, new DeferProxy.InvocHandlerPus() {
          @Override
          public Object initialize() {
            return param.get();
          }
        });
        this.mapObj.put(uri, proxy);
      }
      Object _get = this.mapObj.get(uri);
      _xblockexpression = ((X) _get);
    }
    return _xblockexpression;
  }
  
  private FSMAlgebra<T, S, F, IS, FS> concreteAlgebra;
  
  private Class<F> fsmClass;
  
  private Class<T> transitionClass;
  
  private Class<S> stateClass;
  
  private Class<IS> initialStateClass;
  
  private Class<FS> finalStateClass;
  
  protected Map<URI, Object> mapObj = CollectionLiterals.<URI, Object>newHashMap();
  
  public DeferProxy(final FSMAlgebra<T, S, F, IS, FS> concreteAlgebra, final Class<F> fsmClass, final Class<T> transitionClass, final Class<S> stateClass, final Class<IS> initialStateClass, final Class<FS> finalStateClass) {
    this.concreteAlgebra = concreteAlgebra;
    this.fsmClass = fsmClass;
    this.transitionClass = transitionClass;
    this.stateClass = stateClass;
    this.initialStateClass = initialStateClass;
    this.finalStateClass = finalStateClass;
  }
  
  protected F _fsm(final FSM fsm) {
    return this.<F, FSM>init(
      new DeferProxy.GetMe<F>() {
        @Override
        public F get() {
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
          return DeferProxy.this.concreteAlgebra.fsm(_map, _map_1, _state, _name);
        }
      }, fsm, this.fsmClass);
  }
  
  protected T _transition(final Transition transition) {
    return this.<T, Transition>init(
      new DeferProxy.GetMe<T>() {
        @Override
        public T get() {
          State _from = transition.getFrom();
          S _state = DeferProxy.this.state(_from);
          State _to = transition.getTo();
          S _state_1 = DeferProxy.this.state(_to);
          FSM _fsm = transition.getFsm();
          F _fsm_1 = DeferProxy.this.fsm(_fsm);
          String _event = transition.getEvent();
          return DeferProxy.this.concreteAlgebra.transition(_state, _state_1, _fsm_1, _event);
        }
      }, transition, this.transitionClass);
  }
  
  protected S _state(final State state) {
    return this.<S, State>init(new DeferProxy.GetMe<S>() {
      @Override
      public S get() {
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
        return DeferProxy.this.concreteAlgebra.state(_name, _fsm_1, _map, _map_1);
      }
    }, state, this.stateClass);
  }
  
  protected IS _state(final InitialState initialState) {
    return this.<IS, InitialState>init(
      new DeferProxy.GetMe<IS>() {
        @Override
        public IS get() {
          String _name = initialState.getName();
          FSM _fsm = initialState.getFsm();
          F _fsm_1 = DeferProxy.this.fsm(_fsm);
          EList<Transition> _outgoingtransitions = initialState.getOutgoingtransitions();
          final Function1<Transition, T> _function = (Transition it) -> {
            return DeferProxy.this.transition(it);
          };
          List<T> _map = ListExtensions.<Transition, T>map(_outgoingtransitions, _function);
          EList<Transition> _incommingtransitions = initialState.getIncommingtransitions();
          final Function1<Transition, T> _function_1 = (Transition it) -> {
            return DeferProxy.this.transition(it);
          };
          List<T> _map_1 = ListExtensions.<Transition, T>map(_incommingtransitions, _function_1);
          return DeferProxy.this.concreteAlgebra.initialState(_name, _fsm_1, _map, _map_1);
        }
      }, initialState, this.initialStateClass);
  }
  
  protected FS _state(final FinalState finalState) {
    return this.<FS, FinalState>init(new DeferProxy.GetMe<FS>() {
      @Override
      public FS get() {
        String _name = finalState.getName();
        FSM _fsm = finalState.getFsm();
        F _fsm_1 = DeferProxy.this.fsm(_fsm);
        EList<Transition> _outgoingtransitions = finalState.getOutgoingtransitions();
        final Function1<Transition, T> _function = (Transition it) -> {
          return DeferProxy.this.transition(it);
        };
        List<T> _map = ListExtensions.<Transition, T>map(_outgoingtransitions, _function);
        EList<Transition> _incommingtransitions = finalState.getIncommingtransitions();
        final Function1<Transition, T> _function_1 = (Transition it) -> {
          return DeferProxy.this.transition(it);
        };
        List<T> _map_1 = ListExtensions.<Transition, T>map(_incommingtransitions, _function_1);
        return DeferProxy.this.concreteAlgebra.finalState(_name, _fsm_1, _map, _map_1);
      }
    }, finalState, this.finalStateClass);
  }
  
  public F fsm(final FSM fsm) {
    return _fsm(fsm);
  }
  
  public T transition(final Transition transition) {
    return _transition(transition);
  }
  
  public S state(final State finalState) {
    if (finalState instanceof FinalState) {
      return _state((FinalState)finalState);
    } else if (finalState instanceof InitialState) {
      return _state((InitialState)finalState);
    } else if (finalState != null) {
      return _state(finalState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(finalState).toString());
    }
  }
}
