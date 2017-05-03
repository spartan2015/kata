package algo2.graphs.edgeweighted.directed.acyclic;

import java.util.Arrays;
import java.util.Stack;

import algo2.graphs.edgeweighted.directed.DirectedEdge;
import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;

public class EdgeWeightedDirectedGraphCycleDetector {

	boolean[] marked;
	int[] arrivedFrom;
	Stack<Integer> cycleStack = null;
	Stack<DirectedEdge> edgeCycleStack = new Stack<>();
	EdgeWeightedDiagraph graph;
	DirectedEdge[] edgeTo;
	boolean cycle = false;
	
	public EdgeWeightedDirectedGraphCycleDetector(EdgeWeightedDiagraph graph) {
		this.graph = graph;
		this.marked = new boolean[graph.V()];
		this.arrivedFrom = new int[graph.V()];
		this.edgeTo = new DirectedEdge[graph.V()];
		Arrays.setAll(this.arrivedFrom, n->n-1);
		for(int v = 0; v < this.graph.V(); v++){
			dfs(v, v);
		}
	}
	
	public Stack<Integer> getCycleStack() {
		return cycleStack;
	}
	
	public boolean hasCycle() {
		return cycle;
	}
	
	public boolean isAcyclic() {
		return !cycle;
	}
	
	public Stack<DirectedEdge> getEdgeCycleStack() {
		return edgeCycleStack;
	}
	
	private void dfs(int v, int startedFrom){
		if (marked[v]) return;
		marked[v]=true;
		for(DirectedEdge e : graph.adjacent(v)){
			int w = e.to();
			if (w==startedFrom){
				cycle = true;
				cycleStack = new Stack<>();
				for(int x = v; x!=startedFrom; x=arrivedFrom[x]){
					cycleStack.push(x);
					edgeCycleStack.push(edgeTo[x]);
				}
				cycleStack.push(startedFrom);
				edgeCycleStack.push(e);
			}else{
				edgeTo[w] = e;
				arrivedFrom[w]=v;
				dfs(w, startedFrom);
			}
		}
	}
}
