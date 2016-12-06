package fr.inria.diverse.fsm.algebra.exprs;

import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public interface GraphvizStateExp {
  public static class StateData {
    public final String name;
    
    public final Map<String, String> attributes = CollectionLiterals.<String, String>newHashMap();
    
    public StateData(final String name) {
      this.name = name;
    }
  }
  
  public abstract GraphvizStateExp.StateData evalGraph();
}
