package algo2.graphs;

import java.util.LinkedList;
import java.util.List;

public class ArrayListGraph extends AbstractGraph {

	private List<Integer>[] connections;
	int noOfEdges = 0;

	public ArrayListGraph(int v) {
		super(v);
		connections = new List[v];
	}

	@Override
	public void addEdge(int v, int w) {
		createListIfEmpty(v);
		createListIfEmpty(w);
		connections[v].add(w);
		connections[w].add(v);
		noOfEdges++;
	}

	private void createListIfEmpty(int v) {
		if (connections[v] == null) {
			connections[v] = new LinkedList<>();
		}
	}

	@Override
	public Iterable<Integer> adjacent(int v) {
		return connections[v];
	}

	@Override
	public int noOfEdges() {
		return noOfEdges;
	}
}
