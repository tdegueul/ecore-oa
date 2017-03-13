package fr.inria.diverse.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GraphvizRep {
	public Map<String, Map<String, String>> nodes = Maps.newHashMap();
	public List<String> edges = Lists.newArrayList();
	public String name;

	public String show() {
		StringBuilder b = new StringBuilder();
		b.append("digraph " + name);
		for (Entry<String, Map<String, String>> node : nodes.entrySet()) {
			b.append(node.getKey());
			if (!node.getValue().isEmpty())
				for (Entry<String, String> attrs : node.getValue().entrySet()) {
					// FIXME: Need a "," separator somewhere
					b.append(attrs.getKey() + "=" + attrs.getValue());
				}
		}
		return b.toString();
	}

	public void addNode(String nodeName, Map<String, String> props) {
		if (!nodes.containsKey(nodeName))
			nodes.put(nodeName, props);

		Map<String, String> node = nodes.get(nodeName);
		node.putAll(props);
	}
}
