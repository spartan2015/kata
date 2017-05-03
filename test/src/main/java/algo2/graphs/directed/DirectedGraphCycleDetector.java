package algo2.graphs.directed;

import java.util.Arrays;
import java.util.Stack;

public class DirectedGraphCycleDetector {

	boolean[] marked;
	int[] arrivedFrom;
	Stack<Integer> cycleStack = null;
	DirectedGraph graph;
	boolean cycle = false;
	
	public DirectedGraphCycleDetector(DirectedGraph graph) {
		this.graph = graph;
		this.marked = new boolean[graph.getNoOfVertices()];
		this.arrivedFrom = new int[graph.getNoOfEdges()];
		Arrays.setAll(this.arrivedFrom, n->n-1);
		for(int v = 0; v < this.graph.getNoOfVertices(); v++){
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
	
	private void dfs(int v, int startedFrom){
		if (marked[v]) return;
		marked[v]=true;
		for(int w : graph.adjacent(v)){
			if (w==startedFrom){
				cycle = true;
				cycleStack = new Stack<>();
				for(int x = v; x!=startedFrom; x=arrivedFrom[x]){
					cycleStack.push(x);
				}
				cycleStack.push(startedFrom);
			}else{
				arrivedFrom[w]=v;
				dfs(w, startedFrom);
			}
		}
	}
}
