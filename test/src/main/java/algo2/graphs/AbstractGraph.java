package algo2.graphs;

import sedgewick.In;

public abstract class AbstractGraph {
	int noOfVertices;
	int noOfEdges;
	boolean hasCycle = false;
	boolean isBiPartite = true;

	public AbstractGraph(int v) {
		noOfVertices = v;
	}

	public AbstractGraph(In in) {
	}

	public abstract void addEdge(int v, int w);

	public abstract Iterable<Integer> adjacent(final int v);

	public int noOfVertices() {
		return noOfVertices;
	}

	public abstract int noOfEdges();

	public int degree(int v) {
		int degree = 0;
		for (int w : adjacent(v))
			degree++;
		return degree;
	}

	public int maxDegree() {
		int max = 0;
		for (int i = 0; i < noOfVertices; i++) {
			int current = degree(i);
			if (current > max) {
				max = current;
			}
		}
		return max;
	}

	public double averageDegree() {
		return 2 * noOfEdges / noOfVertices;
	}

	public int countSelfLoops() {
		int selfLoops = 0;
		for (int i = 0; i < noOfVertices; i++) {
			for (int w : adjacent(i)) {
				if (i == w)
					selfLoops++;
			}
		}
		return selfLoops / 2;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < noOfVertices; i++) {
			for (int w : adjacent(i)) {
				sb.append("(" + i + "," + w + ")");
			}
		}
		return sb.toString();
	}

	public boolean isBiPartite() {
		return isBiPartite;
	}

	public void setBiPartite(boolean isBiPartite) {
		this.isBiPartite = isBiPartite;
	}

	public boolean isHasCycle() {
		return hasCycle;
	}

	public void setHasCycle(boolean hasCycle) {
		this.hasCycle = hasCycle;
	}
}
