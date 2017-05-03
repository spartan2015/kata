package algo2.graphs;

/**
 * Kosaraju's algorithm for Connected Components
 * 
 * @author vasil
 *
 */
public class ConnectedComponents {
	AbstractGraph graph;
	boolean[] marked;
	public int[] id;

	public ConnectedComponents(AbstractGraph graph) {
		this.graph = graph;
		marked = new boolean[graph.noOfVertices];
		id = new int[graph.noOfVertices];
		initialScan();
	}

	/**
	 * are v and w connected (is there a path between them)
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	private void initialScan() {
		int componentId = 0;
		int firstDisconnected = 0;
		do {
			DepthFirstSearch dfs = new DepthFirstSearch(graph, firstDisconnected);
			firstDisconnected = addConnected(dfs, firstDisconnected, componentId);
			componentId++;
		} while (firstDisconnected >= 0);
	}

	private int addConnected(DepthFirstSearch dfs, int startFrom, int componentId) {
		int firstDisconnected = -1;
		for (int i = startFrom; i < graph.noOfVertices; i++) {
			if (dfs.isConnected(i)) {
				id[i] = componentId;
			} else if (firstDisconnected == -1) {
				firstDisconnected = i;
			}
		}
		return firstDisconnected;
	}

	/**
	 * no of connected components
	 * 
	 * @return
	 */
	public int count() {
		int count = 1;
		for (int i = 1; i < graph.noOfVertices; i++) {
			if (id[i] != id[i - 1]) {
				count++;
			}
		}
		return count;
	}

	/**
	 * component identifier for v between 0 and count()-1
	 * 
	 * @param v
	 * @return
	 */
	public int id(int v) {
		return id[v];
	}
}
