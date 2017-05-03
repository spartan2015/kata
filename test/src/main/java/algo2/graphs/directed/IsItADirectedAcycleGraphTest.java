package algo2.graphs.directed;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsItADirectedAcycleGraphTest {

	@Test
	public void test(){
		DirectedGraph graph = new DirectedGraph(10);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		
		DirectedGraphCycleDetector isItADirectedAcycleGraph = new DirectedGraphCycleDetector(graph);
		assertTrue(isItADirectedAcycleGraph.hasCycle());
		System.out.println(isItADirectedAcycleGraph.getCycleStack());
		
		graph.clearEdge(3);
		graph.addEdge(0, 3);
		
		isItADirectedAcycleGraph = new DirectedGraphCycleDetector(graph);
		assertFalse(isItADirectedAcycleGraph.hasCycle());
	}
}
