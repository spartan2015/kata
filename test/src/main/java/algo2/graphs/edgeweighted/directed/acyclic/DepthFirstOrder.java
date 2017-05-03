package algo2.graphs.edgeweighted.directed.acyclic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo2.graphs.edgeweighted.directed.DirectedEdge;
import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;

/**
 * PrecedenceConstraintSchedulingAkaTopologicalOrder
 * 
 * if it has not cycle - then a dfs will discover the EXACT ORDER (add that to
 * some List and voila) = topological order
 * 
 * @author vasil
 *
 */
public class DepthFirstOrder {

	EdgeWeightedDiagraph graph;
	boolean[] marked;

	Queue<Integer> preOrder = new LinkedList<>();
	Queue<Integer> postOrder = new LinkedList<>();
	LinkedList<Integer> reversePostOrder = new LinkedList<>();

	public DepthFirstOrder(EdgeWeightedDiagraph graph) {
		this.graph = graph;
		this.marked = new boolean[graph.V()];
		for (int v = 0; v < graph.V(); v++) {
			dfs(v);
		}
	}

	private void dfs(int v) {
		if (marked[v])
			return;
		marked[v] = true;
		preOrder.offer(v);
		for (DirectedEdge e : graph.adjacent(v)) {
			int w = e.to();
			dfs(w);
		}
		postOrder.offer(v);
		reversePostOrder.offerFirst(v);
	}

	public Queue<Integer> getPreOrder() {
		return preOrder;
	}

	public Queue<Integer> getPostOrder() {
		return postOrder;
	}

	public List<Integer> getReversePostOrder() {
		return reversePostOrder;
	}
}