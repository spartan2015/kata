package algo2.graphs.edgeweighted.directed;

import java.util.PriorityQueue;

import algo2.graphs.edgeweighted.VertexAndDistanceToIt;

/**
 * effective for non negative values
 * complexity E log V
 * 
 * works the same for unidirected graphs
 * 
 * @author vasil
 *
 */
public class DijkstrasShortestPath extends ShortestPath{

	PriorityQueue<VertexAndDistanceToIt> minpq = new PriorityQueue<>();
	
	public DijkstrasShortestPath(EdgeWeightedDiagraph diagraph, int s) {
		super(diagraph, s);
		minpq.add(new VertexAndDistanceToIt(0, 0.0));
		while(!minpq.isEmpty()){
			VertexAndDistanceToIt next = minpq.poll();
			
			relax(next.v);
			for(DirectedEdge fromVToW : diagraph.adjacent(next.v)){
				// can be optimized so q changes only when relax fromVtoW happens 
				
			}
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
				changeInPqDistanceTo(w, newDist);				
			}
		}		
	}

	private void changeInPqDistanceTo(int w, double newDist) {
		VertexAndDistanceToIt existingDistanceToW = new VertexAndDistanceToIt(w, 0.0);
		if (minpq.contains(existingDistanceToW)){
			minpq.remove(existingDistanceToW);
		}
		minpq.add(new VertexAndDistanceToIt(w, newDist));
	}

}
