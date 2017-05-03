package algo2.graphs.directed;

/**
 * we use this to determine reachability in a directed graph - efficiently (like
 * constant time in CC example)
 * 
 * computes the transitive closure of another graph - so we can determine all pairs reachability
 * 
 * first solution based on DFS is only effective for small graphs
 * because space is V*V (OUCH), time is ok though is V+E
 * 
 * @author vasil
 *
 */
public class TransitiveClosure {

	DirectedGraph graph;
	DirectedDFS[] all;
	
	public TransitiveClosure(DirectedGraph graph) {
		this.graph = graph;
		DirectedDFS[] all = new DirectedDFS[graph.getNoOfVertices()];
		for(int v = 0; v<graph.getNoOfVertices(); v++){
			all[v] = new DirectedDFS(graph, v);
		}
	}
	
	/**
	 * all pairs reachability 
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean reachable(int v, int w){
		return all[v].isMarked(w);
	}
	
}
