package algo2.graphs.edgeweighted.directed.acyclic;

import algo2.graphs.edgeweighted.directed.DirectedEdge;
import algo2.graphs.edgeweighted.directed.EdgeWeightedDiagraph;
import algo2.graphs.edgeweighted.directed.ShortestPath;

/**
 * handles negative, is simpler than Dijkstras
 * 
 * complexity linear V
 * 
 * ayclic graphs
 * 
 * DOES NOT WORK - SHOULD DEBUG FIXME	
 * 
 * @author vasil
 *
 */
public class DagLongestPathByReversingWeightsForShortest extends ShortestPath{
	
	public DagLongestPathByReversingWeightsForShortest(EdgeWeightedDiagraph diagraph, int s) {
		super(diagraph, s);
		
		reverseWeights(diagraph);
		
		for(int v : new TopologicalOrder(diagraph).getOrder()){			
			relax(v);
		}
	}
	
	private EdgeWeightedDiagraph reverseWeights(EdgeWeightedDiagraph diagraph) {
		EdgeWeightedDiagraph newDiagraph = new EdgeWeightedDiagraph(diagraph.V());
		for(DirectedEdge e : diagraph.edges()){
			newDiagraph.addEdge(new DirectedEdge(e.v, e.w, -1 * e.weight));
		}
		diagraph = newDiagraph;
		return diagraph;
	}

	
	@Override
	protected void relax(int v) {
		for(DirectedEdge toWFromV : diagraph.adjacent(v)){
			double newDist = distTo[v]+toWFromV.weight;
			int w = toWFromV.to();
			if(distTo[w] > newDist){
				distTo[w] = newDist;
				edgeTo[w] = toWFromV;				
			}
		}		
	}

}
