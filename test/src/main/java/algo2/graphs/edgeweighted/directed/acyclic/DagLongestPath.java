package algo2.graphs.edgeweighted.directed.acyclic;

import java.util.Arrays;
import java.util.Stack;

import algo2.graphs.edgeweighted.directed.DirectedEdge;
import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;
import algo2.graphs.edgeweighted.directed.ShortestPath;

/**
 * handles negative, is simpler than Dijkstras
 * 
 * complexity linear V
 * 
 * ayclic graphs
 * 
 * @author vasil
 *
 */
public class DagLongestPath{
	
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
	
	public DagLongestPath(EdgeWeightedDiagraph diagraph, int s) {
		this.diagraph = diagraph;
		this.s = s;
		distTo = new double[diagraph.V()];
		edgeTo = new DirectedEdge[diagraph.V()];
		Arrays.setAll(distTo, i -> Double.NEGATIVE_INFINITY);
		distTo[s] = 0;
		
		
		for(int v : new TopologicalOrder(diagraph).getOrder()){			
			relax(v);
		}
	}
	
	protected void relax(int v) {
		for(DirectedEdge toWFromV : diagraph.adjacent(v)){
			double newDist = distTo[v]+toWFromV.weight;
			int w = toWFromV.to();
			if(distTo[w] < newDist){
				distTo[w] = newDist;
				edgeTo[w] = toWFromV;				
			}
		}		
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

}
