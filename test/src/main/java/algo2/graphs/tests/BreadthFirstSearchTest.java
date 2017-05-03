package algo2.graphs.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import algo2.graphs.ArrayListGraph;
import algo2.graphs.BreadthFirstSearch;

public class BreadthFirstSearchTest {
	@Test
	public void test() {
		ArrayListGraph graph = new ArrayListGraph(6);
		graph.addEdge(0, 5);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(1, 2);
		graph.addEdge(0, 1);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(0, 2);
		/**
		 */
		BreadthFirstSearch search = new BreadthFirstSearch(graph, 0);
		assertEquals("", Integer.valueOf(1), (Integer) search.search(5));
		assertEquals("", Integer.valueOf(1), (Integer) search.search(1));
		assertEquals("", Integer.valueOf(1), (Integer) search.search(2));
		assertEquals("", Integer.valueOf(2), (Integer) search.search(3));
		assertEquals("", Integer.valueOf(2), (Integer) search.search(4));
	}
}
