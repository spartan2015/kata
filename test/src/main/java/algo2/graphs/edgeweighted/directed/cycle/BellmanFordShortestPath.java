package algo2.graphs.edgeweighted.directed.cycle;

import java.util.Arrays;
import java.util.Stack;

import algo2.graphs.edgeweighted.directed.DirectedEdge;
import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;

/**
 * complexity: VE
 * 
 * general algo
 * 
 * @author vasil
 *
 */
public class BellmanFordShortestPath {

	EdgeWeightedDiagraph diagraph;
	DirectedEdge[] edgeTo;
	double[] distTo;

	public BellmanFordShortestPath(EdgeWeightedDiagraph diagraph) {
		this.diagraph = diagraph;
		edgeTo = new DirectedEdge[diagraph.V()];
		distTo = new double[diagraph.V()];
		Arrays.setAll(distTo, i -> Double.POSITIVE_INFINITY);
		distTo[0] = 0;

		for (int pass = 0; pass < diagraph.V(); pass++) {
			for (int v = 0; v < diagraph.V(); v++) {
				for (DirectedEdge vToW : diagraph.adjacent(v)) {
					relax(vToW);
				}
			}
		}

	}

	private void relax(DirectedEdge vToW) {
		int v = vToW.from();
		int w = vToW.to();
		double distVtoW = distTo[v] + vToW.weight;
		if (distTo[w] > distVtoW) {
			distTo[w] = distVtoW;
			edgeTo[w] = vToW;
		}
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