package algo2.graphs.edgeweighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EdgeWeightedGraph {
	/**
	 * no of vertices
	 */
	int V;
	/**
	 * no of edges
	 */
	int E;

	List<Edge>[] edges;

	public EdgeWeightedGraph(int noOfVertices) {
		this.V = noOfVertices;
	}

	public void addEdge(Edge e) {
		if (edges[e.v] == null) {
			edges[e.v] = new ArrayList<>();
		}
		edges[e.v].add(e);

		if (edges[e.w] == null) {
			edges[e.w] = new ArrayList<>();
		}
		edges[e.w].add(e);
	}

	Iterable<Edge> adjacent(int v) {
		return edges[v];
	}

	Iterable<Edge> edges() {
		return Arrays.stream(edges).flatMap(list -> list.stream()).collect(Collectors.toList());
	}
}
