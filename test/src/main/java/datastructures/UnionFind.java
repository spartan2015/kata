package datastructures;

import java.util.stream.IntStream;

/**
 * like balancing a tree - logN complexity
 * @param v
 * @return
 */
public class UnionFind {
	int id[];
	int sz[];
	int N;
	int count;

	public UnionFind(int size) {
		this.N = size;
		id = new int[size];
		sz = new int[size];
		IntStream.rangeClosed(0, size - 1).forEach(i -> {
			id[i] = i;
			sz[i] = i;
		});
	}

	public boolean connected(int v, int w) {
		return find(v) == find(w);
	}

	/**
	 * like balancing a tree - logN complexity
	 * @param v
	 * @return
	 */
	private int find(int v) { // find the parent
		while (v != id[v]){
			v = id[v];
		}
		return v;
	}

	public void union(int v, int w) {
		int i = find(v);
		int j = find(w);

		if (i == j)
			return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[i];
		}
		count--;
	}
}
