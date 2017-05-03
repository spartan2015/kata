package algo2.graphs.edgeweighted;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Complexity
 * 
 * space is V
 * time is E log V
 * 
 * @author vasil
 *
 */
public class EagerPrimMinimumSpanningTree {

	EdgeWeightedGraph graph;
	boolean[] marked;

	Edge[] edgeTo;
	double[] distTo;

	PriorityQueue<VertexAndDistanceToIt> minpq = new PriorityQueue<>();

	public EagerPrimMinimumSpanningTree(EdgeWeightedGraph graph) {

		this.graph = graph;

		marked = new boolean[graph.V];
		edgeTo = new Edge[graph.V];
		distTo = new double[graph.V];
		Arrays.setAll(distTo, d -> Double.POSITIVE_INFINITY);

		distTo[0] = 0;

		minpq.offer(new VertexAndDistanceToIt(0, 0.0));

		while (!minpq.isEmpty()) {
			visit(minpq.poll().v);
		}
	}

	private void visit(int v) {
		marked[v] = true;
		for (Edge fromVToW : graph.adjacent(v)) {
			int w = fromVToW.other(v);
			if (marked[w])
				continue;
			if (fromVToW.weight < distTo[w]) {
				edgeTo[w] = fromVToW;
				distTo[w] = fromVToW.weight;
				if (minpq.contains(new VertexAndDistanceToIt(w, 0.0))) {
					minpq.remove(new VertexAndDistanceToIt(w, 0.0));
				}
				minpq.add(new VertexAndDistanceToIt(w, fromVToW.weight));
			}
		}
	}

	public Iterable<Edge> edges() {
		return Arrays.stream(edgeTo).collect(Collectors.toList());
	}

	public double weight() {
		return Arrays.stream(edgeTo).mapToDouble(e->e.weight).sum();
	}

}
