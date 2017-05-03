package algo2.graphs.edgeweighted;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import datastructures.UnionFind;

/**
 * a bit slower than prim's algo: E log E
 * 
 * @author vasil
 *
 */
public class KruskalAlgorithmMinimumSpanningTree {

	EdgeWeightedGraph graph;
	Queue<Edge> mst = new LinkedList<>();
	
	
	public KruskalAlgorithmMinimumSpanningTree(EdgeWeightedGraph graph) {
		this.graph = graph;
		
		PriorityQueue<Edge> minpq = new PriorityQueue<Edge>((List)graph.edges());
		UnionFind unionFind = new UnionFind(graph.V);
		
		while(!minpq.isEmpty() && mst.size() < graph.V -1){
			Edge e = minpq.poll();
			int v= e.either();
			int w = e.other(v);
			if (unionFind.connected(v, w)) continue;
			unionFind.union(v, w);
			mst.offer(e);
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	public double weight(){
		return mst.stream().mapToDouble(e->e.weight).sum();
	}
}
