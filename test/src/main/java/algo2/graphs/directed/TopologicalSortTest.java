package algo2.graphs.directed;

import org.junit.Test;

/**
 * DFS complexity = V+E
 * @author vasil
 *
 */
public class TopologicalSortTest {

	@Test
	public void test() {
		String[] verticesNames = { "Calculus", "Linear Algebra", "Computer Science Fundamentals",
				"Theory of Computer Science" };
		DirectedGraph graph = new DirectedGraph(verticesNames.length);
		graph.addEdge(0, 1);
		// PreReq of Theory of Computer science
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		// Problem name: topological sort (the student must take the courses in
		// this order)
		// put the vertices in order so that all its directed edges point from
		// vertices earlier or report when this is not possible
		// a cycle makes this kind of problem unsolvable
		DepthFirstOrder topOrd = new DepthFirstOrder(
				graph);
		Iterable<Integer> preOrder2 = topOrd.getPreOrder();
		printOrder(verticesNames, preOrder2);
		printOrder(verticesNames, topOrd.getPostOrder());
		printOrder(verticesNames, topOrd.getReversePostOrder());
	}

	private void printOrder(String[] verticesNames, Iterable<Integer> iterable) {
		for (int v : iterable) {
			System.out.print("->" + verticesNames[v]);
		}
		System.out.println("");
	}
}