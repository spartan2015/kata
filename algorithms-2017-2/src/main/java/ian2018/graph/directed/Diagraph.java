package ian2018.graph.directed;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Diagraph {
    /**
     * no of vertices
     */
    private int V;
    /**
     * no of edges
     */
    private int E;
    private List[] edges;

    public Diagraph(int v) {
        init(v);
    }

    private void init(int v) {
        V = v;
        edges = new LinkedList[V];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new LinkedList();
        }
    }

    public Diagraph(String s) {
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

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        edges[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return edges[v];
    }

    public Diagraph reverse() {
        Diagraph d = new Diagraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                d.addEdge(w, v);
            }
        }
        return d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < V; v++) {
            sb.append(v).append(" -> ");
            for (int w : adj(v)) {
                sb.append(w).append(",");
            }
            sb.append("\n");

        }
        return sb.toString();
    }
}
