package algo2.graphs.edgeweighted;

public class VertexAndDistanceToIt implements Comparable<VertexAndDistanceToIt> {
	public int v;
	public Double weight;

	public VertexAndDistanceToIt(int v, double weight) {
		this.v = v;
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		VertexAndDistanceToIt other = (VertexAndDistanceToIt) obj;
		return this.v == other.v;
	}

	@Override
	public int compareTo(VertexAndDistanceToIt o) {
		return this.weight.compareTo(o.weight);
	}
}