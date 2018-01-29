package ian2018.graph.unidrected;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Other options:
 *
 * adjacency matrix- FAST but V2 space - but constant time for edge, check adj, and on V for adjacency
 * list of edges:  space E  , add edge 1,      check adj: E,              iterate: adj E
 * adjacency sets: space E+V, add edge log V,  check adj: log V,     iterate: adj: log V + degree(v)
 * adjacency list: space E+V, add edge      1, check adj: degree(V), iterate: adj: degree(V)
 *
 * So we implement the classic: adjacency-lists data structure
 */
public class UnidirectedGraph {
    int[] v;
    LinkedList<Integer>[] e;
    int E;

    public UnidirectedGraph(int V) {
        init(V);
    }

    public UnidirectedGraph(String s) {
        Scanner sc = new Scanner(s);
        int V = sc.nextInt();
        init(V);
        int E = sc.nextInt();
        for (int i = 0; i < E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            addEdge(v, w);
        }
    }

    private void init(int V) {
        v = new int[V];
        e = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            e[i] = new LinkedList();
        }
    }

    public int V() {
        return v.length;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        e[v].push(w);
        e[w].push(v);
        E++;
    }

    Iterable<Integer> adj(int v) {
        return e[v];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v.length; i++) {
            sb.append(i + " : " + adj(i)).append("\n");
        }
        return sb.toString();
    }
}
