package fr.inria.diverse.fsm.algebra.program;

import fr.inria.diverse.fsm.algebra.DeferProxy;
import fr.inria.diverse.fsm.algebra.abstr.FSMAlgebra;
import fr.inria.diverse.fsm.algebra.exprs.GraphvizExp;
import fr.inria.diverse.fsm.algebra.impl.GraphvizFSMAlgebra;
import fsm.FSM;
import fsm.FsmPackage;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Program1 {
  public FSM createModel() {
    FSM _xblockexpression = null;
    {
      final ResourceSetImpl resSet = new ResourceSetImpl();
      Resource.Factory.Registry _resourceFactoryRegistry = resSet.getResourceFactoryRegistry();
      Map<String, Object> _extensionToFactoryMap = _resourceFactoryRegistry.getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("fsm", _xMIResourceFactoryImpl);
      final FsmPackage fsmPackage = FsmPackage.eINSTANCE;
      URI _createURI = URI.createURI("/home/mleduc/dev/ecore/ecore-oa/fsm/fr.inria.diverse.fsm.algebra2/models/FSM1.fsm");
      final Resource resource = resSet.getResource(_createURI, true);
      EList<EObject> _contents = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      _xblockexpression = ((FSM) _head);
    }
    return _xblockexpression;
  }
  
  public <T extends Object, S extends Object, F extends Object, IS extends S, FS extends S> F make(final FSMAlgebra<T, S, F, IS, FS> f, final Class<F> fsmClass, final Class<T> transitionClass, final Class<S> stateClass) {
    F _xblockexpression = null;
    {
      final FSM exp = this.createModel();
      final DeferProxy<T, S, F, IS, FS> df = new DeferProxy<T, S, F, IS, FS>(f, fsmClass, transitionClass, stateClass);
      _xblockexpression = df.fsm(exp);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    Program1 _program1 = new Program1();
    _program1.execute();
  }
  
  public String execute() {
    String _xblockexpression = null;
    {
      GraphvizFSMAlgebra _graphvizFSMAlgebra = new GraphvizFSMAlgebra();
      final GraphvizExp evalAlg = this.<GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp, GraphvizExp>make(_graphvizFSMAlgebra, GraphvizExp.class, GraphvizExp.class, GraphvizExp.class);
      String _evalGraph = evalAlg.evalGraph();
      _xblockexpression = InputOutput.<String>println(_evalGraph);
    }
    return _xblockexpression;
  }
}
