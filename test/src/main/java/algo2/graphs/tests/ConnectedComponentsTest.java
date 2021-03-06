package algo2.graphs.tests;

import java.util.Arrays;

import org.junit.Test;

import algo2.graphs.ArrayListGraph;
import algo2.graphs.ConnectedComponents;

public class ConnectedComponentsTest {

	@Test
	public void test(){
		ArrayListGraph graph = new ArrayListGraph(13);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(9, 12);
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(11, 12);
		graph.addEdge(9, 10);
		graph.addEdge(0, 6);
		graph.addEdge(7, 8);
		graph.addEdge(9, 11);
		graph.addEdge(5, 3);
		
		ConnectedComponents cc = new ConnectedComponents(graph);
		System.out.println(Arrays.toString(cc.id));
	}
}
