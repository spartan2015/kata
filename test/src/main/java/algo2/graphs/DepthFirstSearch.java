package algo2.graphs;

public class DepthFirstSearch {
	private AbstractGraph graph;
	private boolean[] connected;
	private int source;
	private int count;
	private boolean[] color;
	
	public DepthFirstSearch(AbstractGraph graph, int source){
		this.graph = graph;
		this.connected = new boolean[graph.noOfVertices];
		this.color = new boolean[graph.noOfVertices];
		this.source = source;
		depthFirstScan(source, source);
	}
	
	public boolean[] getConected(){
		return connected;
	}
	
	public boolean isConnected(int v){
		return connected[v];
	}
	
	public int count(){		
		return count;
	}

	private void depthFirstScan(int v, int pa) {
		connected[v] = true;
		count++;
		for (int w : graph.adjacent(v)){
			if (!isConnected(w)){
				color[w] = !color[v];
				depthFirstScan(w,v);
			}else {
				if(w != pa){
					graph.hasCycle = true;
				}
				if (color[w] == color[v]){
					graph.isBiPartite = false;
				}
			}
		}
	}
}
