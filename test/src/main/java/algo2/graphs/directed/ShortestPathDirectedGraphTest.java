package algo2.graphs.directed;

import org.junit.Test;

public class ShortestPathDirectedGraphTest {

	@Test
	public void test(){
		DirectedGraph graph = new DirectedGraph(10);
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		
		graph.addEdge(5, 4);
		
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		
		ShortestPathDirectedGraph shortestPathDirectedGraph = new ShortestPathDirectedGraph(graph);
		
		shortestPathDirectedGraph.bfs(0, 4);
		System.out.println(shortestPathDirectedGraph.getPath(0, 4));
		System.out.println(shortestPathDirectedGraph.getPath(0, 3));
		System.out.println(shortestPathDirectedGraph.getPath(0, 2));
	}
	
}
