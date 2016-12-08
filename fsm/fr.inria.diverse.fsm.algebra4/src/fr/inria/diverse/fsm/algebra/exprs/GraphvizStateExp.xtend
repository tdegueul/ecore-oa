package fr.inria.diverse.fsm.algebra.exprs

import java.util.Map

interface GraphvizStateExp {
	public static class StateData {
		public final String name
		public final Map<String, String> attributes = newHashMap()

		new(String name) {
			this.name = name
		}
	}

	def StateData evalGraph()
}
