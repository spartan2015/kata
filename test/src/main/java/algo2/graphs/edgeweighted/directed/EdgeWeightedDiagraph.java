package algo2.graphs.edgeweighted.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EdgeWeightedDiagraph {
	int V;
	int E;
	List<DirectedEdge>[] adj;
	
	public EdgeWeightedDiagraph(int size) {
		this.V = size;
		adj = new List[V];
		Arrays.setAll(adj, i->new ArrayList());
	}

	public void addEdge(int from, int to, double weight) {
		addEdge(new DirectedEdge(from, to, weight));
	}
	
	public void addEdge(DirectedEdge edge) {
		adj[edge.from()].add(edge);
		E++;
	}

	public Iterable<DirectedEdge> adjacent(int v) {
		return adj[v];
	}

	public Iterable<DirectedEdge> edges() {
		return Arrays.stream(adj).flatMap(list -> list.stream()).collect(Collectors.toList());
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
}
