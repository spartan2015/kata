package algo2.graphs.directed;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class AreNodesConnectedInDirectedGraph {

	@Test
	public void test(){
		 DirectedGraph graph = new  DirectedGraph(10);
		 graph.addEdge(1, 2);
		 graph.addEdge(2, 3);
		 graph.addEdge(3, 4);
		 graph.addEdge(2, 5);
		 graph.addEdge(2, 6);
		 
		 DFS dfs = new DFS(graph, 1);
		 assertTrue(dfs.isNodeReachable(4));
		 
		 Iterator it = graph.adjacent(3).iterator();
		 it.next();
		 it.remove();
		 
		 dfs = new DFS(graph, 1);
		 graph.draw();
		 
		 assertFalse(dfs.isNodeReachable(4));
	}
	
	static class DFS {
		private DirectedGraph graph;
		boolean[] marked;

		public DFS(DirectedGraph graph, int source) {
			this.graph = graph;
			this.marked = new boolean[graph.getNoOfVertices()];
			dfs(source);
		}

		private void dfs(int v) {
			if (marked[v]) {
				return;
			}
			marked[v] = true;
			for (int w : graph.adjacent(v)) {
				dfs(w);
			}
		}

		public boolean isNodeReachable(int v) {
			return marked[v];
		}
	}
}
