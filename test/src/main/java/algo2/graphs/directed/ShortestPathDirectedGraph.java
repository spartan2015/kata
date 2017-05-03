package algo2.graphs.directed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShortestPathDirectedGraph {

	DirectedGraph graph;
	boolean[] marked;
	int[] arrivedFrom;

	public ShortestPathDirectedGraph(DirectedGraph graph) {
		this.graph = graph;
		marked = new boolean[graph.getNoOfVertices()];
		arrivedFrom = new int[graph.getNoOfVertices()];
	}

	public List<Integer> getPath(int v, int w) {
		LinkedList<Integer> result = new LinkedList<>();
		int prev = w;
		do {
			result.offer(prev);
			prev = arrivedFrom[prev];
		} while (prev != -1 && prev != v);
		result.offer(prev);
		return result;
	}

	public void bfs(int v, int w) {
		marked = new boolean[graph.getNoOfVertices()];
		arrivedFrom = new int[graph.getNoOfVertices()];
		Arrays.setAll(arrivedFrom, i -> i - 1);

		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(v);
		while (!queue.isEmpty()) {
			int current = queue.pop();
			marked[current] = true;
			for (int adjacentNode : graph.adjacent(current)) {
				if (!marked[adjacentNode]) {
					marked[adjacentNode] = true;
					queue.push(adjacentNode);
					arrivedFrom[adjacentNode] = current;
				}
			}
		}
	}
}
