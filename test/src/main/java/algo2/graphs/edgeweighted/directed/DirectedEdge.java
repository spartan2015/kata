package algo2.graphs.edgeweighted.directed;

public class DirectedEdge {

	public final int v;
	public final int w;
	public final double weight;

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	@Override
	public boolean equals(Object obj) {
		DirectedEdge other = (DirectedEdge)obj;
		return this.v == other.v && this.w == other.w && this.weight == other.weight;
	}
	
	public String toString() {
		return String.format("DirectedEdge[from=%d,to=%d,weight=%.2f", v, w, weight);
	}

}
