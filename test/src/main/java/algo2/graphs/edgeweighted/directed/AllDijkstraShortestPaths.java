package algo2.graphs.edgeweighted.directed;

public class AllDijkstraShortestPaths {

	DijkstrasShortestPath[] allsp;
	
	public AllDijkstraShortestPaths(EdgeWeightedDiagraph diagraph) {
		allsp = new DijkstrasShortestPath[diagraph.V];
		for(int s =0; s< diagraph.V; s++){
			allsp[s] = new DijkstrasShortestPath(diagraph, s);
		}
	}
	
	public Iterable<DirectedEdge> path(int s, int t){
		return allsp[t].pathTo(t);
	}
	
	public double dist(int s, int t){
		return allsp[s].distTo(t);
	}
}
