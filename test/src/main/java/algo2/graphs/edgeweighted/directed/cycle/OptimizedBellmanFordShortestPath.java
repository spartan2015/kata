package algo2.graphs.edgeweighted.directed.cycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import algo2.graphs.edgeweighted.directed.DirectedEdge;
import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;
import algo2.graphs.edgeweighted.directed.acyclic.EdgeWeightedDirectedGraphCycleDetector;

/**
 * complexity: E*V
 * 
 * q base algo
 * 
 * widely used in practice
 * 
 * @author vasil
 *
 */
public class OptimizedBellmanFordShortestPath {

	EdgeWeightedDiagraph diagraph;
	DirectedEdge[] edgeTo;
	double[] distTo;
	Queue<Integer> queue = new LinkedList<>();
	boolean[] onQ;
	int cost;
	Iterable<DirectedEdge> negativeCycle; // is there a negative cycle in
											// edgeTo[]?

	public OptimizedBellmanFordShortestPath(EdgeWeightedDiagraph diagraph) {
		this.diagraph = diagraph;
		edgeTo = new DirectedEdge[diagraph.V()];
		distTo = new double[diagraph.V()];
		onQ = new boolean[diagraph.V()];
		Arrays.setAll(distTo, i -> Double.POSITIVE_INFINITY);
		distTo[0] = 0;

		queue.add(0);
		onQ[0] = true;
		while (!queue.isEmpty() && !hasNegativeCycle()) {
			Integer v = queue.remove();
			onQ[v] = false;
			relax(v);
		}
	}

	public Iterable<DirectedEdge> getNegativeCycle() {
		return negativeCycle;
	}

	public boolean hasNegativeCycle() {
		return negativeCycle != null;
	}

	private void relax(int v) {
		for (DirectedEdge vToW : diagraph.adjacent(v)) {
			int w = vToW.to();
			double distVtoW = distTo[v] + vToW.weight;
			if (distTo[w] > distVtoW) {
				distTo[w] = distVtoW;
				edgeTo[w] = vToW;

				if (!onQ[w]) {
					queue.add(w);
					onQ[w] = true;
				}
			}

			if (cost++ % diagraph.V() == 0) {
				findNegativeCycle();
			}
		}
	}

	private void findNegativeCycle() {
		EdgeWeightedDirectedGraphCycleDetector cycleDetector = new EdgeWeightedDirectedGraphCycleDetector(
				constructDiagraphFromEdgeTo());
		if (cycleDetector.hasCycle()) {
			this.negativeCycle = new ArrayList<>(cycleDetector.getEdgeCycleStack());
		}
	}

	private EdgeWeightedDiagraph constructDiagraphFromEdgeTo() {
		EdgeWeightedDiagraph edgeWeightedDiagraph = new EdgeWeightedDiagraph(edgeTo.length);
		for (int v = 0; v < diagraph.V(); v++) {
			if (edgeTo[v] != null) {
				edgeWeightedDiagraph.addEdge(edgeTo[v]);
			}
		}
		return edgeWeightedDiagraph;
	}

	public double distTo(int t) {
		return distTo[t];
	}

	public boolean hasPathTo(int t) {
		return distTo[t] != Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int t) {
		if (!hasPathTo(t)) {
			return null;
		}
		Stack<DirectedEdge> path = new Stack<>();
		DirectedEdge edge = null;
		while ((edge = edgeTo[t]) != null) {
			path.push(edge);
			t = edge.v;
		}
		return path;
	}
}