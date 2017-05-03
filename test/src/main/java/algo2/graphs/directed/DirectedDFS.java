package algo2.graphs.directed;

import java.util.List;

public class DirectedDFS {
	DirectedGraph graph;
	int source;
	boolean[] marked;
	List<Integer> sources;

	public DirectedDFS(DirectedGraph graph, int v) {
		this.graph = graph;
		this.source = v;
		marked = new boolean[graph.getNoOfVertices()];
		dfs(graph, v);
	}

	public DirectedDFS(DirectedGraph graph, List<Integer> sources) {
		this.graph = graph;
		this.sources = sources;
		marked = new boolean[graph.getNoOfVertices()];
		for(int s : sources){
			if (!marked[s]){
				dfs(graph, s);
			}
		}
	}

	public boolean isMarked(int v) {
		return marked[v];
	}

	private void dfs(DirectedGraph graph, int v) {
		marked[v] = true;
		for (int w : graph.adjacent(v)) {
			if (!marked[w]) {
				dfs(graph, w);
			}
		}
	}

}
