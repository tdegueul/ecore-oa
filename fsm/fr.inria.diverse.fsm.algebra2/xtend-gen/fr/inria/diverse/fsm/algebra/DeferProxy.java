package fr.inria.diverse.fsm.algebra;

import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fsm.FSM;
import fsm.InitialState;
import fsm.State;
import fsm.Transition;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class DeferProxy<T extends Object, S extends Object, F extends Object, IS extends S, FS extends S> {
  private static class LazyProxy implements InvocationHandler {
    private Object res = null;
    
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
      return method.invoke(this.res, args);
    }
  }
  
  private FSMAlgebra<T, S, F, IS, FS> concreteAlgebra;
  
  private Map<URI, DeferProxy.LazyProxy> mapUri = CollectionLiterals.<URI, DeferProxy.LazyProxy>newHashMap();
  
  public DeferProxy(final FSMAlgebra<T, S, F, IS, FS> concreteAlgebra) {
    this.concreteAlgebra = concreteAlgebra;
  }
  
  public F fsm(final FSM fsm) {
    F _xblockexpression = null;
    {
      final URI stateId = EcoreUtil.getURI(fsm);
      boolean _containsKey = this.mapUri.containsKey(stateId);
      boolean _not = (!_containsKey);
      if (_not) {
        DeferProxy.LazyProxy _lazyProxy = new DeferProxy.LazyProxy();
        this.mapUri.put(stateId, _lazyProxy);
      }
      F _xifexpression = null;
      boolean _or = false;
      EReference _eContainmentFeature = fsm.eContainmentFeature();
      boolean _tripleEquals = (_eContainmentFeature == null);
      if (_tripleEquals) {
        _or = true;
      } else {
        EReference _eContainmentFeature_1 = fsm.eContainmentFeature();
        boolean _isContainment = _eContainmentFeature_1.isContainment();
        boolean _not_1 = (!_isContainment);
        _or = _not_1;
      }
      if (_or) {
        F _xblockexpression_1 = null;
        {
          EList<State> _states = fsm.getStates();
          final Function1<State, S> _function = (State s) -> {
            return this.state(s);
          };
          List<S> _map = ListExtensions.<State, S>map(_states, _function);
          EList<Transition> _transitions = fsm.getTransitions();
          final Function1<Transition, T> _function_1 = (Transition t) -> {
            return this.transition(t);
          };
          List<T> _map_1 = ListExtensions.<Transition, T>map(_transitions, _function_1);
          InitialState _initialstate = fsm.getInitialstate();
          S _state = this.state(_initialstate);
          String _name = fsm.getName();
          final F res = this.concreteAlgebra.fsm(_map, _map_1, _state, _name);
          DeferProxy.LazyProxy _get = this.mapUri.get(stateId);
          _get.res = res;
          _xblockexpression_1 = res;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        DeferProxy.LazyProxy _get = this.mapUri.get(stateId);
        _xifexpression = ((F) _get);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public T transition(final Transition transition) {
    T _xblockexpression = null;
    {
      final URI stateId = EcoreUtil.getURI(transition);
      boolean _containsKey = this.mapUri.containsKey(stateId);
      boolean _not = (!_containsKey);
      if (_not) {
        DeferProxy.LazyProxy _lazyProxy = new DeferProxy.LazyProxy();
        this.mapUri.put(stateId, _lazyProxy);
      }
      T _xifexpression = null;
      boolean _or = false;
      EReference _eContainmentFeature = transition.eContainmentFeature();
      boolean _tripleEquals = (_eContainmentFeature == null);
      if (_tripleEquals) {
        _or = true;
      } else {
        EReference _eContainmentFeature_1 = transition.eContainmentFeature();
        boolean _isContainment = _eContainmentFeature_1.isContainment();
        boolean _not_1 = (!_isContainment);
        _or = _not_1;
      }
      if (_or) {
        T _xblockexpression_1 = null;
        {
          State _from = transition.getFrom();
          S _state = this.state(_from);
          State _to = transition.getTo();
          S _state_1 = this.state(_to);
          FSM _fsm = transition.getFsm();
          F _fsm_1 = this.fsm(_fsm);
          String _event = transition.getEvent();
          final T res = this.concreteAlgebra.transition(_state, _state_1, _fsm_1, _event);
          DeferProxy.LazyProxy _get = this.mapUri.get(stateId);
          _get.res = res;
          _xblockexpression_1 = res;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        DeferProxy.LazyProxy _get = this.mapUri.get(stateId);
        _xifexpression = ((T) _get);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public S state(final State state) {
    S _xblockexpression = null;
    {
      final URI stateId = EcoreUtil.getURI(state);
      boolean _containsKey = this.mapUri.containsKey(stateId);
      boolean _not = (!_containsKey);
      if (_not) {
        DeferProxy.LazyProxy _lazyProxy = new DeferProxy.LazyProxy();
        this.mapUri.put(stateId, _lazyProxy);
      }
      S _xifexpression = null;
      boolean _or = false;
      EReference _eContainmentFeature = state.eContainmentFeature();
      boolean _tripleEquals = (_eContainmentFeature == null);
      if (_tripleEquals) {
        _or = true;
      } else {
        EReference _eContainmentFeature_1 = state.eContainmentFeature();
        boolean _isContainment = _eContainmentFeature_1.isContainment();
        boolean _not_1 = (!_isContainment);
        _or = _not_1;
      }
      if (_or) {
        S _xblockexpression_1 = null;
        {
          String _name = state.getName();
          FSM _fsm = state.getFsm();
          F _fsm_1 = this.fsm(_fsm);
          EList<Transition> _outgoingtransitions = state.getOutgoingtransitions();
          final Function1<Transition, T> _function = (Transition ot) -> {
            return this.transition(ot);
          };
          List<T> _map = ListExtensions.<Transition, T>map(_outgoingtransitions, _function);
          EList<Transition> _incommingtransitions = state.getIncommingtransitions();
          final Function1<Transition, T> _function_1 = (Transition itr) -> {
            return this.transition(itr);
          };
          List<T> _map_1 = ListExtensions.<Transition, T>map(_incommingtransitions, _function_1);
          final S res = this.concreteAlgebra.state(_name, _fsm_1, _map, _map_1);
          DeferProxy.LazyProxy _get = this.mapUri.get(stateId);
          _get.res = res;
          _xblockexpression_1 = res;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        DeferProxy.LazyProxy _get = this.mapUri.get(stateId);
        _xifexpression = ((S) _get);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
