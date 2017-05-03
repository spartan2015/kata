package trees.algo.s2;

import static org.junit.Assert.*;

import org.junit.Test;

import algo2.graphs.directed.DirectedGraph;

public class RouteBetweeen2Nodes {

	@Test
	public void test(){
		DirectedGraph graph = new DirectedGraph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		
		assertTrue(isRoute(graph, 0, 2));
	}
	
	public boolean isRoute(DirectedGraph graph, int s, int t){
		boolean marked[] = new boolean[graph.getNoOfVertices()];
		dfs(s,graph, marked);
		return marked[t];
	}

	private void dfs(int v,DirectedGraph graph, boolean[] marked) {
		if (marked[v]) return;
		marked[v]=true;
		for(int w : graph.adjacent(v)){
			dfs(w, graph, marked);
		}
	}
	
	
}
