package algo2.graphs.edgeweighted;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMinimumSpanningTree {
	EdgeWeightedGraph graph;
	boolean[] marked;
	Queue<Edge> mst = new LinkedList<>();
	PriorityQueue<Edge> minpq = new PriorityQueue<>();

	public LazyPrimMinimumSpanningTree(EdgeWeightedGraph graph) {
		this.graph = graph;
		marked = new boolean[graph.V];

		visit(0);
		while (!minpq.isEmpty()) {
			Edge e = minpq.poll();
			mst.add(e);
			int v = e.either();
			int w = e.other(v);
			if (marked[v] && marked[w])
				continue;
			if (!marked[v])
				visit(v);
			if (!marked[w])
				visit(w);
		}
	}

	private void visit(int v) {
		marked[v] = true;
		for (Edge e : graph.adjacent(v)) {
			if (!marked[e.other(v)]) {
				minpq.offer(e);
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return mst.stream().mapToDouble(e -> e.weight).sum();
	}
}
