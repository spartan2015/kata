package algo2.graphs.edgeweighted.directed.cycle;

import org.junit.Test;

import algo2.graphs.edgeweighted.directed.DirectedEdge;
import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;

public class Arbitrage {

	@Test
	public void test() {
		String[] nodeNames = { "USD", "EUR", "CAD" };
		EdgeWeightedDiagraph ewd = new EdgeWeightedDiagraph(2);
		ewd.addEdge(0, 1, -Math.log(0.95));
		ewd.addEdge(1, 0, -Math.log(1.09)); // negative because going back to 0 when it distTo[0]=0 instead of Double.POSITIVE_INFINITY

		OptimizedBellmanFordShortestPath sp = new OptimizedBellmanFordShortestPath(ewd);
		if (sp.hasNegativeCycle()) {
			double stake = 1000;
			for (DirectedEdge e : sp.getNegativeCycle()) {
				System.out.println(String.format("%10.5f %s", stake, nodeNames[e.from()]));
				stake *= -Math.exp(e.weight);
				System.out.println(String.format(" = %10.5f %s", stake, nodeNames[e.to()]));
			}
		} else {
			System.out.println("no arbitrage opportunity");
		}
	}

}
