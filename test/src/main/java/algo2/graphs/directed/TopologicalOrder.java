package algo2.graphs.directed;

public class TopologicalOrder {

	DirectedGraph graph;
	Iterable<Integer> order;

	public TopologicalOrder(DirectedGraph graph) {
		this.graph = graph;
		if(!new DirectedGraphCycleDetector(graph).hasCycle()){
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
