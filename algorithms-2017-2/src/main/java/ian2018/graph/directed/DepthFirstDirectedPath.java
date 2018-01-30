package ian2018.graph.directed;


import ian2018.graph.unidrected.UnidirectedGraph;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstDirectedPath {

    boolean[] marked;
    int[] source;
    int s;

    public DepthFirstDirectedPath(Diagraph g, int source) {
        marked = new boolean[g.V()];
        this.source = new int[g.V()];
        this.s = source;

        Stack<Integer> q = new Stack();
        q.push(source);
        marked[source]=true;
        while (!q.isEmpty()) {
            int v = q.pop();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    this.source[w] = v;
                    q.push(w);
                }
            }
        }
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public Iterable<Integer> pathTo(int w) {
        LinkedList<Integer> path = new LinkedList<>();
        path.push(w);
        int current = w;
        while ((current = source[current]) != s) {
            path.push(current);
        }
        path.push(s);
        return path;
    }
}
