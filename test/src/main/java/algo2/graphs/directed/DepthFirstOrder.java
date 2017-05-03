package algo2.graphs.directed;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

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

	DirectedGraph graph;
	boolean[] marked;

	Queue<Integer> preOrder = new LinkedList<>();
	Queue<Integer> postOrder = new LinkedList<>();
	Stack<Integer> reversePostOrder = new Stack<>();

	public DepthFirstOrder(DirectedGraph graph) {
		this.graph = graph;
		this.marked = new boolean[graph.getNoOfVertices()];
		for (int v = 0; v < graph.getNoOfVertices(); v++) {
			dfs(v);
		}
	}

	private void dfs(int v) {
		if (marked[v])
			return;
		marked[v] = true;
		preOrder.offer(v);
		for (int w : graph.adjacent(v)) {
			dfs(v);
		}
		postOrder.offer(v);
		reversePostOrder.push(v);
	}

	public Queue<Integer> getPreOrder() {
		return preOrder;
	}

	public Queue<Integer> getPostOrder() {
		return postOrder;
	}

	public Stack<Integer> getReversePostOrder() {
		return reversePostOrder;
	}
}