package hackerRank.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class EvenTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int e = in.nextInt();

		List<Integer>[] edges = new List[n];
		Arrays.setAll(edges, i -> new ArrayList());
		for (int i = 0; i < e; i++) {
			int v = in.nextInt() - 1;
			int w = in.nextInt() - 1;
			edges[v].add(w);
			edges[w].add(v);
		}

		int count = 0;
		for (int v = 0; v < n; v++) {
			for (int w : edges[v]) {
				int countSubNodes = count(n,v, w, edges);
				if (countSubNodes > 0 && countSubNodes % 2 == 0 && edges[v].size() > 1) {
					//System.out.println((v+1)+"-"+(w+1));
					count++;
				}
			}
		}
		System.out.println(count/2);
	}

	private static int count(int n, int root,  int v, List<Integer>[] edges) {
		boolean[] marked = new boolean[n];
		marked[root]=true;
		int count = 1;
		Queue<Integer> q = new LinkedList();
		q.add(v);
		while (!q.isEmpty()) {
			int next = q.remove();
			marked[next] = true;
			for (int w : edges[next]) {
				if (!marked[w]) {
					q.offer(w);
					count++;
				}
			}
		}
		return count;
	}
}
