package algo2.graphs.edgeweighted;

public class Edge implements Comparable<Edge> {

	int v;
	int w;
	double weight;

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either(){
		return v;
	}
	
	public int other(int v){
		return this.v == v ? w : v;
	} 
	
	@Override
	public int compareTo(Edge edge) {
		return Double.valueOf(weight).compareTo(Double.valueOf(edge.weight));
	}

	public String toString(){
		return "Edge[v="+v+",w="+v+",weight="+weight+"]";
	}
}
