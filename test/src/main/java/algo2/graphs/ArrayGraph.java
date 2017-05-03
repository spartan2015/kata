package algo2.graphs;

import java.util.Iterator;

public class ArrayGraph extends AbstractGraph{
	boolean[][] connections;
	int noOfVertices;
	int noOfEdges;

	public ArrayGraph(int v) {
		super(v);
		connections = new boolean[v][v];
	}

	public void addEdge(int v, int w) {
		noOfEdges++;
		connections[v][w] = true;
	}

	public Iterable<Integer> adjacent(final int v) {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {

				return new Iterator<Integer>() {
					int currentIndex = 0;

					@Override
					public boolean hasNext() {
						while (currentIndex < noOfVertices && connections[v][currentIndex] == false){
							currentIndex++;
						}	
						return currentIndex < noOfVertices;
					}

					@Override
					public Integer next() {
						return currentIndex++;
					}

				};
			}
		};
	}

	@Override
	public int noOfEdges() {
		return noOfEdges;
	}
}
