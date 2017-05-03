package algo2.graphs.tests;

import org.junit.Test;

import algo2.graphs.AbstractGraph;
import algo2.graphs.ArrayListGraph;
import algo2.graphs.BreadthFirstSearch;
import algo2.graphs.SymbolGraph;

public class SymbolGraphTest {
	@Test
	public void degreesOfSeparation() {
		String[] symbols = {"George","Seinfeld","Vasile","PreFor8kAMonth","Oracle"};
		AbstractGraph graph = new ArrayListGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		SymbolGraph symbolGraph =new SymbolGraph(graph,symbols);
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, symbolGraph.index("Vasile"));
		for(int ipath : bfs.pathTo(symbolGraph.index("Oracle"))){
			System.out.print("->" + symbolGraph.name(ipath));
		}
		System.out.println();
		
	}
}
