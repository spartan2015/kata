package algo2.graphs.edgeweighted.directed;

import java.util.Arrays;
import java.util.Stack;

public abstract class ShortestPath {
	protected EdgeWeightedDiagraph diagraph;
	protected int s;
	/**
	 * points to parent edgeTo[s] = null by convention
	 */
	protected DirectedEdge[] edgeTo;
	/**
	 * distance from s to every v distoTo[s]=0 by convention not reachable
	 * nodes: Double.POSITIVE_INFINITY
	 */
	protected double[] distTo;

	public ShortestPath(EdgeWeightedDiagraph diagraph, int s) {
		this.diagraph = diagraph;
		this.s = s;
		distTo = new double[diagraph.V];
		edgeTo = new DirectedEdge[diagraph.V];
		Arrays.setAll(distTo, i -> Double.POSITIVE_INFINITY);
		distTo[s] = 0;
	}

	public double distTo(int t) {
		return distTo[t];
	}

	public boolean hasPathTo(int t) {
		return distTo[t]!=Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int t) {
		if (!hasPathTo(t)){
			return null;
		}
		Stack<DirectedEdge> path = new Stack<>();
		DirectedEdge edge = null;
		while( (edge = edgeTo[t])!=null){
			path.push(edge);
			t= edge.v;
		}
		return path;
	}

	/**
	 * vertex relaxation
	 * @param v
	 */
	protected void relax(int v) {
		if (diagraph.adjacent(v)==null) return;
		for (DirectedEdge fromVtoW : diagraph.adjacent(v)) {
			int w = fromVtoW.to();
			double distThroughV = distTo[v] + fromVtoW.weight;
			if (distTo[w] > distThroughV) {
				distTo[w] = distThroughV;
				edgeTo[w] = fromVtoW;
			}
		}
	}

	/**
	 * edge relaxation
	 * 
	 * @param edgeFromVtoW
	 */
	protected void relax(DirectedEdge edgeFromVtoW) {
		int v = edgeFromVtoW.from();
		int w = edgeFromVtoW.to();
		double distanceThroughNodeV = distTo[v] + edgeFromVtoW.weight;
		if (distTo[w] > distanceThroughNodeV) {
			distTo[w] = distanceThroughNodeV;
			edgeTo[w] = edgeFromVtoW;
		}
	}
}
