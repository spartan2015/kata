package algo2.graphs.directed;

/**
 * web pages
 * program modules
 * book topics
 * animal food chain
 * etc.
 * 
 * Algo: Kosaraju's algorithm - also used for uni graphs in finding Connected Components
 * 
 * @author vasil
 *
 */
public class StrongConnectedComponents {
	
	DirectedGraph graph;
	boolean[] marked;
	int[] id;
	int count;
	
	public StrongConnectedComponents(DirectedGraph graph) {
		this.graph = graph;
		marked = new boolean[graph.getNoOfVertices()];
		id = new int[graph.getNoOfVertices()];
		DepthFirstOrder order = new DepthFirstOrder(graph.reverse());
		for(int v : order.getReversePostOrder()){
			if (!marked[v]){
				dfs(v); 
				count++;
			}
		}
	}
	
	private void dfs(int v) {
		if (marked[v]) return;
		marked[v]=true;
		id[v]=count;
		for(int w : graph.adjacent(v)){
			dfs(w);
		}
	}

	public boolean stronglyConnected(int v, int w){
		return id[v] == id[w];
	}
	
	/**
	 * number of strong components 
	 * 
	 * @return
	 */
	public int count(){
		return count;	
	}
	
	/**
	 * component identifier for vertex v
	 * 
	 * @param v
	 * @return
	 */
	public int id(int v){
		return id[v];
	}
}
