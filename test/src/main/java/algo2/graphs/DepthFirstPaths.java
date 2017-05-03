package algo2.graphs;

import java.util.Iterator;

import org.junit.Test;

public class DepthFirstPaths {
	AbstractGraph graph;
	int source;
	boolean[] marked;
	int[] arrivedFrom;

	public DepthFirstPaths(AbstractGraph graph, int source) {
		this.graph = graph;
		this.source = source;
		marked = new boolean[graph.noOfVertices];
		arrivedFrom = new int[graph.noOfVertices];
	}

	boolean hasPath(int to) {
		return marked[to];
	}

	public Iterable<Integer> path(final int to) {
		dfs(source);

		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {

				return new Iterator<Integer>() {
					int next = to;

					@Override
					public boolean hasNext() {
						return next != source;
					}

					@Override
					public Integer next() {
						int from = arrivedFrom[next];
						next = arrivedFrom[next];
						return from;
					}
				};
			}

		};
	}

	private void dfs(int v) {
		marked[v] = true;
		for (int w : graph.adjacent(v)) {
			if (!marked[w]) {
				System.out.println(v + "->" + w);
				arrivedFrom[w] = v;
				dfs(w);
			}
		}
	}

}
