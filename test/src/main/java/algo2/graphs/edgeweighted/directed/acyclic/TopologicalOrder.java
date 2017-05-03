package algo2.graphs.edgeweighted.directed.acyclic;

import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;

public class TopologicalOrder {

	EdgeWeightedDiagraph graph;
	Iterable<Integer> order;

	public TopologicalOrder(EdgeWeightedDiagraph graph) {
		this.graph = graph;
		if(!new EdgeWeightedDirectedGraphCycleDetector(graph).hasCycle()){
			order = new DepthFirstOrder(graph).getReversePostOrder(); 
		}	
	}
	
	public Iterable<Integer> getOrder() {
		return order;
	}
	
	public boolean isDAG(){
		return order!=null;
	}
}
