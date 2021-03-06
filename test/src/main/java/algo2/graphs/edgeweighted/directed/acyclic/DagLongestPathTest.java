package algo2.graphs.edgeweighted.directed.acyclic;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

import algo2.graphs.edgeweighted.directed.DirectedEdge;
import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;
import algo2.graphs.edgeweighted.directed.ShortestPath;

public class DagLongestPathTest {
	@Test
	public void test() {
		EdgeWeightedDiagraph diagraph = new EdgeWeightedDiagraph(11);
		diagraph.addEdge(0, 1, 10);
		diagraph.addEdge(1, 2, 1.0);
		diagraph.addEdge(2, 3, 1.1);
		diagraph.addEdge(3, 4, 1.3);
		diagraph.addEdge(4, 5, 1.2);
		
		diagraph.addEdge(0, 6, 1.2);
		diagraph.addEdge(0, 7, 1.2);
		diagraph.addEdge(7, 8, 1.2);
		diagraph.addEdge(9, 10, 1.2);
		//diagraph.addEdge(5, 1, 1.5);
		
		Iterable<DirectedEdge>[] expected = new Iterable[2];
		expected[1]=
				Arrays.asList(
				new DirectedEdge(5,1,1.5), 
				new DirectedEdge(4,5,1.2),
				new DirectedEdge(3,4,1.3),
				new DirectedEdge(2,3,1.1),
				new DirectedEdge(0,2,1.0)
				);
		
		checkPathTo(diagraph, expected);
	}

	private void checkPathTo(EdgeWeightedDiagraph diagraph, Iterable<DirectedEdge>[] expected) {
		int s = 0;
		DagLongestPath DagLongestPath = new DagLongestPath(diagraph, s);
		IntStream.rangeClosed(s, diagraph.V() - 1).forEach(t -> {
			System.out.println(String.format("%d to %d with total distance %.2f", s,t,DagLongestPath.distTo(t)));
			if (DagLongestPath.hasPathTo(t)) {
				Iterable<DirectedEdge> pathTo = DagLongestPath.pathTo(t);
				if (t < expected.length && expected[t] != null){
					//assertTrue(expected[t].equals(pathTo));
				}
				for (DirectedEdge edge : pathTo) {
					System.out.println("->" + edge);
				}
			}
		});
	}

	
	
}
