package algo2.graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class BreadthFirstSearch {
	LinkedList<Integer> queue = new LinkedList<>();
	AbstractGraph graph;
	int source;
	boolean[] marked;
	int[] arrivedFrom;

	public BreadthFirstSearch(AbstractGraph graph, int source) {
		this.graph = graph;
		this.source = source;
		marked = new boolean[graph.noOfVertices];
		arrivedFrom = new int[graph.noOfVertices];
		Arrays.setAll(arrivedFrom, i -> -1);
		bfs(this.source);
	}

	public Iterable<Integer> pathTo(int v) {
		LinkedList<Integer> pathTo = new LinkedList<>();
		System.out.print(v + "");
		pathTo.addFirst(v);
		int count = 0;
		while (v != source) {
			v = arrivedFrom[v];
			pathTo.addFirst(v);
			System.out.print("->" + v + "");
			count++;
		}
		System.out.println();
		return pathTo;
	}

	public int search(int v) {
		bfs(source);
		int count = 0;
		for (int i : pathTo(v))
			count++;
		return count;
	}

	private void bfs(int v) {
		queue.add(source);
		while (!queue.isEmpty()) {
			int next = queue.removeFirst();
			analyzeNode(next);
		}
	}

	private void analyzeNode(int v) {
		System.out.print("found " + v + ": ");
		if (marked[v])
			return;
		marked[v] = true;

		Iterable<Integer> adjacent = graph.adjacent(v);
		for (int w : adjacent) {
			System.out.print(w + ", ");
			if (arrivedFrom[w] == -1) {
				arrivedFrom[w] = v;
				queue.add(w);
			}
		}
		System.out.println(";");
	}

}