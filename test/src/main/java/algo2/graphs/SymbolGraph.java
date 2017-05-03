package algo2.graphs;

import searching.SearchType;
import trees.structures.RedBlackTree;

public class SymbolGraph {
	SearchType<String, Integer> st = new RedBlackTree<>();
	String[] keys;
	AbstractGraph graph;

	public SymbolGraph(AbstractGraph graph, String[] keys) {
		this.graph = graph;
		this.keys = keys;
		
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			st.put(key, i);
		}
	}

	public String name(int v) {
		return keys[v];
	}

	public Integer index(String name) {
		return st.get(name);
	}
}
