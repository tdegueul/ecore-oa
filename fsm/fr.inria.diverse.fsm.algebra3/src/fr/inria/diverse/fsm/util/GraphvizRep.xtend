package fr.inria.diverse.fsm.util

import java.util.List
import java.util.Map
import java.util.HashMap

class GraphvizRep {
	public Map<String, Map<String,String>> nodes = newHashMap()
	public List<String> edges = newArrayList()
	public String name;

	public def String show() {
		
		'''
			digraph «name» {
				«FOR node : nodes.entrySet»
					«node.key» «IF !node.value.empty»[«FOR attr:node.value.entrySet SEPARATOR ','»«attr.key»="«attr.value»" «ENDFOR»]«ENDIF»
				«ENDFOR»
				«FOR edge : edges»
					«edge»
				«ENDFOR»
			}
		'''
	}
	
	def addNode(String nodename, HashMap<String, String> properties) {
		if(!nodes.containsKey(nodename)) {
			nodes.put(nodename, properties)
		}
		
		val node = nodes.get(nodename)
		
		node.putAll(properties)
	}
	
}