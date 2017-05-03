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
 * @author vasil
 *
 */
public class DagShortestPath extends ShortestPath{
	
	public DagShortestPath(EdgeWeightedDiagraph diagraph, int s) {
		super(diagraph, s);
		
		for(int v : new TopologicalOrder(diagraph).getOrder()){			
			relax(v);
		}
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
