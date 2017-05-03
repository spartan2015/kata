package algo2.graphs.tests;

import org.junit.Test;

import algo2.graphs.ArrayListGraph;
import algo2.graphs.DepthFirstPaths;

public class PathsTest {

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
		
		DepthFirstPaths paths = new DepthFirstPaths(graph, 0);
		for (int i = 0; i < 6; i++) {
			System.out.print("start " + i + ": ");
			for (int w : paths.path(i)) {
				System.out.print("-> " + w);
			}
			System.out.println();
		}
	}
}
